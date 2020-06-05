package p655io.reactivex.internal.operators.observable;

import p655io.reactivex.ObservableSource;
import p655io.reactivex.Observer;
import p655io.reactivex.internal.disposables.DisposableHelper;
import p655io.reactivex.internal.disposables.EmptyDisposable;
import p655io.reactivex.p662b.Disposable;
import p655io.reactivex.p666f.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.observable.v */
public final class ObservableTake<T> extends AbstractObservableWithUpstream<T, T> {
    /* renamed from: b */
    final long f27594b;

    /* compiled from: ObservableTake */
    /* renamed from: io.reactivex.internal.operators.observable.v$a */
    static final class C8141a<T> implements Disposable, Observer<T> {
        /* renamed from: a */
        final Observer<? super T> f27595a;
        /* renamed from: b */
        boolean f27596b;
        /* renamed from: c */
        Disposable f27597c;
        /* renamed from: d */
        long f27598d;

        C8141a(Observer<? super T> lVar, long j) {
            this.f27595a = lVar;
            this.f27598d = j;
        }

        public void onSubscribe(Disposable bVar) {
            if (DisposableHelper.validate(this.f27597c, bVar)) {
                this.f27597c = bVar;
                if (this.f27598d == 0) {
                    this.f27596b = true;
                    bVar.dispose();
                    EmptyDisposable.complete(this.f27595a);
                    return;
                }
                this.f27595a.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            if (!this.f27596b) {
                long j = this.f27598d;
                this.f27598d = j - 1;
                if (j > 0) {
                    boolean z = this.f27598d == 0;
                    this.f27595a.onNext(t);
                    if (z) {
                        onComplete();
                    }
                }
            }
        }

        public void onError(Throwable th) {
            if (this.f27596b) {
                RxJavaPlugins.m34959a(th);
                return;
            }
            this.f27596b = true;
            this.f27597c.dispose();
            this.f27595a.onError(th);
        }

        public void onComplete() {
            if (!this.f27596b) {
                this.f27596b = true;
                this.f27597c.dispose();
                this.f27595a.onComplete();
            }
        }

        public void dispose() {
            this.f27597c.dispose();
        }

        public boolean isDisposed() {
            return this.f27597c.isDisposed();
        }
    }

    public ObservableTake(ObservableSource<T> kVar, long j) {
        super(kVar);
        this.f27594b = j;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo19781a(Observer<? super T> lVar) {
        this.f27515a.subscribe(new C8141a(lVar, this.f27594b));
    }
}
