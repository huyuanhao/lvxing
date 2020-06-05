package com.airbnb.lottie.model.p015a;

import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.p008a.p010b.BaseKeyframeAnimation;
import com.airbnb.lottie.p008a.p010b.GradientColorKeyframeAnimation;
import com.airbnb.lottie.p014e.Keyframe;
import java.util.List;

/* renamed from: com.airbnb.lottie.model.a.c */
public class AnimatableGradientColorValue extends BaseAnimatableValue<GradientColor, GradientColor> {
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public AnimatableGradientColorValue(List<Keyframe<GradientColor>> list) {
        super(list);
    }

    /* renamed from: a */
    public BaseKeyframeAnimation<GradientColor, GradientColor> mo10017a() {
        return new GradientColorKeyframeAnimation(this.f1584a);
    }
}
