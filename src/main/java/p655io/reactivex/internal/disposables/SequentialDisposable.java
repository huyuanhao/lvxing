package p655io.reactivex.internal.disposables;

import java.util.concurrent.atomic.AtomicReference;
import p655io.reactivex.p662b.Disposable;

/* renamed from: io.reactivex.internal.disposables.SequentialDisposable */
public final class SequentialDisposable extends AtomicReference<Disposable> implements Disposable {
    private static final long serialVersionUID = -754898800686245608L;

    public SequentialDisposable() {
    }

    public SequentialDisposable(Disposable bVar) {
        lazySet(bVar);
    }

    public boolean update(Disposable bVar) {
        return DisposableHelper.set(this, bVar);
    }

    public boolean replace(Disposable bVar) {
        return DisposableHelper.replace(this, bVar);
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }
}
