package okhttp3;

import com.tencent.qqpim.discovery.internal.protocol.C7516p;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.C8362ab.C8363a;
import okhttp3.C8379e.C8380a;
import okhttp3.C8498p.C8501a;
import okhttp3.C8504s.C8505a;
import okhttp3.internal.C8388a;
import okhttp3.internal.C8417c;
import okhttp3.internal.connection.C8430c;
import okhttp3.internal.connection.C8431d;
import okhttp3.internal.connection.C8434f;
import okhttp3.internal.p697a.C8401f;
import okhttp3.internal.p701e.C8447f;
import okhttp3.internal.p702f.C8450c;
import okhttp3.internal.p702f.C8451d;

/* compiled from: OkHttpClient */
/* renamed from: okhttp3.x */
public class C8513x implements Cloneable, C8380a {
    /* renamed from: a */
    static final List<Protocol> f28929a = C8417c.m36035a((T[]) new Protocol[]{Protocol.HTTP_2, Protocol.HTTP_1_1});
    /* renamed from: b */
    static final List<C8490k> f28930b = C8417c.m36035a((T[]) new C8490k[]{C8490k.f28838b, C8490k.f28840d});
    /* renamed from: A */
    final int f28931A;
    /* renamed from: B */
    final int f28932B;
    /* renamed from: C */
    final int f28933C;
    /* renamed from: c */
    final C8495n f28934c;
    @Nullable
    /* renamed from: d */
    final Proxy f28935d;
    /* renamed from: e */
    final List<Protocol> f28936e;
    /* renamed from: f */
    final List<C8490k> f28937f;
    /* renamed from: g */
    final List<C8508u> f28938g;
    /* renamed from: h */
    final List<C8508u> f28939h;
    /* renamed from: i */
    final C8501a f28940i;
    /* renamed from: j */
    final ProxySelector f28941j;
    /* renamed from: k */
    final C8493m f28942k;
    @Nullable
    /* renamed from: l */
    final C8370c f28943l;
    @Nullable
    /* renamed from: m */
    final C8401f f28944m;
    /* renamed from: n */
    final SocketFactory f28945n;
    @Nullable
    /* renamed from: o */
    final SSLSocketFactory f28946o;
    @Nullable
    /* renamed from: p */
    final C8450c f28947p;
    /* renamed from: q */
    final HostnameVerifier f28948q;
    /* renamed from: r */
    final C8382g f28949r;
    /* renamed from: s */
    final C8368b f28950s;
    /* renamed from: t */
    final C8368b f28951t;
    /* renamed from: u */
    final C8488j f28952u;
    /* renamed from: v */
    final C8496o f28953v;
    /* renamed from: w */
    final boolean f28954w;
    /* renamed from: x */
    final boolean f28955x;
    /* renamed from: y */
    final boolean f28956y;
    /* renamed from: z */
    final int f28957z;

    /* compiled from: OkHttpClient */
    /* renamed from: okhttp3.x$a */
    public static final class C8515a {
        /* renamed from: A */
        int f28958A = 0;
        /* renamed from: a */
        C8495n f28959a = new C8495n();
        @Nullable
        /* renamed from: b */
        Proxy f28960b;
        /* renamed from: c */
        List<Protocol> f28961c = C8513x.f28929a;
        /* renamed from: d */
        List<C8490k> f28962d = C8513x.f28930b;
        /* renamed from: e */
        final List<C8508u> f28963e = new ArrayList();
        /* renamed from: f */
        final List<C8508u> f28964f = new ArrayList();
        /* renamed from: g */
        C8501a f28965g = C8498p.m36474a(C8498p.f28873a);
        /* renamed from: h */
        ProxySelector f28966h = ProxySelector.getDefault();
        /* renamed from: i */
        C8493m f28967i = C8493m.f28864a;
        @Nullable
        /* renamed from: j */
        C8370c f28968j;
        @Nullable
        /* renamed from: k */
        C8401f f28969k;
        /* renamed from: l */
        SocketFactory f28970l = SocketFactory.getDefault();
        @Nullable
        /* renamed from: m */
        SSLSocketFactory f28971m;
        @Nullable
        /* renamed from: n */
        C8450c f28972n;
        /* renamed from: o */
        HostnameVerifier f28973o = C8451d.f28651a;
        /* renamed from: p */
        C8382g f28974p = C8382g.f28308a;
        /* renamed from: q */
        C8368b f28975q = C8368b.f28250a;
        /* renamed from: r */
        C8368b f28976r = C8368b.f28250a;
        /* renamed from: s */
        C8488j f28977s = new C8488j();
        /* renamed from: t */
        C8496o f28978t = C8496o.f28872a;
        /* renamed from: u */
        boolean f28979u = true;
        /* renamed from: v */
        boolean f28980v = true;
        /* renamed from: w */
        boolean f28981w = true;
        /* renamed from: x */
        int f28982x = C7516p.f25219Cf;
        /* renamed from: y */
        int f28983y = C7516p.f25219Cf;
        /* renamed from: z */
        int f28984z = C7516p.f25219Cf;

