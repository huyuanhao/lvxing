package p655io.reactivex.internal.operators.observable;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import p655io.reactivex.Observable;
import p655io.reactivex.ObservableSource;
import p655io.reactivex.Observer;
import p655io.reactivex.exceptions.Exceptions;
import p655io.reactivex.internal.disposables.EmptyDisposable;
import p655io.reactivex.internal.p669a.ObjectHelper;
import p655io.reactivex.internal.p670b.QueueDisposable;
import p655io.reactivex.p664d.Function;
import p655io.reactivex.p666f.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.observable.ObservableScalarXMap */
public final class ObservableScalarXMap {

    /* renamed from: io.reactivex.internal.operators.observable.ObservableScalarXMap$ScalarDisposable */
    public static final class ScalarDisposable<T> extends AtomicInteger implements QueueDisposable<T>, Runnable {
        static final int FUSED = 1;
        static final int ON_COMPLETE = 3;
        static final int ON_NEXT = 2;
        static final int START = 0;
        private static final long serialVersionUID = 3880992722410194083L;
        final Observer<? super T> observer;
        final T value;

        public ScalarDisposable(Observer<? super T> lVar, T t) {
            this.observer = lVar;
            this.value = t;
        }

        public boolean offer(T t) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        public boolean offer(T t, T t2) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        public T poll() throws Exception {
            if (get() != 1) {
                return null;
            }
            lazySet(3);
            return this.value;
        }

        public boolean isEmpty() {
            return get() != 1;
        }

        public void clear() {
            lazySet(3);
        }

        public void dispose() {
            set(3);
        }

        public boolean isDisposed() {
            return get() == 3;
        }

        public int requestFusion(int i) {
            if ((i & 1) == 0) {
                return 0;
            }
            lazySet(1);
            return 1;
        }

        public void run() {
            if (get() == 0 && compareAndSet(0, 2)) {
                this.observer.onNext(this.value);
                if (get() == 2) {
                    lazySet(3);
                    this.observer.onComplete();
                }
            }
        }
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableScalarXMap$a */
    static final class C8121a<T, R> extends Observable<R> {
        /* renamed from: a */
        final T f27513a;
        /* renamed from: b */
        final Function<? super T, ? extends ObservableSource<? extends R>> f27514b;

        C8121a(T t, Function<? super T, ? extends ObservableSource<? extends R>> hVar) {
            this.f27513a = t;
            this.f27514b = hVar;
        }

        /* renamed from: a */
        public void mo19781a(Observer<? super R> lVar) {
            try {
                ObservableSource kVar = (ObservableSource) ObjectHelper.m35048a(this.f27514b.apply(this.f27513a), "The mapper returned a null ObservableSource");
                if (kVar instanceof Callable) {
                    try {
                        Object call = ((Callable) kVar).call();
                        if (call == null) {
                            EmptyDisposable.complete(lVar);
                            return;
                        }
                        ScalarDisposable scalarDisposable = new ScalarDisposable(lVar, call);
                        lVar.onSubscribe(scalarDisposable);
                        scalarDisposable.run();
                    } catch (Throwable th) {
                        Exceptions.m34944b(th);
                        EmptyDisposable.error(th, lVar);
                    }
                } else {
                    kVar.subscribe(lVar);
                }
            } catch (Throwable th2) {
                EmptyDisposable.error(th2, lVar);
            }
        }
    }

    /* renamed from: a */
    public static <T, R> boolean m35080a(ObservableSource<T> kVar, Observer<? super R> lVar, Function<? super T, ? extends ObservableSource<? extends R>> hVar) {
        if (!(kVar instanceof Callable)) {
            return false;
        }
        try {
            Object call = ((Callable) kVar).call();
            if (call == null) {
                EmptyDisposable.complete(lVar);
                return true;
            }
            try {
                ObservableSource kVar2 = (ObservableSource) ObjectHelper.m35048a(hVar.apply(call), "The mapper returned a null ObservableSource");
                if (kVar2 instanceof Callable) {
                    try {
                        Object call2 = ((Callable) kVar2).call();
                        if (call2 == null) {
                            EmptyDisposable.complete(lVar);
                            return true;
                        }
                        ScalarDisposable scalarDisposable = new ScalarDisposable(lVar, call2);
                        lVar.onSubscribe(scalarDisposable);
                        scalarDisposable.run();
                    } catch (Throwable th) {
                        Exceptions.m34944b(th);
                        EmptyDisposable.error(th, lVar);
                        return true;
                    }
                } else {
                    kVar2.subscribe(lVar);
                }
                return true;
            } catch (Throwable th2) {
                Exceptions.m34944b(th2);
                EmptyDisposable.error(th2, lVar);
                return true;
            }
        } catch (Throwable th3) {
            Exceptions.m34944b(th3);
            EmptyDisposable.error(th3, lVar);
            return true;
        }
    }

    /* renamed from: a */
    public static <T, U> Observable<U> m35079a(T t, Function<? super T, ? extends ObservableSource<? extends U>> hVar) {
        return RxJavaPlugins.m34949a((Observable<T>) new C8121a<T>(t, hVar));
    }
}
