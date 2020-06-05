package p655io.reactivex.internal.observers;

import java.util.concurrent.atomic.AtomicReference;
import p655io.reactivex.CompletableObserver;
import p655io.reactivex.exceptions.Exceptions;
import p655io.reactivex.exceptions.OnErrorNotImplementedException;
import p655io.reactivex.internal.disposables.DisposableHelper;
import p655io.reactivex.p662b.Disposable;
import p655io.reactivex.p664d.C8083a;
import p655io.reactivex.p664d.Consumer;
import p655io.reactivex.p666f.RxJavaPlugins;

/* renamed from: io.reactivex.internal.observers.CallbackCompletableObserver */
public final class CallbackCompletableObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable, Consumer<Throwable> {
    private static final long serialVersionUID = -4361286194466301354L;
    final C8083a onComplete;
    final Consumer<? super Throwable> onError;

    public CallbackCompletableObserver(C8083a aVar) {
        this.onError = this;
        this.onComplete = aVar;
    }

    public CallbackCompletableObserver(Consumer<? super Throwable> gVar, C8083a aVar) {
        this.onError = gVar;
        this.onComplete = aVar;
    }

    public void accept(Throwable th) {
        RxJavaPlugins.m34959a((Throwable) new OnErrorNotImplementedException(th));
    }

    public void onComplete() {
        try {
            this.onComplete.mo19849a();
        } catch (Throwable th) {
            Exceptions.m34944b(th);
            RxJavaPlugins.m34959a(th);
        }
        lazySet(DisposableHelper.DISPOSED);
    }

    public void onError(Throwable th) {
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            Exceptions.m34944b(th2);
            RxJavaPlugins.m34959a(th2);
        }
        lazySet(DisposableHelper.DISPOSED);
    }

    public void onSubscribe(Disposable bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    public boolean hasCustomOnError() {
        return this.onError != this;
    }
}
