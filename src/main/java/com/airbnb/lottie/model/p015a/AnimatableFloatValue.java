package com.airbnb.lottie.model.p015a;

import com.airbnb.lottie.p008a.p010b.BaseKeyframeAnimation;
import com.airbnb.lottie.p008a.p010b.FloatKeyframeAnimation;
import com.airbnb.lottie.p014e.Keyframe;
import java.util.List;

/* renamed from: com.airbnb.lottie.model.a.b */
public class AnimatableFloatValue extends BaseAnimatableValue<Float, Float> {
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    AnimatableFloatValue() {
        super(Float.valueOf(0.0f));
    }

    public AnimatableFloatValue(List<Keyframe<Float>> list) {
        super(list);
    }

    /* renamed from: a */
    public BaseKeyframeAnimation<Float, Float> mo10017a() {
        return new FloatKeyframeAnimation(this.f1584a);
    }
}
