package com.jiayouya.travel.module.p276me.p279ui.dialog;

import android.content.Context;
import android.view.View;
import androidx.databinding.DataBindingUtil;
import com.jiayouya.travel.R;
import com.jiayouya.travel.databinding.DialogRealNameAuthFailBinding;
import ezy.p653ui.widget.dialog.CustomDialog;
import ezy.p653ui.widget.round.RoundText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8247b;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, mo39189d2 = {"Lcom/jiayouya/travel/module/me/ui/dialog/RealNameAuthFailDialog;", "Lezy/ui/widget/dialog/CustomDialog;", "context", "Landroid/content/Context;", "errorText", "", "(Landroid/content/Context;Ljava/lang/String;)V", "binding", "Lcom/jiayouya/travel/databinding/DialogRealNameAuthFailBinding;", "kotlin.jvm.PlatformType", "setupClick", "", "setupView", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.module.me.ui.dialog.g */
public final class RealNameAuthFailDilaog extends CustomDialog {
    /* renamed from: a */
    private final DialogRealNameAuthFailBinding f11678a = ((DialogRealNameAuthFailBinding) DataBindingUtil.inflate(getLayoutInflater(), R.layout.dialog_real_name_auth_fail, null, false));
    /* renamed from: b */
    private final String f11679b;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: RealNameAuthFailDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.dialog.g$a */
    static final class C3222a extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ RealNameAuthFailDilaog this$0;

        C3222a(RealNameAuthFailDilaog gVar) {
            this.this$0 = gVar;
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

    public RealNameAuthFailDilaog(Context context, String str) {
        C8271i.m35386b(context, "context");
        super(context);
        this.f11679b = str;
        DialogRealNameAuthFailBinding dialogRealNameAuthFailBinding = this.f11678a;
        C8271i.m35382a((Object) dialogRealNameAuthFailBinding, "binding");
        setView(dialogRealNameAuthFailBinding.getRoot());
        m14167b();
        m14166a();
    }

    /* renamed from: a */
    private final void m14166a() {
        setDimAmount(0.7f);
        DialogRealNameAuthFailBinding dialogRealNameAuthFailBinding = this.f11678a;
        String str = "binding";
        C8271i.m35382a((Object) dialogRealNameAuthFailBinding, str);
        View root = dialogRealNameAuthFailBinding.getRoot();
        C8271i.m35382a((Object) root, "binding.root");
        root.getLayoutParams().width = dp2px(260.0f);
        DialogRealNameAuthFailBinding dialogRealNameAuthFailBinding2 = this.f11678a;
        C8271i.m35382a((Object) dialogRealNameAuthFailBinding2, str);
        dialogRealNameAuthFailBinding2.mo20136a(this.f11679b);
    }

    /* renamed from: b */
    private final void m14167b() {
        RoundText roundText = this.f11678a.f10577a;
        C8271i.m35382a((Object) roundText, "binding.btn");
        ezy.p642a.View.m34750a(roundText, 0, new C3222a(this), 1, null);
    }
}
