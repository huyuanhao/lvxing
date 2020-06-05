package com.airbnb.lottie.model;

import android.graphics.PointF;

/* renamed from: com.airbnb.lottie.model.a */
public class CubicCurveData {
    /* renamed from: a */
    private final PointF f1567a;
    /* renamed from: b */
    private final PointF f1568b;
    /* renamed from: c */
    private final PointF f1569c;

    public CubicCurveData() {
        this.f1567a = new PointF();
        this.f1568b = new PointF();
        this.f1569c = new PointF();
    }

    public CubicCurveData(PointF pointF, PointF pointF2, PointF pointF3) {
        this.f1567a = pointF;
        this.f1568b = pointF2;
        this.f1569c = pointF3;
    }

    /* renamed from: a */
    public void mo10012a(float f, float f2) {
        this.f1567a.set(f, f2);
    }

    /* renamed from: a */
    public PointF mo10011a() {
        return this.f1567a;
    }

    /* renamed from: b */
    public void mo10014b(float f, float f2) {
        this.f1568b.set(f, f2);
    }

    /* renamed from: b */
    public PointF mo10013b() {
        return this.f1568b;
    }

    /* renamed from: c */
    public void mo10016c(float f, float f2) {
        this.f1569c.set(f, f2);
    }

    /* renamed from: c */
    public PointF mo10015c() {
        return this.f1569c;
    }
}
