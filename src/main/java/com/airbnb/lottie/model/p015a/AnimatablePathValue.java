package com.airbnb.lottie.model.p015a;

import android.graphics.PointF;
import com.airbnb.lottie.p008a.p010b.BaseKeyframeAnimation;
import com.airbnb.lottie.p008a.p010b.PathKeyframeAnimation;
import com.airbnb.lottie.p008a.p010b.PointKeyframeAnimation;
import com.airbnb.lottie.p014e.Keyframe;
import java.util.Collections;
import java.util.List;

/* renamed from: com.airbnb.lottie.model.a.e */
public class AnimatablePathValue implements AnimatableValue<PointF, PointF> {
    /* renamed from: a */
    private final List<Keyframe<PointF>> f1570a;

    public AnimatablePathValue() {
        this.f1570a = Collections.singletonList(new Keyframe(new PointF(0.0f, 0.0f)));
    }

    public AnimatablePathValue(List<Keyframe<PointF>> list) {
        this.f1570a = list;
    }

    /* renamed from: a */
    public BaseKeyframeAnimation<PointF, PointF> mo10017a() {
        if (((Keyframe) this.f1570a.get(0)).mo9982d()) {
            return new PointKeyframeAnimation(this.f1570a);
        }
        return new PathKeyframeAnimation(this.f1570a);
    }
}
