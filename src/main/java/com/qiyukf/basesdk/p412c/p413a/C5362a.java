package com.qiyukf.basesdk.p412c.p413a;

import android.text.TextUtils;
import java.io.File;
import java.io.IOException;

/* renamed from: com.qiyukf.basesdk.c.a.a */
public final class C5362a {
    /* JADX WARNING: Removed duplicated region for block: B:41:0x007f A[SYNTHETIC, Splitter:B:41:0x007f] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0084 A[Catch:{ IOException -> 0x0093 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x008f A[SYNTHETIC, Splitter:B:50:0x008f] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0097 A[Catch:{ IOException -> 0x0093 }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00a4 A[SYNTHETIC, Splitter:B:61:0x00a4] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00ac A[Catch:{ IOException -> 0x00a8 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:38:0x007a=Splitter:B:38:0x007a, B:47:0x008a=Splitter:B:47:0x008a} */
    /* renamed from: a */
    public static long m22018a(java.lang.String r6, java.lang.String r7) {
        /*
        boolean r0 = android.text.TextUtils.isEmpty(r6)
        r1 = -1
        if (r0 != 0) goto L_0x00b4
        boolean r0 = android.text.TextUtils.isEmpty(r7)
        if (r0 == 0) goto L_0x0010
        goto L_0x00b4
    L_0x0010:
        java.io.File r0 = new java.io.File
        r0.<init>(r6)
        boolean r3 = r0.exists()
        if (r3 != 0) goto L_0x001c
        return r1
    L_0x001c:
        boolean r6 = r6.equals(r7)
        if (r6 == 0) goto L_0x0027
        long r6 = r0.length()
        return r6
    L_0x0027:
        r6 = 0
        java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0088, IOException -> 0x0078, all -> 0x0075 }
        r3.<init>(r0)     // Catch:{ FileNotFoundException -> 0x0088, IOException -> 0x0078, all -> 0x0075 }
        java.nio.channels.FileChannel r3 = r3.getChannel()     // Catch:{ FileNotFoundException -> 0x0088, IOException -> 0x0078, all -> 0x0075 }
        java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0071, IOException -> 0x006d, all -> 0x006b }
        java.io.File r7 = m22019a(r7)     // Catch:{ FileNotFoundException -> 0x0071, IOException -> 0x006d, all -> 0x006b }
        r4.<init>(r7)     // Catch:{ FileNotFoundException -> 0x0071, IOException -> 0x006d, all -> 0x006b }
        java.nio.channels.FileChannel r6 = r4.getChannel()     // Catch:{ FileNotFoundException -> 0x0071, IOException -> 0x006d, all -> 0x006b }
        r7 = 4096(0x1000, float:5.74E-42)
        java.nio.ByteBuffer r7 = java.nio.ByteBuffer.allocateDirect(r7)     // Catch:{ FileNotFoundException -> 0x0071, IOException -> 0x006d, all -> 0x006b }
    L_0x0044:
        int r4 = r3.read(r7)     // Catch:{ FileNotFoundException -> 0x0071, IOException -> 0x006d, all -> 0x006b }
        r5 = -1
        if (r4 == r5) goto L_0x0055
        r7.flip()     // Catch:{ FileNotFoundException -> 0x0071, IOException -> 0x006d, all -> 0x006b }
        r6.write(r7)     // Catch:{ FileNotFoundException -> 0x0071, IOException -> 0x006d, all -> 0x006b }
        r7.clear()     // Catch:{ FileNotFoundException -> 0x0071, IOException -> 0x006d, all -> 0x006b }
        goto L_0x0044
    L_0x0055:
        long r0 = r0.length()     // Catch:{ FileNotFoundException -> 0x0071, IOException -> 0x006d, all -> 0x006b }
        if (r3 == 0) goto L_0x0061
        r3.close()     // Catch:{ IOException -> 0x005f }
        goto L_0x0061
    L_0x005f:
        r6 = move-exception
        goto L_0x0067
    L_0x0061:
        if (r6 == 0) goto L_0x006a
        r6.close()     // Catch:{ IOException -> 0x005f }
        goto L_0x006a
    L_0x0067:
        r6.printStackTrace()
    L_0x006a:
        return r0
    L_0x006b:
        r7 = move-exception
        goto L_0x00a2
    L_0x006d:
        r7 = move-exception
        r0 = r6
        r6 = r3
        goto L_0x007a
    L_0x0071:
        r7 = move-exception
        r0 = r6
        r6 = r3
        goto L_0x008a
    L_0x0075:
        r7 = move-exception
        r3 = r6
        goto L_0x00a2
    L_0x0078:
        r7 = move-exception
        r0 = r6
    L_0x007a:
        r7.printStackTrace()     // Catch:{ all -> 0x009f }
        if (r6 == 0) goto L_0x0082
        r6.close()     // Catch:{ IOException -> 0x0093 }
    L_0x0082:
        if (r0 == 0) goto L_0x009e
        r0.close()     // Catch:{ IOException -> 0x0093 }
        goto L_0x009e
    L_0x0088:
        r7 = move-exception
        r0 = r6
    L_0x008a:
        r7.printStackTrace()     // Catch:{ all -> 0x009f }
        if (r6 == 0) goto L_0x0095
        r6.close()     // Catch:{ IOException -> 0x0093 }
        goto L_0x0095
    L_0x0093:
        r6 = move-exception
        goto L_0x009b
    L_0x0095:
        if (r0 == 0) goto L_0x009e
        r0.close()     // Catch:{ IOException -> 0x0093 }
        goto L_0x009e
    L_0x009b:
        r6.printStackTrace()
    L_0x009e:
        return r1
    L_0x009f:
        r7 = move-exception
        r3 = r6
        r6 = r0
    L_0x00a2:
        if (r3 == 0) goto L_0x00aa
        r3.close()     // Catch:{ IOException -> 0x00a8 }
        goto L_0x00aa
    L_0x00a8:
        r6 = move-exception
        goto L_0x00b0
    L_0x00aa:
        if (r6 == 0) goto L_0x00b3
        r6.close()     // Catch:{ IOException -> 0x00a8 }
        goto L_0x00b3
    L_0x00b0:
        r6.printStackTrace()
    L_0x00b3:
        throw r7
    L_0x00b4:
        return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.basesdk.p412c.p413a.C5362a.m22018a(java.lang.String, java.lang.String):long");
    }

    /* renamed from: a */
    public static File m22019a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        try {
            file.createNewFile();
            return file;
        } catch (IOException unused) {
            if (file.exists()) {
                file.delete();
            }
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x002c A[SYNTHETIC, Splitter:B:19:0x002c] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0036 A[SYNTHETIC, Splitter:B:27:0x0036] */
    /* renamed from: a */
    public static boolean m22020a(android.graphics.Bitmap r3, java.lang.String r4) {
        /*
        r0 = 0
        if (r3 == 0) goto L_0x003c
        boolean r1 = android.text.TextUtils.isEmpty(r4)
        if (r1 == 0) goto L_0x000a
        goto L_0x003c
    L_0x000a:
        r1 = 0
        java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0033, all -> 0x0029 }
        r2.<init>(r4)     // Catch:{ FileNotFoundException -> 0x0033, all -> 0x0029 }
        java.io.BufferedOutputStream r4 = new java.io.BufferedOutputStream     // Catch:{ FileNotFoundException -> 0x0033, all -> 0x0029 }
        r4.<init>(r2)     // Catch:{ FileNotFoundException -> 0x0033, all -> 0x0029 }
        android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ FileNotFoundException -> 0x0027, all -> 0x0024 }
        r2 = 80
        r3.compress(r1, r2, r4)     // Catch:{ FileNotFoundException -> 0x0027, all -> 0x0024 }
        r4.close()     // Catch:{ IOException -> 0x001f }
    L_0x001f:
        r3.recycle()
        r3 = 1
        return r3
    L_0x0024:
        r0 = move-exception
        r1 = r4
        goto L_0x002a
        goto L_0x0034
    L_0x0029:
        r0 = move-exception
    L_0x002a:
        if (r1 == 0) goto L_0x002f
        r1.close()     // Catch:{ IOException -> 0x002f }
    L_0x002f:
        r3.recycle()
        throw r0
    L_0x0033:
        r4 = r1
    L_0x0034:
        if (r4 == 0) goto L_0x0039
        r4.close()     // Catch:{ IOException -> 0x0039 }
    L_0x0039:
        r3.recycle()
    L_0x003c:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.basesdk.p412c.p413a.C5362a.m22020a(android.graphics.Bitmap, java.lang.String):boolean");
    }

    /* renamed from: b */
    public static boolean m22021b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(file.getParent());
        sb.append("/");
        sb.append(System.currentTimeMillis());
        sb.append("_tmp");
        File file2 = new File(sb.toString());
        if (file.renameTo(file2)) {
            file = file2;
        }
        return file.delete();
    }
}
