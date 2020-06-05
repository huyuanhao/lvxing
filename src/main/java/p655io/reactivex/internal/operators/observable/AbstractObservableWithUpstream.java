package p655io.reactivex.internal.operators.observable;

import p655io.reactivex.Observable;
import p655io.reactivex.ObservableSource;

/* renamed from: io.reactivex.internal.operators.observable.a */
abstract class AbstractObservableWithUpstream<T, U> extends Observable<U> {
    /* renamed from: a */
    protected final ObservableSource<T> f27515a;

    AbstractObservableWithUpstream(ObservableSource<T> kVar) {
        this.f27515a = kVar;
    }
}
