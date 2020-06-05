package com.jiayouya.travel.module.login.p270ui.p271a;

import android.content.Context;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p244b.GloblaEx;
import com.jiayouya.travel.common.p245c.PreferenceRes;
import com.jiayouya.travel.common.p246d.H5Util;
import com.jiayouya.travel.databinding.DialogProtocolBinding;
import com.jiayouya.travel.module.common.data.LaunchConfig;
import com.jiayouya.travel.module.common.p258b.LauncherConfigEvent;
import ezy.app.p645rx.C8019a;
import ezy.app.p645rx.RxBus;
import ezy.p653ui.widget.dialog.CustomDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8246a;
import kotlin.jvm.p679a.C8247b;
import kotlin.text.C8313m;
import p655io.reactivex.Observable;
import p655io.reactivex.p664d.Consumer;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\r\u001a\u00020\u0006H\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\b\u0010\u0010\u001a\u00020\u0006H\u0002R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo39189d2 = {"Lcom/jiayouya/travel/module/login/ui/dialog/ProtocolDialog;", "Lezy/ui/widget/dialog/CustomDialog;", "context", "Landroid/content/Context;", "action", "Lkotlin/Function0;", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function0;)V", "getAction", "()Lkotlin/jvm/functions/Function0;", "binding", "Lcom/jiayouya/travel/databinding/DialogProtocolBinding;", "kotlin.jvm.PlatformType", "setContent", "setupClick", "setupObserve", "setupView", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.module.login.ui.a.a */
public final class ProtocolDilaog extends CustomDialog {
    /* renamed from: a */
    private final DialogProtocolBinding f11529a = ((DialogProtocolBinding) DataBindingUtil.inflate(getLayoutInflater(), R.layout.dialog_protocol, null, false));
    /* renamed from: b */
    private final C8246a<Unit> f11530b;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: ProtocolDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.login.ui.a.a$a */
    static final class C3088a extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ ProtocolDilaog this$0;

        C3088a(ProtocolDilaog aVar) {
            this.this$0 = aVar;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            this.this$0.mo21165a().invoke();
            this.this$0.dismiss();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: ProtocolDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.login.ui.a.a$b */
    static final class C3089b extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ ProtocolDilaog this$0;

        C3089b(ProtocolDilaog aVar) {
            this.this$0 = aVar;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            PreferenceRes.f9605b.mo19926c(true);
            this.this$0.dismiss();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/common/event/LauncherConfigEvent;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: ProtocolDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.login.ui.a.a$c */
    static final class C3090c<T> implements Consumer<LauncherConfigEvent> {
        /* renamed from: a */
        final /* synthetic */ ProtocolDilaog f11531a;

        C3090c(ProtocolDilaog aVar) {
            this.f11531a = aVar;
        }

        /* renamed from: a */
        public final void accept(LauncherConfigEvent bVar) {
            this.f11531a.m13860d();
        }
    }

    public ProtocolDilaog(Context context, C8246a<Unit> aVar) {
        C8271i.m35386b(context, "context");
        C8271i.m35386b(aVar, "action");
        super(context);
        this.f11530b = aVar;
        DialogProtocolBinding dialogProtocolBinding = this.f11529a;
        C8271i.m35382a((Object) dialogProtocolBinding, "binding");
        setView(dialogProtocolBinding.getRoot());
        m13861e();
        m13859c();
        m13858b();
    }

    /* renamed from: a */
    public final C8246a<Unit> mo21165a() {
        return this.f11530b;
    }

    /* renamed from: b */
    private final void m13858b() {
        Observable a = RxBus.f27263a.mo38571a(LauncherConfigEvent.class);
        DialogProtocolBinding dialogProtocolBinding = this.f11529a;
        C8271i.m35382a((Object) dialogProtocolBinding, "binding");
        View root = dialogProtocolBinding.getRoot();
        C8271i.m35382a((Object) root, "binding.root");
        C8019a.m34776a(a, root).mo37374a(new C3090c(this));
    }

    /* renamed from: c */
    private final void m13859c() {
        setDimAmount(0.7f);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        DialogProtocolBinding dialogProtocolBinding = this.f11529a;
        C8271i.m35382a((Object) dialogProtocolBinding, "binding");
        View root = dialogProtocolBinding.getRoot();
        C8271i.m35382a((Object) root, "binding.root");
        root.getLayoutParams().width = dp2px(280.0f);
        m13860d();
    }

    /* access modifiers changed from: private|final */
    /* renamed from: d */
    public final void m13860d() {
        LaunchConfig b = PreferenceRes.f9605b.mo19924b();
        String str = "http://private";
        String a = C8313m.m35461a(C8313m.m35461a(GloblaEx.m12819b((int) R.string.protocol), "http://protocol", b.getProtocolUrl(), false, 4, (Object) null), str, b.getPrivacyUrl(), false, 4, (Object) null);
        TextView textView = this.f11529a.f10564c;
        String str2 = "binding.tvContent";
        C8271i.m35382a((Object) textView, str2);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        TextView textView2 = this.f11529a.f10564c;
        C8271i.m35382a((Object) textView2, str2);
        Spanned fromHtml = Html.fromHtml(a);
        C8271i.m35382a((Object) fromHtml, "Html.fromHtml(s)");
        textView2.setText(H5Util.m12958a(fromHtml));
    }

    /* renamed from: e */
    private final void m13861e() {
        TextView textView = this.f11529a.f10562a;
        C8271i.m35382a((Object) textView, "binding.btnCancel");
        ezy.p642a.View.m34750a(textView, 0, new C3088a(this), 1, null);
        TextView textView2 = this.f11529a.f10563b;
        C8271i.m35382a((Object) textView2, "binding.btnConfirm");
        ezy.p642a.View.m34750a(textView2, 0, new C3089b(this), 1, null);
    }
}
