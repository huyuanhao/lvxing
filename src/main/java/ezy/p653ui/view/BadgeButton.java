package ezy.p653ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import ezy.library.badgebutton.R;

/* renamed from: ezy.ui.view.BadgeButton */
public final class BadgeButton extends TextView {
    private BadgeDrawable mBadgeDrawable;

    /* renamed from: ezy.ui.view.BadgeButton$BadgeDrawable */
    private static class BadgeDrawable extends GradientDrawable {
        private int mHeight = 0;
        private boolean mIsVisible;
        private TextPaint mPaint = new TextPaint(1);
        private String mText;

        public BadgeDrawable(int i, int i2) {
            setColor(i2);
            this.mPaint.setColor(-1);
            this.mPaint.setTextAlign(Align.CENTER);
            this.mPaint.setTextSize(((float) i) * 0.8f);
            this.mHeight = i;
        }

        /* access modifiers changed from: 0000 */
        public void layout(int i, int i2, int i3) {
            Rect bounds = getBounds();
            bounds.offsetTo(Math.min(i - (bounds.width() / 2), (i3 - bounds.width()) - ((int) (((float) this.mHeight) * 0.2f))), Math.max(0, i2 - (bounds.height() / 2)));
            setBounds(bounds);
        }

        /* access modifiers changed from: 0000 */
        public void resize(int i, int i2) {
            Rect bounds = getBounds();
            setBounds(bounds.left, bounds.top, bounds.left + i, bounds.top + i2);
            invalidateSelf();
        }

        public void setText(String str) {
            this.mText = str;
            if (TextUtils.isEmpty(this.mText)) {
                int i = (int) (((double) this.mHeight) * 0.65d);
                resize(i, i);
                return;
            }
            double measureText = (double) this.mPaint.measureText(this.mText);
            int i2 = this.mHeight;
            resize(Math.max((int) (measureText + (((double) i2) * 0.4d)), i2), this.mHeight);
        }

        public void setVisible(boolean z) {
            if (this.mIsVisible != z) {
                invalidateSelf();
            }
            this.mIsVisible = z;
        }

        /* access modifiers changed from: protected */
        public void onBoundsChange(Rect rect) {
            super.onBoundsChange(rect);
            setCornerRadius(((float) getBounds().height()) / 2.0f);
        }

        public void draw(Canvas canvas) {
            if (this.mIsVisible) {
                super.draw(canvas);
                if (!TextUtils.isEmpty(this.mText)) {
                    canvas.drawText(this.mText, getBounds().exactCenterX(), getBounds().exactCenterY() - ((this.mPaint.descent() + this.mPaint.ascent()) / 2.0f), this.mPaint);
                }
            }
        }
    }

    public BadgeButton(Context context) {
        this(context, null);
    }

    public BadgeButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BadgeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BadgeButton);
        String string = obtainStyledAttributes.getString(R.styleable.BadgeButton_btnBadgeText);
        int color = obtainStyledAttributes.getColor(R.styleable.BadgeButton_btnBadgeColor, -49023);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BadgeButton_btnBadgeHeight, (int) (getResources().getDisplayMetrics().density * 12.0f));
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.BadgeButton_btnBadgeVisible, false);
        obtainStyledAttributes.recycle();
        this.mBadgeDrawable = new BadgeDrawable(dimensionPixelSize, color);
        this.mBadgeDrawable.setVisible(z);
        this.mBadgeDrawable.setText(string);
        setIcon(getCompoundDrawables()[1]);
    }

    public BadgeButton setIcon(Drawable drawable) {
        if (drawable != null && drawable.getBounds().isEmpty()) {
            drawable.setBounds(0, 0, drawable.getIntrinsicHeight(), drawable.getIntrinsicHeight());
        }
        Drawable[] compoundDrawables = getCompoundDrawables();
        setCompoundDrawables(compoundDrawables[0], drawable, compoundDrawables[2], compoundDrawables[3]);
        return this;
    }

    public void setText(CharSequence charSequence, BufferType bufferType) {
        super.setText(charSequence, bufferType);
    }

    public BadgeButton setBadgeText(String str) {
        this.mBadgeDrawable.setText(str);
        return this;
    }

    public BadgeButton setBadgeVisible(boolean z) {
        this.mBadgeDrawable.setVisible(z);
        return this;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        if (getCompoundDrawables()[1] != null) {
            this.mBadgeDrawable.layout((getCompoundDrawables()[1].getIntrinsicWidth() + measuredWidth) / 2, getPaddingTop(), measuredWidth);
        } else {
            this.mBadgeDrawable.layout((((int) getLayout().getLineWidth(0)) + measuredWidth) / 2, getPaddingTop(), measuredWidth);
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.mBadgeDrawable.draw(canvas);
    }
}
