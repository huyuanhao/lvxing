package com.uber.autodispose;

import com.uber.autodispose.p618a.C7694a;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p655io.reactivex.CompletableSource;
import p655io.reactivex.Observer;
import p655io.reactivex.observers.DisposableCompletableObserver;
import p655io.reactivex.p662b.Disposable;

/* renamed from: com.uber.autodispose.i */
final class AutoDisposingObserverImpl<T> extends AtomicInteger implements C7694a<T> {
    private final Observer<? super T> delegate;
    private final AtomicThrowable error = new AtomicThrowable();
    final AtomicReference<Disposable> mainDisposable = new AtomicReference<>();
    private final CompletableSource scope;
    final AtomicReference<Disposable> scopeDisposable = new AtomicReference<>();

    AutoDisposingObserverImpl(CompletableSource cVar, Observer<? super T> lVar) {
        this.scope = cVar;
        this.delegate = lVar;
    }

    public Observer<? super T> delegateObserver() {
        return this.delegate;
    }

    public void onSubscribe(Disposable bVar) {
        C77031 r0 = new DisposableCompletableObserver() {
            public void onError(Throwable th) {
                AutoDisposingObserverImpl.this.scopeDisposable.lazySet(AutoDisposableHelper.DISPOSED);
                AutoDisposingObserverImpl.this.onError(th);
            }

            public void onComplete() {
                AutoDisposingObserverImpl.this.scopeDisposable.lazySet(AutoDisposableHelper.DISPOSED);
                AutoDisposableHelper.dispose(AutoDisposingObserverImpl.this.mainDisposable);
            }
        };
        if (AutoDisposeEndConsumerHelper.m33083a(this.scopeDisposable, r0, getClass())) {
            this.delegate.onSubscribe(this);
            this.scope.mo38816a(r0);
            AutoDisposeEndConsumerHelper.m33083a(this.mainDisposable, bVar, getClass());
        }
    }

    public boolean isDisposed() {
        return this.mainDisposable.get() == AutoDisposableHelper.DISPOSED;
    }

    public void dispose() {
        AutoDisposableHelper.dispose(this.scopeDisposable);
        AutoDisposableHelper.dispose(this.mainDisposable);
    }

    public void onNext(T t) {
        if (!isDisposed() && HalfSerializer.m33092a(this.delegate, t, (AtomicInteger) this, this.error)) {
            this.mainDisposable.lazySet(AutoDisposableHelper.DISPOSED);
            AutoDisposableHelper.dispose(this.scopeDisposable);
        }
    }

    public void onError(Throwable th) {
        if (!isDisposed()) {
            this.mainDisposable.lazySet(AutoDisposableHelper.DISPOSED);
            AutoDisposableHelper.dispose(this.scopeDisposable);
            HalfSerializer.m33090a(this.delegate, th, (AtomicInteger) this, this.error);
        }
    }

    public void onComplete() {
        if (!isDisposed()) {
            this.mainDisposable.lazySet(AutoDisposableHelper.DISPOSED);
            AutoDisposableHelper.dispose(this.scopeDisposable);
            HalfSerializer.m33091a(this.delegate, this, this.error);
        }
    }
}
