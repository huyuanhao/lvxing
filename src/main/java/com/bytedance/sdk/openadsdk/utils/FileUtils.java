package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.bytedance.sdk.openadsdk.utils.k */
public class FileUtils {

    /* compiled from: FileUtils */
    /* renamed from: com.bytedance.sdk.openadsdk.utils.k$a */
    private static final class C2556a implements Comparator<File> {
        /* renamed from: a */
        private int m12180a(long j, long j2) {
            int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
            if (i < 0) {
                return -1;
            }
            return i == 0 ? 0 : 1;
        }

        private C2556a() {
        }

        /* renamed from: a */
        public int compare(File file, File file2) {
            return m12180a(file.lastModified(), file2.lastModified());
        }
    }

    /* renamed from: a */
    public static File m12172a(Context context, boolean z, String str, String str2) {
        String a = m12173a(context);
        if (z) {
            StringBuilder sb = new StringBuilder();
            sb.append("/");
            sb.append(C2569z.m12261a(context));
            sb.append("-");
            sb.append(str);
            str = sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(a);
        sb2.append(str);
        String sb3 = sb2.toString();
        File file = new File(sb3);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(sb3, str2);
    }

    /* renamed from: a */
    private static String m12173a(Context context) {
        String str = null;
        if (context == null) {
            return null;
        }
        boolean z = "mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable();
        File externalCacheDir = z ? context.getExternalCacheDir() : null;
        if (externalCacheDir == null) {
            externalCacheDir = context.getCacheDir();
        }
        if (externalCacheDir != null) {
            str = externalCacheDir.getPath();
        }
        return str;
    }

    /* renamed from: a */
    public static List<File> m12174a(File file) {
        LinkedList linkedList = new LinkedList();
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return linkedList;
        }
        List<File> asList = Arrays.asList(listFiles);
        Collections.sort(asList, new C2556a());
        return asList;
    }

    /* renamed from: b */
    public static void m12175b(File file) throws IOException {
        if (file.exists()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!file.setLastModified(currentTimeMillis)) {
                m12178e(file);
                if (file.lastModified() < currentTimeMillis) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Last modified date ");
                    sb.append(new Date(file.lastModified()));
                    sb.append(" is not set for file ");
                    sb.append(file.getAbsolutePath());
                    C2564t.m12225d("Files", sb.toString());
                }
            }
        }
    }

    /* renamed from: c */
    public static void m12176c(File file) {
        if (file != null && file.exists()) {
            if (file.isFile()) {
                try {
                    file.delete();
                } catch (Throwable unused) {
                }
            } else {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length > 0) {
                    for (File file2 : listFiles) {
                        if (file2.isDirectory()) {
                            m12176c(file2);
                        } else {
                            try {
                                file2.delete();
                            } catch (Throwable unused2) {
                            }
                        }
                    }
                }
                file.delete();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002a, code lost:
            if (r3 == null) goto L_0x002f;
     */
    /* renamed from: e */
    private static void m12178e(java.io.File r6) throws java.io.IOException {
        /*
        long r0 = r6.length()
        r2 = 0
        int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
        if (r4 != 0) goto L_0x000e
        m12179f(r6)
        return
    L_0x000e:
        r2 = 0
        java.io.RandomAccessFile r3 = new java.io.RandomAccessFile     // Catch:{ all -> 0x0029 }
        java.lang.String r4 = "rwd"
        r3.<init>(r6, r4)     // Catch:{ all -> 0x0029 }
        r4 = 1
        long r0 = r0 - r4
        r3.seek(r0)     // Catch:{ all -> 0x0027 }
        byte r6 = r3.readByte()     // Catch:{ all -> 0x0027 }
        r3.seek(r0)     // Catch:{ all -> 0x0027 }
        r3.write(r6)     // Catch:{ all -> 0x0027 }
        goto L_0x002c
        goto L_0x002a
    L_0x0029:
        r3 = r2
    L_0x002a:
        if (r3 == 0) goto L_0x002f
    L_0x002c:
        r3.close()
    L_0x002f:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.utils.FileUtils.m12178e(java.io.File):void");
    }

    /* renamed from: f */
    private static void m12179f(File file) throws IOException {
        if (!file.delete() || !file.createNewFile()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Error recreate zero-size file ");
            sb.append(file);
            throw new IOException(sb.toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004a, code lost:
            if (r2 != null) goto L_0x0043;
     */
    /* renamed from: d */
    public static byte[] m12177d(java.io.File r7) {
        /*
        r0 = 0
        if (r7 == 0) goto L_0x004d
        boolean r1 = r7.isFile()
        if (r1 == 0) goto L_0x004d
        boolean r1 = r7.exists()
        if (r1 == 0) goto L_0x004d
        boolean r1 = r7.canRead()
        if (r1 == 0) goto L_0x004d
        long r1 = r7.length()
        r3 = 0
        int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
        if (r5 <= 0) goto L_0x004d
        long r1 = r7.length()     // Catch:{ all -> 0x0049 }
        java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x0049 }
        java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x0049 }
        r2.<init>(r7)     // Catch:{ all -> 0x0049 }
        int r7 = r1.intValue()     // Catch:{ all -> 0x0047 }
        byte[] r7 = new byte[r7]     // Catch:{ all -> 0x0047 }
        int r3 = r2.read(r7)     // Catch:{ all -> 0x0047 }
        long r3 = (long) r3     // Catch:{ all -> 0x0047 }
        long r5 = r1.longValue()     // Catch:{ all -> 0x0047 }
        int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
        if (r1 != 0) goto L_0x0043
        r2.close()     // Catch:{ all -> 0x0042 }
    L_0x0042:
        return r7
    L_0x0043:
        r2.close()     // Catch:{ all -> 0x004d }
        goto L_0x004d
        goto L_0x004a
    L_0x0049:
        r2 = r0
    L_0x004a:
        if (r2 == 0) goto L_0x004d
        goto L_0x0043
    L_0x004d:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.utils.FileUtils.m12177d(java.io.File):byte[]");
    }
}
