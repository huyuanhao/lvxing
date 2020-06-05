package com.kwad.sdk.contentalliance.refreshview;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.core.view.InputDeviceCompat;
import com.kwad.sdk.p306a.C3817t;

public class ShootRefreshView extends View implements C4052d {
    /* renamed from: a */
    public static final Property<ShootRefreshView, Float> f13587a = new Property<ShootRefreshView, Float>(Float.class, null) {
        /* renamed from: a */
        public Float get(ShootRefreshView shootRefreshView) {
            return Float.valueOf(shootRefreshView.f13601o);
        }

        /* renamed from: a */
        public void set(ShootRefreshView shootRefreshView, Float f) {
            shootRefreshView.f13601o = f.floatValue();
            shootRefreshView.invalidate();
        }
    };
    /* renamed from: b */
    public static final Property<ShootRefreshView, Float> f13588b = new Property<ShootRefreshView, Float>(Float.class, null) {
        /* renamed from: a */
        public Float get(ShootRefreshView shootRefreshView) {
            return Float.valueOf(shootRefreshView.f13602p);
        }

        /* renamed from: a */
        public void set(ShootRefreshView shootRefreshView, Float f) {
            shootRefreshView.f13602p = f.floatValue();
            shootRefreshView.invalidate();
        }
    };
    /* renamed from: c */
    private static final float f13589c = ((float) Math.toDegrees(0.5235987901687622d));
    /* renamed from: d */
    private static final float f13590d = ((float) Math.sqrt(3.0d));
    /* renamed from: e */
    private final Paint f13591e;
    /* renamed from: f */
    private final RectF f13592f;
    /* renamed from: g */
    private int f13593g;
    /* renamed from: h */
    private int f13594h;
    /* renamed from: i */
    private int f13595i;
    /* renamed from: j */
    private int f13596j;
    /* renamed from: k */
    private int f13597k;
    /* renamed from: l */
    private int f13598l;
    /* renamed from: m */
    private int f13599m;
    /* access modifiers changed from: private */
    /* renamed from: n */
    public float f13600n;
    /* access modifiers changed from: private */
    /* renamed from: o */
    public float f13601o;
    /* access modifiers changed from: private */
    /* renamed from: p */
    public float f13602p;
    /* renamed from: q */
    private Shader f13603q;
    /* renamed from: r */
    private boolean f13604r;
    /* renamed from: s */
    private ValueAnimator f13605s;
    /* renamed from: t */
    private float f13606t;
    /* renamed from: u */
    private float f13607u;
    /* renamed from: v */
    private boolean f13608v;
    /* renamed from: w */
    private AnimatorSet f13609w;

    public ShootRefreshView(Context context) {
        this(context, null);
    }

