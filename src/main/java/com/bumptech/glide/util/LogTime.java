package com.bumptech.glide.util;

import android.os.Build.VERSION;
import android.os.SystemClock;

/* renamed from: com.bumptech.glide.util.e */
public final class LogTime {
    /* renamed from: a */
    private static final double f4913a;

    static {
        double d = 1.0d;
        if (VERSION.SDK_INT >= 17) {
            d = 1.0d / Math.pow(10.0d, 6.0d);
        }
        f4913a = d;
    }

    /* renamed from: a */
    public static long m6125a() {
        if (VERSION.SDK_INT >= 17) {
            return SystemClock.elapsedRealtimeNanos();
        }
        return SystemClock.uptimeMillis();
    }

    /* renamed from: a */
    public static double m6124a(long j) {
        return ((double) (m6125a() - j)) * f4913a;
    }
}
