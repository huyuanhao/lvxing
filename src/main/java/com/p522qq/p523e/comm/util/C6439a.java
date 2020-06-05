package com.p522qq.p523e.comm.util;

import android.util.Base64;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* renamed from: com.qq.e.comm.util.a */
public class C6439a {
    /* renamed from: a */
    private PublicKey f20321a;
    /* renamed from: b */
    private final boolean f20322b;

    /* renamed from: com.qq.e.comm.util.a$a */
    static final class C6440a {
        /* renamed from: a */
        public static final C6439a f20323a = new C6439a(0);
    }

    private C6439a() {
        boolean z;
        try {
            this.f20321a = m25267b("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDKta2b5Vw5YkWHCAj4rJCwS227\r/35FZ29e4I6pS2B8zSq2RgBpXUuMg7oZF1Qt3x0iyg8PeyblyNeCRB6gIMehFThe\r1Y7m1FaQyaZp+CJYOTLM4/THKp9UndrEgJ/5a83vP1375YCV2lMvWARrNlBep4RN\rnESUJhQz58Gr/F39TwIDAQAB");
            z = true;
        } catch (Throwable unused) {
            z = false;
        }
        this.f20322b = z;
    }

    /* synthetic */ C6439a(byte b) {
        this();
    }

    /* renamed from: a */
    public static C6439a m25265a() {
        return C6440a.f20323a;
    }

    /* renamed from: a */
    private String m25266a(String str) {
        if (this.f20321a != null) {
            byte[] decode = Base64.decode(str, 0);
            try {
                Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                instance.init(2, this.f20321a);
                return new String(instance.doFinal(decode), "UTF-8").trim();
            } catch (Throwable th) {
                GDTLogger.m25261e("ErrorWhileVerifySigNature", th);
            }
        }
        return null;
    }

    /* renamed from: b */
    private static PublicKey m25267b(String str) throws Exception {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        } catch (NoSuchAlgorithmException unused) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException unused2) {
            throw new Exception("公钥非法");
        } catch (NullPointerException unused3) {
            throw new Exception("公钥数据为空");
        }
    }

    /* renamed from: a */
    public final boolean mo30392a(String str, String str2) {
        return mo30393b(str, Md5Util.encode(str2));
    }

    /* renamed from: b */
    public final boolean mo30393b(String str, String str2) {
        if (StringUtil.isEmpty(str2)) {
            return false;
        }
        if (!this.f20322b) {
            return true;
        }
        String a = m25266a(str);
        boolean equals = str2.equals(a);
        StringBuilder sb = new StringBuilder("Verify Result");
        sb.append(equals);
        sb.append("src=");
        sb.append(str2);
        sb.append(" & target=");
        sb.append(a);
        GDTLogger.m25258d(sb.toString());
        return equals;
    }
}
