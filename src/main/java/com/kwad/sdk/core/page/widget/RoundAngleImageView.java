package com.kwad.sdk.core.page.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.ImageView;

public class RoundAngleImageView extends ImageView {
    /* renamed from: a */
    private Path f14041a;
    /* renamed from: b */
    private int f14042b;
    /* renamed from: c */
    private int f14043c;
    /* renamed from: d */
    private int f14044d;
    /* renamed from: e */
    private int f14045e;

    public RoundAngleImageView(Context context) {
        this(context, null);
    }

    public RoundAngleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAngleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14041a = new Path();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.f14042b == 0 && this.f14045e == 0 && this.f14043c == 0 && this.f14044d == 0) {
            super.onDraw(canvas);
            return;
        }
        if (VERSION.SDK_INT < 18) {
            setLayerType(1, null);
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int max = Math.max(this.f14042b, this.f14043c) + Math.max(this.f14045e, this.f14044d);
        if (measuredWidth >= Math.max(this.f14042b, this.f14045e) + Math.max(this.f14043c, this.f14044d) && measuredHeight > max) {
            this.f14041a.reset();
            this.f14041a.moveTo((float) this.f14042b, 0.0f);
            this.f14041a.lineTo((float) (measuredWidth - this.f14043c), 0.0f);
            float f = (float) measuredWidth;
            this.f14041a.quadTo(f, 0.0f, f, (float) this.f14043c);
            this.f14041a.lineTo(f, (float) (measuredHeight - this.f14044d));
            float f2 = (float) measuredHeight;
            this.f14041a.quadTo(f, f2, (float) (measuredWidth - this.f14044d), f2);
            this.f14041a.lineTo((float) this.f14045e, f2);
            this.f14041a.quadTo(0.0f, f2, 0.0f, (float) (measuredHeight - this.f14045e));
            this.f14041a.lineTo(0.0f, (float) this.f14042b);
            this.f14041a.quadTo(0.0f, 0.0f, (float) this.f14042b, 0.0f);
            canvas.clipPath(this.f14041a);
        }
        super.onDraw(canvas);
    }

    public void setRadius(int i) {
        this.f14042b = i;
        this.f14045e = i;
        this.f14043c = i;
        this.f14044d = i;
    }
}
