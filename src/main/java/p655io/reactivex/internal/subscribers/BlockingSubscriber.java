package p655io.reactivex.internal.subscribers;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;
import org.p705b.Subscription;
import p655io.reactivex.C8085e;
import p655io.reactivex.internal.subscriptions.SubscriptionHelper;
import p655io.reactivex.internal.util.NotificationLite;

/* renamed from: io.reactivex.internal.subscribers.BlockingSubscriber */
public final class BlockingSubscriber<T> extends AtomicReference<Subscription> implements C8085e<T>, Subscription {
    public static final Object TERMINATED = new Object();
    private static final long serialVersionUID = -4875965440900746268L;
    final Queue<Object> queue;

    public BlockingSubscriber(Queue<Object> queue2) {
        this.queue = queue2;
    }

    public void onSubscribe(Subscription cVar) {
        if (SubscriptionHelper.setOnce(this, cVar)) {
            this.queue.offer(NotificationLite.subscription(this));
        }
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

    public void request(long j) {
        ((Subscription) get()).request(j);
    }

    public void cancel() {
        if (SubscriptionHelper.cancel(this)) {
            this.queue.offer(TERMINATED);
        }
    }

    public boolean isCancelled() {
        return get() == SubscriptionHelper.CANCELLED;
    }
}
