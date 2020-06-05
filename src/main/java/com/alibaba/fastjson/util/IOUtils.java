package com.alibaba.fastjson.util;

import com.alibaba.fastjson.JSONException;
import com.p522qq.taf.jce.JceStruct;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import com.tencent.p605ep.commonbase.utils.ScreenUtil;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.MalformedInputException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.Properties;

/* renamed from: com.alibaba.fastjson.util.d */
public class IOUtils {
    /* renamed from: a */
    public static final Properties f3013a = new Properties();
    /* renamed from: b */
    public static final Charset f3014b = Charset.forName("UTF-8");
    /* renamed from: c */
    public static final char[] f3015c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    /* renamed from: d */
    public static final boolean[] f3016d = new boolean[256];
    /* renamed from: e */
    public static final boolean[] f3017e = new boolean[256];
    /* renamed from: f */
    public static final byte[] f3018f = new byte[161];
    /* renamed from: g */
    public static final byte[] f3019g = new byte[161];
    /* renamed from: h */
    public static final boolean[] f3020h = new boolean[161];
    /* renamed from: i */
    public static final boolean[] f3021i = new boolean[161];
    /* renamed from: j */
    public static final char[] f3022j = new char[93];
    /* renamed from: k */
    public static final char[] f3023k = {'0', '0', '0', '1', '0', '2', '0', '3', '0', '4', '0', '5', '0', '6', '0', '7', '0', '8', '0', '9', '0', 'A', '0', 'B', '0', 'C', '0', 'D', '0', 'E', '0', 'F', '1', '0', '1', '1', '1', '2', '1', '3', '1', '4', '1', '5', '1', '6', '1', '7', '1', '8', '1', '9', '1', 'A', '1', 'B', '1', 'C', '1', 'D', '1', 'E', '1', 'F', '2', '0', '2', '1', '2', '2', '2', '3', '2', '4', '2', '5', '2', '6', '2', '7', '2', '8', '2', '9', '2', 'A', '2', 'B', '2', 'C', '2', 'D', '2', 'E', '2', 'F'};
    /* renamed from: l */
    static final char[] f3024l = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    /* renamed from: m */
    static final char[] f3025m = {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9'};
    /* renamed from: n */
    static final char[] f3026n = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    /* renamed from: o */
    static final int[] f3027o = {9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED};
    /* renamed from: p */
    public static final char[] f3028p = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
    /* renamed from: q */
    public static final int[] f3029q = new int[256];

    /* renamed from: a */
    public static int m3187a(long j) {
        long j2 = 10;
        for (int i = 1; i < 19; i++) {
            if (j < j2) {
                return i;
            }
            j2 *= 10;
        }
        return 19;
    }

    static {
        char c = 0;
        while (true) {
            boolean[] zArr = f3016d;
            if (c >= zArr.length) {
                break;
            }
            if (c >= 'A' && c <= 'Z') {
                zArr[c] = true;
            } else if (c >= 'a' && c <= 'z') {
                f3016d[c] = true;
            } else if (c == '_' || c == '$') {
                f3016d[c] = true;
            }
            c = (char) (c + 1);
        }
        char c2 = 0;
        while (true) {
            boolean[] zArr2 = f3017e;
            if (c2 < zArr2.length) {
                if (c2 >= 'A' && c2 <= 'Z') {
                    zArr2[c2] = true;
                } else if (c2 >= 'a' && c2 <= 'z') {
                    f3017e[c2] = true;
                } else if (c2 == '_') {
                    f3017e[c2] = true;
                } else if (c2 >= '0' && c2 <= '9') {
                    f3017e[c2] = true;
                }
                c2 = (char) (c2 + 1);
            } else {
                try {
                    break;
                } catch (Throwable unused) {
                }
            }
        }
        m3191a();
        byte[] bArr = f3018f;
        bArr[0] = 4;
        bArr[1] = 4;
        bArr[2] = 4;
        bArr[3] = 4;
        bArr[4] = 4;
        bArr[5] = 4;
        bArr[6] = 4;
        bArr[7] = 4;
        bArr[8] = 1;
        bArr[9] = 1;
        bArr[10] = 1;
        bArr[11] = 4;
        bArr[12] = 1;
        bArr[13] = 1;
        bArr[34] = 1;
        bArr[92] = 1;
        byte[] bArr2 = f3019g;
        bArr2[0] = 4;
        bArr2[1] = 4;
        bArr2[2] = 4;
        bArr2[3] = 4;
        bArr2[4] = 4;
        bArr2[5] = 4;
        bArr2[6] = 4;
        bArr2[7] = 4;
        bArr2[8] = 1;
        bArr2[9] = 1;
        bArr2[10] = 1;
        bArr2[11] = 4;
        bArr2[12] = 1;
        bArr2[13] = 1;
        bArr2[92] = 1;
        bArr2[39] = 1;
        for (int i = 14; i <= 31; i++) {
            f3018f[i] = 4;
            f3019g[i] = 4;
        }
        for (int i2 = 127; i2 < 160; i2++) {
            f3018f[i2] = 4;
            f3019g[i2] = 4;
        }
        for (int i3 = 0; i3 < 161; i3++) {
            f3020h[i3] = f3018f[i3] != 0;
            f3021i[i3] = f3019g[i3] != 0;
        }
        char[] cArr = f3022j;
        cArr[0] = '0';
        cArr[1] = '1';
        cArr[2] = '2';
        cArr[3] = '3';
        cArr[4] = '4';
        cArr[5] = '5';
        cArr[6] = '6';
        cArr[7] = '7';
        cArr[8] = 'b';
        cArr[9] = 't';
        cArr[10] = 'n';
        cArr[11] = 'v';
        cArr[12] = 'f';
        cArr[13] = 'r';
        cArr[34] = '\"';
        cArr[39] = '\'';
        cArr[47] = '/';
        cArr[92] = '\\';
        Arrays.fill(f3029q, -1);
        int length = f3028p.length;
        for (int i4 = 0; i4 < length; i4++) {
            f3029q[f3028p[i4]] = i4;
        }
        f3029q[61] = 0;
    }

    /* renamed from: a */
    public static String m3190a(String str) {
        String str2;
        try {
            str2 = System.getProperty(str);
        } catch (SecurityException unused) {
            str2 = null;
        }
        return str2 == null ? f3013a.getProperty(str) : str2;
    }

    /* renamed from: a */
    public static void m3191a() {
        InputStream inputStream = (InputStream) AccessController.doPrivileged(new PrivilegedAction<InputStream>() {
            /* renamed from: a */
            public InputStream run() {
                ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
                String str = "fastjson.properties";
                if (contextClassLoader != null) {
                    return contextClassLoader.getResourceAsStream(str);
                }
                return ClassLoader.getSystemResourceAsStream(str);
            }
        });
        if (inputStream != null) {
            try {
                f3013a.load(inputStream);
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    /* renamed from: a */
    public static void m3194a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    public static void m3193a(long j, int i, char[] cArr) {
        char c;
        if (j < 0) {
            c = '-';
            j = -j;
        } else {
            c = 0;
        }
        while (j > 2147483647L) {
            long j2 = j / 100;
            int i2 = (int) (j - (((j2 << 6) + (j2 << 5)) + (j2 << 2)));
            int i3 = i - 1;
            cArr[i3] = f3026n[i2];
            i = i3 - 1;
            cArr[i] = f3025m[i2];
            j = j2;
        }
        int i4 = (int) j;
        while (i4 >= 65536) {
            int i5 = i4 / 100;
            int i6 = i4 - (((i5 << 6) + (i5 << 5)) + (i5 << 2));
            int i7 = i - 1;
            cArr[i7] = f3026n[i6];
            i = i7 - 1;
            cArr[i] = f3025m[i6];
            i4 = i5;
        }
        while (true) {
            int i8 = (52429 * i4) >>> 19;
            i--;
            cArr[i] = f3024l[i4 - ((i8 << 3) + (i8 << 1))];
            if (i8 == 0) {
                break;
            }
            i4 = i8;
        }
        if (c != 0) {
            cArr[i - 1] = c;
        }
    }

    /* renamed from: a */
    public static void m3192a(int i, int i2, char[] cArr) {
        char c;
        if (i < 0) {
            c = '-';
            i = -i;
        } else {
            c = 0;
        }
        while (i >= 65536) {
            int i3 = i / 100;
            int i4 = i - (((i3 << 6) + (i3 << 5)) + (i3 << 2));
            int i5 = i2 - 1;
            cArr[i5] = f3026n[i4];
            i2 = i5 - 1;
            cArr[i2] = f3025m[i4];
            i = i3;
        }
        while (true) {
            int i6 = (52429 * i) >>> 19;
            i2--;
            cArr[i2] = f3024l[i - ((i6 << 3) + (i6 << 1))];
            if (i6 == 0) {
                break;
            }
            i = i6;
        }
        if (c != 0) {
            cArr[i2 - 1] = c;
        }
    }

    /* renamed from: a */
    public static int m3186a(int i) {
        int i2 = 0;
        while (i > f3027o[i2]) {
            i2++;
        }
        return i2 + 1;
    }

    /* renamed from: a */
    public static void m3195a(CharsetDecoder charsetDecoder, ByteBuffer byteBuffer, CharBuffer charBuffer) {
        try {
            CoderResult decode = charsetDecoder.decode(byteBuffer, charBuffer, true);
            if (!decode.isUnderflow()) {
                decode.throwException();
            }
            CoderResult flush = charsetDecoder.flush(charBuffer);
            if (!flush.isUnderflow()) {
                flush.throwException();
            }
        } catch (CharacterCodingException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("utf8 decode error, ");
            sb.append(e.getMessage());
            throw new JSONException(sb.toString(), e);
        }
    }

    /* renamed from: a */
    public static boolean m3196a(char c) {
        boolean[] zArr = f3016d;
        return c < zArr.length && zArr[c];
    }

    /* renamed from: b */
    public static boolean m3199b(char c) {
        boolean[] zArr = f3017e;
        return c < zArr.length && zArr[c];
    }

    /* renamed from: a */
    public static byte[] m3198a(char[] cArr, int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 == 0) {
            return new byte[0];
        }
        int i5 = (i + i2) - 1;
        while (i < i5 && f3029q[cArr[i]] < 0) {
            i++;
        }
        while (i5 > 0 && f3029q[cArr[i5]] < 0) {
            i5--;
        }
        int i6 = cArr[i5] == '=' ? cArr[i5 + -1] == '=' ? 2 : 1 : 0;
        int i7 = (i5 - i) + 1;
        if (i2 > 76) {
            i3 = (cArr[76] == 13 ? i7 / 78 : 0) << 1;
        } else {
            i3 = 0;
        }
        int i8 = (((i7 - i3) * 6) >> 3) - i6;
        byte[] bArr = new byte[i8];
        int i9 = (i8 / 3) * 3;
        int i10 = i;
        int i11 = 0;
        int i12 = 0;
        while (i11 < i9) {
            int[] iArr = f3029q;
            int i13 = i10 + 1;
            int i14 = i13 + 1;
            int i15 = (iArr[cArr[i10]] << 18) | (iArr[cArr[i13]] << 12);
            int i16 = i14 + 1;
            int i17 = i15 | (iArr[cArr[i14]] << 6);
            int i18 = i16 + 1;
            int i19 = i17 | iArr[cArr[i16]];
            int i20 = i11 + 1;
            bArr[i11] = (byte) (i19 >> 16);
            int i21 = i20 + 1;
            bArr[i20] = (byte) (i19 >> 8);
            int i22 = i21 + 1;
            bArr[i21] = (byte) i19;
            if (i3 > 0) {
                i12++;
                if (i12 == 19) {
                    i10 = i18 + 2;
                    i12 = 0;
                    i11 = i22;
                }
            }
            i10 = i18;
            i11 = i22;
        }
        if (i11 < i8) {
            int i23 = 0;
            while (i10 <= i5 - i6) {
                i4 |= f3029q[cArr[i10]] << (18 - (i23 * 6));
                i23++;
                i10++;
            }
            int i24 = 16;
            while (i11 < i8) {
                int i25 = i11 + 1;
                bArr[i11] = (byte) (i4 >> i24);
                i24 -= 8;
                i11 = i25;
            }
        }
        return bArr;
    }

    /* renamed from: a */
    public static byte[] m3197a(String str, int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 == 0) {
            return new byte[0];
        }
        int i5 = (i + i2) - 1;
        while (i < i5 && f3029q[str.charAt(i)] < 0) {
            i++;
        }
        while (i5 > 0 && f3029q[str.charAt(i5)] < 0) {
            i5--;
        }
        int i6 = str.charAt(i5) == '=' ? str.charAt(i5 + -1) == '=' ? 2 : 1 : 0;
        int i7 = (i5 - i) + 1;
        if (i2 > 76) {
            i3 = (str.charAt(76) == 13 ? i7 / 78 : 0) << 1;
        } else {
            i3 = 0;
        }
        int i8 = (((i7 - i3) * 6) >> 3) - i6;
        byte[] bArr = new byte[i8];
        int i9 = (i8 / 3) * 3;
        int i10 = i;
        int i11 = 0;
        int i12 = 0;
        while (i11 < i9) {
            int i13 = i10 + 1;
            int i14 = i13 + 1;
            int i15 = i14 + 1;
            int i16 = i15 + 1;
            int i17 = (f3029q[str.charAt(i10)] << 18) | (f3029q[str.charAt(i13)] << 12) | (f3029q[str.charAt(i14)] << 6) | f3029q[str.charAt(i15)];
            int i18 = i11 + 1;
            bArr[i11] = (byte) (i17 >> 16);
            int i19 = i18 + 1;
            bArr[i18] = (byte) (i17 >> 8);
            int i20 = i19 + 1;
            bArr[i19] = (byte) i17;
            if (i3 > 0) {
                i12++;
                if (i12 == 19) {
                    i10 = i16 + 2;
                    i12 = 0;
                    i11 = i20;
                }
            }
            i10 = i16;
            i11 = i20;
        }
        if (i11 < i8) {
            int i21 = 0;
            while (i10 <= i5 - i6) {
                i4 |= f3029q[str.charAt(i10)] << (18 - (i21 * 6));
                i21++;
                i10++;
            }
            int i22 = 16;
            while (i11 < i8) {
                int i23 = i11 + 1;
                bArr[i11] = (byte) (i4 >> i22);
                i22 -= 8;
                i11 = i23;
            }
        }
        return bArr;
    }

    /* renamed from: b */
    public static byte[] m3200b(String str) {
        int i;
        int length = str.length();
        int i2 = 0;
        if (length == 0) {
            return new byte[0];
        }
        int i3 = length - 1;
        int i4 = 0;
        while (i4 < i3 && f3029q[str.charAt(i4) & 255] < 0) {
            i4++;
        }
        while (i3 > 0 && f3029q[str.charAt(i3) & 255] < 0) {
            i3--;
        }
        int i5 = str.charAt(i3) == '=' ? str.charAt(i3 + -1) == '=' ? 2 : 1 : 0;
        int i6 = (i3 - i4) + 1;
        if (length > 76) {
            i = (str.charAt(76) == 13 ? i6 / 78 : 0) << 1;
        } else {
            i = 0;
        }
        int i7 = (((i6 - i) * 6) >> 3) - i5;
        byte[] bArr = new byte[i7];
        int i8 = (i7 / 3) * 3;
        int i9 = i4;
        int i10 = 0;
        int i11 = 0;
        while (i10 < i8) {
            int i12 = i9 + 1;
            int i13 = i12 + 1;
            int i14 = i13 + 1;
            int i15 = i14 + 1;
            int i16 = (f3029q[str.charAt(i9)] << 18) | (f3029q[str.charAt(i12)] << 12) | (f3029q[str.charAt(i13)] << 6) | f3029q[str.charAt(i14)];
            int i17 = i10 + 1;
            bArr[i10] = (byte) (i16 >> 16);
            int i18 = i17 + 1;
            bArr[i17] = (byte) (i16 >> 8);
            int i19 = i18 + 1;
            bArr[i18] = (byte) i16;
            if (i > 0) {
                i11++;
                if (i11 == 19) {
                    i9 = i15 + 2;
                    i11 = 0;
                    i10 = i19;
                }
            }
            i9 = i15;
            i10 = i19;
        }
        if (i10 < i7) {
            int i20 = 0;
            while (i9 <= i3 - i5) {
                i2 |= f3029q[str.charAt(i9)] << (18 - (i20 * 6));
                i20++;
                i9++;
            }
            int i21 = 16;
            while (i10 < i7) {
                int i22 = i10 + 1;
                bArr[i10] = (byte) (i2 >> i21);
                i21 -= 8;
                i10 = i22;
            }
        }
        return bArr;
    }

    /* renamed from: a */
    public static int m3189a(char[] cArr, int i, int i2, byte[] bArr) {
        int i3;
        int i4;
        int i5;
        int i6 = i + i2;
        int i7 = 0;
        int min = Math.min(i2, bArr.length) + 0;
        while (i3 < min && cArr[r10] < 128(0x80)) {
            int i8 = i3 + 1;
            int i9 = r10 + 1;
            bArr[i3] = (byte) cArr[r10];
            i7 = i8;
            i = i9;
        }
        while (r10 < i6) {
            int i10 = r10 + 1;
            char c = cArr[r10];
            if (c < 128(0x80)) {
                i4 = i3 + 1;
                bArr[i3] = (byte) c;
            } else {
                if (c < 2048(0x800)) {
                    int i11 = i3 + 1;
                    bArr[i3] = (byte) ((c >> 6) | 192);
                    i3 = i11 + 1;
                    bArr[i11] = (byte) ((c & 63) | 128);
                } else if (c < 55296(0xd800) || c >= 57344(0xe000)) {
                    int i12 = i3 + 1;
                    bArr[i3] = (byte) ((c >> 12) | 224);
                    int i13 = i12 + 1;
                    bArr[i12] = (byte) ((63 & (c >> 6)) | 128);
                    i4 = i13 + 1;
                    bArr[i13] = (byte) ((c & 63) | 128);
                } else {
                    int i14 = i10 - 1;
                    String str = "encodeUTF8 error";
                    if (Character.isHighSurrogate(c)) {
                        if (i6 - i14 < 2) {
                            c = -1;
                        } else {
                            char c2 = cArr[i14 + 1];
                            if (Character.isLowSurrogate(c2)) {
                                c = Character.toCodePoint(c, c2);
                            } else {
                                throw new JSONException(str, new MalformedInputException(1));
                            }
                        }
                    } else if (Character.isLowSurrogate(c)) {
                        throw new JSONException(str, new MalformedInputException(1));
                    }
                    if (c < 0) {
                        i5 = i3 + 1;
                        bArr[i3] = 63;
                    } else {
                        int i15 = i3 + 1;
                        bArr[i3] = (byte) ((c >> 18) | ScreenUtil.G8_WIDTH);
                        int i16 = i15 + 1;
                        bArr[i15] = (byte) (((c >> 12) & 63) | 128);
                        int i17 = i16 + 1;
                        bArr[i16] = (byte) ((63 & (c >> 6)) | 128);
                        int i18 = i17 + 1;
                        bArr[i17] = (byte) ((c & 63) | 128);
                        i10++;
                        i5 = i18;
                    }
                    i3 = i5;
                }
                r10 = i10;
            }
            r10 = i10;
            i3 = i4;
        }
        return i3;
    }

    /* renamed from: a */
    public static int m3188a(byte[] bArr, int i, int i2, char[] cArr) {
        int i3;
        int i4;
        int i5 = i + i2;
        int min = Math.min(i2, cArr.length);
        int i6 = i;
        int i7 = 0;
        while (i3 < min && bArr[i4] >= 0) {
            int i8 = i3 + 1;
            int i9 = i4 + 1;
            cArr[i3] = (char) bArr[i4];
            i7 = i8;
            i6 = i9;
        }
        while (i4 < i5) {
            int i10 = i4 + 1;
            byte b = bArr[i4];
            if (b >= 0) {
                int i11 = i3 + 1;
                cArr[i3] = (char) b;
                i4 = i10;
                i3 = i11;
            } else if ((b >> 5) != -2 || (b & 30) == 0) {
                if ((b >> 4) == -2) {
                    int i12 = i10 + 1;
                    if (i12 < i5) {
                        byte b2 = bArr[i10];
                        int i13 = i12 + 1;
                        byte b3 = bArr[i12];
                        if (!(b == -32 && (b2 & -32) == Byte.MIN_VALUE) && (b2 & -64) == Byte.MIN_VALUE && (b3 & -64) == Byte.MIN_VALUE) {
                            char c = (char) (((b2 << 6) ^ (b << JceStruct.ZERO_TAG)) ^ (Byte.MIN_VALUE ^ b3));
                            boolean z = c >= 55296 && c < 57344;
                            if (z) {
                                return -1;
                            }
                            int i14 = i3 + 1;
                            cArr[i3] = c;
                            i3 = i14;
                            i4 = i13;
                        }
                    }
                    return -1;
                }
                if ((b >> 3) == -2 && i10 + 2 < i5) {
                    int i15 = i10 + 1;
                    byte b4 = bArr[i10];
                    int i16 = i15 + 1;
                    byte b5 = bArr[i15];
                    int i17 = i16 + 1;
                    byte b6 = bArr[i16];
                    byte b7 = (((b << 18) ^ (b4 << JceStruct.ZERO_TAG)) ^ (b5 << 6)) ^ (Byte.MIN_VALUE ^ b6);
                    if ((b4 & -64) == Byte.MIN_VALUE && (b5 & -64) == Byte.MIN_VALUE && (b6 & -64) == Byte.MIN_VALUE && Character.isSupplementaryCodePoint(b7)) {
                        int i18 = i3 + 1;
                        cArr[i3] = (char) ((b7 >>> 10) + 55232);
                        i3 = i18 + 1;
                        cArr[i18] = (char) ((b7 & DeviceInfos.NETWORK_TYPE_UNCONNECTED) + 0);
                        i4 = i17;
                    }
                }
                return -1;
            } else if (i10 >= i5) {
                return -1;
            } else {
                int i19 = i10 + 1;
                byte b8 = bArr[i10];
                if ((b8 & -64) != Byte.MIN_VALUE) {
                    return -1;
                }
                int i20 = i3 + 1;
                cArr[i3] = (char) ((b8 ^ (b << 6)) ^ Byte.MIN_VALUE);
                i4 = i19;
                i3 = i20;
            }
        }
        return i3;
    }
}
