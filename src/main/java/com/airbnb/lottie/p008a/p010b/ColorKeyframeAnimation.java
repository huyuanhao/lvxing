package com.airbnb.lottie.p008a.p010b;

import com.airbnb.lottie.p013d.GammaEvaluator;
import com.airbnb.lottie.p014e.Keyframe;
import java.util.List;

/* renamed from: com.airbnb.lottie.a.b.b */
public class ColorKeyframeAnimation extends KeyframeAnimation<Integer> {
    public ColorKeyframeAnimation(List<Keyframe<Integer>> list) {
        super(list);
    }

    /* renamed from: b */
    public Integer mo9862a(Keyframe<Integer> aVar, float f) {
        if (aVar.f1496a == null || aVar.f1497b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        int intValue = ((Integer) aVar.f1496a).intValue();
        int intValue2 = ((Integer) aVar.f1497b).intValue();
        if (this.f1397b == null) {
            return Integer.valueOf(GammaEvaluator.m1415a(f, intValue, intValue2));
        }
        return (Integer) this.f1397b.mo9985a(aVar.f1499d, aVar.f1500e.floatValue(), Integer.valueOf(intValue), Integer.valueOf(intValue2), f, mo9868c(), mo9871f());
    }
}
