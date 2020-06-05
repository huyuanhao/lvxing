package p655io.reactivex.internal.util;

import org.p705b.Subscriber;
import org.p705b.Subscription;
import p655io.reactivex.C8085e;
import p655io.reactivex.CompletableObserver;
import p655io.reactivex.MaybeObserver;
import p655io.reactivex.Observer;
import p655io.reactivex.SingleObserver;
import p655io.reactivex.p662b.Disposable;
import p655io.reactivex.p666f.RxJavaPlugins;

/* renamed from: io.reactivex.internal.util.EmptyComponent */
public enum EmptyComponent implements CompletableObserver, Disposable, C8085e<Object>, MaybeObserver<Object>, Observer<Object>, SingleObserver<Object>, Subscription {
    INSTANCE;

    public void cancel() {
    }

    public void dispose() {
    }

    public boolean isDisposed() {
        return true;
    }

    public void onComplete() {
    }

    public void onNext(Object obj) {
    }

    public void onSuccess(Object obj) {
    }

    public void request(long j) {
    }

    public static <T> Subscriber<T> asSubscriber() {
        return INSTANCE;
    }

    public static <T> Observer<T> asObserver() {
        return INSTANCE;
    }

    public void onSubscribe(Disposable bVar) {
        bVar.dispose();
    }

    public void onSubscribe(Subscription cVar) {
        cVar.cancel();
    }

    public void onError(Throwable th) {
        RxJavaPlugins.m34959a(th);
    }
}
