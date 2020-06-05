package p655io.reactivex.internal.subscriptions;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.p705b.Subscription;
import p655io.reactivex.exceptions.ProtocolViolationException;
import p655io.reactivex.internal.p669a.ObjectHelper;
import p655io.reactivex.internal.util.BackpressureHelper;
import p655io.reactivex.p666f.RxJavaPlugins;

/* renamed from: io.reactivex.internal.subscriptions.SubscriptionHelper */
public enum SubscriptionHelper implements Subscription {
    CANCELLED;

    public void cancel() {
    }

    public void request(long j) {
    }

    public static boolean validate(Subscription cVar, Subscription cVar2) {
        if (cVar2 == null) {
            RxJavaPlugins.m34959a((Throwable) new NullPointerException("next is null"));
            return false;
        } else if (cVar == null) {
            return true;
        } else {
            cVar2.cancel();
            reportSubscriptionSet();
            return false;
        }
    }

    public static void reportSubscriptionSet() {
        RxJavaPlugins.m34959a((Throwable) new ProtocolViolationException("Subscription already set!"));
    }

    public static boolean validate(long j) {
        if (j > 0) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("n > 0 required but it was ");
        sb.append(j);
        RxJavaPlugins.m34959a((Throwable) new IllegalArgumentException(sb.toString()));
        return false;
    }

    public static void reportMoreProduced(long j) {
        StringBuilder sb = new StringBuilder();
        sb.append("More produced than requested: ");
        sb.append(j);
        RxJavaPlugins.m34959a((Throwable) new ProtocolViolationException(sb.toString()));
    }

    public static boolean isCancelled(Subscription cVar) {
        return cVar == CANCELLED;
    }

    public static boolean set(AtomicReference<Subscription> atomicReference, Subscription cVar) {
        Subscription cVar2;
        do {
            cVar2 = (Subscription) atomicReference.get();
            if (cVar2 == CANCELLED) {
                if (cVar != null) {
                    cVar.cancel();
                }
                return false;
            }
        } while (!atomicReference.compareAndSet(cVar2, cVar));
        if (cVar2 != null) {
            cVar2.cancel();
        }
        return true;
    }

    public static boolean setOnce(AtomicReference<Subscription> atomicReference, Subscription cVar) {
        ObjectHelper.m35048a(cVar, "s is null");
        if (atomicReference.compareAndSet(null, cVar)) {
            return true;
        }
        cVar.cancel();
        if (atomicReference.get() != CANCELLED) {
            reportSubscriptionSet();
        }
        return false;
    }

    public static boolean replace(AtomicReference<Subscription> atomicReference, Subscription cVar) {
        Subscription cVar2;
        do {
            cVar2 = (Subscription) atomicReference.get();
            if (cVar2 == CANCELLED) {
                if (cVar != null) {
                    cVar.cancel();
                }
                return false;
            }
        } while (!atomicReference.compareAndSet(cVar2, cVar));
        return true;
    }

    public static boolean cancel(AtomicReference<Subscription> atomicReference) {
        Subscription cVar = (Subscription) atomicReference.get();
        SubscriptionHelper subscriptionHelper = CANCELLED;
        if (cVar != subscriptionHelper) {
            Subscription cVar2 = (Subscription) atomicReference.getAndSet(subscriptionHelper);
            if (cVar2 != CANCELLED) {
                if (cVar2 != null) {
                    cVar2.cancel();
                }
                return true;
            }
        }
        return false;
    }

    public static boolean deferredSetOnce(AtomicReference<Subscription> atomicReference, AtomicLong atomicLong, Subscription cVar) {
        if (!setOnce(atomicReference, cVar)) {
            return false;
        }
        long andSet = atomicLong.getAndSet(0);
        if (andSet != 0) {
            cVar.request(andSet);
        }
        return true;
    }

    public static void deferredRequest(AtomicReference<Subscription> atomicReference, AtomicLong atomicLong, long j) {
        Subscription cVar = (Subscription) atomicReference.get();
        if (cVar != null) {
            cVar.request(j);
        } else if (validate(j)) {
            BackpressureHelper.m35177a(atomicLong, j);
            Subscription cVar2 = (Subscription) atomicReference.get();
            if (cVar2 != null) {
                long andSet = atomicLong.getAndSet(0);
                if (andSet != 0) {
                    cVar2.request(andSet);
                }
            }
        }
    }

    public static boolean setOnce(AtomicReference<Subscription> atomicReference, Subscription cVar, long j) {
        if (!setOnce(atomicReference, cVar)) {
            return false;
        }
        cVar.request(j);
        return true;
    }
}
