package ezy.assist.p648c;

import ezy.assist.exception.UncheckedException;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: ezy.assist.c.a */
public class CryptoUtil {
    /* renamed from: a */
    private static SecureRandom f27271a = m34793a();

    /* renamed from: a */
    public static SecureRandom m34793a() {
        try {
            return SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException unused) {
            return new SecureRandom();
        }
    }

    /* renamed from: a */
    public static RuntimeException m34792a(Throwable th) {
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        } else if (th instanceof Error) {
            throw ((Error) th);
        } else {
            throw new UncheckedException(th);
        }
    }

    /* renamed from: a */
    public static byte[] m34795a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return m34796a(bArr, bArr2, bArr3, 1);
    }

    /* renamed from: b */
    public static String m34797b(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return new String(m34796a(bArr, bArr2, bArr3, 2), StandardCharsets.UTF_8);
    }

    /* renamed from: a */
    private static byte[] m34796a(byte[] bArr, byte[] bArr2, byte[] bArr3, int i) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(i, secretKeySpec, ivParameterSpec);
            return instance.doFinal(bArr);
        } catch (GeneralSecurityException e) {
            throw m34792a((Throwable) e);
        }
    }

    /* renamed from: a */
    public static byte[] m34794a(int i) {
        try {
            KeyGenerator instance = KeyGenerator.getInstance("AES");
            instance.init(i);
            return instance.generateKey().getEncoded();
        } catch (GeneralSecurityException e) {
            throw m34792a((Throwable) e);
        }
    }

    /* renamed from: b */
    public static byte[] m34798b() {
        byte[] bArr = new byte[16];
        f27271a.nextBytes(bArr);
        return bArr;
    }
}
