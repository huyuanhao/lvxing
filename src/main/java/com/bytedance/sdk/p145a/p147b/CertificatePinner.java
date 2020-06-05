package com.bytedance.sdk.p145a.p147b;

import com.bytedance.sdk.p145a.p146a.ByteString;
import com.bytedance.sdk.p145a.p147b.p148a.C1876c;
import com.bytedance.sdk.p145a.p147b.p148a.p157i.CertificateChainCleaner;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;

/* renamed from: com.bytedance.sdk.a.b.j */
public final class CertificatePinner {
    /* renamed from: a */
    public static final CertificatePinner f5787a = new C1925a().mo14001a();
    /* renamed from: b */
    private final Set<C1926b> f5788b;
    /* renamed from: c */
    private final CertificateChainCleaner f5789c;

    /* compiled from: CertificatePinner */
    /* renamed from: com.bytedance.sdk.a.b.j$a */
    public static final class C1925a {
        /* renamed from: a */
        private final List<C1926b> f5790a = new ArrayList();

        /* renamed from: a */
        public CertificatePinner mo14001a() {
            return new CertificatePinner(new LinkedHashSet(this.f5790a), null);
        }
    }

    /* compiled from: CertificatePinner */
    /* renamed from: com.bytedance.sdk.a.b.j$b */
    static final class C1926b {
        /* renamed from: a */
        final String f5791a;
        /* renamed from: b */
        final String f5792b;
        /* renamed from: c */
        final String f5793c;
        /* renamed from: d */
        final ByteString f5794d;

