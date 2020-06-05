package okhttp3;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.internal.C8417c;
import okhttp3.internal.p702f.C8450c;
import okio.ByteString;

/* compiled from: CertificatePinner */
/* renamed from: okhttp3.g */
public final class C8382g {
    /* renamed from: a */
    public static final C8382g f28308a = new C8383a().mo40183a();
    /* renamed from: b */
    private final Set<C8384b> f28309b;
    @Nullable
    /* renamed from: c */
    private final C8450c f28310c;

    /* compiled from: CertificatePinner */
    /* renamed from: okhttp3.g$a */
    public static final class C8383a {
        /* renamed from: a */
        private final List<C8384b> f28311a = new ArrayList();

        /* renamed from: a */
        public C8382g mo40183a() {
            return new C8382g(new LinkedHashSet(this.f28311a), null);
        }
    }

    /* compiled from: CertificatePinner */
    /* renamed from: okhttp3.g$b */
    static final class C8384b {
        /* renamed from: a */
        final String f28312a;
        /* renamed from: b */
        final String f28313b;
        /* renamed from: c */
        final String f28314c;
        /* renamed from: d */
        final ByteString f28315d;

        /* access modifiers changed from: 0000 */
        /* JADX WARNING: Code restructure failed: missing block: B:5:0x002e, code lost:
            if (r11.regionMatches(false, r6, r7, 0, r7.length()) != false) goto L_0x0032;
     */
        /* renamed from: a */
        public boolean mo40184a(java.lang.String r11) {
            /*
            r10 = this;
            java.lang.String r0 = r10.f28312a
            java.lang.String r1 = "*."
            boolean r0 = r0.startsWith(r1)
            if (r0 == 0) goto L_0x0033
            r0 = 46
            int r0 = r11.indexOf(r0)
            int r1 = r11.length()
            int r1 = r1 - r0
            r2 = 1
            int r1 = r1 - r2
            java.lang.String r3 = r10.f28313b
            int r3 = r3.length()
            if (r1 != r3) goto L_0x0031
            r5 = 0
            int r6 = r0 + 1
            java.lang.String r7 = r10.f28313b
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
            java.lang.String r0 = r10.f28313b
            boolean r11 = r11.equals(r0)
            return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.C8382g.C8384b.mo40184a(java.lang.String):boolean");
        }

        public boolean equals(Object obj) {
            if (obj instanceof C8384b) {
                C8384b bVar = (C8384b) obj;
                if (this.f28312a.equals(bVar.f28312a) && this.f28314c.equals(bVar.f28314c) && this.f28315d.equals(bVar.f28315d)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((((527 + this.f28312a.hashCode()) * 31) + this.f28314c.hashCode()) * 31) + this.f28315d.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f28314c);
            sb.append(this.f28315d.base64());
            return sb.toString();
        }
    }

    C8382g(Set<C8384b> set, @Nullable C8450c cVar) {
        this.f28309b = set;
        this.f28310c = cVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001c, code lost:
            if (r3.f28309b.equals(r4.f28309b) != false) goto L_0x0020;
     */
    public boolean equals(@javax.annotation.Nullable java.lang.Object r4) {
        /*
        r3 = this;
        r0 = 1
        if (r4 != r3) goto L_0x0004
        return r0
    L_0x0004:
        boolean r1 = r4 instanceof okhttp3.C8382g
        if (r1 == 0) goto L_0x001f
        okhttp3.internal.f.c r1 = r3.f28310c
        okhttp3.g r4 = (okhttp3.C8382g) r4
        okhttp3.internal.f.c r2 = r4.f28310c
        boolean r1 = okhttp3.internal.C8417c.m36044a(r1, r2)
        if (r1 == 0) goto L_0x001f
        java.util.Set<okhttp3.g$b> r1 = r3.f28309b
        java.util.Set<okhttp3.g$b> r4 = r4.f28309b
        boolean r4 = r1.equals(r4)
        if (r4 == 0) goto L_0x001f
        goto L_0x0020
    L_0x001f:
        r0 = 0
    L_0x0020:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.C8382g.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        C8450c cVar = this.f28310c;
        return ((cVar != null ? cVar.hashCode() : 0) * 31) + this.f28309b.hashCode();
    }

    /* renamed from: a */
    public void mo40180a(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        String str2;
        List a = mo40178a(str);
        if (!a.isEmpty()) {
            C8450c cVar = this.f28310c;
            if (cVar != null) {
                list = cVar.mo40330a(list, str);
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                X509Certificate x509Certificate = (X509Certificate) list.get(i);
                int size2 = a.size();
                ByteString byteString = null;
                Object obj = null;
                for (int i2 = 0; i2 < size2; i2++) {
                    C8384b bVar = (C8384b) a.get(i2);
                    if (bVar.f28314c.equals("sha256/")) {
                        if (byteString == null) {
                            byteString = m35886b(x509Certificate);
                        }
                        if (bVar.f28315d.equals(byteString)) {
                            return;
                        }
                    } else if (bVar.f28314c.equals("sha1/")) {
                        if (obj == null) {
                            obj = m35885a(x509Certificate);
                        }
                        if (bVar.f28315d.equals(obj)) {
                            return;
                        }
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("unsupported hashAlgorithm: ");
                        sb.append(bVar.f28314c);
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
                sb2.append(m35884a((Certificate) x509Certificate2));
                sb2.append(": ");
                sb2.append(x509Certificate2.getSubjectDN().getName());
                i3++;
            }
            sb2.append("\n  Pinned certificates for ");
            sb2.append(str);
            sb2.append(":");
            int size4 = a.size();
            for (int i4 = 0; i4 < size4; i4++) {
                C8384b bVar2 = (C8384b) a.get(i4);
                sb2.append(str2);
                sb2.append(bVar2);
            }
            throw new SSLPeerUnverifiedException(sb2.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public List<C8384b> mo40178a(String str) {
        List<C8384b> emptyList = Collections.emptyList();
        for (C8384b bVar : this.f28309b) {
            if (bVar.mo40184a(str)) {
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
    public C8382g mo40179a(@Nullable C8450c cVar) {
        if (C8417c.m36044a((Object) this.f28310c, (Object) cVar)) {
            return this;
        }
        return new C8382g(this.f28309b, cVar);
    }

    /* renamed from: a */
    public static String m35884a(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            StringBuilder sb = new StringBuilder();
            sb.append("sha256/");
            sb.append(m35886b((X509Certificate) certificate).base64());
            return sb.toString();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    /* renamed from: a */
    static ByteString m35885a(X509Certificate x509Certificate) {
        return ByteString.m36697of(x509Certificate.getPublicKey().getEncoded()).sha1();
    }

    /* renamed from: b */
    static ByteString m35886b(X509Certificate x509Certificate) {
        return ByteString.m36697of(x509Certificate.getPublicKey().getEncoded()).sha256();
    }
}
