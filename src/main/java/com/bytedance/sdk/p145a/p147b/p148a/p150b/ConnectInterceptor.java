package com.bytedance.sdk.p145a.p147b.p148a.p150b;

import com.bytedance.sdk.p145a.p147b.C1918ab;
import com.bytedance.sdk.p145a.p147b.Interceptor;
import com.bytedance.sdk.p145a.p147b.Interceptor.C1939a;
import com.bytedance.sdk.p145a.p147b.OkHttpClient;
import com.bytedance.sdk.p145a.p147b.Response;
import com.bytedance.sdk.p145a.p147b.p148a.p151c.RealInterceptorChain;
import java.io.IOException;

/* renamed from: com.bytedance.sdk.a.b.a.b.a */
public final class ConnectInterceptor implements Interceptor {
    /* renamed from: a */
    public final OkHttpClient f5350a;

    public ConnectInterceptor(OkHttpClient zVar) {
        this.f5350a = zVar;
    }

    /* renamed from: a */
    public Response mo13664a(C1939a aVar) throws IOException {
        RealInterceptorChain gVar = (RealInterceptorChain) aVar;
        C1918ab i = gVar.mo13743i();
        StreamAllocation e = gVar.mo13739e();
        return gVar.mo13734a(i, e, e.mo13712a(this.f5350a, aVar, !i.mo13912b().equals("GET")), e.mo13717b());
    }
}
