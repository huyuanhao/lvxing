package okhttp3.internal.http2;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.C8362ab;
import okhttp3.C8362ab.C8363a;
import okhttp3.C8364ac;
import okhttp3.C8504s;
import okhttp3.C8504s.C8505a;
import okhttp3.C8508u.C8509a;
import okhttp3.C8513x;
import okhttp3.C8518z;
import okhttp3.Protocol;
import okhttp3.internal.C8388a;
import okhttp3.internal.C8417c;
import okhttp3.internal.connection.C8434f;
import okhttp3.internal.p698b.C8406c;
import okhttp3.internal.p698b.C8409e;
import okhttp3.internal.p698b.C8412h;
import okhttp3.internal.p698b.C8413i;
import okhttp3.internal.p698b.C8415k;
import okio.ByteString;
import okio.C8525c;
import okio.C8531g;
import okio.C8535k;
import okio.C8546q;
import okio.C8547r;

/* compiled from: Http2Codec */
/* renamed from: okhttp3.internal.http2.d */
public final class C8458d implements C8406c {
    /* renamed from: b */
    private static final ByteString f28685b = ByteString.encodeUtf8("connection");
    /* renamed from: c */
    private static final ByteString f28686c = ByteString.encodeUtf8("host");
    /* renamed from: d */
    private static final ByteString f28687d = ByteString.encodeUtf8("keep-alive");
    /* renamed from: e */
    private static final ByteString f28688e = ByteString.encodeUtf8("proxy-connection");
    /* renamed from: f */
    private static final ByteString f28689f = ByteString.encodeUtf8("transfer-encoding");
    /* renamed from: g */
    private static final ByteString f28690g = ByteString.encodeUtf8("te");
    /* renamed from: h */
    private static final ByteString f28691h = ByteString.encodeUtf8("encoding");
    /* renamed from: i */
    private static final ByteString f28692i = ByteString.encodeUtf8("upgrade");
    /* renamed from: j */
    private static final List<ByteString> f28693j = C8417c.m36035a((T[]) new ByteString[]{f28685b, f28686c, f28687d, f28688e, f28690g, f28689f, f28691h, f28692i, C8453a.f28654c, C8453a.f28655d, C8453a.f28656e, C8453a.f28657f});
    /* renamed from: k */
    private static final List<ByteString> f28694k = C8417c.m36035a((T[]) new ByteString[]{f28685b, f28686c, f28687d, f28688e, f28690g, f28689f, f28691h, f28692i});
    /* renamed from: a */
    final C8434f f28695a;
    /* renamed from: l */
    private final C8509a f28696l;
    /* renamed from: m */
    private final C8460e f28697m;
    /* renamed from: n */
    private C8478g f28698n;
    /* renamed from: o */
    private final Protocol f28699o;

    /* compiled from: Http2Codec */
    /* renamed from: okhttp3.internal.http2.d$a */
    class C8459a extends C8531g {
        /* renamed from: a */
        boolean f28700a = false;
        /* renamed from: b */
        long f28701b = 0;

        C8459a(C8547r rVar) {
            super(rVar);
        }

        /* renamed from: a */
        public long mo40202a(C8525c cVar, long j) throws IOException {
            try {
                long a = mo40799b().mo40202a(cVar, j);
                if (a > 0) {
                    this.f28701b += a;
                }
                return a;
            } catch (IOException e) {
                m36265a(e);
                throw e;
            }
        }

        public void close() throws IOException {
            super.close();
            m36265a(null);
        }

        /* renamed from: a */
        private void m36265a(IOException iOException) {
            if (!this.f28700a) {
                this.f28700a = true;
                C8458d.this.f28695a.mo40304a(false, C8458d.this, this.f28701b, iOException);
            }
        }
    }

    public C8458d(C8513x xVar, C8509a aVar, C8434f fVar, C8460e eVar) {
        Protocol protocol;
        this.f28696l = aVar;
        this.f28695a = fVar;
        this.f28697m = eVar;
        if (xVar.mo40617u().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
            protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        } else {
            protocol = Protocol.HTTP_2;
        }
        this.f28699o = protocol;
    }

