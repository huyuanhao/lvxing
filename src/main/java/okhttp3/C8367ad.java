package okhttp3;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import javax.annotation.Nullable;

/* compiled from: Route */
/* renamed from: okhttp3.ad */
public final class C8367ad {
    /* renamed from: a */
    final C8357a f28247a;
    /* renamed from: b */
    final Proxy f28248b;
    /* renamed from: c */
    final InetSocketAddress f28249c;

    public C8367ad(C8357a aVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (aVar == null) {
            throw new NullPointerException("address == null");
        } else if (proxy == null) {
            throw new NullPointerException("proxy == null");
        } else if (inetSocketAddress != null) {
            this.f28247a = aVar;
            this.f28248b = proxy;
            this.f28249c = inetSocketAddress;
        } else {
            throw new NullPointerException("inetSocketAddress == null");
        }
    }

    /* renamed from: a */
    public C8357a mo40130a() {
        return this.f28247a;
    }

    /* renamed from: b */
    public Proxy mo40131b() {
        return this.f28248b;
    }

    /* renamed from: c */
    public InetSocketAddress mo40132c() {
        return this.f28249c;
    }

    /* renamed from: d */
    public boolean mo40133d() {
        return this.f28247a.f28203i != null && this.f28248b.type() == Type.HTTP;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof C8367ad) {
            C8367ad adVar = (C8367ad) obj;
            if (adVar.f28247a.equals(this.f28247a) && adVar.f28248b.equals(this.f28248b) && adVar.f28249c.equals(this.f28249c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + this.f28247a.hashCode()) * 31) + this.f28248b.hashCode()) * 31) + this.f28249c.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Route{");
        sb.append(this.f28249c);
        sb.append("}");
        return sb.toString();
    }
}
