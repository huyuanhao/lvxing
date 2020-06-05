package p655io.reactivex.internal.operators.observable;

import p655io.reactivex.ObservableSource;
import p655io.reactivex.Observer;
import p655io.reactivex.exceptions.CompositeException;
import p655io.reactivex.exceptions.Exceptions;
import p655io.reactivex.internal.disposables.DisposableHelper;
import p655io.reactivex.p662b.Disposable;
import p655io.reactivex.p664d.C8083a;
import p655io.reactivex.p664d.Consumer;
import p655io.reactivex.p666f.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.observable.d */
public final class ObservableDoOnEach<T> extends AbstractObservableWithUpstream<T, T> {
    /* renamed from: b */
    final Consumer<? super T> f27533b;
    /* renamed from: c */
    final Consumer<? super Throwable> f27534c;
    /* renamed from: d */
    final C8083a f27535d;
    /* renamed from: e */
    final C8083a f27536e;

    /* compiled from: ObservableDoOnEach */
    /* renamed from: io.reactivex.internal.operators.observable.d$a */
    static final class C8127a<T> implements Disposable, Observer<T> {
        /* renamed from: a */
        final Observer<? super T> f27537a;
        /* renamed from: b */
        final Consumer<? super T> f27538b;
        /* renamed from: c */
        final Consumer<? super Throwable> f27539c;
        /* renamed from: d */
        final C8083a f27540d;
        /* renamed from: e */
        final C8083a f27541e;
        /* renamed from: f */
        Disposable f27542f;
        /* renamed from: g */
        boolean f27543g;

        C8127a(Observer<? super T> lVar, Consumer<? super T> gVar, Consumer<? super Throwable> gVar2, C8083a aVar, C8083a aVar2) {
            this.f27537a = lVar;
            this.f27538b = gVar;
            this.f27539c = gVar2;
            this.f27540d = aVar;
            this.f27541e = aVar2;
        }

        public void onSubscribe(Disposable bVar) {
            if (DisposableHelper.validate(this.f27542f, bVar)) {
                this.f27542f = bVar;
                this.f27537a.onSubscribe(this);
            }
        }

        public void dispose() {
            this.f27542f.dispose();
        }

        public boolean isDisposed() {
            return this.f27542f.isDisposed();
        }

        public void onNext(T t) {
            if (!this.f27543g) {
                try {
                    this.f27538b.accept(t);
                    this.f27537a.onNext(t);
                } catch (Throwable th) {
                    Exceptions.m34944b(th);
                    this.f27542f.dispose();
                    onError(th);
                }
            }
        }

        public void onError(Throwable th) {
            if (this.f27543g) {
                RxJavaPlugins.m34959a(th);
                return;
            }
            this.f27543g = true;
            try {
                this.f27539c.accept(th);
            } catch (Throwable th2) {
                Exceptions.m34944b(th2);
                th = new CompositeException(th, th2);
            }
            this.f27537a.onError(th);
            try {
                this.f27541e.mo19849a();
            } catch (Throwable th3) {
                Exceptions.m34944b(th3);
                RxJavaPlugins.m34959a(th3);
            }
        }

        public void onComplete() {
            if (!this.f27543g) {
                try {
                    this.f27540d.mo19849a();
                    this.f27543g = true;
                    this.f27537a.onComplete();
                    try {
                        this.f27541e.mo19849a();
                    } catch (Throwable th) {
                        Exceptions.m34944b(th);
                        RxJavaPlugins.m34959a(th);
                    }
                } catch (Throwable th2) {
                    Exceptions.m34944b(th2);
                    onError(th2);
                }
            }
        }
    }

    public ObservableDoOnEach(ObservableSource<T> kVar, Consumer<? super T> gVar, Consumer<? super Throwable> gVar2, C8083a aVar, C8083a aVar2) {
        super(kVar);
        this.f27533b = gVar;
        this.f27534c = gVar2;
        this.f27535d = aVar;
        this.f27536e = aVar2;
    }

    /* renamed from: a */
    public void mo19781a(Observer<? super T> lVar) {
        ObservableSource kVar = this.f27515a;
        C8127a aVar = new C8127a(lVar, this.f27533b, this.f27534c, this.f27535d, this.f27536e);
        kVar.subscribe(aVar);
    }
}
