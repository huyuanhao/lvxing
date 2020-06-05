package com.kwad.sdk.p306a;

import com.kwad.sdk.core.p319c.C4065b;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.security.MessageDigest;

/* renamed from: com.kwad.sdk.a.h */
public class C3805h {
    /* renamed from: a */
    static final char[] f12923a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX WARNING: type inference failed for: r3v1, types: [int] */
    /* JADX WARNING: type inference failed for: r3v4 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    public static java.lang.String m15773a(java.lang.String r5) {
        /*
        java.lang.String r0 = "MD5"
        java.security.MessageDigest r0 = java.security.MessageDigest.getInstance(r0)     // Catch:{ Exception -> 0x0038 }
        byte[] r5 = r5.getBytes()     // Catch:{ Exception -> 0x0038 }
        r0.update(r5)     // Catch:{ Exception -> 0x0038 }
        byte[] r5 = r0.digest()     // Catch:{ Exception -> 0x0038 }
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0038 }
        r0.<init>()     // Catch:{ Exception -> 0x0038 }
        int r1 = r5.length     // Catch:{ Exception -> 0x0038 }
        r2 = 0
    L_0x0018:
        if (r2 >= r1) goto L_0x0033
        byte r3 = r5[r2]     // Catch:{ Exception -> 0x0038 }
        if (r3 >= 0) goto L_0x0020
        int r3 = r3 + 256
    L_0x0020:
        r4 = 16
        if (r3 >= r4) goto L_0x0029
        java.lang.String r4 = "0"
        r0.append(r4)     // Catch:{ Exception -> 0x0038 }
    L_0x0029:
        java.lang.String r3 = java.lang.Integer.toHexString(r3)     // Catch:{ Exception -> 0x0038 }
        r0.append(r3)     // Catch:{ Exception -> 0x0038 }
        int r2 = r2 + 1
        goto L_0x0018
    L_0x0033:
        java.lang.String r5 = r0.toString()     // Catch:{ Exception -> 0x0038 }
        return r5
    L_0x0038:
        java.lang.String r5 = ""
        return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.p306a.C3805h.m15773a(java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    public static String m15774a(byte[] bArr, int i, int i2) {
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
                char[] cArr2 = f12923a;
                cArr[i4] = cArr2[b >> 4];
                i4 = i6 + 1;
                cArr[i6] = cArr2[b & 15];
            }
            return new String(cArr, 0, i3);
        }
    }

    /* renamed from: b */
    public static String m15775b(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            return m15774a(digest, 0, digest.length);
        } catch (Exception e) {
            C4065b.m16865a(e);
            return "";
        }
    }
}
