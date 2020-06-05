package p655io.reactivex;

import p655io.reactivex.p662b.Disposable;

/* renamed from: io.reactivex.b */
public interface CompletableObserver {
    void onComplete();

    void onError(Throwable th);

    void onSubscribe(Disposable bVar);
}
