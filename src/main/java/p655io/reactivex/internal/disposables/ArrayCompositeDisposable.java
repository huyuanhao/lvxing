package p655io.reactivex.internal.disposables;

import java.util.concurrent.atomic.AtomicReferenceArray;
import p655io.reactivex.p662b.Disposable;

/* renamed from: io.reactivex.internal.disposables.ArrayCompositeDisposable */
public final class ArrayCompositeDisposable extends AtomicReferenceArray<Disposable> implements Disposable {
    private static final long serialVersionUID = 2746389416410565408L;

    public ArrayCompositeDisposable(int i) {
        super(i);
    }

    public boolean setResource(int i, Disposable bVar) {
        Disposable bVar2;
        do {
            bVar2 = (Disposable) get(i);
            if (bVar2 == DisposableHelper.DISPOSED) {
                bVar.dispose();
                return false;
            }
        } while (!compareAndSet(i, bVar2, bVar));
        if (bVar2 != null) {
            bVar2.dispose();
        }
        return true;
    }

    public Disposable replaceResource(int i, Disposable bVar) {
        Disposable bVar2;
        do {
            bVar2 = (Disposable) get(i);
            if (bVar2 == DisposableHelper.DISPOSED) {
                bVar.dispose();
                return null;
            }
        } while (!compareAndSet(i, bVar2, bVar));
        return bVar2;
    }

    public void dispose() {
        if (get(0) != DisposableHelper.DISPOSED) {
            int length = length();
            for (int i = 0; i < length; i++) {
                if (((Disposable) get(i)) != DisposableHelper.DISPOSED) {
                    Disposable bVar = (Disposable) getAndSet(i, DisposableHelper.DISPOSED);
                    if (!(bVar == DisposableHelper.DISPOSED || bVar == null)) {
                        bVar.dispose();
                    }
                }
            }
        }
    }

    public boolean isDisposed() {
        return get(0) == DisposableHelper.DISPOSED;
    }
}
