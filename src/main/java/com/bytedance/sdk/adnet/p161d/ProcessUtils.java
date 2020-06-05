package com.bytedance.sdk.adnet.p161d;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.android.tpush.common.Constants;

/* renamed from: com.bytedance.sdk.adnet.d.g */
public class ProcessUtils {
    /* renamed from: a */
    private static String f6317a;

    /* renamed from: a */
    public static boolean m7956a(Context context) {
        String c = m7958c(context);
        return c != null && (c.endsWith(":push") || c.endsWith(":pushservice"));
    }

    /* renamed from: b */
    public static boolean m7957b(Context context) {
        String c = m7958c(context);
        boolean z = false;
        if (c != null && c.contains(":")) {
            return false;
        }
        if (c != null && c.equals(context.getPackageName())) {
            z = true;
        }
        return z;
    }

    /* renamed from: c */
    public static String m7958c(Context context) {
        String str = f6317a;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            int myPid = Process.myPid();
            for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(Constants.FLAG_ACTIVITY_NAME)).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    f6317a = runningAppProcessInfo.processName;
                    return f6317a;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        f6317a = m7955a();
        return f6317a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0049 A[SYNTHETIC, Splitter:B:17:0x0049] */
    /* renamed from: a */
    private static java.lang.String m7955a() {
        /*
        r0 = 0
        java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ all -> 0x0046 }
        java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ all -> 0x0046 }
        java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ all -> 0x0046 }
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0046 }
        r4.<init>()     // Catch:{ all -> 0x0046 }
        java.lang.String r5 = "/proc/"
        r4.append(r5)     // Catch:{ all -> 0x0046 }
        int r5 = android.os.Process.myPid()     // Catch:{ all -> 0x0046 }
        r4.append(r5)     // Catch:{ all -> 0x0046 }
        java.lang.String r5 = "/cmdline"
        r4.append(r5)     // Catch:{ all -> 0x0046 }
        java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0046 }
        r3.<init>(r4)     // Catch:{ all -> 0x0046 }
        java.lang.String r4 = "iso-8859-1"
        r2.<init>(r3, r4)     // Catch:{ all -> 0x0046 }
        r1.<init>(r2)     // Catch:{ all -> 0x0046 }
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0044 }
        r2.<init>()     // Catch:{ all -> 0x0044 }
    L_0x0031:
        int r3 = r1.read()     // Catch:{ all -> 0x0044 }
        if (r3 <= 0) goto L_0x003c
        char r3 = (char) r3     // Catch:{ all -> 0x0044 }
        r2.append(r3)     // Catch:{ all -> 0x0044 }
        goto L_0x0031
    L_0x003c:
        java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0044 }
        r1.close()     // Catch:{ Exception -> 0x0043 }
    L_0x0043:
        return r0
        goto L_0x0047
    L_0x0046:
        r1 = r0
    L_0x0047:
        if (r1 == 0) goto L_0x004c
        r1.close()     // Catch:{ Exception -> 0x004c }
    L_0x004c:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.adnet.p161d.ProcessUtils.m7955a():java.lang.String");
    }
}
