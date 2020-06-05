package com.alibaba.baichuan.trade.biz.core.config;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.alibaba.baichuan.trade.biz.core.config.a */
public class C1186a {
    /* renamed from: c */
    private static final String f2451c = C1186a.class.getSimpleName();
    /* renamed from: a */
    private Map<String, Map<String, Object>> f2452a = new HashMap();
    /* renamed from: b */
    private Set<String> f2453b = new HashSet();

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0034, code lost:
            if (r4 != null) goto L_0x0014;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0022 */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x003b A[SYNTHETIC, Splitter:B:25:0x003b] */
    /* renamed from: a */
    public static java.lang.Object m2321a(android.content.Context r3, java.lang.String r4) {
        /*
        java.lang.String r0 = "close input stream exception"
        r1 = 0
        android.content.Context r3 = r3.getApplicationContext()     // Catch:{ IOException -> 0x002c, ClassNotFoundException -> 0x0021, all -> 0x001e }
        java.io.FileInputStream r3 = r3.openFileInput(r4)     // Catch:{ IOException -> 0x002c, ClassNotFoundException -> 0x0021, all -> 0x001e }
        java.io.ObjectInputStream r4 = new java.io.ObjectInputStream     // Catch:{ IOException -> 0x002c, ClassNotFoundException -> 0x0021, all -> 0x001e }
        r4.<init>(r3)     // Catch:{ IOException -> 0x002c, ClassNotFoundException -> 0x0021, all -> 0x001e }
        java.lang.Object r1 = r4.readObject()     // Catch:{ IOException -> 0x002d, ClassNotFoundException -> 0x0022 }
    L_0x0014:
        r4.close()     // Catch:{ IOException -> 0x0018 }
        goto L_0x0037
    L_0x0018:
        java.lang.String r3 = f2451c
        com.alibaba.baichuan.trade.common.utils.C1224a.m2406d(r3, r0)
        goto L_0x0037
    L_0x001e:
        r3 = move-exception
        r4 = r1
        goto L_0x0039
    L_0x0021:
        r4 = r1
    L_0x0022:
        java.lang.String r3 = f2451c     // Catch:{ all -> 0x0038 }
        java.lang.String r2 = "class not found"
        com.alibaba.baichuan.trade.common.utils.C1224a.m2406d(r3, r2)     // Catch:{ all -> 0x0038 }
        if (r4 == 0) goto L_0x0037
        goto L_0x0014
    L_0x002c:
        r4 = r1
    L_0x002d:
        java.lang.String r3 = f2451c     // Catch:{ all -> 0x0038 }
        java.lang.String r2 = "read object from local file exception"
        com.alibaba.baichuan.trade.common.utils.C1224a.m2406d(r3, r2)     // Catch:{ all -> 0x0038 }
        if (r4 == 0) goto L_0x0037
        goto L_0x0014
    L_0x0037:
        return r1
    L_0x0038:
        r3 = move-exception
    L_0x0039:
        if (r4 == 0) goto L_0x0044
        r4.close()     // Catch:{ IOException -> 0x003f }
        goto L_0x0044
    L_0x003f:
        java.lang.String r4 = f2451c
        com.alibaba.baichuan.trade.common.utils.C1224a.m2406d(r4, r0)
    L_0x0044:
        throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.baichuan.trade.biz.core.config.C1186a.m2321a(android.content.Context, java.lang.String):java.lang.Object");
    }
}
