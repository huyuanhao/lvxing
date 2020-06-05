package com.bytedance.sdk.p145a.p147b;

import com.bytedance.sdk.p145a.p147b.HttpUrl.C1937a;
import com.bytedance.sdk.p145a.p147b.p148a.C1876c;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* renamed from: com.bytedance.sdk.a.b.a */
public final class Address {
    /* renamed from: a */
    final HttpUrl f5291a;
    /* renamed from: b */
    final Dns f5292b;
    /* renamed from: c */
    final SocketFactory f5293c;
    /* renamed from: d */
    final Authenticator f5294d;
    /* renamed from: e */
    final List<Protocol> f5295e;
    /* renamed from: f */
    final List<ConnectionSpec> f5296f;
    /* renamed from: g */
    final ProxySelector f5297g;
    /* renamed from: h */
    final Proxy f5298h;
    /* renamed from: i */
    final SSLSocketFactory f5299i;
    /* renamed from: j */
    final HostnameVerifier f5300j;
    /* renamed from: k */
    final CertificatePinner f5301k;

    public Address(String str, int i, Dns rVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, CertificatePinner jVar, Authenticator eVar, Proxy proxy, List<Protocol> list, List<ConnectionSpec> list2, ProxySelector proxySelector) {
        this.f5291a = new C1937a().mo14106a(sSLSocketFactory != null ? "https" : "http").mo14111d(str).mo14105a(i).mo14110c();
        if (rVar != null) {
            this.f5292b = rVar;
            if (socketFactory != null) {
                this.f5293c = socketFactory;
                if (eVar != null) {
                    this.f5294d = eVar;
                    if (list != null) {
                        this.f5295e = C1876c.m6957a(list);
                        if (list2 != null) {
                            this.f5296f = C1876c.m6957a(list2);
                            if (proxySelector != null) {
                                this.f5297g = proxySelector;
                                this.f5298h = proxy;
                                this.f5299i = sSLSocketFactory;
                                this.f5300j = hostnameVerifier;
                                this.f5301k = jVar;
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
    public HttpUrl mo13639a() {
        return this.f5291a;
    }

    /* renamed from: b */
    public Dns mo13641b() {
        return this.f5292b;
    }

    /* renamed from: c */
    public SocketFactory mo13642c() {
        return this.f5293c;
    }

    /* renamed from: d */
    public Authenticator mo13643d() {
        return this.f5294d;
    }

    /* renamed from: e */
    public List<Protocol> mo13644e() {
        return this.f5295e;
    }

    /* renamed from: f */
    public List<ConnectionSpec> mo13646f() {
        return this.f5296f;
    }

    /* renamed from: g */
    public ProxySelector mo13647g() {
        return this.f5297g;
    }

    /* renamed from: h */
    public Proxy mo13648h() {
        return this.f5298h;
    }

    /* renamed from: i */
    public SSLSocketFactory mo13650i() {
        return this.f5299i;
    }

    /* renamed from: j */
    public HostnameVerifier mo13651j() {
        return this.f5300j;
    }

    /* renamed from: k */
    public CertificatePinner mo13652k() {
        return this.f5301k;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Address) {
            Address aVar = (Address) obj;
            if (this.f5291a.equals(aVar.f5291a) && mo13640a(aVar)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (((((((((((527 + this.f5291a.hashCode()) * 31) + this.f5292b.hashCode()) * 31) + this.f5294d.hashCode()) * 31) + this.f5295e.hashCode()) * 31) + this.f5296f.hashCode()) * 31) + this.f5297g.hashCode()) * 31;
        Proxy proxy = this.f5298h;
        int i = 0;
        int hashCode2 = (hashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.f5299i;
        int hashCode3 = (hashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.f5300j;
        int hashCode4 = (hashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        CertificatePinner jVar = this.f5301k;
        if (jVar != null) {
            i = jVar.hashCode();
        }
        return hashCode4 + i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo13640a(Address aVar) {
        return this.f5292b.equals(aVar.f5292b) && this.f5294d.equals(aVar.f5294d) && this.f5295e.equals(aVar.f5295e) && this.f5296f.equals(aVar.f5296f) && this.f5297g.equals(aVar.f5297g) && C1876c.m6965a((Object) this.f5298h, (Object) aVar.f5298h) && C1876c.m6965a((Object) this.f5299i, (Object) aVar.f5299i) && C1876c.m6965a((Object) this.f5300j, (Object) aVar.f5300j) && C1876c.m6965a((Object) this.f5301k, (Object) aVar.f5301k) && mo13639a().mo14093g() == aVar.mo13639a().mo14093g();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address{");
        sb.append(this.f5291a.mo14092f());
        sb.append(":");
        sb.append(this.f5291a.mo14093g());
        if (this.f5298h != null) {
            sb.append(", proxy=");
            sb.append(this.f5298h);
        } else {
            sb.append(", proxySelector=");
            sb.append(this.f5297g);
        }
        sb.append("}");
        return sb.toString();
    }
}
