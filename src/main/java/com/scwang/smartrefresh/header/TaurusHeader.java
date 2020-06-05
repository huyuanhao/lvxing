package com.scwang.smartrefresh.header;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import com.scwang.smartrefresh.header.internal.pathview.PathsDrawable;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
import com.scwang.smartrefresh.layout.p527a.RefreshHeader;
import com.scwang.smartrefresh.layout.p527a.RefreshLayout;
import com.scwang.smartrefresh.layout.p529c.DensityUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class TaurusHeader extends InternalAbstract implements RefreshHeader {
    /* renamed from: a */
    protected static String[] f20500a = {"m23.01,81.48c-0.21,-0.3 -0.38,-0.83 -0.38,-1.19 0,-0.55 0.24,-0.78 1.5,-1.48 1.78,-0.97 2.62,-1.94 2.24,-2.57 -0.57,-0.93 -1.97,-1.24 -11.64,-2.59 -5.35,-0.74 -10.21,-1.44 -10.82,-1.54l-1.09,-0.18 1.19,-0.91c0.99,-0.76 1.38,-0.91 2.35,-0.91 0.64,0 6.39,0.33 12.79,0.74 6.39,0.41 12.09,0.71 12.65,0.67l1.03,-0.07 -1.24,-2.19C30.18,66.77 15.91,42 15.13,40.68l-0.51,-0.87 4.19,-1.26c2.3,-0.69 4.27,-1.26 4.37,-1.26 0.1,0 5.95,3.85 13,8.55 14.69,9.81 17.1,11.31 19.7,12.31 4.63,1.78 6.45,1.69 12.94,-0.64 13.18,-4.73 25.22,-9.13 25.75,-9.4 0.69,-0.36 3.6,1.33 -24.38,-14.22L50.73,23.07 46.74,16.42 42.75,9.77 43.63,8.89c0.83,-0.83 0.91,-0.86 1.46,-0.52 0.32,0.2 3.72,3.09 7.55,6.44 3.83,3.34 7.21,6.16 7.5,6.27 0.29,0.11 13.6,2.82 29.58,6.03 15.98,3.21 31.86,6.4 35.3,7.1l6.26,1.26 3.22,-1.13c41.63,-14.63 67.88,-23.23 85.38,-28 14.83,-4.04 23.75,-4.75 32.07,-2.57 7.04,1.84 9.87,4.88 7.71,8.27 -1.6,2.5 -4.6,4.63 -10.61,7.54 -5.94,2.88 -10.22,4.46 -25.4,9.41 -8.15,2.66 -16.66,5.72 -39.01,14.02 -66.79,24.82 -88.49,31.25 -121.66,36.07 -14.56,2.11 -24.17,2.95 -34.08,2.95 -5.43,0 -5.52,-0.01 -5.89,-0.54z"};
    /* renamed from: b */
    protected static int[] f20501b = {-1};
    /* renamed from: c */
    protected static String[] f20502c = {"M551.81,1.01A65.42,65.42 0,0 0,504.38 21.5A50.65,50.65 0,0 0,492.4 20A50.65,50.65 0,0 0,441.75 70.65A50.65,50.65 0,0 0,492.4 121.3A50.65,50.65 0,0 0,511.22 117.64A65.42,65.42 0,0 0,517.45 122L586.25,122A65.42,65.42 0,0 0,599.79 110.78A59.79,59.79 0,0 0,607.81 122L696.34,122A59.79,59.79 0,0 0,711.87 81.9A59.79,59.79 0,0 0,652.07 22.11A59.79,59.79 0,0 0,610.93 38.57A65.42,65.42 0,0 0,551.81 1.01zM246.2,1.71A54.87,54.87 0,0 0,195.14 36.64A46.78,46.78 0,0 0,167.77 27.74A46.78,46.78 0,0 0,120.99 74.52A46.78,46.78 0,0 0,167.77 121.3A46.78,46.78 0,0 0,208.92 96.74A54.87,54.87 0,0 0,246.2 111.45A54.87,54.87 0,0 0,268.71 106.54A39.04,39.04 0,0 0,281.09 122L327.6,122A39.04,39.04 0,0 0,343.38 90.7A39.04,39.04 0,0 0,304.34 51.66A39.04,39.04 0,0 0,300.82 51.85A54.87,54.87 0,0 0,246.2 1.71z", "m506.71,31.37a53.11,53.11 0,0 0,-53.11 53.11,53.11 53.11,0 0,0 15.55,37.5h75.12a53.11,53.11 0,0 0,1.88 -2.01,28.49 28.49,0 0,0 0.81,2.01h212.96a96.72,96.72 0,0 0,-87.09 -54.85,96.72 96.72,0 0,0 -73.14,33.52 28.49,28.49 0,0 0,-26.74 -18.74,28.49 28.49,0 0,0 -13.16,3.23 53.11,53.11 0,0 0,0.03 -0.66,53.11 53.11,0 0,0 -53.11,-53.11zM206.23,31.81a53.81,53.81 0,0 0,-49.99 34.03,74.91 74.91,0 0,0 -47.45,-17 74.91,74.91 0,0 0,-73.54 60.82,31.3 31.3,0 0,0 -10.17,-1.73 31.3,31.3 0,0 0,-26.09 14.05L300.86,121.98a37.63,37.63 0,0 0,0.2 -3.85,37.63 37.63,0 0,0 -37.63,-37.63 37.63,37.63 0,0 0,-3.65 0.21,53.81 53.81,0 0,0 -53.54,-48.9z", "m424.05,36.88a53.46,53.46 0,0 0,-40.89 19.02,53.46 53.46,0 0,0 -1.34,1.76 62.6,62.6 0,0 0,-5.39 -0.27,62.6 62.6,0 0,0 -61.36,50.17 62.6,62.6 0,0 0,-0.53 3.51,15.83 15.83,0 0,0 -10.33,-3.84 15.83,15.83 0,0 0,-8.06 2.23,21.1 21.1,0 0,0 -18.31,-10.67 21.1,21.1 0,0 0,-19.47 12.97,21.81 21.81,0 0,0 -6.56,-1.01 21.81,21.81 0,0 0,-19.09 11.32L522.84,122.07a43.61,43.61 0,0 0,-43.11 -37.35,43.61 43.61,0 0,0 -2.57,0.09 53.46,53.46 0,0 0,-53.11 -47.93zM129.08,38.4a50.29,50.29 0,0 0,-50.29 50.29,50.29 50.29,0 0,0 2.37,15.06 15.48,15.83 0,0 0,-5.87 1.68,15.48 15.83,0 0,0 -0.98,0.58 16.53,16.18 0,0 0,-0.19 -0.21,16.53 16.18,0 0,0 -11.86,-4.91 16.53,16.18 0,0 0,-16.38 14.13,20.05 16.18,0 0,0 -14.97,7.04L223.95,122.07a42.56,42.56 0,0 0,1.14 -9.56,42.56 42.56,0 0,0 -42.56,-42.56 42.56,42.56 0,0 0,-6.58 0.54,50.29 50.29,0 0,0 -0,-0.01 50.29,50.29 0,0 0,-46.88 -32.07zM631.67,82.61a64.01,64.01 0,0 0,-44.9 18.42,26.73 26.73,0 0,0 -10.67,-2.24 26.73,26.73 0,0 0,-22.72 12.71,16.88 16.88,0 0,0 -0.25,-0.12 16.88,16.88 0,0 0,-6.57 -1.33,16.88 16.88,0 0,0 -16.15,12.03h160.36a64.01,64.01 0,0 0,-59.1 -39.46z"};
    /* renamed from: d */
    protected static int[] f20503d = {-1429742351, -571935747, -131587};
    /* renamed from: e */
    protected static final Interpolator f20504e = new AccelerateDecelerateInterpolator();
    /* renamed from: f */
    protected Drawable f20505f;
    /* renamed from: g */
    protected Drawable f20506g;
    /* renamed from: h */
    protected Matrix f20507h;
    /* renamed from: i */
    protected float f20508i;
    /* renamed from: j */
    protected int f20509j;
    /* renamed from: k */
    protected Animation f20510k;
    /* renamed from: l */
    protected boolean f20511l;
    /* renamed from: m */
    protected float f20512m;
    /* renamed from: n */
    protected float f20513n;
    /* renamed from: o */
    protected Random f20514o;
    /* renamed from: p */
    protected Map<Float, Float> f20515p;
    /* renamed from: q */
    protected Paint f20516q;
    /* renamed from: r */
    protected float f20517r;
    /* renamed from: s */
    protected boolean f20518s;
    /* renamed from: t */
    protected boolean f20519t;
    /* renamed from: u */
    protected float f20520u;

    /* renamed from: com.scwang.smartrefresh.header.TaurusHeader$3 */
    static /* synthetic */ class C64603 {
        /* renamed from: a */
        static final /* synthetic */ int[] f20525a = new int[AnimationPart.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
            com.scwang.smartrefresh.header.TaurusHeader$AnimationPart[] r0 = com.scwang.smartrefresh.header.TaurusHeader.AnimationPart.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f20525a = r0
            int[] r0 = f20525a     // Catch:{ NoSuchFieldError -> 0x0014 }
            com.scwang.smartrefresh.header.TaurusHeader$AnimationPart r1 = com.scwang.smartrefresh.header.TaurusHeader.AnimationPart.FIRST     // Catch:{ NoSuchFieldError -> 0x0014 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            int[] r0 = f20525a     // Catch:{ NoSuchFieldError -> 0x001f }
            com.scwang.smartrefresh.header.TaurusHeader$AnimationPart r1 = com.scwang.smartrefresh.header.TaurusHeader.AnimationPart.SECOND     // Catch:{ NoSuchFieldError -> 0x001f }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            int[] r0 = f20525a     // Catch:{ NoSuchFieldError -> 0x002a }
            com.scwang.smartrefresh.header.TaurusHeader$AnimationPart r1 = com.scwang.smartrefresh.header.TaurusHeader.AnimationPart.THIRD     // Catch:{ NoSuchFieldError -> 0x002a }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            int[] r0 = f20525a     // Catch:{ NoSuchFieldError -> 0x0035 }
            com.scwang.smartrefresh.header.TaurusHeader$AnimationPart r1 = com.scwang.smartrefresh.header.TaurusHeader.AnimationPart.FOURTH     // Catch:{ NoSuchFieldError -> 0x0035 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
            r2 = 4
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
        L_0x0035:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.header.TaurusHeader.C64603.m51040clinit():void");
        }
    }

    /* renamed from: com.scwang.smartrefresh.header.TaurusHeader$AnimationPart */
    protected enum AnimationPart {
        FIRST,
        SECOND,
        THIRD,
        FOURTH
    }

    public TaurusHeader(Context context) {
        this(context, null);
    }

    public TaurusHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TaurusHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f20511l = false;
        DensityUtil bVar = new DensityUtil();
        setMinimumHeight(bVar.mo30968b(100.0f));
        this.f20507h = new Matrix();
        this.f20515p = new HashMap();
        this.f20514o = new Random();
        this.f20516q = new Paint();
        this.f20516q.setColor(-1);
        this.f20516q.setStrokeWidth((float) bVar.mo30968b(3.0f));
        this.f20516q.setAlpha(50);
        this.f20937ab = SpinnerStyle.Scale;
        this.f20510k = new Animation() {
            public void applyTransformation(float f, Transformation transformation) {
                TaurusHeader.this.f20512m = (f / 6.0f) * 80.0f;
                this.invalidate();
            }
        };
        this.f20510k.setRepeatCount(-1);
        this.f20510k.setRepeatMode(2);
        this.f20510k.setInterpolator(f20504e);
        this.f20510k.setDuration(1000);
        PathsDrawable bVar2 = new PathsDrawable();
        if (!bVar2.mo30809a(f20500a)) {
            bVar2.mo30806a(3, 3, 257, 79);
        }
        bVar2.mo30807a(f20501b);
        PathsDrawable bVar3 = new PathsDrawable();
        if (!bVar3.mo30809a(f20502c)) {
            bVar3.mo30806a(-1, 1, 761, 121);
        }
        bVar3.mo30807a(f20503d);
        this.f20505f = bVar2;
        this.f20506g = bVar3;
        this.f20505f.setBounds(0, 0, bVar.mo30968b(65.0f), bVar.mo30968b(20.0f));
        this.f20506g.setBounds(0, 0, bVar.mo30968b(260.0f), bVar.mo30968b(45.0f));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TaurusHeader);
        int color = obtainStyledAttributes.getColor(R.styleable.TaurusHeader_thPrimaryColor, 0);
        if (color != 0) {
            setBackgroundColor(color);
        } else {
            setBackgroundColor(-15614977);
        }
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    public void mo30672a(boolean z, float f, int i, int i2, int i3) {
        this.f20508i = f;
        this.f20509j = i2;
        if (z) {
            this.f20520u = 0.0f;
        }
    }

    /* renamed from: b */
    public void mo30679b(RefreshLayout jVar, int i, int i2) {
        this.f20511l = true;
        this.f20520u = 0.0f;
        startAnimation(this.f20510k);
    }

    /* renamed from: a */
    public int mo30670a(RefreshLayout jVar, boolean z) {
        clearAnimation();
        if (z) {
            startAnimation(new Animation() {
                {
                    super.setDuration(100);
                    super.setInterpolator(new AccelerateInterpolator());
                }

                /* access modifiers changed from: protected */
                public void applyTransformation(float f, Transformation transformation) {
                    if (f == 1.0f) {
                        TaurusHeader.this.f20511l = false;
                    }
                    TaurusHeader.this.f20520u = f;
                    this.invalidate();
                }
            });
            return 200;
        }
        this.f20511l = false;
        return 0;
    }

    @Deprecated
    public void setPrimaryColors(int... iArr) {
        setBackgroundColor(iArr[0]);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        float f;
        int width = getWidth();
        int height = getHeight();
        if (this.f20511l) {
            while (this.f20515p.size() < 10) {
                float random = (float) (((double) this.f20509j) / (Math.random() * 5.0d));
                float a = m25348a(1000, 2000);
                if (this.f20515p.size() > 1) {
                    while (true) {
                        f = 0.0f;
                        while (true) {
                            if (f != 0.0f) {
                                break;
                            }
                            float random2 = (float) (((double) this.f20509j) / (Math.random() * 5.0d));
                            Iterator it = this.f20515p.entrySet().iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    if (Math.abs(((Float) ((Entry) it.next()).getKey()).floatValue() - random2) > ((float) (this.f20509j / 5))) {
                                        f = random2;
                                    }
                                }
                            }
                        }
                    }
                    random = f;
                    break;
                }
                this.f20515p.put(Float.valueOf(random), Float.valueOf(a));
                m25350a(canvas, random, a, width);
            }
            if (this.f20515p.size() >= 10) {
                for (Entry entry : this.f20515p.entrySet()) {
                    m25350a(canvas, ((Float) entry.getKey()).floatValue(), ((Float) entry.getValue()).floatValue(), width);
                }
            }
            if (this.f20519t && this.f20518s) {
                this.f20515p.clear();
                this.f20518s = false;
                this.f20517r = m25348a(50, 300);
            }
            this.f20513n = this.f20512m;
        }
        m25355c(canvas, width, height);
        m25351a(canvas, width, height);
        m25352b(canvas, width, height);
        super.dispatchDraw(canvas);
    }

    /* renamed from: a */
    private void m25350a(Canvas canvas, float f, float f2, int i) {
        float f3 = (float) i;
        float f4 = (f3 + f2) / 13.0f;
        float f5 = this.f20512m;
        if (this.f20513n - f5 > 0.0f) {
            this.f20519t = true;
            f5 = 13.0f - f5;
        } else {
            this.f20518s = true;
            this.f20519t = false;
        }
        float f6 = (f3 - (f5 * f4)) + f2;
        float f7 = this.f20517r;
        float f8 = f6 - f7;
        canvas.drawLine(f8, f, f8 + f7, f, this.f20516q);
    }

    /* renamed from: a */
    private void m25351a(Canvas canvas, int i, int i2) {
        float a;
        float a2;
        Matrix matrix = this.f20507h;
        matrix.reset();
        Drawable drawable = this.f20506g;
        float min = Math.min(1.0f, Math.abs(this.f20508i));
        if (isInEditMode()) {
            this.f20509j = i2;
            min = 1.0f;
        }
        float f = min - 0.5f;
        float f2 = 0.6f;
        if (f > 0.0f) {
            f2 = 0.6f + ((f / 0.5f) * 0.39999998f);
        }
        float f3 = ((float) this.f20509j) * (1.0f - min);
        float width = (float) (0 - (drawable.getBounds().width() / 2));
        float width2 = (float) (i - (drawable.getBounds().width() / 2));
        if (this.f20511l) {
            if (m25353b(AnimationPart.FIRST)) {
                width -= (m25349a(AnimationPart.FIRST) * 2.0f) / 4.0f;
                a2 = m25349a(AnimationPart.FIRST);
            } else if (m25353b(AnimationPart.SECOND)) {
                width -= (m25349a(AnimationPart.SECOND) * 2.0f) / 4.0f;
                a2 = m25349a(AnimationPart.SECOND);
            } else if (m25353b(AnimationPart.THIRD)) {
                width -= m25349a(AnimationPart.THIRD) / 4.0f;
                a2 = m25349a(AnimationPart.THIRD) * 2.0f;
            } else if (m25353b(AnimationPart.FOURTH)) {
                width -= m25349a(AnimationPart.FOURTH) / 2.0f;
                a = (m25349a(AnimationPart.FOURTH) * 2.0f) / 4.0f;
                width2 += a;
            }
            a = a2 / 2.0f;
            width2 += a;
        }
        float f4 = (float) (i2 + 2);
        float height = (((float) drawable.getBounds().height()) * f2) + f3 < f4 ? f4 - (((float) drawable.getBounds().height()) * f2) : f3;
        if ((((float) drawable.getBounds().height()) * f2) + f3 < f4) {
            f3 = f4 - (((float) drawable.getBounds().height()) * f2);
        }
        int saveCount = canvas.getSaveCount();
        canvas.save();
        canvas.translate(width, height);
        matrix.postScale(f2, f2, (float) ((drawable.getBounds().width() * 3) / 4), (float) drawable.getBounds().height());
        canvas.concat(matrix);
        drawable.setAlpha(100);
        drawable.draw(canvas);
        drawable.setAlpha(255);
        canvas.restoreToCount(saveCount);
        canvas.save();
        canvas.translate(width2, f3);
        matrix.postScale(f2, f2, 0.0f, (float) drawable.getBounds().height());
        canvas.concat(matrix);
        drawable.setAlpha(100);
        drawable.draw(canvas);
        drawable.setAlpha(255);
        canvas.restoreToCount(saveCount);
    }

    /* renamed from: b */
    private void m25352b(Canvas canvas, int i, int i2) {
        float f;
        boolean z;
        float f2;
        float a;
        float f3;
        float a2;
        Matrix matrix = this.f20507h;
        matrix.reset();
        float min = Math.min(1.0f, Math.abs(this.f20508i));
        if (isInEditMode()) {
            this.f20509j = i2;
            min = 1.0f;
        }
        float f4 = this.f20508i;
        boolean z2 = true;
        if (f4 > 1.0f) {
            f = Math.abs(1.0f - f4);
            z = true;
        } else {
            z = false;
            f = 0.0f;
        }
        float f5 = min - 0.5f;
        float f6 = 0.8f;
        if (f5 > 0.0f) {
            f6 = 0.8f + ((f5 / 0.5f) * 0.19999999f);
        }
        int i3 = this.f20509j;
        float f7 = ((float) i3) * min;
        float height = (float) (i3 - (this.f20506g.getBounds().height() / 2));
        if (f7 > height) {
            f2 = f7 - height;
        } else {
            f2 = 0.0f;
            z2 = false;
        }
        float width = (float) ((i / 2) - (this.f20506g.getBounds().width() / 2));
        float height2 = f7 - (z2 ? ((float) (this.f20506g.getBounds().height() / 2)) + f2 : (float) (this.f20506g.getBounds().height() / 2));
        float f8 = z ? (f / 4.0f) + f6 : f6;
        float f9 = z ? (f / 2.0f) + f6 : f6;
        if (this.f20511l && !z) {
            if (m25353b(AnimationPart.FIRST)) {
                a2 = m25349a(AnimationPart.FIRST);
            } else if (m25353b(AnimationPart.SECOND)) {
                a2 = m25349a(AnimationPart.SECOND);
            } else {
                if (m25353b(AnimationPart.THIRD)) {
                    a = m25349a(AnimationPart.THIRD);
                } else {
                    if (m25353b(AnimationPart.FOURTH)) {
                        a = m25349a(AnimationPart.FOURTH);
                    }
                    f9 = f8;
                }
                f3 = f6 + ((a / 80.0f) / 6.0f);
                f8 = f3;
                f9 = f8;
            }
            f3 = f6 - ((a2 / 80.0f) / 8.0f);
            f8 = f3;
            f9 = f8;
        }
        matrix.postScale(f8, f9, (float) (this.f20506g.getBounds().width() / 2), 0.0f);
        float f10 = (float) (i2 + 2);
        if ((((float) this.f20506g.getBounds().height()) * f9) + height2 < f10) {
            height2 = f10 - (f9 * ((float) this.f20506g.getBounds().height()));
        }
        int saveCount = canvas.getSaveCount();
        canvas.save();
        canvas.translate(width, height2);
        canvas.concat(matrix);
        this.f20506g.draw(canvas);
        canvas.restoreToCount(saveCount);
    }

    /* renamed from: c */
    private void m25355c(Canvas canvas, int i, int i2) {
        float f;
        float a;
        float a2;
        Matrix matrix = this.f20507h;
        matrix.reset();
        float f2 = this.f20508i;
        if (isInEditMode()) {
            this.f20509j = i2;
            f2 = 1.0f;
        }
        if (f2 > 1.0f) {
            f = ((float) (1.0d - Math.pow(100.0d, (double) ((-(f2 - 1.0f)) / 2.0f)))) * 20.0f;
            f2 = 1.0f;
        } else {
            f = 0.0f;
        }
        float width = ((((float) i) * f2) / 2.0f) - ((float) (this.f20505f.getBounds().width() / 2));
        float height = (((float) this.f20509j) * (1.0f - (f2 / 2.0f))) - ((float) (this.f20505f.getBounds().height() / 2));
        float f3 = this.f20520u;
        if (f3 > 0.0f) {
            height += (0.0f - height) * f3;
            width += (((float) (i + this.f20505f.getBounds().width())) - width) * this.f20520u;
        }
        if (this.f20511l) {
            if (m25353b(AnimationPart.FIRST)) {
                a2 = m25349a(AnimationPart.FIRST);
            } else if (m25353b(AnimationPart.SECOND)) {
                a2 = m25349a(AnimationPart.SECOND);
            } else {
                if (m25353b(AnimationPart.THIRD)) {
                    a = m25349a(AnimationPart.THIRD);
                } else if (m25353b(AnimationPart.FOURTH)) {
                    a = m25349a(AnimationPart.FOURTH);
                }
                height += a;
            }
            height -= a2;
        }
        if (f > 0.0f) {
            matrix.postRotate(f, (float) (this.f20505f.getBounds().width() / 2), (float) (this.f20505f.getBounds().height() / 2));
        }
        int saveCount = canvas.getSaveCount();
        canvas.save();
        canvas.translate(width, height);
        canvas.concat(matrix);
        this.f20505f.draw(canvas);
        canvas.restoreToCount(saveCount);
    }

    /* renamed from: a */
    private float m25348a(int i, int i2) {
        return (float) (this.f20514o.nextInt((i2 - i) + 1) + i);
    }

    /* renamed from: a */
    private float m25349a(AnimationPart animationPart) {
        float c;
        float f;
        int c2;
        float f2;
        int i = C64603.f20525a[animationPart.ordinal()];
        if (i == 1) {
            return this.f20512m;
        }
        if (i == 2) {
            c = (float) m25354c(AnimationPart.FOURTH);
            f = this.f20512m;
            c2 = m25354c(AnimationPart.FOURTH);
        } else if (i == 3) {
            c = this.f20512m;
            f2 = (float) m25354c(AnimationPart.SECOND);
            return c - f2;
        } else if (i != 4) {
            return 0.0f;
        } else {
            c = (float) m25354c(AnimationPart.THIRD);
            f = this.f20512m;
            c2 = m25354c(AnimationPart.FOURTH);
        }
        f2 = f - ((float) c2);
        return c - f2;
    }

    /* renamed from: b */
    private boolean m25353b(AnimationPart animationPart) {
        boolean z;
        int i = C64603.f20525a[animationPart.ordinal()];
        boolean z2 = false;
        if (i == 1) {
            if (this.f20512m < ((float) m25354c(AnimationPart.FOURTH))) {
                z = true;
            }
            return z;
        } else if (i == 2 || i == 3) {
            if (this.f20512m < ((float) m25354c(animationPart))) {
                z2 = true;
            }
            return z2;
        } else if (i != 4) {
            return false;
        } else {
            if (this.f20512m > ((float) m25354c(AnimationPart.THIRD))) {
                z2 = true;
            }
            return z2;
        }
    }

    /* renamed from: c */
    private int m25354c(AnimationPart animationPart) {
        int i = C64603.f20525a[animationPart.ordinal()];
        if (i == 2) {
            return 40;
        }
        if (i != 3) {
            return i != 4 ? 0 : 20;
        }
        return m25354c(AnimationPart.FOURTH) * 3;
    }
}
