package com.scwang.smartrefresh.header;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.core.graphics.ColorUtils;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
import com.scwang.smartrefresh.layout.p527a.RefreshHeader;
import com.scwang.smartrefresh.layout.p527a.RefreshLayout;
import com.scwang.smartrefresh.layout.p529c.DensityUtil;

public class BezierCircleHeader extends InternalAbstract implements RefreshHeader {
    /* renamed from: a */
    protected Path f20330a;
    /* renamed from: b */
    protected Paint f20331b;
    /* renamed from: c */
    protected Paint f20332c;
    /* renamed from: d */
    protected Paint f20333d;
    /* renamed from: e */
    protected float f20334e;
    /* renamed from: f */
    protected float f20335f;
    /* renamed from: g */
    protected float f20336g;
    /* renamed from: h */
    protected float f20337h;
    /* renamed from: i */
    protected float f20338i;
    /* renamed from: j */
    protected boolean f20339j;
    /* renamed from: k */
    protected boolean f20340k;
    /* renamed from: l */
    protected boolean f20341l;
    /* renamed from: m */
    protected float f20342m;
    /* renamed from: n */
    protected int f20343n;
    /* renamed from: o */
    protected int f20344o;
    /* renamed from: p */
    protected boolean f20345p;
    /* renamed from: q */
    protected boolean f20346q;

    public BezierCircleHeader(Context context) {
        this(context, null);
    }

