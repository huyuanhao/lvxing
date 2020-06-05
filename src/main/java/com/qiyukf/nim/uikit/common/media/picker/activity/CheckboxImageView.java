package com.qiyukf.nim.uikit.common.media.picker.activity;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.C6029d;
import com.qiyukf.unicorn.api.UICustomization;

public class CheckboxImageView extends ImageView {
    /* renamed from: a */
    private int[] f17508a;
    /* renamed from: b */
    private boolean f17509b;

    public CheckboxImageView(Context context) {
        super(context);
        m22261a();
    }

    public CheckboxImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m22261a();
    }

    public CheckboxImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m22261a();
    }

    public CheckboxImageView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m22261a();
    }

    /* renamed from: a */
    private void m22261a() {
        setBackgroundResource(C5961R.C5962drawable.ysf_circle_shape_bg);
        this.f17508a = new int[2];
        this.f17508a[0] = getResources().getColor(C5961R.color.ysf_picker_unselected_color);
        this.f17508a[1] = getResources().getColor(C5961R.color.ysf_theme_color_normal);
        UICustomization uICustomization = C6029d.m24045e().uiCustomization;
        if (uICustomization != null && uICustomization.buttonBackgroundColorList > 0) {
            try {
                ColorStateList colorStateList = getResources().getColorStateList(uICustomization.buttonBackgroundColorList);
                if (colorStateList != null) {
                    this.f17508a[1] = colorStateList.getColorForState(View.ENABLED_STATE_SET, colorStateList.getDefaultColor());
                }
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder("ui customization error: ");
                sb.append(e.toString());
                C5264a.m21622c("CIV", sb.toString());
            }
        }
    }

    /* renamed from: a */
    public final void mo27467a(boolean z) {
        this.f17509b = z;
        int i = z ? this.f17508a[1] : this.f17508a[0];
        if (getBackground() instanceof GradientDrawable) {
            ((GradientDrawable) getBackground()).setColor(i);
        } else if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i);
        }
        invalidate();
    }
}
