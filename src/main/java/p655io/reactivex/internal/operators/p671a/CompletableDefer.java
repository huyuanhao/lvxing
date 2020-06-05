package p655io.reactivex.internal.operators.p671a;

import java.util.concurrent.Callable;
import p655io.reactivex.Completable;
import p655io.reactivex.CompletableObserver;
import p655io.reactivex.CompletableSource;
import p655io.reactivex.exceptions.Exceptions;
import p655io.reactivex.internal.disposables.EmptyDisposable;
import p655io.reactivex.internal.p669a.ObjectHelper;

/* renamed from: io.reactivex.internal.operators.a.a */
public final class CompletableDefer extends Completable {
    /* renamed from: a */
    final Callable<? extends CompletableSource> f27495a;

    public CompletableDefer(Callable<? extends CompletableSource> callable) {
        this.f27495a = callable;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo38817b(CompletableObserver bVar) {
        try {
            ((CompletableSource) ObjectHelper.m35048a(this.f27495a.call(), "The completableSupplier returned a null CompletableSource")).mo38816a(bVar);
        } catch (Throwable th) {
            Exceptions.m34944b(th);
            EmptyDisposable.error(th, bVar);
        }
    }
}
