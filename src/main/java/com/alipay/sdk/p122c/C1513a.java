package com.alipay.sdk.p122c;

import com.tencent.bugly.beta.tinker.TinkerReport;
import com.tencent.p605ep.commonbase.utils.ScreenUtil;

/* renamed from: com.alipay.sdk.c.a */
public final class C1513a {
    /* renamed from: a */
    private static final byte[] f3885a = new byte[128];
    /* renamed from: b */
    private static final char[] f3886b = new char[64];

    /* renamed from: a */
    private static boolean m4507a(char c) {
        return c == ' ' || c == 13 || c == 10 || c == 9;
    }

    /* renamed from: b */
    private static boolean m4509b(char c) {
        return c == '=';
    }

    static {
        int i;
        int i2;
        int i3 = 0;
        for (int i4 = 0; i4 < 128; i4++) {
            f3885a[i4] = -1;
        }
        for (int i5 = 90; i5 >= 65; i5--) {
            f3885a[i5] = (byte) (i5 - 65);
        }
        int i6 = 122;
        while (true) {
            i = 26;
            if (i6 < 97) {
                break;
            }
            f3885a[i6] = (byte) ((i6 - 97) + 26);
            i6--;
        }
        int i7 = 57;
        while (true) {
            i2 = 52;
            if (i7 < 48) {
                break;
            }
            f3885a[i7] = (byte) ((i7 - 48) + 52);
            i7--;
        }
        byte[] bArr = f3885a;
        bArr[43] = 62;
        bArr[47] = 63;
        for (int i8 = 0; i8 <= 25; i8++) {
            f3886b[i8] = (char) (i8 + 65);
        }
        int i9 = 0;
        while (i <= 51) {
            f3886b[i] = (char) (i9 + 97);
            i++;
            i9++;
        }
        while (i2 <= 61) {
            f3886b[i2] = (char) (i3 + 48);
            i2++;
            i3++;
        }
        char[] cArr = f3886b;
        cArr[62] = '+';
        cArr[63] = '/';
    }

    /* renamed from: c */
    private static boolean m4510c(char c) {
        return c < 128 && f3885a[c] != -1;
    }

