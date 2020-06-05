package com.bumptech.glide.load.engine;

import androidx.core.util.Pools.Pool;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.p138b.GlideExecutor;
import com.bumptech.glide.p131c.ResourceCallback;
import com.bumptech.glide.util.Executors;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.p140a.FactoryPools.C1766c;
import com.bumptech.glide.util.p140a.StateVerifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.bumptech.glide.load.engine.l */
class EngineJob<R> implements C1670a<R>, C1766c {
    /* renamed from: e */
    private static final C1691c f4659e = new C1691c();
    /* renamed from: a */
    final C1693e f4660a;
    /* renamed from: b */
    DataSource f4661b;
    /* renamed from: c */
    GlideException f4662c;
    /* renamed from: d */
    EngineResource<?> f4663d;
    /* renamed from: f */
    private final StateVerifier f4664f;
    /* renamed from: g */
    private final Pool<EngineJob<?>> f4665g;
    /* renamed from: h */
    private final C1691c f4666h;
    /* renamed from: i */
    private final EngineJobListener f4667i;
    /* renamed from: j */
    private final GlideExecutor f4668j;
    /* renamed from: k */
    private final GlideExecutor f4669k;
    /* renamed from: l */
    private final GlideExecutor f4670l;
    /* renamed from: m */
    private final GlideExecutor f4671m;
    /* renamed from: n */
    private final AtomicInteger f4672n;
    /* renamed from: o */
    private Key f4673o;
    /* renamed from: p */
    private boolean f4674p;
    /* renamed from: q */
    private boolean f4675q;
    /* renamed from: r */
    private boolean f4676r;
    /* renamed from: s */
    private boolean f4677s;
    /* renamed from: t */
    private Resource<?> f4678t;
    /* renamed from: u */
    private boolean f4679u;
    /* renamed from: v */
    private boolean f4680v;
    /* renamed from: w */
    private DecodeJob<R> f4681w;
    /* renamed from: x */
    private volatile boolean f4682x;

    /* compiled from: EngineJob */
    /* renamed from: com.bumptech.glide.load.engine.l$a */
    private class C1689a implements Runnable {
        /* renamed from: b */
        private final ResourceCallback f4684b;

        C1689a(ResourceCallback gVar) {
            this.f4684b = gVar;
        }

        public void run() {
            synchronized (EngineJob.this) {
                if (EngineJob.this.f4660a.mo12891b(this.f4684b)) {
                    EngineJob.this.mo12876b(this.f4684b);
                }
                EngineJob.this.mo12880e();
            }
        }
    }

    /* compiled from: EngineJob */
    /* renamed from: com.bumptech.glide.load.engine.l$b */
    private class C1690b implements Runnable {
        /* renamed from: b */
        private final ResourceCallback f4686b;

        C1690b(ResourceCallback gVar) {
            this.f4686b = gVar;
        }

        public void run() {
            synchronized (EngineJob.this) {
                if (EngineJob.this.f4660a.mo12891b(this.f4686b)) {
                    EngineJob.this.f4663d.mo12900c();
                    EngineJob.this.mo12872a(this.f4686b);
                    EngineJob.this.mo12879c(this.f4686b);
                }
                EngineJob.this.mo12880e();
            }
        }
    }

    /* compiled from: EngineJob */
    /* renamed from: com.bumptech.glide.load.engine.l$c */
    static class C1691c {
        C1691c() {
        }

        /* renamed from: a */
        public <R> EngineResource<R> mo12884a(Resource<R> uVar, boolean z) {
            return new EngineResource<>(uVar, z, true);
        }
    }

    /* compiled from: EngineJob */
    /* renamed from: com.bumptech.glide.load.engine.l$d */
    static final class C1692d {
        /* renamed from: a */
        final ResourceCallback f4687a;
        /* renamed from: b */
        final Executor f4688b;

