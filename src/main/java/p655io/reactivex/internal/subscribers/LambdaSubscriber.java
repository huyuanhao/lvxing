package p655io.reactivex.internal.subscribers;

import java.util.concurrent.atomic.AtomicReference;
import org.p705b.Subscription;
import p655io.reactivex.C8085e;
import p655io.reactivex.exceptions.CompositeException;
import p655io.reactivex.exceptions.Exceptions;
import p655io.reactivex.internal.p669a.Functions;
import p655io.reactivex.internal.subscriptions.SubscriptionHelper;
import p655io.reactivex.p662b.Disposable;
import p655io.reactivex.p664d.C8083a;
import p655io.reactivex.p664d.Consumer;
import p655io.reactivex.p666f.RxJavaPlugins;

/* renamed from: io.reactivex.internal.subscribers.LambdaSubscriber */
public final class LambdaSubscriber<T> extends AtomicReference<Subscription> implements Disposable, C8085e<T>, Subscription {
    private static final long serialVersionUID = -7251123623727029452L;
    final C8083a onComplete;
    final Consumer<? super Throwable> onError;
    final Consumer<? super T> onNext;
    final Consumer<? super Subscription> onSubscribe;

    public LambdaSubscriber(Consumer<? super T> gVar, Consumer<? super Throwable> gVar2, C8083a aVar, Consumer<? super Subscription> gVar3) {
        this.onNext = gVar;
        this.onError = gVar2;
        this.onComplete = aVar;
        this.onSubscribe = gVar3;
    }

    public void onSubscribe(Subscription cVar) {
        if (SubscriptionHelper.setOnce(this, cVar)) {
            try {
                this.onSubscribe.accept(this);
            } catch (Throwable th) {
                Exceptions.m34944b(th);
                cVar.cancel();
                onError(th);
            }
        }
    }

    public void onNext(T t) {
        if (!isDisposed()) {
            try {
                this.onNext.accept(t);
            } catch (Throwable th) {
                Exceptions.m34944b(th);
                ((Subscription) get()).cancel();
                onError(th);
            }
        }
    }

    public void onError(Throwable th) {
        if (get() != SubscriptionHelper.CANCELLED) {
            lazySet(SubscriptionHelper.CANCELLED);
            try {
                this.onError.accept(th);
            } catch (Throwable th2) {
                Exceptions.m34944b(th2);
                RxJavaPlugins.m34959a((Throwable) new CompositeException(th, th2));
            }
        } else {
            RxJavaPlugins.m34959a(th);
        }
    }

    public void onComplete() {
        if (get() != SubscriptionHelper.CANCELLED) {
            lazySet(SubscriptionHelper.CANCELLED);
            try {
                this.onComplete.mo19849a();
            } catch (Throwable th) {
                Exceptions.m34944b(th);
                RxJavaPlugins.m34959a(th);
            }
        }
    }

    public void dispose() {
        cancel();
    }

    public boolean isDisposed() {
        return get() == SubscriptionHelper.CANCELLED;
    }

    public void request(long j) {
        ((Subscription) get()).request(j);
    }

    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    public boolean hasCustomOnError() {
        return this.onError != Functions.f27473f;
    }
}
