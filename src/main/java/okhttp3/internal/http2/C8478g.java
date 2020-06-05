package okhttp3.internal.http2;

import android.support.p000v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import okio.C8520a;
import okio.C8525c;
import okio.C8529e;
import okio.C8546q;
import okio.C8547r;
import okio.C8548s;

/* compiled from: Http2Stream */
/* renamed from: okhttp3.internal.http2.g */
public final class C8478g {
    /* renamed from: i */
    static final /* synthetic */ boolean f28777i = (!C8478g.class.desiredAssertionStatus());
    /* renamed from: a */
    long f28778a = 0;
    /* renamed from: b */
    long f28779b;
    /* renamed from: c */
    final int f28780c;
    /* renamed from: d */
    final C8460e f28781d;
    /* renamed from: e */
    final C8479a f28782e;
    /* renamed from: f */
    final C8481c f28783f = new C8481c();
    /* renamed from: g */
    final C8481c f28784g = new C8481c();
    /* renamed from: h */
    ErrorCode f28785h = null;
    /* renamed from: j */
    private final List<C8453a> f28786j;
    /* renamed from: k */
    private List<C8453a> f28787k;
    /* renamed from: l */
    private boolean f28788l;
    /* renamed from: m */
    private final C8480b f28789m;

    /* compiled from: Http2Stream */
    /* renamed from: okhttp3.internal.http2.g$a */
    final class C8479a implements C8546q {
        /* renamed from: c */
        static final /* synthetic */ boolean f28790c = (!C8478g.class.desiredAssertionStatus());
        /* renamed from: a */
        boolean f28791a;
        /* renamed from: b */
        boolean f28792b;
        /* renamed from: e */
        private final C8525c f28794e = new C8525c();

        C8479a() {
        }

        /* renamed from: a_ */
        public void mo40231a_(C8525c cVar, long j) throws IOException {
            if (f28790c || !Thread.holdsLock(C8478g.this)) {
                this.f28794e.mo40231a_(cVar, j);
                while (this.f28794e.mo40734b() >= PlaybackStateCompat.ACTION_PREPARE) {
                    m36371a(false);
                }
                return;
            }
            throw new AssertionError();
        }

        /* JADX INFO: finally extract failed */
        /* renamed from: a */
        private void m36371a(boolean z) throws IOException {
            long min;
            synchronized (C8478g.this) {
                C8478g.this.f28784g.mo40710c();
                while (C8478g.this.f28779b <= 0 && !this.f28792b && !this.f28791a && C8478g.this.f28785h == null) {
                    try {
                        C8478g.this.mo40421l();
                    } catch (Throwable th) {
                        C8478g.this.f28784g.mo40425b();
                        throw th;
                    }
                }
                C8478g.this.f28784g.mo40425b();
                C8478g.this.mo40420k();
                min = Math.min(C8478g.this.f28779b, this.f28794e.mo40734b());
                C8478g.this.f28779b -= min;
            }
            C8478g.this.f28784g.mo40710c();
            try {
                C8460e eVar = C8478g.this.f28781d;
                int i = C8478g.this.f28780c;
                boolean z2 = z && min == this.f28794e.mo40734b();
                eVar.mo40373a(i, z2, this.f28794e, min);
            } finally {
                C8478g.this.f28784g.mo40425b();
            }
        }

        public void flush() throws IOException {
            if (f28790c || !Thread.holdsLock(C8478g.this)) {
                synchronized (C8478g.this) {
                    C8478g.this.mo40420k();
                }
                while (this.f28794e.mo40734b() > 0) {
                    m36371a(false);
                    C8478g.this.f28781d.mo40380b();
                }
                return;
            }
            throw new AssertionError();
        }

