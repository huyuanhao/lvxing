package com.jiayouya.travel.common.glide;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* renamed from: com.jiayouya.travel.common.glide.d */
public class HttpsUtil {

    /* compiled from: HttpsUtil */
    /* renamed from: com.jiayouya.travel.common.glide.d$a */
    public static class C2902a implements HostnameVerifier {
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    }

    /* compiled from: HttpsUtil */
    /* renamed from: com.jiayouya.travel.common.glide.d$b */
    public static class C2903b implements X509TrustManager {
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    /* renamed from: a */
    public static SSLSocketFactory m13079a() {
        SSLSocketFactory sSLSocketFactory = null;
        try {
            SSLContext instance = SSLContext.getInstance("SSL");
            instance.init(null, new TrustManager[]{new C2903b()}, new SecureRandom());
            sSLSocketFactory = instance.getSocketFactory();
            return sSLSocketFactory;
        } catch (KeyManagementException | NoSuchAlgorithmException e) {
            e.printStackTrace();
            return sSLSocketFactory;
        }
    }
}
