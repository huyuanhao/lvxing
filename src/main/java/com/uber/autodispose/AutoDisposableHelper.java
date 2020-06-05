package com.uber.autodispose;

import java.util.concurrent.atomic.AtomicReference;
import p655io.reactivex.p662b.Disposable;

/* renamed from: com.uber.autodispose.b */
enum AutoDisposableHelper implements Disposable {
    DISPOSED;

    public void dispose() {
    }

    public boolean isDisposed() {
        return true;
    }

    static boolean dispose(AtomicReference<Disposable> atomicReference) {
        Disposable bVar = (Disposable) atomicReference.get();
        AutoDisposableHelper bVar2 = DISPOSED;
        if (bVar != bVar2) {
            Disposable bVar3 = (Disposable) atomicReference.getAndSet(bVar2);
            if (bVar3 != bVar2) {
                if (bVar3 != null) {
                    bVar3.dispose();
                }
                return true;
            }
        }
        return false;
    }
}
