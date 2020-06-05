package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.core.util.Pools.Pool;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskCache.C1660a;
import com.bumptech.glide.load.engine.cache.DiskCacheAdapter;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.cache.MemoryCache.C1665a;
import com.bumptech.glide.load.engine.p138b.GlideExecutor;
import com.bumptech.glide.p131c.ResourceCallback;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.p140a.FactoryPools;
import com.bumptech.glide.util.p140a.FactoryPools.C1764a;
import com.tencent.bugly.beta.tinker.TinkerReport;
import java.util.Map;

/* renamed from: com.bumptech.glide.load.engine.k */
public class Engine implements C1665a, EngineJobListener, C1694a {
    /* renamed from: a */
    private static final boolean f4634a = Log.isLoggable("Engine", 2);
    /* renamed from: b */
    private final Jobs f4635b;
    /* renamed from: c */
    private final EngineKeyFactory f4636c;
    /* renamed from: d */
    private final MemoryCache f4637d;
    /* renamed from: e */
    private final C1685b f4638e;
    /* renamed from: f */
    private final ResourceRecycler f4639f;
    /* renamed from: g */
    private final C1687c f4640g;
    /* renamed from: h */
    private final C1683a f4641h;
    /* renamed from: i */
    private final ActiveResources f4642i;

    /* compiled from: Engine */
    /* renamed from: com.bumptech.glide.load.engine.k$a */
    static class C1683a {
        /* renamed from: a */
        final C1673d f4643a;
        /* renamed from: b */
        final Pool<DecodeJob<?>> f4644b = FactoryPools.m6095a((int) TinkerReport.KEY_APPLIED_PACKAGE_CHECK_SIGNATURE, (C1764a<T>) new C1764a<DecodeJob<?>>() {
            /* renamed from: a */
            public DecodeJob<?> mo12521b() {
                return new DecodeJob<>(C1683a.this.f4643a, C1683a.this.f4644b);
            }
        });
        /* renamed from: c */
        private int f4645c;

        C1683a(C1673d dVar) {
            this.f4643a = dVar;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public <R> DecodeJob<R> mo12865a(GlideContext gVar, Object obj, EngineKey nVar, Key cVar, int i, int i2, Class<?> cls, Class<R> cls2, Priority priority, DiskCacheStrategy jVar, Map<Class<?>, Transformation<?>> map, boolean z, boolean z2, boolean z3, Options fVar, C1670a<R> aVar) {
            GlideContext gVar2 = gVar;
            Object obj2 = obj;
            EngineKey nVar2 = nVar;
            Key cVar2 = cVar;
            int i3 = i;
            int i4 = i2;
            Class<?> cls3 = cls;
            Class<R> cls4 = cls2;
            Priority priority2 = priority;
            DiskCacheStrategy jVar2 = jVar;
            Map<Class<?>, Transformation<?>> map2 = map;
            boolean z4 = z;
            boolean z5 = z2;
            boolean z6 = z3;
            Options fVar2 = fVar;
            C1670a<R> aVar2 = aVar;
            DecodeJob hVar = (DecodeJob) Preconditions.m6138a((DecodeJob) this.f4644b.acquire());
            int i5 = this.f4645c;
            int i6 = i5;
            this.f4645c = i5 + 1;
            return hVar.mo12834a(gVar2, obj2, nVar2, cVar2, i3, i4, cls3, cls4, priority2, jVar2, map2, z4, z5, z6, fVar2, aVar2, i6);
        }
    }

    /* compiled from: Engine */
    /* renamed from: com.bumptech.glide.load.engine.k$b */
    static class C1685b {
        /* renamed from: a */
        final GlideExecutor f4647a;
        /* renamed from: b */
        final GlideExecutor f4648b;
        /* renamed from: c */
        final GlideExecutor f4649c;
        /* renamed from: d */
        final GlideExecutor f4650d;
        /* renamed from: e */
        final EngineJobListener f4651e;
        /* renamed from: f */
        final Pool<EngineJob<?>> f4652f = FactoryPools.m6095a((int) TinkerReport.KEY_APPLIED_PACKAGE_CHECK_SIGNATURE, (C1764a<T>) new C1764a<EngineJob<?>>() {
            /* renamed from: a */
            public EngineJob<?> mo12521b() {
                EngineJob lVar = new EngineJob(C1685b.this.f4647a, C1685b.this.f4648b, C1685b.this.f4649c, C1685b.this.f4650d, C1685b.this.f4651e, C1685b.this.f4652f);
                return lVar;
            }
        });

