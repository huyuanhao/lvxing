package com.bytedance.sdk.p145a.p147b.p148a.p150b;

import com.bytedance.sdk.p145a.p146a.BufferedSink;
import com.bytedance.sdk.p145a.p146a.BufferedSource;
import com.bytedance.sdk.p145a.p146a.Okio;
import com.bytedance.sdk.p145a.p146a.Source;
import com.bytedance.sdk.p145a.p147b.Address;
import com.bytedance.sdk.p145a.p147b.C1918ab;
import com.bytedance.sdk.p145a.p147b.C1918ab.C1919a;
import com.bytedance.sdk.p145a.p147b.Call;
import com.bytedance.sdk.p145a.p147b.Connection;
import com.bytedance.sdk.p145a.p147b.ConnectionPool;
import com.bytedance.sdk.p145a.p147b.EventListener;
import com.bytedance.sdk.p145a.p147b.Handshake;
import com.bytedance.sdk.p145a.p147b.HttpUrl;
import com.bytedance.sdk.p145a.p147b.Interceptor.C1939a;
import com.bytedance.sdk.p145a.p147b.OkHttpClient;
import com.bytedance.sdk.p145a.p147b.Protocol;
import com.bytedance.sdk.p145a.p147b.Response;
import com.bytedance.sdk.p145a.p147b.Route;
import com.bytedance.sdk.p145a.p147b.p148a.C1876c;
import com.bytedance.sdk.p145a.p147b.p148a.Internal;
import com.bytedance.sdk.p145a.p147b.p148a.Version;
import com.bytedance.sdk.p145a.p147b.p148a.p151c.HttpCodec;
import com.bytedance.sdk.p145a.p147b.p148a.p151c.HttpHeaders;
import com.bytedance.sdk.p145a.p147b.p148a.p152d.Http1Codec;
import com.bytedance.sdk.p145a.p147b.p148a.p153e.ErrorCode;
import com.bytedance.sdk.p145a.p147b.p148a.p153e.Http2Codec;
import com.bytedance.sdk.p145a.p147b.p148a.p153e.Http2Connection;
import com.bytedance.sdk.p145a.p147b.p148a.p153e.Http2Connection.C1898a;
import com.bytedance.sdk.p145a.p147b.p148a.p153e.Http2Connection.C1899b;
import com.bytedance.sdk.p145a.p147b.p148a.p153e.Http2Stream;
import com.bytedance.sdk.p145a.p147b.p148a.p155g.Platform;
import com.bytedance.sdk.p145a.p147b.p148a.p157i.OkHostnameVerifier;
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
import javax.net.ssl.SSLPeerUnverifiedException;
import p655io.reactivex.annotations.SchedulerSupport;

/* renamed from: com.bytedance.sdk.a.b.a.b.c */
public final class RealConnection extends C1899b implements Connection {
    /* renamed from: a */
    public boolean f5355a;
    /* renamed from: b */
    public int f5356b;
    /* renamed from: c */
    public int f5357c = 1;
    /* renamed from: d */
    public final List<Reference<StreamAllocation>> f5358d = new ArrayList();
    /* renamed from: e */
    public long f5359e = Long.MAX_VALUE;
    /* renamed from: g */
    private final ConnectionPool f5360g;
    /* renamed from: h */
    private final Route f5361h;
    /* renamed from: i */
    private Socket f5362i;
    /* renamed from: j */
    private Socket f5363j;
    /* renamed from: k */
    private Handshake f5364k;
    /* renamed from: l */
    private Protocol f5365l;
    /* renamed from: m */
    private Http2Connection f5366m;
    /* renamed from: n */
    private BufferedSource f5367n;
    /* renamed from: o */
    private BufferedSink f5368o;

