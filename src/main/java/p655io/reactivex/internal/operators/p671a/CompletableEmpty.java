package p655io.reactivex.internal.operators.p671a;

import p655io.reactivex.Completable;
import p655io.reactivex.CompletableObserver;
import p655io.reactivex.internal.disposables.EmptyDisposable;

/* renamed from: io.reactivex.internal.operators.a.b */
public final class CompletableEmpty extends Completable {
    /* renamed from: a */
    public static final Completable f27496a = new CompletableEmpty();

    private CompletableEmpty() {
    }

    /* renamed from: b */
    public void mo38817b(CompletableObserver bVar) {
        EmptyDisposable.complete(bVar);
    }
}
