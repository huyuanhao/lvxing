package com.bytedance.sdk.openadsdk.utils;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SignatureException;
import javax.security.cert.Certificate;
import javax.security.cert.CertificateException;
import javax.security.cert.X509Certificate;

/* renamed from: com.bytedance.sdk.openadsdk.utils.aj */
public class VerifyCertsChain {
    /* renamed from: a */
    public static boolean m12096a(Certificate[] certificateArr) {
        if (certificateArr != null) {
            int length = certificateArr.length;
            int i = 0;
            while (i < length) {
                X509Certificate[] a = m12098a(certificateArr, i);
                if (!m12097a(a)) {
                    return false;
                }
                i += a.length;
            }
        }
        return true;
    }

    /* renamed from: a */
    private static X509Certificate[] m12098a(Certificate[] certificateArr, int i) {
        int i2 = i;
        while (i2 < certificateArr.length - 1) {
            int i3 = i2 + 1;
            if (!certificateArr[i2].getIssuerDN().equals(certificateArr[i3].getSubjectDN())) {
                break;
            }
            i2 = i3;
        }
        int i4 = (i2 - i) + 1;
        X509Certificate[] x509CertificateArr = new X509Certificate[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            x509CertificateArr[i5] = certificateArr[i + i5];
        }
        return x509CertificateArr;
    }

    /* renamed from: a */
    private static boolean m12097a(X509Certificate[] x509CertificateArr) {
        int length = x509CertificateArr.length;
        int i = 0;
        while (i < length - 1) {
            X509Certificate x509Certificate = x509CertificateArr[i];
            i++;
            try {
                x509Certificate.verify(x509CertificateArr[i].getPublicKey());
            } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchProviderException | SignatureException | CertificateException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }
}
