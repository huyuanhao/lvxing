package com.jiayouya.travel.common.p246d;

import com.alipay.sdk.app.AuthTask;
import com.elvishew.xlog.XLog;
import com.jiayouya.travel.common.base.BaseActivity;
import com.jiayouya.travel.module.common.data.AliAuthResult;
import com.jiayouya.travel.module.common.data.AliAuthRsp;
import com.jiayouya.travel.module.common.data.AliUserRsp;
import com.jiayouya.travel.module.common.data.User;
import com.jiayouya.travel.module.common.p257a.AliService;
import com.jiayouya.travel.module.common.p257a.C2958d;
import com.jiayouya.travel.module.common.p260vm.ResidentMemoryModel;
import com.tencent.android.tpush.common.Constants;
import ezy.app.p643a.API;
import ezy.app.p645rx.C8019a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.p679a.C8246a;
import p655io.reactivex.Observable;
import p655io.reactivex.ObservableSource;
import p655io.reactivex.p664d.Consumer;
import p655io.reactivex.p664d.Function;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a<\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005H\u0002\u001a<\u0010\u0007\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005H\u0002\u001a<\u0010\b\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005H\u0007¨\u0006\t"}, mo39189d2 = {"bindAli", "", "activity", "Lcom/jiayouya/travel/common/base/BaseActivity;", "onSucceed", "Lkotlin/Function0;", "onFailed", "editAli", "startBindAli", "app_grRelease"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.common.d.b */
public final class AliBindUtil {

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "Lcom/jiayouya/travel/module/common/data/AliAuthResult;", "it", "Lcom/jiayouya/travel/module/common/data/AliAuthRsp;", "apply"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: AliBindUtil.kt */
    /* renamed from: com.jiayouya.travel.common.d.b$a */
    static final class C2884a<T, R> implements Function<T, R> {
        /* renamed from: a */
        final /* synthetic */ BaseActivity f9619a;

        C2884a(BaseActivity baseActivity) {
            this.f9619a = baseActivity;
        }

