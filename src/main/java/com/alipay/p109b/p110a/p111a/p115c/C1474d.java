package com.alipay.p109b.p110a.p111a.p115c;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.alipay.b.a.a.c.d */
public final class C1474d {
    /* renamed from: a */
    private static String f3749a = "";
    /* renamed from: b */
    private static String f3750b = "";
    /* renamed from: c */
    private static String f3751c = "";

    /* renamed from: a */
    public static synchronized void m4293a(String str) {
        synchronized (C1474d.class) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            m4296a((List<String>) arrayList);
        }
    }

    /* renamed from: a */
    public static synchronized void m4294a(String str, String str2, String str3) {
        synchronized (C1474d.class) {
            f3749a = str;
            f3750b = str2;
            f3751c = str3;
        }
    }

    /* renamed from: a */
    public static synchronized void m4295a(Throwable th) {
        String str;
        synchronized (C1474d.class) {
            ArrayList arrayList = new ArrayList();
            if (th != null) {
                StringWriter stringWriter = new StringWriter();
                th.printStackTrace(new PrintWriter(stringWriter));
                str = stringWriter.toString();
            } else {
                str = "";
            }
            arrayList.add(str);
            m4296a((List<String>) arrayList);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0097, code lost:
            return;
     */
    /* renamed from: a */
    private static synchronized void m4296a(java.util.List<java.lang.String> r7) {
        /*
        java.lang.Class<com.alipay.b.a.a.c.d> r0 = com.alipay.p109b.p110a.p111a.p115c.C1474d.class
        monitor-enter(r0)
        java.lang.String r1 = f3750b     // Catch:{ all -> 0x0098 }
        boolean r1 = com.alipay.p109b.p110a.p111a.p112a.C1460a.m4260a(r1)     // Catch:{ all -> 0x0098 }
        if (r1 != 0) goto L_0x0096
        java.lang.String r1 = f3751c     // Catch:{ all -> 0x0098 }
        boolean r1 = com.alipay.p109b.p110a.p111a.p112a.C1460a.m4260a(r1)     // Catch:{ all -> 0x0098 }
        if (r1 == 0) goto L_0x0015
        goto L_0x0096
    L_0x0015:
        java.lang.StringBuffer r1 = new java.lang.StringBuffer     // Catch:{ all -> 0x0098 }
        r1.<init>()     // Catch:{ all -> 0x0098 }
        java.lang.String r2 = f3751c     // Catch:{ all -> 0x0098 }
        r1.append(r2)     // Catch:{ all -> 0x0098 }
        java.util.Iterator r7 = r7.iterator()     // Catch:{ all -> 0x0098 }
    L_0x0023:
        boolean r2 = r7.hasNext()     // Catch:{ all -> 0x0098 }
        if (r2 == 0) goto L_0x0041
        java.lang.Object r2 = r7.next()     // Catch:{ all -> 0x0098 }
        java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0098 }
        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0098 }
        java.lang.String r4 = ", "
        r3.<init>(r4)     // Catch:{ all -> 0x0098 }
        r3.append(r2)     // Catch:{ all -> 0x0098 }
        java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x0098 }
        r1.append(r2)     // Catch:{ all -> 0x0098 }
        goto L_0x0023
    L_0x0041:
        java.lang.String r7 = "\n"
        r1.append(r7)     // Catch:{ all -> 0x0098 }
        java.io.File r7 = new java.io.File     // Catch:{ Exception -> 0x0094 }
        java.lang.String r2 = f3749a     // Catch:{ Exception -> 0x0094 }
        r7.<init>(r2)     // Catch:{ Exception -> 0x0094 }
        boolean r2 = r7.exists()     // Catch:{ Exception -> 0x0094 }
        if (r2 != 0) goto L_0x0056
        r7.mkdirs()     // Catch:{ Exception -> 0x0094 }
    L_0x0056:
        java.io.File r7 = new java.io.File     // Catch:{ Exception -> 0x0094 }
        java.lang.String r2 = f3749a     // Catch:{ Exception -> 0x0094 }
        java.lang.String r3 = f3750b     // Catch:{ Exception -> 0x0094 }
        r7.<init>(r2, r3)     // Catch:{ Exception -> 0x0094 }
        boolean r2 = r7.exists()     // Catch:{ Exception -> 0x0094 }
        if (r2 != 0) goto L_0x0068
        r7.createNewFile()     // Catch:{ Exception -> 0x0094 }
    L_0x0068:
        long r2 = r7.length()     // Catch:{ Exception -> 0x0094 }
        int r4 = r1.length()     // Catch:{ Exception -> 0x0094 }
        long r4 = (long) r4     // Catch:{ Exception -> 0x0094 }
        long r4 = r4 + r2
        r2 = 51200(0xc800, double:2.5296E-319)
        int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
        if (r6 > 0) goto L_0x0080
        java.io.FileWriter r2 = new java.io.FileWriter     // Catch:{ Exception -> 0x0094 }
        r3 = 1
        r2.<init>(r7, r3)     // Catch:{ Exception -> 0x0094 }
        goto L_0x0085
    L_0x0080:
        java.io.FileWriter r2 = new java.io.FileWriter     // Catch:{ Exception -> 0x0094 }
        r2.<init>(r7)     // Catch:{ Exception -> 0x0094 }
    L_0x0085:
        java.lang.String r7 = r1.toString()     // Catch:{ Exception -> 0x0094 }
        r2.write(r7)     // Catch:{ Exception -> 0x0094 }
        r2.flush()     // Catch:{ Exception -> 0x0094 }
        r2.close()     // Catch:{ Exception -> 0x0094 }
        monitor-exit(r0)
        return
    L_0x0094:
        monitor-exit(r0)
        return
    L_0x0096:
        monitor-exit(r0)
        return
    L_0x0098:
        r7 = move-exception
        monitor-exit(r0)
        throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.p109b.p110a.p111a.p115c.C1474d.m4296a(java.util.List):void");
    }
}
