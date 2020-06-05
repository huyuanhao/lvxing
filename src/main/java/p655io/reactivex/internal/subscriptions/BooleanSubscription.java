package p655io.reactivex.internal.subscriptions;

import java.util.concurrent.atomic.AtomicBoolean;
import org.p705b.Subscription;

/* renamed from: io.reactivex.internal.subscriptions.BooleanSubscription */
public final class BooleanSubscription extends AtomicBoolean implements Subscription {
    private static final long serialVersionUID = -8127758972444290902L;

    public void request(long j) {
        SubscriptionHelper.validate(j);
    }

    public void cancel() {
        lazySet(true);
    }

    public boolean isCancelled() {
        return get();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BooleanSubscription(cancelled=");
        sb.append(get());
        sb.append(")");
        return sb.toString();
    }
}
