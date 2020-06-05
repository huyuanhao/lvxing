package com.qiyukf.nimlib.p429a.p442d;

import com.qiyukf.basesdk.sdk.ResponseCode;
import com.qiyukf.nimlib.p473h.p481c.C5888a;
import com.qiyukf.nimlib.p473h.p481c.p484c.C5898f;

/* renamed from: com.qiyukf.nimlib.a.d.a */
public abstract class C5686a {
    /* renamed from: a */
    protected C5888a f18230a;

    /* renamed from: com.qiyukf.nimlib.a.d.a$a */
    public static final class C5687a {
        /* renamed from: a */
        public C5888a f18231a;
        /* renamed from: b */
        public C5898f f18232b;

        /* renamed from: a */
        public static C5687a m22947a(C5888a aVar, short s) {
            if (aVar == null) {
                return null;
            }
            C5687a aVar2 = new C5687a();
            aVar2.f18231a = aVar.mo28221a();
            aVar2.f18231a.mo28227b(s);
            return aVar2;
        }
    }

    /* renamed from: a */
    public final C5888a mo27891a() {
        return this.f18230a;
    }

    /* renamed from: a */
    public abstract C5898f mo27845a(C5898f fVar);

    /* renamed from: a */
    public final void mo27892a(C5888a aVar) {
        this.f18230a = aVar;
    }

    /* renamed from: b */
    public final boolean mo27893b() {
        C5888a aVar = this.f18230a;
        return aVar != null && aVar.mo28235j() == 200;
    }

    /* renamed from: c */
    public final short mo27894c() {
        C5888a aVar = this.f18230a;
        if (aVar != null) {
            return aVar.mo28234i();
        }
        return 0;
    }

    /* renamed from: d */
    public final byte mo27895d() {
        C5888a aVar = this.f18230a;
        if (aVar != null) {
            return aVar.mo28233h();
        }
        return 0;
    }

    /* renamed from: e */
    public final short mo27896e() {
        C5888a aVar = this.f18230a;
        return aVar != null ? aVar.mo28235j() : ResponseCode.RES_EUNKNOWN;
    }
}
