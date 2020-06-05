package com.jiayouya.travel.module.p276me.p280vm;

import androidx.lifecycle.MutableLiveData;
import com.jiayouya.travel.common.base.BaseViewModel;
import com.jiayouya.travel.common.p244b.ObservableEx;
import com.jiayouya.travel.module.common.data.UserPrivacyRsp;
import com.jiayouya.travel.module.common.p257a.C2962j;
import ezy.app.p643a.API;
import kotlin.Metadata;
import okhttp3.C8364ac;
import p655io.reactivex.p664d.Consumer;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0010\u001a\u00020\fR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007¨\u0006\u0011"}, mo39189d2 = {"Lcom/jiayouya/travel/module/me/vm/PrivateVM;", "Lcom/jiayouya/travel/common/base/BaseViewModel;", "()V", "editData", "Landroidx/lifecycle/MutableLiveData;", "Lokhttp3/ResponseBody;", "getEditData", "()Landroidx/lifecycle/MutableLiveData;", "infoData", "Lcom/jiayouya/travel/module/common/data/UserPrivacyRsp;", "getInfoData", "edit", "", "parent", "", "children", "info", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: PrivateVM.kt */
/* renamed from: com.jiayouya.travel.module.me.vm.PrivateVM */
public final class PrivateVM extends BaseViewModel {
    /* renamed from: a */
    private final MutableLiveData<UserPrivacyRsp> f11748a = new MutableLiveData<>();
    /* renamed from: b */
    private final MutableLiveData<C8364ac> f11749b = new MutableLiveData<>();

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lokhttp3/ResponseBody;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: PrivateVM.kt */
    /* renamed from: com.jiayouya.travel.module.me.vm.PrivateVM$a */
    static final class C3257a<T> implements Consumer<C8364ac> {
        /* renamed from: a */
        final /* synthetic */ PrivateVM f11750a;

        C3257a(PrivateVM privateVM) {
            this.f11750a = privateVM;
        }

        /* renamed from: a */
        public final void accept(C8364ac acVar) {
            this.f11750a.mo21495c().postValue(acVar);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/common/data/UserPrivacyRsp;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: PrivateVM.kt */
    /* renamed from: com.jiayouya.travel.module.me.vm.PrivateVM$b */
    static final class C3258b<T> implements Consumer<UserPrivacyRsp> {
        /* renamed from: a */
        final /* synthetic */ PrivateVM f11751a;

        C3258b(PrivateVM privateVM) {
            this.f11751a = privateVM;
        }

        /* renamed from: a */
        public final void accept(UserPrivacyRsp userPrivacyRsp) {
            this.f11751a.mo21494b().postValue(userPrivacyRsp);
        }
    }

    /* renamed from: b */
    public final MutableLiveData<UserPrivacyRsp> mo21494b() {
        return this.f11748a;
    }

    /* renamed from: c */
    public final MutableLiveData<C8364ac> mo21495c() {
        return this.f11749b;
    }

    /* renamed from: d */
    public final void mo21496d() {
        ObservableEx.m12825b(C2962j.m13561a(API.f27251a).mo20432f(), mo19904a()).mo38904c((Consumer<? super T>) new C3258b<Object>(this));
    }

    /* renamed from: a */
    public static /* synthetic */ void m14262a(PrivateVM privateVM, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = -1;
        }
        if ((i3 & 2) != 0) {
            i2 = -1;
        }
        privateVM.mo21493a(i, i2);
    }

    /* renamed from: a */
    public final void mo21493a(int i, int i2) {
        ObservableEx.m12824a(C2962j.m13561a(API.f27251a).mo20418a(i, i2), mo19904a()).mo38904c((Consumer<? super T>) new C3257a<Object>(this));
    }
}
