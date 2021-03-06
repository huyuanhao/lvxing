package com.jiayouya.travel.module.group.p268ui.dialog;

import android.content.Context;
import android.view.View;
import androidx.databinding.DataBindingUtil;
import com.jiayouya.travel.R;
import com.jiayouya.travel.databinding.DialogTotalProfitBinding;
import ezy.p653ui.widget.dialog.CustomDialog;
import ezy.p653ui.widget.round.RoundText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8247b;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\tH\u0002R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo39189d2 = {"Lcom/jiayouya/travel/module/group/ui/dialog/TotalProfitDialog;", "Lezy/ui/widget/dialog/CustomDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "binding", "Lcom/jiayouya/travel/databinding/DialogTotalProfitBinding;", "kotlin.jvm.PlatformType", "setupClick", "", "setupView", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: TotalProfitDilaog.kt */
/* renamed from: com.jiayouya.travel.module.group.ui.dialog.TotalProfitDialog */
public final class TotalProfitDialog extends CustomDialog {
    /* renamed from: a */
    private final DialogTotalProfitBinding f11495a = ((DialogTotalProfitBinding) DataBindingUtil.inflate(getLayoutInflater(), R.layout.dialog_total_profit, null, false));

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TotalProfitDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.group.ui.dialog.TotalProfitDialog$a */
    static final class C3048a extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ TotalProfitDialog this$0;

        C3048a(TotalProfitDialog totalProfitDialog) {
            this.this$0 = totalProfitDialog;
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

    public TotalProfitDialog(Context context) {
        C8271i.m35386b(context, "context");
        super(context);
        DialogTotalProfitBinding dialogTotalProfitBinding = this.f11495a;
        C8271i.m35382a((Object) dialogTotalProfitBinding, "binding");
        setView(dialogTotalProfitBinding.getRoot());
        m13790b();
        m13789a();
    }

    /* renamed from: a */
    private final void m13789a() {
        setDimAmount(0.7f);
        DialogTotalProfitBinding dialogTotalProfitBinding = this.f11495a;
        C8271i.m35382a((Object) dialogTotalProfitBinding, "binding");
        View root = dialogTotalProfitBinding.getRoot();
        C8271i.m35382a((Object) root, "binding.root");
        root.getLayoutParams().width = dp2px(260.0f);
    }

    /* renamed from: b */
    private final void m13790b() {
        RoundText roundText = this.f11495a.f10678a;
        C8271i.m35382a((Object) roundText, "binding.btn");
        ezy.p642a.View.m34750a(roundText, 0, new C3048a(this), 1, null);
    }
}
