package com.qiyukf.nimlib.p473h.p474a.p477c;

import com.qiyukf.nimlib.p429a.C5645a;
import com.qiyukf.nimlib.p429a.p442d.C5686a;
import com.qiyukf.nimlib.p429a.p442d.C5692b;
import com.qiyukf.nimlib.p473h.p481c.p484c.C5896d;
import com.qiyukf.nimlib.p473h.p481c.p484c.C5898f;
import java.util.ArrayList;

@C5692b(mo27899a = 2, mo27900b = {"7"})
/* renamed from: com.qiyukf.nimlib.h.a.c.c */
public class C5859c extends C5686a {
    /* renamed from: b */
    private byte f18562b;
    /* renamed from: c */
    private ArrayList<C5645a> f18563c;

    /* renamed from: a */
    public final C5898f mo27845a(C5898f fVar) {
        this.f18562b = fVar.mo28264c();
        int f = fVar.mo28267f();
        this.f18563c = new ArrayList<>(f);
        for (int i = 0; i < f; i++) {
            this.f18563c.add(C5645a.m22814a(C5896d.m23615a(fVar)));
        }
        return null;
    }

    /* renamed from: f */
    public final byte mo28173f() {
        return this.f18562b;
    }

    /* renamed from: g */
    public final ArrayList<C5645a> mo28174g() {
        return this.f18563c;
    }
}
