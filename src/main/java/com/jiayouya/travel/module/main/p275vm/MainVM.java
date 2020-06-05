package com.jiayouya.travel.module.main.p275vm;

import androidx.lifecycle.MutableLiveData;
import com.jiayouya.travel.common.base.BaseViewModel;
import com.jiayouya.travel.module.common.data.SystemNotice;
import com.jiayouya.travel.module.common.p257a.C2961h;
import ezy.app.p643a.API;
import java.util.List;
import kotlin.Metadata;
import p655io.reactivex.p664d.Consumer;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nR\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, mo39189d2 = {"Lcom/jiayouya/travel/module/main/vm/MainVM;", "Lcom/jiayouya/travel/common/base/BaseViewModel;", "()V", "systemNoticeData", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/jiayouya/travel/module/common/data/SystemNotice;", "getSystemNoticeData", "()Landroidx/lifecycle/MutableLiveData;", "systemNotice", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: MainVM.kt */
/* renamed from: com.jiayouya.travel.module.main.vm.MainVM */
public final class MainVM extends BaseViewModel {
    /* renamed from: a */
    private final MutableLiveData<List<SystemNotice>> f11552a = new MutableLiveData<>();

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo39189d2 = {"<anonymous>", "", "it", "", "Lcom/jiayouya/travel/module/common/data/SystemNotice;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: MainVM.kt */
    /* renamed from: com.jiayouya.travel.module.main.vm.MainVM$a */
    static final class C3101a<T> implements Consumer<List<? extends SystemNotice>> {
        /* renamed from: a */
        final /* synthetic */ MainVM f11553a;

        C3101a(MainVM mainVM) {
            this.f11553a = mainVM;
        }

        /* renamed from: a */
        public final void accept(List<SystemNotice> list) {
            this.f11553a.mo21185b().postValue(list);
        }
    }

    /* renamed from: b */
    public final MutableLiveData<List<SystemNotice>> mo21185b() {
        return this.f11552a;
    }

    /* renamed from: c */
    public final void mo21186c() {
        C2961h.m13543a(API.f27251a).mo20416b().mo38904c((Consumer<? super T>) new C3101a<Object>(this));
    }
}
