package com.ksad.lottie.p298a.p300b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import com.ksad.lottie.p304e.C3717a;
import java.util.List;

/* renamed from: com.ksad.lottie.a.b.i */
public class C3655i extends C3652f<PointF> {
    /* renamed from: c */
    private final PointF f12540c = new PointF();
    /* renamed from: d */
    private final float[] f12541d = new float[2];
    /* renamed from: e */
    private C3654h f12542e;
    /* renamed from: f */
    private PathMeasure f12543f;

    public C3655i(List<? extends C3717a<PointF>> list) {
        super(list);
    }

    /* renamed from: b */
    public PointF mo22824a(C3717a<PointF> aVar, float f) {
        C3654h hVar = (C3654h) aVar;
        Path a = hVar.mo22840a();
        if (a == null) {
            return (PointF) aVar.f12629a;
        }
        if (this.f12530b != null) {
            PointF pointF = (PointF) this.f12530b.mo22947a(hVar.f12632d, hVar.f12633e.floatValue(), hVar.f12629a, hVar.f12630b, mo22829c(), f, mo22832f());
            if (pointF != null) {
                return pointF;
            }
        }
        if (this.f12542e != hVar) {
            this.f12543f = new PathMeasure(a, false);
            this.f12542e = hVar;
        }
        PathMeasure pathMeasure = this.f12543f;
        pathMeasure.getPosTan(f * pathMeasure.getLength(), this.f12541d, null);
        PointF pointF2 = this.f12540c;
        float[] fArr = this.f12541d;
        pointF2.set(fArr[0], fArr[1]);
        return this.f12540c;
    }
}
