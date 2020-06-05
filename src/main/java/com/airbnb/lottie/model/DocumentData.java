package com.airbnb.lottie.model;

/* renamed from: com.airbnb.lottie.model.b */
public class DocumentData {
    /* renamed from: a */
    public final String f1585a;
    /* renamed from: b */
    public final String f1586b;
    /* renamed from: c */
    public final double f1587c;
    /* renamed from: d */
    final int f1588d;
    /* renamed from: e */
    public final int f1589e;
    /* renamed from: f */
    final double f1590f;
    /* renamed from: g */
    public final double f1591g;
    /* renamed from: h */
    public final int f1592h;
    /* renamed from: i */
    public final int f1593i;
    /* renamed from: j */
    public final int f1594j;
    /* renamed from: k */
    public final boolean f1595k;

    public DocumentData(String str, String str2, double d, int i, int i2, double d2, double d3, int i3, int i4, int i5, boolean z) {
        this.f1585a = str;
        this.f1586b = str2;
        this.f1587c = d;
        this.f1588d = i;
        this.f1589e = i2;
        this.f1590f = d2;
        this.f1591g = d3;
        this.f1592h = i3;
        this.f1593i = i4;
        this.f1594j = i5;
        this.f1595k = z;
    }

    public int hashCode() {
        int hashCode = (((((int) (((double) (((this.f1585a.hashCode() * 31) + this.f1586b.hashCode()) * 31)) + this.f1587c)) * 31) + this.f1588d) * 31) + this.f1589e;
        long doubleToLongBits = Double.doubleToLongBits(this.f1590f);
        return (((hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + this.f1592h;
    }
}
