package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;

public class ShadowTextView extends TextView {
    /* renamed from: a */
    private Paint f8241a;
    /* renamed from: b */
    private RectF f8242b;
    /* renamed from: c */
    private int f8243c;

    public ShadowTextView(Context context) {
        this(context, null);
    }

    public ShadowTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShadowTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8243c = 0;
        m10750a();
    }

    /* renamed from: a */
    private void m10750a() {
        setTextColor(-1);
        this.f8241a = new Paint();
        this.f8241a.setStyle(Style.FILL_AND_STROKE);
        this.f8241a.setColor(Color.parseColor("#99333333"));
        this.f8241a.setAntiAlias(true);
        this.f8241a.setStrokeWidth(0.0f);
        this.f8242b = new RectF();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth <= 0 || measuredHeight <= 0) {
            this.f8242b.set(0.0f, 0.0f, 0.0f, 0.0f);
            return;
        }
        this.f8243c = (int) getPaint().measureText("00");
        int i3 = this.f8243c;
        if (measuredWidth < i3) {
            measuredWidth = i3;
        }
        int i4 = measuredWidth + ((measuredHeight / 2) * 2);
        setMeasuredDimension(i4, measuredHeight);
        this.f8242b.set(0.0f, 0.0f, (float) i4, (float) measuredHeight);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        RectF rectF = this.f8242b;
        canvas.drawRoundRect(rectF, rectF.bottom / 2.0f, this.f8242b.bottom / 2.0f, this.f8241a);
        canvas.translate((this.f8242b.right / 2.0f) - (getPaint().measureText(getText().toString()) / 2.0f), 0.0f);
        super.onDraw(canvas);
    }
}
