package com.bytedance.sdk.p145a.p147b.p148a.p153e;

import android.support.p000v4.media.session.PlaybackStateCompat;
import com.bytedance.sdk.p145a.p146a.AsyncTimeout;
import com.bytedance.sdk.p145a.p146a.Buffer;
import com.bytedance.sdk.p145a.p146a.BufferedSource;
import com.bytedance.sdk.p145a.p146a.Sink;
import com.bytedance.sdk.p145a.p146a.Source;
import com.bytedance.sdk.p145a.p146a.Timeout;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.bytedance.sdk.a.b.a.e.i */
public final class Http2Stream {
    /* renamed from: i */
    static final /* synthetic */ boolean f5606i = (!Http2Stream.class.desiredAssertionStatus());
    /* renamed from: a */
    long f5607a = 0;
    /* renamed from: b */
    long f5608b;
    /* renamed from: c */
    final int f5609c;
    /* renamed from: d */
    final Http2Connection f5610d;
    /* renamed from: e */
    final C1907a f5611e;
    /* renamed from: f */
    final C1909c f5612f = new C1909c();
    /* renamed from: g */
    final C1909c f5613g = new C1909c();
    /* renamed from: h */
    ErrorCode f5614h = null;
    /* renamed from: j */
    private final List<Header> f5615j;
    /* renamed from: k */
    private List<Header> f5616k;
    /* renamed from: l */
    private boolean f5617l;
    /* renamed from: m */
    private final C1908b f5618m;

    /* compiled from: Http2Stream */
    /* renamed from: com.bytedance.sdk.a.b.a.e.i$a */
    final class C1907a implements Sink {
        /* renamed from: c */
        static final /* synthetic */ boolean f5619c = (!Http2Stream.class.desiredAssertionStatus());
        /* renamed from: a */
        boolean f5620a;
        /* renamed from: b */
        boolean f5621b;
        /* renamed from: e */
        private final Buffer f5623e = new Buffer();

        C1907a() {
        }

        /* renamed from: a_ */
        public void mo13507a_(Buffer cVar, long j) throws IOException {
            if (f5619c || !Thread.holdsLock(Http2Stream.this)) {
                this.f5623e.mo13507a_(cVar, j);
                while (this.f5623e.mo13530b() >= PlaybackStateCompat.ACTION_PREPARE) {
                    m7198a(false);
                }
                return;
            }
            throw new AssertionError();
        }

        /* JADX INFO: finally extract failed */
        /* renamed from: a */
        private void m7198a(boolean z) throws IOException {
            long min;
            synchronized (Http2Stream.this) {
                Http2Stream.this.f5613g.mo13501a();
                while (Http2Stream.this.f5608b <= 0 && !this.f5621b && !this.f5620a && Http2Stream.this.f5614h == null) {
                    try {
                        Http2Stream.this.mo13826l();
                    } catch (Throwable th) {
                        Http2Stream.this.f5613g.mo13828h();
                        throw th;
                    }
                }
                Http2Stream.this.f5613g.mo13828h();
                Http2Stream.this.mo13825k();
                min = Math.min(Http2Stream.this.f5608b, this.f5623e.mo13530b());
                Http2Stream.this.f5608b -= min;
            }
            Http2Stream.this.f5613g.mo13501a();
            try {
                Http2Connection gVar = Http2Stream.this.f5610d;
                int i = Http2Stream.this.f5609c;
                boolean z2 = z && min == this.f5623e.mo13530b();
                gVar.mo13777a(i, z2, this.f5623e, min);
            } finally {
                Http2Stream.this.f5613g.mo13828h();
            }
        }

        public void flush() throws IOException {
            if (f5619c || !Thread.holdsLock(Http2Stream.this)) {
                synchronized (Http2Stream.this) {
                    Http2Stream.this.mo13825k();
                }
                while (this.f5623e.mo13530b() > 0) {
                    m7198a(false);
                    Http2Stream.this.f5610d.mo13784b();
                }
                return;
            }
            throw new AssertionError();
        }

