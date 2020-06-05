package com.alipay.android.phone.mrpc.core;

import org.apache.http.HttpResponse;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.protocol.HttpContext;

/* renamed from: com.alipay.android.phone.mrpc.core.f */
final class C1414f implements ConnectionKeepAliveStrategy {
    /* renamed from: a */
    final /* synthetic */ C1412d f3626a;

    C1414f(C1412d dVar) {
        this.f3626a = dVar;
    }

    public final long getKeepAliveDuration(HttpResponse httpResponse, HttpContext httpContext) {
        return 180000;
    }
}