    /* renamed from: a */
    public static String m4506a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length * 8;
        if (length == 0) {
            return "";
        }
        int i = length % 24;
        int i2 = length / 24;
        char[] cArr = new char[((i != 0 ? i2 + 1 : i2) * 4)];
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < i2) {
            int i6 = i4 + 1;
            byte b = bArr[i4];
            int i7 = i6 + 1;
            byte b2 = bArr[i6];
            int i8 = i7 + 1;
            byte b3 = bArr[i7];
            byte b4 = (byte) (b2 & 15);
            byte b5 = (byte) (b & 3);
            byte b6 = b & Byte.MIN_VALUE;
            int i9 = b >> 2;
            if (b6 != 0) {
                i9 ^= 192;
            }
            byte b7 = (byte) i9;
            byte b8 = b2 & Byte.MIN_VALUE;
            int i10 = b2 >> 4;
            if (b8 != 0) {
                i10 ^= ScreenUtil.G8_WIDTH;
            }
            byte b9 = (byte) i10;
            byte b10 = (byte) ((b3 & Byte.MIN_VALUE) == 0 ? b3 >> 6 : (b3 >> 6) ^ TinkerReport.KEY_LOADED_EXCEPTION_DEX);
            int i11 = i5 + 1;
            char[] cArr2 = f3886b;
            cArr[i5] = cArr2[b7];
            int i12 = i11 + 1;
            cArr[i11] = cArr2[(b5 << 4) | b9];
            int i13 = i12 + 1;
            cArr[i12] = cArr2[(b4 << 2) | b10];
            int i14 = i13 + 1;
            cArr[i13] = cArr2[b3 & 63];
            i3++;
            i5 = i14;
            i4 = i8;
        }
        if (i == 8) {
            byte b11 = bArr[i4];
            byte b12 = (byte) (b11 & 3);
            byte b13 = b11 & Byte.MIN_VALUE;
            int i15 = b11 >> 2;
            if (b13 != 0) {
                i15 ^= 192;
            }
            byte b14 = (byte) i15;
            int i16 = i5 + 1;
            char[] cArr3 = f3886b;
            cArr[i5] = cArr3[b14];
            int i17 = i16 + 1;
            cArr[i16] = cArr3[b12 << 4];
            int i18 = i17 + 1;
            cArr[i17] = '=';
            cArr[i18] = '=';
        } else if (i == 16) {
            byte b15 = bArr[i4];
            byte b16 = bArr[i4 + 1];
            byte b17 = (byte) (b16 & 15);
            byte b18 = (byte) (b15 & 3);
            byte b19 = b15 & Byte.MIN_VALUE;
            int i19 = b15 >> 2;
            if (b19 != 0) {
                i19 ^= 192;
            }
            byte b20 = (byte) i19;
            byte b21 = b16 & Byte.MIN_VALUE;
            int i20 = b16 >> 4;
            if (b21 != 0) {
                i20 ^= ScreenUtil.G8_WIDTH;
            }
            byte b22 = (byte) i20;
            int i21 = i5 + 1;
            char[] cArr4 = f3886b;
            cArr[i5] = cArr4[b20];
            int i22 = i21 + 1;
            cArr[i21] = cArr4[b22 | (b18 << 4)];
            int i23 = i22 + 1;
            cArr[i22] = cArr4[b17 << 2];
            cArr[i23] = '=';
        }
        return new String(cArr);
    }

    /* renamed from: a */
    public static byte[] m4508a(String str) {
        byte[] bArr = null;
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        int a = m4505a(charArray);
        if (a % 4 != 0) {
            return null;
        }
        int i = a / 4;
        if (i == 0) {
            return new byte[0];
        }
        byte[] bArr2 = new byte[(i * 3)];
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < i - 1) {
            int i5 = i3 + 1;
            char c = charArray[i3];
            if (m4510c(c)) {
                int i6 = i5 + 1;
                char c2 = charArray[i5];
                if (m4510c(c2)) {
                    int i7 = i6 + 1;
                    char c3 = charArray[i6];
                    if (m4510c(c3)) {
                        int i8 = i7 + 1;
                        char c4 = charArray[i7];
                        if (m4510c(c4)) {
                            byte[] bArr3 = f3885a;
                            byte b = bArr3[c];
                            byte b2 = bArr3[c2];
                            byte b3 = bArr3[c3];
                            byte b4 = bArr3[c4];
                            int i9 = i4 + 1;
                            bArr2[i4] = (byte) ((b << 2) | (b2 >> 4));
                            int i10 = i9 + 1;
                            bArr2[i9] = (byte) (((b2 & 15) << 4) | ((b3 >> 2) & 15));
                            i4 = i10 + 1;
                            bArr2[i10] = (byte) ((b3 << 6) | b4);
                            i2++;
                            i3 = i8;
                        }
                    }
                }
            }
            return null;
        }
        int i11 = i3 + 1;
        char c5 = charArray[i3];
        if (m4510c(c5)) {
            int i12 = i11 + 1;
            char c6 = charArray[i11];
            if (m4510c(c6)) {
                byte[] bArr4 = f3885a;
                byte b5 = bArr4[c5];
                byte b6 = bArr4[c6];
                int i13 = i12 + 1;
                char c7 = charArray[i12];
                char c8 = charArray[i13];
                if (m4510c(c7) && m4510c(c8)) {
                    byte[] bArr5 = f3885a;
                    byte b7 = bArr5[c7];
                    byte b8 = bArr5[c8];
                    int i14 = i4 + 1;
                    bArr2[i4] = (byte) ((b5 << 2) | (b6 >> 4));
                    int i15 = i14 + 1;
                    bArr2[i14] = (byte) (((b6 & 15) << 4) | ((b7 >> 2) & 15));
                    bArr2[i15] = (byte) (b8 | (b7 << 6));
                    return bArr2;
                } else if (!m4509b(c7) || !m4509b(c8)) {
                    if (!m4509b(c7) && m4509b(c8)) {
                        byte b9 = f3885a[c7];
                        if ((b9 & 3) != 0) {
                            return null;
                        }
                        int i16 = i2 * 3;
                        bArr = new byte[(i16 + 2)];
                        System.arraycopy(bArr2, 0, bArr, 0, i16);
                        int i17 = i4 + 1;
                        bArr[i4] = (byte) ((b5 << 2) | (b6 >> 4));
                        bArr[i17] = (byte) (((b9 >> 2) & 15) | ((b6 & 15) << 4));
                    }
                } else if ((b6 & 15) != 0) {
                    return null;
                } else {
                    int i18 = i2 * 3;
                    byte[] bArr6 = new byte[(i18 + 1)];
                    System.arraycopy(bArr2, 0, bArr6, 0, i18);
                    bArr6[i4] = (byte) ((b5 << 2) | (b6 >> 4));
                    return bArr6;
                }
            }
        }
        return bArr;
    }

    /* renamed from: a */
    private static int m4505a(char[] cArr) {
        if (cArr == null) {
            return 0;
        }
        int length = cArr.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (!m4507a(cArr[i2])) {
                int i3 = i + 1;
                cArr[i] = cArr[i2];
                i = i3;
            }
        }
        return i;
    }
}
