package com.scwang.smartrefresh.header.internal;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

public class MaterialProgressDrawable extends Drawable implements Animatable {
    /* renamed from: a */
    static final Interpolator f20618a = new FastOutSlowInInterpolator();
    /* renamed from: d */
    private static final Interpolator f20619d = new LinearInterpolator();
    /* renamed from: e */
    private static final int[] f20620e = {-16777216};
    /* renamed from: b */
    float f20621b;
    /* renamed from: c */
    boolean f20622c;
    /* renamed from: f */
    private final List<Animation> f20623f = new ArrayList();
    /* renamed from: g */
    private final C6471a f20624g = new C6471a();
    /* renamed from: h */
    private float f20625h;
    /* renamed from: i */
    private View f20626i;
    /* renamed from: j */
    private Animation f20627j;
    /* renamed from: k */
    private float f20628k;
    /* renamed from: l */
    private float f20629l;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.scwang.smartrefresh.header.internal.MaterialProgressDrawable$ProgressDrawableSize */
    public @interface ProgressDrawableSize {
    }

    /* renamed from: com.scwang.smartrefresh.header.internal.MaterialProgressDrawable$a */
    private class C6471a {
        /* renamed from: a */
        final RectF f20634a = new RectF();
        /* renamed from: b */
        final Paint f20635b = new Paint();
        /* renamed from: c */
        final Paint f20636c = new Paint();
        /* renamed from: d */
        float f20637d = 0.0f;
        /* renamed from: e */
        float f20638e = 0.0f;
        /* renamed from: f */
        float f20639f = 0.0f;
        /* renamed from: g */
        float f20640g = 5.0f;
        /* renamed from: h */
        float f20641h = 2.5f;
        /* renamed from: i */
        int[] f20642i;
        /* renamed from: j */
        int f20643j;
        /* renamed from: k */
        float f20644k;
        /* renamed from: l */
        float f20645l;
        /* renamed from: m */
        float f20646m;
        /* renamed from: n */
        boolean f20647n;
        /* renamed from: o */
        Path f20648o;
        /* renamed from: p */
        float f20649p;
        /* renamed from: q */
        double f20650q;
        /* renamed from: r */
        int f20651r;
        /* renamed from: s */
        int f20652s;
        /* renamed from: t */
        int f20653t;
        /* renamed from: u */
        final Paint f20654u = new Paint(1);
        /* renamed from: v */
        int f20655v;
        /* renamed from: w */
        int f20656w;

        C6471a() {
            this.f20635b.setStrokeCap(Cap.SQUARE);
            this.f20635b.setAntiAlias(true);
            this.f20635b.setStyle(Style.STROKE);
            this.f20636c.setStyle(Style.FILL);
            this.f20636c.setAntiAlias(true);
        }

        /* renamed from: a */
        public void mo30794a(Canvas canvas, Rect rect) {
            RectF rectF = this.f20634a;
            rectF.set(rect);
            float f = this.f20641h;
            rectF.inset(f, f);
            float f2 = this.f20637d;
            float f3 = this.f20639f;
            float f4 = (f2 + f3) * 360.0f;
            float f5 = ((this.f20638e + f3) * 360.0f) - f4;
            if (f5 != 0.0f) {
                this.f20635b.setColor(this.f20656w);
                canvas.drawArc(rectF, f4, f5, false, this.f20635b);
            }
            m25413a(canvas, f4, f5, rect);
            if (this.f20653t < 255) {
                this.f20654u.setColor(this.f20655v);
                this.f20654u.setAlpha(255 - this.f20653t);
                canvas.drawCircle(rect.exactCenterX(), rect.exactCenterY(), (float) (rect.width() / 2), this.f20654u);
            }
        }

