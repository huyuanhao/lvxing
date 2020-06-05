package com.bytedance.sdk.p145a.p147b;

import com.bytedance.sdk.p145a.p147b.C1935u.C1936a;
import com.bytedance.sdk.p145a.p147b.EventListener.C1934a;
import com.bytedance.sdk.p145a.p147b.Response.C1921a;
import com.bytedance.sdk.p145a.p147b.p148a.C1876c;
import com.bytedance.sdk.p145a.p147b.p148a.Internal;
import com.bytedance.sdk.p145a.p147b.p148a.p149a.InternalCache;
import com.bytedance.sdk.p145a.p147b.p148a.p150b.RealConnection;
import com.bytedance.sdk.p145a.p147b.p148a.p150b.RouteDatabase;
import com.bytedance.sdk.p145a.p147b.p148a.p150b.StreamAllocation;
import com.bytedance.sdk.p145a.p147b.p148a.p157i.CertificateChainCleaner;
import com.bytedance.sdk.p145a.p147b.p148a.p157i.OkHostnameVerifier;
import com.tencent.qqpim.discovery.internal.protocol.C7516p;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* renamed from: com.bytedance.sdk.a.b.z */
public class OkHttpClient implements Cloneable {
    /* renamed from: a */
    static final List<Protocol> f5997a = C1876c.m6958a((T[]) new Protocol[]{Protocol.HTTP_2, Protocol.HTTP_1_1});
    /* renamed from: b */
    static final List<ConnectionSpec> f5998b = C1876c.m6958a((T[]) new ConnectionSpec[]{ConnectionSpec.f5919a, ConnectionSpec.f5921c});
    /* renamed from: A */
    final int f5999A;
    /* renamed from: B */
    final int f6000B;
    /* renamed from: C */
    final int f6001C;
    /* renamed from: c */
    final Dispatcher f6002c;
    /* renamed from: d */
    final Proxy f6003d;
    /* renamed from: e */
    final List<Protocol> f6004e;
    /* renamed from: f */
    final List<ConnectionSpec> f6005f;
    /* renamed from: g */
    final List<Interceptor> f6006g;
    /* renamed from: h */
    final List<Interceptor> f6007h;
    /* renamed from: i */
    final C1934a f6008i;
    /* renamed from: j */
    final ProxySelector f6009j;
    /* renamed from: k */
    final CookieJar f6010k;
    /* renamed from: l */
    final Cache f6011l;
    /* renamed from: m */
    final InternalCache f6012m;
    /* renamed from: n */
    final SocketFactory f6013n;
    /* renamed from: o */
    final SSLSocketFactory f6014o;
    /* renamed from: p */
    final CertificateChainCleaner f6015p;
    /* renamed from: q */
    final HostnameVerifier f6016q;
    /* renamed from: r */
    final CertificatePinner f6017r;
    /* renamed from: s */
    final Authenticator f6018s;
    /* renamed from: t */
    final Authenticator f6019t;
    /* renamed from: u */
    final ConnectionPool f6020u;
    /* renamed from: v */
    final Dns f6021v;
    /* renamed from: w */
    final boolean f6022w;
    /* renamed from: x */
    final boolean f6023x;
    /* renamed from: y */
    final boolean f6024y;
    /* renamed from: z */
    final int f6025z;

