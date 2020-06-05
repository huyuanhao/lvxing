package com.ksad.lottie.p303d;

/* renamed from: com.ksad.lottie.d.d */
public class C3707d {
    /* renamed from: a */
    private float f12611a;
    /* renamed from: b */
    private int f12612b;

    /* renamed from: a */
    public void mo22930a(float f) {
        this.f12611a += f;
        this.f12612b++;
        int i = this.f12612b;
        if (i == Integer.MAX_VALUE) {
            this.f12611a /= 2.0f;
            this.f12612b = i / 2;
        }
    }
}
