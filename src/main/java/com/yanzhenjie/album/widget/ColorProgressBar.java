package com.yanzhenjie.album.widget;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class ColorProgressBar extends ProgressBar {
    public ColorProgressBar(Context context) {
        super(context);
    }

    public ColorProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ColorProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setColorFilter(int i) {
        Drawable mutate = getIndeterminateDrawable().mutate();
        mutate.setColorFilter(i, Mode.SRC_IN);
        setIndeterminateDrawable(mutate);
    }
}
