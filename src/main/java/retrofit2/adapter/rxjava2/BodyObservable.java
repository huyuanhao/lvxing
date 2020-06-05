package retrofit2.adapter.rxjava2;

import p655io.reactivex.Observable;
import p655io.reactivex.Observer;
import p655io.reactivex.exceptions.CompositeException;
import p655io.reactivex.exceptions.Exceptions;
import p655io.reactivex.p662b.Disposable;
import p655io.reactivex.p666f.RxJavaPlugins;
import retrofit2.C8658l;

/* renamed from: retrofit2.adapter.rxjava2.a */
final class BodyObservable<T> extends Observable<T> {
    /* renamed from: a */
    private final Observable<C8658l<T>> f29312a;

    /* compiled from: BodyObservable */
    /* renamed from: retrofit2.adapter.rxjava2.a$a */
    private static class C8618a<R> implements Observer<C8658l<R>> {
        /* renamed from: a */
        private final Observer<? super R> f29313a;
        /* renamed from: b */
        private boolean f29314b;

        C8618a(Observer<? super R> lVar) {
            this.f29313a = lVar;
        }

        public void onSubscribe(Disposable bVar) {
            this.f29313a.onSubscribe(bVar);
        }

        /* renamed from: a */
        public void onNext(C8658l<R> lVar) {
            if (lVar.mo41353c()) {
                this.f29313a.onNext(lVar.mo41354d());
                return;
            }
            this.f29314b = true;
            HttpException httpException = new HttpException(lVar);
            try {
                this.f29313a.onError(httpException);
            } catch (Throwable th) {
                Exceptions.m34944b(th);
                RxJavaPlugins.m34959a((Throwable) new CompositeException(httpException, th));
            }
        }

        public void onComplete() {
            if (!this.f29314b) {
                this.f29313a.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (!this.f29314b) {
                this.f29313a.onError(th);
                return;
            }
            AssertionError assertionError = new AssertionError("This should never happen! Report as a bug with the full stacktrace.");
            assertionError.initCause(th);
            RxJavaPlugins.m34959a((Throwable) assertionError);
        }
    }

    BodyObservable(Observable<C8658l<T>> iVar) {
        this.f29312a = iVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo19781a(Observer<? super T> lVar) {
        this.f29312a.subscribe(new C8618a(lVar));
    }
}
