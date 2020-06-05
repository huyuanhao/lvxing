package com.jakewharton.rxbinding2;

import p655io.reactivex.Observable;
import p655io.reactivex.Observer;

/* renamed from: com.jakewharton.rxbinding2.a */
public abstract class InitialValueObservable<T> extends Observable<T> {
    /* renamed from: a */
    public abstract T mo19780a();

    /* renamed from: b */
    public abstract void mo19782b(Observer<? super T> lVar);

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final void mo19781a(Observer<? super T> lVar) {
        mo19782b(lVar);
        lVar.onNext(mo19780a());
    }
}
