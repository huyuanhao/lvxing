package p655io.reactivex.internal.subscribers;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.p705b.Subscriber;
import org.p705b.Subscription;
import p655io.reactivex.C8085e;
import p655io.reactivex.internal.subscriptions.SubscriptionHelper;
import p655io.reactivex.internal.util.AtomicThrowable;
import p655io.reactivex.internal.util.C8164e;

/* renamed from: io.reactivex.internal.subscribers.StrictSubscriber */
public class StrictSubscriber<T> extends AtomicInteger implements C8085e<T>, Subscription {
    private static final long serialVersionUID = -4945028590049415624L;
    volatile boolean done;
    final Subscriber<? super T> downstream;
    final AtomicThrowable error = new AtomicThrowable();
    final AtomicBoolean once = new AtomicBoolean();
    final AtomicLong requested = new AtomicLong();
    final AtomicReference<Subscription> upstream = new AtomicReference<>();

    public StrictSubscriber(Subscriber<? super T> bVar) {
        this.downstream = bVar;
    }

    public void request(long j) {
        if (j <= 0) {
            cancel();
            StringBuilder sb = new StringBuilder();
            sb.append("§3.9 violated: positive request amount required but it was ");
            sb.append(j);
            onError(new IllegalArgumentException(sb.toString()));
            return;
        }
        SubscriptionHelper.deferredRequest(this.upstream, this.requested, j);
    }

    public void cancel() {
        if (!this.done) {
            SubscriptionHelper.cancel(this.upstream);
        }
    }

    public void onSubscribe(Subscription cVar) {
        if (this.once.compareAndSet(false, true)) {
            this.downstream.onSubscribe(this);
            SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, cVar);
            return;
        }
        cVar.cancel();
        cancel();
        onError(new IllegalStateException("§2.12 violated: onSubscribe must be called at most once"));
    }

    public void onNext(T t) {
        C8164e.m35185a(this.downstream, t, (AtomicInteger) this, this.error);
    }

    public void onError(Throwable th) {
        this.done = true;
        C8164e.m35186a(this.downstream, th, (AtomicInteger) this, this.error);
    }

    public void onComplete() {
        this.done = true;
        C8164e.m35187a(this.downstream, this, this.error);
    }
}
