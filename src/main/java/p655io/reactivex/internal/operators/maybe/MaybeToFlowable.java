package p655io.reactivex.internal.operators.maybe;

import p655io.reactivex.Flowable;
import p655io.reactivex.MaybeSource;

/* renamed from: io.reactivex.internal.operators.maybe.a */
public final class MaybeToFlowable<T> extends Flowable<T> {
    /* renamed from: b */
    final MaybeSource<T> f27507b;

    public MaybeToFlowable(MaybeSource<T> hVar) {
        this.f27507b = hVar;
    }
}
