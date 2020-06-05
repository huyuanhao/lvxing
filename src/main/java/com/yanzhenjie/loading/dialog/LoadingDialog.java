package com.yanzhenjie.loading.dialog;

import android.app.Dialog;
import android.content.Context;
import com.yanzhenjie.loading.C7812R;

public class LoadingDialog extends Dialog {
    public LoadingDialog(Context context) {
        super(context, C7812R.style.LoadingWaitDialog);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        setContentView(C7812R.C7814layout.loading_wait_dialog);
    }
}
