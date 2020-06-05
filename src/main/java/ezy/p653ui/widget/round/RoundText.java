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
import androidx.appcompat.widget.AppCompatTextView;
import reezy.lib.common.R;

/* renamed from: ezy.ui.widget.round.RoundText */
public final class RoundText extends AppCompatTextView {
    private static final int DEFAULT_SHADOW_COLOR = -1250068;
    private int gradientCenterColor;
    /* access modifiers changed from: private */
    public int mCornerRadius;
    public Paint mShadowPaint;
    /* access modifiers changed from: private */
    public RectF mShadowRect;
    /* access modifiers changed from: private */
    /* renamed from: rd */
    public RoundDrawable f27325rd;

    public RoundText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundText(Context context, AttributeSet attributeSet, int i) {
        RoundText roundText;
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RoundText);
        int color = obtainStyledAttributes.getColor(R.styleable.RoundText_rndShadowColor, DEFAULT_SHADOW_COLOR);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(R.styleable.RoundText_rndShadowLen, 0);
        int layoutDimension2 = obtainStyledAttributes.getLayoutDimension(R.styleable.RoundText_rndLeftShadowLen, layoutDimension);
        int layoutDimension3 = obtainStyledAttributes.getLayoutDimension(R.styleable.RoundText_rndTopShadowLen, layoutDimension);
        int layoutDimension4 = obtainStyledAttributes.getLayoutDimension(R.styleable.RoundText_rndRightShadowLen, layoutDimension);
        int layoutDimension5 = obtainStyledAttributes.getLayoutDimension(R.styleable.RoundText_rndBottomShadowLen, layoutDimension);
        String string = obtainStyledAttributes.getString(R.styleable.RoundText_rndGradientColors);
        int layoutDimension6 = obtainStyledAttributes.getLayoutDimension(R.styleable.RoundText_rndGradientType, 0);
        float f = obtainStyledAttributes.getFloat(R.styleable.RoundText_rndGradientCenterX, 0.5f);
        float f2 = obtainStyledAttributes.getFloat(R.styleable.RoundText_rndGradientCenterY, 0.5f);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundText_rndGradientRadius, 0);
        int color2 = obtainStyledAttributes.getColor(R.styleable.RoundText_rndGradientStartColor, -1);
        this.gradientCenterColor = obtainStyledAttributes.getColor(R.styleable.RoundText_rndGradientCenterColor, -1);
        int color3 = obtainStyledAttributes.getColor(R.styleable.RoundText_rndGradientEndColor, -1);
        int color4 = obtainStyledAttributes.getColor(R.styleable.RoundText_rndGradientOrientation, 6);
        int i2 = color;
        float f3 = obtainStyledAttributes.getFloat(R.styleable.RoundText_rndPressedRatio, 0.8f);
        int i3 = layoutDimension2;
        this.mCornerRadius = obtainStyledAttributes.getLayoutDimension(R.styleable.RoundText_rndCornerRadius, 0);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(R.styleable.RoundText_rndSolidColor);
        int i4 = layoutDimension3;
        int color5 = obtainStyledAttributes.getColor(R.styleable.RoundText_rndStrokeColor, 0);
        int i5 = layoutDimension4;
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundText_rndStrokeWidth, 0);
        int i6 = layoutDimension5;
        int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundText_rndStrokeDashWidth, 0);
        float f4 = f;
        int dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundText_rndStrokeDashGap, 0);
        float f5 = f2;
        int dimensionPixelSize5 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundText_rndShadowOffsetX, 0);
        int dimensionPixelSize6 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundText_rndShadowOffsetY, 0);
        obtainStyledAttributes.recycle();
        setMaxLines(1);
        setGravity(17);
        this.f27325rd = new RoundDrawable(colorStateList, string, f3);
        int i7 = this.mCornerRadius;
        if (i7 != -1) {
            this.f27325rd.setCornerRadius((float) i7);
        }
        this.f27325rd.setStroke(dimensionPixelSize2, color5, (float) dimensionPixelSize3, (float) dimensionPixelSize4);
        this.f27325rd.setOrientation(RoundUtil.parseGradientOrientation(color4));
        int[] parseGradientColors = RoundUtil.parseGradientColors(color2, this.gradientCenterColor, color3);
        if (parseGradientColors != null && parseGradientColors.length > 1) {
            this.f27325rd.setGradientColors(parseGradientColors);
        }
        this.f27325rd.setGradientType(layoutDimension6);
        this.f27325rd.setGradientRadius((float) dimensionPixelSize);
        this.f27325rd.setGradientCenter(f4, f5);
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        int i11 = i6;
        this.f27325rd.setBoundsRect(new Rect(i8, i9, i10, i11));
        boolean z = i8 > 0 || i9 > 0 || i10 > 0 || i11 > 0;
        setBackground(this.f27325rd);
        final int i12 = i8;
        final int i13 = i10;
        final int i14 = i9;
        int i15 = dimensionPixelSize6;
        int i16 = dimensionPixelSize5;
        final int i17 = i11;
        int i18 = i15;
        C80571 r8 = r0;
        final boolean z2 = z;
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        final int i19 = dimensionPixelSize2;
        C80571 r0 = new OnPreDrawListener() {
            public boolean onPreDraw() {
                if (RoundText.this.getMeasuredWidth() > 0 && RoundText.this.getMeasuredHeight() > 0) {
                    if (RoundText.this.mCornerRadius == -1) {
                        RoundText roundText = RoundText.this;
                        roundText.mCornerRadius = Math.min((roundText.getMeasuredWidth() - i12) - i13, (RoundText.this.getMeasuredHeight() - i14) - i17) / 2;
                        RoundText.this.f27325rd.setCornerRadius((float) RoundText.this.mCornerRadius);
                    }
                    if (z2 && RoundText.this.mShadowRect == null) {
                        RoundText roundText2 = RoundText.this;
                        float f = (float) i12;
                        int i = i19;
                        roundText2.mShadowRect = new RectF(f + (((float) i) / 2.0f), ((float) i14) + (((float) i) / 2.0f), ((float) (roundText2.getMeasuredWidth() - i13)) - (((float) i19) / 2.0f), ((float) (RoundText.this.getMeasuredHeight() - i17)) - (((float) i19) / 2.0f));
                    }
                    RoundText.this.getViewTreeObserver().removeOnPreDrawListener(this);
                }
                return true;
            }
        };
        viewTreeObserver.addOnPreDrawListener(r8);
        if (z) {
            roundText = this;
            roundText.mShadowPaint = RoundUtil.initShadowPaint(i2, Math.max(Math.max(i8, i9), Math.max(i10, i11)), dimensionPixelSize5, i18);
            roundText.setLayerType(1, null);
        } else {
            roundText = this;
        }
        roundText.setPadding(i8 + getPaddingLeft(), i9 + getPaddingTop(), i10 + getPaddingRight(), i11 + getPaddingBottom());
    }

    public void setBGColor(int i, int i2) {
        int[] parseGradientColors = RoundUtil.parseGradientColors(i, i2);
        if (parseGradientColors != null && parseGradientColors.length > 1) {
            this.f27325rd.setGradientColors(parseGradientColors);
        }
        setBackground(this.f27325rd);
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
