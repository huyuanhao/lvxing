package p655io.reactivex;

import p655io.reactivex.p662b.Disposable;

/* renamed from: io.reactivex.o */
public interface SingleObserver<T> {
    void onError(Throwable th);

    void onSubscribe(Disposable bVar);
}
