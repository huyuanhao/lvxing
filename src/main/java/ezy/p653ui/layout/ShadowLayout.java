package ezy.p653ui.layout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import reezy.lib.common.R;

/* renamed from: ezy.ui.layout.ShadowLayout */
public class ShadowLayout extends FrameLayout {
    private static final int DEFAULT_SHADOW_COLOR = -1250068;
    private int mRoundCornerRadius;
    private int mShadowColor;
    private int mShadowPaddingBottom;
    private int mShadowPaddingLeft;
    private int mShadowPaddingRight;
    private int mShadowPaddingTop;
    private Paint mShadowPaint;
    private int mShadowRadius;
    private RectF mShadowRect;

    public ShadowLayout(Context context) {
        super(context);
        init(context, null);
    }

    public ShadowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public ShadowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ShadowLayout);
        this.mRoundCornerRadius = (int) obtainStyledAttributes.getDimension(R.styleable.ShadowLayout_slRoundCornerRadius, dip2px(0.0f));
        this.mShadowColor = obtainStyledAttributes.getColor(R.styleable.ShadowLayout_slShadowColor, DEFAULT_SHADOW_COLOR);
        this.mShadowRadius = (int) obtainStyledAttributes.getDimension(R.styleable.ShadowLayout_slShadowRadius, dip2px(8.0f));
        float dimension = (float) ((int) obtainStyledAttributes.getDimension(R.styleable.ShadowLayout_slShadowPadding, 0.0f));
        this.mShadowPaddingLeft = (int) obtainStyledAttributes.getDimension(R.styleable.ShadowLayout_slShadowPaddingLeft, dimension);
        this.mShadowPaddingTop = (int) obtainStyledAttributes.getDimension(R.styleable.ShadowLayout_slShadowPaddingTop, dimension);
        this.mShadowPaddingRight = (int) obtainStyledAttributes.getDimension(R.styleable.ShadowLayout_slShadowPaddingRight, dimension);
        this.mShadowPaddingBottom = (int) obtainStyledAttributes.getDimension(R.styleable.ShadowLayout_slShadowPaddingBottom, dimension);
        obtainStyledAttributes.recycle();
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setColor(-1);
        this.mShadowPaint.setStyle(Style.FILL);
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setShadowLayer((float) this.mShadowRadius, 0.0f, 0.0f, this.mShadowColor);
        setLayerType(1, null);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.mShadowRect == null) {
            this.mShadowRect = new RectF();
        }
        this.mShadowRect.left = (float) (getPaddingLeft() + this.mShadowPaddingLeft);
        this.mShadowRect.top = (float) (getPaddingTop() + this.mShadowPaddingTop);
        this.mShadowRect.right = (float) ((getWidth() - getPaddingRight()) - this.mShadowPaddingRight);
        this.mShadowRect.bottom = (float) ((getHeight() - getPaddingBottom()) - this.mShadowPaddingBottom);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        if (this.mShadowRect == null) {
            this.mShadowRect = new RectF();
            this.mShadowRect.left = (float) (getPaddingLeft() + this.mShadowPaddingLeft);
            this.mShadowRect.top = (float) (getPaddingTop() + this.mShadowPaddingTop);
            this.mShadowRect.right = (float) ((getWidth() - getPaddingRight()) - this.mShadowPaddingRight);
            this.mShadowRect.bottom = (float) ((getHeight() - getPaddingBottom()) - this.mShadowPaddingBottom);
        }
        RectF rectF = this.mShadowRect;
        int i = this.mRoundCornerRadius;
        canvas.drawRoundRect(rectF, (float) i, (float) i, this.mShadowPaint);
        super.dispatchDraw(canvas);
    }

    private float dip2px(float f) {
        return (float) ((int) ((f * getContext().getResources().getDisplayMetrics().density) + 0.5f));
    }

    public void setShadowColor(int i) {
        this.mShadowPaint.setShadowLayer((float) this.mShadowRadius, 0.0f, 0.0f, this.mShadowColor);
        invalidate();
    }

    public void setShadowRadius(int i) {
        this.mShadowRadius = i;
        this.mShadowPaint.setShadowLayer((float) this.mShadowRadius, 0.0f, 0.0f, this.mShadowColor);
        invalidate();
    }

    public void setRoundCornerRadius(int i) {
        this.mRoundCornerRadius = i;
        invalidate();
    }
}
