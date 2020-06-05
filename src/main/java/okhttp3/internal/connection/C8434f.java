package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import okhttp3.C8357a;
import okhttp3.C8367ad;
import okhttp3.C8379e;
import okhttp3.C8387i;
import okhttp3.C8488j;
import okhttp3.C8498p;
import okhttp3.C8508u.C8509a;
import okhttp3.C8513x;
import okhttp3.internal.C8388a;
import okhttp3.internal.C8417c;
import okhttp3.internal.connection.C8432e.C8433a;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;
import okhttp3.internal.p698b.C8406c;

/* compiled from: StreamAllocation */
/* renamed from: okhttp3.internal.connection.f */
public final class C8434f {
    /* renamed from: d */
    static final /* synthetic */ boolean f28604d = (!C8434f.class.desiredAssertionStatus());
    /* renamed from: a */
    public final C8357a f28605a;
    /* renamed from: b */
    public final C8379e f28606b;
    /* renamed from: c */
    public final C8498p f28607c;
    /* renamed from: e */
    private C8433a f28608e;
    /* renamed from: f */
    private C8367ad f28609f;
    /* renamed from: g */
    private final C8488j f28610g;
    /* renamed from: h */
    private final Object f28611h;
    /* renamed from: i */
    private final C8432e f28612i;
    /* renamed from: j */
    private int f28613j;
    /* renamed from: k */
    private C8430c f28614k;
    /* renamed from: l */
    private boolean f28615l;
    /* renamed from: m */
    private boolean f28616m;
    /* renamed from: n */
    private boolean f28617n;
    /* renamed from: o */
    private C8406c f28618o;

    /* compiled from: StreamAllocation */
    /* renamed from: okhttp3.internal.connection.f$a */
    public static final class C8435a extends WeakReference<C8434f> {
        /* renamed from: a */
        public final Object f28619a;

        C8435a(C8434f fVar, Object obj) {
            super(fVar);
            this.f28619a = obj;
        }
    }

    public C8434f(C8488j jVar, C8357a aVar, C8379e eVar, C8498p pVar, Object obj) {
        this.f28610g = jVar;
        this.f28605a = aVar;
        this.f28606b = eVar;
        this.f28607c = pVar;
        this.f28612i = new C8432e(aVar, m36126i(), eVar, pVar);
        this.f28611h = obj;
    }

