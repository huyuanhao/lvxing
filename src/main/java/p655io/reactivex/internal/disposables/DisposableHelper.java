package p655io.reactivex.internal.disposables;

import java.util.concurrent.atomic.AtomicReference;
import p655io.reactivex.exceptions.ProtocolViolationException;
import p655io.reactivex.internal.p669a.ObjectHelper;
import p655io.reactivex.p662b.Disposable;
import p655io.reactivex.p666f.RxJavaPlugins;

/* renamed from: io.reactivex.internal.disposables.DisposableHelper */
public enum DisposableHelper implements Disposable {
    DISPOSED;

    public void dispose() {
    }

    public boolean isDisposed() {
        return true;
    }

    public static boolean isDisposed(Disposable bVar) {
        return bVar == DISPOSED;
    }

    public static boolean set(AtomicReference<Disposable> atomicReference, Disposable bVar) {
        Disposable bVar2;
        do {
            bVar2 = (Disposable) atomicReference.get();
            if (bVar2 == DISPOSED) {
                if (bVar != null) {
                    bVar.dispose();
                }
                return false;
            }
        } while (!atomicReference.compareAndSet(bVar2, bVar));
        if (bVar2 != null) {
            bVar2.dispose();
        }
        return true;
    }

    public static boolean setOnce(AtomicReference<Disposable> atomicReference, Disposable bVar) {
        ObjectHelper.m35048a(bVar, "d is null");
        if (atomicReference.compareAndSet(null, bVar)) {
            return true;
        }
        bVar.dispose();
        if (atomicReference.get() != DISPOSED) {
            reportDisposableSet();
        }
        return false;
    }

    public static boolean replace(AtomicReference<Disposable> atomicReference, Disposable bVar) {
        Disposable bVar2;
        do {
            bVar2 = (Disposable) atomicReference.get();
            if (bVar2 == DISPOSED) {
                if (bVar != null) {
                    bVar.dispose();
                }
                return false;
            }
        } while (!atomicReference.compareAndSet(bVar2, bVar));
        return true;
    }

    public static boolean dispose(AtomicReference<Disposable> atomicReference) {
        Disposable bVar = (Disposable) atomicReference.get();
        DisposableHelper disposableHelper = DISPOSED;
        if (bVar != disposableHelper) {
            Disposable bVar2 = (Disposable) atomicReference.getAndSet(disposableHelper);
            if (bVar2 != disposableHelper) {
                if (bVar2 != null) {
                    bVar2.dispose();
                }
                return true;
            }
        }
        return false;
    }

    public static boolean validate(Disposable bVar, Disposable bVar2) {
        if (bVar2 == null) {
            RxJavaPlugins.m34959a((Throwable) new NullPointerException("next is null"));
            return false;
        } else if (bVar == null) {
            return true;
        } else {
            bVar2.dispose();
            reportDisposableSet();
            return false;
        }
    }

    public static void reportDisposableSet() {
        RxJavaPlugins.m34959a((Throwable) new ProtocolViolationException("Disposable already set!"));
    }

    public static boolean trySet(AtomicReference<Disposable> atomicReference, Disposable bVar) {
        if (atomicReference.compareAndSet(null, bVar)) {
            return true;
        }
        if (atomicReference.get() == DISPOSED) {
            bVar.dispose();
        }
        return false;
    }
}
