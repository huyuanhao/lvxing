package com.bytedance.sdk.p145a.p147b.p148a.p151c;

import com.bytedance.sdk.p145a.p146a.Buffer;
import com.bytedance.sdk.p145a.p146a.BufferedSink;
import com.bytedance.sdk.p145a.p146a.ForwardingSink;
import com.bytedance.sdk.p145a.p146a.Okio;
import com.bytedance.sdk.p145a.p146a.Sink;
import com.bytedance.sdk.p145a.p147b.C1918ab;
import com.bytedance.sdk.p145a.p147b.Interceptor;
import com.bytedance.sdk.p145a.p147b.Interceptor.C1939a;
import com.bytedance.sdk.p145a.p147b.Response;
import com.bytedance.sdk.p145a.p147b.Response.C1921a;
import com.bytedance.sdk.p145a.p147b.p148a.C1876c;
import com.bytedance.sdk.p145a.p147b.p148a.p150b.RealConnection;
import com.bytedance.sdk.p145a.p147b.p148a.p150b.StreamAllocation;
import java.io.IOException;
import java.net.ProtocolException;

/* renamed from: com.bytedance.sdk.a.b.a.c.b */
public final class CallServerInterceptor implements Interceptor {
    /* renamed from: a */
    private final boolean f5419a;

    /* compiled from: CallServerInterceptor */
    /* renamed from: com.bytedance.sdk.a.b.a.c.b$a */
    static final class C1879a extends ForwardingSink {
        /* renamed from: a */
        long f5420a;

        C1879a(Sink rVar) {
            super(rVar);
        }

        /* renamed from: a_ */
        public void mo13507a_(Buffer cVar, long j) throws IOException {
            super.mo13507a_(cVar, j);
            this.f5420a += j;
        }
    }

    public CallServerInterceptor(boolean z) {
        this.f5419a = z;
    }

    /* renamed from: a */
    public Response mo13664a(C1939a aVar) throws IOException {
        Response bVar;
        RealInterceptorChain gVar = (RealInterceptorChain) aVar;
        HttpCodec f = gVar.mo13740f();
        StreamAllocation e = gVar.mo13739e();
        RealConnection cVar = (RealConnection) gVar.mo13735a();
        C1918ab i = gVar.mo13743i();
        long currentTimeMillis = System.currentTimeMillis();
        gVar.mo13742h().mo14059c(gVar.mo13741g());
        f.mo13729a(i);
        gVar.mo13742h().mo14046a(gVar.mo13741g(), i);
        C1921a aVar2 = null;
        if (HttpMethod.m7001c(i.mo13912b()) && i.mo13914d() != null) {
            if ("100-continue".equalsIgnoreCase(i.mo13911a("Expect"))) {
                f.mo13728a();
                gVar.mo13742h().mo14061e(gVar.mo13741g());
                aVar2 = f.mo13726a(true);
            }
            if (aVar2 == null) {
                gVar.mo13742h().mo14060d(gVar.mo13741g());
                C1879a aVar3 = new C1879a(f.mo13725a(i, i.mo13914d().mo13936b()));
                BufferedSink a = Okio.m6746a((Sink) aVar3);
                i.mo13914d().mo13935a(a);
                a.close();
                gVar.mo13742h().mo14045a(gVar.mo13741g(), aVar3.f5420a);
            } else if (!cVar.mo13698d()) {
                e.mo13719d();
            }
        }
        f.mo13730b();
        if (aVar2 == null) {
            gVar.mo13742h().mo14061e(gVar.mo13741g());
            aVar2 = f.mo13726a(false);
        }
        Response a2 = aVar2.mo13955a(i).mo13958a(e.mo13717b().mo13697c()).mo13954a(currentTimeMillis).mo13964b(System.currentTimeMillis()).mo13963a();
        gVar.mo13742h().mo14047a(gVar.mo13741g(), a2);
        int c = a2.mo13941c();
        if (!this.f5419a || c != 101) {
            bVar = a2.mo13947h().mo13957a(f.mo13727a(a2)).mo13963a();
        } else {
            bVar = a2.mo13947h().mo13957a(C1876c.f5400c).mo13963a();
        }
        String str = "Connection";
        String str2 = "close";
        if (str2.equalsIgnoreCase(bVar.mo13937a().mo13911a(str)) || str2.equalsIgnoreCase(bVar.mo13938a(str))) {
            e.mo13719d();
        }
        if ((c != 204 && c != 205) || bVar.mo13946g().mo13744a() <= 0) {
            return bVar;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("HTTP ");
        sb.append(c);
        sb.append(" had non-zero Content-Length: ");
        sb.append(bVar.mo13946g().mo13744a());
        throw new ProtocolException(sb.toString());
    }
}
