package okhttp3.internal.http2;

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
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.C8402b;
import okhttp3.internal.C8417c;
import okio.ByteString;
import okio.C8525c;
import okio.C8528d;
import okio.C8529e;

/* compiled from: Http2Connection */
/* renamed from: okhttp3.internal.http2.e */
public final class C8460e implements Closeable {
    /* renamed from: r */
    static final /* synthetic */ boolean f28703r = (!C8460e.class.desiredAssertionStatus());
    /* access modifiers changed from: private|static|final */
    /* renamed from: s */
    public static final ExecutorService f28704s;
    /* renamed from: a */
    final boolean f28705a;
    /* renamed from: b */
    final C8468b f28706b;
    /* renamed from: c */
    final Map<Integer, C8478g> f28707c = new LinkedHashMap();
    /* renamed from: d */
    final String f28708d;
    /* renamed from: e */
    int f28709e;
    /* renamed from: f */
    int f28710f;
    /* renamed from: g */
    boolean f28711g;
    /* renamed from: h */
    final C8485j f28712h;
    /* renamed from: i */
    long f28713i = 0;
    /* renamed from: j */
    long f28714j;
    /* renamed from: k */
    C8487k f28715k = new C8487k();
    /* renamed from: l */
    final C8487k f28716l = new C8487k();
    /* renamed from: m */
    boolean f28717m = false;
    /* renamed from: n */
    final Socket f28718n;
    /* renamed from: o */
    final C8482h f28719o;
    /* renamed from: p */
    final C8471d f28720p;
    /* renamed from: q */
    final Set<Integer> f28721q = new LinkedHashSet();
    /* access modifiers changed from: private|final */
    /* renamed from: t */
    public final ScheduledExecutorService f28722t;
    /* renamed from: u */
    private final ExecutorService f28723u;
    /* access modifiers changed from: private */
    /* renamed from: v */
    public boolean f28724v;

    /* compiled from: Http2Connection */
    /* renamed from: okhttp3.internal.http2.e$a */
    public static class C8467a {
        /* renamed from: a */
        Socket f28746a;
        /* renamed from: b */
        String f28747b;
        /* renamed from: c */
        C8529e f28748c;
        /* renamed from: d */
        C8528d f28749d;
        /* renamed from: e */
        C8468b f28750e = C8468b.f28754f;
        /* renamed from: f */
        C8485j f28751f = C8485j.f28817a;
        /* renamed from: g */
        boolean f28752g;
        /* renamed from: h */
        int f28753h;

        public C8467a(boolean z) {
            this.f28752g = z;
        }

        /* renamed from: a */
        public C8467a mo40388a(Socket socket, String str, C8529e eVar, C8528d dVar) {
            this.f28746a = socket;
            this.f28747b = str;
            this.f28748c = eVar;
            this.f28749d = dVar;
            return this;
        }

        /* renamed from: a */
        public C8467a mo40389a(C8468b bVar) {
            this.f28750e = bVar;
            return this;
        }

        /* renamed from: a */
        public C8467a mo40387a(int i) {
            this.f28753h = i;
            return this;
        }

        /* renamed from: a */
        public C8460e mo40390a() {
            return new C8460e(this);
        }
    }

    /* compiled from: Http2Connection */
    /* renamed from: okhttp3.internal.http2.e$b */
    public static abstract class C8468b {
        /* renamed from: f */
        public static final C8468b f28754f = new C8468b() {
            /* renamed from: a */
            public void mo40281a(C8478g gVar) throws IOException {
                gVar.mo40407a(ErrorCode.REFUSED_STREAM);
            }
        };

        /* renamed from: a */
        public void mo40280a(C8460e eVar) {
        }

        /* renamed from: a */
        public abstract void mo40281a(C8478g gVar) throws IOException;
    }

    /* compiled from: Http2Connection */
    /* renamed from: okhttp3.internal.http2.e$c */
    final class C8470c extends C8402b {
        /* renamed from: a */
        final boolean f28755a;
        /* renamed from: c */
        final int f28756c;
        /* renamed from: d */
        final int f28757d;

        C8470c(boolean z, int i, int i2) {
            super("OkHttp %s ping %08x%08x", C8460e.this.f28708d, Integer.valueOf(i), Integer.valueOf(i2));
            this.f28755a = z;
            this.f28756c = i;
            this.f28757d = i2;
        }

        /* renamed from: c */
        public void mo40233c() {
            C8460e.this.mo40378a(this.f28755a, this.f28756c, this.f28757d);
        }
    }

    /* compiled from: Http2Connection */
    /* renamed from: okhttp3.internal.http2.e$d */
    class C8471d extends C8402b implements C8477b {
        /* renamed from: a */
        final C8475f f28759a;

