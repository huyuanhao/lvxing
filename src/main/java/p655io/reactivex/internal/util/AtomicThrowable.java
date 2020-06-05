package p655io.reactivex.internal.util;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: io.reactivex.internal.util.AtomicThrowable */
public final class AtomicThrowable extends AtomicReference<Throwable> {
    private static final long serialVersionUID = 3949248817947090603L;

    public boolean addThrowable(Throwable th) {
        return C8162d.m35184a(this, th);
    }

    public Throwable terminate() {
        return C8162d.m35183a((AtomicReference<Throwable>) this);
    }

    public boolean isTerminated() {
        return get() == C8162d.f27691a;
    }
}
