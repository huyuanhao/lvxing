package com.jiayouya.travel.module.p276me.p279ui.dialog;

import android.content.Context;
import android.view.View;
import androidx.databinding.DataBindingUtil;
import com.jiayouya.travel.R;
import com.jiayouya.travel.databinding.DialogMyBonusDogBinding;
import ezy.p653ui.widget.dialog.CustomDialog;
import ezy.p653ui.widget.round.RoundText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8247b;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\tH\u0002R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo39189d2 = {"Lcom/jiayouya/travel/module/me/ui/dialog/MyBonusDogDialog;", "Lezy/ui/widget/dialog/CustomDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "binding", "Lcom/jiayouya/travel/databinding/DialogMyBonusDogBinding;", "kotlin.jvm.PlatformType", "setupClick", "", "setupView", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: MyBonusDogDilaog.kt */
/* renamed from: com.jiayouya.travel.module.me.ui.dialog.MyBonusDogDialog */
public final class MyBonusDogDialog extends CustomDialog {
    /* renamed from: a */
    private final DialogMyBonusDogBinding f11657a = ((DialogMyBonusDogBinding) DataBindingUtil.inflate(getLayoutInflater(), R.layout.dialog_my_bonus_dog, null, false));

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: MyBonusDogDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.dialog.MyBonusDogDialog$a */
    static final class C3202a extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ MyBonusDogDialog this$0;

        C3202a(MyBonusDogDialog myBonusDogDialog) {
            this.this$0 = myBonusDogDialog;
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

    public MyBonusDogDialog(Context context) {
        C8271i.m35386b(context, "context");
        super(context);
        DialogMyBonusDogBinding dialogMyBonusDogBinding = this.f11657a;
        C8271i.m35382a((Object) dialogMyBonusDogBinding, "binding");
        setView(dialogMyBonusDogBinding.getRoot());
        m14138b();
        m14137a();
    }

    /* renamed from: a */
    private final void m14137a() {
        setDimAmount(0.7f);
        DialogMyBonusDogBinding dialogMyBonusDogBinding = this.f11657a;
        C8271i.m35382a((Object) dialogMyBonusDogBinding, "binding");
        View root = dialogMyBonusDogBinding.getRoot();
        C8271i.m35382a((Object) root, "binding.root");
        root.getLayoutParams().width = dp2px(280.0f);
    }

    /* renamed from: b */
    private final void m14138b() {
        RoundText roundText = this.f11657a.f10511a;
        C8271i.m35382a((Object) roundText, "binding.btn");
        ezy.p642a.View.m34750a(roundText, 0, new C3202a(this), 1, null);
    }
}