    /* renamed from: a */
    public C8406c mo40301a(C8513x xVar, C8509a aVar, boolean z) {
        try {
            C8406c a = m36123a(aVar.mo40247b(), aVar.mo40248c(), aVar.mo40249d(), xVar.mo40600d(), xVar.mo40615s(), z).mo40278a(xVar, aVar, this);
            synchronized (this.f28610g) {
                this.f28618o = a;
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
            if (r0.mo40284a(r9) != false) goto L_0x0018;
     */
    /* renamed from: a */
    private okhttp3.internal.connection.C8430c m36123a(int r4, int r5, int r6, int r7, boolean r8, boolean r9) throws java.io.IOException {
        /*
        r3 = this;
    L_0x0000:
        okhttp3.internal.connection.c r0 = r3.m36122a(r4, r5, r6, r7, r8)
        okhttp3.j r1 = r3.f28610g
        monitor-enter(r1)
        int r2 = r0.f28580b     // Catch:{ all -> 0x0019 }
        if (r2 != 0) goto L_0x000d
        monitor-exit(r1)     // Catch:{ all -> 0x0019 }
        return r0
    L_0x000d:
        monitor-exit(r1)     // Catch:{ all -> 0x0019 }
        boolean r1 = r0.mo40284a(r9)
        if (r1 != 0) goto L_0x0018
        r3.mo40308e()
        goto L_0x0000
    L_0x0018:
        return r0
    L_0x0019:
        r4 = move-exception
        monitor-exit(r1)     // Catch:{ all -> 0x0019 }
        throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.C8434f.m36123a(int, int, int, int, boolean, boolean):okhttp3.internal.connection.c");
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x0079 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00cb  */
    /* renamed from: a */
    private okhttp3.internal.connection.C8430c m36122a(int r19, int r20, int r21, int r22, boolean r23) throws java.io.IOException {
        /*
        r18 = this;
        r1 = r18
        okhttp3.j r2 = r1.f28610g
        monitor-enter(r2)
        boolean r0 = r1.f28616m     // Catch:{ all -> 0x013c }
        if (r0 != 0) goto L_0x0134
        okhttp3.internal.b.c r0 = r1.f28618o     // Catch:{ all -> 0x013c }
        if (r0 != 0) goto L_0x012c
        boolean r0 = r1.f28617n     // Catch:{ all -> 0x013c }
        if (r0 != 0) goto L_0x0124
        okhttp3.internal.connection.c r0 = r1.f28614k     // Catch:{ all -> 0x013c }
        java.net.Socket r3 = r18.m36125h()     // Catch:{ all -> 0x013c }
        okhttp3.internal.connection.c r4 = r1.f28614k     // Catch:{ all -> 0x013c }
        r5 = 0
        if (r4 == 0) goto L_0x0020
        okhttp3.internal.connection.c r0 = r1.f28614k     // Catch:{ all -> 0x013c }
        r4 = r5
        goto L_0x0022
    L_0x0020:
        r4 = r0
        r0 = r5
    L_0x0022:
        boolean r6 = r1.f28615l     // Catch:{ all -> 0x013c }
        if (r6 != 0) goto L_0x0027
        r4 = r5
    L_0x0027:
        r6 = 1
        r7 = 0
        if (r0 != 0) goto L_0x0043
        okhttp3.internal.a r8 = okhttp3.internal.C8388a.f28432a     // Catch:{ all -> 0x013c }
        okhttp3.j r9 = r1.f28610g     // Catch:{ all -> 0x013c }
        okhttp3.a r10 = r1.f28605a     // Catch:{ all -> 0x013c }
        r8.mo40194a(r9, r10, r1, r5)     // Catch:{ all -> 0x013c }
        okhttp3.internal.connection.c r8 = r1.f28614k     // Catch:{ all -> 0x013c }
        if (r8 == 0) goto L_0x003e
        okhttp3.internal.connection.c r0 = r1.f28614k     // Catch:{ all -> 0x013c }
        r8 = r0
        r9 = r5
        r0 = 1
        goto L_0x0046
    L_0x003e:
        okhttp3.ad r8 = r1.f28609f     // Catch:{ all -> 0x013c }
        r9 = r8
        r8 = r0
        goto L_0x0045
    L_0x0043:
        r8 = r0
        r9 = r5
    L_0x0045:
        r0 = 0
    L_0x0046:
        monitor-exit(r2)     // Catch:{ all -> 0x013c }
        okhttp3.internal.C8417c.m36042a(r3)
        if (r4 == 0) goto L_0x0053
        okhttp3.p r2 = r1.f28607c
        okhttp3.e r3 = r1.f28606b
        r2.mo40510b(r3, r4)
    L_0x0053:
        if (r0 == 0) goto L_0x005c
        okhttp3.p r2 = r1.f28607c
        okhttp3.e r3 = r1.f28606b
        r2.mo40505a(r3, r8)
    L_0x005c:
        if (r8 == 0) goto L_0x005f
        return r8
    L_0x005f:
        if (r9 != 0) goto L_0x0075
        okhttp3.internal.connection.e$a r2 = r1.f28608e
        if (r2 == 0) goto L_0x006b
        boolean r2 = r2.mo40296a()
        if (r2 != 0) goto L_0x0075
    L_0x006b:
        okhttp3.internal.connection.e r2 = r1.f28612i
        okhttp3.internal.connection.e$a r2 = r2.mo40295b()
        r1.f28608e = r2
        r2 = 1
        goto L_0x0076
    L_0x0075:
        r2 = 0
    L_0x0076:
        okhttp3.j r3 = r1.f28610g
        monitor-enter(r3)
        boolean r4 = r1.f28617n     // Catch:{ all -> 0x0121 }
        if (r4 != 0) goto L_0x0119
        if (r2 == 0) goto L_0x00a8
        okhttp3.internal.connection.e$a r2 = r1.f28608e     // Catch:{ all -> 0x0121 }
        java.util.List r2 = r2.mo40298c()     // Catch:{ all -> 0x0121 }
        int r4 = r2.size()     // Catch:{ all -> 0x0121 }
        r10 = 0
    L_0x008a:
        if (r10 >= r4) goto L_0x00a8
        java.lang.Object r11 = r2.get(r10)     // Catch:{ all -> 0x0121 }
        okhttp3.ad r11 = (okhttp3.C8367ad) r11     // Catch:{ all -> 0x0121 }
        okhttp3.internal.a r12 = okhttp3.internal.C8388a.f28432a     // Catch:{ all -> 0x0121 }
        okhttp3.j r13 = r1.f28610g     // Catch:{ all -> 0x0121 }
        okhttp3.a r14 = r1.f28605a     // Catch:{ all -> 0x0121 }
        r12.mo40194a(r13, r14, r1, r11)     // Catch:{ all -> 0x0121 }
        okhttp3.internal.connection.c r12 = r1.f28614k     // Catch:{ all -> 0x0121 }
        if (r12 == 0) goto L_0x00a5
        okhttp3.internal.connection.c r8 = r1.f28614k     // Catch:{ all -> 0x0121 }
        r1.f28609f = r11     // Catch:{ all -> 0x0121 }
        r0 = 1
        goto L_0x00a8
    L_0x00a5:
        int r10 = r10 + 1
        goto L_0x008a
    L_0x00a8:
        if (r0 != 0) goto L_0x00c0
        if (r9 != 0) goto L_0x00b2
        okhttp3.internal.connection.e$a r2 = r1.f28608e     // Catch:{ all -> 0x0121 }
        okhttp3.ad r9 = r2.mo40297b()     // Catch:{ all -> 0x0121 }
    L_0x00b2:
        r1.f28609f = r9     // Catch:{ all -> 0x0121 }
        r1.f28613j = r7     // Catch:{ all -> 0x0121 }
        okhttp3.internal.connection.c r8 = new okhttp3.internal.connection.c     // Catch:{ all -> 0x0121 }
        okhttp3.j r2 = r1.f28610g     // Catch:{ all -> 0x0121 }
        r8.m55425init(r2, r9)     // Catch:{ all -> 0x0121 }
        r1.mo40303a(r8, r7)     // Catch:{ all -> 0x0121 }
    L_0x00c0:
        monitor-exit(r3)     // Catch:{ all -> 0x0121 }
        if (r0 == 0) goto L_0x00cb
        okhttp3.p r0 = r1.f28607c
        okhttp3.e r2 = r1.f28606b
        r0.mo40505a(r2, r8)
        return r8
    L_0x00cb:
        okhttp3.e r0 = r1.f28606b
        okhttp3.p r2 = r1.f28607c
        r10 = r8
        r11 = r19
        r12 = r20
        r13 = r21
        r14 = r22
        r15 = r23
        r16 = r0
        r17 = r2
        r10.mo40279a(r11, r12, r13, r14, r15, r16, r17)
        okhttp3.internal.connection.d r0 = r18.m36126i()
        okhttp3.ad r2 = r8.mo40277a()
        r0.mo40291b(r2)
        okhttp3.j r2 = r1.f28610g
        monitor-enter(r2)
        r1.f28615l = r6     // Catch:{ all -> 0x0116 }
        okhttp3.internal.a r0 = okhttp3.internal.C8388a.f28432a     // Catch:{ all -> 0x0116 }
        okhttp3.j r3 = r1.f28610g     // Catch:{ all -> 0x0116 }
        r0.mo40201b(r3, r8)     // Catch:{ all -> 0x0116 }
        boolean r0 = r8.mo40288e()     // Catch:{ all -> 0x0116 }
        if (r0 == 0) goto L_0x010a
        okhttp3.internal.a r0 = okhttp3.internal.C8388a.f28432a     // Catch:{ all -> 0x0116 }
        okhttp3.j r3 = r1.f28610g     // Catch:{ all -> 0x0116 }
        okhttp3.a r4 = r1.f28605a     // Catch:{ all -> 0x0116 }
        java.net.Socket r5 = r0.mo40193a(r3, r4, r1)     // Catch:{ all -> 0x0116 }
        okhttp3.internal.connection.c r8 = r1.f28614k     // Catch:{ all -> 0x0116 }
    L_0x010a:
        monitor-exit(r2)     // Catch:{ all -> 0x0116 }
        okhttp3.internal.C8417c.m36042a(r5)
        okhttp3.p r0 = r1.f28607c
        okhttp3.e r2 = r1.f28606b
        r0.mo40505a(r2, r8)
        return r8
    L_0x0116:
        r0 = move-exception
        monitor-exit(r2)     // Catch:{ all -> 0x0116 }
        throw r0
    L_0x0119:
        java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0121 }
        java.lang.String r2 = "Canceled"
        r0.<init>(r2)     // Catch:{ all -> 0x0121 }
        throw r0     // Catch:{ all -> 0x0121 }
    L_0x0121:
        r0 = move-exception
        monitor-exit(r3)     // Catch:{ all -> 0x0121 }
        throw r0
    L_0x0124:
        java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x013c }
        java.lang.String r3 = "Canceled"
        r0.<init>(r3)     // Catch:{ all -> 0x013c }
        throw r0     // Catch:{ all -> 0x013c }
    L_0x012c:
        java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x013c }
        java.lang.String r3 = "codec != null"
        r0.<init>(r3)     // Catch:{ all -> 0x013c }
        throw r0     // Catch:{ all -> 0x013c }
    L_0x0134:
        java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x013c }
        java.lang.String r3 = "released"
        r0.<init>(r3)     // Catch:{ all -> 0x013c }
        throw r0     // Catch:{ all -> 0x013c }
    L_0x013c:
        r0 = move-exception
        monitor-exit(r2)     // Catch:{ all -> 0x013c }
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.C8434f.m36122a(int, int, int, int, boolean):okhttp3.internal.connection.c");
    }

    /* renamed from: h */
    private Socket m36125h() {
        if (f28604d || Thread.holdsLock(this.f28610g)) {
            C8430c cVar = this.f28614k;
            if (cVar == null || !cVar.f28579a) {
                return null;
            }
            return m36121a(false, false, true);
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public void mo40304a(boolean z, C8406c cVar, long j, IOException iOException) {
        C8430c cVar2;
        Socket a;
        boolean z2;
        this.f28607c.mo40509b(this.f28606b, j);
        synchronized (this.f28610g) {
            if (cVar != null) {
                if (cVar == this.f28618o) {
                    if (!z) {
                        this.f28614k.f28580b++;
                    }
                    cVar2 = this.f28614k;
                    a = m36121a(z, false, true);
                    if (this.f28614k != null) {
                        cVar2 = null;
                    }
                    z2 = this.f28616m;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("expected ");
            sb.append(this.f28618o);
            sb.append(" but was ");
            sb.append(cVar);
            throw new IllegalStateException(sb.toString());
        }
        C8417c.m36042a(a);
        if (cVar2 != null) {
            this.f28607c.mo40510b(this.f28606b, (C8387i) cVar2);
        }
        if (iOException != null) {
            this.f28607c.mo40498a(this.f28606b, iOException);
        } else if (z2) {
            this.f28607c.mo40515g(this.f28606b);
        }
    }

    /* renamed from: a */
    public C8406c mo40300a() {
        C8406c cVar;
        synchronized (this.f28610g) {
            cVar = this.f28618o;
        }
        return cVar;
    }

    /* renamed from: i */
    private C8431d m36126i() {
        return C8388a.f28432a.mo40195a(this.f28610g);
    }

    /* renamed from: b */
    public C8367ad mo40305b() {
        return this.f28609f;
    }

    /* renamed from: c */
    public synchronized C8430c mo40306c() {
        return this.f28614k;
    }

    /* renamed from: d */
    public void mo40307d() {
        C8430c cVar;
        Socket a;
        synchronized (this.f28610g) {
            cVar = this.f28614k;
            a = m36121a(false, true, false);
            if (this.f28614k != null) {
                cVar = null;
            }
        }
        C8417c.m36042a(a);
        if (cVar != null) {
            this.f28607c.mo40510b(this.f28606b, (C8387i) cVar);
            this.f28607c.mo40515g(this.f28606b);
        }
    }

    /* renamed from: e */
    public void mo40308e() {
        C8430c cVar;
        Socket a;
        synchronized (this.f28610g) {
            cVar = this.f28614k;
            a = m36121a(true, false, false);
            if (this.f28614k != null) {
                cVar = null;
            }
        }
        C8417c.m36042a(a);
        if (cVar != null) {
            this.f28607c.mo40510b(this.f28606b, (C8387i) cVar);
        }
    }

    /* renamed from: a */
    private Socket m36121a(boolean z, boolean z2, boolean z3) {
        Socket socket;
        if (f28604d || Thread.holdsLock(this.f28610g)) {
            if (z3) {
                this.f28618o = null;
            }
            if (z2) {
                this.f28616m = true;
            }
            C8430c cVar = this.f28614k;
            if (cVar != null) {
                if (z) {
                    cVar.f28579a = true;
                }
                if (this.f28618o == null && (this.f28616m || this.f28614k.f28579a)) {
                    m36124b(this.f28614k);
                    if (this.f28614k.f28582d.isEmpty()) {
                        this.f28614k.f28583e = System.nanoTime();
                        if (C8388a.f28432a.mo40200a(this.f28610g, this.f28614k)) {
                            socket = this.f28614k.mo40286c();
                            this.f28614k = null;
                            return socket;
                        }
                    }
                    socket = null;
                    this.f28614k = null;
                    return socket;
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: f */
    public void mo40309f() {
        C8406c cVar;
        C8430c cVar2;
        synchronized (this.f28610g) {
            this.f28617n = true;
            cVar = this.f28618o;
            cVar2 = this.f28614k;
        }
        if (cVar != null) {
            cVar.mo40241c();
        } else if (cVar2 != null) {
            cVar2.mo40285b();
        }
    }

    /* renamed from: a */
    public void mo40302a(IOException iOException) {
        boolean z;
        C8430c cVar;
        Socket a;
        synchronized (this.f28610g) {
            if (iOException instanceof StreamResetException) {
                ErrorCode errorCode = ((StreamResetException) iOException).errorCode;
                if (errorCode == ErrorCode.REFUSED_STREAM) {
                    this.f28613j++;
                    if (this.f28613j > 1) {
                        this.f28609f = null;
                    }
                    z = false;
                    cVar = this.f28614k;
                    a = m36121a(z, false, true);
                    if (this.f28614k != null || !this.f28615l) {
                        cVar = null;
                    }
                } else {
                    if (errorCode != ErrorCode.CANCEL) {
                        this.f28609f = null;
                    }
                    z = false;
                    cVar = this.f28614k;
                    a = m36121a(z, false, true);
                    cVar = null;
                }
            } else {
                if (this.f28614k != null && (!this.f28614k.mo40288e() || (iOException instanceof ConnectionShutdownException))) {
                    if (this.f28614k.f28580b == 0) {
                        if (!(this.f28609f == null || iOException == null)) {
                            this.f28612i.mo40293a(this.f28609f, iOException);
                        }
                        this.f28609f = null;
                    }
                }
                z = false;
                cVar = this.f28614k;
                a = m36121a(z, false, true);
                cVar = null;
            }
            z = true;
            cVar = this.f28614k;
            a = m36121a(z, false, true);
            cVar = null;
        }
        C8417c.m36042a(a);
        if (cVar != null) {
            this.f28607c.mo40510b(this.f28606b, (C8387i) cVar);
        }
    }

    /* renamed from: a */
    public void mo40303a(C8430c cVar, boolean z) {
        if (!f28604d && !Thread.holdsLock(this.f28610g)) {
            throw new AssertionError();
        } else if (this.f28614k == null) {
            this.f28614k = cVar;
            this.f28615l = z;
            cVar.f28582d.add(new C8435a(this, this.f28611h));
        } else {
            throw new IllegalStateException();
        }
    }

    /* renamed from: b */
    private void m36124b(C8430c cVar) {
        int size = cVar.f28582d.size();
        for (int i = 0; i < size; i++) {
            if (((Reference) cVar.f28582d.get(i)).get() == this) {
                cVar.f28582d.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }

    /* renamed from: a */
    public Socket mo40299a(C8430c cVar) {
        if (!f28604d && !Thread.holdsLock(this.f28610g)) {
            throw new AssertionError();
        } else if (this.f28618o == null && this.f28614k.f28582d.size() == 1) {
            Reference reference = (Reference) this.f28614k.f28582d.get(0);
            Socket a = m36121a(true, false, false);
            this.f28614k = cVar;
            cVar.f28582d.add(reference);
            return a;
        } else {
            throw new IllegalStateException();
        }
    }

    /* renamed from: g */
    public boolean mo40310g() {
        if (this.f28609f == null) {
            C8433a aVar = this.f28608e;
            if ((aVar == null || !aVar.mo40296a()) && !this.f28612i.mo40294a()) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        C8430c c = mo40306c();
        return c != null ? c.toString() : this.f28605a.toString();
    }
}
