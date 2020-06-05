package com.alibaba.mtl.appmonitor;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.Measure;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.alibaba.mtl.appmonitor.model.Metric;
import com.alibaba.mtl.appmonitor.model.MetricRepo;
import com.alibaba.mtl.appmonitor.p068a.EventRepo;
import com.alibaba.mtl.appmonitor.p068a.EventType;
import com.alibaba.mtl.appmonitor.p069b.AppMonitorException;
import com.alibaba.mtl.appmonitor.p069b.ExceptionEventBuilder;
import com.alibaba.mtl.appmonitor.p070c.BalancedPool;
import com.alibaba.mtl.appmonitor.p071d.SampleRules;
import com.alibaba.mtl.appmonitor.p073f.StringUtils;
import com.alibaba.mtl.log.UTDC;
import com.alibaba.mtl.log.p074a.Config;
import com.alibaba.mtl.log.p075b.CoreStatics;
import com.alibaba.mtl.log.p077d.Logger;
import com.alibaba.mtl.log.p077d.NetworkUtil;
import com.alibaba.mtl.log.p078e.BaseRequestAuth;
import com.alibaba.mtl.log.p078e.IRequestAuth;
import com.alibaba.mtl.log.p078e.SecurityRequestAuth;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.alibaba.mtl.appmonitor.b */
public final class AppMonitorDelegate {
    /* renamed from: a */
    public static boolean f3187a = false;
    /* renamed from: b */
    static volatile boolean f3188b = false;
    /* renamed from: c */
    private static Application f3189c;

    /* compiled from: AppMonitorDelegate */
    /* renamed from: com.alibaba.mtl.appmonitor.b$a */
    public static class C1293a {
        /* renamed from: a */
        public static void m3380a(int i) {
            EventType.ALARM.setStatisticsInterval(i);
            AppMonitorDelegate.m3368a(EventType.ALARM, i);
        }

        /* renamed from: b */
        public static void m3386b(int i) {
            SampleRules.m3572a().mo11650a(EventType.ALARM, i);
        }

        @Deprecated
        /* renamed from: a */
        public static boolean m3385a(String str, String str2) {
            return SampleRules.m3573a(EventType.ALARM, str, str2);
        }

        /* renamed from: a */
        public static void m3384a(String str, String str2, Map<String, String> map) {
            m3383a(str, str2, null, map);
        }

        /* renamed from: a */
        public static void m3383a(String str, String str2, String str3, Map<String, String> map) {
            try {
                String str4 = "AppMonitorDelegate";
                if (!TextUtils.isEmpty(str)) {
                    if (!TextUtils.isEmpty(str2)) {
                        CoreStatics.m3751i();
                        if (!AppMonitorDelegate.f3188b || !Config.m3711c() || !EventType.ALARM.isOpen() || (!AppMonitorDelegate.f3187a && !SampleRules.m3575a(str, str2, Boolean.valueOf(true), null))) {
                            Logger.m3831a("log discard !", (Object) "");
                        } else {
                            Logger.m3833a(str4, "commitSuccess module:", str, " monitorPoint:", str2);
                            CoreStatics.m3752j();
                            EventRepo.m3324a().mo11559a(EventType.ALARM.mo11568a(), str, str2, str3, map);
                        }
                        return;
                    }
                }
                Logger.m3831a(str4, (Object) "module & monitorPoint must not null");
            } catch (Throwable th) {
                ExceptionEventBuilder.m3405a(th);
            }
        }

        /* renamed from: a */
        public static void m3382a(String str, String str2, String str3, String str4, Map<String, String> map) {
            m3381a(str, str2, null, str3, str4, map);
        }

