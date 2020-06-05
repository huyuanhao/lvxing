package com.tencent.bugly.crashreport.crash.jni;

import com.tencent.bugly.proguard.C7226an;
import com.tencent.bugly.proguard.C7232aq;
import com.tencent.mid.sotrage.StorageInterface;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.crashreport.crash.jni.b */
public class C7204b {
    /* renamed from: a */
    private static List<File> f24281a = new ArrayList();

    /* renamed from: a */
    protected static Map<String, Integer> m31008a(String str) {
        String[] split;
        if (str == null) {
            return null;
        }
        try {
            HashMap hashMap = new HashMap();
            for (String str2 : str.split(StorageInterface.KEY_SPLITER)) {
                String[] split2 = str2.split(":");
                if (split2.length != 2) {
                    C7226an.m31149e("error format at %s", str2);
                    return null;
                }
                hashMap.put(split2[0], Integer.valueOf(Integer.parseInt(split2[1])));
            }
            return hashMap;
        } catch (Exception e) {
            C7226an.m31149e("error format intStateStr %s", str);
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    protected static String m31010b(String str) {
        if (str == null) {
            return "";
        }
        String str2 = "\n";
        String[] split = str.split(str2);
        if (!(split == null || split.length == 0)) {
            StringBuilder sb = new StringBuilder();
            for (String str3 : split) {
                if (!str3.contains("java.lang.Thread.getStackTrace(")) {
                    sb.append(str3);
                    sb.append(str2);
                }
            }
            str = sb.toString();
        }
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:60:0x0127 A[Catch:{ NumberFormatException -> 0x0291, all -> 0x02a2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0132 A[Catch:{ NumberFormatException -> 0x0291, all -> 0x02a2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0152 A[Catch:{ NumberFormatException -> 0x0291, all -> 0x02a2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x015d A[Catch:{ NumberFormatException -> 0x0291, all -> 0x02a2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x017d A[Catch:{ NumberFormatException -> 0x0291, all -> 0x02a2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x017e A[Catch:{ NumberFormatException -> 0x0291, all -> 0x02a2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0189 A[Catch:{ NumberFormatException -> 0x0291, all -> 0x02a2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01a9 A[Catch:{ NumberFormatException -> 0x0291, all -> 0x02a2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01d8 A[Catch:{ NumberFormatException -> 0x0291, all -> 0x02a2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0222 A[Catch:{ NumberFormatException -> 0x0291, all -> 0x02a2 }] */
    /* renamed from: a */
    protected static com.tencent.bugly.crashreport.crash.CrashDetailBean m31004a(android.content.Context r24, java.util.Map<java.lang.String, java.lang.String> r25, com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler r26) {
        /*
        r0 = r25
        r1 = 0
        if (r0 != 0) goto L_0x0006
        return r1
    L_0x0006:
        com.tencent.bugly.crashreport.common.info.a r2 = com.tencent.bugly.crashreport.common.info.C7174a.m30753a(r24)
        r3 = 0
        if (r2 != 0) goto L_0x0015
        java.lang.Object[] r0 = new java.lang.Object[r3]
        java.lang.String r2 = "abnormal com info not created"
        com.tencent.bugly.proguard.C7226an.m31149e(r2, r0)
        return r1
    L_0x0015:
        java.lang.String r2 = "intStateStr"
        java.lang.Object r2 = r0.get(r2)
        java.lang.String r2 = (java.lang.String) r2
        if (r2 == 0) goto L_0x02af
        java.lang.String r4 = r2.trim()
        int r4 = r4.length()
        if (r4 > 0) goto L_0x002b
        goto L_0x02af
    L_0x002b:
        java.util.Map r2 = m31008a(r2)
        r4 = 1
        if (r2 != 0) goto L_0x0044
        java.lang.Object[] r2 = new java.lang.Object[r4]
        int r0 = r25.size()
        java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
        r2[r3] = r0
        java.lang.String r0 = "parse intSateMap fail"
        com.tencent.bugly.proguard.C7226an.m31149e(r0, r2)
        return r1
    L_0x0044:
        java.lang.String r5 = "sino"
        java.lang.Object r5 = r2.get(r5)     // Catch:{ all -> 0x02a2 }
        java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ all -> 0x02a2 }
        r5.intValue()     // Catch:{ all -> 0x02a2 }
        java.lang.String r5 = "sud"
        java.lang.Object r5 = r2.get(r5)     // Catch:{ all -> 0x02a2 }
        java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ all -> 0x02a2 }
        r5.intValue()     // Catch:{ all -> 0x02a2 }
        java.lang.String r5 = "soVersion"
        java.lang.Object r5 = r0.get(r5)     // Catch:{ all -> 0x02a2 }
        r19 = r5
        java.lang.String r19 = (java.lang.String) r19     // Catch:{ all -> 0x02a2 }
        if (r19 != 0) goto L_0x006e
        java.lang.String r0 = "error format at version"
        java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch:{ all -> 0x02a2 }
        com.tencent.bugly.proguard.C7226an.m31149e(r0, r2)     // Catch:{ all -> 0x02a2 }
        return r1
    L_0x006e:
        java.lang.String r5 = "errorAddr"
        java.lang.Object r5 = r0.get(r5)     // Catch:{ all -> 0x02a2 }
        java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x02a2 }
        java.lang.String r6 = "unknown"
        if (r5 != 0) goto L_0x007c
        r12 = r6
        goto L_0x007d
    L_0x007c:
        r12 = r5
    L_0x007d:
        java.lang.String r5 = "codeMsg"
        java.lang.Object r5 = r0.get(r5)     // Catch:{ all -> 0x02a2 }
        java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x02a2 }
        if (r5 != 0) goto L_0x0088
        r5 = r6
    L_0x0088:
        java.lang.String r7 = "tombPath"
        java.lang.Object r7 = r0.get(r7)     // Catch:{ all -> 0x02a2 }
        java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x02a2 }
        if (r7 != 0) goto L_0x0095
        r16 = r6
        goto L_0x0097
    L_0x0095:
        r16 = r7
    L_0x0097:
        java.lang.String r7 = "signalName"
        java.lang.Object r7 = r0.get(r7)     // Catch:{ all -> 0x02a2 }
        java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x02a2 }
        if (r7 != 0) goto L_0x00a2
        r7 = r6
    L_0x00a2:
        java.lang.String r8 = "errnoMsg"
        java.lang.Object r8 = r0.get(r8)     // Catch:{ all -> 0x02a2 }
        java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x02a2 }
        java.lang.String r8 = "stack"
        java.lang.Object r8 = r0.get(r8)     // Catch:{ all -> 0x02a2 }
        java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x02a2 }
        if (r8 != 0) goto L_0x00b5
        r8 = r6
    L_0x00b5:
        java.lang.String r9 = "jstack"
        java.lang.Object r9 = r0.get(r9)     // Catch:{ all -> 0x02a2 }
        java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x02a2 }
        if (r9 == 0) goto L_0x00d3
        java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x02a2 }
        r10.<init>()     // Catch:{ all -> 0x02a2 }
        r10.append(r8)     // Catch:{ all -> 0x02a2 }
        java.lang.String r8 = "java:\n"
        r10.append(r8)     // Catch:{ all -> 0x02a2 }
        r10.append(r9)     // Catch:{ all -> 0x02a2 }
        java.lang.String r8 = r10.toString()     // Catch:{ all -> 0x02a2 }
    L_0x00d3:
        java.lang.String r9 = "sico"
        java.lang.Object r9 = r2.get(r9)     // Catch:{ all -> 0x02a2 }
        java.lang.Integer r9 = (java.lang.Integer) r9     // Catch:{ all -> 0x02a2 }
        java.lang.String r10 = ")"
        java.lang.String r11 = "("
        if (r9 == 0) goto L_0x0100
        int r9 = r9.intValue()     // Catch:{ all -> 0x02a2 }
        if (r9 <= 0) goto L_0x0100
        java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x02a2 }
        r9.<init>()     // Catch:{ all -> 0x02a2 }
        r9.append(r7)     // Catch:{ all -> 0x02a2 }
        r9.append(r11)     // Catch:{ all -> 0x02a2 }
        r9.append(r5)     // Catch:{ all -> 0x02a2 }
        r9.append(r10)     // Catch:{ all -> 0x02a2 }
        java.lang.String r5 = r9.toString()     // Catch:{ all -> 0x02a2 }
        java.lang.String r7 = "KERNEL"
        r14 = r7
        goto L_0x0102
    L_0x0100:
        r14 = r5
        r5 = r7
    L_0x0102:
        java.lang.String r7 = "nativeLog"
        java.lang.Object r7 = r0.get(r7)     // Catch:{ all -> 0x02a2 }
        java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x02a2 }
        if (r7 == 0) goto L_0x011b
        boolean r9 = r7.isEmpty()     // Catch:{ all -> 0x02a2 }
        if (r9 != 0) goto L_0x011b
        java.lang.String r9 = "BuglyNativeLog.txt"
        byte[] r7 = com.tencent.bugly.proguard.C7232aq.m31200a(r1, r7, r9)     // Catch:{ all -> 0x02a2 }
        r20 = r7
        goto L_0x011d
    L_0x011b:
        r20 = r1
    L_0x011d:
        java.lang.String r7 = "sendingProcess"
        java.lang.Object r7 = r0.get(r7)     // Catch:{ all -> 0x02a2 }
        java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x02a2 }
        if (r7 != 0) goto L_0x0128
        r7 = r6
    L_0x0128:
        java.lang.String r9 = "spd"
        java.lang.Object r9 = r2.get(r9)     // Catch:{ all -> 0x02a2 }
        java.lang.Integer r9 = (java.lang.Integer) r9     // Catch:{ all -> 0x02a2 }
        if (r9 == 0) goto L_0x0147
        java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x02a2 }
        r13.<init>()     // Catch:{ all -> 0x02a2 }
        r13.append(r7)     // Catch:{ all -> 0x02a2 }
        r13.append(r11)     // Catch:{ all -> 0x02a2 }
        r13.append(r9)     // Catch:{ all -> 0x02a2 }
        r13.append(r10)     // Catch:{ all -> 0x02a2 }
        java.lang.String r7 = r13.toString()     // Catch:{ all -> 0x02a2 }
    L_0x0147:
        r15 = r7
        java.lang.String r7 = "threadName"
        java.lang.Object r7 = r0.get(r7)     // Catch:{ all -> 0x02a2 }
        java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x02a2 }
        if (r7 != 0) goto L_0x0153
        r7 = r6
    L_0x0153:
        java.lang.String r9 = "et"
        java.lang.Object r9 = r2.get(r9)     // Catch:{ all -> 0x02a2 }
        java.lang.Integer r9 = (java.lang.Integer) r9     // Catch:{ all -> 0x02a2 }
        if (r9 == 0) goto L_0x0172
        java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x02a2 }
        r13.<init>()     // Catch:{ all -> 0x02a2 }
        r13.append(r7)     // Catch:{ all -> 0x02a2 }
        r13.append(r11)     // Catch:{ all -> 0x02a2 }
        r13.append(r9)     // Catch:{ all -> 0x02a2 }
        r13.append(r10)     // Catch:{ all -> 0x02a2 }
        java.lang.String r7 = r13.toString()     // Catch:{ all -> 0x02a2 }
    L_0x0172:
        r9 = r7
        java.lang.String r7 = "processName"
        java.lang.Object r7 = r0.get(r7)     // Catch:{ all -> 0x02a2 }
        java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x02a2 }
        if (r7 != 0) goto L_0x017e
        goto L_0x017f
    L_0x017e:
        r6 = r7
    L_0x017f:
        java.lang.String r7 = "ep"
        java.lang.Object r7 = r2.get(r7)     // Catch:{ all -> 0x02a2 }
        java.lang.Integer r7 = (java.lang.Integer) r7     // Catch:{ all -> 0x02a2 }
        if (r7 == 0) goto L_0x019e
        java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x02a2 }
        r13.<init>()     // Catch:{ all -> 0x02a2 }
        r13.append(r6)     // Catch:{ all -> 0x02a2 }
        r13.append(r11)     // Catch:{ all -> 0x02a2 }
        r13.append(r7)     // Catch:{ all -> 0x02a2 }
        r13.append(r10)     // Catch:{ all -> 0x02a2 }
        java.lang.String r6 = r13.toString()     // Catch:{ all -> 0x02a2 }
    L_0x019e:
        r7 = r6
        java.lang.String r6 = "key-value"
        java.lang.Object r6 = r0.get(r6)     // Catch:{ all -> 0x02a2 }
        java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x02a2 }
        if (r6 == 0) goto L_0x01d8
        java.util.HashMap r10 = new java.util.HashMap     // Catch:{ all -> 0x02a2 }
        r10.<init>()     // Catch:{ all -> 0x02a2 }
        java.lang.String r11 = "\n"
        java.lang.String[] r6 = r6.split(r11)     // Catch:{ all -> 0x02a2 }
        int r11 = r6.length     // Catch:{ all -> 0x02a2 }
        r13 = 0
    L_0x01b6:
        if (r13 >= r11) goto L_0x01d5
        r1 = r6[r13]     // Catch:{ all -> 0x02a2 }
        java.lang.String r4 = "="
        java.lang.String[] r1 = r1.split(r4)     // Catch:{ all -> 0x02a2 }
        int r4 = r1.length     // Catch:{ all -> 0x02a2 }
        r17 = r6
        r6 = 2
        if (r4 != r6) goto L_0x01ce
        r4 = r1[r3]     // Catch:{ all -> 0x02a2 }
        r6 = 1
        r1 = r1[r6]     // Catch:{ all -> 0x02a2 }
        r10.put(r4, r1)     // Catch:{ all -> 0x02a2 }
    L_0x01ce:
        int r13 = r13 + 1
        r6 = r17
        r1 = 0
        r4 = 1
        goto L_0x01b6
    L_0x01d5:
        r21 = r10
        goto L_0x01da
    L_0x01d8:
        r21 = 0
    L_0x01da:
        java.lang.String r1 = "ets"
        java.lang.Object r1 = r2.get(r1)     // Catch:{ all -> 0x02a2 }
        java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x02a2 }
        int r1 = r1.intValue()     // Catch:{ all -> 0x02a2 }
        long r10 = (long) r1     // Catch:{ all -> 0x02a2 }
        java.lang.String r1 = "etms"
        java.lang.Object r1 = r2.get(r1)     // Catch:{ all -> 0x02a2 }
        java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x02a2 }
        int r1 = r1.intValue()     // Catch:{ all -> 0x02a2 }
        long r1 = (long) r1     // Catch:{ all -> 0x02a2 }
        r17 = 1000(0x3e8, double:4.94E-321)
        long r10 = r10 * r17
        long r1 = r1 / r17
        long r1 = r1 + r10
        java.lang.String r13 = m31010b(r8)     // Catch:{ all -> 0x02a2 }
        java.lang.String r4 = "sysLogPath"
        java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x02a2 }
        r17 = r4
        java.lang.String r17 = (java.lang.String) r17     // Catch:{ all -> 0x02a2 }
        java.lang.String r4 = "jniLogPath"
        java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x02a2 }
        r18 = r4
        java.lang.String r18 = (java.lang.String) r18     // Catch:{ all -> 0x02a2 }
        r22 = 0
        r23 = 0
        r6 = r26
        r8 = r9
        r9 = r1
        r11 = r5
        com.tencent.bugly.crashreport.crash.CrashDetailBean r1 = r6.packageCrashDatas(r7, r8, r9, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)     // Catch:{ all -> 0x02a2 }
        if (r1 == 0) goto L_0x02a1
        java.lang.String r2 = "userId"
        java.lang.Object r2 = r0.get(r2)     // Catch:{ all -> 0x02a2 }
        java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x02a2 }
        if (r2 == 0) goto L_0x0238
        java.lang.String r4 = "[Native record info] userId: %s"
        r5 = 1
        java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ all -> 0x02a2 }
        r6[r3] = r2     // Catch:{ all -> 0x02a2 }
        com.tencent.bugly.proguard.C7226an.m31147c(r4, r6)     // Catch:{ all -> 0x02a2 }
        r1.f24128m = r2     // Catch:{ all -> 0x02a2 }
    L_0x0238:
        java.lang.String r2 = "sysLog"
        java.lang.Object r2 = r0.get(r2)     // Catch:{ all -> 0x02a2 }
        java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x02a2 }
        if (r2 == 0) goto L_0x0244
        r1.f24138w = r2     // Catch:{ all -> 0x02a2 }
    L_0x0244:
        java.lang.String r2 = "appVersion"
        java.lang.Object r2 = r0.get(r2)     // Catch:{ all -> 0x02a2 }
        java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x02a2 }
        if (r2 == 0) goto L_0x025a
        java.lang.String r4 = "[Native record info] appVersion: %s"
        r5 = 1
        java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ all -> 0x02a2 }
        r6[r3] = r2     // Catch:{ all -> 0x02a2 }
        com.tencent.bugly.proguard.C7226an.m31147c(r4, r6)     // Catch:{ all -> 0x02a2 }
        r1.f24121f = r2     // Catch:{ all -> 0x02a2 }
    L_0x025a:
        java.lang.String r2 = "isAppForeground"
        java.lang.Object r2 = r0.get(r2)     // Catch:{ all -> 0x02a2 }
        java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x02a2 }
        if (r2 == 0) goto L_0x0276
        java.lang.String r4 = "[Native record info] isAppForeground: %s"
        r5 = 1
        java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ all -> 0x02a2 }
        r6[r3] = r2     // Catch:{ all -> 0x02a2 }
        com.tencent.bugly.proguard.C7226an.m31147c(r4, r6)     // Catch:{ all -> 0x02a2 }
        java.lang.String r4 = "true"
        boolean r2 = r2.equalsIgnoreCase(r4)     // Catch:{ all -> 0x02a2 }
        r1.f24107O = r2     // Catch:{ all -> 0x02a2 }
    L_0x0276:
        java.lang.String r2 = "launchTime"
        java.lang.Object r0 = r0.get(r2)     // Catch:{ all -> 0x02a2 }
        java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x02a2 }
        if (r0 == 0) goto L_0x029b
        java.lang.String r2 = "[Native record info] launchTime: %s"
        r4 = 1
        java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x02a2 }
        r5[r3] = r0     // Catch:{ all -> 0x02a2 }
        com.tencent.bugly.proguard.C7226an.m31147c(r2, r5)     // Catch:{ all -> 0x02a2 }
        long r4 = java.lang.Long.parseLong(r0)     // Catch:{ NumberFormatException -> 0x0291 }
        r1.f24106N = r4     // Catch:{ NumberFormatException -> 0x0291 }
        goto L_0x029b
    L_0x0291:
        r0 = move-exception
        boolean r2 = com.tencent.bugly.proguard.C7226an.m31142a(r0)     // Catch:{ all -> 0x02a2 }
        if (r2 != 0) goto L_0x029b
        r0.printStackTrace()     // Catch:{ all -> 0x02a2 }
    L_0x029b:
        r2 = 0
        r1.f24141z = r2     // Catch:{ all -> 0x02a2 }
        r2 = 1
        r1.f24126k = r2     // Catch:{ all -> 0x02a2 }
    L_0x02a1:
        return r1
    L_0x02a2:
        r0 = move-exception
        java.lang.Object[] r1 = new java.lang.Object[r3]
        java.lang.String r2 = "error format"
        com.tencent.bugly.proguard.C7226an.m31149e(r2, r1)
        r0.printStackTrace()
        r1 = 0
        return r1
    L_0x02af:
        java.lang.Object[] r0 = new java.lang.Object[r3]
        java.lang.String r2 = "no intStateStr"
        com.tencent.bugly.proguard.C7226an.m31149e(r2, r0)
        return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.jni.C7204b.m31004a(android.content.Context, java.util.Map, com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler):com.tencent.bugly.crashreport.crash.CrashDetailBean");
    }

    /* renamed from: a */
    protected static String m31005a(BufferedInputStream bufferedInputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        if (bufferedInputStream == null) {
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(1024);
            while (true) {
                try {
                    int read = bufferedInputStream.read();
                    if (read == -1) {
                        break;
                    } else if (read == 0) {
                        String str = new String(byteArrayOutputStream.toByteArray(), "UTf-8");
                        byteArrayOutputStream.close();
                        return str;
                    } else {
                        byteArrayOutputStream.write(read);
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        C7226an.m31142a(th);
                    } finally {
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream = null;
            C7226an.m31142a(th);
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x008c A[SYNTHETIC, Splitter:B:53:0x008c] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0098 A[SYNTHETIC, Splitter:B:60:0x0098] */
    /* renamed from: a */
    public static com.tencent.bugly.crashreport.crash.CrashDetailBean m31003a(android.content.Context r6, java.lang.String r7, com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler r8) {
        /*
        r0 = 0
        r1 = 0
        if (r6 == 0) goto L_0x00a2
        if (r7 == 0) goto L_0x00a2
        if (r8 != 0) goto L_0x000a
        goto L_0x00a2
    L_0x000a:
        java.io.File r2 = new java.io.File
        java.lang.String r3 = "rqd_record.eup"
        r2.<init>(r7, r3)
        boolean r7 = r2.exists()
        if (r7 == 0) goto L_0x00a1
        boolean r7 = r2.canRead()
        if (r7 != 0) goto L_0x001f
        goto L_0x00a1
    L_0x001f:
        java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x0085, all -> 0x0082 }
        java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0085, all -> 0x0082 }
        r3.<init>(r2)     // Catch:{ IOException -> 0x0085, all -> 0x0082 }
        r7.<init>(r3)     // Catch:{ IOException -> 0x0085, all -> 0x0082 }
        java.lang.String r2 = m31005a(r7)     // Catch:{ IOException -> 0x0080 }
        r3 = 1
        if (r2 == 0) goto L_0x006e
        java.lang.String r4 = "NATIVE_RQD_REPORT"
        boolean r4 = r2.equals(r4)     // Catch:{ IOException -> 0x0080 }
        if (r4 != 0) goto L_0x0039
        goto L_0x006e
    L_0x0039:
        java.util.HashMap r2 = new java.util.HashMap     // Catch:{ IOException -> 0x0080 }
        r2.<init>()     // Catch:{ IOException -> 0x0080 }
    L_0x003e:
        r4 = r1
    L_0x003f:
        java.lang.String r5 = m31005a(r7)     // Catch:{ IOException -> 0x0080 }
        if (r5 == 0) goto L_0x004d
        if (r4 != 0) goto L_0x0049
        r4 = r5
        goto L_0x003f
    L_0x0049:
        r2.put(r4, r5)     // Catch:{ IOException -> 0x0080 }
        goto L_0x003e
    L_0x004d:
        if (r4 == 0) goto L_0x0061
        java.lang.String r6 = "record not pair! drop! %s"
        java.lang.Object[] r8 = new java.lang.Object[r3]     // Catch:{ IOException -> 0x0080 }
        r8[r0] = r4     // Catch:{ IOException -> 0x0080 }
        com.tencent.bugly.proguard.C7226an.m31149e(r6, r8)     // Catch:{ IOException -> 0x0080 }
        r7.close()     // Catch:{ IOException -> 0x005c }
        goto L_0x0060
    L_0x005c:
        r6 = move-exception
        r6.printStackTrace()
    L_0x0060:
        return r1
    L_0x0061:
        com.tencent.bugly.crashreport.crash.CrashDetailBean r6 = m31004a(r6, r2, r8)     // Catch:{ IOException -> 0x0080 }
        r7.close()     // Catch:{ IOException -> 0x0069 }
        goto L_0x006d
    L_0x0069:
        r7 = move-exception
        r7.printStackTrace()
    L_0x006d:
        return r6
    L_0x006e:
        java.lang.String r6 = "record read fail! %s"
        java.lang.Object[] r8 = new java.lang.Object[r3]     // Catch:{ IOException -> 0x0080 }
        r8[r0] = r2     // Catch:{ IOException -> 0x0080 }
        com.tencent.bugly.proguard.C7226an.m31149e(r6, r8)     // Catch:{ IOException -> 0x0080 }
        r7.close()     // Catch:{ IOException -> 0x007b }
        goto L_0x007f
    L_0x007b:
        r6 = move-exception
        r6.printStackTrace()
    L_0x007f:
        return r1
    L_0x0080:
        r6 = move-exception
        goto L_0x0087
    L_0x0082:
        r6 = move-exception
        r7 = r1
        goto L_0x0096
    L_0x0085:
        r6 = move-exception
        r7 = r1
    L_0x0087:
        r6.printStackTrace()     // Catch:{ all -> 0x0095 }
        if (r7 == 0) goto L_0x0094
        r7.close()     // Catch:{ IOException -> 0x0090 }
        goto L_0x0094
    L_0x0090:
        r6 = move-exception
        r6.printStackTrace()
    L_0x0094:
        return r1
    L_0x0095:
        r6 = move-exception
    L_0x0096:
        if (r7 == 0) goto L_0x00a0
        r7.close()     // Catch:{ IOException -> 0x009c }
        goto L_0x00a0
    L_0x009c:
        r7 = move-exception
        r7.printStackTrace()
    L_0x00a0:
        throw r6
    L_0x00a1:
        return r1
    L_0x00a2:
        java.lang.Object[] r6 = new java.lang.Object[r0]
        java.lang.String r7 = "get eup record file args error"
        com.tencent.bugly.proguard.C7226an.m31149e(r7, r6)
        return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.jni.C7204b.m31003a(android.content.Context, java.lang.String, com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler):com.tencent.bugly.crashreport.crash.CrashDetailBean");
    }

    /* renamed from: b */
    private static String m31011b(String str, String str2) {
        String str3;
        String a = C7232aq.m31175a(str, "reg_record.txt");
        if (a == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            a = a.readLine();
            if (a != null) {
                if (a.startsWith(str2)) {
                    String str4 = "                ";
                    int i = 0;
                    int i2 = 18;
                    int i3 = 0;
                    while (true) {
                        String readLine = a.readLine();
                        str3 = "\n";
                        if (readLine == null) {
                            break;
                        }
                        if (i % 4 == 0) {
                            if (i > 0) {
                                sb.append(str3);
                            }
                            sb.append("  ");
                        } else {
                            if (readLine.length() > 16) {
                                i2 = 28;
                            }
                            sb.append(str4.substring(0, i2 - i3));
                        }
                        i3 = readLine.length();
                        sb.append(readLine);
                        i++;
                    }
                    sb.append(str3);
                    String sb2 = sb.toString();
                    if (a != null) {
                        try {
                            a.close();
                        } catch (Exception e) {
                            C7226an.m31142a(e);
                        }
                    }
                    return sb2;
                }
            }
            if (a != null) {
                try {
                    a.close();
                } catch (Exception e2) {
                    C7226an.m31142a(e2);
                }
            }
            return null;
        } catch (Throwable th) {
            C7226an.m31142a(th);
            if (a != null) {
                try {
                    a.close();
                } catch (Exception e3) {
                    C7226an.m31142a(e3);
                }
            }
            return null;
        } finally {
            if (a != null) {
                try {
                    a.close();
                } catch (Exception e4) {
                    C7226an.m31142a(e4);
                }
            }
        }
    }

    /* renamed from: c */
    private static String m31013c(String str, String str2) {
        String a = C7232aq.m31175a(str, "map_record.txt");
        if (a == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            a = a.readLine();
            if (a != null) {
                if (a.startsWith(str2)) {
                    while (true) {
                        String readLine = a.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append("  ");
                        sb.append(readLine);
                        sb.append("\n");
                    }
                    String sb2 = sb.toString();
                    if (a != null) {
                        try {
                            a.close();
                        } catch (Exception e) {
                            C7226an.m31142a(e);
                        }
                    }
                    return sb2;
                }
            }
            if (a != null) {
                try {
                    a.close();
                } catch (Exception e2) {
                    C7226an.m31142a(e2);
                }
            }
            return null;
        } catch (Throwable th) {
            C7226an.m31142a(th);
            if (a != null) {
                try {
                    a.close();
                } catch (Exception e3) {
                    C7226an.m31142a(e3);
                }
            }
            return null;
        } finally {
            if (a != null) {
                try {
                    a.close();
                } catch (Exception e4) {
                    C7226an.m31142a(e4);
                }
            }
        }
    }

    /* renamed from: a */
    public static String m31007a(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String b = m31011b(str, str2);
        if (b != null && !b.isEmpty()) {
            sb.append("Register infos:\n");
            sb.append(b);
        }
        String c = m31013c(str, str2);
        if (c != null && !c.isEmpty()) {
            if (sb.length() > 0) {
                sb.append("\n");
            }
            sb.append("System SO infos:\n");
            sb.append(c);
        }
        return sb.toString();
    }

    /* renamed from: c */
    public static String m31012c(String str) {
        if (str == null) {
            return null;
        }
        File file = new File(str, "backup_record.txt");
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        return null;
    }

    /* renamed from: d */
    public static void m31014d(String str) {
        if (str != null) {
            try {
                File file = new File(str);
                if (file.canRead() && file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null) {
                        int length = listFiles.length;
                        for (int i = 0; i < length; i++) {
                            File file2 = listFiles[i];
                            if (file2.canRead() && file2.canWrite() && file2.length() == 0) {
                                file2.delete();
                                C7226an.m31147c("Delete empty record file %s", file2.getAbsoluteFile());
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                C7226an.m31142a(th);
            }
        }
    }

    /* renamed from: a */
    public static void m31009a(boolean z, String str) {
        if (str != null) {
            f24281a.add(new File(str, "rqd_record.eup"));
            f24281a.add(new File(str, "reg_record.txt"));
            f24281a.add(new File(str, "map_record.txt"));
            f24281a.add(new File(str, "backup_record.txt"));
            if (z) {
                m31014d(str);
            }
        }
        List<File> list = f24281a;
        if (list != null && list.size() > 0) {
            for (File file : f24281a) {
                if (file.exists() && file.canWrite()) {
                    file.delete();
                    C7226an.m31147c("Delete record file %s", file.getAbsoluteFile());
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e2 A[SYNTHETIC, Splitter:B:36:0x00e2] */
    /* renamed from: a */
    public static java.lang.String m31006a(java.lang.String r6, int r7, java.lang.String r8, boolean r9) {
        /*
        r0 = 0
        if (r6 == 0) goto L_0x00f2
        if (r7 > 0) goto L_0x0007
        goto L_0x00f2
    L_0x0007:
        java.io.File r1 = new java.io.File
        r1.<init>(r6)
        boolean r2 = r1.exists()
        if (r2 == 0) goto L_0x00f2
        boolean r2 = r1.canRead()
        if (r2 != 0) goto L_0x001a
        goto L_0x00f2
    L_0x001a:
        r2 = 2
        java.lang.Object[] r2 = new java.lang.Object[r2]
        long r3 = r1.length()
        java.lang.Long r3 = java.lang.Long.valueOf(r3)
        r4 = 0
        r2[r4] = r3
        r3 = 1
        java.lang.String r5 = r1.getAbsolutePath()
        r2[r3] = r5
        java.lang.String r3 = "Read system log from native record file(length: %s bytes): %s"
        com.tencent.bugly.proguard.C7226an.m31141a(r3, r2)
        java.util.List<java.io.File> r2 = f24281a
        r2.add(r1)
        java.lang.Object[] r2 = new java.lang.Object[r4]
        java.lang.String r3 = "Add this record file to list for cleaning lastly."
        com.tencent.bugly.proguard.C7226an.m31147c(r3, r2)
        if (r8 != 0) goto L_0x004d
        java.io.File r8 = new java.io.File
        r8.<init>(r6)
        java.lang.String r6 = com.tencent.bugly.proguard.C7232aq.m31181a(r8, r7, r9)
        goto L_0x00e5
    L_0x004d:
        java.lang.StringBuilder r6 = new java.lang.StringBuilder
        r6.<init>()
        java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x00ba }
        java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ all -> 0x00ba }
        java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ all -> 0x00ba }
        r5.<init>(r1)     // Catch:{ all -> 0x00ba }
        java.lang.String r1 = "utf-8"
        r3.<init>(r5, r1)     // Catch:{ all -> 0x00ba }
        r2.<init>(r3)     // Catch:{ all -> 0x00ba }
    L_0x0063:
        java.lang.String r0 = r2.readLine()     // Catch:{ all -> 0x00b8 }
        if (r0 == 0) goto L_0x00ab
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b8 }
        r1.<init>()     // Catch:{ all -> 0x00b8 }
        r1.append(r8)     // Catch:{ all -> 0x00b8 }
        java.lang.String r3 = "[ ]*:"
        r1.append(r3)     // Catch:{ all -> 0x00b8 }
        java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00b8 }
        java.util.regex.Pattern r1 = java.util.regex.Pattern.compile(r1)     // Catch:{ all -> 0x00b8 }
        java.util.regex.Matcher r1 = r1.matcher(r0)     // Catch:{ all -> 0x00b8 }
        boolean r1 = r1.find()     // Catch:{ all -> 0x00b8 }
        if (r1 == 0) goto L_0x0090
        r6.append(r0)     // Catch:{ all -> 0x00b8 }
        java.lang.String r0 = "\n"
        r6.append(r0)     // Catch:{ all -> 0x00b8 }
    L_0x0090:
        if (r7 <= 0) goto L_0x0063
        int r0 = r6.length()     // Catch:{ all -> 0x00b8 }
        if (r0 <= r7) goto L_0x0063
        if (r9 == 0) goto L_0x00a2
        int r8 = r6.length()     // Catch:{ all -> 0x00b8 }
        r6.delete(r7, r8)     // Catch:{ all -> 0x00b8 }
        goto L_0x00ab
    L_0x00a2:
        int r0 = r6.length()     // Catch:{ all -> 0x00b8 }
        int r0 = r0 - r7
        r6.delete(r4, r0)     // Catch:{ all -> 0x00b8 }
        goto L_0x0063
    L_0x00ab:
        java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x00b8 }
        r2.close()     // Catch:{ Exception -> 0x00b3 }
        goto L_0x00e5
    L_0x00b3:
        r7 = move-exception
        com.tencent.bugly.proguard.C7226an.m31142a(r7)
        goto L_0x00e5
    L_0x00b8:
        r7 = move-exception
        goto L_0x00bc
    L_0x00ba:
        r7 = move-exception
        r2 = r0
    L_0x00bc:
        com.tencent.bugly.proguard.C7226an.m31142a(r7)     // Catch:{ all -> 0x00e6 }
        java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e6 }
        r8.<init>()     // Catch:{ all -> 0x00e6 }
        java.lang.String r9 = "\n[error:"
        r8.append(r9)     // Catch:{ all -> 0x00e6 }
        java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00e6 }
        r8.append(r7)     // Catch:{ all -> 0x00e6 }
        java.lang.String r7 = "]"
        r8.append(r7)     // Catch:{ all -> 0x00e6 }
        java.lang.String r7 = r8.toString()     // Catch:{ all -> 0x00e6 }
        r6.append(r7)     // Catch:{ all -> 0x00e6 }
        java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x00e6 }
        if (r2 == 0) goto L_0x00e5
        r2.close()     // Catch:{ Exception -> 0x00b3 }
    L_0x00e5:
        return r6
    L_0x00e6:
        r6 = move-exception
        if (r2 == 0) goto L_0x00f1
        r2.close()     // Catch:{ Exception -> 0x00ed }
        goto L_0x00f1
    L_0x00ed:
        r7 = move-exception
        com.tencent.bugly.proguard.C7226an.m31142a(r7)
    L_0x00f1:
        throw r6
    L_0x00f2:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.jni.C7204b.m31006a(java.lang.String, int, java.lang.String, boolean):java.lang.String");
    }
}
