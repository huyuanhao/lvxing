package p655io.reactivex.internal.util;

import java.util.concurrent.atomic.AtomicReference;
import p655io.reactivex.exceptions.ProtocolViolationException;
import p655io.reactivex.internal.disposables.DisposableHelper;
import p655io.reactivex.internal.p669a.ObjectHelper;
import p655io.reactivex.p662b.Disposable;
import p655io.reactivex.p666f.RxJavaPlugins;

/* renamed from: io.reactivex.internal.util.c */
public final class EndConsumerHelper {
    /* renamed from: a */
    public static boolean m35181a(AtomicReference<Disposable> atomicReference, Disposable bVar, Class<?> cls) {
        ObjectHelper.m35048a(bVar, "next is null");
        if (atomicReference.compareAndSet(null, bVar)) {
            return true;
        }
        bVar.dispose();
        if (atomicReference.get() != DisposableHelper.DISPOSED) {
            m35180a(cls);
        }
        return false;
    }

    /* renamed from: a */
    public static String m35179a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("It is not allowed to subscribe with a(n) ");
        sb.append(str);
        sb.append(" multiple times. Please create a fresh instance of ");
        sb.append(str);
        sb.append(" and subscribe that to the target source instead.");
        return sb.toString();
    }

    /* renamed from: a */
    public static void m35180a(Class<?> cls) {
        RxJavaPlugins.m34959a((Throwable) new ProtocolViolationException(m35179a(cls.getName())));
    }
}
