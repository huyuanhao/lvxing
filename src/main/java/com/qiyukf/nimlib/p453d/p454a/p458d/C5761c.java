package com.qiyukf.nimlib.p453d.p454a.p458d;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.android.tpush.common.Constants;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.qiyukf.nimlib.d.a.d.c */
public final class C5761c {
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004f A[SYNTHETIC, Splitter:B:19:0x004f] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005b A[SYNTHETIC, Splitter:B:27:0x005b] */
    /* renamed from: a */
    private static java.lang.String m23158a() {
        /*
        r0 = 0
        int r1 = android.os.Process.myPid()     // Catch:{ Exception -> 0x0058, all -> 0x004c }
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0058, all -> 0x004c }
        java.lang.String r3 = "/proc/"
        r2.<init>(r3)     // Catch:{ Exception -> 0x0058, all -> 0x004c }
        r2.append(r1)     // Catch:{ Exception -> 0x0058, all -> 0x004c }
        java.lang.String r1 = "/cmdline"
        r2.append(r1)     // Catch:{ Exception -> 0x0058, all -> 0x004c }
        java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x0058, all -> 0x004c }
        java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0058, all -> 0x004c }
        java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0058, all -> 0x004c }
        java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0058, all -> 0x004c }
        r4.<init>(r1)     // Catch:{ Exception -> 0x0058, all -> 0x004c }
        java.lang.String r1 = "iso-8859-1"
        r3.<init>(r4, r1)     // Catch:{ Exception -> 0x0058, all -> 0x004c }
        r2.<init>(r3)     // Catch:{ Exception -> 0x0058, all -> 0x004c }
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004a, all -> 0x0046 }
        r1.<init>()     // Catch:{ Exception -> 0x004a, all -> 0x0046 }
    L_0x002e:
        int r3 = r2.read()     // Catch:{ Exception -> 0x004a, all -> 0x0046 }
        if (r3 <= 0) goto L_0x0039
        char r3 = (char) r3     // Catch:{ Exception -> 0x004a, all -> 0x0046 }
        r1.append(r3)     // Catch:{ Exception -> 0x004a, all -> 0x0046 }
        goto L_0x002e
    L_0x0039:
        java.lang.String r0 = r1.toString()     // Catch:{ Exception -> 0x004a, all -> 0x0046 }
        r2.close()     // Catch:{ IOException -> 0x0041 }
        goto L_0x0045
    L_0x0041:
        r1 = move-exception
        r1.printStackTrace()
    L_0x0045:
        return r0
    L_0x0046:
        r0 = move-exception
        r1 = r0
        r0 = r2
        goto L_0x004d
        goto L_0x0059
    L_0x004c:
        r1 = move-exception
    L_0x004d:
        if (r0 == 0) goto L_0x0057
        r0.close()     // Catch:{ IOException -> 0x0053 }
        goto L_0x0057
    L_0x0053:
        r0 = move-exception
        r0.printStackTrace()
    L_0x0057:
        throw r1
    L_0x0058:
        r2 = r0
    L_0x0059:
        if (r2 == 0) goto L_0x0063
        r2.close()     // Catch:{ IOException -> 0x005f }
        goto L_0x0063
    L_0x005f:
        r1 = move-exception
        r1.printStackTrace()
    L_0x0063:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.p453d.p454a.p458d.C5761c.m23158a():java.lang.String");
    }

    /* renamed from: a */
    public static boolean m23159a(Context context) {
        if (context == null) {
            return false;
        }
        String packageName = context.getApplicationContext().getPackageName();
        String a = m23158a();
        if (a == null) {
            a = m23160b(context);
        }
        return packageName.equals(a);
    }

    /* renamed from: b */
    private static String m23160b(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Constants.FLAG_ACTIVITY_NAME);
        if (activityManager == null) {
            return null;
        }
        String str = null;
        for (int i = 0; i < 2; i++) {
            List runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses != null) {
                Iterator it = runningAppProcesses.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    RunningAppProcessInfo runningAppProcessInfo = (RunningAppProcessInfo) it.next();
                    if (runningAppProcessInfo.pid == Process.myPid()) {
                        str = runningAppProcessInfo.processName;
                        break;
                    }
                }
            }
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
