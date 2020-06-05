package com.oasisfeng.condom;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.util.EventLog;
import android.util.Log;
import com.tencent.android.tpush.common.Constants;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class CondomCore {
    private static final int EVENT_TAG = TAG.hashCode();
    static final int FLAG_RECEIVER_EXCLUDE_BACKGROUND = 8388608;
    private static final String TAG = "Condom";
    final boolean DEBUG;
    final Context mBase;
    boolean mDryRun;
    boolean mExcludeBackgroundReceivers;
    boolean mExcludeBackgroundServices;
    boolean mExcludeStoppedPackages = true;
    OutboundJudge mOutboundJudge;

    /* renamed from: com.oasisfeng.condom.CondomCore$BackgroundUidFilter */
    class BackgroundUidFilter {
        /* renamed from: b */
        private final List<RunningServiceInfo> f15379b;
        /* renamed from: c */
        private final List<RunningAppProcessInfo> f15380c;

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo25443a(int i) {
            List<RunningAppProcessInfo> list = this.f15380c;
            if (list != null) {
                for (RunningAppProcessInfo runningAppProcessInfo : list) {
                    if (runningAppProcessInfo.pid != 0 && runningAppProcessInfo.importance < 400 && runningAppProcessInfo.uid == i) {
                        return true;
                    }
                }
            } else {
                List<RunningServiceInfo> list2 = this.f15379b;
                if (list2 != null) {
                    for (RunningServiceInfo runningServiceInfo : list2) {
                        if (runningServiceInfo.pid != 0 && runningServiceInfo.uid == i) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        BackgroundUidFilter() {
            int i = VERSION.SDK_INT;
            String str = Constants.FLAG_ACTIVITY_NAME;
            if (i >= 22) {
                this.f15379b = ((ActivityManager) CondomCore.this.mBase.getSystemService(str)).getRunningServices(32);
                this.f15380c = null;
                return;
            }
            this.f15379b = null;
            this.f15380c = ((ActivityManager) CondomCore.this.mBase.getSystemService(str)).getRunningAppProcesses();
        }
    }

    /* renamed from: com.oasisfeng.condom.CondomCore$CondomEvent */
    enum CondomEvent {
        CONCERN,
        BIND_PASS,
        START_PASS,
        FILTER_BG_SERVICE
    }

    /* renamed from: com.oasisfeng.condom.CondomCore$WrappedProcedure */
    static abstract class WrappedProcedure implements WrappedValueProcedure<Void> {
        /* renamed from: a */
        public abstract void mo25409a();

        WrappedProcedure() {
        }

        /* renamed from: c */
        public Void mo25408b() {
            mo25409a();
            return null;
        }
    }

    /* renamed from: com.oasisfeng.condom.CondomCore$WrappedValueProcedure */
    interface WrappedValueProcedure<R> extends WrappedValueProcedureThrows<R, RuntimeException> {
    }

    /* renamed from: com.oasisfeng.condom.CondomCore$WrappedValueProcedureThrows */
    interface WrappedValueProcedureThrows<R, T extends Throwable> {
        /* renamed from: b */
        R mo25408b() throws Throwable;
    }

    /* access modifiers changed from: 0000 */
    public void proceedBroadcast(Intent intent, WrappedProcedure wrappedProcedure) {
        proceed(OutboundType.BROADCAST, intent, null, wrappedProcedure);
    }

    /* access modifiers changed from: 0000 */
    public <R, T extends Throwable> R proceed(OutboundType outboundType, Intent intent, R r, WrappedValueProcedureThrows<R, T> wrappedValueProcedureThrows) throws Throwable {
        String targetPackage = getTargetPackage(intent);
        if (targetPackage != null) {
            if (this.mBase.getPackageName().equals(targetPackage)) {
                return wrappedValueProcedureThrows.mo25408b();
            }
            if (shouldBlockRequestTarget(outboundType, intent, targetPackage)) {
                return r;
            }
        }
        int adjustIntentFlags = adjustIntentFlags(outboundType, intent);
        try {
            return wrappedValueProcedureThrows.mo25408b();
        } finally {
            intent.setFlags(adjustIntentFlags);
        }
    }

    /* access modifiers changed from: 0000 */
    public <T extends Throwable> List<ResolveInfo> proceedQuery(final OutboundType outboundType, final Intent intent, final WrappedValueProcedureThrows<List<ResolveInfo>, T> wrappedValueProcedureThrows) throws Throwable {
        return (List) proceed(outboundType, intent, Collections.emptyList(), new WrappedValueProcedureThrows<List<ResolveInfo>, T>() {
            /* renamed from: a */
            public List<ResolveInfo> mo25408b() throws Throwable {
                List<ResolveInfo> list = (List) wrappedValueProcedureThrows.mo25408b();
                if (CondomCore.this.mOutboundJudge != null && CondomCore.getTargetPackage(intent) == null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ResolveInfo resolveInfo = (ResolveInfo) it.next();
                        String str = outboundType == OutboundType.QUERY_SERVICES ? resolveInfo.serviceInfo.packageName : outboundType == OutboundType.QUERY_RECEIVERS ? resolveInfo.activityInfo.packageName : null;
                        if (str != null && CondomCore.this.shouldBlockRequestTarget(outboundType, intent, str)) {
                            it.remove();
                        }
                    }
                }
                return list;
            }
        });
    }

    static String getTargetPackage(Intent intent) {
        ComponentName component = intent.getComponent();
        return component != null ? component.getPackageName() : intent.getPackage();
    }

    /* access modifiers changed from: private */
    public boolean shouldBlockRequestTarget(OutboundType outboundType, Intent intent, String str) {
        OutboundJudge outboundJudge = this.mOutboundJudge;
        return outboundJudge != null && !outboundJudge.shouldAllow(outboundType, intent, str) && !this.mDryRun;
    }

    private int adjustIntentFlags(OutboundType outboundType, Intent intent) {
        int flags = intent.getFlags();
        if (this.mDryRun) {
            return flags;
        }
        if (this.mExcludeBackgroundReceivers && (outboundType == OutboundType.BROADCAST || outboundType == OutboundType.QUERY_RECEIVERS)) {
            intent.addFlags(VERSION.SDK_INT >= 24 ? 8388608 : 1073741824);
        }
        if (VERSION.SDK_INT >= 12 && this.mExcludeStoppedPackages) {
            intent.setFlags((intent.getFlags() & -33) | 16);
        }
        return flags;
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0048, code lost:
            if (r2.mo25443a(r5) != false) goto L_0x004a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0066 A[SYNTHETIC] */
    public android.content.pm.ResolveInfo filterCandidates(com.oasisfeng.condom.OutboundType r10, android.content.Intent r11, java.util.List<android.content.pm.ResolveInfo> r12, java.lang.String r13, boolean r14) {
        /*
        r9 = this;
        r0 = 0
        if (r12 == 0) goto L_0x0074
        boolean r1 = r12.isEmpty()
        if (r1 == 0) goto L_0x000b
        goto L_0x0074
    L_0x000b:
        int r1 = android.os.Process.myUid()
        java.util.Iterator r12 = r12.iterator()
        r2 = r0
    L_0x0014:
        boolean r3 = r12.hasNext()
        if (r3 == 0) goto L_0x0074
        java.lang.Object r3 = r12.next()
        android.content.pm.ResolveInfo r3 = (android.content.pm.ResolveInfo) r3
        android.content.pm.ServiceInfo r4 = r3.serviceInfo
        android.content.pm.ApplicationInfo r4 = r4.applicationInfo
        int r5 = r4.uid
        if (r5 != r1) goto L_0x0029
        goto L_0x004a
    L_0x0029:
        com.oasisfeng.condom.OutboundJudge r6 = r9.mOutboundJudge
        if (r6 == 0) goto L_0x0039
        java.lang.String r7 = r4.packageName
        boolean r6 = r6.shouldAllow(r10, r11, r7)
        if (r6 == 0) goto L_0x0036
        goto L_0x0039
    L_0x0036:
        r5 = r2
        r2 = r0
        goto L_0x004c
    L_0x0039:
        boolean r6 = r9.mExcludeBackgroundServices
        if (r6 == 0) goto L_0x004a
        if (r2 != 0) goto L_0x0044
        com.oasisfeng.condom.CondomCore$BackgroundUidFilter r2 = new com.oasisfeng.condom.CondomCore$BackgroundUidFilter
        r2.m48832init()
    L_0x0044:
        boolean r5 = r2.mo25443a(r5)
        if (r5 == 0) goto L_0x0036
    L_0x004a:
        r5 = r2
        r2 = r3
    L_0x004c:
        if (r2 != 0) goto L_0x0062
        com.oasisfeng.condom.CondomCore$CondomEvent r6 = com.oasisfeng.condom.CondomCore.CondomEvent.FILTER_BG_SERVICE
        r7 = 2
        java.lang.String[] r7 = new java.lang.String[r7]
        r8 = 0
        java.lang.String r4 = r4.packageName
        r7[r8] = r4
        r4 = 1
        java.lang.String r8 = r11.toString()
        r7[r4] = r8
        r9.log(r13, r6, r7)
    L_0x0062:
        boolean r4 = r9.mDryRun
        if (r4 == 0) goto L_0x0067
        return r3
    L_0x0067:
        if (r14 == 0) goto L_0x006f
        if (r2 != 0) goto L_0x0072
        r12.remove()
        goto L_0x0072
    L_0x006f:
        if (r2 == 0) goto L_0x0072
        return r2
    L_0x0072:
        r2 = r5
        goto L_0x0014
    L_0x0074:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oasisfeng.condom.CondomCore.filterCandidates(com.oasisfeng.condom.OutboundType, android.content.Intent, java.util.List, java.lang.String, boolean):android.content.pm.ResolveInfo");
    }

    /* access modifiers changed from: 0000 */
    public boolean shouldAllowProvider(ProviderInfo providerInfo) {
        if (providerInfo == null) {
            return false;
        }
        if (this.mBase.getPackageName().equals(providerInfo.packageName)) {
            return true;
        }
        if (shouldBlockRequestTarget(OutboundType.CONTENT, null, providerInfo.packageName)) {
            return this.mDryRun;
        }
        if (VERSION.SDK_INT < 12 || !this.mExcludeStoppedPackages || (providerInfo.applicationInfo.flags & 2097153) != 2097152) {
            return true;
        }
        return this.mDryRun;
    }

    /* access modifiers changed from: 0000 */
    public boolean shouldAllowProvider(Context context, String str, int i) {
        return shouldAllowProvider(context.getPackageManager().resolveContentProvider(str, i));
    }

    private void log(String str, CondomEvent condomEvent, String... strArr) {
        Object[] objArr = new Object[(strArr.length + 2)];
        objArr[0] = this.mBase.getPackageName();
        objArr[1] = str;
        System.arraycopy(strArr, 0, objArr, 2, strArr.length);
        EventLog.writeEvent(EVENT_TAG + condomEvent.ordinal(), objArr);
        if (this.DEBUG) {
            String asLogTag = asLogTag(str);
            StringBuilder sb = new StringBuilder();
            sb.append(condomEvent.name());
            sb.append(" ");
            sb.append(Arrays.toString(strArr));
            Log.d(asLogTag, sb.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    public void logConcern(String str, String str2) {
        EventLog.writeEvent(EVENT_TAG + CondomEvent.CONCERN.ordinal(), new Object[]{this.mBase.getPackageName(), str, str2, getCaller()});
        if (this.DEBUG) {
            String asLogTag = asLogTag(str);
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(" is invoked");
            Log.w(asLogTag, sb.toString(), new Throwable());
        }
    }

    /* access modifiers changed from: 0000 */
    public void logIfOutboundPass(String str, Intent intent, String str2, CondomEvent condomEvent) {
        if (str2 != null && !this.mBase.getPackageName().equals(str2)) {
            log(str, condomEvent, str2, intent.toString());
        }
    }

    private static String getCaller() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length <= 5) {
            return "<bottom>";
        }
        StackTraceElement stackTraceElement = stackTrace[5];
        StringBuilder sb = new StringBuilder();
        sb.append(stackTraceElement.getClassName());
        sb.append(".");
        sb.append(stackTraceElement.getMethodName());
        sb.append(":");
        sb.append(stackTraceElement.getLineNumber());
        return sb.toString();
    }

    static String buildLogTag(String str, String str2, String str3) {
        if (str3 == null || str3.isEmpty()) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(str3);
        return asLogTag(sb.toString());
    }

    static String asLogTag(String str) {
        return str.length() > 23 ? str.substring(0, 23) : str;
    }

    CondomCore(Context context, CondomOptions condomOptions) {
        boolean z = true;
        this.mBase = context;
        if ((context.getApplicationInfo().flags & 2) == 0) {
            z = false;
        }
        this.DEBUG = z;
        this.mExcludeBackgroundReceivers = condomOptions.mExcludeBackgroundReceivers;
        this.mExcludeBackgroundServices = condomOptions.mExcludeBackgroundServices;
        this.mOutboundJudge = condomOptions.mOutboundJudge;
        this.mDryRun = condomOptions.mDryRun;
        if (this.mDryRun) {
            Log.w(TAG, "Start dry-run mode, no outbound requests will be blocked actually, despite later stated in log.");
        }
    }
}
