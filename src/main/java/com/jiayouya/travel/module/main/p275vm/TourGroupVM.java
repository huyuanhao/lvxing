package com.jiayouya.travel.module.main.p275vm;

import androidx.lifecycle.MutableLiveData;
import com.jiayouya.travel.common.base.BaseViewModel;
import com.jiayouya.travel.common.p244b.ObservableEx;
import com.jiayouya.travel.module.common.data.ParentRsp;
import com.jiayouya.travel.module.common.p257a.C2962j;
import com.jiayouya.travel.module.group.data.GroupIndexRsp;
import com.jiayouya.travel.module.group.p267a.C3042b;
import ezy.app.p643a.API;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;
import p655io.reactivex.p664d.Consumer;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u000eJ\u0006\u0010\u0013\u001a\u00020\u000eR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0007¨\u0006\u0014"}, mo39189d2 = {"Lcom/jiayouya/travel/module/main/vm/TourGroupVM;", "Lcom/jiayouya/travel/common/base/BaseViewModel;", "()V", "indexData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/jiayouya/travel/module/group/data/GroupIndexRsp;", "getIndexData", "()Landroidx/lifecycle/MutableLiveData;", "parentData", "Lcom/jiayouya/travel/module/common/data/ParentRsp;", "getParentData", "starParentData", "getStarParentData", "claimReward", "", "id", "", "index", "inviteParent", "starParent", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: TourGroupVM.kt */
/* renamed from: com.jiayouya.travel.module.main.vm.TourGroupVM */
public final class TourGroupVM extends BaseViewModel {
    /* renamed from: a */
    private final MutableLiveData<GroupIndexRsp> f11560a = new MutableLiveData<>();
    /* renamed from: b */
    private final MutableLiveData<ParentRsp> f11561b = new MutableLiveData<>();
    /* renamed from: c */
    private final MutableLiveData<ParentRsp> f11562c = new MutableLiveData<>();

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/group/data/GroupIndexRsp;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TourGroupVM.kt */
    /* renamed from: com.jiayouya.travel.module.main.vm.TourGroupVM$a */
    static final class C3105a<T> implements Consumer<GroupIndexRsp> {
        /* renamed from: a */
        final /* synthetic */ TourGroupVM f11563a;

        C3105a(TourGroupVM tourGroupVM) {
            this.f11563a = tourGroupVM;
        }

        /* renamed from: a */
        public final void accept(GroupIndexRsp groupIndexRsp) {
            this.f11563a.mo21196b().postValue(groupIndexRsp);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/common/data/ParentRsp;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TourGroupVM.kt */
    /* renamed from: com.jiayouya.travel.module.main.vm.TourGroupVM$b */
    static final class C3106b<T> implements Consumer<ParentRsp> {
        /* renamed from: a */
        final /* synthetic */ TourGroupVM f11564a;

        C3106b(TourGroupVM tourGroupVM) {
            this.f11564a = tourGroupVM;
        }

        /* renamed from: a */
        public final void accept(ParentRsp parentRsp) {
            this.f11564a.mo21197c().postValue(parentRsp);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/common/data/ParentRsp;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TourGroupVM.kt */
    /* renamed from: com.jiayouya.travel.module.main.vm.TourGroupVM$c */
    static final class C3107c<T> implements Consumer<ParentRsp> {
        /* renamed from: a */
        final /* synthetic */ TourGroupVM f11565a;

        C3107c(TourGroupVM tourGroupVM) {
            this.f11565a = tourGroupVM;
        }

        /* renamed from: a */
        public final void accept(ParentRsp parentRsp) {
            this.f11565a.mo21198d().postValue(parentRsp);
        }
    }

    /* renamed from: b */
    public final MutableLiveData<GroupIndexRsp> mo21196b() {
        return this.f11560a;
    }

    /* renamed from: c */
    public final MutableLiveData<ParentRsp> mo21197c() {
        return this.f11561b;
    }

    /* renamed from: d */
    public final MutableLiveData<ParentRsp> mo21198d() {
        return this.f11562c;
    }

    /* renamed from: e */
    public final void mo21199e() {
        ObservableEx.m12825b(C3042b.m13773a(API.f27251a).mo20955a(), mo19904a()).mo38904c((Consumer<? super T>) new C3105a<Object>(this));
    }

    /* renamed from: a */
    public final void mo21195a(String str) {
        C8271i.m35386b(str, "id");
        ObservableEx.m12824a(C3042b.m13773a(API.f27251a).mo20960d(str), mo19904a()).mo38910i();
    }

    /* renamed from: f */
    public final void mo21200f() {
        ObservableEx.m12824a(C2962j.m13561a(API.f27251a).mo20426c(), mo19904a()).mo38904c((Consumer<? super T>) new C3106b<Object>(this));
    }

    /* renamed from: g */
    public final void mo21201g() {
        ObservableEx.m12824a(C2962j.m13561a(API.f27251a).mo20428d(), mo19904a()).mo38904c((Consumer<? super T>) new C3107c<Object>(this));
    }
}
