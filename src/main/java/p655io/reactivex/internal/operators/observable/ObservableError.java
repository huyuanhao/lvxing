package p655io.reactivex.internal.operators.observable;

import java.util.concurrent.Callable;
import p655io.reactivex.Observable;
import p655io.reactivex.Observer;
import p655io.reactivex.exceptions.Exceptions;
import p655io.reactivex.internal.disposables.EmptyDisposable;
import p655io.reactivex.internal.p669a.ObjectHelper;

/* renamed from: io.reactivex.internal.operators.observable.g */
public final class ObservableError<T> extends Observable<T> {
    /* renamed from: a */
    final Callable<? extends Throwable> f27547a;

    public ObservableError(Callable<? extends Throwable> callable) {
        this.f27547a = callable;
    }

    /* renamed from: a */
    public void mo19781a(Observer<? super T> lVar) {
        try {
            th = (Throwable) ObjectHelper.m35048a(this.f27547a.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th) {
            th = th;
            Exceptions.m34944b(th);
        }
        EmptyDisposable.error(th, lVar);
    }
}
