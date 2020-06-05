package com.tencent.android.tpush.service;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.LocalServerSocket;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.common.C6901c;
import com.tencent.android.tpush.common.C6906f;
import com.tencent.android.tpush.common.C6914l;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.data.RegisterEntity;
import com.tencent.android.tpush.p579a.C6861a;
import com.tencent.android.tpush.p580b.C6864a;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.android.tpush.service.channel.C7005b;
import com.tencent.android.tpush.service.p595e.C7056i;
import com.tencent.android.tpush.stat.p596a.C7066c;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.service.b */
public class C6973b {
    /* access modifiers changed from: private|static */
    /* renamed from: a */
    public static Context f23168a = null;
    /* renamed from: b */
    private static String f23169b = "";
    /* renamed from: c */
    private static LocalServerSocket f23170c = null;
    /* renamed from: d */
    private static LocalServerSocket f23171d = null;
    /* renamed from: f */
    private static volatile boolean f23172f = false;
    /* renamed from: g */
    private static volatile boolean f23173g = false;
    /* access modifiers changed from: private|static|volatile */
    /* renamed from: h */
    public static volatile boolean f23174h = false;
    /* access modifiers changed from: private|static|volatile */
    /* renamed from: i */
    public static volatile boolean f23175i = false;
    /* renamed from: e */
    private Handler f23176e;

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.android.tpush.service.b$a */
    public static class C6977a {
        /* renamed from: a */
        public static final C6973b f23180a = new C6973b();
    }

    /* renamed from: b */
    public void mo33287b() {
    }

    private C6973b() {
        this.f23176e = null;
        f23169b = C7056i.m30177a(m29776f());
    }

