package p655io.reactivex;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import p655io.reactivex.annotations.BackpressureKind;
import p655io.reactivex.annotations.BackpressureSupport;
import p655io.reactivex.annotations.CheckReturnValue;
import p655io.reactivex.annotations.SchedulerSupport;
import p655io.reactivex.exceptions.Exceptions;
import p655io.reactivex.internal.observers.LambdaObserver;
import p655io.reactivex.internal.operators.flowable.FlowableFromObservable;
import p655io.reactivex.internal.operators.flowable.FlowableOnBackpressureError;
import p655io.reactivex.internal.operators.observable.ObservableDelay;
import p655io.reactivex.internal.operators.observable.ObservableDoFinally;
import p655io.reactivex.internal.operators.observable.ObservableDoOnEach;
import p655io.reactivex.internal.operators.observable.ObservableDoOnLifecycle;
import p655io.reactivex.internal.operators.observable.ObservableEmpty;
import p655io.reactivex.internal.operators.observable.ObservableError;
import p655io.reactivex.internal.operators.observable.ObservableFilter;
import p655io.reactivex.internal.operators.observable.ObservableFlatMap;
import p655io.reactivex.internal.operators.observable.ObservableFromArray;
import p655io.reactivex.internal.operators.observable.ObservableHide;
import p655io.reactivex.internal.operators.observable.ObservableIgnoreElementsCompletable;
import p655io.reactivex.internal.operators.observable.ObservableInterval;
import p655io.reactivex.internal.operators.observable.ObservableJust;
import p655io.reactivex.internal.operators.observable.ObservableMap;
import p655io.reactivex.internal.operators.observable.ObservableObserveOn;
import p655io.reactivex.internal.operators.observable.ObservableOnErrorNext;
import p655io.reactivex.internal.operators.observable.ObservableScalarXMap;
import p655io.reactivex.internal.operators.observable.ObservableSingleMaybe;
import p655io.reactivex.internal.operators.observable.ObservableSingleSingle;
import p655io.reactivex.internal.operators.observable.ObservableSkip;
import p655io.reactivex.internal.operators.observable.ObservableSubscribeOn;
import p655io.reactivex.internal.operators.observable.ObservableTake;
import p655io.reactivex.internal.operators.observable.ObservableTakeUntilPredicate;
import p655io.reactivex.internal.operators.observable.ObservableTimer;
import p655io.reactivex.internal.p669a.Functions;
import p655io.reactivex.internal.p669a.ObjectHelper;
import p655io.reactivex.internal.p670b.ScalarCallable;
import p655io.reactivex.p662b.Disposable;
import p655io.reactivex.p664d.C8083a;
import p655io.reactivex.p664d.C8084j;
import p655io.reactivex.p664d.Consumer;
import p655io.reactivex.p664d.Function;
import p655io.reactivex.p666f.RxJavaPlugins;
import p655io.reactivex.p667g.Schedulers;

/* renamed from: io.reactivex.i */
public abstract class Observable<T> implements ObservableSource<T> {

    /* compiled from: Observable */
    /* renamed from: io.reactivex.i$1 */
    static /* synthetic */ class C81001 {
        /* renamed from: a */
        static final /* synthetic */ int[] f27467a = new int[BackpressureStrategy.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
            io.reactivex.BackpressureStrategy[] r0 = p655io.reactivex.BackpressureStrategy.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f27467a = r0
            int[] r0 = f27467a     // Catch:{ NoSuchFieldError -> 0x0014 }
            io.reactivex.BackpressureStrategy r1 = p655io.reactivex.BackpressureStrategy.DROP     // Catch:{ NoSuchFieldError -> 0x0014 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            int[] r0 = f27467a     // Catch:{ NoSuchFieldError -> 0x001f }
            io.reactivex.BackpressureStrategy r1 = p655io.reactivex.BackpressureStrategy.LATEST     // Catch:{ NoSuchFieldError -> 0x001f }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            int[] r0 = f27467a     // Catch:{ NoSuchFieldError -> 0x002a }
            io.reactivex.BackpressureStrategy r1 = p655io.reactivex.BackpressureStrategy.MISSING     // Catch:{ NoSuchFieldError -> 0x002a }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            int[] r0 = f27467a     // Catch:{ NoSuchFieldError -> 0x0035 }
            io.reactivex.BackpressureStrategy r1 = p655io.reactivex.BackpressureStrategy.ERROR     // Catch:{ NoSuchFieldError -> 0x0035 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
            r2 = 4
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
        L_0x0035:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: p655io.reactivex.Observable.C81001.m54690clinit():void");
        }
    }

