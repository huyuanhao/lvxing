package com.jiayouya.travel.common.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import androidx.databinding.DataBindingUtil;
import com.jiayouya.travel.R;
import com.jiayouya.travel.databinding.DialogLoadingBinding;
import ezy.p653ui.widget.dialog.CustomDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, mo39189d2 = {"Lcom/jiayouya/travel/common/widget/LoadingDialog;", "Lezy/ui/widget/dialog/CustomDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "binding", "Lcom/jiayouya/travel/databinding/DialogLoadingBinding;", "kotlin.jvm.PlatformType", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: LoadingDialog.kt */
public final class LoadingDialog extends CustomDialog {
    /* renamed from: a */
    private final DialogLoadingBinding f9665a = ((DialogLoadingBinding) DataBindingUtil.inflate(getLayoutInflater(), R.layout.dialog_loading, null, false));

    public LoadingDialog(Context context) {
        C8271i.m35386b(context, "context");
        super(context);
        DialogLoadingBinding dialogLoadingBinding = this.f9665a;
        String str = "binding";
        C8271i.m35382a((Object) dialogLoadingBinding, str);
        setView(dialogLoadingBinding.getRoot());
        DialogLoadingBinding dialogLoadingBinding2 = this.f9665a;
        C8271i.m35382a((Object) dialogLoadingBinding2, str);
        View root = dialogLoadingBinding2.getRoot();
        C8271i.m35382a((Object) root, "binding.root");
        LayoutParams layoutParams = root.getLayoutParams();
        layoutParams.width = dp2px(100.0f);
        layoutParams.height = dp2px(100.0f);
        setCancelable(true);
        setCanceledOnTouchOutside(true);
    }
}
