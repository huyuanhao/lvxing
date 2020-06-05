package com.jiayouya.travel.module.p276me.p279ui;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.jakewharton.rxbinding2.p241a.RxTextView;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.base.BaseActivity;
import com.jiayouya.travel.common.p244b.RoundTextEx;
import com.jiayouya.travel.common.p244b.TextViewEx;
import com.jiayouya.travel.common.p244b.ViewEx;
import com.jiayouya.travel.common.p246d.AliBindUtil;
import com.jiayouya.travel.common.p246d.RxUtil;
import com.jiayouya.travel.databinding.ActivityEditAliPayBinding;
import com.jiayouya.travel.module.p276me.p278b.RefreshAliBindEvent;
import com.jiayouya.travel.module.p276me.p280vm.EditAliPayVM;
import ezy.app.p645rx.C8019a;
import ezy.app.p645rx.RxBus;
import ezy.p642a.Context;
import ezy.p653ui.widget.round.RoundText;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8246a;
import kotlin.jvm.p679a.C8247b;
import p655io.reactivex.p664d.Consumer;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\u0012\u0010\u000e\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0017¨\u0006\u0011"}, mo39189d2 = {"Lcom/jiayouya/travel/module/me/ui/EditAliPayActivity;", "Lcom/jiayouya/travel/common/base/BaseActivity;", "Lcom/jiayouya/travel/databinding/ActivityEditAliPayBinding;", "Lcom/jiayouya/travel/module/me/vm/EditAliPayVM;", "()V", "getLayoutId", "", "providerViewModelClass", "Ljava/lang/Class;", "setBtnEnable", "", "setupClick", "setupObserver", "setupStatusBar", "setupView", "savedInstanceState", "Landroid/os/Bundle;", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: EditAliPayActivity.kt */
/* renamed from: com.jiayouya.travel.module.me.ui.EditAliPayActivity */
public final class EditAliPayActivity extends BaseActivity<ActivityEditAliPayBinding, EditAliPayVM> {
    /* renamed from: c */
    private HashMap f11584c;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: EditAliPayActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.EditAliPayActivity$a */
    static final class C3125a extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ EditAliPayActivity this$0;

