package p655io.reactivex.internal.util;

import java.util.concurrent.atomic.AtomicInteger;
import org.p705b.Subscriber;
import p655io.reactivex.p666f.RxJavaPlugins;

/* compiled from: HalfSerializer */
/* renamed from: io.reactivex.internal.util.e */
public final class C8164e {
    /* renamed from: a */
    public static <T> void m35185a(Subscriber<? super T> bVar, T t, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            bVar.onNext(t);
            if (atomicInteger.decrementAndGet() != 0) {
                Throwable terminate = atomicThrowable.terminate();
                if (terminate != null) {
                    bVar.onError(terminate);
                } else {
                    bVar.onComplete();
                }
            }
        }
    }

    /* renamed from: a */
    public static void m35186a(Subscriber<?> bVar, Throwable th, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (!atomicThrowable.addThrowable(th)) {
            RxJavaPlugins.m34959a(th);
        } else if (atomicInteger.getAndIncrement() == 0) {
            bVar.onError(atomicThrowable.terminate());
        }
    }

    /* renamed from: a */
    public static void m35187a(Subscriber<?> bVar, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.getAndIncrement() == 0) {
            Throwable terminate = atomicThrowable.terminate();
            if (terminate != null) {
                bVar.onError(terminate);
            } else {
                bVar.onComplete();
            }
        }
    }
}
