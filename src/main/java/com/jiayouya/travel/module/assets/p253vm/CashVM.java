package com.jiayouya.travel.module.assets.p253vm;

import androidx.lifecycle.MutableLiveData;
import com.jiayouya.travel.common.base.BaseViewModel;
import com.jiayouya.travel.common.p244b.ObservableEx;
import com.jiayouya.travel.module.assets.data.CashApplyRsp;
import com.jiayouya.travel.module.assets.data.CashConfig;
import com.jiayouya.travel.module.assets.p250a.C2929b;
import com.jiayouya.travel.module.common.data.CertifiedStatusRsp;
import com.jiayouya.travel.module.common.data.PayChannelItem;
import com.jiayouya.travel.module.common.p257a.C2962j;
import com.tencent.stat.apkreader.ChannelReader;
import ezy.app.p643a.API;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;
import p655io.reactivex.p664d.Consumer;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0014\u001a\u00020\u000fR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007¨\u0006\u0015"}, mo39189d2 = {"Lcom/jiayouya/travel/module/assets/vm/CashVM;", "Lcom/jiayouya/travel/common/base/BaseViewModel;", "()V", "authStatusData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/jiayouya/travel/module/common/data/CertifiedStatusRsp;", "getAuthStatusData", "()Landroidx/lifecycle/MutableLiveData;", "cashResultData", "Lcom/jiayouya/travel/module/assets/data/CashApplyRsp;", "getCashResultData", "configData", "Lcom/jiayouya/travel/module/assets/data/CashConfig;", "getConfigData", "authStatus", "", "cashApply", "channel", "", "amount", "config", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: CashVM.kt */
/* renamed from: com.jiayouya.travel.module.assets.vm.CashVM */
public final class CashVM extends BaseViewModel {
    /* renamed from: a */
    private final MutableLiveData<CashConfig> f11275a = new MutableLiveData<>();
    /* renamed from: b */
    private final MutableLiveData<CashApplyRsp> f11276b = new MutableLiveData<>();
    /* renamed from: c */
    private final MutableLiveData<CertifiedStatusRsp> f11277c = new MutableLiveData<>();

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/common/data/CertifiedStatusRsp;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: CashVM.kt */
    /* renamed from: com.jiayouya.travel.module.assets.vm.CashVM$a */
    static final class C2947a<T> implements Consumer<CertifiedStatusRsp> {
        /* renamed from: a */
        final /* synthetic */ CashVM f11278a;

        C2947a(CashVM cashVM) {
            this.f11278a = cashVM;
        }

        /* renamed from: a */
        public final void accept(CertifiedStatusRsp certifiedStatusRsp) {
            this.f11278a.mo20382d().postValue(certifiedStatusRsp);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/assets/data/CashApplyRsp;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: CashVM.kt */
    /* renamed from: com.jiayouya.travel.module.assets.vm.CashVM$b */
    static final class C2948b<T> implements Consumer<CashApplyRsp> {
        /* renamed from: a */
        final /* synthetic */ CashVM f11279a;

        C2948b(CashVM cashVM) {
            this.f11279a = cashVM;
        }

        /* renamed from: a */
        public final void accept(CashApplyRsp cashApplyRsp) {
            this.f11279a.mo20381c().postValue(cashApplyRsp);
            this.f11279a.mo20383e();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/assets/data/CashConfig;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: CashVM.kt */
    /* renamed from: com.jiayouya.travel.module.assets.vm.CashVM$c */
    static final class C2949c<T> implements Consumer<CashConfig> {
        /* renamed from: a */
        final /* synthetic */ CashVM f11280a;

        C2949c(CashVM cashVM) {
            this.f11280a = cashVM;
        }

        /* renamed from: a */
        public final void accept(CashConfig cashConfig) {
            Iterator it = cashConfig.getChannels().iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                }
                if (((PayChannelItem) it.next()).getStatus() == 1) {
                    break;
                }
                i++;
            }
            if (i != -1) {
                ((PayChannelItem) cashConfig.getChannels().get(i)).setSelected(true);
            }
            this.f11280a.mo20380b().postValue(cashConfig);
        }
    }

    /* renamed from: b */
    public final MutableLiveData<CashConfig> mo20380b() {
        return this.f11275a;
    }

    /* renamed from: c */
    public final MutableLiveData<CashApplyRsp> mo20381c() {
        return this.f11276b;
    }

    /* renamed from: d */
    public final MutableLiveData<CertifiedStatusRsp> mo20382d() {
        return this.f11277c;
    }

    /* renamed from: e */
    public final void mo20383e() {
        ObservableEx.m12825b(C2929b.m13449a(API.f27251a).mo20303a(), mo19904a()).mo38904c((Consumer<? super T>) new C2949c<Object>(this));
    }

    /* renamed from: a */
    public final void mo20379a(String str, String str2) {
        C8271i.m35386b(str, ChannelReader.CHANNEL_KEY);
        C8271i.m35386b(str2, "amount");
        ObservableEx.m12824a(C2929b.m13449a(API.f27251a).mo20305a(str, str2), mo19904a()).mo38904c((Consumer<? super T>) new C2948b<Object>(this));
    }

    /* renamed from: f */
    public final void mo20384f() {
        ObservableEx.m12824a(C2962j.m13561a(API.f27251a).mo20433g(), mo19904a()).mo38904c((Consumer<? super T>) new C2947a<Object>(this));
    }
}
