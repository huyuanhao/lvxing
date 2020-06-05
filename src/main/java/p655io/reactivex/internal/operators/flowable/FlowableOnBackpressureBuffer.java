package p655io.reactivex.internal.operators.flowable;

import p655io.reactivex.Flowable;
import p655io.reactivex.p664d.C8083a;

/* renamed from: io.reactivex.internal.operators.flowable.c */
public final class FlowableOnBackpressureBuffer<T> extends AbstractFlowableWithUpstream<T, T> {
    /* renamed from: c */
    final int f27502c;
    /* renamed from: d */
    final boolean f27503d;
    /* renamed from: e */
    final boolean f27504e;
    /* renamed from: f */
    final C8083a f27505f;

    public FlowableOnBackpressureBuffer(Flowable<T> dVar, int i, boolean z, boolean z2, C8083a aVar) {
        super(dVar);
        this.f27502c = i;
        this.f27503d = z;
        this.f27504e = z2;
        this.f27505f = aVar;
    }
}
