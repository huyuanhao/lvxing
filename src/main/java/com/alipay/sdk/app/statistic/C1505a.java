package com.alipay.sdk.app.statistic;

import android.content.Context;

/* renamed from: com.alipay.sdk.app.statistic.a */
public class C1505a {
    /* renamed from: a */
    private static C1507c f3852a;

    /* renamed from: a */
    public static void m4450a(Context context) {
        if (f3852a == null) {
            f3852a = new C1507c(context);
        }
    }

    /* renamed from: a */
    public static void m4451a(Context context, String str) {
        new Thread(new C1506b(context, str)).start();
    }

    /* renamed from: b */
    public static synchronized void m4456b(Context context, String str) {
        synchronized (C1505a.class) {
            if (f3852a != null) {
                m4451a(context, f3852a.mo12147a(str));
                f3852a = null;
            }
        }
    }

    /* renamed from: a */
    public static void m4455a(String str, Throwable th) {
        if (!(f3852a == null || th == null || th.getClass() == null)) {
            f3852a.mo12150a(str, th.getClass().getSimpleName(), th);
        }
    }

    /* renamed from: a */
    public static void m4454a(String str, String str2, Throwable th, String str3) {
        C1507c cVar = f3852a;
        if (cVar != null) {
            cVar.mo12151a(str, str2, th, str3);
        }
    }

    /* renamed from: a */
    public static void m4453a(String str, String str2, Throwable th) {
        C1507c cVar = f3852a;
        if (cVar != null) {
            cVar.mo12150a(str, str2, th);
        }
    }

    /* renamed from: a */
    public static void m4452a(String str, String str2, String str3) {
        C1507c cVar = f3852a;
        if (cVar != null) {
            cVar.mo12148a(str, str2, str3);
        }
    }
}
