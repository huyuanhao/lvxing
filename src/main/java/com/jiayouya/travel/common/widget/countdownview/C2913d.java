package com.jiayouya.travel.common.widget.countdownview;

import android.content.Context;

/* compiled from: Utils */
/* renamed from: com.jiayouya.travel.common.widget.countdownview.d */
final class C2913d {
    /* renamed from: a */
    public static int m13172a(Context context, float f) {
        if (f <= 0.0f) {
            return 0;
        }
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: b */
    public static float m13174b(Context context, float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        return f * context.getResources().getDisplayMetrics().scaledDensity;
    }

    /* renamed from: a */
    public static String m13173a(int i) {
        if (i >= 10) {
            return String.valueOf(i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("0");
        sb.append(i);
        return sb.toString();
    }

    /* renamed from: b */
    public static String m13175b(int i) {
        if (i > 99) {
            return String.valueOf(i / 10);
        }
        if (i > 9) {
            return String.valueOf(i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("0");
        sb.append(i);
        return sb.toString();
    }
}
