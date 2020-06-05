package com.uber.autodispose;

import java.util.concurrent.atomic.AtomicReference;
import p655io.reactivex.exceptions.CompositeException;

/* renamed from: com.uber.autodispose.j */
final class ExceptionHelper {
    /* renamed from: a */
    private static final Throwable f25997a = new C7704a();

    /* compiled from: ExceptionHelper */
    /* renamed from: com.uber.autodispose.j$a */
    static final class C7704a extends Throwable {
        C7704a() {
            super("No further exceptions");
        }

        public synchronized Throwable fillInStackTrace() {
            return this;
        }
    }

    /* renamed from: a */
    static boolean m33089a(AtomicReference<Throwable> atomicReference, Throwable th) {
        Throwable th2;
        Throwable th3;
        do {
            th2 = (Throwable) atomicReference.get();
            if (th2 == f25997a) {
                return false;
            }
            if (th2 == null) {
                th3 = th;
            } else {
                th3 = new CompositeException(th2, th);
            }
        } while (!atomicReference.compareAndSet(th2, th3));
        return true;
    }

    /* renamed from: a */
    static Throwable m33088a(AtomicReference<Throwable> atomicReference) {
        Throwable th = (Throwable) atomicReference.get();
        Throwable th2 = f25997a;
        return th != th2 ? (Throwable) atomicReference.getAndSet(th2) : th;
    }
}
