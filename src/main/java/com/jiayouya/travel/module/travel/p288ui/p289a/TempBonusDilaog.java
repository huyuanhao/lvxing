package com.jiayouya.travel.module.travel.p288ui.p289a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p246d.Router;
import com.jiayouya.travel.databinding.DialogTempBonusBinding;
import com.jiayouya.travel.module.travel.data.TempBonusItem;
import ezy.p653ui.widget.dialog.CustomDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8247b;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/ui/dialog/TempBonusDialog;", "Lezy/ui/widget/dialog/CustomDialog;", "context", "Landroid/content/Context;", "item", "Lcom/jiayouya/travel/module/travel/data/TempBonusItem;", "(Landroid/content/Context;Lcom/jiayouya/travel/module/travel/data/TempBonusItem;)V", "binding", "Lcom/jiayouya/travel/databinding/DialogTempBonusBinding;", "kotlin.jvm.PlatformType", "getItem", "()Lcom/jiayouya/travel/module/travel/data/TempBonusItem;", "setupClick", "", "setupView", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.module.travel.ui.a.p */
public final class TempBonusDilaog extends CustomDialog {
    /* renamed from: a */
    private final DialogTempBonusBinding f12036a = ((DialogTempBonusBinding) DataBindingUtil.inflate(getLayoutInflater(), R.layout.dialog_temp_bonus, null, false));
    /* renamed from: b */
    private final TempBonusItem f12037b;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TempBonusDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.p$a */
    static final class C3411a extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ TempBonusDilaog this$0;

        C3411a(TempBonusDilaog pVar) {
            this.this$0 = pVar;
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
    /* compiled from: TempBonusDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.p$b */
    static final class C3412b extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ TempBonusDilaog this$0;

        C3412b(TempBonusDilaog pVar) {
            this.this$0 = pVar;
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

    public TempBonusDilaog(Context context, TempBonusItem tempBonusItem) {
        C8271i.m35386b(context, "context");
        C8271i.m35386b(tempBonusItem, "item");
        super(context);
        this.f12037b = tempBonusItem;
        DialogTempBonusBinding dialogTempBonusBinding = this.f12036a;
        C8271i.m35382a((Object) dialogTempBonusBinding, "binding");
        setView(dialogTempBonusBinding.getRoot());
        m14633b();
        m14632a();
    }

    /* renamed from: a */
    private final void m14632a() {
        setDimAmount(0.7f);
        DialogTempBonusBinding dialogTempBonusBinding = this.f12036a;
        C8271i.m35382a((Object) dialogTempBonusBinding, "binding");
        dialogTempBonusBinding.mo20142a(this.f12037b);
    }

    /* renamed from: b */
    private final void m14633b() {
        ImageView imageView = this.f12036a.f10643a;
        C8271i.m35382a((Object) imageView, "binding.ivClose");
        ezy.p642a.View.m34750a(imageView, 0, new C3411a(this), 1, null);
        TextView textView = this.f12036a.f10644b;
        C8271i.m35382a((Object) textView, "binding.tvBonusDog");
        ezy.p642a.View.m34750a(textView, 0, new C3412b(this), 1, null);
    }
}
