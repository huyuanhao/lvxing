package com.tencent.stat.common;

import android.content.Context;
import android.provider.Settings.System;
import android.util.Log;
import com.tencent.mid.core.Constants;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* renamed from: com.tencent.stat.common.j */
public class C7606j {
    /* renamed from: a */
    public static void m32782a(final Context context) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    C7606j.m32790g(context);
                    C7606j.m32791h(context);
                    C7606j.m32789f(context);
                } catch (Throwable unused) {
                }
            }
        }).start();
    }

    /* renamed from: e */
    private static boolean m32788e(Context context) {
        if (m32784a(context, Constants.PERMISSION_WRITE_SETTINGS)) {
            try {
                return System.putInt(context.getContentResolver(), "com.tencent.tpnsWatchdogPort", 1000);
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    /* access modifiers changed from: private|static */
    /* renamed from: f */
    public static void m32789f(Context context) {
        try {
            int i = System.getInt(context.getContentResolver(), "com.tencent.tpnsWatchdogPort");
            if (i > 2048) {
                m32788e(context);
                m32783a("exit:", i);
                m32783a("exit1:", i);
                m32783a("exit2:", i);
            }
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: private|static */
    /* renamed from: g */
    public static boolean m32790g(Context context) {
        try {
            StringBuffer stringBuffer = new StringBuffer(context.getDir("watchdog", 0).getAbsolutePath());
            stringBuffer.append(File.separator);
            stringBuffer.append("libtpnsWatchdog.so");
            String stringBuffer2 = stringBuffer.toString();
            if (new File(stringBuffer2).exists()) {
                StringBuilder sb = new StringBuilder();
                sb.append("chmod 400 ");
                sb.append(stringBuffer2);
                try {
                    int waitFor = Runtime.getRuntime().exec(sb.toString()).waitFor();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("fixsdfile exit:");
                    sb2.append(waitFor);
                    Log.i("XGFix", sb2.toString());
                } catch (Throwable unused) {
                    return false;
                }
            }
        } catch (Throwable unused2) {
        }
        return true;
    }

    /* access modifiers changed from: private|static */
    /* renamed from: h */
    public static boolean m32791h(Context context) {
        try {
            Class cls = Class.forName("com.tencent.android.tpush.service.XGWatchdog");
            Object invoke = cls.getMethod("getInstance", new Class[]{Context.class}).invoke(cls, new Object[]{context});
            Field declaredField = invoke.getClass().getDeclaredField("WatchdogPath");
            declaredField.setAccessible(true);
            declaredField.set(invoke, "echo");
            return true;
        } catch (Exception | InvocationTargetException unused) {
            return false;
        }
    }

    /* renamed from: a */
    private static boolean m32784a(Context context, String str) {
        try {
            if (context.getPackageManager().checkPermission(str, context.getPackageName()) == 0) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            Log.e("XGFix", "checkPermission error", th);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0051 A[SYNTHETIC, Splitter:B:23:0x0051] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006e A[SYNTHETIC, Splitter:B:28:0x006e] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0075 A[SYNTHETIC, Splitter:B:35:0x0075] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0092 A[SYNTHETIC, Splitter:B:40:0x0092] */
    /* JADX WARNING: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    private static void m32783a(java.lang.String r6, int r7) {
        /*
        java.lang.String r0 = "close socket failed "
        java.lang.String r1 = "XGFix"
        r2 = 0
        java.net.Socket r3 = new java.net.Socket     // Catch:{ Exception -> 0x0072, all -> 0x004d }
        java.lang.String r4 = "127.0.0.1"
        r3.<init>(r4, r7)     // Catch:{ Exception -> 0x0072, all -> 0x004d }
        r7 = 2000(0x7d0, float:2.803E-42)
        r3.setSoTimeout(r7)     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
        java.io.BufferedWriter r7 = new java.io.BufferedWriter     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
        java.io.OutputStreamWriter r4 = new java.io.OutputStreamWriter     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
        java.io.OutputStream r5 = r3.getOutputStream()     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
        r4.<init>(r5)     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
        r7.<init>(r4)     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
        r7.write(r6)     // Catch:{ Exception -> 0x0047, all -> 0x0044 }
        r7.flush()     // Catch:{ Exception -> 0x0047, all -> 0x0044 }
        r3.close()     // Catch:{ Exception -> 0x0029 }
        goto L_0x0040
    L_0x0029:
        r6 = move-exception
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>()
        r2.append(r0)
        java.lang.String r6 = r6.getMessage()
        r2.append(r6)
        java.lang.String r6 = r2.toString()
        android.util.Log.e(r1, r6)
    L_0x0040:
        r7.close()     // Catch:{ Exception -> 0x0095 }
        goto L_0x0095
    L_0x0044:
        r6 = move-exception
        r2 = r7
        goto L_0x004f
    L_0x0047:
        r2 = r7
        goto L_0x0073
    L_0x0049:
        r6 = move-exception
        goto L_0x004f
        goto L_0x0073
    L_0x004d:
        r6 = move-exception
        r3 = r2
    L_0x004f:
        if (r3 == 0) goto L_0x006c
        r3.close()     // Catch:{ Exception -> 0x0055 }
        goto L_0x006c
    L_0x0055:
        r7 = move-exception
        java.lang.StringBuilder r3 = new java.lang.StringBuilder
        r3.<init>()
        r3.append(r0)
        java.lang.String r7 = r7.getMessage()
        r3.append(r7)
        java.lang.String r7 = r3.toString()
        android.util.Log.e(r1, r7)
    L_0x006c:
        if (r2 == 0) goto L_0x0071
        r2.close()     // Catch:{ Exception -> 0x0071 }
    L_0x0071:
        throw r6
    L_0x0072:
        r3 = r2
    L_0x0073:
        if (r3 == 0) goto L_0x0090
        r3.close()     // Catch:{ Exception -> 0x0079 }
        goto L_0x0090
    L_0x0079:
        r6 = move-exception
        java.lang.StringBuilder r7 = new java.lang.StringBuilder
        r7.<init>()
        r7.append(r0)
        java.lang.String r6 = r6.getMessage()
        r7.append(r6)
        java.lang.String r6 = r7.toString()
        android.util.Log.e(r1, r6)
    L_0x0090:
        if (r2 == 0) goto L_0x0095
        r2.close()     // Catch:{ Exception -> 0x0095 }
    L_0x0095:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.common.C7606j.m32783a(java.lang.String, int):void");
    }
}
