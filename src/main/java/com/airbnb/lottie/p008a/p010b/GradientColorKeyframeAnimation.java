package com.airbnb.lottie.p008a.p010b;

import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.p014e.Keyframe;
import java.util.List;

/* renamed from: com.airbnb.lottie.a.b.d */
public class GradientColorKeyframeAnimation extends KeyframeAnimation<GradientColor> {
    /* renamed from: c */
    private final GradientColor f1402c;

    public GradientColorKeyframeAnimation(List<Keyframe<GradientColor>> list) {
        super(list);
        int i = 0;
        GradientColor cVar = (GradientColor) ((Keyframe) list.get(0)).f1496a;
        if (cVar != null) {
            i = cVar.mo10072c();
        }
        this.f1402c = new GradientColor(new float[i], new int[i]);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public GradientColor mo9862a(Keyframe<GradientColor> aVar, float f) {
        this.f1402c.mo10069a((GradientColor) aVar.f1496a, (GradientColor) aVar.f1497b, f);
        return this.f1402c;
    }
}
