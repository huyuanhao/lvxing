package com.bytedance.embedapplog.p142b;

import org.json.JSONObject;

/* renamed from: com.bytedance.embedapplog.b.c */
abstract class C1816c {
    /* renamed from: a */
    boolean f5095a;
    /* renamed from: b */
    boolean f5096b;
    /* renamed from: c */
    boolean f5097c;
    /* renamed from: d */
    boolean f5098d;

    /* renamed from: a */
    public abstract boolean mo13364a(JSONObject jSONObject);

    C1816c(boolean z, boolean z2) {
        this.f5096b = z;
        this.f5097c = z2;
        this.f5098d = false;
    }

    C1816c(boolean z, boolean z2, boolean z3) {
        this.f5096b = z;
        this.f5097c = z2;
        this.f5098d = z3;
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Can't wrap try/catch for region: R(10:11|12|13|(4:15|16|17|(2:20|(4:(2:23|24)|25|26|27)))|29|30|(2:32|33)|34|35|36) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:(2:23|24)|25|26|27) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0086 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x009b */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00ae A[Catch:{ all -> 0x00d3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00c8 A[SYNTHETIC, Splitter:B:52:0x00c8] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00cf A[SYNTHETIC, Splitter:B:56:0x00cf] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00d6 A[SYNTHETIC, Splitter:B:62:0x00d6] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00dd A[SYNTHETIC, Splitter:B:66:0x00dd] */
    /* renamed from: a */
    public java.lang.String mo13365a(java.lang.String r7, java.lang.String r8) {
        /*
        r6 = this;
        java.lang.String r0 = android.os.Environment.getExternalStorageState()
        java.lang.String r1 = "mounted"
        boolean r0 = r1.equals(r0)
        if (r0 != 0) goto L_0x000d
        return r8
    L_0x000d:
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.io.File r1 = android.os.Environment.getExternalStorageDirectory()
        java.lang.String r1 = r1.getPath()
        r0.append(r1)
        java.lang.String r1 = "/Android/data/com.snssdk.api.embed/cache"
        r0.append(r1)
        java.lang.String r0 = r0.toString()
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>()
        r1.append(r0)
        java.lang.String r2 = "/"
        r1.append(r2)
        r1.append(r7)
        java.lang.String r7 = r1.toString()
        r1 = 0
        java.io.File r2 = new java.io.File     // Catch:{ IOException -> 0x00a5, all -> 0x00a1 }
        r2.<init>(r0)     // Catch:{ IOException -> 0x00a5, all -> 0x00a1 }
        boolean r0 = r2.exists()     // Catch:{ IOException -> 0x00a5, all -> 0x00a1 }
        if (r0 != 0) goto L_0x004d
        boolean r0 = r2.mkdirs()     // Catch:{ IOException -> 0x00a5, all -> 0x00a1 }
        if (r0 != 0) goto L_0x004d
        return r8
    L_0x004d:
        java.io.File r0 = new java.io.File     // Catch:{ IOException -> 0x00a5, all -> 0x00a1 }
        r0.<init>(r7)     // Catch:{ IOException -> 0x00a5, all -> 0x00a1 }
        java.io.RandomAccessFile r7 = new java.io.RandomAccessFile     // Catch:{ IOException -> 0x00a5, all -> 0x00a1 }
        java.lang.String r2 = "rwd"
        r7.<init>(r0, r2)     // Catch:{ IOException -> 0x00a5, all -> 0x00a1 }
        java.nio.channels.FileChannel r2 = r7.getChannel()     // Catch:{ IOException -> 0x009f }
        java.nio.channels.FileLock r1 = r2.lock()     // Catch:{ IOException -> 0x009f }
        boolean r0 = r0.isFile()     // Catch:{ IOException -> 0x009f }
        java.lang.String r2 = "UTF-8"
        if (r0 == 0) goto L_0x008a
        r0 = 129(0x81, float:1.81E-43)
        byte[] r3 = new byte[r0]     // Catch:{ IOException -> 0x009f }
        r4 = 0
        int r5 = r7.read(r3, r4, r0)     // Catch:{ IOException -> 0x009f }
        if (r5 <= 0) goto L_0x008a
        if (r5 >= r0) goto L_0x008a
        java.lang.String r0 = new java.lang.String     // Catch:{ IOException -> 0x009f }
        r0.<init>(r3, r4, r5, r2)     // Catch:{ IOException -> 0x009f }
        boolean r3 = com.bytedance.embedapplog.p142b.C1822i.m6385d(r0)     // Catch:{ IOException -> 0x009f }
        if (r3 == 0) goto L_0x008a
        if (r1 == 0) goto L_0x0086
        r1.release()     // Catch:{ Exception -> 0x0086 }
    L_0x0086:
        r7.close()     // Catch:{ Exception -> 0x0089 }
    L_0x0089:
        return r0
    L_0x008a:
        byte[] r0 = r8.getBytes(r2)     // Catch:{ IOException -> 0x009f }
        r2 = 0
        r7.setLength(r2)     // Catch:{ IOException -> 0x009f }
        r7.write(r0)     // Catch:{ IOException -> 0x009f }
        if (r1 == 0) goto L_0x009b
        r1.release()     // Catch:{ Exception -> 0x009b }
    L_0x009b:
        r7.close()     // Catch:{ Exception -> 0x009e }
    L_0x009e:
        return r8
    L_0x009f:
        r0 = move-exception
        goto L_0x00a8
    L_0x00a1:
        r7 = move-exception
        r8 = r7
        r7 = r1
        goto L_0x00d4
    L_0x00a5:
        r7 = move-exception
        r0 = r7
        r7 = r1
    L_0x00a8:
        int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x00d3 }
        r3 = 23
        if (r2 < r3) goto L_0x00c6
        com.bytedance.embedapplog.a.e r2 = com.bytedance.embedapplog.p141a.C1805e.m6275b()     // Catch:{ all -> 0x00d3 }
        android.app.Application r2 = r2.f5049a     // Catch:{ all -> 0x00d3 }
        java.lang.String r3 = "android.permission.READ_EXTERNAL_STORAGE"
        int r2 = r2.checkSelfPermission(r3)     // Catch:{ all -> 0x00d3 }
        if (r2 != 0) goto L_0x00c0
        com.bytedance.embedapplog.util.C1856h.m6582a(r0)     // Catch:{ all -> 0x00d3 }
        goto L_0x00c6
    L_0x00c0:
        java.lang.SecurityException r8 = new java.lang.SecurityException     // Catch:{ all -> 0x00d3 }
        r8.<init>(r0)     // Catch:{ all -> 0x00d3 }
        throw r8     // Catch:{ all -> 0x00d3 }
    L_0x00c6:
        if (r1 == 0) goto L_0x00cd
        r1.release()     // Catch:{ Exception -> 0x00cc }
        goto L_0x00cd
    L_0x00cd:
        if (r7 == 0) goto L_0x00d2
        r7.close()     // Catch:{ Exception -> 0x00d2 }
    L_0x00d2:
        return r8
    L_0x00d3:
        r8 = move-exception
    L_0x00d4:
        if (r1 == 0) goto L_0x00db
        r1.release()     // Catch:{ Exception -> 0x00da }
        goto L_0x00db
    L_0x00db:
        if (r7 == 0) goto L_0x00e0
        r7.close()     // Catch:{ Exception -> 0x00e0 }
    L_0x00e0:
        throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.p142b.C1816c.mo13365a(java.lang.String, java.lang.String):java.lang.String");
    }
}
