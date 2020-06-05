package epco;

import epco.C7949b.C7951b;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.security.cert.X509Certificate;

/* renamed from: epco.g */
public class C7969g {
    /* renamed from: a */
    private final InputStream f27083a;

    public C7969g(InputStream inputStream) {
        this.f27083a = new BufferedInputStream(inputStream);
    }

    /* renamed from: a */
    private String m34491a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length);
        for (byte b : bArr) {
            String hexString = Integer.toHexString(((char) b) & 255);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString.toUpperCase());
        }
        return sb.toString();
    }

    /* renamed from: a */
    private MessageDigest m34492a(String str) {
        try {
            return MessageDigest.getInstance(str);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: b */
    private String m34493b(String str) {
        MessageDigest a = m34492a("MD5");
        a.update(str.getBytes("UTF-8"));
        return m34494b(a.digest());
    }

    /* renamed from: b */
    private String m34494b(byte[] bArr) {
        return String.format("%032x", new Object[]{new BigInteger(1, bArr)});
    }

    /* renamed from: c */
    private String m34495c(byte[] bArr) {
        MessageDigest a = m34492a("MD5");
        a.update(bArr);
        return m34494b(a.digest());
    }

    /* renamed from: a */
    public C7949b mo38338a() {
        X509Certificate instance = X509Certificate.getInstance(C8007w0.m34701a(this.f27083a));
        C7951b a = C7949b.m34382a();
        byte[] encoded = instance.getEncoded();
        String c = m34495c(encoded);
        String b = m34493b(m34491a(encoded));
        a.mo38260a(encoded);
        a.mo38258a(b);
        a.mo38262b(c);
        a.mo38263b(instance.getNotBefore());
        a.mo38259a(instance.getNotAfter());
        a.mo38264c(instance.getSigAlgName());
        a.mo38265d(instance.getSigAlgOID());
        return a.mo38261a();
    }
}