    /* compiled from: OkHttpClient */
    /* renamed from: com.bytedance.sdk.a.b.z$a */
    public static final class C1941a {
        /* renamed from: A */
        int f6026A;
        /* renamed from: a */
        Dispatcher f6027a;
        /* renamed from: b */
        Proxy f6028b;
        /* renamed from: c */
        List<Protocol> f6029c;
        /* renamed from: d */
        List<ConnectionSpec> f6030d;
        /* renamed from: e */
        final List<Interceptor> f6031e;
        /* renamed from: f */
        final List<Interceptor> f6032f;
        /* renamed from: g */
        C1934a f6033g;
        /* renamed from: h */
        ProxySelector f6034h;
        /* renamed from: i */
        CookieJar f6035i;
        /* renamed from: j */
        Cache f6036j;
        /* renamed from: k */
        InternalCache f6037k;
        /* renamed from: l */
        SocketFactory f6038l;
        /* renamed from: m */
        SSLSocketFactory f6039m;
        /* renamed from: n */
        CertificateChainCleaner f6040n;
        /* renamed from: o */
        HostnameVerifier f6041o;
        /* renamed from: p */
        CertificatePinner f6042p;
        /* renamed from: q */
        Authenticator f6043q;
        /* renamed from: r */
        Authenticator f6044r;
        /* renamed from: s */
        ConnectionPool f6045s;
        /* renamed from: t */
        Dns f6046t;
        /* renamed from: u */
        boolean f6047u;
        /* renamed from: v */
        boolean f6048v;
        /* renamed from: w */
        boolean f6049w;
        /* renamed from: x */
        int f6050x;
        /* renamed from: y */
        int f6051y;
        /* renamed from: z */
        int f6052z;

        public C1941a() {
            this.f6031e = new ArrayList();
            this.f6032f = new ArrayList();
            this.f6027a = new Dispatcher();
            this.f6029c = OkHttpClient.f5997a;
            this.f6030d = OkHttpClient.f5998b;
            this.f6033g = EventListener.m7496a(EventListener.f5953a);
            this.f6034h = ProxySelector.getDefault();
            this.f6035i = CookieJar.f5944a;
            this.f6038l = SocketFactory.getDefault();
            this.f6041o = OkHostnameVerifier.f5699a;
            this.f6042p = CertificatePinner.f5787a;
            this.f6043q = Authenticator.f5761a;
            this.f6044r = Authenticator.f5761a;
            this.f6045s = new ConnectionPool();
            this.f6046t = Dns.f5952a;
            this.f6047u = true;
            this.f6048v = true;
            this.f6049w = true;
            this.f6050x = C7516p.f25219Cf;
            this.f6051y = C7516p.f25219Cf;
            this.f6052z = C7516p.f25219Cf;
            this.f6026A = 0;
        }

        C1941a(OkHttpClient zVar) {
            this.f6031e = new ArrayList();
            this.f6032f = new ArrayList();
            this.f6027a = zVar.f6002c;
            this.f6028b = zVar.f6003d;
            this.f6029c = zVar.f6004e;
            this.f6030d = zVar.f6005f;
            this.f6031e.addAll(zVar.f6006g);
            this.f6032f.addAll(zVar.f6007h);
            this.f6033g = zVar.f6008i;
            this.f6034h = zVar.f6009j;
            this.f6035i = zVar.f6010k;
            this.f6037k = zVar.f6012m;
            this.f6036j = zVar.f6011l;
            this.f6038l = zVar.f6013n;
            this.f6039m = zVar.f6014o;
            this.f6040n = zVar.f6015p;
            this.f6041o = zVar.f6016q;
            this.f6042p = zVar.f6017r;
            this.f6043q = zVar.f6018s;
            this.f6044r = zVar.f6019t;
            this.f6045s = zVar.f6020u;
            this.f6046t = zVar.f6021v;
            this.f6047u = zVar.f6022w;
            this.f6048v = zVar.f6023x;
            this.f6049w = zVar.f6024y;
            this.f6050x = zVar.f6025z;
            this.f6051y = zVar.f5999A;
            this.f6052z = zVar.f6000B;
            this.f6026A = zVar.f6001C;
        }

        /* renamed from: a */
        public C1941a mo14144a(long j, TimeUnit timeUnit) {
            this.f6050x = C1876c.m6950a("timeout", j, timeUnit);
            return this;
        }

        /* renamed from: b */
        public C1941a mo14149b(long j, TimeUnit timeUnit) {
            this.f6051y = C1876c.m6950a("timeout", j, timeUnit);
            return this;
        }

        /* renamed from: c */
        public C1941a mo14151c(long j, TimeUnit timeUnit) {
            this.f6052z = C1876c.m6950a("timeout", j, timeUnit);
            return this;
        }

