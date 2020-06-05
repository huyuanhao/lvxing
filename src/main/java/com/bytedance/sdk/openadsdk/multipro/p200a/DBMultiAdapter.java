package com.bytedance.sdk.openadsdk.multipro.p200a;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.p003os.EnvironmentCompat;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.multipro.TTPathConst;

/* renamed from: com.bytedance.sdk.openadsdk.multipro.a.a */
public class DBMultiAdapter {
    /* renamed from: a */
    private static ContentResolver m11759a(Context context) {
        if (context == null) {
            try {
                context = InternalContainer.m10059a();
            } catch (Throwable unused) {
                return null;
            }
        }
        return context.getContentResolver();
    }

    /* renamed from: a */
    private static String m11761a() {
        StringBuilder sb = new StringBuilder();
        sb.append(TTPathConst.f9099b);
        String str = "/";
        sb.append(str);
        sb.append("t_db");
        sb.append(str);
        sb.append("ttopensdk.db");
        sb.append(str);
        return sb.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0032, code lost:
            return;
     */
    /* renamed from: a */
    public static synchronized void m11763a(android.content.Context r3, java.lang.String r4, android.content.ContentValues r5) {
        /*
        java.lang.Class<com.bytedance.sdk.openadsdk.multipro.a.a> r0 = com.bytedance.sdk.openadsdk.multipro.p200a.DBMultiAdapter.class
        monitor-enter(r0)
        if (r5 == 0) goto L_0x0031
        boolean r1 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x002e }
        if (r1 == 0) goto L_0x000c
        goto L_0x0031
    L_0x000c:
        android.content.ContentResolver r3 = m11759a(r3)     // Catch:{ all -> 0x002c }
        if (r3 == 0) goto L_0x002c
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x002c }
        r1.<init>()     // Catch:{ all -> 0x002c }
        java.lang.String r2 = m11761a()     // Catch:{ all -> 0x002c }
        r1.append(r2)     // Catch:{ all -> 0x002c }
        r1.append(r4)     // Catch:{ all -> 0x002c }
        java.lang.String r4 = r1.toString()     // Catch:{ all -> 0x002c }
        android.net.Uri r4 = android.net.Uri.parse(r4)     // Catch:{ all -> 0x002c }
        r3.insert(r4, r5)     // Catch:{ all -> 0x002c }
    L_0x002c:
        monitor-exit(r0)
        return
    L_0x002e:
        r3 = move-exception
        monitor-exit(r0)
        throw r3
    L_0x0031:
        monitor-exit(r0)
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.multipro.p200a.DBMultiAdapter.m11763a(android.content.Context, java.lang.String, android.content.ContentValues):void");
    }

    /* renamed from: a */
    public static synchronized int m11758a(Context context, String str, String str2, String[] strArr) {
        synchronized (DBMultiAdapter.class) {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            try {
                ContentResolver a = m11759a(context);
                if (a != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(m11761a());
                    sb.append(str);
                    int delete = a.delete(Uri.parse(sb.toString()), str2, strArr);
                    return delete;
                }
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0036, code lost:
            return 0;
     */
    /* renamed from: a */
    public static synchronized int m11757a(android.content.Context r4, java.lang.String r5, android.content.ContentValues r6, java.lang.String r7, java.lang.String[] r8) {
        /*
        java.lang.Class<com.bytedance.sdk.openadsdk.multipro.a.a> r0 = com.bytedance.sdk.openadsdk.multipro.p200a.DBMultiAdapter.class
        monitor-enter(r0)
        r1 = 0
        if (r6 == 0) goto L_0x0035
        boolean r2 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0032 }
        if (r2 == 0) goto L_0x000d
        goto L_0x0035
    L_0x000d:
        android.content.ContentResolver r4 = m11759a(r4)     // Catch:{ all -> 0x0030 }
        if (r4 == 0) goto L_0x0030
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0030 }
        r2.<init>()     // Catch:{ all -> 0x0030 }
        java.lang.String r3 = m11761a()     // Catch:{ all -> 0x0030 }
        r2.append(r3)     // Catch:{ all -> 0x0030 }
        r2.append(r5)     // Catch:{ all -> 0x0030 }
        java.lang.String r5 = r2.toString()     // Catch:{ all -> 0x0030 }
        android.net.Uri r5 = android.net.Uri.parse(r5)     // Catch:{ all -> 0x0030 }
        int r4 = r4.update(r5, r6, r7, r8)     // Catch:{ all -> 0x0030 }
        monitor-exit(r0)
        return r4
    L_0x0030:
        monitor-exit(r0)
        return r1
    L_0x0032:
        r4 = move-exception
        monitor-exit(r0)
        throw r4
    L_0x0035:
        monitor-exit(r0)
        return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.multipro.p200a.DBMultiAdapter.m11757a(android.content.Context, java.lang.String, android.content.ContentValues, java.lang.String, java.lang.String[]):int");
    }

    /* renamed from: a */
    public static synchronized Cursor m11760a(Context context, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        synchronized (DBMultiAdapter.class) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                ContentResolver a = m11759a(context);
                if (a != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(m11761a());
                    sb.append(str);
                    Cursor query = a.query(Uri.parse(sb.toString()), strArr, str2, strArr2, str5);
                    return query;
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    /* renamed from: a */
    public static synchronized void m11762a(Context context, String str) {
        synchronized (DBMultiAdapter.class) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    ContentResolver a = m11759a(context);
                    if (a != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(m11761a());
                        sb.append(EnvironmentCompat.MEDIA_UNKNOWN);
                        sb.append("/");
                        sb.append("execSQL");
                        sb.append("?sql=");
                        sb.append(str);
                        a.getType(Uri.parse(sb.toString()));
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }
}
