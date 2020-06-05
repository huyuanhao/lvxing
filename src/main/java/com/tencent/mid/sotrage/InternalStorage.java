package com.tencent.mid.sotrage;

import android.content.Context;
import android.os.Environment;
import com.tencent.mid.core.Constants;
import com.tencent.mid.util.Logger;
import com.tencent.mid.util.Util;

public class InternalStorage extends StorageInterface {
    public int getType() {
        return 2;
    }

    /* access modifiers changed from: protected */
    public CheckEntity readCheckEntityIner() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void writeCheckEntityIner(CheckEntity checkEntity) {
    }

    public InternalStorage(Context context, int i) {
        super(context, i);
    }

    /* access modifiers changed from: protected */
    public boolean checkPermission() {
        boolean z = false;
        try {
            if (Util.checkPermission(this.context, Constants.PERMISSION_WRITE_EXTERNAL_STORAGE) && "mounted".equals(Environment.getExternalStorageState())) {
                z = true;
            }
            return z;
        } catch (Throwable th) {
            Logger logger = logger;
            StringBuilder sb = new StringBuilder();
            sb.append("checkPermission ");
            sb.append(th);
            logger.mo35700i(sb.toString());
            return false;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:1|2|3|4|5|(2:6|(2:8|(1:20)(3:21|12|13))(0))|14|15) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x005d */
    public java.lang.String read() {
        /*
        r6 = this;
        monitor-enter(r6)
        com.tencent.mid.util.Logger r0 = logger     // Catch:{ all -> 0x005f }
        java.lang.String r1 = "read mid from InternalStorage  version code = 4.07"
        r0.mo35700i(r1)     // Catch:{ all -> 0x005f }
        java.io.File r0 = new java.io.File     // Catch:{ all -> 0x005f }
        java.io.File r1 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ all -> 0x005f }
        java.lang.String r2 = r6.getMidFilePath()     // Catch:{ all -> 0x005f }
        r0.<init>(r1, r2)     // Catch:{ all -> 0x005f }
        r1 = 0
        java.util.List r0 = com.tencent.mid.sotrage.FileHelper.readEntireFileLines(r0)     // Catch:{ IOException -> 0x005d }
        java.util.Iterator r0 = r0.iterator()     // Catch:{ IOException -> 0x005d }
    L_0x001e:
        boolean r2 = r0.hasNext()     // Catch:{ IOException -> 0x005d }
        if (r2 == 0) goto L_0x005d
        java.lang.Object r2 = r0.next()     // Catch:{ IOException -> 0x005d }
        java.lang.String r2 = (java.lang.String) r2     // Catch:{ IOException -> 0x005d }
        java.lang.String r3 = ","
        java.lang.String[] r2 = r2.split(r3)     // Catch:{ IOException -> 0x005d }
        int r3 = r2.length     // Catch:{ IOException -> 0x005d }
        r4 = 2
        if (r3 != r4) goto L_0x001e
        r3 = 0
        r3 = r2[r3]     // Catch:{ IOException -> 0x005d }
        java.lang.String r4 = r6.getStorageKey()     // Catch:{ IOException -> 0x005d }
        boolean r3 = r3.equals(r4)     // Catch:{ IOException -> 0x005d }
        if (r3 == 0) goto L_0x001e
        com.tencent.mid.util.Logger r0 = logger     // Catch:{ IOException -> 0x005d }
        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x005d }
        r3.<init>()     // Catch:{ IOException -> 0x005d }
        java.lang.String r4 = "read mid from InternalStorage:"
        r3.append(r4)     // Catch:{ IOException -> 0x005d }
        r4 = 1
        r5 = r2[r4]     // Catch:{ IOException -> 0x005d }
        r3.append(r5)     // Catch:{ IOException -> 0x005d }
        java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x005d }
        r0.mo35700i(r3)     // Catch:{ IOException -> 0x005d }
        r0 = r2[r4]     // Catch:{ IOException -> 0x005d }
        r1 = r0
    L_0x005d:
        monitor-exit(r6)     // Catch:{ all -> 0x005f }
        return r1
    L_0x005f:
        r0 = move-exception
        monitor-exit(r6)     // Catch:{ all -> 0x005f }
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mid.sotrage.InternalStorage.read():java.lang.String");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:10|(0)|17|18) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x006e */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x006b A[SYNTHETIC, Splitter:B:15:0x006b] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0072 A[Catch:{ IOException -> 0x006f, all -> 0x0067 }] */
    public void write(java.lang.String r4) {
        /*
        r3 = this;
        monitor-enter(r3)
        com.tencent.mid.util.Logger r0 = logger     // Catch:{ all -> 0x0075 }
        java.lang.String r1 = "write mid to InternalStorage"
        r0.mo35700i(r1)     // Catch:{ all -> 0x0075 }
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0075 }
        r0.<init>()     // Catch:{ all -> 0x0075 }
        java.io.File r1 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ all -> 0x0075 }
        r0.append(r1)     // Catch:{ all -> 0x0075 }
        java.lang.String r1 = "/"
        r0.append(r1)     // Catch:{ all -> 0x0075 }
        java.lang.String r1 = r3.getMidDir()     // Catch:{ all -> 0x0075 }
        r0.append(r1)     // Catch:{ all -> 0x0075 }
        java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0075 }
        com.tencent.mid.sotrage.FileHelper.createDir(r0)     // Catch:{ all -> 0x0075 }
        java.io.File r0 = new java.io.File     // Catch:{ all -> 0x0075 }
        java.io.File r1 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ all -> 0x0075 }
        java.lang.String r2 = r3.getMidFilePath()     // Catch:{ all -> 0x0075 }
        r0.<init>(r1, r2)     // Catch:{ all -> 0x0075 }
        r1 = 0
        java.io.FileWriter r2 = new java.io.FileWriter     // Catch:{ IOException -> 0x006f, all -> 0x0067 }
        r2.<init>(r0)     // Catch:{ IOException -> 0x006f, all -> 0x0067 }
        java.io.BufferedWriter r0 = new java.io.BufferedWriter     // Catch:{ IOException -> 0x006f, all -> 0x0067 }
        r0.<init>(r2)     // Catch:{ IOException -> 0x006f, all -> 0x0067 }
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0065, all -> 0x0063 }
        r1.<init>()     // Catch:{ IOException -> 0x0065, all -> 0x0063 }
        java.lang.String r2 = r3.getStorageKey()     // Catch:{ IOException -> 0x0065, all -> 0x0063 }
        r1.append(r2)     // Catch:{ IOException -> 0x0065, all -> 0x0063 }
        java.lang.String r2 = ","
        r1.append(r2)     // Catch:{ IOException -> 0x0065, all -> 0x0063 }
        r1.append(r4)     // Catch:{ IOException -> 0x0065, all -> 0x0063 }
        java.lang.String r4 = r1.toString()     // Catch:{ IOException -> 0x0065, all -> 0x0063 }
        r0.write(r4)     // Catch:{ IOException -> 0x0065, all -> 0x0063 }
        java.lang.String r4 = "\n"
        r0.write(r4)     // Catch:{ IOException -> 0x0065, all -> 0x0063 }
    L_0x005f:
        r0.close()     // Catch:{ Exception -> 0x0073 }
        goto L_0x0073
    L_0x0063:
        r4 = move-exception
        goto L_0x0069
        goto L_0x0070
    L_0x0067:
        r4 = move-exception
        r0 = r1
    L_0x0069:
        if (r0 == 0) goto L_0x006e
        r0.close()     // Catch:{ Exception -> 0x006e }
    L_0x006e:
        throw r4     // Catch:{ all -> 0x0075 }
    L_0x006f:
        r0 = r1
    L_0x0070:
        if (r0 == 0) goto L_0x0073
        goto L_0x005f
    L_0x0073:
        monitor-exit(r3)     // Catch:{ all -> 0x0075 }
        return
    L_0x0075:
        r4 = move-exception
        monitor-exit(r3)     // Catch:{ all -> 0x0075 }
        throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mid.sotrage.InternalStorage.write(java.lang.String):void");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:11|12|(0)|19|20) */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:1|2|3|4|5|6|(4:7|8|9|10)|25|26) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0055 */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004b A[SYNTHETIC, Splitter:B:17:0x004b] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0052 A[SYNTHETIC, Splitter:B:23:0x0052] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:25:0x0055=Splitter:B:25:0x0055, B:19:0x004e=Splitter:B:19:0x004e} */
    public void clear() {
        /*
        r4 = this;
        monitor-enter(r4)
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0057 }
        r0.<init>()     // Catch:{ all -> 0x0057 }
        java.io.File r1 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ all -> 0x0057 }
        r0.append(r1)     // Catch:{ all -> 0x0057 }
        java.lang.String r1 = "/"
        r0.append(r1)     // Catch:{ all -> 0x0057 }
        java.lang.String r1 = r4.getMidDir()     // Catch:{ all -> 0x0057 }
        r0.append(r1)     // Catch:{ all -> 0x0057 }
        java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0057 }
        com.tencent.mid.sotrage.FileHelper.createDir(r0)     // Catch:{ all -> 0x0057 }
        java.io.File r0 = new java.io.File     // Catch:{ all -> 0x0057 }
        java.io.File r1 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ all -> 0x0057 }
        java.lang.String r2 = r4.getMidFilePath()     // Catch:{ all -> 0x0057 }
        r0.<init>(r1, r2)     // Catch:{ all -> 0x0057 }
        r1 = 0
        java.io.FileWriter r2 = new java.io.FileWriter     // Catch:{ IOException -> 0x004f, all -> 0x0048 }
        r2.<init>(r0)     // Catch:{ IOException -> 0x004f, all -> 0x0048 }
        java.io.BufferedWriter r0 = new java.io.BufferedWriter     // Catch:{ IOException -> 0x004f, all -> 0x0048 }
        r0.<init>(r2)     // Catch:{ IOException -> 0x004f, all -> 0x0048 }
        java.lang.String r1 = ""
        r0.write(r1)     // Catch:{ IOException -> 0x0046, all -> 0x0041 }
        r0.close()     // Catch:{ Exception -> 0x0055 }
        goto L_0x0055
    L_0x0041:
        r1 = move-exception
        r3 = r1
        r1 = r0
        r0 = r3
        goto L_0x0049
    L_0x0046:
        r1 = r0
        goto L_0x0050
    L_0x0048:
        r0 = move-exception
    L_0x0049:
        if (r1 == 0) goto L_0x004e
        r1.close()     // Catch:{ Exception -> 0x004e }
    L_0x004e:
        throw r0     // Catch:{ all -> 0x0057 }
    L_0x0050:
        if (r1 == 0) goto L_0x0055
        r1.close()     // Catch:{ Exception -> 0x0055 }
    L_0x0055:
        monitor-exit(r4)     // Catch:{ all -> 0x0057 }
        return
    L_0x0057:
        r0 = move-exception
        monitor-exit(r4)     // Catch:{ all -> 0x0057 }
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mid.sotrage.InternalStorage.clear():void");
    }
}
