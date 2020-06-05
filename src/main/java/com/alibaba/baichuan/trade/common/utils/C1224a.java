package com.alibaba.baichuan.trade.common.utils;

import android.util.Log;
import com.alibaba.baichuan.trade.common.C1223b;

/* renamed from: com.alibaba.baichuan.trade.common.utils.a */
public class C1224a {
    /* renamed from: a */
    private static final String f2515a;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("AliBC_Trade[");
        sb.append(C1223b.f2467g);
        sb.append("]");
        f2515a = sb.toString();
    }

    /* renamed from: a */
    public static void m2402a(String str, String str2) {
        if (C1223b.m2401e()) {
            Log.i(f2515a, m2407e(str, str2));
        }
    }

    /* renamed from: a */
    public static void m2403a(String str, String str2, Throwable th) {
        Log.e(f2515a, m2407e(str, str2), th);
    }

    /* renamed from: b */
    public static void m2404b(String str, String str2) {
        if (C1223b.m2401e()) {
            Log.d(f2515a, m2407e(str, str2));
        }
    }

    /* renamed from: c */
    public static void m2405c(String str, String str2) {
        if (C1223b.m2401e()) {
            Log.w(f2515a, m2407e(str, str2));
        }
    }

    /* renamed from: d */
    public static void m2406d(String str, String str2) {
        if (C1223b.m2401e()) {
            Log.e(f2515a, m2407e(str, str2));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0055  */
    /* renamed from: e */
    private static java.lang.String m2407e(java.lang.String r5, java.lang.String r6) {
        /*
        java.lang.String r0 = ""
        java.lang.Throwable r1 = new java.lang.Throwable     // Catch:{ Exception -> 0x0024 }
        r1.<init>()     // Catch:{ Exception -> 0x0024 }
        java.lang.StackTraceElement[] r1 = r1.getStackTrace()     // Catch:{ Exception -> 0x0024 }
        r2 = 2
        r3 = r1[r2]     // Catch:{ Exception -> 0x0024 }
        java.lang.String r3 = r3.getClassName()     // Catch:{ Exception -> 0x0024 }
        r4 = r1[r2]     // Catch:{ Exception -> 0x0021 }
        java.lang.String r4 = r4.getMethodName()     // Catch:{ Exception -> 0x0021 }
        r1 = r1[r2]     // Catch:{ Exception -> 0x001f }
        int r1 = r1.getLineNumber()     // Catch:{ Exception -> 0x001f }
        goto L_0x002b
    L_0x001f:
        r1 = move-exception
        goto L_0x0027
    L_0x0021:
        r1 = move-exception
        r4 = r0
        goto L_0x0027
    L_0x0024:
        r1 = move-exception
        r3 = r0
        r4 = r3
    L_0x0027:
        r1.printStackTrace()
        r1 = -1
    L_0x002b:
        java.lang.StringBuffer r2 = new java.lang.StringBuffer
        r2.<init>()
        if (r5 != 0) goto L_0x0033
        r5 = r0
    L_0x0033:
        r2.append(r5)
        java.lang.String r5 = " -> ["
        r2.append(r5)
        r2.append(r3)
        java.lang.String r5 = "."
        r2.append(r5)
        r2.append(r4)
        java.lang.String r5 = ":"
        r2.append(r5)
        r2.append(r1)
        java.lang.String r5 = "] "
        r2.append(r5)
        if (r6 != 0) goto L_0x0056
        r6 = r0
    L_0x0056:
        r2.append(r6)
        java.lang.String r5 = r2.toString()
        return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.baichuan.trade.common.utils.C1224a.m2407e(java.lang.String, java.lang.String):java.lang.String");
    }
}
