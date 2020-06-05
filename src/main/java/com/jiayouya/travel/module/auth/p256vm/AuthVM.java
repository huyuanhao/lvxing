package com.jiayouya.travel.module.auth.p256vm;

import androidx.lifecycle.MutableLiveData;
import com.jiayouya.travel.common.base.BaseViewModel;
import com.jiayouya.travel.common.p244b.ObservableEx;
import com.jiayouya.travel.module.auth.data.AuthCode;
import com.jiayouya.travel.module.auth.p254a.C2950b;
import ezy.app.p643a.API;
import kotlin.Metadata;
import p655io.reactivex.p664d.Consumer;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, mo39189d2 = {"Lcom/jiayouya/travel/module/auth/vm/AuthVM;", "Lcom/jiayouya/travel/common/base/BaseViewModel;", "()V", "liveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/jiayouya/travel/module/auth/data/AuthCode;", "getLiveData", "()Landroidx/lifecycle/MutableLiveData;", "code", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: AuthVM.kt */
/* renamed from: com.jiayouya.travel.module.auth.vm.AuthVM */
public final class AuthVM extends BaseViewModel {
    /* renamed from: a */
    private final MutableLiveData<AuthCode> f11286a = new MutableLiveData<>();

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/auth/data/AuthCode;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: AuthVM.kt */
    /* renamed from: com.jiayouya.travel.module.auth.vm.AuthVM$a */
    static final class C2956a<T> implements Consumer<AuthCode> {
        /* renamed from: a */
        final /* synthetic */ AuthVM f11287a;

        C2956a(AuthVM authVM) {
            this.f11287a = authVM;
        }

        /* renamed from: a */
        public final void accept(AuthCode authCode) {
            this.f11287a.mo20400b().postValue(authCode);
        }
    }

    /* renamed from: b */
    public final MutableLiveData<AuthCode> mo20400b() {
        return this.f11286a;
    }

    /* renamed from: c */
    public final void mo20401c() {
        ObservableEx.m12824a(C2950b.m13506a(API.f27251a).mo20388a(), mo19904a()).mo38904c((Consumer<? super T>) new C2956a<Object>(this));
    }
}