        C3125a(EditAliPayActivity editAliPayActivity) {
            this.this$0 = editAliPayActivity;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            ((EditAliPayVM) this.this$0.mo19853a()).mo21455c();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: EditAliPayActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.EditAliPayActivity$b */
    static final class C3126b extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ EditAliPayActivity this$0;

        C3126b(EditAliPayActivity editAliPayActivity) {
            this.this$0 = editAliPayActivity;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            AliBindUtil.m12938a(this.this$0, new C8246a<Unit>(this) {
                final /* synthetic */ C3126b this$0;

                {
                    this.this$0 = r1;
                }

                public final void invoke() {
                    Context.m34744a(this.this$0.this$0, "更换成功", 0, 0, 6, null);
                    RxBus.f27263a.mo38572a((Object) new RefreshAliBindEvent());
                    this.this$0.this$0.finish();
                }
            }, C31282.INSTANCE);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: EditAliPayActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.EditAliPayActivity$c */
    static final class C3129c<T> implements Observer<Object> {
        /* renamed from: a */
        final /* synthetic */ EditAliPayActivity f11585a;

        C3129c(EditAliPayActivity editAliPayActivity) {
            this.f11585a = editAliPayActivity;
        }

        public final void onChanged(Object obj) {
            Context.m34744a(this.f11585a, "验证码已发送,请注意查收", 0, 0, 6, null);
            TextView textView = (TextView) this.f11585a.mo19852a(R.id.tv_get_code);
            C8271i.m35382a((Object) textView, "tv_get_code");
            ViewEx.m12841a(textView, false, 1, null);
            TextView textView2 = (TextView) this.f11585a.mo19852a(R.id.tv_countdown);
            C8271i.m35382a((Object) textView2, "tv_countdown");
            ViewEx.m12840a(textView2, false);
            C8019a.m34778a(RxUtil.m12972a(0, null, 3, null), this.f11585a, null, 2, null).mo37374a(new Consumer<Long>(this) {
                /* renamed from: a */
                final /* synthetic */ C3129c f11586a;

                {
                    this.f11586a = r1;
                }

                /* renamed from: a */
                public final void accept(Long l) {
                    boolean z = l.longValue() > 0;
                    TextView textView = (TextView) this.f11586a.f11585a.mo19852a(R.id.tv_countdown);
                    String str = "tv_countdown";
                    C8271i.m35382a((Object) textView, str);
                    textView.setText(String.valueOf(l));
                    TextView textView2 = (TextView) this.f11586a.f11585a.mo19852a(R.id.tv_get_code);
                    C8271i.m35382a((Object) textView2, "tv_get_code");
                    ViewEx.m12840a(textView2, z);
                    TextView textView3 = (TextView) this.f11586a.f11585a.mo19852a(R.id.tv_countdown);
                    C8271i.m35382a((Object) textView3, str);
                    ViewEx.m12840a(textView3, !z);
                }
            });
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: EditAliPayActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.EditAliPayActivity$d */
    static final class C3131d<T> implements Consumer<CharSequence> {
        /* renamed from: a */
        final /* synthetic */ EditAliPayActivity f11587a;

        C3131d(EditAliPayActivity editAliPayActivity) {
            this.f11587a = editAliPayActivity;
        }

        /* renamed from: a */
        public final void accept(CharSequence charSequence) {
            this.f11587a.m13973q();
            TextView textView = (TextView) this.f11587a.mo19852a(R.id.tv_get_code);
            C8271i.m35382a((Object) textView, "tv_get_code");
            boolean z = charSequence == null || charSequence.length() == 0;
            textView.setEnabled(!z);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: EditAliPayActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.EditAliPayActivity$e */
    static final class C3132e<T> implements Consumer<CharSequence> {
        /* renamed from: a */
        final /* synthetic */ EditAliPayActivity f11588a;

        C3132e(EditAliPayActivity editAliPayActivity) {
            this.f11588a = editAliPayActivity;
        }

        /* renamed from: a */
        public final void accept(CharSequence charSequence) {
            this.f11588a.m13973q();
        }
    }

    /* renamed from: a */
    public View mo19852a(int i) {
        if (this.f11584c == null) {
            this.f11584c = new HashMap();
        }
        View view = (View) this.f11584c.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f11584c.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* renamed from: f */
    public int mo19863f() {
        return R.layout.activity_edit_ali_pay;
    }

    /* renamed from: d */
    public Class<EditAliPayVM> mo19861d() {
        return EditAliPayVM.class;
    }

    /* renamed from: e */
    public void mo19862e() {
        mo19859c().fitsSystemWindows(true).statusBarDarkFont(true).init();
    }

    /* renamed from: a */
    public void mo19854a(Bundle bundle) {
        RxTextView.m12726a((EditText) mo19852a(R.id.edit_phone)).mo38904c((Consumer<? super T>) new C3131d<Object>(this));
        RxTextView.m12726a((EditText) mo19852a(R.id.edit_code)).mo38904c((Consumer<? super T>) new C3132e<Object>(this));
    }

    /* access modifiers changed from: private|final */
    /* renamed from: q */
    public final void m13973q() {
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
        ((EditAliPayVM) mo19853a()).mo21454b().observe(this, new C3129c(this));
    }

    /* renamed from: k */
    public void mo19868k() {
        TextView textView = (TextView) mo19852a(R.id.tv_get_code);
        C8271i.m35382a((Object) textView, "tv_get_code");
        ezy.p642a.View.m34750a(textView, 0, new C3125a(this), 1, null);
        RoundText roundText = (RoundText) mo19852a(R.id.btn);
        C8271i.m35382a((Object) roundText, "btn");
        ezy.p642a.View.m34750a(roundText, 0, new C3126b(this), 1, null);
    }
}
