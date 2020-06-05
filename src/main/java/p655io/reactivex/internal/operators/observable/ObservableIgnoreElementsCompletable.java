package p655io.reactivex.internal.operators.observable;

import p655io.reactivex.Completable;
import p655io.reactivex.CompletableObserver;
import p655io.reactivex.ObservableSource;
import p655io.reactivex.Observer;
import p655io.reactivex.p662b.Disposable;

/* renamed from: io.reactivex.internal.operators.observable.l */
public final class ObservableIgnoreElementsCompletable<T> extends Completable {
    /* renamed from: a */
    final ObservableSource<T> f27563a;

    /* compiled from: ObservableIgnoreElementsCompletable */
    /* renamed from: io.reactivex.internal.operators.observable.l$a */
    static final class C8133a<T> implements Disposable, Observer<T> {
        /* renamed from: a */
        final CompletableObserver f27564a;
        /* renamed from: b */
        Disposable f27565b;

        public void onNext(T t) {
        }

        C8133a(CompletableObserver bVar) {
            this.f27564a = bVar;
        }

        public void onSubscribe(Disposable bVar) {
            this.f27565b = bVar;
            this.f27564a.onSubscribe(this);
        }

        public void onError(Throwable th) {
            this.f27564a.onError(th);
        }

        public void onComplete() {
            this.f27564a.onComplete();
        }

        public void dispose() {
            this.f27565b.dispose();
        }

        public boolean isDisposed() {
            return this.f27565b.isDisposed();
        }
    }

    public ObservableIgnoreElementsCompletable(ObservableSource<T> kVar) {
        this.f27563a = kVar;
    }

    /* renamed from: b */
    public void mo38817b(CompletableObserver bVar) {
        this.f27563a.subscribe(new C8133a(bVar));
    }
}
