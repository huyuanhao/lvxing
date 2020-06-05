package com.bumptech.glide.load.engine;

import android.os.Process;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* renamed from: com.bumptech.glide.load.engine.a */
final class ActiveResources {
    /* renamed from: a */
    final Map<Key, C1637b> f4435a;
    /* renamed from: b */
    private final boolean f4436b;
    /* renamed from: c */
    private final Executor f4437c;
    /* renamed from: d */
    private final ReferenceQueue<EngineResource<?>> f4438d;
    /* renamed from: e */
    private C1694a f4439e;
    /* renamed from: f */
    private volatile boolean f4440f;
    /* renamed from: g */
    private volatile C1636a f4441g;

    /* compiled from: ActiveResources */
    /* renamed from: com.bumptech.glide.load.engine.a$a */
    interface C1636a {
        /* renamed from: a */
        void mo12696a();
    }

    /* compiled from: ActiveResources */
    /* renamed from: com.bumptech.glide.load.engine.a$b */
    static final class C1637b extends WeakReference<EngineResource<?>> {
        /* renamed from: a */
        final Key f4445a;
        /* renamed from: b */
        final boolean f4446b;
        /* renamed from: c */
        Resource<?> f4447c;

        C1637b(Key cVar, EngineResource<?> pVar, ReferenceQueue<? super EngineResource<?>> referenceQueue, boolean z) {
            super(pVar, referenceQueue);
            this.f4445a = (Key) Preconditions.m6138a(cVar);
            Resource<?> uVar = (!pVar.mo12899b() || !z) ? null : (Resource) Preconditions.m6138a(pVar.mo12897a());
            this.f4447c = uVar;
            this.f4446b = pVar.mo12899b();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo12697a() {
            this.f4447c = null;
            clear();
        }
    }

    ActiveResources(boolean z) {
        this(z, Executors.newSingleThreadExecutor(new ThreadFactory() {
            public Thread newThread(final Runnable runnable) {
                return new Thread(new Runnable() {
                    public void run() {
                        Process.setThreadPriority(10);
                        runnable.run();
                    }
                }, "glide-active-resources");
            }
        }));
    }

    ActiveResources(boolean z, Executor executor) {
        this.f4435a = new HashMap();
        this.f4438d = new ReferenceQueue<>();
        this.f4436b = z;
        this.f4437c = executor;
        executor.execute(new Runnable() {
            public void run() {
                ActiveResources.this.mo12687a();
            }
        });
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo12691a(C1694a aVar) {
        synchronized (aVar) {
            synchronized (this) {
                this.f4439e = aVar;
            }
        }
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: a */
    public synchronized void mo12689a(Key cVar, EngineResource<?> pVar) {
        C1637b bVar = (C1637b) this.f4435a.put(cVar, new C1637b(cVar, pVar, this.f4438d, this.f4436b));
        if (bVar != null) {
            bVar.mo12697a();
        }
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: a */
    public synchronized void mo12688a(Key cVar) {
        C1637b bVar = (C1637b) this.f4435a.remove(cVar);
        if (bVar != null) {
            bVar.mo12697a();
        }
    }

    /* access modifiers changed from: declared_synchronized */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001a, code lost:
            return r0;
     */
    /* renamed from: b */
    public synchronized com.bumptech.glide.load.engine.EngineResource<?> mo12692b(com.bumptech.glide.load.Key r2) {
        /*
        r1 = this;
        monitor-enter(r1)
        java.util.Map<com.bumptech.glide.load.c, com.bumptech.glide.load.engine.a$b> r0 = r1.f4435a     // Catch:{ all -> 0x001b }
        java.lang.Object r2 = r0.get(r2)     // Catch:{ all -> 0x001b }
        com.bumptech.glide.load.engine.a$b r2 = (com.bumptech.glide.load.engine.ActiveResources.C1637b) r2     // Catch:{ all -> 0x001b }
        if (r2 != 0) goto L_0x000e
        r2 = 0
        monitor-exit(r1)
        return r2
    L_0x000e:
        java.lang.Object r0 = r2.get()     // Catch:{ all -> 0x001b }
        com.bumptech.glide.load.engine.p r0 = (com.bumptech.glide.load.engine.EngineResource) r0     // Catch:{ all -> 0x001b }
        if (r0 != 0) goto L_0x0019
        r1.mo12690a(r2)     // Catch:{ all -> 0x001b }
    L_0x0019:
        monitor-exit(r1)
        return r0
    L_0x001b:
        r2 = move-exception
        monitor-exit(r1)
        throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.ActiveResources.mo12692b(com.bumptech.glide.load.c):com.bumptech.glide.load.engine.p");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo12690a(C1637b bVar) {
        synchronized (this.f4439e) {
            synchronized (this) {
                this.f4435a.remove(bVar.f4445a);
                if (bVar.f4446b) {
                    if (bVar.f4447c != null) {
                        EngineResource pVar = new EngineResource(bVar.f4447c, true, false);
                        pVar.mo12898a(bVar.f4445a, this.f4439e);
                        this.f4439e.mo12861a(bVar.f4445a, pVar);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo12687a() {
        while (!this.f4440f) {
            try {
                mo12690a((C1637b) this.f4438d.remove());
                C1636a aVar = this.f4441g;
                if (aVar != null) {
                    aVar.mo12696a();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