        /* renamed from: a */
        public C8548s mo40271a() {
            return C8478g.this.f28784g;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0024, code lost:
            if (r8.f28793d.f28782e.f28792b != false) goto L_0x004f;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0030, code lost:
            if (r8.f28794e.mo40734b() <= 0) goto L_0x0040;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x003a, code lost:
            if (r8.f28794e.mo40734b() <= 0) goto L_0x004f;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x003c, code lost:
            m36371a(true);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0040, code lost:
            r8.f28793d.f28781d.mo40373a(r8.f28793d.f28780c, true, (okio.C8525c) null, 0);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x004f, code lost:
            r2 = r8.f28793d;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0051, code lost:
            monitor-enter(r2);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            r8.f28791a = true;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0054, code lost:
            monitor-exit(r2);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0055, code lost:
            r8.f28793d.f28781d.mo40380b();
            r8.f28793d.mo40419j();
     */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0061, code lost:
            return;
     */
        public void close() throws java.io.IOException {
            /*
            r8 = this;
            boolean r0 = f28790c
            if (r0 != 0) goto L_0x0013
            okhttp3.internal.http2.g r0 = okhttp3.internal.http2.C8478g.this
            boolean r0 = java.lang.Thread.holdsLock(r0)
            if (r0 != 0) goto L_0x000d
            goto L_0x0013
        L_0x000d:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r0.<init>()
            throw r0
        L_0x0013:
            okhttp3.internal.http2.g r0 = okhttp3.internal.http2.C8478g.this
            monitor-enter(r0)
            boolean r1 = r8.f28791a     // Catch:{ all -> 0x0065 }
            if (r1 == 0) goto L_0x001c
            monitor-exit(r0)     // Catch:{ all -> 0x0065 }
            return
        L_0x001c:
            monitor-exit(r0)     // Catch:{ all -> 0x0065 }
            okhttp3.internal.http2.g r0 = okhttp3.internal.http2.C8478g.this
            okhttp3.internal.http2.g$a r0 = r0.f28782e
            boolean r0 = r0.f28792b
            r1 = 1
            if (r0 != 0) goto L_0x004f
            okio.c r0 = r8.f28794e
            long r2 = r0.mo40734b()
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x0040
        L_0x0032:
            okio.c r0 = r8.f28794e
            long r2 = r0.mo40734b()
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x004f
            r8.m36371a(r1)
            goto L_0x0032
        L_0x0040:
            okhttp3.internal.http2.g r0 = okhttp3.internal.http2.C8478g.this
            okhttp3.internal.http2.e r2 = r0.f28781d
            okhttp3.internal.http2.g r0 = okhttp3.internal.http2.C8478g.this
            int r3 = r0.f28780c
            r4 = 1
            r5 = 0
            r6 = 0
            r2.mo40373a(r3, r4, r5, r6)
        L_0x004f:
            okhttp3.internal.http2.g r2 = okhttp3.internal.http2.C8478g.this
            monitor-enter(r2)
            r8.f28791a = r1     // Catch:{ all -> 0x0062 }
            monitor-exit(r2)     // Catch:{ all -> 0x0062 }
            okhttp3.internal.http2.g r0 = okhttp3.internal.http2.C8478g.this
            okhttp3.internal.http2.e r0 = r0.f28781d
            r0.mo40380b()
            okhttp3.internal.http2.g r0 = okhttp3.internal.http2.C8478g.this
            r0.mo40419j()
            return
        L_0x0062:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0062 }
            throw r0
        L_0x0065:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0065 }
            throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.C8478g.C8479a.close():void");
        }
    }

    /* compiled from: Http2Stream */
    /* renamed from: okhttp3.internal.http2.g$b */
    private final class C8480b implements C8547r {
        /* renamed from: c */
        static final /* synthetic */ boolean f28795c = (!C8478g.class.desiredAssertionStatus());
        /* renamed from: a */
        boolean f28796a;
        /* renamed from: b */
        boolean f28797b;
        /* renamed from: e */
        private final C8525c f28799e = new C8525c();
        /* renamed from: f */
        private final C8525c f28800f = new C8525c();
        /* renamed from: g */
        private final long f28801g;

        C8480b(long j) {
            this.f28801g = j;
        }

        /* renamed from: a */
        public long mo40202a(C8525c cVar, long j) throws IOException {
            ErrorCode errorCode;
            long j2;
            if (j >= 0) {
                synchronized (C8478g.this) {
                    m36375b();
                    if (!this.f28796a) {
                        errorCode = C8478g.this.f28785h;
                        if (this.f28800f.mo40734b() > 0) {
                            j2 = this.f28800f.mo40202a(cVar, Math.min(j, this.f28800f.mo40734b()));
                            C8478g.this.f28778a += j2;
                        } else {
                            j2 = -1;
                        }
                        if (errorCode == null && C8478g.this.f28778a >= ((long) (C8478g.this.f28781d.f28715k.mo40457d() / 2))) {
                            C8478g.this.f28781d.mo40368a(C8478g.this.f28780c, C8478g.this.f28778a);
                            C8478g.this.f28778a = 0;
                        }
                    } else {
                        throw new IOException("stream closed");
                    }
                }
                if (j2 != -1) {
                    m36374a(j2);
                    return j2;
                } else if (errorCode == null) {
                    return -1;
                } else {
                    throw new StreamResetException(errorCode);
                }
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("byteCount < 0: ");
                sb.append(j);
                throw new IllegalArgumentException(sb.toString());
            }
        }

        /* renamed from: a */
        private void m36374a(long j) {
            if (f28795c || !Thread.holdsLock(C8478g.this)) {
                C8478g.this.f28781d.mo40374a(j);
                return;
            }
            throw new AssertionError();
        }

        /* renamed from: b */
        private void m36375b() throws IOException {
            C8478g.this.f28783f.mo40710c();
            while (this.f28800f.mo40734b() == 0 && !this.f28797b && !this.f28796a && C8478g.this.f28785h == null) {
                try {
                    C8478g.this.mo40421l();
                } finally {
                    C8478g.this.f28783f.mo40425b();
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo40422a(C8529e eVar, long j) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            if (f28795c || !Thread.holdsLock(C8478g.this)) {
                while (j > 0) {
                    synchronized (C8478g.this) {
                        z = this.f28797b;
                        z2 = true;
                        z3 = this.f28800f.mo40734b() + j > this.f28801g;
                    }
                    if (z3) {
                        eVar.mo40761h(j);
                        C8478g.this.mo40409b(ErrorCode.FLOW_CONTROL_ERROR);
                        return;
                    } else if (z) {
                        eVar.mo40761h(j);
                        return;
                    } else {
                        long a = eVar.mo40202a(this.f28799e, j);
                        if (a != -1) {
                            j -= a;
                            synchronized (C8478g.this) {
                                if (this.f28800f.mo40734b() != 0) {
                                    z2 = false;
                                }
                                this.f28800f.mo40719a((C8547r) this.f28799e);
                                if (z2) {
                                    C8478g.this.notifyAll();
                                }
                            }
                        } else {
                            throw new EOFException();
                        }
                    }
                }
                return;
            }
            throw new AssertionError();
        }

        /* renamed from: a */
        public C8548s mo40203a() {
            return C8478g.this.f28783f;
        }

        public void close() throws IOException {
            long b;
            synchronized (C8478g.this) {
                this.f28796a = true;
                b = this.f28800f.mo40734b();
                this.f28800f.mo40781t();
                C8478g.this.notifyAll();
            }
            if (b > 0) {
                m36374a(b);
            }
            C8478g.this.mo40419j();
        }
    }

    /* compiled from: Http2Stream */
    /* renamed from: okhttp3.internal.http2.g$c */
    class C8481c extends C8520a {
        C8481c() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo40424a() {
            C8478g.this.mo40409b(ErrorCode.CANCEL);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public IOException mo40423a(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        /* renamed from: b */
        public void mo40425b() throws IOException {
            if (mo40711m_()) {
                throw mo40423a(null);
            }
        }
    }

    C8478g(int i, C8460e eVar, boolean z, boolean z2, List<C8453a> list) {
        if (eVar == null) {
            throw new NullPointerException("connection == null");
        } else if (list != null) {
            this.f28780c = i;
            this.f28781d = eVar;
            this.f28779b = (long) eVar.f28716l.mo40457d();
            this.f28789m = new C8480b((long) eVar.f28715k.mo40457d());
            this.f28782e = new C8479a();
            this.f28789m.f28797b = z2;
            this.f28782e.f28792b = z;
            this.f28786j = list;
        } else {
            throw new NullPointerException("requestHeaders == null");
        }
    }

    /* renamed from: a */
    public int mo40404a() {
        return this.f28780c;
    }

    /* renamed from: b */
    public synchronized boolean mo40410b() {
        if (this.f28785h != null) {
            return false;
        }
        if ((this.f28789m.f28797b || this.f28789m.f28796a) && ((this.f28782e.f28792b || this.f28782e.f28791a) && this.f28788l)) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    public boolean mo40412c() {
        if (this.f28781d.f28705a == ((this.f28780c & 1) == 1)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: d */
    public synchronized List<C8453a> mo40413d() throws IOException {
        List<C8453a> list;
        if (mo40412c()) {
            this.f28783f.mo40710c();
            while (this.f28787k == null && this.f28785h == null) {
                try {
                    mo40421l();
                } catch (Throwable th) {
                    this.f28783f.mo40425b();
                    throw th;
                }
            }
            this.f28783f.mo40425b();
            list = this.f28787k;
            if (list != null) {
                this.f28787k = null;
            } else {
                throw new StreamResetException(this.f28785h);
            }
        } else {
            throw new IllegalStateException("servers cannot read response headers");
        }
        return list;
    }

    /* renamed from: e */
    public C8548s mo40414e() {
        return this.f28783f;
    }

    /* renamed from: f */
    public C8548s mo40415f() {
        return this.f28784g;
    }

    /* renamed from: g */
    public C8547r mo40416g() {
        return this.f28789m;
    }

    /* renamed from: h */
    public C8546q mo40417h() {
        synchronized (this) {
            if (!this.f28788l) {
                if (!mo40412c()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
            }
        }
        return this.f28782e;
    }

    /* renamed from: a */
    public void mo40407a(ErrorCode errorCode) throws IOException {
        if (m36352d(errorCode)) {
            this.f28781d.mo40381b(this.f28780c, errorCode);
        }
    }

    /* renamed from: b */
    public void mo40409b(ErrorCode errorCode) {
        if (m36352d(errorCode)) {
            this.f28781d.mo40371a(this.f28780c, errorCode);
        }
    }

    /* renamed from: d */
    private boolean m36352d(ErrorCode errorCode) {
        if (f28777i || !Thread.holdsLock(this)) {
            synchronized (this) {
                if (this.f28785h != null) {
                    return false;
                }
                if (this.f28789m.f28797b && this.f28782e.f28792b) {
                    return false;
                }
                this.f28785h = errorCode;
                notifyAll();
                this.f28781d.mo40379b(this.f28780c);
                return true;
            }
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo40406a(List<C8453a> list) {
        boolean z;
        if (f28777i || !Thread.holdsLock(this)) {
            synchronized (this) {
                z = true;
                this.f28788l = true;
                if (this.f28787k == null) {
                    this.f28787k = list;
                    z = mo40410b();
                    notifyAll();
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(this.f28787k);
                    arrayList.add(null);
                    arrayList.addAll(list);
                    this.f28787k = arrayList;
                }
            }
            if (!z) {
                this.f28781d.mo40379b(this.f28780c);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo40408a(C8529e eVar, int i) throws IOException {
        if (f28777i || !Thread.holdsLock(this)) {
            this.f28789m.mo40422a(eVar, (long) i);
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public void mo40418i() {
        boolean b;
        if (f28777i || !Thread.holdsLock(this)) {
            synchronized (this) {
                this.f28789m.f28797b = true;
                b = mo40410b();
                notifyAll();
            }
            if (!b) {
                this.f28781d.mo40379b(this.f28780c);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: c */
    public synchronized void mo40411c(ErrorCode errorCode) {
        if (this.f28785h == null) {
            this.f28785h = errorCode;
            notifyAll();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public void mo40419j() throws IOException {
        boolean z;
        boolean b;
        if (f28777i || !Thread.holdsLock(this)) {
            synchronized (this) {
                z = !this.f28789m.f28797b && this.f28789m.f28796a && (this.f28782e.f28792b || this.f28782e.f28791a);
                b = mo40410b();
            }
            if (z) {
                mo40407a(ErrorCode.CANCEL);
            } else if (!b) {
                this.f28781d.mo40379b(this.f28780c);
            }
        } else {
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo40405a(long j) {
        this.f28779b += j;
        if (j > 0) {
            notifyAll();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: k */
    public void mo40420k() throws IOException {
        if (this.f28782e.f28791a) {
            throw new IOException("stream closed");
        } else if (!this.f28782e.f28792b) {
            ErrorCode errorCode = this.f28785h;
            if (errorCode != null) {
                throw new StreamResetException(errorCode);
            }
        } else {
            throw new IOException("stream finished");
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: l */
    public void mo40421l() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }
}
