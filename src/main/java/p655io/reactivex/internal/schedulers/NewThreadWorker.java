package p655io.reactivex.internal.schedulers;

import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import p655io.reactivex.Scheduler.C8167c;
import p655io.reactivex.internal.disposables.DisposableContainer;
import p655io.reactivex.internal.disposables.EmptyDisposable;
import p655io.reactivex.p662b.Disposable;
import p655io.reactivex.p666f.RxJavaPlugins;

/* renamed from: io.reactivex.internal.schedulers.f */
public class NewThreadWorker extends C8167c implements Disposable {
    /* renamed from: a */
    volatile boolean f27657a;
    /* renamed from: b */
    private final ScheduledExecutorService f27658b;

    public NewThreadWorker(ThreadFactory threadFactory) {
        this.f27658b = SchedulerPoolFactory.m35149a(threadFactory);
    }

    /* renamed from: a */
    public Disposable mo39043a(Runnable runnable) {
        return mo38823a(runnable, 0, null);
    }

    /* renamed from: a */
    public Disposable mo38823a(Runnable runnable, long j, TimeUnit timeUnit) {
        if (this.f27657a) {
            return EmptyDisposable.INSTANCE;
        }
        return mo39058a(runnable, j, timeUnit, null);
    }

    /* renamed from: b */
    public Disposable mo39060b(Runnable runnable, long j, TimeUnit timeUnit) {
        Future future;
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(RxJavaPlugins.m34957a(runnable));
        if (j <= 0) {
            try {
                future = this.f27658b.submit(scheduledDirectTask);
            } catch (RejectedExecutionException e) {
                RxJavaPlugins.m34959a((Throwable) e);
                return EmptyDisposable.INSTANCE;
            }
        } else {
            future = this.f27658b.schedule(scheduledDirectTask, j, timeUnit);
        }
        scheduledDirectTask.setFuture(future);
        return scheduledDirectTask;
    }

    /* renamed from: b */
    public Disposable mo39059b(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        Future future;
        Runnable a = RxJavaPlugins.m34957a(runnable);
        if (j2 <= 0) {
            InstantPeriodicTask cVar = new InstantPeriodicTask(a, this.f27658b);
            if (j <= 0) {
                try {
                    future = this.f27658b.submit(cVar);
                } catch (RejectedExecutionException e) {
                    RxJavaPlugins.m34959a((Throwable) e);
                    return EmptyDisposable.INSTANCE;
                }
            } else {
                future = this.f27658b.schedule(cVar, j, timeUnit);
            }
            cVar.mo39047a(future);
            return cVar;
        }
        ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(a);
        try {
            scheduledDirectPeriodicTask.setFuture(this.f27658b.scheduleAtFixedRate(scheduledDirectPeriodicTask, j, j2, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (RejectedExecutionException e2) {
            RxJavaPlugins.m34959a((Throwable) e2);
            return EmptyDisposable.INSTANCE;
        }
    }

    /* renamed from: a */
    public ScheduledRunnable mo39058a(Runnable runnable, long j, TimeUnit timeUnit, DisposableContainer aVar) {
        Future future;
        ScheduledRunnable scheduledRunnable = new ScheduledRunnable(RxJavaPlugins.m34957a(runnable), aVar);
        if (aVar != null && !aVar.mo38830a(scheduledRunnable)) {
            return scheduledRunnable;
        }
        if (j <= 0) {
            try {
                future = this.f27658b.submit(scheduledRunnable);
            } catch (RejectedExecutionException e) {
                if (aVar != null) {
                    aVar.mo38831b(scheduledRunnable);
                }
                RxJavaPlugins.m34959a((Throwable) e);
            }
        } else {
            future = this.f27658b.schedule(scheduledRunnable, j, timeUnit);
        }
        scheduledRunnable.setFuture(future);
        return scheduledRunnable;
    }

    public void dispose() {
        if (!this.f27657a) {
            this.f27657a = true;
            this.f27658b.shutdownNow();
        }
    }

    /* renamed from: b */
    public void mo39061b() {
        if (!this.f27657a) {
            this.f27657a = true;
            this.f27658b.shutdown();
        }
    }

    public boolean isDisposed() {
        return this.f27657a;
    }
}
