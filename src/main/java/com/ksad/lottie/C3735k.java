package com.ksad.lottie;

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

/* renamed from: com.ksad.lottie.k */
public class C3735k<T> {
    /* renamed from: a */
    public static Executor f12689a = Executors.newCachedThreadPool();
    /* renamed from: b */
    private Thread f12690b;
    /* renamed from: c */
    private final Set<C3732h<T>> f12691c;
    /* renamed from: d */
    private final Set<C3732h<Throwable>> f12692d;
    /* renamed from: e */
    private final Handler f12693e;
    /* access modifiers changed from: private|final */
    /* renamed from: f */
    public final FutureTask<C3734j<T>> f12694f;
    /* access modifiers changed from: private|volatile */
    /* renamed from: g */
    public volatile C3734j<T> f12695g;

    public C3735k(Callable<C3734j<T>> callable) {
        this(callable, false);
    }

    C3735k(Callable<C3734j<T>> callable, boolean z) {
        this.f12691c = new LinkedHashSet(1);
        this.f12692d = new LinkedHashSet(1);
        this.f12693e = new Handler(Looper.getMainLooper());
        this.f12695g = null;
        this.f12694f = new FutureTask<>(callable);
        if (z) {
            try {
                m15494a((C3734j) callable.call());
            } catch (Throwable th) {
                m15494a(new C3734j<>(th));
            }
        } else {
            f12689a.execute(this.f12694f);
            m15501b();
        }
    }

    /* renamed from: a */
    private void m15493a() {
        this.f12693e.post(new Runnable() {
            public void run() {
                if (C3735k.this.f12695g != null && !C3735k.this.f12694f.isCancelled()) {
                    C3734j a = C3735k.this.f12695g;
                    if (a.mo23014a() != null) {
                        C3735k.this.m15498a(a.mo23014a());
                    } else {
                        C3735k.this.m15499a(a.mo23015b());
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15494a(C3734j<T> jVar) {
        if (this.f12695g == null) {
            this.f12695g = jVar;
            m15493a();
            return;
        }
        throw new IllegalStateException("A task may only be set once.");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15498a(T t) {
        for (C3732h a : new ArrayList(this.f12691c)) {
            a.mo22802a(t);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15499a(Throwable th) {
        ArrayList<C3732h> arrayList = new ArrayList<>(this.f12692d);
        if (arrayList.isEmpty()) {
            Log.w("LOTTIE", "Lottie encountered an error but no failure listener was added.", th);
            return;
        }
        for (C3732h a : arrayList) {
            a.mo22802a(th);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0022, code lost:
            return;
     */
    /* renamed from: b */
    private synchronized void m15501b() {
        /*
        r2 = this;
        monitor-enter(r2)
        boolean r0 = r2.m15504d()     // Catch:{ all -> 0x0023 }
        if (r0 != 0) goto L_0x0021
        com.ksad.lottie.j<T> r0 = r2.f12695g     // Catch:{ all -> 0x0023 }
        if (r0 == 0) goto L_0x000c
        goto L_0x0021
    L_0x000c:
        com.ksad.lottie.k$2 r0 = new com.ksad.lottie.k$2     // Catch:{ all -> 0x0023 }
        java.lang.String r1 = "LottieTaskObserver"
        r0.m47486init(r1)     // Catch:{ all -> 0x0023 }
        r2.f12690b = r0     // Catch:{ all -> 0x0023 }
        java.lang.Thread r0 = r2.f12690b     // Catch:{ all -> 0x0023 }
        r0.start()     // Catch:{ all -> 0x0023 }
        java.lang.String r0 = "Starting TaskObserver thread"
        com.ksad.lottie.C3665c.m15250a(r0)     // Catch:{ all -> 0x0023 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.ksad.lottie.C3735k.m15501b():void");
    }

    /* access modifiers changed from: private|declared_synchronized */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0023, code lost:
            return;
     */
    /* renamed from: c */
    public synchronized void m15502c() {
        /*
        r1 = this;
        monitor-enter(r1)
        boolean r0 = r1.m15504d()     // Catch:{ all -> 0x0024 }
        if (r0 != 0) goto L_0x0009
        monitor-exit(r1)
        return
    L_0x0009:
        java.util.Set<com.ksad.lottie.h<T>> r0 = r1.f12691c     // Catch:{ all -> 0x0024 }
        boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0024 }
        if (r0 != 0) goto L_0x0015
        com.ksad.lottie.j<T> r0 = r1.f12695g     // Catch:{ all -> 0x0024 }
        if (r0 == 0) goto L_0x0022
    L_0x0015:
        java.lang.Thread r0 = r1.f12690b     // Catch:{ all -> 0x0024 }
        r0.interrupt()     // Catch:{ all -> 0x0024 }
        r0 = 0
        r1.f12690b = r0     // Catch:{ all -> 0x0024 }
        java.lang.String r0 = "Stopping TaskObserver thread"
        com.ksad.lottie.C3665c.m15250a(r0)     // Catch:{ all -> 0x0024 }
    L_0x0022:
        monitor-exit(r1)
        return
    L_0x0024:
        r0 = move-exception
        monitor-exit(r1)
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ksad.lottie.C3735k.m15502c():void");
    }

    /* renamed from: d */
    private boolean m15504d() {
        Thread thread = this.f12690b;
        return thread != null && thread.isAlive();
    }

    /* renamed from: a */
    public synchronized C3735k<T> mo23018a(C3732h<T> hVar) {
        if (!(this.f12695g == null || this.f12695g.mo23014a() == null)) {
            hVar.mo22802a(this.f12695g.mo23014a());
        }
        this.f12691c.add(hVar);
        m15501b();
        return this;
    }

    /* renamed from: b */
    public synchronized C3735k<T> mo23019b(C3732h<T> hVar) {
        this.f12691c.remove(hVar);
        m15502c();
        return this;
    }

    /* renamed from: c */
    public synchronized C3735k<T> mo23020c(C3732h<Throwable> hVar) {
        if (!(this.f12695g == null || this.f12695g.mo23015b() == null)) {
            hVar.mo22802a(this.f12695g.mo23015b());
        }
        this.f12692d.add(hVar);
        m15501b();
        return this;
    }

    /* renamed from: d */
    public synchronized C3735k<T> mo23021d(C3732h<Throwable> hVar) {
        this.f12692d.remove(hVar);
        m15502c();
        return this;
    }
}
