package com.qiyukf.basesdk.p394b.p395a.p404c.p405a;

import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* renamed from: com.qiyukf.basesdk.b.a.c.a.a */
public final class C5313a implements X509TrustManager {
    /* renamed from: b */
    private static SSLSocketFactory f17215b;
    /* renamed from: a */
    private X509TrustManager f17216a = null;

    private C5313a() {
        TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        instance.init(null);
        TrustManager[] trustManagers = instance.getTrustManagers();
        int length = trustManagers.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            TrustManager trustManager = trustManagers[i];
            if (trustManager instanceof X509TrustManager) {
                this.f17216a = (X509TrustManager) trustManager;
                break;
            }
            i++;
        }
        if (this.f17216a == null) {
            throw new NoSuchAlgorithmException("no trust manager found");
        }
    }

    /* renamed from: a */
    public static SSLSocketFactory m21840a() {
        if (f17215b == null) {
            SSLSocketFactory b = m21841b();
            f17215b = b;
            if (b == null) {
                f17215b = (SSLSocketFactory) SSLSocketFactory.getDefault();
            }
        }
        return f17215b;
    }

    /* renamed from: b */
    private static SSLSocketFactory m21841b() {
        SSLSocketFactory sSLSocketFactory = null;
        try {
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init(null, new TrustManager[]{new C5313a()}, null);
            sSLSocketFactory = instance.getSocketFactory();
            return sSLSocketFactory;
        } catch (Exception e) {
            e.printStackTrace();
            return sSLSocketFactory;
        }
    }

    public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        this.f17216a.checkClientTrusted(x509CertificateArr, str);
    }

    public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        if (x509CertificateArr == null || x509CertificateArr.length != 1) {
            this.f17216a.checkServerTrusted(x509CertificateArr, str);
        } else {
            x509CertificateArr[0].checkValidity();
        }
    }

    public final X509Certificate[] getAcceptedIssuers() {
        return this.f17216a.getAcceptedIssuers();
    }
}
