package com.qiyukf.basesdk.p394b.p406b.p407a;

import com.qiyukf.basesdk.p394b.p406b.p409c.C5349c;
import com.qiyukf.basesdk.p394b.p406b.p409c.C5350d;
import com.qiyukf.basesdk.p394b.p406b.p409c.C5354g;

/* renamed from: com.qiyukf.basesdk.b.b.a.d */
public abstract class C5327d {
    /* renamed from: a */
    protected C5330g f17239a;
    /* renamed from: b */
    volatile C5327d f17240b;
    /* renamed from: c */
    volatile C5327d f17241c;
    /* renamed from: d */
    private boolean f17242d;
    /* renamed from: e */
    private boolean f17243e;

    public C5327d(C5330g gVar, boolean z, boolean z2) {
        this.f17239a = gVar;
        this.f17242d = z;
        this.f17243e = z2;
    }

    /* renamed from: a */
    public final C5327d mo27245a() {
        return this.f17241c;
    }

    /* renamed from: b */
    public final C5327d mo27246b() {
        for (C5327d dVar = this.f17241c; dVar != null; dVar = dVar.f17241c) {
            if (dVar.f17242d) {
                return dVar;
            }
        }
        return null;
    }

    /* renamed from: c */
    public final C5327d mo27247c() {
        for (C5327d dVar = this.f17240b; dVar != null; dVar = dVar.f17240b) {
            if (dVar.f17243e) {
                return dVar;
            }
        }
        return null;
    }

    /* renamed from: d */
    public final C5350d mo27248d() {
        C5327d b = mo27246b();
        if (b == null) {
            return null;
        }
        return (C5350d) b.mo27251g();
    }

    /* renamed from: e */
    public final C5354g mo27249e() {
        C5327d c = mo27247c();
        if (c == null) {
            return null;
        }
        return (C5354g) c.mo27251g();
    }

    /* renamed from: f */
    public final C5321a mo27250f() {
        return this.f17239a.mo27254a();
    }

    /* renamed from: g */
    public abstract C5349c mo27251g();
}
