package com.qiyukf.unicorn.p493a.p494a.p495a.p496a;

import com.qiyukf.unicorn.p503f.p504a.C6118d;
import com.qiyukf.unicorn.p503f.p504a.C6144e;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6112c;

/* renamed from: com.qiyukf.unicorn.a.a.a.a.c */
public abstract class C5972c extends C6118d {
    /* renamed from: a */
    private C6144e f18806a;

    /* renamed from: a */
    public final C6144e mo28535a() {
        return this.f18806a;
    }

    /* renamed from: a */
    public final void mo28536a(C6144e eVar) {
        this.f18806a = eVar;
    }

    /* renamed from: b */
    public final String mo28537b() {
        C6112c cVar = (C6112c) getClass().getAnnotation(C6112c.class);
        if (cVar != null) {
            return cVar.mo29054a();
        }
        return null;
    }

    public String toJson(boolean z) {
        return this.f18806a.toJson(z);
    }
}
