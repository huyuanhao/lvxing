package com.alibaba.fastjson.p065a;

/* renamed from: com.alibaba.fastjson.a.f */
public class Label {
    /* renamed from: a */
    int f2562a;
    /* renamed from: b */
    int f2563b;
    /* renamed from: c */
    private int f2564c;
    /* renamed from: d */
    private int[] f2565d;

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo11027a(MethodWriter iVar, ByteVector aVar, int i) {
        if ((this.f2562a & 2) == 0) {
            m2477a(i, aVar.f2525b);
            aVar.mo11008b(-1);
            return;
        }
        aVar.mo11008b(this.f2563b - i);
    }

    /* renamed from: a */
    private void m2477a(int i, int i2) {
        if (this.f2565d == null) {
            this.f2565d = new int[6];
        }
        int i3 = this.f2564c;
        int[] iArr = this.f2565d;
        if (i3 >= iArr.length) {
            int[] iArr2 = new int[(iArr.length + 6)];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.f2565d = iArr2;
        }
        int[] iArr3 = this.f2565d;
        int i4 = this.f2564c;
        this.f2564c = i4 + 1;
        iArr3[i4] = i;
        int i5 = this.f2564c;
        this.f2564c = i5 + 1;
        iArr3[i5] = i2;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo11026a(MethodWriter iVar, int i, byte[] bArr) {
        this.f2562a |= 2;
        this.f2563b = i;
        int i2 = 0;
        while (i2 < this.f2564c) {
            int[] iArr = this.f2565d;
            int i3 = i2 + 1;
            int i4 = iArr[i2];
            int i5 = i3 + 1;
            int i6 = iArr[i3];
            int i7 = i - i4;
            int i8 = i6 + 1;
            bArr[i6] = (byte) (i7 >>> 8);
            bArr[i8] = (byte) i7;
            i2 = i5;
        }
    }
}
