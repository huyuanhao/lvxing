package com.airbnb.lottie.model.p015a;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.p008a.p009a.Content;
import com.airbnb.lottie.p008a.p010b.TransformKeyframeAnimation;

/* renamed from: com.airbnb.lottie.model.a.l */
public class AnimatableTransform implements ContentModel {
    /* renamed from: a */
    private final AnimatablePathValue f1577a;
    /* renamed from: b */
    private final AnimatableValue<PointF, PointF> f1578b;
    /* renamed from: c */
    private final AnimatableScaleValue f1579c;
    /* renamed from: d */
    private final AnimatableFloatValue f1580d;
    /* renamed from: e */
    private final AnimatableIntegerValue f1581e;
    /* renamed from: f */
    private final AnimatableFloatValue f1582f;
    /* renamed from: g */
    private final AnimatableFloatValue f1583g;

    /* renamed from: a */
    public Content mo10020a(LottieDrawable lottieDrawable, BaseLayer aVar) {
        return null;
    }

    public AnimatableTransform() {
        this(new AnimatablePathValue(), new AnimatablePathValue(), new AnimatableScaleValue(), new AnimatableFloatValue(), new AnimatableIntegerValue(), new AnimatableFloatValue(), new AnimatableFloatValue());
    }

    public AnimatableTransform(AnimatablePathValue eVar, AnimatableValue<PointF, PointF> mVar, AnimatableScaleValue gVar, AnimatableFloatValue bVar, AnimatableIntegerValue dVar, AnimatableFloatValue bVar2, AnimatableFloatValue bVar3) {
        this.f1577a = eVar;
        this.f1578b = mVar;
        this.f1579c = gVar;
        this.f1580d = bVar;
        this.f1581e = dVar;
        this.f1582f = bVar2;
        this.f1583g = bVar3;
    }

    /* renamed from: a */
    public AnimatablePathValue mo10021a() {
        return this.f1577a;
    }

    /* renamed from: b */
    public AnimatableValue<PointF, PointF> mo10022b() {
        return this.f1578b;
    }

    /* renamed from: c */
    public AnimatableScaleValue mo10023c() {
        return this.f1579c;
    }

    /* renamed from: d */
    public AnimatableFloatValue mo10024d() {
        return this.f1580d;
    }

    /* renamed from: e */
    public AnimatableIntegerValue mo10025e() {
        return this.f1581e;
    }

    /* renamed from: f */
    public AnimatableFloatValue mo10026f() {
        return this.f1582f;
    }

    /* renamed from: g */
    public AnimatableFloatValue mo10027g() {
        return this.f1583g;
    }

    /* renamed from: h */
    public TransformKeyframeAnimation mo10028h() {
        return new TransformKeyframeAnimation(this);
    }
}
