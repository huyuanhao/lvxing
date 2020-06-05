package p655io.reactivex.internal.subscriptions;

import java.util.concurrent.atomic.AtomicReferenceArray;
import org.p705b.Subscription;
import p655io.reactivex.p662b.Disposable;

/* renamed from: io.reactivex.internal.subscriptions.ArrayCompositeSubscription */
public final class ArrayCompositeSubscription extends AtomicReferenceArray<Subscription> implements Disposable {
    private static final long serialVersionUID = 2746389416410565408L;

    public ArrayCompositeSubscription(int i) {
        super(i);
    }

    public boolean setResource(int i, Subscription cVar) {
        Subscription cVar2;
        do {
            cVar2 = (Subscription) get(i);
            if (cVar2 == SubscriptionHelper.CANCELLED) {
                if (cVar != null) {
                    cVar.cancel();
                }
                return false;
            }
        } while (!compareAndSet(i, cVar2, cVar));
        if (cVar2 != null) {
            cVar2.cancel();
        }
        return true;
    }

    public Subscription replaceResource(int i, Subscription cVar) {
        Subscription cVar2;
        do {
            cVar2 = (Subscription) get(i);
            if (cVar2 == SubscriptionHelper.CANCELLED) {
                if (cVar != null) {
                    cVar.cancel();
                }
                return null;
            }
        } while (!compareAndSet(i, cVar2, cVar));
        return cVar2;
    }

    public void dispose() {
        if (get(0) != SubscriptionHelper.CANCELLED) {
            int length = length();
            for (int i = 0; i < length; i++) {
                if (((Subscription) get(i)) != SubscriptionHelper.CANCELLED) {
                    Subscription cVar = (Subscription) getAndSet(i, SubscriptionHelper.CANCELLED);
                    if (!(cVar == SubscriptionHelper.CANCELLED || cVar == null)) {
                        cVar.cancel();
                    }
                }
            }
        }
    }

    public boolean isDisposed() {
        return get(0) == SubscriptionHelper.CANCELLED;
    }
}