        C1692d(ResourceCallback gVar, Executor executor) {
            this.f4687a = gVar;
            this.f4688b = executor;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1692d)) {
                return false;
            }
            return this.f4687a.equals(((C1692d) obj).f4687a);
        }

        public int hashCode() {
            return this.f4687a.hashCode();
        }
    }

    /* compiled from: EngineJob */
    /* renamed from: com.bumptech.glide.load.engine.l$e */
    static final class C1693e implements Iterable<C1692d> {
        /* renamed from: a */
        private final List<C1692d> f4689a;

        C1693e() {
            this(new ArrayList(2));
        }

        C1693e(List<C1692d> list) {
            this.f4689a = list;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo12888a(ResourceCallback gVar, Executor executor) {
            this.f4689a.add(new C1692d(gVar, executor));
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo12887a(ResourceCallback gVar) {
            this.f4689a.remove(m5714c(gVar));
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public boolean mo12891b(ResourceCallback gVar) {
            return this.f4689a.contains(m5714c(gVar));
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo12889a() {
            return this.f4689a.isEmpty();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public int mo12890b() {
            return this.f4689a.size();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public void mo12892c() {
            this.f4689a.clear();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: d */
        public C1693e mo12893d() {
            return new C1693e(new ArrayList(this.f4689a));
        }

        /* renamed from: c */
        private static C1692d m5714c(ResourceCallback gVar) {
            return new C1692d(gVar, Executors.m6123b());
        }

        public Iterator<C1692d> iterator() {
            return this.f4689a.iterator();
        }
    }

    EngineJob(GlideExecutor aVar, GlideExecutor aVar2, GlideExecutor aVar3, GlideExecutor aVar4, EngineJobListener mVar, Pool<EngineJob<?>> pool) {
        this(aVar, aVar2, aVar3, aVar4, mVar, pool, f4659e);
    }

    EngineJob(GlideExecutor aVar, GlideExecutor aVar2, GlideExecutor aVar3, GlideExecutor aVar4, EngineJobListener mVar, Pool<EngineJob<?>> pool, C1691c cVar) {
        this.f4660a = new C1693e();
        this.f4664f = StateVerifier.m6111a();
        this.f4672n = new AtomicInteger();
        this.f4668j = aVar;
        this.f4669k = aVar2;
        this.f4670l = aVar3;
        this.f4671m = aVar4;
        this.f4667i = mVar;
        this.f4665g = pool;
        this.f4666h = cVar;
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: a */
    public synchronized EngineJob<R> mo12870a(Key cVar, boolean z, boolean z2, boolean z3, boolean z4) {
        this.f4673o = cVar;
        this.f4674p = z;
        this.f4675q = z2;
        this.f4676r = z3;
        this.f4677s = z4;
        return this;
    }

    /* renamed from: b */
    public synchronized void mo12877b(DecodeJob<R> hVar) {
        GlideExecutor aVar;
        this.f4681w = hVar;
        if (hVar.mo12837a()) {
            aVar = this.f4668j;
        } else {
            aVar = m5694g();
        }
        aVar.execute(hVar);
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: a */
    public synchronized void mo12873a(ResourceCallback gVar, Executor executor) {
        this.f4664f.mo13207b();
        this.f4660a.mo12888a(gVar, executor);
        boolean z = true;
        if (this.f4679u) {
            mo12871a(1);
            executor.execute(new C1690b(gVar));
        } else if (this.f4680v) {
            mo12871a(1);
            executor.execute(new C1689a(gVar));
        } else {
            if (this.f4682x) {
                z = false;
            }
            Preconditions.m6142a(z, "Cannot add callbacks to a cancelled EngineJob");
        }
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: a */
    public synchronized void mo12872a(ResourceCallback gVar) {
        try {
            gVar.mo12518a(this.f4663d, this.f4661b);
        } catch (Throwable th) {
            throw new CallbackException(th);
        }
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: b */
    public synchronized void mo12876b(ResourceCallback gVar) {
        try {
            gVar.mo12517a(this.f4662c);
        } catch (Throwable th) {
            throw new CallbackException(th);
        }
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: c */
    public synchronized void mo12879c(ResourceCallback gVar) {
        boolean z;
        this.f4664f.mo13207b();
        this.f4660a.mo12887a(gVar);
        if (this.f4660a.mo12889a()) {
            mo12875b();
            if (!this.f4679u) {
                if (!this.f4680v) {
                    z = false;
                    if (z && this.f4672n.get() == 0) {
                        m5696i();
                    }
                }
            }
            z = true;
            m5696i();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo12874a() {
        return this.f4677s;
    }

    /* renamed from: g */
    private GlideExecutor m5694g() {
        if (this.f4675q) {
            return this.f4670l;
        }
        return this.f4676r ? this.f4671m : this.f4669k;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo12875b() {
        if (!m5695h()) {
            this.f4682x = true;
            this.f4681w.mo12838b();
            this.f4667i.mo12862a(this, this.f4673o);
        }
    }

    /* renamed from: h */
    private boolean m5695h() {
        return this.f4680v || this.f4679u || this.f4682x;
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0042, code lost:
            r4.f4667i.mo12863a(r4, r0, r2);
            r0 = r1.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004f, code lost:
            if (r0.hasNext() == false) goto L_0x0064;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0051, code lost:
            r1 = (com.bumptech.glide.load.engine.EngineJob.C1692d) r0.next();
            r1.f4688b.execute(new com.bumptech.glide.load.engine.EngineJob.C1690b(r4, r1.f4687a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0064, code lost:
            mo12880e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0067, code lost:
            return;
     */
    /* renamed from: c */
    public void mo12878c() {
        /*
        r4 = this;
        monitor-enter(r4)
        com.bumptech.glide.util.a.c r0 = r4.f4664f     // Catch:{ all -> 0x0078 }
        r0.mo13207b()     // Catch:{ all -> 0x0078 }
        boolean r0 = r4.f4682x     // Catch:{ all -> 0x0078 }
        if (r0 == 0) goto L_0x0014
        com.bumptech.glide.load.engine.u<?> r0 = r4.f4678t     // Catch:{ all -> 0x0078 }
        r0.recycle()     // Catch:{ all -> 0x0078 }
        r4.m5696i()     // Catch:{ all -> 0x0078 }
        monitor-exit(r4)     // Catch:{ all -> 0x0078 }
        return
    L_0x0014:
        com.bumptech.glide.load.engine.l$e r0 = r4.f4660a     // Catch:{ all -> 0x0078 }
        boolean r0 = r0.mo12889a()     // Catch:{ all -> 0x0078 }
        if (r0 != 0) goto L_0x0070
        boolean r0 = r4.f4679u     // Catch:{ all -> 0x0078 }
        if (r0 != 0) goto L_0x0068
        com.bumptech.glide.load.engine.l$c r0 = r4.f4666h     // Catch:{ all -> 0x0078 }
        com.bumptech.glide.load.engine.u<?> r1 = r4.f4678t     // Catch:{ all -> 0x0078 }
        boolean r2 = r4.f4674p     // Catch:{ all -> 0x0078 }
        com.bumptech.glide.load.engine.p r0 = r0.mo12884a(r1, r2)     // Catch:{ all -> 0x0078 }
        r4.f4663d = r0     // Catch:{ all -> 0x0078 }
        r0 = 1
        r4.f4679u = r0     // Catch:{ all -> 0x0078 }
        com.bumptech.glide.load.engine.l$e r1 = r4.f4660a     // Catch:{ all -> 0x0078 }
        com.bumptech.glide.load.engine.l$e r1 = r1.mo12893d()     // Catch:{ all -> 0x0078 }
        int r2 = r1.mo12890b()     // Catch:{ all -> 0x0078 }
        int r2 = r2 + r0
        r4.mo12871a(r2)     // Catch:{ all -> 0x0078 }
        com.bumptech.glide.load.c r0 = r4.f4673o     // Catch:{ all -> 0x0078 }
        com.bumptech.glide.load.engine.p<?> r2 = r4.f4663d     // Catch:{ all -> 0x0078 }
        monitor-exit(r4)     // Catch:{ all -> 0x0078 }
        com.bumptech.glide.load.engine.m r3 = r4.f4667i
        r3.mo12863a(r4, r0, r2)
        java.util.Iterator r0 = r1.iterator()
    L_0x004b:
        boolean r1 = r0.hasNext()
        if (r1 == 0) goto L_0x0064
        java.lang.Object r1 = r0.next()
        com.bumptech.glide.load.engine.l$d r1 = (com.bumptech.glide.load.engine.EngineJob.C1692d) r1
        java.util.concurrent.Executor r2 = r1.f4688b
        com.bumptech.glide.load.engine.l$b r3 = new com.bumptech.glide.load.engine.l$b
        com.bumptech.glide.c.g r1 = r1.f4687a
        r3.m42498init(r1)
        r2.execute(r3)
        goto L_0x004b
    L_0x0064:
        r4.mo12880e()
        return
    L_0x0068:
        java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0078 }
        java.lang.String r1 = "Already have resource"
        r0.<init>(r1)     // Catch:{ all -> 0x0078 }
        throw r0     // Catch:{ all -> 0x0078 }
    L_0x0070:
        java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0078 }
        java.lang.String r1 = "Received a resource without any callbacks to notify"
        r0.<init>(r1)     // Catch:{ all -> 0x0078 }
        throw r0     // Catch:{ all -> 0x0078 }
    L_0x0078:
        r0 = move-exception
        monitor-exit(r4)     // Catch:{ all -> 0x0078 }
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.EngineJob.mo12878c():void");
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: a */
    public synchronized void mo12871a(int i) {
        Preconditions.m6142a(m5695h(), "Not yet complete!");
        if (this.f4672n.getAndAdd(i) == 0 && this.f4663d != null) {
            this.f4663d.mo12900c();
        }
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: e */
    public synchronized void mo12880e() {
        this.f4664f.mo13207b();
        Preconditions.m6142a(m5695h(), "Not yet complete!");
        int decrementAndGet = this.f4672n.decrementAndGet();
        Preconditions.m6142a(decrementAndGet >= 0, "Can't decrement below 0");
        if (decrementAndGet == 0) {
            if (this.f4663d != null) {
                this.f4663d.mo12901d();
            }
            m5696i();
        }
    }

    /* renamed from: i */
    private synchronized void m5696i() {
        if (this.f4673o != null) {
            this.f4660a.mo12892c();
            this.f4673o = null;
            this.f4663d = null;
            this.f4678t = null;
            this.f4680v = false;
            this.f4682x = false;
            this.f4679u = false;
            this.f4681w.mo12836a(false);
            this.f4681w = null;
            this.f4662c = null;
            this.f4661b = null;
            this.f4665g.release(this);
        } else {
            throw new IllegalArgumentException();
        }
    }

    /* renamed from: a */
    public void mo12843a(Resource<R> uVar, DataSource dataSource) {
        synchronized (this) {
            this.f4678t = uVar;
            this.f4661b = dataSource;
        }
        mo12878c();
    }

    /* renamed from: a */
    public void mo12841a(GlideException glideException) {
        synchronized (this) {
            this.f4662c = glideException;
        }
        mo12881f();
    }

    /* renamed from: a */
    public void mo12842a(DecodeJob<?> hVar) {
        m5694g().execute(hVar);
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002f, code lost:
            r4.f4667i.mo12863a(r4, r1, null);
            r0 = r2.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003d, code lost:
            if (r0.hasNext() == false) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003f, code lost:
            r1 = (com.bumptech.glide.load.engine.EngineJob.C1692d) r0.next();
            r1.f4688b.execute(new com.bumptech.glide.load.engine.EngineJob.C1689a(r4, r1.f4687a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0052, code lost:
            mo12880e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0055, code lost:
            return;
     */
    /* renamed from: f */
    public void mo12881f() {
        /*
        r4 = this;
        monitor-enter(r4)
        com.bumptech.glide.util.a.c r0 = r4.f4664f     // Catch:{ all -> 0x0066 }
        r0.mo13207b()     // Catch:{ all -> 0x0066 }
        boolean r0 = r4.f4682x     // Catch:{ all -> 0x0066 }
        if (r0 == 0) goto L_0x000f
        r4.m5696i()     // Catch:{ all -> 0x0066 }
        monitor-exit(r4)     // Catch:{ all -> 0x0066 }
        return
    L_0x000f:
        com.bumptech.glide.load.engine.l$e r0 = r4.f4660a     // Catch:{ all -> 0x0066 }
        boolean r0 = r0.mo12889a()     // Catch:{ all -> 0x0066 }
        if (r0 != 0) goto L_0x005e
        boolean r0 = r4.f4680v     // Catch:{ all -> 0x0066 }
        if (r0 != 0) goto L_0x0056
        r0 = 1
        r4.f4680v = r0     // Catch:{ all -> 0x0066 }
        com.bumptech.glide.load.c r1 = r4.f4673o     // Catch:{ all -> 0x0066 }
        com.bumptech.glide.load.engine.l$e r2 = r4.f4660a     // Catch:{ all -> 0x0066 }
        com.bumptech.glide.load.engine.l$e r2 = r2.mo12893d()     // Catch:{ all -> 0x0066 }
        int r3 = r2.mo12890b()     // Catch:{ all -> 0x0066 }
        int r3 = r3 + r0
        r4.mo12871a(r3)     // Catch:{ all -> 0x0066 }
        monitor-exit(r4)     // Catch:{ all -> 0x0066 }
        com.bumptech.glide.load.engine.m r0 = r4.f4667i
        r3 = 0
        r0.mo12863a(r4, r1, r3)
        java.util.Iterator r0 = r2.iterator()
    L_0x0039:
        boolean r1 = r0.hasNext()
        if (r1 == 0) goto L_0x0052
        java.lang.Object r1 = r0.next()
        com.bumptech.glide.load.engine.l$d r1 = (com.bumptech.glide.load.engine.EngineJob.C1692d) r1
        java.util.concurrent.Executor r2 = r1.f4688b
        com.bumptech.glide.load.engine.l$a r3 = new com.bumptech.glide.load.engine.l$a
        com.bumptech.glide.c.g r1 = r1.f4687a
        r3.m42497init(r1)
        r2.execute(r3)
        goto L_0x0039
    L_0x0052:
        r4.mo12880e()
        return
    L_0x0056:
        java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0066 }
        java.lang.String r1 = "Already failed once"
        r0.<init>(r1)     // Catch:{ all -> 0x0066 }
        throw r0     // Catch:{ all -> 0x0066 }
    L_0x005e:
        java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0066 }
        java.lang.String r1 = "Received an exception without any callbacks to notify"
        r0.<init>(r1)     // Catch:{ all -> 0x0066 }
        throw r0     // Catch:{ all -> 0x0066 }
    L_0x0066:
        r0 = move-exception
        monitor-exit(r4)     // Catch:{ all -> 0x0066 }
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.EngineJob.mo12881f():void");
    }

    /* renamed from: d */
    public StateVerifier mo12519d() {
        return this.f4664f;
    }
}
