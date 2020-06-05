package com.jiayouya.travel.module.p276me.p279ui.dialog;

import android.content.Context;
import android.view.View;
import androidx.databinding.DataBindingUtil;
import com.jiayouya.travel.R;
import com.jiayouya.travel.databinding.DialogBindPhoneHintBinding;
import ezy.p653ui.widget.dialog.CustomDialog;
import ezy.p653ui.widget.round.RoundText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8246a;
import kotlin.jvm.p679a.C8247b;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, mo39189d2 = {"Lcom/jiayouya/travel/module/me/ui/dialog/BindPhoneHintDialog;", "Lezy/ui/widget/dialog/CustomDialog;", "context", "Landroid/content/Context;", "action", "Lkotlin/Function0;", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function0;)V", "binding", "Lcom/jiayouya/travel/databinding/DialogBindPhoneHintBinding;", "kotlin.jvm.PlatformType", "setupClick", "setupView", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.module.me.ui.dialog.b */
public final class BindPhoneHintDilaog extends CustomDialog {
    /* renamed from: a */
    private final DialogBindPhoneHintBinding f11663a = ((DialogBindPhoneHintBinding) DataBindingUtil.inflate(getLayoutInflater(), R.layout.dialog_bind_phone_hint, null, false));
    /* access modifiers changed from: private|final */
    /* renamed from: b */
    public final C8246a<Unit> f11664b;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: BindPhoneHintDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.dialog.b$a */
    static final class C3209a extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ BindPhoneHintDilaog this$0;

        C3209a(BindPhoneHintDilaog bVar) {
            this.this$0 = bVar;
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
    /* compiled from: BindPhoneHintDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.dialog.b$b */
    static final class C3210b extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ BindPhoneHintDilaog this$0;

        C3210b(BindPhoneHintDilaog bVar) {
            this.this$0 = bVar;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            this.this$0.dismiss();
            this.this$0.f11664b.invoke();
        }
    }

    public BindPhoneHintDilaog(Context context, C8246a<Unit> aVar) {
        C8271i.m35386b(context, "context");
        C8271i.m35386b(aVar, "action");
        super(context);
        this.f11664b = aVar;
        DialogBindPhoneHintBinding dialogBindPhoneHintBinding = this.f11663a;
        C8271i.m35382a((Object) dialogBindPhoneHintBinding, "binding");
        setView(dialogBindPhoneHintBinding.getRoot());
        m14148b();
        m14147a();
    }

    /* renamed from: a */
    private final void m14147a() {
        setDimAmount(0.7f);
        DialogBindPhoneHintBinding dialogBindPhoneHintBinding = this.f11663a;
        C8271i.m35382a((Object) dialogBindPhoneHintBinding, "binding");
        View root = dialogBindPhoneHintBinding.getRoot();
        C8271i.m35382a((Object) root, "binding.root");
        root.getLayoutParams().width = dp2px(260.0f);
    }

    /* renamed from: b */
    private final void m14148b() {
        RoundText roundText = this.f11663a.f10276a;
        C8271i.m35382a((Object) roundText, "binding.btnCancel");
        ezy.p642a.View.m34750a(roundText, 0, new C3209a(this), 1, null);
        RoundText roundText2 = this.f11663a.f10277b;
        C8271i.m35382a((Object) roundText2, "binding.btnConfirm");
        ezy.p642a.View.m34750a(roundText2, 0, new C3210b(this), 1, null);
    }
}
