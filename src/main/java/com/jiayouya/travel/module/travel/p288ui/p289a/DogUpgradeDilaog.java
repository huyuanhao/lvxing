package com.jiayouya.travel.module.travel.p288ui.p289a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.databinding.DataBindingUtil;
import com.jiayouya.travel.R;
import com.jiayouya.travel.databinding.DialogDogUpgradeBinding;
import com.jiayouya.travel.module.travel.data.Extra;
import ezy.p653ui.widget.dialog.CustomDialog;
import ezy.p653ui.widget.round.RoundText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8247b;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/ui/dialog/DogUpgradeDialog;", "Lezy/ui/widget/dialog/CustomDialog;", "context", "Landroid/content/Context;", "profit", "", "item", "Lcom/jiayouya/travel/module/travel/data/Extra;", "(Landroid/content/Context;Ljava/lang/String;Lcom/jiayouya/travel/module/travel/data/Extra;)V", "binding", "Lcom/jiayouya/travel/databinding/DialogDogUpgradeBinding;", "kotlin.jvm.PlatformType", "getItem", "()Lcom/jiayouya/travel/module/travel/data/Extra;", "setupClick", "", "setupView", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.module.travel.ui.a.e */
public final class DogUpgradeDilaog extends CustomDialog {
    /* renamed from: a */
    private final DialogDogUpgradeBinding f11965a = ((DialogDogUpgradeBinding) DataBindingUtil.inflate(getLayoutInflater(), R.layout.dialog_dog_upgrade, null, false));
    /* renamed from: b */
    private final String f11966b;
    /* renamed from: c */
    private final Extra f11967c;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: DogUpgradeDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.e$a */
    static final class C3357a extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ DogUpgradeDilaog this$0;

        C3357a(DogUpgradeDilaog eVar) {
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
    /* compiled from: DogUpgradeDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.e$b */
    static final class C3358b extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ DogUpgradeDilaog this$0;

        C3358b(DogUpgradeDilaog eVar) {
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

    public DogUpgradeDilaog(Context context, String str, Extra extra) {
        C8271i.m35386b(context, "context");
        C8271i.m35386b(str, "profit");
        C8271i.m35386b(extra, "item");
        super(context);
        this.f11966b = str;
        this.f11967c = extra;
        DialogDogUpgradeBinding dialogDogUpgradeBinding = this.f11965a;
        C8271i.m35382a((Object) dialogDogUpgradeBinding, "binding");
        setView(dialogDogUpgradeBinding.getRoot());
        m14538b();
        m14537a();
    }

    /* renamed from: a */
    private final void m14537a() {
        setDimAmount(0.7f);
        DialogDogUpgradeBinding dialogDogUpgradeBinding = this.f11965a;
        C8271i.m35382a((Object) dialogDogUpgradeBinding, "binding");
        View root = dialogDogUpgradeBinding.getRoot();
        C8271i.m35382a((Object) root, "binding.root");
        root.getLayoutParams().width = dp2px(280.0f);
        DialogDogUpgradeBinding dialogDogUpgradeBinding2 = this.f11965a;
        dialogDogUpgradeBinding2.mo20113a(this.f11967c);
        dialogDogUpgradeBinding2.mo20114a(this.f11966b);
    }

    /* renamed from: b */
    private final void m14538b() {
        RoundText roundText = this.f11965a.f10356a;
        C8271i.m35382a((Object) roundText, "binding.btn");
        ezy.p642a.View.m34750a(roundText, 0, new C3357a(this), 1, null);
        ImageView imageView = this.f11965a.f10357b;
        C8271i.m35382a((Object) imageView, "binding.ivClose");
        ezy.p642a.View.m34750a(imageView, 0, new C3358b(this), 1, null);
    }
}
