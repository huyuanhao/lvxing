package okhttp3;

import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import okhttp3.C8362ab.C8363a;
import okhttp3.C8504s.C8505a;
import okhttp3.C8518z.C8519a;
import okhttp3.internal.C8417c;
import okhttp3.internal.p697a.C8391b;
import okhttp3.internal.p697a.C8392c;
import okhttp3.internal.p697a.C8394d;
import okhttp3.internal.p697a.C8394d.C8397a;
import okhttp3.internal.p697a.C8394d.C8400c;
import okhttp3.internal.p697a.C8401f;
import okhttp3.internal.p698b.C8409e;
import okhttp3.internal.p698b.C8410f;
import okhttp3.internal.p698b.C8415k;
import okhttp3.internal.p700d.C8437a;
import okhttp3.internal.p701e.C8447f;
import okio.ByteString;
import okio.C8525c;
import okio.C8528d;
import okio.C8529e;
import okio.C8530f;
import okio.C8531g;
import okio.C8535k;
import okio.C8546q;
import okio.C8547r;

/* compiled from: Cache */
/* renamed from: okhttp3.c */
public final class C8370c implements Closeable, Flushable {
    /* renamed from: a */
    final C8401f f28251a;
    /* renamed from: b */
    final C8394d f28252b;
    /* renamed from: c */
    int f28253c;
    /* renamed from: d */
    int f28254d;
    /* renamed from: e */
    private int f28255e;
    /* renamed from: f */
    private int f28256f;
    /* renamed from: g */
    private int f28257g;

    /* compiled from: Cache */
    /* renamed from: okhttp3.c$a */
    private final class C8372a implements C8391b {
        /* renamed from: a */
        boolean f28259a;
        /* renamed from: c */
        private final C8397a f28261c;
        /* renamed from: d */
        private C8546q f28262d;
        /* renamed from: e */
        private C8546q f28263e;

        C8372a(final C8397a aVar) {
            this.f28261c = aVar;
            this.f28262d = aVar.mo40221a(1);
            this.f28263e = new C8530f(this.f28262d, C8370c.this) {
                public void close() throws IOException {
                    synchronized (C8370c.this) {
                        if (!C8372a.this.f28259a) {
                            C8372a.this.f28259a = true;
                            C8370c.this.f28253c++;
                            super.close();
                            aVar.mo40223b();
                        }
                    }
                }
            };
        }

        /* JADX INFO: used method not loaded: okhttp3.internal.c.a(java.io.Closeable):null, types can be incorrect */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            r4.f28261c.mo40224c();
     */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0014, code lost:
            okhttp3.internal.C8417c.m36040a((java.io.Closeable) r4.f28262d);
     */
        /* renamed from: a */
        public void mo40151a() {
            /*
            r4 = this;
            okhttp3.c r0 = okhttp3.C8370c.this
            monitor-enter(r0)
            boolean r1 = r4.f28259a     // Catch:{ all -> 0x001f }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            return
        L_0x0009:
            r1 = 1
            r4.f28259a = r1     // Catch:{ all -> 0x001f }
            okhttp3.c r2 = okhttp3.C8370c.this     // Catch:{ all -> 0x001f }
            int r3 = r2.f28254d     // Catch:{ all -> 0x001f }
            int r3 = r3 + r1
            r2.f28254d = r3     // Catch:{ all -> 0x001f }
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            okio.q r0 = r4.f28262d
            okhttp3.internal.C8417c.m36040a(r0)
            okhttp3.internal.a.d$a r0 = r4.f28261c     // Catch:{ IOException -> 0x001e }
            r0.mo40224c()     // Catch:{ IOException -> 0x001e }
        L_0x001e:
            return
        L_0x001f:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.C8370c.C8372a.mo40151a():void");
        }

        /* renamed from: b */
        public C8546q mo40152b() {
            return this.f28263e;
        }
    }

    /* compiled from: Cache */
    /* renamed from: okhttp3.c$b */
    private static class C8374b extends C8364ac {
        /* renamed from: a */
        final C8400c f28267a;
        /* renamed from: b */
        private final C8529e f28268b;
        @Nullable
        /* renamed from: c */
        private final String f28269c;
        @Nullable
        /* renamed from: d */
        private final String f28270d;

        C8374b(final C8400c cVar, String str, String str2) {
            this.f28267a = cVar;
            this.f28269c = str;
            this.f28270d = str2;
            this.f28268b = C8535k.m36849a((C8547r) new C8531g(cVar.mo40229a(1)) {
                public void close() throws IOException {
                    cVar.close();
                    super.close();
                }
            });
        }

