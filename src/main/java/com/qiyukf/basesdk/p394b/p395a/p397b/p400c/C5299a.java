package com.qiyukf.basesdk.p394b.p395a.p397b.p400c;

import android.util.Base64;

/* renamed from: com.qiyukf.basesdk.b.a.b.c.a */
public final class C5299a {
    /* renamed from: a */
    private Object f17162a;
    /* renamed from: b */
    private String f17163b;
    /* renamed from: c */
    private int f17164c;
    /* renamed from: d */
    private String f17165d;
    /* renamed from: e */
    private Exception f17166e;
    /* renamed from: f */
    private String f17167f;
    /* renamed from: g */
    private String f17168g;

    public C5299a(Object obj, String str, int i, String str2, String str3, String str4, Exception exc) {
        this.f17162a = obj;
        this.f17163b = str;
        this.f17164c = i;
        this.f17167f = str2;
        this.f17168g = new String(Base64.decode(str3, 0));
        this.f17165d = str4;
        this.f17166e = exc;
    }

    /* renamed from: a */
    public final int mo27173a() {
        return this.f17164c;
    }

    /* renamed from: b */
    public final Exception mo27174b() {
        return this.f17166e;
    }
}
