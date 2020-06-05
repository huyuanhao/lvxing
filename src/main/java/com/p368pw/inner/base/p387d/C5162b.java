package com.p368pw.inner.base.p387d;

import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.security.KeyStore;
import java.security.KeyStore.SecretKeyEntry;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.pw.inner.base.d.b */
public class C5162b {
    /* renamed from: a */
    private static String f16841a = "AES";
    /* renamed from: b */
    private static String f16842b = "AES/CBC/PKCS5Padding";
    /* renamed from: c */
    private String f16843c;
    /* renamed from: d */
    private Cipher f16844d;
    /* renamed from: e */
    private Cipher f16845e;

    /* renamed from: com.pw.inner.base.d.b$a */
    private static class C5164a {
        /* access modifiers changed from: private|static */
        /* renamed from: a */
        public static C5162b f16846a = new C5162b(C5162b.m21312d(), C5162b.m21313e());
    }

    private C5162b(String str, String str2) {
        this.f16843c = "utf-8";
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(this.f16843c), f16841a);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(str2.getBytes(this.f16843c));
            this.f16844d = Cipher.getInstance(f16842b);
            this.f16845e = Cipher.getInstance(f16842b);
            this.f16844d.init(1, secretKeySpec, ivParameterSpec);
            this.f16845e.init(2, secretKeySpec, ivParameterSpec);
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: a */
    public static C5162b m21305a() {
        return C5164a.f16846a;
    }

    /* renamed from: a */
    private byte[] m21306a(byte[] bArr) {
        try {
            return this.f16844d.doFinal(bArr);
        } catch (Exception e) {
            C5205o.m21464a((Throwable) e);
            return null;
        }
    }

    /* renamed from: b */
    private byte[] m21308b(byte[] bArr) {
        try {
            return this.f16845e.doFinal(bArr);
        } catch (Exception e) {
            C5205o.m21464a((Throwable) e);
            return null;
        }
    }

    /* renamed from: c */
    private String m21310c(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString);
        }
        return sb.toString().toUpperCase();
    }

    /* renamed from: c */
    private byte[] m21311c(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length % 2 == 1) {
            return null;
        }
        int i = length / 2;
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 != i; i2++) {
            int i3 = i2 * 2;
            bArr[i2] = (byte) Integer.parseInt(str.substring(i3, i3 + 2), 16);
        }
        return bArr;
    }

    /* access modifiers changed from: private|static */
    /* renamed from: d */
    public static String m21312d() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        try {
            byte[] bArr = new byte[20];
            new SecureRandom().nextBytes(bArr);
            sb.append(new String(bArr));
            sb.delete(0, sb.length());
            for (int i = 0; i < 1; i++) {
                sb.append("cda2");
                sb.append("ga36j");
                sb.append("57t");
                sb.append("4vn2");
            }
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
        try {
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            instance.load(null);
            instance.setEntry(sb.toString(), new SecretKeyEntry(SecretKeyFactory.getInstance("AES").generateSecret(null)), null);
        } catch (Throwable unused) {
            C5205o.m21462a("todo AES初始化异常");
        }
        return sb.toString();
    }

    /* access modifiers changed from: private|static */
    /* renamed from: e */
    public static String m21313e() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        try {
            sb.append(new String(new SecureRandom().generateSeed(20)));
            sb.delete(0, sb.length());
            for (int i = 0; i < 1; i++) {
                sb.append("b3a");
                sb.append("1cm21");
                sb.append("ty6s");
                sb.append("3vo6");
            }
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
        try {
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            instance.load(null);
            instance.setEntry(sb.toString(), new SecretKeyEntry(SecretKeyFactory.getInstance("AES").generateSecret(null)), null);
        } catch (Throwable unused) {
            C5205o.m21462a("todo AES初始化异常");
        }
        return sb.toString();
    }

    /* renamed from: a */
    public String mo26769a(String str) {
        try {
            return m21310c(m21306a(str.getBytes(this.f16843c)));
        } catch (Throwable th) {
            C5205o.m21464a(th);
            return "";
        }
    }

    /* renamed from: a */
    public String mo26770a(String str, boolean z) {
        return z ? mo26769a(str) : str;
    }

    /* renamed from: b */
    public String mo26771b(String str) {
        try {
            return new String(m21308b(m21311c(str)), this.f16843c);
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: b */
    public String mo26772b(String str, boolean z) {
        return z ? mo26771b(str) : str;
    }
}
