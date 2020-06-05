package com.scwang.smartrefresh.layout.header;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.scwang.smartrefresh.layout.R;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
import com.scwang.smartrefresh.layout.p527a.RefreshHeader;
import com.scwang.smartrefresh.layout.p527a.RefreshLayout;
import com.scwang.smartrefresh.layout.p529c.DensityUtil;

public class BezierRadarHeader extends InternalAbstract implements RefreshHeader {
    /* renamed from: a */
    protected int f20870a;
    /* renamed from: b */
    protected int f20871b;
    /* renamed from: c */
    protected boolean f20872c;
    /* renamed from: d */
    protected boolean f20873d;
    /* renamed from: e */
    protected boolean f20874e;
    /* renamed from: f */
    protected boolean f20875f;
    /* renamed from: g */
    protected Path f20876g;
    /* renamed from: h */
    protected Paint f20877h;
    /* renamed from: i */
    protected int f20878i;
    /* renamed from: j */
    protected int f20879j;
    /* renamed from: k */
    protected int f20880k;
    /* renamed from: l */
    protected float f20881l;
    /* renamed from: m */
    protected float f20882m;
    /* renamed from: n */
    protected float f20883n;
    /* renamed from: o */
    protected float f20884o;
    /* renamed from: p */
    protected int f20885p;
    /* renamed from: q */
    protected float f20886q;
    /* renamed from: r */
    protected float f20887r;
    /* renamed from: s */
    protected float f20888s;
    /* renamed from: t */
    protected Animator f20889t;
    /* renamed from: u */
    protected RectF f20890u;

    /* renamed from: com.scwang.smartrefresh.layout.header.BezierRadarHeader$1 */
    static /* synthetic */ class C65031 {
        /* renamed from: a */
        static final /* synthetic */ int[] f20891a = new int[RefreshState.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
     */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
            com.scwang.smartrefresh.layout.constant.RefreshState[] r0 = com.scwang.smartrefresh.layout.constant.RefreshState.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f20891a = r0
            int[] r0 = f20891a     // Catch:{ NoSuchFieldError -> 0x0014 }
            com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.None     // Catch:{ NoSuchFieldError -> 0x0014 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            int[] r0 = f20891a     // Catch:{ NoSuchFieldError -> 0x001f }
            com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.PullDownToRefresh     // Catch:{ NoSuchFieldError -> 0x001f }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.header.BezierRadarHeader.C65031.m51145clinit():void");
        }
    }

    /* renamed from: com.scwang.smartrefresh.layout.header.BezierRadarHeader$a */
    protected class C6504a implements AnimatorUpdateListener {
        /* renamed from: a */
        byte f20892a;

        C6504a(byte b) {
            this.f20892a = b;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            byte b = this.f20892a;
            if (b == 0) {
                BezierRadarHeader.this.f20888s = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            } else if (1 == b) {
                if (BezierRadarHeader.this.f20874e) {
                    valueAnimator.cancel();
                    return;
                } else {
                    BezierRadarHeader.this.f20879j = ((Integer) valueAnimator.getAnimatedValue()).intValue() / 2;
                }
            } else if (2 == b) {
                BezierRadarHeader.this.f20881l = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            } else if (3 == b) {
                BezierRadarHeader.this.f20884o = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            } else if (4 == b) {
                BezierRadarHeader.this.f20885p = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            }
            BezierRadarHeader.this.invalidate();
        }
    }

    public BezierRadarHeader(Context context) {
        this(context, null);
    }

