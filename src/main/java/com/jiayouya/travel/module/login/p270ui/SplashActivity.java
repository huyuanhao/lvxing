package com.jiayouya.travel.module.login.p270ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import androidx.core.app.NotificationCompat;
import com.elvishew.xlog.XLog;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.base.BaseActivity;
import com.jiayouya.travel.common.p245c.PreferenceRes;
import com.jiayouya.travel.common.p246d.Router;
import com.jiayouya.travel.common.p246d.RxUtil;
import com.jiayouya.travel.databinding.ActivitySplashBinding;
import com.jiayouya.travel.module.common.data.User;
import com.jiayouya.travel.module.common.p260vm.ResidentMemoryModel;
import com.jiayouya.travel.module.login.p272vm.SplashVM;
import com.tencent.android.tpush.common.MessageKey;
import com.travel.adlibrary.AdSdk;
import ezy.app.p643a.Session;
import ezy.app.p645rx.C8019a;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8246a;
import kotlin.jvm.p679a.C8263r;
import kotlin.p674b.Thread;
import p655io.reactivex.p664d.Consumer;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\nH\u0014J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013H\u0016J\b\u0010\u0014\u001a\u00020\nH\u0002J\u0012\u0010\u0015\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\nH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo39189d2 = {"Lcom/jiayouya/travel/module/login/ui/SplashActivity;", "Lcom/jiayouya/travel/common/base/BaseActivity;", "Lcom/jiayouya/travel/databinding/ActivitySplashBinding;", "Lcom/jiayouya/travel/module/login/vm/SplashVM;", "()V", "isClickedAd", "", "getLayoutId", "", "loadSplashAd", "", "adId", "", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onResume", "providerViewModelClass", "Ljava/lang/Class;", "setCallBack", "setupView", "savedInstanceState", "Landroid/os/Bundle;", "start", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: SplashActivity.kt */
/* renamed from: com.jiayouya.travel.module.login.ui.SplashActivity */
public final class SplashActivity extends BaseActivity<ActivitySplashBinding, SplashVM> {
    /* access modifiers changed from: private */
    /* renamed from: c */
    public boolean f11525c;
    /* renamed from: d */
    private HashMap f11526d;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u000b\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\n¢\u0006\u0002\b\n"}, mo39189d2 = {"<anonymous>", "", "method", "", "Lcom/travel/adlibrary/AdSdk$AdMethod;", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "<anonymous parameter 3>", "", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: SplashActivity.kt */
    /* renamed from: com.jiayouya.travel.module.login.ui.SplashActivity$a */
    static final class C3084a extends Lambda implements C8263r<String, Integer, Integer, Object, Unit> {
        final /* synthetic */ SplashActivity this$0;

        C3084a(SplashActivity splashActivity) {
            this.this$0 = splashActivity;
            super(4);
        }

        public /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            invoke((String) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue(), obj4);
            return Unit.f27778a;
        }

        public final void invoke(String str, int i, int i2, Object obj) {
            C8271i.m35386b(str, "method");
            int hashCode = str.hashCode();
            if (hashCode != -1563948504) {
                if (hashCode != 48725286) {
                    if (hashCode == 1919870917 && str.equals("METHOD_ON_CLICKED")) {
                        this.this$0.f11525c = true;
                        return;
                    }
                    return;
                } else if (!str.equals("METHOD_ON_ERROR")) {
                    return;
                }
            } else if (!str.equals("METHOD_ON_DISMISS")) {
                return;
            }
            this.this$0.m13851r();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, mo39189d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept", "(Ljava/lang/Long;)V"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: SplashActivity.kt */
    /* renamed from: com.jiayouya.travel.module.login.ui.SplashActivity$b */
    static final class C3085b<T> implements Consumer<Long> {
        /* renamed from: a */
        final /* synthetic */ SplashActivity f11527a;

        C3085b(SplashActivity splashActivity) {
            this.f11527a = splashActivity;
        }

        /* renamed from: a */
        public final void accept(Long l) {
            if (l != null && l.longValue() == 0) {
                this.f11527a.m13851r();
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: SplashActivity.kt */
    /* renamed from: com.jiayouya.travel.module.login.ui.SplashActivity$c */
    static final class C3086c extends Lambda implements C8246a<Unit> {
        final /* synthetic */ SplashActivity this$0;

        C3086c(SplashActivity splashActivity) {
            this.this$0 = splashActivity;
            super(0);
        }

        public final void invoke() {
            User user;
            do {
                user = (User) ResidentMemoryModel.f11323a.mo20737b().getValue();
            } while (TextUtils.isEmpty(user != null ? user.getHost() : null));
            this.this$0.runOnUiThread(new Runnable(this) {
                /* renamed from: a */
                final /* synthetic */ C3086c f11528a;

                {
                    this.f11528a = r1;
                }

                public final void run() {
                    Router.m12969a(Router.f9644a, "/main/index", null, null, 6, null);
                    this.f11528a.this$0.finish();
                }
            });
        }
    }

    /* renamed from: a */
    public View mo19852a(int i) {
        if (this.f11526d == null) {
            this.f11526d = new HashMap();
        }
        View view = (View) this.f11526d.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f11526d.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* renamed from: f */
    public int mo19863f() {
        return R.layout.activity_splash;
    }

    /* renamed from: d */
    public Class<SplashVM> mo19861d() {
        return SplashVM.class;
    }

    /* renamed from: a */
    public void mo19854a(Bundle bundle) {
        String adIdOpenApp = PreferenceRes.f9605b.mo19924b().getAdIdOpenApp();
        if (TextUtils.isEmpty(adIdOpenApp)) {
            C8019a.m34778a(RxUtil.m12972a(1, null, 2, null), this, null, 2, null).mo37374a(new C3085b(this));
        } else {
            m13849a(adIdOpenApp);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0014, code lost:
            if (r1 != null) goto L_0x0019;
     */
    /* renamed from: a */
    private final void m13849a(java.lang.String r19) {
        /*
        r18 = this;
        r0 = r18
        com.jiayouya.travel.module.common.vm.ResidentMemoryModel r1 = com.jiayouya.travel.module.common.p260vm.ResidentMemoryModel.f11323a
        androidx.lifecycle.MutableLiveData r1 = r1.mo20737b()
        java.lang.Object r1 = r1.getValue()
        com.jiayouya.travel.module.common.data.User r1 = (com.jiayouya.travel.module.common.data.User) r1
        if (r1 == 0) goto L_0x0017
        java.lang.String r1 = r1.getUid()
        if (r1 == 0) goto L_0x0017
        goto L_0x0019
    L_0x0017:
        java.lang.String r1 = ""
    L_0x0019:
        r6 = r1
        r18.m13850q()
        com.travel.adlibrary.a.a r1 = new com.travel.adlibrary.a.a
        r3 = 6
        r4 = r0
        android.app.Activity r4 = (android.app.Activity) r4
        int r2 = com.jiayouya.travel.R.id.lyt_container
        android.view.View r2 = r0.mo19852a(r2)
        r7 = r2
        android.widget.FrameLayout r7 = (android.widget.FrameLayout) r7
        r8 = 0
        r9 = 0
        r10 = 0
        r11 = 0
        r12 = 0
        r13 = 0
        r14 = 0
        r15 = 0
        r16 = 8160(0x1fe0, float:1.1435E-41)
        r17 = 0
        r2 = r1
        r5 = r19
        r2.m53800init(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
        com.travel.adlibrary.AdSdk r2 = com.travel.adlibrary.AdSdk.f25896a
        r2.mo37292a(r1)
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.login.p270ui.SplashActivity.m13849a(java.lang.String):void");
    }

    /* renamed from: q */
    private final void m13850q() {
        AdSdk.f25896a.mo37293b().put("SPLASH_CALL_BACK_KEY", new C3084a(this));
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.f11525c) {
            m13851r();
        }
    }

    /* access modifiers changed from: private|final */
    /* renamed from: r */
    public final void m13851r() {
        XLog.m12692b(MessageKey.MSG_ACCEPT_TIME_START);
        this.f11525c = false;
        if (Session.f27256a.mo38540c()) {
            Router.m12969a(Router.f9644a, "/login/wx", null, null, 6, null);
            finish();
            return;
        }
        Thread.m35249a(false, false, null, null, 0, new C3086c(this), 31, null);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        C8271i.m35386b(keyEvent, NotificationCompat.CATEGORY_EVENT);
        if (i == 4 || i == 3) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