        /* renamed from: a */
        public static void m3381a(String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
            try {
                String str6 = "AppMonitorDelegate";
                if (!TextUtils.isEmpty(str)) {
                    if (!TextUtils.isEmpty(str2)) {
                        CoreStatics.m3751i();
                        HashMap hashMap = new HashMap();
                        hashMap.put("_status", "0");
                        if (!AppMonitorDelegate.f3188b || !Config.m3711c() || !EventType.ALARM.isOpen() || (!AppMonitorDelegate.f3187a && !SampleRules.m3575a(str, str2, Boolean.valueOf(false), (Map<String, String>) hashMap))) {
                            Logger.m3831a("log discard !", (Object) "");
                        } else {
                            Logger.m3833a(str6, "commitFail module:", str, " monitorPoint:", str2, " errorCode:", str4, "errorMsg:", str5);
                            CoreStatics.m3752j();
                            EventRepo.m3324a().mo11558a(EventType.ALARM.mo11568a(), str, str2, str3, str4, str5, map);
                        }
                        return;
                    }
                }
                Logger.m3831a(str6, (Object) "module & monitorPoint must not null");
            } catch (Throwable th) {
                ExceptionEventBuilder.m3405a(th);
            }
        }
    }

    /* compiled from: AppMonitorDelegate */
    /* renamed from: com.alibaba.mtl.appmonitor.b$b */
    public static class C1294b {
        /* renamed from: a */
        public static void m3387a(int i) {
            EventType.COUNTER.setStatisticsInterval(i);
            AppMonitorDelegate.m3368a(EventType.COUNTER, i);
        }

        /* renamed from: b */
        public static void m3391b(int i) {
            SampleRules.m3572a().mo11650a(EventType.COUNTER, i);
        }

        @Deprecated
        /* renamed from: a */
        public static boolean m3390a(String str, String str2) {
            return SampleRules.m3573a(EventType.COUNTER, str, str2);
        }

        /* renamed from: a */
        public static void m3388a(String str, String str2, double d, Map<String, String> map) {
            m3389a(str, str2, null, d, map);
        }

        /* renamed from: a */
        public static void m3389a(String str, String str2, String str3, double d, Map<String, String> map) {
            try {
                String str4 = "AppMonitorDelegate";
                if (!TextUtils.isEmpty(str)) {
                    if (!TextUtils.isEmpty(str2)) {
                        CoreStatics.m3749g();
                        if (AppMonitorDelegate.f3188b && Config.m3711c() && EventType.COUNTER.isOpen() && (AppMonitorDelegate.f3187a || SampleRules.m3573a(EventType.COUNTER, str, str2))) {
                            Logger.m3833a(str4, "commitCount module: ", str, " monitorPoint: ", str2, " value: ", Double.valueOf(d));
                            CoreStatics.m3750h();
                            EventRepo.m3324a().mo11557a(EventType.COUNTER.mo11568a(), str, str2, str3, d, map);
                        }
                        return;
                    }
                }
                Logger.m3831a(str4, (Object) "module & monitorPoint must not null");
            } catch (Throwable th) {
                ExceptionEventBuilder.m3405a(th);
            }
        }
    }

    /* compiled from: AppMonitorDelegate */
    /* renamed from: com.alibaba.mtl.appmonitor.b$c */
    public static class C1295c {
        /* renamed from: a */
        public static void m3392a(int i) {
            EventType.OFFLINE_COUNTER.setStatisticsInterval(i);
            AppMonitorDelegate.m3368a(EventType.OFFLINE_COUNTER, i);
        }

        /* renamed from: b */
        public static void m3395b(int i) {
            SampleRules.m3572a().mo11650a(EventType.OFFLINE_COUNTER, i);
        }

        @Deprecated
        /* renamed from: a */
        public static boolean m3394a(String str, String str2) {
            return SampleRules.m3573a(EventType.OFFLINE_COUNTER, str, str2);
        }

