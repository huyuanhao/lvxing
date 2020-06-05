package com.bytedance.sdk.p145a.p146a;

/* renamed from: com.bytedance.sdk.a.a.o */
final class Segment {
    /* renamed from: a */
    final byte[] f5275a;
    /* renamed from: b */
    int f5276b;
    /* renamed from: c */
    int f5277c;
    /* renamed from: d */
    boolean f5278d;
    /* renamed from: e */
    boolean f5279e;
    /* renamed from: f */
    Segment f5280f;
    /* renamed from: g */
    Segment f5281g;

    Segment() {
        this.f5275a = new byte[8192];
        this.f5279e = true;
        this.f5278d = false;
    }

    Segment(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.f5275a = bArr;
        this.f5276b = i;
        this.f5277c = i2;
        this.f5278d = z;
        this.f5279e = z2;
    }

    /* access modifiers changed from: final */
    /* renamed from: a */
    public final Segment mo13633a() {
        this.f5278d = true;
        Segment oVar = new Segment(this.f5275a, this.f5276b, this.f5277c, true, false);
        return oVar;
    }

    /* renamed from: b */
    public final Segment mo13637b() {
        Segment oVar = this.f5280f;
        if (oVar == this) {
            oVar = null;
        }
        Segment oVar2 = this.f5281g;
        oVar2.f5280f = this.f5280f;
        this.f5280f.f5281g = oVar2;
        this.f5280f = null;
        this.f5281g = null;
        return oVar;
    }

    /* renamed from: a */
    public final Segment mo13635a(Segment oVar) {
        oVar.f5281g = this;
        oVar.f5280f = this.f5280f;
        this.f5280f.f5281g = oVar;
        this.f5280f = oVar;
        return oVar;
    }

    /* renamed from: a */
    public final Segment mo13634a(int i) {
        Segment oVar;
        if (i <= 0 || i > this.f5277c - this.f5276b) {
            throw new IllegalArgumentException();
        }
        if (i >= 1024) {
            oVar = mo13633a();
        } else {
            oVar = SegmentPool.m6800a();
            System.arraycopy(this.f5275a, this.f5276b, oVar.f5275a, 0, i);
        }
        oVar.f5277c = oVar.f5276b + i;
        this.f5276b += i;
        this.f5281g.mo13635a(oVar);
        return oVar;
    }

    /* renamed from: c */
    public final void mo13638c() {
        Segment oVar = this.f5281g;
        if (oVar == this) {
            throw new IllegalStateException();
        } else if (oVar.f5279e) {
            int i = this.f5277c - this.f5276b;
            if (i <= (8192 - oVar.f5277c) + (oVar.f5278d ? 0 : oVar.f5276b)) {
                mo13636a(this.f5281g, i);
                mo13637b();
                SegmentPool.m6801a(this);
            }
        }
    }

    /* renamed from: a */
    public final void mo13636a(Segment oVar, int i) {
        if (oVar.f5279e) {
            int i2 = oVar.f5277c;
            if (i2 + i > 8192) {
                if (!oVar.f5278d) {
                    int i3 = i2 + i;
                    int i4 = oVar.f5276b;
                    if (i3 - i4 <= 8192) {
                        byte[] bArr = oVar.f5275a;
                        System.arraycopy(bArr, i4, bArr, 0, i2 - i4);
                        oVar.f5277c -= oVar.f5276b;
                        oVar.f5276b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.f5275a, this.f5276b, oVar.f5275a, oVar.f5277c, i);
            oVar.f5277c += i;
            this.f5276b += i;
            return;
        }
        throw new IllegalArgumentException();
    }
}
