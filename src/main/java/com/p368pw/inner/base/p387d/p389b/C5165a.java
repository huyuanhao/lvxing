package com.p368pw.inner.base.p387d.p389b;

import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* renamed from: com.pw.inner.base.d.b.a */
public class C5165a implements X509TrustManager {
    /* renamed from: a */
    private static TrustManager[] f16847a;

    /* renamed from: a */
    public static void m21319a() {
        try {
            HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
                public boolean verify(String str, SSLSession sSLSession) {
                    return true;
                }
            });
            if (f16847a == null) {
                f16847a = new TrustManager[]{new C5165a()};
            }
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init(null, f16847a, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(instance.getSocketFactory());
        } catch (Throwable unused) {
        }
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
    }

    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }
}
