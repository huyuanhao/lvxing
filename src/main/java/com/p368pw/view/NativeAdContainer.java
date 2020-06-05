package com.p368pw.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

/* renamed from: com.pw.view.NativeAdContainer */
public class NativeAdContainer extends com.p522qq.p523e.ads.nativ.widget.NativeAdContainer {
    public boolean allowAddView = true;

    public NativeAdContainer(Context context) {
        super(context);
    }

    public NativeAdContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NativeAdContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void addView(View view) {
        if (this.allowAddView) {
            super.addView(view);
        }
    }

    public void addView(View view, int i) {
        if (this.allowAddView) {
            super.addView(view, i);
        }
    }

    public void addView(View view, int i, int i2) {
        if (this.allowAddView) {
            super.addView(view, i, i2);
        }
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        if (this.allowAddView) {
            super.addView(view, i, layoutParams);
        }
    }

    public void addView(View view, LayoutParams layoutParams) {
        if (this.allowAddView) {
            super.addView(view, layoutParams);
        }
    }

    /* access modifiers changed from: protected */
    public boolean addViewInLayout(View view, int i, LayoutParams layoutParams) {
        if (!this.allowAddView) {
            return false;
        }
        return super.addViewInLayout(view, i, layoutParams);
    }

    /* access modifiers changed from: protected */
    public boolean addViewInLayout(View view, int i, LayoutParams layoutParams, boolean z) {
        if (!this.allowAddView) {
            return false;
        }
        return super.addViewInLayout(view, i, layoutParams, z);
    }
}
