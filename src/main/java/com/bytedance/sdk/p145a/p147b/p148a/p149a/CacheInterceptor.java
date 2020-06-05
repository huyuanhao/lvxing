package com.bytedance.sdk.p145a.p147b.p148a.p149a;

import com.bytedance.sdk.p145a.p146a.Buffer;
import com.bytedance.sdk.p145a.p146a.BufferedSink;
import com.bytedance.sdk.p145a.p146a.BufferedSource;
import com.bytedance.sdk.p145a.p146a.Okio;
import com.bytedance.sdk.p145a.p146a.Sink;
import com.bytedance.sdk.p145a.p146a.Source;
import com.bytedance.sdk.p145a.p146a.Timeout;
import com.bytedance.sdk.p145a.p147b.C1918ab;
import com.bytedance.sdk.p145a.p147b.C1935u;
import com.bytedance.sdk.p145a.p147b.C1935u.C1936a;
import com.bytedance.sdk.p145a.p147b.Interceptor;
import com.bytedance.sdk.p145a.p147b.Interceptor.C1939a;
import com.bytedance.sdk.p145a.p147b.Protocol;
import com.bytedance.sdk.p145a.p147b.Response;
import com.bytedance.sdk.p145a.p147b.Response.C1921a;
import com.bytedance.sdk.p145a.p147b.ResponseBody;
import com.bytedance.sdk.p145a.p147b.p148a.C1876c;
import com.bytedance.sdk.p145a.p147b.p148a.Internal;
import com.bytedance.sdk.p145a.p147b.p148a.p149a.CacheStrategy.C1870a;
import com.bytedance.sdk.p145a.p147b.p148a.p151c.HttpHeaders;
import com.bytedance.sdk.p145a.p147b.p148a.p151c.HttpMethod;
import com.bytedance.sdk.p145a.p147b.p148a.p151c.RealResponseBody;
import com.tencent.p605ep.commonbase.network.HttpStatus;
import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* renamed from: com.bytedance.sdk.a.b.a.a.a */
public final class CacheInterceptor implements Interceptor {
    /* renamed from: a */
    final InternalCache f5303a;

    public CacheInterceptor(InternalCache eVar) {
        this.f5303a = eVar;
    }

    /* renamed from: a */
    public Response mo13664a(C1939a aVar) throws IOException {
        InternalCache eVar = this.f5303a;
        Response a = eVar != null ? eVar.mo13679a(aVar.mo13743i()) : null;
        CacheStrategy a2 = new C1870a(System.currentTimeMillis(), aVar.mo13743i(), a).mo13667a();
        C1918ab abVar = a2.f5309a;
        Response bVar = a2.f5310b;
        InternalCache eVar2 = this.f5303a;
        if (eVar2 != null) {
            eVar2.mo13681a(a2);
        }
        if (a != null && bVar == null) {
            C1876c.m6961a((Closeable) a.mo13946g());
        }
        if (abVar == null && bVar == null) {
            return new C1921a().mo13955a(aVar.mo13743i()).mo13960a(Protocol.HTTP_1_1).mo13953a((int) HttpStatus.SC_GATEWAY_TIMEOUT).mo13961a("Unsatisfiable Request (only-if-cached)").mo13957a(C1876c.f5400c).mo13954a(-1).mo13964b(System.currentTimeMillis()).mo13963a();
        }
        if (abVar == null) {
            return bVar.mo13947h().mo13965b(m6861a(bVar)).mo13963a();
        }
        try {
            Response a3 = aVar.mo13733a(abVar);
            if (a3 == null && a != null) {
            }
            if (bVar != null) {
                if (a3.mo13941c() == 304) {
                    Response a4 = bVar.mo13947h().mo13959a(m6862a(bVar.mo13945f(), a3.mo13945f())).mo13954a(a3.mo13950k()).mo13964b(a3.mo13951l()).mo13965b(m6861a(bVar)).mo13956a(m6861a(a3)).mo13963a();
                    a3.mo13946g().close();
                    this.f5303a.mo13680a();
                    this.f5303a.mo13682a(bVar, a4);
                    return a4;
                }
                C1876c.m6961a((Closeable) bVar.mo13946g());
            }
            Response a5 = a3.mo13947h().mo13965b(m6861a(bVar)).mo13956a(m6861a(a3)).mo13963a();
            if (this.f5303a != null) {
                if (HttpHeaders.m6998b(a5) && CacheStrategy.m6869a(a5, abVar)) {
                    return m6860a(this.f5303a.mo13678a(a5), a5);
                }
                if (HttpMethod.m6999a(abVar.mo13912b())) {
                    try {
                        this.f5303a.mo13683b(abVar);
                    } catch (IOException unused) {
                    }
                }
            }
            return a5;
        } finally {
            if (a != null) {
                C1876c.m6961a((Closeable) a.mo13946g());
            }
        }
    }

