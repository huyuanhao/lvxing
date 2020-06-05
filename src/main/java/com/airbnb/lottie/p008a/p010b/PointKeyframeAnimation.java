package com.airbnb.lottie.p008a.p010b;

import android.graphics.PointF;
import com.airbnb.lottie.p014e.Keyframe;
import java.util.List;

/* renamed from: com.airbnb.lottie.a.b.j */
public class PointKeyframeAnimation extends KeyframeAnimation<PointF> {
    /* renamed from: c */
    private final PointF f1411c = new PointF();

    public PointKeyframeAnimation(List<Keyframe<PointF>> list) {
        super(list);
    }

    /* renamed from: b */
    public PointF mo9862a(Keyframe<PointF> aVar, float f) {
        if (aVar.f1496a == null || aVar.f1497b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF = (PointF) aVar.f1496a;
        PointF pointF2 = (PointF) aVar.f1497b;
        if (this.f1397b != null) {
            return (PointF) this.f1397b.mo9985a(aVar.f1499d, aVar.f1500e.floatValue(), pointF, pointF2, f, mo9868c(), mo9871f());
        }
        this.f1411c.set(pointF.x + ((pointF2.x - pointF.x) * f), pointF.y + (f * (pointF2.y - pointF.y)));
        return this.f1411c;
    }
}
