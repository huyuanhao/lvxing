package com.airbnb.lottie.model.content;

import com.airbnb.lottie.model.p015a.AnimatableIntegerValue;
import com.airbnb.lottie.model.p015a.AnimatableShapeValue;

public class Mask {
    /* renamed from: a */
    private final MaskMode f1600a;
    /* renamed from: b */
    private final AnimatableShapeValue f1601b;
    /* renamed from: c */
    private final AnimatableIntegerValue f1602c;

    /* renamed from: com.airbnb.lottie.model.content.Mask$MaskMode */
    public enum MaskMode {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect
    }

    public Mask(MaskMode maskMode, AnimatableShapeValue hVar, AnimatableIntegerValue dVar) {
        this.f1600a = maskMode;
        this.f1601b = hVar;
        this.f1602c = dVar;
    }

    /* renamed from: a */
    public MaskMode mo10033a() {
        return this.f1600a;
    }

    /* renamed from: b */
    public AnimatableShapeValue mo10034b() {
        return this.f1601b;
    }

    /* renamed from: c */
    public AnimatableIntegerValue mo10035c() {
        return this.f1602c;
    }
}
