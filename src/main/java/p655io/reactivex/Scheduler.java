package p655io.reactivex;

import java.util.concurrent.TimeUnit;
import p655io.reactivex.exceptions.Exceptions;
import p655io.reactivex.internal.disposables.EmptyDisposable;
import p655io.reactivex.internal.disposables.SequentialDisposable;
import p655io.reactivex.internal.schedulers.NewThreadWorker;
import p655io.reactivex.internal.util.C8162d;
import p655io.reactivex.p662b.Disposable;
import p655io.reactivex.p666f.RxJavaPlugins;

/* renamed from: io.reactivex.m */
public abstract class Scheduler {
    /* renamed from: a */
    static final long f27697a = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    /* compiled from: Scheduler */
    /* renamed from: io.reactivex.m$a */
    static final class C8165a implements Disposable, Runnable {
        /* renamed from: a */
        final Runnable f27698a;
        /* renamed from: b */
        final C8167c f27699b;
        /* renamed from: c */
        Thread f27700c;

        C8165a(Runnable runnable, C8167c cVar) {
            this.f27698a = runnable;
            this.f27699b = cVar;
        }

        public void run() {
            this.f27700c = Thread.currentThread();
            try {
                this.f27698a.run();
            } finally {
                dispose();
                this.f27700c = null;
            }
        }

        public void dispose() {
            if (this.f27700c == Thread.currentThread()) {
                C8167c cVar = this.f27699b;
                if (cVar instanceof NewThreadWorker) {
                    ((NewThreadWorker) cVar).mo39061b();
                    return;
                }
            }
            this.f27699b.dispose();
        }

        public boolean isDisposed() {
            return this.f27699b.isDisposed();
        }
    }

    /* compiled from: Scheduler */
    /* renamed from: io.reactivex.m$b */
    static final class C8166b implements Disposable, Runnable {
        /* renamed from: a */
        final Runnable f27701a;
        /* renamed from: b */
        final C8167c f27702b;
        /* renamed from: c */
        volatile boolean f27703c;

        C8166b(Runnable runnable, C8167c cVar) {
            this.f27701a = runnable;
            this.f27702b = cVar;
        }

        public void run() {
            if (!this.f27703c) {
                try {
                    this.f27701a.run();
                } catch (Throwable th) {
                    Exceptions.m34944b(th);
                    this.f27702b.dispose();
                    throw C8162d.m35182a(th);
                }
            }
        }

        public void dispose() {
            this.f27703c = true;
            this.f27702b.dispose();
        }

        public boolean isDisposed() {
            return this.f27703c;
        }
    }

    /* compiled from: Scheduler */
    /* renamed from: io.reactivex.m$c */
    public static abstract class C8167c implements Disposable {

        /* compiled from: Scheduler */
        /* renamed from: io.reactivex.m$c$a */
        final class C8168a implements Runnable {
            /* renamed from: a */
            final Runnable f27704a;
            /* renamed from: b */
            final SequentialDisposable f27705b;
            /* renamed from: c */
            final long f27706c;
            /* renamed from: d */
            long f27707d;
            /* renamed from: e */
            long f27708e;
            /* renamed from: f */
            long f27709f;

            C8168a(long j, Runnable runnable, long j2, SequentialDisposable sequentialDisposable, long j3) {
                this.f27704a = runnable;
                this.f27705b = sequentialDisposable;
                this.f27706c = j3;
                this.f27708e = j2;
                this.f27709f = j;
            }

            public void run() {
                long j;
                this.f27704a.run();
                if (!this.f27705b.isDisposed()) {
                    long a = C8167c.this.mo39157a(TimeUnit.NANOSECONDS);
                    long j2 = Scheduler.f27697a + a;
                    long j3 = this.f27708e;
                    if (j2 < j3 || a >= j3 + this.f27706c + Scheduler.f27697a) {
                        long j4 = this.f27706c;
                        long j5 = a + j4;
                        long j6 = this.f27707d + 1;
                        this.f27707d = j6;
                        this.f27709f = j5 - (j4 * j6);
                        j = j5;
                    } else {
                        long j7 = this.f27709f;
                        long j8 = this.f27707d + 1;
                        this.f27707d = j8;
                        j = j7 + (j8 * this.f27706c);
                    }
                    this.f27708e = a;
                    this.f27705b.replace(C8167c.this.mo38823a(this, j - a, TimeUnit.NANOSECONDS));
                }
            }
        }

        /* renamed from: a */
        public abstract Disposable mo38823a(Runnable runnable, long j, TimeUnit timeUnit);

        /* renamed from: a */
        public Disposable mo39043a(Runnable runnable) {
            return mo38823a(runnable, 0, TimeUnit.NANOSECONDS);
        }

        /* renamed from: a */
        public Disposable mo39158a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            long j3 = j;
            TimeUnit timeUnit2 = timeUnit;
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            Runnable a = RxJavaPlugins.m34957a(runnable);
            long nanos = timeUnit2.toNanos(j2);
            long a2 = mo39157a(TimeUnit.NANOSECONDS);
            SequentialDisposable sequentialDisposable3 = sequentialDisposable;
            C8168a aVar = r0;
            C8168a aVar2 = new C8168a(a2 + timeUnit2.toNanos(j3), a, a2, sequentialDisposable2, nanos);
            Disposable a3 = mo38823a(aVar, j3, timeUnit2);
            if (a3 == EmptyDisposable.INSTANCE) {
                return a3;
            }
            sequentialDisposable3.replace(a3);
            return sequentialDisposable2;
        }

        /* renamed from: a */
        public long mo39157a(TimeUnit timeUnit) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }
    }

    /* renamed from: a */
    public abstract C8167c mo38822a();

    /* renamed from: b */
    public void mo39042b() {
    }

    /* renamed from: a */
    public Disposable mo39064a(Runnable runnable) {
        return mo38821a(runnable, 0, TimeUnit.NANOSECONDS);
    }

    /* renamed from: a */
    public Disposable mo38821a(Runnable runnable, long j, TimeUnit timeUnit) {
        C8167c a = mo38822a();
        C8165a aVar = new C8165a(RxJavaPlugins.m34957a(runnable), a);
        a.mo38823a(aVar, j, timeUnit);
        return aVar;
    }

    /* renamed from: a */
    public Disposable mo39041a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        C8167c a = mo38822a();
        C8166b bVar = new C8166b(RxJavaPlugins.m34957a(runnable), a);
        Disposable a2 = a.mo39158a(bVar, j, j2, timeUnit);
        return a2 == EmptyDisposable.INSTANCE ? a2 : bVar;
    }
}
