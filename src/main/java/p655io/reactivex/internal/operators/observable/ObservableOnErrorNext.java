package p655io.reactivex.internal.operators.observable;

import p655io.reactivex.ObservableSource;
import p655io.reactivex.Observer;
import p655io.reactivex.exceptions.CompositeException;
import p655io.reactivex.exceptions.Exceptions;
import p655io.reactivex.internal.disposables.SequentialDisposable;
import p655io.reactivex.p662b.Disposable;
import p655io.reactivex.p664d.Function;
import p655io.reactivex.p666f.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.observable.q */
public final class ObservableOnErrorNext<T> extends AbstractObservableWithUpstream<T, T> {
    /* renamed from: b */
    final Function<? super Throwable, ? extends ObservableSource<? extends T>> f27576b;
    /* renamed from: c */
    final boolean f27577c;

    /* compiled from: ObservableOnErrorNext */
    /* renamed from: io.reactivex.internal.operators.observable.q$a */
    static final class C8137a<T> implements Observer<T> {
        /* renamed from: a */
        final Observer<? super T> f27578a;
        /* renamed from: b */
        final Function<? super Throwable, ? extends ObservableSource<? extends T>> f27579b;
        /* renamed from: c */
        final boolean f27580c;
        /* renamed from: d */
        final SequentialDisposable f27581d = new SequentialDisposable();
        /* renamed from: e */
        boolean f27582e;
        /* renamed from: f */
        boolean f27583f;

        C8137a(Observer<? super T> lVar, Function<? super Throwable, ? extends ObservableSource<? extends T>> hVar, boolean z) {
            this.f27578a = lVar;
            this.f27579b = hVar;
            this.f27580c = z;
        }

        public void onSubscribe(Disposable bVar) {
            this.f27581d.replace(bVar);
        }

        public void onNext(T t) {
            if (!this.f27583f) {
                this.f27578a.onNext(t);
            }
        }

        public void onError(Throwable th) {
            if (!this.f27582e) {
                this.f27582e = true;
                if (!this.f27580c || (th instanceof Exception)) {
                    try {
                        ObservableSource kVar = (ObservableSource) this.f27579b.apply(th);
                        if (kVar == null) {
                            NullPointerException nullPointerException = new NullPointerException("Observable is null");
                            nullPointerException.initCause(th);
                            this.f27578a.onError(nullPointerException);
                            return;
                        }
                        kVar.subscribe(this);
                    } catch (Throwable th2) {
                        Exceptions.m34944b(th2);
                        this.f27578a.onError(new CompositeException(th, th2));
                    }
                } else {
                    this.f27578a.onError(th);
                }
            } else if (this.f27583f) {
                RxJavaPlugins.m34959a(th);
            } else {
                this.f27578a.onError(th);
            }
        }

        public void onComplete() {
            if (!this.f27583f) {
                this.f27583f = true;
                this.f27582e = true;
                this.f27578a.onComplete();
            }
        }
    }

    public ObservableOnErrorNext(ObservableSource<T> kVar, Function<? super Throwable, ? extends ObservableSource<? extends T>> hVar, boolean z) {
        super(kVar);
        this.f27576b = hVar;
        this.f27577c = z;
    }

    /* renamed from: a */
    public void mo19781a(Observer<? super T> lVar) {
        C8137a aVar = new C8137a(lVar, this.f27576b, this.f27577c);
        lVar.onSubscribe(aVar.f27581d);
        this.f27515a.subscribe(aVar);
    }
}
