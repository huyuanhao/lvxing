package p655io.reactivex.internal.observers;

import java.util.concurrent.atomic.AtomicReference;
import p655io.reactivex.Observer;
import p655io.reactivex.exceptions.CompositeException;
import p655io.reactivex.exceptions.Exceptions;
import p655io.reactivex.internal.disposables.DisposableHelper;
import p655io.reactivex.p662b.Disposable;
import p655io.reactivex.p664d.C8083a;
import p655io.reactivex.p664d.C8084j;
import p655io.reactivex.p664d.Consumer;
import p655io.reactivex.p666f.RxJavaPlugins;

/* renamed from: io.reactivex.internal.observers.ForEachWhileObserver */
public final class ForEachWhileObserver<T> extends AtomicReference<Disposable> implements Disposable, Observer<T> {
    private static final long serialVersionUID = -4403180040475402120L;
    boolean done;
    final C8083a onComplete;
    final Consumer<? super Throwable> onError;
    final C8084j<? super T> onNext;

    public ForEachWhileObserver(C8084j<? super T> jVar, Consumer<? super Throwable> gVar, C8083a aVar) {
        this.onNext = jVar;
        this.onError = gVar;
        this.onComplete = aVar;
    }

    public void onSubscribe(Disposable bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    public void onNext(T t) {
        if (!this.done) {
            try {
                if (!this.onNext.test(t)) {
                    dispose();
                    onComplete();
                }
            } catch (Throwable th) {
                Exceptions.m34944b(th);
                dispose();
                onError(th);
            }
        }
    }

    public void onError(Throwable th) {
        if (this.done) {
            RxJavaPlugins.m34959a(th);
            return;
        }
        this.done = true;
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            Exceptions.m34944b(th2);
            RxJavaPlugins.m34959a((Throwable) new CompositeException(th, th2));
        }
    }

    public void onComplete() {
        if (!this.done) {
            this.done = true;
            try {
                this.onComplete.mo19849a();
            } catch (Throwable th) {
                Exceptions.m34944b(th);
                RxJavaPlugins.m34959a(th);
            }
        }
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }
}