        /* renamed from: a */
        public C8515a mo40622a(long j, TimeUnit timeUnit) {
            this.f28982x = C8417c.m36026a("timeout", j, timeUnit);
            return this;
        }

        /* renamed from: b */
        public C8515a mo40633b(long j, TimeUnit timeUnit) {
            this.f28983y = C8417c.m36026a("timeout", j, timeUnit);
            return this;
        }

        /* renamed from: c */
        public C8515a mo40636c(long j, TimeUnit timeUnit) {
            this.f28984z = C8417c.m36026a("timeout", j, timeUnit);
            return this;
        }

        /* renamed from: a */
        public C8515a mo40627a(@Nullable C8370c cVar) {
            this.f28968j = cVar;
            this.f28969k = null;
            return this;
        }

        /* renamed from: a */
        public C8515a mo40625a(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
            if (sSLSocketFactory == null) {
                throw new NullPointerException("sslSocketFactory == null");
            } else if (x509TrustManager != null) {
                this.f28971m = sSLSocketFactory;
                this.f28972n = C8450c.m36216a(x509TrustManager);
                return this;
            } else {
                throw new NullPointerException("trustManager == null");
            }
        }

        /* renamed from: a */
        public C8515a mo40624a(HostnameVerifier hostnameVerifier) {
            if (hostnameVerifier != null) {
                this.f28973o = hostnameVerifier;
                return this;
            }
            throw new NullPointerException("hostnameVerifier == null");
        }

        /* renamed from: a */
        public C8515a mo40626a(C8368b bVar) {
            if (bVar != null) {
                this.f28976r = bVar;
                return this;
            }
            throw new NullPointerException("authenticator == null");
        }

        /* renamed from: a */
        public C8515a mo40628a(C8488j jVar) {
            if (jVar != null) {
                this.f28977s = jVar;
                return this;
            }
            throw new NullPointerException("connectionPool == null");
        }

        /* renamed from: a */
        public C8515a mo40631a(boolean z) {
            this.f28980v = z;
            return this;
        }

        /* renamed from: b */
        public C8515a mo40635b(boolean z) {
            this.f28981w = z;
            return this;
        }

        /* renamed from: a */
        public C8515a mo40629a(C8495n nVar) {
            if (nVar != null) {
                this.f28959a = nVar;
                return this;
            }
            throw new IllegalArgumentException("dispatcher == null");
        }

        /* renamed from: a */
        public C8515a mo40623a(List<Protocol> list) {
            ArrayList arrayList = new ArrayList(list);
            if (!arrayList.contains(Protocol.H2_PRIOR_KNOWLEDGE) && !arrayList.contains(Protocol.HTTP_1_1)) {
                StringBuilder sb = new StringBuilder();
                sb.append("protocols must contain h2_prior_knowledge or http/1.1: ");
                sb.append(arrayList);
                throw new IllegalArgumentException(sb.toString());
            } else if (arrayList.contains(Protocol.H2_PRIOR_KNOWLEDGE) && arrayList.size() > 1) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("protocols containing h2_prior_knowledge cannot use other protocols: ");
                sb2.append(arrayList);
                throw new IllegalArgumentException(sb2.toString());
            } else if (arrayList.contains(Protocol.HTTP_1_0)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("protocols must not contain http/1.0: ");
                sb3.append(arrayList);
                throw new IllegalArgumentException(sb3.toString());
            } else if (!arrayList.contains(null)) {
                arrayList.remove(Protocol.SPDY_3);
                this.f28961c = Collections.unmodifiableList(arrayList);
                return this;
            } else {
                throw new IllegalArgumentException("protocols must not contain null");
            }
        }

