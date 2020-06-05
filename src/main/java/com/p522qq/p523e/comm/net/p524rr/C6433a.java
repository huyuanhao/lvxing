package com.p522qq.p523e.comm.net.p524rr;

import android.util.Base64;
import com.p522qq.p523e.comm.C6411a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.qq.e.comm.net.rr.a */
public final class C6433a {
    /* renamed from: a */
    private static final byte[] f20291a = {91, -62};
    /* renamed from: b */
    private static Cipher f20292b = null;
    /* renamed from: c */
    private static Cipher f20293c = null;
    /* renamed from: d */
    private static String f20294d = String.format("AES/%s/PKCS7Padding", new Object[]{"ECB"});
    /* renamed from: e */
    private static byte[] f20295e = Base64.decode("4M3PpUC4Vu1uMp+Y0Mxd+vfc6v4ggJAINfgTlH74pis=", 0);

    /* renamed from: com.qq.e.comm.net.rr.a$a */
    static class C6434a extends Exception {
        public C6434a(String str, Throwable th) {
            super(str, th);
        }
    }

    /* renamed from: com.qq.e.comm.net.rr.a$b */
    public static class C6435b extends Exception {
        public C6435b(String str, Throwable th) {
            super(str, th);
        }
    }

    /* renamed from: a */
    private static synchronized Cipher m25245a() throws C6434a {
        synchronized (C6433a.class) {
            if (f20292b != null) {
                Cipher cipher = f20292b;
                return cipher;
            }
            try {
                Cipher instance = Cipher.getInstance(f20294d);
                instance.init(1, new SecretKeySpec(f20295e, "AES"));
                f20292b = instance;
                Cipher cipher2 = f20292b;
                return cipher2;
            } catch (Exception e) {
                throw new C6434a("Fail To Init Cipher", e);
            }
        }
    }

    /* renamed from: a */
    public static byte[] m25246a(byte[] bArr) throws C6435b {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.write(f20291a);
            dataOutputStream.writeByte(1);
            dataOutputStream.writeByte(2);
            dataOutputStream.write(m25249c(C6411a.m25178a(bArr)));
            dataOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            throw new C6435b("Exception while packaging byte array", e);
        }
    }

    /* renamed from: b */
    private static synchronized Cipher m25247b() throws C6434a {
        synchronized (C6433a.class) {
            if (f20293c != null) {
                Cipher cipher = f20293c;
                return cipher;
            }
            try {
                Cipher instance = Cipher.getInstance(f20294d);
                instance.init(2, new SecretKeySpec(f20295e, "AES"));
                f20293c = instance;
                Cipher cipher2 = f20293c;
                return cipher2;
            } catch (Exception e) {
                throw new C6434a("Fail To Init Cipher", e);
            }
        }
    }

    /* renamed from: b */
    public static byte[] m25248b(byte[] bArr) throws C6435b {
        if (bArr == null || bArr.length < 4) {
            throw new C6435b("S2SS Package FormatError", null);
        }
        try {
            DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
            byte[] bArr2 = new byte[4];
            dataInputStream.read(bArr2);
            if (f20291a[0] == bArr2[0] && f20291a[1] == bArr2[1] && 1 == bArr2[2] && 2 == bArr2[3]) {
                return C6411a.m25181b(m25250d(Arrays.copyOfRange(bArr, 4, bArr.length)));
            }
            throw new C6435b("S2SS Package Magic/Version FormatError", null);
        } catch (Exception e) {
            throw new C6435b("Exception while packaging byte array", e);
        }
    }

    /* renamed from: c */
    private static byte[] m25249c(byte[] bArr) throws C6434a {
        try {
            return m25245a().doFinal(bArr);
        } catch (Exception e) {
            throw new C6434a("Exception While encrypt byte array", e);
        }
    }

    /* renamed from: d */
    private static byte[] m25250d(byte[] bArr) throws C6434a {
        try {
            return m25247b().doFinal(bArr);
        } catch (Exception e) {
            throw new C6434a("Exception While dencrypt byte array", e);
        }
    }
}
