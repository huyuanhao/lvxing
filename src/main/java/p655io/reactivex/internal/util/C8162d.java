package p655io.reactivex.internal.util;

import java.util.concurrent.atomic.AtomicReference;
import p655io.reactivex.exceptions.CompositeException;

/* compiled from: ExceptionHelper */
/* renamed from: io.reactivex.internal.util.d */
public final class C8162d {
    /* renamed from: a */
    public static final Throwable f27691a = new C8163a();

    /* compiled from: ExceptionHelper */
    /* renamed from: io.reactivex.internal.util.d$a */
    static final class C8163a extends Throwable {
        private static final long serialVersionUID = -4649703670690200604L;

        public Throwable fillInStackTrace() {
            return this;
        }

        C8163a() {
            super("No further exceptions");
        }
    }

    /* renamed from: a */
    public static RuntimeException m35182a(Throwable th) {
        if (th instanceof Error) {
            throw ((Error) th);
        } else if (th instanceof RuntimeException) {
            return (RuntimeException) th;
        } else {
            return new RuntimeException(th);
        }
    }

    /* renamed from: a */
    public static <T> boolean m35184a(AtomicReference<Throwable> atomicReference, Throwable th) {
        Throwable th2;
        Throwable th3;
        do {
            th2 = (Throwable) atomicReference.get();
            if (th2 == f27691a) {
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
    public static <T> Throwable m35183a(AtomicReference<Throwable> atomicReference) {
        Throwable th = (Throwable) atomicReference.get();
        Throwable th2 = f27691a;
        return th != th2 ? (Throwable) atomicReference.getAndSet(th2) : th;
    }
}
