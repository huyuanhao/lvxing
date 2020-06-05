package com.jiayouya.travel.module.p276me.p279ui.dialog;

import android.app.Dialog;
import android.view.View;
import android.widget.ImageView;
import androidx.databinding.DataBindingUtil;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p244b.GloblaEx;
import com.jiayouya.travel.databinding.DialogInviterHintBinding;
import com.jiayouya.travel.module.common.data.ParentRsp;
import com.jiayouya.travel.module.common.data.User;
import com.jiayouya.travel.module.common.p257a.C2962j;
import com.jiayouya.travel.module.p276me.p278b.BindInviterEvent;
import ezy.app.p643a.API;
import ezy.app.p645rx.C8019a;
import ezy.app.p645rx.RxBus;
import ezy.p653ui.widget.dialog.CustomDialog;
import ezy.p653ui.widget.round.RoundText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8247b;
import p655io.reactivex.Observable;
import p655io.reactivex.p664d.Consumer;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, mo39189d2 = {"Lcom/jiayouya/travel/module/me/ui/dialog/InviterHintDialog;", "Lezy/ui/widget/dialog/CustomDialog;", "dialog", "Landroid/app/Dialog;", "user", "Lcom/jiayouya/travel/module/common/data/User;", "inviterCode", "", "(Landroid/app/Dialog;Lcom/jiayouya/travel/module/common/data/User;Ljava/lang/String;)V", "binding", "Lcom/jiayouya/travel/databinding/DialogInviterHintBinding;", "kotlin.jvm.PlatformType", "getDialog", "()Landroid/app/Dialog;", "getUser", "()Lcom/jiayouya/travel/module/common/data/User;", "setupClick", "", "setupView", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.module.me.ui.dialog.e */
public final class InviterHintDilaog extends CustomDialog {
    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final DialogInviterHintBinding f11670a = ((DialogInviterHintBinding) DataBindingUtil.inflate(getLayoutInflater(), R.layout.dialog_inviter_hint, null, false));
    /* renamed from: b */
    private final Dialog f11671b;
    /* renamed from: c */
    private final User f11672c;
    /* access modifiers changed from: private|final */
    /* renamed from: d */
    public final String f11673d;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: InviterHintDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.dialog.e$a */
    static final class C3215a extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ InviterHintDilaog this$0;

        C3215a(InviterHintDilaog eVar) {
            this.this$0 = eVar;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            this.this$0.dismiss();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: InviterHintDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.dialog.e$b */
    static final class C3216b extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ InviterHintDilaog this$0;

        C3216b(InviterHintDilaog eVar) {
            this.this$0 = eVar;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            Observable d = C2962j.m13561a(API.f27251a).mo20429d(this.this$0.f11673d);
            DialogInviterHintBinding b = this.this$0.f11670a;
            C8271i.m35382a((Object) b, "binding");
            View root = b.getRoot();
            C8271i.m35382a((Object) root, "binding.root");
            C8019a.m34776a(d, root).mo37374a(new Consumer<ParentRsp>(this) {
                /* renamed from: a */
                final /* synthetic */ C3216b f11674a;

                {
                    this.f11674a = r1;
                }

                /* renamed from: a */
                public final void accept(ParentRsp parentRsp) {
                    this.f11674a.this$0.mo21421a().dismiss();
                    GloblaEx.m12816a("绑定成功", 0, 0, 6, null);
                    RxBus.f27263a.mo38572a((Object) new BindInviterEvent());
                    this.f11674a.this$0.dismiss();
                }
            });
        }
    }

    public InviterHintDilaog(Dialog dialog, User user, String str) {
        C8271i.m35386b(dialog, "dialog");
        C8271i.m35386b(user, "user");
        C8271i.m35386b(str, "inviterCode");
        super(dialog.getContext());
        this.f11671b = dialog;
        this.f11672c = user;
        this.f11673d = str;
        DialogInviterHintBinding dialogInviterHintBinding = this.f11670a;
        C8271i.m35382a((Object) dialogInviterHintBinding, "binding");
        setView(dialogInviterHintBinding.getRoot());
        m14160c();
        m14159b();
    }

    /* renamed from: a */
    public final Dialog mo21421a() {
        return this.f11671b;
    }

    /* renamed from: b */
    private final void m14159b() {
        setDimAmount(0.7f);
        DialogInviterHintBinding dialogInviterHintBinding = this.f11670a;
        String str = "binding";
        C8271i.m35382a((Object) dialogInviterHintBinding, str);
        View root = dialogInviterHintBinding.getRoot();
        C8271i.m35382a((Object) root, "binding.root");
        root.getLayoutParams().width = dp2px(260.0f);
        DialogInviterHintBinding dialogInviterHintBinding2 = this.f11670a;
        C8271i.m35382a((Object) dialogInviterHintBinding2, str);
        dialogInviterHintBinding2.mo20125a(this.f11672c);
    }

    /* renamed from: c */
    private final void m14160c() {
        ImageView imageView = this.f11670a.f10463b;
        C8271i.m35382a((Object) imageView, "binding.ivClose");
        ezy.p642a.View.m34750a(imageView, 0, new C3215a(this), 1, null);
        RoundText roundText = this.f11670a.f10462a;
        C8271i.m35382a((Object) roundText, "binding.btn");
        ezy.p642a.View.m34750a(roundText, 0, new C3216b(this), 1, null);
    }
}
