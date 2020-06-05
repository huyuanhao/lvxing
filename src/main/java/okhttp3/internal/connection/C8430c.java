package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.C8357a;
import okhttp3.C8362ab;
import okhttp3.C8367ad;
import okhttp3.C8379e;
import okhttp3.C8387i;
import okhttp3.C8488j;
import okhttp3.C8498p;
import okhttp3.C8503r;
import okhttp3.C8506t;
import okhttp3.C8508u.C8509a;
import okhttp3.C8513x;
import okhttp3.C8518z;
import okhttp3.C8518z.C8519a;
import okhttp3.Protocol;
import okhttp3.internal.C8388a;
import okhttp3.internal.C8417c;
import okhttp3.internal.C8436d;
import okhttp3.internal.http2.C8458d;
import okhttp3.internal.http2.C8460e;
import okhttp3.internal.http2.C8460e.C8467a;
import okhttp3.internal.http2.C8460e.C8468b;
import okhttp3.internal.http2.C8478g;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.p698b.C8406c;
import okhttp3.internal.p698b.C8409e;
import okhttp3.internal.p699c.C8420a;
import okhttp3.internal.p701e.C8447f;
import okhttp3.internal.p702f.C8451d;
import okio.C8528d;
import okio.C8529e;
import okio.C8535k;
import okio.C8547r;
import p655io.reactivex.annotations.SchedulerSupport;

/* compiled from: RealConnection */
/* renamed from: okhttp3.internal.connection.c */
public final class C8430c extends C8468b implements C8387i {
    /* renamed from: a */
    public boolean f28579a;
    /* renamed from: b */
    public int f28580b;
    /* renamed from: c */
    public int f28581c = 1;
    /* renamed from: d */
    public final List<Reference<C8434f>> f28582d = new ArrayList();
    /* renamed from: e */
    public long f28583e = Long.MAX_VALUE;
    /* renamed from: g */
    private final C8488j f28584g;
    /* renamed from: h */
    private final C8367ad f28585h;
    /* renamed from: i */
    private Socket f28586i;
    /* renamed from: j */
    private Socket f28587j;
    /* renamed from: k */
    private C8503r f28588k;
    /* renamed from: l */
    private Protocol f28589l;
    /* renamed from: m */
    private C8460e f28590m;
    /* renamed from: n */
    private C8529e f28591n;
    /* renamed from: o */
    private C8528d f28592o;

