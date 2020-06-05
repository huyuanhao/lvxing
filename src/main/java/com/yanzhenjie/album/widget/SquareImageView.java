package com.yanzhenjie.album.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;

public class SquareImageView extends AppCompatImageView {
    /* renamed from: a */
    private Configuration f26346a;

    public SquareImageView(Context context) {
        this(context, null, 0);
    }

    public SquareImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SquareImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f26346a = getResources().getConfiguration();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3 = this.f26346a.orientation;
        if (i3 == 1) {
            super.onMeasure(i, i);
        } else if (i3 == 2) {
            super.onMeasure(i2, i2);
        } else {
            throw new AssertionError("This should not be the case.");
        }
    }
}
