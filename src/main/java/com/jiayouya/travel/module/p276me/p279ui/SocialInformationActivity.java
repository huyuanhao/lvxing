package com.jiayouya.travel.module.p276me.p279ui;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.jakewharton.rxbinding2.p241a.RxTextView;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.base.BaseActivity;
import com.jiayouya.travel.common.p244b.RoundTextEx;
import com.jiayouya.travel.common.p244b.TextViewEx;
import com.jiayouya.travel.databinding.ActivitySocialInformationBinding;
import com.jiayouya.travel.module.common.data.ContactRsp;
import com.jiayouya.travel.module.p276me.p280vm.SocialInformationVM;
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
import p655io.reactivex.p664d.Consumer;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\fH\u0016J\b\u0010\r\u001a\u00020\u0006H\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\u0012\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0017J\b\u0010\u0014\u001a\u00020\bH\u0002¨\u0006\u0015"}, mo39189d2 = {"Lcom/jiayouya/travel/module/me/ui/SocialInformationActivity;", "Lcom/jiayouya/travel/common/base/BaseActivity;", "Lcom/jiayouya/travel/databinding/ActivitySocialInformationBinding;", "Lcom/jiayouya/travel/module/me/vm/SocialInformationVM;", "()V", "fetchData", "", "isRefresh", "", "getLayoutId", "", "providerViewModelClass", "Ljava/lang/Class;", "setEnable", "setupClick", "setupObserver", "setupStatusBar", "setupView", "savedInstanceState", "Landroid/os/Bundle;", "verifyInput", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: SocialInformationActivity.kt */
/* renamed from: com.jiayouya.travel.module.me.ui.SocialInformationActivity */
public final class SocialInformationActivity extends BaseActivity<ActivitySocialInformationBinding, SocialInformationVM> {
    /* renamed from: c */
    private HashMap f11648c;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: SocialInformationActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.SocialInformationActivity$a */
    static final class C3192a extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ SocialInformationActivity this$0;

