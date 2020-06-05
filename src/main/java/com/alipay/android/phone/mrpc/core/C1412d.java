package com.alipay.android.phone.mrpc.core;

import org.apache.http.client.RedirectHandler;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.BasicHttpProcessor;
import org.apache.http.protocol.HttpContext;

/* renamed from: com.alipay.android.phone.mrpc.core.d */
final class C1412d extends DefaultHttpClient {
    /* renamed from: a */
    final /* synthetic */ C1408b f3623a;

    C1412d(C1408b bVar, ClientConnectionManager clientConnectionManager, HttpParams httpParams) {
        this.f3623a = bVar;
        super(clientConnectionManager, httpParams);
    }

    /* access modifiers changed from: protected|final */
    public final ConnectionKeepAliveStrategy createConnectionKeepAliveStrategy() {
        return new C1414f(this);
    }

    /* access modifiers changed from: protected|final */
    public final HttpContext createHttpContext() {
        BasicHttpContext basicHttpContext = new BasicHttpContext();
        basicHttpContext.setAttribute("http.authscheme-registry", getAuthSchemes());
        basicHttpContext.setAttribute("http.cookiespec-registry", getCookieSpecs());
        basicHttpContext.setAttribute("http.auth.credentials-provider", getCredentialsProvider());
        return basicHttpContext;
    }

    /* access modifiers changed from: protected|final */
    public final BasicHttpProcessor createHttpProcessor() {
        BasicHttpProcessor createHttpProcessor = C1412d.super.createHttpProcessor();
        createHttpProcessor.addRequestInterceptor(C1408b.f3616c);
        createHttpProcessor.addRequestInterceptor(new C1409a(this.f3623a, 0));
        return createHttpProcessor;
    }

    /* access modifiers changed from: protected|final */
    public final RedirectHandler createRedirectHandler() {
        return new C1413e(this);
    }
}
