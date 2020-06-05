package com.qiyukf.nimlib.p453d.p459b.p460a;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.p003os.EnvironmentCompat;

/* renamed from: com.qiyukf.nimlib.d.b.a.g */
public final class C5769g {
    /* renamed from: a */
    private static String f18375a;
    /* renamed from: b */
    private static String f18376b;

    /* renamed from: a */
    static String m23185a() {
        String str;
        Throwable th;
        String str2 = EnvironmentCompat.MEDIA_UNKNOWN;
        try {
            if (f18375a == null) {
                m23186a("");
            }
            str = f18375a;
            try {
                String b = m23187b();
                if (TextUtils.isEmpty(b) || str2.equals(b)) {
                    return str;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append("_");
                sb.append(m23187b());
                return sb.toString();
            } catch (Throwable th2) {
                th = th2;
                StringBuilder sb2 = new StringBuilder("RomUtils getNameVersion error=");
                sb2.append(th.getMessage());
                Log.e("stat", sb2.toString());
                th.printStackTrace();
                return str;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            str = str2;
            th = th4;
            StringBuilder sb22 = new StringBuilder("RomUtils getNameVersion error=");
            sb22.append(th.getMessage());
            Log.e("stat", sb22.toString());
            th.printStackTrace();
            return str;
        }
    }

    /* renamed from: a */
    private static boolean m23186a(String str) {
        String upperCase;
        String str2 = f18375a;
        if (str2 != null) {
            return str2.equals(str);
        }
        String b = m23188b("ro.miui.ui.version.name");
        f18376b = b;
        if (!TextUtils.isEmpty(b)) {
            upperCase = "MIUI";
        } else {
            String b2 = m23188b("ro.build.version.emui");
            f18376b = b2;
            if (!TextUtils.isEmpty(b2)) {
                upperCase = "EMUI";
            } else {
                String b3 = m23188b("ro.build.version.opporom");
                f18376b = b3;
                if (!TextUtils.isEmpty(b3)) {
                    upperCase = "OPPO";
                } else {
                    String b4 = m23188b("ro.vivo.os.version");
                    f18376b = b4;
                    if (!TextUtils.isEmpty(b4)) {
                        upperCase = "VIVO";
                    } else {
                        String b5 = m23188b("ro.smartisan.version");
                        f18376b = b5;
                        if (!TextUtils.isEmpty(b5)) {
                            upperCase = "SMARTISAN";
                        } else {
                            String str3 = Build.DISPLAY;
                            f18376b = str3;
                            String str4 = "FLYME";
                            if (str3.toUpperCase().contains(str4)) {
                                f18375a = str4;
                                return f18375a.equals(str);
                            }
                            f18376b = EnvironmentCompat.MEDIA_UNKNOWN;
                            upperCase = Build.MANUFACTURER.toUpperCase();
                        }
                    }
                }
            }
        }
        f18375a = upperCase;
        return f18375a.equals(str);
    }

    /* renamed from: b */
    private static String m23187b() {
        if (f18376b == null) {
            m23186a("");
        }
        return f18376b;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x004f A[SYNTHETIC, Splitter:B:18:0x004f] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005c A[SYNTHETIC, Splitter:B:26:0x005c] */
    /* renamed from: b */
    private static java.lang.String m23188b(java.lang.String r5) {
        /*
        r0 = 0
        java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch:{ IOException -> 0x0039, all -> 0x0037 }
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0039, all -> 0x0037 }
        java.lang.String r3 = "getprop "
        r2.<init>(r3)     // Catch:{ IOException -> 0x0039, all -> 0x0037 }
        r2.append(r5)     // Catch:{ IOException -> 0x0039, all -> 0x0037 }
        java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x0039, all -> 0x0037 }
        java.lang.Process r1 = r1.exec(r2)     // Catch:{ IOException -> 0x0039, all -> 0x0037 }
        java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0039, all -> 0x0037 }
        java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0039, all -> 0x0037 }
        java.io.InputStream r1 = r1.getInputStream()     // Catch:{ IOException -> 0x0039, all -> 0x0037 }
        r3.<init>(r1)     // Catch:{ IOException -> 0x0039, all -> 0x0037 }
        r1 = 1024(0x400, float:1.435E-42)
        r2.<init>(r3, r1)     // Catch:{ IOException -> 0x0039, all -> 0x0037 }
        java.lang.String r1 = r2.readLine()     // Catch:{ IOException -> 0x003a }
        r2.close()     // Catch:{ IOException -> 0x003a }
        r2.close()     // Catch:{ IOException -> 0x0032 }
        goto L_0x0036
    L_0x0032:
        r5 = move-exception
        r5.printStackTrace()
    L_0x0036:
        return r1
    L_0x0037:
        r5 = move-exception
        goto L_0x005a
    L_0x0039:
        r2 = r0
    L_0x003a:
        java.lang.String r1 = "stat"
        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0058 }
        java.lang.String r4 = "Unable to read rom prop "
        r3.<init>(r4)     // Catch:{ all -> 0x0058 }
        r3.append(r5)     // Catch:{ all -> 0x0058 }
        java.lang.String r5 = r3.toString()     // Catch:{ all -> 0x0058 }
        android.util.Log.e(r1, r5)     // Catch:{ all -> 0x0058 }
        if (r2 == 0) goto L_0x0057
        r2.close()     // Catch:{ IOException -> 0x0053 }
        goto L_0x0057
    L_0x0053:
        r5 = move-exception
        r5.printStackTrace()
    L_0x0057:
        return r0
    L_0x0058:
        r5 = move-exception
        r0 = r2
    L_0x005a:
        if (r0 == 0) goto L_0x0064
        r0.close()     // Catch:{ IOException -> 0x0060 }
        goto L_0x0064
    L_0x0060:
        r0 = move-exception
        r0.printStackTrace()
    L_0x0064:
        throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.p453d.p459b.p460a.C5769g.m23188b(java.lang.String):java.lang.String");
    }
}
