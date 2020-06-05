package com.tencent.android.tpush.service.channel.security;

import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.service.channel.security.d */
public class C7043d {
    /* renamed from: a */
    private static RSAPublicKey f23420a;

    /* renamed from: a */
    public static void m30108a(String str) {
        try {
            f23420a = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(C7038a.m30101a(str, 0)));
        } catch (NoSuchAlgorithmException unused) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException unused2) {
            throw new Exception("公钥非法");
        } catch (NullPointerException unused3) {
            throw new Exception("公钥数据为空");
        }
    }

    /* renamed from: a */
    public static String m30107a(byte[] bArr) {
        byte[][] a;
        if (f23420a == null) {
            m30108a("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDyMrH3s73WgYu7MnBDurisRILqXwj1enRsuO7lPZCrPIxRd1RpTrv0xoWzKSyl2gwhY+l6/csBqs/Ako70II7wFWP3ugyKroHaWgvPw9M090xowDqBhQjcEfWKMd8A/cimVAlO/1p7kQDH0eTvZvOsv7sLmfTsMe8PkT2t22gZWQIDAQAB");
        }
        try {
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(2, f23420a);
            String str = "";
            for (byte[] bArr2 : m30109a(bArr, f23420a.getModulus().bitLength() / 8)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(new String(instance.doFinal(bArr2), "UTF-8"));
                str = sb.toString();
            }
            return str;
        } catch (NoSuchAlgorithmException unused) {
            throw new Exception("无此解密算法");
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
            return null;
        } catch (InvalidKeyException unused2) {
            throw new Exception("解密私钥非法,请检查");
        } catch (IllegalBlockSizeException unused3) {
            throw new Exception("密文长度非法");
        } catch (BadPaddingException unused4) {
            throw new Exception("密文数据已损坏");
        }
    }

    /* renamed from: b */
    public static byte[] m30110b(String str) {
        if (str == null || str.length() < 2) {
            return new byte[0];
        }
        String lowerCase = str.toLowerCase();
        int length = lowerCase.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (Integer.parseInt(lowerCase.substring(i2, i2 + 2), 16) & 255);
        }
        return bArr;
    }

    /* renamed from: a */
    public static byte[][] m30109a(byte[] bArr, int i) {
        int length = bArr.length % i;
        int length2 = (bArr.length / i) + (length != 0 ? 1 : 0);
        byte[][] bArr2 = new byte[length2][];
        for (int i2 = 0; i2 < length2; i2++) {
            byte[] bArr3 = new byte[i];
            if (i2 != length2 - 1 || length == 0) {
                System.arraycopy(bArr, i2 * i, bArr3, 0, i);
            } else {
                System.arraycopy(bArr, i2 * i, bArr3, 0, length);
            }
            bArr2[i2] = bArr3;
        }
        return bArr2;
    }
}
