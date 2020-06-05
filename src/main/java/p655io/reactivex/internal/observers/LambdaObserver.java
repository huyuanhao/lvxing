package p655io.reactivex.internal.observers;

import java.util.concurrent.atomic.AtomicReference;
import p655io.reactivex.Observer;
import p655io.reactivex.exceptions.CompositeException;
import p655io.reactivex.exceptions.Exceptions;
import p655io.reactivex.internal.disposables.DisposableHelper;
import p655io.reactivex.internal.p669a.Functions;
import p655io.reactivex.p662b.Disposable;
import p655io.reactivex.p664d.C8083a;
import p655io.reactivex.p664d.Consumer;
import p655io.reactivex.p666f.RxJavaPlugins;

/* renamed from: io.reactivex.internal.observers.LambdaObserver */
public final class LambdaObserver<T> extends AtomicReference<Disposable> implements Disposable, Observer<T> {
    private static final long serialVersionUID = -7251123623727029452L;
    final C8083a onComplete;
    final Consumer<? super Throwable> onError;
    final Consumer<? super T> onNext;
    final Consumer<? super Disposable> onSubscribe;

    public LambdaObserver(Consumer<? super T> gVar, Consumer<? super Throwable> gVar2, C8083a aVar, Consumer<? super Disposable> gVar3) {
        this.onNext = gVar;
        this.onError = gVar2;
        this.onComplete = aVar;
        this.onSubscribe = gVar3;
    }

    public void onSubscribe(Disposable bVar) {
        if (DisposableHelper.setOnce(this, bVar)) {
            try {
                this.onSubscribe.accept(this);
            } catch (Throwable th) {
                Exceptions.m34944b(th);
                bVar.dispose();
                onError(th);
            }
        }
    }

    public void onNext(T t) {
        if (!isDisposed()) {
            try {
                this.onNext.accept(t);
            } catch (Throwable th) {
                Exceptions.m34944b(th);
                ((Disposable) get()).dispose();
                onError(th);
            }
        }
    }

    public void onError(Throwable th) {
        if (!isDisposed()) {
            lazySet(DisposableHelper.DISPOSED);
            try {
                this.onError.accept(th);
            } catch (Throwable th2) {
                Exceptions.m34944b(th2);
                RxJavaPlugins.m34959a((Throwable) new CompositeException(th, th2));
            }
        } else {
            RxJavaPlugins.m34959a(th);
        }
    }

    public void onComplete() {
        if (!isDisposed()) {
            lazySet(DisposableHelper.DISPOSED);
            try {
                this.onComplete.mo19849a();
            } catch (Throwable th) {
                Exceptions.m34944b(th);
                RxJavaPlugins.m34959a(th);
            }
        }
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    public boolean hasCustomOnError() {
        return this.onError != Functions.f27473f;
    }
}
