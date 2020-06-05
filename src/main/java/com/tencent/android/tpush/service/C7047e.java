package com.tencent.android.tpush.service;

import android.os.PowerManager.WakeLock;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.service.e */
public class C7047e {
    /* renamed from: a */
    private static C7047e f23426a;
    /* renamed from: b */
    private WakeLock f23427b = null;

    private C7047e() {
    }

    /* renamed from: a */
    public static C7047e m30136a() {
        if (f23426a == null) {
            f23426a = new C7047e();
        }
        return f23426a;
    }

    /* renamed from: b */
    public WakeLock mo34150b() {
        return this.f23427b;
    }
}
