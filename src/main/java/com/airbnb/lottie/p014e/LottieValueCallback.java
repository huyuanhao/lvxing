package com.airbnb.lottie.p014e;

import com.airbnb.lottie.p008a.p010b.BaseKeyframeAnimation;

/* renamed from: com.airbnb.lottie.e.c */
public class LottieValueCallback<T> {
    /* renamed from: a */
    BaseKeyframeAnimation<?, ?> f1513a;
    /* renamed from: b */
    protected T f1514b = null;
    /* renamed from: c */
    private final LottieFrameInfo<T> f1515c = new LottieFrameInfo<>();

    public LottieValueCallback() {
    }

    public LottieValueCallback(T t) {
        this.f1514b = t;
    }

    /* renamed from: a */
    public T mo9986a(LottieFrameInfo<T> bVar) {
        return this.f1514b;
    }

    /* renamed from: a */
    public final T mo9985a(float f, float f2, T t, T t2, float f3, float f4, float f5) {
        return mo9986a(this.f1515c.mo9984a(f, f2, t, t2, f3, f4, f5));
    }

    /* renamed from: a */
    public final void mo9987a(BaseKeyframeAnimation<?, ?> aVar) {
        this.f1513a = aVar;
    }
}
