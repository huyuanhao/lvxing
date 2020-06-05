package p655io.reactivex;

import p655io.reactivex.p662b.Disposable;

/* renamed from: io.reactivex.l */
public interface Observer<T> {
    void onComplete();

    void onError(Throwable th);

    void onNext(T t);

    void onSubscribe(Disposable bVar);
}
