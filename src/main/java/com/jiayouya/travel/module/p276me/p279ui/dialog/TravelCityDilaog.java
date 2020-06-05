package com.jiayouya.travel.module.p276me.p279ui.dialog;

import android.content.Context;
import android.view.View;
import androidx.databinding.DataBindingUtil;
import com.jiayouya.travel.R;
import com.jiayouya.travel.databinding.DialogTravelCityBinding;
import ezy.p653ui.widget.dialog.CustomDialog;
import ezy.p653ui.widget.round.RoundText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8247b;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, mo39189d2 = {"Lcom/jiayouya/travel/module/me/ui/dialog/TravelCityDialog;", "Lezy/ui/widget/dialog/CustomDialog;", "context", "Landroid/content/Context;", "process", "", "(Landroid/content/Context;Ljava/lang/String;)V", "binding", "Lcom/jiayouya/travel/databinding/DialogTravelCityBinding;", "kotlin.jvm.PlatformType", "setupClick", "", "setupView", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.module.me.ui.dialog.i */
public final class TravelCityDilaog extends CustomDialog {
    /* renamed from: a */
    private final DialogTravelCityBinding f11682a = ((DialogTravelCityBinding) DataBindingUtil.inflate(getLayoutInflater(), R.layout.dialog_travel_city, null, false));
    /* renamed from: b */
    private final String f11683b;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: TravelCityDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.dialog.i$a */
    static final class C3225a extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ TravelCityDilaog this$0;

        C3225a(TravelCityDilaog iVar) {
            this.this$0 = iVar;
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

    public TravelCityDilaog(Context context, String str) {
        C8271i.m35386b(context, "context");
        C8271i.m35386b(str, "process");
        super(context);
        this.f11683b = str;
        DialogTravelCityBinding dialogTravelCityBinding = this.f11682a;
        C8271i.m35382a((Object) dialogTravelCityBinding, "binding");
        setView(dialogTravelCityBinding.getRoot());
        m14172b();
        m14171a();
    }

    /* renamed from: a */
    private final void m14171a() {
        setDimAmount(0.7f);
        DialogTravelCityBinding dialogTravelCityBinding = this.f11682a;
        String str = "binding";
        C8271i.m35382a((Object) dialogTravelCityBinding, str);
        View root = dialogTravelCityBinding.getRoot();
        C8271i.m35382a((Object) root, "binding.root");
        root.getLayoutParams().width = dp2px(280.0f);
        DialogTravelCityBinding dialogTravelCityBinding2 = this.f11682a;
        C8271i.m35382a((Object) dialogTravelCityBinding2, str);
        dialogTravelCityBinding2.mo20145a(this.f11683b);
    }

    /* renamed from: b */
    private final void m14172b() {
        RoundText roundText = this.f11682a.f10684a;
        C8271i.m35382a((Object) roundText, "binding.btn");
        ezy.p642a.View.m34750a(roundText, 0, new C3225a(this), 1, null);
    }
}
