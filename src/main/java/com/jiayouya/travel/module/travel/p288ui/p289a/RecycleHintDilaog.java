package com.jiayouya.travel.module.travel.p288ui.p289a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.databinding.DataBindingUtil;
import com.jiayouya.travel.R;
import com.jiayouya.travel.databinding.DialogRecycleHintBinding;
import com.jiayouya.travel.module.travel.p287c.MergeUtil;
import ezy.p653ui.widget.dialog.CustomDialog;
import ezy.p653ui.widget.round.RoundText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8246a;
import kotlin.jvm.p679a.C8247b;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\b\u0010\u0013\u001a\u00020\nH\u0002J\b\u0010\u0014\u001a\u00020\nH\u0002R\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/ui/dialog/RecycleHintDialog;", "Lezy/ui/widget/dialog/CustomDialog;", "context", "Landroid/content/Context;", "dogId", "", "price", "", "recycleAction", "Lkotlin/Function0;", "", "(Landroid/content/Context;ILjava/lang/String;Lkotlin/jvm/functions/Function0;)V", "binding", "Lcom/jiayouya/travel/databinding/DialogRecycleHintBinding;", "kotlin.jvm.PlatformType", "getDogId", "()I", "getPrice", "()Ljava/lang/String;", "setupClick", "setupView", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.module.travel.ui.a.o */
public final class RecycleHintDilaog extends CustomDialog {
    /* renamed from: a */
    private final DialogRecycleHintBinding f12032a = ((DialogRecycleHintBinding) DataBindingUtil.inflate(getLayoutInflater(), R.layout.dialog_recycle_hint, null, false));
    /* renamed from: b */
    private final int f12033b;
    /* renamed from: c */
    private final String f12034c;
    /* access modifiers changed from: private|final */
    /* renamed from: d */
    public final C8246a<Unit> f12035d;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: RecycleHintDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.o$a */
    static final class C3409a extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ RecycleHintDilaog this$0;

        C3409a(RecycleHintDilaog oVar) {
            this.this$0 = oVar;
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
    /* compiled from: RecycleHintDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.o$b */
    static final class C3410b extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ RecycleHintDilaog this$0;

        C3410b(RecycleHintDilaog oVar) {
            this.this$0 = oVar;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            this.this$0.f12035d.invoke();
            this.this$0.dismiss();
        }
    }

    public RecycleHintDilaog(Context context, int i, String str, C8246a<Unit> aVar) {
        C8271i.m35386b(context, "context");
        C8271i.m35386b(str, "price");
        C8271i.m35386b(aVar, "recycleAction");
        super(context);
        this.f12033b = i;
        this.f12034c = str;
        this.f12035d = aVar;
        DialogRecycleHintBinding dialogRecycleHintBinding = this.f12032a;
        C8271i.m35382a((Object) dialogRecycleHintBinding, "binding");
        setView(dialogRecycleHintBinding.getRoot());
        m14631b();
        m14630a();
    }

    /* renamed from: a */
    private final void m14630a() {
        setDimAmount(0.7f);
        DialogRecycleHintBinding dialogRecycleHintBinding = this.f12032a;
        View root = dialogRecycleHintBinding.getRoot();
        C8271i.m35382a((Object) root, "root");
        root.getLayoutParams().width = dp2px(260.0f);
        dialogRecycleHintBinding.mo20137a(MergeUtil.m14455b(this.f12033b));
        dialogRecycleHintBinding.mo20138a(this.f12034c);
    }

    /* renamed from: b */
    private final void m14631b() {
        ImageView imageView = this.f12032a.f10591b;
        C8271i.m35382a((Object) imageView, "binding.ivClose");
        ezy.p642a.View.m34750a(imageView, 0, new C3409a(this), 1, null);
        RoundText roundText = this.f12032a.f10590a;
        C8271i.m35382a((Object) roundText, "binding.btnRecycle");
        ezy.p642a.View.m34750a(roundText, 0, new C3410b(this), 1, null);
    }
}
