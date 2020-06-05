package com.tencent.p605ep.commonbase.apkparser;

import com.tencent.p605ep.commonbase.api.Log;

/* renamed from: com.tencent.ep.commonbase.apkparser.b */
public final class C7296b {
    /* renamed from: b */
    private static final String f24740b = "ZipChecker";
    /* renamed from: a */
    private byte[] f24741a = new byte[16384];

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0021  */
    /* renamed from: a */
    private void m31516a(java.util.zip.ZipFile r1, java.util.zip.ZipEntry r2, boolean r3) {
        /*
        r0 = this;
        java.io.InputStream r1 = r1.getInputStream(r2)     // Catch:{ all -> 0x001d }
        if (r3 == 0) goto L_0x0010
    L_0x0006:
        r2 = -1
        byte[] r3 = r0.f24741a     // Catch:{ all -> 0x001b }
        int r3 = r1.read(r3)     // Catch:{ all -> 0x001b }
        if (r2 == r3) goto L_0x0015
        goto L_0x0006
    L_0x0010:
        byte[] r2 = r0.f24741a     // Catch:{ all -> 0x001b }
        r1.read(r2)     // Catch:{ all -> 0x001b }
    L_0x0015:
        if (r1 == 0) goto L_0x001a
        r1.close()
    L_0x001a:
        return
    L_0x001b:
        r2 = move-exception
        goto L_0x001f
    L_0x001d:
        r2 = move-exception
        r1 = 0
    L_0x001f:
        if (r1 == 0) goto L_0x0024
        r1.close()
    L_0x0024:
        throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.p605ep.commonbase.apkparser.C7296b.m31516a(java.util.zip.ZipFile, java.util.zip.ZipEntry, boolean):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x00b1  */
    /* renamed from: b */
    private void m31517b(java.lang.String r18) {
        /*
        r17 = this;
        r1 = r17
        r0 = r18
        java.io.File r2 = new java.io.File     // Catch:{ all -> 0x00ad }
        r2.<init>(r0)     // Catch:{ all -> 0x00ad }
        long r2 = r2.length()     // Catch:{ all -> 0x00ad }
        java.util.zip.ZipFile r4 = new java.util.zip.ZipFile     // Catch:{ all -> 0x00ad }
        r4.<init>(r0)     // Catch:{ all -> 0x00ad }
        java.util.Enumeration r0 = r4.entries()     // Catch:{ all -> 0x00ab }
        r5 = 0
        r6 = 0
        r7 = 0
    L_0x0019:
        boolean r8 = r0.hasMoreElements()     // Catch:{ all -> 0x00ab }
        if (r8 == 0) goto L_0x00a7
        java.lang.Object r8 = r0.nextElement()     // Catch:{ all -> 0x00ab }
        java.util.zip.ZipEntry r8 = (java.util.zip.ZipEntry) r8     // Catch:{ all -> 0x00ab }
        boolean r9 = r8.isDirectory()     // Catch:{ all -> 0x00ab }
        if (r9 == 0) goto L_0x002c
        goto L_0x0019
    L_0x002c:
        java.lang.String r9 = r8.getName()     // Catch:{ all -> 0x00ab }
        java.lang.String r10 = "../"
        boolean r9 = r9.contains(r10)     // Catch:{ all -> 0x00ab }
        if (r9 == 0) goto L_0x0039
        goto L_0x0019
    L_0x0039:
        long r9 = r8.getCompressedSize()     // Catch:{ all -> 0x00ab }
        long r11 = r8.getSize()     // Catch:{ all -> 0x00ab }
        r13 = -1
        int r15 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
        if (r15 < 0) goto L_0x009f
        int r15 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
        if (r15 > 0) goto L_0x009f
        int r15 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
        if (r15 < 0) goto L_0x009f
        r13 = 1500(0x5dc, double:7.41E-321)
        long r13 = r13 * r9
        int r15 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
        if (r15 > 0) goto L_0x009f
        java.lang.String r13 = r8.getName()     // Catch:{ all -> 0x00ab }
        r14 = 1
        if (r13 == 0) goto L_0x0081
        java.lang.String r13 = r8.getName()     // Catch:{ all -> 0x00ab }
        java.lang.String r15 = "AndroidManifest.xml"
        boolean r13 = r13.contains(r15)     // Catch:{ all -> 0x00ab }
        if (r13 == 0) goto L_0x0081
        r15 = 0
        int r7 = (r9 > r15 ? 1 : (r9 == r15 ? 0 : -1))
        if (r7 == 0) goto L_0x0079
        int r7 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
        if (r7 == 0) goto L_0x0079
        r1.m31516a(r4, r8, r14)     // Catch:{ all -> 0x00ab }
        r7 = 1
        goto L_0x0097
    L_0x0079:
        java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ all -> 0x00ab }
        java.lang.String r2 = "Invalid AndroidManifest!"
        r0.<init>(r2)     // Catch:{ all -> 0x00ab }
        throw r0     // Catch:{ all -> 0x00ab }
    L_0x0081:
        java.lang.String r9 = r8.getName()     // Catch:{ all -> 0x00ab }
        if (r9 == 0) goto L_0x0097
        java.lang.String r9 = r8.getName()     // Catch:{ all -> 0x00ab }
        java.lang.String r10 = "classes.dex"
        boolean r9 = r9.contains(r10)     // Catch:{ all -> 0x00ab }
        if (r9 == 0) goto L_0x0097
        r1.m31516a(r4, r8, r5)     // Catch:{ all -> 0x00ab }
        r6 = 1
    L_0x0097:
        if (r6 == 0) goto L_0x0019
        if (r7 == 0) goto L_0x0019
        r4.close()
        return
    L_0x009f:
        java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ all -> 0x00ab }
        java.lang.String r2 = "Invalid entry size!"
        r0.<init>(r2)     // Catch:{ all -> 0x00ab }
        throw r0     // Catch:{ all -> 0x00ab }
    L_0x00a7:
        r4.close()
        return
    L_0x00ab:
        r0 = move-exception
        goto L_0x00af
    L_0x00ad:
        r0 = move-exception
        r4 = 0
    L_0x00af:
        if (r4 == 0) goto L_0x00b4
        r4.close()
    L_0x00b4:
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.p605ep.commonbase.apkparser.C7296b.m31517b(java.lang.String):void");
    }

    /* renamed from: a */
    public synchronized boolean mo35378a(String str) {
        boolean z;
        try {
            m31517b(str);
            z = true;
        } catch (Throwable th) {
            Log.m31480e(f24740b, "check", th);
            z = false;
        }
        return z;
    }
}
