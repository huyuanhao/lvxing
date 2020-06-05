package com.p570ta.utdid2.p572b.p573a;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.ta.utdid2.b.a.a */
public class AESUtils {
    /* renamed from: a */
    public static byte[] f22485a = {48, 48, 49, 55, 68, 67, 49, 66, 69, 50, 50, 53, 56, 53, 53, 52, 67, 70, 48, 50, 67, 53, 55, 66, 55, 56, 69, 55, 52, 48, 65, 53};

    /* renamed from: d */
    public static String m29021d(String str, String str2) {
        byte[] bArr;
        try {
            bArr = m29019a(m29015a(str.getBytes()), str2.getBytes());
        } catch (Exception unused) {
            bArr = null;
        }
        if (bArr != null) {
            return m29015a(bArr);
        }
        return null;
    }

    /* renamed from: e */
    public static String m29022e(String str, String str2) {
        try {
            return new String(m29020b(m29015a(str.getBytes()), m29017a(str2)));
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    private static byte[] m29018a(byte[] bArr) throws Exception {
        return m29017a(new String(f22485a, 0, 32));
    }

    /* renamed from: a */
    private static byte[] m29019a(byte[] bArr, byte[] bArr2) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(1, secretKeySpec, new IvParameterSpec(new byte[instance.getBlockSize()]));
        return instance.doFinal(bArr2);
    }

    /* renamed from: b */
    private static byte[] m29020b(byte[] bArr, byte[] bArr2) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(2, secretKeySpec, new IvParameterSpec(new byte[instance.getBlockSize()]));
        return instance.doFinal(bArr2);
    }

    /* renamed from: a */
    public static byte[] m29017a(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = Integer.valueOf(str.substring(i2, i2 + 2), 16).byteValue();
        }
        return bArr;
    }

    /* renamed from: a */
    public static String m29015a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte a : bArr) {
            m29016a(stringBuffer, a);
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    private static void m29016a(StringBuffer stringBuffer, byte b) {
        String str = "0123456789ABCDEF";
        stringBuffer.append(str.charAt((b >> 4) & 15));
        stringBuffer.append(str.charAt(b & 15));
    }
}