    public BezierRadarHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BezierRadarHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f20875f = false;
        this.f20880k = -1;
        this.f20885p = 0;
        this.f20886q = 0.0f;
        this.f20887r = 0.0f;
        this.f20888s = 0.0f;
        this.f20890u = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.f20937ab = SpinnerStyle.Scale;
        DensityUtil bVar = new DensityUtil();
        this.f20876g = new Path();
        this.f20877h = new Paint();
        this.f20877h.setAntiAlias(true);
        this.f20883n = (float) bVar.mo30968b(7.0f);
        this.f20886q = (float) bVar.mo30968b(20.0f);
        this.f20887r = (float) bVar.mo30968b(7.0f);
        this.f20877h.setStrokeWidth((float) bVar.mo30968b(3.0f));
        setMinimumHeight(bVar.mo30968b(100.0f));
        if (isInEditMode()) {
            this.f20878i = 1000;
            this.f20888s = 1.0f;
            this.f20885p = 270;
        } else {
            this.f20888s = 0.0f;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BezierRadarHeader);
        this.f20875f = obtainStyledAttributes.getBoolean(R.styleable.BezierRadarHeader_srlEnableHorizontalDrag, this.f20875f);
        mo30984b(obtainStyledAttributes.getColor(R.styleable.BezierRadarHeader_srlAccentColor, -1));
        mo30981a(obtainStyledAttributes.getColor(R.styleable.BezierRadarHeader_srlPrimaryColor, -14540254));
        this.f20873d = obtainStyledAttributes.hasValue(R.styleable.BezierRadarHeader_srlAccentColor);
        this.f20872c = obtainStyledAttributes.hasValue(R.styleable.BezierRadarHeader_srlPrimaryColor);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Animator animator = this.f20889t;
        if (animator != null) {
            animator.removeAllListeners();
            this.f20889t.end();
            this.f20889t = null;
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        mo30982a(canvas, width);
        mo30983a(canvas, width, height);
        mo30985b(canvas, width, height);
        mo30986c(canvas, width, height);
        super.dispatchDraw(canvas);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo30982a(Canvas canvas, int i) {
        this.f20876g.reset();
        this.f20876g.lineTo(0.0f, (float) this.f20878i);
        Path path = this.f20876g;
        int i2 = this.f20880k;
        if (i2 < 0) {
            i2 = i / 2;
        }
        float f = (float) i2;
        int i3 = this.f20878i;
        float f2 = (float) i;
        path.quadTo(f, (float) (this.f20879j + i3), f2, (float) i3);
        this.f20876g.lineTo(f2, 0.0f);
        this.f20877h.setColor(this.f20871b);
        canvas.drawPath(this.f20876g, this.f20877h);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo30983a(Canvas canvas, int i, int i2) {
        float f = 0.0f;
        if (this.f20881l > 0.0f) {
            this.f20877h.setColor(this.f20870a);
            float a = DensityUtil.m25571a(i2);
            float f2 = (float) (i / 7);
            float f3 = this.f20882m;
            float f4 = 1.0f;
            float f5 = (f2 * f3) - (f3 > 1.0f ? ((f3 - 1.0f) * f2) / f3 : 0.0f);
            float f6 = (float) i2;
            float f7 = this.f20882m;
            float f8 = 2.0f;
            if (f7 > 1.0f) {
                f = (((f7 - 1.0f) * f6) / 2.0f) / f7;
            }
            float f9 = f6 - f;
            int i3 = 0;
            while (i3 < 7) {
                float f10 = (((float) i3) + f4) - 4.0f;
                this.f20877h.setAlpha((int) (((double) (this.f20881l * (f4 - ((Math.abs(f10) / 7.0f) * f8)) * 255.0f)) * (1.0d - (1.0d / Math.pow((((double) a) / 800.0d) + 1.0d, 15.0d)))));
                float f11 = this.f20883n * (1.0f - (1.0f / ((a / 10.0f) + 1.0f)));
                canvas.drawCircle((((float) (i / 2)) - (f11 / 2.0f)) + (f10 * f5), f9 / 2.0f, f11, this.f20877h);
                i3++;
                f4 = 1.0f;
                f8 = 2.0f;
            }
            this.f20877h.setAlpha(255);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo30985b(Canvas canvas, int i, int i2) {
        if (this.f20889t != null || isInEditMode()) {
            float f = this.f20886q;
            float f2 = this.f20888s;
            float f3 = f * f2;
            float f4 = this.f20887r * f2;
            this.f20877h.setColor(this.f20870a);
            this.f20877h.setStyle(Style.FILL);
            float f5 = (float) (i / 2);
            float f6 = (float) (i2 / 2);
            canvas.drawCircle(f5, f6, f3, this.f20877h);
            this.f20877h.setStyle(Style.STROKE);
            float f7 = f4 + f3;
            canvas.drawCircle(f5, f6, f7, this.f20877h);
            this.f20877h.setColor((this.f20871b & 16777215) | 1426063360);
            this.f20877h.setStyle(Style.FILL);
            this.f20890u.set(f5 - f3, f6 - f3, f5 + f3, f3 + f6);
            canvas.drawArc(this.f20890u, 270.0f, (float) this.f20885p, true, this.f20877h);
            this.f20877h.setStyle(Style.STROKE);
            this.f20890u.set(f5 - f7, f6 - f7, f5 + f7, f6 + f7);
            canvas.drawArc(this.f20890u, 270.0f, (float) this.f20885p, false, this.f20877h);
            this.f20877h.setStyle(Style.FILL);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo30986c(Canvas canvas, int i, int i2) {
        if (this.f20884o > 0.0f) {
            this.f20877h.setColor(this.f20870a);
            canvas.drawCircle((float) (i / 2), (float) (i2 / 2), this.f20884o, this.f20877h);
        }
    }

    /* renamed from: a */
    public void mo30672a(boolean z, float f, int i, int i2, int i3) {
        if (z || this.f20874e) {
            this.f20874e = true;
            this.f20878i = Math.min(i2, i);
            this.f20879j = (int) (((float) Math.max(0, i - i2)) * 1.9f);
            this.f20882m = f;
        }
    }

    /* renamed from: a */
    public void mo30671a(RefreshLayout jVar, int i, int i2) {
        this.f20878i = i;
        this.f20874e = false;
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, 360});
        ofInt.setDuration(720);
        ofInt.setRepeatCount(-1);
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        ofInt.addUpdateListener(new C6504a(4));
        DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        ofFloat.setInterpolator(decelerateInterpolator);
        ofFloat.addUpdateListener(new C6504a(2));
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.setInterpolator(decelerateInterpolator);
        ofFloat2.addUpdateListener(new C6504a(0));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(new Animator[]{ofFloat, ofFloat2, ofInt});
        animatorSet.start();
        int i3 = this.f20879j;
        ValueAnimator ofInt2 = ValueAnimator.ofInt(new int[]{i3, 0, -((int) (((float) i3) * 0.8f)), 0, -((int) (((float) i3) * 0.4f)), 0});
        ofInt2.addUpdateListener(new C6504a(1));
        ofInt2.setInterpolator(decelerateInterpolator);
        ofInt2.setDuration(800);
        ofInt2.start();
        this.f20889t = animatorSet;
    }

    /* renamed from: a */
    public int mo30670a(RefreshLayout jVar, boolean z) {
        Animator animator = this.f20889t;
        if (animator != null) {
            animator.removeAllListeners();
            this.f20889t.end();
            this.f20889t = null;
        }
        int width = getWidth();
        int height = getHeight();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, (float) Math.sqrt((double) ((width * width) + (height * height)))});
        ofFloat.setDuration(400);
        ofFloat.addUpdateListener(new C6504a(3));
        ofFloat.start();
        return 400;
    }

    /* renamed from: a */
    public void mo30678a(RefreshLayout jVar, RefreshState refreshState, RefreshState refreshState2) {
        int i = C65031.f20891a[refreshState2.ordinal()];
        if (i == 1 || i == 2) {
            this.f20881l = 1.0f;
            this.f20888s = 0.0f;
            this.f20884o = 0.0f;
        }
    }

    @Deprecated
    public void setPrimaryColors(int... iArr) {
        if (iArr.length > 0 && !this.f20872c) {
            mo30981a(iArr[0]);
            this.f20872c = false;
        }
        if (iArr.length > 1 && !this.f20873d) {
            mo30984b(iArr[1]);
            this.f20873d = false;
        }
    }

    /* renamed from: f */
    public boolean mo30952f() {
        return this.f20875f;
    }

    /* renamed from: a */
    public void mo30951a(float f, int i, int i2) {
        this.f20880k = i;
        if (VERSION.SDK_INT >= 16) {
            postInvalidateOnAnimation();
        } else {
            invalidate();
        }
    }

    /* renamed from: a */
    public BezierRadarHeader mo30981a(int i) {
        this.f20871b = i;
        this.f20872c = true;
        return this;
    }

    /* renamed from: b */
    public BezierRadarHeader mo30984b(int i) {
        this.f20870a = i;
        this.f20873d = true;
        return this;
    }
}
