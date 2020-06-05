package com.scwang.smartrefresh.header.flyrefresh;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.scwang.smartrefresh.header.R;
import com.tencent.bugly.beta.tinker.TinkerReport;

public class MountainSceneView extends View {
    /* renamed from: a */
    protected int f20555a;
    /* renamed from: b */
    protected int f20556b;
    /* renamed from: c */
    protected int f20557c;
    /* renamed from: d */
    protected int f20558d;
    /* renamed from: e */
    protected int f20559e;
    /* renamed from: f */
    protected int f20560f;
    /* renamed from: g */
    protected int f20561g;
    /* renamed from: h */
    protected int f20562h;
    /* renamed from: i */
    protected int f20563i;
    /* renamed from: j */
    protected int f20564j;
    /* renamed from: k */
    protected Paint f20565k;
    /* renamed from: l */
    protected Paint f20566l;
    /* renamed from: m */
    protected Paint f20567m;
    /* renamed from: n */
    protected Paint f20568n;
    /* renamed from: o */
    protected Path f20569o;
    /* renamed from: p */
    protected Path f20570p;
    /* renamed from: q */
    protected Path f20571q;
    /* renamed from: r */
    protected Path f20572r;
    /* renamed from: s */
    protected Path f20573s;
    /* renamed from: t */
    protected Matrix f20574t;
    /* renamed from: u */
    protected float f20575u;
    /* renamed from: v */
    protected float f20576v;
    /* renamed from: w */
    protected float f20577w;
    /* renamed from: x */
    protected float f20578x;
    /* renamed from: y */
    protected float f20579y;
    /* renamed from: z */
    protected int f20580z;

    public MountainSceneView(Context context) {
        this(context, null);
    }

