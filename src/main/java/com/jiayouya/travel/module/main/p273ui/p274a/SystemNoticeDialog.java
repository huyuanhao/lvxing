package com.jiayouya.travel.module.main.p273ui.p274a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.databinding.DataBindingUtil;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p246d.Router;
import com.jiayouya.travel.databinding.DialogSystemNoticeBinding;
import com.jiayouya.travel.module.common.data.SystemNotice;
import ezy.p653ui.widget.dialog.CustomDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8247b;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, mo39189d2 = {"Lcom/jiayouya/travel/module/main/ui/dialog/SystemNoticeDialog;", "Lezy/ui/widget/dialog/CustomDialog;", "context", "Landroid/content/Context;", "item", "Lcom/jiayouya/travel/module/common/data/SystemNotice;", "(Landroid/content/Context;Lcom/jiayouya/travel/module/common/data/SystemNotice;)V", "binding", "Lcom/jiayouya/travel/databinding/DialogSystemNoticeBinding;", "kotlin.jvm.PlatformType", "getItem", "()Lcom/jiayouya/travel/module/common/data/SystemNotice;", "setupClick", "", "setupView", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.module.main.ui.a.a */
public final class SystemNoticeDialog extends CustomDialog {
    /* renamed from: a */
    private final DialogSystemNoticeBinding f11550a = ((DialogSystemNoticeBinding) DataBindingUtil.inflate(getLayoutInflater(), R.layout.dialog_system_notice, null, false));
    /* renamed from: b */
    private final SystemNotice f11551b;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: SystemNoticeDialog.kt */
    /* renamed from: com.jiayouya.travel.module.main.ui.a.a$a */
    static final class C3099a extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ SystemNoticeDialog this$0;

        C3099a(SystemNoticeDialog aVar) {
            this.this$0 = aVar;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            this.this$0.dismiss();
            Router.m12969a(Router.f9644a, this.this$0.mo21182a().getRoute(), null, null, 6, null);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: SystemNoticeDialog.kt */
    /* renamed from: com.jiayouya.travel.module.main.ui.a.a$b */
    static final class C3100b extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ SystemNoticeDialog this$0;

        C3100b(SystemNoticeDialog aVar) {
            this.this$0 = aVar;
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

    public SystemNoticeDialog(Context context, SystemNotice systemNotice) {
        C8271i.m35386b(context, "context");
        C8271i.m35386b(systemNotice, "item");
        super(context);
        this.f11551b = systemNotice;
        setDimAmount(0.7f);
        DialogSystemNoticeBinding dialogSystemNoticeBinding = this.f11550a;
        C8271i.m35382a((Object) dialogSystemNoticeBinding, "binding");
        setView(dialogSystemNoticeBinding.getRoot());
        m13892b();
        m13893c();
    }

    /* renamed from: a */
    public final SystemNotice mo21182a() {
        return this.f11551b;
    }

    /* renamed from: b */
    private final void m13892b() {
        DialogSystemNoticeBinding dialogSystemNoticeBinding = this.f11550a;
        C8271i.m35382a((Object) dialogSystemNoticeBinding, "binding");
        dialogSystemNoticeBinding.mo20141a(this.f11551b);
        if (this.f11551b.isForce()) {
            setCanceledOnTouchOutside(false);
            setCancelable(false);
        }
    }

    /* renamed from: c */
    private final void m13893c() {
        ImageView imageView = this.f11550a.f10625a;
        C8271i.m35382a((Object) imageView, "binding.img");
        ezy.p642a.View.m34750a(imageView, 0, new C3099a(this), 1, null);
        ImageView imageView2 = this.f11550a.f10626b;
        C8271i.m35382a((Object) imageView2, "binding.imgClose");
        ezy.p642a.View.m34750a(imageView2, 0, new C3100b(this), 1, null);
    }
}
