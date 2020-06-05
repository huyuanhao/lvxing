package com.jiayouya.travel.module.explore.p266vm;

import androidx.lifecycle.MutableLiveData;
import com.jiayouya.travel.common.base.BaseViewModel;
import com.jiayouya.travel.common.p244b.ObservableEx;
import com.jiayouya.travel.module.common.data.AdRsp;
import com.jiayouya.travel.module.common.data.Resource;
import com.jiayouya.travel.module.common.data.Resource.Companion;
import com.jiayouya.travel.module.common.p257a.C2957b;
import com.jiayouya.travel.module.explore.data.ExploreIndex;
import com.jiayouya.travel.module.explore.data.ExploreIndexKt;
import com.jiayouya.travel.module.explore.data.HarvestItem;
import com.jiayouya.travel.module.explore.p263a.C2994b;
import ezy.app.p643a.API;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;
import okhttp3.C8364ac;
import p655io.reactivex.Observable;
import p655io.reactivex.p662b.Disposable;
import p655io.reactivex.p664d.Consumer;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\nJ\u0006\u0010\u0019\u001a\u00020\u0015J\u000e\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\nJ\u0006\u0010\u001c\u001a\u00020\u0015J\b\u0010\u001d\u001a\u00020\u0015H\u0014J\u0006\u0010\u001e\u001a\u00020\u0015R\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\bR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\b¨\u0006\u001f"}, mo39189d2 = {"Lcom/jiayouya/travel/module/explore/vm/ExploreVM;", "Lcom/jiayouya/travel/common/base/BaseViewModel;", "()V", "adData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/jiayouya/travel/module/common/data/Resource;", "Lcom/jiayouya/travel/module/common/data/AdRsp;", "getAdData", "()Landroidx/lifecycle/MutableLiveData;", "claimData", "", "getClaimData", "d", "Lio/reactivex/disposables/Disposable;", "indexData", "Lcom/jiayouya/travel/module/explore/data/ExploreIndex;", "getIndexData", "recallData", "", "getRecallData", "claimReward", "", "item", "Lcom/jiayouya/travel/module/explore/data/HarvestItem;", "position", "dispose", "getAdId", "scene", "index", "onCleared", "recall", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: ExplorVM.kt */
/* renamed from: com.jiayouya.travel.module.explore.vm.ExploreVM */
public final class ExploreVM extends BaseViewModel {
    /* renamed from: a */
    private final MutableLiveData<Object> f11443a = new MutableLiveData<>();
    /* renamed from: b */
    private final MutableLiveData<ExploreIndex> f11444b = new MutableLiveData<>();
    /* renamed from: c */
    private final MutableLiveData<Resource<AdRsp>> f11445c = new MutableLiveData<>();
    /* renamed from: d */
    private final MutableLiveData<Integer> f11446d = new MutableLiveData<>();
    /* access modifiers changed from: private */
    /* renamed from: e */
    public Disposable f11447e;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lokhttp3/ResponseBody;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: ExplorVM.kt */
    /* renamed from: com.jiayouya.travel.module.explore.vm.ExploreVM$a */
    static final class C3031a<T> implements Consumer<C8364ac> {
        /* renamed from: a */
        final /* synthetic */ ExploreVM f11448a;
        /* renamed from: b */
        final /* synthetic */ int f11449b;

        C3031a(ExploreVM exploreVM, int i) {
            this.f11448a = exploreVM;
            this.f11449b = i;
        }

