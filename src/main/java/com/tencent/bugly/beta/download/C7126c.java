package com.tencent.bugly.beta.download;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.beta.download.c */
public class C7126c {
    /* renamed from: a */
    final int f23685a;
    /* renamed from: b */
    final Object[] f23686b;

    public C7126c(int i, Object... objArr) {
        this.f23685a = i;
        this.f23686b = objArr;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0099, code lost:
            return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00a7, code lost:
            return;
     */
    /* renamed from: a */
    public synchronized void mo34327a(int r6, int r7) {
        /*
        r5 = this;
        monitor-enter(r5)
        int r0 = r5.f23685a     // Catch:{ Exception -> 0x009c }
        r1 = 1
        if (r0 == r1) goto L_0x0073
        r2 = 2
        if (r0 == r2) goto L_0x000b
        goto L_0x00a6
    L_0x000b:
        java.lang.Object[] r0 = r5.f23686b     // Catch:{ Exception -> 0x009c }
        r3 = 0
        r0 = r0[r3]     // Catch:{ Exception -> 0x009c }
        com.tencent.bugly.beta.download.DownloadTask r0 = (com.tencent.bugly.beta.download.DownloadTask) r0     // Catch:{ Exception -> 0x009c }
        java.lang.Object[] r4 = r5.f23686b     // Catch:{ Exception -> 0x009c }
        r2 = r4[r2]     // Catch:{ Exception -> 0x009c }
        com.tencent.bugly.beta.ui.f r2 = (com.tencent.bugly.beta.p602ui.C7147f) r2     // Catch:{ Exception -> 0x009c }
        if (r7 != r1) goto L_0x0031
        r0.download()     // Catch:{ Exception -> 0x009c }
        java.lang.String r6 = "continue download"
        java.lang.Object[] r7 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x009c }
        com.tencent.bugly.proguard.C7226an.m31147c(r6, r7)     // Catch:{ Exception -> 0x009c }
        java.lang.Object[] r6 = r5.f23686b     // Catch:{ Exception -> 0x009c }
        java.lang.Boolean r7 = java.lang.Boolean.valueOf(r3)     // Catch:{ Exception -> 0x009c }
        r6[r1] = r7     // Catch:{ Exception -> 0x009c }
        r2.mo34434a()     // Catch:{ Exception -> 0x009c }
        goto L_0x00a6
    L_0x0031:
        if (r6 == r1) goto L_0x003f
        java.lang.Object[] r6 = r5.f23686b     // Catch:{ Exception -> 0x009c }
        r6 = r6[r1]     // Catch:{ Exception -> 0x009c }
        java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ Exception -> 0x009c }
        boolean r6 = r6.booleanValue()     // Catch:{ Exception -> 0x009c }
        if (r6 == 0) goto L_0x00a6
    L_0x003f:
        com.tencent.bugly.beta.global.e r6 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ Exception -> 0x009c }
        boolean r6 = r6.f23717S     // Catch:{ Exception -> 0x009c }
        if (r6 != 0) goto L_0x00a6
        com.tencent.bugly.beta.global.e r6 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ Exception -> 0x009c }
        boolean r6 = r6.f23718T     // Catch:{ Exception -> 0x009c }
        if (r6 != 0) goto L_0x00a6
        r0.stop()     // Catch:{ Exception -> 0x009c }
        java.lang.String r6 = "wifi network change to mobile network, stop download"
        java.lang.Object[] r7 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x009c }
        com.tencent.bugly.proguard.C7226an.m31147c(r6, r7)     // Catch:{ Exception -> 0x009c }
        java.lang.Object[] r6 = r5.f23686b     // Catch:{ Exception -> 0x009c }
        java.lang.Boolean r7 = java.lang.Boolean.valueOf(r1)     // Catch:{ Exception -> 0x009c }
        r6[r1] = r7     // Catch:{ Exception -> 0x009c }
        com.tencent.bugly.beta.global.e r6 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ Exception -> 0x009c }
        android.content.Context r6 = r6.f23747s     // Catch:{ Exception -> 0x009c }
        java.lang.String r6 = com.tencent.bugly.crashreport.common.info.C7175b.m30828f(r6)     // Catch:{ Exception -> 0x009c }
        if (r6 == 0) goto L_0x00a6
        com.tencent.bugly.beta.p602ui.C7148g.m30581a(r2, r1)     // Catch:{ Exception -> 0x009c }
        java.lang.Object[] r6 = r5.f23686b     // Catch:{ Exception -> 0x009c }
        java.lang.Boolean r7 = java.lang.Boolean.valueOf(r3)     // Catch:{ Exception -> 0x009c }
        r6[r1] = r7     // Catch:{ Exception -> 0x009c }
        goto L_0x00a6
    L_0x0073:
        if (r7 == r1) goto L_0x007c
        r6 = 3
        if (r7 == r6) goto L_0x007c
        r6 = 4
        if (r7 == r6) goto L_0x007c
        goto L_0x00a6
    L_0x007c:
        com.tencent.bugly.proguard.p r6 = com.tencent.bugly.proguard.C7270p.f24600a     // Catch:{ Exception -> 0x009c }
        java.util.List r6 = r6.mo34950a()     // Catch:{ Exception -> 0x009c }
        java.util.ArrayList r6 = (java.util.ArrayList) r6     // Catch:{ Exception -> 0x009c }
        if (r6 == 0) goto L_0x0098
        boolean r7 = r6.isEmpty()     // Catch:{ Exception -> 0x009c }
        if (r7 == 0) goto L_0x008d
        goto L_0x0098
    L_0x008d:
        com.tencent.bugly.beta.upgrade.b r7 = com.tencent.bugly.beta.upgrade.C7151b.f23829a     // Catch:{ Exception -> 0x009c }
        com.tencent.bugly.proguard.x r0 = new com.tencent.bugly.proguard.x     // Catch:{ Exception -> 0x009c }
        r0.m52632init(r6)     // Catch:{ Exception -> 0x009c }
        r7.mo34471a(r0, r1)     // Catch:{ Exception -> 0x009c }
        goto L_0x00a6
    L_0x0098:
        monitor-exit(r5)
        return
    L_0x009a:
        r6 = move-exception
        goto L_0x00a8
    L_0x009c:
        r6 = move-exception
        boolean r7 = com.tencent.bugly.proguard.C7226an.m31145b(r6)     // Catch:{ all -> 0x009a }
        if (r7 != 0) goto L_0x00a6
        r6.printStackTrace()     // Catch:{ all -> 0x009a }
    L_0x00a6:
        monitor-exit(r5)
        return
    L_0x00a8:
        monitor-exit(r5)
        throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.download.C7126c.mo34327a(int, int):void");
    }
}
