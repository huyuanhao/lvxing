package com.tencent.p605ep.commonbase.utils;

import android.os.Environment;
import android.os.StatFs;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.ep.commonbase.utils.SdcardUtil */
public final class SdcardUtil {
    public static final int SD_STATUS_CANNOT_WRITE = 2;
    public static final int SD_STATUS_OK = 0;
    public static final int SD_STATUS_SPACE_NOT_ENOUGH = 3;
    public static final int SD_STATUS_UNMOUNTED = 1;
    private static final String TAG = "SecurePhoneInfoUtil";

    /* renamed from: com.tencent.ep.commonbase.utils.SdcardUtil$SizeInfo */
    public static class SizeInfo {
        public long availableSize;
        public long totalSize;
    }

    public static boolean canWrite2SDCard() {
        StringBuilder sb = new StringBuilder();
        sb.append(Environment.getExternalStorageDirectory().toString());
        sb.append("/DCIM");
        String sb2 = sb.toString();
        File file = new File(sb2);
        if (!file.isDirectory() && !file.mkdirs()) {
            return false;
        }
        File file2 = new File(sb2, ".probe");
        try {
            if (file2.exists()) {
                file2.delete();
            }
            if (!file2.createNewFile()) {
                return false;
            }
            file2.delete();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0077, code lost:
            if (r2 != null) goto L_0x0079;
     */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x006f A[Catch:{ FileNotFoundException -> 0x0070, IOException -> 0x0066, all -> 0x0064, all -> 0x0082 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0086 A[SYNTHETIC, Splitter:B:50:0x0086] */
    public static java.util.List<java.lang.String> getCommonReadWriteMounts() {
        /*
        java.util.ArrayList r0 = new java.util.ArrayList
        r0.<init>()
        r1 = 0
        java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ FileNotFoundException -> 0x0070, IOException -> 0x0066, all -> 0x0064 }
        java.io.FileReader r3 = new java.io.FileReader     // Catch:{ FileNotFoundException -> 0x0070, IOException -> 0x0066, all -> 0x0064 }
        java.lang.String r4 = "/proc/mounts"
        r3.<init>(r4)     // Catch:{ FileNotFoundException -> 0x0070, IOException -> 0x0066, all -> 0x0064 }
        r2.<init>(r3)     // Catch:{ FileNotFoundException -> 0x0070, IOException -> 0x0066, all -> 0x0064 }
        java.lang.String r1 = "^/(?:sys|system|dev|cache|proc|acct|data|efs|osh|pds|(?:mnt/asec)|(?:mnt/obb)|(?:mnt/secure))/*.*$"
    L_0x0014:
        java.lang.String r3 = r2.readLine()     // Catch:{ FileNotFoundException -> 0x0062, IOException -> 0x0060 }
        if (r3 == 0) goto L_0x0057
        java.lang.String r4 = "\\s+"
        java.lang.String[] r3 = r3.split(r4)     // Catch:{ FileNotFoundException -> 0x0062, IOException -> 0x0060 }
        int r4 = r3.length     // Catch:{ FileNotFoundException -> 0x0062, IOException -> 0x0060 }
        r5 = 4
        if (r4 < r5) goto L_0x0014
        r4 = 3
        r4 = r3[r4]     // Catch:{ FileNotFoundException -> 0x0062, IOException -> 0x0060 }
        java.lang.String r5 = "rw"
        boolean r4 = r4.startsWith(r5)     // Catch:{ FileNotFoundException -> 0x0062, IOException -> 0x0060 }
        if (r4 != 0) goto L_0x0030
        goto L_0x0014
    L_0x0030:
        r4 = 1
        r3 = r3[r4]     // Catch:{ FileNotFoundException -> 0x0062, IOException -> 0x0060 }
        java.lang.String r4 = "/"
        boolean r4 = r3.equals(r4)     // Catch:{ FileNotFoundException -> 0x0062, IOException -> 0x0060 }
        if (r4 == 0) goto L_0x003c
        goto L_0x0014
    L_0x003c:
        java.util.regex.Pattern r4 = java.util.regex.Pattern.compile(r1)     // Catch:{ FileNotFoundException -> 0x0062, IOException -> 0x0060 }
        java.util.regex.Matcher r4 = r4.matcher(r3)     // Catch:{ FileNotFoundException -> 0x0062, IOException -> 0x0060 }
        if (r4 == 0) goto L_0x004d
        boolean r4 = r4.find()     // Catch:{ FileNotFoundException -> 0x0062, IOException -> 0x0060 }
        if (r4 == 0) goto L_0x004d
        goto L_0x0014
    L_0x004d:
        boolean r4 = r0.contains(r3)     // Catch:{ FileNotFoundException -> 0x0062, IOException -> 0x0060 }
        if (r4 != 0) goto L_0x0014
        r0.add(r3)     // Catch:{ FileNotFoundException -> 0x0062, IOException -> 0x0060 }
        goto L_0x0014
    L_0x0057:
        r2.close()     // Catch:{ IOException -> 0x005b }
        goto L_0x005f
    L_0x005b:
        r1 = move-exception
        r1.printStackTrace()
    L_0x005f:
        return r0
    L_0x0060:
        r1 = move-exception
        goto L_0x006a
    L_0x0062:
        r1 = move-exception
        goto L_0x0074
    L_0x0064:
        r0 = move-exception
        goto L_0x0084
    L_0x0066:
        r2 = move-exception
        r6 = r2
        r2 = r1
        r1 = r6
    L_0x006a:
        r1.printStackTrace()     // Catch:{ all -> 0x0082 }
        if (r2 == 0) goto L_0x0081
        goto L_0x0079
    L_0x0070:
        r2 = move-exception
        r6 = r2
        r2 = r1
        r1 = r6
    L_0x0074:
        r1.printStackTrace()     // Catch:{ all -> 0x0082 }
        if (r2 == 0) goto L_0x0081
    L_0x0079:
        r2.close()     // Catch:{ IOException -> 0x007d }
        goto L_0x0081
    L_0x007d:
        r1 = move-exception
        r1.printStackTrace()
    L_0x0081:
        return r0
    L_0x0082:
        r0 = move-exception
        r1 = r2
    L_0x0084:
        if (r1 == 0) goto L_0x008e
        r1.close()     // Catch:{ IOException -> 0x008a }
        goto L_0x008e
    L_0x008a:
        r1 = move-exception
        r1.printStackTrace()
    L_0x008e:
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.p605ep.commonbase.utils.SdcardUtil.getCommonReadWriteMounts():java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x009e A[SYNTHETIC, Splitter:B:44:0x009e] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00ab A[SYNTHETIC, Splitter:B:52:0x00ab] */
    public static java.util.ArrayList<java.lang.String> getExternalStorageDirectories() {
        /*
        java.util.ArrayList r0 = new java.util.ArrayList
        r0.<init>()
        r1 = 0
        java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0095, all -> 0x0093 }
        java.io.FileReader r3 = new java.io.FileReader     // Catch:{ Exception -> 0x0095, all -> 0x0093 }
        java.lang.String r4 = "/proc/mounts"
        r3.<init>(r4)     // Catch:{ Exception -> 0x0095, all -> 0x0093 }
        r2.<init>(r3)     // Catch:{ Exception -> 0x0095, all -> 0x0093 }
    L_0x0012:
        java.lang.String r1 = r2.readLine()     // Catch:{ Exception -> 0x0091 }
        if (r1 == 0) goto L_0x0085
        java.lang.String r3 = "vfat"
        boolean r3 = r1.contains(r3)     // Catch:{ Exception -> 0x0091 }
        if (r3 != 0) goto L_0x0038
        java.lang.String r3 = "exfat"
        boolean r3 = r1.contains(r3)     // Catch:{ Exception -> 0x0091 }
        if (r3 != 0) goto L_0x0038
        java.lang.String r3 = "/mnt"
        boolean r3 = r1.contains(r3)     // Catch:{ Exception -> 0x0091 }
        if (r3 != 0) goto L_0x0038
        java.lang.String r3 = "fuse"
        boolean r3 = r1.contains(r3)     // Catch:{ Exception -> 0x0091 }
        if (r3 == 0) goto L_0x0012
    L_0x0038:
        java.lang.String r3 = "/dev/block/vold"
        boolean r3 = r1.contains(r3)     // Catch:{ Exception -> 0x0091 }
        if (r3 != 0) goto L_0x0048
        java.lang.String r3 = "/by-name/ISD"
        boolean r3 = r1.contains(r3)     // Catch:{ Exception -> 0x0091 }
        if (r3 == 0) goto L_0x0012
    L_0x0048:
        java.lang.String r3 = "/mnt/secure"
        boolean r3 = r1.contains(r3)     // Catch:{ Exception -> 0x0091 }
        if (r3 != 0) goto L_0x0012
        java.lang.String r3 = "/mnt/asec"
        boolean r3 = r1.contains(r3)     // Catch:{ Exception -> 0x0091 }
        if (r3 != 0) goto L_0x0012
        java.lang.String r3 = "/mnt/obb"
        boolean r3 = r1.contains(r3)     // Catch:{ Exception -> 0x0091 }
        if (r3 != 0) goto L_0x0012
        java.lang.String r3 = "/dev/mapper"
        boolean r3 = r1.contains(r3)     // Catch:{ Exception -> 0x0091 }
        if (r3 != 0) goto L_0x0012
        java.lang.String r3 = "tmpfs"
        boolean r3 = r1.contains(r3)     // Catch:{ Exception -> 0x0091 }
        if (r3 != 0) goto L_0x0012
        java.lang.String r3 = "\\s+"
        java.lang.String[] r1 = r1.split(r3)     // Catch:{ Exception -> 0x0091 }
        r3 = 1
        r4 = r1[r3]     // Catch:{ Exception -> 0x0091 }
        boolean r4 = includedInList(r0, r4)     // Catch:{ Exception -> 0x0091 }
        if (r4 != 0) goto L_0x0012
        r1 = r1[r3]     // Catch:{ Exception -> 0x0091 }
        r0.add(r1)     // Catch:{ Exception -> 0x0091 }
        goto L_0x0012
    L_0x0085:
        trimLastSlash(r0)     // Catch:{ Exception -> 0x0091 }
        r2.close()     // Catch:{ IOException -> 0x008c }
        goto L_0x0090
    L_0x008c:
        r1 = move-exception
        r1.printStackTrace()
    L_0x0090:
        return r0
    L_0x0091:
        r1 = move-exception
        goto L_0x0099
    L_0x0093:
        r0 = move-exception
        goto L_0x00a9
    L_0x0095:
        r2 = move-exception
        r5 = r2
        r2 = r1
        r1 = r5
    L_0x0099:
        r1.printStackTrace()     // Catch:{ all -> 0x00a7 }
        if (r2 == 0) goto L_0x00a6
        r2.close()     // Catch:{ IOException -> 0x00a2 }
        goto L_0x00a6
    L_0x00a2:
        r1 = move-exception
        r1.printStackTrace()
    L_0x00a6:
        return r0
    L_0x00a7:
        r0 = move-exception
        r1 = r2
    L_0x00a9:
        if (r1 == 0) goto L_0x00b3
        r1.close()     // Catch:{ IOException -> 0x00af }
        goto L_0x00b3
    L_0x00af:
        r1 = move-exception
        r1.printStackTrace()
    L_0x00b3:
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.p605ep.commonbase.utils.SdcardUtil.getExternalStorageDirectories():java.util.ArrayList");
    }

    public static File getExternalStorageDirectory() {
        try {
            return Environment.getExternalStorageDirectory();
        } catch (Throwable th) {
            th.printStackTrace();
            return new File("/sdcard");
        }
    }

    public static int getSDCardStatus(long j) {
        if (!hasStorageCard()) {
            return 1;
        }
        if (!canWrite2SDCard()) {
            return 2;
        }
        SizeInfo sizeInfo = new SizeInfo();
        getSizeInfo(Environment.getExternalStorageDirectory(), sizeInfo);
        return sizeInfo.availableSize < j ? 3 : 0;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:15|16|17|18|19|20) */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006b, code lost:
            if (r0 == null) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
            r0.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x005f */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0090 A[SYNTHETIC, Splitter:B:36:0x0090] */
    public static java.lang.String getSDCid(boolean r6) {
        /*
        if (r6 == 0) goto L_0x0007
        java.lang.String r6 = "/sys/block/mmcblk0/device/"
        java.lang.String r0 = "MMC"
        goto L_0x000b
    L_0x0007:
        java.lang.String r6 = "/sys/block/mmcblk1/device/"
        java.lang.String r0 = "SD"
    L_0x000b:
        r1 = 0
        java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x0071 }
        java.io.FileReader r3 = new java.io.FileReader     // Catch:{ all -> 0x0071 }
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0071 }
        r4.<init>()     // Catch:{ all -> 0x0071 }
        r4.append(r6)     // Catch:{ all -> 0x0071 }
        java.lang.String r5 = "type"
        r4.append(r5)     // Catch:{ all -> 0x0071 }
        java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0071 }
        r3.<init>(r4)     // Catch:{ all -> 0x0071 }
        r2.<init>(r3)     // Catch:{ all -> 0x0071 }
        java.lang.String r3 = r2.readLine()     // Catch:{ all -> 0x006e }
        if (r3 == 0) goto L_0x0065
        java.lang.String r3 = r3.toUpperCase()     // Catch:{ all -> 0x006e }
        boolean r0 = r3.equals(r0)     // Catch:{ all -> 0x006e }
        if (r0 == 0) goto L_0x0065
        java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ all -> 0x006e }
        java.io.FileReader r3 = new java.io.FileReader     // Catch:{ all -> 0x006e }
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x006e }
        r4.<init>()     // Catch:{ all -> 0x006e }
        r4.append(r6)     // Catch:{ all -> 0x006e }
        java.lang.String r6 = "cid"
        r4.append(r6)     // Catch:{ all -> 0x006e }
        java.lang.String r6 = r4.toString()     // Catch:{ all -> 0x006e }
        r3.<init>(r6)     // Catch:{ all -> 0x006e }
        r0.<init>(r3)     // Catch:{ all -> 0x006e }
        java.lang.String r6 = r0.readLine()     // Catch:{ all -> 0x0063 }
        if (r6 == 0) goto L_0x0066
        java.lang.String r6 = r6.trim()     // Catch:{ all -> 0x0063 }
        r2.close()     // Catch:{ IOException -> 0x005f }
    L_0x005f:
        r0.close()     // Catch:{ IOException -> 0x0062 }
    L_0x0062:
        return r6
    L_0x0063:
        r6 = move-exception
        goto L_0x0074
    L_0x0065:
        r0 = r1
    L_0x0066:
        r2.close()     // Catch:{ IOException -> 0x006a }
        goto L_0x006b
    L_0x006b:
        if (r0 == 0) goto L_0x009a
        goto L_0x0097
    L_0x006e:
        r6 = move-exception
        r0 = r1
        goto L_0x0074
    L_0x0071:
        r6 = move-exception
        r0 = r1
        r2 = r0
    L_0x0074:
        java.lang.String r3 = "SecurePhoneInfoUtil"
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x009b }
        r4.<init>()     // Catch:{ all -> 0x009b }
        java.lang.String r5 = "getSDCid(): "
        r4.append(r5)     // Catch:{ all -> 0x009b }
        java.lang.String r5 = r6.getMessage()     // Catch:{ all -> 0x009b }
        r4.append(r5)     // Catch:{ all -> 0x009b }
        java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x009b }
        android.util.Log.w(r3, r4, r6)     // Catch:{ all -> 0x009b }
        if (r2 == 0) goto L_0x0095
        r2.close()     // Catch:{ IOException -> 0x0094 }
        goto L_0x0095
    L_0x0095:
        if (r0 == 0) goto L_0x009a
    L_0x0097:
        r0.close()     // Catch:{ IOException -> 0x009a }
    L_0x009a:
        return r1
    L_0x009b:
        r6 = move-exception
        if (r2 == 0) goto L_0x00a3
        r2.close()     // Catch:{ IOException -> 0x00a2 }
        goto L_0x00a3
    L_0x00a3:
        if (r0 == 0) goto L_0x00a8
        r0.close()     // Catch:{ IOException -> 0x00a8 }
    L_0x00a8:
        throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.p605ep.commonbase.utils.SdcardUtil.getSDCid(boolean):java.lang.String");
    }

    public static String getSdCardPath() {
        return Environment.getExternalStorageDirectory().toString();
    }

    public static boolean getSizeInfo(File file, SizeInfo sizeInfo) {
        try {
            StatFs statFs = new StatFs(file.getPath());
            long blockSize = (long) statFs.getBlockSize();
            sizeInfo.availableSize = ((long) statFs.getAvailableBlocks()) * blockSize;
            sizeInfo.totalSize = ((long) statFs.getBlockCount()) * blockSize;
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void getStorageCardSize(SizeInfo sizeInfo) {
        if (hasStorageCard()) {
            getSizeInfo(getExternalStorageDirectory(), sizeInfo);
            return;
        }
        sizeInfo.availableSize = 0;
        sizeInfo.totalSize = 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x00c4 A[SYNTHETIC, Splitter:B:53:0x00c4] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00d1 A[SYNTHETIC, Splitter:B:61:0x00d1] */
    public static java.util.ArrayList<java.lang.String> getStorageDirectories() {
        /*
        java.util.ArrayList r0 = new java.util.ArrayList
        r0.<init>()
        r1 = 0
        boolean r2 = hasStorageCard()     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
        if (r2 == 0) goto L_0x0019
        java.io.File r2 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
        java.lang.String r2 = r2.getAbsolutePath()     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
        if (r2 == 0) goto L_0x0019
        r0.add(r2)     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
    L_0x0019:
        java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
        java.io.FileReader r3 = new java.io.FileReader     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
        java.lang.String r4 = "/proc/mounts"
        r3.<init>(r4)     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
        r2.<init>(r3)     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
    L_0x0025:
        java.lang.String r1 = r2.readLine()     // Catch:{ Exception -> 0x00b7 }
        if (r1 == 0) goto L_0x00ab
        java.lang.String r3 = "vfat"
        boolean r3 = r1.contains(r3)     // Catch:{ Exception -> 0x00b7 }
        if (r3 != 0) goto L_0x004b
        java.lang.String r3 = "exfat"
        boolean r3 = r1.contains(r3)     // Catch:{ Exception -> 0x00b7 }
        if (r3 != 0) goto L_0x004b
        java.lang.String r3 = "/mnt"
        boolean r3 = r1.contains(r3)     // Catch:{ Exception -> 0x00b7 }
        if (r3 != 0) goto L_0x004b
        java.lang.String r3 = "fuse"
        boolean r3 = r1.contains(r3)     // Catch:{ Exception -> 0x00b7 }
        if (r3 == 0) goto L_0x0025
    L_0x004b:
        java.lang.String r3 = "\\s+"
        java.lang.String[] r3 = r1.split(r3)     // Catch:{ Exception -> 0x00b7 }
        r4 = 1
        r5 = r3[r4]     // Catch:{ Exception -> 0x00b7 }
        java.io.File r6 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ Exception -> 0x00b7 }
        java.lang.String r6 = r6.getPath()     // Catch:{ Exception -> 0x00b7 }
        boolean r5 = r5.equals(r6)     // Catch:{ Exception -> 0x00b7 }
        if (r5 == 0) goto L_0x0070
        r1 = r3[r4]     // Catch:{ Exception -> 0x00b7 }
        boolean r1 = includedInList(r0, r1)     // Catch:{ Exception -> 0x00b7 }
        if (r1 != 0) goto L_0x0025
        r1 = r3[r4]     // Catch:{ Exception -> 0x00b7 }
    L_0x006c:
        r0.add(r1)     // Catch:{ Exception -> 0x00b7 }
        goto L_0x0025
    L_0x0070:
        java.lang.String r5 = "/dev/block/vold"
        boolean r5 = r1.contains(r5)     // Catch:{ Exception -> 0x00b7 }
        if (r5 == 0) goto L_0x0025
        java.lang.String r5 = "/mnt/secure"
        boolean r5 = r1.contains(r5)     // Catch:{ Exception -> 0x00b7 }
        if (r5 != 0) goto L_0x0025
        java.lang.String r5 = "/mnt/asec"
        boolean r5 = r1.contains(r5)     // Catch:{ Exception -> 0x00b7 }
        if (r5 != 0) goto L_0x0025
        java.lang.String r5 = "/mnt/obb"
        boolean r5 = r1.contains(r5)     // Catch:{ Exception -> 0x00b7 }
        if (r5 != 0) goto L_0x0025
        java.lang.String r5 = "/dev/mapper"
        boolean r5 = r1.contains(r5)     // Catch:{ Exception -> 0x00b7 }
        if (r5 != 0) goto L_0x0025
        java.lang.String r5 = "tmpfs"
        boolean r1 = r1.contains(r5)     // Catch:{ Exception -> 0x00b7 }
        if (r1 != 0) goto L_0x0025
        r1 = r3[r4]     // Catch:{ Exception -> 0x00b7 }
        boolean r1 = includedInList(r0, r1)     // Catch:{ Exception -> 0x00b7 }
        if (r1 != 0) goto L_0x0025
        r1 = r3[r4]     // Catch:{ Exception -> 0x00b7 }
        goto L_0x006c
    L_0x00ab:
        trimLastSlash(r0)     // Catch:{ Exception -> 0x00b7 }
        r2.close()     // Catch:{ IOException -> 0x00b2 }
        goto L_0x00b6
    L_0x00b2:
        r1 = move-exception
        r1.printStackTrace()
    L_0x00b6:
        return r0
    L_0x00b7:
        r1 = move-exception
        goto L_0x00bf
    L_0x00b9:
        r0 = move-exception
        goto L_0x00cf
    L_0x00bb:
        r2 = move-exception
        r7 = r2
        r2 = r1
        r1 = r7
    L_0x00bf:
        r1.printStackTrace()     // Catch:{ all -> 0x00cd }
        if (r2 == 0) goto L_0x00cc
        r2.close()     // Catch:{ IOException -> 0x00c8 }
        goto L_0x00cc
    L_0x00c8:
        r1 = move-exception
        r1.printStackTrace()
    L_0x00cc:
        return r0
    L_0x00cd:
        r0 = move-exception
        r1 = r2
    L_0x00cf:
        if (r1 == 0) goto L_0x00d9
        r1.close()     // Catch:{ IOException -> 0x00d5 }
        goto L_0x00d9
    L_0x00d5:
        r1 = move-exception
        r1.printStackTrace()
    L_0x00d9:
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.p605ep.commonbase.utils.SdcardUtil.getStorageDirectories():java.util.ArrayList");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0073, code lost:
            if (r10.equals(r9) != false) goto L_0x0075;
     */
    public static java.util.List<java.lang.String> getStoragePathList(android.content.Context r12, boolean r13) {
        /*
        int r0 = android.os.Build.VERSION.SDK_INT
        r1 = 9
        if (r0 >= r1) goto L_0x000b
        java.util.ArrayList r12 = getStorageDirectories()
        return r12
    L_0x000b:
        java.util.ArrayList r0 = new java.util.ArrayList
        r0.<init>()
        java.lang.String r1 = "storage"
        java.lang.Object r12 = r12.getSystemService(r1)     // Catch:{ all -> 0x008e }
        android.os.storage.StorageManager r12 = (android.os.storage.StorageManager) r12     // Catch:{ all -> 0x008e }
        java.lang.Class r1 = r12.getClass()     // Catch:{ all -> 0x008e }
        java.lang.String r2 = "getVolumeList"
        r3 = 0
        java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ all -> 0x008e }
        java.lang.reflect.Method r1 = r1.getMethod(r2, r4)     // Catch:{ all -> 0x008e }
        java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch:{ all -> 0x008e }
        java.lang.Object r1 = r1.invoke(r12, r2)     // Catch:{ all -> 0x008e }
        java.lang.Object[] r1 = (java.lang.Object[]) r1     // Catch:{ all -> 0x008e }
        if (r1 == 0) goto L_0x008d
        int r2 = r1.length     // Catch:{ all -> 0x008e }
        if (r2 <= 0) goto L_0x008d
        r2 = r1[r3]     // Catch:{ all -> 0x008e }
        java.lang.Class r2 = r2.getClass()     // Catch:{ all -> 0x008e }
        java.lang.String r4 = "getPath"
        java.lang.Class[] r5 = new java.lang.Class[r3]     // Catch:{ all -> 0x008e }
        java.lang.reflect.Method r2 = r2.getDeclaredMethod(r4, r5)     // Catch:{ all -> 0x008e }
        java.lang.Class r4 = r12.getClass()     // Catch:{ all -> 0x008e }
        java.lang.String r5 = "getVolumeState"
        r6 = 1
        java.lang.Class[] r7 = new java.lang.Class[r6]     // Catch:{ all -> 0x008e }
        java.lang.Class<java.lang.String> r8 = java.lang.String.class
        r7[r3] = r8     // Catch:{ all -> 0x008e }
        java.lang.reflect.Method r4 = r4.getMethod(r5, r7)     // Catch:{ all -> 0x008e }
        int r5 = r1.length     // Catch:{ all -> 0x008e }
        r7 = 0
    L_0x0053:
        if (r7 >= r5) goto L_0x008d
        r8 = r1[r7]     // Catch:{ all -> 0x008e }
        java.lang.Object[] r9 = new java.lang.Object[r3]     // Catch:{ all -> 0x008e }
        java.lang.Object r8 = r2.invoke(r8, r9)     // Catch:{ all -> 0x008e }
        java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x008e }
        if (r8 == 0) goto L_0x008a
        java.lang.Object[] r9 = new java.lang.Object[r6]     // Catch:{ all -> 0x008e }
        r9[r3] = r8     // Catch:{ all -> 0x008e }
        java.lang.Object r9 = r4.invoke(r12, r9)     // Catch:{ all -> 0x008e }
        java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x008e }
        java.lang.String r10 = "mounted"
        if (r13 == 0) goto L_0x0079
        boolean r11 = r10.equals(r9)     // Catch:{ all -> 0x008e }
        if (r11 == 0) goto L_0x0079
    L_0x0075:
        r0.add(r8)     // Catch:{ all -> 0x008e }
        goto L_0x008a
    L_0x0079:
        if (r13 != 0) goto L_0x008a
        boolean r9 = r10.equals(r9)     // Catch:{ all -> 0x008e }
        if (r9 != 0) goto L_0x008a
        java.lang.String r9 = "sd"
        boolean r9 = r8.contains(r9)     // Catch:{ all -> 0x008e }
        if (r9 == 0) goto L_0x008a
        goto L_0x0075
    L_0x008a:
        int r7 = r7 + 1
        goto L_0x0053
    L_0x008d:
        return r0
    L_0x008e:
        r12 = move-exception
        r12.printStackTrace()
        java.util.ArrayList r12 = getStorageDirectories()
        return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.p605ep.commonbase.utils.SdcardUtil.getStoragePathList(android.content.Context, boolean):java.util.List");
    }

    public static boolean hasStorageCard() {
        try {
            return Environment.getExternalStorageState().equals("mounted");
        } catch (Throwable unused) {
            return false;
        }
    }

    static boolean includedInList(ArrayList<String> arrayList, String str) {
        boolean z;
        Iterator it = arrayList.iterator();
        do {
            z = false;
            if (!it.hasNext()) {
                break;
            }
            String str2 = (String) it.next();
            if (str.equals(str2)) {
                return true;
            }
            try {
                String canonicalPath = new File(str2).getCanonicalPath();
                String canonicalPath2 = new File(str).getCanonicalPath();
                if (!(canonicalPath == null || canonicalPath2 == null)) {
                    z = canonicalPath.equals(canonicalPath2);
                    continue;
                }
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        } while (!z);
        return z;
    }

    static void trimLastSlash(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                while (((String) arrayList.get(i)).endsWith("/")) {
                    arrayList.set(i, ((String) arrayList.get(i)).substring(0, ((String) arrayList.get(i)).length() - 1));
                }
            }
        }
    }
}
