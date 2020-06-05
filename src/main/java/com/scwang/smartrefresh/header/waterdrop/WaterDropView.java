package com.scwang.smartrefresh.header.waterdrop;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.scwang.smartrefresh.layout.p529c.DensityUtil;

public class WaterDropView extends View {
    /* renamed from: g */
    protected static int f20681g = 2;
    /* renamed from: a */
    protected Circle f20682a = new Circle();
    /* renamed from: b */
    protected Circle f20683b = new Circle();
    /* renamed from: c */
    protected Path f20684c = new Path();
    /* renamed from: d */
    protected Paint f20685d = new Paint();
    /* renamed from: e */
    protected int f20686e;
    /* renamed from: f */
    protected int f20687f;

    /* renamed from: a */
    public void mo30820a(int i, int i2) {
    }

    public WaterDropView(Context context) {
        super(context);
        this.f20685d.setColor(-7829368);
        this.f20685d.setAntiAlias(true);
        this.f20685d.setStyle(Style.FILL_AND_STROKE);
        Paint paint = this.f20685d;
        int a = DensityUtil.m25572a(1.0f);
        f20681g = a;
        paint.setStrokeWidth((float) a);
        Paint paint2 = this.f20685d;
        int i = f20681g;
        paint2.setShadowLayer((float) i, (float) (i / 2), (float) i, -1728053248);
        setLayerType(1, null);
        int i2 = f20681g * 4;
        setPadding(i2, i2, i2, i2);
        this.f20685d.setColor(-7829368);
        this.f20686e = DensityUtil.m25572a(20.0f);
        int i3 = this.f20686e;
        this.f20687f = i3 / 5;
        Circle aVar = this.f20682a;
        aVar.f20691c = (float) i3;
        Circle aVar2 = this.f20683b;
        aVar2.f20691c = (float) i3;
        int i4 = f20681g;
        aVar.f20689a = (float) (i4 + i3);
        aVar.f20690b = (float) (i4 + i3);
        aVar2.f20689a = (float) (i4 + i3);
        aVar2.f20690b = (float) (i4 + i3);
    }

    public int getMaxCircleRadius() {
        return this.f20686e;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.setMeasuredDimension(((this.f20686e + f20681g) * 2) + getPaddingLeft() + getPaddingRight(), View.resolveSize(((int) Math.ceil((double) (this.f20683b.f20690b + this.f20683b.f20691c + ((float) (f20681g * 2))))) + getPaddingTop() + getPaddingBottom(), i2));
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        mo30819a(getHeight());
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        canvas.save();
        float f = (float) height;
        float f2 = (float) paddingTop;
        float f3 = (float) paddingBottom;
        if (f <= (this.f20682a.f20691c * 2.0f) + f2 + f3) {
            canvas.translate((float) paddingLeft, (f - (this.f20682a.f20691c * 2.0f)) - f3);
            canvas.drawCircle(this.f20682a.f20689a, this.f20682a.f20690b, this.f20682a.f20691c, this.f20685d);
        } else {
            canvas.translate((float) paddingLeft, f2);
            m25448b();
            canvas.drawPath(this.f20684c, this.f20685d);
        }
        canvas.restore();
    }

