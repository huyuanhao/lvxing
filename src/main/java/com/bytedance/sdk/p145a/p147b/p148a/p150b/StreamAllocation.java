package com.bytedance.sdk.p145a.p147b.p148a.p150b;

import com.bytedance.sdk.p145a.p147b.Address;
import com.bytedance.sdk.p145a.p147b.Call;
import com.bytedance.sdk.p145a.p147b.Connection;
import com.bytedance.sdk.p145a.p147b.ConnectionPool;
import com.bytedance.sdk.p145a.p147b.EventListener;
import com.bytedance.sdk.p145a.p147b.Interceptor.C1939a;
import com.bytedance.sdk.p145a.p147b.OkHttpClient;
import com.bytedance.sdk.p145a.p147b.Route;
import com.bytedance.sdk.p145a.p147b.p148a.C1876c;
import com.bytedance.sdk.p145a.p147b.p148a.Internal;
import com.bytedance.sdk.p145a.p147b.p148a.p150b.RouteSelector.C1874a;
import com.bytedance.sdk.p145a.p147b.p148a.p151c.HttpCodec;
import com.bytedance.sdk.p145a.p147b.p148a.p153e.ConnectionShutdownException;
import com.bytedance.sdk.p145a.p147b.p148a.p153e.ErrorCode;
import com.bytedance.sdk.p145a.p147b.p148a.p153e.StreamResetException;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;

/* renamed from: com.bytedance.sdk.a.b.a.b.g */
public final class StreamAllocation {
    /* renamed from: d */
    static final /* synthetic */ boolean f5382d = (!StreamAllocation.class.desiredAssertionStatus());
    /* renamed from: a */
    public final Address f5383a;
    /* renamed from: b */
    public final Call f5384b;
    /* renamed from: c */
    public final EventListener f5385c;
    /* renamed from: e */
    private C1874a f5386e;
    /* renamed from: f */
    private Route f5387f;
    /* renamed from: g */
    private final ConnectionPool f5388g;
    /* renamed from: h */
    private final Object f5389h;
    /* renamed from: i */
    private final RouteSelector f5390i;
    /* renamed from: j */
    private int f5391j;
    /* renamed from: k */
    private RealConnection f5392k;
    /* renamed from: l */
    private boolean f5393l;
    /* renamed from: m */
    private boolean f5394m;
    /* renamed from: n */
    private boolean f5395n;
    /* renamed from: o */
    private HttpCodec f5396o;

    /* compiled from: StreamAllocation */
    /* renamed from: com.bytedance.sdk.a.b.a.b.g$a */
    public static final class C1875a extends WeakReference<StreamAllocation> {
        /* renamed from: a */
        public final Object f5397a;

        C1875a(StreamAllocation gVar, Object obj) {
            super(gVar);
            this.f5397a = obj;
        }
    }

    public StreamAllocation(ConnectionPool mVar, Address aVar, Call hVar, EventListener sVar, Object obj) {
        this.f5388g = mVar;
        this.f5383a = aVar;
        this.f5384b = hVar;
        this.f5385c = sVar;
        this.f5390i = new RouteSelector(aVar, m6935g(), hVar, sVar);
        this.f5389h = obj;
    }

