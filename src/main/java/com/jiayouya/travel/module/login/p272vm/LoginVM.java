package com.jiayouya.travel.module.login.p272vm;

import androidx.lifecycle.MutableLiveData;
import com.jiayouya.travel.common.base.BaseViewModel;
import com.jiayouya.travel.common.p244b.ObservableEx;
import com.jiayouya.travel.module.common.p257a.AuthService;
import com.jiayouya.travel.module.common.p257a.C2959f;
import ezy.app.data.Token;
import ezy.app.p643a.API;
import ezy.app.p643a.Session;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;
import p655io.reactivex.p664d.Consumer;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, mo39189d2 = {"Lcom/jiayouya/travel/module/login/vm/LoginVM;", "Lcom/jiayouya/travel/common/base/BaseViewModel;", "()V", "liveData", "Landroidx/lifecycle/MutableLiveData;", "Lezy/app/data/Token;", "getLiveData", "()Landroidx/lifecycle/MutableLiveData;", "login", "", "credential", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: LoginVM.kt */
/* renamed from: com.jiayouya.travel.module.login.vm.LoginVM */
public final class LoginVM extends BaseViewModel {
    /* renamed from: a */
    private final MutableLiveData<Token> f11532a = new MutableLiveData<>();

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lezy/app/data/Token;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: LoginVM.kt */
    /* renamed from: com.jiayouya.travel.module.login.vm.LoginVM$a */
    static final class C3091a<T> implements Consumer<Token> {
        /* renamed from: a */
        public static final C3091a f11533a = new C3091a();

        C3091a() {
        }

        /* renamed from: a */
        public final void accept(Token token) {
            Session bVar = Session.f27256a;
            C8271i.m35382a((Object) token, "it");
            bVar.mo38537b(token);
        }
    }

    /* renamed from: a */
    public final void mo21169a(String str) {
        C8271i.m35386b(str, "credential");
        AuthService a = C2959f.m13538a(API.f27251a);
        String substring = str.substring(5);
        C8271i.m35382a((Object) substring, "(this as java.lang.String).substring(startIndex)");
        ObservableEx.m12824a(a.mo20409a("weixin", substring), mo19904a()).mo38904c((Consumer<? super T>) C3091a.f11533a);
    }
}
