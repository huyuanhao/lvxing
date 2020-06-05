package iko.dmaz.lloq.p654a;

import com.p522qq.taf.jce.JceStruct;

/* renamed from: iko.dmaz.lloq.a.a */
public class C8059a {
    /* renamed from: a */
    private static final byte[] f27334a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    /* renamed from: b */
    private static final byte[] f27335b = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, JceStruct.STRUCT_END, JceStruct.ZERO_TAG, JceStruct.SIMPLE_LIST, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9};

    /* renamed from: a */
    public static String m34874a(byte[] bArr) {
        return m34876a(bArr, true);
    }

    /* renamed from: a */
    public static String m34875a(byte[] bArr, int i, int i2, boolean z) {
        int i3;
        int i4 = (i2 * 4) / 3;
        byte[] bArr2 = new byte[((i2 % 3 > 0 ? 4 : 0) + i4 + (z ? i4 / 76 : 0))];
        int i5 = i2 - 2;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i6 < i5) {
            m34877a(bArr, i6 + i, 3, bArr2, i3);
            i8 += 4;
            if (z && i8 == 76) {
                bArr2[i3 + 4] = 10;
                i3++;
                i8 = 0;
            }
            i6 += 3;
            i7 = i3 + 4;
        }
        if (i6 < i2) {
            m34877a(bArr, i + i6, i2 - i6, bArr2, i3);
            i3 += 4;
        }
        return new String(bArr2, 0, i3, "iso-8859-1");
    }

    /* renamed from: a */
    public static String m34876a(byte[] bArr, boolean z) {
        return m34875a(bArr, 0, bArr.length, z);
    }

    /* renamed from: a */
    private static byte[] m34877a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int i4 = 0;
        int i5 = (i2 > 0 ? (bArr[i] << 24) >>> 8 : 0) | (i2 > 1 ? (bArr[i + 1] << 24) >>> 16 : 0);
        if (i2 > 2) {
            i4 = (bArr[i + 2] << 24) >>> 24;
        }
        int i6 = i5 | i4;
        if (i2 == 1) {
            byte[] bArr3 = f27334a;
            bArr2[i3] = bArr3[i6 >>> 18];
            bArr2[i3 + 1] = bArr3[(i6 >>> 12) & 63];
            int i7 = i3 + 3;
            bArr2[i3 + 2] = 61;
            bArr2[i7] = 61;
            return bArr2;
        } else if (i2 == 2) {
            byte[] bArr4 = f27334a;
            bArr2[i3] = bArr4[i6 >>> 18];
            bArr2[i3 + 1] = bArr4[(i6 >>> 12) & 63];
            bArr2[i3 + 2] = bArr4[(i6 >>> 6) & 63];
            bArr2[i3 + 3] = 61;
            return bArr2;
        } else if (i2 != 3) {
            return bArr2;
        } else {
            byte[] bArr5 = f27334a;
            bArr2[i3] = bArr5[i6 >>> 18];
            bArr2[i3 + 1] = bArr5[(i6 >>> 12) & 63];
            bArr2[i3 + 2] = bArr5[(i6 >>> 6) & 63];
            bArr2[i3 + 3] = bArr5[i6 & 63];
            return bArr2;
        }
    }
}
