package com.bytedance.sdk.openadsdk.p188g;

import com.bytedance.sdk.openadsdk.utils.VerifyCertsChain;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import javax.security.cert.Certificate;

/* renamed from: com.bytedance.sdk.openadsdk.g.d */
public class TTHostNameVerifier implements HostnameVerifier {
    /* renamed from: a */
    public static final TTHostNameVerifier f8720a = new TTHostNameVerifier();

    private TTHostNameVerifier() {
    }

    public boolean verify(String str, SSLSession sSLSession) {
        try {
            if ("is.snssdk.com".equalsIgnoreCase(str) || "pangolin.snssdk.com".equalsIgnoreCase(str)) {
                return VerifyCertsChain.m12096a((Certificate[]) sSLSession.getPeerCertificateChain());
            }
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }
}