        /* renamed from: a */
        public C8510v mo40120a() {
            String str = this.f28269c;
            if (str != null) {
                return C8510v.m36598b(str);
            }
            return null;
        }

        /* renamed from: b */
        public long mo40121b() {
            try {
                if (this.f28270d != null) {
                    return Long.parseLong(this.f28270d);
                }
                return -1;
            } catch (NumberFormatException unused) {
                return -1;
            }
        }

        /* renamed from: c */
        public C8529e mo40122c() {
            return this.f28268b;
        }
    }

    /* compiled from: Cache */
    /* renamed from: okhttp3.c$c */
    private static final class C8376c {
        /* renamed from: a */
        private static final String f28273a;
        /* renamed from: b */
        private static final String f28274b;
        /* renamed from: c */
        private final String f28275c;
        /* renamed from: d */
        private final C8504s f28276d;
        /* renamed from: e */
        private final String f28277e;
        /* renamed from: f */
        private final Protocol f28278f;
        /* renamed from: g */
        private final int f28279g;
        /* renamed from: h */
        private final String f28280h;
        /* renamed from: i */
        private final C8504s f28281i;
        @Nullable
        /* renamed from: j */
        private final C8503r f28282j;
        /* renamed from: k */
        private final long f28283k;
        /* renamed from: l */
        private final long f28284l;

        static {
            StringBuilder sb = new StringBuilder();
            sb.append(C8447f.m36198c().mo40346d());
            sb.append("-Sent-Millis");
            f28273a = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(C8447f.m36198c().mo40346d());
            sb2.append("-Received-Millis");
            f28274b = sb2.toString();
        }

        C8376c(C8547r rVar) throws IOException {
            TlsVersion tlsVersion;
            try {
                C8529e a = C8535k.m36849a(rVar);
                this.f28275c = a.mo40778r();
                this.f28277e = a.mo40778r();
                C8505a aVar = new C8505a();
                int a2 = C8370c.m35835a(a);
                for (int i = 0; i < a2; i++) {
                    aVar.mo40541a(a.mo40778r());
                }
                this.f28276d = aVar.mo40543a();
                C8415k a3 = C8415k.m36021a(a.mo40778r());
                this.f28278f = a3.f28525a;
                this.f28279g = a3.f28526b;
                this.f28280h = a3.f28527c;
                C8505a aVar2 = new C8505a();
                int a4 = C8370c.m35835a(a);
                for (int i2 = 0; i2 < a4; i2++) {
                    aVar2.mo40541a(a.mo40778r());
                }
                String c = aVar2.mo40546c(f28273a);
                String c2 = aVar2.mo40546c(f28274b);
                aVar2.mo40544b(f28273a);
                aVar2.mo40544b(f28274b);
                long j = 0;
                this.f28283k = c != null ? Long.parseLong(c) : 0;
                if (c2 != null) {
                    j = Long.parseLong(c2);
                }
                this.f28284l = j;
                this.f28281i = aVar2.mo40543a();
                if (m35857a()) {
                    String r = a.mo40778r();
                    if (r.length() <= 0) {
                        C8385h a5 = C8385h.m35893a(a.mo40778r());
                        List a6 = m35855a(a);
                        List a7 = m35855a(a);
                        if (!a.mo40755f()) {
                            tlsVersion = TlsVersion.forJavaName(a.mo40778r());
                        } else {
                            tlsVersion = TlsVersion.SSL_3_0;
                        }
                        this.f28282j = C8503r.m36510a(tlsVersion, a5, a6, a7);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("expected \"\" but was \"");
                        sb.append(r);
                        sb.append("\"");
                        throw new IOException(sb.toString());
                    }
                } else {
                    this.f28282j = null;
                }
            } finally {
                rVar.close();
            }
        }

        C8376c(C8362ab abVar) {
            this.f28275c = abVar.mo40088a().mo40645a().toString();
            this.f28276d = C8409e.m35987c(abVar);
            this.f28277e = abVar.mo40088a().mo40646b();
            this.f28278f = abVar.mo40090b();
            this.f28279g = abVar.mo40091c();
            this.f28280h = abVar.mo40094e();
            this.f28281i = abVar.mo40096g();
            this.f28282j = abVar.mo40095f();
            this.f28283k = abVar.mo40102m();
            this.f28284l = abVar.mo40103n();
        }