    public MountainSceneView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20555a = -8466743;
        this.f20556b = -7939369;
        this.f20557c = -12807524;
        this.f20558d = -12689549;
        this.f20559e = -14716553;
        this.f20560f = -15974840;
        this.f20561g = -13334385;
        this.f20562h = -14982807;
        this.f20563i = -11030098;
        this.f20564j = -10312531;
        this.f20565k = new Paint();
        this.f20566l = new Paint();
        this.f20567m = new Paint();
        this.f20568n = new Paint();
        this.f20569o = new Path();
        this.f20570p = new Path();
        this.f20571q = new Path();
        this.f20572r = new Path();
        this.f20573s = new Path();
        this.f20574t = new Matrix();
        this.f20575u = 5.0f;
        this.f20576v = 5.0f;
        this.f20577w = 0.0f;
        this.f20578x = 1.0f;
        this.f20579y = Float.MAX_VALUE;
        this.f20580z = 0;
        this.f20565k.setAntiAlias(true);
        this.f20565k.setStyle(Style.FILL);
        this.f20566l.setAntiAlias(true);
        this.f20567m.setAntiAlias(true);
        this.f20568n.setAntiAlias(true);
        this.f20568n.setStyle(Style.STROKE);
        this.f20568n.setStrokeWidth(2.0f);
        this.f20568n.setStrokeJoin(Join.ROUND);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MountainSceneView);
        if (obtainStyledAttributes.hasValue(R.styleable.MountainSceneView_msvPrimaryColor)) {
            setPrimaryColor(obtainStyledAttributes.getColor(R.styleable.MountainSceneView_msvPrimaryColor, ViewCompat.MEASURED_STATE_MASK));
        }
        this.f20580z = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.MountainSceneView_msvViewportHeight, 0);
        obtainStyledAttributes.recycle();
        m25375a(this.f20577w, (int) TinkerReport.KEY_APPLIED_VERSION_CHECK);
        m25376a(this.f20577w, true);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.f20575u = (((float) measuredWidth) * 1.0f) / 240.0f;
        int i3 = this.f20580z;
        if (i3 <= 0) {
            i3 = measuredHeight;
        }
        this.f20576v = (((float) i3) * 1.0f) / 180.0f;
        m25375a(this.f20577w, measuredHeight);
        m25376a(this.f20577w, true);
    }

    /* renamed from: a */
    private void m25375a(float f, int i) {
        this.f20574t.reset();
        this.f20574t.setScale(this.f20575u, this.f20576v);
        float f2 = 10.0f * f;
        this.f20569o.reset();
        this.f20569o.moveTo(0.0f, 95.0f + f2);
        this.f20569o.lineTo(55.0f, 74.0f + f2);
        this.f20569o.lineTo(146.0f, f2 + 104.0f);
        this.f20569o.lineTo(227.0f, 72.0f + f2);
        this.f20569o.lineTo(240.0f, f2 + 80.0f);
        this.f20569o.lineTo(240.0f, 180.0f);
        this.f20569o.lineTo(0.0f, 180.0f);
        this.f20569o.close();
        this.f20569o.transform(this.f20574t);
        float f3 = 20.0f * f;
        this.f20570p.reset();
        this.f20570p.moveTo(0.0f, 103.0f + f3);
        this.f20570p.lineTo(67.0f, 90.0f + f3);
        this.f20570p.lineTo(165.0f, 115.0f + f3);
        this.f20570p.lineTo(221.0f, 87.0f + f3);
        this.f20570p.lineTo(240.0f, f3 + 100.0f);
        this.f20570p.lineTo(240.0f, 180.0f);
        this.f20570p.lineTo(0.0f, 180.0f);
        this.f20570p.close();
        this.f20570p.transform(this.f20574t);
        float f4 = f * 30.0f;
        this.f20571q.reset();
        this.f20571q.moveTo(0.0f, 114.0f + f4);
        this.f20571q.cubicTo(30.0f, f4 + 106.0f, 196.0f, f4 + 97.0f, 240.0f, f4 + 104.0f);
        float f5 = (float) i;
        this.f20571q.lineTo(240.0f, f5 / this.f20576v);
        this.f20571q.lineTo(0.0f, f5 / this.f20576v);
        this.f20571q.close();
        this.f20571q.transform(this.f20574t);
    }

    /* renamed from: a */
    private void m25376a(float f, boolean z) {
        int i;
        if (f != this.f20579y || z) {
            Interpolator create = PathInterpolatorCompat.create(0.8f, -0.5f * f);
            float f2 = f * 30.000002f;
            float[] fArr = new float[26];
            float[] fArr2 = new float[26];
            int i2 = 0;
            float f3 = 0.0f;
            float f4 = 200.0f;
            while (true) {
                if (i2 > 25) {
                    break;
                }
                fArr[i2] = (create.getInterpolation(f3) * f2) + 50.0f;
                fArr2[i2] = f4;
                f4 -= 0.5f;
                f3 += 0.04f;
                i2++;
            }
            this.f20572r.reset();
            this.f20572r.moveTo(45.0f, 200.0f);
            int i3 = (int) (((float) 17) * 0.5f);
            float f5 = (float) (17 - i3);
            for (int i4 = 0; i4 < 17; i4++) {
                if (i4 < i3) {
                    this.f20572r.lineTo(fArr[i4] - 5.0f, fArr2[i4]);
                } else {
                    this.f20572r.lineTo(fArr[i4] - ((((float) (17 - i4)) * 5.0f) / f5), fArr2[i4]);
                }
            }
            for (int i5 = 16; i5 >= 0; i5--) {
                if (i5 < i3) {
                    this.f20572r.lineTo(fArr[i5] + 5.0f, fArr2[i5]);
                } else {
                    this.f20572r.lineTo(fArr[i5] + ((((float) (17 - i5)) * 5.0f) / f5), fArr2[i5]);
                }
            }
            this.f20572r.close();
            this.f20573s.reset();
            float f6 = (float) 15;
            this.f20573s.moveTo(fArr[10] - 20.0f, fArr2[10]);
            this.f20573s.addArc(new RectF(fArr[10] - 20.0f, fArr2[10] - 20.0f, fArr[10] + 20.0f, fArr2[10] + 20.0f), 0.0f, 180.0f);
            for (int i6 = 10; i6 <= 25; i6++) {
                float f7 = ((float) (i6 - 10)) / f6;
                this.f20573s.lineTo((fArr[i6] - 20.0f) + (f7 * f7 * 20.0f), fArr2[i6]);
            }
            for (i = 25; i >= 10; i--) {
                float f8 = ((float) (i - 10)) / f6;
                this.f20573s.lineTo((fArr[i] + 20.0f) - ((f8 * f8) * 20.0f), fArr2[i]);
            }
        }
    }

    /* renamed from: a */
    private void m25377a(Canvas canvas, float f, float f2, float f3, int i, int i2) {
        canvas.save();
        canvas.translate(f2 - ((100.0f * f) / 2.0f), f3 - (200.0f * f));
        canvas.scale(f, f);
        this.f20567m.setColor(i2);
        canvas.drawPath(this.f20573s, this.f20567m);
        this.f20566l.setColor(i);
        canvas.drawPath(this.f20572r, this.f20566l);
        this.f20568n.setColor(i);
        canvas.drawPath(this.f20573s, this.f20568n);
        canvas.restore();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(this.f20555a);
        this.f20565k.setColor(this.f20556b);
        canvas.drawPath(this.f20569o, this.f20565k);
        canvas.save();
        canvas.scale(-1.0f, 1.0f, (float) (getWidth() / 2), 0.0f);
        float f = this.f20575u;
        m25377a(canvas, f * 0.12f, f * 180.0f, ((this.f20577w * 20.0f) + 93.0f) * this.f20576v, this.f20564j, this.f20563i);
        float f2 = this.f20575u;
        m25377a(canvas, f2 * 0.1f, f2 * 200.0f, ((this.f20577w * 20.0f) + 96.0f) * this.f20576v, this.f20564j, this.f20563i);
        canvas.restore();
        this.f20565k.setColor(this.f20557c);
        canvas.drawPath(this.f20570p, this.f20565k);
        float f3 = this.f20575u;
        m25377a(canvas, f3 * 0.2f, f3 * 160.0f, ((this.f20577w * 30.0f) + 105.0f) * this.f20576v, this.f20560f, this.f20559e);
        float f4 = this.f20575u;
        m25377a(canvas, f4 * 0.14f, f4 * 180.0f, ((this.f20577w * 30.0f) + 105.0f) * this.f20576v, this.f20562h, this.f20561g);
        float f5 = this.f20575u;
        m25377a(canvas, f5 * 0.16f, f5 * 140.0f, ((this.f20577w * 30.0f) + 105.0f) * this.f20576v, this.f20562h, this.f20561g);
        this.f20565k.setColor(this.f20558d);
        canvas.drawPath(this.f20571q, this.f20565k);
    }

    public void setPrimaryColor(int i) {
        this.f20555a = i;
        this.f20556b = ColorUtils.compositeColors(-1711276033, i);
        this.f20557c = ColorUtils.compositeColors(-1724083556, i);
        this.f20558d = ColorUtils.compositeColors(-868327565, i);
        this.f20559e = ColorUtils.compositeColors(1428124023, i);
        this.f20560f = ColorUtils.compositeColors(-871612856, i);
        this.f20561g = ColorUtils.compositeColors(1429506191, i);
        this.f20562h = ColorUtils.compositeColors(-870620823, i);
        this.f20563i = ColorUtils.compositeColors(1431810478, i);
        this.f20564j = ColorUtils.compositeColors(-865950547, i);
    }

    /* renamed from: a */
    public void mo30753a(float f) {
        this.f20578x = f;
        float max = Math.max(0.0f, f);
        this.f20577w = Math.max(0.0f, this.f20578x);
        int measuredHeight = getMeasuredHeight();
        float f2 = this.f20577w;
        if (measuredHeight <= 0) {
            measuredHeight = TinkerReport.KEY_APPLIED_VERSION_CHECK;
        }
        m25375a(f2, measuredHeight);
        m25376a(max, false);
    }
}