    /* renamed from: a */
    private static Response m6861a(Response bVar) {
        return (bVar == null || bVar.mo13946g() == null) ? bVar : bVar.mo13947h().mo13957a((ResponseBody) null).mo13963a();
    }

    /* renamed from: a */
    private Response m6860a(final CacheRequest bVar, Response bVar2) throws IOException {
        if (bVar == null) {
            return bVar2;
        }
        Sink a = bVar.mo13665a();
        if (a == null) {
            return bVar2;
        }
        final BufferedSource b = bVar2.mo13946g().mo13745b();
        final BufferedSink a2 = Okio.m6746a(a);
        C18691 r2 = new Source() {
            /* renamed from: a */
            boolean f5304a;

            /* renamed from: a */
            public long mo13511a(Buffer cVar, long j) throws IOException {
                try {
                    long a = b.mo13511a(cVar, j);
                    if (a == -1) {
                        if (!this.f5304a) {
                            this.f5304a = true;
                            a2.close();
                        }
                        return -1;
                    }
                    cVar.mo13521a(a2.mo13535c(), cVar.mo13530b() - a, a);
                    a2.mo13578u();
                    return a;
                } catch (IOException e) {
                    if (!this.f5304a) {
                        this.f5304a = true;
                        bVar.mo13666b();
                    }
                    throw e;
                }
            }

            /* renamed from: a */
            public Timeout mo13512a() {
                return b.mo13512a();
            }

            public void close() throws IOException {
                if (!this.f5304a && !C1876c.m6963a((Source) this, 100, TimeUnit.MILLISECONDS)) {
                    this.f5304a = true;
                    bVar.mo13666b();
                }
                b.close();
            }
        };
        return bVar2.mo13947h().mo13957a((ResponseBody) new RealResponseBody(bVar2.mo13938a("Content-Type"), bVar2.mo13946g().mo13744a(), Okio.m6747a((Source) r2))).mo13963a();
    }

    /* renamed from: a */
    private static C1935u m6862a(C1935u uVar, C1935u uVar2) {
        C1936a aVar = new C1936a();
        int a = uVar.mo14069a();
        for (int i = 0; i < a; i++) {
            String a2 = uVar.mo14070a(i);
            String b = uVar.mo14073b(i);
            if ((!"Warning".equalsIgnoreCase(a2) || !b.startsWith("1")) && (!m6863a(a2) || uVar2.mo14071a(a2) == null)) {
                Internal.f5302a.mo13661a(aVar, a2, b);
            }
        }
        int a3 = uVar2.mo14069a();
        for (int i2 = 0; i2 < a3; i2++) {
            String a4 = uVar2.mo14070a(i2);
            if (!"Content-Length".equalsIgnoreCase(a4) && m6863a(a4)) {
                Internal.f5302a.mo13661a(aVar, a4, uVar2.mo14073b(i2));
            }
        }
        return aVar.mo14080a();
    }

    /* renamed from: a */
    static boolean m6863a(String str) {
        return !"Connection".equalsIgnoreCase(str) && !"Keep-Alive".equalsIgnoreCase(str) && !"Proxy-Authenticate".equalsIgnoreCase(str) && !"Proxy-Authorization".equalsIgnoreCase(str) && !"TE".equalsIgnoreCase(str) && !"Trailers".equalsIgnoreCase(str) && !"Transfer-Encoding".equalsIgnoreCase(str) && !"Upgrade".equalsIgnoreCase(str);
    }
}
