package com.bytedance.tea.crash.p221g;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.tea.crash.upload.CrashUploader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;

/* renamed from: com.bytedance.tea.crash.g.c */
public class Device {
    /* renamed from: a */
    private static boolean f9372a = false;

    /* renamed from: a */
    public static boolean m12518a(String str) {
        if (TextUtils.isEmpty(str)) {
            str = m12517a();
        }
        if (TextUtils.isEmpty(str) || !str.toLowerCase(Locale.getDefault()).startsWith("emotionui")) {
            return m12520b();
        }
        return true;
    }

    /* renamed from: a */
    public static String m12517a() {
        return m12519b("ro.build.version.emui");
    }

    /* renamed from: b */
    private static String m12519b(String str) {
        BufferedReader bufferedReader;
        String str2 = null;
        try {
            Runtime runtime = Runtime.getRuntime();
            StringBuilder sb = new StringBuilder();
            sb.append("getprop ");
            sb.append(str);
            bufferedReader = new BufferedReader(new InputStreamReader(runtime.exec(sb.toString()).getInputStream()), 1024);
            try {
                str2 = bufferedReader.readLine();
                bufferedReader.close();
                IoUtil.m12535a(bufferedReader);
                return str2;
            } catch (Throwable unused) {
                IoUtil.m12535a(bufferedReader);
                return str2;
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
            IoUtil.m12535a(bufferedReader);
            return str2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0019, code lost:
            if (android.os.Build.BRAND.toLowerCase(java.util.Locale.getDefault()).startsWith(r2) == false) goto L_0x001b;
     */
    /* renamed from: b */
    public static boolean m12520b() {
        /*
        r0 = 0
        java.lang.String r1 = android.os.Build.BRAND     // Catch:{ all -> 0x0034 }
        boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0034 }
        java.lang.String r2 = "huawei"
        if (r1 != 0) goto L_0x001b
        java.lang.String r1 = android.os.Build.BRAND     // Catch:{ all -> 0x0034 }
        java.util.Locale r3 = java.util.Locale.getDefault()     // Catch:{ all -> 0x0034 }
        java.lang.String r1 = r1.toLowerCase(r3)     // Catch:{ all -> 0x0034 }
        boolean r1 = r1.startsWith(r2)     // Catch:{ all -> 0x0034 }
        if (r1 != 0) goto L_0x0033
    L_0x001b:
        java.lang.String r1 = android.os.Build.MANUFACTURER     // Catch:{ all -> 0x0034 }
        boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0034 }
        if (r1 != 0) goto L_0x0034
        java.lang.String r1 = android.os.Build.MANUFACTURER     // Catch:{ all -> 0x0034 }
        java.util.Locale r3 = java.util.Locale.getDefault()     // Catch:{ all -> 0x0034 }
        java.lang.String r1 = r1.toLowerCase(r3)     // Catch:{ all -> 0x0034 }
        boolean r1 = r1.startsWith(r2)     // Catch:{ all -> 0x0034 }
        if (r1 == 0) goto L_0x0034
    L_0x0033:
        r0 = 1
    L_0x0034:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.tea.crash.p221g.Device.m12520b():boolean");
    }

    /* renamed from: c */
    public static boolean m12521c() {
        if (!f9372a) {
            try {
                if (Class.forName("miui.os.Build") != null) {
                    CrashUploader.f9393a = true;
                    f9372a = true;
                    return CrashUploader.f9393a;
                }
            } catch (Exception unused) {
            }
            f9372a = true;
        }
        return CrashUploader.f9393a;
    }

    /* renamed from: d */
    public static boolean m12522d() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }
}
