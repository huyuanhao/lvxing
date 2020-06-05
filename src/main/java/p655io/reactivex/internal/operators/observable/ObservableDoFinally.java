package p655io.reactivex.internal.operators.observable;

import p655io.reactivex.ObservableSource;
import p655io.reactivex.Observer;
import p655io.reactivex.exceptions.Exceptions;
import p655io.reactivex.internal.disposables.DisposableHelper;
import p655io.reactivex.internal.observers.BasicIntQueueDisposable;
import p655io.reactivex.internal.p670b.QueueDisposable;
import p655io.reactivex.p662b.Disposable;
import p655io.reactivex.p664d.C8083a;
import p655io.reactivex.p666f.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.observable.c */
public final class ObservableDoFinally<T> extends AbstractObservableWithUpstream<T, T> {
    /* renamed from: b */
    final C8083a f27531b;

    /* compiled from: ObservableDoFinally */
    /* renamed from: io.reactivex.internal.operators.observable.c$a */
    static final class C8126a<T> extends BasicIntQueueDisposable<T> implements Observer<T> {
        private static final long serialVersionUID = 4109457741734051389L;
        final Observer<? super T> downstream;
        final C8083a onFinally;
        /* renamed from: qd */
        QueueDisposable<T> f27532qd;
        boolean syncFused;
        Disposable upstream;

        C8126a(Observer<? super T> lVar, C8083a aVar) {
            this.downstream = lVar;
            this.onFinally = aVar;
        }

        public void onSubscribe(Disposable bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                if (bVar instanceof QueueDisposable) {
                    this.f27532qd = (QueueDisposable) bVar;
                }
                this.downstream.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        public void onError(Throwable th) {
            this.downstream.onError(th);
            runFinally();
        }

        public void onComplete() {
            this.downstream.onComplete();
            runFinally();
        }

        public void dispose() {
            this.upstream.dispose();
            runFinally();
        }

        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        public int requestFusion(int i) {
            QueueDisposable<T> aVar = this.f27532qd;
            if (aVar == null || (i & 4) != 0) {
                return 0;
            }
            int requestFusion = aVar.requestFusion(i);
            if (requestFusion != 0) {
                boolean z = true;
                if (requestFusion != 1) {
                    z = false;
                }
                this.syncFused = z;
            }
            return requestFusion;
        }

        public void clear() {
            this.f27532qd.clear();
        }

        public boolean isEmpty() {
            return this.f27532qd.isEmpty();
        }

        public T poll() throws Exception {
            T poll = this.f27532qd.poll();
            if (poll == null && this.syncFused) {
                runFinally();
            }
            return poll;
        }

        /* access modifiers changed from: 0000 */
        public void runFinally() {
            if (compareAndSet(0, 1)) {
                try {
                    this.onFinally.mo19849a();
                } catch (Throwable th) {
                    Exceptions.m34944b(th);
                    RxJavaPlugins.m34959a(th);
                }
            }
        }
    }

    public ObservableDoFinally(ObservableSource<T> kVar, C8083a aVar) {
        super(kVar);
        this.f27531b = aVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo19781a(Observer<? super T> lVar) {
        this.f27515a.subscribe(new C8126a(lVar, this.f27531b));
    }
}
