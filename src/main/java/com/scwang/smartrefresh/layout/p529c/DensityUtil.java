package com.scwang.smartrefresh.layout.p529c;

import android.content.res.Resources;

/* renamed from: com.scwang.smartrefresh.layout.c.b */
public class DensityUtil {
    /* renamed from: a */
    public float f20843a = Resources.getSystem().getDisplayMetrics().density;

    /* renamed from: a */
    public static int m25572a(float f) {
        return (int) ((f * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: a */
    public static float m25571a(int i) {
        return ((float) i) / Resources.getSystem().getDisplayMetrics().density;
    }

    /* renamed from: b */
    public int mo30968b(float f) {
        return (int) ((f * this.f20843a) + 0.5f);
    }
}
