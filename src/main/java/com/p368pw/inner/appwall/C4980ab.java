package com.p368pw.inner.appwall;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import androidx.core.content.ContextCompat;
import com.p368pw.inner.C5233e;
import com.p368pw.inner.base.p387d.C5196m;

/* renamed from: com.pw.inner.appwall.ab */
public class C4980ab extends FrameLayout {
    /* renamed from: a */
    private ImageView f16203a;
    /* renamed from: b */
    private Drawable f16204b;

    public C4980ab(Context context) {
        this(context, null);
    }

    public C4980ab(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C4980ab(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f16203a = new ImageView(context);
        this.f16203a.setScaleType(ScaleType.CENTER_CROP);
        addView(this.f16203a, new LayoutParams(-1, -1));
        setBackgroundColor(-1);
    }

    /* renamed from: a */
    public void mo26352a(int i, int i2) {
        if (i != 0) {
            this.f16204b = ContextCompat.getDrawable(getContext(), i);
            Drawable drawable = this.f16204b;
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), this.f16204b.getMinimumHeight());
            }
        }
    }

    /* renamed from: a */
    public void mo26353a(String str, String str2) {
        C5196m.m21445a(C5233e.m21559b(), str, this.f16203a);
    }
}
