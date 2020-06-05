package com.airbnb.lottie.model.p015a;

import android.graphics.PointF;
import com.airbnb.lottie.p008a.p010b.BaseKeyframeAnimation;
import com.airbnb.lottie.p008a.p010b.SplitDimensionPathKeyframeAnimation;

/* renamed from: com.airbnb.lottie.model.a.i */
public class AnimatableSplitDimensionPathValue implements AnimatableValue<PointF, PointF> {
    /* renamed from: a */
    private final AnimatableFloatValue f1571a;
    /* renamed from: b */
    private final AnimatableFloatValue f1572b;

    public AnimatableSplitDimensionPathValue(AnimatableFloatValue bVar, AnimatableFloatValue bVar2) {
        this.f1571a = bVar;
        this.f1572b = bVar2;
    }

    /* renamed from: a */
    public BaseKeyframeAnimation<PointF, PointF> mo10017a() {
        return new SplitDimensionPathKeyframeAnimation(this.f1571a.mo10017a(), this.f1572b.mo10017a());
    }
}
