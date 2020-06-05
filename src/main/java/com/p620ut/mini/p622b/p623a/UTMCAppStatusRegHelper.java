package com.p620ut.mini.p622b.p623a;

import android.app.Application;

/* renamed from: com.ut.mini.b.a.c */
public class UTMCAppStatusRegHelper {
    /* renamed from: a */
    public static void m33141a(UTMCAppStatusCallbacks aVar) {
        if (aVar != null) {
            UTMCAppStatusMonitor.m33134a().mo37411a(aVar);
        }
    }

    /* renamed from: a */
    public static void m33140a(Application application) {
        if (application != null) {
            application.registerActivityLifecycleCallbacks(UTMCAppStatusMonitor.m33134a());
        }
    }
}
