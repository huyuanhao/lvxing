package com.bytedance.sdk.openadsdk.core;

import android.app.Application;
import android.content.Context;
import com.bytedance.sdk.openadsdk.core.p174h.SdkSwitch;
import com.bytedance.sdk.openadsdk.core.p174h.TTDnsSettings;
import com.bytedance.sdk.openadsdk.core.p174h.TTSdkSettings;
import com.bytedance.sdk.openadsdk.multipro.MultiGlobalInfo;
import com.bytedance.sdk.openadsdk.p165c.AdEvent;
import com.bytedance.sdk.openadsdk.p165c.AdEventDispatcher;
import com.bytedance.sdk.openadsdk.p165c.AdEventDispatcher4MultiProcess;
import com.bytedance.sdk.openadsdk.p165c.AdEventRepertory;
import com.bytedance.sdk.openadsdk.p165c.AdEventRepertoryImpl;
import com.bytedance.sdk.openadsdk.p165c.AdEventThread.C2086a;
import com.bytedance.sdk.openadsdk.p165c.AdEventThread.C2087b;
import com.bytedance.sdk.openadsdk.p165c.StatsBatchEventRepertoryImpl;
import com.bytedance.sdk.openadsdk.p165c.StatsDispatcher4MultiProcess;
import com.bytedance.sdk.openadsdk.p165c.StatsEventRepertoryImpl;
import com.bytedance.sdk.openadsdk.p165c.StatsEventThread;
import com.bytedance.sdk.openadsdk.p185f.p187b.ILogUploader;
import com.bytedance.sdk.openadsdk.p185f.p187b.LogUploaderImpl;
import com.bytedance.sdk.openadsdk.p185f.p187b.LogUploaderImpl.C2424a;
import com.bytedance.sdk.openadsdk.p185f.p187b.LogUploaderImpl4MultiProcess;
import com.bytedance.sdk.openadsdk.p199j.TrackAdUrl;
import com.bytedance.sdk.openadsdk.p199j.TrackAdUrlImpl;
import com.bytedance.sdk.openadsdk.p199j.TrackAdUrlImpl4MultiProcess;
import com.bytedance.sdk.openadsdk.p199j.TrackRetryRepertoryImpl;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.C2566w;
import java.lang.reflect.Method;

/* renamed from: com.bytedance.sdk.openadsdk.core.o */
public class InternalContainer {
    /* renamed from: a */
    private static volatile AdEventDispatcher<AdEvent> f7864a;
    /* renamed from: b */
    private static volatile AdEventDispatcher<C2424a> f7865b;
    /* renamed from: c */
    private static volatile AdEventDispatcher<C2424a> f7866c;
    /* renamed from: d */
    private static volatile NetApi<AdEvent> f7867d;
    /* renamed from: e */
    private static volatile TrackAdUrl f7868e;
    /* renamed from: f */
    private static volatile ILogUploader f7869f;
    /* renamed from: g */
    private static volatile Context f7870g;
    /* renamed from: h */
    private static volatile TTSdkSettings f7871h;
    /* renamed from: i */
    private static volatile TTDnsSettings f7872i;

    /* compiled from: InternalContainer */
    /* renamed from: com.bytedance.sdk.openadsdk.core.o$a */
    private static class C2285a {
        /* renamed from: a */
        private static volatile Application f7874a;

        /* renamed from: a */
        public static Application m10074a() {
            return f7874a;
        }

        static {
            String str = "MyApplication";
            try {
                Object b = m10075b();
                f7874a = (Application) b.getClass().getMethod("getApplication", new Class[0]).invoke(b, new Object[0]);
                C2564t.m12226e(str, "application get success");
            } catch (Throwable th) {
                C2564t.m12223c(str, "application get failed", th);
            }
        }

        /* renamed from: b */
        private static Object m10075b() {
            Object obj = null;
            try {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
                method.setAccessible(true);
                obj = method.invoke(null, new Object[0]);
                return obj;
            } catch (Throwable th) {
                C2564t.m12223c("MyApplication", "ActivityThread get error, maybe api level <= 4.2.2", th);
                return obj;
            }
        }
    }