    public C8430c(C8488j jVar, C8367ad adVar) {
        this.f28584g = jVar;
        this.f28585h = adVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00cc, code lost:
            if (r7.f28585h.mo40133d() == false) goto L_0x00e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00d0, code lost:
            if (r7.f28586i == null) goto L_0x00d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00df, code lost:
            throw new okhttp3.internal.connection.RouteException(new java.net.ProtocolException("Too many tunnel connections attempted: 21"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00e2, code lost:
            if (r7.f28590m == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00e4, code lost:
            r1 = r7.f28584g;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00e6, code lost:
            monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
            r7.f28581c = r7.f28590m.mo40365a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00ef, code lost:
            monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
            return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
            return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0136  */
    /* renamed from: a */
    public void mo40279a(int r17, int r18, int r19, int r20, boolean r21, okhttp3.C8379e r22, okhttp3.C8498p r23) {
        /*
        r16 = this;
        r7 = r16
        r8 = r22
        r9 = r23
        okhttp3.Protocol r0 = r7.f28589l
        if (r0 != 0) goto L_0x0151
        okhttp3.ad r0 = r7.f28585h
        okhttp3.a r0 = r0.mo40130a()
        java.util.List r0 = r0.mo40075f()
        okhttp3.internal.connection.b r10 = new okhttp3.internal.connection.b
        r10.m55424init(r0)
        okhttp3.ad r1 = r7.f28585h
        okhttp3.a r1 = r1.mo40130a()
        javax.net.ssl.SSLSocketFactory r1 = r1.mo40079i()
        if (r1 != 0) goto L_0x0074
        okhttp3.k r1 = okhttp3.C8490k.f28840d
        boolean r0 = r0.contains(r1)
        if (r0 == 0) goto L_0x0067
        okhttp3.ad r0 = r7.f28585h
        okhttp3.a r0 = r0.mo40130a()
        okhttp3.t r0 = r0.mo40068a()
        java.lang.String r0 = r0.mo40556f()
        okhttp3.internal.e.f r1 = okhttp3.internal.p701e.C8447f.m36198c()
        boolean r1 = r1.mo40329b(r0)
        if (r1 == 0) goto L_0x0046
        goto L_0x0086
    L_0x0046:
        okhttp3.internal.connection.RouteException r1 = new okhttp3.internal.connection.RouteException
        java.net.UnknownServiceException r2 = new java.net.UnknownServiceException
        java.lang.StringBuilder r3 = new java.lang.StringBuilder
        r3.<init>()
        java.lang.String r4 = "CLEARTEXT communication to "
        r3.append(r4)
        r3.append(r0)
        java.lang.String r0 = " not permitted by network security policy"
        r3.append(r0)
        java.lang.String r0 = r3.toString()
        r2.<init>(r0)
        r1.m55422init(r2)
        throw r1
    L_0x0067:
        okhttp3.internal.connection.RouteException r0 = new okhttp3.internal.connection.RouteException
        java.net.UnknownServiceException r1 = new java.net.UnknownServiceException
        java.lang.String r2 = "CLEARTEXT communication not enabled for client"
        r1.<init>(r2)
        r0.m55422init(r1)
        throw r0
    L_0x0074:
        okhttp3.ad r0 = r7.f28585h
        okhttp3.a r0 = r0.mo40130a()
        java.util.List r0 = r0.mo40073e()
        okhttp3.Protocol r1 = okhttp3.Protocol.H2_PRIOR_KNOWLEDGE
        boolean r0 = r0.contains(r1)
        if (r0 != 0) goto L_0x0144
    L_0x0086:
        r11 = 0
        r12 = r11
    L_0x0088:
        okhttp3.ad r0 = r7.f28585h     // Catch:{ IOException -> 0x00f9 }
        boolean r0 = r0.mo40133d()     // Catch:{ IOException -> 0x00f9 }
        if (r0 == 0) goto L_0x00a9
        r1 = r16
        r2 = r17
        r3 = r18
        r4 = r19
        r5 = r22
        r6 = r23
        r1.m36090a(r2, r3, r4, r5, r6)     // Catch:{ IOException -> 0x00f9 }
        java.net.Socket r0 = r7.f28586i     // Catch:{ IOException -> 0x00f9 }
        if (r0 != 0) goto L_0x00a4
        goto L_0x00c6
    L_0x00a4:
        r13 = r17
        r14 = r18
        goto L_0x00b0
    L_0x00a9:
        r13 = r17
        r14 = r18
        r7.m36091a(r13, r14, r8, r9)     // Catch:{ IOException -> 0x00f7 }
    L_0x00b0:
        r15 = r20
        r7.m36093a(r10, r15, r8, r9)     // Catch:{ IOException -> 0x00f5 }
        okhttp3.ad r0 = r7.f28585h     // Catch:{ IOException -> 0x00f5 }
        java.net.InetSocketAddress r0 = r0.mo40132c()     // Catch:{ IOException -> 0x00f5 }
        okhttp3.ad r1 = r7.f28585h     // Catch:{ IOException -> 0x00f5 }
        java.net.Proxy r1 = r1.mo40131b()     // Catch:{ IOException -> 0x00f5 }
        okhttp3.Protocol r2 = r7.f28589l     // Catch:{ IOException -> 0x00f5 }
        r9.mo40502a(r8, r0, r1, r2)     // Catch:{ IOException -> 0x00f5 }
    L_0x00c6:
        okhttp3.ad r0 = r7.f28585h
        boolean r0 = r0.mo40133d()
        if (r0 == 0) goto L_0x00e0
        java.net.Socket r0 = r7.f28586i
        if (r0 == 0) goto L_0x00d3
        goto L_0x00e0
    L_0x00d3:
        java.net.ProtocolException r0 = new java.net.ProtocolException
        java.lang.String r1 = "Too many tunnel connections attempted: 21"
        r0.<init>(r1)
        okhttp3.internal.connection.RouteException r1 = new okhttp3.internal.connection.RouteException
        r1.m55422init(r0)
        throw r1
    L_0x00e0:
        okhttp3.internal.http2.e r0 = r7.f28590m
        if (r0 == 0) goto L_0x00f4
        okhttp3.j r1 = r7.f28584g
        monitor-enter(r1)
        okhttp3.internal.http2.e r0 = r7.f28590m     // Catch:{ all -> 0x00f1 }
        int r0 = r0.mo40365a()     // Catch:{ all -> 0x00f1 }
        r7.f28581c = r0     // Catch:{ all -> 0x00f1 }
        monitor-exit(r1)     // Catch:{ all -> 0x00f1 }
        goto L_0x00f4
    L_0x00f1:
        r0 = move-exception
        monitor-exit(r1)     // Catch:{ all -> 0x00f1 }
        throw r0
    L_0x00f4:
        return
    L_0x00f5:
        r0 = move-exception
        goto L_0x0100
    L_0x00f7:
        r0 = move-exception
        goto L_0x00fe
    L_0x00f9:
        r0 = move-exception
        r13 = r17
        r14 = r18
    L_0x00fe:
        r15 = r20
    L_0x0100:
        java.net.Socket r1 = r7.f28587j
        okhttp3.internal.C8417c.m36042a(r1)
        java.net.Socket r1 = r7.f28586i
        okhttp3.internal.C8417c.m36042a(r1)
        r7.f28587j = r11
        r7.f28586i = r11
        r7.f28591n = r11
        r7.f28592o = r11
        r7.f28588k = r11
        r7.f28589l = r11
        r7.f28590m = r11
        okhttp3.ad r1 = r7.f28585h
        java.net.InetSocketAddress r3 = r1.mo40132c()
        okhttp3.ad r1 = r7.f28585h
        java.net.Proxy r4 = r1.mo40131b()
        r5 = 0
        r1 = r23
        r2 = r22
        r6 = r0
        r1.mo40503a(r2, r3, r4, r5, r6)
        if (r12 != 0) goto L_0x0136
        okhttp3.internal.connection.RouteException r1 = new okhttp3.internal.connection.RouteException
        r1.m55422init(r0)
        r12 = r1
        goto L_0x0139
    L_0x0136:
        r12.addConnectException(r0)
    L_0x0139:
        if (r21 == 0) goto L_0x0143
        boolean r0 = r10.mo40276a(r0)
        if (r0 == 0) goto L_0x0143
        goto L_0x0088
    L_0x0143:
        throw r12
    L_0x0144:
        okhttp3.internal.connection.RouteException r0 = new okhttp3.internal.connection.RouteException
        java.net.UnknownServiceException r1 = new java.net.UnknownServiceException
        java.lang.String r2 = "H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"
        r1.<init>(r2)
        r0.m55422init(r1)
        throw r0
    L_0x0151:
        java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
        java.lang.String r1 = "already connected"
        r0.<init>(r1)
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.C8430c.mo40279a(int, int, int, int, boolean, okhttp3.e, okhttp3.p):void");
    }

    /* renamed from: a */
    private void m36090a(int i, int i2, int i3, C8379e eVar, C8498p pVar) throws IOException {
        C8518z f = m36094f();
        C8506t a = f.mo40645a();
        int i4 = 0;
        while (i4 < 21) {
            m36091a(i, i2, eVar, pVar);
            f = m36088a(i2, i3, f, a);
            if (f != null) {
                C8417c.m36042a(this.f28586i);
                this.f28586i = null;
                this.f28592o = null;
                this.f28591n = null;
                pVar.mo40502a(eVar, this.f28585h.mo40132c(), this.f28585h.mo40131b(), null);
                i4++;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    private void m36091a(int i, int i2, C8379e eVar, C8498p pVar) throws IOException {
        Socket socket;
        Proxy b = this.f28585h.mo40131b();
        C8357a a = this.f28585h.mo40130a();
        if (b.type() == Type.DIRECT || b.type() == Type.HTTP) {
            socket = a.mo40071c().createSocket();
        } else {
            socket = new Socket(b);
        }
        this.f28586i = socket;
        pVar.mo40501a(eVar, this.f28585h.mo40132c(), b);
        this.f28586i.setSoTimeout(i2);
        try {
            C8447f.m36198c().mo40325a(this.f28586i, this.f28585h.mo40132c(), i);
            try {
                this.f28591n = C8535k.m36849a(C8535k.m36859b(this.f28586i));
                this.f28592o = C8535k.m36848a(C8535k.m36853a(this.f28586i));
            } catch (NullPointerException e) {
                if ("throw with null exception".equals(e.getMessage())) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to connect to ");
            sb.append(this.f28585h.mo40132c());
            ConnectException connectException = new ConnectException(sb.toString());
            connectException.initCause(e2);
            throw connectException;
        }
    }

    /* renamed from: a */
    private void m36093a(C8429b bVar, int i, C8379e eVar, C8498p pVar) throws IOException {
        if (this.f28585h.mo40130a().mo40079i() != null) {
            pVar.mo40508b(eVar);
            m36092a(bVar);
            pVar.mo40506a(eVar, this.f28588k);
            if (this.f28589l == Protocol.HTTP_2) {
                m36089a(i);
            }
        } else if (this.f28585h.mo40130a().mo40073e().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
            this.f28587j = this.f28586i;
            this.f28589l = Protocol.H2_PRIOR_KNOWLEDGE;
            m36089a(i);
        } else {
            this.f28587j = this.f28586i;
            this.f28589l = Protocol.HTTP_1_1;
        }
    }

    /* renamed from: a */
    private void m36089a(int i) throws IOException {
        this.f28587j.setSoTimeout(0);
        this.f28590m = new C8467a(true).mo40388a(this.f28587j, this.f28585h.mo40130a().mo40068a().mo40556f(), this.f28591n, this.f28592o).mo40389a((C8468b) this).mo40387a(i).mo40390a();
        this.f28590m.mo40382c();
    }

    /* JADX WARNING: type inference failed for: r2v1 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0111 A[Catch:{ all -> 0x0107 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0117 A[Catch:{ all -> 0x0107 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x011a  */
    /* renamed from: a */
    private void m36092a(okhttp3.internal.connection.C8429b r8) throws java.io.IOException {
        /*
        r7 = this;
        okhttp3.ad r0 = r7.f28585h
        okhttp3.a r0 = r0.mo40130a()
        javax.net.ssl.SSLSocketFactory r1 = r0.mo40079i()
        r2 = 0
        java.net.Socket r3 = r7.f28586i     // Catch:{ AssertionError -> 0x010a }
        okhttp3.t r4 = r0.mo40068a()     // Catch:{ AssertionError -> 0x010a }
        java.lang.String r4 = r4.mo40556f()     // Catch:{ AssertionError -> 0x010a }
        okhttp3.t r5 = r0.mo40068a()     // Catch:{ AssertionError -> 0x010a }
        int r5 = r5.mo40557g()     // Catch:{ AssertionError -> 0x010a }
        r6 = 1
        java.net.Socket r1 = r1.createSocket(r3, r4, r5, r6)     // Catch:{ AssertionError -> 0x010a }
        javax.net.ssl.SSLSocket r1 = (javax.net.ssl.SSLSocket) r1     // Catch:{ AssertionError -> 0x010a }
        okhttp3.k r8 = r8.mo40275a(r1)     // Catch:{ AssertionError -> 0x0104, all -> 0x0102 }
        boolean r3 = r8.mo40471d()     // Catch:{ AssertionError -> 0x0104, all -> 0x0102 }
        if (r3 == 0) goto L_0x0041
        okhttp3.internal.e.f r3 = okhttp3.internal.p701e.C8447f.m36198c()     // Catch:{ AssertionError -> 0x0104, all -> 0x0102 }
        okhttp3.t r4 = r0.mo40068a()     // Catch:{ AssertionError -> 0x0104, all -> 0x0102 }
        java.lang.String r4 = r4.mo40556f()     // Catch:{ AssertionError -> 0x0104, all -> 0x0102 }
        java.util.List r5 = r0.mo40073e()     // Catch:{ AssertionError -> 0x0104, all -> 0x0102 }
        r3.mo40326a(r1, r4, r5)     // Catch:{ AssertionError -> 0x0104, all -> 0x0102 }
    L_0x0041:
        r1.startHandshake()     // Catch:{ AssertionError -> 0x0104, all -> 0x0102 }
        javax.net.ssl.SSLSession r3 = r1.getSession()     // Catch:{ AssertionError -> 0x0104, all -> 0x0102 }
        okhttp3.r r4 = okhttp3.C8503r.m36509a(r3)     // Catch:{ AssertionError -> 0x0104, all -> 0x0102 }
        javax.net.ssl.HostnameVerifier r5 = r0.mo40080j()     // Catch:{ AssertionError -> 0x0104, all -> 0x0102 }
        okhttp3.t r6 = r0.mo40068a()     // Catch:{ AssertionError -> 0x0104, all -> 0x0102 }
        java.lang.String r6 = r6.mo40556f()     // Catch:{ AssertionError -> 0x0104, all -> 0x0102 }
        boolean r3 = r5.verify(r6, r3)     // Catch:{ AssertionError -> 0x0104, all -> 0x0102 }
        if (r3 == 0) goto L_0x00b0
        okhttp3.g r3 = r0.mo40081k()     // Catch:{ AssertionError -> 0x0104, all -> 0x0102 }
        okhttp3.t r0 = r0.mo40068a()     // Catch:{ AssertionError -> 0x0104, all -> 0x0102 }
        java.lang.String r0 = r0.mo40556f()     // Catch:{ AssertionError -> 0x0104, all -> 0x0102 }
        java.util.List r5 = r4.mo40527c()     // Catch:{ AssertionError -> 0x0104, all -> 0x0102 }
        r3.mo40180a(r0, r5)     // Catch:{ AssertionError -> 0x0104, all -> 0x0102 }
        boolean r8 = r8.mo40471d()     // Catch:{ AssertionError -> 0x0104, all -> 0x0102 }
        if (r8 == 0) goto L_0x007f
        okhttp3.internal.e.f r8 = okhttp3.internal.p701e.C8447f.m36198c()     // Catch:{ AssertionError -> 0x0104, all -> 0x0102 }
        java.lang.String r2 = r8.mo40321a(r1)     // Catch:{ AssertionError -> 0x0104, all -> 0x0102 }
    L_0x007f:
        r7.f28587j = r1     // Catch:{ AssertionError -> 0x0104, all -> 0x0102 }
        java.net.Socket r8 = r7.f28587j     // Catch:{ AssertionError -> 0x0104, all -> 0x0102 }
        okio.r r8 = okio.C8535k.m36859b(r8)     // Catch:{ AssertionError -> 0x0104, all -> 0x0102 }
        okio.e r8 = okio.C8535k.m36849a(r8)     // Catch:{ AssertionError -> 0x0104, all -> 0x0102 }
        r7.f28591n = r8     // Catch:{ AssertionError -> 0x0104, all -> 0x0102 }
        java.net.Socket r8 = r7.f28587j     // Catch:{ AssertionError -> 0x0104, all -> 0x0102 }
        okio.q r8 = okio.C8535k.m36853a(r8)     // Catch:{ AssertionError -> 0x0104, all -> 0x0102 }
        okio.d r8 = okio.C8535k.m36848a(r8)     // Catch:{ AssertionError -> 0x0104, all -> 0x0102 }
        r7.f28592o = r8     // Catch:{ AssertionError -> 0x0104, all -> 0x0102 }
        r7.f28588k = r4     // Catch:{ AssertionError -> 0x0104, all -> 0x0102 }
        if (r2 == 0) goto L_0x00a2
        okhttp3.Protocol r8 = okhttp3.Protocol.get(r2)     // Catch:{ AssertionError -> 0x0104, all -> 0x0102 }
        goto L_0x00a4
    L_0x00a2:
        okhttp3.Protocol r8 = okhttp3.Protocol.HTTP_1_1     // Catch:{ AssertionError -> 0x0104, all -> 0x0102 }
    L_0x00a4:
        r7.f28589l = r8     // Catch:{ AssertionError -> 0x0104, all -> 0x0102 }
        if (r1 == 0) goto L_0x00af
        okhttp3.internal.e.f r8 = okhttp3.internal.p701e.C8447f.m36198c()
        r8.mo40339b(r1)
    L_0x00af:
        return
    L_0x00b0:
        java.util.List r8 = r4.mo40527c()     // Catch:{ AssertionError -> 0x0104, all -> 0x0102 }
        r2 = 0
        java.lang.Object r8 = r8.get(r2)     // Catch:{ AssertionError -> 0x0104, all -> 0x0102 }
        java.security.cert.X509Certificate r8 = (java.security.cert.X509Certificate) r8     // Catch:{ AssertionError -> 0x0104, all -> 0x0102 }
        javax.net.ssl.SSLPeerUnverifiedException r2 = new javax.net.ssl.SSLPeerUnverifiedException     // Catch:{ AssertionError -> 0x0104, all -> 0x0102 }
        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ AssertionError -> 0x0104, all -> 0x0102 }
        r3.<init>()     // Catch:{ AssertionError -> 0x0104, all -> 0x0102 }
        java.lang.String r4 = "Hostname "
        r3.append(r4)     // Catch:{ AssertionError -> 0x0104, all -> 0x0102 }
        okhttp3.t r0 = r0.mo40068a()     // Catch:{ AssertionError -> 0x0104, all -> 0x0102 }
        java.lang.String r0 = r0.mo40556f()     // Catch:{ AssertionError -> 0x0104, all -> 0x0102 }
        r3.append(r0)     // Catch:{ AssertionError -> 0x0104, all -> 0x0102 }
        java.lang.String r0 = " not verified:\n    certificate: "
        r3.append(r0)     // Catch:{ AssertionError -> 0x0104, all -> 0x0102 }
        java.lang.String r0 = okhttp3.C8382g.m35884a(r8)     // Catch:{ AssertionError -> 0x0104, all -> 0x0102 }
        r3.append(r0)     // Catch:{ AssertionError -> 0x0104, all -> 0x0102 }
        java.lang.String r0 = "\n    DN: "
        r3.append(r0)     // Catch:{ AssertionError -> 0x0104, all -> 0x0102 }
        java.security.Principal r0 = r8.getSubjectDN()     // Catch:{ AssertionError -> 0x0104, all -> 0x0102 }
        java.lang.String r0 = r0.getName()     // Catch:{ AssertionError -> 0x0104, all -> 0x0102 }
        r3.append(r0)     // Catch:{ AssertionError -> 0x0104, all -> 0x0102 }
        java.lang.String r0 = "\n    subjectAltNames: "
        r3.append(r0)     // Catch:{ AssertionError -> 0x0104, all -> 0x0102 }
        java.util.List r8 = okhttp3.internal.p702f.C8451d.m36218a(r8)     // Catch:{ AssertionError -> 0x0104, all -> 0x0102 }
        r3.append(r8)     // Catch:{ AssertionError -> 0x0104, all -> 0x0102 }
        java.lang.String r8 = r3.toString()     // Catch:{ AssertionError -> 0x0104, all -> 0x0102 }
        r2.<init>(r8)     // Catch:{ AssertionError -> 0x0104, all -> 0x0102 }
        throw r2     // Catch:{ AssertionError -> 0x0104, all -> 0x0102 }
    L_0x0102:
        r8 = move-exception
        goto L_0x0118
    L_0x0104:
        r8 = move-exception
        r2 = r1
        goto L_0x010b
    L_0x0107:
        r8 = move-exception
        r1 = r2
        goto L_0x0118
    L_0x010a:
        r8 = move-exception
    L_0x010b:
        boolean r0 = okhttp3.internal.C8417c.m36043a(r8)     // Catch:{ all -> 0x0107 }
        if (r0 == 0) goto L_0x0117
        java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0107 }
        r0.<init>(r8)     // Catch:{ all -> 0x0107 }
        throw r0     // Catch:{ all -> 0x0107 }
    L_0x0117:
        throw r8     // Catch:{ all -> 0x0107 }
    L_0x0118:
        if (r1 == 0) goto L_0x0121
        okhttp3.internal.e.f r0 = okhttp3.internal.p701e.C8447f.m36198c()
        r0.mo40339b(r1)
    L_0x0121:
        okhttp3.internal.C8417c.m36042a(r1)
        throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.C8430c.m36092a(okhttp3.internal.connection.b):void");
    }

    /* renamed from: a */
    private C8518z m36088a(int i, int i2, C8518z zVar, C8506t tVar) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("CONNECT ");
        sb.append(C8417c.m36031a(tVar, true));
        sb.append(" HTTP/1.1");
        String sb2 = sb.toString();
        while (true) {
            C8420a aVar = new C8420a(null, null, this.f28591n, this.f28592o);
            this.f28591n.mo40203a().mo40804a((long) i, TimeUnit.MILLISECONDS);
            this.f28592o.mo40271a().mo40804a((long) i2, TimeUnit.MILLISECONDS);
            aVar.mo40264a(zVar.mo40648c(), sb2);
            aVar.mo40240b();
            C8362ab a = aVar.mo40235a(false).mo40114a(zVar).mo40115a();
            long a2 = C8409e.m35978a(a);
            if (a2 == -1) {
                a2 = 0;
            }
            C8547r b = aVar.mo40266b(a2);
            C8417c.m36052b(b, (int) ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, TimeUnit.MILLISECONDS);
            b.close();
            int c = a.mo40091c();
            if (c != 200) {
                if (c == 407) {
                    C8518z a3 = this.f28585h.mo40130a().mo40072d().mo20012a(this.f28585h, a);
                    if (a3 != null) {
                        if ("close".equalsIgnoreCase(a.mo40089b("Connection"))) {
                            return a3;
                        }
                        zVar = a3;
                    } else {
                        throw new IOException("Failed to authenticate with proxy");
                    }
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Unexpected response code for CONNECT: ");
                    sb3.append(a.mo40091c());
                    throw new IOException(sb3.toString());
                }
            } else if (this.f28591n.mo40741c().mo40755f() && this.f28592o.mo40741c().mo40755f()) {
                return null;
            } else {
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
        }
    }

    /* renamed from: f */
    private C8518z m36094f() {
        return new C8519a().mo40660a(this.f28585h.mo40130a().mo40068a()).mo40656a("Host", C8417c.m36031a(this.f28585h.mo40130a().mo40068a(), true)).mo40656a("Proxy-Connection", "Keep-Alive").mo40656a("User-Agent", C8436d.m36139a()).mo40663b();
    }

    /* renamed from: a */
    public boolean mo40282a(C8357a aVar, @Nullable C8367ad adVar) {
        if (this.f28582d.size() >= this.f28581c || this.f28579a || !C8388a.f28432a.mo40199a(this.f28585h.mo40130a(), aVar)) {
            return false;
        }
        if (aVar.mo40068a().mo40556f().equals(mo40277a().mo40130a().mo40068a().mo40556f())) {
            return true;
        }
        if (this.f28590m == null || adVar == null || adVar.mo40131b().type() != Type.DIRECT || this.f28585h.mo40131b().type() != Type.DIRECT || !this.f28585h.mo40132c().equals(adVar.mo40132c()) || adVar.mo40130a().mo40080j() != C8451d.f28651a || !mo40283a(aVar.mo40068a())) {
            return false;
        }
        try {
            aVar.mo40081k().mo40180a(aVar.mo40068a().mo40556f(), mo40287d().mo40527c());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    /* renamed from: a */
    public boolean mo40283a(C8506t tVar) {
        if (tVar.mo40557g() != this.f28585h.mo40130a().mo40068a().mo40557g()) {
            return false;
        }
        boolean z = true;
        if (!tVar.mo40556f().equals(this.f28585h.mo40130a().mo40068a().mo40556f()) && (this.f28588k == null || !C8451d.f28651a.mo40352a(tVar.mo40556f(), (X509Certificate) this.f28588k.mo40527c().get(0)))) {
            z = false;
        }
        return z;
    }

    /* renamed from: a */
    public C8406c mo40278a(C8513x xVar, C8509a aVar, C8434f fVar) throws SocketException {
        C8460e eVar = this.f28590m;
        if (eVar != null) {
            return new C8458d(xVar, aVar, fVar, eVar);
        }
        this.f28587j.setSoTimeout(aVar.mo40248c());
        this.f28591n.mo40203a().mo40804a((long) aVar.mo40248c(), TimeUnit.MILLISECONDS);
        this.f28592o.mo40271a().mo40804a((long) aVar.mo40249d(), TimeUnit.MILLISECONDS);
        return new C8420a(xVar, fVar, this.f28591n, this.f28592o);
    }

    /* renamed from: a */
    public C8367ad mo40277a() {
        return this.f28585h;
    }

    /* renamed from: b */
    public void mo40285b() {
        C8417c.m36042a(this.f28586i);
    }

    /* renamed from: c */
    public Socket mo40286c() {
        return this.f28587j;
    }

    /* renamed from: a */
    public boolean mo40284a(boolean z) {
        int soTimeout;
        if (this.f28587j.isClosed() || this.f28587j.isInputShutdown() || this.f28587j.isOutputShutdown()) {
            return false;
        }
        C8460e eVar = this.f28590m;
        if (eVar != null) {
            return !eVar.mo40386d();
        }
        if (z) {
            try {
                soTimeout = this.f28587j.getSoTimeout();
                this.f28587j.setSoTimeout(1);
                if (this.f28591n.mo40755f()) {
                    this.f28587j.setSoTimeout(soTimeout);
                    return false;
                }
                this.f28587j.setSoTimeout(soTimeout);
                return true;
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            } catch (Throwable th) {
                this.f28587j.setSoTimeout(soTimeout);
                throw th;
            }
        }
        return true;
    }

    /* renamed from: a */
    public void mo40281a(C8478g gVar) throws IOException {
        gVar.mo40407a(ErrorCode.REFUSED_STREAM);
    }

    /* renamed from: a */
    public void mo40280a(C8460e eVar) {
        synchronized (this.f28584g) {
            this.f28581c = eVar.mo40365a();
        }
    }

    /* renamed from: d */
    public C8503r mo40287d() {
        return this.f28588k;
    }

    /* renamed from: e */
    public boolean mo40288e() {
        return this.f28590m != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.f28585h.mo40130a().mo40068a().mo40556f());
        sb.append(":");
        sb.append(this.f28585h.mo40130a().mo40068a().mo40557g());
        sb.append(", proxy=");
        sb.append(this.f28585h.mo40131b());
        sb.append(" hostAddress=");
        sb.append(this.f28585h.mo40132c());
        sb.append(" cipherSuite=");
        C8503r rVar = this.f28588k;
        sb.append(rVar != null ? rVar.mo40526b() : SchedulerSupport.NONE);
        sb.append(" protocol=");
        sb.append(this.f28589l);
        sb.append('}');
        return sb.toString();
    }
}
