package com.qiyukf.nimlib.p429a.p436c.p440d;

import com.qiyukf.nimlib.p429a.p436c.C5669a;
import com.qiyukf.nimlib.p473h.p481c.p484c.C5894b;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;

/* renamed from: com.qiyukf.nimlib.a.c.d.c */
public final class C5680c extends C5669a {
    /* renamed from: a */
    private SessionTypeEnum f18220a;
    /* renamed from: b */
    private String f18221b;
    /* renamed from: c */
    private long f18222c;
    /* renamed from: d */
    private long f18223d;
    /* renamed from: e */
    private long f18224e;
    /* renamed from: f */
    private int f18225f;
    /* renamed from: g */
    private boolean f18226g;
    /* renamed from: h */
    private boolean f18227h;

    public C5680c(String str, SessionTypeEnum sessionTypeEnum, long j, long j2, long j3, int i, boolean z, boolean z2) {
        this.f18221b = str;
        this.f18220a = sessionTypeEnum;
        this.f18222c = j;
        this.f18223d = j2;
        this.f18224e = j3;
        this.f18225f = i;
        this.f18226g = z;
        this.f18227h = z2;
    }

    /* renamed from: b */
    public final C5894b mo27872b() {
        C5894b bVar = new C5894b();
        if (this.f18220a == SessionTypeEnum.Team) {
            bVar.mo28256b(this.f18221b);
        } else {
            bVar.mo28250a(this.f18221b);
        }
        bVar.mo28248a(this.f18222c);
        bVar.mo28248a(this.f18223d);
        bVar.mo28248a(this.f18224e);
        bVar.mo28247a(this.f18225f);
        bVar.mo28253a(this.f18226g);
        return bVar;
    }

    /* renamed from: c */
    public final byte mo27873c() {
        return this.f18220a == SessionTypeEnum.Team ? (byte) 8 : 7;
    }

    /* renamed from: d */
    public final byte mo27874d() {
        return this.f18220a == SessionTypeEnum.Team ? (byte) 23 : 6;
    }
}
