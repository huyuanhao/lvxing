package p655io.reactivex.internal.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import org.p705b.Subscriber;
import p655io.reactivex.internal.p670b.QueueSubscription;

/* renamed from: io.reactivex.internal.subscriptions.ScalarSubscription */
public final class ScalarSubscription<T> extends AtomicInteger implements QueueSubscription<T> {
    static final int CANCELLED = 2;
    static final int NO_REQUEST = 0;
    static final int REQUESTED = 1;
    private static final long serialVersionUID = -3830916580126663321L;
    final Subscriber<? super T> subscriber;
    final T value;

    public int requestFusion(int i) {
        return i & 1;
    }

    public ScalarSubscription(Subscriber<? super T> bVar, T t) {
        this.subscriber = bVar;
        this.value = t;
    }

    public void request(long j) {
        if (SubscriptionHelper.validate(j) && compareAndSet(0, 1)) {
            Subscriber<? super T> bVar = this.subscriber;
            bVar.onNext(this.value);
            if (get() != 2) {
                bVar.onComplete();
            }
        }
    }

    public void cancel() {
        lazySet(2);
    }

    public boolean isCancelled() {
        return get() == 2;
    }

    public boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public boolean offer(T t, T t2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public T poll() {
        if (get() != 0) {
            return null;
        }
        lazySet(1);
        return this.value;
    }

    public boolean isEmpty() {
        return get() != 0;
    }

    public void clear() {
        lazySet(1);
    }
}
