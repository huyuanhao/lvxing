package com.bytedance.sdk.openadsdk.utils;

import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.security.MessageDigest;

/* renamed from: com.bytedance.sdk.openadsdk.utils.j */
public class DigestUtils {
    /* renamed from: a */
    private static final char[] f9174a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: a */
    public static String m12170a(byte[] bArr) {
        if (bArr != null) {
            return m12171a(bArr, 0, bArr.length);
        }
        throw new NullPointerException("bytes is null");
    }

    /* renamed from: a */
    public static String m12171a(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        } else if (i < 0 || i + i2 > bArr.length) {
            throw new IndexOutOfBoundsException();
        } else {
            int i3 = i2 * 2;
            char[] cArr = new char[i3];
            int i4 = 0;
            for (int i5 = 0; i5 < i2; i5++) {
                byte b = bArr[i5 + i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
                int i6 = i4 + 1;
                char[] cArr2 = f9174a;
                cArr[i4] = cArr2[b >> 4];
                i4 = i6 + 1;
                cArr[i6] = cArr2[b & 15];
            }
            return new String(cArr, 0, i3);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0033 A[SYNTHETIC, Splitter:B:22:0x0033] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x003a A[SYNTHETIC, Splitter:B:29:0x003a] */
    /* renamed from: a */
    public static java.lang.String m12168a(java.io.File r5) {
        /*
        r0 = 0
        java.lang.String r1 = "MD5"
        java.security.MessageDigest r1 = java.security.MessageDigest.getInstance(r1)     // Catch:{ Exception -> 0x0037, all -> 0x002f }
        if (r1 != 0) goto L_0x000a
        return r0
    L_0x000a:
        java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0037, all -> 0x002f }
        r2.<init>(r5)     // Catch:{ Exception -> 0x0037, all -> 0x002f }
        r5 = 8192(0x2000, float:1.14794E-41)
        byte[] r5 = new byte[r5]     // Catch:{ Exception -> 0x002d, all -> 0x002b }
    L_0x0013:
        int r3 = r5.length     // Catch:{ Exception -> 0x002d, all -> 0x002b }
        r4 = 0
        int r3 = r2.read(r5, r4, r3)     // Catch:{ Exception -> 0x002d, all -> 0x002b }
        if (r3 <= 0) goto L_0x001f
        r1.update(r5, r4, r3)     // Catch:{ Exception -> 0x002d, all -> 0x002b }
        goto L_0x0013
    L_0x001f:
        byte[] r5 = r1.digest()     // Catch:{ Exception -> 0x002d, all -> 0x002b }
        java.lang.String r5 = m12170a(r5)     // Catch:{ Exception -> 0x002d, all -> 0x002b }
        r2.close()     // Catch:{ Exception -> 0x002a }
    L_0x002a:
        return r5
    L_0x002b:
        r5 = move-exception
        goto L_0x0031
        goto L_0x0038
    L_0x002f:
        r5 = move-exception
        r2 = r0
    L_0x0031:
        if (r2 == 0) goto L_0x0036
        r2.close()     // Catch:{ Exception -> 0x0036 }
    L_0x0036:
        throw r5
    L_0x0037:
        r2 = r0
    L_0x0038:
        if (r2 == 0) goto L_0x003d
        r2.close()     // Catch:{ Exception -> 0x003d }
    L_0x003d:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.utils.DigestUtils.m12168a(java.io.File):java.lang.String");
    }

    /* renamed from: a */
    public static String m12169a(String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    MessageDigest instance = MessageDigest.getInstance("MD5");
                    instance.update(str.getBytes("UTF-8"));
                    return m12170a(instance.digest());
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
