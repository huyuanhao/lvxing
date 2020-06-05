package com.tencent.bugly.beta.utils;

import android.os.Handler;
import android.os.Looper;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.beta.utils.e */
public class C7159e {
    /* renamed from: a */
    private static Handler f23904a;

    /* renamed from: a */
    private static Handler m30680a() {
        if (f23904a == null && Looper.getMainLooper() != null) {
            f23904a = new Handler(Looper.getMainLooper());
        }
        return f23904a;
    }

    /* renamed from: a */
    public static void m30681a(Runnable runnable) {
        if (m30680a() != null) {
            f23904a.post(runnable);
        }
    }

    /* renamed from: b */
    public static void m30683b(Runnable runnable) {
        if (m30680a() != null) {
            f23904a.removeCallbacks(runnable);
        }
    }

    /* renamed from: a */
    public static void m30682a(Runnable runnable, long j) {
        if (m30680a() != null) {
            f23904a.postDelayed(runnable, j);
        }
    }
}
