package com.uber.autodispose;

import p655io.reactivex.CompletableSource;
import p655io.reactivex.Observable;
import p655io.reactivex.ObservableSource;
import p655io.reactivex.Observer;

/* renamed from: com.uber.autodispose.f */
final class AutoDisposeObservable<T> extends Observable<T> {
    /* renamed from: a */
    private final ObservableSource<T> f25992a;
    /* renamed from: b */
    private final CompletableSource f25993b;

    AutoDisposeObservable(ObservableSource<T> kVar, CompletableSource cVar) {
        this.f25992a = kVar;
        this.f25993b = cVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo19781a(Observer<? super T> lVar) {
        this.f25992a.subscribe(new AutoDisposingObserverImpl(this.f25993b, lVar));
    }
}
