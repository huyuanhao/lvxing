package com.bumptech.glide.load.engine;

import android.os.Build.VERSION;
import android.util.Log;
import androidx.core.util.Pools.Pool;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DataFetcherGenerator.C1668a;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.p135a.DataFetcher;
import com.bumptech.glide.load.p135a.DataRewinder;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.p140a.FactoryPools.C1766c;
import com.bumptech.glide.util.p140a.GlideTrace;
import com.bumptech.glide.util.p140a.StateVerifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.bumptech.glide.load.engine.h */
class DecodeJob<R> implements C1668a, C1766c, Comparable<DecodeJob<?>>, Runnable {
    /* renamed from: A */
    private DataSource f4580A;
    /* renamed from: B */
    private DataFetcher<?> f4581B;
    /* renamed from: C */
    private volatile DataFetcherGenerator f4582C;
    /* renamed from: D */
    private volatile boolean f4583D;
    /* renamed from: E */
    private volatile boolean f4584E;
    /* renamed from: a */
    private final DecodeHelper<R> f4585a = new DecodeHelper<>();
    /* renamed from: b */
    private final List<Throwable> f4586b = new ArrayList();
    /* renamed from: c */
    private final StateVerifier f4587c = StateVerifier.m6111a();
    /* renamed from: d */
    private final C1673d f4588d;
    /* renamed from: e */
    private final Pool<DecodeJob<?>> f4589e;
    /* renamed from: f */
    private final C1672c<?> f4590f = new C1672c<>();
    /* renamed from: g */
    private final C1674e f4591g = new C1674e();
    /* renamed from: h */
    private GlideContext f4592h;
    /* renamed from: i */
    private Key f4593i;
    /* renamed from: j */
    private Priority f4594j;
    /* renamed from: k */
    private EngineKey f4595k;
    /* renamed from: l */
    private int f4596l;
    /* renamed from: m */
    private int f4597m;
    /* renamed from: n */
    private DiskCacheStrategy f4598n;
    /* renamed from: o */
    private Options f4599o;
    /* renamed from: p */
    private C1670a<R> f4600p;
    /* renamed from: q */
    private int f4601q;
    /* renamed from: r */
    private C1676g f4602r;
    /* renamed from: s */
    private C1675f f4603s;
    /* renamed from: t */
    private long f4604t;
    /* renamed from: u */
    private boolean f4605u;
    /* renamed from: v */
    private Object f4606v;
    /* renamed from: w */
    private Thread f4607w;
    /* renamed from: x */
    private Key f4608x;
    /* renamed from: y */
    private Key f4609y;
    /* renamed from: z */
    private Object f4610z;

