package com.jiayouya.travel.module.travel.p290vm;

import androidx.lifecycle.MutableLiveData;
import com.jiayouya.travel.common.base.BaseViewModel;
import com.jiayouya.travel.common.p244b.ObservableEx;
import com.jiayouya.travel.module.travel.data.CoinRankListItem;
import com.jiayouya.travel.module.travel.p285a.C3324d;
import ezy.app.data.DataPage;
import ezy.app.p643a.API;
import kotlin.Metadata;
import p655io.reactivex.p664d.Consumer;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/vm/CoinRankListVM;", "Lcom/jiayouya/travel/common/base/BaseViewModel;", "()V", "liveData", "Landroidx/lifecycle/MutableLiveData;", "Lezy/app/data/DataPage;", "Lcom/jiayouya/travel/module/travel/data/CoinRankListItem;", "getLiveData", "()Landroidx/lifecycle/MutableLiveData;", "next", "", "list", "", "isRefresh", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: CoinRankListVM.kt */
/* renamed from: com.jiayouya.travel.module.travel.vm.CoinRankListVM */
public final class CoinRankListVM extends BaseViewModel {
    /* renamed from: a */
    private final MutableLiveData<DataPage<CoinRankListItem>> f12139a = new MutableLiveData<>();
    /* access modifiers changed from: private */
    /* renamed from: b */
    public String f12140b = "";

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo39189d2 = {"<anonymous>", "", "it", "Lezy/app/data/DataPage;", "Lcom/jiayouya/travel/module/travel/data/CoinRankListItem;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: CoinRankListVM.kt */
    /* renamed from: com.jiayouya.travel.module.travel.vm.CoinRankListVM$a */
    static final class C3517a<T> implements Consumer<DataPage<CoinRankListItem>> {
        /* renamed from: a */
        final /* synthetic */ CoinRankListVM f12141a;
        /* renamed from: b */
        final /* synthetic */ boolean f12142b;

        C3517a(CoinRankListVM coinRankListVM, boolean z) {
            this.f12141a = coinRankListVM;
            this.f12142b = z;
        }

        /* renamed from: a */
        public final void accept(DataPage<CoinRankListItem> dataPage) {
            dataPage.setRefresh(this.f12142b);
            this.f12141a.f12140b = dataPage.getNext();
            this.f12141a.mo22404b().postValue(dataPage);
        }
    }

    /* renamed from: b */
    public final MutableLiveData<DataPage<CoinRankListItem>> mo22404b() {
        return this.f12139a;
    }

    /* renamed from: a */
    public final void mo22403a(boolean z) {
        if (z) {
            this.f12140b = "";
        }
        ObservableEx.m12825b(C3324d.m14443a(API.f27251a).mo21639d(this.f12140b), mo19904a()).mo38904c((Consumer<? super T>) new C3517a<Object>(this, z));
    }
}
