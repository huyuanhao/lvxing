package com.jiayouya.travel.module.group.p268ui.dialog;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.databinding.DataBindingUtil;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p246d.ClipboardUtil;
import com.jiayouya.travel.databinding.DialogUpgradeChannelBinding;
import ezy.p653ui.widget.dialog.CustomDialog;
import ezy.p653ui.widget.round.RoundText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8247b;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, mo39189d2 = {"Lcom/jiayouya/travel/module/group/ui/dialog/UpgradeChannelDialog;", "Lezy/ui/widget/dialog/CustomDialog;", "context", "Landroid/content/Context;", "contactInfo", "", "(Landroid/content/Context;Ljava/lang/String;)V", "binding", "Lcom/jiayouya/travel/databinding/DialogUpgradeChannelBinding;", "kotlin.jvm.PlatformType", "setupClick", "", "setupView", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.module.group.ui.dialog.b */
public final class UpgradeChannelDilaog extends CustomDialog {
    /* renamed from: a */
    private final DialogUpgradeChannelBinding f11499a = ((DialogUpgradeChannelBinding) DataBindingUtil.inflate(getLayoutInflater(), R.layout.dialog_upgrade_channel, null, false));
    /* access modifiers changed from: private|final */
    /* renamed from: b */
    public final String f11500b;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: UpgradeChannelDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.group.ui.dialog.b$a */
    static final class C3051a extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ UpgradeChannelDilaog this$0;

        C3051a(UpgradeChannelDilaog bVar) {
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
    /* compiled from: UpgradeChannelDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.group.ui.dialog.b$b */
    static final class C3052b extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ UpgradeChannelDilaog this$0;

        C3052b(UpgradeChannelDilaog bVar) {
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
            Context context = this.this$0.getContext();
            C8271i.m35382a((Object) context, "context");
            ClipboardUtil.m12953a(context, this.this$0.f11500b, false, null, 12, null);
        }
    }

    public UpgradeChannelDilaog(Context context, String str) {
        C8271i.m35386b(context, "context");
        C8271i.m35386b(str, "contactInfo");
        super(context);
        this.f11500b = str;
        DialogUpgradeChannelBinding dialogUpgradeChannelBinding = this.f11499a;
        C8271i.m35382a((Object) dialogUpgradeChannelBinding, "binding");
        setView(dialogUpgradeChannelBinding.getRoot());
        m13796b();
        m13795a();
    }

    /* renamed from: a */
    private final void m13795a() {
        setDimAmount(0.7f);
        DialogUpgradeChannelBinding dialogUpgradeChannelBinding = this.f11499a;
        C8271i.m35382a((Object) dialogUpgradeChannelBinding, "binding");
        dialogUpgradeChannelBinding.mo20147a(this.f11500b);
    }

    /* renamed from: b */
    private final void m13796b() {
        ImageView imageView = this.f11499a.f10704b;
        C8271i.m35382a((Object) imageView, "binding.ivClose");
        ezy.p642a.View.m34750a(imageView, 0, new C3051a(this), 1, null);
        RoundText roundText = this.f11499a.f10703a;
        C8271i.m35382a((Object) roundText, "binding.btn");
        ezy.p642a.View.m34750a(roundText, 0, new C3052b(this), 1, null);
    }
}
