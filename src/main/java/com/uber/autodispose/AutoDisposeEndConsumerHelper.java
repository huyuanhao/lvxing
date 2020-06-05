package com.uber.autodispose;

import java.util.concurrent.atomic.AtomicReference;
import p655io.reactivex.exceptions.ProtocolViolationException;
import p655io.reactivex.p662b.Disposable;
import p655io.reactivex.p666f.RxJavaPlugins;

/* renamed from: com.uber.autodispose.e */
final class AutoDisposeEndConsumerHelper {
    /* renamed from: a */
    public static boolean m33083a(AtomicReference<Disposable> atomicReference, Disposable bVar, Class<?> cls) {
        AutoDisposeUtil.m33087a(bVar, "next is null");
        if (atomicReference.compareAndSet(null, bVar)) {
            return true;
        }
        bVar.dispose();
        if (atomicReference.get() != AutoDisposableHelper.DISPOSED) {
            m33082a(cls);
        }
        return false;
    }

    /* renamed from: a */
    public static String m33081a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("It is not allowed to subscribe with a(n) ");
        sb.append(str);
        sb.append(" multiple times. Please create a fresh instance of ");
        sb.append(str);
        sb.append(" and subscribe that to the target source instead.");
        return sb.toString();
    }

    /* renamed from: a */
    public static void m33082a(Class<?> cls) {
        RxJavaPlugins.m34959a((Throwable) new ProtocolViolationException(m33081a(cls.getName())));
    }
}
