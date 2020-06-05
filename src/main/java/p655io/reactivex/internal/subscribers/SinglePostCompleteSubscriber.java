package p655io.reactivex.internal.subscribers;

import java.util.concurrent.atomic.AtomicLong;
import org.p705b.Subscriber;
import org.p705b.Subscription;
import p655io.reactivex.C8085e;
import p655io.reactivex.internal.subscriptions.SubscriptionHelper;
import p655io.reactivex.internal.util.BackpressureHelper;

/* renamed from: io.reactivex.internal.subscribers.SinglePostCompleteSubscriber */
public abstract class SinglePostCompleteSubscriber<T, R> extends AtomicLong implements C8085e<T>, Subscription {
    static final long COMPLETE_MASK = Long.MIN_VALUE;
    static final long REQUEST_MASK = Long.MAX_VALUE;
    private static final long serialVersionUID = 7917814472626990048L;
    protected final Subscriber<? super R> downstream;
    protected long produced;
    protected Subscription upstream;
    protected R value;

    /* access modifiers changed from: protected */
    public void onDrop(R r) {
    }

    public SinglePostCompleteSubscriber(Subscriber<? super R> bVar) {
        this.downstream = bVar;
    }

    public void onSubscribe(Subscription cVar) {
        if (SubscriptionHelper.validate(this.upstream, cVar)) {
            this.upstream = cVar;
            this.downstream.onSubscribe(this);
        }
    }

    /* access modifiers changed from: protected|final */
    public final void complete(R r) {
        long j = this.produced;
        if (j != 0) {
            BackpressureHelper.m35178b(this, j);
        }
        while (true) {
            long j2 = get();
            if ((j2 & COMPLETE_MASK) != 0) {
                onDrop(r);
                return;
            } else if ((j2 & REQUEST_MASK) != 0) {
                lazySet(-9223372036854775807L);
                this.downstream.onNext(r);
                this.downstream.onComplete();
                return;
            } else {
                this.value = r;
                if (!compareAndSet(0, COMPLETE_MASK)) {
                    this.value = null;
                } else {
                    return;
                }
            }
        }
    }

    public final void request(long j) {
        long j2;
        if (SubscriptionHelper.validate(j)) {
            do {
                j2 = get();
                if ((j2 & COMPLETE_MASK) != 0) {
                    if (compareAndSet(COMPLETE_MASK, -9223372036854775807L)) {
                        this.downstream.onNext(this.value);
                        this.downstream.onComplete();
                        return;
                    }
                    return;
                }
            } while (!compareAndSet(j2, BackpressureHelper.m35176a(j2, j)));
            this.upstream.request(j);
        }
    }

    public void cancel() {
        this.upstream.cancel();
    }
}
