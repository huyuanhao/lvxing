package p655io.reactivex.internal.operators.observable;

import p655io.reactivex.ObservableSource;
import p655io.reactivex.Single;

/* renamed from: io.reactivex.internal.operators.observable.s */
public final class ObservableSingleSingle<T> extends Single<T> {
    /* renamed from: a */
    final ObservableSource<? extends T> f27585a;
    /* renamed from: b */
    final T f27586b;

    public ObservableSingleSingle(ObservableSource<? extends T> kVar, T t) {
        this.f27585a = kVar;
        this.f27586b = t;
    }
}
