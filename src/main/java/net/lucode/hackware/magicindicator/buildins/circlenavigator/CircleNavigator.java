package net.lucode.hackware.magicindicator.buildins.circlenavigator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.List;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.p694a.IPagerNavigator;

public class CircleNavigator extends View implements IPagerNavigator {
    /* renamed from: a */
    private int f28080a;
    /* renamed from: b */
    private int f28081b;
    /* renamed from: c */
    private int f28082c;
    /* renamed from: d */
    private int f28083d;
    /* renamed from: e */
    private int f28084e;
    /* renamed from: f */
    private int f28085f;
    /* renamed from: g */
    private Interpolator f28086g = new LinearInterpolator();
    /* renamed from: h */
    private Paint f28087h = new Paint(1);
    /* renamed from: i */
    private List<PointF> f28088i = new ArrayList();
    /* renamed from: j */
    private float f28089j;
    /* renamed from: k */
    private boolean f28090k;
    /* renamed from: l */
    private C8352a f28091l;
    /* renamed from: m */
    private float f28092m;
    /* renamed from: n */
    private float f28093n;
    /* renamed from: o */
    private int f28094o;
    /* renamed from: p */
    private boolean f28095p = true;

    /* renamed from: net.lucode.hackware.magicindicator.buildins.circlenavigator.CircleNavigator$a */
    public interface C8352a {
        /* renamed from: a */
        void mo39929a(int i);
    }

    /* renamed from: a */
    public void mo39891a() {
    }

    /* renamed from: b */
    public void mo39894b() {
    }

    /* renamed from: b */
    public void mo39895b(int i) {
    }

    public CircleNavigator(Context context) {
        super(context);
        m35641a(context);
    }

    /* renamed from: a */
    private void m35641a(Context context) {
        this.f28094o = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f28080a = UIUtil.m35640a(context, 3.0d);
        this.f28083d = UIUtil.m35640a(context, 8.0d);
        this.f28082c = UIUtil.m35640a(context, 1.0d);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(m35644c(i), m35646d(i2));
    }

    /* renamed from: c */
    private int m35644c(int i) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int i2 = this.f28085f;
            return (this.f28082c * 2) + (this.f28080a * i2 * 2) + ((i2 - 1) * this.f28083d) + getPaddingLeft() + getPaddingRight();
        } else if (mode != 1073741824) {
            return 0;
        } else {
            return size;
        }
    }

    /* renamed from: d */
    private int m35646d(int i) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            return (this.f28080a * 2) + (this.f28082c * 2) + getPaddingTop() + getPaddingBottom();
        }
        if (mode != 1073741824) {
            return 0;
        }
        return size;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        this.f28087h.setColor(this.f28081b);
        m35642a(canvas);
        m35643b(canvas);
    }

    /* renamed from: a */
    private void m35642a(Canvas canvas) {
        this.f28087h.setStyle(Style.STROKE);
        this.f28087h.setStrokeWidth((float) this.f28082c);
        int size = this.f28088i.size();
        for (int i = 0; i < size; i++) {
            PointF pointF = (PointF) this.f28088i.get(i);
            canvas.drawCircle(pointF.x, pointF.y, (float) this.f28080a, this.f28087h);
        }
    }

    /* renamed from: b */
    private void m35643b(Canvas canvas) {
        this.f28087h.setStyle(Style.FILL);
        if (this.f28088i.size() > 0) {
            canvas.drawCircle(this.f28089j, (float) ((int) ((((float) getHeight()) / 2.0f) + 0.5f)), (float) this.f28080a, this.f28087h);
        }
    }

    /* renamed from: c */
    private void m35645c() {
        this.f28088i.clear();
        if (this.f28085f > 0) {
            int height = (int) ((((float) getHeight()) / 2.0f) + 0.5f);
            int i = this.f28080a;
            int i2 = (i * 2) + this.f28083d;
            int paddingLeft = i + ((int) ((((float) this.f28082c) / 2.0f) + 0.5f)) + getPaddingLeft();
            for (int i3 = 0; i3 < this.f28085f; i3++) {
                this.f28088i.add(new PointF((float) paddingLeft, (float) height));
                paddingLeft += i2;
            }
            this.f28089j = ((PointF) this.f28088i.get(this.f28084e)).x;
        }
    }

    /* renamed from: a */
    public void mo39893a(int i, float f, int i2) {
        if (this.f28095p && !this.f28088i.isEmpty()) {
            int min = Math.min(this.f28088i.size() - 1, i);
            PointF pointF = (PointF) this.f28088i.get(min);
            this.f28089j = pointF.x + ((((PointF) this.f28088i.get(Math.min(this.f28088i.size() - 1, i + 1))).x - pointF.x) * this.f28086g.getInterpolation(f));
            invalidate();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 && this.f28091l != null && Math.abs(x - this.f28092m) <= ((float) this.f28094o) && Math.abs(y - this.f28093n) <= ((float) this.f28094o)) {
                int i = 0;
                float f = Float.MAX_VALUE;
                for (int i2 = 0; i2 < this.f28088i.size(); i2++) {
                    float abs = Math.abs(((PointF) this.f28088i.get(i2)).x - x);
                    if (abs < f) {
                        i = i2;
                        f = abs;
                    }
                }
                this.f28091l.mo39929a(i);
            }
        } else if (this.f28090k) {
            this.f28092m = x;
            this.f28093n = y;
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    /* renamed from: a */
    public void mo39892a(int i) {
        this.f28084e = i;
        if (!this.f28095p) {
            this.f28089j = ((PointF) this.f28088i.get(this.f28084e)).x;
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        m35645c();
    }

    public int getRadius() {
        return this.f28080a;
    }

    public void setRadius(int i) {
        this.f28080a = i;
        m35645c();
        invalidate();
    }

    public int getCircleColor() {
        return this.f28081b;
    }

    public void setCircleColor(int i) {
        this.f28081b = i;
        invalidate();
    }

    public int getStrokeWidth() {
        return this.f28082c;
    }

    public void setStrokeWidth(int i) {
        this.f28082c = i;
        invalidate();
    }

    public int getCircleSpacing() {
        return this.f28083d;
    }

    public void setCircleSpacing(int i) {
        this.f28083d = i;
        m35645c();
        invalidate();
    }

    public Interpolator getStartInterpolator() {
        return this.f28086g;
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.f28086g = interpolator;
        if (this.f28086g == null) {
            this.f28086g = new LinearInterpolator();
        }
    }

    public int getCircleCount() {
        return this.f28085f;
    }

    public void setCircleCount(int i) {
        this.f28085f = i;
    }

    public void setTouchable(boolean z) {
        this.f28090k = z;
    }

    public void setFollowTouch(boolean z) {
        this.f28095p = z;
    }

    public C8352a getCircleClickListener() {
        return this.f28091l;
    }

    public void setCircleClickListener(C8352a aVar) {
        if (!this.f28090k) {
            this.f28090k = true;
        }
        this.f28091l = aVar;
    }
}
