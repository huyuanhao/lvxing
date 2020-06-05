package com.bytedance.sdk.p145a.p147b.p148a.p151c;

import com.bytedance.sdk.p145a.p147b.C1918ab;
import com.bytedance.sdk.p145a.p147b.Call;
import com.bytedance.sdk.p145a.p147b.Connection;
import com.bytedance.sdk.p145a.p147b.EventListener;
import com.bytedance.sdk.p145a.p147b.Interceptor;
import com.bytedance.sdk.p145a.p147b.Interceptor.C1939a;
import com.bytedance.sdk.p145a.p147b.Response;
import com.bytedance.sdk.p145a.p147b.p148a.p150b.RealConnection;
import com.bytedance.sdk.p145a.p147b.p148a.p150b.StreamAllocation;
import java.io.IOException;
import java.util.List;

/* renamed from: com.bytedance.sdk.a.b.a.c.g */
public final class RealInterceptorChain implements C1939a {
    /* renamed from: a */
    private final List<Interceptor> f5425a;
    /* renamed from: b */
    private final StreamAllocation f5426b;
    /* renamed from: c */
    private final HttpCodec f5427c;
    /* renamed from: d */
    private final RealConnection f5428d;
    /* renamed from: e */
    private final int f5429e;
    /* renamed from: f */
    private final C1918ab f5430f;
    /* renamed from: g */
    private final Call f5431g;
    /* renamed from: h */
    private final EventListener f5432h;
    /* renamed from: i */
    private final int f5433i;
    /* renamed from: j */
    private final int f5434j;
    /* renamed from: k */
    private final int f5435k;
    /* renamed from: l */
    private int f5436l;

    public RealInterceptorChain(List<Interceptor> list, StreamAllocation gVar, HttpCodec cVar, RealConnection cVar2, int i, C1918ab abVar, Call hVar, EventListener sVar, int i2, int i3, int i4) {
        this.f5425a = list;
        this.f5428d = cVar2;
        this.f5426b = gVar;
        this.f5427c = cVar;
        this.f5429e = i;
        this.f5430f = abVar;
        this.f5431g = hVar;
        this.f5432h = sVar;
        this.f5433i = i2;
        this.f5434j = i3;
        this.f5435k = i4;
    }

    /* renamed from: a */
    public Connection mo13735a() {
        return this.f5428d;
    }

    /* renamed from: b */
    public int mo13736b() {
        return this.f5433i;
    }

    /* renamed from: c */
    public int mo13737c() {
        return this.f5434j;
    }

    /* renamed from: d */
    public int mo13738d() {
        return this.f5435k;
    }

    /* renamed from: e */
    public StreamAllocation mo13739e() {
        return this.f5426b;
    }

    /* renamed from: f */
    public HttpCodec mo13740f() {
        return this.f5427c;
    }

    /* renamed from: g */
    public Call mo13741g() {
        return this.f5431g;
    }

    /* renamed from: h */
    public EventListener mo13742h() {
        return this.f5432h;
    }

    /* renamed from: i */
    public C1918ab mo13743i() {
        return this.f5430f;
    }

    /* renamed from: a */
    public Response mo13733a(C1918ab abVar) throws IOException {
        return mo13734a(abVar, this.f5426b, this.f5427c, this.f5428d);
    }

    /* renamed from: a */
    public Response mo13734a(C1918ab abVar, StreamAllocation gVar, HttpCodec cVar, RealConnection cVar2) throws IOException {
        if (this.f5429e < this.f5425a.size()) {
            this.f5436l++;
            String str = "network interceptor ";
            if (this.f5427c == null || this.f5428d.mo13694a(abVar.mo13910a())) {
                String str2 = " must call proceed() exactly once";
                if (this.f5427c == null || this.f5436l <= 1) {
                    RealInterceptorChain gVar2 = new RealInterceptorChain(this.f5425a, gVar, cVar, cVar2, this.f5429e + 1, abVar, this.f5431g, this.f5432h, this.f5433i, this.f5434j, this.f5435k);
                    Interceptor xVar = (Interceptor) this.f5425a.get(this.f5429e);
                    Response a = xVar.mo13664a(gVar2);
                    if (cVar == null || this.f5429e + 1 >= this.f5425a.size() || gVar2.f5436l == 1) {
                        String str3 = "interceptor ";
                        if (a == null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(str3);
                            sb.append(xVar);
                            sb.append(" returned null");
                            throw new NullPointerException(sb.toString());
                        } else if (a.mo13946g() != null) {
                            return a;
                        } else {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(str3);
                            sb2.append(xVar);
                            sb2.append(" returned a response with no body");
                            throw new IllegalStateException(sb2.toString());
                        }
                    } else {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(str);
                        sb3.append(xVar);
                        sb3.append(str2);
                        throw new IllegalStateException(sb3.toString());
                    }
                } else {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(str);
                    sb4.append(this.f5425a.get(this.f5429e - 1));
                    sb4.append(str2);
                    throw new IllegalStateException(sb4.toString());
                }
            } else {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str);
                sb5.append(this.f5425a.get(this.f5429e - 1));
                sb5.append(" must retain the same host and port");
                throw new IllegalStateException(sb5.toString());
            }
        } else {
            throw new AssertionError();
        }
    }
}
