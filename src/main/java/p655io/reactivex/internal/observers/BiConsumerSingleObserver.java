package p655io.reactivex.internal.observers;

import java.util.concurrent.atomic.AtomicReference;
import p655io.reactivex.SingleObserver;
import p655io.reactivex.exceptions.CompositeException;
import p655io.reactivex.exceptions.Exceptions;
import p655io.reactivex.internal.disposables.DisposableHelper;
import p655io.reactivex.p662b.Disposable;
import p655io.reactivex.p664d.BiConsumer;
import p655io.reactivex.p666f.RxJavaPlugins;

/* renamed from: io.reactivex.internal.observers.BiConsumerSingleObserver */
public final class BiConsumerSingleObserver<T> extends AtomicReference<Disposable> implements Disposable, SingleObserver<T> {
    private static final long serialVersionUID = 4943102778943297569L;
    final BiConsumer<? super T, ? super Throwable> onCallback;

    public BiConsumerSingleObserver(BiConsumer<? super T, ? super Throwable> bVar) {
        this.onCallback = bVar;
    }

    public void onError(Throwable th) {
        try {
            lazySet(DisposableHelper.DISPOSED);
            this.onCallback.mo38840a(null, th);
        } catch (Throwable th2) {
            Exceptions.m34944b(th2);
            RxJavaPlugins.m34959a((Throwable) new CompositeException(th, th2));
        }
    }

    public void onSubscribe(Disposable bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    public void onSuccess(T t) {
        try {
            lazySet(DisposableHelper.DISPOSED);
            this.onCallback.mo38840a(t, null);
        } catch (Throwable th) {
            Exceptions.m34944b(th);
            RxJavaPlugins.m34959a(th);
        }
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }
}
