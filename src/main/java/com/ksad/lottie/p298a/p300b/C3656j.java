package com.ksad.lottie.p298a.p300b;

import android.graphics.PointF;
import com.ksad.lottie.p304e.C3717a;
import java.util.List;

/* renamed from: com.ksad.lottie.a.b.j */
public class C3656j extends C3652f<PointF> {
    /* renamed from: c */
    private final PointF f12544c = new PointF();

    public C3656j(List<C3717a<PointF>> list) {
        super(list);
    }

    /* renamed from: b */
    public PointF mo22824a(C3717a<PointF> aVar, float f) {
        if (aVar.f12629a == null || aVar.f12630b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF = (PointF) aVar.f12629a;
        PointF pointF2 = (PointF) aVar.f12630b;
        if (this.f12530b != null) {
            PointF pointF3 = (PointF) this.f12530b.mo22947a(aVar.f12632d, aVar.f12633e.floatValue(), pointF, pointF2, f, mo22829c(), mo22832f());
            if (pointF3 != null) {
                return pointF3;
            }
        }
        this.f12544c.set(pointF.x + ((pointF2.x - pointF.x) * f), pointF.y + (f * (pointF2.y - pointF.y)));
        return this.f12544c;
    }
}
