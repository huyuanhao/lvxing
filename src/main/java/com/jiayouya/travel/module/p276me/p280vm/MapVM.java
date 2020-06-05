package com.jiayouya.travel.module.p276me.p280vm;

import androidx.lifecycle.MutableLiveData;
import com.jiayouya.travel.common.base.BaseViewModel;
import com.jiayouya.travel.common.p244b.ObservableEx;
import com.jiayouya.travel.module.common.data.Resource;
import com.jiayouya.travel.module.common.data.Resource.Companion;
import com.jiayouya.travel.module.group.data.ClaimCityReward;
import com.jiayouya.travel.module.group.data.TravelCity;
import com.jiayouya.travel.module.group.p267a.C3042b;
import com.jiayouya.travel.module.p276me.data.DogProgressRsp;
import com.jiayouya.travel.module.p276me.p277a.C3109b;
import ezy.app.p643a.API;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;
import p655io.reactivex.p664d.Consumer;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0010J\u0006\u0010\u0014\u001a\u00020\u0010R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007R\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0007¨\u0006\u0015"}, mo39189d2 = {"Lcom/jiayouya/travel/module/me/vm/MapVM;", "Lcom/jiayouya/travel/common/base/BaseViewModel;", "()V", "liveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/jiayouya/travel/module/group/data/TravelCity;", "getLiveData", "()Landroidx/lifecycle/MutableLiveData;", "progressData", "Lcom/jiayouya/travel/module/me/data/DogProgressRsp;", "getProgressData", "rewardData", "Lcom/jiayouya/travel/module/common/data/Resource;", "Lcom/jiayouya/travel/module/group/data/ClaimCityReward;", "getRewardData", "claimReward", "", "id", "", "progress", "travelCity", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: MapVM.kt */
/* renamed from: com.jiayouya.travel.module.me.vm.MapVM */
public final class MapVM extends BaseViewModel {
    /* renamed from: a */
    private final MutableLiveData<TravelCity> f11723a = new MutableLiveData<>();
    /* renamed from: b */
    private final MutableLiveData<DogProgressRsp> f11724b = new MutableLiveData<>();
    /* renamed from: c */
    private final MutableLiveData<Resource<ClaimCityReward>> f11725c = new MutableLiveData<>();

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/group/data/ClaimCityReward;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: MapVM.kt */
    /* renamed from: com.jiayouya.travel.module.me.vm.MapVM$a */
    static final class C3247a<T> implements Consumer<ClaimCityReward> {
        /* renamed from: a */
        final /* synthetic */ MapVM f11726a;
        /* renamed from: b */
        final /* synthetic */ String f11727b;

        C3247a(MapVM mapVM, String str) {
            this.f11726a = mapVM;
            this.f11727b = str;
        }

        /* renamed from: a */
        public final void accept(ClaimCityReward claimCityReward) {
            this.f11726a.mo21466d().postValue(Companion.success$default(Resource.Companion, claimCityReward, false, this.f11727b, 2, null));
            this.f11726a.mo21468f();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/me/data/DogProgressRsp;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: MapVM.kt */
    /* renamed from: com.jiayouya.travel.module.me.vm.MapVM$b */
    static final class C3248b<T> implements Consumer<DogProgressRsp> {
        /* renamed from: a */
        final /* synthetic */ MapVM f11728a;

        C3248b(MapVM mapVM) {
            this.f11728a = mapVM;
        }

        /* renamed from: a */
        public final void accept(DogProgressRsp dogProgressRsp) {
            this.f11728a.mo21465c().postValue(dogProgressRsp);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/group/data/TravelCity;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: MapVM.kt */
    /* renamed from: com.jiayouya.travel.module.me.vm.MapVM$c */
    static final class C3249c<T> implements Consumer<TravelCity> {
        /* renamed from: a */
        final /* synthetic */ MapVM f11729a;

        C3249c(MapVM mapVM) {
            this.f11729a = mapVM;
        }

        /* renamed from: a */
        public final void accept(TravelCity travelCity) {
            this.f11729a.mo21464b().postValue(travelCity);
        }
    }

    /* renamed from: b */
    public final MutableLiveData<TravelCity> mo21464b() {
        return this.f11723a;
    }

    /* renamed from: c */
    public final MutableLiveData<DogProgressRsp> mo21465c() {
        return this.f11724b;
    }

    /* renamed from: d */
    public final MutableLiveData<Resource<ClaimCityReward>> mo21466d() {
        return this.f11725c;
    }

    /* renamed from: e */
    public final void mo21467e() {
        ObservableEx.m12824a(C3042b.m13773a(API.f27251a).mo20957b(), mo19904a()).mo38904c((Consumer<? super T>) new C3249c<Object>(this));
    }

    /* renamed from: f */
    public final void mo21468f() {
        C3109b.m13925a(API.f27251a).mo21205a().mo38904c((Consumer<? super T>) new C3248b<Object>(this));
    }

    /* renamed from: a */
    public final void mo21463a(String str) {
        C8271i.m35386b(str, "id");
        ObservableEx.m12824a(C3042b.m13773a(API.f27251a).mo20962f(str), mo19904a()).mo38904c((Consumer<? super T>) new C3247a<Object>(this, str));
    }
}
