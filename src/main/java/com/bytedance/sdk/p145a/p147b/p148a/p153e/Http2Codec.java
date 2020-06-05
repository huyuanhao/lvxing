package com.bytedance.sdk.p145a.p147b.p148a.p153e;

import com.bytedance.sdk.p145a.p146a.Buffer;
import com.bytedance.sdk.p145a.p146a.ByteString;
import com.bytedance.sdk.p145a.p146a.ForwardingSource;
import com.bytedance.sdk.p145a.p146a.Okio;
import com.bytedance.sdk.p145a.p146a.Sink;
import com.bytedance.sdk.p145a.p146a.Source;
import com.bytedance.sdk.p145a.p147b.C1918ab;
import com.bytedance.sdk.p145a.p147b.C1935u;
import com.bytedance.sdk.p145a.p147b.C1935u.C1936a;
import com.bytedance.sdk.p145a.p147b.Interceptor.C1939a;
import com.bytedance.sdk.p145a.p147b.OkHttpClient;
import com.bytedance.sdk.p145a.p147b.Protocol;
import com.bytedance.sdk.p145a.p147b.Response;
import com.bytedance.sdk.p145a.p147b.Response.C1921a;
import com.bytedance.sdk.p145a.p147b.ResponseBody;
import com.bytedance.sdk.p145a.p147b.p148a.C1876c;
import com.bytedance.sdk.p145a.p147b.p148a.Internal;
import com.bytedance.sdk.p145a.p147b.p148a.p150b.StreamAllocation;
import com.bytedance.sdk.p145a.p147b.p148a.p151c.HttpCodec;
import com.bytedance.sdk.p145a.p147b.p148a.p151c.HttpHeaders;
import com.bytedance.sdk.p145a.p147b.p148a.p151c.RealResponseBody;
import com.bytedance.sdk.p145a.p147b.p148a.p151c.RequestLine;
import com.bytedance.sdk.p145a.p147b.p148a.p151c.StatusLine;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* renamed from: com.bytedance.sdk.a.b.a.e.f */
public final class Http2Codec implements HttpCodec {
    /* renamed from: b */
    private static final ByteString f5514b = ByteString.m6702a("connection");
    /* renamed from: c */
    private static final ByteString f5515c = ByteString.m6702a("host");
    /* renamed from: d */
    private static final ByteString f5516d = ByteString.m6702a("keep-alive");
    /* renamed from: e */
    private static final ByteString f5517e = ByteString.m6702a("proxy-connection");
    /* renamed from: f */
    private static final ByteString f5518f = ByteString.m6702a("transfer-encoding");
    /* renamed from: g */
    private static final ByteString f5519g = ByteString.m6702a("te");
    /* renamed from: h */
    private static final ByteString f5520h = ByteString.m6702a("encoding");
    /* renamed from: i */
    private static final ByteString f5521i = ByteString.m6702a("upgrade");
    /* renamed from: j */
    private static final List<ByteString> f5522j = C1876c.m6958a((T[]) new ByteString[]{f5514b, f5515c, f5516d, f5517e, f5519g, f5518f, f5520h, f5521i, Header.f5483c, Header.f5484d, Header.f5485e, Header.f5486f});
    /* renamed from: k */
    private static final List<ByteString> f5523k = C1876c.m6958a((T[]) new ByteString[]{f5514b, f5515c, f5516d, f5517e, f5519g, f5518f, f5520h, f5521i});
    /* renamed from: a */
    final StreamAllocation f5524a;
    /* renamed from: l */
    private final OkHttpClient f5525l;
    /* renamed from: m */
    private final C1939a f5526m;
    /* renamed from: n */
    private final Http2Connection f5527n;
    /* renamed from: o */
    private Http2Stream f5528o;

    /* compiled from: Http2Codec */
    /* renamed from: com.bytedance.sdk.a.b.a.e.f$a */
    class C1890a extends ForwardingSource {
        /* renamed from: a */
        boolean f5529a = false;
        /* renamed from: b */
        long f5530b = 0;

        C1890a(Source sVar) {
            super(sVar);
        }

        /* renamed from: a */
        public long mo13511a(Buffer cVar, long j) throws IOException {
            try {
                long a = mo13605b().mo13511a(cVar, j);
                if (a > 0) {
                    this.f5530b += a;
                }
                return a;
            } catch (IOException e) {
                m7097a(e);
                throw e;
            }
        }

