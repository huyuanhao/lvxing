package com.p368pw.inner.base.p387d.p388a;

import java.io.File;
import java.util.List;
import java.util.Map;

/* renamed from: com.pw.inner.base.d.a.d */
public class C5160d {
    /* renamed from: a */
    private int f16838a;
    /* renamed from: b */
    private Map<String, List<String>> f16839b;
    /* renamed from: c */
    private String f16840c;

    /* renamed from: com.pw.inner.base.d.a.d$a */
    public interface C5161a {
        /* renamed from: a */
        void mo26757a(int i);
    }

    /* renamed from: a */
    public File mo26766a(String str, String str2, C5161a aVar) {
        return mo26767a(str, str2, false, aVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:62:0x0104 A[Catch:{ Exception -> 0x00b5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x011d A[Catch:{ Exception -> 0x0121 }] */
    /* renamed from: a */
    public java.io.File mo26767a(java.lang.String r17, java.lang.String r18, boolean r19, com.p368pw.inner.base.p387d.p388a.C5160d.C5161a r20) {
        /*
        r16 = this;
        r1 = r16
        r2 = r17
        r3 = r18
        r4 = r20
        java.lang.String r5 = "https://"
        java.io.File r6 = new java.io.File
        r6.<init>(r3)
        java.io.File r0 = r6.getParentFile()
        boolean r0 = r0.exists()
        if (r0 != 0) goto L_0x0020
        java.io.File r0 = r6.getParentFile()
        r0.mkdirs()
    L_0x0020:
        java.lang.String r7 = "fail"
        r8 = 0
        r9 = 0
        boolean r0 = r2.startsWith(r5)     // Catch:{ Exception -> 0x00cc, all -> 0x00c8 }
        if (r0 == 0) goto L_0x002d
        com.p368pw.inner.base.p387d.p389b.C5165a.m21319a()     // Catch:{ Exception -> 0x00cc, all -> 0x00c8 }
    L_0x002d:
        java.net.URL r0 = new java.net.URL     // Catch:{ Exception -> 0x00cc, all -> 0x00c8 }
        r0.<init>(r2)     // Catch:{ Exception -> 0x00cc, all -> 0x00c8 }
        java.net.URLConnection r0 = r0.openConnection()     // Catch:{ Exception -> 0x00cc, all -> 0x00c8 }
        r10 = r0
        java.net.HttpURLConnection r10 = (java.net.HttpURLConnection) r10     // Catch:{ Exception -> 0x00cc, all -> 0x00c8 }
        java.lang.String r0 = "GET"
        r10.setRequestMethod(r0)     // Catch:{ Exception -> 0x00c4, all -> 0x00bf }
        r10.setUseCaches(r9)     // Catch:{ Exception -> 0x00c4, all -> 0x00bf }
        r0 = 300000(0x493e0, float:4.2039E-40)
        r10.setReadTimeout(r0)     // Catch:{ Exception -> 0x00c4, all -> 0x00bf }
        r0 = 60000(0xea60, float:8.4078E-41)
        r10.setConnectTimeout(r0)     // Catch:{ Exception -> 0x00c4, all -> 0x00bf }
        java.io.InputStream r11 = r10.getInputStream()     // Catch:{ Exception -> 0x00c4, all -> 0x00bf }
        int r0 = r10.getResponseCode()     // Catch:{ Exception -> 0x00bd, all -> 0x00ba }
        r12 = 200(0xc8, float:2.8E-43)
        if (r0 == r12) goto L_0x0075
        int r0 = r10.getResponseCode()     // Catch:{ Exception -> 0x0070 }
        r1.f16838a = r0     // Catch:{ Exception -> 0x0070 }
        java.util.Map r0 = r10.getHeaderFields()     // Catch:{ Exception -> 0x0070 }
        r1.f16839b = r0     // Catch:{ Exception -> 0x0070 }
        r1.f16840c = r7     // Catch:{ Exception -> 0x0070 }
        com.p368pw.inner.base.p387d.C5175d.m21353a(r11)     // Catch:{ Exception -> 0x0070 }
        if (r10 == 0) goto L_0x0074
        r10.disconnect()     // Catch:{ Exception -> 0x0070 }
        goto L_0x0074
    L_0x0070:
        r0 = move-exception
        com.p368pw.inner.base.p387d.C5205o.m21464a(r0)
    L_0x0074:
        return r8
    L_0x0075:
        int r0 = r10.getContentLength()     // Catch:{ Exception -> 0x00bd, all -> 0x00ba }
        java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00bd, all -> 0x00ba }
        r8.<init>(r6)     // Catch:{ Exception -> 0x00bd, all -> 0x00ba }
        r12 = 1024(0x400, float:1.435E-42)
        byte[] r12 = new byte[r12]     // Catch:{ Exception -> 0x00bd, all -> 0x00ba }
        r13 = 0
    L_0x0083:
        int r14 = r11.read(r12)     // Catch:{ Exception -> 0x00bd, all -> 0x00ba }
        r15 = -1
        if (r14 == r15) goto L_0x009c
        r8.write(r12, r9, r14)     // Catch:{ Exception -> 0x00bd, all -> 0x00ba }
        int r13 = r13 + r14
        if (r4 == 0) goto L_0x0083
        float r14 = (float) r13     // Catch:{ Exception -> 0x00bd, all -> 0x00ba }
        float r15 = (float) r0     // Catch:{ Exception -> 0x00bd, all -> 0x00ba }
        float r14 = r14 / r15
        r15 = 1120403456(0x42c80000, float:100.0)
        float r14 = r14 * r15
        int r14 = (int) r14     // Catch:{ Exception -> 0x00bd, all -> 0x00ba }
        r4.mo26757a(r14)     // Catch:{ Exception -> 0x00bd, all -> 0x00ba }
        goto L_0x0083
    L_0x009c:
        java.lang.String r0 = "success"
        int r2 = r10.getResponseCode()     // Catch:{ Exception -> 0x00b5 }
        r1.f16838a = r2     // Catch:{ Exception -> 0x00b5 }
        java.util.Map r2 = r10.getHeaderFields()     // Catch:{ Exception -> 0x00b5 }
        r1.f16839b = r2     // Catch:{ Exception -> 0x00b5 }
        r1.f16840c = r0     // Catch:{ Exception -> 0x00b5 }
        com.p368pw.inner.base.p387d.C5175d.m21353a(r11)     // Catch:{ Exception -> 0x00b5 }
        if (r10 == 0) goto L_0x0107
        r10.disconnect()     // Catch:{ Exception -> 0x00b5 }
        goto L_0x0107
    L_0x00b5:
        r0 = move-exception
        com.p368pw.inner.base.p387d.C5205o.m21464a(r0)
        goto L_0x0107
    L_0x00ba:
        r0 = move-exception
        r2 = r0
        goto L_0x00c2
    L_0x00bd:
        r0 = move-exception
        goto L_0x00c6
    L_0x00bf:
        r0 = move-exception
        r2 = r0
        r11 = r8
    L_0x00c2:
        r8 = r10
        goto L_0x010a
    L_0x00c4:
        r0 = move-exception
        r11 = r8
    L_0x00c6:
        r8 = r10
        goto L_0x00ce
    L_0x00c8:
        r0 = move-exception
        r2 = r0
        r11 = r8
        goto L_0x010a
    L_0x00cc:
        r0 = move-exception
        r11 = r8
    L_0x00ce:
        com.p368pw.inner.base.p387d.C5205o.m21464a(r0)     // Catch:{ all -> 0x0108 }
        boolean r10 = r0 instanceof javax.net.ssl.SSLException     // Catch:{ all -> 0x0108 }
        if (r10 != 0) goto L_0x00e5
        boolean r10 = r0 instanceof java.io.IOException     // Catch:{ all -> 0x0108 }
        if (r10 == 0) goto L_0x00f1
        java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0108 }
        java.lang.String r10 = "Cleartext HTTP traffic"
        boolean r0 = r0.contains(r10)     // Catch:{ all -> 0x0108 }
        if (r0 == 0) goto L_0x00f1
    L_0x00e5:
        if (r19 == 0) goto L_0x00f1
        java.lang.String r0 = "http://"
        java.lang.String r0 = r2.replaceAll(r0, r5)     // Catch:{ all -> 0x0108 }
        java.io.File r6 = r1.mo26767a(r0, r3, r9, r4)     // Catch:{ all -> 0x0108 }
    L_0x00f1:
        int r0 = r8.getResponseCode()     // Catch:{ Exception -> 0x00b5 }
        r1.f16838a = r0     // Catch:{ Exception -> 0x00b5 }
        java.util.Map r0 = r8.getHeaderFields()     // Catch:{ Exception -> 0x00b5 }
        r1.f16839b = r0     // Catch:{ Exception -> 0x00b5 }
        r1.f16840c = r7     // Catch:{ Exception -> 0x00b5 }
        com.p368pw.inner.base.p387d.C5175d.m21353a(r11)     // Catch:{ Exception -> 0x00b5 }
        if (r8 == 0) goto L_0x0107
        r8.disconnect()     // Catch:{ Exception -> 0x00b5 }
    L_0x0107:
        return r6
    L_0x0108:
        r0 = move-exception
        r2 = r0
    L_0x010a:
        int r0 = r8.getResponseCode()     // Catch:{ Exception -> 0x0121 }
        r1.f16838a = r0     // Catch:{ Exception -> 0x0121 }
        java.util.Map r0 = r8.getHeaderFields()     // Catch:{ Exception -> 0x0121 }
        r1.f16839b = r0     // Catch:{ Exception -> 0x0121 }
        r1.f16840c = r7     // Catch:{ Exception -> 0x0121 }
        com.p368pw.inner.base.p387d.C5175d.m21353a(r11)     // Catch:{ Exception -> 0x0121 }
        if (r8 == 0) goto L_0x0125
        r8.disconnect()     // Catch:{ Exception -> 0x0121 }
        goto L_0x0125
    L_0x0121:
        r0 = move-exception
        com.p368pw.inner.base.p387d.C5205o.m21464a(r0)
    L_0x0125:
        throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p368pw.inner.base.p387d.p388a.C5160d.mo26767a(java.lang.String, java.lang.String, boolean, com.pw.inner.base.d.a.d$a):java.io.File");
    }

    /* renamed from: a */
    public String mo26768a() {
        return this.f16840c;
    }
}
