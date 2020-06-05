package p655io.reactivex.internal.schedulers;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p655io.reactivex.Scheduler;
import p655io.reactivex.Scheduler.C8167c;
import p655io.reactivex.internal.disposables.EmptyDisposable;
import p655io.reactivex.p662b.CompositeDisposable;
import p655io.reactivex.p662b.Disposable;

/* renamed from: io.reactivex.internal.schedulers.d */
public final class IoScheduler extends Scheduler {
    /* renamed from: b */
    static final RxThreadFactory f27637b;
    /* renamed from: c */
    static final RxThreadFactory f27638c;
    /* renamed from: d */
    static final C8150c f27639d = new C8150c(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
    /* renamed from: g */
    static final C8148a f27640g = new C8148a(0, null, f27637b);
    /* renamed from: h */
    private static final TimeUnit f27641h = TimeUnit.SECONDS;
    /* renamed from: e */
    final ThreadFactory f27642e;
    /* renamed from: f */
    final AtomicReference<C8148a> f27643f;

    /* compiled from: IoScheduler */
    /* renamed from: io.reactivex.internal.schedulers.d$a */
    static final class C8148a implements Runnable {
        /* renamed from: a */
        final CompositeDisposable f27644a;
        /* renamed from: b */
        private final long f27645b;
        /* renamed from: c */
        private final ConcurrentLinkedQueue<C8150c> f27646c;
        /* renamed from: d */
        private final ScheduledExecutorService f27647d;
        /* renamed from: e */
        private final Future<?> f27648e;
        /* renamed from: f */
        private final ThreadFactory f27649f;

        C8148a(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            Future<?> future;
            this.f27645b = timeUnit != null ? timeUnit.toNanos(j) : 0;
            this.f27646c = new ConcurrentLinkedQueue<>();
            this.f27644a = new CompositeDisposable();
            this.f27649f = threadFactory;
            ScheduledExecutorService scheduledExecutorService = null;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, IoScheduler.f27638c);
                long j2 = this.f27645b;
                future = scheduledExecutorService.scheduleWithFixedDelay(this, j2, j2, TimeUnit.NANOSECONDS);
            } else {
                future = null;
            }
            this.f27647d = scheduledExecutorService;
            this.f27648e = future;
        }

        public void run() {
            mo39052b();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C8150c mo39050a() {
            if (this.f27644a.isDisposed()) {
                return IoScheduler.f27639d;
            }
            while (!this.f27646c.isEmpty()) {
                C8150c cVar = (C8150c) this.f27646c.poll();
                if (cVar != null) {
                    return cVar;
                }
            }
            C8150c cVar2 = new C8150c(this.f27649f);
            this.f27644a.mo38830a((Disposable) cVar2);
            return cVar2;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo39051a(C8150c cVar) {
            cVar.mo39057a(mo39053c() + this.f27645b);
            this.f27646c.offer(cVar);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo39052b() {
            if (!this.f27646c.isEmpty()) {
                long c = mo39053c();
                Iterator it = this.f27646c.iterator();
                while (it.hasNext()) {
                    C8150c cVar = (C8150c) it.next();
                    if (cVar.mo39056a() > c) {
                        return;
                    }
                    if (this.f27646c.remove(cVar)) {
                        this.f27644a.mo38831b(cVar);
                    }
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public long mo39053c() {
            return System.nanoTime();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: d */
        public void mo39054d() {
            this.f27644a.dispose();
            Future<?> future = this.f27648e;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.f27647d;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }
    }

    /* compiled from: IoScheduler */
    /* renamed from: io.reactivex.internal.schedulers.d$b */
    static final class C8149b extends C8167c {
        /* renamed from: a */
        final AtomicBoolean f27650a = new AtomicBoolean();
        /* renamed from: b */
        private final CompositeDisposable f27651b;
        /* renamed from: c */
        private final C8148a f27652c;
        /* renamed from: d */
        private final C8150c f27653d;

        C8149b(C8148a aVar) {
            this.f27652c = aVar;
            this.f27651b = new CompositeDisposable();
            this.f27653d = aVar.mo39050a();
        }

        public void dispose() {
            if (this.f27650a.compareAndSet(false, true)) {
                this.f27651b.dispose();
                this.f27652c.mo39051a(this.f27653d);
            }
        }

        public boolean isDisposed() {
            return this.f27650a.get();
        }

        /* renamed from: a */
        public Disposable mo38823a(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.f27651b.isDisposed()) {
                return EmptyDisposable.INSTANCE;
            }
            return this.f27653d.mo39058a(runnable, j, timeUnit, this.f27651b);
        }
    }

    /* compiled from: IoScheduler */
    /* renamed from: io.reactivex.internal.schedulers.d$c */
    static final class C8150c extends NewThreadWorker {
        /* renamed from: b */
        private long f27654b = 0;

        C8150c(ThreadFactory threadFactory) {
            super(threadFactory);
        }

        /* renamed from: a */
        public long mo39056a() {
            return this.f27654b;
        }

        /* renamed from: a */
        public void mo39057a(long j) {
            this.f27654b = j;
        }
    }

    static {
        f27639d.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        f27637b = new RxThreadFactory("RxCachedThreadScheduler", max);
        f27638c = new RxThreadFactory("RxCachedWorkerPoolEvictor", max);
        f27640g.mo39054d();
    }

    public IoScheduler() {
        this(f27637b);
    }

    public IoScheduler(ThreadFactory threadFactory) {
        this.f27642e = threadFactory;
        this.f27643f = new AtomicReference<>(f27640g);
        mo39042b();
    }

    /* renamed from: b */
    public void mo39042b() {
        C8148a aVar = new C8148a(60, f27641h, this.f27642e);
        if (!this.f27643f.compareAndSet(f27640g, aVar)) {
            aVar.mo39054d();
        }
    }

    /* renamed from: a */
    public C8167c mo38822a() {
        return new C8149b((C8148a) this.f27643f.get());
    }
}
