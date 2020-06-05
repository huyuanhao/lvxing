package com.airbnb.lottie.model.p015a;

import com.airbnb.lottie.p008a.p010b.BaseKeyframeAnimation;
import com.airbnb.lottie.p008a.p010b.ScaleKeyframeAnimation;
import com.airbnb.lottie.p014e.Keyframe;
import com.airbnb.lottie.p014e.ScaleXY;
import java.util.List;

/* renamed from: com.airbnb.lottie.model.a.g */
public class AnimatableScaleValue extends BaseAnimatableValue<ScaleXY, ScaleXY> {
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    AnimatableScaleValue() {
        this(new ScaleXY(1.0f, 1.0f));
    }

    public AnimatableScaleValue(ScaleXY dVar) {
        super(dVar);
    }

    public AnimatableScaleValue(List<Keyframe<ScaleXY>> list) {
        super(list);
    }

    /* renamed from: a */
    public BaseKeyframeAnimation<ScaleXY, ScaleXY> mo10017a() {
        return new ScaleKeyframeAnimation(this.f1584a);
    }
}
