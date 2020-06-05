package com.jiayouya.travel.module.login.p270ui;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.jakewharton.rxbinding2.p241a.RxTextView;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.base.BaseActivity;
import com.jiayouya.travel.common.p244b.GloblaEx;
import com.jiayouya.travel.common.p244b.RoundTextEx;
import com.jiayouya.travel.common.p244b.TextViewEx;
import com.jiayouya.travel.common.p246d.RxUtil;
import com.jiayouya.travel.databinding.ActivityPhoneLoginBinding;
import com.jiayouya.travel.module.common.data.User;
import com.jiayouya.travel.module.common.p260vm.ResidentMemoryModel;
import com.jiayouya.travel.module.login.p272vm.PhoneLoginVM;
import com.jiayouya.travel.module.main.p273ui.MainActivity;
import com.jiayouya.travel.module.main.p273ui.MainActivity.C3094a;
import ezy.app.p643a.Session;
import ezy.app.p645rx.C8019a;
import ezy.p642a.TextView;
import ezy.p653ui.widget.round.RoundText;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8247b;
import p655io.reactivex.p664d.Consumer;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\u0012\u0010\u000e\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0017¨\u0006\u0011"}, mo39189d2 = {"Lcom/jiayouya/travel/module/login/ui/PhoneLoginActivity;", "Lcom/jiayouya/travel/common/base/BaseActivity;", "Lcom/jiayouya/travel/databinding/ActivityPhoneLoginBinding;", "Lcom/jiayouya/travel/module/login/vm/PhoneLoginVM;", "()V", "getLayoutId", "", "providerViewModelClass", "Ljava/lang/Class;", "setBtnEnable", "", "setupClick", "setupObserver", "setupStatusBar", "setupView", "savedInstanceState", "Landroid/os/Bundle;", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: PhoneLoginActivity.kt */
/* renamed from: com.jiayouya.travel.module.login.ui.PhoneLoginActivity */
public final class PhoneLoginActivity extends BaseActivity<ActivityPhoneLoginBinding, PhoneLoginVM> {
    /* renamed from: c */
    private HashMap f11519c;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: PhoneLoginActivity.kt */
    /* renamed from: com.jiayouya.travel.module.login.ui.PhoneLoginActivity$a */
    static final class C3077a extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ PhoneLoginActivity this$0;

