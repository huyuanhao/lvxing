package okhttp3.internal.p702f;

import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;
import okhttp3.internal.p701e.C8447f;

/* compiled from: CertificateChainCleaner */
/* renamed from: okhttp3.internal.f.c */
public abstract class C8450c {
    /* renamed from: a */
    public abstract List<Certificate> mo40330a(List<Certificate> list, String str) throws SSLPeerUnverifiedException;

    /* renamed from: a */
    public static C8450c m36216a(X509TrustManager x509TrustManager) {
        return C8447f.m36198c().mo40322a(x509TrustManager);
    }
}
