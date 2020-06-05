package com.jiayouya.travel.module.assets.p253vm;

import androidx.lifecycle.MutableLiveData;
import com.jiayouya.travel.common.base.BaseViewModel;
import com.jiayouya.travel.common.p244b.ObservableEx;
import com.jiayouya.travel.module.assets.data.LogsItem;
import com.jiayouya.travel.module.assets.p250a.C2929b;
import ezy.app.data.DataPage;
import ezy.app.p643a.API;
import kotlin.Metadata;
import p655io.reactivex.p664d.Consumer;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo39189d2 = {"Lcom/jiayouya/travel/module/assets/vm/CashLogsVM;", "Lcom/jiayouya/travel/common/base/BaseViewModel;", "()V", "liveData", "Landroidx/lifecycle/MutableLiveData;", "Lezy/app/data/DataPage;", "Lcom/jiayouya/travel/module/assets/data/LogsItem;", "getLiveData", "()Landroidx/lifecycle/MutableLiveData;", "next", "", "list", "", "isRefresh", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: CashLogsVM.kt */
/* renamed from: com.jiayouya.travel.module.assets.vm.CashLogsVM */
public final class CashLogsVM extends BaseViewModel {
    /* renamed from: a */
    private final MutableLiveData<DataPage<LogsItem>> f11270a = new MutableLiveData<>();
    /* access modifiers changed from: private */
    /* renamed from: b */
    public String f11271b = "";

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo39189d2 = {"<anonymous>", "", "it", "Lezy/app/data/DataPage;", "Lcom/jiayouya/travel/module/assets/data/LogsItem;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: CashLogsVM.kt */
    /* renamed from: com.jiayouya.travel.module.assets.vm.CashLogsVM$a */
    static final class C2946a<T> implements Consumer<DataPage<LogsItem>> {
        /* renamed from: a */
        final /* synthetic */ CashLogsVM f11272a;
        /* renamed from: b */
        final /* synthetic */ boolean f11273b;

        C2946a(CashLogsVM cashLogsVM, boolean z) {
            this.f11272a = cashLogsVM;
            this.f11273b = z;
        }

        /* renamed from: a */
        public final void accept(DataPage<LogsItem> dataPage) {
            dataPage.setRefresh(this.f11273b);
            this.f11272a.f11271b = dataPage.getNext();
            this.f11272a.mo20377b().postValue(dataPage);
        }
    }

    /* renamed from: b */
    public final MutableLiveData<DataPage<LogsItem>> mo20377b() {
        return this.f11270a;
    }

    /* renamed from: a */
    public final void mo20376a(boolean z) {
        if (z) {
            this.f11271b = "";
        }
        ObservableEx.m12825b(C2929b.m13449a(API.f27251a).mo20304a(this.f11271b), mo19904a()).mo38904c((Consumer<? super T>) new C2946a<Object>(this, z));
    }
}
