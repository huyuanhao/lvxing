package com.p368pw.view;

import android.content.Context;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.p368pw.inner.base.p387d.C5191i;

/* renamed from: com.pw.view.DownloadProgressBar */
public class DownloadProgressBar extends ProgressBar {
    public DownloadProgressBar(Context context) {
        this(context, null);
    }

    public DownloadProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DownloadProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setColor(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setStroke(C5191i.m21391b(getContext(), 1), i);
        gradientDrawable.setCornerRadius((float) C5191i.m21391b(getContext(), 8));
        gradientDrawable.setColor(-1);
        gradientDrawable.setOrientation(Orientation.LEFT_RIGHT);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadius((float) C5191i.m21391b(getContext(), 8));
        gradientDrawable2.setColor(i);
        gradientDrawable2.setOrientation(Orientation.LEFT_RIGHT);
        setProgressDrawable(new LayerDrawable(new Drawable[]{gradientDrawable, new ClipDrawable(gradientDrawable2, 3, 1)}));
    }
}
