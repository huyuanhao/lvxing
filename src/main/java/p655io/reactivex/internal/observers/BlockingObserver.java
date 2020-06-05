package p655io.reactivex.internal.observers;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;
import p655io.reactivex.Observer;
import p655io.reactivex.internal.disposables.DisposableHelper;
import p655io.reactivex.internal.util.NotificationLite;
import p655io.reactivex.p662b.Disposable;

/* renamed from: io.reactivex.internal.observers.BlockingObserver */
public final class BlockingObserver<T> extends AtomicReference<Disposable> implements Disposable, Observer<T> {
    public static final Object TERMINATED = new Object();
    private static final long serialVersionUID = -4875965440900746268L;
    final Queue<Object> queue;

    public BlockingObserver(Queue<Object> queue2) {
        this.queue = queue2;
    }

    public void onSubscribe(Disposable bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    public void onNext(T t) {
        this.queue.offer(NotificationLite.next(t));
    }

    public void onError(Throwable th) {
        this.queue.offer(NotificationLite.error(th));
    }

    public void onComplete() {
        this.queue.offer(NotificationLite.complete());
    }

    public void dispose() {
        if (DisposableHelper.dispose(this)) {
            this.queue.offer(TERMINATED);
        }
    }

    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }
}
