package p655io.reactivex.internal.disposables;

import java.util.concurrent.atomic.AtomicReference;
import p655io.reactivex.exceptions.Exceptions;
import p655io.reactivex.p662b.Disposable;
import p655io.reactivex.p664d.Cancellable;
import p655io.reactivex.p666f.RxJavaPlugins;

/* renamed from: io.reactivex.internal.disposables.CancellableDisposable */
public final class CancellableDisposable extends AtomicReference<Cancellable> implements Disposable {
    private static final long serialVersionUID = 5718521705281392066L;

    public CancellableDisposable(Cancellable fVar) {
        super(fVar);
    }

    public boolean isDisposed() {
        return get() == null;
    }

    public void dispose() {
        if (get() != null) {
            Cancellable fVar = (Cancellable) getAndSet(null);
            if (fVar != null) {
                try {
                    fVar.mo38842a();
                } catch (Exception e) {
                    Exceptions.m34944b(e);
                    RxJavaPlugins.m34959a((Throwable) e);
                }
            }
        }
    }
}
