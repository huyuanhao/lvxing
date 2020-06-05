package p655io.reactivex.internal.operators.flowable;

import p655io.reactivex.Flowable;
import p655io.reactivex.Observable;

/* renamed from: io.reactivex.internal.operators.flowable.b */
public final class FlowableFromObservable<T> extends Flowable<T> {
    /* renamed from: b */
    private final Observable<T> f27501b;

    public FlowableFromObservable(Observable<T> iVar) {
        this.f27501b = iVar;
    }
}