    public ShootRefreshView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShootRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13591e = new Paint(1);
        this.f13592f = new RectF();
        this.f13608v = false;
        m16766a(context, attributeSet);
        m16772g();
        m16773h();
        mo23631a();
    }

    /* renamed from: a */
    private void m16766a(Context context, AttributeSet attributeSet) {
        this.f13596j = -1044481;
        this.f13597k = InputDeviceCompat.SOURCE_ANY;
        this.f13598l = 234880768;
        this.f13599m = C3817t.m15862a(getContext(), 1.5f);
        this.f13603q = new SweepGradient(0.0f, 0.0f, new int[]{this.f13597k, this.f13598l}, new float[]{0.3f, 1.0f});
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x003b  */
    /* renamed from: a */
    private void m16767a(android.graphics.Canvas r11) {
        /*
        r10 = this;
        r11.save()
        int r0 = r10.f13594h
        float r0 = (float) r0
        int r1 = r10.f13595i
        float r1 = (float) r1
        r11.translate(r0, r1)
        android.animation.ValueAnimator r0 = r10.f13605s
        boolean r0 = r0.isRunning()
        if (r0 == 0) goto L_0x0029
        r0 = -1028390912(0xffffffffc2b40000, float:-90.0)
        float r1 = r10.f13600n
        float r1 = r1 + r0
        r11.rotate(r1)
        android.graphics.Paint r0 = r10.f13591e
        android.graphics.Shader r0 = r0.getShader()
        android.graphics.Shader r1 = r10.f13603q
        if (r0 == r1) goto L_0x002f
        android.graphics.Paint r0 = r10.f13591e
        goto L_0x002c
    L_0x0029:
        android.graphics.Paint r0 = r10.f13591e
        r1 = 0
    L_0x002c:
        r0.setShader(r1)
    L_0x002f:
        float r0 = r10.f13607u
        int r1 = r10.f13593g
        int r2 = r1 * 2
        float r2 = (float) r2
        r3 = 0
        int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
        if (r2 >= 0) goto L_0x003e
        r10.f13606t = r3
        goto L_0x004e
    L_0x003e:
        r2 = 1135869952(0x43b40000, float:360.0)
        int r4 = r1 * 2
        float r4 = (float) r4
        float r0 = r0 - r4
        float r0 = r0 * r2
        r2 = 1082130432(0x40800000, float:4.0)
        float r1 = (float) r1
        float r1 = r1 * r2
        float r0 = r0 / r1
        r10.f13606t = r0
    L_0x004e:
        android.graphics.Paint r0 = r10.f13591e
        r1 = 1
        r0.setAntiAlias(r1)
        android.graphics.Paint r0 = r10.f13591e
        android.graphics.Paint$Style r1 = android.graphics.Paint.Style.STROKE
        r0.setStyle(r1)
        android.graphics.RectF r5 = new android.graphics.RectF
        int r0 = r10.f13593g
        float r1 = (float) r0
        float r1 = r3 - r1
        float r2 = (float) r0
        float r2 = r3 - r2
        float r4 = (float) r0
        float r4 = r4 + r3
        float r0 = (float) r0
        float r0 = r0 + r3
        r5.<init>(r1, r2, r4, r0)
        boolean r0 = r10.f13608v
        r6 = -1028390912(0xffffffffc2b40000, float:-90.0)
        if (r0 == 0) goto L_0x0075
        r7 = 1135869952(0x43b40000, float:360.0)
        goto L_0x0077
    L_0x0075:
        float r7 = r10.f13606t
    L_0x0077:
        r8 = 0
        android.graphics.Paint r9 = r10.f13591e
        r4 = r11
        r4.drawArc(r5, r6, r7, r8, r9)
        r11.restore()
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.contentalliance.refreshview.ShootRefreshView.m16767a(android.graphics.Canvas):void");
    }

    /* renamed from: b */
    private void m16770b(Canvas canvas) {
        int i;
        Paint paint;
        float f;
        float f2;
        float f3;
        float f4;
        Canvas canvas2;
        Canvas canvas3 = canvas;
        this.f13591e.setShader(null);
        canvas.save();
        canvas3.translate((float) this.f13594h, (float) this.f13595i);
        canvas3.rotate(-this.f13602p);
        int i2 = 0;
        while (i2 < 6) {
            canvas.save();
            canvas3.rotate((float) (i2 * -60));
            float f5 = this.f13601o;
            if (f5 > 0.5235988f) {
                double tan = Math.tan((double) f5);
                double tan2 = Math.tan((double) (this.f13601o + 1.0471976f));
                float f6 = f13590d;
                double d = (tan - tan2) * 2.0d;
                float f7 = (float) ((1.0d - (((double) f6) * tan2)) / d);
                int i3 = this.f13593g;
                float f8 = ((float) i3) * f7;
                i = i2;
                f = ((float) ((((2.0d * tan2) - tan) - ((((double) f6) * tan) * tan2)) / d)) * ((float) i3);
                f4 = 0.0f;
                f3 = (float) (-i3);
                paint = this.f13591e;
                canvas2 = canvas;
                f2 = f8;
            } else {
                i = i2;
                double tan3 = Math.tan((double) f5);
                float pow = (float) (((tan3 * 2.0d) * ((double) this.f13593g)) / (Math.pow(tan3, 2.0d) + 1.0d));
                f = (float) (((Math.pow(tan3, 2.0d) - 1.0d) * ((double) this.f13593g)) / (Math.pow(tan3, 2.0d) + 1.0d));
                f4 = 0.0f;
                f3 = (float) (-this.f13593g);
                paint = this.f13591e;
                canvas2 = canvas;
                f2 = pow;
            }
            canvas2.drawLine(f4, f3, f2, f, paint);
            canvas.restore();
            i2 = i + 1;
            canvas3 = canvas;
        }
        canvas.restore();
    }

    /* renamed from: g */
    private void m16772g() {
        this.f13591e.setStyle(Style.STROKE);
        this.f13591e.setStrokeWidth((float) this.f13599m);
        this.f13591e.setColor(this.f13596j);
    }

    /* renamed from: h */
    private void m16773h() {
        m16774i();
        this.f13605s = ValueAnimator.ofFloat(new float[]{0.0f, 360.0f});
        this.f13605s.setRepeatCount(-1);
        this.f13605s.setInterpolator(new LinearInterpolator());
        this.f13605s.setDuration(400);
        this.f13605s.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ShootRefreshView.this.f13600n = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ShootRefreshView.this.invalidate();
            }
        });
    }

    /* renamed from: i */
    private void m16774i() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 0.5235988f});
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.setDuration(30);
        ofFloat.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ShootRefreshView.this.f13600n = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ShootRefreshView.this.invalidate();
            }
        });
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat(f13587a, new float[]{0.5235988f, 1.2566371f});
        Property<ShootRefreshView, Float> property = f13588b;
        float f = f13589c;
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{ofFloat2, PropertyValuesHolder.ofFloat(property, new float[]{-(f / 2.0f), (-(f / 2.0f)) - 120.0f})});
        ofPropertyValuesHolder.setInterpolator(new DecelerateInterpolator());
        ofPropertyValuesHolder.setDuration(350);
        this.f13609w = new AnimatorSet();
        this.f13609w.play(ofPropertyValuesHolder).after(ofFloat);
    }

    /* renamed from: a */
    public void mo23631a() {
        this.f13601o = 1.2566371f;
        this.f13602p = (-(f13589c / 2.0f)) - 240.0f;
        this.f13600n = 0.0f;
        invalidate();
        this.f13608v = false;
        this.f13604r = false;
        this.f13609w.end();
        this.f13605s.end();
    }

    /* renamed from: a */
    public void mo23632a(float f, float f2) {
        this.f13607u = f;
        invalidate();
    }

    /* renamed from: b */
    public void mo23633b() {
        this.f13600n = 0.0f;
        this.f13602p = 0.0f;
        this.f13601o = 0.0f;
        if (this.f13609w.isRunning()) {
            this.f13605s.end();
        } else {
            this.f13605s.start();
        }
        this.f13604r = true;
        this.f13608v = true;
    }

    /* renamed from: c */
    public void mo23634c() {
        this.f13609w.start();
        this.f13605s.end();
    }

    /* renamed from: d */
    public void mo23635d() {
    }

    /* renamed from: e */
    public void mo23636e() {
    }

    /* renamed from: f */
    public int mo23637f() {
        return VERSION.SDK_INT > 19 ? 500 : 800;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        mo23631a();
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f13604r) {
            m16770b(canvas);
        }
        m16767a(canvas);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f13592f.set((float) (getPaddingLeft() + 0), (float) (getPaddingTop() + 0), (float) (i - getPaddingRight()), (float) (i2 - getPaddingBottom()));
        RectF rectF = this.f13592f;
        int i5 = this.f13599m;
        rectF.inset((float) i5, (float) i5);
        this.f13593g = (int) (Math.min(this.f13592f.width(), this.f13592f.height()) / 2.0f);
        this.f13594h = (int) this.f13592f.centerX();
        this.f13595i = (int) this.f13592f.centerY();
    }
}
