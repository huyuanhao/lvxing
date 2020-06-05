package com.bytedance.sdk.openadsdk.utils;

import android.text.TextUtils;
import java.lang.reflect.Method;

/* renamed from: com.bytedance.sdk.openadsdk.utils.ag */
public class TTReflectUtils {
    /* renamed from: a */
    public static Method m11989a(String str, String str2, Class<?>... clsArr) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            Class a = m11987a(str);
            if (a != null) {
                return a.getMethod(str2, clsArr);
            }
            return null;
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("get method: ");
            sb.append(str);
            sb.append(", ");
            sb.append(str2);
            C2564t.m12216a("TTClassLoader", sb.toString(), th);
            return null;
        }
    }

    /* JADX WARNING: type inference failed for: r2v5, types: [java.lang.Class<?>, java.lang.Class] */
    /* JADX WARNING: type inference failed for: r2v6, types: [java.lang.Class<?>, java.lang.Class] */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:4|3|5|6|7|8|14) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return r2;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0015 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* renamed from: a */
    public static java.lang.Class<?> m11987a(java.lang.String r2) {
        /*
        r0 = 1
        java.lang.ClassLoader r1 = m11988a()     // Catch:{ ClassNotFoundException -> 0x000a }
        java.lang.Class r2 = java.lang.Class.forName(r2, r0, r1)     // Catch:{ ClassNotFoundException -> 0x000a }
        goto L_0x001b
    L_0x000a:
        java.lang.Class<com.bytedance.sdk.openadsdk.utils.ag> r1 = com.bytedance.sdk.openadsdk.utils.TTReflectUtils.class
        java.lang.ClassLoader r1 = r1.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x0015 }
        java.lang.Class r2 = java.lang.Class.forName(r2, r0, r1)     // Catch:{ ClassNotFoundException -> 0x0015 }
        goto L_0x001b
    L_0x0015:
        java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException -> 0x001a }
        goto L_0x001b
    L_0x001a:
        r2 = 0
    L_0x001b:
        return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.utils.TTReflectUtils.m11987a(java.lang.String):java.lang.Class");
    }

    /* renamed from: a */
    private static ClassLoader m11988a() {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        return contextClassLoader == null ? TTReflectUtils.class.getClassLoader() : contextClassLoader;
    }
}
