package com.qiyukf.nim.uikit.session.helper;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class MsgBgImageView extends ImageView {
    public MsgBgImageView(Context context) {
        super(context);
        super.setScaleType(ScaleType.CENTER_CROP);
    }

    public MsgBgImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setScaleType(ScaleType.CENTER_CROP);
    }

    public MsgBgImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        super.setScaleType(ScaleType.CENTER_CROP);
    }

    public MsgBgImageView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        super.setScaleType(ScaleType.CENTER_CROP);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float f;
        Drawable drawable = getDrawable();
        if (drawable == null) {
            super.onDraw(canvas);
            return;
        }
        int width = drawable.getBounds().width();
        int height = drawable.getBounds().height();
        int width2 = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        if (width * height2 <= width2 * height) {
            f = (((float) height2) - (((float) height) * (((float) width2) / ((float) width)))) * 0.5f;
        } else {
            f = 0.0f;
        }
        canvas.save();
        canvas.translate(0.0f, (float) (-((int) (f + 0.5f))));
        super.onDraw(canvas);
        canvas.restore();
    }

    public final void setScaleType(ScaleType scaleType) {
    }
}
