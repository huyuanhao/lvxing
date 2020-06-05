package p655io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicReference;
import p655io.reactivex.Observer;
import p655io.reactivex.internal.disposables.DisposableHelper;
import p655io.reactivex.p662b.Disposable;

/* renamed from: io.reactivex.internal.operators.observable.ObserverResourceWrapper */
public final class ObserverResourceWrapper<T> extends AtomicReference<Disposable> implements Disposable, Observer<T> {
    private static final long serialVersionUID = -8612022020200669122L;
    final Observer<? super T> downstream;
    final AtomicReference<Disposable> upstream = new AtomicReference<>();

    public ObserverResourceWrapper(Observer<? super T> lVar) {
        this.downstream = lVar;
    }

    public void onSubscribe(Disposable bVar) {
        if (DisposableHelper.setOnce(this.upstream, bVar)) {
            this.downstream.onSubscribe(this);
        }
    }

    public void onNext(T t) {
        this.downstream.onNext(t);
    }

    public void onError(Throwable th) {
        dispose();
        this.downstream.onError(th);
    }

    public void onComplete() {
        dispose();
        this.downstream.onComplete();
    }

    public void dispose() {
        DisposableHelper.dispose(this.upstream);
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return this.upstream.get() == DisposableHelper.DISPOSED;
    }

    public void setResource(Disposable bVar) {
        DisposableHelper.set(this, bVar);
    }
}
