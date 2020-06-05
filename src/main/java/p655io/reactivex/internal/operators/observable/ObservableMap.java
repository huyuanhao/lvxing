package p655io.reactivex.internal.operators.observable;

import p655io.reactivex.ObservableSource;
import p655io.reactivex.Observer;
import p655io.reactivex.internal.observers.BasicFuseableObserver;
import p655io.reactivex.internal.p669a.ObjectHelper;
import p655io.reactivex.p664d.Function;

/* renamed from: io.reactivex.internal.operators.observable.o */
public final class ObservableMap<T, U> extends AbstractObservableWithUpstream<T, U> {
    /* renamed from: b */
    final Function<? super T, ? extends U> f27571b;

    /* compiled from: ObservableMap */
    /* renamed from: io.reactivex.internal.operators.observable.o$a */
    static final class C8135a<T, U> extends BasicFuseableObserver<T, U> {
        /* renamed from: f */
        final Function<? super T, ? extends U> f27572f;

        C8135a(Observer<? super U> lVar, Function<? super T, ? extends U> hVar) {
            super(lVar);
            this.f27572f = hVar;
        }

        public void onNext(T t) {
            if (!this.f27489d) {
                if (this.f27490e != 0) {
                    this.f27486a.onNext(null);
                    return;
                }
                try {
                    this.f27486a.onNext(ObjectHelper.m35048a(this.f27572f.apply(t), "The mapper function returned a null value."));
                } catch (Throwable th) {
                    mo38954a(th);
                }
            }
        }

        public int requestFusion(int i) {
            return mo38953a(i);
        }

        public U poll() throws Exception {
            Object poll = this.f27488c.poll();
            if (poll != null) {
                return ObjectHelper.m35048a(this.f27572f.apply(poll), "The mapper function returned a null value.");
            }
            return null;
        }
    }

    public ObservableMap(ObservableSource<T> kVar, Function<? super T, ? extends U> hVar) {
        super(kVar);
        this.f27571b = hVar;
    }

    /* renamed from: a */
    public void mo19781a(Observer<? super U> lVar) {
        this.f27515a.subscribe(new C8135a(lVar, this.f27571b));
    }
}
