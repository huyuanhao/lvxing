package com.bytedance.tea.crash.p218e;

import android.os.Handler;
import android.os.HandlerThread;

/* renamed from: com.bytedance.tea.crash.e.h */
public class NpthHandlerThread {
    /* renamed from: a */
    private static volatile HandlerThread f9349a;
    /* renamed from: b */
    private static volatile Handler f9350b;
    /* renamed from: c */
    private static volatile Handler f9351c;

    /* renamed from: a */
    public static HandlerThread m12473a() {
        if (f9349a == null) {
            synchronized (NpthHandlerThread.class) {
                if (f9349a == null) {
                    f9349a = new HandlerThread("default_npth_thread");
                    f9349a.start();
                    f9350b = new Handler(f9349a.getLooper());
                }
            }
        }
        return f9349a;
    }

    /* renamed from: b */
    public static Handler m12474b() {
        if (f9350b == null) {
            m12473a();
        }
        return f9350b;
    }
}
