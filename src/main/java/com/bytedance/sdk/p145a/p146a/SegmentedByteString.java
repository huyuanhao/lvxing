package com.bytedance.sdk.p145a.p146a;

import java.util.Arrays;

/* renamed from: com.bytedance.sdk.a.a.q */
final class SegmentedByteString extends ByteString {
    /* renamed from: f */
    final transient byte[][] f5284f;
    /* renamed from: g */
    final transient int[] f5285g;

    SegmentedByteString(Buffer cVar, int i) {
        super(null);
        C1868u.m6834a(cVar.f5243b, 0, (long) i);
        int i2 = 0;
        Segment oVar = cVar.f5242a;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            if (oVar.f5277c != oVar.f5276b) {
                i3 += oVar.f5277c - oVar.f5276b;
                i4++;
                oVar = oVar.f5280f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        this.f5284f = new byte[i4][];
        this.f5285g = new int[(i4 * 2)];
        Segment oVar2 = cVar.f5242a;
        int i5 = 0;
        while (i2 < i) {
            this.f5284f[i5] = oVar2.f5275a;
            i2 += oVar2.f5277c - oVar2.f5276b;
            if (i2 > i) {
                i2 = i;
            }
            int[] iArr = this.f5285g;
            iArr[i5] = i2;
            iArr[this.f5284f.length + i5] = oVar2.f5276b;
            oVar2.f5278d = true;
            i5++;
            oVar2 = oVar2.f5280f;
        }
    }

    /* renamed from: a */
    public String mo13587a() {
        return m6803i().mo13587a();
    }

    /* renamed from: b */
    public String mo13593b() {
        return m6803i().mo13593b();
    }

    /* renamed from: e */
    public String mo13597e() {
        return m6803i().mo13597e();
    }

    /* renamed from: f */
    public ByteString mo13599f() {
        return m6803i().mo13599f();
    }

    /* renamed from: c */
    public ByteString mo13594c() {
        return m6803i().mo13594c();
    }

    /* renamed from: d */
    public ByteString mo13596d() {
        return m6803i().mo13596d();
    }

    /* renamed from: a */
    public ByteString mo13586a(int i, int i2) {
        return m6803i().mo13586a(i, i2);
    }

    /* renamed from: a */
    public byte mo13585a(int i) {
        int i2;
        C1868u.m6834a((long) this.f5285g[this.f5284f.length - 1], (long) i, 1);
        int b = m6802b(i);
        if (b == 0) {
            i2 = 0;
        } else {
            i2 = this.f5285g[b - 1];
        }
        int[] iArr = this.f5285g;
        byte[][] bArr = this.f5284f;
        return bArr[b][(i - i2) + iArr[bArr.length + b]];
    }

    /* renamed from: b */
    private int m6802b(int i) {
        int binarySearch = Arrays.binarySearch(this.f5285g, 0, this.f5284f.length, i + 1);
        return binarySearch >= 0 ? binarySearch : ~binarySearch;
    }

    /* renamed from: g */
    public int mo13600g() {
        return this.f5285g[this.f5284f.length - 1];
    }

    /* renamed from: h */
    public byte[] mo13601h() {
        int[] iArr = this.f5285g;
        byte[][] bArr = this.f5284f;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.f5285g;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            System.arraycopy(this.f5284f[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo13588a(Buffer cVar) {
        int length = this.f5284f.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.f5285g;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            Segment oVar = new Segment(this.f5284f[i], i3, (i3 + i4) - i2, true, false);
            if (cVar.f5242a == null) {
                oVar.f5281g = oVar;
                oVar.f5280f = oVar;
                cVar.f5242a = oVar;
            } else {
                cVar.f5242a.f5281g.mo13635a(oVar);
            }
            i++;
            i2 = i4;
        }
        cVar.f5243b += (long) i2;
    }

    /* renamed from: a */
    public boolean mo13589a(int i, ByteString fVar, int i2, int i3) {
        int i4;
        if (i < 0 || i > mo13600g() - i3) {
            return false;
        }
        int b = m6802b(i);
        while (i3 > 0) {
            if (b == 0) {
                i4 = 0;
            } else {
                i4 = this.f5285g[b - 1];
            }
            int min = Math.min(i3, ((this.f5285g[b] - i4) + i4) - i);
            int[] iArr = this.f5285g;
            byte[][] bArr = this.f5284f;
            if (!fVar.mo13590a(i2, bArr[b], (i - i4) + iArr[bArr.length + b], min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            b++;
        }
        return true;
    }

    /* renamed from: a */
    public boolean mo13590a(int i, byte[] bArr, int i2, int i3) {
        int i4;
        if (i < 0 || i > mo13600g() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int b = m6802b(i);
        while (i3 > 0) {
            if (b == 0) {
                i4 = 0;
            } else {
                i4 = this.f5285g[b - 1];
            }
            int min = Math.min(i3, ((this.f5285g[b] - i4) + i4) - i);
            int[] iArr = this.f5285g;
            byte[][] bArr2 = this.f5284f;
            if (!C1868u.m6836a(bArr2[b], (i - i4) + iArr[bArr2.length + b], bArr, i2, min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            b++;
        }
        return true;
    }

    /* renamed from: i */
    private ByteString m6803i() {
        return new ByteString(mo13601h());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001d, code lost:
            if (mo13589a(0, r5, 0, mo13600g()) != false) goto L_0x0021;
     */
    public boolean equals(java.lang.Object r5) {
        /*
        r4 = this;
        r0 = 1
        if (r5 != r4) goto L_0x0004
        return r0
    L_0x0004:
        boolean r1 = r5 instanceof com.bytedance.sdk.p145a.p146a.ByteString
        r2 = 0
        if (r1 == 0) goto L_0x0020
        com.bytedance.sdk.a.a.f r5 = (com.bytedance.sdk.p145a.p146a.ByteString) r5
        int r1 = r5.mo13600g()
        int r3 = r4.mo13600g()
        if (r1 != r3) goto L_0x0020
        int r1 = r4.mo13600g()
        boolean r5 = r4.mo13589a(r2, r5, r2, r1)
        if (r5 == 0) goto L_0x0020
        goto L_0x0021
    L_0x0020:
        r0 = 0
    L_0x0021:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.p145a.p146a.SegmentedByteString.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i = this.f5248d;
        if (i != 0) {
            return i;
        }
        int length = this.f5284f.length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            byte[] bArr = this.f5284f[i2];
            int[] iArr = this.f5285g;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            int i7 = (i6 - i4) + i5;
            while (i5 < i7) {
                i3 = (i3 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i4 = i6;
        }
        this.f5248d = i3;
        return i3;
    }

    public String toString() {
        return m6803i().toString();
    }
}