        C3192a(SocialInformationActivity socialInformationActivity) {
            this.this$0 = socialInformationActivity;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            if (this.this$0.m14118r()) {
                SocialInformationVM socialInformationVM = (SocialInformationVM) this.this$0.mo19853a();
                EditText editText = (EditText) this.this$0.mo19852a(R.id.edit_wx);
                C8271i.m35382a((Object) editText, "edit_wx");
                String a = TextView.m34747a(editText);
                EditText editText2 = (EditText) this.this$0.mo19852a(R.id.edit_qq);
                C8271i.m35382a((Object) editText2, "edit_qq");
                socialInformationVM.mo21507a(a, TextView.m34747a(editText2));
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/common/data/ContactRsp;", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: SocialInformationActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.SocialInformationActivity$b */
    static final class C3193b<T> implements Observer<ContactRsp> {
        /* renamed from: a */
        final /* synthetic */ SocialInformationActivity f11649a;

        C3193b(SocialInformationActivity socialInformationActivity) {
            this.f11649a = socialInformationActivity;
        }

        /* renamed from: a */
        public final void onChanged(ContactRsp contactRsp) {
            CharSequence qq = contactRsp.getQq();
            boolean z = false;
            boolean z2 = qq == null || qq.length() == 0;
            if (!z2) {
                ((EditText) this.f11649a.mo19852a(R.id.edit_qq)).setText(contactRsp.getQq());
                ((EditText) this.f11649a.mo19852a(R.id.edit_qq)).setSelection(contactRsp.getQq().length());
            }
            CharSequence wx = contactRsp.getWx();
            if (wx == null || wx.length() == 0) {
                z = true;
            }
            if (!z) {
                ((EditText) this.f11649a.mo19852a(R.id.edit_wx)).setText(contactRsp.getWx());
                ((EditText) this.f11649a.mo19852a(R.id.edit_wx)).setSelection(contactRsp.getWx().length());
            }
            SoftInputUtil.m34787a((View) (EditText) this.f11649a.mo19852a(R.id.edit_wx));
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: SocialInformationActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.SocialInformationActivity$c */
    static final class C3194c<T> implements Observer<Object> {
        /* renamed from: a */
        final /* synthetic */ SocialInformationActivity f11650a;

        C3194c(SocialInformationActivity socialInformationActivity) {
            this.f11650a = socialInformationActivity;
        }

        public final void onChanged(Object obj) {
            Context.m34744a(this.f11650a, "保存成功", 0, 0, 6, null);
            this.f11650a.finish();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: SocialInformationActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.SocialInformationActivity$d */
    static final class C3195d<T> implements Consumer<CharSequence> {
        /* renamed from: a */
        final /* synthetic */ SocialInformationActivity f11651a;

        C3195d(SocialInformationActivity socialInformationActivity) {
            this.f11651a = socialInformationActivity;
        }

        /* renamed from: a */
        public final void accept(CharSequence charSequence) {
            this.f11651a.m14117q();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: SocialInformationActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.SocialInformationActivity$e */
    static final class C3196e<T> implements Consumer<CharSequence> {
        /* renamed from: a */
        final /* synthetic */ SocialInformationActivity f11652a;

        C3196e(SocialInformationActivity socialInformationActivity) {
            this.f11652a = socialInformationActivity;
        }

        /* renamed from: a */
        public final void accept(CharSequence charSequence) {
            this.f11652a.m14117q();
        }
    }

    /* renamed from: a */
    public View mo19852a(int i) {
        if (this.f11648c == null) {
            this.f11648c = new HashMap();
        }
        View view = (View) this.f11648c.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f11648c.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* renamed from: f */
    public int mo19863f() {
        return R.layout.activity_social_information;
    }

    /* renamed from: d */
    public Class<SocialInformationVM> mo19861d() {
        return SocialInformationVM.class;
    }

    /* renamed from: a */
    public void mo19854a(Bundle bundle) {
        RxTextView.m12726a((EditText) mo19852a(R.id.edit_qq)).mo38904c((Consumer<? super T>) new C3195d<Object>(this));
        RxTextView.m12726a((EditText) mo19852a(R.id.edit_wx)).mo38904c((Consumer<? super T>) new C3196e<Object>(this));
        BaseActivity.m12847a(this, false, 1, null);
    }

    /* renamed from: b */
    public void mo19858b(boolean z) {
        ((SocialInformationVM) mo19853a()).mo21510d();
    }

    /* renamed from: e */
    public void mo19862e() {
        mo19859c().fitsSystemWindows(true).statusBarDarkFont(true).init();
    }

    /* access modifiers changed from: private|final */
    /* renamed from: q */
    public final void m14117q() {
        boolean z;
        RoundText roundText = (RoundText) mo19852a(R.id.btn_save);
        C8271i.m35382a((Object) roundText, "btn_save");
        EditText editText = (EditText) mo19852a(R.id.edit_wx);
        C8271i.m35382a((Object) editText, "edit_wx");
        if (!TextViewEx.m12838a(editText)) {
            EditText editText2 = (EditText) mo19852a(R.id.edit_qq);
            C8271i.m35382a((Object) editText2, "edit_qq");
            if (!TextViewEx.m12838a(editText2)) {
                z = true;
                RoundTextEx.m12837a(roundText, z, (String) null, (String) null, 6, (Object) null);
            }
        }
        z = false;
        RoundTextEx.m12837a(roundText, z, (String) null, (String) null, 6, (Object) null);
    }

    /* renamed from: k */
    public void mo19868k() {
        RoundText roundText = (RoundText) mo19852a(R.id.btn_save);
        C8271i.m35382a((Object) roundText, "btn_save");
        ezy.p642a.View.m34750a(roundText, 0, new C3192a(this), 1, null);
    }

    /* renamed from: g */
    public void mo19864g() {
        super.mo19864g();
        LifecycleOwner lifecycleOwner = this;
        ((SocialInformationVM) mo19853a()).mo21509c().observe(lifecycleOwner, new C3193b(this));
        ((SocialInformationVM) mo19853a()).mo21508b().observe(lifecycleOwner, new C3194c(this));
    }

    /* access modifiers changed from: private|final */
    /* renamed from: r */
    public final boolean m14118r() {
        EditText editText = (EditText) mo19852a(R.id.edit_wx);
        C8271i.m35382a((Object) editText, "edit_wx");
        if (TextViewEx.m12838a(editText)) {
            Context.m34744a(this, "请输入您的微信号", 0, 0, 6, null);
            return false;
        }
        EditText editText2 = (EditText) mo19852a(R.id.edit_qq);
        C8271i.m35382a((Object) editText2, "edit_qq");
        if (!TextViewEx.m12838a(editText2)) {
            return true;
        }
        Context.m34744a(this, "请输入您的QQ号", 0, 0, 6, null);
        return false;
    }
}