        /* access modifiers changed from: 0000 */
        /* JADX WARNING: Code restructure failed: missing block: B:5:0x002e, code lost:
            if (r11.regionMatches(false, r6, r7, 0, r7.length()) != false) goto L_0x0032;
     */
        /* renamed from: a */
        public boolean mo14002a(java.lang.String r11) {
            /*
            r10 = this;
            java.lang.String r0 = r10.f5791a
            java.lang.String r1 = "*."
            boolean r0 = r0.startsWith(r1)
            if (r0 == 0) goto L_0x0033
            r0 = 46
            int r0 = r11.indexOf(r0)
            int r1 = r11.length()
            int r1 = r1 - r0
            r2 = 1
            int r1 = r1 - r2
            java.lang.String r3 = r10.f5792b
            int r3 = r3.length()
            if (r1 != r3) goto L_0x0031
            r5 = 0
            int r6 = r0 + 1
            java.lang.String r7 = r10.f5792b
            r8 = 0
            int r9 = r7.length()
            r4 = r11
            boolean r11 = r4.regionMatches(r5, r6, r7, r8, r9)
            if (r11 == 0) goto L_0x0031
            goto L_0x0032
        L_0x0031:
            r2 = 0
        L_0x0032:
            return r2
        L_0x0033:
            java.lang.String r0 = r10.f5792b
            boolean r11 = r11.equals(r0)
            return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.p145a.p147b.CertificatePinner.C1926b.mo14002a(java.lang.String):boolean");
        }

        public boolean equals(Object obj) {
            if (obj instanceof C1926b) {
                C1926b bVar = (C1926b) obj;
                if (this.f5791a.equals(bVar.f5791a) && this.f5793c.equals(bVar.f5793c) && this.f5794d.equals(bVar.f5794d)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((((527 + this.f5791a.hashCode()) * 31) + this.f5793c.hashCode()) * 31) + this.f5794d.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f5793c);
            sb.append(this.f5794d.mo13593b());
            return sb.toString();
        }
    }

    CertificatePinner(Set<C1926b> set, CertificateChainCleaner cVar) {
        this.f5788b = set;
        this.f5789c = cVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001c, code lost:
            if (r3.f5788b.equals(r4.f5788b) != false) goto L_0x0020;
     */
    public boolean equals(java.lang.Object r4) {
        /*
        r3 = this;
        r0 = 1
        if (r4 != r3) goto L_0x0004
        return r0
    L_0x0004:
        boolean r1 = r4 instanceof com.bytedance.sdk.p145a.p147b.CertificatePinner
        if (r1 == 0) goto L_0x001f
        com.bytedance.sdk.a.b.a.i.c r1 = r3.f5789c
        com.bytedance.sdk.a.b.j r4 = (com.bytedance.sdk.p145a.p147b.CertificatePinner) r4
        com.bytedance.sdk.a.b.a.i.c r2 = r4.f5789c
        boolean r1 = com.bytedance.sdk.p145a.p147b.p148a.C1876c.m6965a(r1, r2)
        if (r1 == 0) goto L_0x001f
        java.util.Set<com.bytedance.sdk.a.b.j$b> r1 = r3.f5788b
        java.util.Set<com.bytedance.sdk.a.b.j$b> r4 = r4.f5788b
        boolean r4 = r1.equals(r4)
        if (r4 == 0) goto L_0x001f
        goto L_0x0020
    L_0x001f:
        r0 = 0
    L_0x0020:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.p145a.p147b.CertificatePinner.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        CertificateChainCleaner cVar = this.f5789c;
        return ((cVar != null ? cVar.hashCode() : 0) * 31) + this.f5788b.hashCode();
    }

    /* renamed from: a */
    public void mo13998a(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        String str2;
        List a = mo13997a(str);
        if (!a.isEmpty()) {
            CertificateChainCleaner cVar = this.f5789c;
            if (cVar != null) {
                list = cVar.mo13878a(list, str);
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                X509Certificate x509Certificate = (X509Certificate) list.get(i);
                int size2 = a.size();
                ByteString fVar = null;
                Object obj = null;
                for (int i2 = 0; i2 < size2; i2++) {
                    C1926b bVar = (C1926b) a.get(i2);
                    if (bVar.f5793c.equals("sha256/")) {
                        if (fVar == null) {
                            fVar = m7441b(x509Certificate);
                        }
                        if (bVar.f5794d.equals(fVar)) {
                            return;
                        }
                    } else if (bVar.f5793c.equals("sha1/")) {
                        if (obj == null) {
                            obj = m7439a(x509Certificate);
                        }
                        if (bVar.f5794d.equals(obj)) {
                            return;
                        }
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("unsupported hashAlgorithm: ");
                        sb.append(bVar.f5793c);
                        throw new AssertionError(sb.toString());
                    }
                }
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Certificate pinning failure!");
            sb2.append("\n  Peer certificate chain:");
            int size3 = list.size();
            int i3 = 0;
            while (true) {
                str2 = "\n    ";
                if (i3 >= size3) {
                    break;
                }
                X509Certificate x509Certificate2 = (X509Certificate) list.get(i3);
                sb2.append(str2);
                sb2.append(m7440a((Certificate) x509Certificate2));
                sb2.append(": ");
                sb2.append(x509Certificate2.getSubjectDN().getName());
                i3++;
            }
            sb2.append("\n  Pinned certificates for ");
            sb2.append(str);
            sb2.append(":");
            int size4 = a.size();
            for (int i4 = 0; i4 < size4; i4++) {
                C1926b bVar2 = (C1926b) a.get(i4);
                sb2.append(str2);
                sb2.append(bVar2);
            }
            throw new SSLPeerUnverifiedException(sb2.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public List<C1926b> mo13997a(String str) {
        List<C1926b> emptyList = Collections.emptyList();
        for (C1926b bVar : this.f5788b) {
            if (bVar.mo14002a(str)) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList<>();
                }
                emptyList.add(bVar);
            }
        }
        return emptyList;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public CertificatePinner mo13996a(CertificateChainCleaner cVar) {
        return C1876c.m6965a((Object) this.f5789c, (Object) cVar) ? this : new CertificatePinner(this.f5788b, cVar);
    }

    /* renamed from: a */
    public static String m7440a(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            StringBuilder sb = new StringBuilder();
            sb.append("sha256/");
            sb.append(m7441b((X509Certificate) certificate).mo13593b());
            return sb.toString();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    /* renamed from: a */
    static ByteString m7439a(X509Certificate x509Certificate) {
        return ByteString.m6703a(x509Certificate.getPublicKey().getEncoded()).mo13594c();
    }

    /* renamed from: b */
    static ByteString m7441b(X509Certificate x509Certificate) {
        return ByteString.m6703a(x509Certificate.getPublicKey().getEncoded()).mo13596d();
    }
}
