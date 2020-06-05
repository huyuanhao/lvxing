package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.bugly.BuglyStrategy.C7120a;
import com.tencent.bugly.crashreport.common.info.AppInfo;
import com.tencent.bugly.crashreport.common.info.C7174a;
import com.tencent.bugly.crashreport.common.strategy.C7177a;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.anr.C7187b;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.proguard.C7212ae;
import com.tencent.bugly.proguard.C7215ag;
import com.tencent.bugly.proguard.C7219ak;
import com.tencent.bugly.proguard.C7224am;
import com.tencent.bugly.proguard.C7226an;
import com.tencent.bugly.proguard.C7232aq;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.crashreport.crash.c */
public class C7192c {
    /* renamed from: a */
    public static int f24187a = 0;
    /* renamed from: b */
    public static boolean f24188b = false;
    /* renamed from: c */
    public static int f24189c = 2;
    /* renamed from: d */
    public static boolean f24190d = true;
    /* renamed from: e */
    public static int f24191e = 20480;
    /* renamed from: f */
    public static int f24192f = 20480;
    /* renamed from: g */
    public static long f24193g = 604800000;
    /* renamed from: h */
    public static String f24194h = null;
    /* renamed from: i */
    public static boolean f24195i = false;
    /* renamed from: j */
    public static String f24196j = null;
    /* renamed from: k */
    public static int f24197k = 5000;
    /* renamed from: l */
    public static boolean f24198l = true;
    /* renamed from: m */
    public static boolean f24199m = false;
    /* renamed from: n */
    public static String f24200n;
    /* renamed from: o */
    public static String f24201o;
    /* renamed from: v */
    private static C7192c f24202v;
    /* renamed from: p */
    public final C7190b f24203p;
    /* renamed from: q */
    public final C7177a f24204q = C7177a.m30857a();
    /* renamed from: r */
    public final C7224am f24205r;
    /* renamed from: s */
    public C7120a f24206s;
    /* renamed from: t */
    public C7199f f24207t;
    /* access modifiers changed from: private|final */
    /* renamed from: u */
    public final Context f24208u;
    /* access modifiers changed from: private|final */
    /* renamed from: w */
    public final C7198e f24209w;
    /* renamed from: x */
    private final NativeCrashHandler f24210x;
    /* renamed from: y */
    private final C7187b f24211y;
    /* renamed from: z */
    private Boolean f24212z;

    protected C7192c(int i, Context context, C7224am amVar, boolean z, C7120a aVar, C7199f fVar, String str) {
        f24187a = i;
        Context a = C7232aq.m31172a(context);
        this.f24208u = a;
        this.f24205r = amVar;
        this.f24206s = aVar;
        C7199f fVar2 = fVar;
        this.f24207t = fVar2;
        C7219ak a2 = C7219ak.m31089a();
        C7212ae a3 = C7212ae.m31041a();
        C7190b bVar = new C7190b(i, a, a2, a3, this.f24204q, aVar, fVar2);
        this.f24203p = bVar;
        C7174a a4 = C7174a.m30753a(a);
        this.f24209w = new C7198e(a, this.f24203p, this.f24204q, a4);
        C7224am amVar2 = amVar;
        this.f24210x = NativeCrashHandler.getInstance(a, a4, this.f24203p, this.f24204q, amVar2, z, str);
        a4.f23975M = this.f24210x;
        C7187b bVar2 = new C7187b(a, this.f24204q, a4, amVar2, a3, this.f24203p, aVar);
        this.f24211y = bVar2;
    }

    /* renamed from: a */
    public static synchronized C7192c m30938a(int i, Context context, boolean z, C7120a aVar, C7199f fVar, String str) {
        C7192c cVar;
        synchronized (C7192c.class) {
            if (f24202v == null) {
                C7192c cVar2 = new C7192c(i, context, C7224am.m31132a(), z, aVar, fVar, str);
                f24202v = cVar2;
            }
            cVar = f24202v;
        }
        return cVar;
    }

    /* renamed from: a */
    public static synchronized C7192c m30937a() {
        C7192c cVar;
        synchronized (C7192c.class) {
            cVar = f24202v;
        }
        return cVar;
    }

    /* renamed from: a */
    public void mo34688a(StrategyBean strategyBean) {
        this.f24209w.mo34711a(strategyBean);
        this.f24210x.onStrategyChanged(strategyBean);
        this.f24211y.mo34650a(strategyBean);
        mo34687a(3000);
    }

