package com.tencent.p605ep.commonbase.api;

import android.util.Log;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/* renamed from: com.tencent.ep.commonbase.api.LogImpl */
class LogImpl extends AbstractLog {
    LogImpl() {
    }

    public void println(int i, String str, String str2) {
        if (str2 == null) {
            str2 = "(null)";
        }
        if (i == 10) {
            super.mo35332d(str, str2);
            String format = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(new Date(System.currentTimeMillis()));
            StringBuilder sb = new StringBuilder();
            sb.append("/sdcard/ep_debug_");
            sb.append(str);
            File file = new File(sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(format);
            String str3 = " ";
            sb2.append(str3);
            sb2.append(str);
            sb2.append(str3);
            sb2.append(str2);
            sb2.append("\n");
            writeLog(file, sb2.toString());
            return;
        }
        Log.println(i, str, str2);
    }

    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v1, types: [java.io.FileOutputStream] */
    /* JADX WARNING: type inference failed for: r1v1 */
    /* JADX WARNING: type inference failed for: r2v2 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v8, types: [java.io.FileOutputStream] */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v11 */
    /* JADX WARNING: type inference failed for: r1v16 */
    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: type inference failed for: r1v17 */
    /* JADX WARNING: type inference failed for: r1v18 */
    /* JADX WARNING: type inference failed for: r1v19 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e A[Catch:{ FileNotFoundException -> 0x005c, IOException -> 0x004f, Exception -> 0x0042, all -> 0x0040, all -> 0x006d }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x005b A[Catch:{ FileNotFoundException -> 0x005c, IOException -> 0x004f, Exception -> 0x0042, all -> 0x0040, all -> 0x006d }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0071 A[SYNTHETIC, Splitter:B:39:0x0071] */
    /* JADX WARNING: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 5 */
    public void writeLog(java.io.File r5, java.lang.String r6) {
        /*
        r4 = this;
        java.lang.String r0 = "ep-commonbase"
        java.lang.String r1 = "mounted"
        r2 = 0
        java.lang.String r3 = android.os.Environment.getExternalStorageState()     // Catch:{ FileNotFoundException -> 0x005c, IOException -> 0x004f, Exception -> 0x0042, all -> 0x0040 }
        boolean r1 = r1.equals(r3)     // Catch:{ FileNotFoundException -> 0x005c, IOException -> 0x004f, Exception -> 0x0042, all -> 0x0040 }
        if (r1 == 0) goto L_0x0037
        boolean r1 = r5.exists()     // Catch:{ FileNotFoundException -> 0x005c, IOException -> 0x004f, Exception -> 0x0042, all -> 0x0040 }
        if (r1 != 0) goto L_0x0023
        java.io.File r1 = r5.getAbsoluteFile()     // Catch:{ FileNotFoundException -> 0x005c, IOException -> 0x004f, Exception -> 0x0042, all -> 0x0040 }
        java.io.File r1 = r1.getParentFile()     // Catch:{ FileNotFoundException -> 0x005c, IOException -> 0x004f, Exception -> 0x0042, all -> 0x0040 }
        r1.mkdirs()     // Catch:{ FileNotFoundException -> 0x005c, IOException -> 0x004f, Exception -> 0x0042, all -> 0x0040 }
        r5.createNewFile()     // Catch:{ FileNotFoundException -> 0x005c, IOException -> 0x004f, Exception -> 0x0042, all -> 0x0040 }
    L_0x0023:
        java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x005c, IOException -> 0x004f, Exception -> 0x0042, all -> 0x0040 }
        r3 = 1
        r1.<init>(r5, r3)     // Catch:{ FileNotFoundException -> 0x005c, IOException -> 0x004f, Exception -> 0x0042, all -> 0x0040 }
        byte[] r5 = r6.getBytes()     // Catch:{ FileNotFoundException -> 0x0035, IOException -> 0x0033, Exception -> 0x0031 }
        r1.write(r5)     // Catch:{ FileNotFoundException -> 0x0035, IOException -> 0x0033, Exception -> 0x0031 }
        goto L_0x0038
    L_0x0031:
        r5 = move-exception
        goto L_0x0044
    L_0x0033:
        r5 = move-exception
        goto L_0x0051
    L_0x0035:
        r5 = move-exception
        goto L_0x005e
    L_0x0037:
        r1 = r2
    L_0x0038:
        if (r1 == 0) goto L_0x006c
    L_0x003a:
        r1.close()     // Catch:{ IOException -> 0x003e }
        goto L_0x006c
    L_0x003e:
        r5 = move-exception
        goto L_0x0069
    L_0x0040:
        r5 = move-exception
        goto L_0x006f
    L_0x0042:
        r5 = move-exception
        r1 = r2
    L_0x0044:
        java.lang.String r6 = "runtime error"
        android.util.Log.e(r0, r6)     // Catch:{ all -> 0x006d }
        r5.printStackTrace()     // Catch:{ all -> 0x006d }
        if (r1 == 0) goto L_0x006c
        goto L_0x003a
    L_0x004f:
        r5 = move-exception
        r1 = r2
    L_0x0051:
        java.lang.String r6 = "io exception"
        android.util.Log.e(r0, r6)     // Catch:{ all -> 0x006d }
        r5.printStackTrace()     // Catch:{ all -> 0x006d }
        if (r1 == 0) goto L_0x006c
        goto L_0x003a
    L_0x005c:
        r5 = move-exception
        r1 = r2
    L_0x005e:
        java.lang.String r6 = "file not found"
        android.util.Log.e(r0, r6)     // Catch:{ all -> 0x006d }
        r5.printStackTrace()     // Catch:{ all -> 0x006d }
        if (r1 == 0) goto L_0x006c
        goto L_0x003a
    L_0x0069:
        r5.printStackTrace()
    L_0x006c:
        return
    L_0x006d:
        r5 = move-exception
        r2 = r1
    L_0x006f:
        if (r2 == 0) goto L_0x0079
        r2.close()     // Catch:{ IOException -> 0x0075 }
        goto L_0x0079
    L_0x0075:
        r6 = move-exception
        r6.printStackTrace()
    L_0x0079:
        throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.p605ep.commonbase.api.LogImpl.writeLog(java.io.File, java.lang.String):void");
    }
}
