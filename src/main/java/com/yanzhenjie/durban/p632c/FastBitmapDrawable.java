package com.yanzhenjie.durban.p632c;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* renamed from: com.yanzhenjie.durban.c.e */
public class FastBitmapDrawable extends Drawable {
    /* renamed from: a */
    private final Paint f26475a = new Paint(2);
    /* renamed from: b */
    private Bitmap f26476b;
    /* renamed from: c */
    private int f26477c = 255;
    /* renamed from: d */
    private int f26478d;
    /* renamed from: e */
    private int f26479e;

    public int getOpacity() {
        return -3;
    }

    public FastBitmapDrawable(Bitmap bitmap) {
        mo37825a(bitmap);
    }

    public void draw(Canvas canvas) {
        Bitmap bitmap = this.f26476b;
        if (bitmap != null && !bitmap.isRecycled()) {
            canvas.drawBitmap(this.f26476b, null, getBounds(), this.f26475a);
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f26475a.setColorFilter(colorFilter);
    }

    public void setFilterBitmap(boolean z) {
        this.f26475a.setFilterBitmap(z);
    }

    public int getAlpha() {
        return this.f26477c;
    }

    public void setAlpha(int i) {
        this.f26477c = i;
        this.f26475a.setAlpha(i);
    }

    public int getIntrinsicWidth() {
        return this.f26478d;
    }

    public int getIntrinsicHeight() {
        return this.f26479e;
    }

    public int getMinimumWidth() {
        return this.f26478d;
    }

    public int getMinimumHeight() {
        return this.f26479e;
    }

    /* renamed from: a */
    public Bitmap mo37824a() {
        return this.f26476b;
    }

    /* renamed from: a */
    public void mo37825a(Bitmap bitmap) {
        this.f26476b = bitmap;
        if (bitmap != null) {
            this.f26478d = this.f26476b.getWidth();
            this.f26479e = this.f26476b.getHeight();
            return;
        }
        this.f26479e = 0;
        this.f26478d = 0;
    }
}
