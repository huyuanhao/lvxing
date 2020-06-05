package com.qiyukf.unicorn.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.C6029d;
import com.qiyukf.unicorn.api.UICustomization;

public class StylableTextView extends TextView {
    /* renamed from: a */
    private ColorStateList f19819a;

    public StylableTextView(Context context) {
        super(context);
        m24978a(context);
    }

    public StylableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24978a(context);
    }

    public StylableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m24978a(context);
    }

    public StylableTextView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m24978a(context);
    }

    /* renamed from: a */
    private void m24977a() {
        Resources resources;
        int i;
        if (this.f19819a == null) {
            if (!isEnabled()) {
                resources = getResources();
                i = C5961R.color.ysf_theme_color_disabled;
            } else if (!isPressed()) {
                resources = getResources();
                i = C5961R.color.ysf_theme_color_normal;
            } else {
                resources = getResources();
                i = C5961R.color.ysf_theme_color_pressed;
            }
            int color = resources.getColor(i);
            if (getBackground() instanceof GradientDrawable) {
                ((GradientDrawable) getBackground()).setColor(color);
            } else if (getBackground() instanceof ShapeDrawable) {
                ((ShapeDrawable) getBackground()).getPaint().setColor(color);
            }
        }
        ColorStateList colorStateList = this.f19819a;
        if (colorStateList != null) {
            int colorForState = colorStateList.getColorForState(getDrawableState(), this.f19819a.getDefaultColor());
            if (getBackground() instanceof GradientDrawable) {
                ((GradientDrawable) getBackground()).setColor(colorForState);
            } else if (getBackground() instanceof ShapeDrawable) {
                ((ShapeDrawable) getBackground()).getPaint().setColor(colorForState);
            }
        }
    }

    /* renamed from: a */
    private void m24978a(Context context) {
        setBackgroundResource(C5961R.C5962drawable.ysf_theme_button_shape);
        setTextColor(-1);
        UICustomization uICustomization = C6029d.m24045e().uiCustomization;
        if (uICustomization == null) {
            this.f19819a = ContextCompat.getColorStateList(context, C5961R.color.ysf_button_color_state_list);
            m24977a();
            return;
        }
        try {
            if (uICustomization.buttonBackgroundColorList > 0) {
                this.f19819a = ContextCompat.getColorStateList(context, uICustomization.buttonBackgroundColorList);
                m24977a();
            }
            if (uICustomization.buttonTextColor != 0) {
                setTextColor(uICustomization.buttonTextColor);
            }
        } catch (Exception e) {
            e.printStackTrace();
            StringBuilder sb = new StringBuilder("ui customization error: ");
            sb.append(e.toString());
            C5264a.m21622c("STV", sb.toString());
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        m24977a();
    }
}
