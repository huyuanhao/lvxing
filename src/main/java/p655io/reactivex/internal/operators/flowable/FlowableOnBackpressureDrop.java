package p655io.reactivex.internal.operators.flowable;

import p655io.reactivex.Flowable;
import p655io.reactivex.p664d.Consumer;

/* renamed from: io.reactivex.internal.operators.flowable.d */
public final class FlowableOnBackpressureDrop<T> extends AbstractFlowableWithUpstream<T, T> implements Consumer<T> {
    /* renamed from: c */
    final Consumer<? super T> f27506c = this;

    public void accept(T t) {
    }

    public FlowableOnBackpressureDrop(Flowable<T> dVar) {
        super(dVar);
    }
}
