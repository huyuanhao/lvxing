package com.airbnb.lottie.model.p015a;

import com.airbnb.lottie.p008a.p010b.BaseKeyframeAnimation;
import com.airbnb.lottie.p008a.p010b.ColorKeyframeAnimation;
import com.airbnb.lottie.p014e.Keyframe;
import java.util.List;

/* renamed from: com.airbnb.lottie.model.a.a */
public class AnimatableColorValue extends BaseAnimatableValue<Integer, Integer> {
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public AnimatableColorValue(List<Keyframe<Integer>> list) {
        super(list);
    }

    /* renamed from: a */
    public BaseKeyframeAnimation<Integer, Integer> mo10017a() {
        return new ColorKeyframeAnimation(this.f1584a);
    }
}
