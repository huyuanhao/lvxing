package p655io.reactivex.internal.observers;

import p655io.reactivex.Observer;
import p655io.reactivex.exceptions.Exceptions;
import p655io.reactivex.internal.disposables.DisposableHelper;
import p655io.reactivex.internal.disposables.EmptyDisposable;
import p655io.reactivex.p662b.Disposable;
import p655io.reactivex.p664d.C8083a;
import p655io.reactivex.p664d.Consumer;
import p655io.reactivex.p666f.RxJavaPlugins;

/* renamed from: io.reactivex.internal.observers.c */
public final class DisposableLambdaObserver<T> implements Disposable, Observer<T> {
    /* renamed from: a */
    final Observer<? super T> f27491a;
    /* renamed from: b */
    final Consumer<? super Disposable> f27492b;
    /* renamed from: c */
    final C8083a f27493c;
    /* renamed from: d */
    Disposable f27494d;

    public DisposableLambdaObserver(Observer<? super T> lVar, Consumer<? super Disposable> gVar, C8083a aVar) {
        this.f27491a = lVar;
        this.f27492b = gVar;
        this.f27493c = aVar;
    }

    public void onSubscribe(Disposable bVar) {
        try {
            this.f27492b.accept(bVar);
            if (DisposableHelper.validate(this.f27494d, bVar)) {
                this.f27494d = bVar;
                this.f27491a.onSubscribe(this);
            }
        } catch (Throwable th) {
            Exceptions.m34944b(th);
            bVar.dispose();
            this.f27494d = DisposableHelper.DISPOSED;
            EmptyDisposable.error(th, this.f27491a);
        }
    }

    public void onNext(T t) {
        this.f27491a.onNext(t);
    }

    public void onError(Throwable th) {
        if (this.f27494d != DisposableHelper.DISPOSED) {
            this.f27491a.onError(th);
        } else {
            RxJavaPlugins.m34959a(th);
        }
    }

    public void onComplete() {
        if (this.f27494d != DisposableHelper.DISPOSED) {
            this.f27491a.onComplete();
        }
    }

    public void dispose() {
        try {
            this.f27493c.mo19849a();
        } catch (Throwable th) {
            Exceptions.m34944b(th);
            RxJavaPlugins.m34959a(th);
        }
        this.f27494d.dispose();
    }

    public boolean isDisposed() {
        return this.f27494d.isDisposed();
    }
}
