package com.bytedance.embedapplog.util;

import android.text.TextUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.bytedance.embedapplog.util.f */
public class C1854f {
    /* renamed from: a */
    public static String m6572a(String str) {
        return m6573a(str, "SHA-256");
    }

    /* renamed from: a */
    public static String m6573a(String str, String str2) {
        byte[] bytes = str.getBytes();
        try {
            if (TextUtils.isEmpty(str2)) {
                str2 = "SHA-256";
            }
            MessageDigest instance = MessageDigest.getInstance(str2);
            instance.update(bytes);
            return m6574a(instance.digest());
        } catch (Exception | NoSuchAlgorithmException unused) {
            return null;
        }
    }

    /* renamed from: a */
    private static String m6574a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            for (byte valueOf : bArr) {
                sb.append(String.format("%02x", new Object[]{Byte.valueOf(valueOf)}));
            }
            return sb.toString();
        } catch (Throwable unused) {
            return null;
        }
    }
}
