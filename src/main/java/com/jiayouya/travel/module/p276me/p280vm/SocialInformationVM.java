package com.jiayouya.travel.module.p276me.p280vm;

import androidx.lifecycle.MutableLiveData;
import com.jiayouya.travel.common.base.BaseViewModel;
import com.jiayouya.travel.common.p244b.ObservableEx;
import com.jiayouya.travel.module.common.data.ContactRsp;
import com.jiayouya.travel.module.common.p257a.C2962j;
import ezy.app.p643a.API;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;
import okhttp3.C8364ac;
import p655io.reactivex.p664d.Consumer;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0010\u001a\u00020\fR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007¨\u0006\u0011"}, mo39189d2 = {"Lcom/jiayouya/travel/module/me/vm/SocialInformationVM;", "Lcom/jiayouya/travel/common/base/BaseViewModel;", "()V", "infoData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/jiayouya/travel/module/common/data/ContactRsp;", "getInfoData", "()Landroidx/lifecycle/MutableLiveData;", "liveData", "", "getLiveData", "edit", "", "wx", "", "qq", "info", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: SocialInformationVM.kt */
/* renamed from: com.jiayouya.travel.module.me.vm.SocialInformationVM */
public final class SocialInformationVM extends BaseViewModel {
    /* renamed from: a */
    private final MutableLiveData<Object> f11757a = new MutableLiveData<>();
    /* renamed from: b */
    private final MutableLiveData<ContactRsp> f11758b = new MutableLiveData<>();

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lokhttp3/ResponseBody;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: SocialInformationVM.kt */
    /* renamed from: com.jiayouya.travel.module.me.vm.SocialInformationVM$a */
    static final class C3262a<T> implements Consumer<C8364ac> {
        /* renamed from: a */
        final /* synthetic */ SocialInformationVM f11759a;

        C3262a(SocialInformationVM socialInformationVM) {
            this.f11759a = socialInformationVM;
        }

        /* renamed from: a */
        public final void accept(C8364ac acVar) {
            this.f11759a.mo21508b().postValue(acVar);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/common/data/ContactRsp;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: SocialInformationVM.kt */
    /* renamed from: com.jiayouya.travel.module.me.vm.SocialInformationVM$b */
    static final class C3263b<T> implements Consumer<ContactRsp> {
        /* renamed from: a */
        final /* synthetic */ SocialInformationVM f11760a;

        C3263b(SocialInformationVM socialInformationVM) {
            this.f11760a = socialInformationVM;
        }

        /* renamed from: a */
        public final void accept(ContactRsp contactRsp) {
            this.f11760a.mo21509c().postValue(contactRsp);
        }
    }

    /* renamed from: b */
    public final MutableLiveData<Object> mo21508b() {
        return this.f11757a;
    }

    /* renamed from: c */
    public final MutableLiveData<ContactRsp> mo21509c() {
        return this.f11758b;
    }

    /* renamed from: d */
    public final void mo21510d() {
        ObservableEx.m12824a(C2962j.m13561a(API.f27251a).mo20430e(), mo19904a()).mo38904c((Consumer<? super T>) new C3263b<Object>(this));
    }

    /* renamed from: a */
    public final void mo21507a(String str, String str2) {
        C8271i.m35386b(str, "wx");
        C8271i.m35386b(str2, "qq");
        ObservableEx.m12824a(C2962j.m13561a(API.f27251a).mo20425b(str, str2), mo19904a()).mo38904c((Consumer<? super T>) new C3262a<Object>(this));
    }
}
