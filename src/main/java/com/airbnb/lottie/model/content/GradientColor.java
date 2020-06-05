package com.airbnb.lottie.model.content;

import com.airbnb.lottie.p013d.GammaEvaluator;
import com.airbnb.lottie.p013d.MiscUtils;

/* renamed from: com.airbnb.lottie.model.content.c */
public class GradientColor {
    /* renamed from: a */
    private final float[] f1634a;
    /* renamed from: b */
    private final int[] f1635b;

    public GradientColor(float[] fArr, int[] iArr) {
        this.f1634a = fArr;
        this.f1635b = iArr;
    }

    /* renamed from: a */
    public float[] mo10070a() {
        return this.f1634a;
    }

    /* renamed from: b */
    public int[] mo10071b() {
        return this.f1635b;
    }

    /* renamed from: c */
    public int mo10072c() {
        return this.f1635b.length;
    }

    /* renamed from: a */
    public void mo10069a(GradientColor cVar, GradientColor cVar2, float f) {
        if (cVar.f1635b.length == cVar2.f1635b.length) {
            for (int i = 0; i < cVar.f1635b.length; i++) {
                this.f1634a[i] = MiscUtils.m1440a(cVar.f1634a[i], cVar2.f1634a[i], f);
                this.f1635b[i] = GammaEvaluator.m1415a(f, cVar.f1635b[i], cVar2.f1635b[i]);
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot interpolate between gradients. Lengths vary (");
        sb.append(cVar.f1635b.length);
        sb.append(" vs ");
        sb.append(cVar2.f1635b.length);
        sb.append(")");
        throw new IllegalArgumentException(sb.toString());
    }
}
