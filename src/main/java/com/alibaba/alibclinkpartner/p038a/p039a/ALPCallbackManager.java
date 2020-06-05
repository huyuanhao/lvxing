package com.alibaba.alibclinkpartner.p038a.p039a;

/* renamed from: com.alibaba.alibclinkpartner.a.a.c */
public class ALPCallbackManager {
    /* renamed from: a */
    public static ALPCallbackInfo f2230a;

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0045, code lost:
            return;
     */
    /* renamed from: a */
    public static synchronized void m2115a(java.lang.String r2, java.lang.String r3, int r4, android.os.Bundle r5) {
        /*
        java.lang.Class<com.alibaba.alibclinkpartner.a.a.c> r0 = com.alibaba.alibclinkpartner.p038a.p039a.ALPCallbackManager.class
        monitor-enter(r0)
        boolean r1 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0046 }
        if (r1 != 0) goto L_0x0044
        boolean r1 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0046 }
        if (r1 != 0) goto L_0x0044
        com.alibaba.alibclinkpartner.a.a.b r1 = f2230a     // Catch:{ all -> 0x0046 }
        if (r1 != 0) goto L_0x0014
        goto L_0x0044
    L_0x0014:
        java.lang.String r1 = ","
        java.lang.String[] r3 = r3.split(r1)     // Catch:{ all -> 0x0046 }
        int r1 = r3.length     // Catch:{ all -> 0x0046 }
        if (r1 != 0) goto L_0x001f
        monitor-exit(r0)
        return
    L_0x001f:
        r1 = 0
        r3 = r3[r1]     // Catch:{ all -> 0x0046 }
        java.lang.String r1 = "result"
        android.os.Bundle r5 = r5.getBundle(r1)     // Catch:{ all -> 0x0046 }
        com.alibaba.alibclinkpartner.a.a.b r1 = f2230a     // Catch:{ all -> 0x0046 }
        boolean r2 = r1.mo10478a(r2, r3)     // Catch:{ all -> 0x0046 }
        if (r2 == 0) goto L_0x003c
        com.alibaba.alibclinkpartner.a.a.b r2 = f2230a     // Catch:{ all -> 0x0046 }
        if (r5 != 0) goto L_0x0039
        android.os.Bundle r5 = new android.os.Bundle     // Catch:{ all -> 0x0046 }
        r5.<init>()     // Catch:{ all -> 0x0046 }
    L_0x0039:
        r2.mo10477a(r4, r5)     // Catch:{ all -> 0x0046 }
    L_0x003c:
        r2 = 0
        f2230a = r2     // Catch:{ all -> 0x0046 }
        com.alibaba.alibclinkpartner.p038a.p039a.ALPCallbackCleaner.m2109a()     // Catch:{ all -> 0x0046 }
        monitor-exit(r0)
        return
    L_0x0044:
        monitor-exit(r0)
        return
    L_0x0046:
        r2 = move-exception
        monitor-exit(r0)
        throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.alibclinkpartner.p038a.p039a.ALPCallbackManager.m2115a(java.lang.String, java.lang.String, int, android.os.Bundle):void");
    }
}
