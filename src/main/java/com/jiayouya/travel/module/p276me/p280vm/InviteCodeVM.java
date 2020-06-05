package com.jiayouya.travel.module.p276me.p280vm;

import androidx.lifecycle.MutableLiveData;
import com.jiayouya.travel.common.base.BaseViewModel;
import com.jiayouya.travel.common.p244b.ObservableEx;
import com.jiayouya.travel.module.common.data.InviteDataRsp;
import com.jiayouya.travel.module.common.data.ParentRsp;
import com.jiayouya.travel.module.common.p257a.C2962j;
import ezy.app.p643a.API;
import kotlin.Metadata;
import p655io.reactivex.p664d.Consumer;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u000bR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007¨\u0006\r"}, mo39189d2 = {"Lcom/jiayouya/travel/module/me/vm/InviteCodeVM;", "Lcom/jiayouya/travel/common/base/BaseViewModel;", "()V", "inviteData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/jiayouya/travel/module/common/data/InviteDataRsp;", "getInviteData", "()Landroidx/lifecycle/MutableLiveData;", "parentData", "Lcom/jiayouya/travel/module/common/data/ParentRsp;", "getParentData", "", "inviteParent", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: InviteCodeVM.kt */
/* renamed from: com.jiayouya.travel.module.me.vm.InviteCodeVM */
public final class InviteCodeVM extends BaseViewModel {
    /* renamed from: a */
    private final MutableLiveData<InviteDataRsp> f11718a = new MutableLiveData<>();
    /* renamed from: b */
    private final MutableLiveData<ParentRsp> f11719b = new MutableLiveData<>();

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/common/data/InviteDataRsp;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: InviteCodeVM.kt */
    /* renamed from: com.jiayouya.travel.module.me.vm.InviteCodeVM$a */
    static final class C3245a<T> implements Consumer<InviteDataRsp> {
        /* renamed from: a */
        final /* synthetic */ InviteCodeVM f11720a;

        C3245a(InviteCodeVM inviteCodeVM) {
            this.f11720a = inviteCodeVM;
        }

        /* renamed from: a */
        public final void accept(InviteDataRsp inviteDataRsp) {
            this.f11720a.mo21457b().postValue(inviteDataRsp);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/common/data/ParentRsp;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: InviteCodeVM.kt */
    /* renamed from: com.jiayouya.travel.module.me.vm.InviteCodeVM$b */
    static final class C3246b<T> implements Consumer<ParentRsp> {
        /* renamed from: a */
        final /* synthetic */ InviteCodeVM f11721a;

        C3246b(InviteCodeVM inviteCodeVM) {
            this.f11721a = inviteCodeVM;
        }

        /* renamed from: a */
        public final void accept(ParentRsp parentRsp) {
            this.f11721a.mo21458c().postValue(parentRsp);
        }
    }

    /* renamed from: b */
    public final MutableLiveData<InviteDataRsp> mo21457b() {
        return this.f11718a;
    }

    /* renamed from: c */
    public final MutableLiveData<ParentRsp> mo21458c() {
        return this.f11719b;
    }

    /* renamed from: d */
    public final void mo21459d() {
        ObservableEx.m12825b(C2962j.m13561a(API.f27251a).mo20423b(), mo19904a()).mo38904c((Consumer<? super T>) new C3245a<Object>(this));
    }

    /* renamed from: e */
    public final void mo21460e() {
        ObservableEx.m12824a(C2962j.m13561a(API.f27251a).mo20426c(), mo19904a()).mo38904c((Consumer<? super T>) new C3246b<Object>(this));
    }
}