        /* renamed from: a */
        public C1941a mo14146a(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
            if (sSLSocketFactory == null) {
                throw new NullPointerException("sslSocketFactory == null");
            } else if (x509TrustManager != null) {
                this.f6039m = sSLSocketFactory;
                this.f6040n = CertificateChainCleaner.m7316a(x509TrustManager);
                return this;
            } else {
                throw new NullPointerException("trustManager == null");
            }
        }

        /* renamed from: a */
        public C1941a mo14145a(HostnameVerifier hostnameVerifier) {
            if (hostnameVerifier != null) {
                this.f6041o = hostnameVerifier;
                return this;
            }
            throw new NullPointerException("hostnameVerifier == null");
        }

        /* renamed from: a */
        public C1941a mo14147a(boolean z) {
            this.f6047u = z;
            return this;
        }

        /* renamed from: b */
        public C1941a mo14150b(boolean z) {
            this.f6048v = z;
            return this;
        }

        /* renamed from: a */
        public OkHttpClient mo14148a() {
            return new OkHttpClient(this);
        }
    }

    static {
        Internal.f5302a = new Internal() {
            /* renamed from: a */
            public void mo13660a(C1936a aVar, String str) {
                aVar.mo14078a(str);
            }

            /* renamed from: a */
            public void mo13661a(C1936a aVar, String str, String str2) {
                aVar.mo14082b(str, str2);
            }

            /* renamed from: b */
            public boolean mo13663b(ConnectionPool mVar, RealConnection cVar) {
                return mVar.mo14013b(cVar);
            }

            /* renamed from: a */
            public RealConnection mo13655a(ConnectionPool mVar, Address aVar, StreamAllocation gVar, Route dVar) {
                return mVar.mo14010a(aVar, gVar, dVar);
            }

            /* renamed from: a */
            public boolean mo13662a(Address aVar, Address aVar2) {
                return aVar.mo13640a(aVar2);
            }

            /* renamed from: a */
            public Socket mo13657a(ConnectionPool mVar, Address aVar, StreamAllocation gVar) {
                return mVar.mo14011a(aVar, gVar);
            }

            /* renamed from: a */
            public void mo13658a(ConnectionPool mVar, RealConnection cVar) {
                mVar.mo14012a(cVar);
            }

            /* renamed from: a */
            public RouteDatabase mo13656a(ConnectionPool mVar) {
                return mVar.f5912a;
            }

            /* renamed from: a */
            public int mo13654a(C1921a aVar) {
                return aVar.f5745c;
            }

            /* renamed from: a */
            public void mo13659a(ConnectionSpec nVar, SSLSocket sSLSocket, boolean z) {
                nVar.mo14015a(sSLSocket, z);
            }
        };
    }

    public OkHttpClient() {
        this(new C1941a());
    }

