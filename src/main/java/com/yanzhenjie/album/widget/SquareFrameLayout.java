package com.yanzhenjie.album.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class SquareFrameLayout extends FrameLayout {
    /* renamed from: a */
    private Configuration f26345a;

    public SquareFrameLayout(Context context) {
        this(context, null, 0);
    }

    public SquareFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SquareFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f26345a = getResources().getConfiguration();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3 = this.f26345a.orientation;
        if (i3 == 1) {
            super.onMeasure(i, i);
        } else if (i3 == 2) {
            super.onMeasure(i2, i2);
        } else {
            throw new AssertionError("This should not be the case.");
        }
    }
}
