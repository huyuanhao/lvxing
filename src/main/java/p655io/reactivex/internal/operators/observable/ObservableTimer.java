package p655io.reactivex.internal.operators.observable;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p655io.reactivex.Observable;
import p655io.reactivex.Observer;
import p655io.reactivex.Scheduler;
import p655io.reactivex.internal.disposables.DisposableHelper;
import p655io.reactivex.internal.disposables.EmptyDisposable;
import p655io.reactivex.p662b.Disposable;

/* renamed from: io.reactivex.internal.operators.observable.x */
public final class ObservableTimer extends Observable<Long> {
    /* renamed from: a */
    final Scheduler f27604a;
    /* renamed from: b */
    final long f27605b;
    /* renamed from: c */
    final TimeUnit f27606c;

    /* compiled from: ObservableTimer */
    /* renamed from: io.reactivex.internal.operators.observable.x$a */
    static final class C8143a extends AtomicReference<Disposable> implements Disposable, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;
        final Observer<? super Long> downstream;

        C8143a(Observer<? super Long> lVar) {
            this.downstream = lVar;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }

        public void run() {
            if (!isDisposed()) {
                this.downstream.onNext(Long.valueOf(0));
                lazySet(EmptyDisposable.INSTANCE);
                this.downstream.onComplete();
            }
        }

        public void setResource(Disposable bVar) {
            DisposableHelper.trySet(this, bVar);
        }
    }

    public ObservableTimer(long j, TimeUnit timeUnit, Scheduler mVar) {
        this.f27605b = j;
        this.f27606c = timeUnit;
        this.f27604a = mVar;
    }

    /* renamed from: a */
    public void mo19781a(Observer<? super Long> lVar) {
        C8143a aVar = new C8143a(lVar);
        lVar.onSubscribe(aVar);
        aVar.setResource(this.f27604a.mo38821a(aVar, this.f27605b, this.f27606c));
    }
}