        /* renamed from: a */
        public void mo40391a() {
        }

        /* renamed from: a */
        public void mo40392a(int i, int i2, int i3, boolean z) {
        }

        C8471d(C8475f fVar) {
            super("OkHttp %s", C8460e.this.f28708d);
            this.f28759a = fVar;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            r0 = okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR;
            r1 = okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            r2 = r4.f28760c;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            r4.f28760c.mo40376a(r0, r1);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0030, code lost:
            okhttp3.internal.C8417c.m36040a((java.io.Closeable) r4.f28759a);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0035, code lost:
            throw r2;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
            r2 = move-exception;
     */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x001c */
        /* renamed from: c */
        public void mo40233c() {
            /*
            r4 = this;
            okhttp3.internal.http2.ErrorCode r0 = okhttp3.internal.http2.ErrorCode.INTERNAL_ERROR
            okhttp3.internal.http2.ErrorCode r1 = okhttp3.internal.http2.ErrorCode.INTERNAL_ERROR
            okhttp3.internal.http2.f r2 = r4.f28759a     // Catch:{ IOException -> 0x001c }
            r2.mo40401a(r4)     // Catch:{ IOException -> 0x001c }
        L_0x0009:
            okhttp3.internal.http2.f r2 = r4.f28759a     // Catch:{ IOException -> 0x001c }
            r3 = 0
            boolean r2 = r2.mo40402a(r3, r4)     // Catch:{ IOException -> 0x001c }
            if (r2 == 0) goto L_0x0013
            goto L_0x0009
        L_0x0013:
            okhttp3.internal.http2.ErrorCode r0 = okhttp3.internal.http2.ErrorCode.NO_ERROR     // Catch:{ IOException -> 0x001c }
            okhttp3.internal.http2.ErrorCode r1 = okhttp3.internal.http2.ErrorCode.CANCEL     // Catch:{ IOException -> 0x001c }
            okhttp3.internal.http2.e r2 = okhttp3.internal.http2.C8460e.this     // Catch:{ IOException -> 0x0025 }
            goto L_0x0022
        L_0x001a:
            r2 = move-exception
            goto L_0x002b
        L_0x001c:
            okhttp3.internal.http2.ErrorCode r0 = okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR     // Catch:{ all -> 0x001a }
            okhttp3.internal.http2.ErrorCode r1 = okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR     // Catch:{ all -> 0x001a }
            okhttp3.internal.http2.e r2 = okhttp3.internal.http2.C8460e.this     // Catch:{ IOException -> 0x0025 }
        L_0x0022:
            r2.mo40376a(r0, r1)     // Catch:{ IOException -> 0x0025 }
        L_0x0025:
            okhttp3.internal.http2.f r0 = r4.f28759a
            okhttp3.internal.C8417c.m36040a(r0)
            return
        L_0x002b:
            okhttp3.internal.http2.e r3 = okhttp3.internal.http2.C8460e.this     // Catch:{ IOException -> 0x0030 }
            r3.mo40376a(r0, r1)     // Catch:{ IOException -> 0x0030 }
        L_0x0030:
            okhttp3.internal.http2.f r0 = r4.f28759a
            okhttp3.internal.C8417c.m36040a(r0)
            throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.C8460e.C8471d.mo40233c():void");
        }

        /* renamed from: a */
        public void mo40399a(boolean z, int i, C8529e eVar, int i2) throws IOException {
            if (C8460e.this.mo40384c(i)) {
                C8460e.this.mo40372a(i, eVar, i2, z);
                return;
            }
            C8478g a = C8460e.this.mo40366a(i);
            if (a == null) {
                C8460e.this.mo40371a(i, ErrorCode.PROTOCOL_ERROR);
                long j = (long) i2;
                C8460e.this.mo40374a(j);
                eVar.mo40761h(j);
                return;
            }
            a.mo40408a(eVar, i2);
            if (z) {
                a.mo40418i();
            }
        }

        /* JADX INFO: used method not loaded: okhttp3.internal.http2.g.a(java.util.List):null, types can be incorrect */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0071, code lost:
            r0.mo40406a((java.util.List) r13);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0074, code lost:
            if (r10 == false) goto L_0x0079;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0076, code lost:
            r0.mo40418i();
     */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0079, code lost:
            return;
     */
        /* renamed from: a */
        public void mo40398a(boolean r10, int r11, int r12, java.util.List<okhttp3.internal.http2.C8453a> r13) {
            /*
            r9 = this;
            okhttp3.internal.http2.e r12 = okhttp3.internal.http2.C8460e.this
            boolean r12 = r12.mo40384c(r11)
            if (r12 == 0) goto L_0x000e
            okhttp3.internal.http2.e r12 = okhttp3.internal.http2.C8460e.this
            r12.mo40370a(r11, r13, r10)
            return
        L_0x000e:
            okhttp3.internal.http2.e r12 = okhttp3.internal.http2.C8460e.this
            monitor-enter(r12)
            okhttp3.internal.http2.e r0 = okhttp3.internal.http2.C8460e.this     // Catch:{ all -> 0x007a }
            okhttp3.internal.http2.g r0 = r0.mo40366a(r11)     // Catch:{ all -> 0x007a }
            if (r0 != 0) goto L_0x0070
            okhttp3.internal.http2.e r0 = okhttp3.internal.http2.C8460e.this     // Catch:{ all -> 0x007a }
            boolean r0 = r0.f28711g     // Catch:{ all -> 0x007a }
            if (r0 == 0) goto L_0x0021
            monitor-exit(r12)     // Catch:{ all -> 0x007a }
            return
        L_0x0021:
            okhttp3.internal.http2.e r0 = okhttp3.internal.http2.C8460e.this     // Catch:{ all -> 0x007a }
            int r0 = r0.f28709e     // Catch:{ all -> 0x007a }
            if (r11 > r0) goto L_0x0029
            monitor-exit(r12)     // Catch:{ all -> 0x007a }
            return
        L_0x0029:
            int r0 = r11 % 2
            okhttp3.internal.http2.e r1 = okhttp3.internal.http2.C8460e.this     // Catch:{ all -> 0x007a }
            int r1 = r1.f28710f     // Catch:{ all -> 0x007a }
            r2 = 2
            int r1 = r1 % r2
            if (r0 != r1) goto L_0x0035
            monitor-exit(r12)     // Catch:{ all -> 0x007a }
            return
        L_0x0035:
            okhttp3.internal.http2.g r0 = new okhttp3.internal.http2.g     // Catch:{ all -> 0x007a }
            okhttp3.internal.http2.e r5 = okhttp3.internal.http2.C8460e.this     // Catch:{ all -> 0x007a }
            r6 = 0
            r3 = r0
            r4 = r11
            r7 = r10
            r8 = r13
            r3.m55489init(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x007a }
            okhttp3.internal.http2.e r10 = okhttp3.internal.http2.C8460e.this     // Catch:{ all -> 0x007a }
            r10.f28709e = r11     // Catch:{ all -> 0x007a }
            okhttp3.internal.http2.e r10 = okhttp3.internal.http2.C8460e.this     // Catch:{ all -> 0x007a }
            java.util.Map<java.lang.Integer, okhttp3.internal.http2.g> r10 = r10.f28707c     // Catch:{ all -> 0x007a }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x007a }
            r10.put(r13, r0)     // Catch:{ all -> 0x007a }
            java.util.concurrent.ExecutorService r10 = okhttp3.internal.http2.C8460e.f28704s     // Catch:{ all -> 0x007a }
            okhttp3.internal.http2.e$d$1 r13 = new okhttp3.internal.http2.e$d$1     // Catch:{ all -> 0x007a }
            java.lang.String r1 = "OkHttp %s stream %d"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x007a }
            r3 = 0
            okhttp3.internal.http2.e r4 = okhttp3.internal.http2.C8460e.this     // Catch:{ all -> 0x007a }
            java.lang.String r4 = r4.f28708d     // Catch:{ all -> 0x007a }
            r2[r3] = r4     // Catch:{ all -> 0x007a }
            r3 = 1
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x007a }
            r2[r3] = r11     // Catch:{ all -> 0x007a }
            r13.m55482init(r1, r2, r0)     // Catch:{ all -> 0x007a }
            r10.execute(r13)     // Catch:{ all -> 0x007a }
            monitor-exit(r12)     // Catch:{ all -> 0x007a }
            return
        L_0x0070:
            monitor-exit(r12)     // Catch:{ all -> 0x007a }
            r0.mo40406a(r13)
            if (r10 == 0) goto L_0x0079
            r0.mo40418i()
        L_0x0079:
            return
        L_0x007a:
            r10 = move-exception
            monitor-exit(r12)     // Catch:{ all -> 0x007a }
            throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.C8460e.C8471d.mo40398a(boolean, int, int, java.util.List):void");
        }

        /* renamed from: a */
        public void mo40395a(int i, ErrorCode errorCode) {
            if (C8460e.this.mo40384c(i)) {
                C8460e.this.mo40383c(i, errorCode);
                return;
            }
            C8478g b = C8460e.this.mo40379b(i);
            if (b != null) {
                b.mo40411c(errorCode);
            }
        }

        /* renamed from: a */
        public void mo40400a(boolean z, C8487k kVar) {
            C8478g[] gVarArr;
            long j;
            int i;
            synchronized (C8460e.this) {
                int d = C8460e.this.f28716l.mo40457d();
                if (z) {
                    C8460e.this.f28716l.mo40450a();
                }
                C8460e.this.f28716l.mo40451a(kVar);
                m36309a(kVar);
                int d2 = C8460e.this.f28716l.mo40457d();
                gVarArr = null;
                if (d2 == -1 || d2 == d) {
                    j = 0;
                } else {
                    j = (long) (d2 - d);
                    if (!C8460e.this.f28717m) {
                        C8460e.this.f28717m = true;
                    }
                    if (!C8460e.this.f28707c.isEmpty()) {
                        gVarArr = (C8478g[]) C8460e.this.f28707c.values().toArray(new C8478g[C8460e.this.f28707c.size()]);
                    }
                }
                C8460e.f28704s.execute(new C8402b("OkHttp %s settings", C8460e.this.f28708d) {
                    /* renamed from: c */
                    public void mo40233c() {
                        C8460e.this.f28706b.mo40280a(C8460e.this);
                    }
                });
            }
            if (gVarArr != null && j != 0) {
                for (C8478g gVar : gVarArr) {
                    synchronized (gVar) {
                        gVar.mo40405a(j);
                    }
                }
            }
        }

        /* renamed from: a */
        private void m36309a(final C8487k kVar) {
            try {
                C8460e.this.f28722t.execute(new C8402b("OkHttp %s ACK Settings", new Object[]{C8460e.this.f28708d}) {
                    /* renamed from: c */
                    public void mo40233c() {
                        try {
                            C8460e.this.f28719o.mo40433a(kVar);
                        } catch (IOException unused) {
                            C8460e.this.m36273f();
                        }
                    }
                });
            } catch (RejectedExecutionException unused) {
            }
        }

        /* renamed from: a */
        public void mo40397a(boolean z, int i, int i2) {
            if (z) {
                synchronized (C8460e.this) {
                    C8460e.this.f28724v = false;
                    C8460e.this.notifyAll();
                }
                return;
            }
            try {
                C8460e.this.f28722t.execute(new C8470c(true, i, i2));
            } catch (RejectedExecutionException unused) {
            }
        }

        /* renamed from: a */
        public void mo40396a(int i, ErrorCode errorCode, ByteString byteString) {
            C8478g[] gVarArr;
            byteString.size();
            synchronized (C8460e.this) {
                gVarArr = (C8478g[]) C8460e.this.f28707c.values().toArray(new C8478g[C8460e.this.f28707c.size()]);
                C8460e.this.f28711g = true;
            }
            int length = gVarArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                C8478g gVar = gVarArr[i2];
                if (gVar.mo40404a() > i && gVar.mo40412c()) {
                    gVar.mo40411c(ErrorCode.REFUSED_STREAM);
                    C8460e.this.mo40379b(gVar.mo40404a());
                }
            }
        }

        /* renamed from: a */
        public void mo40394a(int i, long j) {
            if (i == 0) {
                synchronized (C8460e.this) {
                    C8460e.this.f28714j += j;
                    C8460e.this.notifyAll();
                }
                return;
            }
            C8478g a = C8460e.this.mo40366a(i);
            if (a != null) {
                synchronized (a) {
                    a.mo40405a(j);
                }
            }
        }

        /* renamed from: a */
        public void mo40393a(int i, int i2, List<C8453a> list) {
            C8460e.this.mo40369a(i2, list);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public boolean mo40384c(int i) {
        return i != 0 && (i & 1) == 0;
    }

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 60, TimeUnit.SECONDS, new SynchronousQueue(), C8417c.m36037a("OkHttp Http2Connection", true));
        f28704s = threadPoolExecutor;
    }

    C8460e(C8467a aVar) {
        C8467a aVar2 = aVar;
        this.f28712h = aVar2.f28751f;
        this.f28705a = aVar2.f28752g;
        this.f28706b = aVar2.f28750e;
        this.f28710f = aVar2.f28752g ? 1 : 2;
        if (aVar2.f28752g) {
            this.f28710f += 2;
        }
        if (aVar2.f28752g) {
            this.f28715k.mo40449a(7, 16777216);
        }
        this.f28708d = aVar2.f28747b;
        this.f28722t = new ScheduledThreadPoolExecutor(1, C8417c.m36037a(C8417c.m36030a("OkHttp %s Writer", this.f28708d), false));
        if (aVar2.f28753h != 0) {
            this.f28722t.scheduleAtFixedRate(new C8470c(false, 0, 0), (long) aVar2.f28753h, (long) aVar2.f28753h, TimeUnit.MILLISECONDS);
        }
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), C8417c.m36037a(C8417c.m36030a("OkHttp %s Push Observer", this.f28708d), true));
        this.f28723u = threadPoolExecutor;
        this.f28716l.mo40449a(7, 65535);
        this.f28716l.mo40449a(5, 16384);
        this.f28714j = (long) this.f28716l.mo40457d();
        this.f28718n = aVar2.f28746a;
        this.f28719o = new C8482h(aVar2.f28749d, this.f28705a);
        this.f28720p = new C8471d(new C8475f(aVar2.f28748c, this.f28705a));
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: a */
    public synchronized C8478g mo40366a(int i) {
        return (C8478g) this.f28707c.get(Integer.valueOf(i));
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: b */
    public synchronized C8478g mo40379b(int i) {
        C8478g gVar;
        gVar = (C8478g) this.f28707c.remove(Integer.valueOf(i));
        notifyAll();
        return gVar;
    }

    /* renamed from: a */
    public synchronized int mo40365a() {
        return this.f28716l.mo40456c(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: a */
    public synchronized void mo40374a(long j) {
        this.f28713i += j;
        if (this.f28713i >= ((long) (this.f28715k.mo40457d() / 2))) {
            mo40368a(0, this.f28713i);
            this.f28713i = 0;
        }
    }

    /* renamed from: a */
    public C8478g mo40367a(List<C8453a> list, boolean z) throws IOException {
        return m36271b(0, list, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0043  */
    /* renamed from: b */
    private okhttp3.internal.http2.C8478g m36271b(int r11, java.util.List<okhttp3.internal.http2.C8453a> r12, boolean r13) throws java.io.IOException {
        /*
        r10 = this;
        r6 = r13 ^ 1
        r4 = 0
        okhttp3.internal.http2.h r7 = r10.f28719o
        monitor-enter(r7)
        monitor-enter(r10)     // Catch:{ all -> 0x0078 }
        int r0 = r10.f28710f     // Catch:{ all -> 0x0075 }
        r1 = 1073741823(0x3fffffff, float:1.9999999)
        if (r0 <= r1) goto L_0x0013
        okhttp3.internal.http2.ErrorCode r0 = okhttp3.internal.http2.ErrorCode.REFUSED_STREAM     // Catch:{ all -> 0x0075 }
        r10.mo40375a(r0)     // Catch:{ all -> 0x0075 }
    L_0x0013:
        boolean r0 = r10.f28711g     // Catch:{ all -> 0x0075 }
        if (r0 != 0) goto L_0x006f
        int r8 = r10.f28710f     // Catch:{ all -> 0x0075 }
        int r0 = r10.f28710f     // Catch:{ all -> 0x0075 }
        int r0 = r0 + 2
        r10.f28710f = r0     // Catch:{ all -> 0x0075 }
        okhttp3.internal.http2.g r9 = new okhttp3.internal.http2.g     // Catch:{ all -> 0x0075 }
        r0 = r9
        r1 = r8
        r2 = r10
        r3 = r6
        r5 = r12
        r0.m55489init(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x0075 }
        if (r13 == 0) goto L_0x003c
        long r0 = r10.f28714j     // Catch:{ all -> 0x0075 }
        r2 = 0
        int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
        if (r13 == 0) goto L_0x003c
        long r0 = r9.f28779b     // Catch:{ all -> 0x0075 }
        int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
        if (r13 != 0) goto L_0x003a
        goto L_0x003c
    L_0x003a:
        r13 = 0
        goto L_0x003d
    L_0x003c:
        r13 = 1
    L_0x003d:
        boolean r0 = r9.mo40410b()     // Catch:{ all -> 0x0075 }
        if (r0 == 0) goto L_0x004c
        java.util.Map<java.lang.Integer, okhttp3.internal.http2.g> r0 = r10.f28707c     // Catch:{ all -> 0x0075 }
        java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0075 }
        r0.put(r1, r9)     // Catch:{ all -> 0x0075 }
    L_0x004c:
        monitor-exit(r10)     // Catch:{ all -> 0x0075 }
        if (r11 != 0) goto L_0x0055
        okhttp3.internal.http2.h r0 = r10.f28719o     // Catch:{ all -> 0x0078 }
        r0.mo40435a(r6, r8, r11, r12)     // Catch:{ all -> 0x0078 }
        goto L_0x005e
    L_0x0055:
        boolean r0 = r10.f28705a     // Catch:{ all -> 0x0078 }
        if (r0 != 0) goto L_0x0067
        okhttp3.internal.http2.h r0 = r10.f28719o     // Catch:{ all -> 0x0078 }
        r0.mo40429a(r11, r8, r12)     // Catch:{ all -> 0x0078 }
    L_0x005e:
        monitor-exit(r7)     // Catch:{ all -> 0x0078 }
        if (r13 == 0) goto L_0x0066
        okhttp3.internal.http2.h r11 = r10.f28719o
        r11.mo40438b()
    L_0x0066:
        return r9
    L_0x0067:
        java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0078 }
        java.lang.String r12 = "client streams shouldn't have associated stream IDs"
        r11.<init>(r12)     // Catch:{ all -> 0x0078 }
        throw r11     // Catch:{ all -> 0x0078 }
    L_0x006f:
        okhttp3.internal.http2.ConnectionShutdownException r11 = new okhttp3.internal.http2.ConnectionShutdownException     // Catch:{ all -> 0x0075 }
        r11.m55450init()     // Catch:{ all -> 0x0075 }
        throw r11     // Catch:{ all -> 0x0075 }
    L_0x0075:
        r11 = move-exception
        monitor-exit(r10)     // Catch:{ all -> 0x0075 }
        throw r11     // Catch:{ all -> 0x0078 }
    L_0x0078:
        r11 = move-exception
        monitor-exit(r7)     // Catch:{ all -> 0x0078 }
        throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.C8460e.m36271b(int, java.util.List, boolean):okhttp3.internal.http2.g");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:26|27|28) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            r3 = java.lang.Math.min((int) java.lang.Math.min(r12, r8.f28714j), r8.f28719o.mo40440c());
            r6 = (long) r3;
            r8.f28714j -= r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0066, code lost:
            throw new java.io.InterruptedIOException();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x005a */
    /* renamed from: a */
    public void mo40373a(int r9, boolean r10, okio.C8525c r11, long r12) throws java.io.IOException {
        /*
        r8 = this;
        r0 = 0
        r1 = 0
        int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
        if (r3 != 0) goto L_0x000d
        okhttp3.internal.http2.h r12 = r8.f28719o
        r12.mo40437a(r10, r9, r11, r0)
        return
    L_0x000d:
        int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
        if (r3 <= 0) goto L_0x0069
        monitor-enter(r8)
    L_0x0012:
        long r3 = r8.f28714j     // Catch:{ InterruptedException -> 0x005a }
        int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
        if (r5 > 0) goto L_0x0030
        java.util.Map<java.lang.Integer, okhttp3.internal.http2.g> r3 = r8.f28707c     // Catch:{ InterruptedException -> 0x005a }
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
        long r3 = r8.f28714j     // Catch:{ all -> 0x0058 }
        long r3 = java.lang.Math.min(r12, r3)     // Catch:{ all -> 0x0058 }
        int r4 = (int) r3     // Catch:{ all -> 0x0058 }
        okhttp3.internal.http2.h r3 = r8.f28719o     // Catch:{ all -> 0x0058 }
        int r3 = r3.mo40440c()     // Catch:{ all -> 0x0058 }
        int r3 = java.lang.Math.min(r4, r3)     // Catch:{ all -> 0x0058 }
        long r4 = r8.f28714j     // Catch:{ all -> 0x0058 }
        long r6 = (long) r3     // Catch:{ all -> 0x0058 }
        long r4 = r4 - r6
        r8.f28714j = r4     // Catch:{ all -> 0x0058 }
        monitor-exit(r8)     // Catch:{ all -> 0x0058 }
        long r12 = r12 - r6
        okhttp3.internal.http2.h r4 = r8.f28719o
        if (r10 == 0) goto L_0x0053
        int r5 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
        if (r5 != 0) goto L_0x0053
        r5 = 1
        goto L_0x0054
    L_0x0053:
        r5 = 0
    L_0x0054:
        r4.mo40437a(r5, r9, r11, r3)
        goto L_0x000d
    L_0x0058:
        r9 = move-exception
        goto L_0x0067
    L_0x005a:
        java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0058 }
        r9.interrupt()     // Catch:{ all -> 0x0058 }
        java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch:{ all -> 0x0058 }
        r9.<init>()     // Catch:{ all -> 0x0058 }
        throw r9     // Catch:{ all -> 0x0058 }
    L_0x0067:
        monitor-exit(r8)     // Catch:{ all -> 0x0058 }
        throw r9
    L_0x0069:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.C8460e.mo40373a(int, boolean, okio.c, long):void");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo40371a(int i, ErrorCode errorCode) {
        try {
            ScheduledExecutorService scheduledExecutorService = this.f28722t;
            final int i2 = i;
            final ErrorCode errorCode2 = errorCode;
            C84611 r1 = new C8402b("OkHttp %s stream %d", new Object[]{this.f28708d, Integer.valueOf(i)}) {
                /* renamed from: c */
                public void mo40233c() {
                    try {
                        C8460e.this.mo40381b(i2, errorCode2);
                    } catch (IOException unused) {
                        C8460e.this.m36273f();
                    }
                }
            };
            scheduledExecutorService.execute(r1);
        } catch (RejectedExecutionException unused) {
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo40381b(int i, ErrorCode errorCode) throws IOException {
        this.f28719o.mo40431a(i, errorCode);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo40368a(int i, long j) {
        try {
            ScheduledExecutorService scheduledExecutorService = this.f28722t;
            final int i2 = i;
            final long j2 = j;
            C84622 r1 = new C8402b("OkHttp Window Update %s stream %d", new Object[]{this.f28708d, Integer.valueOf(i)}) {
                /* renamed from: c */
                public void mo40233c() {
                    try {
                        C8460e.this.f28719o.mo40430a(i2, j2);
                    } catch (IOException unused) {
                        C8460e.this.m36273f();
                    }
                }
            };
            scheduledExecutorService.execute(r1);
        } catch (RejectedExecutionException unused) {
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo40378a(boolean z, int i, int i2) {
        boolean z2;
        if (!z) {
            synchronized (this) {
                z2 = this.f28724v;
                this.f28724v = true;
            }
            if (z2) {
                m36273f();
                return;
            }
        }
        try {
            this.f28719o.mo40434a(z, i, i2);
        } catch (IOException unused) {
            m36273f();
        }
    }

    /* renamed from: b */
    public void mo40380b() throws IOException {
        this.f28719o.mo40438b();
    }

    /* renamed from: a */
    public void mo40375a(ErrorCode errorCode) throws IOException {
        synchronized (this.f28719o) {
            synchronized (this) {
                if (!this.f28711g) {
                    this.f28711g = true;
                    int i = this.f28709e;
                    this.f28719o.mo40432a(i, errorCode, C8417c.f28528a);
                }
            }
        }
    }

    public void close() throws IOException {
        mo40376a(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo40376a(ErrorCode errorCode, ErrorCode errorCode2) throws IOException {
        IOException e;
        if (f28703r || !Thread.holdsLock(this)) {
            C8478g[] gVarArr = null;
            try {
                mo40375a(errorCode);
                e = null;
            } catch (IOException e2) {
                e = e2;
            }
            synchronized (this) {
                if (!this.f28707c.isEmpty()) {
                    gVarArr = (C8478g[]) this.f28707c.values().toArray(new C8478g[this.f28707c.size()]);
                    this.f28707c.clear();
                }
            }
            if (gVarArr != null) {
                for (C8478g a : gVarArr) {
                    try {
                        a.mo40407a(errorCode2);
                    } catch (IOException e3) {
                        if (e != null) {
                            e = e3;
                        }
                    }
                }
            }
            try {
                this.f28719o.close();
            } catch (IOException e4) {
                if (e == null) {
                    e = e4;
                }
            }
            try {
                this.f28718n.close();
            } catch (IOException e5) {
                e = e5;
            }
            this.f28722t.shutdown();
            this.f28723u.shutdown();
            if (e != null) {
                throw e;
            }
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m36273f() {
        try {
            mo40376a(ErrorCode.PROTOCOL_ERROR, ErrorCode.PROTOCOL_ERROR);
        } catch (IOException unused) {
        }
    }

    /* renamed from: c */
    public void mo40382c() throws IOException {
        mo40377a(true);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo40377a(boolean z) throws IOException {
        if (z) {
            this.f28719o.mo40426a();
            this.f28719o.mo40439b(this.f28715k);
            int d = this.f28715k.mo40457d();
            if (d != 65535) {
                this.f28719o.mo40430a(0, (long) (d - 65535));
            }
        }
        new Thread(this.f28720p).start();
    }

    /* renamed from: d */
    public synchronized boolean mo40386d() {
        return this.f28711g;
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
            r3 = r8;
            r6 = r9;
            r7 = r10;
            r2 = new okhttp3.internal.http2.C8460e.C84633(r3, "OkHttp %s Push Request[%s]", new java.lang.Object[]{r8.f28708d, java.lang.Integer.valueOf(r9)});
            m36267a((okhttp3.internal.C8402b) r2);
     */
    /* renamed from: a */
    public void mo40369a(int r9, java.util.List<okhttp3.internal.http2.C8453a> r10) {
        /*
        r8 = this;
        monitor-enter(r8)
        java.util.Set<java.lang.Integer> r0 = r8.f28721q     // Catch:{ all -> 0x003c }
        java.lang.Integer r1 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x003c }
        boolean r0 = r0.contains(r1)     // Catch:{ all -> 0x003c }
        if (r0 == 0) goto L_0x0014
        okhttp3.internal.http2.ErrorCode r10 = okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR     // Catch:{ all -> 0x003c }
        r8.mo40371a(r9, r10)     // Catch:{ all -> 0x003c }
        monitor-exit(r8)     // Catch:{ all -> 0x003c }
        return
    L_0x0014:
        java.util.Set<java.lang.Integer> r0 = r8.f28721q     // Catch:{ all -> 0x003c }
        java.lang.Integer r1 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x003c }
        r0.add(r1)     // Catch:{ all -> 0x003c }
        monitor-exit(r8)     // Catch:{ all -> 0x003c }
        okhttp3.internal.http2.e$3 r0 = new okhttp3.internal.http2.e$3     // Catch:{ RejectedExecutionException -> 0x003b }
        java.lang.String r4 = "OkHttp %s Push Request[%s]"
        r1 = 2
        java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ RejectedExecutionException -> 0x003b }
        r1 = 0
        java.lang.String r2 = r8.f28708d     // Catch:{ RejectedExecutionException -> 0x003b }
        r5[r1] = r2     // Catch:{ RejectedExecutionException -> 0x003b }
        r1 = 1
        java.lang.Integer r2 = java.lang.Integer.valueOf(r9)     // Catch:{ RejectedExecutionException -> 0x003b }
        r5[r1] = r2     // Catch:{ RejectedExecutionException -> 0x003b }
        r2 = r0
        r3 = r8
        r6 = r9
        r7 = r10
        r2.m55472init(r4, r5, r6, r7)     // Catch:{ RejectedExecutionException -> 0x003b }
        r8.m36267a(r0)     // Catch:{ RejectedExecutionException -> 0x003b }
    L_0x003b:
        return
    L_0x003c:
        r9 = move-exception
        monitor-exit(r8)     // Catch:{ all -> 0x003c }
        throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.C8460e.mo40369a(int, java.util.List):void");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo40370a(int i, List<C8453a> list, boolean z) {
        try {
            final int i2 = i;
            final List<C8453a> list2 = list;
            final boolean z2 = z;
            C84644 r0 = new C8402b("OkHttp %s Push Headers[%s]", new Object[]{this.f28708d, Integer.valueOf(i)}) {
                /* renamed from: c */
                public void mo40233c() {
                    boolean a = C8460e.this.f28712h.mo40447a(i2, list2, z2);
                    if (a) {
                        try {
                            C8460e.this.f28719o.mo40431a(i2, ErrorCode.CANCEL);
                        } catch (IOException unused) {
                            return;
                        }
                    }
                    if (a || z2) {
                        synchronized (C8460e.this) {
                            C8460e.this.f28721q.remove(Integer.valueOf(i2));
                        }
                    }
                }
            };
            m36267a((C8402b) r0);
        } catch (RejectedExecutionException unused) {
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo40372a(int i, C8529e eVar, int i2, boolean z) throws IOException {
        final C8525c cVar = new C8525c();
        long j = (long) i2;
        eVar.mo40729a(j);
        eVar.mo40202a(cVar, j);
        if (cVar.mo40734b() == j) {
            final int i3 = i;
            final int i4 = i2;
            final boolean z2 = z;
            C84655 r0 = new C8402b("OkHttp %s Push Data[%s]", new Object[]{this.f28708d, Integer.valueOf(i)}) {
                /* renamed from: c */
                public void mo40233c() {
                    try {
                        boolean a = C8460e.this.f28712h.mo40448a(i3, cVar, i4, z2);
                        if (a) {
                            C8460e.this.f28719o.mo40431a(i3, ErrorCode.CANCEL);
                        }
                        if (a || z2) {
                            synchronized (C8460e.this) {
                                C8460e.this.f28721q.remove(Integer.valueOf(i3));
                            }
                        }
                    } catch (IOException unused) {
                    }
                }
            };
            m36267a((C8402b) r0);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(cVar.mo40734b());
        sb.append(" != ");
        sb.append(i2);
        throw new IOException(sb.toString());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo40383c(int i, ErrorCode errorCode) {
        final int i2 = i;
        final ErrorCode errorCode2 = errorCode;
        C84666 r0 = new C8402b("OkHttp %s Push Reset[%s]", new Object[]{this.f28708d, Integer.valueOf(i)}) {
            /* renamed from: c */
            public void mo40233c() {
                C8460e.this.f28712h.mo40445a(i2, errorCode2);
                synchronized (C8460e.this) {
                    C8460e.this.f28721q.remove(Integer.valueOf(i2));
                }
            }
        };
        m36267a((C8402b) r0);
    }

    /* renamed from: a */
    private synchronized void m36267a(C8402b bVar) {
        if (!mo40386d()) {
            this.f28723u.execute(bVar);
        }
    }
}
