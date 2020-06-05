package p655io.reactivex.internal.disposables;

import p655io.reactivex.CompletableObserver;
import p655io.reactivex.MaybeObserver;
import p655io.reactivex.Observer;
import p655io.reactivex.SingleObserver;
import p655io.reactivex.internal.p670b.QueueDisposable;

/* renamed from: io.reactivex.internal.disposables.EmptyDisposable */
public enum EmptyDisposable implements QueueDisposable<Object> {
    INSTANCE,
    NEVER;

    public void clear() {
    }

    public void dispose() {
    }

    public boolean isEmpty() {
        return true;
    }

    public Object poll() throws Exception {
        return null;
    }

    public int requestFusion(int i) {
        return i & 2;
    }

    public boolean isDisposed() {
        return this == INSTANCE;
    }

    public static void complete(Observer<?> lVar) {
        lVar.onSubscribe(INSTANCE);
        lVar.onComplete();
    }

    public static void complete(MaybeObserver<?> gVar) {
        gVar.onSubscribe(INSTANCE);
        gVar.onComplete();
    }

    public static void error(Throwable th, Observer<?> lVar) {
        lVar.onSubscribe(INSTANCE);
        lVar.onError(th);
    }

    public static void complete(CompletableObserver bVar) {
        bVar.onSubscribe(INSTANCE);
        bVar.onComplete();
    }

    public static void error(Throwable th, CompletableObserver bVar) {
        bVar.onSubscribe(INSTANCE);
        bVar.onError(th);
    }

    public static void error(Throwable th, SingleObserver<?> oVar) {
        oVar.onSubscribe(INSTANCE);
        oVar.onError(th);
    }

    public static void error(Throwable th, MaybeObserver<?> gVar) {
        gVar.onSubscribe(INSTANCE);
        gVar.onError(th);
    }

    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
