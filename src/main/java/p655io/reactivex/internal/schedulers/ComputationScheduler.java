package p655io.reactivex.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p655io.reactivex.Scheduler;
import p655io.reactivex.Scheduler.C8167c;
import p655io.reactivex.internal.disposables.EmptyDisposable;
import p655io.reactivex.internal.disposables.ListCompositeDisposable;
import p655io.reactivex.p662b.CompositeDisposable;
import p655io.reactivex.p662b.Disposable;

/* renamed from: io.reactivex.internal.schedulers.b */
public final class ComputationScheduler extends Scheduler {
    /* renamed from: b */
    static final C8146b f27617b = new C8146b(0, f27618c);
    /* renamed from: c */
    static final RxThreadFactory f27618c = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
    /* renamed from: d */
    static final int f27619d = m35120a(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());
    /* renamed from: e */
    static final C8147c f27620e = new C8147c(new RxThreadFactory("RxComputationShutdown"));
    /* renamed from: f */
    final ThreadFactory f27621f;
    /* renamed from: g */
    final AtomicReference<C8146b> f27622g;

    /* compiled from: ComputationScheduler */
    /* renamed from: io.reactivex.internal.schedulers.b$a */
    static final class C8145a extends C8167c {
        /* renamed from: a */
        volatile boolean f27623a;
        /* renamed from: b */
        private final ListCompositeDisposable f27624b = new ListCompositeDisposable();
        /* renamed from: c */
        private final CompositeDisposable f27625c = new CompositeDisposable();
        /* renamed from: d */
        private final ListCompositeDisposable f27626d = new ListCompositeDisposable();
        /* renamed from: e */
        private final C8147c f27627e;

        C8145a(C8147c cVar) {
            this.f27627e = cVar;
            this.f27626d.mo38830a((Disposable) this.f27624b);
            this.f27626d.mo38830a((Disposable) this.f27625c);
        }

        public void dispose() {
            if (!this.f27623a) {
                this.f27623a = true;
                this.f27626d.dispose();
            }
        }

        public boolean isDisposed() {
            return this.f27623a;
        }

        /* renamed from: a */
        public Disposable mo39043a(Runnable runnable) {
            if (this.f27623a) {
                return EmptyDisposable.INSTANCE;
            }
            return this.f27627e.mo39058a(runnable, 0, TimeUnit.MILLISECONDS, this.f27624b);
        }

        /* renamed from: a */
        public Disposable mo38823a(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.f27623a) {
                return EmptyDisposable.INSTANCE;
            }
            return this.f27627e.mo39058a(runnable, j, timeUnit, this.f27625c);
        }
    }

    /* compiled from: ComputationScheduler */
    /* renamed from: io.reactivex.internal.schedulers.b$b */
    static final class C8146b {
        /* renamed from: a */
        final int f27628a;
        /* renamed from: b */
        final C8147c[] f27629b;
        /* renamed from: c */
        long f27630c;

        C8146b(int i, ThreadFactory threadFactory) {
            this.f27628a = i;
            this.f27629b = new C8147c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.f27629b[i2] = new C8147c(threadFactory);
            }
        }

        /* renamed from: a */
        public C8147c mo39044a() {
            int i = this.f27628a;
            if (i == 0) {
                return ComputationScheduler.f27620e;
            }
            C8147c[] cVarArr = this.f27629b;
            long j = this.f27630c;
            this.f27630c = 1 + j;
            return cVarArr[(int) (j % ((long) i))];
        }

        /* renamed from: b */
        public void mo39045b() {
            for (C8147c dispose : this.f27629b) {
                dispose.dispose();
            }
        }
    }

    /* compiled from: ComputationScheduler */
    /* renamed from: io.reactivex.internal.schedulers.b$c */
    static final class C8147c extends NewThreadWorker {
        C8147c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    /* renamed from: a */
    static int m35120a(int i, int i2) {
        return (i2 <= 0 || i2 > i) ? i : i2;
    }

    static {
        f27620e.dispose();
        f27617b.mo39045b();
    }

    public ComputationScheduler() {
        this(f27618c);
    }

    public ComputationScheduler(ThreadFactory threadFactory) {
        this.f27621f = threadFactory;
        this.f27622g = new AtomicReference<>(f27617b);
        mo39042b();
    }

    /* renamed from: a */
    public C8167c mo38822a() {
        return new C8145a(((C8146b) this.f27622g.get()).mo39044a());
    }

    /* renamed from: a */
    public Disposable mo38821a(Runnable runnable, long j, TimeUnit timeUnit) {
        return ((C8146b) this.f27622g.get()).mo39044a().mo39060b(runnable, j, timeUnit);
    }

    /* renamed from: a */
    public Disposable mo39041a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return ((C8146b) this.f27622g.get()).mo39044a().mo39059b(runnable, j, j2, timeUnit);
    }

    /* renamed from: b */
    public void mo39042b() {
        C8146b bVar = new C8146b(f27619d, this.f27621f);
        if (!this.f27622g.compareAndSet(f27617b, bVar)) {
            bVar.mo39045b();
        }
    }
}