        /* renamed from: a */
        public void mo40156a(C8397a aVar) throws IOException {
            String str;
            C8528d a = C8535k.m36848a(aVar.mo40221a(0));
            a.mo40738b(this.f28275c).mo40765i(10);
            a.mo40738b(this.f28277e).mo40765i(10);
            a.mo40771l((long) this.f28276d.mo40531a()).mo40765i(10);
            int a2 = this.f28276d.mo40531a();
            int i = 0;
            while (true) {
                str = ": ";
                if (i >= a2) {
                    break;
                }
                a.mo40738b(this.f28276d.mo40532a(i)).mo40738b(str).mo40738b(this.f28276d.mo40534b(i)).mo40765i(10);
                i++;
            }
            a.mo40738b(new C8415k(this.f28278f, this.f28279g, this.f28280h).toString()).mo40765i(10);
            a.mo40771l((long) (this.f28281i.mo40531a() + 2)).mo40765i(10);
            int a3 = this.f28281i.mo40531a();
            for (int i2 = 0; i2 < a3; i2++) {
                a.mo40738b(this.f28281i.mo40532a(i2)).mo40738b(str).mo40738b(this.f28281i.mo40534b(i2)).mo40765i(10);
            }
            a.mo40738b(f28273a).mo40738b(str).mo40771l(this.f28283k).mo40765i(10);
            a.mo40738b(f28274b).mo40738b(str).mo40771l(this.f28284l).mo40765i(10);
            if (m35857a()) {
                a.mo40765i(10);
                a.mo40738b(this.f28282j.mo40526b().mo40188a()).mo40765i(10);
                m35856a(a, this.f28282j.mo40527c());
                m35856a(a, this.f28282j.mo40528d());
                a.mo40738b(this.f28282j.mo40525a().javaName()).mo40765i(10);
            }
            a.close();
        }

        /* renamed from: a */
        private boolean m35857a() {
            return this.f28275c.startsWith("https://");
        }

        /* renamed from: a */
        private List<Certificate> m35855a(C8529e eVar) throws IOException {
            int a = C8370c.m35835a(eVar);
            if (a == -1) {
                return Collections.emptyList();
            }
            try {
                CertificateFactory instance = CertificateFactory.getInstance("X.509");
                ArrayList arrayList = new ArrayList(a);
                for (int i = 0; i < a; i++) {
                    String r = eVar.mo40778r();
                    C8525c cVar = new C8525c();
                    cVar.mo40739b(ByteString.decodeBase64(r));
                    arrayList.add(instance.generateCertificate(cVar.mo40756g()));
                }
                return arrayList;
            } catch (CertificateException e) {
                throw new IOException(e.getMessage());
            }
        }

        /* renamed from: a */
        private void m35856a(C8528d dVar, List<Certificate> list) throws IOException {
            try {
                dVar.mo40771l((long) list.size()).mo40765i(10);
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    dVar.mo40738b(ByteString.m36697of(((Certificate) list.get(i)).getEncoded()).base64()).mo40765i(10);
                }
            } catch (CertificateEncodingException e) {
                throw new IOException(e.getMessage());
            }
        }

        /* renamed from: a */
        public boolean mo40157a(C8518z zVar, C8362ab abVar) {
            return this.f28275c.equals(zVar.mo40645a().toString()) && this.f28277e.equals(zVar.mo40646b()) && C8409e.m35982a(abVar, this.f28276d, zVar);
        }

        /* renamed from: a */
        public C8362ab mo40155a(C8400c cVar) {
            String a = this.f28281i.mo40533a("Content-Type");
            String a2 = this.f28281i.mo40533a("Content-Length");
            return new C8363a().mo40114a(new C8519a().mo40655a(this.f28275c).mo40657a(this.f28277e, (C8358aa) null).mo40659a(this.f28276d).mo40663b()).mo40109a(this.f28278f).mo40105a(this.f28279g).mo40107a(this.f28280h).mo40113a(this.f28281i).mo40111a((C8364ac) new C8374b(cVar, a, a2)).mo40112a(this.f28282j).mo40106a(this.f28283k).mo40116b(this.f28284l).mo40115a();
        }
    }

    public C8370c(File file, long j) {
        this(file, j, C8437a.f28620a);
    }

