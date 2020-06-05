package p655io.reactivex.p666f;

import java.util.concurrent.Callable;
import p655io.reactivex.Completable;
import p655io.reactivex.CompletableObserver;
import p655io.reactivex.Flowable;
import p655io.reactivex.Maybe;
import p655io.reactivex.Observable;
import p655io.reactivex.Observer;
import p655io.reactivex.Scheduler;
import p655io.reactivex.Single;
import p655io.reactivex.exceptions.CompositeException;
import p655io.reactivex.exceptions.MissingBackpressureException;
import p655io.reactivex.exceptions.OnErrorNotImplementedException;
import p655io.reactivex.exceptions.UndeliverableException;
import p655io.reactivex.internal.p669a.ObjectHelper;
import p655io.reactivex.internal.util.C8162d;
import p655io.reactivex.p664d.BiFunction;
import p655io.reactivex.p664d.Consumer;
import p655io.reactivex.p664d.Function;

/* renamed from: io.reactivex.f.a */
public final class RxJavaPlugins {
    /* renamed from: a */
    static volatile Consumer<? super Throwable> f27416a;
    /* renamed from: b */
    static volatile Function<? super Runnable, ? extends Runnable> f27417b;
    /* renamed from: c */
    static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> f27418c;
    /* renamed from: d */
    static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> f27419d;
    /* renamed from: e */
    static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> f27420e;
    /* renamed from: f */
    static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> f27421f;
    /* renamed from: g */
    static volatile Function<? super Scheduler, ? extends Scheduler> f27422g;
    /* renamed from: h */
    static volatile Function<? super Scheduler, ? extends Scheduler> f27423h;
    /* renamed from: i */
    static volatile Function<? super Flowable, ? extends Flowable> f27424i;
    /* renamed from: j */
    static volatile Function<? super Observable, ? extends Observable> f27425j;
    /* renamed from: k */
    static volatile Function<? super Maybe, ? extends Maybe> f27426k;
    /* renamed from: l */
    static volatile Function<? super Single, ? extends Single> f27427l;
    /* renamed from: m */
    static volatile Function<? super Completable, ? extends Completable> f27428m;
    /* renamed from: n */
    static volatile BiFunction<? super Observable, ? super Observer, ? extends Observer> f27429n;
    /* renamed from: o */
    static volatile BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver> f27430o;
    /* renamed from: p */
    static volatile boolean f27431p;

    /* renamed from: a */
    public static Scheduler m34953a(Callable<Scheduler> callable) {
        ObjectHelper.m35048a(callable, "Scheduler Callable can't be null");
        Function<? super Callable<Scheduler>, ? extends Scheduler> hVar = f27418c;
        if (hVar == null) {
            return m34966e(callable);
        }
        return m34951a(hVar, callable);
    }

    /* renamed from: b */
    public static Scheduler m34961b(Callable<Scheduler> callable) {
        ObjectHelper.m35048a(callable, "Scheduler Callable can't be null");
        Function<? super Callable<Scheduler>, ? extends Scheduler> hVar = f27420e;
        if (hVar == null) {
            return m34966e(callable);
        }
        return m34951a(hVar, callable);
    }

    /* renamed from: c */
    public static Scheduler m34963c(Callable<Scheduler> callable) {
        ObjectHelper.m35048a(callable, "Scheduler Callable can't be null");
        Function<? super Callable<Scheduler>, ? extends Scheduler> hVar = f27421f;
        if (hVar == null) {
            return m34966e(callable);
        }
        return m34951a(hVar, callable);
    }

    /* renamed from: d */
    public static Scheduler m34965d(Callable<Scheduler> callable) {
        ObjectHelper.m35048a(callable, "Scheduler Callable can't be null");
        Function<? super Callable<Scheduler>, ? extends Scheduler> hVar = f27419d;
        if (hVar == null) {
            return m34966e(callable);
        }
        return m34951a(hVar, callable);
    }

    /* renamed from: a */
    public static Scheduler m34952a(Scheduler mVar) {
        Function<? super Scheduler, ? extends Scheduler> hVar = f27422g;
        if (hVar == null) {
            return mVar;
        }
        return (Scheduler) m34956a(hVar, (T) mVar);
    }

