package com.p522qq.p523e.comm.util;

import android.util.Log;
import com.p522qq.p523e.comm.services.C6437a;

/* renamed from: com.qq.e.comm.util.GDTLogger */
public class GDTLogger {
    public static final boolean DEBUG_ENABLE = false;

    /* renamed from: d */
    public static void m25258d(String str) {
        m25259d("gdt_ad_mob", str);
    }

    /* renamed from: d */
    public static void m25259d(String str, String str2) {
    }

    /* renamed from: e */
    public static void m25260e(String str) {
        Log.e("gdt_ad_mob", str);
    }

    /* renamed from: e */
    public static void m25261e(String str, Throwable th) {
        String str2 = "gdt_ad_mob";
        if (th == null) {
            Log.e(str2, str);
        } else {
            Log.e(str2, str, th);
        }
    }

    /* renamed from: i */
    public static void m25262i(String str) {
        Log.i("gdt_ad_mob", str);
    }

    public static void report(String str) {
        report(str, null);
    }

    public static void report(String str, Throwable th) {
        m25261e(str, th);
        C6437a.m25254a();
        C6437a.m25256a(str, th);
    }

    /* renamed from: w */
    public static void m25263w(String str) {
        Log.e("gdt_ad_mob", str);
    }

    /* renamed from: w */
    public static void m25264w(String str, Throwable th) {
        String str2 = "gdt_ad_mob";
        if (th == null) {
            Log.w(str2, str);
        } else {
            Log.w(str2, str, th);
        }
    }
}
