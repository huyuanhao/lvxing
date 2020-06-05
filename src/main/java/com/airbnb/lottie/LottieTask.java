package com.airbnb.lottie;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* renamed from: com.airbnb.lottie.j */
public class LottieTask<T> {
    /* renamed from: a */
    public Executor f1550a;
    /* renamed from: b */
    private Thread f1551b;
    /* renamed from: c */
    private final Set<LottieListener<T>> f1552c;
    /* renamed from: d */
    private final Set<LottieListener<Throwable>> f1553d;
    /* renamed from: e */
    private final Handler f1554e;
    /* access modifiers changed from: private|final */
    /* renamed from: f */
    public final FutureTask<LottieResult<T>> f1555f;
    /* access modifiers changed from: private|volatile */
    /* renamed from: g */
    public volatile LottieResult<T> f1556g;

    public LottieTask(Callable<LottieResult<T>> callable) {
        this(callable, false);
    }

    LottieTask(Callable<LottieResult<T>> callable, boolean z) {
        this.f1550a = Executors.newCachedThreadPool();
        this.f1552c = new LinkedHashSet(1);
        this.f1553d = new LinkedHashSet(1);
        this.f1554e = new Handler(Looper.getMainLooper());
        this.f1556g = null;
        this.f1555f = new FutureTask<>(callable);
        if (z) {
            try {
                m1500a((LottieResult) callable.call());
            } catch (Throwable th) {
                m1500a(new LottieResult<>(th));
            }
        } else {
            this.f1550a.execute(this.f1555f);
            m1507b();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1500a(LottieResult<T> iVar) {
        if (this.f1556g == null) {
            this.f1556g = iVar;
            m1499a();
            return;
        }
        throw new IllegalStateException("A task may only be set once.");
    }

    /* renamed from: a */
    public synchronized LottieTask<T> mo9999a(LottieListener<T> gVar) {
        if (!(this.f1556g == null || this.f1556g.mo9995a() == null)) {
            gVar.mo9777a(this.f1556g.mo9995a());
        }
        this.f1552c.add(gVar);
        m1507b();
        return this;
    }

    /* renamed from: b */
    public synchronized LottieTask<T> mo10000b(LottieListener<T> gVar) {
        this.f1552c.remove(gVar);
        m1508c();
        return this;
    }

    /* renamed from: c */
    public synchronized LottieTask<T> mo10001c(LottieListener<Throwable> gVar) {
        if (!(this.f1556g == null || this.f1556g.mo9996b() == null)) {
            gVar.mo9777a(this.f1556g.mo9996b());
        }
        this.f1553d.add(gVar);
        m1507b();
        return this;
    }

    /* renamed from: d */
    public synchronized LottieTask<T> mo10002d(LottieListener<T> gVar) {
        this.f1553d.remove(gVar);
        m1508c();
        return this;
    }

    /* renamed from: a */
    private void m1499a() {
        this.f1554e.post(new Runnable() {
            public void run() {
                if (LottieTask.this.f1556g != null && !LottieTask.this.f1555f.isCancelled()) {
                    LottieResult a = LottieTask.this.f1556g;
                    if (a.mo9995a() != null) {
                        LottieTask.this.m1504a(a.mo9995a());
                    } else {
                        LottieTask.this.m1505a(a.mo9996b());
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1504a(T t) {
        for (LottieListener a : new ArrayList(this.f1552c)) {
            a.mo9777a(t);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1505a(Throwable th) {
        ArrayList<LottieListener> arrayList = new ArrayList<>(this.f1553d);
        if (arrayList.isEmpty()) {
            Log.w("LOTTIE", "Lottie encountered an error but no failure listener was added.", th);
            return;
        }
        for (LottieListener a : arrayList) {
            a.mo9777a(th);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0022, code lost:
            return;
     */
    /* renamed from: b */
    private synchronized void m1507b() {
        /*
        r2 = this;
        monitor-enter(r2)
        boolean r0 = r2.m1510d()     // Catch:{ all -> 0x0023 }
        if (r0 != 0) goto L_0x0021
        com.airbnb.lottie.i<T> r0 = r2.f1556g     // Catch:{ all -> 0x0023 }
        if (r0 == 0) goto L_0x000c
        goto L_0x0021
    L_0x000c:
        com.airbnb.lottie.j$2 r0 = new com.airbnb.lottie.j$2     // Catch:{ all -> 0x0023 }
        java.lang.String r1 = "LottieTaskObserver"
        r0.m40981init(r1)     // Catch:{ all -> 0x0023 }
        r2.f1551b = r0     // Catch:{ all -> 0x0023 }
        java.lang.Thread r0 = r2.f1551b     // Catch:{ all -> 0x0023 }
        r0.start()     // Catch:{ all -> 0x0023 }
        java.lang.String r0 = "Starting TaskObserver thread"
        com.airbnb.lottie.L.m1313a(r0)     // Catch:{ all -> 0x0023 }
        monitor-exit(r2)
        return
    L_0x0021:
        monitor-exit(r2)
        return
    L_0x0023:
        r0 = move-exception
        monitor-exit(r2)
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.LottieTask.m1507b():void");
    }

    /* access modifiers changed from: private|declared_synchronized */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0023, code lost:
            return;
     */
    /* renamed from: c */
    public synchronized void m1508c() {
        /*
        r1 = this;
        monitor-enter(r1)
        boolean r0 = r1.m1510d()     // Catch:{ all -> 0x0024 }
        if (r0 != 0) goto L_0x0009
        monitor-exit(r1)
        return
    L_0x0009:
        java.util.Set<com.airbnb.lottie.g<T>> r0 = r1.f1552c     // Catch:{ all -> 0x0024 }
        boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0024 }
        if (r0 != 0) goto L_0x0015
        com.airbnb.lottie.i<T> r0 = r1.f1556g     // Catch:{ all -> 0x0024 }
        if (r0 == 0) goto L_0x0022
    L_0x0015:
        java.lang.Thread r0 = r1.f1551b     // Catch:{ all -> 0x0024 }
        r0.interrupt()     // Catch:{ all -> 0x0024 }
        r0 = 0
        r1.f1551b = r0     // Catch:{ all -> 0x0024 }
        java.lang.String r0 = "Stopping TaskObserver thread"
        com.airbnb.lottie.L.m1313a(r0)     // Catch:{ all -> 0x0024 }
    L_0x0022:
        monitor-exit(r1)
        return
    L_0x0024:
        r0 = move-exception
        monitor-exit(r1)
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.LottieTask.m1508c():void");
    }

    /* renamed from: d */
    private boolean m1510d() {
        Thread thread = this.f1551b;
        return thread != null && thread.isAlive();
    }
}