        /* renamed from: a */
        public final AliAuthResult apply(AliAuthRsp aliAuthRsp) {
            C8271i.m35386b(aliAuthRsp, "it");
            return new AliAuthResult(new AuthTask(this.f9619a).authV2(aliAuthRsp.getAuthInfo(), true), true);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, mo39189d2 = {"<anonymous>", "Lio/reactivex/Observable;", "Lcom/jiayouya/travel/module/common/data/AliUserRsp;", "kotlin.jvm.PlatformType", "it", "Lcom/jiayouya/travel/module/common/data/AliAuthResult;", "apply"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: AliBindUtil.kt */
    /* renamed from: com.jiayouya.travel.common.d.b$b */
    static final class C2885b<T, R> implements Function<T, ObservableSource<? extends R>> {
        /* renamed from: a */
        public static final C2885b f9620a = new C2885b();

        C2885b() {
        }

        /* renamed from: a */
        public final Observable<AliUserRsp> apply(AliAuthResult aliAuthResult) {
            C8271i.m35386b(aliAuthResult, "it");
            if (!C8271i.m35384a((Object) aliAuthResult.getResultCode(), (Object) "200") || !C8271i.m35384a((Object) aliAuthResult.getResultStatus(), (Object) "9000")) {
                return Observable.m34997a(new Throwable("授权失败"));
            }
            AliService a = C2958d.m13532a(API.f27251a);
            String authCode = aliAuthResult.getAuthCode();
            C8271i.m35382a((Object) authCode, "it.authCode");
            return a.mo20406a(authCode).mo38884a((Consumer<? super Throwable>) C28861.f9621a);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: AliBindUtil.kt */
    /* renamed from: com.jiayouya.travel.common.d.b$c */
    static final class C2887c<T> implements Consumer<Throwable> {
        /* renamed from: a */
        final /* synthetic */ BaseActivity f9622a;
        /* renamed from: b */
        final /* synthetic */ C8246a f9623b;

        C2887c(BaseActivity baseActivity, C8246a aVar) {
            this.f9622a = baseActivity;
            this.f9623b = aVar;
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            this.f9622a.runOnUiThread(new Runnable(this) {
                /* renamed from: a */
                final /* synthetic */ C2887c f9624a;

                {
                    this.f9624a = r1;
                }

                public final void run() {
                    C8246a aVar = this.f9624a.f9623b;
                    if (aVar != null) {
                        Unit jVar = (Unit) aVar.invoke();
                    }
                    XLog.m12691a("支付宝绑定失败");
                }
            });
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/common/data/AliUserRsp;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: AliBindUtil.kt */
    /* renamed from: com.jiayouya.travel.common.d.b$d */
    static final class C2889d<T> implements Consumer<AliUserRsp> {
        /* renamed from: a */
        final /* synthetic */ C8246a f9625a;

        C2889d(C8246a aVar) {
            this.f9625a = aVar;
        }

        /* renamed from: a */
        public final void accept(AliUserRsp aliUserRsp) {
            XLog.m12691a("支付宝绑定成功");
            C8246a aVar = this.f9625a;
            if (aVar != null) {
                Unit jVar = (Unit) aVar.invoke();
            }
            ResidentMemoryModel.m13597a(ResidentMemoryModel.f11323a, null, null, null, 7, null);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "Lcom/jiayouya/travel/module/common/data/AliAuthResult;", "it", "Lcom/jiayouya/travel/module/common/data/AliAuthRsp;", "apply"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: AliBindUtil.kt */
    /* renamed from: com.jiayouya.travel.common.d.b$e */
    static final class C2890e<T, R> implements Function<T, R> {
        /* renamed from: a */
        final /* synthetic */ BaseActivity f9626a;

        C2890e(BaseActivity baseActivity) {
            this.f9626a = baseActivity;
        }

        /* renamed from: a */
        public final AliAuthResult apply(AliAuthRsp aliAuthRsp) {
            C8271i.m35386b(aliAuthRsp, "it");
            AliAuthResult aliAuthResult = new AliAuthResult(new AuthTask(this.f9626a).authV2(aliAuthRsp.getAuthInfo(), true), true);
            aliAuthResult.setCredential(aliAuthRsp.getAuthInfo());
            return aliAuthResult;
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "Lio/reactivex/Observable;", "Lcom/jiayouya/travel/module/common/data/AliUserRsp;", "it", "Lcom/jiayouya/travel/module/common/data/AliAuthResult;", "apply"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: AliBindUtil.kt */
    /* renamed from: com.jiayouya.travel.common.d.b$f */
    static final class C2891f<T, R> implements Function<T, ObservableSource<? extends R>> {
        /* renamed from: a */
        public static final C2891f f9627a = new C2891f();

        C2891f() {
        }

        /* renamed from: a */
        public final Observable<AliUserRsp> apply(AliAuthResult aliAuthResult) {
            C8271i.m35386b(aliAuthResult, "it");
            if (!C8271i.m35384a((Object) aliAuthResult.getResultCode(), (Object) "200") || !C8271i.m35384a((Object) aliAuthResult.getResultStatus(), (Object) "9000")) {
                Observable<AliUserRsp> a = Observable.m34997a(new Throwable("授权失败"));
                C8271i.m35382a((Object) a, "Observable.error(Throwable(\"授权失败\"))");
                return a;
            }
            AliService a2 = C2958d.m13532a(API.f27251a);
            String authCode = aliAuthResult.getAuthCode();
            C8271i.m35382a((Object) authCode, "it.authCode");
            String credential = aliAuthResult.getCredential();
            C8271i.m35382a((Object) credential, "it.credential");
            return a2.mo20407a(authCode, credential);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: AliBindUtil.kt */
    /* renamed from: com.jiayouya.travel.common.d.b$g */
    static final class C2892g<T> implements Consumer<Throwable> {
        /* renamed from: a */
        final /* synthetic */ BaseActivity f9628a;
        /* renamed from: b */
        final /* synthetic */ C8246a f9629b;

        C2892g(BaseActivity baseActivity, C8246a aVar) {
            this.f9628a = baseActivity;
            this.f9629b = aVar;
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            this.f9628a.runOnUiThread(new Runnable(this) {
                /* renamed from: a */
                final /* synthetic */ C2892g f9630a;

                {
                    this.f9630a = r1;
                }

                public final void run() {
                    XLog.m12691a("支付宝改绑失败");
                    C8246a aVar = this.f9630a.f9629b;
                    if (aVar != null) {
                        Unit jVar = (Unit) aVar.invoke();
                    }
                }
            });
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/common/data/AliUserRsp;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: AliBindUtil.kt */
    /* renamed from: com.jiayouya.travel.common.d.b$h */
    static final class C2894h<T> implements Consumer<AliUserRsp> {
        /* renamed from: a */
        final /* synthetic */ C8246a f9631a;

        C2894h(C8246a aVar) {
            this.f9631a = aVar;
        }

        /* renamed from: a */
        public final void accept(AliUserRsp aliUserRsp) {
            XLog.m12691a("支付宝改绑成功");
            ResidentMemoryModel.m13597a(ResidentMemoryModel.f11323a, null, null, null, 7, null);
            C8246a aVar = this.f9631a;
            if (aVar != null) {
                Unit jVar = (Unit) aVar.invoke();
            }
        }
    }

    /* renamed from: a */
    public static /* synthetic */ void m12939a(BaseActivity baseActivity, C8246a aVar, C8246a aVar2, int i, Object obj) {
        if ((i & 2) != 0) {
            aVar = null;
        }
        if ((i & 4) != 0) {
            aVar2 = null;
        }
        m12938a(baseActivity, aVar, aVar2);
    }

    /* renamed from: a */
    public static final void m12938a(BaseActivity<?, ?> baseActivity, C8246a<Unit> aVar, C8246a<Unit> aVar2) {
        C8271i.m35386b(baseActivity, Constants.FLAG_ACTIVITY_NAME);
        User user = (User) ResidentMemoryModel.f11323a.mo20737b().getValue();
        if (user == null) {
            return;
        }
        if (user.isBindAliPay()) {
            m12941c(baseActivity, aVar, aVar2);
        } else {
            m12940b(baseActivity, aVar, aVar2);
        }
    }

    /* renamed from: b */
    private static final void m12940b(BaseActivity<?, ?> baseActivity, C8246a<Unit> aVar, C8246a<Unit> aVar2) {
        Observable a = C2958d.m13532a(API.f27251a).mo20408b().mo38900b((Function<? super T, ? extends R>) new C2884a<Object,Object>(baseActivity)).mo38886a((Function<? super T, ? extends ObservableSource<? extends R>>) C2885b.f9620a).mo38884a((Consumer<? super Throwable>) new C2887c<Object>(baseActivity, aVar2));
        C8271i.m35382a((Object) a, "API.ali().auth().map {\n …支付宝绑定失败\")\n        }\n    }");
        C8019a.m34778a(a, baseActivity, null, 2, null).mo37374a(new C2889d(aVar));
    }

    /* renamed from: c */
    private static final void m12941c(BaseActivity<?, ?> baseActivity, C8246a<Unit> aVar, C8246a<Unit> aVar2) {
        Observable a = C2958d.m13532a(API.f27251a).mo20408b().mo38900b((Function<? super T, ? extends R>) new C2890e<Object,Object>(baseActivity)).mo38886a((Function<? super T, ? extends ObservableSource<? extends R>>) C2891f.f9627a).mo38884a((Consumer<? super Throwable>) new C2892g<Object>(baseActivity, aVar2));
        C8271i.m35382a((Object) a, "API.ali().auth().map {\n ….invoke()\n        }\n    }");
        C8019a.m34778a(a, baseActivity, null, 2, null).mo37374a(new C2894h(aVar));
    }
}
