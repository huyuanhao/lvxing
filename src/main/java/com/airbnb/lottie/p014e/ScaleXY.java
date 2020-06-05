package com.airbnb.lottie.p014e;

/* renamed from: com.airbnb.lottie.e.d */
public class ScaleXY {
    /* renamed from: a */
    private final float f1516a;
    /* renamed from: b */
    private final float f1517b;

    public ScaleXY(float f, float f2) {
        this.f1516a = f;
        this.f1517b = f2;
    }

    public ScaleXY() {
        this(1.0f, 1.0f);
    }

    /* renamed from: a */
    public float mo9988a() {
        return this.f1516a;
    }

    /* renamed from: b */
    public float mo9989b() {
        return this.f1517b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(mo9988a());
        sb.append("x");
        sb.append(mo9989b());
        return sb.toString();
    }
}
