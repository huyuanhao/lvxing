package com.airbnb.lottie.p008a.p010b;

import com.airbnb.lottie.p013d.MiscUtils;
import com.airbnb.lottie.p014e.Keyframe;
import com.airbnb.lottie.p014e.ScaleXY;
import java.util.List;

/* renamed from: com.airbnb.lottie.a.b.k */
public class ScaleKeyframeAnimation extends KeyframeAnimation<ScaleXY> {
    public ScaleKeyframeAnimation(List<Keyframe<ScaleXY>> list) {
        super(list);
    }

    /* renamed from: b */
    public ScaleXY mo9862a(Keyframe<ScaleXY> aVar, float f) {
        if (aVar.f1496a == null || aVar.f1497b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        ScaleXY dVar = (ScaleXY) aVar.f1496a;
        ScaleXY dVar2 = (ScaleXY) aVar.f1497b;
        if (this.f1397b == null) {
            return new ScaleXY(MiscUtils.m1440a(dVar.mo9988a(), dVar2.mo9988a(), f), MiscUtils.m1440a(dVar.mo9989b(), dVar2.mo9989b(), f));
        }
        return (ScaleXY) this.f1397b.mo9985a(aVar.f1499d, aVar.f1500e.floatValue(), dVar, dVar2, f, mo9868c(), mo9871f());
    }
}
