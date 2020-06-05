package retrofit2.adapter.rxjava2;

import p655io.reactivex.Observable;
import p655io.reactivex.Observer;
import p655io.reactivex.exceptions.CompositeException;
import p655io.reactivex.exceptions.Exceptions;
import p655io.reactivex.p662b.Disposable;
import p655io.reactivex.p666f.RxJavaPlugins;
import retrofit2.C8658l;

/* renamed from: retrofit2.adapter.rxjava2.e */
final class ResultObservable<T> extends Observable<C8621d<T>> {
    /* renamed from: a */
    private final Observable<C8658l<T>> f29325a;

    /* compiled from: ResultObservable */
    /* renamed from: retrofit2.adapter.rxjava2.e$a */
    private static class C8622a<R> implements Observer<C8658l<R>> {
        /* renamed from: a */
        private final Observer<? super C8621d<R>> f29326a;

        C8622a(Observer<? super C8621d<R>> lVar) {
            this.f29326a = lVar;
        }

        public void onSubscribe(Disposable bVar) {
            this.f29326a.onSubscribe(bVar);
        }

        /* renamed from: a */
        public void onNext(C8658l<R> lVar) {
            this.f29326a.onNext(C8621d.m37486a(lVar));
        }

        public void onError(Throwable th) {
            try {
                this.f29326a.onNext(C8621d.m37485a(th));
                this.f29326a.onComplete();
            } catch (Throwable th2) {
                Exceptions.m34944b(th2);
                RxJavaPlugins.m34959a((Throwable) new CompositeException(th, th2));
            }
        }

        public void onComplete() {
            this.f29326a.onComplete();
        }
    }

    ResultObservable(Observable<C8658l<T>> iVar) {
        this.f29325a = iVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo19781a(Observer<? super C8621d<T>> lVar) {
        this.f29325a.subscribe(new C8622a(lVar));
    }
}
