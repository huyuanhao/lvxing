package com.scwang.smartrefresh.layout.internal;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;

/* renamed from: com.scwang.smartrefresh.layout.internal.a */
public class ArrowDrawable extends PaintDrawable {
    /* renamed from: a */
    private int f20952a = 0;
    /* renamed from: b */
    private int f20953b = 0;
    /* renamed from: c */
    private Path f20954c = new Path();

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        if (!(this.f20952a == width && this.f20953b == height)) {
            int i = (width * 30) / 225;
            this.f20954c.reset();
            double d = (double) i;
            float sin = (float) (Math.sin(0.7853981633974483d) * d);
            float sin2 = (float) (d / Math.sin(0.7853981633974483d));
            int i2 = width / 2;
            float f = (float) height;
            this.f20954c.moveTo((float) i2, f);
            float f2 = (float) (height / 2);
            this.f20954c.lineTo(0.0f, f2);
            float f3 = f2 - sin;
            this.f20954c.lineTo(sin, f3);
            int i3 = i / 2;
            float f4 = (float) (i2 - i3);
            float f5 = (f - sin2) - ((float) i3);
            this.f20954c.lineTo(f4, f5);
            this.f20954c.lineTo(f4, 0.0f);
            float f6 = (float) (i2 + i3);
            this.f20954c.lineTo(f6, 0.0f);
            this.f20954c.lineTo(f6, f5);
            float f7 = (float) width;
            this.f20954c.lineTo(f7 - sin, f3);
            this.f20954c.lineTo(f7, f2);
            this.f20954c.close();
            this.f20952a = width;
            this.f20953b = height;
        }
        canvas.drawPath(this.f20954c, this.f20955m);
    }
}
