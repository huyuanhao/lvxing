package p655io.reactivex.internal.operators.observable;

import p655io.reactivex.Observable;
import p655io.reactivex.Observer;
import p655io.reactivex.internal.observers.DisposableLambdaObserver;
import p655io.reactivex.p662b.Disposable;
import p655io.reactivex.p664d.C8083a;
import p655io.reactivex.p664d.Consumer;

/* renamed from: io.reactivex.internal.operators.observable.e */
public final class ObservableDoOnLifecycle<T> extends AbstractObservableWithUpstream<T, T> {
    /* renamed from: b */
    private final Consumer<? super Disposable> f27544b;
    /* renamed from: c */
    private final C8083a f27545c;

    public ObservableDoOnLifecycle(Observable<T> iVar, Consumer<? super Disposable> gVar, C8083a aVar) {
        super(iVar);
        this.f27544b = gVar;
        this.f27545c = aVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo19781a(Observer<? super T> lVar) {
        this.f27515a.subscribe(new DisposableLambdaObserver(lVar, this.f27544b, this.f27545c));
    }
}
