package ezy.p653ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import reezy.lib.common.R;

/* renamed from: ezy.ui.view.AspectRatioImageView */
public class AspectRatioImageView extends AppCompatImageView {
    private float mRatio;

    public AspectRatioImageView(Context context) {
        super(context);
        init(context, null, 0, 0);
    }

    public AspectRatioImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet, 0, 0);
    }

    public AspectRatioImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet, i, 0);
    }

    private void init(Context context, AttributeSet attributeSet, int i, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AspectRatioImageView, i, i2);
        this.mRatio = obtainStyledAttributes.getFloat(R.styleable.AspectRatioImageView_ariRatio, 1.0f);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        setMeasuredDimension(measuredWidth, Math.round(((float) measuredWidth) * this.mRatio));
    }
}
