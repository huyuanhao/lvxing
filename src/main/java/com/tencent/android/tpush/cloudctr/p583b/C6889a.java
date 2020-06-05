package com.tencent.android.tpush.cloudctr.p583b;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.cloudctr.b.a */
public class C6889a {
    /* renamed from: a */
    private static String f22949a = "cloudcontrol file util";

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0058 A[Catch:{ Exception -> 0x006d }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x005d A[Catch:{ Exception -> 0x006d }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0064 A[Catch:{ Exception -> 0x006d }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0069 A[Catch:{ Exception -> 0x006d }] */
    /* renamed from: a */
    public static boolean m29429a(java.io.File r10, java.io.File r11) {
        /*
        r0 = 0
        java.io.File r1 = r11.getParentFile()     // Catch:{ Exception -> 0x006d }
        boolean r1 = r1.exists()     // Catch:{ Exception -> 0x006d }
        if (r1 != 0) goto L_0x0012
        java.io.File r1 = r11.getParentFile()     // Catch:{ Exception -> 0x006d }
        r1.mkdirs()     // Catch:{ Exception -> 0x006d }
    L_0x0012:
        boolean r1 = r11.exists()     // Catch:{ Exception -> 0x006d }
        if (r1 != 0) goto L_0x001b
        r11.createNewFile()     // Catch:{ Exception -> 0x006d }
    L_0x001b:
        r1 = 0
        java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0061, all -> 0x0054 }
        r2.<init>(r10)     // Catch:{ IOException -> 0x0061, all -> 0x0054 }
        java.nio.channels.FileChannel r10 = r2.getChannel()     // Catch:{ IOException -> 0x0061, all -> 0x0054 }
        java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0052, all -> 0x004c }
        r2.<init>(r11)     // Catch:{ IOException -> 0x0052, all -> 0x004c }
        java.nio.channels.FileChannel r11 = r2.getChannel()     // Catch:{ IOException -> 0x0052, all -> 0x004c }
        r5 = 0
        long r7 = r10.size()     // Catch:{ IOException -> 0x004a, all -> 0x0045 }
        r3 = r11
        r4 = r10
        r3.transferFrom(r4, r5, r7)     // Catch:{ IOException -> 0x004a, all -> 0x0045 }
        if (r10 == 0) goto L_0x003e
        r10.close()     // Catch:{ Exception -> 0x006d }
    L_0x003e:
        if (r11 == 0) goto L_0x0043
        r11.close()     // Catch:{ Exception -> 0x006d }
    L_0x0043:
        r10 = 1
        return r10
    L_0x0045:
        r1 = move-exception
        r9 = r1
        r1 = r10
        r10 = r9
        goto L_0x0056
    L_0x004a:
        r1 = r11
        goto L_0x0062
    L_0x004c:
        r11 = move-exception
        r9 = r1
        r1 = r10
        r10 = r11
        r11 = r9
        goto L_0x0056
        goto L_0x0062
    L_0x0054:
        r10 = move-exception
        r11 = r1
    L_0x0056:
        if (r1 == 0) goto L_0x005b
        r1.close()     // Catch:{ Exception -> 0x006d }
    L_0x005b:
        if (r11 == 0) goto L_0x0060
        r11.close()     // Catch:{ Exception -> 0x006d }
    L_0x0060:
        throw r10     // Catch:{ Exception -> 0x006d }
    L_0x0061:
        r10 = r1
    L_0x0062:
        if (r10 == 0) goto L_0x0067
        r10.close()     // Catch:{ Exception -> 0x006d }
    L_0x0067:
        if (r1 == 0) goto L_0x006c
        r1.close()     // Catch:{ Exception -> 0x006d }
    L_0x006c:
        return r0
    L_0x006d:
        r10 = move-exception
        java.lang.String r11 = f22949a
        java.lang.String r10 = r10.toString()
        com.tencent.android.tpush.p580b.C6864a.m29308i(r11, r10)
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.cloudctr.p583b.C6889a.m29429a(java.io.File, java.io.File):boolean");
    }
}