        C1685b(GlideExecutor aVar, GlideExecutor aVar2, GlideExecutor aVar3, GlideExecutor aVar4, EngineJobListener mVar) {
            this.f4647a = aVar;
            this.f4648b = aVar2;
            this.f4649c = aVar3;
            this.f4650d = aVar4;
            this.f4651e = mVar;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public <R> EngineJob<R> mo12867a(Key cVar, boolean z, boolean z2, boolean z3, boolean z4) {
            return ((EngineJob) Preconditions.m6138a((EngineJob) this.f4652f.acquire())).mo12870a(cVar, z, z2, z3, z4);
        }
    }

    /* compiled from: Engine */
    /* renamed from: com.bumptech.glide.load.engine.k$c */
    private static class C1687c implements C1673d {
        /* renamed from: a */
        private final C1660a f4654a;
        /* renamed from: b */
        private volatile DiskCache f4655b;

        C1687c(C1660a aVar) {
            this.f4654a = aVar;
        }

        /* renamed from: a */
        public DiskCache mo12849a() {
            if (this.f4655b == null) {
                synchronized (this) {
                    if (this.f4655b == null) {
                        this.f4655b = this.f4654a.mo12787a();
                    }
                    if (this.f4655b == null) {
                        this.f4655b = new DiskCacheAdapter();
                    }
                }
            }
            return this.f4655b;
        }
    }

    /* compiled from: Engine */
    /* renamed from: com.bumptech.glide.load.engine.k$d */
    public class C1688d {
        /* renamed from: b */
        private final EngineJob<?> f4657b;
        /* renamed from: c */
        private final ResourceCallback f4658c;

        C1688d(ResourceCallback gVar, EngineJob<?> lVar) {
            this.f4658c = gVar;
            this.f4657b = lVar;
        }

        /* renamed from: a */
        public void mo12869a() {
            synchronized (Engine.this) {
                this.f4657b.mo12879c(this.f4658c);
            }
        }
    }

    public Engine(MemoryCache gVar, C1660a aVar, GlideExecutor aVar2, GlideExecutor aVar3, GlideExecutor aVar4, GlideExecutor aVar5, boolean z) {
        this(gVar, aVar, aVar2, aVar3, aVar4, aVar5, null, null, null, null, null, null, z);
    }

