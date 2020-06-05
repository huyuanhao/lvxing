package com.bytedance.sdk.p145a.p147b.p148a.p153e;

import com.bytedance.sdk.p145a.p146a.Buffer;
import com.bytedance.sdk.p145a.p146a.BufferedSink;
import com.bytedance.sdk.p145a.p146a.BufferedSource;
import com.bytedance.sdk.p145a.p146a.ByteString;
import com.bytedance.sdk.p145a.p147b.p148a.C1876c;
import com.bytedance.sdk.p145a.p147b.p148a.NamedRunnable;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.bytedance.sdk.a.b.a.e.g */
public final class Http2Connection implements Closeable {
    /* renamed from: a */
    static final ExecutorService f5532a;
    /* renamed from: s */
    static final /* synthetic */ boolean f5533s = (!Http2Connection.class.desiredAssertionStatus());
    /* renamed from: b */
    final boolean f5534b;
    /* renamed from: c */
    final C1899b f5535c;
    /* renamed from: d */
    final Map<Integer, Http2Stream> f5536d = new LinkedHashMap();
    /* renamed from: e */
    final String f5537e;
    /* renamed from: f */
    int f5538f;
    /* renamed from: g */
    int f5539g;
    /* renamed from: h */
    boolean f5540h;
    /* renamed from: i */
    final PushObserver f5541i;
    /* renamed from: j */
    long f5542j = 0;
    /* renamed from: k */
    long f5543k;
    /* renamed from: l */
    Settings f5544l = new Settings();
    /* renamed from: m */
    final Settings f5545m = new Settings();
    /* renamed from: n */
    boolean f5546n = false;
    /* renamed from: o */
    final Socket f5547o;
    /* renamed from: p */
    final Http2Writer f5548p;
    /* renamed from: q */
    final C1901c f5549q;
    /* renamed from: r */
    final Set<Integer> f5550r = new LinkedHashSet();
    /* renamed from: t */
    private final ExecutorService f5551t;
    /* renamed from: u */
    private Map<Integer, Ping> f5552u;
    /* renamed from: v */
    private int f5553v;

    /* compiled from: Http2Connection */
    /* renamed from: com.bytedance.sdk.a.b.a.e.g$a */
    public static class C1898a {
        /* renamed from: a */
        Socket f5580a;
        /* renamed from: b */
        String f5581b;
        /* renamed from: c */
        BufferedSource f5582c;
        /* renamed from: d */
        BufferedSink f5583d;
        /* renamed from: e */
        C1899b f5584e = C1899b.f5587f;
        /* renamed from: f */
        PushObserver f5585f = PushObserver.f5649a;
        /* renamed from: g */
        boolean f5586g;

        public C1898a(boolean z) {
            this.f5586g = z;
        }

        /* renamed from: a */
        public C1898a mo13794a(Socket socket, String str, BufferedSource eVar, BufferedSink dVar) {
            this.f5580a = socket;
            this.f5581b = str;
            this.f5582c = eVar;
            this.f5583d = dVar;
            return this;
        }

        /* renamed from: a */
        public C1898a mo13793a(C1899b bVar) {
            this.f5584e = bVar;
            return this;
        }

        /* renamed from: a */
        public Http2Connection mo13795a() {
            return new Http2Connection(this);
        }
    }

    /* compiled from: Http2Connection */
    /* renamed from: com.bytedance.sdk.a.b.a.e.g$b */
    public static abstract class C1899b {
        /* renamed from: f */
        public static final C1899b f5587f = new C1899b() {
            /* renamed from: a */
            public void mo13692a(Http2Stream iVar) throws IOException {
                iVar.mo13812a(ErrorCode.REFUSED_STREAM);
            }
        };

        /* renamed from: a */
        public void mo13691a(Http2Connection gVar) {
        }

        /* renamed from: a */
        public abstract void mo13692a(Http2Stream iVar) throws IOException;
    }

    /* compiled from: Http2Connection */
    /* renamed from: com.bytedance.sdk.a.b.a.e.g$c */
    class C1901c extends NamedRunnable implements C1906b {
        /* renamed from: b */
        final Http2Reader f5588b;

        /* renamed from: a */
        public void mo13796a(int i, int i2, int i3, boolean z) {
        }

        /* renamed from: b */
        public void mo13805b() {
        }

