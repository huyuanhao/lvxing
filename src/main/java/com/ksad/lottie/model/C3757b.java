package com.ksad.lottie.model;

/* renamed from: com.ksad.lottie.model.b */
public class C3757b {
    /* renamed from: a */
    public final String f12724a;
    /* renamed from: b */
    public final String f12725b;
    /* renamed from: c */
    public final double f12726c;
    /* renamed from: d */
    final int f12727d;
    /* renamed from: e */
    public final int f12728e;
    /* renamed from: f */
    final double f12729f;
    /* renamed from: g */
    public final double f12730g;
    /* renamed from: h */
    public final int f12731h;
    /* renamed from: i */
    public final int f12732i;
    /* renamed from: j */
    public final double f12733j;
    /* renamed from: k */
    public final boolean f12734k;

    public C3757b(String str, String str2, double d, int i, int i2, double d2, double d3, int i3, int i4, double d4, boolean z) {
        this.f12724a = str;
        this.f12725b = str2;
        this.f12726c = d;
        this.f12727d = i;
        this.f12728e = i2;
        this.f12729f = d2;
        this.f12730g = d3;
        this.f12731h = i3;
        this.f12732i = i4;
        this.f12733j = d4;
        this.f12734k = z;
    }

    public int hashCode() {
        int hashCode = (((((int) (((double) (((this.f12724a.hashCode() * 31) + this.f12725b.hashCode()) * 31)) + this.f12726c)) * 31) + this.f12727d) * 31) + this.f12728e;
        long doubleToLongBits = Double.doubleToLongBits(this.f12729f);
        return (((hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + this.f12731h;
    }
}
