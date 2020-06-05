package com.qiyukf.basesdk.p412c.p416c;

/* renamed from: com.qiyukf.basesdk.c.c.a */
public final class C5401a {
    /* renamed from: a */
    private static final char[] f17371a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    /* renamed from: b */
    private static final int[] f17372b = {60, 56, 52, 48, 44, 40, 36, 32, 28, 24, 20, 16, 12, 8, 4, 0};

    /* renamed from: a */
    private static int m22107a(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        char c2 = 'a';
        if (c < 'a' || c > 'f') {
            c2 = 'A';
            if (c < 'A' || c > 'F') {
                return -1;
            }
        }
        return (c - c2) + 10;
    }

    /* renamed from: a */
    private static String m22108a(byte b) {
        long j = (long) b;
        StringBuilder sb = new StringBuilder(2);
        for (int i = 0; i < 2; i++) {
            sb.append(f17371a[(int) ((j >> f17372b[i + 14]) & 15)]);
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static String m22109a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte a : bArr) {
            sb.append(m22108a(a));
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static byte[] m22110a(String str) {
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = i * 2;
            int a = m22107a(str.charAt(i2));
            int a2 = m22107a(str.charAt(i2 + 1));
            if (a == -1 || a2 == -1) {
                return null;
            }
            bArr[i] = (byte) ((a << 4) + a2);
        }
        return bArr;
    }
}
