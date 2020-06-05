package com.jiayouya.travel.module.travel.p288ui.p289a;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.databinding.DataBindingUtil;
import com.jiayouya.travel.R;
import com.jiayouya.travel.databinding.DialogMergeBonusDogBinding;
import com.jiayouya.travel.module.travel.data.MergeBonusDogItem;
import ezy.p653ui.widget.dialog.CustomDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8247b;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B8\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\u0002\u0010\u000bJ\b\u0010\u0013\u001a\u00020\nH\u0002J\b\u0010\u0014\u001a\u00020\nH\u0002R,\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000fX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/ui/dialog/MergeBonusDogDialog;", "Lezy/ui/widget/dialog/CustomDialog;", "context", "Landroid/content/Context;", "item", "Lcom/jiayouya/travel/module/travel/data/MergeBonusDogItem;", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "(Landroid/content/Context;Lcom/jiayouya/travel/module/travel/data/MergeBonusDogItem;Lkotlin/jvm/functions/Function1;)V", "getAction", "()Lkotlin/jvm/functions/Function1;", "binding", "Lcom/jiayouya/travel/databinding/DialogMergeBonusDogBinding;", "kotlin.jvm.PlatformType", "getItem", "()Lcom/jiayouya/travel/module/travel/data/MergeBonusDogItem;", "setupClick", "setupView", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.module.travel.ui.a.l */
public final class MergeBonusDogDilaog extends CustomDialog {
    /* renamed from: a */
    private final DialogMergeBonusDogBinding f12007a = ((DialogMergeBonusDogBinding) DataBindingUtil.inflate(getLayoutInflater(), R.layout.dialog_merge_bonus_dog, null, false));
    /* renamed from: b */
    private final MergeBonusDogItem f12008b;
    /* renamed from: c */
    private final C8247b<MergeBonusDogItem, Unit> f12009c;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: MergeBonusDogDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.l$a */
    static final class C3390a extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ MergeBonusDogDilaog this$0;

        C3390a(MergeBonusDogDilaog lVar) {
            this.this$0 = lVar;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            this.this$0.dismiss();
            this.this$0.mo22293b().invoke(this.this$0.mo22292a());
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: MergeBonusDogDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.travel.ui.a.l$b */
    static final class C3391b extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ MergeBonusDogDilaog this$0;

        C3391b(MergeBonusDogDilaog lVar) {
            this.this$0 = lVar;
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

    /* renamed from: a */
    public final MergeBonusDogItem mo22292a() {
        return this.f12008b;
    }

    /* renamed from: b */
    public final C8247b<MergeBonusDogItem, Unit> mo22293b() {
        return this.f12009c;
    }

    public MergeBonusDogDilaog(Context context, MergeBonusDogItem mergeBonusDogItem, C8247b<? super MergeBonusDogItem, Unit> bVar) {
        C8271i.m35386b(context, "context");
        C8271i.m35386b(mergeBonusDogItem, "item");
        C8271i.m35386b(bVar, "action");
        super(context);
        this.f12008b = mergeBonusDogItem;
        this.f12009c = bVar;
        DialogMergeBonusDogBinding dialogMergeBonusDogBinding = this.f12007a;
        C8271i.m35382a((Object) dialogMergeBonusDogBinding, "binding");
        setView(dialogMergeBonusDogBinding.getRoot());
        m14594d();
        m14593c();
    }

    /* renamed from: c */
    private final void m14593c() {
        setDimAmount(0.7f);
        DialogMergeBonusDogBinding dialogMergeBonusDogBinding = this.f12007a;
        C8271i.m35382a((Object) dialogMergeBonusDogBinding, "binding");
        dialogMergeBonusDogBinding.mo20130a(this.f12008b);
        FrameLayout frameLayout = this.f12007a.f10494a;
        C8271i.m35382a((Object) frameLayout, "binding.btn");
        boolean z = (this.f12008b.getOzDogIndex() == -1 || this.f12008b.getMzDogIndex() == -1 || this.f12008b.getDyzDogIndex() == -1 || this.f12008b.getFzDogIndex() == -1 || this.f12008b.getYzDogIndex() == -1) ? false : true;
        frameLayout.setEnabled(z);
    }

    /* renamed from: d */
    private final void m14594d() {
        FrameLayout frameLayout = this.f12007a.f10494a;
        C8271i.m35382a((Object) frameLayout, "binding.btn");
        ezy.p642a.View.m34750a(frameLayout, 0, new C3390a(this), 1, null);
        ImageView imageView = this.f12007a.f10495b;
        C8271i.m35382a((Object) imageView, "binding.ivClose");
        ezy.p642a.View.m34750a(imageView, 0, new C3391b(this), 1, null);
    }
}