    public BezierCircleHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BezierCircleHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f20343n = 90;
        this.f20344o = 90;
        this.f20345p = true;
        this.f20346q = false;
        this.f20937ab = SpinnerStyle.Scale;
        setMinimumHeight(DensityUtil.m25572a(100.0f));
        this.f20331b = new Paint();
        this.f20331b.setColor(-15614977);
        this.f20331b.setAntiAlias(true);
        this.f20332c = new Paint();
        this.f20332c.setColor(-1);
        this.f20332c.setAntiAlias(true);
        this.f20333d = new Paint();
        this.f20333d.setAntiAlias(true);
        this.f20333d.setColor(-1);
        this.f20333d.setStyle(Style.STROKE);
        this.f20333d.setStrokeWidth((float) DensityUtil.m25572a(2.0f));
        this.f20330a = new Path();
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        if (isInEditMode()) {
            this.f20339j = true;
            this.f20341l = true;
            this.f20335f = (float) height;
            this.f20343n = 270;
            float f = this.f20335f;
            this.f20338i = f / 2.0f;
            this.f20342m = f / 6.0f;
        }
        m25273a(canvas, width, height);
        m25271a(canvas, width);
        m25274b(canvas, width);
        m25275c(canvas, width);
        m25276d(canvas, width);
        super.dispatchDraw(canvas);
    }

    /* renamed from: a */
    private void m25273a(Canvas canvas, int i, int i2) {
        float min = Math.min(this.f20335f, (float) i2);
        if (this.f20334e != 0.0f) {
            this.f20330a.reset();
            float f = (float) i;
            this.f20330a.lineTo(f, 0.0f);
            this.f20330a.lineTo(f, min);
            this.f20330a.quadTo((float) (i / 2), (this.f20334e * 2.0f) + min, 0.0f, min);
            this.f20330a.close();
            canvas.drawPath(this.f20330a, this.f20331b);
            return;
        }
        canvas.drawRect(0.0f, 0.0f, (float) i, min, this.f20331b);
    }

    /* renamed from: a */
    private void m25271a(Canvas canvas, int i) {
        float f = this.f20336g;
        if (f > 0.0f) {
            float f2 = (float) (i / 2);
            float f3 = this.f20342m;
            float f4 = (f2 - (4.0f * f3)) + (3.0f * f * f3);
            if (((double) f) < 0.9d) {
                this.f20330a.reset();
                this.f20330a.moveTo(f4, this.f20338i);
                Path path = this.f20330a;
                float f5 = this.f20338i;
                path.quadTo(f2, f5 - ((this.f20342m * this.f20336g) * 2.0f), ((float) i) - f4, f5);
                canvas.drawPath(this.f20330a, this.f20332c);
                return;
            }
            canvas.drawCircle(f2, this.f20338i, f3, this.f20332c);
        }
    }

    /* renamed from: b */
    private void m25274b(Canvas canvas, int i) {
        if (this.f20339j) {
            canvas.drawCircle((float) (i / 2), this.f20338i, this.f20342m, this.f20332c);
            float f = this.f20335f;
            m25272a(canvas, i, (this.f20334e + f) / f);
        }
    }

    /* renamed from: a */
    private void m25272a(Canvas canvas, int i, float f) {
        if (this.f20340k) {
            float f2 = this.f20335f + this.f20334e;
            float f3 = this.f20338i;
            float f4 = this.f20342m;
            float f5 = f3 + ((f4 * f) / 2.0f);
            float f6 = (float) (i / 2);
            float sqrt = ((float) Math.sqrt((double) (f4 * f4 * (1.0f - ((f * f) / 4.0f))))) + f6;
            float f7 = this.f20342m;
            float f8 = f6 + (((3.0f * f7) / 4.0f) * (1.0f - f));
            float f9 = f7 + f8;
            this.f20330a.reset();
            this.f20330a.moveTo(sqrt, f5);
            this.f20330a.quadTo(f8, f2, f9, f2);
            float f10 = (float) i;
            this.f20330a.lineTo(f10 - f9, f2);
            this.f20330a.quadTo(f10 - f8, f2, f10 - sqrt, f5);
            canvas.drawPath(this.f20330a, this.f20332c);
        }
    }

    /* renamed from: c */
    private void m25275c(Canvas canvas, int i) {
        if (this.f20341l) {
            float strokeWidth = this.f20342m + (this.f20333d.getStrokeWidth() * 2.0f);
            int i2 = 3;
            this.f20344o += this.f20345p ? 3 : 10;
            int i3 = this.f20343n;
            if (this.f20345p) {
                i2 = 10;
            }
            this.f20343n = i3 + i2;
            this.f20344o %= 360;
            this.f20343n %= 360;
            int i4 = this.f20343n - this.f20344o;
            if (i4 < 0) {
                i4 += 360;
            }
            float f = (float) (i / 2);
            float f2 = f - strokeWidth;
            float f3 = this.f20338i;
            canvas.drawArc(new RectF(f2, f3 - strokeWidth, f + strokeWidth, f3 + strokeWidth), (float) this.f20344o, (float) i4, false, this.f20333d);
            if (i4 >= 270) {
                this.f20345p = false;
            } else if (i4 <= 10) {
                this.f20345p = true;
            }
            invalidate();
        }
    }

    /* renamed from: d */
    private void m25276d(Canvas canvas, int i) {
        Canvas canvas2 = canvas;
        int i2 = i;
        if (this.f20337h > 0.0f) {
            int color = this.f20333d.getColor();
            if (((double) this.f20337h) < 0.3d) {
                int i3 = i2 / 2;
                canvas2.drawCircle((float) i3, this.f20338i, this.f20342m, this.f20332c);
                float f = this.f20342m;
                float strokeWidth = this.f20333d.getStrokeWidth() * 2.0f;
                float f2 = this.f20337h;
                int i4 = (int) (f + (strokeWidth * ((f2 / 0.3f) + 1.0f)));
                this.f20333d.setColor(ColorUtils.setAlphaComponent(color, (int) ((1.0f - (f2 / 0.3f)) * 255.0f)));
                float f3 = (float) (i3 - i4);
                float f4 = this.f20338i;
                float f5 = (float) i4;
                canvas.drawArc(new RectF(f3, f4 - f5, (float) (i3 + i4), f4 + f5), 0.0f, 360.0f, false, this.f20333d);
            }
            this.f20333d.setColor(color);
            float f6 = this.f20337h;
            if (((double) f6) >= 0.3d && ((double) f6) < 0.7d) {
                float f7 = (f6 - 0.3f) / 0.4f;
                float f8 = this.f20335f;
                this.f20338i = (float) ((int) ((f8 / 2.0f) + ((f8 - (f8 / 2.0f)) * f7)));
                canvas2.drawCircle((float) (i2 / 2), this.f20338i, this.f20342m, this.f20332c);
                if (this.f20338i >= this.f20335f - (this.f20342m * 2.0f)) {
                    this.f20340k = true;
                    m25272a(canvas2, i2, f7);
                }
                this.f20340k = false;
            }
            float f9 = this.f20337h;
            if (((double) f9) >= 0.7d && f9 <= 1.0f) {
                float f10 = (f9 - 0.7f) / 0.3f;
                float f11 = (float) (i2 / 2);
                float f12 = this.f20342m;
                int i5 = (int) ((f11 - f12) - ((f12 * 2.0f) * f10));
                this.f20330a.reset();
                this.f20330a.moveTo((float) i5, this.f20335f);
                Path path = this.f20330a;
                float f13 = this.f20335f;
                path.quadTo(f11, f13 - (this.f20342m * (1.0f - f10)), (float) (i2 - i5), f13);
                canvas2.drawPath(this.f20330a, this.f20332c);
            }
        }
    }

    /* renamed from: a */
    public void mo30672a(boolean z, float f, int i, int i2, int i3) {
        if (z || this.f20346q) {
            this.f20346q = true;
            this.f20335f = (float) i2;
            this.f20334e = ((float) Math.max(i - i2, 0)) * 0.8f;
        }
    }

    /* renamed from: a */
    public void mo30671a(RefreshLayout jVar, int i, int i2) {
        this.f20346q = false;
        this.f20335f = (float) i;
        this.f20342m = (float) (i / 6);
        DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
        final float min = Math.min(this.f20334e * 0.8f, this.f20335f / 2.0f);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.f20334e, 0.0f, -(1.0f * min), 0.0f, -(0.4f * min), 0.0f});
        ofFloat.addUpdateListener(new AnimatorUpdateListener() {
            /* renamed from: a */
            float f20347a = 0.0f;
            /* renamed from: b */
            float f20348b;
            /* renamed from: c */
            float f20349c = 0.0f;
            /* renamed from: d */
            int f20350d = 0;

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (this.f20350d == 0 && floatValue <= 0.0f) {
                    this.f20350d = 1;
                    this.f20347a = Math.abs(floatValue - BezierCircleHeader.this.f20334e);
                }
                if (this.f20350d == 1) {
                    this.f20349c = (-floatValue) / min;
                    if (this.f20349c >= BezierCircleHeader.this.f20336g) {
                        BezierCircleHeader bezierCircleHeader = BezierCircleHeader.this;
                        bezierCircleHeader.f20336g = this.f20349c;
                        bezierCircleHeader.f20338i = bezierCircleHeader.f20335f + floatValue;
                        this.f20347a = Math.abs(floatValue - BezierCircleHeader.this.f20334e);
                    } else {
                        this.f20350d = 2;
                        BezierCircleHeader bezierCircleHeader2 = BezierCircleHeader.this;
                        bezierCircleHeader2.f20336g = 0.0f;
                        bezierCircleHeader2.f20339j = true;
                        bezierCircleHeader2.f20340k = true;
                        this.f20348b = bezierCircleHeader2.f20338i;
                    }
                }
                if (this.f20350d == 2 && BezierCircleHeader.this.f20338i > BezierCircleHeader.this.f20335f / 2.0f) {
                    BezierCircleHeader bezierCircleHeader3 = BezierCircleHeader.this;
                    bezierCircleHeader3.f20338i = Math.max(bezierCircleHeader3.f20335f / 2.0f, BezierCircleHeader.this.f20338i - this.f20347a);
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    float f = BezierCircleHeader.this.f20335f / 2.0f;
                    float f2 = this.f20348b;
                    float f3 = (animatedFraction * (f - f2)) + f2;
                    if (BezierCircleHeader.this.f20338i > f3) {
                        BezierCircleHeader.this.f20338i = f3;
                    }
                }
                if (BezierCircleHeader.this.f20340k && floatValue < BezierCircleHeader.this.f20334e) {
                    BezierCircleHeader bezierCircleHeader4 = BezierCircleHeader.this;
                    bezierCircleHeader4.f20341l = true;
                    bezierCircleHeader4.f20340k = false;
                    bezierCircleHeader4.f20345p = true;
                    bezierCircleHeader4.f20344o = 90;
                    bezierCircleHeader4.f20343n = 90;
                }
                if (!BezierCircleHeader.this.f20346q) {
                    BezierCircleHeader bezierCircleHeader5 = BezierCircleHeader.this;
                    bezierCircleHeader5.f20334e = floatValue;
                    bezierCircleHeader5.invalidate();
                }
            }
        });
        ofFloat.setInterpolator(decelerateInterpolator);
        ofFloat.setDuration(1000);
        ofFloat.start();
    }

    /* renamed from: a */
    public int mo30670a(RefreshLayout jVar, boolean z) {
        this.f20339j = false;
        this.f20341l = false;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                BezierCircleHeader bezierCircleHeader = BezierCircleHeader.this;
                bezierCircleHeader.f20337h = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                bezierCircleHeader.invalidate();
            }
        });
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.setDuration(800);
        ofFloat.start();
        return 800;
    }

    @Deprecated
    public void setPrimaryColors(int... iArr) {
        if (iArr.length > 0) {
            this.f20331b.setColor(iArr[0]);
            if (iArr.length > 1) {
                this.f20332c.setColor(iArr[1]);
                this.f20333d.setColor(iArr[1]);
            }
        }
    }
}
