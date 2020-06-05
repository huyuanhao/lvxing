package p655io.reactivex.internal.subscriptions;

import org.p705b.Subscriber;
import p655io.reactivex.internal.p670b.QueueSubscription;

/* renamed from: io.reactivex.internal.subscriptions.EmptySubscription */
public enum EmptySubscription implements QueueSubscription<Object> {
    INSTANCE;

    public void cancel() {
    }

    public void clear() {
    }

    public boolean isEmpty() {
        return true;
    }

    public Object poll() {
        return null;
    }

    public int requestFusion(int i) {
        return i & 2;
    }

    public String toString() {
        return "EmptySubscription";
    }

    public void request(long j) {
        SubscriptionHelper.validate(j);
    }

    public static void error(Throwable th, Subscriber<?> bVar) {
        bVar.onSubscribe(INSTANCE);
        bVar.onError(th);
    }

    public static void complete(Subscriber<?> bVar) {
        bVar.onSubscribe(INSTANCE);
        bVar.onComplete();
    }

    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
