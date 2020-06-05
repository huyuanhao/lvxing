package com.scwang.smartrefresh.header.p526a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.util.Random;

/* renamed from: com.scwang.smartrefresh.header.a.a */
public class StoreHouseBarItem extends Animation {
    /* renamed from: a */
    public PointF f20546a;
    /* renamed from: b */
    public float f20547b;
    /* renamed from: c */
    public int f20548c;
    /* renamed from: d */
    protected final Paint f20549d = new Paint();
    /* renamed from: e */
    protected float f20550e = 1.0f;
    /* renamed from: f */
    protected float f20551f = 0.4f;
    /* renamed from: g */
    protected PointF f20552g;
    /* renamed from: h */
    protected PointF f20553h;

    public StoreHouseBarItem(int i, PointF pointF, PointF pointF2, int i2, int i3) {
        this.f20548c = i;
        this.f20546a = new PointF((pointF.x + pointF2.x) / 2.0f, (pointF.y + pointF2.y) / 2.0f);
        this.f20552g = new PointF(pointF.x - this.f20546a.x, pointF.y - this.f20546a.y);
        this.f20553h = new PointF(pointF2.x - this.f20546a.x, pointF2.y - this.f20546a.y);
        mo30751b(i2);
        mo30748a(i3);
        this.f20549d.setAntiAlias(true);
        this.f20549d.setStyle(Style.STROKE);
    }

    /* renamed from: a */
    public void mo30748a(int i) {
        this.f20549d.setStrokeWidth((float) i);
    }

    /* renamed from: b */
    public void mo30751b(int i) {
        this.f20549d.setColor(i);
    }

    /* renamed from: c */
    public void mo30752c(int i) {
        this.f20547b = (float) ((-new Random().nextInt(i)) + i);
    }

    /* access modifiers changed from: protected */
    public void applyTransformation(float f, Transformation transformation) {
        float f2 = this.f20550e;
        mo30746a(f2 + ((this.f20551f - f2) * f));
    }

    /* renamed from: a */
    public void mo30747a(float f, float f2) {
        this.f20550e = f;
        this.f20551f = f2;
        super.start();
    }

    /* renamed from: a */
    public void mo30746a(float f) {
        this.f20549d.setAlpha((int) (f * 255.0f));
    }

    /* renamed from: a */
    public void mo30749a(Canvas canvas) {
        canvas.drawLine(this.f20552g.x, this.f20552g.y, this.f20553h.x, this.f20553h.y, this.f20549d);
    }
}
