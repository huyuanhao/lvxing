package com.jiayouya.travel.module.group.p269vm;

import androidx.lifecycle.MutableLiveData;
import com.jiayouya.travel.common.base.BaseViewModel;
import com.jiayouya.travel.common.p244b.ObservableEx;
import com.jiayouya.travel.module.group.data.InviteLogsItem;
import com.jiayouya.travel.module.group.p267a.C3042b;
import ezy.app.data.DataPage;
import ezy.app.p643a.API;
import kotlin.Metadata;
import p655io.reactivex.Observable;
import p655io.reactivex.p664d.Consumer;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo39189d2 = {"Lcom/jiayouya/travel/module/group/vm/InviteLogsVM;", "Lcom/jiayouya/travel/common/base/BaseViewModel;", "()V", "liveData", "Landroidx/lifecycle/MutableLiveData;", "Lezy/app/data/DataPage;", "Lcom/jiayouya/travel/module/group/data/InviteLogsItem;", "getLiveData", "()Landroidx/lifecycle/MutableLiveData;", "next", "", "list", "", "isRefresh", "", "type", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: InviteLogsVM.kt */
/* renamed from: com.jiayouya.travel.module.group.vm.InviteLogsVM */
public final class InviteLogsVM extends BaseViewModel {
    /* renamed from: a */
    private final MutableLiveData<DataPage<InviteLogsItem>> f11506a = new MutableLiveData<>();
    /* access modifiers changed from: private */
    /* renamed from: b */
    public String f11507b = "";

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo39189d2 = {"<anonymous>", "", "it", "Lezy/app/data/DataPage;", "Lcom/jiayouya/travel/module/group/data/InviteLogsItem;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: InviteLogsVM.kt */
    /* renamed from: com.jiayouya.travel.module.group.vm.InviteLogsVM$a */
    static final class C3067a<T> implements Consumer<DataPage<InviteLogsItem>> {
        /* renamed from: a */
        final /* synthetic */ InviteLogsVM f11508a;
        /* renamed from: b */
        final /* synthetic */ boolean f11509b;

        C3067a(InviteLogsVM inviteLogsVM, boolean z) {
            this.f11508a = inviteLogsVM;
            this.f11509b = z;
        }

        /* renamed from: a */
        public final void accept(DataPage<InviteLogsItem> dataPage) {
            this.f11508a.f11507b = dataPage.getNext();
            dataPage.setRefresh(this.f11509b);
            this.f11508a.mo21143b().postValue(dataPage);
        }
    }

    /* renamed from: b */
    public final MutableLiveData<DataPage<InviteLogsItem>> mo21143b() {
        return this.f11506a;
    }

    /* renamed from: a */
    public final void mo21142a(boolean z, int i) {
        Observable iVar;
        if (z) {
            this.f11507b = "";
        }
        if (i == 1) {
            iVar = C3042b.m13773a(API.f27251a).mo20956a(this.f11507b);
        } else if (i != 2) {
            iVar = C3042b.m13773a(API.f27251a).mo20959c(this.f11507b);
        } else {
            iVar = C3042b.m13773a(API.f27251a).mo20958b(this.f11507b);
        }
        ObservableEx.m12825b(iVar, mo19904a()).mo38904c((Consumer<? super T>) new C3067a<Object>(this, z));
    }
}
