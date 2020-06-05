package com.qiyukf.unicorn.p513g;

import android.content.Context;
import android.os.Handler;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.nimlib.p470f.C5837d;
import com.qiyukf.nimlib.p473h.C5906f;
import com.qiyukf.unicorn.api.SavePowerConfig;

/* renamed from: com.qiyukf.unicorn.g.c */
public final class C6174c {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public Context f19285a;
    /* renamed from: b */
    private Handler f19286b;
    /* renamed from: c */
    private Runnable f19287c;

    /* renamed from: com.qiyukf.unicorn.g.c$a */
    private static class C6176a {
        /* renamed from: a */
        public static final C6174c f19289a = new C6174c(0);
    }

    private C6174c() {
        this.f19287c = new Runnable() {
            public final void run() {
                C6169a.m24482a(C6174c.this.f19285a, false);
            }
        };
    }

    /* synthetic */ C6174c(byte b) {
        this();
    }

    /* renamed from: a */
    public static C6174c m24489a(Context context) {
        if (C6176a.f19289a.f19285a == null && context != null) {
            C6176a.f19289a.f19285a = context;
            C6176a.f19289a.f19286b = new Handler(context.getMainLooper());
        }
        return C6176a.f19289a;
    }

    /* renamed from: a */
    private void m24490a(long j) {
        SavePowerConfig f = C6177d.m24495a().mo29256f();
        long j2 = f == null ? -1 : f.activeDelay * 1000;
        if (j2 >= 0) {
            long max = Math.max(Math.min(j2 - j, j2), 15000);
            this.f19286b.removeCallbacks(this.f19287c);
            StringBuilder sb = new StringBuilder("switch to saver mode in ");
            sb.append(max);
            C5264a.m21617a("PowerSaver", sb.toString());
            this.f19286b.postDelayed(this.f19287c, max);
        }
    }

    /* renamed from: c */
    private static boolean m24491c() {
        SavePowerConfig f = C6177d.m24495a().mo29256f();
        return f != null && f.customPush && C6177d.m24495a().mo29259i();
    }

    /* renamed from: a */
    public final void mo29240a(int i) {
        if (C6177d.m24495a().mo29257g()) {
            String str = "PowerSaver";
            if (i == 1) {
                C5264a.m21617a(str, "quit saver mode");
                this.f19286b.removeCallbacks(this.f19287c);
                C6177d a = C6177d.m24495a();
                if (a.mo29254e() != 0) {
                    a.mo29244a(0);
                    a.mo29245a(System.currentTimeMillis());
                    C5906f.m23656a().mo28284b(this.f19285a);
                    C6169a.m24483b(this.f19285a);
                    if (C6177d.m24495a().mo29259i()) {
                        C5837d.m23406a(false);
                    }
                }
            } else if (i == 0) {
                C6177d a2 = C6177d.m24495a();
                if (a2.mo29254e() == 0) {
                    C5264a.m21617a(str, "persistent connection goes dying");
                    a2.mo29245a(System.currentTimeMillis());
                    m24490a(0);
                }
            } else {
                if (i == 2) {
                    C6177d a3 = C6177d.m24495a();
                    if (a3.mo29254e() != 1) {
                        a3.mo29244a(1);
                        C5906f.m23656a().mo28285c();
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public final boolean mo29241a() {
        String str = "PowerSaver";
        if (!C6177d.m24495a().mo29257g()) {
            C5264a.m21617a(str, "not need Save Mode");
            C5906f.m23656a().mo28278a(this.f19285a);
            return false;
        }
        C6177d a = C6177d.m24495a();
        int e = a.mo29254e();
        StringBuilder sb = new StringBuilder("check when start, mode is ");
        sb.append(e);
        C5264a.m21617a(str, sb.toString());
        if (e == 0) {
            C5906f.m23656a().mo28278a(this.f19285a);
            m24490a(System.currentTimeMillis() - a.mo29250c());
            return false;
        }
        if (!m24491c()) {
            C6169a.m24481a(this.f19285a);
        }
        return true;
    }

    /* renamed from: b */
    public final void mo29242b() {
        C6177d a = C6177d.m24495a();
        int e = a.mo29254e();
        StringBuilder sb = new StringBuilder("switch to saver mode from: ");
        sb.append(e);
        C5264a.m21617a("PowerSaver", sb.toString());
        if (!m24491c()) {
            if (e != 1) {
                a.mo29244a(1);
                C5906f.m23656a().mo28285c();
            }
            C6177d.m24495a().mo29249b(System.currentTimeMillis());
            C6169a.m24481a(this.f19285a);
        } else if (e != 1) {
            C5837d.m23406a(true);
        }
    }
}
