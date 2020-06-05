package com.tencent.p605ep.commonbase.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/* renamed from: com.tencent.ep.commonbase.utils.ZipUtils */
public class ZipUtils {
    private static final int CACHE_SIZE = 1024;
    public static final String TAG = "ZipUtils";

    public static boolean checkValidZipFiles(List<File> list) {
        for (File verifyZipFile : list) {
            if (!verifyZipFile(verifyZipFile)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x0079 A[SYNTHETIC, Splitter:B:57:0x0079] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0083 A[SYNTHETIC, Splitter:B:62:0x0083] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x008d A[SYNTHETIC, Splitter:B:67:0x008d] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x00ad A[SYNTHETIC, Splitter:B:84:0x00ad] */
    public static boolean extractFile(java.io.File r8, java.lang.String r9, java.io.File r10) {
        /*
        r0 = 0
        r1 = 0
        java.util.zip.ZipFile r2 = new java.util.zip.ZipFile     // Catch:{ all -> 0x0070 }
        r2.<init>(r8)     // Catch:{ all -> 0x0070 }
        java.util.zip.ZipEntry r8 = r2.getEntry(r9)     // Catch:{ all -> 0x006c }
        if (r8 == 0) goto L_0x0052
        java.io.InputStream r8 = r2.getInputStream(r8)     // Catch:{ all -> 0x006c }
        java.io.FileOutputStream r9 = new java.io.FileOutputStream     // Catch:{ all -> 0x004f }
        r9.<init>(r10)     // Catch:{ all -> 0x004f }
        r1 = 1024(0x400, float:1.435E-42)
        byte[] r1 = new byte[r1]     // Catch:{ all -> 0x004c }
        r3 = 0
    L_0x001b:
        int r4 = r8.read(r1)     // Catch:{ all -> 0x004c }
        r5 = -1
        if (r4 == r5) goto L_0x0027
        r9.write(r1, r0, r4)     // Catch:{ all -> 0x004c }
        int r3 = r3 + r4
        goto L_0x001b
    L_0x0027:
        long r4 = r10.length()     // Catch:{ all -> 0x004c }
        long r6 = (long) r3
        int r10 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
        if (r10 != 0) goto L_0x0054
        r10 = 1
        r2.close()     // Catch:{ all -> 0x0035 }
        goto L_0x0039
    L_0x0035:
        r0 = move-exception
        r0.printStackTrace()
    L_0x0039:
        if (r8 == 0) goto L_0x0043
        r8.close()     // Catch:{ all -> 0x003f }
        goto L_0x0043
    L_0x003f:
        r8 = move-exception
        r8.printStackTrace()
    L_0x0043:
        r9.close()     // Catch:{ all -> 0x0047 }
        goto L_0x004b
    L_0x0047:
        r8 = move-exception
        r8.printStackTrace()
    L_0x004b:
        return r10
    L_0x004c:
        r10 = move-exception
        r1 = r9
        goto L_0x0074
    L_0x004f:
        r9 = move-exception
        r10 = r9
        goto L_0x0074
    L_0x0052:
        r8 = r1
        r9 = r8
    L_0x0054:
        r2.close()     // Catch:{ all -> 0x0058 }
        goto L_0x005c
    L_0x0058:
        r10 = move-exception
        r10.printStackTrace()
    L_0x005c:
        if (r8 == 0) goto L_0x0066
        r8.close()     // Catch:{ all -> 0x0062 }
        goto L_0x0066
    L_0x0062:
        r8 = move-exception
        r8.printStackTrace()
    L_0x0066:
        if (r9 == 0) goto L_0x0095
        r9.close()     // Catch:{ all -> 0x0091 }
        goto L_0x0095
    L_0x006c:
        r8 = move-exception
        r10 = r8
        r8 = r1
        goto L_0x0074
    L_0x0070:
        r8 = move-exception
        r10 = r8
        r8 = r1
        r2 = r8
    L_0x0074:
        r10.printStackTrace()     // Catch:{ all -> 0x0096 }
        if (r2 == 0) goto L_0x0081
        r2.close()     // Catch:{ all -> 0x007d }
        goto L_0x0081
    L_0x007d:
        r9 = move-exception
        r9.printStackTrace()
    L_0x0081:
        if (r8 == 0) goto L_0x008b
        r8.close()     // Catch:{ all -> 0x0087 }
        goto L_0x008b
    L_0x0087:
        r8 = move-exception
        r8.printStackTrace()
    L_0x008b:
        if (r1 == 0) goto L_0x0095
        r1.close()     // Catch:{ all -> 0x0091 }
        goto L_0x0095
    L_0x0091:
        r8 = move-exception
        r8.printStackTrace()
    L_0x0095:
        return r0
    L_0x0096:
        r9 = move-exception
        if (r2 == 0) goto L_0x00a1
        r2.close()     // Catch:{ all -> 0x009d }
        goto L_0x00a1
    L_0x009d:
        r10 = move-exception
        r10.printStackTrace()
    L_0x00a1:
        if (r8 == 0) goto L_0x00ab
        r8.close()     // Catch:{ all -> 0x00a7 }
        goto L_0x00ab
    L_0x00a7:
        r8 = move-exception
        r8.printStackTrace()
    L_0x00ab:
        if (r1 == 0) goto L_0x00b5
        r1.close()     // Catch:{ all -> 0x00b1 }
        goto L_0x00b5
    L_0x00b1:
        r8 = move-exception
        r8.printStackTrace()
    L_0x00b5:
        throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.p605ep.commonbase.utils.ZipUtils.extractFile(java.io.File, java.lang.String, java.io.File):boolean");
    }

    public static void unZip(String str, String str2) {
        ZipFile zipFile = new ZipFile(str);
        Enumeration entries = zipFile.entries();
        byte[] bArr = new byte[1024];
        while (entries.hasMoreElements()) {
            ZipEntry zipEntry = (ZipEntry) entries.nextElement();
            if (!zipEntry.getName().contains("../")) {
                if (zipEntry.isDirectory()) {
                    new File(str2, zipEntry.getName()).mkdirs();
                } else {
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(zipEntry));
                    File file = new File(str2, zipEntry.getName());
                    File parentFile = file.getParentFile();
                    if (parentFile != null && !parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream, 1024);
                    while (true) {
                        int read = bufferedInputStream.read(bArr, 0, 1024);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                    fileOutputStream.close();
                    bufferedInputStream.close();
                }
            }
        }
        zipFile.close();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0010, code lost:
            r1.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000a, code lost:
            r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
            r1.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000f, code lost:
            r1 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x000f A[ExcHandler: all (r1v3 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    public static boolean verifyZipFile(java.io.File r1) {
        /*
        java.util.zip.ZipFile r0 = new java.util.zip.ZipFile     // Catch:{ ZipException -> 0x0014, all -> 0x000f }
        r0.<init>(r1)     // Catch:{ ZipException -> 0x0014, all -> 0x000f }
        r0.close()     // Catch:{ IOException -> 0x000a, all -> 0x000f }
        r1 = 1
        return r1
    L_0x000a:
        r1 = move-exception
        r1.printStackTrace()     // Catch:{ ZipException -> 0x0014, all -> 0x000f }
        goto L_0x0018
    L_0x000f:
        r1 = move-exception
        r1.printStackTrace()
        goto L_0x0018
    L_0x0014:
        r1 = move-exception
        r1.printStackTrace()
    L_0x0018:
        r1 = 0
        return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.p605ep.commonbase.utils.ZipUtils.verifyZipFile(java.io.File):boolean");
    }

    public static void zip(String str, String str2) {
        FileOutputStream fileOutputStream = new FileOutputStream(str2);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        ZipOutputStream zipOutputStream = new ZipOutputStream(bufferedOutputStream);
        File file = new File(str);
        String path = file.isDirectory() ? file.getPath() : file.getParent();
        if (path != null) {
            zipFile(file, path, zipOutputStream);
        }
        zipOutputStream.closeEntry();
        zipOutputStream.close();
        bufferedOutputStream.close();
        fileOutputStream.close();
    }

    private static void zipFile(File file, String str, ZipOutputStream zipOutputStream) {
        File[] fileArr;
        if (file.isDirectory()) {
            fileArr = file.listFiles();
        } else {
            fileArr = new File[]{file};
        }
        byte[] bArr = new byte[1024];
        for (File file2 : fileArr) {
            if (file2.isDirectory()) {
                StringBuilder sb = new StringBuilder();
                sb.append(file2.getPath().substring(str.length() + 1));
                sb.append("/");
                zipOutputStream.putNextEntry(new ZipEntry(sb.toString()));
                zipFile(file2, str, zipOutputStream);
            } else {
                String substring = file2.getPath().substring(str.length() + 1);
                FileInputStream fileInputStream = new FileInputStream(file2);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
                zipOutputStream.putNextEntry(new ZipEntry(substring));
                while (true) {
                    int read = bufferedInputStream.read(bArr, 0, 1024);
                    if (read == -1) {
                        break;
                    }
                    zipOutputStream.write(bArr, 0, read);
                }
                bufferedInputStream.close();
                fileInputStream.close();
            }
        }
    }
}
