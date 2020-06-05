package p655io.reactivex.internal.schedulers;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;
import p655io.reactivex.internal.p669a.Functions;
import p655io.reactivex.p662b.Disposable;
import p655io.reactivex.p666f.RxJavaPlugins;

/* renamed from: io.reactivex.internal.schedulers.c */
final class InstantPeriodicTask implements Disposable, Callable<Void> {
    /* renamed from: f */
    static final FutureTask<Void> f27631f = new FutureTask<>(Functions.f27469b, null);
    /* renamed from: a */
    final Runnable f27632a;
    /* renamed from: b */
    final AtomicReference<Future<?>> f27633b = new AtomicReference<>();
    /* renamed from: c */
    final AtomicReference<Future<?>> f27634c = new AtomicReference<>();
    /* renamed from: d */
    final ExecutorService f27635d;
    /* renamed from: e */
    Thread f27636e;

    InstantPeriodicTask(Runnable runnable, ExecutorService executorService) {
        this.f27632a = runnable;
        this.f27635d = executorService;
    }

    /* renamed from: a */
    public Void call() throws Exception {
        this.f27636e = Thread.currentThread();
        try {
            this.f27632a.run();
            mo39048b(this.f27635d.submit(this));
            this.f27636e = null;
        } catch (Throwable th) {
            this.f27636e = null;
            RxJavaPlugins.m34959a(th);
        }
        return null;
    }

    public void dispose() {
        Future future = (Future) this.f27634c.getAndSet(f27631f);
        boolean z = true;
        if (!(future == null || future == f27631f)) {
            future.cancel(this.f27636e != Thread.currentThread());
        }
        Future future2 = (Future) this.f27633b.getAndSet(f27631f);
        if (future2 != null && future2 != f27631f) {
            if (this.f27636e == Thread.currentThread()) {
                z = false;
            }
            future2.cancel(z);
        }
    }

    public boolean isDisposed() {
        return this.f27634c.get() == f27631f;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo39047a(Future<?> future) {
        Future future2;
        do {
            future2 = (Future) this.f27634c.get();
            if (future2 == f27631f) {
                future.cancel(this.f27636e != Thread.currentThread());
                return;
            }
        } while (!this.f27634c.compareAndSet(future2, future));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo39048b(Future<?> future) {
        Future future2;
        do {
            future2 = (Future) this.f27633b.get();
            if (future2 == f27631f) {
                future.cancel(this.f27636e != Thread.currentThread());
                return;
            }
        } while (!this.f27633b.compareAndSet(future2, future));
    }
}
