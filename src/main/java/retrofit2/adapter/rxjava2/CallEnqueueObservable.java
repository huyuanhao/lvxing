package retrofit2.adapter.rxjava2;

import p655io.reactivex.Observable;
import p655io.reactivex.Observer;
import p655io.reactivex.exceptions.CompositeException;
import p655io.reactivex.exceptions.Exceptions;
import p655io.reactivex.p662b.Disposable;
import p655io.reactivex.p666f.RxJavaPlugins;
import retrofit2.C8623b;
import retrofit2.C8625d;
import retrofit2.C8658l;

/* renamed from: retrofit2.adapter.rxjava2.b */
final class CallEnqueueObservable<T> extends Observable<C8658l<T>> {
    /* renamed from: a */
    private final C8623b<T> f29315a;

    /* compiled from: CallEnqueueObservable */
    /* renamed from: retrofit2.adapter.rxjava2.b$a */
    private static final class C8619a<T> implements Disposable, C8625d<T> {
        /* renamed from: a */
        boolean f29316a = false;
        /* renamed from: b */
        private final C8623b<?> f29317b;
        /* renamed from: c */
        private final Observer<? super C8658l<T>> f29318c;
        /* renamed from: d */
        private volatile boolean f29319d;

        C8619a(C8623b<?> bVar, Observer<? super C8658l<T>> lVar) {
            this.f29317b = bVar;
            this.f29318c = lVar;
        }

        /* renamed from: a */
        public void mo41284a(C8623b<T> bVar, C8658l<T> lVar) {
            if (!this.f29319d) {
                try {
                    this.f29318c.onNext(lVar);
                    if (!this.f29319d) {
                        this.f29316a = true;
                        this.f29318c.onComplete();
                    }
                } catch (Throwable th) {
                    Exceptions.m34944b(th);
                    RxJavaPlugins.m34959a((Throwable) new CompositeException(th, th));
                }
            }
        }

        /* renamed from: a */
        public void mo41283a(C8623b<T> bVar, Throwable th) {
            if (!bVar.mo41292c()) {
                try {
                    this.f29318c.onError(th);
                } catch (Throwable th2) {
                    Exceptions.m34944b(th2);
                    RxJavaPlugins.m34959a((Throwable) new CompositeException(th, th2));
                }
            }
        }

        public void dispose() {
            this.f29319d = true;
            this.f29317b.mo41291b();
        }

        public boolean isDisposed() {
            return this.f29319d;
        }
    }

    CallEnqueueObservable(C8623b<T> bVar) {
        this.f29315a = bVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo19781a(Observer<? super C8658l<T>> lVar) {
        C8623b d = this.f29315a.mo41293d();
        C8619a aVar = new C8619a(d, lVar);
        lVar.onSubscribe(aVar);
        d.mo41290a(aVar);
    }
}