        /* renamed from: a */
        public static void m3393a(String str, String str2, double d) {
            try {
                String str3 = "AppMonitorDelegate";
                if (!TextUtils.isEmpty(str)) {
                    if (!TextUtils.isEmpty(str2)) {
                        CoreStatics.m3747e();
                        if (AppMonitorDelegate.f3188b && Config.m3711c() && EventType.OFFLINE_COUNTER.isOpen() && (AppMonitorDelegate.f3187a || SampleRules.m3573a(EventType.OFFLINE_COUNTER, str, str2))) {
                            Logger.m3833a(str3, "commitOffLineCount module: ", str, " monitorPoint: ", str2, " value: ", Double.valueOf(d));
                            CoreStatics.m3748f();
                            EventRepo.m3324a().mo11557a(EventType.OFFLINE_COUNTER.mo11568a(), str, str2, (String) null, d, null);
                        }
                        return;
                    }
                }
                Logger.m3831a(str3, (Object) "module & monitorPoint must not null");
            } catch (Throwable th) {
                ExceptionEventBuilder.m3405a(th);
            }
        }
    }

    /* compiled from: AppMonitorDelegate */
    /* renamed from: com.alibaba.mtl.appmonitor.b$d */
    public static class C1296d {
        /* renamed from: a */
        public static void m3396a(int i) {
            EventType.STAT.setStatisticsInterval(i);
            AppMonitorDelegate.m3368a(EventType.STAT, i);
        }

        /* renamed from: b */
        public static void m3402b(int i) {
            SampleRules.m3572a().mo11650a(EventType.STAT, i);
        }

        @Deprecated
        /* renamed from: a */
        public static boolean m3401a(String str, String str2) {
            return SampleRules.m3573a(EventType.STAT, str, str2);
        }

        /* renamed from: a */
        public static void m3400a(String str, String str2, String str3) {
            try {
                if (AppMonitorDelegate.f3188b && Config.m3711c() && EventType.STAT.isOpen()) {
                    if (AppMonitorDelegate.f3187a || SampleRules.m3573a(EventType.STAT, str, str2)) {
                        Logger.m3833a("AppMonitorDelegate", "statEvent begin. module: ", str, " monitorPoint: ", str2, " measureName: ", str3);
                        EventRepo.m3324a().mo11560a(Integer.valueOf(EventType.STAT.mo11568a()), str, str2, str3);
                    }
                }
            } catch (Throwable th) {
                ExceptionEventBuilder.m3405a(th);
            }
        }

        /* renamed from: b */
        public static void m3403b(String str, String str2, String str3) {
            try {
                if (AppMonitorDelegate.f3188b && Config.m3711c() && EventType.STAT.isOpen()) {
                    if (AppMonitorDelegate.f3187a || SampleRules.m3573a(EventType.STAT, str, str2)) {
                        Logger.m3833a("AppMonitorDelegate", "statEvent end. module: ", str, " monitorPoint: ", str2, " measureName: ", str3);
                        EventRepo.m3324a().mo11563a(str, str2, str3);
                    }
                }
            } catch (Throwable th) {
                ExceptionEventBuilder.m3405a(th);
            }
        }

        /* renamed from: a */
        public static void m3397a(String str, String str2, double d, Map<String, String> map) {
            m3398a(str, str2, (DimensionValueSet) null, d, map);
        }

        /* renamed from: a */
        public static void m3398a(String str, String str2, DimensionValueSet dimensionValueSet, double d, Map<String, String> map) {
            try {
                String str3 = "AppMonitorDelegate";
                if (!TextUtils.isEmpty(str)) {
                    if (!TextUtils.isEmpty(str2)) {
                        CoreStatics.m3744c();
                        if (AppMonitorDelegate.f3188b && Config.m3711c() && EventType.STAT.isOpen() && (AppMonitorDelegate.f3187a || SampleRules.m3573a(EventType.STAT, str, str2))) {
                            Logger.m3833a(str3, "statEvent commit. module: ", str, " monitorPoint: ", str2);
                            Metric a = MetricRepo.m3683a().mo11758a(str, str2);
                            CoreStatics.m3746d();
                            if (a != null) {
                                List b = a.mo11755g().mo11713b();
                                if (b.size() == 1) {
                                    m3399a(str, str2, dimensionValueSet, ((MeasureValueSet) BalancedPool.m3491a().mo11627a(MeasureValueSet.class, new Object[0])).mo11735a(((Measure) b.get(0)).mo11700b(), d), map);
                                }
                            }
                        }
                        return;
                    }
                }
                Logger.m3831a(str3, (Object) "module & monitorPoint must not null");
            } catch (Throwable th) {
                ExceptionEventBuilder.m3405a(th);
            }
        }

