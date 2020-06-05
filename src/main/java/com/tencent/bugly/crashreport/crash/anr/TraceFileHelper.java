package com.tencent.bugly.crashreport.crash.anr;

import com.tencent.bugly.proguard.C7226an;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
public class TraceFileHelper {

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.crashreport.crash.anr.TraceFileHelper$a */
    public static class C7184a {
        /* renamed from: a */
        public long f24153a;
        /* renamed from: b */
        public String f24154b;
        /* renamed from: c */
        public long f24155c;
        /* renamed from: d */
        public Map<String, String[]> f24156d;
    }

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.crashreport.crash.anr.TraceFileHelper$b */
    public interface C7185b {
        /* renamed from: a */
        boolean mo34643a(long j);

        /* renamed from: a */
        boolean mo34644a(long j, long j2, String str);

        /* renamed from: a */
        boolean mo34645a(String str, int i, String str2, String str3, boolean z);

        /* renamed from: a */
        boolean mo34646a(String str, long j, long j2);
    }

    public static C7184a readTargetDumpInfo(final String str, String str2, final boolean z) {
        if (!(str == null || str2 == null)) {
            final C7184a aVar = new C7184a();
            readTraceFile(str2, new C7185b() {
                /* renamed from: a */
                public boolean mo34646a(String str, long j, long j2) {
                    return true;
                }

                /* renamed from: a */
                public boolean mo34645a(String str, int i, String str2, String str3, boolean z) {
                    C7226an.m31147c("new thread %s", str);
                    if (aVar.f24153a > 0 && aVar.f24155c > 0 && aVar.f24154b != null) {
                        if (aVar.f24156d == null) {
                            aVar.f24156d = new HashMap();
                        }
                        Map<String, String[]> map = aVar.f24156d;
                        StringBuilder sb = new StringBuilder();
                        sb.append("");
                        sb.append(i);
                        map.put(str, new String[]{str2, str3, sb.toString()});
                    }
                    return true;
                }

                /* renamed from: a */
                public boolean mo34644a(long j, long j2, String str) {
                    C7226an.m31147c("new process %s", str);
                    if (!str.equals(str)) {
                        return true;
                    }
                    C7184a aVar = aVar;
                    aVar.f24153a = j;
                    aVar.f24154b = str;
                    aVar.f24155c = j2;
                    return z;
                }

                /* renamed from: a */
                public boolean mo34643a(long j) {
                    C7226an.m31147c("process end %d", Long.valueOf(j));
                    return aVar.f24153a <= 0 || aVar.f24155c <= 0 || aVar.f24154b == null;
                }
            });
            if (aVar.f24153a <= 0 || aVar.f24155c <= 0 || aVar.f24154b == null) {
                return null;
            }
            return aVar;
        }
        return null;
    }

