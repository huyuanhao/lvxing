package com.bytedance.embedapplog.util;

import android.util.Log;

/* renamed from: com.bytedance.embedapplog.util.h */
public class C1856h {
    /* renamed from: a */
    public static boolean f5225a = false;
    /* renamed from: b */
    public static boolean f5226b = false;

    /* renamed from: a */
    public static void m6581a(String str, Throwable th) {
        if (f5226b) {
            Log.d("TeaLog", str, th);
        }
    }

    /* renamed from: b */
    public static void m6583b(String str, Throwable th) {
        Log.w("TeaLog", str, th);
    }

    /* renamed from: c */
    public static void m6584c(String str, Throwable th) {
        Log.e("TeaLog", str, th);
    }

    /* renamed from: d */
    public static void m6585d(String str, Throwable th) {
        Log.i("TeaLog", str, th);
    }

    /* renamed from: a */
    public static void m6582a(Throwable th) {
        Log.e("TeaLog", "U SHALL NOT PASS!", th);
    }
}