        /* renamed from: a */
        public Timeout mo13506a() {
            return Http2Stream.this.f5613g;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0024, code lost:
            if (r8.f5622d.f5611e.f5621b != false) goto L_0x004f;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0030, code lost:
            if (r8.f5623e.mo13530b() <= 0) goto L_0x0040;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x003a, code lost:
            if (r8.f5623e.mo13530b() <= 0) goto L_0x004f;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x003c, code lost:
            m7198a(true);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0040, code lost:
            r8.f5622d.f5610d.mo13777a(r8.f5622d.f5609c, true, (com.bytedance.sdk.p145a.p146a.Buffer) null, 0);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x004f, code lost:
            r2 = r8.f5622d;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0051, code lost:
            monitor-enter(r2);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            r8.f5620a = true;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0054, code lost:
            monitor-exit(r2);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0055, code lost:
            r8.f5622d.f5610d.mo13784b();
            r8.f5622d.mo13824j();
     */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0061, code lost:
            return;
     */
        public void close() throws java.io.IOException {
            /*
            r8 = this;
            boolean r0 = f5619c
            if (r0 != 0) goto L_0x0013
            com.bytedance.sdk.a.b.a.e.i r0 = com.bytedance.sdk.p145a.p147b.p148a.p153e.Http2Stream.this
            boolean r0 = java.lang.Thread.holdsLock(r0)
            if (r0 != 0) goto L_0x000d
            goto L_0x0013
        L_0x000d:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r0.<init>()
            throw r0
        L_0x0013:
            com.bytedance.sdk.a.b.a.e.i r0 = com.bytedance.sdk.p145a.p147b.p148a.p153e.Http2Stream.this
            monitor-enter(r0)
            boolean r1 = r8.f5620a     // Catch:{ all -> 0x0065 }
            if (r1 == 0) goto L_0x001c
            monitor-exit(r0)     // Catch:{ all -> 0x0065 }
            return
        L_0x001c:
            monitor-exit(r0)     // Catch:{ all -> 0x0065 }
            com.bytedance.sdk.a.b.a.e.i r0 = com.bytedance.sdk.p145a.p147b.p148a.p153e.Http2Stream.this
            com.bytedance.sdk.a.b.a.e.i$a r0 = r0.f5611e
            boolean r0 = r0.f5621b
            r1 = 1
            if (r0 != 0) goto L_0x004f
            com.bytedance.sdk.a.a.c r0 = r8.f5623e
            long r2 = r0.mo13530b()
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x0040
        L_0x0032:
            com.bytedance.sdk.a.a.c r0 = r8.f5623e
            long r2 = r0.mo13530b()
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x004f
            r8.m7198a(r1)
            goto L_0x0032
        L_0x0040:
            com.bytedance.sdk.a.b.a.e.i r0 = com.bytedance.sdk.p145a.p147b.p148a.p153e.Http2Stream.this
            com.bytedance.sdk.a.b.a.e.g r2 = r0.f5610d
            com.bytedance.sdk.a.b.a.e.i r0 = com.bytedance.sdk.p145a.p147b.p148a.p153e.Http2Stream.this
            int r3 = r0.f5609c
            r4 = 1
            r5 = 0
            r6 = 0
            r2.mo13777a(r3, r4, r5, r6)
        L_0x004f:
            com.bytedance.sdk.a.b.a.e.i r2 = com.bytedance.sdk.p145a.p147b.p148a.p153e.Http2Stream.this
            monitor-enter(r2)
            r8.f5620a = r1     // Catch:{ all -> 0x0062 }
            monitor-exit(r2)     // Catch:{ all -> 0x0062 }
            com.bytedance.sdk.a.b.a.e.i r0 = com.bytedance.sdk.p145a.p147b.p148a.p153e.Http2Stream.this
            com.bytedance.sdk.a.b.a.e.g r0 = r0.f5610d
            r0.mo13784b()
            com.bytedance.sdk.a.b.a.e.i r0 = com.bytedance.sdk.p145a.p147b.p148a.p153e.Http2Stream.this
            r0.mo13824j()
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
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.p145a.p147b.p148a.p153e.Http2Stream.C1907a.close():void");
        }
    }

    /* compiled from: Http2Stream */
    /* renamed from: com.bytedance.sdk.a.b.a.e.i$b */
    private final class C1908b implements Source {
        /* renamed from: c */
        static final /* synthetic */ boolean f5624c = (!Http2Stream.class.desiredAssertionStatus());
        /* renamed from: a */
        boolean f5625a;
        /* renamed from: b */
        boolean f5626b;
        /* renamed from: e */
        private final Buffer f5628e = new Buffer();
        /* renamed from: f */
        private final Buffer f5629f = new Buffer();
        /* renamed from: g */
        private final long f5630g;

        C1908b(long j) {
            this.f5630g = j;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x005d, code lost:
            r10 = r7.f5627d.f5610d;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0061, code lost:
            monitor-enter(r10);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
            r7.f5627d.f5610d.f5542j += r8;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0080, code lost:
            if (r7.f5627d.f5610d.f5542j < ((long) (r7.f5627d.f5610d.f5544l.mo13863d() / 2))) goto L_0x0096;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0082, code lost:
            r7.f5627d.f5610d.mo13772a(0, r7.f5627d.f5610d.f5542j);
            r7.f5627d.f5610d.f5542j = 0;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0096, code lost:
            monitor-exit(r10);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0097, code lost:
            return r8;
     */
        /* renamed from: a */
        public long mo13511a(com.bytedance.sdk.p145a.p146a.Buffer r8, long r9) throws java.io.IOException {
            /*
            r7 = this;
            r0 = 0
            int r2 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r2 < 0) goto L_0x009e
            com.bytedance.sdk.a.b.a.e.i r2 = com.bytedance.sdk.p145a.p147b.p148a.p153e.Http2Stream.this
            monitor-enter(r2)
            r7.m7201b()     // Catch:{ all -> 0x009b }
            r7.m7202c()     // Catch:{ all -> 0x009b }
            com.bytedance.sdk.a.a.c r3 = r7.f5629f     // Catch:{ all -> 0x009b }
            long r3 = r3.mo13530b()     // Catch:{ all -> 0x009b }
            int r5 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r5 != 0) goto L_0x001d
            r8 = -1
            monitor-exit(r2)     // Catch:{ all -> 0x009b }
            return r8
        L_0x001d:
            com.bytedance.sdk.a.a.c r3 = r7.f5629f     // Catch:{ all -> 0x009b }
            com.bytedance.sdk.a.a.c r4 = r7.f5629f     // Catch:{ all -> 0x009b }
            long r4 = r4.mo13530b()     // Catch:{ all -> 0x009b }
            long r9 = java.lang.Math.min(r9, r4)     // Catch:{ all -> 0x009b }
            long r8 = r3.mo13511a(r8, r9)     // Catch:{ all -> 0x009b }
            com.bytedance.sdk.a.b.a.e.i r10 = com.bytedance.sdk.p145a.p147b.p148a.p153e.Http2Stream.this     // Catch:{ all -> 0x009b }
            long r3 = r10.f5607a     // Catch:{ all -> 0x009b }
            long r3 = r3 + r8
            r10.f5607a = r3     // Catch:{ all -> 0x009b }
            com.bytedance.sdk.a.b.a.e.i r10 = com.bytedance.sdk.p145a.p147b.p148a.p153e.Http2Stream.this     // Catch:{ all -> 0x009b }
            long r3 = r10.f5607a     // Catch:{ all -> 0x009b }
            com.bytedance.sdk.a.b.a.e.i r10 = com.bytedance.sdk.p145a.p147b.p148a.p153e.Http2Stream.this     // Catch:{ all -> 0x009b }
            com.bytedance.sdk.a.b.a.e.g r10 = r10.f5610d     // Catch:{ all -> 0x009b }
            com.bytedance.sdk.a.b.a.e.n r10 = r10.f5544l     // Catch:{ all -> 0x009b }
            int r10 = r10.mo13863d()     // Catch:{ all -> 0x009b }
            int r10 = r10 / 2
            long r5 = (long) r10     // Catch:{ all -> 0x009b }
            int r10 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r10 < 0) goto L_0x005c
            com.bytedance.sdk.a.b.a.e.i r10 = com.bytedance.sdk.p145a.p147b.p148a.p153e.Http2Stream.this     // Catch:{ all -> 0x009b }
            com.bytedance.sdk.a.b.a.e.g r10 = r10.f5610d     // Catch:{ all -> 0x009b }
            com.bytedance.sdk.a.b.a.e.i r3 = com.bytedance.sdk.p145a.p147b.p148a.p153e.Http2Stream.this     // Catch:{ all -> 0x009b }
            int r3 = r3.f5609c     // Catch:{ all -> 0x009b }
            com.bytedance.sdk.a.b.a.e.i r4 = com.bytedance.sdk.p145a.p147b.p148a.p153e.Http2Stream.this     // Catch:{ all -> 0x009b }
            long r4 = r4.f5607a     // Catch:{ all -> 0x009b }
            r10.mo13772a(r3, r4)     // Catch:{ all -> 0x009b }
            com.bytedance.sdk.a.b.a.e.i r10 = com.bytedance.sdk.p145a.p147b.p148a.p153e.Http2Stream.this     // Catch:{ all -> 0x009b }
            r10.f5607a = r0     // Catch:{ all -> 0x009b }
        L_0x005c:
            monitor-exit(r2)     // Catch:{ all -> 0x009b }
            com.bytedance.sdk.a.b.a.e.i r10 = com.bytedance.sdk.p145a.p147b.p148a.p153e.Http2Stream.this
            com.bytedance.sdk.a.b.a.e.g r10 = r10.f5610d
            monitor-enter(r10)
            com.bytedance.sdk.a.b.a.e.i r2 = com.bytedance.sdk.p145a.p147b.p148a.p153e.Http2Stream.this     // Catch:{ all -> 0x0098 }
            com.bytedance.sdk.a.b.a.e.g r2 = r2.f5610d     // Catch:{ all -> 0x0098 }
            long r3 = r2.f5542j     // Catch:{ all -> 0x0098 }
            long r3 = r3 + r8
            r2.f5542j = r3     // Catch:{ all -> 0x0098 }
            com.bytedance.sdk.a.b.a.e.i r2 = com.bytedance.sdk.p145a.p147b.p148a.p153e.Http2Stream.this     // Catch:{ all -> 0x0098 }
            com.bytedance.sdk.a.b.a.e.g r2 = r2.f5610d     // Catch:{ all -> 0x0098 }
            long r2 = r2.f5542j     // Catch:{ all -> 0x0098 }
            com.bytedance.sdk.a.b.a.e.i r4 = com.bytedance.sdk.p145a.p147b.p148a.p153e.Http2Stream.this     // Catch:{ all -> 0x0098 }
            com.bytedance.sdk.a.b.a.e.g r4 = r4.f5610d     // Catch:{ all -> 0x0098 }
            com.bytedance.sdk.a.b.a.e.n r4 = r4.f5544l     // Catch:{ all -> 0x0098 }
            int r4 = r4.mo13863d()     // Catch:{ all -> 0x0098 }
            int r4 = r4 / 2
            long r4 = (long) r4     // Catch:{ all -> 0x0098 }
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 < 0) goto L_0x0096
            com.bytedance.sdk.a.b.a.e.i r2 = com.bytedance.sdk.p145a.p147b.p148a.p153e.Http2Stream.this     // Catch:{ all -> 0x0098 }
            com.bytedance.sdk.a.b.a.e.g r2 = r2.f5610d     // Catch:{ all -> 0x0098 }
            r3 = 0
            com.bytedance.sdk.a.b.a.e.i r4 = com.bytedance.sdk.p145a.p147b.p148a.p153e.Http2Stream.this     // Catch:{ all -> 0x0098 }
            com.bytedance.sdk.a.b.a.e.g r4 = r4.f5610d     // Catch:{ all -> 0x0098 }
            long r4 = r4.f5542j     // Catch:{ all -> 0x0098 }
            r2.mo13772a(r3, r4)     // Catch:{ all -> 0x0098 }
            com.bytedance.sdk.a.b.a.e.i r2 = com.bytedance.sdk.p145a.p147b.p148a.p153e.Http2Stream.this     // Catch:{ all -> 0x0098 }
            com.bytedance.sdk.a.b.a.e.g r2 = r2.f5610d     // Catch:{ all -> 0x0098 }
            r2.f5542j = r0     // Catch:{ all -> 0x0098 }
        L_0x0096:
            monitor-exit(r10)     // Catch:{ all -> 0x0098 }
            return r8
        L_0x0098:
            r8 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x0098 }
            throw r8
        L_0x009b:
            r8 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x009b }
            throw r8
        L_0x009e:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "byteCount < 0: "
            r0.append(r1)
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            r8.<init>(r9)
            throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.p145a.p147b.p148a.p153e.Http2Stream.C1908b.mo13511a(com.bytedance.sdk.a.a.c, long):long");
        }

        /* renamed from: b */
        private void m7201b() throws IOException {
            Http2Stream.this.f5612f.mo13501a();
            while (this.f5629f.mo13530b() == 0 && !this.f5626b && !this.f5625a && Http2Stream.this.f5614h == null) {
                try {
                    Http2Stream.this.mo13826l();
                } finally {
                    Http2Stream.this.f5612f.mo13828h();
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo13827a(BufferedSource eVar, long j) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            if (f5624c || !Thread.holdsLock(Http2Stream.this)) {
                while (j > 0) {
                    synchronized (Http2Stream.this) {
                        z = this.f5626b;
                        z2 = true;
                        z3 = this.f5629f.mo13530b() + j > this.f5630g;
                    }
                    if (z3) {
                        eVar.mo13556h(j);
                        Http2Stream.this.mo13814b(ErrorCode.FLOW_CONTROL_ERROR);
                        return;
                    } else if (z) {
                        eVar.mo13556h(j);
                        return;
                    } else {
                        long a = eVar.mo13511a(this.f5628e, j);
                        if (a != -1) {
                            j -= a;
                            synchronized (Http2Stream.this) {
                                if (this.f5629f.mo13530b() != 0) {
                                    z2 = false;
                                }
                                this.f5629f.mo13519a((Source) this.f5628e);
                                if (z2) {
                                    Http2Stream.this.notifyAll();
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
        public Timeout mo13512a() {
            return Http2Stream.this.f5612f;
        }

        public void close() throws IOException {
            synchronized (Http2Stream.this) {
                this.f5625a = true;
                this.f5629f.mo13573r();
                Http2Stream.this.notifyAll();
            }
            Http2Stream.this.mo13824j();
        }

        /* renamed from: c */
        private void m7202c() throws IOException {
            if (this.f5625a) {
                throw new IOException("stream closed");
            } else if (Http2Stream.this.f5614h != null) {
                throw new StreamResetException(Http2Stream.this.f5614h);
            }
        }
    }

    /* compiled from: Http2Stream */
    /* renamed from: com.bytedance.sdk.a.b.a.e.i$c */
    class C1909c extends AsyncTimeout {
        C1909c() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public void mo13505c() {
            Http2Stream.this.mo13814b(ErrorCode.CANCEL);
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public IOException mo13503b(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        /* renamed from: h */
        public void mo13828h() throws IOException {
            if (mo13504b()) {
                throw mo13503b(null);
            }
        }
    }

    Http2Stream(int i, Http2Connection gVar, boolean z, boolean z2, List<Header> list) {
        if (gVar == null) {
            throw new NullPointerException("connection == null");
        } else if (list != null) {
            this.f5609c = i;
            this.f5610d = gVar;
            this.f5608b = (long) gVar.f5545m.mo13863d();
            this.f5618m = new C1908b((long) gVar.f5544l.mo13863d());
            this.f5611e = new C1907a();
            this.f5618m.f5626b = z2;
            this.f5611e.f5621b = z;
            this.f5615j = list;
        } else {
            throw new NullPointerException("requestHeaders == null");
        }
    }

    /* renamed from: a */
    public int mo13809a() {
        return this.f5609c;
    }

    /* renamed from: b */
    public synchronized boolean mo13815b() {
        if (this.f5614h != null) {
            return false;
        }
        if ((this.f5618m.f5626b || this.f5618m.f5625a) && ((this.f5611e.f5621b || this.f5611e.f5620a) && this.f5617l)) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    public boolean mo13817c() {
        if (this.f5610d.f5534b == ((this.f5609c & 1) == 1)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: d */
    public synchronized List<Header> mo13818d() throws IOException {
        List<Header> list;
        if (mo13817c()) {
            this.f5612f.mo13501a();
            while (this.f5616k == null && this.f5614h == null) {
                try {
                    mo13826l();
                } catch (Throwable th) {
                    this.f5612f.mo13828h();
                    throw th;
                }
            }
            this.f5612f.mo13828h();
            list = this.f5616k;
            if (list != null) {
                this.f5616k = null;
            } else {
                throw new StreamResetException(this.f5614h);
            }
        } else {
            throw new IllegalStateException("servers cannot read response headers");
        }
        return list;
    }

    /* renamed from: e */
    public Timeout mo13819e() {
        return this.f5612f;
    }

    /* renamed from: f */
    public Timeout mo13820f() {
        return this.f5613g;
    }

    /* renamed from: g */
    public Source mo13821g() {
        return this.f5618m;
    }

    /* renamed from: h */
    public Sink mo13822h() {
        synchronized (this) {
            if (!this.f5617l) {
                if (!mo13817c()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
            }
        }
        return this.f5611e;
    }

    /* renamed from: a */
    public void mo13812a(ErrorCode bVar) throws IOException {
        if (m7179d(bVar)) {
            this.f5610d.mo13785b(this.f5609c, bVar);
        }
    }

    /* renamed from: b */
    public void mo13814b(ErrorCode bVar) {
        if (m7179d(bVar)) {
            this.f5610d.mo13774a(this.f5609c, bVar);
        }
    }

    /* renamed from: d */
    private boolean m7179d(ErrorCode bVar) {
        if (f5606i || !Thread.holdsLock(this)) {
            synchronized (this) {
                if (this.f5614h != null) {
                    return false;
                }
                if (this.f5618m.f5626b && this.f5611e.f5621b) {
                    return false;
                }
                this.f5614h = bVar;
                notifyAll();
                this.f5610d.mo13783b(this.f5609c);
                return true;
            }
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo13813a(List<Header> list) {
        boolean z;
        if (f5606i || !Thread.holdsLock(this)) {
            synchronized (this) {
                z = true;
                this.f5617l = true;
                if (this.f5616k == null) {
                    this.f5616k = list;
                    z = mo13815b();
                    notifyAll();
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(this.f5616k);
                    arrayList.add(null);
                    arrayList.addAll(list);
                    this.f5616k = arrayList;
                }
            }
            if (!z) {
                this.f5610d.mo13783b(this.f5609c);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo13811a(BufferedSource eVar, int i) throws IOException {
        if (f5606i || !Thread.holdsLock(this)) {
            this.f5618m.mo13827a(eVar, (long) i);
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public void mo13823i() {
        boolean b;
        if (f5606i || !Thread.holdsLock(this)) {
            synchronized (this) {
                this.f5618m.f5626b = true;
                b = mo13815b();
                notifyAll();
            }
            if (!b) {
                this.f5610d.mo13783b(this.f5609c);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: c */
    public synchronized void mo13816c(ErrorCode bVar) {
        if (this.f5614h == null) {
            this.f5614h = bVar;
            notifyAll();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public void mo13824j() throws IOException {
        boolean z;
        boolean b;
        if (f5606i || !Thread.holdsLock(this)) {
            synchronized (this) {
                z = !this.f5618m.f5626b && this.f5618m.f5625a && (this.f5611e.f5621b || this.f5611e.f5620a);
                b = mo13815b();
            }
            if (z) {
                mo13812a(ErrorCode.CANCEL);
            } else if (!b) {
                this.f5610d.mo13783b(this.f5609c);
            }
        } else {
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo13810a(long j) {
        this.f5608b += j;
        if (j > 0) {
            notifyAll();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: k */
    public void mo13825k() throws IOException {
        if (this.f5611e.f5620a) {
            throw new IOException("stream closed");
        } else if (!this.f5611e.f5621b) {
            ErrorCode bVar = this.f5614h;
            if (bVar != null) {
                throw new StreamResetException(bVar);
            }
        } else {
            throw new IOException("stream finished");
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: l */
    public void mo13826l() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            throw new InterruptedIOException();
        }
    }
}