    /* renamed from: b */
    public boolean mo34692b() {
        Boolean bool = this.f24212z;
        if (bool != null) {
            return bool.booleanValue();
        }
        String str = C7174a.m30754b().f24024e;
        List<C7215ag> a = C7212ae.m31041a().mo34778a(1);
        ArrayList arrayList = new ArrayList();
        if (a == null || a.size() <= 0) {
            this.f24212z = Boolean.valueOf(false);
            return false;
        }
        for (C7215ag agVar : a) {
            if (str.equals(agVar.f24332c)) {
                this.f24212z = Boolean.valueOf(true);
                arrayList.add(agVar);
            }
        }
        if (arrayList.size() > 0) {
            C7212ae.m31041a().mo34780a((List<C7215ag>) arrayList);
        }
        return true;
    }

    /* renamed from: c */
    public synchronized void mo34693c() {
        mo34696f();
        mo34698h();
        mo34699i();
    }

    /* renamed from: d */
    public synchronized void mo34694d() {
        mo34695e();
        mo34697g();
        mo34700j();
    }

    /* renamed from: e */
    public void mo34695e() {
        this.f24209w.mo34713b();
    }

    /* renamed from: f */
    public void mo34696f() {
        this.f24209w.mo34710a();
    }

    /* renamed from: g */
    public void mo34697g() {
        this.f24210x.setUserOpened(false);
    }

    /* renamed from: h */
    public void mo34698h() {
        this.f24210x.setUserOpened(true);
    }

    /* renamed from: i */
    public void mo34699i() {
        if (VERSION.SDK_INT <= 19) {
            this.f24211y.mo34658b(true);
        } else {
            this.f24211y.mo34664h();
        }
    }

    /* renamed from: j */
    public void mo34700j() {
        if (VERSION.SDK_INT < 19) {
            this.f24211y.mo34658b(false);
        } else {
            this.f24211y.mo34665i();
        }
    }

    /* renamed from: a */
    public synchronized void mo34691a(boolean z, boolean z2, boolean z3) {
        this.f24210x.testNativeCrash(z, z2, z3);
    }

    /* renamed from: k */
    public synchronized void mo34701k() {
        this.f24211y.mo34663g();
    }

    /* renamed from: l */
    public boolean mo34702l() {
        return this.f24211y.mo34653a();
    }

    /* renamed from: a */
    public void mo34690a(Thread thread, Throwable th, boolean z, String str, byte[] bArr, boolean z2) {
        C7224am amVar = this.f24205r;
        final boolean z3 = z;
        final Thread thread2 = thread;
        final Throwable th2 = th;
        final String str2 = str;
        final byte[] bArr2 = bArr;
        final boolean z4 = z2;
        C71931 r0 = new Runnable() {
            public void run() {
                try {
                    C7226an.m31147c("post a throwable %b", Boolean.valueOf(z3));
                    C7192c.this.f24209w.mo34714b(thread2, th2, false, str2, bArr2);
                    if (z4) {
                        C7226an.m31141a("clear user datas", new Object[0]);
                        C7174a.m30753a(C7192c.this.f24208u).mo34557C();
                    }
                } catch (Throwable th) {
                    if (!C7226an.m31145b(th)) {
                        th.printStackTrace();
                    }
                    C7226an.m31149e("java catch error: %s", th2.toString());
                }
            }
        };
        amVar.mo34832a(r0);
    }

    /* renamed from: a */
    public void mo34689a(CrashDetailBean crashDetailBean) {
        this.f24203p.mo34686e(crashDetailBean);
    }

    /* renamed from: a */
    public void mo34687a(long j) {
        C7224am.m31132a().mo34833a(new Thread() {
            public void run() {
                List list;
                String str = "local_crash_lock";
                if (C7232aq.m31193a(C7192c.this.f24208u, str, 10000)) {
                    List a = C7192c.this.f24203p.mo34670a();
                    if (a != null && a.size() > 0) {
                        C7226an.m31147c("Size of crash list: %s", Integer.valueOf(a.size()));
                        int size = a.size();
                        if (((long) size) > 20) {
                            ArrayList arrayList = new ArrayList();
                            Collections.sort(a);
                            for (int i = 0; ((long) i) < 20; i++) {
                                arrayList.add(a.get((size - 1) - i));
                            }
                            list = arrayList;
                        } else {
                            list = a;
                        }
                        C7192c.this.f24203p.mo34674a(list, 0, false, false, false);
                    }
                    C7232aq.m31220c(C7192c.this.f24208u, str);
                }
            }
        }, j);
    }

    /* renamed from: m */
    public void mo34703m() {
        this.f24210x.checkUploadRecordCrash();
    }

    /* renamed from: n */
    public void mo34704n() {
        if (C7174a.m30754b().f24024e.equals(AppInfo.m30738a(this.f24208u))) {
            this.f24210x.removeEmptyNativeRecordFiles();
        }
    }
}
