package com.jiayouya.travel.module.p276me.p280vm;

import androidx.lifecycle.MutableLiveData;
import com.jiayouya.travel.common.base.BaseViewModel;
import com.jiayouya.travel.common.p244b.ObservableEx;
import com.jiayouya.travel.module.common.p257a.C2962j;
import com.jiayouya.travel.module.common.p260vm.ResidentMemoryModel;
import ezy.app.p643a.API;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;
import okhttp3.C8364ac;
import p655io.reactivex.p664d.Consumer;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, mo39189d2 = {"Lcom/jiayouya/travel/module/me/vm/NicknameVM;", "Lcom/jiayouya/travel/common/base/BaseViewModel;", "()V", "liveData", "Landroidx/lifecycle/MutableLiveData;", "", "getLiveData", "()Landroidx/lifecycle/MutableLiveData;", "save", "", "nickname", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: NicknameVM.kt */
/* renamed from: com.jiayouya.travel.module.me.vm.NicknameVM */
public final class NicknameVM extends BaseViewModel {
    /* renamed from: a */
    private final MutableLiveData<Object> f11733a = new MutableLiveData<>();

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lokhttp3/ResponseBody;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: NicknameVM.kt */
    /* renamed from: com.jiayouya.travel.module.me.vm.NicknameVM$a */
    static final class C3251a<T> implements Consumer<C8364ac> {
        /* renamed from: a */
        final /* synthetic */ NicknameVM f11734a;

        C3251a(NicknameVM nicknameVM) {
            this.f11734a = nicknameVM;
        }

        /* renamed from: a */
        public final void accept(C8364ac acVar) {
            this.f11734a.mo21476b().postValue(acVar);
            ResidentMemoryModel.m13597a(ResidentMemoryModel.f11323a, null, null, null, 7, null);
        }
    }

    /* renamed from: b */
    public final MutableLiveData<Object> mo21476b() {
        return this.f11733a;
    }

    /* renamed from: a */
    public final void mo21475a(String str) {
        C8271i.m35386b(str, "nickname");
        ObservableEx.m12824a(C2962j.m13561a(API.f27251a).mo20424b(str), mo19904a()).mo38904c((Consumer<? super T>) new C3251a<Object>(this));
    }
}
