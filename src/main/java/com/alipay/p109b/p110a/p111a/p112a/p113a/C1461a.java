package com.alipay.p109b.p110a.p111a.p112a.p113a;

import com.p522qq.taf.jce.JceStruct;

/* renamed from: com.alipay.b.a.a.a.a.a */
public final class C1461a {
    /* renamed from: a */
    private static char[] f3736a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    /* renamed from: b */
    private static byte[] f3737b = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, JceStruct.STRUCT_END, JceStruct.ZERO_TAG, JceStruct.SIMPLE_LIST, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0047 A[EDGE_INSN: B:34:0x0047->B:16:0x0047 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0047 A[EDGE_INSN: B:35:0x0047->B:16:0x0047 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0047 A[EDGE_INSN: B:37:0x0047->B:16:0x0047 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023 A[LOOP:2: B:8:0x0023->B:11:0x0030, LOOP_START, PHI: r5 
  PHI: (r5v1 int) = (r5v0 int), (r5v9 int) binds: {(r5v0 int)=B:7:0x0021, (r5v9 int)=B:11:0x0030} A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: a */
    public static byte[] m4269a(java.lang.String r9) {
        /*
        java.lang.StringBuffer r0 = new java.lang.StringBuffer
        r0.<init>()
        java.lang.String r1 = "US-ASCII"
        byte[] r9 = r9.getBytes(r1)
        int r1 = r9.length
        r2 = 0
    L_0x000d:
        java.lang.String r3 = "iso8859-1"
        if (r2 >= r1) goto L_0x0047
    L_0x0011:
        byte[] r4 = f3737b
        int r5 = r2 + 1
        byte r2 = r9[r2]
        byte r2 = r4[r2]
        r4 = -1
        if (r5 >= r1) goto L_0x0021
        if (r2 == r4) goto L_0x001f
        goto L_0x0021
    L_0x001f:
        r2 = r5
        goto L_0x0011
    L_0x0021:
        if (r2 == r4) goto L_0x0047
    L_0x0023:
        byte[] r6 = f3737b
        int r7 = r5 + 1
        byte r5 = r9[r5]
        byte r5 = r6[r5]
        if (r7 >= r1) goto L_0x0032
        if (r5 == r4) goto L_0x0030
        goto L_0x0032
    L_0x0030:
        r5 = r7
        goto L_0x0023
    L_0x0032:
        if (r5 == r4) goto L_0x0047
        int r2 = r2 << 2
        r6 = r5 & 48
        int r6 = r6 >>> 4
        r2 = r2 | r6
        char r2 = (char) r2
        r0.append(r2)
    L_0x003f:
        int r2 = r7 + 1
        byte r6 = r9[r7]
        r7 = 61
        if (r6 != r7) goto L_0x0050
    L_0x0047:
        java.lang.String r9 = r0.toString()
        byte[] r9 = r9.getBytes(r3)
        return r9
    L_0x0050:
        byte[] r8 = f3737b
        byte r6 = r8[r6]
        if (r2 >= r1) goto L_0x005b
        if (r6 == r4) goto L_0x0059
        goto L_0x005b
    L_0x0059:
        r7 = r2
        goto L_0x003f
    L_0x005b:
        if (r6 == r4) goto L_0x0047
        r5 = r5 & 15
        int r5 = r5 << 4
        r8 = r6 & 60
        int r8 = r8 >>> 2
        r5 = r5 | r8
        char r5 = (char) r5
        r0.append(r5)
    L_0x006a:
        int r5 = r2 + 1
        byte r2 = r9[r2]
        if (r2 != r7) goto L_0x0071
        goto L_0x0047
    L_0x0071:
        byte[] r8 = f3737b
        byte r2 = r8[r2]
        if (r5 >= r1) goto L_0x007c
        if (r2 == r4) goto L_0x007a
        goto L_0x007c
    L_0x007a:
        r2 = r5
        goto L_0x006a
    L_0x007c:
        if (r2 == r4) goto L_0x0047
        r3 = r6 & 3
        int r3 = r3 << 6
        r2 = r2 | r3
        char r2 = (char) r2
        r0.append(r2)
        r2 = r5
        goto L_0x000d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.p109b.p110a.p111a.p112a.p113a.C1461a.m4269a(java.lang.String):byte[]");
    }
}
