package p655io.reactivex.internal.subscribers;

import java.util.concurrent.atomic.AtomicReference;
import org.p705b.Subscription;
import p655io.reactivex.C8085e;
import p655io.reactivex.internal.p670b.QueueSubscription;
import p655io.reactivex.internal.p670b.SimpleQueue;
import p655io.reactivex.internal.subscriptions.SubscriptionHelper;
import p655io.reactivex.internal.util.QueueDrainHelper;

/* renamed from: io.reactivex.internal.subscribers.InnerQueuedSubscriber */
public final class InnerQueuedSubscriber<T> extends AtomicReference<Subscription> implements C8085e<T>, Subscription {
    private static final long serialVersionUID = 22876611072430776L;
    volatile boolean done;
    int fusionMode;
    final int limit;
    final InnerQueuedSubscriberSupport<T> parent;
    final int prefetch;
    long produced;
    volatile SimpleQueue<T> queue;

    public InnerQueuedSubscriber(InnerQueuedSubscriberSupport<T> aVar, int i) {
        this.parent = aVar;
        this.prefetch = i;
        this.limit = i - (i >> 2);
    }

    public void onSubscribe(Subscription cVar) {
        if (SubscriptionHelper.setOnce(this, cVar)) {
            if (cVar instanceof QueueSubscription) {
                QueueSubscription cVar2 = (QueueSubscription) cVar;
                int requestFusion = cVar2.requestFusion(3);
                if (requestFusion == 1) {
                    this.fusionMode = requestFusion;
                    this.queue = cVar2;
                    this.done = true;
                    this.parent.mo39081a(this);
                    return;
                } else if (requestFusion == 2) {
                    this.fusionMode = requestFusion;
                    this.queue = cVar2;
                    QueueDrainHelper.m35196a(cVar, this.prefetch);
                    return;
                }
            }
            this.queue = QueueDrainHelper.m35195a(this.prefetch);
            QueueDrainHelper.m35196a(cVar, this.prefetch);
        }
    }

    public void onNext(T t) {
        if (this.fusionMode == 0) {
            this.parent.mo39082a(this, t);
        } else {
            this.parent.mo39080a();
        }
    }

    public void onError(Throwable th) {
        this.parent.mo39083a(this, th);
    }

    public void onComplete() {
        this.parent.mo39081a(this);
    }

    public void request(long j) {
        if (this.fusionMode != 1) {
            long j2 = this.produced + j;
            if (j2 >= ((long) this.limit)) {
                this.produced = 0;
                ((Subscription) get()).request(j2);
                return;
            }
            this.produced = j2;
        }
    }

    public void requestOne() {
        if (this.fusionMode != 1) {
            long j = this.produced + 1;
            if (j == ((long) this.limit)) {
                this.produced = 0;
                ((Subscription) get()).request(j);
                return;
            }
            this.produced = j;
        }
    }

    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    public boolean isDone() {
        return this.done;
    }

    public void setDone() {
        this.done = true;
    }

    public SimpleQueue<T> queue() {
        return this.queue;
    }
}
