package p655io.reactivex;

import org.p705b.Publisher;
import p655io.reactivex.annotations.BackpressureKind;
import p655io.reactivex.annotations.BackpressureSupport;
import p655io.reactivex.annotations.CheckReturnValue;
import p655io.reactivex.annotations.SchedulerSupport;
import p655io.reactivex.internal.operators.flowable.FlowableOnBackpressureBuffer;
import p655io.reactivex.internal.operators.flowable.FlowableOnBackpressureDrop;
import p655io.reactivex.internal.operators.flowable.FlowableOnBackpressureLatest;
import p655io.reactivex.internal.p669a.Functions;
import p655io.reactivex.internal.p669a.ObjectHelper;
import p655io.reactivex.p666f.RxJavaPlugins;

/* renamed from: io.reactivex.d */
public abstract class Flowable<T> implements Publisher<T> {
    /* renamed from: a */
    static final int f27412a = Math.max(1, Integer.getInteger("rx2.buffer-size", 128).intValue());

    /* renamed from: a */
    public static int m34932a() {
        return f27412a;
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    /* renamed from: b */
    public final Flowable<T> mo38837b() {
        return mo38836a(m34932a(), false, true);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.SPECIAL)
    @SchedulerSupport("none")
    /* renamed from: a */
    public final Flowable<T> mo38836a(int i, boolean z, boolean z2) {
        ObjectHelper.m35046a(i, "bufferSize");
        FlowableOnBackpressureBuffer cVar = new FlowableOnBackpressureBuffer(this, i, z2, z, Functions.f27470c);
        return RxJavaPlugins.m34947a((Flowable<T>) cVar);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    /* renamed from: c */
    public final Flowable<T> mo38838c() {
        return RxJavaPlugins.m34947a((Flowable<T>) new FlowableOnBackpressureDrop<T>(this));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    /* renamed from: d */
    public final Flowable<T> mo38839d() {
        return RxJavaPlugins.m34947a((Flowable<T>) new FlowableOnBackpressureLatest<T>(this));
    }
}
