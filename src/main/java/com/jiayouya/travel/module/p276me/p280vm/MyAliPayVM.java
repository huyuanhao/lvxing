package com.jiayouya.travel.module.p276me.p280vm;

import androidx.lifecycle.MutableLiveData;
import com.jiayouya.travel.common.base.BaseViewModel;
import com.jiayouya.travel.common.p244b.ObservableEx;
import com.jiayouya.travel.module.common.data.AliUserRsp;
import com.jiayouya.travel.module.common.p257a.C2958d;
import ezy.app.p643a.API;
import kotlin.Metadata;
import p655io.reactivex.p664d.Consumer;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007¨\u0006\u0010"}, mo39189d2 = {"Lcom/jiayouya/travel/module/me/vm/MyAliPayVM;", "Lcom/jiayouya/travel/common/base/BaseViewModel;", "()V", "aliUserData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/jiayouya/travel/module/common/data/AliUserRsp;", "getAliUserData", "()Landroidx/lifecycle/MutableLiveData;", "codeData", "", "getCodeData", "aliInfo", "", "code", "scene", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: MyAliPayVM.kt */
/* renamed from: com.jiayouya.travel.module.me.vm.MyAliPayVM */
public final class MyAliPayVM extends BaseViewModel {
    /* renamed from: a */
    private final MutableLiveData<Object> f11730a = new MutableLiveData<>();
    /* renamed from: b */
    private final MutableLiveData<AliUserRsp> f11731b = new MutableLiveData<>();

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/common/data/AliUserRsp;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: MyAliPayVM.kt */
    /* renamed from: com.jiayouya.travel.module.me.vm.MyAliPayVM$a */
    static final class C3250a<T> implements Consumer<AliUserRsp> {
        /* renamed from: a */
        final /* synthetic */ MyAliPayVM f11732a;

        C3250a(MyAliPayVM myAliPayVM) {
            this.f11732a = myAliPayVM;
        }

        /* renamed from: a */
        public final void accept(AliUserRsp aliUserRsp) {
            this.f11732a.mo21472b().postValue(aliUserRsp);
        }
    }

    /* renamed from: b */
    public final MutableLiveData<AliUserRsp> mo21472b() {
        return this.f11731b;
    }

    /* renamed from: c */
    public final void mo21473c() {
        ObservableEx.m12824a(C2958d.m13532a(API.f27251a).mo20405a(), mo19904a()).mo38904c((Consumer<? super T>) new C3250a<Object>(this));
    }
}