        C1901c(Http2Reader hVar) {
            super("OkHttp %s", Http2Connection.this.f5537e);
            this.f5588b = hVar;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            r0 = com.bytedance.sdk.p145a.p147b.p148a.p153e.ErrorCode.PROTOCOL_ERROR;
            r1 = com.bytedance.sdk.p145a.p147b.p148a.p153e.ErrorCode.PROTOCOL_ERROR;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            r2 = r4.f5589c;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            r4.f5589c.mo13780a(r0, r1);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0030, code lost:
            com.bytedance.sdk.p145a.p147b.p148a.C1876c.m6961a((java.io.Closeable) r4.f5588b);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0035, code lost:
            throw r2;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
            r2 = move-exception;
     */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x001c */
        /* renamed from: a */
        public void mo13684a() {
            /*
            r4 = this;
            com.bytedance.sdk.a.b.a.e.b r0 = com.bytedance.sdk.p145a.p147b.p148a.p153e.ErrorCode.INTERNAL_ERROR
            com.bytedance.sdk.a.b.a.e.b r1 = com.bytedance.sdk.p145a.p147b.p148a.p153e.ErrorCode.INTERNAL_ERROR
            com.bytedance.sdk.a.b.a.e.h r2 = r4.f5588b     // Catch:{ IOException -> 0x001c }
            r2.mo13806a(r4)     // Catch:{ IOException -> 0x001c }
        L_0x0009:
            com.bytedance.sdk.a.b.a.e.h r2 = r4.f5588b     // Catch:{ IOException -> 0x001c }
            r3 = 0
            boolean r2 = r2.mo13807a(r3, r4)     // Catch:{ IOException -> 0x001c }
            if (r2 == 0) goto L_0x0013
            goto L_0x0009
        L_0x0013:
            com.bytedance.sdk.a.b.a.e.b r0 = com.bytedance.sdk.p145a.p147b.p148a.p153e.ErrorCode.NO_ERROR     // Catch:{ IOException -> 0x001c }
            com.bytedance.sdk.a.b.a.e.b r1 = com.bytedance.sdk.p145a.p147b.p148a.p153e.ErrorCode.CANCEL     // Catch:{ IOException -> 0x001c }
            com.bytedance.sdk.a.b.a.e.g r2 = com.bytedance.sdk.p145a.p147b.p148a.p153e.Http2Connection.this     // Catch:{ IOException -> 0x0025 }
            goto L_0x0022
        L_0x001a:
            r2 = move-exception
            goto L_0x002b
        L_0x001c:
            com.bytedance.sdk.a.b.a.e.b r0 = com.bytedance.sdk.p145a.p147b.p148a.p153e.ErrorCode.PROTOCOL_ERROR     // Catch:{ all -> 0x001a }
            com.bytedance.sdk.a.b.a.e.b r1 = com.bytedance.sdk.p145a.p147b.p148a.p153e.ErrorCode.PROTOCOL_ERROR     // Catch:{ all -> 0x001a }
            com.bytedance.sdk.a.b.a.e.g r2 = com.bytedance.sdk.p145a.p147b.p148a.p153e.Http2Connection.this     // Catch:{ IOException -> 0x0025 }
        L_0x0022:
            r2.mo13780a(r0, r1)     // Catch:{ IOException -> 0x0025 }
        L_0x0025:
            com.bytedance.sdk.a.b.a.e.h r0 = r4.f5588b
            com.bytedance.sdk.p145a.p147b.p148a.C1876c.m6961a(r0)
            return
        L_0x002b:
            com.bytedance.sdk.a.b.a.e.g r3 = com.bytedance.sdk.p145a.p147b.p148a.p153e.Http2Connection.this     // Catch:{ IOException -> 0x0030 }
            r3.mo13780a(r0, r1)     // Catch:{ IOException -> 0x0030 }
        L_0x0030:
            com.bytedance.sdk.a.b.a.e.h r0 = r4.f5588b
            com.bytedance.sdk.p145a.p147b.p148a.C1876c.m6961a(r0)
            throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.p145a.p147b.p148a.p153e.Http2Connection.C1901c.mo13684a():void");
        }

        /* renamed from: a */
        public void mo13803a(boolean z, int i, BufferedSource eVar, int i2) throws IOException {
            if (Http2Connection.this.mo13792d(i)) {
                Http2Connection.this.mo13773a(i, eVar, i2, z);
                return;
            }
            Http2Stream a = Http2Connection.this.mo13770a(i);
            if (a == null) {
                Http2Connection.this.mo13774a(i, ErrorCode.PROTOCOL_ERROR);
                eVar.mo13556h((long) i2);
                return;
            }
            a.mo13811a(eVar, i2);
            if (z) {
                a.mo13823i();
            }
        }

        /* JADX INFO: used method not loaded: com.bytedance.sdk.a.b.a.e.i.a(java.util.List):null, types can be incorrect */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x006f, code lost:
            r0.mo13813a((java.util.List) r13);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0072, code lost:
            if (r10 == false) goto L_0x0077;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0074, code lost:
            r0.mo13823i();
     */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0077, code lost:
            return;
     */
        /* renamed from: a */
        public void mo13802a(boolean r10, int r11, int r12, java.util.List<com.bytedance.sdk.p145a.p147b.p148a.p153e.Header> r13) {
            /*
            r9 = this;
            com.bytedance.sdk.a.b.a.e.g r12 = com.bytedance.sdk.p145a.p147b.p148a.p153e.Http2Connection.this
            boolean r12 = r12.mo13792d(r11)
            if (r12 == 0) goto L_0x000e
            com.bytedance.sdk.a.b.a.e.g r12 = com.bytedance.sdk.p145a.p147b.p148a.p153e.Http2Connection.this
            r12.mo13776a(r11, r13, r10)
            return
        L_0x000e:
            com.bytedance.sdk.a.b.a.e.g r12 = com.bytedance.sdk.p145a.p147b.p148a.p153e.Http2Connection.this
            monitor-enter(r12)
            com.bytedance.sdk.a.b.a.e.g r0 = com.bytedance.sdk.p145a.p147b.p148a.p153e.Http2Connection.this     // Catch:{ all -> 0x0078 }
            com.bytedance.sdk.a.b.a.e.i r0 = r0.mo13770a(r11)     // Catch:{ all -> 0x0078 }
            if (r0 != 0) goto L_0x006e
            com.bytedance.sdk.a.b.a.e.g r0 = com.bytedance.sdk.p145a.p147b.p148a.p153e.Http2Connection.this     // Catch:{ all -> 0x0078 }
            boolean r0 = r0.f5540h     // Catch:{ all -> 0x0078 }
            if (r0 == 0) goto L_0x0021
            monitor-exit(r12)     // Catch:{ all -> 0x0078 }
            return
        L_0x0021:
            com.bytedance.sdk.a.b.a.e.g r0 = com.bytedance.sdk.p145a.p147b.p148a.p153e.Http2Connection.this     // Catch:{ all -> 0x0078 }
            int r0 = r0.f5538f     // Catch:{ all -> 0x0078 }
            if (r11 > r0) goto L_0x0029
            monitor-exit(r12)     // Catch:{ all -> 0x0078 }
            return
        L_0x0029:
            int r0 = r11 % 2
            com.bytedance.sdk.a.b.a.e.g r1 = com.bytedance.sdk.p145a.p147b.p148a.p153e.Http2Connection.this     // Catch:{ all -> 0x0078 }
            int r1 = r1.f5539g     // Catch:{ all -> 0x0078 }
            r2 = 2
            int r1 = r1 % r2
            if (r0 != r1) goto L_0x0035
            monitor-exit(r12)     // Catch:{ all -> 0x0078 }
            return
        L_0x0035:
            com.bytedance.sdk.a.b.a.e.i r0 = new com.bytedance.sdk.a.b.a.e.i     // Catch:{ all -> 0x0078 }
            com.bytedance.sdk.a.b.a.e.g r5 = com.bytedance.sdk.p145a.p147b.p148a.p153e.Http2Connection.this     // Catch:{ all -> 0x0078 }
            r6 = 0
            r3 = r0
            r4 = r11
            r7 = r10
            r8 = r13
            r3.m42997init(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0078 }
            com.bytedance.sdk.a.b.a.e.g r10 = com.bytedance.sdk.p145a.p147b.p148a.p153e.Http2Connection.this     // Catch:{ all -> 0x0078 }
            r10.f5538f = r11     // Catch:{ all -> 0x0078 }
            com.bytedance.sdk.a.b.a.e.g r10 = com.bytedance.sdk.p145a.p147b.p148a.p153e.Http2Connection.this     // Catch:{ all -> 0x0078 }
            java.util.Map<java.lang.Integer, com.bytedance.sdk.a.b.a.e.i> r10 = r10.f5536d     // Catch:{ all -> 0x0078 }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x0078 }
            r10.put(r13, r0)     // Catch:{ all -> 0x0078 }
            java.util.concurrent.ExecutorService r10 = com.bytedance.sdk.p145a.p147b.p148a.p153e.Http2Connection.f5532a     // Catch:{ all -> 0x0078 }
            com.bytedance.sdk.a.b.a.e.g$c$1 r13 = new com.bytedance.sdk.a.b.a.e.g$c$1     // Catch:{ all -> 0x0078 }
            java.lang.String r1 = "OkHttp %s stream %d"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0078 }
            r3 = 0
            com.bytedance.sdk.a.b.a.e.g r4 = com.bytedance.sdk.p145a.p147b.p148a.p153e.Http2Connection.this     // Catch:{ all -> 0x0078 }
            java.lang.String r4 = r4.f5537e     // Catch:{ all -> 0x0078 }
            r2[r3] = r4     // Catch:{ all -> 0x0078 }
            r3 = 1
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x0078 }
            r2[r3] = r11     // Catch:{ all -> 0x0078 }
            r13.m42990init(r1, r2, r0)     // Catch:{ all -> 0x0078 }
            r10.execute(r13)     // Catch:{ all -> 0x0078 }
            monitor-exit(r12)     // Catch:{ all -> 0x0078 }
            return
        L_0x006e:
            monitor-exit(r12)     // Catch:{ all -> 0x0078 }
            r0.mo13813a(r13)
            if (r10 == 0) goto L_0x0077
            r0.mo13823i()
        L_0x0077:
            return
        L_0x0078:
            r10 = move-exception
            monitor-exit(r12)     // Catch:{ all -> 0x0078 }
            throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.p145a.p147b.p148a.p153e.Http2Connection.C1901c.mo13802a(boolean, int, int, java.util.List):void");
        }

        /* renamed from: a */
        public void mo13799a(int i, ErrorCode bVar) {
            if (Http2Connection.this.mo13792d(i)) {
                Http2Connection.this.mo13789c(i, bVar);
                return;
            }
            Http2Stream b = Http2Connection.this.mo13783b(i);
            if (b != null) {
                b.mo13816c(bVar);
            }
        }

        /* renamed from: a */
        public void mo13804a(boolean z, Settings nVar) {
            Http2Stream[] iVarArr;
            long j;
            int i;
            synchronized (Http2Connection.this) {
                int d = Http2Connection.this.f5545m.mo13863d();
                if (z) {
                    Http2Connection.this.f5545m.mo13856a();
                }
                Http2Connection.this.f5545m.mo13857a(nVar);
                m7136a(nVar);
                int d2 = Http2Connection.this.f5545m.mo13863d();
                iVarArr = null;
                if (d2 == -1 || d2 == d) {
                    j = 0;
                } else {
                    j = (long) (d2 - d);
                    if (!Http2Connection.this.f5546n) {
                        Http2Connection.this.mo13778a(j);
                        Http2Connection.this.f5546n = true;
                    }
                    if (!Http2Connection.this.f5536d.isEmpty()) {
                        iVarArr = (Http2Stream[]) Http2Connection.this.f5536d.values().toArray(new Http2Stream[Http2Connection.this.f5536d.size()]);
                    }
                }
                Http2Connection.f5532a.execute(new NamedRunnable("OkHttp %s settings", Http2Connection.this.f5537e) {
                    /* renamed from: a */
                    public void mo13684a() {
                        Http2Connection.this.f5535c.mo13691a(Http2Connection.this);
                    }
                });
            }
            if (iVarArr != null && j != 0) {
                for (Http2Stream iVar : iVarArr) {
                    synchronized (iVar) {
                        iVar.mo13810a(j);
                    }
                }
            }
        }

        /* renamed from: a */
        private void m7136a(final Settings nVar) {
            Http2Connection.f5532a.execute(new NamedRunnable("OkHttp %s ACK Settings", new Object[]{Http2Connection.this.f5537e}) {
                /* renamed from: a */
                public void mo13684a() {
                    try {
                        Http2Connection.this.f5548p.mo13836a(nVar);
                    } catch (IOException unused) {
                    }
                }
            });
        }

        /* renamed from: a */
        public void mo13801a(boolean z, int i, int i2) {
            if (z) {
                Ping c = Http2Connection.this.mo13787c(i);
                if (c != null) {
                    c.mo13849b();
                    return;
                }
                return;
            }
            Http2Connection.this.mo13782a(true, i, i2, (Ping) null);
        }

        /* renamed from: a */
        public void mo13800a(int i, ErrorCode bVar, ByteString fVar) {
            Http2Stream[] iVarArr;
            fVar.mo13600g();
            synchronized (Http2Connection.this) {
                iVarArr = (Http2Stream[]) Http2Connection.this.f5536d.values().toArray(new Http2Stream[Http2Connection.this.f5536d.size()]);
                Http2Connection.this.f5540h = true;
            }
            int length = iVarArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                Http2Stream iVar = iVarArr[i2];
                if (iVar.mo13809a() > i && iVar.mo13817c()) {
                    iVar.mo13816c(ErrorCode.REFUSED_STREAM);
                    Http2Connection.this.mo13783b(iVar.mo13809a());
                }
            }
        }

        /* renamed from: a */
        public void mo13798a(int i, long j) {
            if (i == 0) {
                synchronized (Http2Connection.this) {
                    Http2Connection.this.f5543k += j;
                    Http2Connection.this.notifyAll();
                }
                return;
            }
            Http2Stream a = Http2Connection.this.mo13770a(i);
            if (a != null) {
                synchronized (a) {
                    a.mo13810a(j);
                }
            }
        }

        /* renamed from: a */
        public void mo13797a(int i, int i2, List<Header> list) {
            Http2Connection.this.mo13775a(i2, list);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public boolean mo13792d(int i) {
        return i != 0 && (i & 1) == 0;
    }

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 60, TimeUnit.SECONDS, new SynchronousQueue(), C1876c.m6959a("OkHttp Http2Connection", true));
        f5532a = threadPoolExecutor;
    }

    Http2Connection(C1898a aVar) {
        this.f5541i = aVar.f5585f;
        this.f5534b = aVar.f5586g;
        this.f5535c = aVar.f5584e;
        int i = 2;
        this.f5539g = aVar.f5586g ? 1 : 2;
        if (aVar.f5586g) {
            this.f5539g += 2;
        }
        if (aVar.f5586g) {
            i = 1;
        }
        this.f5553v = i;
        if (aVar.f5586g) {
            this.f5544l.mo13855a(7, 16777216);
        }
        this.f5537e = aVar.f5581b;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), C1876c.m6959a(C1876c.m6955a("OkHttp %s Push Observer", this.f5537e), true));
        this.f5551t = threadPoolExecutor;
        this.f5545m.mo13855a(7, 65535);
        this.f5545m.mo13855a(5, 16384);
        this.f5543k = (long) this.f5545m.mo13863d();
        this.f5547o = aVar.f5580a;
        this.f5548p = new Http2Writer(aVar.f5583d, this.f5534b);
        this.f5549q = new C1901c(new Http2Reader(aVar.f5582c, this.f5534b));
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: a */
    public synchronized Http2Stream mo13770a(int i) {
        return (Http2Stream) this.f5536d.get(Integer.valueOf(i));
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: b */
    public synchronized Http2Stream mo13783b(int i) {
        Http2Stream iVar;
        iVar = (Http2Stream) this.f5536d.remove(Integer.valueOf(i));
        notifyAll();
        return iVar;
    }

    /* renamed from: a */
    public synchronized int mo13769a() {
        return this.f5545m.mo13862c(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    /* renamed from: a */
    public Http2Stream mo13771a(List<Header> list, boolean z) throws IOException {
        return m7099b(0, list, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0037  */
    /* renamed from: b */
    private com.bytedance.sdk.p145a.p147b.p148a.p153e.Http2Stream m7099b(int r11, java.util.List<com.bytedance.sdk.p145a.p147b.p148a.p153e.Header> r12, boolean r13) throws java.io.IOException {
        /*
        r10 = this;
        r6 = r13 ^ 1
        r4 = 0
        com.bytedance.sdk.a.b.a.e.j r7 = r10.f5548p
        monitor-enter(r7)
        monitor-enter(r10)     // Catch:{ all -> 0x006c }
        boolean r0 = r10.f5540h     // Catch:{ all -> 0x0069 }
        if (r0 != 0) goto L_0x0063
        int r8 = r10.f5539g     // Catch:{ all -> 0x0069 }
        int r0 = r10.f5539g     // Catch:{ all -> 0x0069 }
        int r0 = r0 + 2
        r10.f5539g = r0     // Catch:{ all -> 0x0069 }
        com.bytedance.sdk.a.b.a.e.i r9 = new com.bytedance.sdk.a.b.a.e.i     // Catch:{ all -> 0x0069 }
        r0 = r9
        r1 = r8
        r2 = r10
        r3 = r6
        r5 = r12
        r0.m42997init(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x0069 }
        if (r13 == 0) goto L_0x0030
        long r0 = r10.f5543k     // Catch:{ all -> 0x0069 }
        r2 = 0
        int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
        if (r13 == 0) goto L_0x0030
        long r0 = r9.f5608b     // Catch:{ all -> 0x0069 }
        int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
        if (r13 != 0) goto L_0x002e
        goto L_0x0030
    L_0x002e:
        r13 = 0
        goto L_0x0031
    L_0x0030:
        r13 = 1
    L_0x0031:
        boolean r0 = r9.mo13815b()     // Catch:{ all -> 0x0069 }
        if (r0 == 0) goto L_0x0040
        java.util.Map<java.lang.Integer, com.bytedance.sdk.a.b.a.e.i> r0 = r10.f5536d     // Catch:{ all -> 0x0069 }
        java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0069 }
        r0.put(r1, r9)     // Catch:{ all -> 0x0069 }
    L_0x0040:
        monitor-exit(r10)     // Catch:{ all -> 0x0069 }
        if (r11 != 0) goto L_0x0049
        com.bytedance.sdk.a.b.a.e.j r0 = r10.f5548p     // Catch:{ all -> 0x006c }
        r0.mo13838a(r6, r8, r11, r12)     // Catch:{ all -> 0x006c }
        goto L_0x0052
    L_0x0049:
        boolean r0 = r10.f5534b     // Catch:{ all -> 0x006c }
        if (r0 != 0) goto L_0x005b
        com.bytedance.sdk.a.b.a.e.j r0 = r10.f5548p     // Catch:{ all -> 0x006c }
        r0.mo13832a(r11, r8, r12)     // Catch:{ all -> 0x006c }
    L_0x0052:
        monitor-exit(r7)     // Catch:{ all -> 0x006c }
        if (r13 == 0) goto L_0x005a
        com.bytedance.sdk.a.b.a.e.j r11 = r10.f5548p
        r11.mo13841b()
    L_0x005a:
        return r9
    L_0x005b:
        java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x006c }
        java.lang.String r12 = "client streams shouldn't have associated stream IDs"
        r11.<init>(r12)     // Catch:{ all -> 0x006c }
        throw r11     // Catch:{ all -> 0x006c }
    L_0x0063:
        com.bytedance.sdk.a.b.a.e.a r11 = new com.bytedance.sdk.a.b.a.e.a     // Catch:{ all -> 0x0069 }
        r11.m42959init()     // Catch:{ all -> 0x0069 }
        throw r11     // Catch:{ all -> 0x0069 }
    L_0x0069:
        r11 = move-exception
        monitor-exit(r10)     // Catch:{ all -> 0x0069 }
        throw r11     // Catch:{ all -> 0x006c }
    L_0x006c:
        r11 = move-exception
        monitor-exit(r7)     // Catch:{ all -> 0x006c }
        throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.p145a.p147b.p148a.p153e.Http2Connection.m7099b(int, java.util.List, boolean):com.bytedance.sdk.a.b.a.e.i");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:26|27|28) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            r3 = java.lang.Math.min((int) java.lang.Math.min(r12, r8.f5543k), r8.f5548p.mo13843c());
            r6 = (long) r3;
            r8.f5543k -= r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005f, code lost:
            throw new java.io.InterruptedIOException();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x005a */
    /* renamed from: a */
    public void mo13777a(int r9, boolean r10, com.bytedance.sdk.p145a.p146a.Buffer r11, long r12) throws java.io.IOException {
        /*
        r8 = this;
        r0 = 0
        r1 = 0
        int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
        if (r3 != 0) goto L_0x000d
        com.bytedance.sdk.a.b.a.e.j r12 = r8.f5548p
        r12.mo13839a(r10, r9, r11, r0)
        return
    L_0x000d:
        int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
        if (r3 <= 0) goto L_0x0062
        monitor-enter(r8)
    L_0x0012:
        long r3 = r8.f5543k     // Catch:{ InterruptedException -> 0x005a }
        int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
        if (r5 > 0) goto L_0x0030
        java.util.Map<java.lang.Integer, com.bytedance.sdk.a.b.a.e.i> r3 = r8.f5536d     // Catch:{ InterruptedException -> 0x005a }
        java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch:{ InterruptedException -> 0x005a }
        boolean r3 = r3.containsKey(r4)     // Catch:{ InterruptedException -> 0x005a }
        if (r3 == 0) goto L_0x0028
        r8.wait()     // Catch:{ InterruptedException -> 0x005a }
        goto L_0x0012
    L_0x0028:
        java.io.IOException r9 = new java.io.IOException     // Catch:{ InterruptedException -> 0x005a }
        java.lang.String r10 = "stream closed"
        r9.<init>(r10)     // Catch:{ InterruptedException -> 0x005a }
        throw r9     // Catch:{ InterruptedException -> 0x005a }
    L_0x0030:
        long r3 = r8.f5543k     // Catch:{ all -> 0x0058 }
        long r3 = java.lang.Math.min(r12, r3)     // Catch:{ all -> 0x0058 }
        int r4 = (int) r3     // Catch:{ all -> 0x0058 }
        com.bytedance.sdk.a.b.a.e.j r3 = r8.f5548p     // Catch:{ all -> 0x0058 }
        int r3 = r3.mo13843c()     // Catch:{ all -> 0x0058 }
        int r3 = java.lang.Math.min(r4, r3)     // Catch:{ all -> 0x0058 }
        long r4 = r8.f5543k     // Catch:{ all -> 0x0058 }
        long r6 = (long) r3     // Catch:{ all -> 0x0058 }
        long r4 = r4 - r6
        r8.f5543k = r4     // Catch:{ all -> 0x0058 }
        monitor-exit(r8)     // Catch:{ all -> 0x0058 }
        long r12 = r12 - r6
        com.bytedance.sdk.a.b.a.e.j r4 = r8.f5548p
        if (r10 == 0) goto L_0x0053
        int r5 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
        if (r5 != 0) goto L_0x0053
        r5 = 1
        goto L_0x0054
    L_0x0053:
        r5 = 0
    L_0x0054:
        r4.mo13839a(r5, r9, r11, r3)
        goto L_0x000d
    L_0x0058:
        r9 = move-exception
        goto L_0x0060
    L_0x005a:
        java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch:{ all -> 0x0058 }
        r9.<init>()     // Catch:{ all -> 0x0058 }
        throw r9     // Catch:{ all -> 0x0058 }
    L_0x0060:
        monitor-exit(r8)     // Catch:{ all -> 0x0058 }
        throw r9
    L_0x0062:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.p145a.p147b.p148a.p153e.Http2Connection.mo13777a(int, boolean, com.bytedance.sdk.a.a.c, long):void");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo13778a(long j) {
        this.f5543k += j;
        if (j > 0) {
            notifyAll();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo13774a(int i, ErrorCode bVar) {
        ExecutorService executorService = f5532a;
        final int i2 = i;
        final ErrorCode bVar2 = bVar;
        C18911 r1 = new NamedRunnable("OkHttp %s stream %d", new Object[]{this.f5537e, Integer.valueOf(i)}) {
            /* renamed from: a */
            public void mo13684a() {
                try {
                    Http2Connection.this.mo13785b(i2, bVar2);
                } catch (IOException unused) {
                }
            }
        };
        executorService.execute(r1);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo13785b(int i, ErrorCode bVar) throws IOException {
        this.f5548p.mo13834a(i, bVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo13772a(int i, long j) {
        ExecutorService executorService = f5532a;
        final int i2 = i;
        final long j2 = j;
        C18922 r1 = new NamedRunnable("OkHttp Window Update %s stream %d", new Object[]{this.f5537e, Integer.valueOf(i)}) {
            /* renamed from: a */
            public void mo13684a() {
                try {
                    Http2Connection.this.f5548p.mo13833a(i2, j2);
                } catch (IOException unused) {
                }
            }
        };
        executorService.execute(r1);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo13782a(boolean z, int i, int i2, Ping lVar) {
        ExecutorService executorService = f5532a;
        final boolean z2 = z;
        final int i3 = i;
        final int i4 = i2;
        final Ping lVar2 = lVar;
        C18933 r1 = new NamedRunnable("OkHttp %s ping %08x%08x", new Object[]{this.f5537e, Integer.valueOf(i), Integer.valueOf(i2)}) {
            /* renamed from: a */
            public void mo13684a() {
                try {
                    Http2Connection.this.mo13786b(z2, i3, i4, lVar2);
                } catch (IOException unused) {
                }
            }
        };
        executorService.execute(r1);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo13786b(boolean z, int i, int i2, Ping lVar) throws IOException {
        synchronized (this.f5548p) {
            if (lVar != null) {
                lVar.mo13848a();
            }
            this.f5548p.mo13837a(z, i, i2);
        }
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: c */
    public synchronized Ping mo13787c(int i) {
        return this.f5552u != null ? (Ping) this.f5552u.remove(Integer.valueOf(i)) : null;
    }

    /* renamed from: b */
    public void mo13784b() throws IOException {
        this.f5548p.mo13841b();
    }

    /* renamed from: a */
    public void mo13779a(ErrorCode bVar) throws IOException {
        synchronized (this.f5548p) {
            synchronized (this) {
                if (!this.f5540h) {
                    this.f5540h = true;
                    int i = this.f5538f;
                    this.f5548p.mo13835a(i, bVar, C1876c.f5398a);
                }
            }
        }
    }

    public void close() throws IOException {
        mo13780a(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo13780a(ErrorCode bVar, ErrorCode bVar2) throws IOException {
        Http2Stream[] iVarArr;
        if (f5533s || !Thread.holdsLock(this)) {
            Ping[] lVarArr = null;
            try {
                mo13779a(bVar);
                e = null;
            } catch (IOException e) {
                e = e;
            }
            synchronized (this) {
                if (!this.f5536d.isEmpty()) {
                    iVarArr = (Http2Stream[]) this.f5536d.values().toArray(new Http2Stream[this.f5536d.size()]);
                    this.f5536d.clear();
                } else {
                    iVarArr = null;
                }
                if (this.f5552u != null) {
                    Ping[] lVarArr2 = (Ping[]) this.f5552u.values().toArray(new Ping[this.f5552u.size()]);
                    this.f5552u = null;
                    lVarArr = lVarArr2;
                }
            }
            if (iVarArr != null) {
                IOException iOException = e;
                for (Http2Stream a : iVarArr) {
                    try {
                        a.mo13812a(bVar2);
                    } catch (IOException e2) {
                        if (iOException != null) {
                            iOException = e2;
                        }
                    }
                }
                e = iOException;
            }
            if (lVarArr != null) {
                for (Ping c : lVarArr) {
                    c.mo13850c();
                }
            }
            try {
                this.f5548p.close();
            } catch (IOException e3) {
                if (e == null) {
                    e = e3;
                }
            }
            try {
                this.f5547o.close();
            } catch (IOException e4) {
                e = e4;
            }
            if (e != null) {
                throw e;
            }
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: c */
    public void mo13788c() throws IOException {
        mo13781a(true);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo13781a(boolean z) throws IOException {
        if (z) {
            this.f5548p.mo13829a();
            this.f5548p.mo13842b(this.f5544l);
            int d = this.f5544l.mo13863d();
            if (d != 65535) {
                this.f5548p.mo13833a(0, (long) (d - 65535));
            }
        }
        new Thread(this.f5549q).start();
    }

    /* renamed from: d */
    public synchronized boolean mo13791d() {
        return this.f5540h;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo13775a(int i, List<Header> list) {
        synchronized (this) {
            if (this.f5550r.contains(Integer.valueOf(i))) {
                mo13774a(i, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.f5550r.add(Integer.valueOf(i));
            ExecutorService executorService = this.f5551t;
            final int i2 = i;
            final List<Header> list2 = list;
            C18944 r1 = new NamedRunnable("OkHttp %s Push Request[%s]", new Object[]{this.f5537e, Integer.valueOf(i)}) {
                /* renamed from: a */
                public void mo13684a() {
                    if (Http2Connection.this.f5541i.mo13853a(i2, list2)) {
                        try {
                            Http2Connection.this.f5548p.mo13834a(i2, ErrorCode.CANCEL);
                            synchronized (Http2Connection.this) {
                                Http2Connection.this.f5550r.remove(Integer.valueOf(i2));
                            }
                        } catch (IOException unused) {
                        }
                    }
                }
            };
            executorService.execute(r1);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo13776a(int i, List<Header> list, boolean z) {
        ExecutorService executorService = this.f5551t;
        final int i2 = i;
        final List<Header> list2 = list;
        final boolean z2 = z;
        C18955 r1 = new NamedRunnable("OkHttp %s Push Headers[%s]", new Object[]{this.f5537e, Integer.valueOf(i)}) {
            /* renamed from: a */
            public void mo13684a() {
                boolean a = Http2Connection.this.f5541i.mo13854a(i2, list2, z2);
                if (a) {
                    try {
                        Http2Connection.this.f5548p.mo13834a(i2, ErrorCode.CANCEL);
                    } catch (IOException unused) {
                        return;
                    }
                }
                if (a || z2) {
                    synchronized (Http2Connection.this) {
                        Http2Connection.this.f5550r.remove(Integer.valueOf(i2));
                    }
                }
            }
        };
        executorService.execute(r1);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo13773a(int i, BufferedSource eVar, int i2, boolean z) throws IOException {
        final Buffer cVar = new Buffer();
        long j = (long) i2;
        eVar.mo13527a(j);
        eVar.mo13511a(cVar, j);
        if (cVar.mo13530b() == j) {
            ExecutorService executorService = this.f5551t;
            final int i3 = i;
            final int i4 = i2;
            final boolean z2 = z;
            C18966 r0 = new NamedRunnable("OkHttp %s Push Data[%s]", new Object[]{this.f5537e, Integer.valueOf(i)}) {
                /* renamed from: a */
                public void mo13684a() {
                    try {
                        boolean a = Http2Connection.this.f5541i.mo13852a(i3, cVar, i4, z2);
                        if (a) {
                            Http2Connection.this.f5548p.mo13834a(i3, ErrorCode.CANCEL);
                        }
                        if (a || z2) {
                            synchronized (Http2Connection.this) {
                                Http2Connection.this.f5550r.remove(Integer.valueOf(i3));
                            }
                        }
                    } catch (IOException unused) {
                    }
                }
            };
            executorService.execute(r0);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(cVar.mo13530b());
        sb.append(" != ");
        sb.append(i2);
        throw new IOException(sb.toString());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo13789c(int i, ErrorCode bVar) {
        ExecutorService executorService = this.f5551t;
        final int i2 = i;
        final ErrorCode bVar2 = bVar;
        C18977 r1 = new NamedRunnable("OkHttp %s Push Reset[%s]", new Object[]{this.f5537e, Integer.valueOf(i)}) {
            /* renamed from: a */
            public void mo13684a() {
                Http2Connection.this.f5541i.mo13851a(i2, bVar2);
                synchronized (Http2Connection.this) {
                    Http2Connection.this.f5550r.remove(Integer.valueOf(i2));
                }
            }
        };
        executorService.execute(r1);
    }
}
