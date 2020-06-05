package com.jiayouya.travel.module.travel.p288ui.p289a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.databinding.DataBindingUtil;
import com.jiayouya.travel.R;
import com.jiayouya.travel.databinding.DialogDogDetailBinding;
import com.jiayouya.travel.module.travel.data.DogInfo;
import ezy.p653ui.widget.dialog.CustomDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8247b;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/ui/dialog/DogDetailDialog;", "Lezy/ui/widget/dialog/CustomDialog;", "context", "Landroid/content/Context;", "item", "Lcom/jiayouya/travel/module/travel/data/DogInfo;", "(Landroid/content/Context;Lcom/jiayouya/travel/module/travel/data/DogInfo;)V", "binding", "Lcom/jiayouya/travel/databinding/DialogDogDetailBinding;", "kotlin.jvm.PlatformType", "getItem", "()Lcom/jiayouya/travel/module/travel/data/DogInfo;", "setupClick", "", "setupView", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.module.travel.ui.a.d */
public final class DogDetailDilaog extends CustomDialog {
    /* renamed from: a */
    private final DialogDogDetailBinding f11963a = ((DialogDogDetailBinding) DataBindingUtil.inflate(getLayoutInflater(), R.layout.dialog_dog_detail, null, false));
    /* renamed from: b */
    private final DogInfo f11964b;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: DogDetailDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.d$a */
    static final class C3356a extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ DogDetailDilaog this$0;

        C3356a(DogDetailDilaog dVar) {
            this.this$0 = dVar;
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

    public DogDetailDilaog(Context context, DogInfo dogInfo) {
        C8271i.m35386b(context, "context");
        C8271i.m35386b(dogInfo, "item");
        super(context);
        this.f11964b = dogInfo;
        DialogDogDetailBinding dialogDogDetailBinding = this.f11963a;
        C8271i.m35382a((Object) dialogDogDetailBinding, "binding");
        setView(dialogDogDetailBinding.getRoot());
        m14536b();
        m14535a();
    }

    /* renamed from: a */
    private final void m14535a() {
        setDimAmount(0.7f);
        DialogDogDetailBinding dialogDogDetailBinding = this.f11963a;
        String str = "binding";
        C8271i.m35382a((Object) dialogDogDetailBinding, str);
        View root = dialogDogDetailBinding.getRoot();
        C8271i.m35382a((Object) root, "binding.root");
        root.getLayoutParams().width = dp2px(310.0f);
        DialogDogDetailBinding dialogDogDetailBinding2 = this.f11963a;
        C8271i.m35382a((Object) dialogDogDetailBinding2, str);
        dialogDogDetailBinding2.mo20112a(this.f11964b);
    }

    /* renamed from: b */
    private final void m14536b() {
        ImageView imageView = this.f11963a.f10337a;
        C8271i.m35382a((Object) imageView, "binding.ivClose");
        ezy.p642a.View.m34750a(imageView, 0, new C3356a(this), 1, null);
    }
}
