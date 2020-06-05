package com.kwad.sdk.core.videocache;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.kwad.sdk.core.videocache.i */
class C4361i extends ProxySelector {
    /* renamed from: a */
    private static final List<Proxy> f14295a = Arrays.asList(new Proxy[]{Proxy.NO_PROXY});
    /* renamed from: b */
    private final ProxySelector f14296b;
    /* renamed from: c */
    private final String f14297c;
    /* renamed from: d */
    private final int f14298d;

    C4361i(ProxySelector proxySelector, String str, int i) {
        this.f14296b = (ProxySelector) C4362j.m17805a(proxySelector);
        this.f14297c = (String) C4362j.m17805a(str);
        this.f14298d = i;
    }

    /* renamed from: a */
    static void m17804a(String str, int i) {
        ProxySelector.setDefault(new C4361i(ProxySelector.getDefault(), str, i));
    }

    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.f14296b.connectFailed(uri, socketAddress, iOException);
    }

    public List<Proxy> select(URI uri) {
        boolean z = this.f14297c.equals(uri.getHost()) && this.f14298d == uri.getPort();
        return z ? f14295a : this.f14296b.select(uri);
    }
}
