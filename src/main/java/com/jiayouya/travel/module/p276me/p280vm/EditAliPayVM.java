package com.jiayouya.travel.module.p276me.p280vm;

import androidx.lifecycle.MutableLiveData;
import com.jiayouya.travel.common.base.BaseViewModel;
import com.jiayouya.travel.common.p244b.ObservableEx;
import com.jiayouya.travel.module.common.p257a.C2961h;
import com.jiayouya.travel.module.common.p257a.CommonService.C2960a;
import ezy.app.p643a.API;
import kotlin.Metadata;
import okhttp3.C8364ac;
import p655io.reactivex.p664d.Consumer;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, mo39189d2 = {"Lcom/jiayouya/travel/module/me/vm/EditAliPayVM;", "Lcom/jiayouya/travel/common/base/BaseViewModel;", "()V", "codeData", "Landroidx/lifecycle/MutableLiveData;", "", "getCodeData", "()Landroidx/lifecycle/MutableLiveData;", "code", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: EditAliPayVM.kt */
/* renamed from: com.jiayouya.travel.module.me.vm.EditAliPayVM */
public final class EditAliPayVM extends BaseViewModel {
    /* renamed from: a */
    private final MutableLiveData<Object> f11716a = new MutableLiveData<>();

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lokhttp3/ResponseBody;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: EditAliPayVM.kt */
    /* renamed from: com.jiayouya.travel.module.me.vm.EditAliPayVM$a */
    static final class C3244a<T> implements Consumer<C8364ac> {
        /* renamed from: a */
        final /* synthetic */ EditAliPayVM f11717a;

        C3244a(EditAliPayVM editAliPayVM) {
            this.f11717a = editAliPayVM;
        }

        /* renamed from: a */
        public final void accept(C8364ac acVar) {
            this.f11717a.mo21454b().postValue(acVar);
        }
    }

    /* renamed from: b */
    public final MutableLiveData<Object> mo21454b() {
        return this.f11716a;
    }

    /* renamed from: c */
    public final void mo21455c() {
        ObservableEx.m12824a(C2960a.m13542a(C2961h.m13543a(API.f27251a), 5, null, 2, null), mo19904a()).mo38904c((Consumer<? super T>) new C3244a<Object>(this));
    }
}
