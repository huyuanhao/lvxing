package com.yanzhenjie.album.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class SquareRelativeLayout extends RelativeLayout {
    /* renamed from: a */
    private Configuration f26347a;

    public SquareRelativeLayout(Context context) {
        this(context, null, 0);
    }

    public SquareRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SquareRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f26347a = getResources().getConfiguration();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3 = this.f26347a.orientation;
        if (i3 == 1) {
            super.onMeasure(i, i);
        } else if (i3 == 2) {
            super.onMeasure(i2, i2);
        } else {
            throw new AssertionError("This should not be the case.");
        }
    }
}
