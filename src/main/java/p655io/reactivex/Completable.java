package p655io.reactivex;

import java.util.concurrent.Callable;
import p655io.reactivex.annotations.CheckReturnValue;
import p655io.reactivex.annotations.SchedulerSupport;
import p655io.reactivex.exceptions.Exceptions;
import p655io.reactivex.internal.operators.p671a.CompletableDefer;
import p655io.reactivex.internal.operators.p671a.CompletableEmpty;
import p655io.reactivex.internal.operators.p671a.CompletableError;
import p655io.reactivex.internal.operators.p671a.CompletableNever;
import p655io.reactivex.internal.p669a.ObjectHelper;
import p655io.reactivex.p666f.RxJavaPlugins;

/* renamed from: io.reactivex.a */
public abstract class Completable implements CompletableSource {
    /* renamed from: b */
    public abstract void mo38817b(CompletableObserver bVar);

    @CheckReturnValue
    @SchedulerSupport("none")
    /* renamed from: a */
    public static Completable m34906a() {
        return RxJavaPlugins.m34945a(CompletableEmpty.f27496a);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    /* renamed from: a */
    public static Completable m34908a(Callable<? extends CompletableSource> callable) {
        ObjectHelper.m35048a(callable, "completableSupplier");
        return RxJavaPlugins.m34945a((Completable) new CompletableDefer(callable));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    /* renamed from: a */
    public static Completable m34907a(Throwable th) {
        ObjectHelper.m35048a(th, "error is null");
        return RxJavaPlugins.m34945a((Completable) new CompletableError(th));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    /* renamed from: b */
    public static Completable m34909b() {
        return RxJavaPlugins.m34945a(CompletableNever.f27498a);
    }

    /* renamed from: b */
    private static NullPointerException m34910b(Throwable th) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th);
        return nullPointerException;
    }

    @SchedulerSupport("none")
    /* renamed from: a */
    public final void mo38816a(CompletableObserver bVar) {
        ObjectHelper.m35048a(bVar, "s is null");
        try {
            CompletableObserver a = RxJavaPlugins.m34946a(this, bVar);
            ObjectHelper.m35048a(a, "The RxJavaPlugins.onSubscribe hook returned a null CompletableObserver. Please check the handler provided to RxJavaPlugins.setOnCompletableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            mo38817b(a);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            Exceptions.m34944b(th);
            RxJavaPlugins.m34959a(th);
            throw m34910b(th);
        }
    }
}
