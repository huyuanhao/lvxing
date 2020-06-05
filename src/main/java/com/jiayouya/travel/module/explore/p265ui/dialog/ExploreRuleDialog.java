package com.jiayouya.travel.module.explore.p265ui.dialog;

import android.content.Context;
import android.view.View;
import androidx.databinding.DataBindingUtil;
import com.jiayouya.travel.R;
import com.jiayouya.travel.databinding.DialogExploreRuleBinding;
import ezy.p653ui.widget.dialog.CustomDialog;
import ezy.p653ui.widget.round.RoundText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8247b;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\tH\u0002R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo39189d2 = {"Lcom/jiayouya/travel/module/explore/ui/dialog/ExploreRuleDialog;", "Lezy/ui/widget/dialog/CustomDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "binding", "Lcom/jiayouya/travel/databinding/DialogExploreRuleBinding;", "kotlin.jvm.PlatformType", "setupClick", "", "setupView", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: ExploreRuleDilaog.kt */
/* renamed from: com.jiayouya.travel.module.explore.ui.dialog.ExploreRuleDialog */
public final class ExploreRuleDialog extends CustomDialog {
    /* renamed from: a */
    private final DialogExploreRuleBinding f11429a = ((DialogExploreRuleBinding) DataBindingUtil.inflate(getLayoutInflater(), R.layout.dialog_explore_rule, null, false));

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: ExploreRuleDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.explore.ui.dialog.ExploreRuleDialog$a */
    static final class C3021a extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ ExploreRuleDialog this$0;

        C3021a(ExploreRuleDialog exploreRuleDialog) {
            this.this$0 = exploreRuleDialog;
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

    public ExploreRuleDialog(Context context) {
        C8271i.m35386b(context, "context");
        super(context);
        DialogExploreRuleBinding dialogExploreRuleBinding = this.f11429a;
        C8271i.m35382a((Object) dialogExploreRuleBinding, "binding");
        setView(dialogExploreRuleBinding.getRoot());
        m13713b();
        m13712a();
    }

    /* renamed from: a */
    private final void m13712a() {
        setDimAmount(0.7f);
        DialogExploreRuleBinding dialogExploreRuleBinding = this.f11429a;
        C8271i.m35382a((Object) dialogExploreRuleBinding, "binding");
        View root = dialogExploreRuleBinding.getRoot();
        C8271i.m35382a((Object) root, "binding.root");
        root.getLayoutParams().width = dp2px(280.0f);
    }

    /* renamed from: b */
    private final void m13713b() {
        RoundText roundText = this.f11429a.f10388a;
        C8271i.m35382a((Object) roundText, "binding.btn");
        ezy.p642a.View.m34750a(roundText, 0, new C3021a(this), 1, null);
    }
}
