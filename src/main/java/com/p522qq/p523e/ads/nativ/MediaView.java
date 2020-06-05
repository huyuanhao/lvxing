package com.p522qq.p523e.ads.nativ;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.p522qq.p523e.comm.managers.status.SDKStatus;
import com.p522qq.p523e.comm.util.GDTLogger;

/* renamed from: com.qq.e.ads.nativ.MediaView */
public final class MediaView extends FrameLayout {
    /* renamed from: a */
    private int f20051a;
    /* renamed from: b */
    private int f20052b;

    public MediaView(Context context) {
        super(context);
    }

    public MediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MediaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected|final */
    public final void onAttachedToWindow() {
        GDTLogger.m25258d("onAttachedToWindow");
        super.onAttachedToWindow();
        if (VERSION.SDK_INT >= 11 && !isHardwareAccelerated()) {
            GDTLogger.m25260e("Hardware acceleration is off");
        }
    }

    /* access modifiers changed from: protected|final */
    public final void onMeasure(int i, int i2) {
        if ((SDKStatus.getSDKVersionCode() == 11 || SDKStatus.getSDKVersionCode() == 12) && this.f20051a > 0 && this.f20052b > 0) {
            int size = MeasureSpec.getSize(i);
            int size2 = MeasureSpec.getSize(i2);
            int i3 = this.f20052b;
            int i4 = size * i3;
            int i5 = this.f20051a;
            if (i4 < i5 * size2 || size2 == 0) {
                int makeMeasureSpec = MeasureSpec.makeMeasureSpec(size, 1073741824);
                i2 = MeasureSpec.makeMeasureSpec((size * this.f20052b) / this.f20051a, 1073741824);
                i = makeMeasureSpec;
            } else {
                if (i3 * size > i5 * size2 || size == 0) {
                    size = (this.f20051a * size2) / this.f20052b;
                }
                i = MeasureSpec.makeMeasureSpec(size, 1073741824);
                i2 = MeasureSpec.makeMeasureSpec(size2, 1073741824);
            }
        }
        super.onMeasure(i, i2);
    }

    public final void setRatio(int i, int i2) {
        this.f20051a = i;
        this.f20052b = i2;
    }
}
