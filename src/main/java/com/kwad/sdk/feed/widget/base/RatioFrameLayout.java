package com.kwad.sdk.feed.widget.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.kwad.sdk.core.p319c.C4065b;

public class RatioFrameLayout extends FrameLayout {
    /* renamed from: a */
    private float f14491a;

    public RatioFrameLayout(Context context) {
        this(context, null);
    }

    public RatioFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RatioFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14491a = 0.0f;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.f14491a != 0.0f) {
            int size = MeasureSpec.getSize(i);
            StringBuilder sb = new StringBuilder();
            sb.append("widthSize:");
            sb.append(size);
            C4065b.m16863a("RatioFrameLayout", sb.toString());
            i2 = MeasureSpec.makeMeasureSpec((int) (((float) size) * this.f14491a), 1073741824);
        }
        super.onMeasure(i, i2);
    }

    public void setRatio(float f) {
        this.f14491a = f;
    }
}
