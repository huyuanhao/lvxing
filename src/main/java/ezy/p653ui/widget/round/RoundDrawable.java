package ezy.p653ui.widget.round;

import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;

/* renamed from: ezy.ui.widget.round.RoundDrawable */
public class RoundDrawable extends GradientDrawable {
    private Rect mBoundsRect;
    private int mFillColor;
    private int[] mFillGradientColors;
    private ColorStateList[] mGradientColorLists;
    private float mPressedRatio;
    private ColorStateList mSolidColor;

    public RoundDrawable(ColorStateList colorStateList, String str, float f) {
        this.mSolidColor = colorStateList;
        this.mPressedRatio = f;
        if (this.mSolidColor == null) {
            this.mSolidColor = ColorStateList.valueOf(0);
        }
        if (this.mSolidColor.isStateful()) {
            setSolidColors(this.mSolidColor);
        } else if (this.mPressedRatio > 1.0E-4f) {
            setSolidColors(RoundUtil.csl(this.mSolidColor.getDefaultColor(), this.mPressedRatio));
        } else {
            setColor(this.mSolidColor.getDefaultColor());
        }
        setGradientColors(RoundUtil.parseGradientColors(str));
    }

    public void setGradientColors(int[] iArr) {
        this.mFillGradientColors = iArr;
        if (iArr != null && iArr.length > 1) {
            this.mGradientColorLists = new ColorStateList[iArr.length];
            for (int i = 0; i < this.mGradientColorLists.length; i++) {
                this.mGradientColorLists[i] = RoundUtil.csl(iArr[i], this.mPressedRatio);
            }
            setColors(iArr);
        }
    }

    public void setBoundsRect(Rect rect) {
        this.mBoundsRect = rect;
    }

    public void setBounds(int i, int i2, int i3, int i4) {
        Rect rect = this.mBoundsRect;
        if (rect != null) {
            super.setBounds(i + rect.left, i2 + this.mBoundsRect.top, i3 - this.mBoundsRect.right, i4 - this.mBoundsRect.bottom);
        } else {
            super.setBounds(i, i2, i3, i4);
        }
    }

    private void setSolidColors(ColorStateList colorStateList) {
        this.mSolidColor = colorStateList;
        setColor(colorStateList.getDefaultColor());
    }

    public void setColor(int i) {
        this.mFillColor = i;
        super.setColor(i);
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        if (this.mGradientColorLists == null || this.mFillGradientColors == null) {
            ColorStateList colorStateList = this.mSolidColor;
            if (colorStateList != null) {
                int colorForState = colorStateList.getColorForState(iArr, 0);
                if (this.mFillColor != colorForState) {
                    setColor(colorForState);
                    return true;
                }
            }
            return false;
        }
        int i = 0;
        while (true) {
            ColorStateList[] colorStateListArr = this.mGradientColorLists;
            if (i < colorStateListArr.length) {
                this.mFillGradientColors[i] = colorStateListArr[i].getColorForState(iArr, 0);
                i++;
            } else {
                setColors(this.mFillGradientColors);
                return true;
            }
        }
    }

    public boolean isStateful() {
        if (!super.isStateful()) {
            ColorStateList colorStateList = this.mSolidColor;
            if (colorStateList == null || !colorStateList.isStateful()) {
                return false;
            }
        }
        return true;
    }
}
