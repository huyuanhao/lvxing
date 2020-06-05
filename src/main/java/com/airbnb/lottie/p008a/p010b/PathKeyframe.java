package com.airbnb.lottie.p008a.p010b;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.p013d.Utils;
import com.airbnb.lottie.p014e.Keyframe;

/* renamed from: com.airbnb.lottie.a.b.h */
public class PathKeyframe extends Keyframe<PointF> {
    /* renamed from: h */
    private Path f1406h;

    public PathKeyframe(LottieComposition dVar, Keyframe<PointF> aVar) {
        super(dVar, aVar.f1496a, aVar.f1497b, aVar.f1498c, aVar.f1499d, aVar.f1500e);
        boolean z = (this.f1497b == null || this.f1496a == null || !((PointF) this.f1496a).equals(((PointF) this.f1497b).x, ((PointF) this.f1497b).y)) ? false : true;
        if (this.f1497b != null && !z) {
            this.f1406h = Utils.m1454a((PointF) this.f1496a, (PointF) this.f1497b, aVar.f1501f, aVar.f1502g);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Path mo9879a() {
        return this.f1406h;
    }
}
