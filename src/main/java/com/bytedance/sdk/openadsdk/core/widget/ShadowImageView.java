package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

public class ShadowImageView extends ImageView {
    /* renamed from: a */
    private Paint f8239a;
    /* renamed from: b */
    private RectF f8240b;

    public ShadowImageView(Context context) {
        super(context);
        m10749a();
    }

    public ShadowImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m10749a();
    }

    public ShadowImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10749a();
    }

    /* renamed from: a */
    private void m10749a() {
        this.f8239a = new Paint();
        this.f8239a.setStyle(Style.FILL_AND_STROKE);
        this.f8239a.setColor(Color.parseColor("#99333333"));
        this.f8239a.setAntiAlias(true);
        this.f8239a.setStrokeWidth(0.0f);
        this.f8240b = new RectF();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f8240b.right != ((float) getMeasuredWidth()) || this.f8240b.bottom != ((float) getMeasuredHeight())) {
            this.f8240b.set(0.0f, 0.0f, (float) getMeasuredWidth(), (float) getMeasuredHeight());
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        RectF rectF = this.f8240b;
        canvas.drawRoundRect(rectF, rectF.right / 2.0f, this.f8240b.bottom / 2.0f, this.f8239a);
        super.onDraw(canvas);
    }
}
