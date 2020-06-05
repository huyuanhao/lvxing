package com.airbnb.lottie.p008a.p010b;

import com.airbnb.lottie.p013d.MiscUtils;
import com.airbnb.lottie.p014e.Keyframe;
import java.util.List;

/* renamed from: com.airbnb.lottie.a.b.c */
public class FloatKeyframeAnimation extends KeyframeAnimation<Float> {
    public FloatKeyframeAnimation(List<Keyframe<Float>> list) {
        super(list);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public Float mo9862a(Keyframe<Float> aVar, float f) {
        if (aVar.f1496a == null || aVar.f1497b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        } else if (this.f1397b == null) {
            return Float.valueOf(MiscUtils.m1440a(((Float) aVar.f1496a).floatValue(), ((Float) aVar.f1497b).floatValue(), f));
        } else {
            return (Float) this.f1397b.mo9985a(aVar.f1499d, aVar.f1500e.floatValue(), aVar.f1496a, aVar.f1497b, f, mo9868c(), mo9871f());
        }
    }
}