    /* compiled from: DecodeJob */
    /* renamed from: com.bumptech.glide.load.engine.h$1 */
    static /* synthetic */ class C16691 {
        /* renamed from: a */
        static final /* synthetic */ int[] f4611a = new int[C1675f.values().length];
        /* renamed from: b */
        static final /* synthetic */ int[] f4612b = new int[C1676g.values().length];
        /* renamed from: c */
        static final /* synthetic */ int[] f4613c = new int[EncodeStrategy.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(25:0|1|2|3|(2:5|6)|7|9|10|11|12|13|15|16|17|18|19|20|21|23|24|25|26|27|28|30) */
        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|5|6|7|9|10|11|12|13|15|16|17|18|19|20|21|23|24|25|26|27|28|30) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0032 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0047 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0052 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0070 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x007a */
        static {
            /*
            com.bumptech.glide.load.EncodeStrategy[] r0 = com.bumptech.glide.load.EncodeStrategy.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f4613c = r0
            r0 = 1
            int[] r1 = f4613c     // Catch:{ NoSuchFieldError -> 0x0014 }
            com.bumptech.glide.load.EncodeStrategy r2 = com.bumptech.glide.load.EncodeStrategy.SOURCE     // Catch:{ NoSuchFieldError -> 0x0014 }
            int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
            r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r1 = 2
            int[] r2 = f4613c     // Catch:{ NoSuchFieldError -> 0x001f }
            com.bumptech.glide.load.EncodeStrategy r3 = com.bumptech.glide.load.EncodeStrategy.TRANSFORMED     // Catch:{ NoSuchFieldError -> 0x001f }
            int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            com.bumptech.glide.load.engine.h$g[] r2 = com.bumptech.glide.load.engine.DecodeJob.C1676g.values()
            int r2 = r2.length
            int[] r2 = new int[r2]
            f4612b = r2
            int[] r2 = f4612b     // Catch:{ NoSuchFieldError -> 0x0032 }
            com.bumptech.glide.load.engine.h$g r3 = com.bumptech.glide.load.engine.DecodeJob.C1676g.RESOURCE_CACHE     // Catch:{ NoSuchFieldError -> 0x0032 }
            int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0032 }
            r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0032 }
        L_0x0032:
            int[] r2 = f4612b     // Catch:{ NoSuchFieldError -> 0x003c }
            com.bumptech.glide.load.engine.h$g r3 = com.bumptech.glide.load.engine.DecodeJob.C1676g.DATA_CACHE     // Catch:{ NoSuchFieldError -> 0x003c }
            int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x003c }
            r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x003c }
        L_0x003c:
            r2 = 3
            int[] r3 = f4612b     // Catch:{ NoSuchFieldError -> 0x0047 }
            com.bumptech.glide.load.engine.h$g r4 = com.bumptech.glide.load.engine.DecodeJob.C1676g.SOURCE     // Catch:{ NoSuchFieldError -> 0x0047 }
            int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0047 }
            r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0047 }
        L_0x0047:
            int[] r3 = f4612b     // Catch:{ NoSuchFieldError -> 0x0052 }
            com.bumptech.glide.load.engine.h$g r4 = com.bumptech.glide.load.engine.DecodeJob.C1676g.FINISHED     // Catch:{ NoSuchFieldError -> 0x0052 }
            int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0052 }
            r5 = 4
            r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0052 }
        L_0x0052:
            int[] r3 = f4612b     // Catch:{ NoSuchFieldError -> 0x005d }
            com.bumptech.glide.load.engine.h$g r4 = com.bumptech.glide.load.engine.DecodeJob.C1676g.INITIALIZE     // Catch:{ NoSuchFieldError -> 0x005d }
            int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x005d }
            r5 = 5
            r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x005d }
        L_0x005d:
            com.bumptech.glide.load.engine.h$f[] r3 = com.bumptech.glide.load.engine.DecodeJob.C1675f.values()
            int r3 = r3.length
            int[] r3 = new int[r3]
            f4611a = r3
            int[] r3 = f4611a     // Catch:{ NoSuchFieldError -> 0x0070 }
            com.bumptech.glide.load.engine.h$f r4 = com.bumptech.glide.load.engine.DecodeJob.C1675f.INITIALIZE     // Catch:{ NoSuchFieldError -> 0x0070 }
            int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0070 }
            r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x0070 }
        L_0x0070:
            int[] r0 = f4611a     // Catch:{ NoSuchFieldError -> 0x007a }
            com.bumptech.glide.load.engine.h$f r3 = com.bumptech.glide.load.engine.DecodeJob.C1675f.SWITCH_TO_SOURCE_SERVICE     // Catch:{ NoSuchFieldError -> 0x007a }
            int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x007a }
            r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x007a }
        L_0x007a:
            int[] r0 = f4611a     // Catch:{ NoSuchFieldError -> 0x0084 }
            com.bumptech.glide.load.engine.h$f r1 = com.bumptech.glide.load.engine.DecodeJob.C1675f.DECODE_DATA     // Catch:{ NoSuchFieldError -> 0x0084 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
        L_0x0084:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.DecodeJob.C16691.m42469clinit():void");
        }
    }

    /* compiled from: DecodeJob */
    /* renamed from: com.bumptech.glide.load.engine.h$a */
    interface C1670a<R> {
        /* renamed from: a */
        void mo12841a(GlideException glideException);

        /* renamed from: a */
        void mo12842a(DecodeJob<?> hVar);

        /* renamed from: a */
        void mo12843a(Resource<R> uVar, DataSource dataSource);
    }

    /* compiled from: DecodeJob */
    /* renamed from: com.bumptech.glide.load.engine.h$b */
    private final class C1671b<Z> implements C1677a<Z> {
        /* renamed from: b */
        private final DataSource f4615b;

        C1671b(DataSource dataSource) {
            this.f4615b = dataSource;
        }

        /* renamed from: a */
        public Resource<Z> mo12844a(Resource<Z> uVar) {
            return DecodeJob.this.mo12835a(this.f4615b, uVar);
        }
    }

    /* compiled from: DecodeJob */
    /* renamed from: com.bumptech.glide.load.engine.h$c */
    private static class C1672c<Z> {
        /* renamed from: a */
        private Key f4616a;
        /* renamed from: b */
        private ResourceEncoder<Z> f4617b;
        /* renamed from: c */
        private LockedResource<Z> f4618c;

        C1672c() {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public <X> void mo12845a(Key cVar, ResourceEncoder<X> hVar, LockedResource<X> tVar) {
            this.f4616a = cVar;
            this.f4617b = hVar;
            this.f4618c = tVar;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo12846a(C1673d dVar, Options fVar) {
            GlideTrace.m6108a("DecodeJob.encode");
            try {
                dVar.mo12849a().mo12786a(this.f4616a, new DataCacheWriter(this.f4617b, this.f4618c, fVar));
            } finally {
                this.f4618c.mo12913a();
                GlideTrace.m6107a();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo12847a() {
            return this.f4618c != null;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo12848b() {
            this.f4616a = null;
            this.f4617b = null;
            this.f4618c = null;
        }
    }

    /* compiled from: DecodeJob */
    /* renamed from: com.bumptech.glide.load.engine.h$d */
    interface C1673d {
        /* renamed from: a */
        DiskCache mo12849a();
    }

    /* compiled from: DecodeJob */
    /* renamed from: com.bumptech.glide.load.engine.h$e */
    private static class C1674e {
        /* renamed from: a */
        private boolean f4619a;
        /* renamed from: b */
        private boolean f4620b;
        /* renamed from: c */
        private boolean f4621c;

        C1674e() {
        }

        /* access modifiers changed from: declared_synchronized */
        /* renamed from: a */
        public synchronized boolean mo12851a(boolean z) {
            this.f4619a = true;
            return m5643b(z);
        }

        /* access modifiers changed from: declared_synchronized */
        /* renamed from: a */
        public synchronized boolean mo12850a() {
            this.f4620b = true;
            return m5643b(false);
        }

        /* access modifiers changed from: declared_synchronized */
        /* renamed from: b */
        public synchronized boolean mo12852b() {
            this.f4621c = true;
            return m5643b(false);
        }

        /* access modifiers changed from: declared_synchronized */
        /* renamed from: c */
        public synchronized void mo12853c() {
            this.f4620b = false;
            this.f4619a = false;
            this.f4621c = false;
        }

        /* renamed from: b */
        private boolean m5643b(boolean z) {
            return (this.f4621c || z || this.f4620b) && this.f4619a;
        }
    }

    /* compiled from: DecodeJob */
    /* renamed from: com.bumptech.glide.load.engine.h$f */
    private enum C1675f {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    /* compiled from: DecodeJob */
    /* renamed from: com.bumptech.glide.load.engine.h$g */
    private enum C1676g {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    DecodeJob(C1673d dVar, Pool<DecodeJob<?>> pool) {
        this.f4588d = dVar;
        this.f4589e = pool;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public DecodeJob<R> mo12834a(GlideContext gVar, Object obj, EngineKey nVar, Key cVar, int i, int i2, Class<?> cls, Class<R> cls2, Priority priority, DiskCacheStrategy jVar, Map<Class<?>, Transformation<?>> map, boolean z, boolean z2, boolean z3, Options fVar, C1670a<R> aVar, int i3) {
        this.f4585a.mo12812a(gVar, obj, cVar, i, i2, jVar, cls, cls2, priority, fVar, map, z, z2, this.f4588d);
        this.f4592h = gVar;
        this.f4593i = cVar;
        this.f4594j = priority;
        this.f4595k = nVar;
        this.f4596l = i;
        this.f4597m = i2;
        this.f4598n = jVar;
        this.f4605u = z3;
        this.f4599o = fVar;
        this.f4600p = aVar;
        this.f4601q = i3;
        this.f4603s = C1675f.INITIALIZE;
        this.f4606v = obj;
        return this;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo12837a() {
        C1676g a = m5605a(C1676g.INITIALIZE);
        return a == C1676g.RESOURCE_CACHE || a == C1676g.DATA_CACHE;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo12836a(boolean z) {
        if (this.f4591g.mo12851a(z)) {
            m5616g();
        }
    }

    /* renamed from: e */
    private void m5614e() {
        if (this.f4591g.mo12850a()) {
            m5616g();
        }
    }

    /* renamed from: f */
    private void m5615f() {
        if (this.f4591g.mo12852b()) {
            m5616g();
        }
    }

    /* renamed from: g */
    private void m5616g() {
        this.f4591g.mo12853c();
        this.f4590f.mo12848b();
        this.f4585a.mo12811a();
        this.f4583D = false;
        this.f4592h = null;
        this.f4593i = null;
        this.f4599o = null;
        this.f4594j = null;
        this.f4595k = null;
        this.f4600p = null;
        this.f4602r = null;
        this.f4582C = null;
        this.f4607w = null;
        this.f4608x = null;
        this.f4610z = null;
        this.f4580A = null;
        this.f4581B = null;
        this.f4604t = 0;
        this.f4584E = false;
        this.f4606v = null;
        this.f4586b.clear();
        this.f4589e.release(this);
    }

    /* renamed from: a */
    public int compareTo(DecodeJob<?> hVar) {
        int h = m5617h() - hVar.m5617h();
        return h == 0 ? this.f4601q - hVar.f4601q : h;
    }

    /* renamed from: h */
    private int m5617h() {
        return this.f4594j.ordinal();
    }

    /* renamed from: b */
    public void mo12838b() {
        this.f4584E = true;
        DataFetcherGenerator fVar = this.f4582C;
        if (fVar != null) {
            fVar.mo12777b();
        }
    }

    public void run() {
        String str = "DecodeJob";
        GlideTrace.m6109a("DecodeJob#run(model=%s)", this.f4606v);
        DataFetcher<?> dVar = this.f4581B;
        try {
            if (this.f4584E) {
                m5621l();
                if (dVar != null) {
                    dVar.mo12627b();
                }
                GlideTrace.m6107a();
                return;
            }
            m5618i();
            if (dVar != null) {
                dVar.mo12627b();
            }
            GlideTrace.m6107a();
        } catch (CallbackException e) {
            throw e;
        } catch (Throwable th) {
            if (dVar != null) {
                dVar.mo12627b();
            }
            GlideTrace.m6107a();
            throw th;
        }
    }

    /* renamed from: i */
    private void m5618i() {
        int i = C16691.f4611a[this.f4603s.ordinal()];
        if (i == 1) {
            this.f4602r = m5605a(C1676g.INITIALIZE);
            this.f4582C = m5619j();
            m5620k();
        } else if (i == 2) {
            m5620k();
        } else if (i == 3) {
            m5623n();
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Unrecognized run reason: ");
            sb.append(this.f4603s);
            throw new IllegalStateException(sb.toString());
        }
    }

    /* renamed from: j */
    private DataFetcherGenerator m5619j() {
        int i = C16691.f4612b[this.f4602r.ordinal()];
        if (i == 1) {
            return new ResourceCacheGenerator(this.f4585a, this);
        }
        if (i == 2) {
            return new DataCacheGenerator(this.f4585a, this);
        }
        if (i == 3) {
            return new SourceGenerator(this.f4585a, this);
        }
        if (i == 4) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unrecognized stage: ");
        sb.append(this.f4602r);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: k */
    private void m5620k() {
        this.f4607w = Thread.currentThread();
        this.f4604t = LogTime.m6125a();
        boolean z = false;
        while (!this.f4584E && this.f4582C != null) {
            z = this.f4582C.mo12776a();
            if (z) {
                break;
            }
            this.f4602r = m5605a(this.f4602r);
            this.f4582C = m5619j();
            if (this.f4602r == C1676g.SOURCE) {
                mo12808c();
                return;
            }
        }
        if ((this.f4602r == C1676g.FINISHED || this.f4584E) && !z) {
            m5621l();
        }
    }

    /* renamed from: l */
    private void m5621l() {
        m5622m();
        this.f4600p.mo12841a(new GlideException("Failed to load resource", (List<Throwable>) new ArrayList<Throwable>(this.f4586b)));
        m5615f();
    }

    /* renamed from: a */
    private void m5610a(Resource<R> uVar, DataSource dataSource) {
        m5622m();
        this.f4600p.mo12843a(uVar, dataSource);
    }

    /* renamed from: m */
    private void m5622m() {
        Throwable th;
        this.f4587c.mo13207b();
        if (this.f4583D) {
            if (this.f4586b.isEmpty()) {
                th = null;
            } else {
                List<Throwable> list = this.f4586b;
                th = (Throwable) list.get(list.size() - 1);
            }
            throw new IllegalStateException("Already notified", th);
        }
        this.f4583D = true;
    }

    /* renamed from: a */
    private C1676g m5605a(C1676g gVar) {
        C1676g gVar2;
        int i = C16691.f4612b[gVar.ordinal()];
        if (i == 1) {
            return this.f4598n.mo12859b() ? C1676g.DATA_CACHE : m5605a(C1676g.DATA_CACHE);
        } else if (i == 2) {
            return this.f4605u ? C1676g.FINISHED : C1676g.SOURCE;
        } else if (i == 3 || i == 4) {
            return C1676g.FINISHED;
        } else {
            if (i == 5) {
                if (this.f4598n.mo12856a()) {
                    gVar2 = C1676g.RESOURCE_CACHE;
                } else {
                    gVar2 = m5605a(C1676g.RESOURCE_CACHE);
                }
                return gVar2;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Unrecognized stage: ");
            sb.append(gVar);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* renamed from: c */
    public void mo12808c() {
        this.f4603s = C1675f.SWITCH_TO_SOURCE_SERVICE;
        this.f4600p.mo12842a(this);
    }

    /* renamed from: a */
    public void mo12807a(Key cVar, Object obj, DataFetcher<?> dVar, DataSource dataSource, Key cVar2) {
        this.f4608x = cVar;
        this.f4610z = obj;
        this.f4581B = dVar;
        this.f4580A = dataSource;
        this.f4609y = cVar2;
        if (Thread.currentThread() != this.f4607w) {
            this.f4603s = C1675f.DECODE_DATA;
            this.f4600p.mo12842a(this);
            return;
        }
        GlideTrace.m6108a("DecodeJob.decodeFromRetrievedData");
        try {
            m5623n();
        } finally {
            GlideTrace.m6107a();
        }
    }

    /* renamed from: a */
    public void mo12806a(Key cVar, Exception exc, DataFetcher<?> dVar, DataSource dataSource) {
        dVar.mo12627b();
        GlideException glideException = new GlideException("Fetching data failed", (Throwable) exc);
        glideException.setLoggingDetails(cVar, dataSource, dVar.mo12619a());
        this.f4586b.add(glideException);
        if (Thread.currentThread() != this.f4607w) {
            this.f4603s = C1675f.SWITCH_TO_SOURCE_SERVICE;
            this.f4600p.mo12842a(this);
            return;
        }
        m5620k();
    }

    /* renamed from: n */
    private void m5623n() {
        if (Log.isLoggable("DecodeJob", 2)) {
            long j = this.f4604t;
            StringBuilder sb = new StringBuilder();
            sb.append("data: ");
            sb.append(this.f4610z);
            sb.append(", cache key: ");
            sb.append(this.f4608x);
            sb.append(", fetcher: ");
            sb.append(this.f4581B);
            m5612a("Retrieved data", j, sb.toString());
        }
        Resource uVar = null;
        try {
            uVar = m5606a(this.f4581B, (Data) this.f4610z, this.f4580A);
        } catch (GlideException e) {
            e.setLoggingDetails(this.f4609y, this.f4580A);
            this.f4586b.add(e);
        }
        if (uVar != null) {
            m5613b(uVar, this.f4580A);
        } else {
            m5620k();
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: type inference failed for: r3v1, types: [com.bumptech.glide.load.engine.u] */
    /* JADX WARNING: type inference failed for: r3v7, types: [com.bumptech.glide.load.engine.t] */
    /* JADX WARNING: type inference failed for: r3v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: b */
    private void m5613b(com.bumptech.glide.load.engine.Resource<R> r3, com.bumptech.glide.load.DataSource r4) {
        /*
        r2 = this;
        boolean r0 = r3 instanceof com.bumptech.glide.load.engine.Initializable
        if (r0 == 0) goto L_0x000a
        r0 = r3
        com.bumptech.glide.load.engine.q r0 = (com.bumptech.glide.load.engine.Initializable) r0
        r0.initialize()
    L_0x000a:
        r0 = 0
        com.bumptech.glide.load.engine.h$c<?> r1 = r2.f4590f
        boolean r1 = r1.mo12847a()
        if (r1 == 0) goto L_0x0018
        com.bumptech.glide.load.engine.t r3 = com.bumptech.glide.load.engine.LockedResource.m5737a(r3)
        r0 = r3
    L_0x0018:
        r2.m5610a(r3, r4)
        com.bumptech.glide.load.engine.h$g r3 = com.bumptech.glide.load.engine.DecodeJob.C1676g.ENCODE
        r2.f4602r = r3
        com.bumptech.glide.load.engine.h$c<?> r3 = r2.f4590f     // Catch:{ all -> 0x0039 }
        boolean r3 = r3.mo12847a()     // Catch:{ all -> 0x0039 }
        if (r3 == 0) goto L_0x0030
        com.bumptech.glide.load.engine.h$c<?> r3 = r2.f4590f     // Catch:{ all -> 0x0039 }
        com.bumptech.glide.load.engine.h$d r4 = r2.f4588d     // Catch:{ all -> 0x0039 }
        com.bumptech.glide.load.f r1 = r2.f4599o     // Catch:{ all -> 0x0039 }
        r3.mo12846a(r4, r1)     // Catch:{ all -> 0x0039 }
    L_0x0030:
        if (r0 == 0) goto L_0x0035
        r0.mo12913a()
    L_0x0035:
        r2.m5614e()
        return
    L_0x0039:
        r3 = move-exception
        if (r0 == 0) goto L_0x003f
        r0.mo12913a()
    L_0x003f:
        throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.DecodeJob.m5613b(com.bumptech.glide.load.engine.u, com.bumptech.glide.load.DataSource):void");
    }

    /* renamed from: a */
    private <Data> Resource<R> m5606a(DataFetcher<?> dVar, Data data, DataSource dataSource) throws GlideException {
        if (data == null) {
            dVar.mo12627b();
            return null;
        }
        try {
            long a = LogTime.m6125a();
            Resource<R> a2 = m5607a(data, dataSource);
            if (Log.isLoggable("DecodeJob", 2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Decoded result ");
                sb.append(a2);
                m5611a(sb.toString(), a);
            }
            return a2;
        } finally {
            dVar.mo12627b();
        }
    }

    /* renamed from: a */
    private <Data> Resource<R> m5607a(Data data, DataSource dataSource) throws GlideException {
        return m5608a(data, dataSource, this.f4585a.mo12817b(data.getClass()));
    }

    /* renamed from: a */
    private Options m5609a(DataSource dataSource) {
        Options fVar = this.f4599o;
        if (VERSION.SDK_INT < 26) {
            return fVar;
        }
        boolean z = dataSource == DataSource.RESOURCE_DISK_CACHE || this.f4585a.mo12830m();
        Boolean bool = (Boolean) fVar.mo12919a(Downsampler.ALLOW_HARDWARE_CONFIG);
        if (bool != null && (!bool.booleanValue() || z)) {
            return fVar;
        }
        Options fVar2 = new Options();
        fVar2.mo12920a(this.f4599o);
        fVar2.mo12918a(Downsampler.ALLOW_HARDWARE_CONFIG, Boolean.valueOf(z));
        return fVar2;
    }

    /* renamed from: a */
    private <Data, ResourceType> Resource<R> m5608a(Data data, DataSource dataSource, LoadPath<Data, ResourceType, R> sVar) throws GlideException {
        Options a = m5609a(dataSource);
        DataRewinder b = this.f4592h.mo12550d().mo12356b(data);
        try {
            return sVar.mo12911a(b, a, this.f4596l, this.f4597m, new C1671b(dataSource));
        } finally {
            b.cleanup();
        }
    }

    /* renamed from: a */
    private void m5611a(String str, long j) {
        m5612a(str, j, (String) null);
    }

    /* renamed from: a */
    private void m5612a(String str, long j, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(LogTime.m6124a(j));
        sb.append(", load key: ");
        sb.append(this.f4595k);
        if (str2 != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(", ");
            sb2.append(str2);
            str3 = sb2.toString();
        } else {
            str3 = "";
        }
        sb.append(str3);
        sb.append(", thread: ");
        sb.append(Thread.currentThread().getName());
        Log.v("DecodeJob", sb.toString());
    }

    /* renamed from: d */
    public StateVerifier mo12519d() {
        return this.f4587c;
    }

    /* JADX WARNING: type inference failed for: r12v5, types: [com.bumptech.glide.load.c] */
    /* JADX WARNING: type inference failed for: r12v6, types: [com.bumptech.glide.load.engine.d] */
    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    public <Z> com.bumptech.glide.load.engine.Resource<Z> mo12835a(com.bumptech.glide.load.DataSource r12, com.bumptech.glide.load.engine.Resource<Z> r13) {
        /*
        r11 = this;
        java.lang.Object r0 = r13.get()
        java.lang.Class r8 = r0.getClass()
        com.bumptech.glide.load.DataSource r0 = com.bumptech.glide.load.DataSource.RESOURCE_DISK_CACHE
        r1 = 0
        if (r12 == r0) goto L_0x0020
        com.bumptech.glide.load.engine.g<R> r0 = r11.f4585a
        com.bumptech.glide.load.i r0 = r0.mo12820c(r8)
        com.bumptech.glide.g r2 = r11.f4592h
        int r3 = r11.f4596l
        int r4 = r11.f4597m
        com.bumptech.glide.load.engine.u r2 = r0.transform(r2, r13, r3, r4)
        r7 = r0
        r0 = r2
        goto L_0x0022
    L_0x0020:
        r0 = r13
        r7 = r1
    L_0x0022:
        boolean r2 = r13.equals(r0)
        if (r2 != 0) goto L_0x002b
        r13.recycle()
    L_0x002b:
        com.bumptech.glide.load.engine.g<R> r13 = r11.f4585a
        boolean r13 = r13.mo12814a(r0)
        if (r13 == 0) goto L_0x0040
        com.bumptech.glide.load.engine.g<R> r13 = r11.f4585a
        com.bumptech.glide.load.h r1 = r13.mo12818b(r0)
        com.bumptech.glide.load.f r13 = r11.f4599o
        com.bumptech.glide.load.EncodeStrategy r13 = r1.getEncodeStrategy(r13)
        goto L_0x0042
    L_0x0040:
        com.bumptech.glide.load.EncodeStrategy r13 = com.bumptech.glide.load.EncodeStrategy.NONE
    L_0x0042:
        r10 = r1
        com.bumptech.glide.load.engine.g<R> r1 = r11.f4585a
        com.bumptech.glide.load.c r2 = r11.f4608x
        boolean r1 = r1.mo12813a(r2)
        r2 = 1
        r1 = r1 ^ r2
        com.bumptech.glide.load.engine.j r3 = r11.f4598n
        boolean r12 = r3.mo12858a(r1, r12, r13)
        if (r12 == 0) goto L_0x00b3
        if (r10 == 0) goto L_0x00a5
        int[] r12 = com.bumptech.glide.load.engine.DecodeJob.C16691.f4613c
        int r1 = r13.ordinal()
        r12 = r12[r1]
        if (r12 == r2) goto L_0x0092
        r1 = 2
        if (r12 != r1) goto L_0x007b
        com.bumptech.glide.load.engine.w r12 = new com.bumptech.glide.load.engine.w
        com.bumptech.glide.load.engine.g<R> r13 = r11.f4585a
        com.bumptech.glide.load.engine.a.b r2 = r13.mo12826i()
        com.bumptech.glide.load.c r3 = r11.f4608x
        com.bumptech.glide.load.c r4 = r11.f4593i
        int r5 = r11.f4596l
        int r6 = r11.f4597m
        com.bumptech.glide.load.f r9 = r11.f4599o
        r1 = r12
        r1.m42513init(r2, r3, r4, r5, r6, r7, r8, r9)
        goto L_0x009b
    L_0x007b:
        java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r1 = "Unknown strategy: "
        r0.append(r1)
        r0.append(r13)
        java.lang.String r13 = r0.toString()
        r12.<init>(r13)
        throw r12
    L_0x0092:
        com.bumptech.glide.load.engine.d r12 = new com.bumptech.glide.load.engine.d
        com.bumptech.glide.load.c r13 = r11.f4608x
        com.bumptech.glide.load.c r1 = r11.f4593i
        r12.m42465init(r13, r1)
    L_0x009b:
        com.bumptech.glide.load.engine.t r0 = com.bumptech.glide.load.engine.LockedResource.m5737a(r0)
        com.bumptech.glide.load.engine.h$c<?> r13 = r11.f4590f
        r13.mo12845a(r12, r10, r0)
        goto L_0x00b3
    L_0x00a5:
        com.bumptech.glide.Registry$NoResultEncoderAvailableException r12 = new com.bumptech.glide.Registry$NoResultEncoderAvailableException
        java.lang.Object r13 = r0.get()
        java.lang.Class r13 = r13.getClass()
        r12.m42258init(r13)
        throw r12
    L_0x00b3:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.DecodeJob.mo12835a(com.bumptech.glide.load.DataSource, com.bumptech.glide.load.engine.u):com.bumptech.glide.load.engine.u");
    }
}
