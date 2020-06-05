package com.uber.autodispose;

import java.util.concurrent.atomic.AtomicInteger;
import p655io.reactivex.Observer;
import p655io.reactivex.p666f.RxJavaPlugins;

/* renamed from: com.uber.autodispose.k */
final class HalfSerializer {
    /* renamed from: a */
    public static <T> boolean m33092a(Observer<? super T> lVar, T t, AtomicInteger atomicInteger, AtomicThrowable aVar) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            lVar.onNext(t);
            if (atomicInteger.decrementAndGet() != 0) {
                Throwable terminate = aVar.terminate();
                if (terminate != null) {
                    lVar.onError(terminate);
                } else {
                    lVar.onComplete();
                }
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static void m33090a(Observer<?> lVar, Throwable th, AtomicInteger atomicInteger, AtomicThrowable aVar) {
        if (!aVar.addThrowable(th)) {
            RxJavaPlugins.m34959a(th);
        } else if (atomicInteger.getAndIncrement() == 0) {
            lVar.onError(aVar.terminate());
        }
    }

    /* renamed from: a */
    public static void m33091a(Observer<?> lVar, AtomicInteger atomicInteger, AtomicThrowable aVar) {
        if (atomicInteger.getAndIncrement() == 0) {
            Throwable terminate = aVar.terminate();
            if (terminate != null) {
                lVar.onError(terminate);
            } else {
                lVar.onComplete();
            }
        }
    }
}
