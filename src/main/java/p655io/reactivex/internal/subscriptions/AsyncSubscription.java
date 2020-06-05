package p655io.reactivex.internal.subscriptions;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.p705b.Subscription;
import p655io.reactivex.internal.disposables.DisposableHelper;
import p655io.reactivex.p662b.Disposable;

/* renamed from: io.reactivex.internal.subscriptions.AsyncSubscription */
public final class AsyncSubscription extends AtomicLong implements Disposable, Subscription {
    private static final long serialVersionUID = 7028635084060361255L;
    final AtomicReference<Subscription> actual;
    final AtomicReference<Disposable> resource;

    public AsyncSubscription() {
        this.resource = new AtomicReference<>();
        this.actual = new AtomicReference<>();
    }

    public AsyncSubscription(Disposable bVar) {
        this();
        this.resource.lazySet(bVar);
    }

    public void request(long j) {
        SubscriptionHelper.deferredRequest(this.actual, this, j);
    }

    public void cancel() {
        dispose();
    }

    public void dispose() {
        SubscriptionHelper.cancel(this.actual);
        DisposableHelper.dispose(this.resource);
    }

    public boolean isDisposed() {
        return this.actual.get() == SubscriptionHelper.CANCELLED;
    }

    public boolean setResource(Disposable bVar) {
        return DisposableHelper.set(this.resource, bVar);
    }

    public boolean replaceResource(Disposable bVar) {
        return DisposableHelper.replace(this.resource, bVar);
    }

    public void setSubscription(Subscription cVar) {
        SubscriptionHelper.deferredSetOnce(this.actual, this, cVar);
    }
}