    public RealConnection(ConnectionPool mVar, Route dVar) {
        this.f5360g = mVar;
        this.f5361h = dVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x009c, code lost:
            m6900a(r10, r8, r9);
            r9.mo14054a(r8, r7.f5361h.mo13971c(), r7.f5361h.mo13970b(), r7.f5365l);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00b6, code lost:
            if (r7.f5361h.mo13972d() == false) goto L_0x00ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00ba, code lost:
            if (r7.f5362i == null) goto L_0x00bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00c9, code lost:
            throw new com.bytedance.sdk.p145a.p147b.p148a.p150b.RouteException(new java.net.ProtocolException("Too many tunnel connections attempted: 21"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00cc, code lost:
            if (r7.f5366m == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00ce, code lost:
            r1 = r7.f5360g;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00d0, code lost:
            monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
            r7.f5357c = r7.f5366m.mo13769a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00d9, code lost:
            monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
            return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
            return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x011c  */
    /* renamed from: a */
    public void mo13690a(int r16, int r17, int r18, boolean r19, com.bytedance.sdk.p145a.p147b.Call r20, com.bytedance.sdk.p145a.p147b.EventListener r21) {
        /*
        r15 = this;
        r7 = r15
        r8 = r20
        r9 = r21
        com.bytedance.sdk.a.b.w r0 = r7.f5365l
        if (r0 != 0) goto L_0x012a
        com.bytedance.sdk.a.b.d r0 = r7.f5361h
        com.bytedance.sdk.a.b.a r0 = r0.mo13969a()
        java.util.List r0 = r0.mo13646f()
        com.bytedance.sdk.a.b.a.b.b r10 = new com.bytedance.sdk.a.b.a.b.b
        r10.m42928init(r0)
        com.bytedance.sdk.a.b.d r1 = r7.f5361h
        com.bytedance.sdk.a.b.a r1 = r1.mo13969a()
        javax.net.ssl.SSLSocketFactory r1 = r1.mo13650i()
        if (r1 != 0) goto L_0x0073
        com.bytedance.sdk.a.b.n r1 = com.bytedance.sdk.p145a.p147b.ConnectionSpec.f5921c
        boolean r0 = r0.contains(r1)
        if (r0 == 0) goto L_0x0066
        com.bytedance.sdk.a.b.d r0 = r7.f5361h
        com.bytedance.sdk.a.b.a r0 = r0.mo13969a()
        com.bytedance.sdk.a.b.v r0 = r0.mo13639a()
        java.lang.String r0 = r0.mo14092f()
        com.bytedance.sdk.a.b.a.g.e r1 = com.bytedance.sdk.p145a.p147b.p148a.p155g.Platform.m7295b()
        boolean r1 = r1.mo13877b(r0)
        if (r1 == 0) goto L_0x0045
        goto L_0x0073
    L_0x0045:
        com.bytedance.sdk.a.b.a.b.e r1 = new com.bytedance.sdk.a.b.a.b.e
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
        r1.m42932init(r2)
        throw r1
    L_0x0066:
        com.bytedance.sdk.a.b.a.b.e r0 = new com.bytedance.sdk.a.b.a.b.e
        java.net.UnknownServiceException r1 = new java.net.UnknownServiceException
        java.lang.String r2 = "CLEARTEXT communication not enabled for client"
        r1.<init>(r2)
        r0.m42932init(r1)
        throw r0
    L_0x0073:
        r11 = 0
        r12 = r11
    L_0x0075:
        com.bytedance.sdk.a.b.d r0 = r7.f5361h     // Catch:{ IOException -> 0x00e1 }
        boolean r0 = r0.mo13972d()     // Catch:{ IOException -> 0x00e1 }
        if (r0 == 0) goto L_0x0095
        r1 = r15
        r2 = r16
        r3 = r17
        r4 = r18
        r5 = r20
        r6 = r21
        r1.m6897a(r2, r3, r4, r5, r6)     // Catch:{ IOException -> 0x00e1 }
        java.net.Socket r0 = r7.f5362i     // Catch:{ IOException -> 0x00e1 }
        if (r0 != 0) goto L_0x0090
        goto L_0x00b0
    L_0x0090:
        r13 = r16
        r14 = r17
        goto L_0x009c
    L_0x0095:
        r13 = r16
        r14 = r17
        r15.m6898a(r13, r14, r8, r9)     // Catch:{ IOException -> 0x00df }
    L_0x009c:
        r15.m6900a(r10, r8, r9)     // Catch:{ IOException -> 0x00df }
        com.bytedance.sdk.a.b.d r0 = r7.f5361h     // Catch:{ IOException -> 0x00df }
        java.net.InetSocketAddress r0 = r0.mo13971c()     // Catch:{ IOException -> 0x00df }
        com.bytedance.sdk.a.b.d r1 = r7.f5361h     // Catch:{ IOException -> 0x00df }
        java.net.Proxy r1 = r1.mo13970b()     // Catch:{ IOException -> 0x00df }
        com.bytedance.sdk.a.b.w r2 = r7.f5365l     // Catch:{ IOException -> 0x00df }
        r9.mo14054a(r8, r0, r1, r2)     // Catch:{ IOException -> 0x00df }
    L_0x00b0:
        com.bytedance.sdk.a.b.d r0 = r7.f5361h
        boolean r0 = r0.mo13972d()
        if (r0 == 0) goto L_0x00ca
        java.net.Socket r0 = r7.f5362i
        if (r0 == 0) goto L_0x00bd
        goto L_0x00ca
    L_0x00bd:
        java.net.ProtocolException r0 = new java.net.ProtocolException
        java.lang.String r1 = "Too many tunnel connections attempted: 21"
        r0.<init>(r1)
        com.bytedance.sdk.a.b.a.b.e r1 = new com.bytedance.sdk.a.b.a.b.e
        r1.m42932init(r0)
        throw r1
    L_0x00ca:
        com.bytedance.sdk.a.b.a.e.g r0 = r7.f5366m
        if (r0 == 0) goto L_0x00de
        com.bytedance.sdk.a.b.m r1 = r7.f5360g
        monitor-enter(r1)
        com.bytedance.sdk.a.b.a.e.g r0 = r7.f5366m     // Catch:{ all -> 0x00db }
        int r0 = r0.mo13769a()     // Catch:{ all -> 0x00db }
        r7.f5357c = r0     // Catch:{ all -> 0x00db }
        monitor-exit(r1)     // Catch:{ all -> 0x00db }
        goto L_0x00de
    L_0x00db:
        r0 = move-exception
        monitor-exit(r1)     // Catch:{ all -> 0x00db }
        throw r0
    L_0x00de:
        return
    L_0x00df:
        r0 = move-exception
        goto L_0x00e6
    L_0x00e1:
        r0 = move-exception
        r13 = r16
        r14 = r17
    L_0x00e6:
        java.net.Socket r1 = r7.f5363j
        com.bytedance.sdk.p145a.p147b.p148a.C1876c.m6962a(r1)
        java.net.Socket r1 = r7.f5362i
        com.bytedance.sdk.p145a.p147b.p148a.C1876c.m6962a(r1)
        r7.f5363j = r11
        r7.f5362i = r11
        r7.f5367n = r11
        r7.f5368o = r11
        r7.f5364k = r11
        r7.f5365l = r11
        r7.f5366m = r11
        com.bytedance.sdk.a.b.d r1 = r7.f5361h
        java.net.InetSocketAddress r3 = r1.mo13971c()
        com.bytedance.sdk.a.b.d r1 = r7.f5361h
        java.net.Proxy r4 = r1.mo13970b()
        r5 = 0
        r1 = r21
        r2 = r20
        r6 = r0
        r1.mo14055a(r2, r3, r4, r5, r6)
        if (r12 != 0) goto L_0x011c
        com.bytedance.sdk.a.b.a.b.e r1 = new com.bytedance.sdk.a.b.a.b.e
        r1.m42932init(r0)
        r12 = r1
        goto L_0x011f
    L_0x011c:
        r12.mo13704a(r0)
    L_0x011f:
        if (r19 == 0) goto L_0x0129
        boolean r0 = r10.mo13687a(r0)
        if (r0 == 0) goto L_0x0129
        goto L_0x0075
    L_0x0129:
        throw r12
    L_0x012a:
        java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
        java.lang.String r1 = "already connected"
        r0.<init>(r1)
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.p145a.p147b.p148a.p150b.RealConnection.mo13690a(int, int, int, boolean, com.bytedance.sdk.a.b.h, com.bytedance.sdk.a.b.s):void");
    }

    /* renamed from: a */
    private void m6897a(int i, int i2, int i3, Call hVar, EventListener sVar) throws IOException {
        C1918ab e = m6901e();
        HttpUrl a = e.mo13910a();
        int i4 = 0;
        while (i4 < 21) {
            m6898a(i, i2, hVar, sVar);
            e = m6896a(i2, i3, e, a);
            if (e != null) {
                C1876c.m6962a(this.f5362i);
                this.f5362i = null;
                this.f5368o = null;
                this.f5367n = null;
                sVar.mo14054a(hVar, this.f5361h.mo13971c(), this.f5361h.mo13970b(), null);
                i4++;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    private void m6898a(int i, int i2, Call hVar, EventListener sVar) throws IOException {
        Proxy b = this.f5361h.mo13970b();
        Socket createSocket = (b.type() == Type.DIRECT || b.type() == Type.HTTP) ? this.f5361h.mo13969a().mo13642c().createSocket() : new Socket(b);
        this.f5362i = createSocket;
        sVar.mo14053a(hVar, this.f5361h.mo13971c(), b);
        this.f5362i.setSoTimeout(i2);
        try {
            Platform.m7295b().mo13874a(this.f5362i, this.f5361h.mo13971c(), i);
            try {
                this.f5367n = Okio.m6747a(Okio.m6753b(this.f5362i));
                this.f5368o = Okio.m6746a(Okio.m6749a(this.f5362i));
            } catch (NullPointerException e) {
                if ("throw with null exception".equals(e.getMessage())) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to connect to ");
            sb.append(this.f5361h.mo13971c());
            ConnectException connectException = new ConnectException(sb.toString());
            connectException.initCause(e2);
            throw connectException;
        }
    }

    /* renamed from: a */
    private void m6900a(ConnectionSpecSelector bVar, Call hVar, EventListener sVar) throws IOException {
        if (this.f5361h.mo13969a().mo13650i() == null) {
            this.f5365l = Protocol.HTTP_1_1;
            this.f5363j = this.f5362i;
            return;
        }
        sVar.mo14056b(hVar);
        m6899a(bVar);
        sVar.mo14049a(hVar, this.f5364k);
        if (this.f5365l == Protocol.HTTP_2) {
            this.f5363j.setSoTimeout(0);
            this.f5366m = new C1898a(true).mo13794a(this.f5363j, this.f5361h.mo13969a().mo13639a().mo14092f(), this.f5367n, this.f5368o).mo13793a(this).mo13795a();
            this.f5366m.mo13788c();
        }
    }

    /* JADX WARNING: type inference failed for: r2v1 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0115 A[Catch:{ all -> 0x010b }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x011b A[Catch:{ all -> 0x010b }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x011e  */
    /* renamed from: a */
    private void m6899a(com.bytedance.sdk.p145a.p147b.p148a.p150b.ConnectionSpecSelector r8) throws java.io.IOException {
        /*
        r7 = this;
        com.bytedance.sdk.a.b.d r0 = r7.f5361h
        com.bytedance.sdk.a.b.a r0 = r0.mo13969a()
        javax.net.ssl.SSLSocketFactory r1 = r0.mo13650i()
        r2 = 0
        java.net.Socket r3 = r7.f5362i     // Catch:{ AssertionError -> 0x010e }
        com.bytedance.sdk.a.b.v r4 = r0.mo13639a()     // Catch:{ AssertionError -> 0x010e }
        java.lang.String r4 = r4.mo14092f()     // Catch:{ AssertionError -> 0x010e }
        com.bytedance.sdk.a.b.v r5 = r0.mo13639a()     // Catch:{ AssertionError -> 0x010e }
        int r5 = r5.mo14093g()     // Catch:{ AssertionError -> 0x010e }
        r6 = 1
        java.net.Socket r1 = r1.createSocket(r3, r4, r5, r6)     // Catch:{ AssertionError -> 0x010e }
        javax.net.ssl.SSLSocket r1 = (javax.net.ssl.SSLSocket) r1     // Catch:{ AssertionError -> 0x010e }
        com.bytedance.sdk.a.b.n r8 = r8.mo13686a(r1)     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        boolean r3 = r8.mo14020d()     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        if (r3 == 0) goto L_0x0041
        com.bytedance.sdk.a.b.a.g.e r3 = com.bytedance.sdk.p145a.p147b.p148a.p155g.Platform.m7295b()     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        com.bytedance.sdk.a.b.v r4 = r0.mo13639a()     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        java.lang.String r4 = r4.mo14092f()     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        java.util.List r5 = r0.mo13644e()     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        r3.mo13875a(r1, r4, r5)     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
    L_0x0041:
        r1.startHandshake()     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        javax.net.ssl.SSLSession r3 = r1.getSession()     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        com.bytedance.sdk.a.b.t r3 = com.bytedance.sdk.p145a.p147b.Handshake.m7519a(r3)     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        javax.net.ssl.HostnameVerifier r4 = r0.mo13651j()     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        com.bytedance.sdk.a.b.v r5 = r0.mo13639a()     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        java.lang.String r5 = r5.mo14092f()     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        javax.net.ssl.SSLSession r6 = r1.getSession()     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        boolean r4 = r4.verify(r5, r6)     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        if (r4 == 0) goto L_0x00b4
        com.bytedance.sdk.a.b.j r4 = r0.mo13652k()     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        com.bytedance.sdk.a.b.v r0 = r0.mo13639a()     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        java.lang.String r0 = r0.mo14092f()     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        java.util.List r5 = r3.mo14066b()     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        r4.mo13998a(r0, r5)     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        boolean r8 = r8.mo14020d()     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        if (r8 == 0) goto L_0x0083
        com.bytedance.sdk.a.b.a.g.e r8 = com.bytedance.sdk.p145a.p147b.p148a.p155g.Platform.m7295b()     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        java.lang.String r2 = r8.mo13871a(r1)     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
    L_0x0083:
        r7.f5363j = r1     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        java.net.Socket r8 = r7.f5363j     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        com.bytedance.sdk.a.a.s r8 = com.bytedance.sdk.p145a.p146a.Okio.m6753b(r8)     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        com.bytedance.sdk.a.a.e r8 = com.bytedance.sdk.p145a.p146a.Okio.m6747a(r8)     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        r7.f5367n = r8     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        java.net.Socket r8 = r7.f5363j     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        com.bytedance.sdk.a.a.r r8 = com.bytedance.sdk.p145a.p146a.Okio.m6749a(r8)     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        com.bytedance.sdk.a.a.d r8 = com.bytedance.sdk.p145a.p146a.Okio.m6746a(r8)     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        r7.f5368o = r8     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        r7.f5364k = r3     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        if (r2 == 0) goto L_0x00a6
        com.bytedance.sdk.a.b.w r8 = com.bytedance.sdk.p145a.p147b.Protocol.m7586a(r2)     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        goto L_0x00a8
    L_0x00a6:
        com.bytedance.sdk.a.b.w r8 = com.bytedance.sdk.p145a.p147b.Protocol.HTTP_1_1     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
    L_0x00a8:
        r7.f5365l = r8     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        if (r1 == 0) goto L_0x00b3
        com.bytedance.sdk.a.b.a.g.e r8 = com.bytedance.sdk.p145a.p147b.p148a.p155g.Platform.m7295b()
        r8.mo13886b(r1)
    L_0x00b3:
        return
    L_0x00b4:
        java.util.List r8 = r3.mo14066b()     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        r2 = 0
        java.lang.Object r8 = r8.get(r2)     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        java.security.cert.X509Certificate r8 = (java.security.cert.X509Certificate) r8     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        javax.net.ssl.SSLPeerUnverifiedException r2 = new javax.net.ssl.SSLPeerUnverifiedException     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        r3.<init>()     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        java.lang.String r4 = "Hostname "
        r3.append(r4)     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        com.bytedance.sdk.a.b.v r0 = r0.mo13639a()     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        java.lang.String r0 = r0.mo14092f()     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        r3.append(r0)     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        java.lang.String r0 = " not verified:\n    certificate: "
        r3.append(r0)     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        java.lang.String r0 = com.bytedance.sdk.p145a.p147b.CertificatePinner.m7440a(r8)     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        r3.append(r0)     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        java.lang.String r0 = "\n    DN: "
        r3.append(r0)     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        java.security.Principal r0 = r8.getSubjectDN()     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        java.lang.String r0 = r0.getName()     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        r3.append(r0)     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        java.lang.String r0 = "\n    subjectAltNames: "
        r3.append(r0)     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        java.util.List r8 = com.bytedance.sdk.p145a.p147b.p148a.p157i.OkHostnameVerifier.m7326a(r8)     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        r3.append(r8)     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        java.lang.String r8 = r3.toString()     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        r2.<init>(r8)     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        throw r2     // Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
    L_0x0106:
        r8 = move-exception
        goto L_0x011c
    L_0x0108:
        r8 = move-exception
        r2 = r1
        goto L_0x010f
    L_0x010b:
        r8 = move-exception
        r1 = r2
        goto L_0x011c
    L_0x010e:
        r8 = move-exception
    L_0x010f:
        boolean r0 = com.bytedance.sdk.p145a.p147b.p148a.C1876c.m6964a(r8)     // Catch:{ all -> 0x010b }
        if (r0 == 0) goto L_0x011b
        java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x010b }
        r0.<init>(r8)     // Catch:{ all -> 0x010b }
        throw r0     // Catch:{ all -> 0x010b }
    L_0x011b:
        throw r8     // Catch:{ all -> 0x010b }
    L_0x011c:
        if (r1 == 0) goto L_0x0125
        com.bytedance.sdk.a.b.a.g.e r0 = com.bytedance.sdk.p145a.p147b.p148a.p155g.Platform.m7295b()
        r0.mo13886b(r1)
    L_0x0125:
        com.bytedance.sdk.p145a.p147b.p148a.C1876c.m6962a(r1)
        throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.p145a.p147b.p148a.p150b.RealConnection.m6899a(com.bytedance.sdk.a.b.a.b.b):void");
    }

    /* renamed from: a */
    private C1918ab m6896a(int i, int i2, C1918ab abVar, HttpUrl vVar) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("CONNECT ");
        sb.append(C1876c.m6953a(vVar, true));
        sb.append(" HTTP/1.1");
        String sb2 = sb.toString();
        while (true) {
            Http1Codec aVar = new Http1Codec(null, null, this.f5367n, this.f5368o);
            this.f5367n.mo13512a().mo13610a((long) i, TimeUnit.MILLISECONDS);
            this.f5368o.mo13506a().mo13610a((long) i2, TimeUnit.MILLISECONDS);
            aVar.mo13752a(abVar.mo13913c(), sb2);
            aVar.mo13730b();
            Response a = aVar.mo13726a(false).mo13955a(abVar).mo13963a();
            long a2 = HttpHeaders.m6993a(a);
            if (a2 == -1) {
                a2 = 0;
            }
            Source b = aVar.mo13753b(a2);
            C1876c.m6971b(b, (int) ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, TimeUnit.MILLISECONDS);
            b.close();
            int c = a.mo13941c();
            if (c != 200) {
                if (c == 407) {
                    C1918ab a3 = this.f5361h.mo13969a().mo13643d().mo13976a(this.f5361h, a);
                    if (a3 != null) {
                        if ("close".equalsIgnoreCase(a.mo13938a("Connection"))) {
                            return a3;
                        }
                        abVar = a3;
                    } else {
                        throw new IOException("Failed to authenticate with proxy");
                    }
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Unexpected response code for CONNECT: ");
                    sb3.append(a.mo13941c());
                    throw new IOException(sb3.toString());
                }
            } else if (this.f5367n.mo13535c().mo13546e() && this.f5368o.mo13535c().mo13546e()) {
                return null;
            } else {
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
        }
    }

    /* renamed from: e */
    private C1918ab m6901e() {
        return new C1919a().mo13922a(this.f5361h.mo13969a().mo13639a()).mo13925a("Host", C1876c.m6953a(this.f5361h.mo13969a().mo13639a(), true)).mo13925a("Proxy-Connection", "Keep-Alive").mo13925a("User-Agent", Version.m7030a()).mo13933d();
    }

    /* renamed from: a */
    public boolean mo13693a(Address aVar, Route dVar) {
        if (this.f5358d.size() >= this.f5357c || this.f5355a || !Internal.f5302a.mo13662a(this.f5361h.mo13969a(), aVar)) {
            return false;
        }
        if (aVar.mo13639a().mo14092f().equals(mo13689a().mo13969a().mo13639a().mo14092f())) {
            return true;
        }
        if (this.f5366m == null || dVar == null || dVar.mo13970b().type() != Type.DIRECT || this.f5361h.mo13970b().type() != Type.DIRECT || !this.f5361h.mo13971c().equals(dVar.mo13971c()) || dVar.mo13969a().mo13651j() != OkHostnameVerifier.f5699a || !mo13694a(aVar.mo13639a())) {
            return false;
        }
        try {
            aVar.mo13652k().mo13998a(aVar.mo13639a().mo14092f(), mo13697c().mo14066b());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    /* renamed from: a */
    public boolean mo13694a(HttpUrl vVar) {
        if (vVar.mo14093g() != this.f5361h.mo13969a().mo13639a().mo14093g()) {
            return false;
        }
        boolean z = true;
        if (!vVar.mo14092f().equals(this.f5361h.mo13969a().mo13639a().mo14092f()) && (this.f5364k == null || !OkHostnameVerifier.f5699a.mo13900a(vVar.mo14092f(), (X509Certificate) this.f5364k.mo14066b().get(0)))) {
            z = false;
        }
        return z;
    }

    /* renamed from: a */
    public HttpCodec mo13688a(OkHttpClient zVar, C1939a aVar, StreamAllocation gVar) throws SocketException {
        Http2Connection gVar2 = this.f5366m;
        if (gVar2 != null) {
            return new Http2Codec(zVar, aVar, gVar, gVar2);
        }
        this.f5363j.setSoTimeout(aVar.mo13737c());
        this.f5367n.mo13512a().mo13610a((long) aVar.mo13737c(), TimeUnit.MILLISECONDS);
        this.f5368o.mo13506a().mo13610a((long) aVar.mo13738d(), TimeUnit.MILLISECONDS);
        return new Http1Codec(zVar, gVar, this.f5367n, this.f5368o);
    }

    /* renamed from: a */
    public Route mo13689a() {
        return this.f5361h;
    }

    /* renamed from: b */
    public Socket mo13696b() {
        return this.f5363j;
    }

    /* renamed from: a */
    public boolean mo13695a(boolean z) {
        int soTimeout;
        if (this.f5363j.isClosed() || this.f5363j.isInputShutdown() || this.f5363j.isOutputShutdown()) {
            return false;
        }
        Http2Connection gVar = this.f5366m;
        if (gVar != null) {
            return !gVar.mo13791d();
        }
        if (z) {
            try {
                soTimeout = this.f5363j.getSoTimeout();
                this.f5363j.setSoTimeout(1);
                if (this.f5367n.mo13546e()) {
                    this.f5363j.setSoTimeout(soTimeout);
                    return false;
                }
                this.f5363j.setSoTimeout(soTimeout);
                return true;
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            } catch (Throwable th) {
                this.f5363j.setSoTimeout(soTimeout);
                throw th;
            }
        }
        return true;
    }

    /* renamed from: a */
    public void mo13692a(Http2Stream iVar) throws IOException {
        iVar.mo13812a(ErrorCode.REFUSED_STREAM);
    }

    /* renamed from: a */
    public void mo13691a(Http2Connection gVar) {
        synchronized (this.f5360g) {
            this.f5357c = gVar.mo13769a();
        }
    }

    /* renamed from: c */
    public Handshake mo13697c() {
        return this.f5364k;
    }

    /* renamed from: d */
    public boolean mo13698d() {
        return this.f5366m != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.f5361h.mo13969a().mo13639a().mo14092f());
        sb.append(":");
        sb.append(this.f5361h.mo13969a().mo13639a().mo14093g());
        sb.append(", proxy=");
        sb.append(this.f5361h.mo13970b());
        sb.append(" hostAddress=");
        sb.append(this.f5361h.mo13971c());
        sb.append(" cipherSuite=");
        Handshake tVar = this.f5364k;
        sb.append(tVar != null ? tVar.mo14065a() : SchedulerSupport.NONE);
        sb.append(" protocol=");
        sb.append(this.f5365l);
        sb.append('}');
        return sb.toString();
    }
}
