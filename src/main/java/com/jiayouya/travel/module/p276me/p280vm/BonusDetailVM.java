package com.jiayouya.travel.module.p276me.p280vm;

import androidx.lifecycle.MutableLiveData;
import com.jiayouya.travel.common.base.BaseViewModel;
import com.jiayouya.travel.common.p244b.ObservableEx;
import com.jiayouya.travel.module.p276me.data.BonusDetailRsp;
import com.jiayouya.travel.module.p276me.p277a.C3109b;
import ezy.app.p643a.API;
import kotlin.Metadata;
import p655io.reactivex.p664d.Consumer;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, mo39189d2 = {"Lcom/jiayouya/travel/module/me/vm/BonusDetailVM;", "Lcom/jiayouya/travel/common/base/BaseViewModel;", "()V", "liveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/jiayouya/travel/module/me/data/BonusDetailRsp;", "getLiveData", "()Landroidx/lifecycle/MutableLiveData;", "info", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: BonusDetailVM.kt */
/* renamed from: com.jiayouya.travel.module.me.vm.BonusDetailVM */
public final class BonusDetailVM extends BaseViewModel {
    /* renamed from: a */
    private final MutableLiveData<BonusDetailRsp> f11708a = new MutableLiveData<>();

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/me/data/BonusDetailRsp;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: BonusDetailVM.kt */
    /* renamed from: com.jiayouya.travel.module.me.vm.BonusDetailVM$a */
    static final class C3241a<T> implements Consumer<BonusDetailRsp> {
        /* renamed from: a */
        final /* synthetic */ BonusDetailVM f11709a;

        C3241a(BonusDetailVM bonusDetailVM) {
            this.f11709a = bonusDetailVM;
        }

        /* renamed from: a */
        public final void accept(BonusDetailRsp bonusDetailRsp) {
            this.f11709a.mo21445b().postValue(bonusDetailRsp);
        }
    }

    /* renamed from: b */
    public final MutableLiveData<BonusDetailRsp> mo21445b() {
        return this.f11708a;
    }

    /* renamed from: c */
    public final void mo21446c() {
        ObservableEx.m12825b(C3109b.m13925a(API.f27251a).mo21211c(), mo19904a()).mo38904c((Consumer<? super T>) new C3241a<Object>(this));
    }
}
