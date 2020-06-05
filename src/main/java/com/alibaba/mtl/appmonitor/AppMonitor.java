package com.alibaba.mtl.appmonitor;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.alibaba.mtl.appmonitor.IMonitor.C1297a;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.log.p077d.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.alibaba.mtl.appmonitor.a */
public final class AppMonitor {
    /* renamed from: a */
    protected static C1290d f3093a;
    /* renamed from: b */
    protected static IMonitor f3094b;
    /* renamed from: c */
    private static Application f3095c;
    /* renamed from: d */
    private static HandlerThread f3096d;
    /* renamed from: e */
    private static volatile boolean f3097e;
    /* access modifiers changed from: private|static */
    /* renamed from: f */
    public static Object f3098f = new Object();
    /* renamed from: g */
    private static List<C1288b> f3099g = Collections.synchronizedList(new ArrayList());
    /* access modifiers changed from: private|static */
    /* renamed from: h */
    public static boolean f3100h = false;
    /* renamed from: i */
    private static String f3101i;
    /* renamed from: j */
    private static String f3102j;
    /* renamed from: k */
    private static boolean f3103k;
    /* renamed from: l */
    private static String f3104l;
    /* access modifiers changed from: private|static */
    /* renamed from: m */
    public static C1289c f3105m = C1289c.Local;
    /* renamed from: n */
    private static Context f3106n;
    /* renamed from: o */
    private static ServiceConnection f3107o = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (C1289c.Service == AppMonitor.f3105m) {
                AppMonitor.f3094b = C1297a.m3449a(iBinder);
                if (AppMonitor.f3100h && AppMonitor.f3093a != null) {
                    AppMonitor.f3093a.postAtFrontOfQueue(new Runnable() {
                        public void run() {
                            AppMonitor.m3297h();
                        }
                    });
                }
            }
            synchronized (AppMonitor.f3098f) {
                AppMonitor.f3098f.notifyAll();
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            Logger.m3833a("AppMonitor", "[onServiceDisconnected]");
            synchronized (AppMonitor.f3098f) {
                AppMonitor.f3098f.notifyAll();
            }
            AppMonitor.f3100h = true;
        }
    };
    /* renamed from: p */
    private static String f3108p;
    /* renamed from: q */
    private static Map<String, Object> f3109q = Collections.synchronizedMap(new HashMap());

    /* compiled from: AppMonitor */
    /* renamed from: com.alibaba.mtl.appmonitor.a$a */
    public static class C1285a {
        /* renamed from: a */
        public static void m3300a(final String str, final String str2, final String str3) {
            if (AppMonitor.m3287a()) {
                AppMonitor.f3093a.mo11539a((Runnable) new Runnable() {
                    public void run() {
                        try {
                            AppMonitor.f3094b.mo11600a(str, str2, str3, (Map) null);
                        } catch (RemoteException e) {
                            AppMonitor.m3290b((Exception) e);
                        }
                    }
                });
            }
        }

        /* renamed from: a */
        public static void m3301a(String str, String str2, String str3, String str4, String str5) {
            if (AppMonitor.m3287a()) {
                final String str6 = str;
                final String str7 = str2;
                final String str8 = str3;
                final String str9 = str4;
                final String str10 = str5;
                C12872 r1 = new Runnable() {
                    public void run() {
                        try {
                            AppMonitor.f3094b.mo11598a(str6, str7, str8, str9, str10, null);
                        } catch (RemoteException e) {
                            AppMonitor.m3290b((Exception) e);
                        }
                    }
                };
                AppMonitor.f3093a.mo11539a((Runnable) r1);
            }
        }
    }

    /* compiled from: AppMonitor */
    /* renamed from: com.alibaba.mtl.appmonitor.a$b */
    static class C1288b {
        /* renamed from: a */
        public String f3130a;
        /* renamed from: b */
        public String f3131b;
        /* renamed from: c */
        public MeasureSet f3132c;
        /* renamed from: d */
        public DimensionSet f3133d;
        /* renamed from: e */
        public boolean f3134e;

        C1288b() {
        }
    }

    /* compiled from: AppMonitor */
    /* renamed from: com.alibaba.mtl.appmonitor.a$c */
    enum C1289c {
        Local,
        Service
    }

    /* compiled from: AppMonitor */
    /* renamed from: com.alibaba.mtl.appmonitor.a$d */
    static class C1290d extends Handler {
        /* renamed from: a */
        private boolean f3138a = false;

        public C1290d(Looper looper) {
            super(looper);
        }

        /* renamed from: a */
        public void mo11539a(Runnable runnable) {
            if (runnable != null) {
                try {
                    Message obtain = Message.obtain();
                    obtain.what = 1;
                    obtain.obj = runnable;
                    sendMessage(obtain);
                } catch (Throwable unused) {
                }
            }
        }

        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0018 */
        public void handleMessage(android.os.Message r5) {
            /*
            r4 = this;
            boolean r0 = r4.f3138a     // Catch:{ all -> 0x0030 }
            if (r0 == 0) goto L_0x001f
            r0 = 0
            r4.f3138a = r0     // Catch:{ all -> 0x0030 }
            java.lang.Object r0 = com.alibaba.mtl.appmonitor.AppMonitor.f3098f     // Catch:{ all -> 0x0030 }
            monitor-enter(r0)     // Catch:{ all -> 0x0030 }
            java.lang.Object r1 = com.alibaba.mtl.appmonitor.AppMonitor.f3098f     // Catch:{ InterruptedException -> 0x0018 }
            r2 = 5000(0x1388, double:2.4703E-320)
            r1.wait(r2)     // Catch:{ InterruptedException -> 0x0018 }
            goto L_0x001b
        L_0x0016:
            r1 = move-exception
            goto L_0x001d
        L_0x0018:
            com.alibaba.mtl.appmonitor.AppMonitor.m3298i()     // Catch:{ all -> 0x0016 }
        L_0x001b:
            monitor-exit(r0)     // Catch:{ all -> 0x0016 }
            goto L_0x001f
        L_0x001d:
            monitor-exit(r0)     // Catch:{ all -> 0x0016 }
            throw r1     // Catch:{ all -> 0x0030 }
        L_0x001f:
            java.lang.Object r0 = r5.obj     // Catch:{ all -> 0x0030 }
            if (r0 == 0) goto L_0x0030
            java.lang.Object r0 = r5.obj     // Catch:{ all -> 0x0030 }
            boolean r0 = r0 instanceof java.lang.Runnable     // Catch:{ all -> 0x0030 }
            if (r0 == 0) goto L_0x0030
            java.lang.Object r0 = r5.obj     // Catch:{ all -> 0x0030 }
            java.lang.Runnable r0 = (java.lang.Runnable) r0     // Catch:{ all -> 0x0030 }
            r0.run()     // Catch:{ all -> 0x0030 }
        L_0x0030:
            super.handleMessage(r5)
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.appmonitor.AppMonitor.C1290d.handleMessage(android.os.Message):void");
        }

        /* renamed from: a */
        public void mo11540a(boolean z) {
            this.f3138a = true;
        }
    }

    static {
        String str = "AppMonitor";
        try {
            System.loadLibrary("ut_c_api");
            Log.i(str, "load ut_c_api.so success");
        } catch (Throwable unused) {
            Log.w(str, "load ut_c_api.so failed");
        }
    }

    /* renamed from: a */
    public static synchronized void m3283a(Application application) {
        synchronized (AppMonitor.class) {
            Logger.m3833a("AppMonitor", "[init]");
            try {
                if (!f3097e) {
                    f3095c = application;
                    if (f3095c != null) {
                        f3106n = f3095c.getApplicationContext();
                    }
                    f3096d = new HandlerThread("AppMonitor_Client");
                    f3096d.start();
                    f3093a = new C1290d(f3096d.getLooper());
                    if (f3105m == C1289c.Local) {
                        m3298i();
                    } else if (m3296g()) {
                        f3093a.mo11540a(true);
                    }
                    m3299j().run();
                    f3097e = true;
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    public static void m3285a(final boolean z) {
        if (m3287a()) {
            f3093a.mo11539a((Runnable) new Runnable() {
                public void run() {
                    try {
                        AppMonitor.f3094b.mo11603a(z);
                    } catch (RemoteException e) {
                        AppMonitor.m3290b((Exception) e);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public static void m3286a(boolean z, String str, String str2, String str3) {
        if (m3287a()) {
            f3093a.mo11539a(m3289b(z, str, str2, str3));
            f3103k = z;
            f3102j = str;
            f3104l = str2;
            f3108p = str3;
        }
    }

    /* renamed from: g */
    private static boolean m3296g() {
        Application application = f3095c;
        if (application == null) {
            return false;
        }
        boolean bindService = application.getApplicationContext().bindService(new Intent(f3095c.getApplicationContext(), AppMonitorService.class), f3107o, 1);
        if (!bindService) {
            m3298i();
        }
        Logger.m3833a("AppMonitor", "bindsuccess:", Boolean.valueOf(bindService));
        return bindService;
    }

    /* access modifiers changed from: private|static */
    /* renamed from: b */
    public static void m3290b(Exception exc) {
        Logger.m3832a("AppMonitor", "", exc);
        if (exc instanceof DeadObjectException) {
            m3297h();
        }
    }

    /* access modifiers changed from: private|static|declared_synchronized */
    /* renamed from: h */
    public static synchronized void m3297h() {
        synchronized (AppMonitor.class) {
            Logger.m3833a("AppMonitor", "[restart]");
            try {
                if (f3100h) {
                    f3100h = false;
                    m3298i();
                    m3299j().run();
                    m3289b(f3103k, f3102j, f3104l, f3108p).run();
                    m3281a(f3101i).run();
                    synchronized (f3099g) {
                        for (int i = 0; i < f3099g.size(); i++) {
                            C1288b bVar = (C1288b) f3099g.get(i);
                            if (bVar != null) {
                                try {
                                    m3282a(bVar.f3130a, bVar.f3131b, bVar.f3132c, bVar.f3133d, bVar.f3134e).run();
                                } catch (Throwable unused) {
                                }
                            }
                        }
                    }
                }
            } catch (Throwable unused2) {
            }
        }
    }

    /* access modifiers changed from: private|static */
    /* renamed from: i */
    public static void m3298i() {
        f3094b = new Monitor(f3095c);
        f3105m = C1289c.Local;
        Logger.m3831a("AppMonitor", (Object) "Start AppMonitor Service failed,AppMonitor run in local Mode...");
    }

    /* renamed from: a */
    public static boolean m3287a() {
        if (!f3097e) {
            Logger.m3833a("AppMonitor", "Please call UTAnalytics.getInstance().setAppApplicationInstance()||.setAppApplicationInstance4sdk() before call other method");
        }
        return f3097e;
    }

    /* renamed from: j */
    private static Runnable m3299j() {
        return new Runnable() {
            public void run() {
                try {
                    AppMonitor.f3094b.mo11583a();
                } catch (RemoteException unused) {
                    AppMonitor.m3298i();
                    AppMonitor.f3094b.mo11583a();
                } catch (Throwable unused2) {
                }
            }
        };
    }

    /* renamed from: b */
    private static Runnable m3289b(final boolean z, final String str, final String str2, final String str3) {
        return new Runnable() {
            public void run() {
                try {
                    AppMonitor.f3094b.mo11604a(z, str, str2, str3);
                } catch (Throwable unused) {
                }
            }
        };
    }

    /* renamed from: a */
    private static Runnable m3281a(final String str) {
        return new Runnable() {
            public void run() {
                try {
                    AppMonitor.f3094b.mo11587a(str);
                } catch (Throwable unused) {
                }
            }
        };
    }

    /* renamed from: a */
    private static Runnable m3282a(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet, boolean z) {
        final String str3 = str;
        final String str4 = str2;
        final MeasureSet measureSet2 = measureSet;
        final DimensionSet dimensionSet2 = dimensionSet;
        final boolean z2 = z;
        C12846 r0 = new Runnable() {
            public void run() {
                try {
                    Logger.m3833a("AppMonitor", "register stat event. module: ", str3, " monitorPoint: ", str4);
                    AppMonitor.f3094b.mo11594a(str3, str4, measureSet2, dimensionSet2, z2);
                } catch (RemoteException e) {
                    AppMonitor.m3290b((Exception) e);
                }
            }
        };
        return r0;
    }
}
