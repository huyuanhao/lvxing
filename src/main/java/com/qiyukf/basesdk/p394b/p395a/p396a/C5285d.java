package com.qiyukf.basesdk.p394b.p395a.p396a;

import com.qiyukf.basesdk.p412c.p416c.C5405c;

/* renamed from: com.qiyukf.basesdk.b.a.a.d */
public final class C5285d {
    /* renamed from: a */
    private String f17111a;
    /* renamed from: b */
    private String f17112b;
    /* renamed from: c */
    private String f17113c;
    /* renamed from: d */
    private long f17114d;
    /* renamed from: e */
    private boolean f17115e;
    /* renamed from: f */
    private C5286e f17116f;

    public C5285d(String str, String str2, C5286e eVar) {
        this(str, str2, eVar, 0);
    }

    private C5285d(String str, String str2, C5286e eVar, byte b) {
        this.f17115e = false;
        this.f17111a = str;
        this.f17112b = str2;
        this.f17116f = eVar;
        this.f17114d = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append("@url#");
        sb.append(C5405c.m22113a(str));
        this.f17113c = sb.toString();
    }

    /* renamed from: a */
    public final String mo27136a() {
        return this.f17111a;
    }

    /* renamed from: b */
    public final String mo27137b() {
        return this.f17112b;
    }

    /* renamed from: c */
    public final String mo27138c() {
        return this.f17113c;
    }

    /* renamed from: d */
    public final long mo27139d() {
        return this.f17114d;
    }

    /* renamed from: e */
    public final void mo27140e() {
        this.f17115e = true;
        C5286e eVar = this.f17116f;
        if (eVar != null) {
            eVar.mo27147c();
        }
    }

    /* renamed from: f */
    public final boolean mo27141f() {
        return this.f17115e;
    }

    /* renamed from: g */
    public final C5286e mo27142g() {
        return this.f17116f;
    }
}
