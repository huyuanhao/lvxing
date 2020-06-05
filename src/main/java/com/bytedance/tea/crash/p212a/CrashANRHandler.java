package com.bytedance.tea.crash.p212a;

import android.content.Context;

/* renamed from: com.bytedance.tea.crash.a.f */
public class CrashANRHandler {
    /* renamed from: a */
    private static volatile CrashANRHandler f9217a;
    /* renamed from: b */
    private final ANRManager f9218b;

    /* renamed from: a */
    public static CrashANRHandler m12285a(Context context) {
        if (f9217a == null) {
            synchronized (CrashANRHandler.class) {
                if (f9217a == null) {
                    f9217a = new CrashANRHandler(context);
                }
            }
        }
        return f9217a;
    }

    private CrashANRHandler(Context context) {
        this.f9218b = new ANRManager(context);
    }

    /* renamed from: a */
    public void mo16965a() {
        this.f9218b.mo16961a();
    }
}
