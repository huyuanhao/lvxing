package com.qiyukf.nimlib.p473h;

import android.content.Context;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.basesdk.p412c.C5361a;
import com.qiyukf.basesdk.p412c.C5420e;
import com.qiyukf.nimlib.p429a.C5648b;
import com.qiyukf.nimlib.p429a.p431b.C5655b;
import com.qiyukf.nimlib.p429a.p436c.C5669a;
import com.qiyukf.nimlib.p429a.p442d.C5686a.C5687a;
import com.qiyukf.nimlib.p470f.p471a.C5826a;
import com.qiyukf.nimlib.p473h.p478b.C5867b;
import com.qiyukf.nimlib.p473h.p478b.C5867b.C5873a;
import com.qiyukf.nimlib.sdk.auth.LoginInfo;
import com.qiyukf.unicorn.p513g.C6177d;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.qiyukf.nimlib.h.f */
public final class C5906f {
    /* renamed from: g */
    private static C5906f f18667g = new C5906f();
    /* renamed from: a */
    private AtomicInteger f18668a = new AtomicInteger(1);
    /* renamed from: b */
    private Context f18669b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public C5862b f18670c = new C5862b();
    /* renamed from: d */
    private C5867b f18671d = new C5867b(new C5873a() {
        /* renamed from: a */
        public final void mo28196a(int i) {
            C5906f.this.f18672e.execute(new Runnable(i) {
                public final void run() {
                    try {
                        C5906f.this.f18670c.mo28179a(r3);
                    } catch (Throwable unused) {
                        C5264a.m21617a("core", "handle connection change error");
                    }
                }
            });
        }

        /* renamed from: a */
        public final void mo28197a(C5687a aVar) {
            C5906f.this.f18673f.mo27843a(aVar);
        }
    });
    /* renamed from: e */
    private C5420e f18672e = new C5420e("Response", C5420e.f17395c, false);
    /* access modifiers changed from: private */
    /* renamed from: f */
    public C5655b f18673f = new C5655b(true, this.f18672e, null);

    private C5906f() {
    }

    /* renamed from: a */
    public static C5906f m23656a() {
        return f18667g;
    }

    /* renamed from: a */
    static /* synthetic */ void m23658a(C5906f fVar, boolean z) {
        String str = "core";
        try {
            if (fVar.f18668a.compareAndSet(3, 4)) {
                C5264a.m21617a(str, "shutdown");
                fVar.f18671d.mo28189a();
                fVar.f18670c.mo28178a();
                fVar.f18672e.mo27366b();
                fVar.f18668a.compareAndSet(4, 1);
            }
            if (z) {
                fVar.mo28278a(fVar.f18669b);
            }
        } catch (Throwable th) {
            C5264a.m21621b(str, "restart error", th);
        }
    }

    /* renamed from: a */
    private void m23659a(final boolean z) {
        this.f18670c.mo28183a(z);
        C5361a.m22014b().postDelayed(new Runnable() {
            public final void run() {
                C5906f.m23658a(C5906f.this, z);
            }
        }, 100);
    }

    /* renamed from: e */
    private boolean m23661e() {
        return this.f18668a.get() == 3;
    }

    /* renamed from: a */
    public final void mo28276a(int i) {
        this.f18670c.mo28185b(i);
    }

    /* renamed from: a */
    public final void mo28277a(int i, int i2) {
        this.f18670c.mo28180a(i, i2);
        C6177d.m24495a().mo29248b();
        C5361a.m22014b().post(new Runnable() {
            public final void run() {
                C5906f.m23658a(C5906f.this, true);
            }
        });
    }

    /* renamed from: a */
    public final void mo28278a(Context context) {
        if (this.f18668a.compareAndSet(1, 2)) {
            C5264a.m21617a("core", "startup");
            this.f18669b = context;
            this.f18672e.mo27364a();
            this.f18670c.mo28181a(context, this.f18671d);
            this.f18668a.compareAndSet(2, 3);
        }
    }

    /* renamed from: a */
    public final void mo28279a(C5669a aVar) {
        if (m23661e()) {
            aVar.mo27870a().mo28225a(C5648b.m22819a(true));
            this.f18671d.mo28190a(aVar);
        }
    }

    /* renamed from: a */
    public final void mo28280a(C5687a aVar) {
        this.f18673f.mo27843a(aVar);
    }

    /* renamed from: a */
    public final void mo28281a(C5826a aVar) {
        if (m23661e()) {
            this.f18671d.mo28191a(aVar);
        }
    }

    /* renamed from: a */
    public final void mo28282a(LoginInfo loginInfo) {
        if (m23661e()) {
            this.f18670c.mo28182a(loginInfo);
        }
    }

    /* renamed from: b */
    public final void mo28283b() {
        m23659a(true);
        C6177d.m24495a().mo29248b();
    }

    /* renamed from: b */
    public final void mo28284b(Context context) {
        mo28278a(context);
        this.f18670c.mo28187d();
    }

    /* renamed from: c */
    public final void mo28285c() {
        m23659a(false);
    }

    /* renamed from: d */
    public final void mo28286d() {
        if (this.f18668a.get() == 3) {
            this.f18671d.mo28193b();
        }
    }
}
