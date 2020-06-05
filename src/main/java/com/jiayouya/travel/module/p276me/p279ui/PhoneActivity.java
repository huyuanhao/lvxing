package com.jiayouya.travel.module.p276me.p279ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.ActionBar;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.jakewharton.rxbinding2.p241a.RxTextView;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.base.BaseActivity;
import com.jiayouya.travel.common.p244b.RoundTextEx;
import com.jiayouya.travel.common.p244b.TextViewEx;
import com.jiayouya.travel.common.p244b.ViewEx;
import com.jiayouya.travel.common.p246d.RxUtil;
import com.jiayouya.travel.databinding.ActivityPhoneBinding;
import com.jiayouya.travel.module.common.data.CheckPhoneRsp;
import com.jiayouya.travel.module.common.data.User;
import com.jiayouya.travel.module.common.p260vm.ResidentMemoryModel;
import com.jiayouya.travel.module.p276me.p280vm.PhoneVM;
import ezy.app.p645rx.C8019a;
import ezy.assist.p647b.SoftInputUtil;
import ezy.p642a.Context;
import ezy.p642a.TextView;
import ezy.p653ui.widget.round.RoundText;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8247b;
import p655io.reactivex.p662b.Disposable;
import p655io.reactivex.p664d.Consumer;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\bH\u0002J\b\u0010\u0013\u001a\u00020\rH\u0016J\b\u0010\u0014\u001a\u00020\rH\u0016J\b\u0010\u0015\u001a\u00020\rH\u0016J\u0012\u0010\u0016\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0017R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo39189d2 = {"Lcom/jiayouya/travel/module/me/ui/PhoneActivity;", "Lcom/jiayouya/travel/common/base/BaseActivity;", "Lcom/jiayouya/travel/databinding/ActivityPhoneBinding;", "Lcom/jiayouya/travel/module/me/vm/PhoneVM;", "()V", "dis", "Lio/reactivex/disposables/Disposable;", "isBind", "", "isMustBind", "getLayoutId", "", "onBackPressed", "", "providerViewModelClass", "Ljava/lang/Class;", "setBtnEnable", "setCountdown", "isCounting", "setupClick", "setupObserver", "setupStatusBar", "setupView", "savedInstanceState", "Landroid/os/Bundle;", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: PhoneActivity.kt */
/* renamed from: com.jiayouya.travel.module.me.ui.PhoneActivity */
public final class PhoneActivity extends BaseActivity<ActivityPhoneBinding, PhoneVM> {
    /* renamed from: c */
    public boolean f11622c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public Disposable f11623d;
    /* access modifiers changed from: private|final */
    /* renamed from: e */
    public final boolean f11624e;
    /* renamed from: f */
    private HashMap f11625f;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: PhoneActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.PhoneActivity$a */
    static final class C3164a extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ PhoneActivity this$0;

        C3164a(PhoneActivity phoneActivity) {
            this.this$0 = phoneActivity;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            int i = this.this$0.f11624e ? 1 : PhoneActivity.m14063b(this.this$0).mo20093a() == 0 ? 2 : 3;
            PhoneVM phoneVM = (PhoneVM) this.this$0.mo19853a();
            EditText editText = (EditText) this.this$0.mo19852a(R.id.edit_phone);
            C8271i.m35382a((Object) editText, "edit_phone");
            phoneVM.mo21481a(i, TextView.m34747a(editText));
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: PhoneActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.PhoneActivity$b */
    static final class C3165b extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ PhoneActivity this$0;

        C3165b(PhoneActivity phoneActivity) {
            this.this$0 = phoneActivity;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            String str = "edit_phone";
            String str2 = "edit_code";
            if (this.this$0.f11624e) {
                PhoneVM phoneVM = (PhoneVM) this.this$0.mo19853a();
                EditText editText = (EditText) this.this$0.mo19852a(R.id.edit_phone);
                C8271i.m35382a((Object) editText, str);
                String a = TextView.m34747a(editText);
                EditText editText2 = (EditText) this.this$0.mo19852a(R.id.edit_code);
                C8271i.m35382a((Object) editText2, str2);
                phoneVM.mo21483a(a, TextView.m34747a(editText2));
            } else if (PhoneActivity.m14063b(this.this$0).mo20093a() == 0) {
                PhoneVM phoneVM2 = (PhoneVM) this.this$0.mo19853a();
                EditText editText3 = (EditText) this.this$0.mo19852a(R.id.edit_code);
                C8271i.m35382a((Object) editText3, str2);
                phoneVM2.mo21482a(TextView.m34747a(editText3));
            } else {
                PhoneVM phoneVM3 = (PhoneVM) this.this$0.mo19853a();
                EditText editText4 = (EditText) this.this$0.mo19852a(R.id.edit_phone);
                C8271i.m35382a((Object) editText4, str);
                String a2 = TextView.m34747a(editText4);
                EditText editText5 = (EditText) this.this$0.mo19852a(R.id.edit_code);
                C8271i.m35382a((Object) editText5, str2);
                phoneVM3.mo21485b(a2, TextView.m34747a(editText5));
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/common/data/User;", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: PhoneActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.PhoneActivity$c */
    static final class C3166c<T> implements Observer<User> {
        /* renamed from: a */
        final /* synthetic */ PhoneActivity f11626a;

        C3166c(PhoneActivity phoneActivity) {
            this.f11626a = phoneActivity;
        }

        /* renamed from: a */
        public final void onChanged(User user) {
            PhoneActivity.m14063b(this.f11626a).mo20095a(user);
            if (!TextUtils.isEmpty(user.getMobile()) && PhoneActivity.m14063b(this.f11626a).mo20093a() == 0) {
                ((EditText) this.f11626a.mo19852a(R.id.edit_phone)).setText(user.getMobile());
                EditText editText = (EditText) this.f11626a.mo19852a(R.id.edit_phone);
                C8271i.m35382a((Object) editText, "edit_phone");
                editText.setEnabled(false);
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: PhoneActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.PhoneActivity$d */
    static final class C3167d<T> implements Observer<Object> {
        /* renamed from: a */
        final /* synthetic */ PhoneActivity f11627a;

        C3167d(PhoneActivity phoneActivity) {
            this.f11627a = phoneActivity;
        }

        public final void onChanged(Object obj) {
            Context.m34744a(this.f11627a, "验证码已发送，请注意查收", 0, 0, 6, null);
            this.f11627a.m14065d(true);
            this.f11627a.f11623d = C8019a.m34778a(RxUtil.m12972a(0, null, 3, null), this.f11627a, null, 2, null).mo37374a(new Consumer<Long>(this) {
                /* renamed from: a */
                final /* synthetic */ C3167d f11628a;

                {
                    this.f11628a = r1;
                }

                /* renamed from: a */
                public final void accept(Long l) {
                    boolean z = l.longValue() > 0;
                    android.widget.TextView textView = (android.widget.TextView) this.f11628a.f11627a.mo19852a(R.id.tv_countdown);
                    C8271i.m35382a((Object) textView, "tv_countdown");
                    textView.setText(String.valueOf(l));
                    this.f11628a.f11627a.m14065d(z);
                }
            });
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: PhoneActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.PhoneActivity$e */
    static final class C3169e<T> implements Observer<Object> {
        /* renamed from: a */
        final /* synthetic */ PhoneActivity f11629a;

        C3169e(PhoneActivity phoneActivity) {
            this.f11629a = phoneActivity;
        }

        public final void onChanged(Object obj) {
            Context.m34744a(this.f11629a, "更换成功", 0, 0, 6, null);
            this.f11629a.finish();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: PhoneActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.PhoneActivity$f */
    static final class C3170f<T> implements Observer<Object> {
        /* renamed from: a */
        final /* synthetic */ PhoneActivity f11630a;

        C3170f(PhoneActivity phoneActivity) {
            this.f11630a = phoneActivity;
        }

        public final void onChanged(Object obj) {
            Context.m34744a(this.f11630a, "绑定成功", 0, 0, 6, null);
            this.f11630a.finish();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/common/data/CheckPhoneRsp;", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: PhoneActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.PhoneActivity$g */
    static final class C3171g<T> implements Observer<CheckPhoneRsp> {
        /* renamed from: a */
        final /* synthetic */ PhoneActivity f11631a;

        C3171g(PhoneActivity phoneActivity) {
            this.f11631a = phoneActivity;
        }

        /* renamed from: a */
        public final void onChanged(CheckPhoneRsp checkPhoneRsp) {
            String str = "";
            ((EditText) this.f11631a.mo19852a(R.id.edit_code)).setText(str);
            EditText editText = (EditText) this.f11631a.mo19852a(R.id.edit_phone);
            Disposable c = this.f11631a.f11623d;
            if (c != null) {
                c.dispose();
            }
            this.f11631a.m14065d(false);
            editText.setText(str);
            editText.setEnabled(true);
            editText.setHint("请输入新手机号");
            SoftInputUtil.m34787a((View) editText);
            PhoneActivity.m14063b(this.f11631a).mo20094a(1);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: PhoneActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.PhoneActivity$h */
    static final class C3172h<T> implements Consumer<CharSequence> {
        /* renamed from: a */
        final /* synthetic */ PhoneActivity f11632a;

        C3172h(PhoneActivity phoneActivity) {
            this.f11632a = phoneActivity;
        }

        /* renamed from: a */
        public final void accept(CharSequence charSequence) {
            this.f11632a.m14067q();
            android.widget.TextView textView = (android.widget.TextView) this.f11632a.mo19852a(R.id.tv_get_code);
            C8271i.m35382a((Object) textView, "tv_get_code");
            boolean z = charSequence == null || charSequence.length() == 0;
            textView.setEnabled(!z);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: PhoneActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.PhoneActivity$i */
    static final class C3173i<T> implements Consumer<CharSequence> {
        /* renamed from: a */
        final /* synthetic */ PhoneActivity f11633a;

        C3173i(PhoneActivity phoneActivity) {
            this.f11633a = phoneActivity;
        }

        /* renamed from: a */
        public final void accept(CharSequence charSequence) {
            this.f11633a.m14067q();
        }
    }

    /* renamed from: a */
    public View mo19852a(int i) {
        if (this.f11625f == null) {
            this.f11625f = new HashMap();
        }
        View view = (View) this.f11625f.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f11625f.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* renamed from: f */
    public int mo19863f() {
        return R.layout.activity_phone;
    }

    /* renamed from: b */
    public static final /* synthetic */ ActivityPhoneBinding m14063b(PhoneActivity phoneActivity) {
        return (ActivityPhoneBinding) phoneActivity.mo19857b();
    }

    public PhoneActivity() {
        User user = (User) ResidentMemoryModel.f11323a.mo20737b().getValue();
        this.f11624e = TextUtils.isEmpty(user != null ? user.getMobile() : null);
    }

    /* renamed from: d */
    public Class<PhoneVM> mo19861d() {
        return PhoneVM.class;
    }

    /* renamed from: e */
    public void mo19862e() {
        mo19859c().fitsSystemWindows(true).statusBarDarkFont(true).init();
    }

    /* renamed from: a */
    public void mo19854a(Bundle bundle) {
        RxTextView.m12726a((EditText) mo19852a(R.id.edit_phone)).mo38904c((Consumer<? super T>) new C3172h<Object>(this));
        RxTextView.m12726a((EditText) mo19852a(R.id.edit_code)).mo38904c((Consumer<? super T>) new C3173i<Object>(this));
        if (this.f11622c) {
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setDisplayHomeAsUpEnabled(false);
            }
        }
    }

    /* access modifiers changed from: private|final */
    /* renamed from: q */
    public final void m14067q() {
        boolean z;
        RoundText roundText = (RoundText) mo19852a(R.id.btn);
        C8271i.m35382a((Object) roundText, "btn");
        EditText editText = (EditText) mo19852a(R.id.edit_phone);
        C8271i.m35382a((Object) editText, "edit_phone");
        if (!TextViewEx.m12838a(editText)) {
            EditText editText2 = (EditText) mo19852a(R.id.edit_code);
            C8271i.m35382a((Object) editText2, "edit_code");
            if (!TextViewEx.m12838a(editText2)) {
                z = true;
                RoundTextEx.m12837a(roundText, z, (String) null, (String) null, 6, (Object) null);
            }
        }
        z = false;
        RoundTextEx.m12837a(roundText, z, (String) null, (String) null, 6, (Object) null);
    }

    /* renamed from: g */
    public void mo19864g() {
        super.mo19864g();
        LifecycleOwner lifecycleOwner = this;
        ResidentMemoryModel.f11323a.mo20737b().observe(lifecycleOwner, new C3166c(this));
        ((PhoneVM) mo19853a()).mo21486c().observe(lifecycleOwner, new C3167d(this));
        ((PhoneVM) mo19853a()).mo21484b().observe(lifecycleOwner, new C3169e(this));
        ((PhoneVM) mo19853a()).mo21487d().observe(lifecycleOwner, new C3170f(this));
        ((PhoneVM) mo19853a()).mo21488e().observe(lifecycleOwner, new C3171g(this));
    }

    /* access modifiers changed from: private|final */
    /* renamed from: d */
    public final void m14065d(boolean z) {
        android.widget.TextView textView = (android.widget.TextView) mo19852a(R.id.tv_get_code);
        C8271i.m35382a((Object) textView, "tv_get_code");
        ViewEx.m12840a(textView, z);
        android.widget.TextView textView2 = (android.widget.TextView) mo19852a(R.id.tv_countdown);
        C8271i.m35382a((Object) textView2, "tv_countdown");
        ViewEx.m12840a(textView2, !z);
    }

    /* renamed from: k */
    public void mo19868k() {
        android.widget.TextView textView = (android.widget.TextView) mo19852a(R.id.tv_get_code);
        C8271i.m35382a((Object) textView, "tv_get_code");
        ezy.p642a.View.m34750a(textView, 0, new C3164a(this), 1, null);
        RoundText roundText = (RoundText) mo19852a(R.id.btn);
        C8271i.m35382a((Object) roundText, "btn");
        ezy.p642a.View.m34750a(roundText, 0, new C3165b(this), 1, null);
    }

    public void onBackPressed() {
        if (!this.f11622c) {
            super.onBackPressed();
        }
    }
}
