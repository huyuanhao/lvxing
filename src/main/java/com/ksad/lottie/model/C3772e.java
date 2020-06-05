package com.ksad.lottie.model;

import androidx.collection.LruCache;
import com.ksad.lottie.C3703d;

/* renamed from: com.ksad.lottie.model.e */
public class C3772e {
    /* renamed from: a */
    private static final C3772e f12823a = new C3772e();
    /* renamed from: b */
    private final LruCache<String, C3703d> f12824b = new LruCache<>(10485760);

    C3772e() {
    }

    /* renamed from: a */
    public static C3772e m15637a() {
        return f12823a;
    }

    /* renamed from: a */
    public C3703d mo23139a(String str) {
        if (str == null) {
            return null;
        }
        return (C3703d) this.f12824b.get(str);
    }

    /* renamed from: a */
    public void mo23140a(String str, C3703d dVar) {
        if (str != null) {
            this.f12824b.put(str, dVar);
        }
    }
}
