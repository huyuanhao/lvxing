package p655io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicReference;
import p655io.reactivex.ObservableSource;
import p655io.reactivex.Observer;
import p655io.reactivex.Scheduler;
import p655io.reactivex.internal.disposables.DisposableHelper;
import p655io.reactivex.p662b.Disposable;

/* renamed from: io.reactivex.internal.operators.observable.u */
public final class ObservableSubscribeOn<T> extends AbstractObservableWithUpstream<T, T> {
    /* renamed from: b */
    final Scheduler f27591b;

    /* compiled from: ObservableSubscribeOn */
    /* renamed from: io.reactivex.internal.operators.observable.u$a */
    static final class C8139a<T> extends AtomicReference<Disposable> implements Disposable, Observer<T> {
        private static final long serialVersionUID = 8094547886072529208L;
        final Observer<? super T> downstream;
        final AtomicReference<Disposable> upstream = new AtomicReference<>();

        C8139a(Observer<? super T> lVar) {
            this.downstream = lVar;
        }

        public void onSubscribe(Disposable bVar) {
            DisposableHelper.setOnce(this.upstream, bVar);
        }

        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        public void onComplete() {
            this.downstream.onComplete();
        }

        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        /* access modifiers changed from: 0000 */
        public void setDisposable(Disposable bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    /* compiled from: ObservableSubscribeOn */
    /* renamed from: io.reactivex.internal.operators.observable.u$b */
    final class C8140b implements Runnable {
        /* renamed from: b */
        private final C8139a<T> f27593b;

        C8140b(C8139a<T> aVar) {
            this.f27593b = aVar;
        }

        public void run() {
            ObservableSubscribeOn.this.f27515a.subscribe(this.f27593b);
        }
    }

    public ObservableSubscribeOn(ObservableSource<T> kVar, Scheduler mVar) {
        super(kVar);
        this.f27591b = mVar;
    }

    /* renamed from: a */
    public void mo19781a(Observer<? super T> lVar) {
        C8139a aVar = new C8139a(lVar);
        lVar.onSubscribe(aVar);
        aVar.setDisposable(this.f27591b.mo39064a(new C8140b(aVar)));
    }
}
