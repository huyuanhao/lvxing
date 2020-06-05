package okhttp3;

import java.io.IOException;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import okhttp3.internal.C8417c;

/* compiled from: Handshake */
/* renamed from: okhttp3.r */
public final class C8503r {
    /* renamed from: a */
    private final TlsVersion f28881a;
    /* renamed from: b */
    private final C8385h f28882b;
    /* renamed from: c */
    private final List<Certificate> f28883c;
    /* renamed from: d */
    private final List<Certificate> f28884d;

    private C8503r(TlsVersion tlsVersion, C8385h hVar, List<Certificate> list, List<Certificate> list2) {
        this.f28881a = tlsVersion;
        this.f28882b = hVar;
        this.f28883c = list;
        this.f28884d = list2;
    }

    /* renamed from: a */
    public static C8503r m36509a(SSLSession sSLSession) throws IOException {
        Certificate[] certificateArr;
        List list;
        List list2;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        } else if (!"SSL_NULL_WITH_NULL_NULL".equals(cipherSuite)) {
            C8385h a = C8385h.m35893a(cipherSuite);
            String protocol = sSLSession.getProtocol();
            if (protocol == null) {
                throw new IllegalStateException("tlsVersion == null");
            } else if (!"NONE".equals(protocol)) {
                TlsVersion forJavaName = TlsVersion.forJavaName(protocol);
                try {
                    certificateArr = sSLSession.getPeerCertificates();
                } catch (SSLPeerUnverifiedException unused) {
                    certificateArr = null;
                }
                if (certificateArr != null) {
                    list = C8417c.m36035a((T[]) certificateArr);
                } else {
                    list = Collections.emptyList();
                }
                Certificate[] localCertificates = sSLSession.getLocalCertificates();
                if (localCertificates != null) {
                    list2 = C8417c.m36035a((T[]) localCertificates);
                } else {
                    list2 = Collections.emptyList();
                }
                return new C8503r(forJavaName, a, list, list2);
            } else {
                throw new IOException("tlsVersion == NONE");
            }
        } else {
            throw new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
        }
    }

    /* renamed from: a */
    public static C8503r m36510a(TlsVersion tlsVersion, C8385h hVar, List<Certificate> list, List<Certificate> list2) {
        if (tlsVersion == null) {
            throw new NullPointerException("tlsVersion == null");
        } else if (hVar != null) {
            return new C8503r(tlsVersion, hVar, C8417c.m36034a(list), C8417c.m36034a(list2));
        } else {
            throw new NullPointerException("cipherSuite == null");
        }
    }

    /* renamed from: a */
    public TlsVersion mo40525a() {
        return this.f28881a;
    }

    /* renamed from: b */
    public C8385h mo40526b() {
        return this.f28882b;
    }

    /* renamed from: c */
    public List<Certificate> mo40527c() {
        return this.f28883c;
    }

    /* renamed from: d */
    public List<Certificate> mo40528d() {
        return this.f28884d;
    }

    public boolean equals(@Nullable Object obj) {
        boolean z = false;
        if (!(obj instanceof C8503r)) {
            return false;
        }
        C8503r rVar = (C8503r) obj;
        if (this.f28881a.equals(rVar.f28881a) && this.f28882b.equals(rVar.f28882b) && this.f28883c.equals(rVar.f28883c) && this.f28884d.equals(rVar.f28884d)) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return ((((((527 + this.f28881a.hashCode()) * 31) + this.f28882b.hashCode()) * 31) + this.f28883c.hashCode()) * 31) + this.f28884d.hashCode();
    }
}
