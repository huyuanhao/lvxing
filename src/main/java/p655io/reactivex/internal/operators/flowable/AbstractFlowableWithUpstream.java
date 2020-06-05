package p655io.reactivex.internal.operators.flowable;

import p655io.reactivex.Flowable;
import p655io.reactivex.internal.p669a.ObjectHelper;

/* renamed from: io.reactivex.internal.operators.flowable.a */
abstract class AbstractFlowableWithUpstream<T, R> extends Flowable<R> {
    /* renamed from: b */
    protected final Flowable<T> f27500b;

    AbstractFlowableWithUpstream(Flowable<T> dVar) {
        this.f27500b = (Flowable) ObjectHelper.m35048a(dVar, "source is null");
    }
}
