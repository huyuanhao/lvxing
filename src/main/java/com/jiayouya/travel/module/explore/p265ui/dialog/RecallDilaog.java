package com.jiayouya.travel.module.explore.p265ui.dialog;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.databinding.DataBindingUtil;
import com.jiayouya.travel.R;
import com.jiayouya.travel.databinding.DialogRecallBinding;
import ezy.p653ui.widget.dialog.CustomDialog;
import ezy.p653ui.widget.round.RoundText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8246a;
import kotlin.jvm.p679a.C8247b;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\r\u001a\u00020\u0006H\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo39189d2 = {"Lcom/jiayouya/travel/module/explore/ui/dialog/RecallDialog;", "Lezy/ui/widget/dialog/CustomDialog;", "context", "Landroid/content/Context;", "action", "Lkotlin/Function0;", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function0;)V", "getAction", "()Lkotlin/jvm/functions/Function0;", "binding", "Lcom/jiayouya/travel/databinding/DialogRecallBinding;", "kotlin.jvm.PlatformType", "setupClick", "setupView", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.module.explore.ui.dialog.b */
public final class RecallDilaog extends CustomDialog {
    /* renamed from: a */
    private final DialogRecallBinding f11437a = ((DialogRecallBinding) DataBindingUtil.inflate(getLayoutInflater(), R.layout.dialog_recall, null, false));
    /* renamed from: b */
    private final C8246a<Unit> f11438b;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: RecallDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.explore.ui.dialog.b$a */
    static final class C3028a extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ RecallDilaog this$0;

        C3028a(RecallDilaog bVar) {
            this.this$0 = bVar;
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
    /* compiled from: RecallDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.explore.ui.dialog.b$b */
    static final class C3029b extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ RecallDilaog this$0;

        C3029b(RecallDilaog bVar) {
            this.this$0 = bVar;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            this.this$0.dismiss();
            this.this$0.mo20922a().invoke();
        }
    }

    public RecallDilaog(Context context, C8246a<Unit> aVar) {
        C8271i.m35386b(context, "context");
        C8271i.m35386b(aVar, "action");
        super(context);
        this.f11438b = aVar;
        DialogRecallBinding dialogRecallBinding = this.f11437a;
        C8271i.m35382a((Object) dialogRecallBinding, "binding");
        setView(dialogRecallBinding.getRoot());
        m13722c();
        m13721b();
    }

    /* renamed from: a */
    public final C8246a<Unit> mo20922a() {
        return this.f11438b;
    }

    /* renamed from: b */
    private final void m13721b() {
        setDimAmount(0.7f);
    }

    /* renamed from: c */
    private final void m13722c() {
        ImageView imageView = this.f11437a.f10585b;
        C8271i.m35382a((Object) imageView, "binding.ivClose");
        ezy.p642a.View.m34750a(imageView, 0, new C3028a(this), 1, null);
        RoundText roundText = this.f11437a.f10584a;
        C8271i.m35382a((Object) roundText, "binding.btn");
        ezy.p642a.View.m34750a(roundText, 0, new C3029b(this), 1, null);
    }
}
