package com.jiayouya.travel.common.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ReplacementSpan;
import android.util.TypedValue;
import com.jiayouya.travel.R;

/* renamed from: com.jiayouya.travel.common.widget.c */
public class RoundedBackgroundSpan extends ReplacementSpan {
    /* renamed from: a */
    private Context f9676a;
    /* renamed from: b */
    private int f9677b;
    /* renamed from: c */
    private String f9678c;
    /* renamed from: d */
    private float f9679d;
    /* renamed from: e */
    private float f9680e;
    /* renamed from: f */
    private float f9681f;
    /* renamed from: g */
    private float f9682g;
    /* renamed from: h */
    private float f9683h;
    /* renamed from: i */
    private int f9684i;
    /* renamed from: j */
    private Paint f9685j;
    /* renamed from: k */
    private Paint f9686k;

    public RoundedBackgroundSpan(Context context, int i, String str, int i2) {
        if (!TextUtils.isEmpty(str)) {
            this.f9684i = i2;
            m13116a(context, i, str);
            this.f9680e = m13114a(str);
            m13115a();
        }
    }

    /* renamed from: a */
    private void m13115a() {
        this.f9685j = new Paint();
        this.f9685j.setColor(this.f9676a.getResources().getColor(this.f9677b));
        this.f9685j.setStyle(Style.FILL);
        this.f9685j.setAntiAlias(true);
        this.f9686k = new TextPaint();
        this.f9686k.setColor(this.f9676a.getResources().getColor(this.f9684i));
        this.f9686k.setTextSize(this.f9683h);
        this.f9686k.setAntiAlias(true);
        this.f9686k.setTextAlign(Align.CENTER);
    }

    /* renamed from: a */
    private void m13116a(Context context, int i, String str) {
        this.f9676a = context.getApplicationContext();
        this.f9677b = i;
        this.f9678c = str;
        this.f9679d = TypedValue.applyDimension(1, 14.0f, this.f9676a.getResources().getDisplayMetrics());
        this.f9682g = TypedValue.applyDimension(1, 2.0f, this.f9676a.getResources().getDisplayMetrics());
        this.f9681f = TypedValue.applyDimension(1, 3.0f, this.f9676a.getResources().getDisplayMetrics());
        this.f9683h = TypedValue.applyDimension(2, 9.0f, this.f9676a.getResources().getDisplayMetrics());
        if (this.f9684i == 0) {
            this.f9684i = R.color.c333333;
        }
    }

    /* renamed from: a */
    private float m13114a(String str) {
        if (str.length() <= 1) {
            return this.f9679d;
        }
        Rect rect = new Rect();
        Paint paint = new Paint();
        paint.setTextSize(this.f9683h);
        paint.getTextBounds(str, 0, str.length(), rect);
        return ((float) rect.width()) + (TypedValue.applyDimension(1, 4.0f, this.f9676a.getResources().getDisplayMetrics()) * 2.0f);
    }

    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, FontMetricsInt fontMetricsInt) {
        return (int) (this.f9680e + this.f9682g);
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Paint paint2 = new Paint();
        paint2.setColor(this.f9676a.getResources().getColor(this.f9677b));
        paint2.setStyle(Style.FILL);
        paint2.setAntiAlias(true);
        FontMetrics fontMetrics = paint.getFontMetrics();
        float f2 = ((float) i4) + (((fontMetrics.descent - fontMetrics.ascent) - this.f9679d) / 2.0f) + fontMetrics.ascent;
        RectF rectF = new RectF(f, f2, this.f9680e + f, this.f9679d + f2);
        float f3 = this.f9681f;
        canvas.drawRoundRect(rectF, f3, f3, paint2);
        TextPaint textPaint = new TextPaint();
        textPaint.setColor(this.f9676a.getResources().getColor(this.f9684i));
        textPaint.setFakeBoldText(true);
        textPaint.setTextSize(this.f9683h);
        textPaint.setAntiAlias(true);
        textPaint.setTextAlign(Align.CENTER);
        FontMetrics fontMetrics2 = textPaint.getFontMetrics();
        canvas.drawText(this.f9678c, f + (this.f9680e / 2.0f), (f2 + ((this.f9679d - (fontMetrics2.bottom - fontMetrics2.top)) / 2.0f)) - fontMetrics2.top, textPaint);
    }
}
