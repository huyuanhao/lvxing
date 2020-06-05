package com.ksad.lottie.p298a.p300b;

import com.ksad.lottie.p303d.C3705b;
import com.ksad.lottie.p304e.C3717a;
import java.util.List;

/* renamed from: com.ksad.lottie.a.b.b */
public class C3648b extends C3652f<Integer> {
    public C3648b(List<C3717a<Integer>> list) {
        super(list);
    }

    /* renamed from: b */
    public Integer mo22824a(C3717a<Integer> aVar, float f) {
        if (aVar.f12629a == null || aVar.f12630b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        int intValue = ((Integer) aVar.f12629a).intValue();
        int intValue2 = ((Integer) aVar.f12630b).intValue();
        if (this.f12530b != null) {
            Integer num = (Integer) this.f12530b.mo22947a(aVar.f12632d, aVar.f12633e.floatValue(), Integer.valueOf(intValue), Integer.valueOf(intValue2), f, mo22829c(), mo22832f());
            if (num != null) {
                return num;
            }
        }
        return Integer.valueOf(C3705b.m15352a(f, intValue, intValue2));
    }
}
