package okhttp3.internal.p702f;

import java.security.cert.X509Certificate;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;

/* compiled from: BasicTrustRootIndex */
/* renamed from: okhttp3.internal.f.b */
public final class C8449b implements C8452e {
    /* renamed from: a */
    private final Map<X500Principal, Set<X509Certificate>> f28650a = new LinkedHashMap();

    public C8449b(X509Certificate... x509CertificateArr) {
        for (X509Certificate x509Certificate : x509CertificateArr) {
            X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
            Set set = (Set) this.f28650a.get(subjectX500Principal);
            if (set == null) {
                set = new LinkedHashSet(1);
                this.f28650a.put(subjectX500Principal, set);
            }
            set.add(x509Certificate);
        }
    }

    /* renamed from: a */
    public X509Certificate mo40333a(X509Certificate x509Certificate) {
        Set<X509Certificate> set = (Set) this.f28650a.get(x509Certificate.getIssuerX500Principal());
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
        if (!(obj instanceof C8449b) || !((C8449b) obj).f28650a.equals(this.f28650a)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return this.f28650a.hashCode();
    }
}
