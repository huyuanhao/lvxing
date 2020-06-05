package com.bytedance.embedapplog.util;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.embedapplog.p142b.C1821h;

/* renamed from: com.bytedance.embedapplog.util.c */
public class C1851c {
    /* renamed from: a */
    private static volatile String f5220a;

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0037 A[Catch:{ all -> 0x0023 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0042 A[Catch:{ all -> 0x0023 }] */
    /* renamed from: a */
    public static java.lang.String m6562a(android.content.Context r5, com.bytedance.embedapplog.p142b.C1821h r6) {
        /*
        java.lang.String r0 = f5220a
        boolean r0 = android.text.TextUtils.isEmpty(r0)
        if (r0 == 0) goto L_0x005c
        java.lang.Class<com.bytedance.embedapplog.util.c> r0 = com.bytedance.embedapplog.util.C1851c.class
        monitor-enter(r0)
        java.lang.String r1 = f5220a     // Catch:{ all -> 0x0059 }
        boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0059 }
        if (r1 != 0) goto L_0x0017
        java.lang.String r5 = f5220a     // Catch:{ all -> 0x0059 }
        monitor-exit(r0)     // Catch:{ all -> 0x0059 }
        return r5
    L_0x0017:
        r1 = 0
        com.google.android.gms.ads.identifier.AdvertisingIdClient$Info r2 = com.google.android.gms.ads.identifier.AdvertisingIdClient.getAdvertisingIdInfo(r5)     // Catch:{ all -> 0x0023 }
        if (r2 == 0) goto L_0x0030
        java.lang.String r2 = r2.getId()     // Catch:{ all -> 0x0023 }
        goto L_0x0031
    L_0x0023:
        r2 = move-exception
        boolean r3 = r2 instanceof java.lang.ClassNotFoundException     // Catch:{ all -> 0x0059 }
        if (r3 != 0) goto L_0x0030
        boolean r3 = r2 instanceof java.lang.NoClassDefFoundError     // Catch:{ all -> 0x0059 }
        if (r3 == 0) goto L_0x002d
        goto L_0x0030
    L_0x002d:
        r2.printStackTrace()     // Catch:{ all -> 0x0059 }
    L_0x0030:
        r2 = r1
    L_0x0031:
        boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0059 }
        if (r3 == 0) goto L_0x0042
        android.content.SharedPreferences r5 = r6.mo13399d()     // Catch:{ all -> 0x0059 }
        java.lang.String r6 = "google_aid"
        java.lang.String r2 = r5.getString(r6, r1)     // Catch:{ all -> 0x0059 }
        goto L_0x0055
    L_0x0042:
        android.content.SharedPreferences r3 = r6.mo13399d()     // Catch:{ all -> 0x0059 }
        java.lang.String r4 = "google_aid"
        java.lang.String r1 = r3.getString(r4, r1)     // Catch:{ all -> 0x0059 }
        boolean r1 = android.text.TextUtils.equals(r1, r2)     // Catch:{ all -> 0x0059 }
        if (r1 != 0) goto L_0x0055
        m6563a(r5, r2, r6)     // Catch:{ all -> 0x0059 }
    L_0x0055:
        f5220a = r2     // Catch:{ all -> 0x0059 }
        monitor-exit(r0)     // Catch:{ all -> 0x0059 }
        goto L_0x005c
    L_0x0059:
        r5 = move-exception
        monitor-exit(r0)     // Catch:{ all -> 0x0059 }
        throw r5
    L_0x005c:
        java.lang.String r5 = f5220a
        return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.util.C1851c.m6562a(android.content.Context, com.bytedance.embedapplog.b.h):java.lang.String");
    }

    /* renamed from: a */
    private static void m6563a(Context context, String str, C1821h hVar) {
        if (!TextUtils.isEmpty(str) && context != null) {
            hVar.mo13399d().edit().putString("google_aid", str).apply();
        }
    }
}
