package com.airbnb.lottie.p008a.p010b;

import android.graphics.PointF;
import com.airbnb.lottie.p008a.p010b.BaseKeyframeAnimation.C0925a;
import com.airbnb.lottie.p014e.Keyframe;
import java.util.Collections;

/* renamed from: com.airbnb.lottie.a.b.m */
public class SplitDimensionPathKeyframeAnimation extends BaseKeyframeAnimation<PointF, PointF> {
    /* renamed from: c */
    private final PointF f1414c = new PointF();
    /* renamed from: d */
    private final BaseKeyframeAnimation<Float, Float> f1415d;
    /* renamed from: e */
    private final BaseKeyframeAnimation<Float, Float> f1416e;

    public SplitDimensionPathKeyframeAnimation(BaseKeyframeAnimation<Float, Float> aVar, BaseKeyframeAnimation<Float, Float> aVar2) {
        super(Collections.emptyList());
        this.f1415d = aVar;
        this.f1416e = aVar2;
        mo9864a(mo9871f());
    }

    /* renamed from: a */
    public void mo9864a(float f) {
        this.f1415d.mo9864a(f);
        this.f1416e.mo9864a(f);
        this.f1414c.set(((Float) this.f1415d.mo9870e()).floatValue(), ((Float) this.f1416e.mo9870e()).floatValue());
        for (int i = 0; i < this.f1396a.size(); i++) {
            ((C0925a) this.f1396a.get(i)).mo9846a();
        }
    }

    /* renamed from: g */
    public PointF mo9870e() {
        return mo9862a(null, 0.0f);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public PointF mo9862a(Keyframe<PointF> aVar, float f) {
        return this.f1414c;
    }
}
