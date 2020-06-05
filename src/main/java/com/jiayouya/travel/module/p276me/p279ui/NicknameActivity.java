package com.jiayouya.travel.module.p276me.p279ui;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.lifecycle.Observer;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.base.BaseActivity;
import com.jiayouya.travel.common.p244b.TextViewEx;
import com.jiayouya.travel.common.p244b.ViewEx;
import com.jiayouya.travel.databinding.ActivityNicknameBinding;
import com.jiayouya.travel.module.p276me.p280vm.NicknameVM;
import ezy.p642a.Context;
import ezy.p642a.TextView;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8247b;
import p655io.reactivex.p664d.Consumer;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\f\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0017¨\u0006\u000f"}, mo39189d2 = {"Lcom/jiayouya/travel/module/me/ui/NicknameActivity;", "Lcom/jiayouya/travel/common/base/BaseActivity;", "Lcom/jiayouya/travel/databinding/ActivityNicknameBinding;", "Lcom/jiayouya/travel/module/me/vm/NicknameVM;", "()V", "getLayoutId", "", "providerViewModelClass", "Ljava/lang/Class;", "setupClick", "", "setupObserver", "setupView", "savedInstanceState", "Landroid/os/Bundle;", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: NicknameActivity.kt */
/* renamed from: com.jiayouya.travel.module.me.ui.NicknameActivity */
public final class NicknameActivity extends BaseActivity<ActivityNicknameBinding, NicknameVM> {
    /* renamed from: c */
    private HashMap f11612c;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: NicknameActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.NicknameActivity$a */
    static final class C3156a extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ NicknameActivity this$0;

        C3156a(NicknameActivity nicknameActivity) {
            this.this$0 = nicknameActivity;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            EditText editText = (EditText) this.this$0.mo19852a(R.id.edit_nickname);
            String str = "edit_nickname";
            C8271i.m35382a((Object) editText, str);
            if (TextViewEx.m12838a(editText)) {
                Context.m34744a(this.this$0, "请输入昵称", 0, 0, 6, null);
                return;
            }
            NicknameVM nicknameVM = (NicknameVM) this.this$0.mo19853a();
            EditText editText2 = (EditText) this.this$0.mo19852a(R.id.edit_nickname);
            C8271i.m35382a((Object) editText2, str);
            nicknameVM.mo21475a(TextView.m34747a(editText2));
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: NicknameActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.NicknameActivity$b */
    static final class C3157b extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ NicknameActivity this$0;

        C3157b(NicknameActivity nicknameActivity) {
            this.this$0 = nicknameActivity;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            ((EditText) this.this$0.mo19852a(R.id.edit_nickname)).setText("");
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: NicknameActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.NicknameActivity$c */
    static final class C3158c<T> implements Observer<Object> {
        /* renamed from: a */
        final /* synthetic */ NicknameActivity f11613a;

        C3158c(NicknameActivity nicknameActivity) {
            this.f11613a = nicknameActivity;
        }

        public final void onChanged(Object obj) {
            Context.m34744a(this.f11613a, "保存成功", 0, 0, 6, null);
            this.f11613a.finish();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: NicknameActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.NicknameActivity$d */
    static final class C3159d<T> implements Consumer<CharSequence> {
        /* renamed from: a */
        final /* synthetic */ NicknameActivity f11614a;

        C3159d(NicknameActivity nicknameActivity) {
            this.f11614a = nicknameActivity;
        }

        /* renamed from: a */
        public final void accept(CharSequence charSequence) {
            ImageView imageView = (ImageView) this.f11614a.mo19852a(R.id.iv_clear);
            C8271i.m35382a((Object) imageView, "iv_clear");
            View view = imageView;
            boolean z = charSequence == null || charSequence.length() == 0;
            ViewEx.m12840a(view, z);
        }
    }

    /* renamed from: a */
    public View mo19852a(int i) {
        if (this.f11612c == null) {
            this.f11612c = new HashMap();
        }
        View view = (View) this.f11612c.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f11612c.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* renamed from: f */
    public int mo19863f() {
        return R.layout.activity_nickname;
    }

    /* renamed from: d */
    public Class<NicknameVM> mo19861d() {
        return NicknameVM.class;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0012, code lost:
            if (r3 != null) goto L_0x0017;
     */
    /* renamed from: a */
    public void mo19854a(android.os.Bundle r3) {
        /*
        r2 = this;
        com.jiayouya.travel.module.common.vm.ResidentMemoryModel r3 = com.jiayouya.travel.module.common.p260vm.ResidentMemoryModel.f11323a
        androidx.lifecycle.MutableLiveData r3 = r3.mo20737b()
        java.lang.Object r3 = r3.getValue()
        com.jiayouya.travel.module.common.data.User r3 = (com.jiayouya.travel.module.common.data.User) r3
        if (r3 == 0) goto L_0x0015
        java.lang.String r3 = r3.getNickname()
        if (r3 == 0) goto L_0x0015
        goto L_0x0017
    L_0x0015:
        java.lang.String r3 = ""
    L_0x0017:
        int r0 = com.jiayouya.travel.R.id.edit_nickname
        android.view.View r0 = r2.mo19852a(r0)
        android.widget.EditText r0 = (android.widget.EditText) r0
        r1 = r3
        java.lang.CharSequence r1 = (java.lang.CharSequence) r1
        r0.setText(r1)
        int r0 = com.jiayouya.travel.R.id.edit_nickname
        android.view.View r0 = r2.mo19852a(r0)
        android.widget.EditText r0 = (android.widget.EditText) r0
        int r3 = r3.length()
        r0.setSelection(r3)
        int r3 = com.jiayouya.travel.R.id.edit_nickname
        android.view.View r3 = r2.mo19852a(r3)
        android.widget.EditText r3 = (android.widget.EditText) r3
        com.jakewharton.rxbinding2.a r3 = com.jakewharton.rxbinding2.p241a.RxTextView.m12726a(r3)
        com.jiayouya.travel.module.me.ui.NicknameActivity$d r0 = new com.jiayouya.travel.module.me.ui.NicknameActivity$d
        r0.m46667init(r2)
        io.reactivex.d.g r0 = (p655io.reactivex.p664d.Consumer) r0
        r3.mo38904c(r0)
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.p276me.p279ui.NicknameActivity.mo19854a(android.os.Bundle):void");
    }

    /* renamed from: k */
    public void mo19868k() {
        android.widget.TextView textView = (android.widget.TextView) mo19852a(R.id.tv_title_right);
        C8271i.m35382a((Object) textView, "tv_title_right");
        ezy.p642a.View.m34750a(textView, 0, new C3156a(this), 1, null);
        ImageView imageView = (ImageView) mo19852a(R.id.iv_clear);
        C8271i.m35382a((Object) imageView, "iv_clear");
        ezy.p642a.View.m34750a(imageView, 0, new C3157b(this), 1, null);
    }

    /* renamed from: g */
    public void mo19864g() {
        super.mo19864g();
        ((NicknameVM) mo19853a()).mo21476b().observe(this, new C3158c(this));
    }
}
