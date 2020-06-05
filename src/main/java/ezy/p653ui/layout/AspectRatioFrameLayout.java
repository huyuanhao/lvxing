package ezy.p653ui.layout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import reezy.lib.common.R;

/* renamed from: ezy.ui.layout.AspectRatioFrameLayout */
public class AspectRatioFrameLayout extends FrameLayout {
    private float mRatio;

    public AspectRatioFrameLayout(Context context) {
        super(context);
        init(context, null, 0, 0);
    }

    public AspectRatioFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet, 0, 0);
    }

    public AspectRatioFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet, i, 0);
    }

    private void init(Context context, AttributeSet attributeSet, int i, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AspectRatioFrameLayout, i, i2);
        this.mRatio = obtainStyledAttributes.getFloat(R.styleable.AspectRatioFrameLayout_aspectRatio, 1.0f);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        setMeasuredDimension(measuredWidth, Math.round(((float) measuredWidth) * this.mRatio));
    }
}
