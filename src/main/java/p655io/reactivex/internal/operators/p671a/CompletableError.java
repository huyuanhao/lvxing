package p655io.reactivex.internal.operators.p671a;

import p655io.reactivex.Completable;
import p655io.reactivex.CompletableObserver;
import p655io.reactivex.internal.disposables.EmptyDisposable;

/* renamed from: io.reactivex.internal.operators.a.c */
public final class CompletableError extends Completable {
    /* renamed from: a */
    final Throwable f27497a;

    public CompletableError(Throwable th) {
        this.f27497a = th;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo38817b(CompletableObserver bVar) {
        EmptyDisposable.error(this.f27497a, bVar);
    }
}
