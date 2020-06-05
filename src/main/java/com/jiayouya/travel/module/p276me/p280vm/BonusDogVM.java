package com.jiayouya.travel.module.p276me.p280vm;

import androidx.lifecycle.MutableLiveData;
import com.jiayouya.travel.common.base.BaseViewModel;
import com.jiayouya.travel.common.p244b.ObservableEx;
import com.jiayouya.travel.module.p276me.data.DogAnalysisRsp;
import com.jiayouya.travel.module.p276me.p277a.C3109b;
import ezy.app.p643a.API;
import kotlin.Metadata;
import p655io.reactivex.p664d.Consumer;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, mo39189d2 = {"Lcom/jiayouya/travel/module/me/vm/BonusDogVM;", "Lcom/jiayouya/travel/common/base/BaseViewModel;", "()V", "liveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/jiayouya/travel/module/me/data/DogAnalysisRsp;", "getLiveData", "()Landroidx/lifecycle/MutableLiveData;", "info", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: BonusDogVM.kt */
/* renamed from: com.jiayouya.travel.module.me.vm.BonusDogVM */
public final class BonusDogVM extends BaseViewModel {
    /* renamed from: a */
    private final MutableLiveData<DogAnalysisRsp> f11710a = new MutableLiveData<>();

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/me/data/DogAnalysisRsp;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: BonusDogVM.kt */
    /* renamed from: com.jiayouya.travel.module.me.vm.BonusDogVM$a */
    static final class C3242a<T> implements Consumer<DogAnalysisRsp> {
        /* renamed from: a */
        final /* synthetic */ BonusDogVM f11711a;

        C3242a(BonusDogVM bonusDogVM) {
            this.f11711a = bonusDogVM;
        }

        /* renamed from: a */
        public final void accept(DogAnalysisRsp dogAnalysisRsp) {
            this.f11711a.mo21448b().postValue(dogAnalysisRsp);
        }
    }

    /* renamed from: b */
    public final MutableLiveData<DogAnalysisRsp> mo21448b() {
        return this.f11710a;
    }

    /* renamed from: c */
    public final void mo21449c() {
        ObservableEx.m12825b(C3109b.m13925a(API.f27251a).mo21208b(), mo19904a()).mo38904c((Consumer<? super T>) new C3242a<Object>(this));
    }
}
