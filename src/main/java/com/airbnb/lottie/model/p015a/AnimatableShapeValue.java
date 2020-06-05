package com.airbnb.lottie.model.p015a;

import android.graphics.Path;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.p008a.p010b.BaseKeyframeAnimation;
import com.airbnb.lottie.p008a.p010b.ShapeKeyframeAnimation;
import com.airbnb.lottie.p014e.Keyframe;
import java.util.List;

/* renamed from: com.airbnb.lottie.model.a.h */
public class AnimatableShapeValue extends BaseAnimatableValue<ShapeData, Path> {
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public AnimatableShapeValue(List<Keyframe<ShapeData>> list) {
        super(list);
    }

    /* renamed from: a */
    public BaseKeyframeAnimation<ShapeData, Path> mo10017a() {
        return new ShapeKeyframeAnimation(this.f1584a);
    }
}
