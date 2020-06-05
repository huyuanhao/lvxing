package com.alipay.sdk.p122c;

import com.alipay.sdk.util.C1542e;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.alipay.sdk.c.b */
public class C1514b {
    /* renamed from: a */
    public static String m4512a(String str, String str2) {
        return m4511a(1, str, str2);
    }

    /* renamed from: b */
    public static String m4513b(String str, String str2) {
        return m4511a(2, str, str2);
    }

    /* renamed from: a */
    public static String m4511a(int i, String str, String str2) {
        byte[] bArr;
        String str3;
        String str4 = "DES";
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), str4);
            Cipher instance = Cipher.getInstance(str4);
            instance.init(i, secretKeySpec);
            if (i == 2) {
                bArr = C1513a.m4508a(str);
            } else {
                bArr = str.getBytes("UTF-8");
            }
            byte[] doFinal = instance.doFinal(bArr);
            if (i == 2) {
                str3 = new String(doFinal);
            } else {
                str3 = C1513a.m4506a(doFinal);
            }
            return str3;
        } catch (Exception e) {
            C1542e.m4633a(e);
            return null;
        }
    }
}
