package com.kwad.sdk.p306a;

import android.os.Handler;
import android.os.Looper;

/* renamed from: com.kwad.sdk.a.r */
public class C3815r {
    /* renamed from: a */
    private static final Handler f12932a = new Handler(Looper.getMainLooper());

    /* renamed from: a */
    public static void m15859a(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            f12932a.post(runnable);
        }
    }
}
