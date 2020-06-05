package p655io.reactivex.internal.operators.observable;

import p655io.reactivex.ObservableSource;
import p655io.reactivex.Observer;
import p655io.reactivex.internal.disposables.DisposableHelper;
import p655io.reactivex.p662b.Disposable;

/* renamed from: io.reactivex.internal.operators.observable.t */
public final class ObservableSkip<T> extends AbstractObservableWithUpstream<T, T> {
    /* renamed from: b */
    final long f27587b;

    /* compiled from: ObservableSkip */
    /* renamed from: io.reactivex.internal.operators.observable.t$a */
    static final class C8138a<T> implements Disposable, Observer<T> {
        /* renamed from: a */
        final Observer<? super T> f27588a;
        /* renamed from: b */
        long f27589b;
        /* renamed from: c */
        Disposable f27590c;

        C8138a(Observer<? super T> lVar, long j) {
            this.f27588a = lVar;
            this.f27589b = j;
        }

        public void onSubscribe(Disposable bVar) {
            if (DisposableHelper.validate(this.f27590c, bVar)) {
                this.f27590c = bVar;
                this.f27588a.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            long j = this.f27589b;
            if (j != 0) {
                this.f27589b = j - 1;
            } else {
                this.f27588a.onNext(t);
            }
        }

        public void onError(Throwable th) {
            this.f27588a.onError(th);
        }

        public void onComplete() {
            this.f27588a.onComplete();
        }

        public void dispose() {
            this.f27590c.dispose();
        }

        public boolean isDisposed() {
            return this.f27590c.isDisposed();
        }
    }

    public ObservableSkip(ObservableSource<T> kVar, long j) {
        super(kVar);
        this.f27587b = j;
    }

    /* renamed from: a */
    public void mo19781a(Observer<? super T> lVar) {
        this.f27515a.subscribe(new C8138a(lVar, this.f27587b));
    }
}