        /* renamed from: a */
        public final void accept(C8364ac acVar) {
            this.f11448a.mo20933e().postValue(Integer.valueOf(this.f11449b));
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/common/data/AdRsp;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: ExplorVM.kt */
    /* renamed from: com.jiayouya.travel.module.explore.vm.ExploreVM$b */
    static final class C3032b<T> implements Consumer<AdRsp> {
        /* renamed from: a */
        final /* synthetic */ ExploreVM f11450a;
        /* renamed from: b */
        final /* synthetic */ int f11451b;

        C3032b(ExploreVM exploreVM, int i) {
            this.f11450a = exploreVM;
            this.f11451b = i;
        }

        /* renamed from: a */
        public final void accept(AdRsp adRsp) {
            this.f11450a.mo20932d().postValue(Companion.success$default(Resource.Companion, adRsp, false, Integer.valueOf(this.f11451b), 2, null));
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/explore/data/ExploreIndex;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: ExplorVM.kt */
    /* renamed from: com.jiayouya.travel.module.explore.vm.ExploreVM$c */
    static final class C3033c<T> implements Consumer<ExploreIndex> {
        /* renamed from: a */
        final /* synthetic */ ExploreVM f11452a;

        C3033c(ExploreVM exploreVM) {
            this.f11452a = exploreVM;
        }

        /* renamed from: a */
        public final void accept(ExploreIndex exploreIndex) {
            this.f11452a.mo20931c().postValue(exploreIndex);
            this.f11452a.mo20936h();
            if (exploreIndex.getSeconds() > 0) {
                this.f11452a.f11447e = Observable.m34992a(exploreIndex.getRSeconds(), TimeUnit.SECONDS).mo38904c((Consumer<? super T>) new Consumer<Long>(this) {
                    /* renamed from: a */
                    final /* synthetic */ C3033c f11453a;

                    {
                        this.f11453a = r1;
                    }

                    /* renamed from: a */
                    public final void accept(Long l) {
                        this.f11453a.f11452a.mo20934f();
                    }
                });
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lokhttp3/ResponseBody;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: ExplorVM.kt */
    /* renamed from: com.jiayouya.travel.module.explore.vm.ExploreVM$d */
    static final class C3035d<T> implements Consumer<C8364ac> {
        /* renamed from: a */
        final /* synthetic */ ExploreVM f11454a;

        C3035d(ExploreVM exploreVM) {
            this.f11454a = exploreVM;
        }

        /* renamed from: a */
        public final void accept(C8364ac acVar) {
            this.f11454a.mo20930b().postValue(acVar);
        }
    }

    /* renamed from: b */
    public final MutableLiveData<Object> mo20930b() {
        return this.f11443a;
    }

    /* renamed from: c */
    public final MutableLiveData<ExploreIndex> mo20931c() {
        return this.f11444b;
    }

    /* renamed from: d */
    public final MutableLiveData<Resource<AdRsp>> mo20932d() {
        return this.f11445c;
    }

    /* renamed from: e */
    public final MutableLiveData<Integer> mo20933e() {
        return this.f11446d;
    }

    /* renamed from: f */
    public final void mo20934f() {
        ObservableEx.m12825b(C2994b.m13658a(API.f27251a).mo20816a(), mo19904a()).mo38904c((Consumer<? super T>) new C3033c<Object>(this));
    }

    /* renamed from: a */
    public final void mo20928a(int i) {
        ObservableEx.m12824a(C2957b.m13527a(API.f27251a).mo20403a(i), mo19904a()).mo38904c((Consumer<? super T>) new C3032b<Object>(this, i));
    }

    /* renamed from: a */
    public final void mo20929a(HarvestItem harvestItem, int i) {
        C8271i.m35386b(harvestItem, "item");
        ObservableEx.m12824a(C2994b.m13658a(API.f27251a).mo20818a(String.valueOf(harvestItem.getType()), ExploreIndexKt.isDog(harvestItem) ? "1" : ""), mo19904a()).mo38904c((Consumer<? super T>) new C3031a<Object>(this, i));
    }

    /* renamed from: g */
    public final void mo20935g() {
        ObservableEx.m12824a(C2994b.m13658a(API.f27251a).mo20819b(), mo19904a()).mo38904c((Consumer<? super T>) new C3035d<Object>(this));
    }

    /* renamed from: h */
    public final void mo20936h() {
        Disposable bVar = this.f11447e;
        if (bVar != null && !bVar.isDisposed()) {
            Disposable bVar2 = this.f11447e;
            if (bVar2 != null) {
                bVar2.dispose();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        super.onCleared();
        mo20936h();
    }
}
