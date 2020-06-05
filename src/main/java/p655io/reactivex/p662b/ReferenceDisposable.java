package p655io.reactivex.p662b;

import java.util.concurrent.atomic.AtomicReference;
import p655io.reactivex.internal.p669a.ObjectHelper;

/* renamed from: io.reactivex.b.d */
abstract class ReferenceDisposable<T> extends AtomicReference<T> implements Disposable {
    private static final long serialVersionUID = 6537757548749041217L;

    public abstract void onDisposed(T t);

    ReferenceDisposable(T t) {
        super(ObjectHelper.m35048a(t, "value is null"));
    }

    public final void dispose() {
        if (get() != null) {
            Object andSet = getAndSet(null);
            if (andSet != null) {
                onDisposed(andSet);
            }
        }
    }

    public final boolean isDisposed() {
        return get() == null;
    }
}
