package com.ksad.lottie.model.content;

import com.ksad.lottie.p303d.C3705b;
import com.ksad.lottie.p303d.C3708e;

/* renamed from: com.ksad.lottie.model.content.c */
public class C3762c {
    /* renamed from: a */
    private final float[] f12773a;
    /* renamed from: b */
    private final int[] f12774b;

    public C3762c(float[] fArr, int[] iArr) {
        this.f12773a = fArr;
        this.f12774b = iArr;
    }

    /* renamed from: a */
    public void mo23088a(C3762c cVar, C3762c cVar2, float f) {
        if (cVar.f12774b.length == cVar2.f12774b.length) {
            for (int i = 0; i < cVar.f12774b.length; i++) {
                this.f12773a[i] = C3708e.m15377a(cVar.f12773a[i], cVar2.f12773a[i], f);
                this.f12774b[i] = C3705b.m15352a(f, cVar.f12774b[i], cVar2.f12774b[i]);
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot interpolate between gradients. Lengths vary (");
        sb.append(cVar.f12774b.length);
        sb.append(" vs ");
        sb.append(cVar2.f12774b.length);
        sb.append(")");
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: a */
    public float[] mo23089a() {
        return this.f12773a;
    }

    /* renamed from: b */
    public int[] mo23090b() {
        return this.f12774b;
    }

    /* renamed from: c */
    public int mo23091c() {
        return this.f12774b.length;
    }
}
