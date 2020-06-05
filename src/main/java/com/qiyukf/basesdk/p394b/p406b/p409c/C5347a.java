package com.qiyukf.basesdk.p394b.p406b.p409c;

import com.qiyukf.basesdk.p394b.p406b.p407a.C5327d;

/* renamed from: com.qiyukf.basesdk.b.b.c.a */
public class C5347a implements C5350d {
    /* renamed from: a */
    protected C5327d f17276a;

    /* renamed from: a */
    public final void mo27275a(C5327d dVar) {
        this.f17276a = dVar;
    }

    /* renamed from: a */
    public void mo27283a(Object obj) {
        C5350d d = this.f17276a.mo27248d();
        if (d != null) {
            try {
                d.mo27283a(obj);
            } catch (Throwable th) {
                d.mo27277a(th);
            }
        }
    }

    /* renamed from: a */
    public final void mo27277a(Throwable th) {
        if (this.f17276a.mo27245a() != null && this.f17276a.mo27245a().mo27251g() != null) {
            this.f17276a.mo27245a().mo27251g().mo27277a(th);
        }
    }

    /* renamed from: h */
    public void mo27284h() {
        C5350d d = this.f17276a.mo27248d();
        if (d != null) {
            try {
                d.mo27284h();
            } catch (Throwable th) {
                d.mo27277a(th);
            }
        }
    }

    /* renamed from: i */
    public void mo27285i() {
        C5350d d = this.f17276a.mo27248d();
        if (d != null) {
            try {
                d.mo27285i();
            } catch (Throwable th) {
                d.mo27277a(th);
            }
        }
    }
}
