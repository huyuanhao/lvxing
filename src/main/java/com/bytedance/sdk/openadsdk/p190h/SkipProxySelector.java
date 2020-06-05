package com.bytedance.sdk.openadsdk.p190h;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Collections;
import java.util.List;

/* renamed from: com.bytedance.sdk.openadsdk.h.j */
class SkipProxySelector extends ProxySelector {
    /* renamed from: a */
    private static final List<Proxy> f8936a = Collections.singletonList(Proxy.NO_PROXY);
    /* renamed from: b */
    private final ProxySelector f8937b = ProxySelector.getDefault();
    /* renamed from: c */
    private final String f8938c;
    /* renamed from: d */
    private final int f8939d;

    private SkipProxySelector(String str, int i) {
        this.f8938c = str;
        this.f8939d = i;
    }

    public List<Proxy> select(URI uri) {
        if (uri != null) {
            return (!this.f8938c.equalsIgnoreCase(uri.getHost()) || this.f8939d != uri.getPort()) ? this.f8937b.select(uri) : f8936a;
        }
        throw new IllegalArgumentException("URI can't be null");
    }

    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.f8937b.connectFailed(uri, socketAddress, iOException);
    }

    /* renamed from: a */
    static void m11685a(String str, int i) {
        ProxySelector.setDefault(new SkipProxySelector(str, i));
    }
}
