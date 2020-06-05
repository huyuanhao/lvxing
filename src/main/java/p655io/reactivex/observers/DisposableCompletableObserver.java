package p655io.reactivex.observers;

import java.util.concurrent.atomic.AtomicReference;
import p655io.reactivex.CompletableObserver;
import p655io.reactivex.internal.disposables.DisposableHelper;
import p655io.reactivex.internal.util.EndConsumerHelper;
import p655io.reactivex.p662b.Disposable;

/* renamed from: io.reactivex.observers.a */
public abstract class DisposableCompletableObserver implements CompletableObserver, Disposable {
    /* renamed from: b */
    final AtomicReference<Disposable> f27711b = new AtomicReference<>();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo39161a() {
    }

    public final void onSubscribe(Disposable bVar) {
        if (EndConsumerHelper.m35181a(this.f27711b, bVar, getClass())) {
            mo39161a();
        }
    }

    public final boolean isDisposed() {
        return this.f27711b.get() == DisposableHelper.DISPOSED;
    }

    public final void dispose() {
        DisposableHelper.dispose(this.f27711b);
    }
}
