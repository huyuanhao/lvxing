package com.tencent.mta.track.util;

import com.tencent.bigdata.dataacquisition.DeviceInfos;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.util.a */
public class C7462a {
    /* renamed from: a */
    private static char[] f25022a = new char[64];
    /* renamed from: b */
    private static byte[] f25023b = new byte[128];

    static {
        char c = 'A';
        int i = 0;
        while (c <= 'Z') {
            int i2 = i + 1;
            f25022a[i] = c;
            c = (char) (c + 1);
            i = i2;
        }
        char c2 = 'a';
        while (c2 <= 'z') {
            int i3 = i + 1;
            f25022a[i] = c2;
            c2 = (char) (c2 + 1);
            i = i3;
        }
        char c3 = '0';
        while (c3 <= '9') {
            int i4 = i + 1;
            f25022a[i] = c3;
            c3 = (char) (c3 + 1);
            i = i4;
        }
        char[] cArr = f25022a;
        int i5 = i + 1;
        cArr[i] = '+';
        cArr[i5] = '/';
        int i6 = 0;
        while (true) {
            byte[] bArr = f25023b;
            if (i6 >= bArr.length) {
                break;
            }
            bArr[i6] = -1;
            i6++;
        }
        for (int i7 = 0; i7 < 64; i7++) {
            f25023b[f25022a[i7]] = (byte) i7;
        }
    }

    /* renamed from: a */
    public static char[] m32329a(byte[] bArr) {
        return m32330a(bArr, bArr.length);
    }

    /* renamed from: a */
    public static char[] m32330a(byte[] bArr, int i) {
        int i2;
        byte b;
        int i3;
        byte b2;
        int i4 = ((i * 4) + 2) / 3;
        char[] cArr = new char[(((i + 2) / 3) * 4)];
        int i5 = 0;
        int i6 = 0;
        while (i5 < i) {
            int i7 = i5 + 1;
            byte b3 = bArr[i5] & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
            if (i7 < i) {
                i2 = i7 + 1;
                b = bArr[i7] & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
            } else {
                i2 = i7;
                b = 0;
            }
            if (i2 < i) {
                i3 = i2 + 1;
                b2 = bArr[i2] & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
            } else {
                i3 = i2;
                b2 = 0;
            }
            int i8 = b3 >>> 2;
            int i9 = ((b3 & 3) << 4) | (b >>> 4);
            int i10 = ((b & 15) << 2) | (b2 >>> 6);
            byte b4 = b2 & 63;
            int i11 = i6 + 1;
            char[] cArr2 = f25022a;
            cArr[i6] = cArr2[i8];
            int i12 = i11 + 1;
            cArr[i11] = cArr2[i9];
            char c = '=';
            cArr[i12] = i12 < i4 ? cArr2[i10] : '=';
            int i13 = i12 + 1;
            if (i13 < i4) {
                c = f25022a[b4];
            }
            cArr[i13] = c;
            i6 = i13 + 1;
            i5 = i3;
        }
        return cArr;
    }
}
