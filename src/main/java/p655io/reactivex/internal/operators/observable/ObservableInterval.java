package p655io.reactivex.internal.operators.observable;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p655io.reactivex.Observable;
import p655io.reactivex.Observer;
import p655io.reactivex.Scheduler;
import p655io.reactivex.Scheduler.C8167c;
import p655io.reactivex.internal.disposables.DisposableHelper;
import p655io.reactivex.internal.schedulers.TrampolineScheduler;
import p655io.reactivex.p662b.Disposable;

/* renamed from: io.reactivex.internal.operators.observable.m */
public final class ObservableInterval extends Observable<Long> {
    /* renamed from: a */
    final Scheduler f27566a;
    /* renamed from: b */
    final long f27567b;
    /* renamed from: c */
    final long f27568c;
    /* renamed from: d */
    final TimeUnit f27569d;

    /* compiled from: ObservableInterval */
    /* renamed from: io.reactivex.internal.operators.observable.m$a */
    static final class C8134a extends AtomicReference<Disposable> implements Disposable, Runnable {
        private static final long serialVersionUID = 346773832286157679L;
        long count;
        final Observer<? super Long> downstream;

        C8134a(Observer<? super Long> lVar) {
            this.downstream = lVar;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }

        public void run() {
            if (get() != DisposableHelper.DISPOSED) {
                Observer<? super Long> lVar = this.downstream;
                long j = this.count;
                this.count = 1 + j;
                lVar.onNext(Long.valueOf(j));
            }
        }

        public void setResource(Disposable bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    public ObservableInterval(long j, long j2, TimeUnit timeUnit, Scheduler mVar) {
        this.f27567b = j;
        this.f27568c = j2;
        this.f27569d = timeUnit;
        this.f27566a = mVar;
    }

    /* renamed from: a */
    public void mo19781a(Observer<? super Long> lVar) {
        C8134a aVar = new C8134a(lVar);
        lVar.onSubscribe(aVar);
        Scheduler mVar = this.f27566a;
        if (mVar instanceof TrampolineScheduler) {
            C8167c a = mVar.mo38822a();
            aVar.setResource(a);
            a.mo39158a(aVar, this.f27567b, this.f27568c, this.f27569d);
            return;
        }
        aVar.setResource(mVar.mo39041a(aVar, this.f27567b, this.f27568c, this.f27569d));
    }
}
