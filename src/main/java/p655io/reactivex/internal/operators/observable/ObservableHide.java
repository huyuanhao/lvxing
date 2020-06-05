package p655io.reactivex.internal.operators.observable;

import p655io.reactivex.ObservableSource;
import p655io.reactivex.Observer;
import p655io.reactivex.internal.disposables.DisposableHelper;
import p655io.reactivex.p662b.Disposable;

/* renamed from: io.reactivex.internal.operators.observable.k */
public final class ObservableHide<T> extends AbstractObservableWithUpstream<T, T> {

    /* compiled from: ObservableHide */
    /* renamed from: io.reactivex.internal.operators.observable.k$a */
    static final class C8132a<T> implements Disposable, Observer<T> {
        /* renamed from: a */
        final Observer<? super T> f27561a;
        /* renamed from: b */
        Disposable f27562b;

        C8132a(Observer<? super T> lVar) {
            this.f27561a = lVar;
        }

        public void dispose() {
            this.f27562b.dispose();
        }

        public boolean isDisposed() {
            return this.f27562b.isDisposed();
        }

        public void onSubscribe(Disposable bVar) {
            if (DisposableHelper.validate(this.f27562b, bVar)) {
                this.f27562b = bVar;
                this.f27561a.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            this.f27561a.onNext(t);
        }

        public void onError(Throwable th) {
            this.f27561a.onError(th);
        }

        public void onComplete() {
            this.f27561a.onComplete();
        }
    }

    public ObservableHide(ObservableSource<T> kVar) {
        super(kVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo19781a(Observer<? super T> lVar) {
        this.f27515a.subscribe(new C8132a(lVar));
    }
}