    /* renamed from: a */
    public C8546q mo40237a(C8518z zVar, long j) {
        return this.f28698n.mo40417h();
    }

    /* renamed from: a */
    public void mo40239a(C8518z zVar) throws IOException {
        if (this.f28698n == null) {
            this.f28698n = this.f28697m.mo40367a(m36257b(zVar), zVar.mo40649d() != null);
            this.f28698n.mo40414e().mo40804a((long) this.f28696l.mo40248c(), TimeUnit.MILLISECONDS);
            this.f28698n.mo40415f().mo40804a((long) this.f28696l.mo40249d(), TimeUnit.MILLISECONDS);
        }
    }

    /* renamed from: a */
    public void mo40238a() throws IOException {
        this.f28697m.mo40380b();
    }

    /* renamed from: b */
    public void mo40240b() throws IOException {
        this.f28698n.mo40417h().close();
    }

    /* renamed from: a */
    public C8363a mo40235a(boolean z) throws IOException {
        C8363a a = m36256a(this.f28698n.mo40413d(), this.f28699o);
        if (!z || C8388a.f28432a.mo40192a(a) != 100) {
            return a;
        }
        return null;
    }

    /* renamed from: b */
    public static List<C8453a> m36257b(C8518z zVar) {
        C8504s c = zVar.mo40648c();
        ArrayList arrayList = new ArrayList(c.mo40531a() + 4);
        arrayList.add(new C8453a(C8453a.f28654c, zVar.mo40646b()));
        arrayList.add(new C8453a(C8453a.f28655d, C8413i.m36009a(zVar.mo40645a())));
        String a = zVar.mo40644a("Host");
        if (a != null) {
            arrayList.add(new C8453a(C8453a.f28657f, a));
        }
        arrayList.add(new C8453a(C8453a.f28656e, zVar.mo40645a().mo40549b()));
        int a2 = c.mo40531a();
        for (int i = 0; i < a2; i++) {
            ByteString encodeUtf8 = ByteString.encodeUtf8(c.mo40532a(i).toLowerCase(Locale.US));
            if (!f28693j.contains(encodeUtf8)) {
                arrayList.add(new C8453a(encodeUtf8, c.mo40534b(i)));
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static C8363a m36256a(List<C8453a> list, Protocol protocol) throws IOException {
        C8505a aVar = new C8505a();
        int size = list.size();
        C8505a aVar2 = aVar;
        C8415k kVar = null;
        for (int i = 0; i < size; i++) {
            C8453a aVar3 = (C8453a) list.get(i);
            if (aVar3 != null) {
                ByteString byteString = aVar3.f28658g;
                String utf8 = aVar3.f28659h.utf8();
                if (byteString.equals(C8453a.f28653b)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("HTTP/1.1 ");
                    sb.append(utf8);
                    kVar = C8415k.m36021a(sb.toString());
                } else if (!f28694k.contains(byteString)) {
                    C8388a.f28432a.mo40198a(aVar2, byteString.utf8(), utf8);
                }
            } else if (kVar != null && kVar.f28526b == 100) {
                aVar2 = new C8505a();
                kVar = null;
            }
        }
        if (kVar != null) {
            return new C8363a().mo40109a(protocol).mo40105a(kVar.f28526b).mo40107a(kVar.f28527c).mo40113a(aVar2.mo40543a());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    /* renamed from: a */
    public C8364ac mo40236a(C8362ab abVar) throws IOException {
        this.f28695a.f28607c.mo40514f(this.f28695a.f28606b);
        return new C8412h(abVar.mo40089b("Content-Type"), C8409e.m35978a(abVar), C8535k.m36849a((C8547r) new C8459a(this.f28698n.mo40416g())));
    }

    /* renamed from: c */
    public void mo40241c() {
        C8478g gVar = this.f28698n;
        if (gVar != null) {
            gVar.mo40409b(ErrorCode.CANCEL);
        }
    }
}
