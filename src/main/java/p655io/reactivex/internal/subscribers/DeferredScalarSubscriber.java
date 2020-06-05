package p655io.reactivex.internal.subscribers;

import org.p705b.Subscriber;
import org.p705b.Subscription;
import p655io.reactivex.C8085e;
import p655io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import p655io.reactivex.internal.subscriptions.SubscriptionHelper;

/* renamed from: io.reactivex.internal.subscribers.DeferredScalarSubscriber */
public abstract class DeferredScalarSubscriber<T, R> extends DeferredScalarSubscription<R> implements C8085e<T> {
    private static final long serialVersionUID = 2984505488220891551L;
    protected boolean hasValue;
    protected Subscription upstream;

    public DeferredScalarSubscriber(Subscriber<? super R> bVar) {
        super(bVar);
    }

    public void onSubscribe(Subscription cVar) {
        if (SubscriptionHelper.validate(this.upstream, cVar)) {
            this.upstream = cVar;
            this.downstream.onSubscribe(this);
            cVar.request(Long.MAX_VALUE);
        }
    }

    public void onError(Throwable th) {
        this.value = null;
        this.downstream.onError(th);
    }

    public void onComplete() {
        if (this.hasValue) {
            complete(this.value);
        } else {
            this.downstream.onComplete();
        }
    }

    public void cancel() {
        super.cancel();
        this.upstream.cancel();
    }
}
