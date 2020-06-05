package com.bytedance.sdk.p145a.p147b.p148a.p157i;

import java.security.cert.X509Certificate;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;

/* renamed from: com.bytedance.sdk.a.b.a.i.b */
public final class BasicTrustRootIndex implements TrustRootIndex {
    /* renamed from: a */
    private final Map<X500Principal, Set<X509Certificate>> f5691a = new LinkedHashMap();

    public BasicTrustRootIndex(X509Certificate... x509CertificateArr) {
        for (X509Certificate x509Certificate : x509CertificateArr) {
            X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
            Set set = (Set) this.f5691a.get(subjectX500Principal);
            if (set == null) {
                set = new LinkedHashSet(1);
                this.f5691a.put(subjectX500Principal, set);
            }
            set.add(x509Certificate);
        }
    }

    /* renamed from: a */
    public X509Certificate mo13881a(X509Certificate x509Certificate) {
        Set<X509Certificate> set = (Set) this.f5691a.get(x509Certificate.getIssuerX500Principal());
        if (set == null) {
            return null;
        }
        for (X509Certificate x509Certificate2 : set) {
            try {
                x509Certificate.verify(x509Certificate2.getPublicKey());
                return x509Certificate2;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BasicTrustRootIndex) || !((BasicTrustRootIndex) obj).f5691a.equals(this.f5691a)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return this.f5691a.hashCode();
    }
}
