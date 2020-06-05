package com.bytedance.sdk.p145a.p147b.p148a.p157i;

import com.bytedance.sdk.p145a.p147b.p148a.p155g.Platform;
import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;

/* renamed from: com.bytedance.sdk.a.b.a.i.c */
public abstract class CertificateChainCleaner {
    /* renamed from: a */
    public abstract List<Certificate> mo13878a(List<Certificate> list, String str) throws SSLPeerUnverifiedException;

    /* renamed from: a */
    public static CertificateChainCleaner m7316a(X509TrustManager x509TrustManager) {
        return Platform.m7295b().mo13869a(x509TrustManager);
    }
}
