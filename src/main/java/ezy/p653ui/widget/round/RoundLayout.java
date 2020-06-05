package ezy.p653ui.widget.round;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.FrameLayout;
import reezy.lib.common.R;

/* renamed from: ezy.ui.widget.round.RoundLayout */
public class RoundLayout extends FrameLayout {
    private static final int DEFAULT_SHADOW_COLOR = -1250068;
    /* access modifiers changed from: private */
    public int mCornerRadius;
    private Paint mShadowPaint;
    /* access modifiers changed from: private */
    public RectF mShadowRect;
    private int shadowOffsetX;
    private int shadowOffsetY;
    private int shadowRadius;

    public RoundLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        int i;
        int i2;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RoundLayout);
        int color = obtainStyledAttributes.getColor(R.styleable.RoundLayout_rndShadowColor, DEFAULT_SHADOW_COLOR);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(R.styleable.RoundLayout_rndShadowLen, 0);
        int layoutDimension2 = obtainStyledAttributes.getLayoutDimension(R.styleable.RoundLayout_rndLeftShadowLen, layoutDimension);
        int layoutDimension3 = obtainStyledAttributes.getLayoutDimension(R.styleable.RoundLayout_rndTopShadowLen, layoutDimension);
        int layoutDimension4 = obtainStyledAttributes.getLayoutDimension(R.styleable.RoundLayout_rndRightShadowLen, layoutDimension);
        int layoutDimension5 = obtainStyledAttributes.getLayoutDimension(R.styleable.RoundLayout_rndBottomShadowLen, layoutDimension);
        String string = obtainStyledAttributes.getString(R.styleable.RoundLayout_rndGradientColors);
        int layoutDimension6 = obtainStyledAttributes.getLayoutDimension(R.styleable.RoundLayout_rndGradientType, 0);
        float f = obtainStyledAttributes.getFloat(R.styleable.RoundLayout_rndGradientCenterX, 0.5f);
        float f2 = obtainStyledAttributes.getFloat(R.styleable.RoundLayout_rndGradientCenterY, 0.5f);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundLayout_rndGradientRadius, 0);
        int color2 = obtainStyledAttributes.getColor(R.styleable.RoundLayout_rndGradientStartColor, -1);
        int color3 = obtainStyledAttributes.getColor(R.styleable.RoundLayout_rndGradientCenterColor, -1);
        int color4 = obtainStyledAttributes.getColor(R.styleable.RoundLayout_rndGradientEndColor, -1);
        int i3 = color;
        int color5 = obtainStyledAttributes.getColor(R.styleable.RoundLayout_rndGradientOrientation, 6);
        int i4 = layoutDimension2;
        float f3 = obtainStyledAttributes.getFloat(R.styleable.RoundLayout_rndPressedRatio, 0.8f);
        int i5 = layoutDimension3;
        this.mCornerRadius = obtainStyledAttributes.getLayoutDimension(R.styleable.RoundLayout_rndCornerRadius, 0);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(R.styleable.RoundLayout_rndSolidColor);
        int i6 = layoutDimension4;
        int color6 = obtainStyledAttributes.getColor(R.styleable.RoundLayout_rndStrokeColor, 0);
        int i7 = layoutDimension5;
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundLayout_rndStrokeWidth, 0);
        float f4 = f;
        int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundLayout_rndStrokeDashWidth, 0);
        float f5 = f2;
        int dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundLayout_rndStrokeDashGap, 0);
        int i8 = dimensionPixelSize;
        this.shadowOffsetX = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundLayout_rndShadowOffsetX, 0);
        this.shadowOffsetY = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundLayout_rndShadowOffsetY, 0);
        obtainStyledAttributes.recycle();
        RoundDrawable roundDrawable = new RoundDrawable(colorStateList, string, f3);
        int i9 = this.mCornerRadius;
        if (i9 != -1) {
            roundDrawable.setCornerRadius((float) i9);
        }
        roundDrawable.setStroke(dimensionPixelSize2, color6, (float) dimensionPixelSize3, (float) dimensionPixelSize4);
        roundDrawable.setOrientation(RoundUtil.parseGradientOrientation(color5));
        int[] parseGradientColors = RoundUtil.parseGradientColors(color2, color3, color4);
        if (parseGradientColors != null && parseGradientColors.length > 1) {
            roundDrawable.setGradientColors(parseGradientColors);
        }
        roundDrawable.setGradientType(layoutDimension6);
        roundDrawable.setGradientRadius((float) i8);
        roundDrawable.setGradientCenter(f4, f5);
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        int i13 = i7;
        roundDrawable.setBoundsRect(new Rect(i10, i11, i12, i13));
        boolean z = i10 > 0 || i11 > 0 || i12 > 0 || i13 > 0;
        final int i14 = i10;
        final int i15 = i12;
        final int i16 = i11;
        final int i17 = i13;
        C80561 r10 = r0;
        final RoundDrawable roundDrawable2 = roundDrawable;
        int i18 = i12;
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        final boolean z2 = z;
        int i19 = i13;
        final int i20 = dimensionPixelSize2;
        C80561 r0 = new OnPreDrawListener() {
            public boolean onPreDraw() {
                if (RoundLayout.this.getMeasuredWidth() > 0 && RoundLayout.this.getMeasuredWidth() > 0) {
                    if (RoundLayout.this.mCornerRadius == -1) {
                        RoundLayout roundLayout = RoundLayout.this;
                        roundLayout.mCornerRadius = Math.min((roundLayout.getMeasuredWidth() - i14) - i15, (RoundLayout.this.getMeasuredHeight() - i16) - i17) / 2;
                        roundDrawable2.setCornerRadius((float) RoundLayout.this.mCornerRadius);
                    }
                    if (z2 && RoundLayout.this.mShadowRect == null) {
                        RoundLayout roundLayout2 = RoundLayout.this;
                        float f = (float) i14;
                        int i = i20;
                        roundLayout2.mShadowRect = new RectF(f + (((float) i) / 2.0f), ((float) i16) + (((float) i) / 2.0f), ((float) (roundLayout2.getMeasuredWidth() - i15)) - (((float) i20) / 2.0f), ((float) (RoundLayout.this.getMeasuredHeight() - i17)) - (((float) i20) / 2.0f));
                    }
                    RoundLayout.this.getViewTreeObserver().removeOnPreDrawListener(this);
                }
                return true;
            }
        };
        viewTreeObserver.addOnPreDrawListener(r10);
        setBackground(roundDrawable);
        if (z) {
            i2 = i18;
            i = i19;
            this.shadowRadius = Math.max(Math.max(i10, i11), Math.max(i2, i));
            this.mShadowPaint = RoundUtil.initShadowPaint(i3, this.shadowRadius, this.shadowOffsetX, this.shadowOffsetY);
            setLayerType(1, null);
        } else {
            i2 = i18;
            i = i19;
        }
        setPadding(i10 + getPaddingLeft(), i11 + getPaddingTop(), i2 + getPaddingRight(), i + getPaddingBottom());
    }

    public void setShadowColor(int i) {
        this.mShadowPaint.setShadowLayer((float) this.shadowRadius, (float) this.shadowOffsetX, (float) this.shadowOffsetY, i);
        invalidate();
    }

    public void draw(Canvas canvas) {
        RectF rectF = this.mShadowRect;
        if (rectF != null) {
            int i = this.mCornerRadius;
            canvas.drawRoundRect(rectF, (float) i, (float) i, this.mShadowPaint);
        }
        super.draw(canvas);
    }
}
