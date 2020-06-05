package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class TTRoundRectImageView extends ImageView {
    /* renamed from: a */
    private Paint f8283a;
    /* renamed from: b */
    private int f8284b;
    /* renamed from: c */
    private int f8285c;
    /* renamed from: d */
    private Matrix f8286d;

    public TTRoundRectImageView(Context context) {
        this(context, null);
    }

    public TTRoundRectImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TTRoundRectImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8284b = 25;
        this.f8285c = 25;
        this.f8283a = new Paint();
        this.f8283a.setAntiAlias(true);
        this.f8283a.setFilterBitmap(true);
        this.f8286d = new Matrix();
    }

    public void setXRound(int i) {
        this.f8284b = i;
        postInvalidate();
    }

    public void setYRound(int i) {
        this.f8285c = i;
        postInvalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            Bitmap a = m10770a(drawable);
            if (a != null) {
                BitmapShader bitmapShader = new BitmapShader(a, TileMode.REPEAT, TileMode.REPEAT);
                float f = 1.0f;
                if (!(a.getWidth() == getWidth() && a.getHeight() == getHeight())) {
                    f = Math.max((((float) getWidth()) * 1.0f) / ((float) a.getWidth()), (((float) getHeight()) * 1.0f) / ((float) a.getHeight()));
                }
                this.f8286d.setScale(f, f);
                bitmapShader.setLocalMatrix(this.f8286d);
                this.f8283a.setShader(bitmapShader);
                canvas.drawRoundRect(new RectF(0.0f, 0.0f, (float) getWidth(), (float) getHeight()), (float) this.f8284b, (float) this.f8285c, this.f8283a);
                return;
            }
            super.onDraw(canvas);
            return;
        }
        super.onDraw(canvas);
    }

    /* renamed from: a */
    private Bitmap m10770a(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int width = drawable.getIntrinsicWidth() <= 0 ? getWidth() : drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight() <= 0 ? getHeight() : drawable.getIntrinsicHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, width, height);
        drawable.draw(canvas);
        return createBitmap;
    }
}
