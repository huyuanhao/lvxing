package com.jiayouya.travel.module.travel.p288ui.p289a;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p246d.Router;
import com.jiayouya.travel.databinding.DialogTempBonusDogBinding;
import com.jiayouya.travel.module.travel.data.Extra;
import ezy.p653ui.widget.dialog.CustomDialog;
import ezy.p653ui.widget.round.RoundText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8247b;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/ui/dialog/TempBonusDogDialog;", "Lezy/ui/widget/dialog/CustomDialog;", "context", "Landroid/content/Context;", "item", "Lcom/jiayouya/travel/module/travel/data/Extra;", "(Landroid/content/Context;Lcom/jiayouya/travel/module/travel/data/Extra;)V", "binding", "Lcom/jiayouya/travel/databinding/DialogTempBonusDogBinding;", "kotlin.jvm.PlatformType", "getItem", "()Lcom/jiayouya/travel/module/travel/data/Extra;", "setupClick", "", "setupView", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.module.travel.ui.a.q */
public final class TempBonusDogDilaog extends CustomDialog {
    /* renamed from: a */
    private final DialogTempBonusDogBinding f12038a = ((DialogTempBonusDogBinding) DataBindingUtil.inflate(getLayoutInflater(), R.layout.dialog_temp_bonus_dog, null, false));
    /* renamed from: b */
    private final Extra f12039b;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TempBonusDogDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.q$a */
    static final class C3413a extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ TempBonusDogDilaog this$0;

        C3413a(TempBonusDogDilaog qVar) {
            this.this$0 = qVar;
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
    /* compiled from: TempBonusDogDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.q$b */
    static final class C3414b extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ TempBonusDogDilaog this$0;

        C3414b(TempBonusDogDilaog qVar) {
            this.this$0 = qVar;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            this.this$0.dismiss();
            Router.m12969a(Router.f9644a, "/me/bonusDetail", null, null, 6, null);
        }
    }

    public TempBonusDogDilaog(Context context, Extra extra) {
        C8271i.m35386b(context, "context");
        C8271i.m35386b(extra, "item");
        super(context);
        this.f12039b = extra;
        DialogTempBonusDogBinding dialogTempBonusDogBinding = this.f12038a;
        C8271i.m35382a((Object) dialogTempBonusDogBinding, "binding");
        setView(dialogTempBonusDogBinding.getRoot());
        m14635b();
        m14634a();
    }

    /* renamed from: a */
    private final void m14634a() {
        setDimAmount(0.7f);
        DialogTempBonusDogBinding dialogTempBonusDogBinding = this.f12038a;
        String str = "binding";
        C8271i.m35382a((Object) dialogTempBonusDogBinding, str);
        View root = dialogTempBonusDogBinding.getRoot();
        C8271i.m35382a((Object) root, "binding.root");
        root.getLayoutParams().width = dp2px(280.0f);
        DialogTempBonusDogBinding dialogTempBonusDogBinding2 = this.f12038a;
        C8271i.m35382a((Object) dialogTempBonusDogBinding2, str);
        dialogTempBonusDogBinding2.mo20143a(this.f12039b);
    }

    /* renamed from: b */
    private final void m14635b() {
        RoundText roundText = this.f12038a.f10654a;
        C8271i.m35382a((Object) roundText, "binding.btn");
        ezy.p642a.View.m34750a(roundText, 0, new C3413a(this), 1, null);
        TextView textView = this.f12038a.f10655b;
        C8271i.m35382a((Object) textView, "binding.tvBonusDog");
        ezy.p642a.View.m34750a(textView, 0, new C3414b(this), 1, null);
    }
}
