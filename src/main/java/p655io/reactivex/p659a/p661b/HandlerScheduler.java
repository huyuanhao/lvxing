package p655io.reactivex.p659a.p661b;

import android.os.Handler;
import android.os.Message;
import java.util.concurrent.TimeUnit;
import p655io.reactivex.Scheduler;
import p655io.reactivex.Scheduler.C8167c;
import p655io.reactivex.p662b.Disposable;
import p655io.reactivex.p662b.Disposables;
import p655io.reactivex.p666f.RxJavaPlugins;

/* renamed from: io.reactivex.a.b.b */
final class HandlerScheduler extends Scheduler {
    /* renamed from: b */
    private final Handler f27400b;
    /* renamed from: c */
    private final boolean f27401c;

    /* compiled from: HandlerScheduler */
    /* renamed from: io.reactivex.a.b.b$a */
    private static final class C8081a extends C8167c {
        /* renamed from: a */
        private final Handler f27402a;
        /* renamed from: b */
        private final boolean f27403b;
        /* renamed from: c */
        private volatile boolean f27404c;

        C8081a(Handler handler, boolean z) {
            this.f27402a = handler;
            this.f27403b = z;
        }

        /* renamed from: a */
        public Disposable mo38823a(Runnable runnable, long j, TimeUnit timeUnit) {
            if (runnable == null) {
                throw new NullPointerException("run == null");
            } else if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            } else if (this.f27404c) {
                return Disposables.m34929a();
            } else {
                C8082b bVar = new C8082b(this.f27402a, RxJavaPlugins.m34957a(runnable));
                Message obtain = Message.obtain(this.f27402a, bVar);
                obtain.obj = this;
                if (this.f27403b) {
                    obtain.setAsynchronous(true);
                }
                this.f27402a.sendMessageDelayed(obtain, timeUnit.toMillis(j));
                if (!this.f27404c) {
                    return bVar;
                }
                this.f27402a.removeCallbacks(bVar);
                return Disposables.m34929a();
            }
        }

        public void dispose() {
            this.f27404c = true;
            this.f27402a.removeCallbacksAndMessages(this);
        }

        public boolean isDisposed() {
            return this.f27404c;
        }
    }

    /* compiled from: HandlerScheduler */
    /* renamed from: io.reactivex.a.b.b$b */
    private static final class C8082b implements Disposable, Runnable {
        /* renamed from: a */
        private final Handler f27405a;
        /* renamed from: b */
        private final Runnable f27406b;
        /* renamed from: c */
        private volatile boolean f27407c;

        C8082b(Handler handler, Runnable runnable) {
            this.f27405a = handler;
            this.f27406b = runnable;
        }

        public void run() {
            try {
                this.f27406b.run();
            } catch (Throwable th) {
                RxJavaPlugins.m34959a(th);
            }
        }

        public void dispose() {
            this.f27405a.removeCallbacks(this);
            this.f27407c = true;
        }

        public boolean isDisposed() {
            return this.f27407c;
        }
    }

    HandlerScheduler(Handler handler, boolean z) {
        this.f27400b = handler;
        this.f27401c = z;
    }

    /* renamed from: a */
    public Disposable mo38821a(Runnable runnable, long j, TimeUnit timeUnit) {
        if (runnable == null) {
            throw new NullPointerException("run == null");
        } else if (timeUnit != null) {
            C8082b bVar = new C8082b(this.f27400b, RxJavaPlugins.m34957a(runnable));
            this.f27400b.postDelayed(bVar, timeUnit.toMillis(j));
            return bVar;
        } else {
            throw new NullPointerException("unit == null");
        }
    }

    /* renamed from: a */
    public C8167c mo38822a() {
        return new C8081a(this.f27400b, this.f27401c);
    }
}