        /* JADX INFO: used method not loaded: com.alibaba.mtl.appmonitor.d.j.a(com.alibaba.mtl.appmonitor.a.f, java.lang.String, java.lang.String, java.util.Map):null, types can be incorrect */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x003c, code lost:
            if (com.alibaba.mtl.appmonitor.p071d.SampleRules.m3574a(com.alibaba.mtl.appmonitor.p068a.EventType.STAT, r10, r11, r12 != null ? r12.mo11689b() : null) != false) goto L_0x003e;
     */
        /* renamed from: a */
        public static void m3399a(java.lang.String r10, java.lang.String r11, com.alibaba.mtl.appmonitor.model.DimensionValueSet r12, com.alibaba.mtl.appmonitor.model.MeasureValueSet r13, java.util.Map<java.lang.String, java.lang.String> r14) {
            /*
            boolean r1 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x007f }
            if (r1 != 0) goto L_0x0077
            boolean r1 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x007f }
            if (r1 == 0) goto L_0x000e
            goto L_0x0077
        L_0x000e:
            com.alibaba.mtl.log.p075b.CoreStatics.m3744c()     // Catch:{ all -> 0x007f }
            boolean r1 = com.alibaba.mtl.appmonitor.AppMonitorDelegate.f3188b     // Catch:{ all -> 0x007f }
            r2 = 3
            java.lang.String r3 = " monitorPoint: "
            r5 = 2
            r6 = 1
            r7 = 0
            r8 = 4
            if (r1 == 0) goto L_0x0065
            boolean r1 = com.alibaba.mtl.log.p074a.Config.m3711c()     // Catch:{ all -> 0x007f }
            if (r1 == 0) goto L_0x0065
            com.alibaba.mtl.appmonitor.a.f r1 = com.alibaba.mtl.appmonitor.p068a.EventType.STAT     // Catch:{ all -> 0x007f }
            boolean r1 = r1.isOpen()     // Catch:{ all -> 0x007f }
            if (r1 == 0) goto L_0x0065
            boolean r1 = com.alibaba.mtl.appmonitor.AppMonitorDelegate.f3187a     // Catch:{ all -> 0x007f }
            if (r1 != 0) goto L_0x003e
            com.alibaba.mtl.appmonitor.a.f r1 = com.alibaba.mtl.appmonitor.p068a.EventType.STAT     // Catch:{ all -> 0x007f }
            if (r12 == 0) goto L_0x0037
            java.util.Map r9 = r12.mo11689b()     // Catch:{ all -> 0x007f }
            goto L_0x0038
        L_0x0037:
            r9 = 0
        L_0x0038:
            boolean r1 = com.alibaba.mtl.appmonitor.p071d.SampleRules.m3574a(r1, r10, r11, r9)     // Catch:{ all -> 0x007f }
            if (r1 == 0) goto L_0x0065
        L_0x003e:
            java.lang.String r1 = "statEvent commit success"
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch:{ all -> 0x007f }
            java.lang.String r9 = "statEvent commit. module: "
            r8[r7] = r9     // Catch:{ all -> 0x007f }
            r8[r6] = r10     // Catch:{ all -> 0x007f }
            r8[r5] = r3     // Catch:{ all -> 0x007f }
            r8[r2] = r11     // Catch:{ all -> 0x007f }
            com.alibaba.mtl.log.p077d.Logger.m3833a(r1, r8)     // Catch:{ all -> 0x007f }
            com.alibaba.mtl.log.p075b.CoreStatics.m3746d()     // Catch:{ all -> 0x007f }
            com.alibaba.mtl.appmonitor.a.e r1 = com.alibaba.mtl.appmonitor.p068a.EventRepo.m3324a()     // Catch:{ all -> 0x007f }
            com.alibaba.mtl.appmonitor.a.f r2 = com.alibaba.mtl.appmonitor.p068a.EventType.STAT     // Catch:{ all -> 0x007f }
            int r2 = r2.mo11568a()     // Catch:{ all -> 0x007f }
            r3 = r10
            r4 = r11
            r5 = r13
            r6 = r12
            r7 = r14
            r1.mo11556a(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x007f }
            goto L_0x0083
        L_0x0065:
            java.lang.String r1 = "statEvent commit failed,log discard"
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch:{ all -> 0x007f }
            java.lang.String r9 = " ,. module: "
            r8[r7] = r9     // Catch:{ all -> 0x007f }
            r8[r6] = r10     // Catch:{ all -> 0x007f }
            r8[r5] = r3     // Catch:{ all -> 0x007f }
            r8[r2] = r11     // Catch:{ all -> 0x007f }
            com.alibaba.mtl.log.p077d.Logger.m3833a(r1, r8)     // Catch:{ all -> 0x007f }
            goto L_0x0083
        L_0x0077:
            java.lang.String r0 = "AppMonitorDelegate"
            java.lang.String r1 = "module & monitorPoint must not null"
            com.alibaba.mtl.log.p077d.Logger.m3831a(r0, r1)     // Catch:{ all -> 0x007f }
            return
        L_0x007f:
            r0 = move-exception
            com.alibaba.mtl.appmonitor.p069b.ExceptionEventBuilder.m3405a(r0)
        L_0x0083:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.appmonitor.AppMonitorDelegate.C1296d.m3399a(java.lang.String, java.lang.String, com.alibaba.mtl.appmonitor.model.DimensionValueSet, com.alibaba.mtl.appmonitor.model.MeasureValueSet, java.util.Map):void");
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:9|10) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
            m3365a();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0030 */
    /* renamed from: a */
    public static synchronized void m3367a(android.app.Application r6) {
        /*
        java.lang.Class<com.alibaba.mtl.appmonitor.b> r0 = com.alibaba.mtl.appmonitor.AppMonitorDelegate.class
        monitor-enter(r0)
        java.lang.String r1 = "AppMonitorDelegate"
        r2 = 1
        java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ all -> 0x0035 }
        r4 = 0
        java.lang.String r5 = "start init"
        r3[r4] = r5     // Catch:{ all -> 0x0035 }
        com.alibaba.mtl.log.p077d.Logger.m3833a(r1, r3)     // Catch:{ all -> 0x0035 }
        boolean r1 = f3188b     // Catch:{ all -> 0x0030 }
        if (r1 != 0) goto L_0x0033
        f3189c = r6     // Catch:{ all -> 0x0030 }
        android.content.Context r1 = r6.getApplicationContext()     // Catch:{ all -> 0x0030 }
        com.alibaba.mtl.log.UTDC.m3692a(r1)     // Catch:{ all -> 0x0030 }
        com.alibaba.mtl.appmonitor.CleanTask.m3597a()     // Catch:{ all -> 0x0030 }
        com.alibaba.mtl.appmonitor.UploadTask.m3600a()     // Catch:{ all -> 0x0030 }
        com.alibaba.mtl.appmonitor.BackgroundTrigger.m3595a(r6)     // Catch:{ all -> 0x0030 }
        android.content.Context r6 = r6.getApplicationContext()     // Catch:{ all -> 0x0030 }
        com.alibaba.mtl.log.p077d.NetworkUtil.m3846b(r6)     // Catch:{ all -> 0x0030 }
        f3188b = r2     // Catch:{ all -> 0x0030 }
        goto L_0x0033
    L_0x0030:
        m3365a()     // Catch:{ all -> 0x0035 }
    L_0x0033:
        monitor-exit(r0)
        return
    L_0x0035:
        r6 = move-exception
        monitor-exit(r0)
        throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.appmonitor.AppMonitorDelegate.m3367a(android.app.Application):void");
    }

    /* renamed from: a */
    public static synchronized void m3365a() {
        synchronized (AppMonitorDelegate.class) {
            try {
                Logger.m3833a("AppMonitorDelegate", "start destory");
                if (f3188b) {
                    UploadTask.m3603c();
                    UploadTask.m3602b();
                    CleanTask.m3598b();
                    if (f3189c != null) {
                        NetworkUtil.m3849c(f3189c.getApplicationContext());
                    }
                    f3188b = false;
                }
            } catch (Throwable th) {
                ExceptionEventBuilder.m3405a(th);
            }
        }
        return;
    }

    /* renamed from: b */
    public static synchronized void m3377b() {
        synchronized (AppMonitorDelegate.class) {
            try {
                Logger.m3833a("AppMonitorDelegate", "triggerUpload");
                if (f3188b && Config.m3711c()) {
                    UploadTask.m3603c();
                }
            } catch (Throwable th) {
                ExceptionEventBuilder.m3405a(th);
            }
        }
        return;
    }

    /* renamed from: a */
    public static void m3366a(int i) {
        EventType[] values;
        for (EventType fVar : EventType.values()) {
            fVar.setStatisticsInterval(i);
            m3368a(fVar, i);
        }
    }

    /* renamed from: b */
    public static void m3378b(int i) {
        EventType[] values;
        Logger.m3833a("AppMonitorDelegate", "[setSampling]");
        for (EventType fVar : EventType.values()) {
            fVar.mo11573c(i);
            SampleRules.m3572a().mo11650a(fVar, i);
        }
    }

    /* renamed from: a */
    public static void m3375a(boolean z) {
        Logger.m3833a("AppMonitorDelegate", "[enableLog]");
        Logger.m3835a(z);
    }

    /* renamed from: a */
    public static void m3370a(String str, String str2, MeasureSet measureSet) {
        m3371a(str, str2, measureSet, (DimensionSet) null);
    }

    /* renamed from: a */
    public static void m3373a(String str, String str2, MeasureSet measureSet, boolean z) {
        m3372a(str, str2, measureSet, null, z);
    }

    /* renamed from: a */
    public static void m3371a(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet) {
        m3372a(str, str2, measureSet, dimensionSet, false);
    }

    /* renamed from: a */
    public static void m3372a(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet, boolean z) {
        try {
            if (f3188b) {
                if (!StringUtils.m3590b(str)) {
                    if (!StringUtils.m3590b(str2)) {
                        Metric bVar = new Metric(str, str2, measureSet, dimensionSet, z);
                        MetricRepo.m3683a().mo11759a(bVar);
                    }
                }
                Logger.m3833a("AppMonitorDelegate", "register stat event. module: ", str, " monitorPoint: ", str2);
                if (f3187a) {
                    throw new AppMonitorException("register error. module and monitorPoint can't be null");
                }
            }
        } catch (Throwable th) {
            ExceptionEventBuilder.m3405a(th);
        }
    }

    /* renamed from: a */
    static void m3368a(EventType fVar, int i) {
        try {
            if (f3188b && fVar != null) {
                UploadTask.m3601a(fVar.mo11568a(), i);
                if (i > 0) {
                    fVar.mo11571b(true);
                } else {
                    fVar.mo11571b(false);
                }
            }
        } catch (Throwable th) {
            ExceptionEventBuilder.m3405a(th);
        }
    }

    /* renamed from: a */
    public static void m3376a(boolean z, String str, String str2, String str3) {
        IRequestAuth bVar;
        if (z) {
            bVar = new SecurityRequestAuth(str, str3);
        } else {
            bVar = new BaseRequestAuth(str, str2, "1".equalsIgnoreCase(str3));
        }
        UTDC.m3693a(bVar);
        Config.m3706a((Context) f3189c);
    }

    /* renamed from: a */
    public static void m3369a(String str) {
        UTDC.m3694a(str);
    }

    /* renamed from: a */
    public static void m3374a(Map<String, String> map) {
        Config.m3707a(map);
    }

    /* renamed from: c */
    public static void m3379c() {
        Logger.m3833a("AppMonitorDelegate", "[turnOffRealTimeDebug]");
    }
}
