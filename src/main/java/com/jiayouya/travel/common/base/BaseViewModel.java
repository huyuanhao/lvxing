package com.jiayouya.travel.common.base;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import p655io.reactivex.p662b.CompositeDisposable;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\b\u0010\u000f\u001a\u00020\u000bH\u0015R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0010"}, mo39189d2 = {"Lcom/jiayouya/travel/common/base/BaseViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "loadingEvent", "Landroidx/lifecycle/MutableLiveData;", "", "getLoadingEvent", "()Landroidx/lifecycle/MutableLiveData;", "launch", "", "job", "Lkotlin/Function0;", "Lio/reactivex/disposables/Disposable;", "onCleared", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: BaseViewModel.kt */
public class BaseViewModel extends ViewModel {
    /* renamed from: a */
    private final CompositeDisposable f9594a = new CompositeDisposable();
    /* renamed from: b */
    private final MutableLiveData<Integer> f9595b = new MutableLiveData<>();

    /* renamed from: a */
    public final MutableLiveData<Integer> mo19904a() {
        return this.f9595b;
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        super.onCleared();
        this.f9594a.mo38828a();
    }
}