        C3077a(PhoneLoginActivity phoneLoginActivity) {
            this.this$0 = phoneLoginActivity;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            PhoneLoginVM phoneLoginVM = (PhoneLoginVM) this.this$0.mo19853a();
            EditText editText = (EditText) this.this$0.mo19852a(R.id.edit_phone);
            C8271i.m35382a((Object) editText, "edit_phone");
            phoneLoginVM.mo21171a(TextView.m34747a(editText));
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: PhoneLoginActivity.kt */
    /* renamed from: com.jiayouya.travel.module.login.ui.PhoneLoginActivity$b */
    static final class C3078b extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ PhoneLoginActivity this$0;

        C3078b(PhoneLoginActivity phoneLoginActivity) {
            this.this$0 = phoneLoginActivity;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            String str = "edit_phone";
            if (PhoneLoginActivity.m13834b(this.this$0).mo20096a() == 0) {
                PhoneLoginActivity.m13834b(this.this$0).mo20097a(1);
                EditText editText = (EditText) this.this$0.mo19852a(R.id.edit_phone);
                C8271i.m35382a((Object) editText, str);
                editText.setEnabled(false);
                this.this$0.m13835q();
                return;
            }
            PhoneLoginVM phoneLoginVM = (PhoneLoginVM) this.this$0.mo19853a();
            EditText editText2 = (EditText) this.this$0.mo19852a(R.id.edit_phone);
            C8271i.m35382a((Object) editText2, str);
            String a = TextView.m34747a(editText2);
            EditText editText3 = (EditText) this.this$0.mo19852a(R.id.edit_code);
            C8271i.m35382a((Object) editText3, "edit_code");
            phoneLoginVM.mo21172a(a, TextView.m34747a(editText3));
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: PhoneLoginActivity.kt */
    /* renamed from: com.jiayouya.travel.module.login.ui.PhoneLoginActivity$c */
    static final class C3079c<T> implements Observer<Object> {
        /* renamed from: a */
        final /* synthetic */ PhoneLoginActivity f11520a;

        C3079c(PhoneLoginActivity phoneLoginActivity) {
            this.f11520a = phoneLoginActivity;
        }

        public final void onChanged(Object obj) {
            GloblaEx.m12816a("验证码已发送，请注意查收", 0, 0, 6, null);
            C8019a.m34778a(RxUtil.m12972a(0, null, 3, null), this.f11520a, null, 2, null).mo37374a(new Consumer<Long>(this) {
                /* renamed from: a */
                final /* synthetic */ C3079c f11521a;

                {
                    this.f11521a = r1;
                }

                /* renamed from: a */
                public final void accept(Long l) {
                    String str;
                    RoundText roundText = (RoundText) this.f11521a.f11520a.mo19852a(R.id.btn_get_code);
                    String str2 = "btn_get_code";
                    C8271i.m35382a((Object) roundText, str2);
                    RoundTextEx.m12837a(roundText, l.longValue() <= 0, (String) null, (String) null, 6, (Object) null);
                    RoundText roundText2 = (RoundText) this.f11521a.f11520a.mo19852a(R.id.btn_get_code);
                    C8271i.m35382a((Object) roundText2, str2);
                    if (l.longValue() > 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(l);
                        sb.append('s');
                        str = sb.toString();
                    } else {
                        str = "获取验证码";
                    }
                    roundText2.setText(str);
                }
            });
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/common/data/User;", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: PhoneLoginActivity.kt */
    /* renamed from: com.jiayouya.travel.module.login.ui.PhoneLoginActivity$d */
    static final class C3081d<T> implements Observer<User> {
        /* renamed from: a */
        final /* synthetic */ PhoneLoginActivity f11522a;

        C3081d(PhoneLoginActivity phoneLoginActivity) {
            this.f11522a = phoneLoginActivity;
        }

        /* renamed from: a */
        public final void onChanged(User user) {
            if (!Session.f27256a.mo38540c()) {
                C3094a.m13887a(MainActivity.f11539c, this.f11522a, null, 2, null);
                this.f11522a.finish();
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: PhoneLoginActivity.kt */
    /* renamed from: com.jiayouya.travel.module.login.ui.PhoneLoginActivity$e */
    static final class C3082e<T> implements Consumer<CharSequence> {
        /* renamed from: a */
        final /* synthetic */ PhoneLoginActivity f11523a;

        C3082e(PhoneLoginActivity phoneLoginActivity) {
            this.f11523a = phoneLoginActivity;
        }

        /* renamed from: a */
        public final void accept(CharSequence charSequence) {
            RoundText roundText = (RoundText) this.f11523a.mo19852a(R.id.btn_get_code);
            C8271i.m35382a((Object) roundText, "btn_get_code");
            boolean z = charSequence == null || charSequence.length() == 0;
            RoundTextEx.m12837a(roundText, !z, (String) null, (String) null, 6, (Object) null);
            this.f11523a.m13835q();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: PhoneLoginActivity.kt */
    /* renamed from: com.jiayouya.travel.module.login.ui.PhoneLoginActivity$f */
    static final class C3083f<T> implements Consumer<CharSequence> {
        /* renamed from: a */
        final /* synthetic */ PhoneLoginActivity f11524a;

        C3083f(PhoneLoginActivity phoneLoginActivity) {
            this.f11524a = phoneLoginActivity;
        }

        /* renamed from: a */
        public final void accept(CharSequence charSequence) {
            this.f11524a.m13835q();
        }
    }

    /* renamed from: a */
    public View mo19852a(int i) {
        if (this.f11519c == null) {
            this.f11519c = new HashMap();
        }
        View view = (View) this.f11519c.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f11519c.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* renamed from: f */
    public int mo19863f() {
        return R.layout.activity_phone_login;
    }

    /* renamed from: b */
    public static final /* synthetic */ ActivityPhoneLoginBinding m13834b(PhoneLoginActivity phoneLoginActivity) {
        return (ActivityPhoneLoginBinding) phoneLoginActivity.mo19857b();
    }

    /* renamed from: d */
    public Class<PhoneLoginVM> mo19861d() {
        return PhoneLoginVM.class;
    }

    /* renamed from: e */
    public void mo19862e() {
        mo19859c().fitsSystemWindows(true).statusBarDarkFont(true).init();
    }

    /* renamed from: a */
    public void mo19854a(Bundle bundle) {
        RxTextView.m12726a((EditText) mo19852a(R.id.edit_phone)).mo38904c((Consumer<? super T>) new C3082e<Object>(this));
        RxTextView.m12726a((EditText) mo19852a(R.id.edit_code)).mo38904c((Consumer<? super T>) new C3083f<Object>(this));
    }

    /* access modifiers changed from: private|final */
    /* renamed from: q */
    public final void m13835q() {
        boolean z;
        String str = "edit_phone";
        String str2 = "btn";
        if (((ActivityPhoneLoginBinding) mo19857b()).mo20096a() == 0) {
            RoundText roundText = (RoundText) mo19852a(R.id.btn);
            C8271i.m35382a((Object) roundText, str2);
            EditText editText = (EditText) mo19852a(R.id.edit_phone);
            C8271i.m35382a((Object) editText, str);
            RoundTextEx.m12837a(roundText, !TextViewEx.m12838a(editText), (String) null, (String) null, 6, (Object) null);
            return;
        }
        RoundText roundText2 = (RoundText) mo19852a(R.id.btn);
        C8271i.m35382a((Object) roundText2, str2);
        EditText editText2 = (EditText) mo19852a(R.id.edit_phone);
        C8271i.m35382a((Object) editText2, str);
        if (!TextViewEx.m12838a(editText2)) {
            EditText editText3 = (EditText) mo19852a(R.id.edit_code);
            C8271i.m35382a((Object) editText3, "edit_code");
            if (!TextViewEx.m12838a(editText3)) {
                z = true;
                RoundTextEx.m12837a(roundText2, z, (String) null, (String) null, 6, (Object) null);
            }
        }
        z = false;
        RoundTextEx.m12837a(roundText2, z, (String) null, (String) null, 6, (Object) null);
    }

    /* renamed from: k */
    public void mo19868k() {
        RoundText roundText = (RoundText) mo19852a(R.id.btn_get_code);
        C8271i.m35382a((Object) roundText, "btn_get_code");
        ezy.p642a.View.m34750a(roundText, 0, new C3077a(this), 1, null);
        RoundText roundText2 = (RoundText) mo19852a(R.id.btn);
        C8271i.m35382a((Object) roundText2, "btn");
        ezy.p642a.View.m34750a(roundText2, 0, new C3078b(this), 1, null);
    }

    /* renamed from: g */
    public void mo19864g() {
        super.mo19864g();
        LifecycleOwner lifecycleOwner = this;
        ((PhoneLoginVM) mo19853a()).mo21173b().observe(lifecycleOwner, new C3079c(this));
        ResidentMemoryModel.f11323a.mo20737b().observe(lifecycleOwner, new C3081d(this));
    }
}
