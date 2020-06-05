package com.ksad.lottie.p298a.p300b;

import com.ksad.lottie.p303d.C3708e;
import com.ksad.lottie.p304e.C3717a;
import java.util.List;

/* renamed from: com.ksad.lottie.a.b.c */
public class C3649c extends C3652f<Float> {
    public C3649c(List<C3717a<Float>> list) {
        super(list);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public Float mo22824a(C3717a<Float> aVar, float f) {
        if (aVar.f12629a == null || aVar.f12630b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        if (this.f12530b != null) {
            Float f2 = (Float) this.f12530b.mo22947a(aVar.f12632d, aVar.f12633e.floatValue(), aVar.f12629a, aVar.f12630b, f, mo22829c(), mo22832f());
            if (f2 != null) {
                return f2;
            }
        }
        return Float.valueOf(C3708e.m15377a(((Float) aVar.f12629a).floatValue(), ((Float) aVar.f12630b).floatValue(), f));
    }
}
