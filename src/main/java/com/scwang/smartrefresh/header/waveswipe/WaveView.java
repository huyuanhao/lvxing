package com.scwang.smartrefresh.header.waveswipe;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;

public class WaveView extends View implements OnPreDrawListener {
    /* renamed from: t */
    protected static final float[][] f20692t = {new float[]{0.1655f, 0.0f}, new float[]{0.4188f, -0.0109f}, new float[]{0.4606f, -0.0049f}, new float[]{0.4893f, 0.0f}, new float[]{0.4893f, 0.0f}, new float[]{0.5f, 0.0f}};
    /* renamed from: u */
    protected static final float[][] f20693u = {new float[]{0.1655f, 0.0f}, new float[]{0.5237f, 0.0553f}, new float[]{0.4557f, 0.0936f}, new float[]{0.3908f, 0.1302f}, new float[]{0.4303f, 0.2173f}, new float[]{0.5f, 0.2173f}};
    /* renamed from: v */
    protected static final float[][] f20694v = {new float[]{0.1655f, 0.0f}, new float[]{0.5909f, 0.0f}, new float[]{0.4557f, 0.1642f}, new float[]{0.3941f, 0.2061f}, new float[]{0.4303f, 0.2889f}, new float[]{0.5f, 0.2889f}};
    /* renamed from: a */
    protected float f20695a = 100.0f;
    /* renamed from: b */
    protected Paint f20696b;
    /* renamed from: c */
    protected Path f20697c;
    /* renamed from: d */
    protected Path f20698d;
    /* renamed from: e */
    protected Path f20699e;
    /* renamed from: f */
    protected Path f20700f;
    /* renamed from: g */
    protected RectF f20701g;
    /* renamed from: h */
    protected int f20702h;
    /* renamed from: i */
    protected float f20703i;
    /* renamed from: j */
    protected int f20704j;
    /* renamed from: k */
    protected boolean f20705k = false;
    /* renamed from: l */
    protected boolean f20706l = false;
    /* renamed from: m */
    protected int f20707m;
    /* renamed from: n */
    protected ValueAnimator f20708n;
    /* renamed from: o */
    protected ValueAnimator f20709o;
    /* renamed from: p */
    protected ValueAnimator f20710p;
    /* renamed from: q */
    protected ValueAnimator f20711q;
    /* renamed from: r */
    protected ValueAnimator f20712r;
    /* renamed from: s */
    protected ValueAnimator f20713s;
    /* renamed from: w */
    protected AnimatorUpdateListener f20714w = new AnimatorUpdateListener() {
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            WaveView.this.postInvalidate();
        }
    };

    public WaveView(Context context) {
        super(context);
        float f = getResources().getDisplayMetrics().density;
        this.f20696b = new Paint();
        this.f20696b.setColor(-14575885);
        this.f20696b.setAntiAlias(true);
        this.f20696b.setStyle(Style.FILL);
        this.f20696b.setShadowLayer((float) ((int) ((f * 2.0f) + 0.5f)), 0.0f, 0.0f, -1728053248);
        this.f20697c = new Path();
        this.f20698d = new Path();
        this.f20699e = new Path();
        this.f20700f = new Path();
        mo30830a();
        this.f20701g = new RectF();
        setLayerType(1, null);
        getViewTreeObserver().addOnPreDrawListener(this);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        this.f20702h = i;
        this.f20695a = ((float) i) / 14.4f;
        mo30834a((int) Math.min((float) Math.min(i, i2), ((float) getHeight()) - this.f20695a));
        super.onSizeChanged(i, i2, i3, i4);
    }

    public boolean onPreDraw() {
        getViewTreeObserver().removeOnPreDrawListener(this);
        if (this.f20706l) {
            mo30834a(this.f20707m);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.f20697c, this.f20696b);
        if (!isInEditMode()) {
            this.f20697c.rewind();
            this.f20698d.rewind();
            this.f20699e.rewind();
        }
        float floatValue = ((Float) this.f20711q.getAnimatedValue()).floatValue();
        float f = ((float) this.f20702h) / 2.0f;
        float floatValue2 = ((Float) this.f20712r.getAnimatedValue()).floatValue();
        float floatValue3 = ((Float) this.f20709o.getAnimatedValue()).floatValue();
        float floatValue4 = ((Float) this.f20710p.getAnimatedValue()).floatValue();
        RectF rectF = this.f20701g;
        float f2 = this.f20695a;
        float f3 = floatValue3 + 1.0f;
        float f4 = 1.0f + floatValue4;
        rectF.set((f - ((f2 * f3) * floatValue2)) + ((f2 * floatValue4) / 2.0f), (((f2 * f4) * floatValue2) + floatValue) - ((f2 * floatValue3) / 2.0f), (((f3 * f2) * floatValue2) + f) - ((floatValue4 * f2) / 2.0f), (floatValue - ((f4 * f2) * floatValue2)) + ((f2 * floatValue3) / 2.0f));
        float floatValue5 = ((Float) this.f20708n.getAnimatedValue()).floatValue();
        this.f20698d.moveTo(f, floatValue5);
        double d = (double) floatValue;
        double pow = ((Math.pow((double) this.f20695a, 2.0d) + ((double) (floatValue * floatValue5))) - Math.pow(d, 2.0d)) / ((double) (floatValue5 - floatValue));
        double d2 = (((double) this.f20702h) * -2.0d) / 2.0d;
        double d3 = -d2;
        double pow2 = (d2 * d2) - (((Math.pow(pow - d, 2.0d) + Math.pow((double) f, 2.0d)) - Math.pow((double) this.f20695a, 2.0d)) * 4.0d);
        double sqrt = (Math.sqrt(pow2) + d3) / 2.0d;
        double sqrt2 = (d3 - Math.sqrt(pow2)) / 2.0d;
        float f5 = (float) pow;
        this.f20698d.lineTo((float) sqrt, f5);
        this.f20698d.lineTo((float) sqrt2, f5);
        this.f20698d.close();
        this.f20700f.set(this.f20698d);
        this.f20700f.addOval(this.f20701g, Direction.CCW);
        this.f20699e.addOval(this.f20701g, Direction.CCW);
        canvas.drawPath(this.f20698d, this.f20696b);
        canvas.drawPath(this.f20699e, this.f20696b);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        ValueAnimator valueAnimator = this.f20712r;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.f20712r.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator2 = this.f20711q;
        if (valueAnimator2 != null) {
            valueAnimator2.end();
            this.f20711q.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator3 = this.f20708n;
        if (valueAnimator3 != null) {
            valueAnimator3.end();
            this.f20708n.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator4 = this.f20713s;
        if (valueAnimator4 != null) {
            valueAnimator4.end();
            this.f20713s.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator5 = this.f20710p;
        if (valueAnimator5 != null) {
            valueAnimator5.end();
            this.f20710p.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator6 = this.f20709o;
        if (valueAnimator6 != null) {
            valueAnimator6.end();
            this.f20709o.removeAllUpdateListeners();
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo30830a() {
        this.f20708n = ValueAnimator.ofFloat(new float[]{0.0f, 0.0f});
        this.f20709o = ValueAnimator.ofFloat(new float[]{0.0f, 0.0f});
        this.f20710p = ValueAnimator.ofFloat(new float[]{0.0f, 0.0f});
        this.f20711q = ValueAnimator.ofFloat(new float[]{-1000.0f, -1000.0f});
        this.f20711q.start();
        this.f20712r = ValueAnimator.ofFloat(new float[]{1.0f, 1.0f});
        this.f20712r.setDuration(1);
        this.f20712r.start();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo30836b() {
        ValueAnimator valueAnimator = this.f20713s;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f20713s.cancel();
        }
    }

    /* renamed from: c */
    public void mo30838c() {
        if (!this.f20705k) {
            this.f20705k = true;
            int i = this.f20704j;
            this.f20711q = ValueAnimator.ofFloat(new float[]{(float) i, (float) i});
            this.f20711q.start();
            int i2 = this.f20704j;
            float f = (float) i2;
            float f2 = this.f20695a;
            this.f20708n = ValueAnimator.ofFloat(new float[]{f - f2, ((float) i2) - f2});
            this.f20708n.start();
            this.f20703i = (float) this.f20704j;
            postInvalidate();
        }
    }

    /* renamed from: a */
    public void mo30831a(float f) {
        mo30836b();
        this.f20697c.moveTo(0.0f, 0.0f);
        Path path = this.f20697c;
        int i = this.f20702h;
        float f2 = (float) i;
        float[][] fArr = f20692t;
        path.cubicTo(f2 * fArr[0][0], fArr[0][1], ((float) i) * fArr[1][0], ((float) i) * (fArr[1][1] + f), ((float) i) * fArr[2][0], ((float) i) * (fArr[2][1] + f));
        Path path2 = this.f20697c;
        int i2 = this.f20702h;
        float f3 = (float) i2;
        float[][] fArr2 = f20692t;
        path2.cubicTo(f3 * fArr2[3][0], ((float) i2) * (fArr2[3][1] + f), ((float) i2) * fArr2[4][0], ((float) i2) * (fArr2[4][1] + f), ((float) i2) * fArr2[5][0], ((float) i2) * (fArr2[5][1] + f));
        Path path3 = this.f20697c;
        int i3 = this.f20702h;
        float f4 = (float) i3;
        float f5 = (float) i3;
        float[][] fArr3 = f20692t;
        path3.cubicTo(f4 - (f5 * fArr3[4][0]), ((float) i3) * (fArr3[4][1] + f), ((float) i3) - (((float) i3) * fArr3[3][0]), ((float) i3) * (fArr3[3][1] + f), ((float) i3) - (((float) i3) * fArr3[2][0]), ((float) i3) * (fArr3[2][1] + f));
        Path path4 = this.f20697c;
        int i4 = this.f20702h;
        float f6 = (float) i4;
        float f7 = (float) i4;
        float[][] fArr4 = f20692t;
        path4.cubicTo(f6 - (f7 * fArr4[1][0]), ((float) i4) * (fArr4[1][1] + f), ((float) i4) - (((float) i4) * fArr4[0][0]), fArr4[0][1], (float) i4, 0.0f);
        if (VERSION.SDK_INT >= 16) {
            postInvalidateOnAnimation();
        } else {
            invalidate();
        }
    }

    /* renamed from: a */
    public void mo30832a(float f, float f2) {
        mo30836b();
        this.f20697c.moveTo(0.0f, 0.0f);
        Path path = this.f20697c;
        int i = this.f20702h;
        float f3 = (float) i;
        float[][] fArr = f20693u;
        path.cubicTo(f3 * fArr[0][0], ((float) i) * fArr[0][1], ((float) i) * Math.min(f20692t[1][0] + f2, fArr[1][0]), ((float) this.f20702h) * Math.max((f20692t[1][1] + f) - f2, f20693u[1][1]), ((float) this.f20702h) * Math.max(f20692t[2][0] - f2, f20693u[2][0]), ((float) this.f20702h) * Math.max((f20692t[2][1] + f) - f2, f20693u[2][1]));
        Path path2 = this.f20697c;
        float max = ((float) this.f20702h) * Math.max(f20692t[3][0] - f2, f20693u[3][0]);
        float min = ((float) this.f20702h) * Math.min(f20692t[3][1] + f + f2, f20693u[3][1]);
        float max2 = ((float) this.f20702h) * Math.max(f20692t[4][0] - f2, f20693u[4][0]);
        float min2 = ((float) this.f20702h) * Math.min(f20692t[4][1] + f + f2, f20693u[4][1]);
        int i2 = this.f20702h;
        float f4 = (float) i2;
        float[][] fArr2 = f20693u;
        path2.cubicTo(max, min, max2, min2, f4 * fArr2[5][0], ((float) i2) * Math.min(f20692t[0][1] + f + f2, fArr2[5][1]));
        Path path3 = this.f20697c;
        int i3 = this.f20702h;
        float max3 = ((float) i3) - (((float) i3) * Math.max(f20692t[4][0] - f2, f20693u[4][0]));
        float min3 = ((float) this.f20702h) * Math.min(f20692t[4][1] + f + f2, f20693u[4][1]);
        int i4 = this.f20702h;
        float max4 = ((float) i4) - (((float) i4) * Math.max(f20692t[3][0] - f2, f20693u[3][0]));
        float min4 = ((float) this.f20702h) * Math.min(f20692t[3][1] + f + f2, f20693u[3][1]);
        int i5 = this.f20702h;
        path3.cubicTo(max3, min3, max4, min4, ((float) i5) - (((float) i5) * Math.max(f20692t[2][0] - f2, f20693u[2][0])), ((float) this.f20702h) * Math.max((f20692t[2][1] + f) - f2, f20693u[2][1]));
        Path path4 = this.f20697c;
        int i6 = this.f20702h;
        float min5 = ((float) i6) - (((float) i6) * Math.min(f20692t[1][0] + f2, f20693u[1][0]));
        float max5 = ((float) this.f20702h) * Math.max((f20692t[1][1] + f) - f2, f20693u[1][1]);
        int i7 = this.f20702h;
        float f5 = (float) i7;
        float f6 = (float) i7;
        float[][] fArr3 = f20693u;
        path4.cubicTo(min5, max5, f5 - (f6 * fArr3[0][0]), ((float) i7) * fArr3[0][1], (float) i7, 0.0f);
        this.f20703i = (((float) this.f20702h) * Math.min(f20692t[3][1] + f + f2, f20693u[3][1])) + this.f20695a;
        if (VERSION.SDK_INT >= 16) {
            postInvalidateOnAnimation();
        } else {
            invalidate();
        }
    }

    /* renamed from: a */
    public void mo30833a(float f, float f2, float f3) {
        mo30836b();
        this.f20697c.moveTo(0.0f, 0.0f);
        Path path = this.f20697c;
        int i = this.f20702h;
        float f4 = (float) i;
        float[][] fArr = f20694v;
        path.cubicTo(f4 * fArr[0][0], ((float) i) * fArr[0][1], ((float) i) * Math.min(Math.min(f20692t[1][0] + f2, f20693u[1][0]) + f3, f20694v[1][0]), ((float) this.f20702h) * Math.max(Math.max((f20692t[1][1] + f) - f2, f20693u[1][1]) - f3, f20694v[1][1]), ((float) this.f20702h) * Math.max(f20692t[2][0] - f2, f20694v[2][0]), ((float) this.f20702h) * Math.min(Math.max((f20692t[2][1] + f) - f2, f20693u[2][1]) + f3, f20694v[2][1]));
        Path path2 = this.f20697c;
        float min = ((float) this.f20702h) * Math.min(Math.max(f20692t[3][0] - f2, f20693u[3][0]) + f3, f20694v[3][0]);
        float min2 = ((float) this.f20702h) * Math.min(Math.min(f20692t[3][1] + f + f2, f20693u[3][1]) + f3, f20694v[3][1]);
        float max = ((float) this.f20702h) * Math.max(f20692t[4][0] - f2, f20694v[4][0]);
        float min3 = ((float) this.f20702h) * Math.min(Math.min(f20692t[4][1] + f + f2, f20693u[4][1]) + f3, f20694v[4][1]);
        int i2 = this.f20702h;
        path2.cubicTo(min, min2, max, min3, ((float) i2) * f20694v[5][0], ((float) i2) * Math.min(Math.min(f20692t[0][1] + f + f2, f20693u[5][1]) + f3, f20694v[5][1]));
        Path path3 = this.f20697c;
        int i3 = this.f20702h;
        float max2 = ((float) i3) - (((float) i3) * Math.max(f20692t[4][0] - f2, f20694v[4][0]));
        float min4 = ((float) this.f20702h) * Math.min(Math.min(f20692t[4][1] + f + f2, f20693u[4][1]) + f3, f20694v[4][1]);
        int i4 = this.f20702h;
        float min5 = ((float) i4) - (((float) i4) * Math.min(Math.max(f20692t[3][0] - f2, f20693u[3][0]) + f3, f20694v[3][0]));
        float min6 = ((float) this.f20702h) * Math.min(Math.min(f20692t[3][1] + f + f2, f20693u[3][1]) + f3, f20694v[3][1]);
        int i5 = this.f20702h;
        path3.cubicTo(max2, min4, min5, min6, ((float) i5) - (((float) i5) * Math.max(f20692t[2][0] - f2, f20694v[2][0])), ((float) this.f20702h) * Math.min(Math.max((f20692t[2][1] + f) - f2, f20693u[2][1]) + f3, f20694v[2][1]));
        Path path4 = this.f20697c;
        int i6 = this.f20702h;
        float min7 = ((float) i6) - (((float) i6) * Math.min(Math.min(f20692t[1][0] + f2, f20693u[1][0]) + f3, f20694v[1][0]));
        float max3 = ((float) this.f20702h) * Math.max(Math.max((f20692t[1][1] + f) - f2, f20693u[1][1]) - f3, f20694v[1][1]);
        int i7 = this.f20702h;
        float f5 = (float) i7;
        float f6 = (float) i7;
        float[][] fArr2 = f20694v;
        path4.cubicTo(min7, max3, f5 - (f6 * fArr2[0][0]), ((float) i7) * fArr2[0][1], (float) i7, 0.0f);
        this.f20703i = (((float) this.f20702h) * Math.min(Math.min(f20692t[3][1] + f + f2, f20693u[3][1]) + f3, f20694v[3][1])) + this.f20695a;
        if (VERSION.SDK_INT >= 16) {
            postInvalidateOnAnimation();
        } else {
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo30834a(int i) {
        float f = (float) i;
        if ((((float) this.f20702h) / 1440.0f) * 500.0f <= f) {
            this.f20704j = (int) Math.min(f, ((float) getHeight()) - this.f20695a);
            if (this.f20705k) {
                this.f20705k = false;
                mo30838c();
            }
        }
    }

    /* renamed from: d */
    public void mo30839d() {
        this.f20712r = ValueAnimator.ofFloat(new float[]{1.0f, 1.0f});
        this.f20712r.setDuration(1);
        this.f20712r.start();
        this.f20711q = ValueAnimator.ofFloat(new float[]{(((float) this.f20702h) / 1440.0f) * 500.0f, (float) this.f20704j});
        this.f20711q.setDuration(500);
        this.f20711q.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                WaveView.this.f20703i = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                WaveView waveView = WaveView.this;
                if (VERSION.SDK_INT >= 16) {
                    waveView.postInvalidateOnAnimation();
                } else {
                    waveView.invalidate();
                }
            }
        });
        this.f20711q.setInterpolator(new AccelerateDecelerateInterpolator());
        this.f20711q.start();
        this.f20708n = ValueAnimator.ofFloat(new float[]{0.0f, ((float) this.f20704j) - this.f20695a});
        this.f20708n.setDuration(500);
        this.f20708n.addUpdateListener(this.f20714w);
        this.f20708n.start();
        this.f20709o = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f20709o.setDuration(500);
        this.f20709o.addUpdateListener(this.f20714w);
        this.f20709o.setInterpolator(new DropBounceInterpolator());
        this.f20709o.setStartDelay(500);
        this.f20709o.start();
        this.f20710p = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f20710p.setDuration(500);
        this.f20710p.addUpdateListener(this.f20714w);
        this.f20710p.setInterpolator(new DropBounceInterpolator());
        this.f20710p.setStartDelay(625);
        this.f20710p.start();
    }

    /* renamed from: e */
    public void mo30840e() {
        this.f20712r = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        this.f20712r.addUpdateListener(this.f20714w);
        this.f20712r.setDuration(200);
        this.f20712r.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                WaveView.this.mo30830a();
                WaveView.this.f20705k = false;
            }
        });
        this.f20712r.start();
    }

    /* renamed from: b */
    public void mo30837b(float f) {
        this.f20713s = ValueAnimator.ofFloat(new float[]{Math.min(f, 0.2f) * ((float) this.f20702h), 0.0f});
        this.f20713s.setDuration(1000);
        this.f20713s.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                WaveView.this.f20697c.moveTo(0.0f, 0.0f);
                float f = floatValue * 0.5f;
                WaveView.this.f20697c.quadTo(((float) WaveView.this.f20702h) * 0.25f, 0.0f, ((float) WaveView.this.f20702h) * 0.333f, f);
                WaveView.this.f20697c.quadTo(((float) WaveView.this.f20702h) * 0.5f, floatValue * 1.4f, ((float) WaveView.this.f20702h) * 0.666f, f);
                WaveView.this.f20697c.quadTo(((float) WaveView.this.f20702h) * 0.75f, 0.0f, (float) WaveView.this.f20702h, 0.0f);
                WaveView.this.postInvalidate();
            }
        });
        this.f20713s.setInterpolator(new BounceInterpolator());
        this.f20713s.start();
    }

    /* renamed from: f */
    public void mo30841f() {
        if (!this.f20712r.isRunning()) {
            mo30839d();
            mo30837b(0.1f);
        }
    }

    public float getCurrentCircleCenterY() {
        return this.f20703i;
    }

    /* renamed from: a */
    public void mo30835a(int i, int i2) {
        this.f20696b.setShadowLayer((float) i, 0.0f, 0.0f, i2);
    }

    public void setWaveColor(int i) {
        this.f20696b.setColor(i);
        invalidate();
    }
}