    Engine(MemoryCache gVar, C1660a aVar, GlideExecutor aVar2, GlideExecutor aVar3, GlideExecutor aVar4, GlideExecutor aVar5, Jobs rVar, EngineKeyFactory oVar, ActiveResources aVar6, C1685b bVar, C1683a aVar7, ResourceRecycler xVar, boolean z) {
        this.f4637d = gVar;
        C1660a aVar8 = aVar;
        this.f4640g = new C1687c(aVar);
        ActiveResources aVar9 = aVar6 == null ? new ActiveResources(z) : aVar6;
        this.f4642i = aVar9;
        aVar9.mo12691a((C1694a) this);
        this.f4636c = oVar == null ? new EngineKeyFactory() : oVar;
        this.f4635b = rVar == null ? new Jobs() : rVar;
        this.f4638e = bVar == null ? new C1685b(aVar2, aVar3, aVar4, aVar5, this) : bVar;
        this.f4641h = aVar7 == null ? new C1683a(this.f4640g) : aVar7;
        this.f4639f = xVar == null ? new ResourceRecycler() : xVar;
        gVar.mo12798a((C1665a) this);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0041, code lost:
            return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0057, code lost:
            return null;
     */
    /* renamed from: a */
    public synchronized <R> com.bumptech.glide.load.engine.Engine.C1688d mo12860a(com.bumptech.glide.GlideContext r31, java.lang.Object r32, com.bumptech.glide.load.Key r33, int r34, int r35, java.lang.Class<?> r36, java.lang.Class<R> r37, com.bumptech.glide.Priority r38, com.bumptech.glide.load.engine.DiskCacheStrategy r39, java.util.Map<java.lang.Class<?>, com.bumptech.glide.load.Transformation<?>> r40, boolean r41, boolean r42, com.bumptech.glide.load.Options r43, boolean r44, boolean r45, boolean r46, boolean r47, com.bumptech.glide.p131c.ResourceCallback r48, java.util.concurrent.Executor r49) {
        /*
        r30 = this;
        r1 = r30
        r0 = r44
        r8 = r48
        r9 = r49
        monitor-enter(r30)
        boolean r2 = f4634a     // Catch:{ all -> 0x00c5 }
        if (r2 == 0) goto L_0x0012
        long r2 = com.bumptech.glide.util.LogTime.m6125a()     // Catch:{ all -> 0x00c5 }
        goto L_0x0014
    L_0x0012:
        r2 = 0
    L_0x0014:
        r10 = r2
        com.bumptech.glide.load.engine.o r12 = r1.f4636c     // Catch:{ all -> 0x00c5 }
        r13 = r32
        r14 = r33
        r15 = r34
        r16 = r35
        r17 = r40
        r18 = r36
        r19 = r37
        r20 = r43
        com.bumptech.glide.load.engine.n r12 = r12.mo12896a(r13, r14, r15, r16, r17, r18, r19, r20)     // Catch:{ all -> 0x00c5 }
        com.bumptech.glide.load.engine.p r2 = r1.m5677a(r12, r0)     // Catch:{ all -> 0x00c5 }
        r3 = 0
        if (r2 == 0) goto L_0x0042
        com.bumptech.glide.load.DataSource r0 = com.bumptech.glide.load.DataSource.MEMORY_CACHE     // Catch:{ all -> 0x00c5 }
        r8.mo12518a(r2, r0)     // Catch:{ all -> 0x00c5 }
        boolean r0 = f4634a     // Catch:{ all -> 0x00c5 }
        if (r0 == 0) goto L_0x0040
        java.lang.String r0 = "Loaded resource from active resources"
        m5678a(r0, r10, r12)     // Catch:{ all -> 0x00c5 }
    L_0x0040:
        monitor-exit(r30)
        return r3
    L_0x0042:
        com.bumptech.glide.load.engine.p r2 = r1.m5679b(r12, r0)     // Catch:{ all -> 0x00c5 }
        if (r2 == 0) goto L_0x0058
        com.bumptech.glide.load.DataSource r0 = com.bumptech.glide.load.DataSource.MEMORY_CACHE     // Catch:{ all -> 0x00c5 }
        r8.mo12518a(r2, r0)     // Catch:{ all -> 0x00c5 }
        boolean r0 = f4634a     // Catch:{ all -> 0x00c5 }
        if (r0 == 0) goto L_0x0056
        java.lang.String r0 = "Loaded resource from cache"
        m5678a(r0, r10, r12)     // Catch:{ all -> 0x00c5 }
    L_0x0056:
        monitor-exit(r30)
        return r3
    L_0x0058:
        com.bumptech.glide.load.engine.r r2 = r1.f4635b     // Catch:{ all -> 0x00c5 }
        r15 = r47
        com.bumptech.glide.load.engine.l r2 = r2.mo12908a(r12, r15)     // Catch:{ all -> 0x00c5 }
        if (r2 == 0) goto L_0x0075
        r2.mo12873a(r8, r9)     // Catch:{ all -> 0x00c5 }
        boolean r0 = f4634a     // Catch:{ all -> 0x00c5 }
        if (r0 == 0) goto L_0x006e
        java.lang.String r0 = "Added to existing load"
        m5678a(r0, r10, r12)     // Catch:{ all -> 0x00c5 }
    L_0x006e:
        com.bumptech.glide.load.engine.k$d r0 = new com.bumptech.glide.load.engine.k$d     // Catch:{ all -> 0x00c5 }
        r0.m42493init(r8, r2)     // Catch:{ all -> 0x00c5 }
        monitor-exit(r30)
        return r0
    L_0x0075:
        com.bumptech.glide.load.engine.k$b r2 = r1.f4638e     // Catch:{ all -> 0x00c5 }
        r3 = r12
        r4 = r44
        r5 = r45
        r6 = r46
        r7 = r47
        com.bumptech.glide.load.engine.l r0 = r2.mo12867a(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x00c5 }
        com.bumptech.glide.load.engine.k$a r13 = r1.f4641h     // Catch:{ all -> 0x00c5 }
        r14 = r31
        r15 = r32
        r16 = r12
        r17 = r33
        r18 = r34
        r19 = r35
        r20 = r36
        r21 = r37
        r22 = r38
        r23 = r39
        r24 = r40
        r25 = r41
        r26 = r42
        r27 = r47
        r28 = r43
        r29 = r0
        com.bumptech.glide.load.engine.h r2 = r13.mo12865a(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)     // Catch:{ all -> 0x00c5 }
        com.bumptech.glide.load.engine.r r3 = r1.f4635b     // Catch:{ all -> 0x00c5 }
        r3.mo12909a(r12, r0)     // Catch:{ all -> 0x00c5 }
        r0.mo12873a(r8, r9)     // Catch:{ all -> 0x00c5 }
        r0.mo12877b(r2)     // Catch:{ all -> 0x00c5 }
        boolean r2 = f4634a     // Catch:{ all -> 0x00c5 }
        if (r2 == 0) goto L_0x00be
        java.lang.String r2 = "Started new load"
        m5678a(r2, r10, r12)     // Catch:{ all -> 0x00c5 }
    L_0x00be:
        com.bumptech.glide.load.engine.k$d r2 = new com.bumptech.glide.load.engine.k$d     // Catch:{ all -> 0x00c5 }
        r2.m42493init(r8, r0)     // Catch:{ all -> 0x00c5 }
        monitor-exit(r30)
        return r2
    L_0x00c5:
        r0 = move-exception
        monitor-exit(r30)
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.Engine.mo12860a(com.bumptech.glide.g, java.lang.Object, com.bumptech.glide.load.c, int, int, java.lang.Class, java.lang.Class, com.bumptech.glide.Priority, com.bumptech.glide.load.engine.j, java.util.Map, boolean, boolean, com.bumptech.glide.load.f, boolean, boolean, boolean, boolean, com.bumptech.glide.c.g, java.util.concurrent.Executor):com.bumptech.glide.load.engine.k$d");
    }

    /* renamed from: a */
    private static void m5678a(String str, long j, Key cVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(LogTime.m6124a(j));
        sb.append("ms, key: ");
        sb.append(cVar);
        Log.v("Engine", sb.toString());
    }

    /* renamed from: a */
    private EngineResource<?> m5677a(Key cVar, boolean z) {
        if (!z) {
            return null;
        }
        EngineResource<?> b = this.f4642i.mo12692b(cVar);
        if (b != null) {
            b.mo12900c();
        }
        return b;
    }

    /* renamed from: b */
    private EngineResource<?> m5679b(Key cVar, boolean z) {
        if (!z) {
            return null;
        }
        EngineResource<?> a = m5676a(cVar);
        if (a != null) {
            a.mo12900c();
            this.f4642i.mo12689a(cVar, a);
        }
        return a;
    }

    /* renamed from: a */
    private EngineResource<?> m5676a(Key cVar) {
        Resource a = this.f4637d.mo12795a(cVar);
        if (a == null) {
            return null;
        }
        if (a instanceof EngineResource) {
            return (EngineResource) a;
        }
        return new EngineResource(a, true, true);
    }

    /* renamed from: a */
    public void mo12864a(Resource<?> uVar) {
        if (uVar instanceof EngineResource) {
            ((EngineResource) uVar).mo12901d();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    /* renamed from: a */
    public synchronized void mo12863a(EngineJob<?> lVar, Key cVar, EngineResource<?> pVar) {
        if (pVar != null) {
            pVar.mo12898a(cVar, this);
            if (pVar.mo12899b()) {
                this.f4642i.mo12689a(cVar, pVar);
            }
        }
        this.f4635b.mo12910b(cVar, lVar);
    }

    /* renamed from: a */
    public synchronized void mo12862a(EngineJob<?> lVar, Key cVar) {
        this.f4635b.mo12910b(cVar, lVar);
    }

    /* renamed from: b */
    public void mo12802b(Resource<?> uVar) {
        this.f4639f.mo12916a(uVar);
    }

    /* renamed from: a */
    public synchronized void mo12861a(Key cVar, EngineResource<?> pVar) {
        this.f4642i.mo12688a(cVar);
        if (pVar.mo12899b()) {
            this.f4637d.mo12800b(cVar, pVar);
        } else {
            this.f4639f.mo12916a(pVar);
        }
    }
}
