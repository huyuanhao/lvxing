package com.ksad.lottie.p298a.p300b;

import com.ksad.lottie.p303d.C3708e;
import com.ksad.lottie.p304e.C3717a;
import java.util.List;

/* renamed from: com.ksad.lottie.a.b.e */
public class C3651e extends C3652f<Integer> {
    public C3651e(List<C3717a<Integer>> list) {
        super(list);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public Integer mo22824a(C3717a<Integer> aVar, float f) {
        if (aVar.f12629a == null || aVar.f12630b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        if (this.f12530b != null) {
            Integer num = (Integer) this.f12530b.mo22947a(aVar.f12632d, aVar.f12633e.floatValue(), aVar.f12629a, aVar.f12630b, f, mo22829c(), mo22832f());
            if (num != null) {
                return num;
            }
        }
        return Integer.valueOf(C3708e.m15380a(((Integer) aVar.f12629a).intValue(), ((Integer) aVar.f12630b).intValue(), f));
    }
}
