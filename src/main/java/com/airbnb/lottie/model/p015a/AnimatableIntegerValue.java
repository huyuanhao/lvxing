package com.airbnb.lottie.model.p015a;

import com.airbnb.lottie.p008a.p010b.BaseKeyframeAnimation;
import com.airbnb.lottie.p008a.p010b.IntegerKeyframeAnimation;
import com.airbnb.lottie.p014e.Keyframe;
import java.util.List;

/* renamed from: com.airbnb.lottie.model.a.d */
public class AnimatableIntegerValue extends BaseAnimatableValue<Integer, Integer> {
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public AnimatableIntegerValue() {
        super(Integer.valueOf(100));
    }

    public AnimatableIntegerValue(List<Keyframe<Integer>> list) {
        super(list);
    }

    /* renamed from: a */
    public BaseKeyframeAnimation<Integer, Integer> mo10017a() {
        return new IntegerKeyframeAnimation(this.f1584a);
    }
}
