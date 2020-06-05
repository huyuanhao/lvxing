package org.p705b;

/* renamed from: org.b.b */
public interface Subscriber<T> {
    void onComplete();

    void onError(Throwable th);

    void onNext(T t);

    void onSubscribe(Subscription cVar);
}
