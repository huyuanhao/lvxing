package com.bytedance.sdk.openadsdk.core.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.LinearInterpolator;

public class TTCountdownView extends View {
    /* access modifiers changed from: private */
    /* renamed from: A */
    public boolean f8244A;
    /* renamed from: a */
    private int f8245a;
    /* renamed from: b */
    private int f8246b;
    /* renamed from: c */
    private int f8247c;
    /* renamed from: d */
    private int f8248d;
    /* renamed from: e */
    private float f8249e;
    /* renamed from: f */
    private float f8250f;
    /* renamed from: g */
    private float f8251g;
    /* renamed from: h */
    private int f8252h;
    /* renamed from: i */
    private boolean f8253i;
    /* renamed from: j */
    private float f8254j;
    /* renamed from: k */
    private float f8255k;
    /* renamed from: l */
    private float f8256l;
    /* renamed from: m */
    private String f8257m;
    /* renamed from: n */
    private boolean f8258n;
    /* renamed from: o */
    private Paint f8259o;
    /* renamed from: p */
    private Paint f8260p;
    /* renamed from: q */
    private Paint f8261q;
    /* renamed from: r */
    private Paint f8262r;
    /* access modifiers changed from: private */
    /* renamed from: s */
    public float f8263s;
    /* access modifiers changed from: private */
    /* renamed from: t */
    public float f8264t;
    /* renamed from: u */
    private RectF f8265u;
    /* access modifiers changed from: private */
    /* renamed from: v */
    public C2354a f8266v;
    /* renamed from: w */
    private AnimatorSet f8267w;
    /* renamed from: x */
    private ValueAnimator f8268x;
    /* renamed from: y */
    private ValueAnimator f8269y;
    /* renamed from: z */
    private ValueAnimator f8270z;

    /* renamed from: com.bytedance.sdk.openadsdk.core.widget.TTCountdownView$a */
    public interface C2354a {
        /* renamed from: a */
        void mo15255a();

        /* renamed from: b */
        void mo15256b();
    }

    /* renamed from: a */
    public float mo16248a(float f, float f2) {
        return f * f2;
    }

    /* renamed from: a */
    public float mo16249a(float f, int i) {
        return ((float) i) * f;
    }

    public TTCountdownView(Context context) {
        this(context, null);
    }

