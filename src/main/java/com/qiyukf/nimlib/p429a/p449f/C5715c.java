package com.qiyukf.nimlib.p429a.p449f;

import com.qiyukf.basesdk.sdk.ResponseCode;
import com.qiyukf.nimlib.p429a.C5668c;
import com.qiyukf.nimlib.p429a.p436c.C5669a;
import com.qiyukf.nimlib.p429a.p442d.C5686a;
import com.qiyukf.nimlib.p429a.p442d.C5686a.C5687a;

/* renamed from: com.qiyukf.nimlib.a.f.c */
public abstract class C5715c {
    /* renamed from: a */
    private final C5713a f18261a;
    /* renamed from: b */
    private boolean f18262b = false;

    public C5715c(C5713a aVar) {
        this.f18261a = aVar == null ? null : new C5713a(aVar);
    }

    /* renamed from: a */
    public abstract void mo27887a(C5686a aVar);

    /* renamed from: a */
    public final void mo27956a(short s) {
        C5668c.m22861a().mo27858a(C5687a.m22947a(mo27955b().mo27870a(), s));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo27888a() {
        mo27955b().mo27870a().mo28226b();
        C5668c.m22861a().mo27866a(this);
        return true;
    }

    /* renamed from: b */
    public abstract C5669a mo27955b();

    /* renamed from: c */
    public final boolean mo27957c() {
        C5713a aVar = this.f18261a;
        return aVar != null && aVar.mo27952a() > 0;
    }

    /* renamed from: d */
    public final int mo27958d() {
        C5713a aVar = this.f18261a;
        if (aVar != null) {
            return aVar.mo27953b();
        }
        return 0;
    }

    /* renamed from: e */
    public final boolean mo27959e() {
        C5713a aVar = this.f18261a;
        if (aVar == null) {
            return false;
        }
        int c = aVar.mo27954c();
        if (c == -1 || this.f18262b) {
            mo27956a((short) ResponseCode.RES_ETIMEOUT);
            return false;
        } else if (c < -1) {
            return false;
        } else {
            return mo27888a();
        }
    }

    /* renamed from: f */
    public final boolean mo27960f() {
        C5713a aVar = this.f18261a;
        boolean z = false;
        if (aVar == null || aVar.mo27954c() < -1) {
            return false;
        }
        if (this.f18261a.mo27952a() == -1) {
            z = true;
        }
        this.f18262b = z;
        return mo27888a();
    }
}
