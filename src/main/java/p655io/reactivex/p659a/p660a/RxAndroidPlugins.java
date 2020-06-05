package p655io.reactivex.p659a.p660a;

import java.util.concurrent.Callable;
import p655io.reactivex.Scheduler;
import p655io.reactivex.exceptions.Exceptions;
import p655io.reactivex.p664d.Function;

/* renamed from: io.reactivex.a.a.a */
public final class RxAndroidPlugins {
    /* renamed from: a */
    private static volatile Function<Callable<Scheduler>, Scheduler> f27396a;
    /* renamed from: b */
    private static volatile Function<Scheduler, Scheduler> f27397b;

    /* renamed from: a */
    public static Scheduler m34916a(Callable<Scheduler> callable) {
        if (callable != null) {
            Function<Callable<Scheduler>, Scheduler> hVar = f27396a;
            if (hVar == null) {
                return m34918b(callable);
            }
            return m34914a(hVar, callable);
        }
        throw new NullPointerException("scheduler == null");
    }

    /* renamed from: a */
    public static Scheduler m34915a(Scheduler mVar) {
        if (mVar != null) {
            Function<Scheduler, Scheduler> hVar = f27397b;
            if (hVar == null) {
                return mVar;
            }
            return (Scheduler) m34917a(hVar, (T) mVar);
        }
        throw new NullPointerException("scheduler == null");
    }

    /* renamed from: b */
    static Scheduler m34918b(Callable<Scheduler> callable) {
        try {
            Scheduler mVar = (Scheduler) callable.call();
            if (mVar != null) {
                return mVar;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Throwable th) {
            throw Exceptions.m34943a(th);
        }
    }

    /* renamed from: a */
    static Scheduler m34914a(Function<Callable<Scheduler>, Scheduler> hVar, Callable<Scheduler> callable) {
        Scheduler mVar = (Scheduler) m34917a(hVar, (T) callable);
        if (mVar != null) {
            return mVar;
        }
        throw new NullPointerException("Scheduler Callable returned null");
    }

    /* renamed from: a */
    static <T, R> R m34917a(Function<T, R> hVar, T t) {
        try {
            return hVar.apply(t);
        } catch (Throwable th) {
            throw Exceptions.m34943a(th);
        }
    }
}
