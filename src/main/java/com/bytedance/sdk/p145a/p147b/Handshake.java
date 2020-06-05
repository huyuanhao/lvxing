package com.bytedance.sdk.p145a.p147b;

import com.bytedance.sdk.p145a.p147b.p148a.C1876c;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* renamed from: com.bytedance.sdk.a.b.t */
public final class Handshake {
    /* renamed from: a */
    private final TlsVersion f5955a;
    /* renamed from: b */
    private final CipherSuite f5956b;
    /* renamed from: c */
    private final List<Certificate> f5957c;
    /* renamed from: d */
    private final List<Certificate> f5958d;

    private Handshake(TlsVersion adVar, CipherSuite kVar, List<Certificate> list, List<Certificate> list2) {
        this.f5955a = adVar;
        this.f5956b = kVar;
        this.f5957c = list;
        this.f5958d = list2;
    }

    /* renamed from: a */
    public static Handshake m7519a(SSLSession sSLSession) {
        Certificate[] certificateArr;
        List list;
        List list2;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite != null) {
            CipherSuite a = CipherSuite.m7447a(cipherSuite);
            String protocol = sSLSession.getProtocol();
            if (protocol != null) {
                TlsVersion a2 = TlsVersion.m7375a(protocol);
                try {
                    certificateArr = sSLSession.getPeerCertificates();
                } catch (SSLPeerUnverifiedException unused) {
                    certificateArr = null;
                }
                if (certificateArr != null) {
                    list = C1876c.m6958a((T[]) certificateArr);
                } else {
                    list = Collections.emptyList();
                }
                Certificate[] localCertificates = sSLSession.getLocalCertificates();
                if (localCertificates != null) {
                    list2 = C1876c.m6958a((T[]) localCertificates);
                } else {
                    list2 = Collections.emptyList();
                }
                return new Handshake(a2, a, list, list2);
            }
            throw new IllegalStateException("tlsVersion == null");
        }
        throw new IllegalStateException("cipherSuite == null");
    }

    /* renamed from: a */
    public CipherSuite mo14065a() {
        return this.f5956b;
    }

    /* renamed from: b */
    public List<Certificate> mo14066b() {
        return this.f5957c;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof Handshake)) {
            return false;
        }
        Handshake tVar = (Handshake) obj;
        if (this.f5955a.equals(tVar.f5955a) && this.f5956b.equals(tVar.f5956b) && this.f5957c.equals(tVar.f5957c) && this.f5958d.equals(tVar.f5958d)) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return ((((((527 + this.f5955a.hashCode()) * 31) + this.f5956b.hashCode()) * 31) + this.f5957c.hashCode()) * 31) + this.f5958d.hashCode();
    }
}
