package p655io.reactivex.internal.observers;

import java.util.concurrent.atomic.AtomicReference;
import p655io.reactivex.Observer;
import p655io.reactivex.internal.disposables.DisposableHelper;
import p655io.reactivex.internal.p670b.QueueDisposable;
import p655io.reactivex.internal.p670b.SimpleQueue;
import p655io.reactivex.internal.util.QueueDrainHelper;
import p655io.reactivex.p662b.Disposable;

/* renamed from: io.reactivex.internal.observers.InnerQueuedObserver */
public final class InnerQueuedObserver<T> extends AtomicReference<Disposable> implements Disposable, Observer<T> {
    private static final long serialVersionUID = -5417183359794346637L;
    volatile boolean done;
    int fusionMode;
    final InnerQueuedObserverSupport<T> parent;
    final int prefetch;
    SimpleQueue<T> queue;

    public InnerQueuedObserver(InnerQueuedObserverSupport<T> dVar, int i) {
        this.parent = dVar;
        this.prefetch = i;
    }

    public void onSubscribe(Disposable bVar) {
        if (DisposableHelper.setOnce(this, bVar)) {
            if (bVar instanceof QueueDisposable) {
                QueueDisposable aVar = (QueueDisposable) bVar;
                int requestFusion = aVar.requestFusion(3);
                if (requestFusion == 1) {
                    this.fusionMode = requestFusion;
                    this.queue = aVar;
                    this.done = true;
                    this.parent.mo38958a(this);
                    return;
                } else if (requestFusion == 2) {
                    this.fusionMode = requestFusion;
                    this.queue = aVar;
                    return;
                }
            }
            this.queue = QueueDrainHelper.m35195a(-this.prefetch);
        }
    }

    public void onNext(T t) {
        if (this.fusionMode == 0) {
            this.parent.mo38959a(this, t);
        } else {
            this.parent.mo38957a();
        }
    }

    public void onError(Throwable th) {
        this.parent.mo38960a(this, th);
    }

    public void onComplete() {
        this.parent.mo38958a(this);
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    public boolean isDone() {
        return this.done;
    }

    public void setDone() {
        this.done = true;
    }

    public SimpleQueue<T> queue() {
        return this.queue;
    }

    public int fusionMode() {
        return this.fusionMode;
    }
}