    public static C7184a readFirstDumpInfo(String str, final boolean z) {
        if (str == null) {
            C7226an.m31149e("path:%s", str);
            return null;
        }
        final C7184a aVar = new C7184a();
        readTraceFile(str, new C7185b() {
            /* renamed from: a */
            public boolean mo34646a(String str, long j, long j2) {
                return true;
            }

            /* renamed from: a */
            public boolean mo34645a(String str, int i, String str2, String str3, boolean z) {
                C7226an.m31147c("new thread %s", str);
                if (aVar.f24156d == null) {
                    aVar.f24156d = new HashMap();
                }
                Map<String, String[]> map = aVar.f24156d;
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(i);
                map.put(str, new String[]{str2, str3, sb.toString()});
                return true;
            }

            /* renamed from: a */
            public boolean mo34644a(long j, long j2, String str) {
                C7226an.m31147c("new process %s", str);
                C7184a aVar = aVar;
                aVar.f24153a = j;
                aVar.f24154b = str;
                aVar.f24155c = j2;
                return z;
            }

            /* renamed from: a */
            public boolean mo34643a(long j) {
                C7226an.m31147c("process end %d", Long.valueOf(j));
                return false;
            }
        });
        if (aVar.f24153a > 0 && aVar.f24155c > 0 && aVar.f24154b != null) {
            return aVar;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(aVar.f24153a);
        String str2 = " ";
        sb.append(str2);
        sb.append(aVar.f24155c);
        sb.append(str2);
        sb.append(aVar.f24154b);
        C7226an.m31149e("first dump error %s", sb.toString());
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:52:0x016a, code lost:
            if (r7.mo34643a(java.lang.Long.parseLong(r0[1].toString().split(r8)[2])) != false) goto L_0x017c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
            r12.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0170, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0171, code lost:
            r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0176, code lost:
            if (com.tencent.bugly.proguard.C7226an.m31142a(r1) == false) goto L_0x0178;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0178, code lost:
            r1.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x017b, code lost:
            return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
            r12.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x018a, code lost:
            if (com.tencent.bugly.proguard.C7226an.m31142a(r1) != false) goto L_0x01da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x018c, code lost:
            r1.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01d7, code lost:
            if (com.tencent.bugly.proguard.C7226an.m31142a(r1) != false) goto L_0x01da;
     */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01a0 A[Catch:{ all -> 0x0195 }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01cd A[SYNTHETIC, Splitter:B:80:0x01cd] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01dd A[SYNTHETIC, Splitter:B:87:0x01dd] */
    public static void readTraceFile(java.lang.String r18, com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.C7185b r19) {
        /*
        r0 = r18
        r7 = r19
        java.lang.String r8 = "\\s"
        if (r0 == 0) goto L_0x01ed
        if (r7 != 0) goto L_0x000c
        goto L_0x01ed
    L_0x000c:
        java.io.File r9 = new java.io.File
        r9.<init>(r0)
        boolean r1 = r9.exists()
        if (r1 != 0) goto L_0x0018
        return
    L_0x0018:
        long r3 = r9.lastModified()
        long r5 = r9.length()
        r1 = r19
        r2 = r18
        boolean r0 = r1.mo34646a(r2, r3, r5)
        if (r0 != 0) goto L_0x002b
        return
    L_0x002b:
        r1 = 0
        r6 = 2
        r10 = 0
        r11 = 1
        java.io.BufferedReader r12 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0199 }
        java.io.FileReader r0 = new java.io.FileReader     // Catch:{ Exception -> 0x0199 }
        r0.<init>(r9)     // Catch:{ Exception -> 0x0199 }
        r12.<init>(r0)     // Catch:{ Exception -> 0x0199 }
        java.lang.String r0 = "-{5}\\spid\\s\\d+\\sat\\s\\d+-\\d+-\\d+\\s\\d{2}:\\d{2}:\\d{2}\\s-{5}"
        java.util.regex.Pattern r9 = java.util.regex.Pattern.compile(r0)     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        java.lang.String r0 = "-{5}\\send\\s\\d+\\s-{5}"
        java.util.regex.Pattern r13 = java.util.regex.Pattern.compile(r0)     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        java.lang.String r0 = "Cmd\\sline:\\s(\\S+)"
        java.util.regex.Pattern r14 = java.util.regex.Pattern.compile(r0)     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        java.lang.String r0 = "\".+\"\\s(daemon\\s){0,1}prio=\\d+\\stid=\\d+\\s.*"
        java.util.regex.Pattern r15 = java.util.regex.Pattern.compile(r0)     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        java.text.SimpleDateFormat r5 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        java.lang.String r0 = "yyyy-MM-dd HH:mm:ss"
        java.util.Locale r1 = java.util.Locale.US     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        r5.<init>(r0, r1)     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
    L_0x005a:
        java.util.regex.Pattern[] r0 = new java.util.regex.Pattern[r11]     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        r0[r10] = r9     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        java.lang.Object[] r0 = m30877a(r12, r0)     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        if (r0 == 0) goto L_0x0180
        r0 = r0[r11]     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        java.lang.String[] r0 = r0.split(r8)     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        r1 = r0[r6]     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        long r1 = java.lang.Long.parseLong(r1)     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        r3.<init>()     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        r4 = 4
        r4 = r0[r4]     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        r3.append(r4)     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        java.lang.String r4 = " "
        r3.append(r4)     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        r4 = 5
        r0 = r0[r4]     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        r3.append(r0)     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        java.util.Date r0 = r5.parse(r0)     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        long r3 = r0.getTime()     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        java.util.regex.Pattern[] r0 = new java.util.regex.Pattern[r11]     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        r0[r10] = r14     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        java.lang.Object[] r0 = m30877a(r12, r0)     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        if (r0 != 0) goto L_0x00b0
        r12.close()     // Catch:{ IOException -> 0x00a4 }
        goto L_0x00af
    L_0x00a4:
        r0 = move-exception
        r1 = r0
        boolean r0 = com.tencent.bugly.proguard.C7226an.m31142a(r1)
        if (r0 != 0) goto L_0x00af
        r1.printStackTrace()
    L_0x00af:
        return
    L_0x00b0:
        r0 = r0[r11]     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        java.util.regex.Matcher r0 = r14.matcher(r0)     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        r0.find()     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        r0.group(r11)     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        java.lang.String r16 = r0.group(r11)     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        r0 = r19
        r17 = r5
        r5 = r16
        boolean r0 = r0.mo34644a(r1, r3, r5)     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        if (r0 != 0) goto L_0x00e0
        r12.close()     // Catch:{ IOException -> 0x00d4 }
        goto L_0x00df
    L_0x00d4:
        r0 = move-exception
        r1 = r0
        boolean r0 = com.tencent.bugly.proguard.C7226an.m31142a(r1)
        if (r0 != 0) goto L_0x00df
        r1.printStackTrace()
    L_0x00df:
        return
    L_0x00e0:
        java.util.regex.Pattern[] r0 = new java.util.regex.Pattern[r6]     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        r0[r10] = r15     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        r0[r11] = r13     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        java.lang.Object[] r0 = m30877a(r12, r0)     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        if (r0 == 0) goto L_0x017c
        r1 = r0[r10]     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        if (r1 != r15) goto L_0x0156
        r0 = r0[r11]     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        java.lang.String r1 = "\".+\""
        java.util.regex.Pattern r1 = java.util.regex.Pattern.compile(r1)     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        java.util.regex.Matcher r1 = r1.matcher(r0)     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        r1.find()     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        java.lang.String r1 = r1.group()     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        int r2 = r1.length()     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        int r2 = r2 - r11
        java.lang.String r1 = r1.substring(r11, r2)     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        java.lang.String r2 = "NATIVE"
        boolean r5 = r0.contains(r2)     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        java.lang.String r2 = "tid=\\d+"
        java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2)     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        java.util.regex.Matcher r0 = r2.matcher(r0)     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        r0.find()     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        java.lang.String r0 = r0.group()     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        java.lang.String r2 = "="
        int r2 = r0.indexOf(r2)     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        int r2 = r2 + r11
        java.lang.String r0 = r0.substring(r2)     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        int r2 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        java.lang.String r3 = m30876a(r12)     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        java.lang.String r4 = m30878b(r12)     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        r0 = r19
        boolean r0 = r0.mo34645a(r1, r2, r3, r4, r5)     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        if (r0 != 0) goto L_0x00e0
        r12.close()     // Catch:{ IOException -> 0x014a }
        goto L_0x0155
    L_0x014a:
        r0 = move-exception
        r1 = r0
        boolean r0 = com.tencent.bugly.proguard.C7226an.m31142a(r1)
        if (r0 != 0) goto L_0x0155
        r1.printStackTrace()
    L_0x0155:
        return
    L_0x0156:
        r0 = r0[r11]     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        java.lang.String[] r0 = r0.split(r8)     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        r0 = r0[r6]     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        long r0 = java.lang.Long.parseLong(r0)     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        boolean r0 = r7.mo34643a(r0)     // Catch:{ Exception -> 0x0192, all -> 0x0190 }
        if (r0 != 0) goto L_0x017c
        r12.close()     // Catch:{ IOException -> 0x0170 }
        goto L_0x017b
    L_0x0170:
        r0 = move-exception
        r1 = r0
        boolean r0 = com.tencent.bugly.proguard.C7226an.m31142a(r1)
        if (r0 != 0) goto L_0x017b
        r1.printStackTrace()
    L_0x017b:
        return
    L_0x017c:
        r5 = r17
        goto L_0x005a
    L_0x0180:
        r12.close()     // Catch:{ IOException -> 0x0184 }
        goto L_0x01da
    L_0x0184:
        r0 = move-exception
        r1 = r0
        boolean r0 = com.tencent.bugly.proguard.C7226an.m31142a(r1)
        if (r0 != 0) goto L_0x01da
    L_0x018c:
        r1.printStackTrace()
        goto L_0x01da
    L_0x0190:
        r0 = move-exception
        goto L_0x0197
    L_0x0192:
        r0 = move-exception
        r1 = r12
        goto L_0x019a
    L_0x0195:
        r0 = move-exception
        r12 = r1
    L_0x0197:
        r1 = r0
        goto L_0x01db
    L_0x0199:
        r0 = move-exception
    L_0x019a:
        boolean r2 = com.tencent.bugly.proguard.C7226an.m31142a(r0)     // Catch:{ all -> 0x0195 }
        if (r2 != 0) goto L_0x01a3
        r0.printStackTrace()     // Catch:{ all -> 0x0195 }
    L_0x01a3:
        java.lang.String r2 = "trace open fail:%s : %s"
        java.lang.Object[] r3 = new java.lang.Object[r6]     // Catch:{ all -> 0x0195 }
        java.lang.Class r4 = r0.getClass()     // Catch:{ all -> 0x0195 }
        java.lang.String r4 = r4.getName()     // Catch:{ all -> 0x0195 }
        r3[r10] = r4     // Catch:{ all -> 0x0195 }
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0195 }
        r4.<init>()     // Catch:{ all -> 0x0195 }
        java.lang.String r5 = ""
        r4.append(r5)     // Catch:{ all -> 0x0195 }
        java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0195 }
        r4.append(r0)     // Catch:{ all -> 0x0195 }
        java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x0195 }
        r3[r11] = r0     // Catch:{ all -> 0x0195 }
        com.tencent.bugly.proguard.C7226an.m31148d(r2, r3)     // Catch:{ all -> 0x0195 }
        if (r1 == 0) goto L_0x01da
        r1.close()     // Catch:{ IOException -> 0x01d1 }
        goto L_0x01da
    L_0x01d1:
        r0 = move-exception
        r1 = r0
        boolean r0 = com.tencent.bugly.proguard.C7226an.m31142a(r1)
        if (r0 != 0) goto L_0x01da
        goto L_0x018c
    L_0x01da:
        return
    L_0x01db:
        if (r12 == 0) goto L_0x01ec
        r12.close()     // Catch:{ IOException -> 0x01e1 }
        goto L_0x01ec
    L_0x01e1:
        r0 = move-exception
        r2 = r0
        boolean r0 = com.tencent.bugly.proguard.C7226an.m31142a(r2)
        if (r0 != 0) goto L_0x01ec
        r2.printStackTrace()
    L_0x01ec:
        throw r1
    L_0x01ed:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.readTraceFile(java.lang.String, com.tencent.bugly.crashreport.crash.anr.TraceFileHelper$b):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0025, code lost:
            return new java.lang.Object[]{r5, r1};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0026, code lost:
            r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
            if (r8 != null) goto L_0x0006;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
            r1 = r7.readLine();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
            if (r1 == null) goto L_0x0029;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000c, code lost:
            r2 = r8.length;
            r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000f, code lost:
            if (r4 >= r2) goto L_0x0006;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0011, code lost:
            r5 = r8[r4];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001b, code lost:
            if (r5.matcher(r1).matches() == false) goto L_0x0026;
     */
    /* renamed from: a */
    protected static java.lang.Object[] m30877a(java.io.BufferedReader r7, java.util.regex.Pattern... r8) throws java.io.IOException {
        /*
        r0 = 0
        if (r7 == 0) goto L_0x0029
        if (r8 != 0) goto L_0x0006
        goto L_0x0029
    L_0x0006:
        java.lang.String r1 = r7.readLine()
        if (r1 == 0) goto L_0x0029
        int r2 = r8.length
        r3 = 0
        r4 = 0
    L_0x000f:
        if (r4 >= r2) goto L_0x0006
        r5 = r8[r4]
        java.util.regex.Matcher r6 = r5.matcher(r1)
        boolean r6 = r6.matches()
        if (r6 == 0) goto L_0x0026
        r7 = 2
        java.lang.Object[] r7 = new java.lang.Object[r7]
        r7[r3] = r5
        r8 = 1
        r7[r8] = r1
        return r7
    L_0x0026:
        int r4 = r4 + 1
        goto L_0x000f
    L_0x0029:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.m30877a(java.io.BufferedReader, java.util.regex.Pattern[]):java.lang.Object[]");
    }

    /* renamed from: a */
    protected static String m30876a(BufferedReader bufferedReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 3; i++) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(readLine);
            sb.append("\n");
            stringBuffer.append(sb.toString());
        }
        return stringBuffer.toString();
    }

    /* renamed from: b */
    protected static String m30878b(BufferedReader bufferedReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null && readLine.trim().length() > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(readLine);
                sb.append("\n");
                stringBuffer.append(sb.toString());
            }
        }
        return stringBuffer.toString();
    }
}
