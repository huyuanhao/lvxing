package com.p368pw.inner.appwall;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.util.AttributeSet;
import android.view.View;

/* renamed from: com.pw.inner.appwall.z */
public class C5068z extends View {
    /* renamed from: a */
    private Paint f16574a;
    /* renamed from: b */
    private int f16575b;
    /* renamed from: c */
    private int f16576c;

    public C5068z(Context context) {
        this(context, null);
    }

    public C5068z(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C5068z(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f16574a = new Paint();
        this.f16574a.setAntiAlias(true);
        this.f16575b = Color.parseColor("#FFFE7A3F");
        this.f16576c = Color.parseColor("#FFFFFFFF");
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f16574a.setStrokeCap(Cap.ROUND);
        this.f16574a.setColor(this.f16575b);
        this.f16574a.setStrokeWidth((float) getHeight());
        canvas.drawLine((float) (getHeight() / 2), (float) (getHeight() / 2), (float) (getWidth() - (getHeight() / 2)), (float) (getHeight() / 2), this.f16574a);
        this.f16574a.reset();
        this.f16574a.setAntiAlias(true);
        this.f16574a.setColor(this.f16576c);
        canvas.drawCircle((float) (getWidth() - (getHeight() / 2)), (float) (getHeight() / 2), (float) ((getHeight() / 2) - (getHeight() / 10)), this.f16574a);
    }
}