    OkHttpClient(C1941a aVar) {
        this.f6002c = aVar.f6027a;
        this.f6003d = aVar.f6028b;
        this.f6004e = aVar.f6029c;
        this.f6005f = aVar.f6030d;
        this.f6006g = C1876c.m6957a(aVar.f6031e);
        this.f6007h = C1876c.m6957a(aVar.f6032f);
        this.f6008i = aVar.f6033g;
        this.f6009j = aVar.f6034h;
        this.f6010k = aVar.f6035i;
        this.f6011l = aVar.f6036j;
        this.f6012m = aVar.f6037k;
        this.f6013n = aVar.f6038l;
        Iterator it = this.f6005f.iterator();
        loop0:
        while (true) {
            boolean z = false;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                ConnectionSpec nVar = (ConnectionSpec) it.next();
                if (z || nVar.mo14016a()) {
                    z = true;
                }
            }
        }
        if (aVar.f6039m != null || !z) {
            this.f6014o = aVar.f6039m;
            this.f6015p = aVar.f6040n;
        } else {
            X509TrustManager z2 = m7595z();
            this.f6014o = m7594a(z2);
            this.f6015p = CertificateChainCleaner.m7316a(z2);
        }
        this.f6016q = aVar.f6041o;
        this.f6017r = aVar.f6042p.mo13996a(this.f6015p);
        this.f6018s = aVar.f6043q;
        this.f6019t = aVar.f6044r;
        this.f6020u = aVar.f6045s;
        this.f6021v = aVar.f6046t;
        this.f6022w = aVar.f6047u;
        this.f6023x = aVar.f6048v;
        this.f6024y = aVar.f6049w;
        this.f6025z = aVar.f6050x;
        this.f5999A = aVar.f6051y;
        this.f6000B = aVar.f6052z;
        this.f6001C = aVar.f6026A;
        if (this.f6006g.contains(null)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Null interceptor: ");
            sb.append(this.f6006g);
            throw new IllegalStateException(sb.toString());
        } else if (this.f6007h.contains(null)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Null network interceptor: ");
            sb2.append(this.f6007h);
            throw new IllegalStateException(sb2.toString());
        }
    }

    /* renamed from: z */
    private X509TrustManager m7595z() {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init(null);
            TrustManager[] trustManagers = instance.getTrustManagers();
            if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
                return (X509TrustManager) trustManagers[0];
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Unexpected default trust managers:");
            sb.append(Arrays.toString(trustManagers));
            throw new IllegalStateException(sb.toString());
        } catch (GeneralSecurityException e) {
            throw C1876c.m6952a("No System TLS", (Exception) e);
        }
    }

    /* renamed from: a */
    private SSLSocketFactory m7594a(X509TrustManager x509TrustManager) {
        try {
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init(null, new TrustManager[]{x509TrustManager}, null);
            return instance.getSocketFactory();
        } catch (GeneralSecurityException e) {
            throw C1876c.m6952a("No System TLS", (Exception) e);
        }
    }

    /* renamed from: a */
    public int mo14118a() {
        return this.f6025z;
    }

    /* renamed from: b */
    public int mo14120b() {
        return this.f5999A;
    }

    /* renamed from: c */
    public int mo14121c() {
        return this.f6000B;
    }

    /* renamed from: d */
    public Proxy mo14122d() {
        return this.f6003d;
    }

    /* renamed from: e */
    public ProxySelector mo14123e() {
        return this.f6009j;
    }

    /* renamed from: f */
    public CookieJar mo14124f() {
        return this.f6010k;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public InternalCache mo14125g() {
        Cache fVar = this.f6011l;
        return fVar != null ? fVar.f5762a : this.f6012m;
    }

    /* renamed from: h */
    public Dns mo14126h() {
        return this.f6021v;
    }

    /* renamed from: i */
    public SocketFactory mo14127i() {
        return this.f6013n;
    }

    /* renamed from: j */
    public SSLSocketFactory mo14128j() {
        return this.f6014o;
    }

    /* renamed from: k */
    public HostnameVerifier mo14129k() {
        return this.f6016q;
    }

    /* renamed from: l */
    public CertificatePinner mo14130l() {
        return this.f6017r;
    }

    /* renamed from: m */
    public Authenticator mo14131m() {
        return this.f6019t;
    }

    /* renamed from: n */
    public Authenticator mo14132n() {
        return this.f6018s;
    }

    /* renamed from: o */
    public ConnectionPool mo14133o() {
        return this.f6020u;
    }

    /* renamed from: p */
    public boolean mo14134p() {
        return this.f6022w;
    }

    /* renamed from: q */
    public boolean mo14135q() {
        return this.f6023x;
    }

    /* renamed from: r */
    public boolean mo14136r() {
        return this.f6024y;
    }

    /* renamed from: s */
    public Dispatcher mo14137s() {
        return this.f6002c;
    }

    /* renamed from: t */
    public List<Protocol> mo14138t() {
        return this.f6004e;
    }

    /* renamed from: u */
    public List<ConnectionSpec> mo14139u() {
        return this.f6005f;
    }

    /* renamed from: v */
    public List<Interceptor> mo14140v() {
        return this.f6006g;
    }

    /* renamed from: w */
    public List<Interceptor> mo14141w() {
        return this.f6007h;
    }

    /* renamed from: x */
    public C1934a mo14142x() {
        return this.f6008i;
    }

    /* renamed from: a */
    public Call mo14119a(C1918ab abVar) {
        return RealCall.m7333a(this, abVar, false);
    }

    /* renamed from: y */
    public C1941a mo14143y() {
        return new C1941a(this);
    }
}
