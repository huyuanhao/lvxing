package com.jiayouya.travel.module.travel.p288ui.p289a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.databinding.DataBindingUtil;
import com.jiayouya.travel.R;
import com.jiayouya.travel.databinding.DialogWarehouseHintBinding;
import com.jiayouya.travel.module.travel.data.PositionItem;
import ezy.p653ui.widget.dialog.CustomDialog;
import ezy.p653ui.widget.round.RoundText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8247b;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B8\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\u0002\u0010\rJ\b\u0010\u0015\u001a\u00020\fH\u0002J\b\u0010\u0016\u001a\u00020\fH\u0002R,\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\n \u0012*\u0004\u0018\u00010\u00110\u0011X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/ui/dialog/WarehouseHintDialog;", "Lezy/ui/widget/dialog/CustomDialog;", "context", "Landroid/content/Context;", "item", "Lcom/jiayouya/travel/module/travel/data/PositionItem;", "action", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isPutIn", "", "(Landroid/content/Context;Lcom/jiayouya/travel/module/travel/data/PositionItem;Lkotlin/jvm/functions/Function1;)V", "getAction", "()Lkotlin/jvm/functions/Function1;", "binding", "Lcom/jiayouya/travel/databinding/DialogWarehouseHintBinding;", "kotlin.jvm.PlatformType", "getItem", "()Lcom/jiayouya/travel/module/travel/data/PositionItem;", "setupClick", "setupView", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.module.travel.ui.a.u */
public final class WarehouseHintDialog extends CustomDialog {
    /* renamed from: a */
    private final DialogWarehouseHintBinding f12057a = ((DialogWarehouseHintBinding) DataBindingUtil.inflate(getLayoutInflater(), R.layout.dialog_warehouse_hint, null, false));
    /* renamed from: b */
    private final PositionItem f12058b;
    /* renamed from: c */
    private final C8247b<Boolean, Unit> f12059c;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: WarehouseHintDialog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.u$a */
    static final class C3427a extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ WarehouseHintDialog this$0;

        C3427a(WarehouseHintDialog uVar) {
            this.this$0 = uVar;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            this.this$0.mo22339a().invoke(Boolean.valueOf(true));
            this.this$0.dismiss();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: WarehouseHintDialog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.u$b */
    static final class C3428b extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ WarehouseHintDialog this$0;

        C3428b(WarehouseHintDialog uVar) {
            this.this$0 = uVar;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            this.this$0.mo22339a().invoke(Boolean.valueOf(false));
            this.this$0.dismiss();
        }
    }

    /* renamed from: a */
    public final C8247b<Boolean, Unit> mo22339a() {
        return this.f12059c;
    }

    public WarehouseHintDialog(Context context, PositionItem positionItem, C8247b<? super Boolean, Unit> bVar) {
        C8271i.m35386b(context, "context");
        C8271i.m35386b(positionItem, "item");
        C8271i.m35386b(bVar, "action");
        super(context);
        this.f12058b = positionItem;
        this.f12059c = bVar;
        DialogWarehouseHintBinding dialogWarehouseHintBinding = this.f12057a;
        C8271i.m35382a((Object) dialogWarehouseHintBinding, "binding");
        setView(dialogWarehouseHintBinding.getRoot());
        setDimAmount(0.8f);
        m14664c();
        m14663b();
    }

    /* renamed from: b */
    private final void m14663b() {
        setDimAmount(0.7f);
        DialogWarehouseHintBinding dialogWarehouseHintBinding = this.f12057a;
        String str = "binding";
        C8271i.m35382a((Object) dialogWarehouseHintBinding, str);
        View root = dialogWarehouseHintBinding.getRoot();
        C8271i.m35382a((Object) root, "binding.root");
        root.getLayoutParams().width = dp2px(260.0f);
        DialogWarehouseHintBinding dialogWarehouseHintBinding2 = this.f12057a;
        C8271i.m35382a((Object) dialogWarehouseHintBinding2, str);
        dialogWarehouseHintBinding2.mo20149a(this.f12058b);
    }

    /* renamed from: c */
    private final void m14664c() {
        RoundText roundText = this.f12057a.f10724a;
        C8271i.m35382a((Object) roundText, "binding.btn");
        ezy.p642a.View.m34750a(roundText, 0, new C3427a(this), 1, null);
        ImageView imageView = this.f12057a.f10725b;
        C8271i.m35382a((Object) imageView, "binding.ivClose");
        ezy.p642a.View.m34750a(imageView, 0, new C3428b(this), 1, null);
    }
}
