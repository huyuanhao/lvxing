package com.airbnb.lottie.model;

import androidx.collection.LruCache;
import com.airbnb.lottie.LottieComposition;

/* renamed from: com.airbnb.lottie.model.g */
public class LottieCompositionCache {
    /* renamed from: a */
    private static final LottieCompositionCache f1686a = new LottieCompositionCache();
    /* renamed from: b */
    private final LruCache<String, LottieComposition> f1687b = new LruCache<>(10485760);

    /* renamed from: a */
    public static LottieCompositionCache m1654a() {
        return f1686a;
    }

    LottieCompositionCache() {
    }

    /* renamed from: a */
    public LottieComposition mo10128a(int i) {
        return mo10129a(Integer.toString(i));
    }

    /* renamed from: a */
    public LottieComposition mo10129a(String str) {
        return (LottieComposition) this.f1687b.get(str);
    }

    /* renamed from: a */
    public void mo10130a(int i, LottieComposition dVar) {
        mo10131a(Integer.toString(i), dVar);
    }

    /* renamed from: a */
    public void mo10131a(String str, LottieComposition dVar) {
        if (str != null) {
            this.f1687b.put(str, dVar);
        }
    }
}
