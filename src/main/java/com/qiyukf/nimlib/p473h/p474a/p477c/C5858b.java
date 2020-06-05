package com.qiyukf.nimlib.p473h.p474a.p477c;

import com.qiyukf.nimlib.p429a.C5645a;
import com.qiyukf.nimlib.p429a.p442d.C5686a;
import com.qiyukf.nimlib.p429a.p442d.C5692b;
import com.qiyukf.nimlib.p473h.p481c.p483b.C5892b;
import com.qiyukf.nimlib.p473h.p481c.p484c.C5896d;
import com.qiyukf.nimlib.p473h.p481c.p484c.C5898f;
import java.util.ArrayList;

@C5692b(mo27899a = 2, mo27900b = {"2"})
/* renamed from: com.qiyukf.nimlib.h.a.c.b */
public class C5858b extends C5686a {
    /* renamed from: b */
    private C5892b f18560b;
    /* renamed from: c */
    private ArrayList<C5645a> f18561c;

    /* renamed from: a */
    public final C5898f mo27845a(C5898f fVar) {
        this.f18560b = C5896d.m23615a(fVar);
        if (fVar.mo28260a() > 0) {
            int f = fVar.mo28267f();
            if (f > 0) {
                this.f18561c = new ArrayList<>(f);
                for (int i = 0; i < f; i++) {
                    this.f18561c.add(C5645a.m22814a(C5896d.m23615a(fVar)));
                }
            }
        }
        return null;
    }

    /* renamed from: f */
    public final C5892b mo28171f() {
        return this.f18560b;
    }

    /* renamed from: g */
    public final ArrayList<C5645a> mo28172g() {
        return this.f18561c;
    }
}
