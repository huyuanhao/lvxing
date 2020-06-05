package p655io.reactivex.internal.subscribers;

import java.util.concurrent.atomic.AtomicReference;
import org.p705b.Subscriber;
import org.p705b.Subscription;
import p655io.reactivex.C8085e;
import p655io.reactivex.internal.disposables.DisposableHelper;
import p655io.reactivex.internal.subscriptions.SubscriptionHelper;
import p655io.reactivex.p662b.Disposable;

/* renamed from: io.reactivex.internal.subscribers.SubscriberResourceWrapper */
public final class SubscriberResourceWrapper<T> extends AtomicReference<Disposable> implements Disposable, C8085e<T>, Subscription {
    private static final long serialVersionUID = -8612022020200669122L;
    final Subscriber<? super T> downstream;
    final AtomicReference<Subscription> upstream = new AtomicReference<>();

    public SubscriberResourceWrapper(Subscriber<? super T> bVar) {
        this.downstream = bVar;
    }

    public void onSubscribe(Subscription cVar) {
        if (SubscriptionHelper.setOnce(this.upstream, cVar)) {
            this.downstream.onSubscribe(this);
        }
    }

    public void onNext(T t) {
        this.downstream.onNext(t);
    }

    public void onError(Throwable th) {
        DisposableHelper.dispose(this);
        this.downstream.onError(th);
    }

    public void onComplete() {
        DisposableHelper.dispose(this);
        this.downstream.onComplete();
    }

    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            ((Subscription) this.upstream.get()).request(j);
        }
    }

    public void dispose() {
        SubscriptionHelper.cancel(this.upstream);
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return this.upstream.get() == SubscriptionHelper.CANCELLED;
    }

    public void cancel() {
        dispose();
    }

    public void setResource(Disposable bVar) {
        DisposableHelper.set(this, bVar);
    }
}