        /* renamed from: a */
        private void m25413a(Canvas canvas, float f, float f2, Rect rect) {
            if (this.f20647n) {
                Path path = this.f20648o;
                if (path == null) {
                    this.f20648o = new Path();
                    this.f20648o.setFillType(FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                float f3 = ((float) (((int) this.f20641h) / 2)) * this.f20649p;
                float cos = (float) ((this.f20650q * Math.cos(0.0d)) + ((double) rect.exactCenterX()));
                float sin = (float) ((this.f20650q * Math.sin(0.0d)) + ((double) rect.exactCenterY()));
                this.f20648o.moveTo(0.0f, 0.0f);
                this.f20648o.lineTo(((float) this.f20651r) * this.f20649p, 0.0f);
                Path path2 = this.f20648o;
                float f4 = (float) this.f20651r;
                float f5 = this.f20649p;
                path2.lineTo((f4 * f5) / 2.0f, ((float) this.f20652s) * f5);
                this.f20648o.offset(cos - f3, sin);
                this.f20648o.close();
                this.f20636c.setColor(this.f20656w);
                canvas.rotate((f + f2) - 5.0f, rect.exactCenterX(), rect.exactCenterY());
                canvas.drawPath(this.f20648o, this.f20636c);
            }
        }

        /* renamed from: a */
        public void mo30792a(int i) {
            this.f20643j = i;
            this.f20656w = this.f20642i[this.f20643j];
        }

        /* renamed from: a */
        public int mo30791a() {
            return this.f20642i[m25414f()];
        }

        /* renamed from: f */
        private int m25414f() {
            return (this.f20643j + 1) % this.f20642i.length;
        }

        /* renamed from: b */
        public void mo30795b() {
            mo30792a(m25414f());
        }

        /* renamed from: c */
        public int mo30796c() {
            return this.f20642i[this.f20643j];
        }

        /* renamed from: a */
        public void mo30793a(int i, int i2) {
            double d;
            float min = (float) Math.min(i, i2);
            double d2 = this.f20650q;
            if (d2 <= 0.0d || min < 0.0f) {
                d = Math.ceil((double) (this.f20640g / 2.0f));
            } else {
                d = ((double) (min / 2.0f)) - d2;
            }
            this.f20641h = (float) d;
        }

        /* renamed from: d */
        public void mo30797d() {
            this.f20644k = this.f20637d;
            this.f20645l = this.f20638e;
            this.f20646m = this.f20639f;
        }

        /* renamed from: e */
        public void mo30798e() {
            this.f20644k = 0.0f;
            this.f20645l = 0.0f;
            this.f20646m = 0.0f;
            this.f20637d = 0.0f;
            this.f20638e = 0.0f;
            this.f20639f = 0.0f;
        }
    }

    public int getOpacity() {
        return -3;
    }

    public MaterialProgressDrawable(View view) {
        this.f20626i = view;
        mo30772a(f20620e);
        mo30770a(1);
        m25400a();
    }

    /* renamed from: a */
    private void m25401a(int i, int i2, float f, float f2, float f3, float f4) {
        float f5 = Resources.getSystem().getDisplayMetrics().density;
        this.f20628k = ((float) i) * f5;
        this.f20629l = ((float) i2) * f5;
        this.f20624g.mo30792a(0);
        float f6 = f2 * f5;
        this.f20624g.f20635b.setStrokeWidth(f6);
        C6471a aVar = this.f20624g;
        aVar.f20640g = f6;
        aVar.f20650q = (double) (f * f5);
        aVar.f20651r = (int) (f3 * f5);
        aVar.f20652s = (int) (f4 * f5);
        aVar.mo30793a((int) this.f20628k, (int) this.f20629l);
        invalidateSelf();
    }

    /* renamed from: a */
    public void mo30770a(int i) {
        if (i == 0) {
            m25401a(56, 56, 12.5f, 3.0f, 12.0f, 6.0f);
        } else {
            m25401a(40, 40, 8.75f, 2.5f, 10.0f, 5.0f);
        }
    }

    /* renamed from: a */
    public void mo30771a(boolean z) {
        if (this.f20624g.f20647n != z) {
            this.f20624g.f20647n = z;
            invalidateSelf();
        }
    }

    /* renamed from: a */
    public void mo30767a(float f) {
        if (this.f20624g.f20649p != f) {
            this.f20624g.f20649p = f;
            invalidateSelf();
        }
    }

    /* renamed from: a */
    public void mo30768a(float f, float f2) {
        C6471a aVar = this.f20624g;
        aVar.f20637d = f;
        aVar.f20638e = f2;
        invalidateSelf();
    }

    /* renamed from: b */
    public void mo30773b(float f) {
        this.f20624g.f20639f = f;
        invalidateSelf();
    }

    /* renamed from: b */
    public void mo30775b(int i) {
        this.f20624g.f20655v = i;
    }

    /* renamed from: a */
    public void mo30772a(int... iArr) {
        C6471a aVar = this.f20624g;
        aVar.f20642i = iArr;
        aVar.mo30792a(0);
    }

    public int getIntrinsicHeight() {
        return (int) this.f20629l;
    }

    public int getIntrinsicWidth() {
        return (int) this.f20628k;
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int save = canvas.save();
        canvas.rotate(this.f20625h, bounds.exactCenterX(), bounds.exactCenterY());
        this.f20624g.mo30794a(canvas, bounds);
        canvas.restoreToCount(save);
    }

    public void setAlpha(int i) {
        this.f20624g.f20653t = i;
    }

    public int getAlpha() {
        return this.f20624g.f20653t;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f20624g.f20635b.setColorFilter(colorFilter);
        invalidateSelf();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo30776c(float f) {
        this.f20625h = f;
        invalidateSelf();
    }

    public boolean isRunning() {
        List<Animation> list = this.f20623f;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Animation animation = (Animation) list.get(i);
            if (animation.hasStarted() && !animation.hasEnded()) {
                return true;
            }
        }
        return false;
    }

    public void start() {
        this.f20627j.reset();
        this.f20624g.mo30797d();
        if (this.f20624g.f20638e != this.f20624g.f20637d) {
            this.f20622c = true;
            this.f20627j.setDuration(666);
            this.f20626i.startAnimation(this.f20627j);
            return;
        }
        this.f20624g.mo30792a(0);
        this.f20624g.mo30798e();
        this.f20627j.setDuration(1332);
        this.f20626i.startAnimation(this.f20627j);
    }

    public void stop() {
        this.f20626i.clearAnimation();
        this.f20624g.mo30792a(0);
        this.f20624g.mo30798e();
        mo30771a(false);
        mo30776c(0.0f);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public float mo30766a(C6471a aVar) {
        return (float) Math.toRadians(((double) aVar.f20640g) / (aVar.f20650q * 6.283185307179586d));
    }

    /* renamed from: a */
    private int m25399a(float f, int i, int i2) {
        int intValue = Integer.valueOf(i).intValue();
        int i3 = (intValue >> 24) & 255;
        int i4 = (intValue >> 16) & 255;
        int i5 = (intValue >> 8) & 255;
        int i6 = intValue & 255;
        int intValue2 = Integer.valueOf(i2).intValue();
        return ((i3 + ((int) (((float) (((intValue2 >> 24) & 255) - i3)) * f))) << 24) | ((i4 + ((int) (((float) (((intValue2 >> 16) & 255) - i4)) * f))) << 16) | ((i5 + ((int) (((float) (((intValue2 >> 8) & 255) - i5)) * f))) << 8) | (i6 + ((int) (f * ((float) ((intValue2 & 255) - i6)))));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo30769a(float f, C6471a aVar) {
        if (f > 0.75f) {
            aVar.f20656w = m25399a((f - 0.75f) / 0.25f, aVar.mo30796c(), aVar.mo30791a());
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo30774b(float f, C6471a aVar) {
        mo30769a(f, aVar);
        float floor = (float) (Math.floor((double) (aVar.f20646m / 0.8f)) + 1.0d);
        mo30768a(aVar.f20644k + (((aVar.f20645l - mo30766a(aVar)) - aVar.f20644k) * f), aVar.f20645l);
        mo30773b(aVar.f20646m + ((floor - aVar.f20646m) * f));
    }

    /* renamed from: a */
    private void m25400a() {
        final C6471a aVar = this.f20624g;
        C64691 r1 = new Animation() {
            public void applyTransformation(float f, Transformation transformation) {
                if (MaterialProgressDrawable.this.f20622c) {
                    MaterialProgressDrawable.this.mo30774b(f, aVar);
                    return;
                }
                float a = MaterialProgressDrawable.this.mo30766a(aVar);
                float f2 = aVar.f20645l;
                float f3 = aVar.f20644k;
                float f4 = aVar.f20646m;
                MaterialProgressDrawable.this.mo30769a(f, aVar);
                if (f <= 0.5f) {
                    float f5 = f / 0.5f;
                    aVar.f20637d = f3 + ((0.8f - a) * MaterialProgressDrawable.f20618a.getInterpolation(f5));
                }
                if (f > 0.5f) {
                    float f6 = 0.8f - a;
                    float f7 = (f - 0.5f) / 0.5f;
                    aVar.f20638e = f2 + (f6 * MaterialProgressDrawable.f20618a.getInterpolation(f7));
                }
                MaterialProgressDrawable.this.mo30773b(f4 + (0.25f * f));
                MaterialProgressDrawable.this.mo30776c((f * 216.0f) + ((MaterialProgressDrawable.this.f20621b / 5.0f) * 1080.0f));
            }
        };
        r1.setRepeatCount(-1);
        r1.setRepeatMode(1);
        r1.setInterpolator(f20619d);
        r1.setAnimationListener(new AnimationListener() {
            public void onAnimationEnd(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
                MaterialProgressDrawable.this.f20621b = 0.0f;
            }

            public void onAnimationRepeat(Animation animation) {
                aVar.mo30797d();
                aVar.mo30795b();
                C6471a aVar = aVar;
                aVar.f20637d = aVar.f20638e;
                if (MaterialProgressDrawable.this.f20622c) {
                    MaterialProgressDrawable.this.f20622c = false;
                    animation.setDuration(1332);
                    MaterialProgressDrawable.this.mo30771a(false);
                    return;
                }
                MaterialProgressDrawable materialProgressDrawable = MaterialProgressDrawable.this;
                materialProgressDrawable.f20621b = (materialProgressDrawable.f20621b + 1.0f) % 5.0f;
            }
        });
        this.f20627j = r1;
    }
}
