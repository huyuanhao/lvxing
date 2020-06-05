package com.qiyukf.nimlib.p473h.p481c.p482a;

import com.tencent.bigdata.dataacquisition.DeviceInfos;

/* renamed from: com.qiyukf.nimlib.h.c.a.a */
public final class C5889a {
    /* renamed from: a */
    private byte[] f18647a = new byte[256];
    /* renamed from: b */
    private int f18648b;
    /* renamed from: c */
    private int f18649c;

    public C5889a(byte[] bArr) {
        for (int i = 0; i < 256; i++) {
            this.f18647a[i] = (byte) i;
        }
        this.f18648b = 0;
        this.f18649c = 0;
        if (bArr == null || bArr.length == 0) {
            throw new NullPointerException();
        }
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < 256; i4++) {
            byte b = bArr[i2] & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
            byte[] bArr2 = this.f18647a;
            i3 = (b + (bArr2[i4] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) + i3) & 255;
            byte b2 = bArr2[i4];
            bArr2[i4] = bArr2[i3];
            bArr2[i3] = b2;
            i2 = (i2 + 1) % bArr.length;
        }
    }

    /* renamed from: a */
    public final void mo28238a(byte[] bArr, int i, int i2) {
        if (bArr != null && i >= 0 && i2 >= 0) {
            int i3 = i2 + i;
            if (i3 <= bArr.length) {
                while (i < i3) {
                    byte b = bArr[i];
                    this.f18648b = (this.f18648b + 1) & 255;
                    byte[] bArr2 = this.f18647a;
                    int i4 = this.f18648b;
                    this.f18649c = ((bArr2[i4] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) + this.f18649c) & 255;
                    byte b2 = bArr2[i4];
                    int i5 = this.f18649c;
                    bArr2[i4] = bArr2[i5];
                    bArr2[i5] = b2;
                    bArr[i] = (byte) (b ^ bArr2[((bArr2[i4] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) + (bArr2[i5] & DeviceInfos.NETWORK_TYPE_UNCONNECTED)) & 255]);
                    i++;
                }
                return;
            }
        }
        throw new IllegalArgumentException("illegal rc4 transform arguments");
    }
}
