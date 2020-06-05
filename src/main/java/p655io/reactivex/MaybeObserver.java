package p655io.reactivex;

import p655io.reactivex.p662b.Disposable;

/* renamed from: io.reactivex.g */
public interface MaybeObserver<T> {
    void onComplete();

    void onError(Throwable th);

    void onSubscribe(Disposable bVar);
}
