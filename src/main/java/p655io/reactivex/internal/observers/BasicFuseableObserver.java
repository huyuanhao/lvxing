package p655io.reactivex.internal.observers;

import p655io.reactivex.Observer;
import p655io.reactivex.exceptions.Exceptions;
import p655io.reactivex.internal.disposables.DisposableHelper;
import p655io.reactivex.internal.p670b.QueueDisposable;
import p655io.reactivex.p662b.Disposable;
import p655io.reactivex.p666f.RxJavaPlugins;

/* renamed from: io.reactivex.internal.observers.a */
public abstract class BasicFuseableObserver<T, R> implements QueueDisposable<R>, Observer<T> {
    /* renamed from: a */
    protected final Observer<? super R> f27486a;
    /* renamed from: b */
    protected Disposable f27487b;
    /* renamed from: c */
    protected QueueDisposable<T> f27488c;
    /* renamed from: d */
    protected boolean f27489d;
    /* renamed from: e */
    protected int f27490e;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo38955a() {
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo38956b() {
    }

    public BasicFuseableObserver(Observer<? super R> lVar) {
        this.f27486a = lVar;
    }

    public final void onSubscribe(Disposable bVar) {
        if (DisposableHelper.validate(this.f27487b, bVar)) {
            this.f27487b = bVar;
            if (bVar instanceof QueueDisposable) {
                this.f27488c = (QueueDisposable) bVar;
            }
            if (mo38955a()) {
                this.f27486a.onSubscribe(this);
                mo38956b();
            }
        }
    }

    public void onError(Throwable th) {
        if (this.f27489d) {
            RxJavaPlugins.m34959a(th);
            return;
        }
        this.f27489d = true;
        this.f27486a.onError(th);
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final void mo38954a(Throwable th) {
        Exceptions.m34944b(th);
        this.f27487b.dispose();
        onError(th);
    }

    public void onComplete() {
        if (!this.f27489d) {
            this.f27489d = true;
            this.f27486a.onComplete();
        }
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final int mo38953a(int i) {
        QueueDisposable<T> aVar = this.f27488c;
        if (aVar == null || (i & 4) != 0) {
            return 0;
        }
        int requestFusion = aVar.requestFusion(i);
        if (requestFusion != 0) {
            this.f27490e = requestFusion;
        }
        return requestFusion;
    }

    public void dispose() {
        this.f27487b.dispose();
    }

    public boolean isDisposed() {
        return this.f27487b.isDisposed();
    }

    public boolean isEmpty() {
        return this.f27488c.isEmpty();
    }

    public void clear() {
        this.f27488c.clear();
    }

    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
