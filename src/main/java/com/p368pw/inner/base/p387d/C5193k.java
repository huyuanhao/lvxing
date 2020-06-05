package com.p368pw.inner.base.p387d;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* renamed from: com.pw.inner.base.d.k */
public class C5193k {
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0031 A[SYNTHETIC, Splitter:B:25:0x0031] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x003c A[SYNTHETIC, Splitter:B:31:0x003c] */
    /* renamed from: a */
    public static boolean m21426a(java.io.File r3, java.io.InputStream r4, boolean r5) {
        /*
        r0 = 0
        r1 = 0
        java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x002b }
        r2.<init>(r3, r5)     // Catch:{ Exception -> 0x002b }
        r3 = 1024(0x400, float:1.435E-42)
        byte[] r3 = new byte[r3]     // Catch:{ Exception -> 0x0025, all -> 0x0023 }
    L_0x000b:
        int r5 = r4.read(r3)     // Catch:{ Exception -> 0x0025, all -> 0x0023 }
        r1 = -1
        if (r5 == r1) goto L_0x0016
        r2.write(r3, r0, r5)     // Catch:{ Exception -> 0x0025, all -> 0x0023 }
        goto L_0x000b
    L_0x0016:
        r2.flush()     // Catch:{ Exception -> 0x0025, all -> 0x0023 }
        r3 = 1
        r2.close()     // Catch:{ Exception -> 0x001e }
        goto L_0x0022
    L_0x001e:
        r4 = move-exception
        com.p368pw.inner.base.p387d.C5205o.m21464a(r4)
    L_0x0022:
        return r3
    L_0x0023:
        r3 = move-exception
        goto L_0x003a
    L_0x0025:
        r3 = move-exception
        r1 = r2
        goto L_0x002c
    L_0x0028:
        r3 = move-exception
        r2 = r1
        goto L_0x003a
    L_0x002b:
        r3 = move-exception
    L_0x002c:
        com.p368pw.inner.base.p387d.C5205o.m21464a(r3)     // Catch:{ all -> 0x0028 }
        if (r1 == 0) goto L_0x0039
        r1.close()     // Catch:{ Exception -> 0x0035 }
        goto L_0x0039
    L_0x0035:
        r3 = move-exception
        com.p368pw.inner.base.p387d.C5205o.m21464a(r3)
    L_0x0039:
        return r0
    L_0x003a:
        if (r2 == 0) goto L_0x0044
        r2.close()     // Catch:{ Exception -> 0x0040 }
        goto L_0x0044
    L_0x0040:
        r4 = move-exception
        com.p368pw.inner.base.p387d.C5205o.m21464a(r4)
    L_0x0044:
        throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p368pw.inner.base.p387d.C5193k.m21426a(java.io.File, java.io.InputStream, boolean):boolean");
    }

    /* renamed from: a */
    public static boolean m21427a(File file, String str) {
        if (!(file == null || str == null)) {
            File file2 = new File(str);
            if (file2.exists()) {
                file2.delete();
            }
            try {
                file2.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                FileChannel channel = new FileInputStream(file).getChannel();
                FileChannel channel2 = new FileOutputStream(file2).getChannel();
                channel.transferTo(0, channel.size(), channel2);
                try {
                    channel.close();
                    channel2.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return true;
            } catch (FileNotFoundException e3) {
                e3.printStackTrace();
            } catch (IOException e4) {
                e4.printStackTrace();
                return false;
            }
        }
        return false;
    }
}