    /* renamed from: a */
    public abstract void mo19781a(Observer<? super T> lVar);

    /* renamed from: c */
    public static int m35000c() {
        return Flowable.m34932a();
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    /* renamed from: d */
    public static <T> Observable<T> m35001d() {
        return RxJavaPlugins.m34949a(ObservableEmpty.f27546a);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    /* renamed from: a */
    public static <T> Observable<T> m34998a(Callable<? extends Throwable> callable) {
        ObjectHelper.m35048a(callable, "errorSupplier is null");
        return RxJavaPlugins.m34949a((Observable<T>) new ObservableError<T>(callable));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    /* renamed from: a */
    public static <T> Observable<T> m34997a(Throwable th) {
        ObjectHelper.m35048a(th, "e is null");
        return m34998a(Functions.m35037a(th));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    /* renamed from: a */
    public static <T> Observable<T> m34999a(T... tArr) {
        ObjectHelper.m35048a(tArr, "items is null");
        if (tArr.length == 0) {
            return m35001d();
        }
        if (tArr.length == 1) {
            return m34996a(tArr[0]);
        }
        return RxJavaPlugins.m34949a((Observable<T>) new ObservableFromArray<T>(tArr));
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    /* renamed from: a */
    public static Observable<Long> m34990a(long j, long j2, TimeUnit timeUnit) {
        return m34991a(j, j2, timeUnit, Schedulers.m34967a());
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    /* renamed from: a */
    public static Observable<Long> m34991a(long j, long j2, TimeUnit timeUnit, Scheduler mVar) {
        ObjectHelper.m35048a(timeUnit, "unit is null");
        ObjectHelper.m35048a(mVar, "scheduler is null");
        ObservableInterval mVar2 = new ObservableInterval(Math.max(0, j), Math.max(0, j2), timeUnit, mVar);
        return RxJavaPlugins.m34949a((Observable<T>) mVar2);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    /* renamed from: a */
    public static <T> Observable<T> m34996a(T t) {
        ObjectHelper.m35048a(t, "The item is null");
        return RxJavaPlugins.m34949a((Observable<T>) new ObservableJust<T>(t));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    /* renamed from: a */
    public static <T> Observable<T> m34995a(ObservableSource<? extends T> kVar, ObservableSource<? extends T> kVar2, ObservableSource<? extends T> kVar3, ObservableSource<? extends T> kVar4) {
        ObjectHelper.m35048a(kVar, "source1 is null");
        ObjectHelper.m35048a(kVar2, "source2 is null");
        ObjectHelper.m35048a(kVar3, "source3 is null");
        ObjectHelper.m35048a(kVar4, "source4 is null");
        return m34999a((T[]) new ObservableSource[]{kVar, kVar2, kVar3, kVar4}).mo38888a(Functions.m35035a(), false, 4);
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    /* renamed from: a */
    public static Observable<Long> m34992a(long j, TimeUnit timeUnit) {
        return m34993a(j, timeUnit, Schedulers.m34967a());
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    /* renamed from: a */
    public static Observable<Long> m34993a(long j, TimeUnit timeUnit, Scheduler mVar) {
        ObjectHelper.m35048a(timeUnit, "unit is null");
        ObjectHelper.m35048a(mVar, "scheduler is null");
        return RxJavaPlugins.m34949a((Observable<T>) new ObservableTimer<T>(Math.max(j, 0), timeUnit, mVar));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    /* renamed from: a */
    public final <R> R mo38895a(ObservableConverter<T, ? extends R> jVar) {
        return ((ObservableConverter) ObjectHelper.m35048a(jVar, "converter is null")).mo37373b(this);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    /* renamed from: a */
    public final <U> Observable<U> mo38894a(Class<U> cls) {
        ObjectHelper.m35048a(cls, "clazz is null");
        return mo38900b(Functions.m35036a(cls));
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    /* renamed from: b */
    public final Observable<T> mo38897b(long j, TimeUnit timeUnit) {
        return mo38882a(j, timeUnit, Schedulers.m34967a(), false);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    /* renamed from: a */
    public final Observable<T> mo38882a(long j, TimeUnit timeUnit, Scheduler mVar, boolean z) {
        ObjectHelper.m35048a(timeUnit, "unit is null");
        ObjectHelper.m35048a(mVar, "scheduler is null");
        ObservableDelay bVar = new ObservableDelay(this, j, timeUnit, mVar, z);
        return RxJavaPlugins.m34949a((Observable<T>) bVar);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    /* renamed from: a */
    public final Observable<T> mo38883a(C8083a aVar) {
        ObjectHelper.m35048a(aVar, "onFinally is null");
        return RxJavaPlugins.m34949a((Observable<T>) new ObservableDoFinally<T>(this, aVar));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    /* renamed from: b */
    public final Observable<T> mo38898b(C8083a aVar) {
        return m34994a(Functions.m35038b(), Functions.m35038b(), aVar, Functions.f27470c);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    /* renamed from: a */
    private Observable<T> m34994a(Consumer<? super T> gVar, Consumer<? super Throwable> gVar2, C8083a aVar, C8083a aVar2) {
        ObjectHelper.m35048a(gVar, "onNext is null");
        ObjectHelper.m35048a(gVar2, "onError is null");
        ObjectHelper.m35048a(aVar, "onComplete is null");
        ObjectHelper.m35048a(aVar2, "onAfterTerminate is null");
        ObservableDoOnEach dVar = new ObservableDoOnEach(this, gVar, gVar2, aVar, aVar2);
        return RxJavaPlugins.m34949a((Observable<T>) dVar);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    /* renamed from: a */
    public final Observable<T> mo38884a(Consumer<? super Throwable> gVar) {
        return m34994a(Functions.m35038b(), gVar, Functions.f27470c, Functions.f27470c);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    /* renamed from: a */
    public final Observable<T> mo38885a(Consumer<? super Disposable> gVar, C8083a aVar) {
        ObjectHelper.m35048a(gVar, "onSubscribe is null");
        ObjectHelper.m35048a(aVar, "onDispose is null");
        return RxJavaPlugins.m34949a((Observable<T>) new ObservableDoOnLifecycle<T>(this, gVar, aVar));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    /* renamed from: b */
    public final Observable<T> mo38899b(Consumer<? super Disposable> gVar) {
        return mo38885a(gVar, Functions.f27470c);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    /* renamed from: a */
    public final Observable<T> mo38890a(C8084j<? super T> jVar) {
        ObjectHelper.m35048a(jVar, "predicate is null");
        return RxJavaPlugins.m34949a((Observable<T>) new ObservableFilter<T>(this, jVar));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    /* renamed from: a */
    public final <R> Observable<R> mo38886a(Function<? super T, ? extends ObservableSource<? extends R>> hVar) {
        return mo38887a(hVar, false);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    /* renamed from: a */
    public final <R> Observable<R> mo38887a(Function<? super T, ? extends ObservableSource<? extends R>> hVar, boolean z) {
        return mo38888a(hVar, z, (int) ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    /* renamed from: a */
    public final <R> Observable<R> mo38888a(Function<? super T, ? extends ObservableSource<? extends R>> hVar, boolean z, int i) {
        return mo38889a(hVar, z, i, m35000c());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    /* renamed from: a */
    public final <R> Observable<R> mo38889a(Function<? super T, ? extends ObservableSource<? extends R>> hVar, boolean z, int i, int i2) {
        ObjectHelper.m35048a(hVar, "mapper is null");
        ObjectHelper.m35046a(i, "maxConcurrency");
        ObjectHelper.m35046a(i2, "bufferSize");
        if (this instanceof ScalarCallable) {
            Object call = ((ScalarCallable) this).call();
            if (call == null) {
                return m35001d();
            }
            return ObservableScalarXMap.m35079a(call, hVar);
        }
        ObservableFlatMap iVar = new ObservableFlatMap(this, hVar, z, i, i2);
        return RxJavaPlugins.m34949a((Observable<T>) iVar);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    /* renamed from: e */
    public final Observable<T> mo38906e() {
        return RxJavaPlugins.m34949a((Observable<T>) new ObservableHide<T>(this));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    /* renamed from: f */
    public final Completable mo38907f() {
        return RxJavaPlugins.m34945a((Completable) new ObservableIgnoreElementsCompletable(this));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    /* renamed from: b */
    public final <R> Observable<R> mo38900b(Function<? super T, ? extends R> hVar) {
        ObjectHelper.m35048a(hVar, "mapper is null");
        return RxJavaPlugins.m34949a((Observable<T>) new ObservableMap<T>(this, hVar));
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    /* renamed from: a */
    public final Observable<T> mo38892a(Scheduler mVar) {
        return mo38893a(mVar, false, m35000c());
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    /* renamed from: a */
    public final Observable<T> mo38893a(Scheduler mVar, boolean z, int i) {
        ObjectHelper.m35048a(mVar, "scheduler is null");
        ObjectHelper.m35046a(i, "bufferSize");
        return RxJavaPlugins.m34949a((Observable<T>) new ObservableObserveOn<T>(this, mVar, z, i));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    /* renamed from: b */
    public final <U> Observable<U> mo38903b(Class<U> cls) {
        ObjectHelper.m35048a(cls, "clazz is null");
        return mo38890a(Functions.m35040b(cls)).mo38894a(cls);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    /* renamed from: c */
    public final Observable<T> mo38905c(Function<? super Throwable, ? extends ObservableSource<? extends T>> hVar) {
        ObjectHelper.m35048a(hVar, "resumeFunction is null");
        return RxJavaPlugins.m34949a((Observable<T>) new ObservableOnErrorNext<T>(this, hVar, false));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    /* renamed from: a */
    public final Observable<T> mo38891a(ObservableSource<? extends T> kVar) {
        ObjectHelper.m35048a(kVar, "next is null");
        return mo38905c(Functions.m35039b(kVar));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    /* renamed from: g */
    public final Maybe<T> mo38908g() {
        return RxJavaPlugins.m34948a((Maybe<T>) new ObservableSingleMaybe<T>(this));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    /* renamed from: h */
    public final Single<T> mo38909h() {
        return RxJavaPlugins.m34954a((Single<T>) new ObservableSingleSingle<T>(this, null));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    /* renamed from: a */
    public final Observable<T> mo38881a(long j) {
        if (j <= 0) {
            return RxJavaPlugins.m34949a(this);
        }
        return RxJavaPlugins.m34949a((Observable<T>) new ObservableSkip<T>(this, j));
    }

    @SchedulerSupport("none")
    /* renamed from: i */
    public final Disposable mo38910i() {
        return mo38879a(Functions.m35038b(), Functions.f27473f, Functions.f27470c, Functions.m35038b());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    /* renamed from: c */
    public final Disposable mo38904c(Consumer<? super T> gVar) {
        return mo38879a(gVar, Functions.f27473f, Functions.f27470c, Functions.m35038b());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    /* renamed from: a */
    public final Disposable mo38879a(Consumer<? super T> gVar, Consumer<? super Throwable> gVar2, C8083a aVar, Consumer<? super Disposable> gVar3) {
        ObjectHelper.m35048a(gVar, "onNext is null");
        ObjectHelper.m35048a(gVar2, "onError is null");
        ObjectHelper.m35048a(aVar, "onComplete is null");
        ObjectHelper.m35048a(gVar3, "onSubscribe is null");
        LambdaObserver lambdaObserver = new LambdaObserver(gVar, gVar2, aVar, gVar3);
        subscribe(lambdaObserver);
        return lambdaObserver;
    }

    @SchedulerSupport("none")
    public final void subscribe(Observer<? super T> lVar) {
        ObjectHelper.m35048a(lVar, "observer is null");
        try {
            Observer a = RxJavaPlugins.m34950a(this, lVar);
            ObjectHelper.m35048a(a, "The RxJavaPlugins.onSubscribe hook returned a null Observer. Please change the handler provided to RxJavaPlugins.setOnObservableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            mo19781a(a);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            Exceptions.m34944b(th);
            RxJavaPlugins.m34959a(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    /* renamed from: b */
    public final Observable<T> mo38902b(Scheduler mVar) {
        ObjectHelper.m35048a(mVar, "scheduler is null");
        return RxJavaPlugins.m34949a((Observable<T>) new ObservableSubscribeOn<T>(this, mVar));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    /* renamed from: b */
    public final Observable<T> mo38896b(long j) {
        if (j >= 0) {
            return RxJavaPlugins.m34949a((Observable<T>) new ObservableTake<T>(this, j));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("count >= 0 required but it was ");
        sb.append(j);
        throw new IllegalArgumentException(sb.toString());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    /* renamed from: b */
    public final Observable<T> mo38901b(C8084j<? super T> jVar) {
        ObjectHelper.m35048a(jVar, "predicate is null");
        return RxJavaPlugins.m34949a((Observable<T>) new ObservableTakeUntilPredicate<T>(this, jVar));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.SPECIAL)
    @SchedulerSupport("none")
    /* renamed from: a */
    public final Flowable<T> mo38880a(BackpressureStrategy backpressureStrategy) {
        FlowableFromObservable bVar = new FlowableFromObservable(this);
        int i = C81001.f27467a[backpressureStrategy.ordinal()];
        if (i == 1) {
            return bVar.mo38838c();
        }
        if (i == 2) {
            return bVar.mo38839d();
        }
        if (i == 3) {
            return bVar;
        }
        if (i != 4) {
            return bVar.mo38837b();
        }
        return RxJavaPlugins.m34947a((Flowable<T>) new FlowableOnBackpressureError<T>(bVar));
    }
}
