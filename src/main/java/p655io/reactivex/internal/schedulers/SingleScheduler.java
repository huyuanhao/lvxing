package p655io.reactivex.internal.schedulers;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p655io.reactivex.Scheduler;
import p655io.reactivex.Scheduler.C8167c;
import p655io.reactivex.internal.disposables.EmptyDisposable;
import p655io.reactivex.p662b.CompositeDisposable;
import p655io.reactivex.p662b.Disposable;
import p655io.reactivex.p666f.RxJavaPlugins;

/* renamed from: io.reactivex.internal.schedulers.h */
public final class SingleScheduler extends Scheduler {
    /* renamed from: d */
    static final RxThreadFactory f27665d = new RxThreadFactory("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue())), true);
    /* renamed from: e */
    static final ScheduledExecutorService f27666e = Executors.newScheduledThreadPool(0);
    /* renamed from: b */
    final ThreadFactory f27667b;
    /* renamed from: c */
    final AtomicReference<ScheduledExecutorService> f27668c;

    /* compiled from: SingleScheduler */
    /* renamed from: io.reactivex.internal.schedulers.h$a */
    static final class C8153a extends C8167c {
        /* renamed from: a */
        final ScheduledExecutorService f27669a;
        /* renamed from: b */
        final CompositeDisposable f27670b = new CompositeDisposable();
        /* renamed from: c */
        volatile boolean f27671c;

        C8153a(ScheduledExecutorService scheduledExecutorService) {
            this.f27669a = scheduledExecutorService;
        }

        /* renamed from: a */
        public Disposable mo38823a(Runnable runnable, long j, TimeUnit timeUnit) {
            Future future;
            if (this.f27671c) {
                return EmptyDisposable.INSTANCE;
            }
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(RxJavaPlugins.m34957a(runnable), this.f27670b);
            this.f27670b.mo38830a((Disposable) scheduledRunnable);
            if (j <= 0) {
                try {
                    future = this.f27669a.submit(scheduledRunnable);
                } catch (RejectedExecutionException e) {
                    dispose();
                    RxJavaPlugins.m34959a((Throwable) e);
                    return EmptyDisposable.INSTANCE;
                }
            } else {
                future = this.f27669a.schedule(scheduledRunnable, j, timeUnit);
            }
            scheduledRunnable.setFuture(future);
            return scheduledRunnable;
        }

        public void dispose() {
            if (!this.f27671c) {
                this.f27671c = true;
                this.f27670b.dispose();
            }
        }

        public boolean isDisposed() {
            return this.f27671c;
        }
    }

    static {
        f27666e.shutdown();
    }

    public SingleScheduler() {
        this(f27665d);
    }

    public SingleScheduler(ThreadFactory threadFactory) {
        this.f27668c = new AtomicReference<>();
        this.f27667b = threadFactory;
        this.f27668c.lazySet(m35154a(threadFactory));
    }

    /* renamed from: a */
    static ScheduledExecutorService m35154a(ThreadFactory threadFactory) {
        return SchedulerPoolFactory.m35149a(threadFactory);
    }

    /* renamed from: b */
    public void mo39042b() {
        ScheduledExecutorService scheduledExecutorService;
        ScheduledExecutorService scheduledExecutorService2 = null;
        do {
            scheduledExecutorService = (ScheduledExecutorService) this.f27668c.get();
            if (scheduledExecutorService != f27666e) {
                if (scheduledExecutorService2 != null) {
                    scheduledExecutorService2.shutdown();
                }
                return;
            } else if (scheduledExecutorService2 == null) {
                scheduledExecutorService2 = m35154a(this.f27667b);
            }
        } while (!this.f27668c.compareAndSet(scheduledExecutorService, scheduledExecutorService2));
    }

    /* renamed from: a */
    public C8167c mo38822a() {
        return new C8153a((ScheduledExecutorService) this.f27668c.get());
    }

    /* renamed from: a */
    public Disposable mo38821a(Runnable runnable, long j, TimeUnit timeUnit) {
        Future future;
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(RxJavaPlugins.m34957a(runnable));
        if (j <= 0) {
            try {
                future = ((ScheduledExecutorService) this.f27668c.get()).submit(scheduledDirectTask);
            } catch (RejectedExecutionException e) {
                RxJavaPlugins.m34959a((Throwable) e);
                return EmptyDisposable.INSTANCE;
            }
        } else {
            future = ((ScheduledExecutorService) this.f27668c.get()).schedule(scheduledDirectTask, j, timeUnit);
        }
        scheduledDirectTask.setFuture(future);
        return scheduledDirectTask;
    }

    /* renamed from: a */
    public Disposable mo39041a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        Future future;
        Runnable a = RxJavaPlugins.m34957a(runnable);
        if (j2 <= 0) {
            ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.f27668c.get();
            InstantPeriodicTask cVar = new InstantPeriodicTask(a, scheduledExecutorService);
            if (j <= 0) {
                try {
                    future = scheduledExecutorService.submit(cVar);
                } catch (RejectedExecutionException e) {
                    RxJavaPlugins.m34959a((Throwable) e);
                    return EmptyDisposable.INSTANCE;
                }
            } else {
                future = scheduledExecutorService.schedule(cVar, j, timeUnit);
            }
            cVar.mo39047a(future);
            return cVar;
        }
        ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(a);
        try {
            scheduledDirectPeriodicTask.setFuture(((ScheduledExecutorService) this.f27668c.get()).scheduleAtFixedRate(scheduledDirectPeriodicTask, j, j2, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (RejectedExecutionException e2) {
            RxJavaPlugins.m34959a((Throwable) e2);
            return EmptyDisposable.INSTANCE;
        }
    }
}
