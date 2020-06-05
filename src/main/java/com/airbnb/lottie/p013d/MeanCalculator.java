package com.airbnb.lottie.p013d;

/* renamed from: com.airbnb.lottie.d.d */
public class MeanCalculator {
    /* renamed from: a */
    private float f1479a;
    /* renamed from: b */
    private int f1480b;

    /* renamed from: a */
    public void mo9970a(float f) {
        this.f1479a += f;
        this.f1480b++;
        int i = this.f1480b;
        if (i == Integer.MAX_VALUE) {
            this.f1479a /= 2.0f;
            this.f1480b = i / 2;
        }
    }
}
