package p655io.reactivex.internal.operators.p671a;

import p655io.reactivex.Completable;
import p655io.reactivex.CompletableObserver;
import p655io.reactivex.internal.disposables.EmptyDisposable;

/* renamed from: io.reactivex.internal.operators.a.d */
public final class CompletableNever extends Completable {
    /* renamed from: a */
    public static final Completable f27498a = new CompletableNever();

    private CompletableNever() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo38817b(CompletableObserver bVar) {
        bVar.onSubscribe(EmptyDisposable.NEVER);
    }
}