        /* renamed from: a */
        public C8515a mo40630a(C8508u uVar) {
            if (uVar != null) {
                this.f28963e.add(uVar);
                return this;
            }
            throw new IllegalArgumentException("interceptor == null");
        }

        /* renamed from: b */
        public C8515a mo40634b(C8508u uVar) {
            if (uVar != null) {
                this.f28964f.add(uVar);
                return this;
            }
            throw new IllegalArgumentException("interceptor == null");
        }

        /* renamed from: a */
        public C8513x mo40632a() {
            return new C8513x(this);
        }
    }

    static {
        C8388a.f28432a = new C8388a() {
            /* renamed from: a */
            public void mo40197a(C8505a aVar, String str) {
                aVar.mo40541a(str);
            }

            /* renamed from: a */
            public void mo40198a(C8505a aVar, String str, String str2) {
                aVar.mo40545b(str, str2);
            }

            /* renamed from: a */
            public boolean mo40200a(C8488j jVar, C8430c cVar) {
                return jVar.mo40464b(cVar);
            }

            /* renamed from: a */
            public C8430c mo40194a(C8488j jVar, C8357a aVar, C8434f fVar, C8367ad adVar) {
                return jVar.mo40462a(aVar, fVar, adVar);
            }

            /* renamed from: a */
            public boolean mo40199a(C8357a aVar, C8357a aVar2) {
                return aVar.mo40069a(aVar2);
            }

            /* renamed from: a */
            public Socket mo40193a(C8488j jVar, C8357a aVar, C8434f fVar) {
                return jVar.mo40461a(aVar, fVar);
            }

            /* renamed from: b */
            public void mo40201b(C8488j jVar, C8430c cVar) {
                jVar.mo40463a(cVar);
            }

            /* renamed from: a */
            public C8431d mo40195a(C8488j jVar) {
                return jVar.f28830a;
            }

            /* renamed from: a */
            public int mo40192a(C8363a aVar) {
                return aVar.f28229c;
            }

            /* renamed from: a */
            public void mo40196a(C8490k kVar, SSLSocket sSLSocket, boolean z) {
                kVar.mo40466a(sSLSocket, z);
            }
        };
    }

    public C8513x() {
        this(new C8515a());
    }

    C8513x(C8515a aVar) {
        this.f28934c = aVar.f28959a;
        this.f28935d = aVar.f28960b;
        this.f28936e = aVar.f28961c;
        this.f28937f = aVar.f28962d;
        this.f28938g = C8417c.m36034a(aVar.f28963e);
        this.f28939h = C8417c.m36034a(aVar.f28964f);
        this.f28940i = aVar.f28965g;
        this.f28941j = aVar.f28966h;
        this.f28942k = aVar.f28967i;
        this.f28943l = aVar.f28968j;
        this.f28944m = aVar.f28969k;
        this.f28945n = aVar.f28970l;
        Iterator it = this.f28937f.iterator();
        loop0:
        while (true) {
            boolean z = false;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                C8490k kVar = (C8490k) it.next();
                if (z || kVar.mo40467a()) {
                    z = true;
                }
            }
        }
        if (aVar.f28971m != null || !z) {
            this.f28946o = aVar.f28971m;
            this.f28947p = aVar.f28972n;
        } else {
            X509TrustManager a = C8417c.m36038a();
            this.f28946o = m36611a(a);
            this.f28947p = C8450c.m36216a(a);
        }
        if (this.f28946o != null) {
            C8447f.m36198c().mo40338a(this.f28946o);
        }
        this.f28948q = aVar.f28973o;
        this.f28949r = aVar.f28974p.mo40179a(this.f28947p);
        this.f28950s = aVar.f28975q;
        this.f28951t = aVar.f28976r;
        this.f28952u = aVar.f28977s;
        this.f28953v = aVar.f28978t;
        this.f28954w = aVar.f28979u;
        this.f28955x = aVar.f28980v;
        this.f28956y = aVar.f28981w;
        this.f28957z = aVar.f28982x;
        this.f28931A = aVar.f28983y;
        this.f28932B = aVar.f28984z;
        this.f28933C = aVar.f28958A;
        if (this.f28938g.contains(null)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Null interceptor: ");
            sb.append(this.f28938g);
            throw new IllegalStateException(sb.toString());
        } else if (this.f28939h.contains(null)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Null network interceptor: ");
            sb2.append(this.f28939h);
            throw new IllegalStateException(sb2.toString());
        }
    }

    /* renamed from: a */
    private static SSLSocketFactory m36611a(X509TrustManager x509TrustManager) {
        try {
            SSLContext b = C8447f.m36198c().mo40327b();
            b.init(null, new TrustManager[]{x509TrustManager}, null);
            return b.getSocketFactory();
        } catch (GeneralSecurityException e) {
            throw C8417c.m36028a("No System TLS", (Exception) e);
        }
    }

    /* renamed from: a */
    public int mo40597a() {
        return this.f28957z;
    }

    /* renamed from: b */
    public int mo40598b() {
        return this.f28931A;
    }

    /* renamed from: c */
    public int mo40599c() {
        return this.f28932B;
    }

    /* renamed from: d */
    public int mo40600d() {
        return this.f28933C;
    }

    /* renamed from: e */
    public Proxy mo40601e() {
        return this.f28935d;
    }

    /* renamed from: f */
    public ProxySelector mo40602f() {
        return this.f28941j;
    }

    /* renamed from: g */
    public C8493m mo40603g() {
        return this.f28942k;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public C8401f mo40604h() {
        C8370c cVar = this.f28943l;
        return cVar != null ? cVar.f28251a : this.f28944m;
    }

    /* renamed from: i */
    public C8496o mo40605i() {
        return this.f28953v;
    }

    /* renamed from: j */
    public SocketFactory mo40606j() {
        return this.f28945n;
    }

    /* renamed from: k */
    public SSLSocketFactory mo40607k() {
        return this.f28946o;
    }

    /* renamed from: l */
    public HostnameVerifier mo40608l() {
        return this.f28948q;
    }

    /* renamed from: m */
    public C8382g mo40609m() {
        return this.f28949r;
    }

    /* renamed from: n */
    public C8368b mo40610n() {
        return this.f28951t;
    }

    /* renamed from: o */
    public C8368b mo40611o() {
        return this.f28950s;
    }

    /* renamed from: p */
    public C8488j mo40612p() {
        return this.f28952u;
    }

    /* renamed from: q */
    public boolean mo40613q() {
        return this.f28954w;
    }

    /* renamed from: r */
    public boolean mo40614r() {
        return this.f28955x;
    }

    /* renamed from: s */
    public boolean mo40615s() {
        return this.f28956y;
    }

    /* renamed from: t */
    public C8495n mo40616t() {
        return this.f28934c;
    }

    /* renamed from: u */
    public List<Protocol> mo40617u() {
        return this.f28936e;
    }

    /* renamed from: v */
    public List<C8490k> mo40618v() {
        return this.f28937f;
    }

    /* renamed from: w */
    public List<C8508u> mo40619w() {
        return this.f28938g;
    }

    /* renamed from: x */
    public List<C8508u> mo40620x() {
        return this.f28939h;
    }

    /* renamed from: y */
    public C8501a mo40621y() {
        return this.f28940i;
    }

    /* renamed from: a */
    public C8379e mo40177a(C8518z zVar) {
        return C8516y.m36664a(this, zVar, false);
    }
}
