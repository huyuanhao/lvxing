package com.tencent.stat.common;

import android.content.Context;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* renamed from: com.tencent.stat.common.d */
public class C7597d {
    /* JADX WARNING: type inference failed for: r6v0, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r6v1, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r5v2 */
    /* JADX WARNING: type inference failed for: r6v2 */
    /* JADX WARNING: type inference failed for: r5v4 */
    /* JADX WARNING: type inference failed for: r6v3 */
    /* JADX WARNING: type inference failed for: r6v5 */
    /* JADX WARNING: type inference failed for: r6v6 */
    /* JADX WARNING: type inference failed for: r6v8 */
    /* JADX WARNING: type inference failed for: r6v9 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a9 A[SYNTHETIC, Splitter:B:38:0x00a9] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00ae A[Catch:{ IOException -> 0x00b1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00bf A[SYNTHETIC, Splitter:B:48:0x00bf] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00c4 A[Catch:{ IOException -> 0x00c7 }] */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* renamed from: a */
    public static java.lang.String m32758a(int r10) {
        /*
        java.lang.String r0 = "logcat"
        java.lang.StringBuffer r1 = new java.lang.StringBuffer
        r1.<init>()
        r2 = 0
        java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x00a0, all -> 0x009b }
        r3.<init>()     // Catch:{ Exception -> 0x00a0, all -> 0x009b }
        r3.add(r0)     // Catch:{ Exception -> 0x00a0, all -> 0x009b }
        java.lang.String r4 = "-d"
        r3.add(r4)     // Catch:{ Exception -> 0x00a0, all -> 0x009b }
        java.lang.String r4 = "-v"
        r3.add(r4)     // Catch:{ Exception -> 0x00a0, all -> 0x009b }
        java.lang.String r4 = "time"
        r3.add(r4)     // Catch:{ Exception -> 0x00a0, all -> 0x009b }
        java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ Exception -> 0x00a0, all -> 0x009b }
        r4.<init>()     // Catch:{ Exception -> 0x00a0, all -> 0x009b }
        r4.add(r0)     // Catch:{ Exception -> 0x00a0, all -> 0x009b }
        java.lang.String r0 = "-c"
        r4.add(r0)     // Catch:{ Exception -> 0x00a0, all -> 0x009b }
        java.lang.Runtime r0 = java.lang.Runtime.getRuntime()     // Catch:{ Exception -> 0x00a0, all -> 0x009b }
        int r5 = r3.size()     // Catch:{ Exception -> 0x00a0, all -> 0x009b }
        java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ Exception -> 0x00a0, all -> 0x009b }
        java.lang.Object[] r3 = r3.toArray(r5)     // Catch:{ Exception -> 0x00a0, all -> 0x009b }
        java.lang.String[] r3 = (java.lang.String[]) r3     // Catch:{ Exception -> 0x00a0, all -> 0x009b }
        java.lang.Process r3 = r0.exec(r3)     // Catch:{ Exception -> 0x00a0, all -> 0x009b }
        java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0098, all -> 0x0095 }
        java.io.InputStream r6 = r3.getInputStream()     // Catch:{ Exception -> 0x0098, all -> 0x0095 }
        r5.<init>(r6)     // Catch:{ Exception -> 0x0098, all -> 0x0095 }
        java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0092, all -> 0x008f }
        r6.<init>(r5)     // Catch:{ Exception -> 0x0092, all -> 0x008f }
        r7 = 0
    L_0x004f:
        java.lang.String r8 = r6.readLine()     // Catch:{ Exception -> 0x008d }
        if (r8 == 0) goto L_0x0070
        java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x008d }
        r9.<init>()     // Catch:{ Exception -> 0x008d }
        r9.append(r8)     // Catch:{ Exception -> 0x008d }
        java.lang.String r8 = "\r\n"
        r9.append(r8)     // Catch:{ Exception -> 0x008d }
        java.lang.String r8 = r9.toString()     // Catch:{ Exception -> 0x008d }
        r1.append(r8)     // Catch:{ Exception -> 0x008d }
        int r8 = r7 + 1
        if (r7 < r10) goto L_0x006e
        goto L_0x0070
    L_0x006e:
        r7 = r8
        goto L_0x004f
    L_0x0070:
        int r10 = r4.size()     // Catch:{ Exception -> 0x008d }
        java.lang.String[] r10 = new java.lang.String[r10]     // Catch:{ Exception -> 0x008d }
        java.lang.Object[] r10 = r4.toArray(r10)     // Catch:{ Exception -> 0x008d }
        java.lang.String[] r10 = (java.lang.String[]) r10     // Catch:{ Exception -> 0x008d }
        java.lang.Process r10 = r0.exec(r10)     // Catch:{ Exception -> 0x008d }
        r5.close()     // Catch:{ IOException -> 0x0086 }
        r6.close()     // Catch:{ IOException -> 0x0086 }
    L_0x0086:
        com.tencent.stat.common.StatCommonHelper.destroyProcess(r3)
        com.tencent.stat.common.StatCommonHelper.destroyProcess(r10)
        goto L_0x00b7
    L_0x008d:
        r10 = move-exception
        goto L_0x00a4
    L_0x008f:
        r10 = move-exception
        r6 = r2
        goto L_0x00bd
    L_0x0092:
        r10 = move-exception
        r6 = r2
        goto L_0x00a4
    L_0x0095:
        r10 = move-exception
        r5 = r2
        goto L_0x009e
    L_0x0098:
        r10 = move-exception
        r5 = r2
        goto L_0x00a3
    L_0x009b:
        r10 = move-exception
        r3 = r2
        r5 = r3
    L_0x009e:
        r6 = r5
        goto L_0x00bd
    L_0x00a0:
        r10 = move-exception
        r3 = r2
        r5 = r3
    L_0x00a3:
        r6 = r5
    L_0x00a4:
        r10.printStackTrace()     // Catch:{ all -> 0x00bc }
        if (r5 == 0) goto L_0x00ac
        r5.close()     // Catch:{ IOException -> 0x00b1 }
    L_0x00ac:
        if (r6 == 0) goto L_0x00b1
        r6.close()     // Catch:{ IOException -> 0x00b1 }
    L_0x00b1:
        com.tencent.stat.common.StatCommonHelper.destroyProcess(r3)
        com.tencent.stat.common.StatCommonHelper.destroyProcess(r2)
    L_0x00b7:
        java.lang.String r10 = r1.toString()
        return r10
    L_0x00bc:
        r10 = move-exception
    L_0x00bd:
        if (r5 == 0) goto L_0x00c2
        r5.close()     // Catch:{ IOException -> 0x00c7 }
    L_0x00c2:
        if (r6 == 0) goto L_0x00c7
        r6.close()     // Catch:{ IOException -> 0x00c7 }
    L_0x00c7:
        com.tencent.stat.common.StatCommonHelper.destroyProcess(r3)
        com.tencent.stat.common.StatCommonHelper.destroyProcess(r2)
        throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.common.C7597d.m32758a(int):java.lang.String");
    }

    /* renamed from: a */
    public static void m32759a(Context context) {
        FileOutputStream fileOutputStream = null;
        try {
            String a = m32758a(500);
            fileOutputStream = Util.getContextSelf(context).openFileOutput("feedback.log", 0);
            if (fileOutputStream != null) {
                fileOutputStream.write(a.getBytes());
                fileOutputStream.flush();
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        } catch (IOException e3) {
            e3.printStackTrace();
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
        }
    }
}
