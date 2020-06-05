package com.tencent.android.tpush.stat.p596a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.stat.a.e */
public class C7068e {
    /* renamed from: a */
    private static SharedPreferences f23499a;

    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
            f23499a = android.preference.PreferenceManager.getDefaultSharedPreferences(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
            r3 = f23499a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0033, code lost:
            return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0039, code lost:
            return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x002a */
    /* renamed from: a */
    static synchronized android.content.SharedPreferences m30284a(android.content.Context r3) {
        /*
        java.lang.Class<com.tencent.android.tpush.stat.a.e> r0 = com.tencent.android.tpush.stat.p596a.C7068e.class
        monitor-enter(r0)
        int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x002a }
        r2 = 11
        if (r1 < r2) goto L_0x0013
        java.lang.String r1 = ".tpush_mta"
        r2 = 4
        android.content.SharedPreferences r1 = r3.getSharedPreferences(r1, r2)     // Catch:{ all -> 0x002a }
        f23499a = r1     // Catch:{ all -> 0x002a }
        goto L_0x001c
    L_0x0013:
        java.lang.String r1 = ".tpush_mta"
        r2 = 0
        android.content.SharedPreferences r1 = r3.getSharedPreferences(r1, r2)     // Catch:{ all -> 0x002a }
        f23499a = r1     // Catch:{ all -> 0x002a }
    L_0x001c:
        android.content.SharedPreferences r1 = f23499a     // Catch:{ all -> 0x002a }
        if (r1 != 0) goto L_0x0026
        android.content.SharedPreferences r1 = android.preference.PreferenceManager.getDefaultSharedPreferences(r3)     // Catch:{ all -> 0x002a }
        f23499a = r1     // Catch:{ all -> 0x002a }
    L_0x0026:
        android.content.SharedPreferences r3 = f23499a     // Catch:{ all -> 0x0034 }
        monitor-exit(r0)
        return r3
    L_0x002a:
        android.content.SharedPreferences r3 = android.preference.PreferenceManager.getDefaultSharedPreferences(r3)     // Catch:{ Exception -> 0x0037 }
        f23499a = r3     // Catch:{ Exception -> 0x0037 }
        android.content.SharedPreferences r3 = f23499a     // Catch:{ all -> 0x0034 }
        monitor-exit(r0)
        return r3
    L_0x0034:
        r3 = move-exception
        monitor-exit(r0)
        throw r3
    L_0x0037:
        r3 = 0
        monitor-exit(r0)
        return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.stat.p596a.C7068e.m30284a(android.content.Context):android.content.SharedPreferences");
    }

    /* renamed from: a */
    public static long m30283a(Context context, String str, long j) {
        StringBuilder sb = new StringBuilder();
        sb.append("tpush_");
        sb.append(str);
        return m30284a(context).getLong(C7066c.m30256a(context, sb.toString()), j);
    }

    /* renamed from: b */
    public static void m30287b(Context context, String str, long j) {
        StringBuilder sb = new StringBuilder();
        sb.append("tpush_");
        sb.append(str);
        String a = C7066c.m30256a(context, sb.toString());
        Editor edit = m30284a(context).edit();
        edit.putLong(a, j);
        edit.commit();
    }

    /* renamed from: a */
    public static int m30282a(Context context, String str, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("tpush_");
        sb.append(str);
        return m30284a(context).getInt(C7066c.m30256a(context, sb.toString()), i);
    }

    /* renamed from: b */
    public static void m30286b(Context context, String str, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("tpush_");
        sb.append(str);
        String a = C7066c.m30256a(context, sb.toString());
        Editor edit = m30284a(context).edit();
        edit.putInt(a, i);
        edit.commit();
    }

    /* renamed from: a */
    public static String m30285a(Context context, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("tpush_");
        sb.append(str);
        return m30284a(context).getString(C7066c.m30256a(context, sb.toString()), str2);
    }

    /* renamed from: b */
    public static void m30288b(Context context, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("tpush_");
        sb.append(str);
        String a = C7066c.m30256a(context, sb.toString());
        Editor edit = m30284a(context).edit();
        edit.putString(a, str2);
        edit.commit();
    }
}
