package com.yanzhenjie.album.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class TransferLayout extends FrameLayout {
    public TransferLayout(Context context) {
        super(context);
    }

    public TransferLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public TransferLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean performClick() {
        if (getChildCount() == 1) {
            return getChildAt(0).performClick();
        }
        return super.performClick();
    }

    public boolean callOnClick() {
        if (getChildCount() == 1) {
            return getChildAt(0).performClick();
        }
        return super.performClick();
    }
}
