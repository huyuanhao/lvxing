package ezy.p653ui.widget.dialog;

import android.content.Context;
import android.view.WindowManager.LayoutParams;

/* renamed from: ezy.ui.widget.dialog.CenterDialog */
public class CenterDialog extends CustomDialog {
    public CenterDialog(Context context) {
        this(context, 0, true);
    }

    public CenterDialog(Context context, int i, boolean z) {
        super(context, i);
        getWindow().setGravity((z ? 7 : 1) | 17);
        getWindow().getDecorView().setLayoutParams(new LayoutParams(-1, -2));
        getWindow().setLayout(-1, -2);
        setCanceledOnTouchOutside(true);
    }
}
