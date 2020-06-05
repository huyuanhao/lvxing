package com.ali.auth.third.p016a.p020d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.ali.auth.third.core.p024c.C0989a;
import com.ali.auth.third.core.p033j.C1018a;
import com.ali.auth.third.core.util.C1034a;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.ali.auth.third.a.d.a */
public class C0977a {
    /* renamed from: a */
    private static AtomicBoolean f1876a = new AtomicBoolean(false);
    /* renamed from: b */
    private static Context f1877b;
    /* renamed from: c */
    private static BroadcastReceiver f1878c;

    /* renamed from: a */
    public static void m1852a() {
        C1018a.m1966c("login.LoginStatus", "reset login status");
        if (f1876a.compareAndSet(true, false)) {
            m1853b();
        }
        C0989a.f1896k = null;
    }

    /* renamed from: b */
    private static void m1853b() {
        if (f1877b != null && f1878c != null) {
            Intent intent = new Intent("NOTIFY_LOGIN_STATUS_CHANGE");
            intent.putExtra("currentProcess", C1034a.m1984d());
            intent.putExtra("isLogining", f1876a.get());
            intent.setPackage(f1877b.getPackageName());
            f1877b.sendBroadcast(intent);
        }
    }
}
