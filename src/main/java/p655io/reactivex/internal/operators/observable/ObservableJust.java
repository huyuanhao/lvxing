package p655io.reactivex.internal.operators.observable;

import p655io.reactivex.Observable;
import p655io.reactivex.Observer;
import p655io.reactivex.internal.operators.observable.ObservableScalarXMap.ScalarDisposable;
import p655io.reactivex.internal.p670b.ScalarCallable;

/* renamed from: io.reactivex.internal.operators.observable.n */
public final class ObservableJust<T> extends Observable<T> implements ScalarCallable<T> {
    /* renamed from: a */
    private final T f27570a;

    public ObservableJust(T t) {
        this.f27570a = t;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo19781a(Observer<? super T> lVar) {
        ScalarDisposable scalarDisposable = new ScalarDisposable(lVar, this.f27570a);
        lVar.onSubscribe(scalarDisposable);
        scalarDisposable.run();
    }

    public T call() {
        return this.f27570a;
    }
}
