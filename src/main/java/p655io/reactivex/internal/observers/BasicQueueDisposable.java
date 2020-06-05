package p655io.reactivex.internal.observers;

import p655io.reactivex.internal.p670b.QueueDisposable;

/* renamed from: io.reactivex.internal.observers.b */
public abstract class BasicQueueDisposable<T> implements QueueDisposable<T> {
    public final boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called");
    }
}
