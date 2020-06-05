package com.jiayouya.travel.module.login.p270ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.elvishew.xlog.XLog;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.base.BaseActivity;
import com.jiayouya.travel.common.p244b.RoundTextEx;
import com.jiayouya.travel.common.p244b.ViewEx;
import com.jiayouya.travel.common.p245c.PreferenceRes;
import com.jiayouya.travel.common.p246d.Router;
import com.jiayouya.travel.databinding.ActivityLoginBinding;
import com.jiayouya.travel.module.common.data.User;
import com.jiayouya.travel.module.common.p260vm.ResidentMemoryModel;
import com.jiayouya.travel.module.login.p270ui.p271a.ProtocolDilaog;
import com.jiayouya.travel.module.login.p272vm.LoginVM;
import com.jiayouya.travel.module.main.p273ui.MainActivity;
import com.jiayouya.travel.module.main.p273ui.MainActivity.C3094a;
import ezy.app.p643a.Session;
import ezy.assist.p646a.PackageUtil;
import ezy.p642a.Context;
import ezy.p653ui.widget.round.RoundLayout;
import ezy.sdk3rd.social.AuthorizeSDK;
import ezy.sdk3rd.social.sdk.OnSucceed;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8246a;
import kotlin.jvm.p679a.C8247b;
import kotlin.text.C8313m;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0016J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010H\u0016J\b\u0010\u0011\u001a\u00020\rH\u0016J\b\u0010\u0012\u001a\u00020\rH\u0016J\u0012\u0010\u0013\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo39189d2 = {"Lcom/jiayouya/travel/module/login/ui/LoginActivity;", "Lcom/jiayouya/travel/common/base/BaseActivity;", "Lcom/jiayouya/travel/databinding/ActivityLoginBinding;", "Lcom/jiayouya/travel/module/login/vm/LoginVM;", "()V", "isAuth", "", "mLastClickTime", "", "getLayoutId", "", "isFastClick", "login", "", "onBackPressed", "providerViewModelClass", "Ljava/lang/Class;", "setupClick", "setupObserver", "setupView", "savedInstanceState", "Landroid/os/Bundle;", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: LoginActivity.kt */
/* renamed from: com.jiayouya.travel.module.login.ui.LoginActivity */
public final class LoginActivity extends BaseActivity<ActivityLoginBinding, LoginVM> {
    /* renamed from: c */
    public boolean f11514c;
    /* renamed from: d */
    private long f11515d;
    /* renamed from: e */
    private HashMap f11516e;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "credential", "", "kotlin.jvm.PlatformType", "onSucceed"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: LoginActivity.kt */
    /* renamed from: com.jiayouya.travel.module.login.ui.LoginActivity$a */
    static final class C3069a<T> implements OnSucceed<String> {
        /* renamed from: a */
        final /* synthetic */ LoginActivity f11517a;

        C3069a(LoginActivity loginActivity) {
            this.f11517a = loginActivity;
        }

        /* renamed from: a */
        public final void mo21148a(String str) {
            StringBuilder sb = new StringBuilder();
            sb.append("credential ==>");
            sb.append(str);
            sb.append(' ');
            XLog.m12692b(sb.toString());
            C8271i.m35382a((Object) str, "credential");
            if (C8313m.m35465a(str, "code|", false, 2, null)) {
                ((LoginVM) this.f11517a.mo19853a()).mo21169a(str);
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: LoginActivity.kt */
    /* renamed from: com.jiayouya.travel.module.login.ui.LoginActivity$b */
    static final class C3070b extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ LoginActivity this$0;

        C3070b(LoginActivity loginActivity) {
            this.this$0 = loginActivity;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            ImageView imageView = (ImageView) this.this$0.mo19852a(R.id.iv_check);
            C8271i.m35382a((Object) imageView, "iv_check");
            if (imageView.isSelected()) {
                this.this$0.m13822q();
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: LoginActivity.kt */
    /* renamed from: com.jiayouya.travel.module.login.ui.LoginActivity$c */
    static final class C3071c extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ LoginActivity this$0;

        C3071c(LoginActivity loginActivity) {
            this.this$0 = loginActivity;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            ImageView imageView = (ImageView) this.this$0.mo19852a(R.id.iv_check);
            C8271i.m35382a((Object) imageView, "iv_check");
            if (imageView.isSelected()) {
                Router.m12969a(Router.f9644a, "/login/phone", null, null, 6, null);
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: LoginActivity.kt */
    /* renamed from: com.jiayouya.travel.module.login.ui.LoginActivity$d */
    static final class C3072d extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ LoginActivity this$0;

        C3072d(LoginActivity loginActivity) {
            this.this$0 = loginActivity;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            view.setSelected(!view.isSelected());
            RoundLayout roundLayout = (RoundLayout) this.this$0.mo19852a(R.id.btn_login);
            C8271i.m35382a((Object) roundLayout, "btn_login");
            RoundTextEx.m12835a(roundLayout, view.isSelected(), (String) null, (String) null, 6, (Object) null);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: LoginActivity.kt */
    /* renamed from: com.jiayouya.travel.module.login.ui.LoginActivity$e */
    static final class C3073e extends Lambda implements C8247b<View, Unit> {
        public static final C3073e INSTANCE = new C3073e();

        C3073e() {
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            Router.m12969a(Router.f9644a, PreferenceRes.f9605b.mo19924b().getProtocolUrl(), null, null, 6, null);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: LoginActivity.kt */
    /* renamed from: com.jiayouya.travel.module.login.ui.LoginActivity$f */
    static final class C3074f extends Lambda implements C8247b<View, Unit> {
        public static final C3074f INSTANCE = new C3074f();

        C3074f() {
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            Router.m12969a(Router.f9644a, PreferenceRes.f9605b.mo19924b().getPrivacyUrl(), null, null, 6, null);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "user", "Lcom/jiayouya/travel/module/common/data/User;", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: LoginActivity.kt */
    /* renamed from: com.jiayouya.travel.module.login.ui.LoginActivity$g */
    static final class C3075g<T> implements Observer<User> {
        /* renamed from: a */
        final /* synthetic */ LoginActivity f11518a;

        C3075g(LoginActivity loginActivity) {
            this.f11518a = loginActivity;
        }

        /* renamed from: a */
        public final void onChanged(User user) {
            if (!Session.f27256a.mo38540c()) {
                if (!this.f11518a.f11514c) {
                    C3094a.m13887a(MainActivity.f11539c, this.f11518a, null, 2, null);
                }
                this.f11518a.finish();
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: LoginActivity.kt */
    /* renamed from: com.jiayouya.travel.module.login.ui.LoginActivity$h */
    static final class C3076h extends Lambda implements C8246a<Unit> {
        final /* synthetic */ LoginActivity this$0;

        C3076h(LoginActivity loginActivity) {
            this.this$0 = loginActivity;
            super(0);
        }

        public final void invoke() {
            this.this$0.finish();
            System.exit(0);
            throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
        }
    }

    /* renamed from: a */
    public View mo19852a(int i) {
        if (this.f11516e == null) {
            this.f11516e = new HashMap();
        }
        View view = (View) this.f11516e.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f11516e.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* renamed from: f */
    public int mo19863f() {
        return R.layout.activity_login;
    }

    /* renamed from: d */
    public Class<LoginVM> mo19861d() {
        return LoginVM.class;
    }

    /* renamed from: a */
    public void mo19854a(Bundle bundle) {
        TextView textView = (TextView) mo19852a(R.id.txt_other_login);
        C8271i.m35382a((Object) textView, "txt_other_login");
        View view = textView;
        boolean z = !PreferenceRes.f9605b.mo19924b().getAllowPhoneLogin() || this.f11514c;
        ViewEx.m12842b(view, z);
        ImageView imageView = (ImageView) mo19852a(R.id.iv_check);
        C8271i.m35382a((Object) imageView, "iv_check");
        imageView.setSelected(true);
        ((ActivityLoginBinding) mo19857b()).mo20089a(R.mipmap.ic_launcher);
        if (!PreferenceRes.f9605b.mo19929e()) {
            new ProtocolDilaog(this, new C3076h(this)).show();
        }
    }

    /* renamed from: k */
    public void mo19868k() {
        RoundLayout roundLayout = (RoundLayout) mo19852a(R.id.btn_login);
        C8271i.m35382a((Object) roundLayout, "btn_login");
        ezy.p642a.View.m34750a(roundLayout, 0, new C3070b(this), 1, null);
        TextView textView = (TextView) mo19852a(R.id.txt_other_login);
        C8271i.m35382a((Object) textView, "txt_other_login");
        ezy.p642a.View.m34750a(textView, 0, new C3071c(this), 1, null);
        ImageView imageView = (ImageView) mo19852a(R.id.iv_check);
        C8271i.m35382a((Object) imageView, "iv_check");
        ezy.p642a.View.m34750a(imageView, 0, new C3072d(this), 1, null);
        TextView textView2 = (TextView) mo19852a(R.id.tv_user_protocol);
        C8271i.m35382a((Object) textView2, "tv_user_protocol");
        ezy.p642a.View.m34750a(textView2, 0, C3073e.INSTANCE, 1, null);
        TextView textView3 = (TextView) mo19852a(R.id.tv_private);
        C8271i.m35382a((Object) textView3, "tv_private");
        ezy.p642a.View.m34750a(textView3, 0, C3074f.INSTANCE, 1, null);
    }

    /* renamed from: g */
    public void mo19864g() {
        super.mo19864g();
        ResidentMemoryModel.f11323a.mo20737b().observe(this, new C3075g(this));
    }

    /* access modifiers changed from: private|final */
    /* renamed from: q */
    public final void m13822q() {
        if (!PackageUtil.m34782a(this, "com.tencent.mm")) {
            Context.m34744a(this, "未安装微信客户端,请先安装微信", 0, 0, 6, null);
            return;
        }
        AuthorizeSDK.m34812a((Activity) this, "weixin", (OnSucceed<String>) new C3069a<String>(this));
    }

    public void onBackPressed() {
        if (this.f11514c) {
            setResult(0);
            finish();
        } else if (!m13823r()) {
            Context.m34744a(this, "再按一次退出程序！", 0, 0, 6, null);
        } else {
            super.onBackPressed();
            finishAffinity();
            System.exit(0);
            throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
        }
    }

    /* renamed from: r */
    private final boolean m13823r() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f11515d < ((long) 4000)) {
            return true;
        }
        this.f11515d = currentTimeMillis;
        return false;
    }
}
