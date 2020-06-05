package p655io.reactivex.internal.operators.observable;

import p655io.reactivex.ObservableSource;
import p655io.reactivex.Observer;
import p655io.reactivex.exceptions.Exceptions;
import p655io.reactivex.internal.disposables.DisposableHelper;
import p655io.reactivex.p662b.Disposable;
import p655io.reactivex.p664d.C8084j;
import p655io.reactivex.p666f.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.observable.w */
public final class ObservableTakeUntilPredicate<T> extends AbstractObservableWithUpstream<T, T> {
    /* renamed from: b */
    final C8084j<? super T> f27599b;

    /* compiled from: ObservableTakeUntilPredicate */
    /* renamed from: io.reactivex.internal.operators.observable.w$a */
    static final class C8142a<T> implements Disposable, Observer<T> {
        /* renamed from: a */
        final Observer<? super T> f27600a;
        /* renamed from: b */
        final C8084j<? super T> f27601b;
        /* renamed from: c */
        Disposable f27602c;
        /* renamed from: d */
        boolean f27603d;

        C8142a(Observer<? super T> lVar, C8084j<? super T> jVar) {
            this.f27600a = lVar;
            this.f27601b = jVar;
        }

        public void onSubscribe(Disposable bVar) {
            if (DisposableHelper.validate(this.f27602c, bVar)) {
                this.f27602c = bVar;
                this.f27600a.onSubscribe(this);
            }
        }

        public void dispose() {
            this.f27602c.dispose();
        }

        public boolean isDisposed() {
            return this.f27602c.isDisposed();
        }

        public void onNext(T t) {
            if (!this.f27603d) {
                this.f27600a.onNext(t);
                try {
                    if (this.f27601b.test(t)) {
                        this.f27603d = true;
                        this.f27602c.dispose();
                        this.f27600a.onComplete();
                    }
                } catch (Throwable th) {
                    Exceptions.m34944b(th);
                    this.f27602c.dispose();
                    onError(th);
                }
            }
        }

        public void onError(Throwable th) {
            if (!this.f27603d) {
                this.f27603d = true;
                this.f27600a.onError(th);
                return;
            }
            RxJavaPlugins.m34959a(th);
        }

        public void onComplete() {
            if (!this.f27603d) {
                this.f27603d = true;
                this.f27600a.onComplete();
            }
        }
    }

    public ObservableTakeUntilPredicate(ObservableSource<T> kVar, C8084j<? super T> jVar) {
        super(kVar);
        this.f27599b = jVar;
    }

    /* renamed from: a */
    public void mo19781a(Observer<? super T> lVar) {
        this.f27515a.subscribe(new C8142a(lVar, this.f27599b));
    }
}
