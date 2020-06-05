package com.p368pw.inner.base.p387d.p391d;

import java.util.Random;

/* renamed from: com.pw.inner.base.d.d.b */
public class C5183b {
    /* renamed from: a */
    public float f16876a;
    /* renamed from: b */
    public float f16877b;
    /* renamed from: c */
    public float f16878c;
    /* renamed from: d */
    public float f16879d;
    /* renamed from: e */
    public float f16880e;
    /* renamed from: f */
    public float f16881f;
    /* renamed from: g */
    public float f16882g;
    /* renamed from: h */
    public float f16883h;

    public C5183b() {
    }

    public C5183b(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        this.f16876a = f;
        this.f16877b = f2;
        this.f16878c = f3;
        this.f16879d = f4;
        this.f16880e = f5;
        this.f16881f = f6;
        this.f16882g = f7;
        this.f16883h = f8;
    }

    /* renamed from: a */
    public static C5183b m21360a() {
        return new C5183b();
    }

    /* renamed from: a */
    public static C5183b m21361a(float f, float f2, float f3, float f4) {
        float nextInt = ((float) new Random().nextInt((int) (f3 - f))) + f;
        float nextInt2 = ((float) new Random().nextInt((int) (f4 - f2))) + f2;
        return m21362a(nextInt, nextInt2, nextInt, nextInt2, nextInt, nextInt2, nextInt, nextInt2);
    }

    /* renamed from: a */
    public static C5183b m21362a(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        C5183b bVar = new C5183b(f, f2, f3, f4, f5, f6, f7, f8);
        return bVar;
    }
}