    /* renamed from: a */
    public static Context m10059a() {
        if (f7870g == null) {
            m10061a(null);
        }
        return f7870g;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0023, code lost:
            return;
     */
    /* renamed from: a */
    public static synchronized void m10061a(android.content.Context r2) {
        /*
        java.lang.Class<com.bytedance.sdk.openadsdk.core.o> r0 = com.bytedance.sdk.openadsdk.core.InternalContainer.class
        monitor-enter(r0)
        android.content.Context r1 = f7870g     // Catch:{ all -> 0x0024 }
        if (r1 != 0) goto L_0x0022
        android.app.Application r1 = com.bytedance.sdk.openadsdk.core.InternalContainer.C2285a.m10074a()     // Catch:{ all -> 0x0024 }
        if (r1 == 0) goto L_0x001a
        android.app.Application r1 = com.bytedance.sdk.openadsdk.core.InternalContainer.C2285a.m10074a()     // Catch:{ all -> 0x0019 }
        f7870g = r1     // Catch:{ all -> 0x0019 }
        android.content.Context r1 = f7870g     // Catch:{ all -> 0x0019 }
        if (r1 == 0) goto L_0x001a
        monitor-exit(r0)
        return
    L_0x001a:
        if (r2 == 0) goto L_0x0022
        android.content.Context r2 = r2.getApplicationContext()     // Catch:{ all -> 0x0024 }
        f7870g = r2     // Catch:{ all -> 0x0024 }
    L_0x0022:
        monitor-exit(r0)
        return
    L_0x0024:
        r2 = move-exception
        monitor-exit(r0)
        throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.InternalContainer.m10061a(android.content.Context):void");
    }

    /* renamed from: b */
    public static void m10063b() {
        f7864a = null;
        f7868e = null;
        f7869f = null;
    }

    /* renamed from: c */
    public static AdEventDispatcher<AdEvent> m10064c() {
        if (!SdkSwitch.m9757a()) {
            return AdEventDispatcher.m8360c();
        }
        if (f7864a == null) {
            synchronized (InternalContainer.class) {
                if (f7864a == null) {
                    if (MultiGlobalInfo.m11808b()) {
                        f7864a = new AdEventDispatcher4MultiProcess();
                    } else {
                        f7864a = new AdEventDispatcher<>(new AdEventRepertoryImpl(f7870g), m10067f(), m10072k(), m10062b(f7870g));
                    }
                }
            }
        }
        return f7864a;
    }

    /* renamed from: d */
    public static AdEventDispatcher<C2424a> m10065d() {
        if (!SdkSwitch.m9757a()) {
            return AdEventDispatcher.m8361d();
        }
        if (f7866c == null) {
            synchronized (InternalContainer.class) {
                if (f7866c == null) {
                    if (MultiGlobalInfo.m11808b()) {
                        f7866c = new StatsDispatcher4MultiProcess(false);
                    } else {
                        f7866c = m10060a("ttad_bk_batch_stats", "AdStatsEventBatchThread", false);
                    }
                }
            }
        }
        return f7866c;
    }

    /* renamed from: e */
    public static AdEventDispatcher<C2424a> m10066e() {
        if (!SdkSwitch.m9757a()) {
            return AdEventDispatcher.m8361d();
        }
        if (f7865b == null) {
            synchronized (InternalContainer.class) {
                if (f7865b == null) {
                    if (MultiGlobalInfo.m11808b()) {
                        f7865b = new StatsDispatcher4MultiProcess(true);
                    } else {
                        f7865b = m10060a("ttad_bk_stats", "AdStatsEventThread", true);
                    }
                }
            }
        }
        return f7865b;
    }

    /* renamed from: f */
    public static NetApi<AdEvent> m10067f() {
        if (f7867d == null) {
            synchronized (InternalContainer.class) {
                if (f7867d == null) {
                    f7867d = new NetApiImpl(f7870g);
                }
            }
        }
        return f7867d;
    }

    /* renamed from: g */
    public static TrackAdUrl m10068g() {
        if (!SdkSwitch.m9757a()) {
            return TrackAdUrlImpl.m11719c();
        }
        if (f7868e == null) {
            synchronized (TrackAdUrl.class) {
                if (f7868e == null) {
                    if (MultiGlobalInfo.m11808b()) {
                        f7868e = new TrackAdUrlImpl4MultiProcess();
                    } else {
                        f7868e = new TrackAdUrlImpl(f7870g, new TrackRetryRepertoryImpl(f7870g));
                    }
                }
            }
        }
        return f7868e;
    }

    /* renamed from: k */
    private static C2087b m10072k() {
        return C2087b.m8469a();
    }

    /* renamed from: a */
    public static AdEventDispatcher<C2424a> m10060a(String str, String str2, boolean z) {
        AdEventRepertory eVar;
        C2087b bVar;
        if (z) {
            eVar = new StatsEventRepertoryImpl(f7870g);
            bVar = C2087b.m8469a();
        } else {
            bVar = C2087b.m8470b();
            eVar = new StatsBatchEventRepertoryImpl(f7870g);
        }
        C2086a b = m10062b(f7870g);
        StatsEventThread oVar = new StatsEventThread(str, str2, eVar, null, bVar, b);
        AdEventDispatcher bVar2 = new AdEventDispatcher(eVar, null, bVar, b, oVar);
        return bVar2;
    }

    /* renamed from: b */
    private static C2086a m10062b(final Context context) {
        return new C2086a() {
            /* renamed from: a */
            public boolean mo15017a() {
                Context context = context;
                if (context == null) {
                    context = InternalContainer.m10059a();
                }
                return C2566w.m12241a(context);
            }
        };
    }

    /* renamed from: h */
    public static TTSdkSettings m10069h() {
        if (f7871h == null) {
            synchronized (TTSdkSettings.class) {
                if (f7871h == null) {
                    f7871h = new TTSdkSettings();
                }
            }
        }
        return f7871h;
    }

    /* renamed from: i */
    public static TTDnsSettings m10070i() {
        if (f7872i == null) {
            synchronized (TTSdkSettings.class) {
                if (f7872i == null) {
                    f7872i = new TTDnsSettings();
                    f7872i.mo15752b();
                }
            }
        }
        return f7872i;
    }

    /* renamed from: j */
    public static ILogUploader m10071j() {
        if (!SdkSwitch.m9757a()) {
            return LogUploaderImpl.m11347c();
        }
        if (f7869f == null) {
            synchronized (LogUploaderImpl.class) {
                if (f7869f == null) {
                    if (MultiGlobalInfo.m11808b()) {
                        f7869f = new LogUploaderImpl4MultiProcess();
                    } else {
                        f7869f = new LogUploaderImpl();
                    }
                }
            }
        }
        return f7869f;
    }
}
