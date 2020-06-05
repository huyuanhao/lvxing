package com.bytedance.sdk.openadsdk.utils;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.android.tpush.common.Constants;

/* compiled from: ProcessUtils */
/* renamed from: com.bytedance.sdk.openadsdk.utils.z */
public class C2569z {
    /* renamed from: a */
    private static String f9197a;

    /* renamed from: a */
    public static String m12261a(Context context) {
        String str = f9197a;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            int myPid = Process.myPid();
            for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(Constants.FLAG_ACTIVITY_NAME)).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    if (C2564t.m12217a()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("processName = ");
                        sb.append(runningAppProcessInfo.processName);
                        C2564t.m12220b("Process", sb.toString());
                    }
                    f9197a = runningAppProcessInfo.processName;
                    return f9197a;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        f9197a = m12260a();
        return f9197a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0069 A[SYNTHETIC, Splitter:B:20:0x0069] */
    /* renamed from: a */
    private static java.lang.String m12260a() {
        /*
        r0 = 0
        java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ all -> 0x0066 }
        java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ all -> 0x0066 }
        java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ all -> 0x0066 }
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0066 }
        r4.<init>()     // Catch:{ all -> 0x0066 }
        java.lang.String r5 = "/proc/"
        r4.append(r5)     // Catch:{ all -> 0x0066 }
        int r5 = android.os.Process.myPid()     // Catch:{ all -> 0x0066 }
        r4.append(r5)     // Catch:{ all -> 0x0066 }
        java.lang.String r5 = "/cmdline"
        r4.append(r5)     // Catch:{ all -> 0x0066 }
        java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0066 }
        r3.<init>(r4)     // Catch:{ all -> 0x0066 }
        java.lang.String r4 = "iso-8859-1"
        r2.<init>(r3, r4)     // Catch:{ all -> 0x0066 }
        r1.<init>(r2)     // Catch:{ all -> 0x0066 }
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0064 }
        r2.<init>()     // Catch:{ all -> 0x0064 }
    L_0x0031:
        int r3 = r1.read()     // Catch:{ all -> 0x0064 }
        if (r3 <= 0) goto L_0x003c
        char r3 = (char) r3     // Catch:{ all -> 0x0064 }
        r2.append(r3)     // Catch:{ all -> 0x0064 }
        goto L_0x0031
    L_0x003c:
        boolean r3 = com.bytedance.sdk.openadsdk.utils.C2564t.m12217a()     // Catch:{ all -> 0x0064 }
        if (r3 == 0) goto L_0x005c
        java.lang.String r3 = "Process"
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0064 }
        r4.<init>()     // Catch:{ all -> 0x0064 }
        java.lang.String r5 = "get processName = "
        r4.append(r5)     // Catch:{ all -> 0x0064 }
        java.lang.String r5 = r2.toString()     // Catch:{ all -> 0x0064 }
        r4.append(r5)     // Catch:{ all -> 0x0064 }
        java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0064 }
        com.bytedance.sdk.openadsdk.utils.C2564t.m12220b(r3, r4)     // Catch:{ all -> 0x0064 }
    L_0x005c:
        java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0064 }
        r1.close()     // Catch:{ Exception -> 0x0063 }
    L_0x0063:
        return r0
        goto L_0x0067
    L_0x0066:
        r1 = r0
    L_0x0067:
        if (r1 == 0) goto L_0x006c
        r1.close()     // Catch:{ Exception -> 0x006c }
    L_0x006c:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.utils.C2569z.m12260a():java.lang.String");
    }
}
