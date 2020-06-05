package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.C8506t.C8507a;
import okhttp3.internal.C8417c;

/* compiled from: Address */
/* renamed from: okhttp3.a */
public final class C8357a {
    /* renamed from: a */
    final C8506t f28195a;
    /* renamed from: b */
    final C8496o f28196b;
    /* renamed from: c */
    final SocketFactory f28197c;
    /* renamed from: d */
    final C8368b f28198d;
    /* renamed from: e */
    final List<Protocol> f28199e;
    /* renamed from: f */
    final List<C8490k> f28200f;
    /* renamed from: g */
    final ProxySelector f28201g;
    @Nullable
    /* renamed from: h */
    final Proxy f28202h;
    @Nullable
    /* renamed from: i */
    final SSLSocketFactory f28203i;
    @Nullable
    /* renamed from: j */
    final HostnameVerifier f28204j;
    @Nullable
    /* renamed from: k */
    final C8382g f28205k;

    public C8357a(String str, int i, C8496o oVar, SocketFactory socketFactory, @Nullable SSLSocketFactory sSLSocketFactory, @Nullable HostnameVerifier hostnameVerifier, @Nullable C8382g gVar, C8368b bVar, @Nullable Proxy proxy, List<Protocol> list, List<C8490k> list2, ProxySelector proxySelector) {
        this.f28195a = new C8507a().mo40572a(sSLSocketFactory != null ? "https" : "http").mo40581d(str).mo40571a(i).mo40580c();
        if (oVar != null) {
            this.f28196b = oVar;
            if (socketFactory != null) {
                this.f28197c = socketFactory;
                if (bVar != null) {
                    this.f28198d = bVar;
                    if (list != null) {
                        this.f28199e = C8417c.m36034a(list);
                        if (list2 != null) {
                            this.f28200f = C8417c.m36034a(list2);
                            if (proxySelector != null) {
                                this.f28201g = proxySelector;
                                this.f28202h = proxy;
                                this.f28203i = sSLSocketFactory;
                                this.f28204j = hostnameVerifier;
                                this.f28205k = gVar;
                                return;
                            }
                            throw new NullPointerException("proxySelector == null");
                        }
                        throw new NullPointerException("connectionSpecs == null");
                    }
                    throw new NullPointerException("protocols == null");
                }
                throw new NullPointerException("proxyAuthenticator == null");
            }
            throw new NullPointerException("socketFactory == null");
        }
        throw new NullPointerException("dns == null");
    }

    /* renamed from: a */
    public C8506t mo40068a() {
        return this.f28195a;
    }

    /* renamed from: b */
    public C8496o mo40070b() {
        return this.f28196b;
    }

    /* renamed from: c */
    public SocketFactory mo40071c() {
        return this.f28197c;
    }

    /* renamed from: d */
    public C8368b mo40072d() {
        return this.f28198d;
    }

    /* renamed from: e */
    public List<Protocol> mo40073e() {
        return this.f28199e;
    }

    /* renamed from: f */
    public List<C8490k> mo40075f() {
        return this.f28200f;
    }

    /* renamed from: g */
    public ProxySelector mo40076g() {
        return this.f28201g;
    }

    @Nullable
    /* renamed from: h */
    public Proxy mo40077h() {
        return this.f28202h;
    }

    @Nullable
    /* renamed from: i */
    public SSLSocketFactory mo40079i() {
        return this.f28203i;
    }

    @Nullable
    /* renamed from: j */
    public HostnameVerifier mo40080j() {
        return this.f28204j;
    }

    @Nullable
    /* renamed from: k */
    public C8382g mo40081k() {
        return this.f28205k;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof C8357a) {
            C8357a aVar = (C8357a) obj;
            if (this.f28195a.equals(aVar.f28195a) && mo40069a(aVar)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (((((((((((527 + this.f28195a.hashCode()) * 31) + this.f28196b.hashCode()) * 31) + this.f28198d.hashCode()) * 31) + this.f28199e.hashCode()) * 31) + this.f28200f.hashCode()) * 31) + this.f28201g.hashCode()) * 31;
        Proxy proxy = this.f28202h;
        int i = 0;
        int hashCode2 = (hashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.f28203i;
        int hashCode3 = (hashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.f28204j;
        int hashCode4 = (hashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        C8382g gVar = this.f28205k;
        if (gVar != null) {
            i = gVar.hashCode();
        }
        return hashCode4 + i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo40069a(C8357a aVar) {
        return this.f28196b.equals(aVar.f28196b) && this.f28198d.equals(aVar.f28198d) && this.f28199e.equals(aVar.f28199e) && this.f28200f.equals(aVar.f28200f) && this.f28201g.equals(aVar.f28201g) && C8417c.m36044a((Object) this.f28202h, (Object) aVar.f28202h) && C8417c.m36044a((Object) this.f28203i, (Object) aVar.f28203i) && C8417c.m36044a((Object) this.f28204j, (Object) aVar.f28204j) && C8417c.m36044a((Object) this.f28205k, (Object) aVar.f28205k) && mo40068a().mo40557g() == aVar.mo40068a().mo40557g();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address{");
        sb.append(this.f28195a.mo40556f());
        sb.append(":");
        sb.append(this.f28195a.mo40557g());
        if (this.f28202h != null) {
            sb.append(", proxy=");
            sb.append(this.f28202h);
        } else {
            sb.append(", proxySelector=");
            sb.append(this.f28201g);
        }
        sb.append("}");
        return sb.toString();
    }
}
