package com.airbnb.lottie.p008a.p010b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import com.airbnb.lottie.p014e.Keyframe;
import java.util.List;

/* renamed from: com.airbnb.lottie.a.b.i */
public class PathKeyframeAnimation extends KeyframeAnimation<PointF> {
    /* renamed from: c */
    private final PointF f1407c = new PointF();
    /* renamed from: d */
    private final float[] f1408d = new float[2];
    /* renamed from: e */
    private PathKeyframe f1409e;
    /* renamed from: f */
    private PathMeasure f1410f;

    public PathKeyframeAnimation(List<? extends Keyframe<PointF>> list) {
        super(list);
    }

    /* renamed from: b */
    public PointF mo9862a(Keyframe<PointF> aVar, float f) {
        PathKeyframe hVar = (PathKeyframe) aVar;
        Path a = hVar.mo9879a();
        if (a == null) {
            return (PointF) aVar.f1496a;
        }
        if (this.f1397b != null) {
            return (PointF) this.f1397b.mo9985a(hVar.f1499d, hVar.f1500e.floatValue(), hVar.f1496a, hVar.f1497b, mo9868c(), f, mo9871f());
        }
        if (this.f1409e != hVar) {
            this.f1410f = new PathMeasure(a, false);
            this.f1409e = hVar;
        }
        PathMeasure pathMeasure = this.f1410f;
        pathMeasure.getPosTan(f * pathMeasure.getLength(), this.f1408d, null);
        PointF pointF = this.f1407c;
        float[] fArr = this.f1408d;
        pointF.set(fArr[0], fArr[1]);
        return this.f1407c;
    }
}
