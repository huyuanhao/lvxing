package com.airbnb.lottie.model.p015a;

import android.graphics.PointF;
import com.airbnb.lottie.p008a.p010b.BaseKeyframeAnimation;
import com.airbnb.lottie.p008a.p010b.PointKeyframeAnimation;
import com.airbnb.lottie.p014e.Keyframe;
import java.util.List;

/* renamed from: com.airbnb.lottie.model.a.f */
public class AnimatablePointValue extends BaseAnimatableValue<PointF, PointF> {
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public AnimatablePointValue(List<Keyframe<PointF>> list) {
        super(list);
    }

    /* renamed from: a */
    public BaseKeyframeAnimation<PointF, PointF> mo10017a() {
        return new PointKeyframeAnimation(this.f1584a);
    }
}
