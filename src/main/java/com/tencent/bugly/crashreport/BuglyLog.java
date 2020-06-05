package com.tencent.bugly.crashreport;

import android.util.Log;
import com.tencent.bugly.C7121b;
import com.tencent.bugly.proguard.C7228ap;

/* compiled from: BUGLY */
public class BuglyLog {
    /* renamed from: v */
    public static void m30689v(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (C7121b.f23665c) {
            Log.v(str, str2);
        }
        C7228ap.m31157a("V", str, str2);
    }

    /* renamed from: d */
    public static void m30685d(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (C7121b.f23665c) {
            Log.d(str, str2);
        }
        C7228ap.m31157a("D", str, str2);
    }

    /* renamed from: i */
    public static void m30688i(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (C7121b.f23665c) {
            Log.i(str, str2);
        }
        C7228ap.m31157a("I", str, str2);
    }

    /* renamed from: w */
    public static void m30690w(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (C7121b.f23665c) {
            Log.w(str, str2);
        }
        C7228ap.m31157a("W", str, str2);
    }

    /* renamed from: e */
    public static void m30686e(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (C7121b.f23665c) {
            Log.e(str, str2);
        }
        C7228ap.m31157a("E", str, str2);
    }

    /* renamed from: e */
    public static void m30687e(String str, String str2, Throwable th) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (C7121b.f23665c) {
            Log.e(str, str2, th);
        }
        C7228ap.m31158a("E", str, th);
    }

    public static void setCache(int i) {
        C7228ap.m31155a(i);
    }
}
