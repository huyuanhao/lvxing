package com.airbnb.lottie.p008a.p010b;

import com.airbnb.lottie.p014e.Keyframe;
import com.airbnb.lottie.p014e.LottieFrameInfo;
import com.airbnb.lottie.p014e.LottieValueCallback;
import java.util.Collections;

/* renamed from: com.airbnb.lottie.a.b.p */
public class ValueCallbackKeyframeAnimation<K, A> extends BaseKeyframeAnimation<K, A> {
    /* renamed from: c */
    private final LottieFrameInfo<A> f1425c = new LottieFrameInfo<>();

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public float mo9869d() {
        return 1.0f;
    }

    public ValueCallbackKeyframeAnimation(LottieValueCallback<A> cVar) {
        super(Collections.emptyList());
        mo9866a(cVar);
    }

    /* renamed from: b */
    public void mo9867b() {
        if (this.f1397b != null) {
            super.mo9867b();
        }
    }

    /* renamed from: e */
    public A mo9870e() {
        return this.f1397b.mo9985a(0.0f, 0.0f, null, null, mo9871f(), mo9871f(), mo9871f());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public A mo9862a(Keyframe<K> aVar, float f) {
        return mo9870e();
    }
}