    C8370c(File file, long j, C8437a aVar) {
        this.f28251a = new C8401f() {
            /* renamed from: a */
            public C8362ab mo40145a(C8518z zVar) throws IOException {
                return C8370c.this.mo40137a(zVar);
            }

            /* renamed from: a */
            public C8391b mo40146a(C8362ab abVar) throws IOException {
                return C8370c.this.mo40138a(abVar);
            }

            /* renamed from: b */
            public void mo40150b(C8518z zVar) throws IOException {
                C8370c.this.mo40142b(zVar);
            }

            /* renamed from: a */
            public void mo40148a(C8362ab abVar, C8362ab abVar2) {
                C8370c.this.mo40140a(abVar, abVar2);
            }

            /* renamed from: a */
            public void mo40147a() {
                C8370c.this.mo40139a();
            }

            /* renamed from: a */
            public void mo40149a(C8392c cVar) {
                C8370c.this.mo40141a(cVar);
            }
        };
        this.f28252b = C8394d.m35923a(aVar, file, 201105, 2, j);
    }

    /* renamed from: a */
    public static String m35836a(C8506t tVar) {
        return ByteString.encodeUtf8(tVar.toString()).md5().hex();
    }

    /* access modifiers changed from: 0000 */
    @Nullable
    /* renamed from: a */
    public C8362ab mo40137a(C8518z zVar) {
        try {
            C8400c a = this.f28252b.mo40206a(m35836a(zVar.mo40645a()));
            if (a == null) {
                return null;
            }
            try {
                C8376c cVar = new C8376c(a.mo40229a(0));
                C8362ab a2 = cVar.mo40155a(a);
                if (cVar.mo40157a(zVar, a2)) {
                    return a2;
                }
                C8417c.m36040a((Closeable) a2.mo40097h());
                return null;
            } catch (IOException unused) {
                C8417c.m36040a((Closeable) a);
                return null;
            }
        } catch (IOException unused2) {
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    @Nullable
    /* renamed from: a */
    public C8391b mo40138a(C8362ab abVar) {
        C8397a aVar;
        String b = abVar.mo40088a().mo40646b();
        if (C8410f.m35990a(abVar.mo40088a().mo40646b())) {
            try {
                mo40142b(abVar.mo40088a());
            } catch (IOException unused) {
            }
            return null;
        } else if (!b.equals("GET") || C8409e.m35984b(abVar)) {
            return null;
        } else {
            C8376c cVar = new C8376c(abVar);
            try {
                aVar = this.f28252b.mo40210b(m35836a(abVar.mo40088a().mo40645a()));
                if (aVar == null) {
                    return null;
                }
                try {
                    cVar.mo40156a(aVar);
                    return new C8372a(aVar);
                } catch (IOException unused2) {
                    m35837a(aVar);
                    return null;
                }
            } catch (IOException unused3) {
                aVar = null;
                m35837a(aVar);
                return null;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo40142b(C8518z zVar) throws IOException {
        this.f28252b.mo40213c(m35836a(zVar.mo40645a()));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo40140a(C8362ab abVar, C8362ab abVar2) {
        C8397a aVar;
        C8376c cVar = new C8376c(abVar2);
        try {
            aVar = ((C8374b) abVar.mo40097h()).f28267a.mo40228a();
            if (aVar != null) {
                try {
                    cVar.mo40156a(aVar);
                    aVar.mo40223b();
                } catch (IOException unused) {
                }
            }
        } catch (IOException unused2) {
            aVar = null;
            m35837a(aVar);
        }
    }

    /* renamed from: a */
    private void m35837a(@Nullable C8397a aVar) {
        if (aVar != null) {
            try {
                aVar.mo40224c();
            } catch (IOException unused) {
            }
        }
    }

    public void flush() throws IOException {
        this.f28252b.flush();
    }

    public void close() throws IOException {
        this.f28252b.close();
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: a */
    public synchronized void mo40141a(C8392c cVar) {
        this.f28257g++;
        if (cVar.f28439a != null) {
            this.f28255e++;
        } else if (cVar.f28440b != null) {
            this.f28256f++;
        }
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: a */
    public synchronized void mo40139a() {
        this.f28256f++;
    }

    /* renamed from: a */
    static int m35835a(C8529e eVar) throws IOException {
        try {
            long n = eVar.mo40774n();
            String r = eVar.mo40778r();
            if (n >= 0 && n <= 2147483647L && r.isEmpty()) {
                return (int) n;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("expected an int but was \"");
            sb.append(n);
            sb.append(r);
            sb.append("\"");
            throw new IOException(sb.toString());
        } catch (NumberFormatException e) {
            throw new IOException(e.getMessage());
        }
    }
}
