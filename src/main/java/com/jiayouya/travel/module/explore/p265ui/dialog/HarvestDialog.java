package com.jiayouya.travel.module.explore.p265ui.dialog;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.databinding.DataBindingUtil;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.binding.BindingType;
import com.jiayouya.travel.databinding.DialogHarvestBinding;
import com.jiayouya.travel.module.explore.data.HarvestItem;
import ezy.p653ui.widget.dialog.CustomDialog;
import ezy.p653ui.widget.recyclerview.adapter.SingleTypeAdapter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8247b;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \n*\u0004\u0018\u00010\f0\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo39189d2 = {"Lcom/jiayouya/travel/module/explore/ui/dialog/HarvestDialog;", "Lezy/ui/widget/dialog/CustomDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "adapter", "Lezy/ui/widget/recyclerview/adapter/SingleTypeAdapter;", "", "binding", "Lcom/jiayouya/travel/databinding/DialogHarvestBinding;", "kotlin.jvm.PlatformType", "type", "Lcom/jiayouya/travel/common/binding/BindingType;", "setupClick", "", "setupView", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: HarvestDilaog.kt */
/* renamed from: com.jiayouya.travel.module.explore.ui.dialog.HarvestDialog */
public final class HarvestDialog extends CustomDialog {
    /* renamed from: a */
    private final DialogHarvestBinding f11430a = ((DialogHarvestBinding) DataBindingUtil.inflate(getLayoutInflater(), R.layout.dialog_harvest, null, false));
    /* renamed from: b */
    private final BindingType f11431b = BindingType.create(HarvestItem.class, (int) R.layout.item_may_harvest);
    /* renamed from: c */
    private final SingleTypeAdapter<String> f11432c = new SingleTypeAdapter<>(this.f11431b);

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: HarvestDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.explore.ui.dialog.HarvestDialog$a */
    static final class C3022a extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ HarvestDialog this$0;

        C3022a(HarvestDialog harvestDialog) {
            this.this$0 = harvestDialog;
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

    public HarvestDialog(Context context) {
        C8271i.m35386b(context, "context");
        super(context);
        DialogHarvestBinding dialogHarvestBinding = this.f11430a;
        C8271i.m35382a((Object) dialogHarvestBinding, "binding");
        setView(dialogHarvestBinding.getRoot());
        m13715b();
        m13714a();
    }

    /* renamed from: a */
    private final void m13714a() {
        setDimAmount(0.7f);
    }

    /* renamed from: b */
    private final void m13715b() {
        ImageView imageView = this.f11430a.f10440a;
        C8271i.m35382a((Object) imageView, "binding.ivClose");
        ezy.p642a.View.m34750a(imageView, 0, new C3022a(this), 1, null);
    }
}
