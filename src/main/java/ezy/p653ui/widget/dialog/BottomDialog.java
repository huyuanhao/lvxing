package ezy.p653ui.widget.dialog;

import android.content.Context;
import android.view.WindowManager.LayoutParams;

/* renamed from: ezy.ui.widget.dialog.BottomDialog */
public class BottomDialog extends CustomDialog {
    public BottomDialog(Context context) {
        this(context, 0, true);
    }

    public BottomDialog(Context context, int i, boolean z) {
        super(context, i);
        setAnimation(translate(1.0f, 0.0f), translate(0.0f, 1.0f));
        getWindow().setGravity((z ? 7 : 1) | 80);
        getWindow().getDecorView().setLayoutParams(new LayoutParams(-1, -2));
        getWindow().setLayout(-1, -2);
        setCanceledOnTouchOutside(true);
    }
}
