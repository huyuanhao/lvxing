package p655io.reactivex.internal.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.p705b.Subscription;
import p655io.reactivex.internal.p669a.ObjectHelper;
import p655io.reactivex.internal.util.BackpressureHelper;

/* renamed from: io.reactivex.internal.subscriptions.SubscriptionArbiter */
public class SubscriptionArbiter extends AtomicInteger implements Subscription {
    private static final long serialVersionUID = -2189523197179400958L;
    Subscription actual;
    volatile boolean cancelled;
    final AtomicLong missedProduced = new AtomicLong();
    final AtomicLong missedRequested = new AtomicLong();
    final AtomicReference<Subscription> missedSubscription = new AtomicReference<>();
    long requested;
    protected boolean unbounded;

    public final void setSubscription(Subscription cVar) {
        if (this.cancelled) {
            cVar.cancel();
            return;
        }
        ObjectHelper.m35048a(cVar, "s is null");
        if (get() != 0 || !compareAndSet(0, 1)) {
            Subscription cVar2 = (Subscription) this.missedSubscription.getAndSet(cVar);
            if (cVar2 != null) {
                cVar2.cancel();
            }
            drain();
            return;
        }
        Subscription cVar3 = this.actual;
        if (cVar3 != null) {
            cVar3.cancel();
        }
        this.actual = cVar;
        long j = this.requested;
        if (decrementAndGet() != 0) {
            drainLoop();
        }
        if (j != 0) {
            cVar.request(j);
        }
    }

    public final void request(long j) {
        if (SubscriptionHelper.validate(j) && !this.unbounded) {
            if (get() != 0 || !compareAndSet(0, 1)) {
                BackpressureHelper.m35177a(this.missedRequested, j);
                drain();
                return;
            }
            long j2 = this.requested;
            if (j2 != Long.MAX_VALUE) {
                long a = BackpressureHelper.m35176a(j2, j);
                this.requested = a;
                if (a == Long.MAX_VALUE) {
                    this.unbounded = true;
                }
            }
            Subscription cVar = this.actual;
            if (decrementAndGet() != 0) {
                drainLoop();
            }
            if (cVar != null) {
                cVar.request(j);
            }
        }
    }

    public final void produced(long j) {
        if (!this.unbounded) {
            if (get() != 0 || !compareAndSet(0, 1)) {
                BackpressureHelper.m35177a(this.missedProduced, j);
                drain();
                return;
            }
            long j2 = this.requested;
            if (j2 != Long.MAX_VALUE) {
                long j3 = j2 - j;
                long j4 = 0;
                if (j3 < 0) {
                    SubscriptionHelper.reportMoreProduced(j3);
                } else {
                    j4 = j3;
                }
                this.requested = j4;
            }
            if (decrementAndGet() != 0) {
                drainLoop();
            }
        }
    }

    public void cancel() {
        if (!this.cancelled) {
            this.cancelled = true;
            drain();
        }
    }

    /* access modifiers changed from: final */
    public final void drain() {
        if (getAndIncrement() == 0) {
            drainLoop();
        }
    }

    /* access modifiers changed from: final */
    public final void drainLoop() {
        Subscription cVar = null;
        long j = 0;
        int i = 1;
        do {
            Subscription cVar2 = (Subscription) this.missedSubscription.get();
            if (cVar2 != null) {
                cVar2 = (Subscription) this.missedSubscription.getAndSet(null);
            }
            long j2 = this.missedRequested.get();
            if (j2 != 0) {
                j2 = this.missedRequested.getAndSet(0);
            }
            long j3 = this.missedProduced.get();
            if (j3 != 0) {
                j3 = this.missedProduced.getAndSet(0);
            }
            Subscription cVar3 = this.actual;
            if (this.cancelled) {
                if (cVar3 != null) {
                    cVar3.cancel();
                    this.actual = null;
                }
                if (cVar2 != null) {
                    cVar2.cancel();
                }
            } else {
                long j4 = this.requested;
                if (j4 != Long.MAX_VALUE) {
                    j4 = BackpressureHelper.m35176a(j4, j2);
                    if (j4 != Long.MAX_VALUE) {
                        long j5 = j4 - j3;
                        if (j5 < 0) {
                            SubscriptionHelper.reportMoreProduced(j5);
                            j5 = 0;
                        }
                        j4 = j5;
                    }
                    this.requested = j4;
                }
                if (cVar2 != null) {
                    if (cVar3 != null) {
                        cVar3.cancel();
                    }
                    this.actual = cVar2;
                    if (j4 != 0) {
                        j = BackpressureHelper.m35176a(j, j4);
                        cVar = cVar2;
                    }
                } else if (!(cVar3 == null || j2 == 0)) {
                    j = BackpressureHelper.m35176a(j, j2);
                    cVar = cVar3;
                }
            }
            i = addAndGet(-i);
        } while (i != 0);
        if (j != 0) {
            cVar.request(j);
        }
    }

    public final boolean isUnbounded() {
        return this.unbounded;
    }

    public final boolean isCancelled() {
        return this.cancelled;
    }
}
