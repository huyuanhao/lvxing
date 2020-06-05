package com.alipay.sdk.p122c;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.alipay.sdk.c.e */
public class C1517e {
    /* renamed from: a */
    private static String f3887a = "DESede/CBC/PKCS5Padding";

    /* renamed from: a */
    public static byte[] m4519a(String str, byte[] bArr) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "DESede");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(new byte[8]);
            Cipher instance = Cipher.getInstance(f3887a);
            instance.init(1, secretKeySpec, ivParameterSpec);
            return instance.doFinal(bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: b */
    public static byte[] m4521b(String str, byte[] bArr) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "DESede");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(new byte[8]);
            Cipher instance = Cipher.getInstance(f3887a);
            instance.init(2, secretKeySpec, ivParameterSpec);
            return instance.doFinal(bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static String m4518a(String str, String str2) {
        try {
            return C1513a.m4506a(m4519a(str, str2.getBytes()));
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: b */
    public static String m4520b(String str, String str2) {
        try {
            return new String(m4521b(str, C1513a.m4508a(str2)));
        } catch (Exception unused) {
            return null;
        }
    }
}
