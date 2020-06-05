package retrofit2.adapter.rxjava2;

import p655io.reactivex.Observable;
import p655io.reactivex.Observer;
import p655io.reactivex.exceptions.CompositeException;
import p655io.reactivex.exceptions.Exceptions;
import p655io.reactivex.p662b.Disposable;
import p655io.reactivex.p666f.RxJavaPlugins;
import retrofit2.C8623b;
import retrofit2.C8658l;

/* renamed from: retrofit2.adapter.rxjava2.c */
final class CallExecuteObservable<T> extends Observable<C8658l<T>> {
    /* renamed from: a */
    private final C8623b<T> f29320a;

    /* compiled from: CallExecuteObservable */
    /* renamed from: retrofit2.adapter.rxjava2.c$a */
    private static final class C8620a implements Disposable {
        /* renamed from: a */
        private final C8623b<?> f29321a;
        /* renamed from: b */
        private volatile boolean f29322b;

        C8620a(C8623b<?> bVar) {
            this.f29321a = bVar;
        }

        public void dispose() {
            this.f29322b = true;
            this.f29321a.mo41291b();
        }

        public boolean isDisposed() {
            return this.f29322b;
        }
    }

    CallExecuteObservable(C8623b<T> bVar) {
        this.f29320a = bVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo19781a(Observer<? super C8658l<T>> lVar) {
        boolean z;
        C8623b d = this.f29320a.mo41293d();
        C8620a aVar = new C8620a(d);
        lVar.onSubscribe(aVar);
        try {
            C8658l a = d.mo41289a();
            if (!aVar.isDisposed()) {
                lVar.onNext(a);
            }
            if (!aVar.isDisposed()) {
                try {
                    lVar.onComplete();
                } catch (Throwable th) {
                    th = th;
                    z = true;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            z = false;
            Exceptions.m34944b(th);
            if (z) {
                RxJavaPlugins.m34959a(th);
            } else if (!aVar.isDisposed()) {
                try {
                    lVar.onError(th);
                } catch (Throwable th3) {
                    Exceptions.m34944b(th3);
                    RxJavaPlugins.m34959a((Throwable) new CompositeException(th, th3));
                }
            }
        }
    }
}
