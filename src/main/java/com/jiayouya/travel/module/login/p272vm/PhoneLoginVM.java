package com.jiayouya.travel.module.login.p272vm;

import androidx.lifecycle.MutableLiveData;
import com.jiayouya.travel.common.base.BaseViewModel;
import com.jiayouya.travel.common.p244b.ObservableEx;
import com.jiayouya.travel.module.common.p257a.C2959f;
import ezy.app.data.Token;
import ezy.app.p643a.API;
import ezy.app.p643a.Session;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;
import okhttp3.C8364ac;
import p655io.reactivex.p664d.Consumer;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007¨\u0006\u0011"}, mo39189d2 = {"Lcom/jiayouya/travel/module/login/vm/PhoneLoginVM;", "Lcom/jiayouya/travel/common/base/BaseViewModel;", "()V", "loginData", "Landroidx/lifecycle/MutableLiveData;", "Lezy/app/data/Token;", "getLoginData", "()Landroidx/lifecycle/MutableLiveData;", "smsData", "", "getSmsData", "phoneLogin", "", "phone", "", "code", "sms", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: PhoneLoginVM.kt */
/* renamed from: com.jiayouya.travel.module.login.vm.PhoneLoginVM */
public final class PhoneLoginVM extends BaseViewModel {
    /* renamed from: a */
    private final MutableLiveData<Object> f11534a = new MutableLiveData<>();
    /* renamed from: b */
    private final MutableLiveData<Token> f11535b = new MutableLiveData<>();

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lezy/app/data/Token;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: PhoneLoginVM.kt */
    /* renamed from: com.jiayouya.travel.module.login.vm.PhoneLoginVM$a */
    static final class C3092a<T> implements Consumer<Token> {
        /* renamed from: a */
        final /* synthetic */ PhoneLoginVM f11536a;

        C3092a(PhoneLoginVM phoneLoginVM) {
            this.f11536a = phoneLoginVM;
        }

        /* renamed from: a */
        public final void accept(Token token) {
            this.f11536a.mo21174c().postValue(token);
            Session bVar = Session.f27256a;
            C8271i.m35382a((Object) token, "it");
            bVar.mo38537b(token);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lokhttp3/ResponseBody;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: PhoneLoginVM.kt */
    /* renamed from: com.jiayouya.travel.module.login.vm.PhoneLoginVM$b */
    static final class C3093b<T> implements Consumer<C8364ac> {
        /* renamed from: a */
        final /* synthetic */ PhoneLoginVM f11537a;

        C3093b(PhoneLoginVM phoneLoginVM) {
            this.f11537a = phoneLoginVM;
        }

        /* renamed from: a */
        public final void accept(C8364ac acVar) {
            this.f11537a.mo21173b().postValue(acVar);
        }
    }

    /* renamed from: b */
    public final MutableLiveData<Object> mo21173b() {
        return this.f11534a;
    }

    /* renamed from: c */
    public final MutableLiveData<Token> mo21174c() {
        return this.f11535b;
    }

    /* renamed from: a */
    public final void mo21171a(String str) {
        C8271i.m35386b(str, "phone");
        ObservableEx.m12824a(C2959f.m13538a(API.f27251a).mo20413c(str), mo19904a()).mo38904c((Consumer<? super T>) new C3093b<Object>(this));
    }

    /* renamed from: a */
    public final void mo21172a(String str, String str2) {
        C8271i.m35386b(str, "phone");
        C8271i.m35386b(str2, "code");
        ObservableEx.m12824a(C2959f.m13538a(API.f27251a).mo20412b(str, str2), mo19904a()).mo38904c((Consumer<? super T>) new C3092a<Object>(this));
    }
}
