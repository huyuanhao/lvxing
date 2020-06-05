package com.p620ut.mini.p627e;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.core.view.PointerIconCompat;
import com.alibaba.mtl.log.UTMCStatConfig;
import com.alibaba.mtl.log.UTMCVariables;
import com.alibaba.mtl.log.p077d.Logger;
import com.p620ut.mini.UTAnalytics;
import com.p620ut.mini.UTInterfaceCallDelegate;
import com.p620ut.mini.UTTracker;
import com.p620ut.mini.p622b.p623a.UTMCAppStatusCallbacks;
import com.p620ut.mini.p625c.UTOriginalCustomHitBuilder;
import com.p620ut.mini.p626d.UTPlugin;
import com.tencent.android.tpush.common.Constants;
import java.util.List;

/* renamed from: com.ut.mini.e.a */
public class UTMI1010_2001Event extends UTPlugin implements UTMCAppStatusCallbacks {
    /* renamed from: a */
    private long f26073a = 0;
    /* renamed from: b */
    private long f26074b = 0;
    /* renamed from: c */
    private long f26075c = 0;

    /* renamed from: a */
    public void mo37405a(Activity activity) {
    }

    /* renamed from: a */
    public void mo37406a(Activity activity, Bundle bundle) {
    }

    /* renamed from: b */
    public void mo37409b(Activity activity, Bundle bundle) {
    }

    /* renamed from: d */
    public int[] mo37435d() {
        return new int[]{3};
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    public void mo37432a(int r5, java.lang.Object r6) {
        /*
        r4 = this;
        r0 = 3
        if (r5 != r0) goto L_0x005b
        java.util.Map r6 = (java.util.Map) r6
        com.alibaba.mtl.log.model.LogField r5 = com.alibaba.mtl.log.model.LogField.EVENTID
        java.lang.String r5 = r5.toString()
        boolean r5 = r6.containsKey(r5)
        if (r5 == 0) goto L_0x005b
        com.alibaba.mtl.log.model.LogField r5 = com.alibaba.mtl.log.model.LogField.EVENTID
        java.lang.String r5 = r5.toString()
        java.lang.Object r5 = r6.get(r5)
        java.lang.String r5 = (java.lang.String) r5
        java.lang.String r0 = "2001"
        boolean r5 = r0.equals(r5)
        if (r5 == 0) goto L_0x005b
        com.alibaba.mtl.log.model.LogField r5 = com.alibaba.mtl.log.model.LogField.ARG3
        java.lang.String r5 = r5.toString()
        boolean r5 = r6.containsKey(r5)
        r0 = 0
        if (r5 == 0) goto L_0x0048
        com.alibaba.mtl.log.model.LogField r5 = com.alibaba.mtl.log.model.LogField.ARG3
        java.lang.String r5 = r5.toString()
        java.lang.Object r5 = r6.get(r5)
        java.lang.String r5 = (java.lang.String) r5
        long r5 = java.lang.Long.parseLong(r5)     // Catch:{ Exception -> 0x0044 }
        goto L_0x0049
    L_0x0044:
        r5 = move-exception
        r5.printStackTrace()
    L_0x0048:
        r5 = r0
    L_0x0049:
        long r2 = r4.f26073a
        long r2 = r2 + r5
        r4.f26073a = r2
        boolean r5 = m33224e()
        if (r5 == 0) goto L_0x005b
        long r5 = r4.f26073a
        r4.m33223a(r5)
        r4.f26073a = r0
    L_0x005b:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p620ut.mini.p627e.UTMI1010_2001Event.mo37432a(int, java.lang.Object):void");
    }

    /* renamed from: e */
    private static boolean m33224e() {
        try {
            Context d = UTMCStatConfig.m3729a().mo11772d();
            if (d != null) {
                String packageName = d.getPackageName();
                if (packageName != null) {
                    ActivityManager activityManager = (ActivityManager) d.getSystemService(Constants.FLAG_ACTIVITY_NAME);
                    if (activityManager != null) {
                        try {
                            List runningTasks = activityManager.getRunningTasks(1);
                            if (runningTasks != null && runningTasks.size() > 0) {
                                ComponentName componentName = ((RunningTaskInfo) runningTasks.get(0)).topActivity;
                                return componentName == null || !packageName.contains(componentName.getPackageName());
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: a */
    private void m33223a(long j) {
        if (!UTMCVariables.m3755a().mo11775b()) {
            long j2 = 0;
            if (j > 0) {
                if (0 != this.f26075c) {
                    j2 = SystemClock.elapsedRealtime() - this.f26075c;
                }
                StringBuilder sb = new StringBuilder();
                String str = "";
                sb.append(str);
                sb.append(j);
                String sb2 = sb.toString();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append(j2);
                UTOriginalCustomHitBuilder aVar = new UTOriginalCustomHitBuilder("UT", PointerIconCompat.TYPE_ALIAS, sb2, sb3.toString(), null, null);
                UTTracker b = UTAnalytics.m33119a().mo37401b();
                if (b != null) {
                    b.mo37476a(aVar.mo37426a());
                } else {
                    Logger.m3831a("Record app display event error", (Object) "Fatal Error,must call setRequestAuthentication method first.");
                }
            }
        }
    }

    /* renamed from: a */
    public void mo37404a() {
        m33223a(SystemClock.elapsedRealtime() - this.f26074b);
        this.f26075c = SystemClock.elapsedRealtime();
    }

    /* renamed from: b */
    public void mo37407b() {
        this.f26074b = SystemClock.elapsedRealtime();
    }

    /* renamed from: b */
    public void mo37408b(Activity activity) {
        UTInterfaceCallDelegate.m33161a(activity);
    }

    /* renamed from: c */
    public void mo37410c(Activity activity) {
        UTInterfaceCallDelegate.m33162b(activity);
    }
}
