package com.scwang.smartrefresh.layout.p529c;

import android.view.animation.Interpolator;

/* renamed from: com.scwang.smartrefresh.layout.c.f */
public class ViscousFluidInterpolator implements Interpolator {
    /* renamed from: a */
    private static final float f20845a = (1.0f / m25586a(1.0f));
    /* renamed from: b */
    private static final float f20846b = (1.0f - (f20845a * m25586a(1.0f)));

    /* renamed from: a */
    private static float m25586a(float f) {
        float f2 = f * 8.0f;
        if (f2 < 1.0f) {
            return f2 - (1.0f - ((float) Math.exp((double) (-f2))));
        }
        return ((1.0f - ((float) Math.exp((double) (1.0f - f2)))) * 0.63212055f) + 0.36787945f;
    }

    public float getInterpolation(float f) {
        float a = f20845a * m25586a(f);
        return a > 0.0f ? a + f20846b : a;
    }
}
