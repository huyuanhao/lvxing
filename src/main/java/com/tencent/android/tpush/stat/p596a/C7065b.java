package com.tencent.android.tpush.stat.p596a;

import android.util.Base64;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.stat.a.b */
public class C7065b {
    /* renamed from: a */
    static byte[] m30245a() {
        return Base64.decode("MDNhOTc2NTExZTJjYmUzYTdmMjY4MDhmYjdhZjNjMDU=", 0);
    }

    /* renamed from: a */
    public static byte[] m30246a(byte[] bArr) {
        return m30247a(bArr, m30245a());
    }

    /* renamed from: b */
    public static byte[] m30248b(byte[] bArr) {
        return m30249b(bArr, m30245a());
    }

    /* JADX WARNING: type inference failed for: r9v0, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r7v2, types: [byte] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=null, for r7v2, types: [byte] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte[], code=null, for r9v0, types: [byte[]] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* renamed from: a */
    static byte[] m30247a(byte[] r8, ? r9) {
        /*
        r0 = 256(0x100, float:3.59E-43)
        int[] r1 = new int[r0]
        int[] r2 = new int[r0]
        int r3 = r9.length
        r4 = 1
        if (r3 < r4) goto L_0x005d
        if (r3 > r0) goto L_0x005d
        r5 = 0
        r6 = 0
    L_0x000e:
        if (r6 >= r0) goto L_0x001b
        r1[r6] = r6
        int r7 = r6 % r3
        byte r7 = r9[r7]
        r2[r6] = r7
        int r6 = r6 + 1
        goto L_0x000e
    L_0x001b:
        r9 = 0
        r3 = 0
    L_0x001d:
        if (r9 >= r0) goto L_0x0032
        r6 = r1[r9]
        int r3 = r3 + r6
        r6 = r2[r9]
        int r3 = r3 + r6
        r3 = r3 & 255(0xff, float:3.57E-43)
        r6 = r1[r9]
        r7 = r1[r3]
        r1[r9] = r7
        r1[r3] = r6
        int r9 = r9 + 1
        goto L_0x001d
    L_0x0032:
        int r9 = r8.length
        byte[] r9 = new byte[r9]
        r0 = 0
        r2 = 0
    L_0x0037:
        int r3 = r8.length
        if (r5 >= r3) goto L_0x005c
        int r0 = r0 + r4
        r0 = r0 & 255(0xff, float:3.57E-43)
        r3 = r1[r0]
        int r2 = r2 + r3
        r2 = r2 & 255(0xff, float:3.57E-43)
        r3 = r1[r0]
        r6 = r1[r2]
        r1[r0] = r6
        r1[r2] = r3
        r3 = r1[r0]
        r6 = r1[r2]
        int r3 = r3 + r6
        r3 = r3 & 255(0xff, float:3.57E-43)
        r3 = r1[r3]
        byte r6 = r8[r5]
        r3 = r3 ^ r6
        byte r3 = (byte) r3
        r9[r5] = r3
        int r5 = r5 + 1
        goto L_0x0037
    L_0x005c:
        return r9
    L_0x005d:
        java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
        java.lang.String r9 = "key must be between 1 and 256 bytes"
        r8.<init>(r9)
        throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.stat.p596a.C7065b.m30247a(byte[], byte[]):byte[]");
    }

    /* renamed from: b */
    static byte[] m30249b(byte[] bArr, byte[] bArr2) {
        return m30247a(bArr, bArr2);
    }
}
