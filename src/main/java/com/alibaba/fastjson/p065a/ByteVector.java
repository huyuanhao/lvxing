package com.alibaba.fastjson.p065a;

/* renamed from: com.alibaba.fastjson.a.a */
public class ByteVector {
    /* renamed from: a */
    byte[] f2524a;
    /* renamed from: b */
    int f2525b;

    public ByteVector() {
        this.f2524a = new byte[64];
    }

    public ByteVector(int i) {
        this.f2524a = new byte[i];
    }

    /* renamed from: a */
    public ByteVector mo11004a(int i) {
        int i2 = this.f2525b;
        int i3 = i2 + 1;
        if (i3 > this.f2524a.length) {
            m2446d(1);
        }
        this.f2524a[i2] = (byte) i;
        this.f2525b = i3;
        return this;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public ByteVector mo11005a(int i, int i2) {
        int i3 = this.f2525b;
        if (i3 + 2 > this.f2524a.length) {
            m2446d(2);
        }
        byte[] bArr = this.f2524a;
        int i4 = i3 + 1;
        bArr[i3] = (byte) i;
        int i5 = i4 + 1;
        bArr[i4] = (byte) i2;
        this.f2525b = i5;
        return this;
    }

    /* renamed from: b */
    public ByteVector mo11008b(int i) {
        int i2 = this.f2525b;
        if (i2 + 2 > this.f2524a.length) {
            m2446d(2);
        }
        byte[] bArr = this.f2524a;
        int i3 = i2 + 1;
        bArr[i2] = (byte) (i >>> 8);
        int i4 = i3 + 1;
        bArr[i3] = (byte) i;
        this.f2525b = i4;
        return this;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public ByteVector mo11009b(int i, int i2) {
        int i3 = this.f2525b;
        if (i3 + 3 > this.f2524a.length) {
            m2446d(3);
        }
        byte[] bArr = this.f2524a;
        int i4 = i3 + 1;
        bArr[i3] = (byte) i;
        int i5 = i4 + 1;
        bArr[i4] = (byte) (i2 >>> 8);
        int i6 = i5 + 1;
        bArr[i5] = (byte) i2;
        this.f2525b = i6;
        return this;
    }

    /* renamed from: c */
    public ByteVector mo11010c(int i) {
        int i2 = this.f2525b;
        if (i2 + 4 > this.f2524a.length) {
            m2446d(4);
        }
        byte[] bArr = this.f2524a;
        int i3 = i2 + 1;
        bArr[i2] = (byte) (i >>> 24);
        int i4 = i3 + 1;
        bArr[i3] = (byte) (i >>> 16);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (i >>> 8);
        int i6 = i5 + 1;
        bArr[i5] = (byte) i;
        this.f2525b = i6;
        return this;
    }

    /* renamed from: a */
    public ByteVector mo11006a(String str) {
        int length = str.length();
        int i = this.f2525b;
        if (i + 2 + length > this.f2524a.length) {
            m2446d(length + 2);
        }
        byte[] bArr = this.f2524a;
        int i2 = i + 1;
        bArr[i] = (byte) (length >>> 8);
        int i3 = i2 + 1;
        bArr[i2] = (byte) length;
        int i4 = 0;
        while (i4 < length) {
            char charAt = str.charAt(i4);
            if (charAt < 1 || charAt > 127) {
                throw new UnsupportedOperationException();
            }
            int i5 = i3 + 1;
            bArr[i3] = (byte) charAt;
            i4++;
            i3 = i5;
        }
        this.f2525b = i3;
        return this;
    }

    /* renamed from: a */
    public ByteVector mo11007a(byte[] bArr, int i, int i2) {
        if (this.f2525b + i2 > this.f2524a.length) {
            m2446d(i2);
        }
        if (bArr != null) {
            System.arraycopy(bArr, i, this.f2524a, this.f2525b, i2);
        }
        this.f2525b += i2;
        return this;
    }

    /* renamed from: d */
    private void m2446d(int i) {
        int length = this.f2524a.length * 2;
        int i2 = i + this.f2525b;
        if (length > i2) {
            i2 = length;
        }
        byte[] bArr = new byte[i2];
        System.arraycopy(this.f2524a, 0, bArr, 0, this.f2525b);
        this.f2524a = bArr;
    }
}
