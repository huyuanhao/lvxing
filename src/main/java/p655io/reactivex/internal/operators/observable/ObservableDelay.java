package p655io.reactivex.internal.operators.observable;

import java.util.concurrent.TimeUnit;
import p655io.reactivex.ObservableSource;
import p655io.reactivex.Observer;
import p655io.reactivex.Scheduler;
import p655io.reactivex.Scheduler.C8167c;
import p655io.reactivex.internal.disposables.DisposableHelper;
import p655io.reactivex.observers.SerializedObserver;
import p655io.reactivex.p662b.Disposable;

/* renamed from: io.reactivex.internal.operators.observable.b */
public final class ObservableDelay<T> extends AbstractObservableWithUpstream<T, T> {
    /* renamed from: b */
    final long f27516b;
    /* renamed from: c */
    final TimeUnit f27517c;
    /* renamed from: d */
    final Scheduler f27518d;
    /* renamed from: e */
    final boolean f27519e;

    /* compiled from: ObservableDelay */
    /* renamed from: io.reactivex.internal.operators.observable.b$a */
    static final class C8122a<T> implements Disposable, Observer<T> {
        /* renamed from: a */
        final Observer<? super T> f27520a;
        /* renamed from: b */
        final long f27521b;
        /* renamed from: c */
        final TimeUnit f27522c;
        /* renamed from: d */
        final C8167c f27523d;
        /* renamed from: e */
        final boolean f27524e;
        /* renamed from: f */
        Disposable f27525f;

        /* compiled from: ObservableDelay */
        /* renamed from: io.reactivex.internal.operators.observable.b$a$a */
        final class C8123a implements Runnable {
            C8123a() {
            }

            public void run() {
                try {
                    C8122a.this.f27520a.onComplete();
                } finally {
                    C8122a.this.f27523d.dispose();
                }
            }
        }

        /* compiled from: ObservableDelay */
        /* renamed from: io.reactivex.internal.operators.observable.b$a$b */
        final class C8124b implements Runnable {
            /* renamed from: b */
            private final Throwable f27528b;

            C8124b(Throwable th) {
                this.f27528b = th;
            }

            public void run() {
                try {
                    C8122a.this.f27520a.onError(this.f27528b);
                } finally {
                    C8122a.this.f27523d.dispose();
                }
            }
        }

        /* compiled from: ObservableDelay */
        /* renamed from: io.reactivex.internal.operators.observable.b$a$c */
        final class C8125c implements Runnable {
            /* renamed from: b */
            private final T f27530b;

            C8125c(T t) {
                this.f27530b = t;
            }

            public void run() {
                C8122a.this.f27520a.onNext(this.f27530b);
            }
        }

        C8122a(Observer<? super T> lVar, long j, TimeUnit timeUnit, C8167c cVar, boolean z) {
            this.f27520a = lVar;
            this.f27521b = j;
            this.f27522c = timeUnit;
            this.f27523d = cVar;
            this.f27524e = z;
        }

        public void onSubscribe(Disposable bVar) {
            if (DisposableHelper.validate(this.f27525f, bVar)) {
                this.f27525f = bVar;
                this.f27520a.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            this.f27523d.mo38823a(new C8125c(t), this.f27521b, this.f27522c);
        }

        public void onError(Throwable th) {
            this.f27523d.mo38823a(new C8124b(th), this.f27524e ? this.f27521b : 0, this.f27522c);
        }

        public void onComplete() {
            this.f27523d.mo38823a(new C8123a(), this.f27521b, this.f27522c);
        }

        public void dispose() {
            this.f27525f.dispose();
            this.f27523d.dispose();
        }

        public boolean isDisposed() {
            return this.f27523d.isDisposed();
        }
    }

    public ObservableDelay(ObservableSource<T> kVar, long j, TimeUnit timeUnit, Scheduler mVar, boolean z) {
        super(kVar);
        this.f27516b = j;
        this.f27517c = timeUnit;
        this.f27518d = mVar;
        this.f27519e = z;
    }

    /* renamed from: a */
    public void mo19781a(Observer<? super T> lVar) {
        Observer<? super T> lVar2;
        if (this.f27519e) {
            lVar2 = lVar;
        } else {
            lVar2 = new SerializedObserver<>(lVar);
        }
        C8167c a = this.f27518d.mo38822a();
        ObservableSource kVar = this.f27515a;
        C8122a aVar = new C8122a(lVar2, this.f27516b, this.f27517c, a, this.f27519e);
        kVar.subscribe(aVar);
    }
}
