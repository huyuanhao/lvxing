package com.jiayouya.travel.module.auth.p255ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.base.BaseActivity;
import com.jiayouya.travel.common.p244b.ActivityEx;
import com.jiayouya.travel.databinding.ActivityAuthBinding;
import com.jiayouya.travel.module.auth.data.AuthCode;
import com.jiayouya.travel.module.auth.p256vm.AuthVM;
import com.jiayouya.travel.module.common.data.User;
import com.jiayouya.travel.module.common.p260vm.ResidentMemoryModel;
import com.jiayouya.travel.module.login.p270ui.LoginActivity;
import com.tencent.p605ep.commonbase.software.AppEntity;
import ezy.app.p643a.Session;
import ezy.p653ui.widget.round.RoundText;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.C8272k;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.p679a.C8247b;
import kotlin.reflect.C8280j;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0002J\u001c\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\u0012\u001a\u00020\u0010H\u0016J\"\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u0016\u001a\u00020\fH\u0014J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018H\u0016J\b\u0010\u0019\u001a\u00020\fH\u0016J\b\u0010\u001a\u001a\u00020\fH\u0016J\u0012\u0010\u001b\u001a\u00020\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u001e"}, mo39189d2 = {"Lcom/jiayouya/travel/module/auth/ui/AuthActivity;", "Lcom/jiayouya/travel/common/base/BaseActivity;", "Lcom/jiayouya/travel/databinding/ActivityAuthBinding;", "Lcom/jiayouya/travel/module/auth/vm/AuthVM;", "()V", "appName", "", "getAppName", "()Ljava/lang/String;", "appName$delegate", "Lkotlin/Lazy;", "authFail", "", "createIntent", "Landroid/content/Intent;", "code", "", "data", "getLayoutId", "onActivityResult", "requestCode", "resultCode", "onResume", "providerViewModelClass", "Ljava/lang/Class;", "setupClick", "setupObserver", "setupView", "savedInstanceState", "Landroid/os/Bundle;", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: AuthActivity.kt */
/* renamed from: com.jiayouya.travel.module.auth.ui.AuthActivity */
public final class AuthActivity extends BaseActivity<ActivityAuthBinding, AuthVM> {
    /* renamed from: c */
    static final /* synthetic */ C8280j[] f11281c = {C8272k.m35400a((PropertyReference1) new PropertyReference1Impl(C8272k.m35394a(AuthActivity.class), AppEntity.KEY_APP_NAME_STR, "getAppName()Ljava/lang/String;"))};
    /* renamed from: d */
    private final Lazy f11282d = ActivityEx.m12803a(this, AppEntity.KEY_APP_NAME_STR, "");
    /* renamed from: e */
    private HashMap f11283e;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: AuthActivity.kt */
    /* renamed from: com.jiayouya.travel.module.auth.ui.AuthActivity$a */
    static final class C2951a extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ AuthActivity this$0;

        C2951a(AuthActivity authActivity) {
            this.this$0 = authActivity;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            this.this$0.m13513r();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: AuthActivity.kt */
    /* renamed from: com.jiayouya.travel.module.auth.ui.AuthActivity$b */
    static final class C2952b extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ AuthActivity this$0;

        C2952b(AuthActivity authActivity) {
            this.this$0 = authActivity;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            ((AuthVM) this.this$0.mo19853a()).mo20401c();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: AuthActivity.kt */
    /* renamed from: com.jiayouya.travel.module.auth.ui.AuthActivity$c */
    static final class C2953c extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ AuthActivity this$0;

        C2953c(AuthActivity authActivity) {
            this.this$0 = authActivity;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            this.this$0.m13513r();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/common/data/User;", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: AuthActivity.kt */
    /* renamed from: com.jiayouya.travel.module.auth.ui.AuthActivity$d */
    static final class C2954d<T> implements Observer<User> {
        /* renamed from: a */
        final /* synthetic */ AuthActivity f11284a;

        C2954d(AuthActivity authActivity) {
            this.f11284a = authActivity;
        }

        /* renamed from: a */
        public final void onChanged(User user) {
            AuthActivity.m13510a(this.f11284a).mo20076a(user);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/auth/data/AuthCode;", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: AuthActivity.kt */
    /* renamed from: com.jiayouya.travel.module.auth.ui.AuthActivity$e */
    static final class C2955e<T> implements Observer<AuthCode> {
        /* renamed from: a */
        final /* synthetic */ AuthActivity f11285a;

        C2955e(AuthActivity authActivity) {
            this.f11285a = authActivity;
        }

        /* renamed from: a */
        public final void onChanged(AuthCode authCode) {
            AuthActivity authActivity = this.f11285a;
            authActivity.setResult(-1, authActivity.m13507a(1, authCode.getAuthCode()));
            this.f11285a.finish();
        }
    }

    /* renamed from: q */
    private final String m13512q() {
        Lazy bVar = this.f11282d;
        C8280j jVar = f11281c[0];
        return (String) bVar.getValue();
    }

    /* renamed from: a */
    public View mo19852a(int i) {
        if (this.f11283e == null) {
            this.f11283e = new HashMap();
        }
        View view = (View) this.f11283e.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f11283e.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* renamed from: f */
    public int mo19863f() {
        return R.layout.activity_auth;
    }

    /* renamed from: a */
    public static final /* synthetic */ ActivityAuthBinding m13510a(AuthActivity authActivity) {
        return (ActivityAuthBinding) authActivity.mo19857b();
    }

    /* renamed from: d */
    public Class<AuthVM> mo19861d() {
        return AuthVM.class;
    }

    /* renamed from: a */
    public void mo19854a(Bundle bundle) {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle((CharSequence) "");
        }
        ((ActivityAuthBinding) mo19857b()).mo20077a(m13512q());
        if (Session.f27256a.mo38540c()) {
            Intent intent = new Intent(this, LoginActivity.class);
            intent.putExtra("isAuth", true);
            startActivityForResult(intent, 264);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (ResidentMemoryModel.f11323a.mo20737b().getValue() == null) {
            ResidentMemoryModel.m13597a(ResidentMemoryModel.f11323a, null, null, null, 7, null);
        }
    }

    /* renamed from: g */
    public void mo19864g() {
        super.mo19864g();
        LifecycleOwner lifecycleOwner = this;
        ResidentMemoryModel.f11323a.mo20737b().observe(lifecycleOwner, new C2954d(this));
        ((AuthVM) mo19853a()).mo20400b().observe(lifecycleOwner, new C2955e(this));
    }

    /* renamed from: k */
    public void mo19868k() {
        RoundText roundText = (RoundText) mo19852a(R.id.btn_refuse);
        C8271i.m35382a((Object) roundText, "btn_refuse");
        ezy.p642a.View.m34750a(roundText, 0, new C2951a(this), 1, null);
        RoundText roundText2 = (RoundText) mo19852a(R.id.btn_agree);
        C8271i.m35382a((Object) roundText2, "btn_agree");
        ezy.p642a.View.m34750a(roundText2, 0, new C2952b(this), 1, null);
        TextView textView = (TextView) mo19852a(R.id.tv_close);
        C8271i.m35382a((Object) textView, "tv_close");
        ezy.p642a.View.m34750a(textView, 0, new C2953c(this), 1, null);
    }

    /* renamed from: a */
    static /* synthetic */ Intent m13509a(AuthActivity authActivity, int i, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        return authActivity.m13507a(i, str);
    }

    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final Intent m13507a(int i, String str) {
        Intent intent = new Intent();
        intent.putExtra("data", str);
        intent.putExtra("code", i);
        return intent;
    }

    /* access modifiers changed from: private|final */
    /* renamed from: r */
    public final void m13513r() {
        setResult(-1, m13509a(this, 2, null, 2, null));
        finish();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 264 && i2 == 0) {
            m13513r();
        }
    }
}
