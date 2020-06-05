package com.qiyukf.unicorn.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint.FontMetrics;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.qiyukf.unicorn.C5961R;

public class FileNameTextView extends View {
    /* renamed from: a */
    private TextPaint f19802a;
    /* renamed from: b */
    private StaticLayout f19803b;
    /* renamed from: c */
    private String f19804c;
    /* renamed from: d */
    private int f19805d;

    public FileNameTextView(Context context) {
        this(context, null);
    }

    public FileNameTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FileNameTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainAttributes = getResources().obtainAttributes(attributeSet, C5961R.styleable.FileNameTextView);
        this.f19804c = obtainAttributes.getString(C5961R.styleable.FileNameTextView_ysf_fntText);
        this.f19805d = obtainAttributes.getInt(C5961R.styleable.FileNameTextView_ysf_fntMaxLines, 1);
        int color = obtainAttributes.getColor(C5961R.styleable.FileNameTextView_ysf_fntTextColor, -7829368);
        float dimension = obtainAttributes.getDimension(C5961R.styleable.FileNameTextView_ysf_fntTextSize, (float) ((int) ((getResources().getDisplayMetrics().scaledDensity * 14.0f) + 0.5f)));
        obtainAttributes.recycle();
        this.f19802a = new TextPaint();
        this.f19802a.setAntiAlias(true);
        this.f19802a.setColor(color);
        this.f19802a.setTextSize(dimension);
    }

    /* renamed from: a */
    private StaticLayout m24974a(int i, String str) {
        int lastIndexOf = str.lastIndexOf(46);
        String substring = str.substring(lastIndexOf + 1);
        if (substring.length() > 6) {
            substring = substring.substring(substring.length() - 6);
            lastIndexOf = str.length() - 6;
        }
        String substring2 = str.substring(0, lastIndexOf);
        int i2 = 0;
        while (i2 < substring2.length()) {
            int i3 = i2 + 1;
            String substring3 = substring2.substring(0, i3);
            StringBuilder sb = new StringBuilder();
            sb.append(substring3);
            String str2 = "...";
            sb.append(str2);
            sb.append(substring);
            if (m24975a(sb.toString(), i).getLineCount() > this.f19805d) {
                String substring4 = substring2.substring(0, i2);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(substring4);
                sb2.append(str2);
                sb2.append(substring);
                return m24975a(sb2.toString(), i);
            }
            i2 = i3;
        }
        return null;
    }

    /* renamed from: a */
    private StaticLayout m24975a(String str, int i) {
        StaticLayout staticLayout = new StaticLayout(str, this.f19802a, i, Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        return staticLayout;
    }

    /* renamed from: a */
    public final void mo29556a(String str) {
        this.f19804c = str;
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (!TextUtils.isEmpty(this.f19804c)) {
            StaticLayout staticLayout = this.f19803b;
            if (staticLayout != null) {
                staticLayout.draw(canvas);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        StaticLayout staticLayout;
        int size = MeasureSpec.getSize(i);
        int mode = MeasureSpec.getMode(i);
        int size2 = MeasureSpec.getSize(i2);
        int mode2 = MeasureSpec.getMode(i2);
        this.f19804c = TextUtils.isEmpty(this.f19804c) ? "" : this.f19804c;
        StaticLayout a = m24975a(this.f19804c, size);
        if ((mode == 0 || mode == Integer.MIN_VALUE) && a.getLineCount() <= 1) {
            size = (int) Math.ceil((double) this.f19802a.measureText(this.f19804c));
        }
        if (mode2 == 0 || mode2 == Integer.MIN_VALUE) {
            int lineCount = a.getLineCount();
            if (lineCount <= 0) {
                lineCount = 1;
            } else {
                int i3 = this.f19805d;
                if (lineCount > i3) {
                    lineCount = i3;
                }
            }
            FontMetrics fontMetrics = this.f19802a.getFontMetrics();
            size2 = (int) Math.ceil((double) (((float) lineCount) * (fontMetrics.descent - fontMetrics.ascent)));
        }
        setMeasuredDimension(size, size2);
        StaticLayout a2 = m24975a(this.f19804c, size);
        if (a2.getLineCount() <= this.f19805d) {
            this.f19803b = a2;
            return;
        }
        int lastIndexOf = this.f19804c.lastIndexOf(46);
        if (lastIndexOf < 0 || lastIndexOf >= this.f19804c.length() - 1) {
            String str = this.f19804c;
            int i4 = 0;
            while (true) {
                if (i4 >= str.length()) {
                    staticLayout = null;
                    break;
                }
                StringBuilder sb = new StringBuilder();
                int i5 = i4 + 1;
                sb.append(str.substring(0, i5));
                String str2 = "...";
                sb.append(str2);
                if (m24975a(sb.toString(), size).getLineCount() > this.f19805d) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str.substring(0, i4));
                    sb2.append(str2);
                    staticLayout = m24975a(sb2.toString(), size);
                    break;
                }
                i4 = i5;
            }
            this.f19803b = staticLayout;
            return;
        }
        this.f19803b = m24974a(size, this.f19804c);
    }
}
