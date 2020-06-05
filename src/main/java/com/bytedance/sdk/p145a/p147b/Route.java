package com.bytedance.sdk.p145a.p147b;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;

/* renamed from: com.bytedance.sdk.a.b.d */
public final class Route {
    /* renamed from: a */
    final Address f5758a;
    /* renamed from: b */
    final Proxy f5759b;
    /* renamed from: c */
    final InetSocketAddress f5760c;

    public Route(Address aVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (aVar == null) {
            throw new NullPointerException("address == null");
        } else if (proxy == null) {
            throw new NullPointerException("proxy == null");
        } else if (inetSocketAddress != null) {
            this.f5758a = aVar;
            this.f5759b = proxy;
            this.f5760c = inetSocketAddress;
        } else {
            throw new NullPointerException("inetSocketAddress == null");
        }
    }

    /* renamed from: a */
    public Address mo13969a() {
        return this.f5758a;
    }

    /* renamed from: b */
    public Proxy mo13970b() {
        return this.f5759b;
    }

    /* renamed from: c */
    public InetSocketAddress mo13971c() {
        return this.f5760c;
    }

    /* renamed from: d */
    public boolean mo13972d() {
        return this.f5758a.f5299i != null && this.f5759b.type() == Type.HTTP;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Route) {
            Route dVar = (Route) obj;
            if (dVar.f5758a.equals(this.f5758a) && dVar.f5759b.equals(this.f5759b) && dVar.f5760c.equals(this.f5760c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + this.f5758a.hashCode()) * 31) + this.f5759b.hashCode()) * 31) + this.f5760c.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Route{");
        sb.append(this.f5760c);
        sb.append("}");
        return sb.toString();
    }
}
