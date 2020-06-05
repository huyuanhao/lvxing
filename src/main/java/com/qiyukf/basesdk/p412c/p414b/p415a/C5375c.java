package com.qiyukf.basesdk.p412c.p414b.p415a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.LeadingMarginSpan;

/* renamed from: com.qiyukf.basesdk.c.b.a.c */
public final class C5375c implements LeadingMarginSpan {
    /* renamed from: a */
    private final String f17338a;
    /* renamed from: b */
    private final int f17339b;

    public C5375c(TextPaint textPaint, int i) {
        this.f17338a = Integer.toString(i).concat(". ");
        this.f17339b = (int) textPaint.measureText(this.f17338a);
    }

    public final void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        if ((charSequence instanceof Spanned) && ((Spanned) charSequence).getSpanStart(this) == i6) {
            canvas.drawText(this.f17338a, (float) i, (float) i4, paint);
        }
    }

    public final int getLeadingMargin(boolean z) {
        return this.f17339b;
    }
}