    /* renamed from: a */
    public HttpCodec mo13712a(OkHttpClient zVar, C1939a aVar, boolean z) {
        try {
            HttpCodec a = m6931a(aVar.mo13736b(), aVar.mo13737c(), aVar.mo13738d(), zVar.mo14136r(), z).mo13688a(zVar, aVar, this);
            synchronized (this.f5388g) {
                this.f5396o = a;
            }
            return a;
        } catch (IOException e) {
            throw new RouteException(e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
            return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
            if (r0.mo13695a(r8) != false) goto L_0x0018;
     */
    /* renamed from: a */
    private com.bytedance.sdk.p145a.p147b.p148a.p150b.RealConnection m6931a(int r4, int r5, int r6, boolean r7, boolean r8) throws java.io.IOException {
        /*
        r3 = this;
    L_0x0000:
        com.bytedance.sdk.a.b.a.b.c r0 = r3.m6930a(r4, r5, r6, r7)
        com.bytedance.sdk.a.b.m r1 = r3.f5388g
        monitor-enter(r1)
        int r2 = r0.f5356b     // Catch:{ all -> 0x0019 }
        if (r2 != 0) goto L_0x000d
        monitor-exit(r1)     // Catch:{ all -> 0x0019 }
        return r0
    L_0x000d:
        monitor-exit(r1)     // Catch:{ all -> 0x0019 }
        boolean r1 = r0.mo13695a(r8)
        if (r1 != 0) goto L_0x0018
        r3.mo13719d()
        goto L_0x0000
    L_0x0018:
        return r0
    L_0x0019:
        r4 = move-exception
        monitor-exit(r1)     // Catch:{ all -> 0x0019 }
        throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.p145a.p147b.p148a.p150b.StreamAllocation.m6931a(int, int, int, boolean, boolean):com.bytedance.sdk.a.b.a.b.c");
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x0079 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00cb  */
    /* renamed from: a */
    private com.bytedance.sdk.p145a.p147b.p148a.p150b.RealConnection m6930a(int r18, int r19, int r20, boolean r21) throws java.io.IOException {
        /*
        r17 = this;
        r1 = r17
        com.bytedance.sdk.a.b.m r2 = r1.f5388g
        monitor-enter(r2)
        boolean r0 = r1.f5394m     // Catch:{ all -> 0x0138 }
        if (r0 != 0) goto L_0x0130
        com.bytedance.sdk.a.b.a.c.c r0 = r1.f5396o     // Catch:{ all -> 0x0138 }
        if (r0 != 0) goto L_0x0128
        boolean r0 = r1.f5395n     // Catch:{ all -> 0x0138 }
        if (r0 != 0) goto L_0x0120
        com.bytedance.sdk.a.b.a.b.c r0 = r1.f5392k     // Catch:{ all -> 0x0138 }
        java.net.Socket r3 = r17.m6934f()     // Catch:{ all -> 0x0138 }
        com.bytedance.sdk.a.b.a.b.c r4 = r1.f5392k     // Catch:{ all -> 0x0138 }
        r5 = 0
        if (r4 == 0) goto L_0x0020
        com.bytedance.sdk.a.b.a.b.c r0 = r1.f5392k     // Catch:{ all -> 0x0138 }
        r4 = r5
        goto L_0x0022
    L_0x0020:
        r4 = r0
        r0 = r5
    L_0x0022:
        boolean r6 = r1.f5393l     // Catch:{ all -> 0x0138 }
        if (r6 != 0) goto L_0x0027
        r4 = r5
    L_0x0027:
        r6 = 1
        r7 = 0
        if (r0 != 0) goto L_0x0043
        com.bytedance.sdk.a.b.a.a r8 = com.bytedance.sdk.p145a.p147b.p148a.Internal.f5302a     // Catch:{ all -> 0x0138 }
        com.bytedance.sdk.a.b.m r9 = r1.f5388g     // Catch:{ all -> 0x0138 }
        com.bytedance.sdk.a.b.a r10 = r1.f5383a     // Catch:{ all -> 0x0138 }
        r8.mo13655a(r9, r10, r1, r5)     // Catch:{ all -> 0x0138 }
        com.bytedance.sdk.a.b.a.b.c r8 = r1.f5392k     // Catch:{ all -> 0x0138 }
        if (r8 == 0) goto L_0x003e
        com.bytedance.sdk.a.b.a.b.c r0 = r1.f5392k     // Catch:{ all -> 0x0138 }
        r8 = r0
        r9 = r5
        r0 = 1
        goto L_0x0046
    L_0x003e:
        com.bytedance.sdk.a.b.d r8 = r1.f5387f     // Catch:{ all -> 0x0138 }
        r9 = r8
        r8 = r0
        goto L_0x0045
    L_0x0043:
        r8 = r0
        r9 = r5
    L_0x0045:
        r0 = 0
    L_0x0046:
        monitor-exit(r2)     // Catch:{ all -> 0x0138 }
        com.bytedance.sdk.p145a.p147b.p148a.C1876c.m6962a(r3)
        if (r4 == 0) goto L_0x0053
        com.bytedance.sdk.a.b.s r2 = r1.f5385c
        com.bytedance.sdk.a.b.h r3 = r1.f5384b
        r2.mo14058b(r3, r4)
    L_0x0053:
        if (r0 == 0) goto L_0x005c
        com.bytedance.sdk.a.b.s r2 = r1.f5385c
        com.bytedance.sdk.a.b.h r3 = r1.f5384b
        r2.mo14048a(r3, r8)
    L_0x005c:
        if (r8 == 0) goto L_0x005f
        return r8
    L_0x005f:
        if (r9 != 0) goto L_0x0075
        com.bytedance.sdk.a.b.a.b.f$a r2 = r1.f5386e
        if (r2 == 0) goto L_0x006b
        boolean r2 = r2.mo13708a()
        if (r2 != 0) goto L_0x0075
    L_0x006b:
        com.bytedance.sdk.a.b.a.b.f r2 = r1.f5390i
        com.bytedance.sdk.a.b.a.b.f$a r2 = r2.mo13707b()
        r1.f5386e = r2
        r2 = 1
        goto L_0x0076
    L_0x0075:
        r2 = 0
    L_0x0076:
        com.bytedance.sdk.a.b.m r3 = r1.f5388g
        monitor-enter(r3)
        boolean r4 = r1.f5395n     // Catch:{ all -> 0x011d }
        if (r4 != 0) goto L_0x0115
        if (r2 == 0) goto L_0x00a8
        com.bytedance.sdk.a.b.a.b.f$a r2 = r1.f5386e     // Catch:{ all -> 0x011d }
        java.util.List r2 = r2.mo13710c()     // Catch:{ all -> 0x011d }
        int r4 = r2.size()     // Catch:{ all -> 0x011d }
        r10 = 0
    L_0x008a:
        if (r10 >= r4) goto L_0x00a8
        java.lang.Object r11 = r2.get(r10)     // Catch:{ all -> 0x011d }
        com.bytedance.sdk.a.b.d r11 = (com.bytedance.sdk.p145a.p147b.Route) r11     // Catch:{ all -> 0x011d }
        com.bytedance.sdk.a.b.a.a r12 = com.bytedance.sdk.p145a.p147b.p148a.Internal.f5302a     // Catch:{ all -> 0x011d }
        com.bytedance.sdk.a.b.m r13 = r1.f5388g     // Catch:{ all -> 0x011d }
        com.bytedance.sdk.a.b.a r14 = r1.f5383a     // Catch:{ all -> 0x011d }
        r12.mo13655a(r13, r14, r1, r11)     // Catch:{ all -> 0x011d }
        com.bytedance.sdk.a.b.a.b.c r12 = r1.f5392k     // Catch:{ all -> 0x011d }
        if (r12 == 0) goto L_0x00a5
        com.bytedance.sdk.a.b.a.b.c r8 = r1.f5392k     // Catch:{ all -> 0x011d }
        r1.f5387f = r11     // Catch:{ all -> 0x011d }
        r0 = 1
        goto L_0x00a8
    L_0x00a5:
        int r10 = r10 + 1
        goto L_0x008a
    L_0x00a8:
        if (r0 != 0) goto L_0x00c0
        if (r9 != 0) goto L_0x00b2
        com.bytedance.sdk.a.b.a.b.f$a r2 = r1.f5386e     // Catch:{ all -> 0x011d }
        com.bytedance.sdk.a.b.d r9 = r2.mo13709b()     // Catch:{ all -> 0x011d }
    L_0x00b2:
        r1.f5387f = r9     // Catch:{ all -> 0x011d }
        r1.f5391j = r7     // Catch:{ all -> 0x011d }
        com.bytedance.sdk.a.b.a.b.c r8 = new com.bytedance.sdk.a.b.a.b.c     // Catch:{ all -> 0x011d }
        com.bytedance.sdk.a.b.m r2 = r1.f5388g     // Catch:{ all -> 0x011d }
        r8.m42929init(r2, r9)     // Catch:{ all -> 0x011d }
        r1.mo13714a(r8, r7)     // Catch:{ all -> 0x011d }
    L_0x00c0:
        monitor-exit(r3)     // Catch:{ all -> 0x011d }
        if (r0 == 0) goto L_0x00cb
        com.bytedance.sdk.a.b.s r0 = r1.f5385c
        com.bytedance.sdk.a.b.h r2 = r1.f5384b
        r0.mo14048a(r2, r8)
        return r8
    L_0x00cb:
        com.bytedance.sdk.a.b.h r15 = r1.f5384b
        com.bytedance.sdk.a.b.s r0 = r1.f5385c
        r10 = r8
        r11 = r18
        r12 = r19
        r13 = r20
        r14 = r21
        r16 = r0
        r10.mo13690a(r11, r12, r13, r14, r15, r16)
        com.bytedance.sdk.a.b.a.b.d r0 = r17.m6935g()
        com.bytedance.sdk.a.b.d r2 = r8.mo13689a()
        r0.mo13701b(r2)
        com.bytedance.sdk.a.b.m r2 = r1.f5388g
        monitor-enter(r2)
        r1.f5393l = r6     // Catch:{ all -> 0x0112 }
        com.bytedance.sdk.a.b.a.a r0 = com.bytedance.sdk.p145a.p147b.p148a.Internal.f5302a     // Catch:{ all -> 0x0112 }
        com.bytedance.sdk.a.b.m r3 = r1.f5388g     // Catch:{ all -> 0x0112 }
        r0.mo13658a(r3, r8)     // Catch:{ all -> 0x0112 }
        boolean r0 = r8.mo13698d()     // Catch:{ all -> 0x0112 }
        if (r0 == 0) goto L_0x0106
        com.bytedance.sdk.a.b.a.a r0 = com.bytedance.sdk.p145a.p147b.p148a.Internal.f5302a     // Catch:{ all -> 0x0112 }
        com.bytedance.sdk.a.b.m r3 = r1.f5388g     // Catch:{ all -> 0x0112 }
        com.bytedance.sdk.a.b.a r4 = r1.f5383a     // Catch:{ all -> 0x0112 }
        java.net.Socket r5 = r0.mo13657a(r3, r4, r1)     // Catch:{ all -> 0x0112 }
        com.bytedance.sdk.a.b.a.b.c r8 = r1.f5392k     // Catch:{ all -> 0x0112 }
    L_0x0106:
        monitor-exit(r2)     // Catch:{ all -> 0x0112 }
        com.bytedance.sdk.p145a.p147b.p148a.C1876c.m6962a(r5)
        com.bytedance.sdk.a.b.s r0 = r1.f5385c
        com.bytedance.sdk.a.b.h r2 = r1.f5384b
        r0.mo14048a(r2, r8)
        return r8
    L_0x0112:
        r0 = move-exception
        monitor-exit(r2)     // Catch:{ all -> 0x0112 }
        throw r0
    L_0x0115:
        java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x011d }
        java.lang.String r2 = "Canceled"
        r0.<init>(r2)     // Catch:{ all -> 0x011d }
        throw r0     // Catch:{ all -> 0x011d }
    L_0x011d:
        r0 = move-exception
        monitor-exit(r3)     // Catch:{ all -> 0x011d }
        throw r0
    L_0x0120:
        java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0138 }
        java.lang.String r3 = "Canceled"
        r0.<init>(r3)     // Catch:{ all -> 0x0138 }
        throw r0     // Catch:{ all -> 0x0138 }
    L_0x0128:
        java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0138 }
        java.lang.String r3 = "codec != null"
        r0.<init>(r3)     // Catch:{ all -> 0x0138 }
        throw r0     // Catch:{ all -> 0x0138 }
    L_0x0130:
        java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0138 }
        java.lang.String r3 = "released"
        r0.<init>(r3)     // Catch:{ all -> 0x0138 }
        throw r0     // Catch:{ all -> 0x0138 }
    L_0x0138:
        r0 = move-exception
        monitor-exit(r2)     // Catch:{ all -> 0x0138 }
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.p145a.p147b.p148a.p150b.StreamAllocation.m6930a(int, int, int, boolean):com.bytedance.sdk.a.b.a.b.c");
    }

    /* renamed from: f */
    private Socket m6934f() {
        if (f5382d || Thread.holdsLock(this.f5388g)) {
            RealConnection cVar = this.f5392k;
            if (cVar == null || !cVar.f5355a) {
                return null;
            }
            return m6932a(false, false, true);
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public void mo13716a(boolean z, HttpCodec cVar, long j, IOException iOException) {
        RealConnection cVar2;
        Socket a;
        boolean z2;
        this.f5385c.mo14057b(this.f5384b, j);
        synchronized (this.f5388g) {
            if (cVar != null) {
                if (cVar == this.f5396o) {
                    if (!z) {
                        this.f5392k.f5356b++;
                    }
                    cVar2 = this.f5392k;
                    a = m6932a(z, false, true);
                    if (this.f5392k != null) {
                        cVar2 = null;
                    }
                    z2 = this.f5394m;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("expected ");
            sb.append(this.f5396o);
            sb.append(" but was ");
            sb.append(cVar);
            throw new IllegalStateException(sb.toString());
        }
        C1876c.m6962a(a);
        if (cVar2 != null) {
            this.f5385c.mo14058b(this.f5384b, (Connection) cVar2);
        }
        if (iOException != null) {
            this.f5385c.mo14050a(this.f5384b, iOException);
        } else if (z2) {
            this.f5385c.mo14063g(this.f5384b);
        }
    }

    /* renamed from: a */
    public HttpCodec mo13711a() {
        HttpCodec cVar;
        synchronized (this.f5388g) {
            cVar = this.f5396o;
        }
        return cVar;
    }

    /* renamed from: g */
    private RouteDatabase m6935g() {
        return Internal.f5302a.mo13656a(this.f5388g);
    }

    /* renamed from: b */
    public synchronized RealConnection mo13717b() {
        return this.f5392k;
    }

    /* renamed from: c */
    public void mo13718c() {
        RealConnection cVar;
        Socket a;
        synchronized (this.f5388g) {
            cVar = this.f5392k;
            a = m6932a(false, true, false);
            if (this.f5392k != null) {
                cVar = null;
            }
        }
        C1876c.m6962a(a);
        if (cVar != null) {
            this.f5385c.mo14058b(this.f5384b, (Connection) cVar);
        }
    }

    /* renamed from: d */
    public void mo13719d() {
        RealConnection cVar;
        Socket a;
        synchronized (this.f5388g) {
            cVar = this.f5392k;
            a = m6932a(true, false, false);
            if (this.f5392k != null) {
                cVar = null;
            }
        }
        C1876c.m6962a(a);
        if (cVar != null) {
            this.f5385c.mo14058b(this.f5384b, (Connection) cVar);
        }
    }

    /* renamed from: a */
    private Socket m6932a(boolean z, boolean z2, boolean z3) {
        Socket socket;
        if (f5382d || Thread.holdsLock(this.f5388g)) {
            if (z3) {
                this.f5396o = null;
            }
            if (z2) {
                this.f5394m = true;
            }
            RealConnection cVar = this.f5392k;
            if (cVar != null) {
                if (z) {
                    cVar.f5355a = true;
                }
                if (this.f5396o == null && (this.f5394m || this.f5392k.f5355a)) {
                    m6933b(this.f5392k);
                    if (this.f5392k.f5358d.isEmpty()) {
                        this.f5392k.f5359e = System.nanoTime();
                        if (Internal.f5302a.mo13663b(this.f5388g, this.f5392k)) {
                            socket = this.f5392k.mo13696b();
                            this.f5392k = null;
                            return socket;
                        }
                    }
                    socket = null;
                    this.f5392k = null;
                    return socket;
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public void mo13715a(IOException iOException) {
        boolean z;
        RealConnection cVar;
        Socket a;
        synchronized (this.f5388g) {
            if (iOException instanceof StreamResetException) {
                StreamResetException oVar = (StreamResetException) iOException;
                if (oVar.f5652a == ErrorCode.REFUSED_STREAM) {
                    this.f5391j++;
                }
                if (oVar.f5652a != ErrorCode.REFUSED_STREAM || this.f5391j > 1) {
                    this.f5387f = null;
                }
                z = false;
                cVar = this.f5392k;
                a = m6932a(z, false, true);
                if (this.f5392k != null || !this.f5393l) {
                    cVar = null;
                }
            } else {
                if (this.f5392k != null && (!this.f5392k.mo13698d() || (iOException instanceof ConnectionShutdownException))) {
                    if (this.f5392k.f5356b == 0) {
                        if (!(this.f5387f == null || iOException == null)) {
                            this.f5390i.mo13705a(this.f5387f, iOException);
                        }
                        this.f5387f = null;
                    }
                }
                z = false;
                cVar = this.f5392k;
                a = m6932a(z, false, true);
                cVar = null;
            }
            z = true;
            cVar = this.f5392k;
            a = m6932a(z, false, true);
            cVar = null;
        }
        C1876c.m6962a(a);
        if (cVar != null) {
            this.f5385c.mo14058b(this.f5384b, (Connection) cVar);
        }
    }

    /* renamed from: a */
    public void mo13714a(RealConnection cVar, boolean z) {
        if (!f5382d && !Thread.holdsLock(this.f5388g)) {
            throw new AssertionError();
        } else if (this.f5392k == null) {
            this.f5392k = cVar;
            this.f5393l = z;
            cVar.f5358d.add(new C1875a(this, this.f5389h));
        } else {
            throw new IllegalStateException();
        }
    }

    /* renamed from: b */
    private void m6933b(RealConnection cVar) {
        int size = cVar.f5358d.size();
        for (int i = 0; i < size; i++) {
            if (((Reference) cVar.f5358d.get(i)).get() == this) {
                cVar.f5358d.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }

    /* renamed from: a */
    public Socket mo13713a(RealConnection cVar) {
        if (!f5382d && !Thread.holdsLock(this.f5388g)) {
            throw new AssertionError();
        } else if (this.f5396o == null && this.f5392k.f5358d.size() == 1) {
            Reference reference = (Reference) this.f5392k.f5358d.get(0);
            Socket a = m6932a(true, false, false);
            this.f5392k = cVar;
            cVar.f5358d.add(reference);
            return a;
        } else {
            throw new IllegalStateException();
        }
    }

    /* renamed from: e */
    public boolean mo13720e() {
        if (this.f5387f == null) {
            C1874a aVar = this.f5386e;
            if ((aVar == null || !aVar.mo13708a()) && !this.f5390i.mo13706a()) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        RealConnection b = mo13717b();
        return b != null ? b.toString() : this.f5383a.toString();
    }
}
