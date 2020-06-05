package p706pl.droidsonroids.gif;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import java.io.IOException;

/* renamed from: pl.droidsonroids.gif.GifTextView */
public class GifTextView extends TextView {
    /* renamed from: a */
    private boolean f29242a;

    public GifTextView(Context context) {
        super(context);
    }

    public GifTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m37397a(attributeSet, 0, 0);
    }

    public GifTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m37397a(attributeSet, i, 0);
    }

    /* renamed from: a */
    private void m37397a(AttributeSet attributeSet, int i, int i2) {
        if (attributeSet != null) {
            String str = "http://schemas.android.com/apk/res/android";
            Drawable a = m37396a(attributeSet.getAttributeResourceValue(str, "drawableLeft", 0));
            Drawable a2 = m37396a(attributeSet.getAttributeResourceValue(str, "drawableTop", 0));
            Drawable a3 = m37396a(attributeSet.getAttributeResourceValue(str, "drawableRight", 0));
            Drawable a4 = m37396a(attributeSet.getAttributeResourceValue(str, "drawableBottom", 0));
            Drawable a5 = m37396a(attributeSet.getAttributeResourceValue(str, "drawableStart", 0));
            Drawable a6 = m37396a(attributeSet.getAttributeResourceValue(str, "drawableEnd", 0));
            if (VERSION.SDK_INT >= 17) {
                if (getLayoutDirection() == 0) {
                    if (a5 == null) {
                        a5 = a;
                    }
                    if (a6 == null) {
                        a6 = a3;
                    }
                } else {
                    if (a5 == null) {
                        a5 = a3;
                    }
                    if (a6 == null) {
                        a6 = a;
                    }
                }
                setCompoundDrawablesRelativeWithIntrinsicBounds(a5, a2, a6, a4);
                setCompoundDrawablesWithIntrinsicBounds(a, a2, a3, a4);
            } else {
                setCompoundDrawablesWithIntrinsicBounds(a, a2, a3, a4);
            }
            setBackgroundInternal(m37396a(attributeSet.getAttributeResourceValue(str, "background", 0)));
        }
        this.f29242a = GifViewUtils.m37438a((View) this, attributeSet, i, i2);
    }

    private void setBackgroundInternal(Drawable drawable) {
        if (VERSION.SDK_INT >= 16) {
            setBackground(drawable);
        } else {
            setBackgroundDrawable(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        setBackgroundInternal(m37396a(i));
    }

    /* renamed from: a */
    private Drawable m37396a(int i) {
        if (i == 0) {
            return null;
        }
        Resources resources = getResources();
        if (!isInEditMode()) {
            if ("drawable".equals(resources.getResourceTypeName(i))) {
                try {
                    return new GifDrawable(resources, i);
                } catch (NotFoundException | IOException unused) {
                }
            }
        }
        if (VERSION.SDK_INT >= 21) {
            return resources.getDrawable(i, getContext().getTheme());
        }
        return resources.getDrawable(i);
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        setCompoundDrawablesRelativeWithIntrinsicBounds(m37396a(i), m37396a(i2), m37396a(i3), m37396a(i4));
    }

    public void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        setCompoundDrawablesWithIntrinsicBounds(m37396a(i), m37396a(i2), m37396a(i3), m37396a(i4));
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m37398a(getCompoundDrawables());
        if (VERSION.SDK_INT >= 17) {
            m37398a(getCompoundDrawablesRelative());
        }
    }

    /* renamed from: a */
    private void m37398a(Drawable[] drawableArr) {
        for (Drawable drawable : drawableArr) {
            if (drawable != null) {
                drawable.setVisible(false, false);
            }
        }
    }

    public Parcelable onSaveInstanceState() {
        Drawable[] drawableArr = new Drawable[7];
        if (this.f29242a) {
            Drawable[] compoundDrawables = getCompoundDrawables();
            System.arraycopy(compoundDrawables, 0, drawableArr, 0, compoundDrawables.length);
            if (VERSION.SDK_INT >= 17) {
                Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
                drawableArr[4] = compoundDrawablesRelative[0];
                drawableArr[5] = compoundDrawablesRelative[2];
            }
            drawableArr[6] = getBackground();
        }
        return new GifViewSavedState(super.onSaveInstanceState(), drawableArr);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof GifViewSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        GifViewSavedState gifViewSavedState = (GifViewSavedState) parcelable;
        super.onRestoreInstanceState(gifViewSavedState.getSuperState());
        Drawable[] compoundDrawables = getCompoundDrawables();
        gifViewSavedState.mo41210a(compoundDrawables[0], 0);
        gifViewSavedState.mo41210a(compoundDrawables[1], 1);
        gifViewSavedState.mo41210a(compoundDrawables[2], 2);
        gifViewSavedState.mo41210a(compoundDrawables[3], 3);
        if (VERSION.SDK_INT >= 17) {
            Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
            gifViewSavedState.mo41210a(compoundDrawablesRelative[0], 4);
            gifViewSavedState.mo41210a(compoundDrawablesRelative[2], 5);
        }
        gifViewSavedState.mo41210a(getBackground(), 6);
    }

    public void setFreezesAnimation(boolean z) {
        this.f29242a = z;
    }
}
