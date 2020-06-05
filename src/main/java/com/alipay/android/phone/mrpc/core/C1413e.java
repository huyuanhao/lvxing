package com.alipay.android.phone.mrpc.core;

import org.apache.http.HttpResponse;
import org.apache.http.impl.client.DefaultRedirectHandler;
import org.apache.http.protocol.HttpContext;

/* renamed from: com.alipay.android.phone.mrpc.core.e */
final class C1413e extends DefaultRedirectHandler {
    /* renamed from: a */
    int f3624a;
    /* renamed from: b */
    final /* synthetic */ C1412d f3625b;

    C1413e(C1412d dVar) {
        this.f3625b = dVar;
    }

    public final boolean isRedirectRequested(HttpResponse httpResponse, HttpContext httpContext) {
        this.f3624a++;
        boolean isRedirectRequested = C1413e.super.isRedirectRequested(httpResponse, httpContext);
        if (!isRedirectRequested && this.f3624a < 5) {
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode == 301 || statusCode == 302) {
                return true;
            }
        }
        return isRedirectRequested;
    }
}
