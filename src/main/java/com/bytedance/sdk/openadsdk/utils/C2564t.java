package com.bytedance.sdk.openadsdk.utils;

import android.util.Log;

/* compiled from: Logger */
/* renamed from: com.bytedance.sdk.openadsdk.utils.t */
public class C2564t {
    /* renamed from: a */
    private static boolean f9187a = false;
    /* renamed from: b */
    private static int f9188b = 4;

    /* renamed from: a */
    public static void m12213a(int i) {
        f9188b = i;
    }

    /* renamed from: a */
    public static boolean m12217a() {
        return f9188b <= 3;
    }

    /* renamed from: b */
    public static void m12218b() {
        f9187a = true;
        m12213a(3);
    }

    /* renamed from: c */
    public static boolean m12224c() {
        return f9187a;
    }

    /* renamed from: a */
    public static void m12215a(String str, String str2) {
        if (m12224c() && str2 != null && f9188b <= 2) {
            Log.v(str, str2);
        }
    }

    /* renamed from: a */
    public static void m12214a(String str) {
        if (m12224c()) {
            m12220b("Logger", str);
        }
    }

    /* renamed from: b */
    public static void m12220b(String str, String str2) {
        if (m12224c() && str2 != null && f9188b <= 3) {
            Log.d(str, str2);
        }
    }

    /* renamed from: a */
    public static void m12216a(String str, String str2, Throwable th) {
        if (m12224c()) {
            if (!(str2 == null && th == null) && f9188b <= 3) {
                Log.d(str, str2, th);
            }
        }
    }

    /* renamed from: c */
    public static void m12222c(String str, String str2) {
        if (m12224c() && str2 != null && f9188b <= 4) {
            Log.i(str, str2);
        }
    }

    /* renamed from: d */
    public static void m12225d(String str, String str2) {
        if (m12224c() && str2 != null && f9188b <= 5) {
            Log.w(str, str2);
        }
    }

    /* renamed from: b */
    public static void m12221b(String str, String str2, Throwable th) {
        if (m12224c()) {
            if (!(str2 == null && th == null) && f9188b <= 5) {
                Log.w(str, str2, th);
            }
        }
    }

    /* renamed from: b */
    public static void m12219b(String str) {
        if (m12224c()) {
            m12226e("Logger", str);
        }
    }

    /* renamed from: e */
    public static void m12226e(String str, String str2) {
        if (m12224c() && str2 != null && f9188b <= 6) {
            Log.e(str, str2);
        }
    }

    /* renamed from: c */
    public static void m12223c(String str, String str2, Throwable th) {
        if (m12224c()) {
            if (!(str2 == null && th == null) && f9188b <= 6) {
                Log.e(str, str2, th);
            }
        }
    }
}
