package com.bytedance.sdk.openadsdk.p190h.p197g;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.bytedance.sdk.openadsdk.h.g.b */
public class MD5 {
    /* renamed from: a */
    private static final MessageDigest f8909a = m11648a();
    /* renamed from: b */
    private static final char[] f8910b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private MD5() {
    }

    /* renamed from: a */
    private static MessageDigest m11648a() {
        try {
            return MessageDigest.getInstance("md5");
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static String m11646a(String str) {
        byte[] digest;
        MessageDigest messageDigest = f8909a;
        if (messageDigest == null) {
            return "";
        }
        byte[] bytes = str.getBytes(C2479d.f8916a);
        synchronized (MD5.class) {
            digest = messageDigest.digest(bytes);
        }
        return m11647a(digest);
    }

    /* renamed from: a */
    public static String m11647a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        char[] cArr = new char[(bArr.length << 1)];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = f8910b;
            cArr[i] = cArr2[(b & -16) >> 4];
            i = i2 + 1;
            cArr[i2] = cArr2[b & 15];
        }
        return new String(cArr);
    }
}