    /* renamed from: b */
    private void m25448b() {
        this.f20684c.reset();
        this.f20684c.addCircle(this.f20682a.f20689a, this.f20682a.f20690b, this.f20682a.f20691c, Direction.CCW);
        if (this.f20683b.f20690b > this.f20682a.f20690b + ((float) DensityUtil.m25572a(1.0f))) {
            this.f20684c.addCircle(this.f20683b.f20689a, this.f20683b.f20690b, this.f20683b.f20691c, Direction.CCW);
            double angle = getAngle();
            float cos = (float) (((double) this.f20682a.f20689a) - (((double) this.f20682a.f20691c) * Math.cos(angle)));
            float sin = (float) (((double) this.f20682a.f20690b) + (((double) this.f20682a.f20691c) * Math.sin(angle)));
            float cos2 = (float) (((double) this.f20682a.f20689a) + (((double) this.f20682a.f20691c) * Math.cos(angle)));
            float cos3 = (float) (((double) this.f20683b.f20689a) - (((double) this.f20683b.f20691c) * Math.cos(angle)));
            float sin2 = (float) (((double) this.f20683b.f20690b) + (((double) this.f20683b.f20691c) * Math.sin(angle)));
            float cos4 = (float) (((double) this.f20683b.f20689a) + (((double) this.f20683b.f20691c) * Math.cos(angle)));
            this.f20684c.moveTo(this.f20682a.f20689a, this.f20682a.f20690b);
            this.f20684c.lineTo(cos, sin);
            this.f20684c.quadTo(this.f20683b.f20689a - this.f20683b.f20691c, (this.f20683b.f20690b + this.f20682a.f20690b) / 2.0f, cos3, sin2);
            this.f20684c.lineTo(cos4, sin2);
            this.f20684c.quadTo(this.f20683b.f20689a + this.f20683b.f20691c, (this.f20683b.f20690b + sin) / 2.0f, cos2, sin);
        }
        this.f20684c.close();
    }

    private double getAngle() {
        if (this.f20683b.f20691c > this.f20682a.f20691c) {
            return 0.0d;
        }
        return Math.asin((double) ((this.f20682a.f20691c - this.f20683b.f20691c) / (this.f20683b.f20690b - this.f20682a.f20690b)));
    }

    /* renamed from: a */
    public ValueAnimator mo30817a() {
        ValueAnimator duration = ValueAnimator.ofFloat(new float[]{1.0f, 0.001f}).setDuration(180);
        duration.setInterpolator(new DecelerateInterpolator());
        duration.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                WaterDropView.this.mo30818a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                WaterDropView.this.postInvalidate();
            }
        });
        return duration;
    }

    /* renamed from: a */
    public void mo30818a(float f) {
        int i = this.f20686e;
        float f2 = (float) (((double) i) - ((((double) f) * 0.25d) * ((double) i)));
        float f3 = (((float) (this.f20687f - i)) * f) + ((float) i);
        float f4 = f * 4.0f * ((float) i);
        Circle aVar = this.f20682a;
        aVar.f20691c = f2;
        Circle aVar2 = this.f20683b;
        aVar2.f20691c = f3;
        aVar2.f20690b = aVar.f20690b + f4;
    }

    /* renamed from: a */
    public void mo30819a(int i) {
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i2 = this.f20686e;
        float f = (float) ((i2 * 2) + paddingTop + paddingBottom);
        float f2 = (float) i;
        if (f2 < f) {
            Circle aVar = this.f20682a;
            aVar.f20691c = (float) i2;
            Circle aVar2 = this.f20683b;
            aVar2.f20691c = (float) i2;
            aVar2.f20690b = aVar.f20690b;
            return;
        }
        float pow = (float) (((double) ((float) (i2 - this.f20687f))) * (1.0d - Math.pow(100.0d, (double) ((-Math.max(0.0f, f2 - f)) / ((float) DensityUtil.m25572a(200.0f))))));
        Circle aVar3 = this.f20682a;
        int i3 = this.f20686e;
        aVar3.f20691c = ((float) i3) - (pow / 4.0f);
        Circle aVar4 = this.f20683b;
        aVar4.f20691c = ((float) i3) - pow;
        aVar4.f20690b = ((float) ((i - paddingTop) - paddingBottom)) - aVar4.f20691c;
    }

    public Circle getTopCircle() {
        return this.f20682a;
    }

    public Circle getBottomCircle() {
        return this.f20683b;
    }

    public void setIndicatorColor(int i) {
        this.f20685d.setColor(i);
    }

    public int getIndicatorColor() {
        return this.f20685d.getColor();
    }
}
