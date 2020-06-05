package com.airbnb.lottie.p008a.p010b;

import com.airbnb.lottie.p013d.MiscUtils;
import com.airbnb.lottie.p014e.Keyframe;
import java.util.List;

/* renamed from: com.airbnb.lottie.a.b.e */
public class IntegerKeyframeAnimation extends KeyframeAnimation<Integer> {
    public IntegerKeyframeAnimation(List<Keyframe<Integer>> list) {
        super(list);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public Integer mo9862a(Keyframe<Integer> aVar, float f) {
        if (aVar.f1496a == null || aVar.f1497b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        } else if (this.f1397b == null) {
            return Integer.valueOf(MiscUtils.m1443a(((Integer) aVar.f1496a).intValue(), ((Integer) aVar.f1497b).intValue(), f));
        } else {
            return (Integer) this.f1397b.mo9985a(aVar.f1499d, aVar.f1500e.floatValue(), aVar.f1496a, aVar.f1497b, f, mo9868c(), mo9871f());
        }
    }
}
