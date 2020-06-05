package p655io.reactivex.internal.operators.observable;

import p655io.reactivex.ObservableSource;
import p655io.reactivex.Observer;
import p655io.reactivex.internal.observers.BasicFuseableObserver;
import p655io.reactivex.p664d.C8084j;

/* renamed from: io.reactivex.internal.operators.observable.h */
public final class ObservableFilter<T> extends AbstractObservableWithUpstream<T, T> {
    /* renamed from: b */
    final C8084j<? super T> f27548b;

    /* compiled from: ObservableFilter */
    /* renamed from: io.reactivex.internal.operators.observable.h$a */
    static final class C8128a<T> extends BasicFuseableObserver<T, T> {
        /* renamed from: f */
        final C8084j<? super T> f27549f;

        C8128a(Observer<? super T> lVar, C8084j<? super T> jVar) {
            super(lVar);
            this.f27549f = jVar;
        }

        public void onNext(T t) {
            if (this.f27490e == 0) {
                try {
                    if (this.f27549f.test(t)) {
                        this.f27486a.onNext(t);
                    }
                } catch (Throwable th) {
                    mo38954a(th);
                }
            } else {
                this.f27486a.onNext(null);
            }
        }

        public int requestFusion(int i) {
            return mo38953a(i);
        }

        public T poll() throws Exception {
            T poll;
            do {
                poll = this.f27488c.poll();
                if (poll == null) {
                    break;
                }
            } while (!this.f27549f.test(poll));
            return poll;
        }
    }

    public ObservableFilter(ObservableSource<T> kVar, C8084j<? super T> jVar) {
        super(kVar);
        this.f27548b = jVar;
    }

    /* renamed from: a */
    public void mo19781a(Observer<? super T> lVar) {
        this.f27515a.subscribe(new C8128a(lVar, this.f27548b));
    }
}
