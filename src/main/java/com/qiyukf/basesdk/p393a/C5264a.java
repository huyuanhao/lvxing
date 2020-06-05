package com.qiyukf.basesdk.p393a;

import android.text.TextUtils;
import android.util.Log;

/* renamed from: com.qiyukf.basesdk.a.a */
public final class C5264a {
    /* renamed from: a */
    private static C5268c f17053a = null;
    /* renamed from: b */
    private static int f17054b = 3;

    /* renamed from: a */
    public static C5268c m21615a() {
        return f17053a;
    }

    /* renamed from: a */
    private static void m21616a(int i, String str, String str2, Throwable th) {
        if (i >= f17054b) {
            long currentTimeMillis = System.currentTimeMillis();
            long id = Thread.currentThread().getId();
            StringBuilder sb = new StringBuilder();
            sb.append(id);
            sb.append("/");
            sb.append(str2);
            sb.append(10);
            sb.append(Log.getStackTraceString(th));
            Log.println(i, str, sb.toString());
            try {
                if (f17053a != null) {
                    f17053a.mo27110a(str, currentTimeMillis, str2, th);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public static void m21617a(String str, String str2) {
        m21616a(4, str, str2, (Throwable) null);
    }

    /* renamed from: a */
    public static void m21618a(String str, String str2, int i, boolean z) {
        f17054b = i;
        if (!TextUtils.isEmpty(str)) {
            C5268c cVar = f17053a;
            if (cVar == null) {
                f17053a = new C5268c(str, str2, z);
                return;
            }
            cVar.mo27109a(str);
        }
    }

    /* renamed from: a */
    public static void m21619a(String str, String str2, Throwable th) {
        m21616a(4, str, str2, th);
    }

    /* renamed from: b */
    public static void m21620b(String str, String str2) {
        m21616a(2, str, str2, (Throwable) null);
    }

    /* renamed from: b */
    public static void m21621b(String str, String str2, Throwable th) {
        m21616a(6, str, str2, th);
    }

    /* renamed from: c */
    public static void m21622c(String str, String str2) {
        m21621b(str, str2, null);
    }

    /* renamed from: c */
    public static void m21623c(String str, String str2, Throwable th) {
        m21616a(3, str, str2, th);
    }

    /* renamed from: d */
    public static void m21624d(String str, String str2) {
        m21616a(3, str, str2, (Throwable) null);
    }

    /* renamed from: d */
    public static void m21625d(String str, String str2, Throwable th) {
        m21616a(5, str, str2, th);
    }

    /* renamed from: e */
    public static void m21626e(String str, String str2) {
        m21616a(5, str, str2, (Throwable) null);
    }
}
