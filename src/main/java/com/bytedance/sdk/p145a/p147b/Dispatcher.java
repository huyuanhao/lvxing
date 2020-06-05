package com.bytedance.sdk.p145a.p147b;

import com.bytedance.sdk.p145a.p147b.p148a.C1876c;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.bytedance.sdk.a.b.q */
public final class Dispatcher {
    /* renamed from: a */
    private int f5945a = 64;
    /* renamed from: b */
    private int f5946b = 5;
    /* renamed from: c */
    private Runnable f5947c;
    /* renamed from: d */
    private ExecutorService f5948d;
    /* renamed from: e */
    private final Deque<C1917a> f5949e = new ArrayDeque();
    /* renamed from: f */
    private final Deque<C1917a> f5950f = new ArrayDeque();
    /* renamed from: g */
    private final Deque<RealCall> f5951g = new ArrayDeque();

    /* renamed from: a */
    public synchronized ExecutorService mo14038a() {
        if (this.f5948d == null) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 60, TimeUnit.SECONDS, new SynchronousQueue(), C1876c.m6959a("OkHttp Dispatcher", false));
            this.f5948d = threadPoolExecutor;
        }
        return this.f5948d;
    }

    /* renamed from: c */
    private void m7488c() {
        if (this.f5950f.size() < this.f5945a && !this.f5949e.isEmpty()) {
            Iterator it = this.f5949e.iterator();
            while (it.hasNext()) {
                C1917a aVar = (C1917a) it.next();
                if (m7487b(aVar) < this.f5946b) {
                    it.remove();
                    this.f5950f.add(aVar);
                    mo14038a().execute(aVar);
                }
                if (this.f5950f.size() >= this.f5945a) {
                    break;
                }
            }
        }
    }

    /* renamed from: b */
    private int m7487b(C1917a aVar) {
        int i = 0;
        for (C1917a b : this.f5950f) {
            if (b.mo13909b().equals(aVar.mo13909b())) {
                i++;
            }
        }
        return i;
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: a */
    public synchronized void mo14040a(RealCall aaVar) {
        this.f5951g.add(aaVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo14039a(C1917a aVar) {
        m7486a(this.f5950f, aVar, true);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo14042b(RealCall aaVar) {
        m7486a(this.f5951g, aaVar, false);
    }

    /* renamed from: a */
    private <T> void m7486a(Deque<T> deque, T t, boolean z) {
        int b;
        Runnable runnable;
        synchronized (this) {
            if (deque.remove(t)) {
                if (z) {
                    m7488c();
                }
                b = mo14041b();
                runnable = this.f5947c;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        if (b == 0 && runnable != null) {
            runnable.run();
        }
    }

    /* renamed from: b */
    public synchronized int mo14041b() {
        return this.f5950f.size() + this.f5951g.size();
    }
}
