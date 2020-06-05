package com.alipay.p109b.p110a.p111a.p112a.p113a;

import com.alipay.p109b.p110a.p111a.p112a.C1460a;
import java.security.MessageDigest;

/* renamed from: com.alipay.b.a.a.a.a.b */
public final class C1462b {
    /* renamed from: a */
    public static String m4270a(String str) {
        try {
            if (C1460a.m4260a(str)) {
                return null;
            }
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.update(str.getBytes("UTF-8"));
            byte[] digest = instance.digest();
            StringBuilder sb = new StringBuilder();
            for (byte valueOf : digest) {
                sb.append(String.format("%02x", new Object[]{Byte.valueOf(valueOf)}));
            }
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }
}
