package com.jiayouya.travel.module.travel.p290vm;

import androidx.lifecycle.MutableLiveData;
import com.jiayouya.travel.common.base.BaseViewModel;
import com.jiayouya.travel.common.p244b.ObservableEx;
import com.jiayouya.travel.module.travel.data.HandbookItem;
import com.jiayouya.travel.module.travel.p285a.C3324d;
import ezy.app.p643a.API;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;
import p655io.reactivex.p664d.Consumer;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nR\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/vm/HandbookVM;", "Lcom/jiayouya/travel/common/base/BaseViewModel;", "()V", "liveData", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/jiayouya/travel/module/travel/data/HandbookItem;", "getLiveData", "()Landroidx/lifecycle/MutableLiveData;", "list", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: HandbookVM.kt */
/* renamed from: com.jiayouya.travel.module.travel.vm.HandbookVM */
public final class HandbookVM extends BaseViewModel {
    /* renamed from: a */
    private final MutableLiveData<List<HandbookItem>> f12149a = new MutableLiveData<>();

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo39189d2 = {"<anonymous>", "", "it", "", "Lcom/jiayouya/travel/module/travel/data/HandbookItem;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: HandbookVM.kt */
    /* renamed from: com.jiayouya.travel.module.travel.vm.HandbookVM$a */
    static final class C3519a<T> implements Consumer<List<? extends HandbookItem>> {
        /* renamed from: a */
        final /* synthetic */ HandbookVM f12150a;

        C3519a(HandbookVM handbookVM) {
            this.f12150a = handbookVM;
        }

        /* renamed from: a */
        public final void accept(List<HandbookItem> list) {
            C8271i.m35382a((Object) list, "it");
            if (!list.isEmpty()) {
                ((HandbookItem) list.get(0)).setFirst(true);
            }
            this.f12150a.mo22409b().postValue(list);
        }
    }

    /* renamed from: b */
    public final MutableLiveData<List<HandbookItem>> mo22409b() {
        return this.f12149a;
    }

    /* renamed from: c */
    public final void mo22410c() {
        ObservableEx.m12825b(C3324d.m14443a(API.f27251a).mo21645i(), mo19904a()).mo38904c((Consumer<? super T>) new C3519a<Object>(this));
    }
}