    /* renamed from: a */
    public static C6973b m29763a() {
        return C6977a.f23180a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0065, code lost:
            return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0093, code lost:
            return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0095, code lost:
            r9 = com.tencent.android.tpush.service.cache.CacheManager.getRegisterInfos(m29776f());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a0, code lost:
            if (r9 == null) goto L_0x00bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a6, code lost:
            if (r9.size() <= 1) goto L_0x00bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00a8, code lost:
            r1 = (long) (((int) (java.lang.Math.random() * 1000.0d)) + 900);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00b9, code lost:
            if (r1 >= 1000) goto L_0x00bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00bb, code lost:
            r1 = 1000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00bc, code lost:
            r8.f23176e.sendMessageDelayed(r8.f23176e.obtainMessage(1), r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00c7, code lost:
            return;
     */
    /* renamed from: a */
    public void mo33286a(android.content.Intent r9) {
        /*
        r8 = this;
        android.os.Handler r0 = r8.f23176e
        if (r0 != 0) goto L_0x0007
        r8.m29785o()
    L_0x0007:
        monitor-enter(r8)
        boolean r0 = f23172f     // Catch:{ all -> 0x00c8 }
        r1 = 0
        if (r0 == 0) goto L_0x0066
        android.net.LocalServerSocket r0 = f23170c     // Catch:{ all -> 0x00c8 }
        if (r0 == 0) goto L_0x0066
        if (r9 == 0) goto L_0x0064
        java.lang.String r0 = r9.getAction()     // Catch:{ all -> 0x00c8 }
        if (r0 == 0) goto L_0x0064
        java.lang.String r3 = "com.tencent.android.tpush.action.keepalive"
        boolean r3 = r3.equals(r0)     // Catch:{ all -> 0x00c8 }
        r4 = 100
        if (r3 == 0) goto L_0x004b
        android.os.Handler r0 = r8.f23176e     // Catch:{ all -> 0x00c8 }
        r3 = 2
        android.os.Message r0 = r0.obtainMessage(r3)     // Catch:{ all -> 0x00c8 }
        java.lang.String r6 = "delay_time"
        long r6 = r9.getLongExtra(r6, r1)     // Catch:{ all -> 0x00c8 }
        int r9 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
        if (r9 != 0) goto L_0x0040
        android.os.Handler r9 = r8.f23176e     // Catch:{ all -> 0x00c8 }
        r9.removeMessages(r3)     // Catch:{ all -> 0x00c8 }
        android.os.Handler r9 = r8.f23176e     // Catch:{ all -> 0x00c8 }
        r9.sendMessageDelayed(r0, r4)     // Catch:{ all -> 0x00c8 }
        goto L_0x0064
    L_0x0040:
        android.os.Handler r9 = r8.f23176e     // Catch:{ all -> 0x00c8 }
        r9.removeMessages(r3)     // Catch:{ all -> 0x00c8 }
        android.os.Handler r9 = r8.f23176e     // Catch:{ all -> 0x00c8 }
        r9.sendMessageDelayed(r0, r6)     // Catch:{ all -> 0x00c8 }
        goto L_0x0064
    L_0x004b:
        java.lang.String r9 = "com.tencent.android.tpush.action.stop_connect"
        boolean r9 = r9.equals(r0)     // Catch:{ all -> 0x00c8 }
        if (r9 == 0) goto L_0x0064
        android.os.Handler r9 = r8.f23176e     // Catch:{ all -> 0x00c8 }
        r0 = 3
        android.os.Message r9 = r9.obtainMessage(r0)     // Catch:{ all -> 0x00c8 }
        android.os.Handler r1 = r8.f23176e     // Catch:{ all -> 0x00c8 }
        r1.removeMessages(r0)     // Catch:{ all -> 0x00c8 }
        android.os.Handler r0 = r8.f23176e     // Catch:{ all -> 0x00c8 }
        r0.sendMessageDelayed(r9, r4)     // Catch:{ all -> 0x00c8 }
    L_0x0064:
        monitor-exit(r8)     // Catch:{ all -> 0x00c8 }
        return
    L_0x0066:
        boolean r0 = f23173g     // Catch:{ all -> 0x00c8 }
        if (r0 == 0) goto L_0x0094
        android.net.LocalServerSocket r0 = f23171d     // Catch:{ all -> 0x00c8 }
        if (r0 == 0) goto L_0x0094
        android.content.Context r0 = m29776f()     // Catch:{ all -> 0x00c8 }
        boolean r0 = com.tencent.android.tpush.service.p595e.C7056i.m30225s(r0)     // Catch:{ all -> 0x00c8 }
        if (r0 != 0) goto L_0x0086
        if (r9 == 0) goto L_0x0092
        java.lang.String r0 = "com.tencent.android.tpush.action.slave2main"
        java.lang.String r9 = r9.getAction()     // Catch:{ all -> 0x00c8 }
        boolean r9 = r0.equals(r9)     // Catch:{ all -> 0x00c8 }
        if (r9 == 0) goto L_0x0092
    L_0x0086:
        android.os.Handler r9 = r8.f23176e     // Catch:{ all -> 0x00c8 }
        r0 = 4
        android.os.Message r9 = r9.obtainMessage(r0)     // Catch:{ all -> 0x00c8 }
        android.os.Handler r0 = r8.f23176e     // Catch:{ all -> 0x00c8 }
        r0.sendMessageDelayed(r9, r1)     // Catch:{ all -> 0x00c8 }
    L_0x0092:
        monitor-exit(r8)     // Catch:{ all -> 0x00c8 }
        return
    L_0x0094:
        monitor-exit(r8)     // Catch:{ all -> 0x00c8 }
        android.content.Context r9 = m29776f()
        java.util.List r9 = com.tencent.android.tpush.service.cache.CacheManager.getRegisterInfos(r9)
        r3 = 1000(0x3e8, double:4.94E-321)
        r0 = 1
        if (r9 == 0) goto L_0x00bc
        int r9 = r9.size()
        if (r9 <= r0) goto L_0x00bc
        double r1 = java.lang.Math.random()
        r5 = 4652007308841189376(0x408f400000000000, double:1000.0)
        double r1 = r1 * r5
        int r9 = (int) r1
        int r9 = r9 + 900
        long r1 = (long) r9
        int r9 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
        if (r9 >= 0) goto L_0x00bc
        r1 = r3
    L_0x00bc:
        android.os.Handler r9 = r8.f23176e
        android.os.Message r9 = r9.obtainMessage(r0)
        android.os.Handler r0 = r8.f23176e
        r0.sendMessageDelayed(r9, r1)
        return
    L_0x00c8:
        r9 = move-exception
        monitor-exit(r8)     // Catch:{ all -> 0x00c8 }
        throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.service.C6973b.mo33286a(android.content.Intent):void");
    }

    /* renamed from: a */
    public static void m29765a(Context context) {
        m29767a(context, Constants.ACTION_KEEPALIVE, 0);
    }

    /* renamed from: b */
    public static void m29770b(Context context) {
        m29767a(context, Constants.ACTION_START_SLVAE, 0);
    }

    /* renamed from: a */
    public static void m29766a(Context context, long j) {
        m29767a(context, Constants.ACTION_KEEPALIVE, j);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0060 A[Catch:{ all -> 0x006b }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0064 A[Catch:{ all -> 0x006b }] */
    /* renamed from: a */
    public static void m29767a(android.content.Context r6, java.lang.String r7, long r8) {
        /*
        java.lang.String r0 = "startService failed, libtpnsSecurity.so not found."
        java.lang.String r1 = "PushServiceManager"
        if (r6 == 0) goto L_0x0089
        r2 = 0
        android.content.Intent r3 = new android.content.Intent     // Catch:{ all -> 0x0032 }
        r3.<init>()     // Catch:{ all -> 0x0032 }
        java.lang.Class<com.tencent.android.tpush.service.XGPushServiceV4> r2 = com.tencent.android.tpush.service.XGPushServiceV4.class
        r3.setClass(r6, r2)     // Catch:{ all -> 0x0030 }
        r3.setAction(r7)     // Catch:{ all -> 0x0030 }
        r4 = 0
        int r7 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
        if (r7 == 0) goto L_0x001f
        java.lang.String r7 = "delay_time"
        r3.putExtra(r7, r8)     // Catch:{ all -> 0x0030 }
    L_0x001f:
        int r7 = com.tencent.android.tpush.common.C6914l.m29505a(r6)     // Catch:{ all -> 0x0030 }
        if (r7 > 0) goto L_0x0029
        r6.startService(r3)     // Catch:{ all -> 0x0030 }
        goto L_0x0089
    L_0x0029:
        com.tencent.android.tpush.p580b.C6864a.m29308i(r1, r0)     // Catch:{ all -> 0x0030 }
        r6.stopService(r3)     // Catch:{ all -> 0x0030 }
        goto L_0x0089
    L_0x0030:
        r7 = move-exception
        goto L_0x0034
    L_0x0032:
        r7 = move-exception
        r3 = r2
    L_0x0034:
        java.lang.StringBuilder r8 = new java.lang.StringBuilder
        r8.<init>()
        java.lang.String r9 = "startService failed, intent:"
        r8.append(r9)
        r8.append(r3)
        java.lang.String r9 = ", ex:"
        r8.append(r9)
        r8.append(r7)
        java.lang.String r7 = r8.toString()
        com.tencent.android.tpush.p580b.C6864a.m29308i(r1, r7)
        android.content.Intent r7 = new android.content.Intent     // Catch:{ all -> 0x006d }
        r7.<init>()     // Catch:{ all -> 0x006d }
        java.lang.Class<com.tencent.android.tpush.service.XGPushServiceV4> r8 = com.tencent.android.tpush.service.XGPushServiceV4.class
        r7.setClass(r6, r8)     // Catch:{ all -> 0x006b }
        int r8 = com.tencent.android.tpush.common.C6914l.m29505a(r6)     // Catch:{ all -> 0x006b }
        if (r8 > 0) goto L_0x0064
        r6.startService(r7)     // Catch:{ all -> 0x006b }
        goto L_0x0089
    L_0x0064:
        com.tencent.android.tpush.p580b.C6864a.m29308i(r1, r0)     // Catch:{ all -> 0x006b }
        r6.stopService(r7)     // Catch:{ all -> 0x006b }
        goto L_0x0089
    L_0x006b:
        r6 = move-exception
        goto L_0x006f
    L_0x006d:
        r6 = move-exception
        r7 = r3
    L_0x006f:
        java.lang.StringBuilder r8 = new java.lang.StringBuilder
        r8.<init>()
        java.lang.String r0 = "222 startService failed, intent:"
        r8.append(r0)
        r8.append(r7)
        r8.append(r9)
        r8.append(r6)
        java.lang.String r6 = r8.toString()
        com.tencent.android.tpush.p580b.C6864a.m29308i(r1, r6)
    L_0x0089:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.service.C6973b.m29767a(android.content.Context, java.lang.String, long):void");
    }

    /* renamed from: c */
    public static void m29773c(Context context) {
        C6864a.m29305f("PushServiceManager", "Action -> stop Current Connect");
        m29767a(context, Constants.ACTION_STOP_CONNECT, 0);
    }

    /* renamed from: c */
    public void mo33288c() {
        C6864a.m29298c("PushServiceManager", "@@ serviceExit()");
        C6914l.m29509a();
        Handler handler = this.f23176e;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f23176e = null;
        }
        if (C6901c.m29459a().mo33107b() != null) {
            C6901c.m29459a().mo33107b().removeCallbacksAndMessages(null);
        }
        C6958a.m29694a().mo33265c(f23168a);
        mo33289d();
        C7056i.m30227u(m29776f());
    }

    /* renamed from: d */
    public void mo33289d() {
        synchronized (this) {
            if (f23170c != null) {
                try {
                    f23170c.close();
                    f23170c = null;
                } catch (Exception e) {
                    C6864a.m29302d(Constants.ServiceLogTag, ">> Destroy local socket exception", e);
                }
            }
            f23172f = Boolean.valueOf(false).booleanValue();
        }
    }

    /* renamed from: e */
    public void mo33290e() {
        synchronized (this) {
            if (f23171d != null) {
                try {
                    f23171d.close();
                    f23171d = null;
                } catch (Exception e) {
                    C6864a.m29302d(Constants.ServiceLogTag, ">> Destroy local socket exception", e);
                }
            }
            f23173g = Boolean.valueOf(false).booleanValue();
        }
    }

    /* renamed from: d */
    public static void m29774d(Context context) {
        if (context != null) {
            f23168a = context;
            f23169b = context.getPackageName();
        }
    }

    /* renamed from: f */
    public static Context m29776f() {
        return f23168a;
    }

    /* renamed from: g */
    public static String m29777g() {
        return f23169b;
    }

    /* renamed from: k */
    private boolean m29781k() {
        float f;
        String str = "PushServiceManager";
        try {
            if (C7056i.m30186a(f23168a.getPackageName())) {
                return true;
            }
            Map registerEntityMap = CacheManager.getRegisterEntityMap();
            if (registerEntityMap != null) {
                if (registerEntityMap.size() >= 2) {
                    HashMap hashMap = new HashMap();
                    for (Entry value : registerEntityMap.entrySet()) {
                        RegisterEntity registerEntity = (RegisterEntity) value.getValue();
                        if (registerEntity != null && !C7056i.m30194b(registerEntity.packageName) && registerEntity.isRegistered()) {
                            hashMap.put(registerEntity.packageName, Float.valueOf(registerEntity.xgSDKVersion));
                        }
                    }
                    float f2 = 0.0f;
                    float floatValue = hashMap.get(f23169b) != null ? ((Float) hashMap.get(f23169b)).floatValue() : 4.03f;
                    List<RunningServiceInfo> runningServices = ((ActivityManager) f23168a.getSystemService(Constants.FLAG_ACTIVITY_NAME)).getRunningServices(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                    if (runningServices != null && runningServices.size() > 0) {
                        String name = XGPushServiceV4.class.getName();
                        for (RunningServiceInfo runningServiceInfo : runningServices) {
                            if (name.equals(runningServiceInfo.service.getClassName())) {
                                String packageName = runningServiceInfo.service.getPackageName();
                                StringBuilder sb = new StringBuilder();
                                sb.append("isSurvive srvPkg :");
                                sb.append(packageName);
                                C6864a.m29298c(str, sb.toString());
                                if (C7066c.m30262b(packageName) && hashMap.get(runningServiceInfo.service.getPackageName()) != null) {
                                    float floatValue2 = ((Float) hashMap.get(packageName)).floatValue();
                                    if (floatValue2 > f2) {
                                        f2 = floatValue2;
                                    }
                                }
                            }
                        }
                    }
                    if (f > floatValue) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Exception e) {
            C6864a.m29302d(str, "isSurvive", e);
        }
    }

    /* renamed from: a */
    public static void m29764a(Service service) {
        StringBuilder sb = new StringBuilder();
        sb.append(service.getClass().getSimpleName());
        sb.append(" showMockNotification");
        C6864a.m29308i("showMockNotification", sb.toString());
        Notification notification = new Notification();
        notification.sound = null;
        notification.vibrate = null;
        service.startForeground(19981111, notification);
    }

    /* renamed from: e */
    public static int m29775e(Context context) {
        int i;
        int i2 = 0;
        try {
            List<RunningServiceInfo> runningServices = ((ActivityManager) context.getSystemService(Constants.FLAG_ACTIVITY_NAME)).getRunningServices(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            if (runningServices != null && runningServices.size() > 0) {
                String name = XGPushServiceV4.class.getName();
                for (RunningServiceInfo runningServiceInfo : runningServices) {
                    if (name.equals(runningServiceInfo.service.getClassName())) {
                        String packageName = runningServiceInfo.service.getPackageName();
                        if (packageName != null && !packageName.equals(context.getPackageName())) {
                            i2++;
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return i;
    }

    /* renamed from: l */
    private void m29782l() {
        if (VERSION.SDK_INT < 18) {
            XGPushServiceV4.m29691b().startForeground(-1998, new Notification());
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:3|4|(3:8|9|10)|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0043 */
    /* renamed from: m */
    public boolean m29783m() {
        /*
        r6 = this;
        boolean r0 = r6.m29781k()
        monitor-enter(r6)
        if (r0 == 0) goto L_0x009e
        android.content.Context r1 = f23168a     // Catch:{ all -> 0x007e }
        java.lang.String r1 = com.tencent.android.tpush.service.cache.CacheManager.getToken(r1)     // Catch:{ all -> 0x007e }
        android.content.Context r2 = f23168a     // Catch:{ all -> 0x007e }
        int r2 = m29775e(r2)     // Catch:{ all -> 0x007e }
        java.lang.String r3 = "PushServiceManager"
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x007e }
        r4.<init>()     // Catch:{ all -> 0x007e }
        java.lang.String r5 = "(ignore) running v4 service count "
        r4.append(r5)     // Catch:{ all -> 0x007e }
        r4.append(r2)     // Catch:{ all -> 0x007e }
        java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x007e }
        com.tencent.android.tpush.p580b.C6864a.m29286a(r3, r2)     // Catch:{ all -> 0x007e }
        boolean r2 = com.tencent.android.tpush.common.C6914l.m29521c(r1)     // Catch:{ all -> 0x007e }
        if (r2 != 0) goto L_0x0043
        java.lang.String r2 = "0"
        boolean r1 = r2.equals(r1)     // Catch:{ all -> 0x007e }
        if (r1 != 0) goto L_0x0043
        android.net.LocalServerSocket r1 = new android.net.LocalServerSocket     // Catch:{ all -> 0x007e }
        java.lang.String r2 = com.tencent.android.tpush.service.p595e.C7056i.m30188b()     // Catch:{ all -> 0x007e }
        r1.<init>(r2)     // Catch:{ all -> 0x007e }
        r1.close()     // Catch:{ all -> 0x0043 }
    L_0x0043:
        android.content.Context r1 = f23168a     // Catch:{ all -> 0x007e }
        java.lang.String r1 = com.tencent.android.tpush.service.p595e.C7056i.m30200d(r1)     // Catch:{ all -> 0x007e }
        android.net.LocalServerSocket r2 = new android.net.LocalServerSocket     // Catch:{ all -> 0x007e }
        r2.<init>(r1)     // Catch:{ all -> 0x007e }
        f23170c = r2     // Catch:{ all -> 0x007e }
        java.lang.String r2 = "PushServiceManager"
        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x007e }
        r3.<init>()     // Catch:{ all -> 0x007e }
        java.lang.String r4 = "tryToKeepServiceAlive socketFinalName:"
        r3.append(r4)     // Catch:{ all -> 0x007e }
        r3.append(r1)     // Catch:{ all -> 0x007e }
        java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x007e }
        com.tencent.android.tpush.p580b.C6864a.m29286a(r2, r1)     // Catch:{ all -> 0x007e }
        r1 = 1
        java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x007e }
        boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x007e }
        f23172f = r1     // Catch:{ all -> 0x007e }
        r6.m29782l()     // Catch:{ all -> 0x007e }
        android.content.Context r1 = f23168a     // Catch:{ all -> 0x007e }
        com.tencent.android.tpush.service.f r1 = com.tencent.android.tpush.service.C7059f.m30231a(r1)     // Catch:{ all -> 0x007e }
        r1.mo34155a()     // Catch:{ all -> 0x007e }
        goto L_0x009e
    L_0x007e:
        r1 = move-exception
        java.lang.String r2 = "PushServiceManager"
        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a0 }
        r3.<init>()     // Catch:{ all -> 0x00a0 }
        java.lang.String r4 = "isSurvive "
        r3.append(r4)     // Catch:{ all -> 0x00a0 }
        r3.append(r0)     // Catch:{ all -> 0x00a0 }
        java.lang.String r0 = r1.getLocalizedMessage()     // Catch:{ all -> 0x00a0 }
        r3.append(r0)     // Catch:{ all -> 0x00a0 }
        java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x00a0 }
        com.tencent.android.tpush.p580b.C6864a.m29305f(r2, r0)     // Catch:{ all -> 0x00a0 }
        boolean r0 = f23172f     // Catch:{ all -> 0x00a0 }
    L_0x009e:
        monitor-exit(r6)     // Catch:{ all -> 0x00a0 }
        return r0
    L_0x00a0:
        r0 = move-exception
        monitor-exit(r6)     // Catch:{ all -> 0x00a0 }
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.service.C6973b.m29783m():boolean");
    }

    /* renamed from: f */
    public boolean mo33291f(Context context) {
        return !C7056i.m30228v(context);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x002e */
    /* renamed from: n */
    public boolean m29784n() {
        /*
        r3 = this;
        java.lang.String r0 = "PushServiceManager"
        java.lang.String r1 = "tryToKeepSlaveServiceAlive"
        com.tencent.android.tpush.p580b.C6864a.m29303e(r0, r1)
        boolean r0 = r3.m29781k()
        monitor-enter(r3)
        if (r0 == 0) goto L_0x0030
        java.lang.String r1 = com.tencent.android.tpush.service.p595e.C7056i.m30196c()     // Catch:{ all -> 0x002e }
        android.net.LocalServerSocket r2 = new android.net.LocalServerSocket     // Catch:{ all -> 0x002e }
        r2.<init>(r1)     // Catch:{ all -> 0x002e }
        f23171d = r2     // Catch:{ all -> 0x002e }
        r1 = 1
        java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x002e }
        boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x002e }
        f23173g = r1     // Catch:{ all -> 0x002e }
        android.content.Context r1 = f23168a     // Catch:{ all -> 0x002e }
        com.tencent.android.tpush.service.f r1 = com.tencent.android.tpush.service.C7059f.m30231a(r1)     // Catch:{ all -> 0x002e }
        r1.mo34155a()     // Catch:{ all -> 0x002e }
        goto L_0x0030
    L_0x002e:
        boolean r0 = f23173g     // Catch:{ all -> 0x0032 }
    L_0x0030:
        monitor-exit(r3)     // Catch:{ all -> 0x0032 }
        return r0
    L_0x0032:
        r0 = move-exception
        monitor-exit(r3)     // Catch:{ all -> 0x0032 }
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.service.C6973b.m29784n():boolean");
    }

    /* renamed from: o */
    private void m29785o() {
        this.f23176e = new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message != null) {
                    int i = message.what;
                    String str = Constants.ServiceLogTag;
                    String str2 = "permission check failed, kill service!";
                    String str3 = "Service's first running at ";
                    String str4 = " version : ";
                    String str5 = "PushServiceManager";
                    if (i != 1) {
                        if (i == 2) {
                            C7005b.m29964a().mo33392b();
                        } else if (i == 3) {
                            C7005b.m29964a().mo33393c();
                        } else if (i != 4) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("unknown handler msg = ");
                            sb.append(message.what);
                            C6864a.m29308i(str5, sb.toString());
                        } else {
                            C6864a.m29303e(str5, "go to slave to main service ...");
                            if (C6973b.this.m29783m()) {
                                C6864a.m29303e(str5, "swicth main service ...");
                                if (!C6973b.f23174h) {
                                    if (XGPushConfig.enableDebug) {
                                        StringBuilder sb2 = new StringBuilder();
                                        sb2.append(str3);
                                        sb2.append(C6973b.f23168a.getPackageName());
                                        sb2.append(str4);
                                        sb2.append(4.03f);
                                        C6864a.m29305f(str5, sb2.toString());
                                    }
                                    C6973b.f23174h = true;
                                    if (!C6906f.m29471a()) {
                                        C6864a.m29308i(str, str2);
                                        C6973b.this.mo33289d();
                                        C7056i.m30227u(C6973b.m29776f());
                                    }
                                    C6958a.m29694a().mo33264b(C6973b.f23168a);
                                    C6958a.m29694a().mo33263a(C6973b.m29776f());
                                }
                                C7005b.m29964a().mo33392b();
                                C6973b.this.mo33290e();
                                C7005b.m29964a().mo33397g();
                                C6901c.m29459a().mo33106a(new Runnable() {
                                    public void run() {
                                        C6864a.m29303e("PushServiceManager", "swicth main service then pull up sloveSerice");
                                        C7056i.m30212h(C6973b.f23168a);
                                    }
                                }, 20000);
                            }
                        }
                    } else if (C6973b.this.m29783m()) {
                        C6864a.m29303e(str5, "start as main service......");
                        if (!C6973b.f23174h) {
                            if (XGPushConfig.enableDebug) {
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append(str3);
                                sb3.append(C6973b.f23168a.getPackageName());
                                sb3.append(str4);
                                sb3.append(4.03f);
                                C6864a.m29305f(str5, sb3.toString());
                            }
                            C6973b.f23174h = true;
                            if (!C6906f.m29471a()) {
                                C6864a.m29308i(str, str2);
                                C6973b.this.mo33289d();
                                C7056i.m30227u(C6973b.m29776f());
                            }
                            C6958a.m29694a().mo33263a(C6973b.m29776f());
                        }
                        C7005b.m29964a().mo33392b();
                        C6973b.this.mo33290e();
                        C7005b.m29964a().mo33397g();
                        C6901c.m29459a().mo33106a(new Runnable() {
                            public void run() {
                                C6864a.m29303e("PushServiceManager", "main service pull up sloveSerice");
                                C7056i.m30212h(C6973b.f23168a);
                            }
                        }, 20000);
                        C6861a.m29264a(C6973b.m29776f()).mo32984a();
                    } else if (C6973b.this.m29784n()) {
                        C6864a.m29303e(str5, "start as slave service......");
                        if (!C6973b.f23175i) {
                            if (XGPushConfig.enableDebug) {
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append("Slave Service's first running at ");
                                sb4.append(C6973b.f23168a.getPackageName());
                                sb4.append(str4);
                                sb4.append(4.03f);
                                C6864a.m29305f(str5, sb4.toString());
                            }
                            C6973b.f23175i = true;
                            C7005b.m29964a().mo33398h();
                        }
                        C6958a.m29694a().mo33265c(C6973b.m29776f());
                    } else {
                        Intent intent = new Intent();
                        intent.setClass(C6973b.f23168a, XGPushServiceV4.class);
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(C6973b.f23168a.getPackageName());
                        sb5.append(" XGPushServiceV4 try to stop self.");
                        C6864a.m29306g(str5, sb5.toString());
                        C6958a.m29694a().mo33265c(C6973b.m29776f());
                        C6973b.f23168a.stopService(intent);
                    }
                }
            }
        };
    }
}
