package com.alibaba.mtl.log.p077d;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* renamed from: com.alibaba.mtl.log.d.k */
public class MutiProcessLock {
    /* renamed from: a */
    static File f3408a;
    /* renamed from: b */
    static FileChannel f3409b;
    /* renamed from: c */
    static FileLock f3410c;

    /* renamed from: a */
    public static synchronized boolean m3842a(Context context) {
        FileLock fileLock;
        synchronized (MutiProcessLock.class) {
            if (f3408a == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(context.getFilesDir());
                sb.append(File.separator);
                sb.append("ap.Lock");
                f3408a = new File(sb.toString());
            }
            boolean exists = f3408a.exists();
            if (!exists) {
                try {
                    exists = f3408a.createNewFile();
                } catch (IOException unused) {
                }
            }
            if (!exists) {
                return true;
            }
            if (f3409b == null) {
                try {
                    f3409b = new RandomAccessFile(f3408a, "rw").getChannel();
                } catch (Exception unused2) {
                    return false;
                }
            }
            try {
                fileLock = f3409b.tryLock();
                if (fileLock != null) {
                    f3410c = fileLock;
                    return true;
                }
            } catch (Throwable unused3) {
                fileLock = null;
            }
            String str = "TAG";
            StringBuilder sb2 = new StringBuilder();
            sb2.append("mLock:");
            sb2.append(fileLock);
            Log.d(str, sb2.toString());
            return false;
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x001d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x000d */
    /* renamed from: a */
    public static synchronized void m3841a() {
        /*
        java.lang.Class<com.alibaba.mtl.log.d.k> r0 = com.alibaba.mtl.log.p077d.MutiProcessLock.class
        monitor-enter(r0)
        java.nio.channels.FileLock r1 = f3410c     // Catch:{ all -> 0x0026 }
        r2 = 0
        if (r1 == 0) goto L_0x0014
        java.nio.channels.FileLock r1 = f3410c     // Catch:{ IOException -> 0x000d, all -> 0x0010 }
        r1.release()     // Catch:{ IOException -> 0x000d, all -> 0x0010 }
    L_0x000d:
        f3410c = r2     // Catch:{ all -> 0x0026 }
        goto L_0x0014
    L_0x0010:
        r1 = move-exception
        f3410c = r2     // Catch:{ all -> 0x0026 }
        throw r1     // Catch:{ all -> 0x0026 }
    L_0x0014:
        java.nio.channels.FileChannel r1 = f3409b     // Catch:{ all -> 0x0026 }
        if (r1 == 0) goto L_0x0024
        java.nio.channels.FileChannel r1 = f3409b     // Catch:{ Exception -> 0x001d, all -> 0x0020 }
        r1.close()     // Catch:{ Exception -> 0x001d, all -> 0x0020 }
    L_0x001d:
        f3409b = r2     // Catch:{ all -> 0x0026 }
        goto L_0x0024
    L_0x0020:
        r1 = move-exception
        f3409b = r2     // Catch:{ all -> 0x0026 }
        throw r1     // Catch:{ all -> 0x0026 }
    L_0x0024:
        monitor-exit(r0)
        return
    L_0x0026:
        r1 = move-exception
        monitor-exit(r0)
        throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.p077d.MutiProcessLock.m3841a():void");
    }
}