    /* renamed from: a */
    public static void m34959a(Throwable th) {
        Consumer<? super Throwable> gVar = f27416a;
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else if (!m34962b(th)) {
            th = new UndeliverableException(th);
        }
        if (gVar != null) {
            try {
                gVar.accept(th);
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
                m34964c(th2);
            }
        }
        th.printStackTrace();
        m34964c(th);
    }

    /* renamed from: b */
    static boolean m34962b(Throwable th) {
        if (!(th instanceof OnErrorNotImplementedException) && !(th instanceof MissingBackpressureException) && !(th instanceof IllegalStateException) && !(th instanceof NullPointerException) && !(th instanceof IllegalArgumentException) && !(th instanceof CompositeException)) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    static void m34964c(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    /* renamed from: b */
    public static Scheduler m34960b(Scheduler mVar) {
        Function<? super Scheduler, ? extends Scheduler> hVar = f27423h;
        if (hVar == null) {
            return mVar;
        }
        return (Scheduler) m34956a(hVar, (T) mVar);
    }

    /* renamed from: a */
    public static Runnable m34957a(Runnable runnable) {
        ObjectHelper.m35048a(runnable, "run is null");
        Function<? super Runnable, ? extends Runnable> hVar = f27417b;
        if (hVar == null) {
            return runnable;
        }
        return (Runnable) m34956a(hVar, (T) runnable);
    }

    /* renamed from: a */
    public static void m34958a(Consumer<? super Throwable> gVar) {
        if (!f27431p) {
            f27416a = gVar;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    /* renamed from: a */
    public static <T> Observer<? super T> m34950a(Observable<T> iVar, Observer<? super T> lVar) {
        BiFunction<? super Observable, ? super Observer, ? extends Observer> cVar = f27429n;
        return cVar != null ? (Observer) m34955a(cVar, iVar, lVar) : lVar;
    }

    /* renamed from: a */
    public static CompletableObserver m34946a(Completable aVar, CompletableObserver bVar) {
        BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver> cVar = f27430o;
        return cVar != null ? (CompletableObserver) m34955a(cVar, aVar, bVar) : bVar;
    }

    /* renamed from: a */
    public static <T> Maybe<T> m34948a(Maybe<T> fVar) {
        Function<? super Maybe, ? extends Maybe> hVar = f27426k;
        return hVar != null ? (Maybe) m34956a(hVar, (T) fVar) : fVar;
    }

    /* renamed from: a */
    public static <T> Flowable<T> m34947a(Flowable<T> dVar) {
        Function<? super Flowable, ? extends Flowable> hVar = f27424i;
        return hVar != null ? (Flowable) m34956a(hVar, (T) dVar) : dVar;
    }

    /* renamed from: a */
    public static <T> Observable<T> m34949a(Observable<T> iVar) {
        Function<? super Observable, ? extends Observable> hVar = f27425j;
        return hVar != null ? (Observable) m34956a(hVar, (T) iVar) : iVar;
    }

    /* renamed from: a */
    public static <T> Single<T> m34954a(Single<T> nVar) {
        Function<? super Single, ? extends Single> hVar = f27427l;
        return hVar != null ? (Single) m34956a(hVar, (T) nVar) : nVar;
    }

    /* renamed from: a */
    public static Completable m34945a(Completable aVar) {
        Function<? super Completable, ? extends Completable> hVar = f27428m;
        return hVar != null ? (Completable) m34956a(hVar, (T) aVar) : aVar;
    }

    /* renamed from: a */
    static <T, R> R m34956a(Function<T, R> hVar, T t) {
        try {
            return hVar.apply(t);
        } catch (Throwable th) {
            throw C8162d.m35182a(th);
        }
    }

    /* renamed from: a */
    static <T, U, R> R m34955a(BiFunction<T, U, R> cVar, T t, U u) {
        try {
            return cVar.apply(t, u);
        } catch (Throwable th) {
            throw C8162d.m35182a(th);
        }
    }

    /* renamed from: e */
    static Scheduler m34966e(Callable<Scheduler> callable) {
        try {
            return (Scheduler) ObjectHelper.m35048a(callable.call(), "Scheduler Callable result can't be null");
        } catch (Throwable th) {
            throw C8162d.m35182a(th);
        }
    }

    /* renamed from: a */
    static Scheduler m34951a(Function<? super Callable<Scheduler>, ? extends Scheduler> hVar, Callable<Scheduler> callable) {
        return (Scheduler) ObjectHelper.m35048a(m34956a(hVar, (T) callable), "Scheduler Callable result can't be null");
    }
}