    public TTCountdownView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TTCountdownView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8245a = Color.parseColor("#fce8b6");
        this.f8246b = Color.parseColor("#f0f0f0");
        this.f8247c = Color.parseColor("#ffffff");
        this.f8248d = Color.parseColor("#7c7c7c");
        this.f8249e = 2.0f;
        this.f8250f = 12.0f;
        this.f8251g = 18.0f;
        this.f8252h = 270;
        this.f8253i = false;
        this.f8254j = 5.0f;
        this.f8255k = 5.0f;
        this.f8256l = 0.8f;
        this.f8257m = "跳过";
        this.f8258n = false;
        this.f8263s = 1.0f;
        this.f8264t = 1.0f;
        this.f8244A = false;
        this.f8249e = m10751a(2.0f);
        this.f8251g = m10751a(18.0f);
        this.f8250f = m10756b(12.0f);
        this.f8252h %= 360;
        m10760c();
        m10761d();
    }

    /* renamed from: c */
    private void m10760c() {
        this.f8259o = new Paint(1);
        this.f8259o.setColor(this.f8245a);
        this.f8259o.setStrokeWidth(this.f8249e);
        this.f8259o.setAntiAlias(true);
        this.f8259o.setStyle(Style.STROKE);
        this.f8260p = new Paint(1);
        this.f8260p.setColor(this.f8247c);
        this.f8260p.setAntiAlias(true);
        this.f8260p.setStrokeWidth(this.f8249e);
        this.f8260p.setStyle(Style.FILL);
        this.f8261q = new Paint(1);
        this.f8261q.setColor(this.f8246b);
        this.f8261q.setAntiAlias(true);
        this.f8261q.setStrokeWidth(this.f8249e / 2.0f);
        this.f8261q.setStyle(Style.STROKE);
        this.f8262r = new Paint(1);
        this.f8262r.setColor(this.f8248d);
        this.f8261q.setAntiAlias(true);
        this.f8262r.setTextSize(this.f8250f);
        this.f8262r.setTextAlign(Align.CENTER);
    }

    /* renamed from: d */
    private void m10761d() {
        float f = this.f8251g;
        this.f8265u = new RectF(-f, -f, f, f);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = MeasureSpec.getSize(i);
        int mode = MeasureSpec.getMode(i);
        int size2 = MeasureSpec.getSize(i2);
        int mode2 = MeasureSpec.getMode(i2);
        if (mode != 1073741824) {
            size = m10762e();
        }
        if (mode2 != 1073741824) {
            size2 = m10762e();
        }
        setMeasuredDimension(size, size2);
    }

    /* renamed from: e */
    private int m10762e() {
        return (int) ((((this.f8249e / 2.0f) + this.f8251g) * 2.0f) + m10751a(4.0f));
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(((float) getMeasuredWidth()) / 2.0f, ((float) getMeasuredHeight()) / 2.0f);
        m10759b(canvas);
        m10753a(canvas);
    }

    /* renamed from: a */
    private void m10753a(Canvas canvas) {
        String str;
        canvas.save();
        FontMetrics fontMetrics = this.f8262r.getFontMetrics();
        if (this.f8258n) {
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append((int) Math.ceil((double) mo16248a(this.f8264t, this.f8255k)));
            str = sb.toString();
        } else {
            str = this.f8257m;
        }
        if (TextUtils.isEmpty(str)) {
            str = "跳过";
        }
        canvas.drawText(str, 0.0f, 0.0f - ((fontMetrics.ascent + fontMetrics.descent) / 2.0f), this.f8262r);
        canvas.restore();
    }

    /* renamed from: b */
    private void m10759b(Canvas canvas) {
        float f;
        canvas.save();
        float a = mo16249a(this.f8263s, 360);
        if (this.f8253i) {
            f = ((float) this.f8252h) - a;
        } else {
            f = (float) this.f8252h;
        }
        float f2 = f;
        canvas.drawCircle(0.0f, 0.0f, this.f8251g, this.f8260p);
        canvas.drawCircle(0.0f, 0.0f, this.f8251g, this.f8261q);
        canvas.drawArc(this.f8265u, f2, a, false, this.f8259o);
        canvas.restore();
    }

    /* renamed from: a */
    public void mo16250a() {
        AnimatorSet animatorSet = this.f8267w;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.f8267w.cancel();
            this.f8267w = null;
        }
        this.f8267w = new AnimatorSet();
        this.f8267w.playTogether(new Animator[]{getNumAnim(), getArcAnim()});
        this.f8267w.setInterpolator(new LinearInterpolator());
        this.f8267w.addListener(new AnimatorListenerAdapter() {
            public void onAnimationCancel(Animator animator) {
                TTCountdownView.this.f8244A = true;
            }

            public void onAnimationEnd(Animator animator) {
                if (TTCountdownView.this.f8244A) {
                    TTCountdownView.this.f8244A = false;
                    return;
                }
                if (TTCountdownView.this.f8266v != null) {
                    TTCountdownView.this.f8266v.mo15256b();
                }
            }

            public void onAnimationStart(Animator animator) {
                if (TTCountdownView.this.f8266v != null) {
                    TTCountdownView.this.f8266v.mo15255a();
                }
            }
        });
        this.f8267w.start();
    }

    private ValueAnimator getNumAnim() {
        ValueAnimator valueAnimator = this.f8268x;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f8268x = null;
        }
        this.f8268x = ValueAnimator.ofFloat(new float[]{this.f8264t, 0.0f});
        this.f8268x.setInterpolator(new LinearInterpolator());
        this.f8268x.setDuration((long) (mo16248a(this.f8264t, this.f8255k) * 1000.0f));
        this.f8268x.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                TTCountdownView.this.f8264t = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                TTCountdownView.this.postInvalidate();
            }
        });
        return this.f8268x;
    }

    private ValueAnimator getArcAnim() {
        ValueAnimator valueAnimator = this.f8269y;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f8269y = null;
        }
        this.f8269y = ValueAnimator.ofFloat(new float[]{this.f8263s, 0.0f});
        this.f8269y.setInterpolator(new LinearInterpolator());
        this.f8269y.setDuration((long) (mo16248a(this.f8263s, this.f8254j) * 1000.0f));
        this.f8269y.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                TTCountdownView.this.f8263s = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                TTCountdownView.this.postInvalidate();
            }
        });
        return this.f8269y;
    }

    /* renamed from: b */
    public void mo16251b() {
        AnimatorSet animatorSet = this.f8267w;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.f8267w = null;
        }
        ValueAnimator valueAnimator = this.f8270z;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f8270z = null;
        }
        ValueAnimator valueAnimator2 = this.f8268x;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
            this.f8268x = null;
        }
        ValueAnimator valueAnimator3 = this.f8269y;
        if (valueAnimator3 != null) {
            valueAnimator3.cancel();
            this.f8269y = null;
        }
        this.f8263s = 1.0f;
        this.f8264t = 1.0f;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        mo16251b();
        super.onDetachedFromWindow();
    }

    public void setCountDownTime(int i) {
        float f = (float) i;
        this.f8255k = f;
        this.f8254j = f;
        mo16251b();
    }

    /* renamed from: a */
    private float m10751a(float f) {
        return TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }

    /* renamed from: b */
    private float m10756b(float f) {
        return TypedValue.applyDimension(2, f, getResources().getDisplayMetrics());
    }

    public C2354a getCountdownListener() {
        return this.f8266v;
    }

    public void setCountdownListener(C2354a aVar) {
        this.f8266v = aVar;
    }
}
