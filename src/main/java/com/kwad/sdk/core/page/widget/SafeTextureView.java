package com.kwad.sdk.core.page.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.TextureView;

public class SafeTextureView extends TextureView {
    public SafeTextureView(Context context) {
        super(context);
    }

    public SafeTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SafeTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public SafeTextureView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