        public void close() throws IOException {
            super.close();
            m7097a(null);
        }

        /* renamed from: a */
        private void m7097a(IOException iOException) {
            if (!this.f5529a) {
                this.f5529a = true;
                Http2Codec.this.f5524a.mo13716a(false, (HttpCodec) Http2Codec.this, this.f5530b, iOException);
            }
        }
    }

    public Http2Codec(OkHttpClient zVar, C1939a aVar, StreamAllocation gVar, Http2Connection gVar2) {
        this.f5525l = zVar;
        this.f5526m = aVar;
        this.f5524a = gVar;
        this.f5527n = gVar2;
    }

    /* renamed from: a */
    public Sink mo13725a(C1918ab abVar, long j) {
        return this.f5528o.mo13822h();
    }

    /* renamed from: a */
    public void mo13729a(C1918ab abVar) throws IOException {
        if (this.f5528o == null) {
            this.f5528o = this.f5527n.mo13771a(m7090b(abVar), abVar.mo13914d() != null);
            this.f5528o.mo13819e().mo13610a((long) this.f5526m.mo13737c(), TimeUnit.MILLISECONDS);
            this.f5528o.mo13820f().mo13610a((long) this.f5526m.mo13738d(), TimeUnit.MILLISECONDS);
        }
    }

    /* renamed from: a */
    public void mo13728a() throws IOException {
        this.f5527n.mo13784b();
    }

    /* renamed from: b */
    public void mo13730b() throws IOException {
        this.f5528o.mo13822h().close();
    }

    /* renamed from: a */
    public C1921a mo13726a(boolean z) throws IOException {
        C1921a a = m7089a(this.f5528o.mo13818d());
        if (!z || Internal.f5302a.mo13654a(a) != 100) {
            return a;
        }
        return null;
    }

    /* renamed from: b */
    public static List<Header> m7090b(C1918ab abVar) {
        C1935u c = abVar.mo13913c();
        ArrayList arrayList = new ArrayList(c.mo14069a() + 4);
        arrayList.add(new Header(Header.f5483c, abVar.mo13912b()));
        arrayList.add(new Header(Header.f5484d, RequestLine.m7018a(abVar.mo13910a())));
        String a = abVar.mo13911a("Host");
        if (a != null) {
            arrayList.add(new Header(Header.f5486f, a));
        }
        arrayList.add(new Header(Header.f5485e, abVar.mo13910a().mo14085b()));
        int a2 = c.mo14069a();
        for (int i = 0; i < a2; i++) {
            ByteString a3 = ByteString.m6702a(c.mo14070a(i).toLowerCase(Locale.US));
            if (!f5522j.contains(a3)) {
                arrayList.add(new Header(a3, c.mo14073b(i)));
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static C1921a m7089a(List<Header> list) throws IOException {
        C1936a aVar = new C1936a();
        int size = list.size();
        C1936a aVar2 = aVar;
        StatusLine kVar = null;
        for (int i = 0; i < size; i++) {
            Header cVar = (Header) list.get(i);
            if (cVar != null) {
                ByteString fVar = cVar.f5487g;
                String a = cVar.f5488h.mo13587a();
                if (fVar.equals(Header.f5482b)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("HTTP/1.1 ");
                    sb.append(a);
                    kVar = StatusLine.m7029a(sb.toString());
                } else if (!f5523k.contains(fVar)) {
                    Internal.f5302a.mo13661a(aVar2, fVar.mo13587a(), a);
                }
            } else if (kVar != null && kVar.f5446b == 100) {
                aVar2 = new C1936a();
                kVar = null;
            }
        }
        if (kVar != null) {
            return new C1921a().mo13960a(Protocol.HTTP_2).mo13953a(kVar.f5446b).mo13961a(kVar.f5447c).mo13959a(aVar2.mo14080a());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    /* renamed from: a */
    public ResponseBody mo13727a(Response bVar) throws IOException {
        this.f5524a.f5385c.mo14062f(this.f5524a.f5384b);
        return new RealResponseBody(bVar.mo13938a("Content-Type"), HttpHeaders.m6993a(bVar), Okio.m6747a((Source) new C1890a(this.f5528o.mo13821g())));
    }
}
