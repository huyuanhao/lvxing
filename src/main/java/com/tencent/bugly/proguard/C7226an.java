package com.tencent.bugly.proguard;

import android.util.Log;
import java.util.Locale;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.an */
public class C7226an {
    /* renamed from: a */
    public static String f24395a = "CrashReportInfo";
    /* renamed from: b */
    public static String f24396b = "CrashReport";
    /* renamed from: c */
    public static boolean f24397c = false;

    /* renamed from: f */
    private static String m31150f(String str, Object... objArr) {
        if (str == null) {
            return "null";
        }
        if (!(objArr == null || objArr.length == 0)) {
            str = String.format(Locale.US, str, objArr);
        }
        return str;
    }

    /* renamed from: a */
    private static boolean m31138a(int i, String str, Object... objArr) {
        if (!f24397c) {
            return false;
        }
        String f = m31150f(str, objArr);
        if (i == 0) {
            Log.i(f24396b, f);
            return true;
        } else if (i == 1) {
            Log.d(f24396b, f);
            return true;
        } else if (i == 2) {
            Log.w(f24396b, f);
            return true;
        } else if (i == 3) {
            Log.e(f24396b, f);
            return true;
        } else if (i != 5) {
            return false;
        } else {
            Log.i(f24395a, f);
            return true;
        }
    }

    /* renamed from: a */
    private static boolean m31139a(int i, Throwable th) {
        if (!f24397c) {
            return false;
        }
        return m31138a(i, C7232aq.m31183a(th), new Object[0]);
    }

    /* renamed from: a */
    public static boolean m31141a(String str, Object... objArr) {
        return m31138a(0, str, objArr);
    }

    /* renamed from: a */
    public static boolean m31140a(Class cls, String str, Object... objArr) {
        return m31138a(0, String.format(Locale.US, "[%s] %s", new Object[]{cls.getSimpleName(), str}), objArr);
    }

    /* renamed from: b */
    public static boolean m31144b(String str, Object... objArr) {
        return m31138a(5, str, objArr);
    }

    /* renamed from: c */
    public static boolean m31147c(String str, Object... objArr) {
        return m31138a(1, str, objArr);
    }

    /* renamed from: b */
    public static boolean m31143b(Class cls, String str, Object... objArr) {
        return m31138a(1, String.format(Locale.US, "[%s] %s", new Object[]{cls.getSimpleName(), str}), objArr);
    }

    /* renamed from: d */
    public static boolean m31148d(String str, Object... objArr) {
        return m31138a(2, str, objArr);
    }

    /* renamed from: a */
    public static boolean m31142a(Throwable th) {
        return m31139a(2, th);
    }

    /* renamed from: e */
    public static boolean m31149e(String str, Object... objArr) {
        return m31138a(3, str, objArr);
    }

    /* renamed from: c */
    public static boolean m31146c(Class cls, String str, Object... objArr) {
        return m31138a(3, String.format(Locale.US, "[%s] %s", new Object[]{cls.getSimpleName(), str}), objArr);
    }

    /* renamed from: b */
    public static boolean m31145b(Throwable th) {
        return m31139a(3, th);
    }
}
