package com.ksad.lottie.p298a.p300b;

import com.ksad.lottie.model.content.C3762c;
import com.ksad.lottie.p304e.C3717a;
import java.util.List;

/* renamed from: com.ksad.lottie.a.b.d */
public class C3650d extends C3652f<C3762c> {
    /* renamed from: c */
    private final C3762c f12535c;

    public C3650d(List<C3717a<C3762c>> list) {
        super(list);
        int i = 0;
        C3762c cVar = (C3762c) ((C3717a) list.get(0)).f12629a;
        if (cVar != null) {
            i = cVar.mo23091c();
        }
        this.f12535c = new C3762c(new float[i], new int[i]);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public C3762c mo22824a(C3717a<C3762c> aVar, float f) {
        this.f12535c.mo23088a((C3762c) aVar.f12629a, (C3762c) aVar.f12630b, f);
        return this.f12535c;
    }
}
