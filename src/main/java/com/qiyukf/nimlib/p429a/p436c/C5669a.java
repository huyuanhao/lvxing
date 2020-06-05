package com.qiyukf.nimlib.p429a.p436c;

import com.qiyukf.nimlib.p473h.p481c.C5888a;
import com.qiyukf.nimlib.p473h.p481c.p484c.C5894b;
import java.nio.ByteBuffer;

/* renamed from: com.qiyukf.nimlib.a.c.a */
public abstract class C5669a {
    /* renamed from: a */
    private C5888a f18202a;
    /* renamed from: b */
    private Object f18203b;

    /* renamed from: com.qiyukf.nimlib.a.c.a$a */
    public static class C5670a {
        /* renamed from: a */
        public C5888a f18204a;
        /* renamed from: b */
        public ByteBuffer f18205b;

        public C5670a(C5888a aVar, ByteBuffer byteBuffer) {
            this.f18204a = aVar;
            this.f18205b = byteBuffer;
        }
    }

    /* renamed from: a */
    public final C5888a mo27870a() {
        if (this.f18202a == null) {
            this.f18202a = new C5888a(mo27873c(), mo27874d());
        }
        return this.f18202a;
    }

    /* renamed from: a */
    public final void mo27871a(Object obj) {
        this.f18203b = obj;
    }

    /* renamed from: b */
    public abstract C5894b mo27872b();

    /* renamed from: c */
    public abstract byte mo27873c();

    /* renamed from: d */
    public abstract byte mo27874d();

    /* renamed from: e */
    public final Object mo27875e() {
        return this.f18203b;
    }
}
