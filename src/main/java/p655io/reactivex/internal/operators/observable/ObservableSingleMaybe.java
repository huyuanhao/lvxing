package p655io.reactivex.internal.operators.observable;

import p655io.reactivex.Maybe;
import p655io.reactivex.ObservableSource;

/* renamed from: io.reactivex.internal.operators.observable.r */
public final class ObservableSingleMaybe<T> extends Maybe<T> {
    /* renamed from: a */
    final ObservableSource<T> f27584a;

    public ObservableSingleMaybe(ObservableSource<T> kVar) {
        this.f27584a = kVar;
    }
}
