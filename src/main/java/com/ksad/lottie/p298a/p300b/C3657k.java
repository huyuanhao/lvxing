package com.ksad.lottie.p298a.p300b;

import com.ksad.lottie.p303d.C3708e;
import com.ksad.lottie.p304e.C3717a;
import com.ksad.lottie.p304e.C3720d;
import java.util.List;

/* renamed from: com.ksad.lottie.a.b.k */
public class C3657k extends C3652f<C3720d> {
    public C3657k(List<C3717a<C3720d>> list) {
        super(list);
    }

    /* renamed from: b */
    public C3720d mo22824a(C3717a<C3720d> aVar, float f) {
        if (aVar.f12629a == null || aVar.f12630b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        C3720d dVar = (C3720d) aVar.f12629a;
        C3720d dVar2 = (C3720d) aVar.f12630b;
        if (this.f12530b != null) {
            C3720d dVar3 = (C3720d) this.f12530b.mo22947a(aVar.f12632d, aVar.f12633e.floatValue(), dVar, dVar2, f, mo22829c(), mo22832f());
            if (dVar3 != null) {
                return dVar3;
            }
        }
        return new C3720d(C3708e.m15377a(dVar.mo22949a(), dVar2.mo22949a(), f), C3708e.m15377a(dVar.mo22950b(), dVar2.mo22950b(), f));
    }
}
