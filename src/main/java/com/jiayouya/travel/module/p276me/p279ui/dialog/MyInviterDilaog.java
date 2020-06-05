package com.jiayouya.travel.module.p276me.p279ui.dialog;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p246d.ClipboardUtil;
import com.jiayouya.travel.common.p246d.Router;
import com.jiayouya.travel.databinding.DialogMyInviterBinding;
import com.jiayouya.travel.module.common.data.ParentRsp;
import ezy.p653ui.widget.dialog.CustomDialog;
import ezy.p653ui.widget.round.RoundText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8247b;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, mo39189d2 = {"Lcom/jiayouya/travel/module/me/ui/dialog/MyInviterDialog;", "Lezy/ui/widget/dialog/CustomDialog;", "context", "Landroid/content/Context;", "item", "Lcom/jiayouya/travel/module/common/data/ParentRsp;", "type", "", "(Landroid/content/Context;Lcom/jiayouya/travel/module/common/data/ParentRsp;I)V", "binding", "Lcom/jiayouya/travel/databinding/DialogMyInviterBinding;", "kotlin.jvm.PlatformType", "getItem", "()Lcom/jiayouya/travel/module/common/data/ParentRsp;", "getType", "()I", "setupClick", "", "setupView", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.module.me.ui.dialog.f */
public final class MyInviterDilaog extends CustomDialog {
    /* renamed from: a */
    private final DialogMyInviterBinding f11675a;
    /* renamed from: b */
    private final ParentRsp f11676b;
    /* renamed from: c */
    private final int f11677c;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: MyInviterDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.dialog.f$a */
    static final class C3218a extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ MyInviterDilaog this$0;

        C3218a(MyInviterDilaog fVar) {
            this.this$0 = fVar;
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
    /* compiled from: MyInviterDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.dialog.f$b */
    static final class C3219b extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ MyInviterDilaog this$0;

        C3219b(MyInviterDilaog fVar) {
            this.this$0 = fVar;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            if (!TextUtils.isEmpty(this.this$0.mo21425a().getQq())) {
                Context context = this.this$0.getContext();
                C8271i.m35382a((Object) context, "context");
                ClipboardUtil.m12953a(context, this.this$0.mo21425a().getQq(), false, null, 12, null);
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: MyInviterDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.dialog.f$c */
    static final class C3220c extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ MyInviterDilaog this$0;

        C3220c(MyInviterDilaog fVar) {
            this.this$0 = fVar;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            if (!TextUtils.isEmpty(this.this$0.mo21425a().getWx())) {
                Context context = this.this$0.getContext();
                C8271i.m35382a((Object) context, "context");
                ClipboardUtil.m12953a(context, this.this$0.mo21425a().getWx(), false, null, 12, null);
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: MyInviterDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.dialog.f$d */
    static final class C3221d extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ MyInviterDilaog this$0;

        C3221d(MyInviterDilaog fVar) {
            this.this$0 = fVar;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            Router.m12969a(Router.f9644a, "/me/socialInfo", null, null, 6, null);
            this.this$0.dismiss();
        }
    }

    public /* synthetic */ MyInviterDilaog(Context context, ParentRsp parentRsp, int i, int i2, DefaultConstructorMarker fVar) {
        if ((i2 & 4) != 0) {
            i = 1;
        }
        this(context, parentRsp, i);
    }

    /* renamed from: a */
    public final ParentRsp mo21425a() {
        return this.f11676b;
    }

    public MyInviterDilaog(Context context, ParentRsp parentRsp, int i) {
        C8271i.m35386b(context, "context");
        C8271i.m35386b(parentRsp, "item");
        super(context);
        this.f11676b = parentRsp;
        this.f11677c = i;
        this.f11675a = (DialogMyInviterBinding) DataBindingUtil.inflate(getLayoutInflater(), R.layout.dialog_my_inviter, null, false);
        DialogMyInviterBinding dialogMyInviterBinding = this.f11675a;
        C8271i.m35382a((Object) dialogMyInviterBinding, "binding");
        setView(dialogMyInviterBinding.getRoot());
        m14164c();
        m14163b();
    }

    /* renamed from: b */
    private final void m14163b() {
        DialogMyInviterBinding dialogMyInviterBinding = this.f11675a;
        String str = "binding";
        C8271i.m35382a((Object) dialogMyInviterBinding, str);
        View root = dialogMyInviterBinding.getRoot();
        C8271i.m35382a((Object) root, "binding.root");
        root.getLayoutParams().width = dp2px(280.0f);
        setDimAmount(0.7f);
        DialogMyInviterBinding dialogMyInviterBinding2 = this.f11675a;
        C8271i.m35382a((Object) dialogMyInviterBinding2, str);
        dialogMyInviterBinding2.mo20132a(this.f11676b);
        DialogMyInviterBinding dialogMyInviterBinding3 = this.f11675a;
        C8271i.m35382a((Object) dialogMyInviterBinding3, str);
        dialogMyInviterBinding3.mo20131a(this.f11677c);
    }

    /* renamed from: c */
    private final void m14164c() {
        ImageView imageView = this.f11675a.f10518c;
        C8271i.m35382a((Object) imageView, "binding.ivClose");
        ezy.p642a.View.m34750a(imageView, 0, new C3218a(this), 1, null);
        RoundText roundText = this.f11675a.f10516a;
        C8271i.m35382a((Object) roundText, "binding.btnCopyQq");
        ezy.p642a.View.m34750a(roundText, 0, new C3219b(this), 1, null);
        RoundText roundText2 = this.f11675a.f10517b;
        C8271i.m35382a((Object) roundText2, "binding.btnCopyWx");
        ezy.p642a.View.m34750a(roundText2, 0, new C3220c(this), 1, null);
        TextView textView = this.f11675a.f10519d;
        C8271i.m35382a((Object) textView, "binding.tvSetting");
        ezy.p642a.View.m34750a(textView, 0, new C3221d(this), 1, null);
    }
}
