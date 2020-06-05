package com.scwang.smartrefresh.layout.internal;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.view.animation.LinearInterpolator;
import com.kwad.sdk.core.response.model.AdConfigData;

/* renamed from: com.scwang.smartrefresh.layout.internal.c */
public class ProgressDrawable extends PaintDrawable implements AnimatorUpdateListener, Animatable {
    /* renamed from: a */
    protected int f20956a = 0;
    /* renamed from: b */
    protected int f20957b = 0;
    /* renamed from: c */
    protected int f20958c = 0;
    /* renamed from: d */
    protected ValueAnimator f20959d = ValueAnimator.ofInt(new int[]{30, AdConfigData.DEFAULT_REQUEST_INTERVAL});
    /* renamed from: e */
    protected Path f20960e = new Path();

    public ProgressDrawable() {
        this.f20959d.setDuration(10000);
        this.f20959d.setInterpolator(new LinearInterpolator());
        this.f20959d.setRepeatCount(-1);
        this.f20959d.setRepeatMode(1);
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f20958c = (((Integer) valueAnimator.getAnimatedValue()).intValue() / 30) * 30;
        invalidateSelf();
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        int max = Math.max(1, width / 20);
        if (!(this.f20956a == width && this.f20957b == height)) {
            this.f20960e.reset();
            float f = (float) (width - max);
            int i = height / 2;
            float f2 = (float) i;
            float f3 = (float) max;
            this.f20960e.addCircle(f, f2, f3, Direction.CW);
            float f4 = (float) (width - (max * 5));
            this.f20960e.addRect(f4, (float) (i - max), f, (float) (i + max), Direction.CW);
            this.f20960e.addCircle(f4, f2, f3, Direction.CW);
            this.f20956a = width;
            this.f20957b = height;
        }
        canvas.save();
        float f5 = (float) (width / 2);
        float f6 = (float) (height / 2);
        canvas.rotate((float) this.f20958c, f5, f6);
        for (int i2 = 0; i2 < 12; i2++) {
            this.f20955m.setAlpha((i2 + 5) * 17);
            canvas.rotate(30.0f, f5, f6);
            canvas.drawPath(this.f20960e, this.f20955m);
        }
        canvas.restore();
    }

    public void start() {
        if (!this.f20959d.isRunning()) {
            this.f20959d.addUpdateListener(this);
            this.f20959d.start();
        }
    }

    public void stop() {
        if (this.f20959d.isRunning()) {
            this.f20959d.removeAllListeners();
            this.f20959d.removeAllUpdateListeners();
            this.f20959d.cancel();
        }
    }

    public boolean isRunning() {
        return this.f20959d.isRunning();
    }
}
