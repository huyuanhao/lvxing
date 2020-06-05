package p655io.reactivex.internal.schedulers;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import p655io.reactivex.Scheduler;
import p655io.reactivex.Scheduler.C8167c;
import p655io.reactivex.internal.disposables.EmptyDisposable;
import p655io.reactivex.internal.p669a.ObjectHelper;
import p655io.reactivex.p662b.Disposable;
import p655io.reactivex.p662b.Disposables;
import p655io.reactivex.p666f.RxJavaPlugins;

/* renamed from: io.reactivex.internal.schedulers.i */
public final class TrampolineScheduler extends Scheduler {
    /* renamed from: b */
    private static final TrampolineScheduler f27672b = new TrampolineScheduler();

    /* compiled from: TrampolineScheduler */
    /* renamed from: io.reactivex.internal.schedulers.i$a */
    static final class C8154a implements Runnable {
        /* renamed from: a */
        private final Runnable f27673a;
        /* renamed from: b */
        private final C8156c f27674b;
        /* renamed from: c */
        private final long f27675c;

        C8154a(Runnable runnable, C8156c cVar, long j) {
            this.f27673a = runnable;
            this.f27674b = cVar;
            this.f27675c = j;
        }

        public void run() {
            if (!this.f27674b.f27682c) {
                long a = this.f27674b.mo39157a(TimeUnit.MILLISECONDS);
                long j = this.f27675c;
                if (j > a) {
                    try {
                        Thread.sleep(j - a);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        RxJavaPlugins.m34959a((Throwable) e);
                        return;
                    }
                }
                if (!this.f27674b.f27682c) {
                    this.f27673a.run();
                }
            }
        }
    }

    /* compiled from: TrampolineScheduler */
    /* renamed from: io.reactivex.internal.schedulers.i$b */
    static final class C8155b implements Comparable<C8155b> {
        /* renamed from: a */
        final Runnable f27676a;
        /* renamed from: b */
        final long f27677b;
        /* renamed from: c */
        final int f27678c;
        /* renamed from: d */
        volatile boolean f27679d;

        C8155b(Runnable runnable, Long l, int i) {
            this.f27676a = runnable;
            this.f27677b = l.longValue();
            this.f27678c = i;
        }

        /* renamed from: a */
        public int compareTo(C8155b bVar) {
            int a = ObjectHelper.m35047a(this.f27677b, bVar.f27677b);
            return a == 0 ? ObjectHelper.m35045a(this.f27678c, bVar.f27678c) : a;
        }
    }

    /* compiled from: TrampolineScheduler */
    /* renamed from: io.reactivex.internal.schedulers.i$c */
    static final class C8156c extends C8167c implements Disposable {
        /* renamed from: a */
        final PriorityBlockingQueue<C8155b> f27680a = new PriorityBlockingQueue<>();
        /* renamed from: b */
        final AtomicInteger f27681b = new AtomicInteger();
        /* renamed from: c */
        volatile boolean f27682c;
        /* renamed from: d */
        private final AtomicInteger f27683d = new AtomicInteger();

        /* compiled from: TrampolineScheduler */
        /* renamed from: io.reactivex.internal.schedulers.i$c$a */
        final class C8157a implements Runnable {
            /* renamed from: a */
            final C8155b f27684a;

            C8157a(C8155b bVar) {
                this.f27684a = bVar;
            }

            public void run() {
                this.f27684a.f27679d = true;
                C8156c.this.f27680a.remove(this.f27684a);
            }
        }

        C8156c() {
        }

        /* renamed from: a */
        public Disposable mo39043a(Runnable runnable) {
            return mo39068a(runnable, mo39157a(TimeUnit.MILLISECONDS));
        }

        /* renamed from: a */
        public Disposable mo38823a(Runnable runnable, long j, TimeUnit timeUnit) {
            long a = mo39157a(TimeUnit.MILLISECONDS) + timeUnit.toMillis(j);
            return mo39068a(new C8154a(runnable, this, a), a);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public Disposable mo39068a(Runnable runnable, long j) {
            if (this.f27682c) {
                return EmptyDisposable.INSTANCE;
            }
            C8155b bVar = new C8155b(runnable, Long.valueOf(j), this.f27681b.incrementAndGet());
            this.f27680a.add(bVar);
            if (this.f27683d.getAndIncrement() != 0) {
                return Disposables.m34930a(new C8157a(bVar));
            }
            int i = 1;
            while (!this.f27682c) {
                C8155b bVar2 = (C8155b) this.f27680a.poll();
                if (bVar2 == null) {
                    i = this.f27683d.addAndGet(-i);
                    if (i == 0) {
                        return EmptyDisposable.INSTANCE;
                    }
                } else if (!bVar2.f27679d) {
                    bVar2.f27676a.run();
                }
            }
            this.f27680a.clear();
            return EmptyDisposable.INSTANCE;
        }

        public void dispose() {
            this.f27682c = true;
        }

        public boolean isDisposed() {
            return this.f27682c;
        }
    }

    /* renamed from: c */
    public static TrampolineScheduler m35160c() {
        return f27672b;
    }

    /* renamed from: a */
    public C8167c mo38822a() {
        return new C8156c();
    }

    TrampolineScheduler() {
    }

    /* renamed from: a */
    public Disposable mo39064a(Runnable runnable) {
        RxJavaPlugins.m34957a(runnable).run();
        return EmptyDisposable.INSTANCE;
    }

    /* renamed from: a */
    public Disposable mo38821a(Runnable runnable, long j, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j);
            RxJavaPlugins.m34957a(runnable).run();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            RxJavaPlugins.m34959a((Throwable) e);
        }
        return EmptyDisposable.INSTANCE;
    }
}
