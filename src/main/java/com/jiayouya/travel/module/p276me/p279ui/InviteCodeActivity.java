package com.jiayouya.travel.module.p276me.p279ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.base.BaseActivity;
import com.jiayouya.travel.common.p244b.ViewEx;
import com.jiayouya.travel.common.p246d.ClipboardUtil;
import com.jiayouya.travel.common.p246d.WebUtils;
import com.jiayouya.travel.databinding.ActivityInviteCodeBinding;
import com.jiayouya.travel.module.common.data.InviteDataRsp;
import com.jiayouya.travel.module.common.data.ParentRsp;
import com.jiayouya.travel.module.common.p259ui.dialog.ShareDilaog;
import com.jiayouya.travel.module.p276me.p278b.BindInviterEvent;
import com.jiayouya.travel.module.p276me.p279ui.dialog.BindInviterDilaog;
import com.jiayouya.travel.module.p276me.p279ui.dialog.MyInviterDilaog;
import com.jiayouya.travel.module.p276me.p280vm.InviteCodeVM;
import ezy.app.p645rx.C8019a;
import ezy.app.p645rx.RxBus;
import ezy.p653ui.widget.round.RoundText;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8247b;
import p655io.reactivex.p664d.Consumer;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010H\u0016J\b\u0010\u0011\u001a\u00020\bH\u0002J\b\u0010\u0012\u001a\u00020\bH\u0016J\b\u0010\u0013\u001a\u00020\bH\u0016J\u0012\u0010\u0014\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, mo39189d2 = {"Lcom/jiayouya/travel/module/me/ui/InviteCodeActivity;", "Lcom/jiayouya/travel/common/base/BaseActivity;", "Lcom/jiayouya/travel/databinding/ActivityInviteCodeBinding;", "Lcom/jiayouya/travel/module/me/vm/InviteCodeVM;", "()V", "webView", "Landroid/webkit/WebView;", "fetchData", "", "isRefresh", "", "getLayoutId", "", "isShowErrorOnReqError", "isShowLoadingOnReqStart", "providerViewModelClass", "Ljava/lang/Class;", "setRightText", "setupClick", "setupObserver", "setupView", "savedInstanceState", "Landroid/os/Bundle;", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: InviteCodeActivity.kt */
/* renamed from: com.jiayouya.travel.module.me.ui.InviteCodeActivity */
public final class InviteCodeActivity extends BaseActivity<ActivityInviteCodeBinding, InviteCodeVM> {
    /* access modifiers changed from: private */
    /* renamed from: c */
    public WebView f11589c;
    /* renamed from: d */
    private HashMap f11590d;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: InviteCodeActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.InviteCodeActivity$a */
    static final class C3133a extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ InviteCodeActivity this$0;

        C3133a(InviteCodeActivity inviteCodeActivity) {
            this.this$0 = inviteCodeActivity;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            InviteDataRsp a = InviteCodeActivity.m13984a(this.this$0).mo20087a();
            if (a != null) {
                int status = a.getStatus();
                if (status == 0) {
                    ((InviteCodeVM) this.this$0.mo19853a()).mo21460e();
                } else if (status == 1) {
                    new BindInviterDilaog(this.this$0, false, 2, null).show();
                }
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: InviteCodeActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.InviteCodeActivity$b */
    static final class C3134b extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ InviteCodeActivity this$0;

        C3134b(InviteCodeActivity inviteCodeActivity) {
            this.this$0 = inviteCodeActivity;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            InviteDataRsp a = InviteCodeActivity.m13984a(this.this$0).mo20087a();
            if (a != null) {
                ClipboardUtil.m12953a(this.this$0, a.getInviteCode(), false, null, 12, null);
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: InviteCodeActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.InviteCodeActivity$c */
    static final class C3135c extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ InviteCodeActivity this$0;

        C3135c(InviteCodeActivity inviteCodeActivity) {
            this.this$0 = inviteCodeActivity;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            new ShareDilaog(this.this$0, null, 2, null).show();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/common/data/InviteDataRsp;", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: InviteCodeActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.InviteCodeActivity$d */
    static final class C3136d<T> implements Observer<InviteDataRsp> {
        /* renamed from: a */
        final /* synthetic */ InviteCodeActivity f11591a;

        C3136d(InviteCodeActivity inviteCodeActivity) {
            this.f11591a = inviteCodeActivity;
        }

        /* renamed from: a */
        public final void onChanged(InviteDataRsp inviteDataRsp) {
            InviteCodeActivity.m13984a(this.f11591a).mo20088a(inviteDataRsp);
            this.f11591a.m13988q();
            if (this.f11591a.f11589c == null) {
                InviteCodeActivity inviteCodeActivity = this.f11591a;
                FrameLayout frameLayout = (FrameLayout) inviteCodeActivity.mo19852a(R.id.lyt_web);
                C8271i.m35382a((Object) frameLayout, "lyt_web");
                inviteCodeActivity.f11589c = WebUtils.m12977a(frameLayout, 0, null, 6, null);
            }
            WebView c = this.f11591a.f11589c;
            if (c != null) {
                c.loadUrl(inviteDataRsp.getRuleUrl());
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/common/data/ParentRsp;", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: InviteCodeActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.InviteCodeActivity$e */
    static final class C3137e<T> implements Observer<ParentRsp> {
        /* renamed from: a */
        final /* synthetic */ InviteCodeActivity f11592a;

        C3137e(InviteCodeActivity inviteCodeActivity) {
            this.f11592a = inviteCodeActivity;
        }

        /* renamed from: a */
        public final void onChanged(ParentRsp parentRsp) {
            Context context = this.f11592a;
            C8271i.m35382a((Object) parentRsp, "it");
            MyInviterDilaog fVar = new MyInviterDilaog(context, parentRsp, 0, 4, null);
            fVar.show();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/me/event/BindInviterEvent;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: InviteCodeActivity.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.InviteCodeActivity$f */
    static final class C3138f<T> implements Consumer<BindInviterEvent> {
        /* renamed from: a */
        final /* synthetic */ InviteCodeActivity f11593a;

        C3138f(InviteCodeActivity inviteCodeActivity) {
            this.f11593a = inviteCodeActivity;
        }

        /* renamed from: a */
        public final void accept(BindInviterEvent bVar) {
            InviteDataRsp a = InviteCodeActivity.m13984a(this.f11593a).mo20087a();
            if (a != null) {
                a.setStatus(0);
            }
            this.f11593a.m13988q();
            InviteCodeActivity.m13984a(this.f11593a).executePendingBindings();
        }
    }

    /* renamed from: a */
    public View mo19852a(int i) {
        if (this.f11590d == null) {
            this.f11590d = new HashMap();
        }
        View view = (View) this.f11590d.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f11590d.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* renamed from: f */
    public int mo19863f() {
        return R.layout.activity_invite_code;
    }

    /* renamed from: h */
    public boolean mo19865h() {
        return true;
    }

    /* renamed from: i */
    public boolean mo19866i() {
        return true;
    }

    /* renamed from: a */
    public static final /* synthetic */ ActivityInviteCodeBinding m13984a(InviteCodeActivity inviteCodeActivity) {
        return (ActivityInviteCodeBinding) inviteCodeActivity.mo19857b();
    }

    /* renamed from: d */
    public Class<InviteCodeVM> mo19861d() {
        return InviteCodeVM.class;
    }

    /* renamed from: a */
    public void mo19854a(Bundle bundle) {
        NestedScrollView nestedScrollView = (NestedScrollView) mo19852a(R.id.scroll_view);
        C8271i.m35382a((Object) nestedScrollView, "scroll_view");
        setupStatusView(nestedScrollView);
        BaseActivity.m12847a(this, false, 1, null);
    }

    /* renamed from: b */
    public void mo19858b(boolean z) {
        ((InviteCodeVM) mo19853a()).mo21459d();
    }

    /* renamed from: k */
    public void mo19868k() {
        TextView textView = (TextView) mo19852a(R.id.tv_title_right);
        C8271i.m35382a((Object) textView, "tv_title_right");
        ezy.p642a.View.m34750a(textView, 0, new C3133a(this), 1, null);
        RoundText roundText = (RoundText) mo19852a(R.id.btn_copy);
        C8271i.m35382a((Object) roundText, "btn_copy");
        ezy.p642a.View.m34750a(roundText, 0, new C3134b(this), 1, null);
        RoundText roundText2 = (RoundText) mo19852a(R.id.btn_invite);
        C8271i.m35382a((Object) roundText2, "btn_invite");
        ezy.p642a.View.m34750a(roundText2, 0, new C3135c(this), 1, null);
    }

    /* renamed from: g */
    public void mo19864g() {
        super.mo19864g();
        LifecycleOwner lifecycleOwner = this;
        ((InviteCodeVM) mo19853a()).mo21457b().observe(lifecycleOwner, new C3136d(this));
        ((InviteCodeVM) mo19853a()).mo21458c().observe(lifecycleOwner, new C3137e(this));
        C8019a.m34778a(RxBus.f27263a.mo38571a(BindInviterEvent.class), lifecycleOwner, null, 2, null).mo37374a(new C3138f(this));
    }

    /* access modifiers changed from: private|final */
    /* renamed from: q */
    public final void m13988q() {
        InviteDataRsp a = ((ActivityInviteCodeBinding) mo19857b()).mo20087a();
        if (a != null) {
            int status = a.getStatus();
            TextView textView = (TextView) mo19852a(R.id.tv_title_right);
            textView.setText(status == 0 ? "我的邀请者" : "填写邀请者");
            ViewEx.m12840a(textView, status == 2);
        }
    }
}
