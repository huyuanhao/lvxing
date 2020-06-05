package com.tencent.p605ep.commonbase.utils;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.tencent.p605ep.commonbase.api.Log;
import com.tencent.p605ep.commonbase.utils.SdcardUtil.SizeInfo;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.Marker;

/* renamed from: com.tencent.ep.commonbase.utils.FileUtil */
public final class FileUtil {
    private static final String[][] MIME_TYPE_ARRAY;
    public static final String TAG = "FileUtil";
    private static boolean isCancelGetMD5_SHA;

    static {
        String str = "application/octet-stream";
        String str2 = "text/plain";
        String str3 = "application/msword";
        String str4 = "text/html";
        String str5 = "image/jpeg";
        String str6 = "audio/mp4a-latm";
        String str7 = "audio/x-mpeg";
        String str8 = "video/mp4";
        String str9 = "video/mpeg";
        String str10 = "application/vnd.ms-powerpoint";
        String str11 = "application/vnd.ms-excel";
        MIME_TYPE_ARRAY = new String[][]{new String[]{"3gp", "video/3gpp"}, new String[]{"apk", "application/vnd.android.package-archive"}, new String[]{"asf", "video/x-ms-asf"}, new String[]{"avi", "video/x-msvideo"}, new String[]{"bin", str}, new String[]{"bmp", "image/bmp"}, new String[]{"c", str2}, new String[]{"class", str}, new String[]{"conf", str2}, new String[]{"cpp", str2}, new String[]{"doc", str3}, new String[]{"docx", str3}, new String[]{"exe", str}, new String[]{"gif", "image/gif"}, new String[]{"gtar", "application/x-gtar"}, new String[]{"gz", "application/x-gzip"}, new String[]{"h", str2}, new String[]{"htm", str4}, new String[]{"html", str4}, new String[]{"jar", "application/java-archive"}, new String[]{"java", str2}, new String[]{"jpeg", str5}, new String[]{"jpg", str5}, new String[]{"js", "application/x-javascript"}, new String[]{"log", str2}, new String[]{"m3u", "audio/x-mpegurl"}, new String[]{"m4a", str6}, new String[]{"m4b", str6}, new String[]{"m4p", str6}, new String[]{"m4u", "video/vnd.mpegurl"}, new String[]{"m4v", "video/x-m4v"}, new String[]{"mov", "video/quicktime"}, new String[]{"mp2", str7}, new String[]{"mp3", str7}, new String[]{"mp4", str8}, new String[]{"mpc", "application/vnd.mpohn.certificate"}, new String[]{"mpe", str9}, new String[]{"mpeg", str9}, new String[]{"mpg", str9}, new String[]{"mpg4", str8}, new String[]{"mpga", "audio/mpeg"}, new String[]{NotificationCompat.CATEGORY_MESSAGE, "application/vnd.ms-outlook"}, new String[]{"ogg", "audio/ogg"}, new String[]{"pdf", "application/pdf"}, new String[]{"png", "image/png"}, new String[]{"pps", str10}, new String[]{"ppsx", str10}, new String[]{"ppt", str10}, new String[]{"pptx", str10}, new String[]{"xls", str11}, new String[]{"xlsx", str11}, new String[]{"prop", str2}, new String[]{"rar", "application/x-rar-compressed"}, new String[]{"rc", str2}, new String[]{"rmvb", "audio/x-pn-realaudio"}, new String[]{"rtf", "application/rtf"}, new String[]{"sh", str2}, new String[]{"tar", "application/x-tar"}, new String[]{"tgz", "application/x-compressed"}, new String[]{"txt", str2}, new String[]{"wav", "audio/x-wav"}, new String[]{"wma", "audio/x-ms-wma"}, new String[]{"wmv", "audio/x-ms-wmv"}, new String[]{"wps", "application/vnd.ms-works"}, new String[]{"xml", str2}, new String[]{"z", "application/x-compress"}, new String[]{"zip", "application/zip"}, new String[]{"epub", "application/epub+zip"}, new String[]{"", "*/*"}};
    }

    @Deprecated
    private static List<String> _getAllApkFiles(File file, final List<String> list, final boolean z) {
        List asList;
        final ArrayList arrayList = new ArrayList();
        C72981 r1 = new FileFilter() {
            public boolean accept(File file) {
                if (file.isDirectory()) {
                    List list = list;
                    if (list == null || !list.contains(file.getAbsolutePath())) {
                        return true;
                    }
                }
                if (file.getAbsolutePath().toLowerCase().endsWith(".apk") || (z && FileUtil.isApkFile(file))) {
                    arrayList.add(file.getAbsolutePath());
                }
                return false;
            }
        };
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        File[] listFiles = file.listFiles(r1);
        if (listFiles != null) {
            asList = Arrays.asList(listFiles);
            linkedBlockingQueue.addAll(asList);
        }
        while (true) {
            if (linkedBlockingQueue.size() > 0 && linkedBlockingQueue.poll() != null) {
                File[] listFiles2 = ((File) linkedBlockingQueue.poll()).listFiles(r1);
                if (listFiles2 != null) {
                    asList = Arrays.asList(listFiles2);
                    break;
                }
            } else {
                return arrayList;
            }
        }
        return arrayList;
    }

    private static String bytesToString(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            int i2 = i * 2;
            cArr2[i2] = cArr[(b >>> 4) & 15];
            cArr2[i2 + 1] = cArr[b & 15];
        }
        return new String(cArr2);
    }

    public static void cancelGetMD5_SHA() {
        isCancelGetMD5_SHA = true;
    }

    public static boolean checkAndCreadFile(File file) {
        boolean z;
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            z = file.createNewFile();
        } else {
            z = true;
        }
        if (!file.canWrite()) {
            return false;
        }
        return z;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:14|15|(2:16|(1:18)(1:58))|19|20|21|22|23|24|26) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0045 */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0060 A[SYNTHETIC, Splitter:B:38:0x0060] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0067 A[SYNTHETIC, Splitter:B:42:0x0067] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0070 A[SYNTHETIC, Splitter:B:49:0x0070] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0077 A[SYNTHETIC, Splitter:B:53:0x0077] */
    public static boolean copyFile(java.lang.String r4, java.lang.String r5) {
        /*
        r0 = 0
        if (r4 == 0) goto L_0x007b
        int r1 = r4.length()
        if (r1 != 0) goto L_0x000b
        goto L_0x007b
    L_0x000b:
        java.io.File r1 = new java.io.File
        r1.<init>(r4)
        boolean r4 = r1.exists()
        if (r4 == 0) goto L_0x007b
        boolean r4 = r1.canRead()
        if (r4 != 0) goto L_0x001e
        goto L_0x007b
    L_0x001e:
        r4 = 0
        java.io.File r2 = new java.io.File     // Catch:{ IOException -> 0x0057, all -> 0x0053 }
        r2.<init>(r5)     // Catch:{ IOException -> 0x0057, all -> 0x0053 }
        deleteFile(r2)     // Catch:{ IOException -> 0x0057, all -> 0x0053 }
        java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0057, all -> 0x0053 }
        r5.<init>(r1)     // Catch:{ IOException -> 0x0057, all -> 0x0053 }
        java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x004e, all -> 0x004c }
        r1.<init>(r2)     // Catch:{ IOException -> 0x004e, all -> 0x004c }
        r4 = 8192(0x2000, float:1.14794E-41)
        byte[] r4 = new byte[r4]     // Catch:{ IOException -> 0x004a }
    L_0x0035:
        int r2 = r5.read(r4)     // Catch:{ IOException -> 0x004a }
        if (r2 <= 0) goto L_0x003f
        r1.write(r4, r0, r2)     // Catch:{ IOException -> 0x004a }
        goto L_0x0035
    L_0x003f:
        r1.flush()     // Catch:{ IOException -> 0x004a }
        r5.close()     // Catch:{ IOException -> 0x0045 }
    L_0x0045:
        r1.close()     // Catch:{ IOException -> 0x0048 }
    L_0x0048:
        r4 = 1
        return r4
    L_0x004a:
        r4 = move-exception
        goto L_0x005b
    L_0x004c:
        r0 = move-exception
        goto L_0x006e
    L_0x004e:
        r1 = move-exception
        r3 = r1
        r1 = r4
        r4 = r3
        goto L_0x005b
    L_0x0053:
        r5 = move-exception
        r0 = r5
        r5 = r4
        goto L_0x006e
    L_0x0057:
        r5 = move-exception
        r1 = r4
        r4 = r5
        r5 = r1
    L_0x005b:
        r4.printStackTrace()     // Catch:{ all -> 0x006b }
        if (r5 == 0) goto L_0x0065
        r5.close()     // Catch:{ IOException -> 0x0064 }
        goto L_0x0065
    L_0x0065:
        if (r1 == 0) goto L_0x006a
        r1.close()     // Catch:{ IOException -> 0x006a }
    L_0x006a:
        return r0
    L_0x006b:
        r4 = move-exception
        r0 = r4
        r4 = r1
    L_0x006e:
        if (r5 == 0) goto L_0x0075
        r5.close()     // Catch:{ IOException -> 0x0074 }
        goto L_0x0075
    L_0x0075:
        if (r4 == 0) goto L_0x007a
        r4.close()     // Catch:{ IOException -> 0x007a }
    L_0x007a:
        throw r0
    L_0x007b:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.p605ep.commonbase.utils.FileUtil.copyFile(java.lang.String, java.lang.String):boolean");
    }

    public static boolean createFile(File file) {
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            try {
                file.createNewFile();
            } catch (Exception e) {
                Log.m31479e("FileUtil", e.toString());
                return false;
            }
        }
        return true;
    }

    public static boolean delete(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        return file.isFile() ? deleteFile(str) : deleteDirectory(str);
    }

    public static boolean deleteDirectory(String str) {
        boolean z;
        if (!str.endsWith(File.separator)) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(File.separator);
            str = sb.toString();
        }
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length <= 0) {
                z = true;
            } else {
                z = true;
                for (int i = 0; i < listFiles.length; i++) {
                    if (listFiles[i].isFile()) {
                        z = deleteFile(listFiles[i].getAbsolutePath());
                        if (!z) {
                            break;
                        }
                    } else {
                        z = deleteDirectory(listFiles[i].getAbsolutePath());
                        if (!z) {
                            break;
                        }
                    }
                }
            }
            if (z && file.delete()) {
                return true;
            }
        }
        return false;
    }

    public static void deleteFile(File file) {
        try {
            if (file.exists()) {
                file.delete();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static boolean deleteFile(String str) {
        try {
            File file = new File(str);
            if (!file.isFile()) {
                return false;
            }
            return file.delete();
        } catch (Throwable unused) {
            return false;
        }
    }

    @Deprecated
    public static List<String> getAllApkFiles(File file, List<String> list) {
        return getAllApkFiles(file, list, true);
    }

    @Deprecated
    public static List<String> getAllApkFiles(File file, List<String> list, boolean z) {
        return _getAllApkFiles(file, list, z);
    }

    @Deprecated
    private static void getAllApkFiles(ArrayList<String> arrayList, File file, String[] strArr, HashMap<String, String> hashMap) {
        if (file.exists()) {
            if (file.isDirectory()) {
                if (strArr != null) {
                    int length = strArr.length;
                    int i = 0;
                    while (i < length) {
                        if (!file.getName().toLowerCase().contains(strArr[i])) {
                            i++;
                        } else {
                            return;
                        }
                    }
                }
                if (!file.getAbsolutePath().equals("/storage/emulated") && !file.getAbsolutePath().equals("/storage_int")) {
                    try {
                        String canonicalPath = file.getCanonicalPath();
                        File file2 = file;
                        while (!canonicalPath.equals(file2.getAbsolutePath())) {
                            file2 = new File(canonicalPath);
                            canonicalPath = file2.getCanonicalPath();
                        }
                        if (!hashMap.containsKey(canonicalPath)) {
                            hashMap.put(canonicalPath, canonicalPath);
                            File[] listFiles = file.listFiles();
                            if (listFiles != null) {
                                for (File allApkFiles : listFiles) {
                                    getAllApkFiles(arrayList, allApkFiles, strArr, hashMap);
                                }
                            }
                        }
                    } catch (IOException unused) {
                    }
                }
            } else if (file.getName().endsWith(".apk")) {
                arrayList.add(file.getAbsolutePath());
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:34|(2:58|59)|(2:62|63)|(2:66|67)|68|69) */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000b, code lost:
            if (r9.equals("") != false) goto L_0x000d;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:68:0x00b8 */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a7 A[SYNTHETIC, Splitter:B:58:0x00a7] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00ae A[SYNTHETIC, Splitter:B:62:0x00ae] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00b5 A[SYNTHETIC, Splitter:B:66:0x00b5] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00be A[SYNTHETIC, Splitter:B:75:0x00be] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00c5 A[SYNTHETIC, Splitter:B:79:0x00c5] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x00cc A[SYNTHETIC, Splitter:B:83:0x00cc] */
    public static synchronized java.lang.String getAssetGZipFile(android.content.Context r7, java.lang.String r8, java.lang.String r9) {
        /*
        java.lang.Class<com.tencent.ep.commonbase.utils.FileUtil> r0 = com.tencent.p605ep.commonbase.utils.FileUtil.class
        monitor-enter(r0)
        if (r9 == 0) goto L_0x000d
        java.lang.String r1 = ""
        boolean r1 = r9.equals(r1)     // Catch:{ all -> 0x00d1 }
        if (r1 == 0) goto L_0x0015
    L_0x000d:
        java.io.File r9 = r7.getFilesDir()     // Catch:{ all -> 0x00d1 }
        java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x00d1 }
    L_0x0015:
        java.io.File r1 = new java.io.File     // Catch:{ all -> 0x00d1 }
        r1.<init>(r9)     // Catch:{ all -> 0x00d1 }
        boolean r2 = r1.exists()     // Catch:{ all -> 0x00d1 }
        if (r2 == 0) goto L_0x0026
        boolean r2 = r1.isDirectory()     // Catch:{ all -> 0x00d1 }
        if (r2 != 0) goto L_0x0029
    L_0x0026:
        r1.mkdirs()     // Catch:{ all -> 0x00d1 }
    L_0x0029:
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d1 }
        r1.<init>()     // Catch:{ all -> 0x00d1 }
        r1.append(r9)     // Catch:{ all -> 0x00d1 }
        java.lang.String r9 = java.io.File.separator     // Catch:{ all -> 0x00d1 }
        r1.append(r9)     // Catch:{ all -> 0x00d1 }
        r1.append(r8)     // Catch:{ all -> 0x00d1 }
        java.lang.String r9 = r1.toString()     // Catch:{ all -> 0x00d1 }
        r1 = 0
        java.io.File r2 = new java.io.File     // Catch:{ IOException -> 0x00b9, all -> 0x00a1 }
        r2.<init>(r9)     // Catch:{ IOException -> 0x00b9, all -> 0x00a1 }
        boolean r3 = r2.exists()     // Catch:{ IOException -> 0x00b9, all -> 0x00a1 }
        if (r3 != 0) goto L_0x008a
        deleteFile(r2)     // Catch:{ IOException -> 0x00b9, all -> 0x00a1 }
        android.content.res.Resources r7 = r7.getResources()     // Catch:{ IOException -> 0x00b9, all -> 0x00a1 }
        android.content.res.AssetManager r7 = r7.getAssets()     // Catch:{ IOException -> 0x00b9, all -> 0x00a1 }
        r3 = 1
        java.io.InputStream r7 = r7.open(r8, r3)     // Catch:{ IOException -> 0x00b9, all -> 0x00a1 }
        java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x00ba, all -> 0x0087 }
        r8.<init>(r2)     // Catch:{ IOException -> 0x00ba, all -> 0x0087 }
        java.util.zip.GZIPInputStream r2 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x0085, all -> 0x0083 }
        r2.<init>(r7)     // Catch:{ IOException -> 0x0085, all -> 0x0083 }
        r4 = 1024(0x400, float:1.435E-42)
        byte[] r4 = new byte[r4]     // Catch:{ IOException -> 0x0081, all -> 0x007e }
    L_0x0067:
        int r5 = r2.read(r4)     // Catch:{ IOException -> 0x0081, all -> 0x007e }
        if (r5 < 0) goto L_0x0072
        r6 = 0
        r8.write(r4, r6, r5)     // Catch:{ IOException -> 0x0081, all -> 0x007e }
        goto L_0x0067
    L_0x0072:
        java.nio.channels.FileChannel r4 = r8.getChannel()     // Catch:{ IOException -> 0x0081, all -> 0x007e }
        r4.force(r3)     // Catch:{ IOException -> 0x0081, all -> 0x007e }
        r8.flush()     // Catch:{ IOException -> 0x0081, all -> 0x007e }
        r1 = r2
        goto L_0x008c
    L_0x007e:
        r9 = move-exception
        r1 = r2
        goto L_0x00a5
        goto L_0x00bc
    L_0x0083:
        r9 = move-exception
        goto L_0x00a5
    L_0x0085:
        r2 = r1
        goto L_0x00bc
    L_0x0087:
        r8 = move-exception
        r9 = r8
        goto L_0x00a4
    L_0x008a:
        r7 = r1
        r8 = r7
    L_0x008c:
        if (r1 == 0) goto L_0x0093
        r1.close()     // Catch:{ IOException -> 0x0092 }
        goto L_0x0093
    L_0x0093:
        if (r7 == 0) goto L_0x009a
        r7.close()     // Catch:{ IOException -> 0x0099 }
        goto L_0x009a
    L_0x009a:
        if (r8 == 0) goto L_0x009f
        r8.close()     // Catch:{ IOException -> 0x009f }
    L_0x009f:
        monitor-exit(r0)
        return r9
    L_0x00a1:
        r7 = move-exception
        r9 = r7
        r7 = r1
    L_0x00a4:
        r8 = r1
    L_0x00a5:
        if (r1 == 0) goto L_0x00ac
        r1.close()     // Catch:{ IOException -> 0x00ab }
        goto L_0x00ac
    L_0x00ac:
        if (r7 == 0) goto L_0x00b3
        r7.close()     // Catch:{ IOException -> 0x00b2 }
        goto L_0x00b3
    L_0x00b3:
        if (r8 == 0) goto L_0x00b8
        r8.close()     // Catch:{ IOException -> 0x00b8 }
    L_0x00b8:
        throw r9     // Catch:{ all -> 0x00d1 }
    L_0x00b9:
        r7 = r1
    L_0x00ba:
        r8 = r1
        r2 = r8
    L_0x00bc:
        if (r2 == 0) goto L_0x00c3
        r2.close()     // Catch:{ IOException -> 0x00c2 }
        goto L_0x00c3
    L_0x00c3:
        if (r7 == 0) goto L_0x00ca
        r7.close()     // Catch:{ IOException -> 0x00c9 }
        goto L_0x00ca
    L_0x00ca:
        if (r8 == 0) goto L_0x00cf
        r8.close()     // Catch:{ IOException -> 0x00cf }
    L_0x00cf:
        monitor-exit(r0)
        return r1
    L_0x00d1:
        r7 = move-exception
        monitor-exit(r0)
        throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.p605ep.commonbase.utils.FileUtil.getAssetGZipFile(android.content.Context, java.lang.String, java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x003c A[SYNTHETIC, Splitter:B:27:0x003c] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0043 A[SYNTHETIC, Splitter:B:34:0x0043] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x004a A[SYNTHETIC, Splitter:B:41:0x004a] */
    @java.lang.Deprecated
    public static java.lang.String getFileMD5(java.io.File r6) {
        /*
        r0 = 0
        isCancelGetMD5_SHA = r0
        r1 = 0
        java.lang.String r2 = "MD5"
        java.security.MessageDigest r2 = java.security.MessageDigest.getInstance(r2)     // Catch:{ IOException -> 0x0047, NoSuchAlgorithmException -> 0x0040, all -> 0x0039 }
        java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0047, NoSuchAlgorithmException -> 0x0040, all -> 0x0039 }
        r3.<init>(r6)     // Catch:{ IOException -> 0x0047, NoSuchAlgorithmException -> 0x0040, all -> 0x0039 }
        r6 = 8192(0x2000, float:1.14794E-41)
        byte[] r6 = new byte[r6]     // Catch:{ IOException -> 0x0037, NoSuchAlgorithmException -> 0x0035, all -> 0x0032 }
    L_0x0013:
        int r4 = r3.read(r6)     // Catch:{ IOException -> 0x0037, NoSuchAlgorithmException -> 0x0035, all -> 0x0032 }
        r5 = -1
        if (r4 == r5) goto L_0x0026
        boolean r5 = isCancelGetMD5_SHA     // Catch:{ IOException -> 0x0037, NoSuchAlgorithmException -> 0x0035, all -> 0x0032 }
        if (r5 == 0) goto L_0x0022
        r3.close()     // Catch:{ IOException -> 0x0021 }
    L_0x0021:
        return r1
    L_0x0022:
        r2.update(r6, r0, r4)     // Catch:{ IOException -> 0x0037, NoSuchAlgorithmException -> 0x0035, all -> 0x0032 }
        goto L_0x0013
    L_0x0026:
        byte[] r6 = r2.digest()     // Catch:{ IOException -> 0x0037, NoSuchAlgorithmException -> 0x0035, all -> 0x0032 }
        java.lang.String r6 = bytesToString(r6)     // Catch:{ IOException -> 0x0037, NoSuchAlgorithmException -> 0x0035, all -> 0x0032 }
        r3.close()     // Catch:{ IOException -> 0x0031 }
    L_0x0031:
        return r6
    L_0x0032:
        r6 = move-exception
        r1 = r3
        goto L_0x003a
        goto L_0x0041
        goto L_0x0048
    L_0x0039:
        r6 = move-exception
    L_0x003a:
        if (r1 == 0) goto L_0x003f
        r1.close()     // Catch:{ IOException -> 0x003f }
    L_0x003f:
        throw r6
    L_0x0040:
        r3 = r1
    L_0x0041:
        if (r3 == 0) goto L_0x0046
        r3.close()     // Catch:{ IOException -> 0x0046 }
    L_0x0046:
        return r1
    L_0x0047:
        r3 = r1
    L_0x0048:
        if (r3 == 0) goto L_0x004d
        r3.close()     // Catch:{ IOException -> 0x004d }
    L_0x004d:
        return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.p605ep.commonbase.utils.FileUtil.getFileMD5(java.io.File):java.lang.String");
    }

    public static String getFileNameByDir(String str) {
        String str2;
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf != -1) {
            int i = lastIndexOf + 1;
            if (i < str.length()) {
                str2 = str.substring(i);
                StringBuilder sb = new StringBuilder();
                sb.append(" QQWebSiteService lastIndex ");
                sb.append(lastIndexOf);
                sb.append(" fileName ");
                sb.append(str2);
                Log.m31483i("QQWebSiteService", sb.toString());
                return str2;
            }
        }
        str2 = null;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(" QQWebSiteService lastIndex ");
        sb2.append(lastIndexOf);
        sb2.append(" fileName ");
        sb2.append(str2);
        Log.m31483i("QQWebSiteService", sb2.toString());
        return str2;
    }

    public static String getFileParentDirByDir(String str) {
        int lastIndexOf = str.lastIndexOf("/");
        String substring = (lastIndexOf == -1 || lastIndexOf + 1 >= str.length()) ? null : str.substring(0, lastIndexOf);
        StringBuilder sb = new StringBuilder();
        sb.append(" QQWebSiteService lastIndex ");
        sb.append(lastIndexOf);
        sb.append(" fileParentDir ");
        sb.append(substring);
        Log.m31483i("QQWebSiteService", sb.toString());
        return substring;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x003c A[SYNTHETIC, Splitter:B:27:0x003c] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0043 A[SYNTHETIC, Splitter:B:34:0x0043] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x004a A[SYNTHETIC, Splitter:B:41:0x004a] */
    public static java.lang.String getFileSHA(java.io.File r6) {
        /*
        r0 = 0
        isCancelGetMD5_SHA = r0
        r1 = 0
        java.lang.String r2 = "SHA"
        java.security.MessageDigest r2 = java.security.MessageDigest.getInstance(r2)     // Catch:{ IOException -> 0x0047, NoSuchAlgorithmException -> 0x0040, all -> 0x0039 }
        java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0047, NoSuchAlgorithmException -> 0x0040, all -> 0x0039 }
        r3.<init>(r6)     // Catch:{ IOException -> 0x0047, NoSuchAlgorithmException -> 0x0040, all -> 0x0039 }
        r6 = 8192(0x2000, float:1.14794E-41)
        byte[] r6 = new byte[r6]     // Catch:{ IOException -> 0x0037, NoSuchAlgorithmException -> 0x0035, all -> 0x0032 }
    L_0x0013:
        int r4 = r3.read(r6)     // Catch:{ IOException -> 0x0037, NoSuchAlgorithmException -> 0x0035, all -> 0x0032 }
        r5 = -1
        if (r4 == r5) goto L_0x0026
        boolean r5 = isCancelGetMD5_SHA     // Catch:{ IOException -> 0x0037, NoSuchAlgorithmException -> 0x0035, all -> 0x0032 }
        if (r5 == 0) goto L_0x0022
        r3.close()     // Catch:{ IOException -> 0x0021 }
    L_0x0021:
        return r1
    L_0x0022:
        r2.update(r6, r0, r4)     // Catch:{ IOException -> 0x0037, NoSuchAlgorithmException -> 0x0035, all -> 0x0032 }
        goto L_0x0013
    L_0x0026:
        byte[] r6 = r2.digest()     // Catch:{ IOException -> 0x0037, NoSuchAlgorithmException -> 0x0035, all -> 0x0032 }
        java.lang.String r6 = bytesToString(r6)     // Catch:{ IOException -> 0x0037, NoSuchAlgorithmException -> 0x0035, all -> 0x0032 }
        r3.close()     // Catch:{ IOException -> 0x0031 }
    L_0x0031:
        return r6
    L_0x0032:
        r6 = move-exception
        r1 = r3
        goto L_0x003a
        goto L_0x0041
        goto L_0x0048
    L_0x0039:
        r6 = move-exception
    L_0x003a:
        if (r1 == 0) goto L_0x003f
        r1.close()     // Catch:{ IOException -> 0x003f }
    L_0x003f:
        throw r6
    L_0x0040:
        r3 = r1
    L_0x0041:
        if (r3 == 0) goto L_0x0046
        r3.close()     // Catch:{ IOException -> 0x0046 }
    L_0x0046:
        return r1
    L_0x0047:
        r3 = r1
    L_0x0048:
        if (r3 == 0) goto L_0x004d
        r3.close()     // Catch:{ IOException -> 0x004d }
    L_0x004d:
        return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.p605ep.commonbase.utils.FileUtil.getFileSHA(java.io.File):java.lang.String");
    }

    public static String getMIMEType(String str) {
        String lowerCase = str.substring(str.lastIndexOf(".") + 1, str.length()).toLowerCase();
        int i = 0;
        while (true) {
            String[][] strArr = MIME_TYPE_ARRAY;
            if (i >= strArr.length) {
                return "/*";
            }
            if (lowerCase.equals(strArr[i][0])) {
                return MIME_TYPE_ARRAY[i][1];
            }
            i++;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x006e A[SYNTHETIC, Splitter:B:29:0x006e] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0078 A[SYNTHETIC, Splitter:B:34:0x0078] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0085 A[SYNTHETIC, Splitter:B:44:0x0085] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x008f A[SYNTHETIC, Splitter:B:49:0x008f] */
    public static java.lang.String getResFilePath(android.content.Context r5, java.lang.String r6) {
        /*
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.io.File r1 = r5.getFilesDir()
        r0.append(r1)
        java.lang.String r1 = "/"
        r0.append(r1)
        r0.append(r6)
        java.lang.String r0 = r0.toString()
        r1 = 0
        java.io.File r2 = new java.io.File     // Catch:{ IOException -> 0x0081, all -> 0x0069 }
        r2.<init>(r0)     // Catch:{ IOException -> 0x0081, all -> 0x0069 }
        boolean r3 = r2.exists()     // Catch:{ IOException -> 0x0081, all -> 0x0069 }
        if (r3 != 0) goto L_0x0053
        android.content.res.Resources r5 = r5.getResources()     // Catch:{ IOException -> 0x0081, all -> 0x0069 }
        android.content.res.AssetManager r5 = r5.getAssets()     // Catch:{ IOException -> 0x0081, all -> 0x0069 }
        r3 = 1
        java.io.InputStream r5 = r5.open(r6, r3)     // Catch:{ IOException -> 0x0081, all -> 0x0069 }
        int r6 = r5.available()     // Catch:{ IOException -> 0x0082, all -> 0x0051 }
        byte[] r6 = new byte[r6]     // Catch:{ IOException -> 0x0082, all -> 0x0051 }
        r3 = 0
        int r4 = r5.available()     // Catch:{ IOException -> 0x0082, all -> 0x0051 }
        r5.read(r6, r3, r4)     // Catch:{ IOException -> 0x0082, all -> 0x0051 }
        checkAndCreadFile(r2)     // Catch:{ IOException -> 0x0082, all -> 0x0051 }
        java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0082, all -> 0x0051 }
        r3.<init>(r2)     // Catch:{ IOException -> 0x0082, all -> 0x0051 }
        r3.write(r6)     // Catch:{ IOException -> 0x004f, all -> 0x004c }
        r1 = r3
        goto L_0x0054
    L_0x004c:
        r6 = move-exception
        r1 = r3
        goto L_0x006c
        goto L_0x0083
    L_0x0051:
        r6 = move-exception
        goto L_0x006c
    L_0x0053:
        r5 = r1
    L_0x0054:
        if (r5 == 0) goto L_0x005e
        r5.close()     // Catch:{ IOException -> 0x005a }
        goto L_0x005e
    L_0x005a:
        r5 = move-exception
        r5.printStackTrace()
    L_0x005e:
        if (r1 == 0) goto L_0x0068
        r1.close()     // Catch:{ IOException -> 0x0064 }
        goto L_0x0068
    L_0x0064:
        r5 = move-exception
        r5.printStackTrace()
    L_0x0068:
        return r0
    L_0x0069:
        r5 = move-exception
        r6 = r5
        r5 = r1
    L_0x006c:
        if (r5 == 0) goto L_0x0076
        r5.close()     // Catch:{ IOException -> 0x0072 }
        goto L_0x0076
    L_0x0072:
        r5 = move-exception
        r5.printStackTrace()
    L_0x0076:
        if (r1 == 0) goto L_0x0080
        r1.close()     // Catch:{ IOException -> 0x007c }
        goto L_0x0080
    L_0x007c:
        r5 = move-exception
        r5.printStackTrace()
    L_0x0080:
        throw r6
    L_0x0081:
        r5 = r1
    L_0x0082:
        r3 = r1
    L_0x0083:
        if (r5 == 0) goto L_0x008d
        r5.close()     // Catch:{ IOException -> 0x0089 }
        goto L_0x008d
    L_0x0089:
        r5 = move-exception
        r5.printStackTrace()
    L_0x008d:
        if (r3 == 0) goto L_0x0097
        r3.close()     // Catch:{ IOException -> 0x0093 }
        goto L_0x0097
    L_0x0093:
        r5 = move-exception
        r5.printStackTrace()
    L_0x0097:
        return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.p605ep.commonbase.utils.FileUtil.getResFilePath(android.content.Context, java.lang.String):java.lang.String");
    }

    public static int getSdcardStatus(long j) {
        if (!SdcardUtil.hasStorageCard()) {
            return 1;
        }
        if (!hasStorageCardReadWritePermission()) {
            return 2;
        }
        SizeInfo sizeInfo = new SizeInfo();
        SdcardUtil.getStorageCardSize(sizeInfo);
        return sizeInfo.availableSize < j ? 3 : 0;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:56|57|(2:59|60)|(2:63|64)|65|66) */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000b, code lost:
            if (r7.equals("") != false) goto L_0x000d;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:65:0x00a1 */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0086 A[SYNTHETIC, Splitter:B:47:0x0086] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x008d A[SYNTHETIC, Splitter:B:51:0x008d] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0097 A[SYNTHETIC, Splitter:B:59:0x0097] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x009e A[SYNTHETIC, Splitter:B:63:0x009e] */
    public static synchronized java.lang.String getSimpleAssetFile(android.content.Context r5, java.lang.String r6, java.lang.String r7) {
        /*
        java.lang.Class<com.tencent.ep.commonbase.utils.FileUtil> r0 = com.tencent.p605ep.commonbase.utils.FileUtil.class
        monitor-enter(r0)
        if (r7 == 0) goto L_0x000d
        java.lang.String r1 = ""
        boolean r1 = r7.equals(r1)     // Catch:{ all -> 0x00a2 }
        if (r1 == 0) goto L_0x0015
    L_0x000d:
        java.io.File r7 = r5.getFilesDir()     // Catch:{ all -> 0x00a2 }
        java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00a2 }
    L_0x0015:
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a2 }
        r1.<init>()     // Catch:{ all -> 0x00a2 }
        r1.append(r7)     // Catch:{ all -> 0x00a2 }
        java.lang.String r7 = java.io.File.separator     // Catch:{ all -> 0x00a2 }
        r1.append(r7)     // Catch:{ all -> 0x00a2 }
        r1.append(r6)     // Catch:{ all -> 0x00a2 }
        java.lang.String r7 = r1.toString()     // Catch:{ all -> 0x00a2 }
        r1 = 0
        java.io.File r2 = new java.io.File     // Catch:{ IOException -> 0x0079, all -> 0x0076 }
        r2.<init>(r7)     // Catch:{ IOException -> 0x0079, all -> 0x0076 }
        boolean r3 = r2.exists()     // Catch:{ IOException -> 0x0079, all -> 0x0076 }
        if (r3 != 0) goto L_0x0066
        deleteFile(r2)     // Catch:{ IOException -> 0x0079, all -> 0x0076 }
        android.content.res.Resources r5 = r5.getResources()     // Catch:{ IOException -> 0x0079, all -> 0x0076 }
        android.content.res.AssetManager r5 = r5.getAssets()     // Catch:{ IOException -> 0x0079, all -> 0x0076 }
        r3 = 1
        java.io.InputStream r5 = r5.open(r6, r3)     // Catch:{ IOException -> 0x0079, all -> 0x0076 }
        java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x007a, all -> 0x0064 }
        r6.<init>(r2)     // Catch:{ IOException -> 0x007a, all -> 0x0064 }
        r1 = 8192(0x2000, float:1.14794E-41)
        byte[] r1 = new byte[r1]     // Catch:{ IOException -> 0x007b }
    L_0x004e:
        int r2 = r5.read(r1)     // Catch:{ IOException -> 0x007b }
        if (r2 <= 0) goto L_0x0059
        r4 = 0
        r6.write(r1, r4, r2)     // Catch:{ IOException -> 0x007b }
        goto L_0x004e
    L_0x0059:
        java.nio.channels.FileChannel r1 = r6.getChannel()     // Catch:{ IOException -> 0x007b }
        r1.force(r3)     // Catch:{ IOException -> 0x007b }
        r6.flush()     // Catch:{ IOException -> 0x007b }
        goto L_0x0068
    L_0x0064:
        r6 = move-exception
        goto L_0x0095
    L_0x0066:
        r5 = r1
        r6 = r5
    L_0x0068:
        if (r5 == 0) goto L_0x006f
        r5.close()     // Catch:{ IOException -> 0x006e }
        goto L_0x006f
    L_0x006f:
        if (r6 == 0) goto L_0x0074
        r6.close()     // Catch:{ IOException -> 0x0074 }
    L_0x0074:
        monitor-exit(r0)
        return r7
    L_0x0076:
        r6 = move-exception
        r5 = r1
        goto L_0x0095
    L_0x0079:
        r5 = r1
    L_0x007a:
        r6 = r1
    L_0x007b:
        java.lang.String r7 = "getSimpleAssetFile"
        java.lang.String r1 = "getSimpleAssetFile error"
        com.tencent.p605ep.commonbase.api.Log.m31479e(r7, r1)     // Catch:{ all -> 0x0092 }
        java.lang.String r7 = ""
        if (r5 == 0) goto L_0x008b
        r5.close()     // Catch:{ IOException -> 0x008a }
        goto L_0x008b
    L_0x008b:
        if (r6 == 0) goto L_0x0090
        r6.close()     // Catch:{ IOException -> 0x0090 }
    L_0x0090:
        monitor-exit(r0)
        return r7
    L_0x0092:
        r7 = move-exception
        r1 = r6
        r6 = r7
    L_0x0095:
        if (r5 == 0) goto L_0x009c
        r5.close()     // Catch:{ IOException -> 0x009b }
        goto L_0x009c
    L_0x009c:
        if (r1 == 0) goto L_0x00a1
        r1.close()     // Catch:{ IOException -> 0x00a1 }
    L_0x00a1:
        throw r6     // Catch:{ all -> 0x00a2 }
    L_0x00a2:
        r5 = move-exception
        monitor-exit(r0)
        throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.p605ep.commonbase.utils.FileUtil.getSimpleAssetFile(android.content.Context, java.lang.String, java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    public static final java.lang.String guessFileName(java.lang.String r2, java.lang.String r3) {
        /*
        java.lang.String r2 = android.net.Uri.decode(r2)
        if (r2 == 0) goto L_0x002a
        r0 = 63
        int r0 = r2.indexOf(r0)
        if (r0 <= 0) goto L_0x0013
        r1 = 0
        java.lang.String r2 = r2.substring(r1, r0)
    L_0x0013:
        java.lang.String r0 = "/"
        boolean r0 = r2.endsWith(r0)
        if (r0 != 0) goto L_0x002a
        r0 = 47
        int r0 = r2.lastIndexOf(r0)
        int r0 = r0 + 1
        if (r0 <= 0) goto L_0x002a
        java.lang.String r2 = r2.substring(r0)
        goto L_0x002b
    L_0x002a:
        r2 = 0
    L_0x002b:
        if (r2 != 0) goto L_0x002e
        r2 = r3
    L_0x002e:
        if (r2 != 0) goto L_0x0032
        java.lang.String r2 = "downloadfile"
    L_0x0032:
        return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.p605ep.commonbase.utils.FileUtil.guessFileName(java.lang.String, java.lang.String):java.lang.String");
    }

    public static boolean hasStorageCardReadWritePermission() {
        StringBuilder sb = new StringBuilder();
        sb.append(SdcardUtil.getExternalStorageDirectory().toString());
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

    /* access modifiers changed from: private|static */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0032 A[SYNTHETIC, Splitter:B:22:0x0032] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0039 A[SYNTHETIC, Splitter:B:28:0x0039] */
    public static boolean isApkFile(java.io.File r6) {
        /*
        boolean r0 = r6.isDirectory()
        r1 = 0
        if (r0 != 0) goto L_0x003c
        long r2 = r6.length()
        r4 = 4
        int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
        if (r0 <= 0) goto L_0x003c
        r0 = 0
        java.io.DataInputStream r2 = new java.io.DataInputStream     // Catch:{ IOException -> 0x0036, all -> 0x002f }
        java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0036, all -> 0x002f }
        r3.<init>(r6)     // Catch:{ IOException -> 0x0036, all -> 0x002f }
        r2.<init>(r3)     // Catch:{ IOException -> 0x0036, all -> 0x002f }
        int r6 = r2.readInt()     // Catch:{ IOException -> 0x002d, all -> 0x002a }
        r0 = 1347093252(0x504b0304, float:1.36238899E10)
        if (r6 != r0) goto L_0x0026
        r1 = 1
    L_0x0026:
        r2.close()     // Catch:{ IOException -> 0x0029 }
    L_0x0029:
        return r1
    L_0x002a:
        r6 = move-exception
        r0 = r2
        goto L_0x0030
    L_0x002d:
        r0 = r2
        goto L_0x0037
    L_0x002f:
        r6 = move-exception
    L_0x0030:
        if (r0 == 0) goto L_0x0035
        r0.close()     // Catch:{ IOException -> 0x0035 }
    L_0x0035:
        throw r6
    L_0x0037:
        if (r0 == 0) goto L_0x003c
        r0.close()     // Catch:{ IOException -> 0x003c }
    L_0x003c:
        return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.p605ep.commonbase.utils.FileUtil.isApkFile(java.io.File):boolean");
    }

    public static boolean isContainFolderErrorChar(String str) {
        return (str.indexOf("\\") == -1 && str.indexOf("/") == -1 && str.indexOf(":") == -1 && str.indexOf(Marker.ANY_MARKER) == -1 && str.indexOf("?") == -1 && str.indexOf("\"") == -1 && str.indexOf("<") == -1 && str.indexOf(">") == -1 && str.indexOf("|") == -1) ? false : true;
    }

    public static boolean isFileExist(String str) {
        return new File(str).exists();
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARNING: type inference failed for: r0v4, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r6v4, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: type inference failed for: r6v8 */
    /* JADX WARNING: type inference failed for: r6v11 */
    /* JADX WARNING: type inference failed for: r6v13, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARNING: type inference failed for: r0v9, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r0v10 */
    /* JADX WARNING: type inference failed for: r0v11 */
    /* JADX WARNING: type inference failed for: r6v15 */
    /* JADX WARNING: type inference failed for: r0v12 */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0047, code lost:
            if (r1 == null) goto L_0x0051;
     */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v9, types: [byte[]]
  assigns: [byte[], ?[int, float, boolean, short, byte, char, OBJECT, ARRAY], ?[OBJECT, ARRAY]]
  uses: [?[int, boolean, OBJECT, ARRAY, byte, short, char], byte[], java.io.ByteArrayOutputStream]
	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:231)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:95)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:88)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:30)
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
	at jadx.core.ProcessClass.process(ProcessClass.java:35)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
 */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x003f A[SYNTHETIC, Splitter:B:27:0x003f] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0061 A[SYNTHETIC, Splitter:B:41:0x0061] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x006b A[SYNTHETIC, Splitter:B:46:0x006b] */
    /* JADX WARNING: Unknown variable types count: 3 */
    public static byte[] loadFile(java.lang.String r6) {
        /*
        r0 = 0
        java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0036, all -> 0x0033 }
        r1.<init>(r6)     // Catch:{ IOException -> 0x0036, all -> 0x0033 }
        java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x002f, all -> 0x002d }
        int r2 = r1.available()     // Catch:{ IOException -> 0x002f, all -> 0x002d }
        r6.<init>(r2)     // Catch:{ IOException -> 0x002f, all -> 0x002d }
        r2 = 1024(0x400, float:1.435E-42)
        byte[] r2 = new byte[r2]     // Catch:{ IOException -> 0x002b }
    L_0x0013:
        int r3 = r1.read(r2)     // Catch:{ IOException -> 0x002b }
        if (r3 < 0) goto L_0x001e
        r4 = 0
        r6.write(r2, r4, r3)     // Catch:{ IOException -> 0x002b }
        goto L_0x0013
    L_0x001e:
        byte[] r0 = r6.toByteArray()     // Catch:{ IOException -> 0x002b }
        r6.close()     // Catch:{ IOException -> 0x0026 }
        goto L_0x0049
    L_0x0026:
        r6 = move-exception
        r6.printStackTrace()
        goto L_0x0049
    L_0x002b:
        r2 = move-exception
        goto L_0x003a
    L_0x002d:
        r6 = move-exception
        goto L_0x005f
    L_0x002f:
        r6 = move-exception
        r2 = r6
        r6 = r0
        goto L_0x003a
    L_0x0033:
        r6 = move-exception
        r1 = r0
        goto L_0x005f
    L_0x0036:
        r6 = move-exception
        r2 = r6
        r6 = r0
        r1 = r6
    L_0x003a:
        r2.printStackTrace()     // Catch:{ all -> 0x005b }
        if (r6 == 0) goto L_0x0047
        r6.close()     // Catch:{ IOException -> 0x0043 }
        goto L_0x0047
    L_0x0043:
        r6 = move-exception
        r6.printStackTrace()
    L_0x0047:
        if (r1 == 0) goto L_0x0051
    L_0x0049:
        r1.close()     // Catch:{ IOException -> 0x004d }
        goto L_0x0051
    L_0x004d:
        r6 = move-exception
        r6.printStackTrace()
    L_0x0051:
        if (r0 == 0) goto L_0x0054
        goto L_0x005a
    L_0x0054:
        java.lang.String r6 = ""
        byte[] r0 = r6.getBytes()
    L_0x005a:
        return r0
    L_0x005b:
        r0 = move-exception
        r5 = r0
        r0 = r6
        r6 = r5
    L_0x005f:
        if (r0 == 0) goto L_0x0069
        r0.close()     // Catch:{ IOException -> 0x0065 }
        goto L_0x0069
    L_0x0065:
        r0 = move-exception
        r0.printStackTrace()
    L_0x0069:
        if (r1 == 0) goto L_0x0073
        r1.close()     // Catch:{ IOException -> 0x006f }
        goto L_0x0073
    L_0x006f:
        r0 = move-exception
        r0.printStackTrace()
    L_0x0073:
        throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.p605ep.commonbase.utils.FileUtil.loadFile(java.lang.String):byte[]");
    }

    public static Object loadWupObjectFromFile(Context context, String str, String str2, Object obj) {
        if (context == null || str == null || str2 == null) {
            return null;
        }
        return loadWupObjectFromFile(str, new File(context.getFilesDir(), str2), obj);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0072, code lost:
            if (r6 == null) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0081, code lost:
            if (r6 == null) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
            r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0093, code lost:
            if (r6 == null) goto L_0x0096;
     */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x006a A[SYNTHETIC, Splitter:B:40:0x006a] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0079 A[SYNTHETIC, Splitter:B:48:0x0079] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x008b A[SYNTHETIC, Splitter:B:58:0x008b] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:24:0x0051=Splitter:B:24:0x0051, B:53:0x0083=Splitter:B:53:0x0083} */
    public static java.lang.Object loadWupObjectFromFile(java.lang.String r5, java.io.File r6, java.lang.Object r7) {
        /*
        r0 = 0
        if (r5 == 0) goto L_0x0096
        if (r6 == 0) goto L_0x0096
        boolean r1 = r6.exists()
        if (r1 != 0) goto L_0x000d
        goto L_0x0096
    L_0x000d:
        java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0087, IOException -> 0x0075, all -> 0x0066 }
        r1.<init>(r6)     // Catch:{ FileNotFoundException -> 0x0087, IOException -> 0x0075, all -> 0x0066 }
        java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream     // Catch:{ FileNotFoundException -> 0x0064, IOException -> 0x0062, all -> 0x0060 }
        r6.<init>()     // Catch:{ FileNotFoundException -> 0x0064, IOException -> 0x0062, all -> 0x0060 }
        r2 = 1024(0x400, float:1.435E-42)
        byte[] r2 = new byte[r2]     // Catch:{ FileNotFoundException -> 0x005e, IOException -> 0x005c, all -> 0x005a }
    L_0x001b:
        int r3 = r1.read(r2)     // Catch:{ FileNotFoundException -> 0x005e, IOException -> 0x005c, all -> 0x005a }
        r4 = -1
        if (r3 == r4) goto L_0x0027
        r4 = 0
        r6.write(r2, r4, r3)     // Catch:{ FileNotFoundException -> 0x005e, IOException -> 0x005c, all -> 0x005a }
        goto L_0x001b
    L_0x0027:
        byte[] r2 = r6.toByteArray()     // Catch:{ FileNotFoundException -> 0x005e, IOException -> 0x005c, all -> 0x005a }
        com.qq.jce.wup.UniAttribute r3 = new com.qq.jce.wup.UniAttribute     // Catch:{ FileNotFoundException -> 0x005e, IOException -> 0x005c, all -> 0x005a }
        r3.m50931init()     // Catch:{ FileNotFoundException -> 0x005e, IOException -> 0x005c, all -> 0x005a }
        java.lang.String r4 = "UTF-8"
        r3.setEncodeName(r4)     // Catch:{ FileNotFoundException -> 0x005e, IOException -> 0x005c, all -> 0x005a }
        byte[] r2 = com.tencent.p605ep.commonbase.utils.XxteaCryptor.decryptV2(r2, r0)     // Catch:{ FileNotFoundException -> 0x005e, IOException -> 0x005c, all -> 0x005a }
        r3.decode(r2)     // Catch:{ FileNotFoundException -> 0x005e, IOException -> 0x005c, all -> 0x005a }
        if (r7 == 0) goto L_0x0044
        java.lang.Object r5 = r3.getByClass(r5, r7)     // Catch:{ FileNotFoundException -> 0x005e, IOException -> 0x005c, all -> 0x005a }
    L_0x0042:
        r0 = r5
        goto L_0x0049
    L_0x0044:
        java.lang.Object r5 = r3.get(r5)     // Catch:{ FileNotFoundException -> 0x005e, IOException -> 0x005c, all -> 0x005a }
        goto L_0x0042
    L_0x0049:
        r1.close()     // Catch:{ IOException -> 0x004d }
        goto L_0x0051
    L_0x004d:
        r5 = move-exception
        r5.printStackTrace()
    L_0x0051:
        r6.close()     // Catch:{ IOException -> 0x0055 }
        goto L_0x0096
    L_0x0055:
        r5 = move-exception
        r5.printStackTrace()
        goto L_0x0096
        goto L_0x0068
        goto L_0x0077
        goto L_0x0089
    L_0x0060:
        r6 = r0
        goto L_0x0068
    L_0x0062:
        r6 = r0
        goto L_0x0077
    L_0x0064:
        r6 = r0
        goto L_0x0089
    L_0x0066:
        r6 = r0
        r1 = r6
    L_0x0068:
        if (r1 == 0) goto L_0x0072
        r1.close()     // Catch:{ IOException -> 0x006e }
        goto L_0x0072
    L_0x006e:
        r5 = move-exception
        r5.printStackTrace()
    L_0x0072:
        if (r6 == 0) goto L_0x0096
        goto L_0x0095
    L_0x0075:
        r6 = r0
        r1 = r6
    L_0x0077:
        if (r1 == 0) goto L_0x0081
        r1.close()     // Catch:{ IOException -> 0x007d }
        goto L_0x0081
    L_0x007d:
        r5 = move-exception
        r5.printStackTrace()
    L_0x0081:
        if (r6 == 0) goto L_0x0096
    L_0x0083:
        r6.close()     // Catch:{ IOException -> 0x0055 }
        goto L_0x0096
    L_0x0087:
        r6 = r0
        r1 = r6
    L_0x0089:
        if (r1 == 0) goto L_0x0093
        r1.close()     // Catch:{ IOException -> 0x008f }
        goto L_0x0093
    L_0x008f:
        r5 = move-exception
        r5.printStackTrace()
    L_0x0093:
        if (r6 == 0) goto L_0x0096
    L_0x0095:
        goto L_0x0083
    L_0x0096:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.p605ep.commonbase.utils.FileUtil.loadWupObjectFromFile(java.lang.String, java.io.File, java.lang.Object):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0067, code lost:
            if (r6 != null) goto L_0x0069;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x007a, code lost:
            if (r6 != null) goto L_0x0069;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x008a, code lost:
            if (r6 != null) goto L_0x0069;
     */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x005f A[SYNTHETIC, Splitter:B:38:0x005f] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0072 A[SYNTHETIC, Splitter:B:50:0x0072] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0082 A[SYNTHETIC, Splitter:B:60:0x0082] */
    public static <T> java.util.ArrayList<T> loadWupObjectListFromFile(android.content.Context r4, java.lang.String r5, java.lang.String r6, T r7) {
        /*
        r0 = 0
        if (r5 == 0) goto L_0x0092
        if (r6 != 0) goto L_0x0007
        goto L_0x0092
    L_0x0007:
        java.io.FileInputStream r4 = r4.openFileInput(r6)     // Catch:{ FileNotFoundException -> 0x007d, IOException -> 0x006d, all -> 0x005a }
        java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream     // Catch:{ FileNotFoundException -> 0x007e, IOException -> 0x006e, all -> 0x005b }
        r6.<init>()     // Catch:{ FileNotFoundException -> 0x007e, IOException -> 0x006e, all -> 0x005b }
        r1 = 1024(0x400, float:1.435E-42)
        byte[] r1 = new byte[r1]     // Catch:{ FileNotFoundException -> 0x0058, IOException -> 0x0056, all -> 0x0054 }
    L_0x0014:
        int r2 = r4.read(r1)     // Catch:{ FileNotFoundException -> 0x0058, IOException -> 0x0056, all -> 0x0054 }
        r3 = -1
        if (r2 == r3) goto L_0x0020
        r3 = 0
        r6.write(r1, r3, r2)     // Catch:{ FileNotFoundException -> 0x0058, IOException -> 0x0056, all -> 0x0054 }
        goto L_0x0014
    L_0x0020:
        byte[] r1 = r6.toByteArray()     // Catch:{ FileNotFoundException -> 0x0058, IOException -> 0x0056, all -> 0x0054 }
        com.qq.jce.wup.UniAttribute r2 = new com.qq.jce.wup.UniAttribute     // Catch:{ FileNotFoundException -> 0x0058, IOException -> 0x0056, all -> 0x0054 }
        r2.m50931init()     // Catch:{ FileNotFoundException -> 0x0058, IOException -> 0x0056, all -> 0x0054 }
        java.lang.String r3 = "UTF-8"
        r2.setEncodeName(r3)     // Catch:{ FileNotFoundException -> 0x0058, IOException -> 0x0056, all -> 0x0054 }
        byte[] r1 = com.tencent.p605ep.commonbase.utils.XxteaCryptor.decryptV2(r1, r0)     // Catch:{ FileNotFoundException -> 0x0058, IOException -> 0x0056, all -> 0x0054 }
        r2.decode(r1)     // Catch:{ FileNotFoundException -> 0x0058, IOException -> 0x0056, all -> 0x0054 }
        java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ FileNotFoundException -> 0x0058, IOException -> 0x0056, all -> 0x0054 }
        r1.<init>()     // Catch:{ FileNotFoundException -> 0x0058, IOException -> 0x0056, all -> 0x0054 }
        r1.add(r7)     // Catch:{ FileNotFoundException -> 0x0052, IOException -> 0x0050, all -> 0x004e }
        java.lang.Object r5 = r2.getByClass(r5, r1)     // Catch:{ FileNotFoundException -> 0x0052, IOException -> 0x0050, all -> 0x004e }
        java.util.ArrayList r5 = (java.util.ArrayList) r5     // Catch:{ FileNotFoundException -> 0x0052, IOException -> 0x0050, all -> 0x004e }
        if (r4 == 0) goto L_0x0069
        r4.close()     // Catch:{ IOException -> 0x0049 }
        goto L_0x0069
    L_0x0049:
        r4 = move-exception
        r4.printStackTrace()
        goto L_0x0069
    L_0x004e:
        r5 = r1
        goto L_0x005d
    L_0x0050:
        r5 = r1
        goto L_0x0070
    L_0x0052:
        r5 = r1
        goto L_0x0080
    L_0x0054:
        r5 = r0
        goto L_0x005d
    L_0x0056:
        r5 = r0
        goto L_0x0070
    L_0x0058:
        r5 = r0
        goto L_0x0080
    L_0x005a:
        r4 = r0
    L_0x005b:
        r5 = r0
        r6 = r5
    L_0x005d:
        if (r4 == 0) goto L_0x0067
        r4.close()     // Catch:{ IOException -> 0x0063 }
        goto L_0x0067
    L_0x0063:
        r4 = move-exception
        r4.printStackTrace()
    L_0x0067:
        if (r6 == 0) goto L_0x0091
    L_0x0069:
        r6.close()     // Catch:{ IOException -> 0x008d }
        goto L_0x0091
    L_0x006d:
        r4 = r0
    L_0x006e:
        r5 = r0
        r6 = r5
    L_0x0070:
        if (r4 == 0) goto L_0x007a
        r4.close()     // Catch:{ IOException -> 0x0076 }
        goto L_0x007a
    L_0x0076:
        r4 = move-exception
        r4.printStackTrace()
    L_0x007a:
        if (r6 == 0) goto L_0x0091
        goto L_0x008c
    L_0x007d:
        r4 = r0
    L_0x007e:
        r5 = r0
        r6 = r5
    L_0x0080:
        if (r4 == 0) goto L_0x008a
        r4.close()     // Catch:{ IOException -> 0x0086 }
        goto L_0x008a
    L_0x0086:
        r4 = move-exception
        r4.printStackTrace()
    L_0x008a:
        if (r6 == 0) goto L_0x0091
    L_0x008c:
        goto L_0x0069
    L_0x008d:
        r4 = move-exception
        r4.printStackTrace()
    L_0x0091:
        return r5
    L_0x0092:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.p605ep.commonbase.utils.FileUtil.loadWupObjectListFromFile(android.content.Context, java.lang.String, java.lang.String, java.lang.Object):java.util.ArrayList");
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARNING: type inference failed for: r0v4, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARNING: type inference failed for: r0v5, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: type inference failed for: r0v10 */
    /* JADX WARNING: type inference failed for: r0v13 */
    /* JADX WARNING: type inference failed for: r0v14 */
    /* JADX WARNING: type inference failed for: r0v15 */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0069, code lost:
            if (r1 == 0) goto L_0x0073;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
            r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x006f, code lost:
            r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0070, code lost:
            r5.printStackTrace();
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x004f A[SYNTHETIC, Splitter:B:32:0x004f] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0061 A[SYNTHETIC, Splitter:B:42:0x0061] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:29:0x004a=Splitter:B:29:0x004a, B:39:0x005c=Splitter:B:39:0x005c} */
    /* JADX WARNING: Unknown variable types count: 3 */
    public static java.lang.String readFile(java.lang.String r5) {
        /*
        r0 = 0
        java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch:{ FileNotFoundException -> 0x005a, all -> 0x0048 }
        java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x005a, all -> 0x0048 }
        r2.<init>(r5)     // Catch:{ FileNotFoundException -> 0x005a, all -> 0x0048 }
        r1.<init>(r2)     // Catch:{ FileNotFoundException -> 0x005a, all -> 0x0048 }
        java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream     // Catch:{ FileNotFoundException -> 0x0046, all -> 0x0044 }
        r5.<init>()     // Catch:{ FileNotFoundException -> 0x0046, all -> 0x0044 }
        r0 = 1024(0x400, float:1.435E-42)
        byte[] r0 = new byte[r0]     // Catch:{ FileNotFoundException -> 0x003f, all -> 0x003a }
    L_0x0014:
        int r2 = r1.read(r0)     // Catch:{ FileNotFoundException -> 0x003f, all -> 0x003a }
        r3 = -1
        if (r2 == r3) goto L_0x0020
        r3 = 0
        r5.write(r0, r3, r2)     // Catch:{ FileNotFoundException -> 0x003f, all -> 0x003a }
        goto L_0x0014
    L_0x0020:
        java.lang.String r0 = new java.lang.String     // Catch:{ FileNotFoundException -> 0x003f, all -> 0x003a }
        byte[] r2 = r5.toByteArray()     // Catch:{ FileNotFoundException -> 0x003f, all -> 0x003a }
        r0.<init>(r2)     // Catch:{ FileNotFoundException -> 0x003f, all -> 0x003a }
        r5.close()     // Catch:{ IOException -> 0x002d }
        goto L_0x0031
    L_0x002d:
        r5 = move-exception
        r5.printStackTrace()
    L_0x0031:
        r1.close()     // Catch:{ IOException -> 0x0035 }
        goto L_0x0039
    L_0x0035:
        r5 = move-exception
        r5.printStackTrace()
    L_0x0039:
        return r0
    L_0x003a:
        r0 = move-exception
        r4 = r0
        r0 = r5
        r5 = r4
        goto L_0x004a
    L_0x003f:
        r0 = move-exception
        r4 = r0
        r0 = r5
        r5 = r4
        goto L_0x005c
    L_0x0044:
        r5 = move-exception
        goto L_0x004a
    L_0x0046:
        r5 = move-exception
        goto L_0x005c
    L_0x0048:
        r5 = move-exception
        r1 = r0
    L_0x004a:
        r5.printStackTrace()     // Catch:{ all -> 0x0076 }
        if (r0 == 0) goto L_0x0057
        r0.close()     // Catch:{ IOException -> 0x0053 }
        goto L_0x0057
    L_0x0053:
        r5 = move-exception
        r5.printStackTrace()
    L_0x0057:
        if (r1 == 0) goto L_0x0073
        goto L_0x006b
    L_0x005a:
        r5 = move-exception
        r1 = r0
    L_0x005c:
        r5.printStackTrace()     // Catch:{ all -> 0x0076 }
        if (r0 == 0) goto L_0x0069
        r0.close()     // Catch:{ IOException -> 0x0065 }
        goto L_0x0069
    L_0x0065:
        r5 = move-exception
        r5.printStackTrace()
    L_0x0069:
        if (r1 == 0) goto L_0x0073
    L_0x006b:
        r1.close()     // Catch:{ IOException -> 0x006f }
        goto L_0x0073
    L_0x006f:
        r5 = move-exception
        r5.printStackTrace()
    L_0x0073:
        java.lang.String r5 = ""
        return r5
    L_0x0076:
        r5 = move-exception
        if (r0 == 0) goto L_0x0081
        r0.close()     // Catch:{ IOException -> 0x007d }
        goto L_0x0081
    L_0x007d:
        r0 = move-exception
        r0.printStackTrace()
    L_0x0081:
        if (r1 == 0) goto L_0x008b
        r1.close()     // Catch:{ IOException -> 0x0087 }
        goto L_0x008b
    L_0x0087:
        r0 = move-exception
        r0.printStackTrace()
    L_0x008b:
        throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.p605ep.commonbase.utils.FileUtil.readFile(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:52:0x007e, code lost:
            if (r5 == null) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
            r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0095, code lost:
            if (r5 == null) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x00a9, code lost:
            if (r5 == null) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x00ac, code lost:
            r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x00ad, code lost:
            r5.printStackTrace();
     */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0062 A[SYNTHETIC, Splitter:B:38:0x0062] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0076 A[SYNTHETIC, Splitter:B:48:0x0076] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x008d A[SYNTHETIC, Splitter:B:60:0x008d] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00a1 A[SYNTHETIC, Splitter:B:70:0x00a1] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:45:0x0071=Splitter:B:45:0x0071, B:57:0x0088=Splitter:B:57:0x0088, B:67:0x009c=Splitter:B:67:0x009c, B:35:0x005d=Splitter:B:35:0x005d} */
    public static java.lang.String[] readLinesFromFile(java.lang.String r5) {
        /*
        r0 = 0
        java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch:{ PatternSyntaxException -> 0x0098, FileNotFoundException -> 0x0084, IOException -> 0x006d, all -> 0x0059 }
        java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ PatternSyntaxException -> 0x0098, FileNotFoundException -> 0x0084, IOException -> 0x006d, all -> 0x0059 }
        r2.<init>(r5)     // Catch:{ PatternSyntaxException -> 0x0098, FileNotFoundException -> 0x0084, IOException -> 0x006d, all -> 0x0059 }
        r1.<init>(r2)     // Catch:{ PatternSyntaxException -> 0x0098, FileNotFoundException -> 0x0084, IOException -> 0x006d, all -> 0x0059 }
        java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream     // Catch:{ PatternSyntaxException -> 0x0055, FileNotFoundException -> 0x0051, IOException -> 0x004d, all -> 0x0049 }
        r5.<init>()     // Catch:{ PatternSyntaxException -> 0x0055, FileNotFoundException -> 0x0051, IOException -> 0x004d, all -> 0x0049 }
        r2 = 1024(0x400, float:1.435E-42)
        byte[] r2 = new byte[r2]     // Catch:{ PatternSyntaxException -> 0x0046, FileNotFoundException -> 0x0044, IOException -> 0x0042, all -> 0x0040 }
    L_0x0014:
        int r3 = r1.read(r2)     // Catch:{ PatternSyntaxException -> 0x0046, FileNotFoundException -> 0x0044, IOException -> 0x0042, all -> 0x0040 }
        r4 = -1
        if (r3 == r4) goto L_0x0020
        r4 = 0
        r5.write(r2, r4, r3)     // Catch:{ PatternSyntaxException -> 0x0046, FileNotFoundException -> 0x0044, IOException -> 0x0042, all -> 0x0040 }
        goto L_0x0014
    L_0x0020:
        java.lang.String r2 = new java.lang.String     // Catch:{ PatternSyntaxException -> 0x0046, FileNotFoundException -> 0x0044, IOException -> 0x0042, all -> 0x0040 }
        byte[] r3 = r5.toByteArray()     // Catch:{ PatternSyntaxException -> 0x0046, FileNotFoundException -> 0x0044, IOException -> 0x0042, all -> 0x0040 }
        r2.<init>(r3)     // Catch:{ PatternSyntaxException -> 0x0046, FileNotFoundException -> 0x0044, IOException -> 0x0042, all -> 0x0040 }
        java.lang.String r3 = "\\n"
        java.lang.String[] r0 = r2.split(r3)     // Catch:{ PatternSyntaxException -> 0x0046, FileNotFoundException -> 0x0044, IOException -> 0x0042, all -> 0x0040 }
        r1.close()     // Catch:{ IOException -> 0x0033 }
        goto L_0x0037
    L_0x0033:
        r1 = move-exception
        r1.printStackTrace()
    L_0x0037:
        r5.close()     // Catch:{ IOException -> 0x003b }
        goto L_0x003f
    L_0x003b:
        r5 = move-exception
        r5.printStackTrace()
    L_0x003f:
        return r0
    L_0x0040:
        r2 = move-exception
        goto L_0x005d
    L_0x0042:
        r2 = move-exception
        goto L_0x0071
    L_0x0044:
        r2 = move-exception
        goto L_0x0088
    L_0x0046:
        r2 = move-exception
        goto L_0x009c
    L_0x0049:
        r5 = move-exception
        r2 = r5
        r5 = r0
        goto L_0x005d
    L_0x004d:
        r5 = move-exception
        r2 = r5
        r5 = r0
        goto L_0x0071
    L_0x0051:
        r5 = move-exception
        r2 = r5
        r5 = r0
        goto L_0x0088
    L_0x0055:
        r5 = move-exception
        r2 = r5
        r5 = r0
        goto L_0x009c
    L_0x0059:
        r5 = move-exception
        r2 = r5
        r5 = r0
        r1 = r5
    L_0x005d:
        r2.printStackTrace()     // Catch:{ all -> 0x00b1 }
        if (r1 == 0) goto L_0x006a
        r1.close()     // Catch:{ IOException -> 0x0066 }
        goto L_0x006a
    L_0x0066:
        r1 = move-exception
        r1.printStackTrace()
    L_0x006a:
        if (r5 == 0) goto L_0x00b0
        goto L_0x00ab
    L_0x006d:
        r5 = move-exception
        r2 = r5
        r5 = r0
        r1 = r5
    L_0x0071:
        r2.printStackTrace()     // Catch:{ all -> 0x00b1 }
        if (r1 == 0) goto L_0x007e
        r1.close()     // Catch:{ IOException -> 0x007a }
        goto L_0x007e
    L_0x007a:
        r1 = move-exception
        r1.printStackTrace()
    L_0x007e:
        if (r5 == 0) goto L_0x00b0
    L_0x0080:
        r5.close()     // Catch:{ IOException -> 0x00ac }
        goto L_0x00b0
    L_0x0084:
        r5 = move-exception
        r2 = r5
        r5 = r0
        r1 = r5
    L_0x0088:
        r2.printStackTrace()     // Catch:{ all -> 0x00b1 }
        if (r1 == 0) goto L_0x0095
        r1.close()     // Catch:{ IOException -> 0x0091 }
        goto L_0x0095
    L_0x0091:
        r1 = move-exception
        r1.printStackTrace()
    L_0x0095:
        if (r5 == 0) goto L_0x00b0
        goto L_0x00ab
    L_0x0098:
        r5 = move-exception
        r2 = r5
        r5 = r0
        r1 = r5
    L_0x009c:
        r2.printStackTrace()     // Catch:{ all -> 0x00b1 }
        if (r1 == 0) goto L_0x00a9
        r1.close()     // Catch:{ IOException -> 0x00a5 }
        goto L_0x00a9
    L_0x00a5:
        r1 = move-exception
        r1.printStackTrace()
    L_0x00a9:
        if (r5 == 0) goto L_0x00b0
    L_0x00ab:
        goto L_0x0080
    L_0x00ac:
        r5 = move-exception
        r5.printStackTrace()
    L_0x00b0:
        return r0
    L_0x00b1:
        r0 = move-exception
        if (r1 == 0) goto L_0x00bc
        r1.close()     // Catch:{ IOException -> 0x00b8 }
        goto L_0x00bc
    L_0x00b8:
        r1 = move-exception
        r1.printStackTrace()
    L_0x00bc:
        if (r5 == 0) goto L_0x00c6
        r5.close()     // Catch:{ IOException -> 0x00c2 }
        goto L_0x00c6
    L_0x00c2:
        r5 = move-exception
        r5.printStackTrace()
    L_0x00c6:
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.p605ep.commonbase.utils.FileUtil.readLinesFromFile(java.lang.String):java.lang.String[]");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:52:0x007e, code lost:
            if (r5 == null) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
            r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0095, code lost:
            if (r5 == null) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x00a9, code lost:
            if (r5 == null) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x00ac, code lost:
            r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x00ad, code lost:
            r5.printStackTrace();
     */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0062 A[SYNTHETIC, Splitter:B:38:0x0062] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0076 A[SYNTHETIC, Splitter:B:48:0x0076] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x008d A[SYNTHETIC, Splitter:B:60:0x008d] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00a1 A[SYNTHETIC, Splitter:B:70:0x00a1] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:45:0x0071=Splitter:B:45:0x0071, B:57:0x0088=Splitter:B:57:0x0088, B:67:0x009c=Splitter:B:67:0x009c, B:35:0x005d=Splitter:B:35:0x005d} */
    public static java.lang.String[] readLinesFromMemoryFile(java.io.File r5) {
        /*
        r0 = 0
        java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch:{ FileNotFoundException -> 0x0098, IOException -> 0x0084, PatternSyntaxException -> 0x006d, all -> 0x0059 }
        java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0098, IOException -> 0x0084, PatternSyntaxException -> 0x006d, all -> 0x0059 }
        r2.<init>(r5)     // Catch:{ FileNotFoundException -> 0x0098, IOException -> 0x0084, PatternSyntaxException -> 0x006d, all -> 0x0059 }
        r1.<init>(r2)     // Catch:{ FileNotFoundException -> 0x0098, IOException -> 0x0084, PatternSyntaxException -> 0x006d, all -> 0x0059 }
        java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream     // Catch:{ FileNotFoundException -> 0x0055, IOException -> 0x0051, PatternSyntaxException -> 0x004d, all -> 0x0049 }
        r5.<init>()     // Catch:{ FileNotFoundException -> 0x0055, IOException -> 0x0051, PatternSyntaxException -> 0x004d, all -> 0x0049 }
        r2 = 1024(0x400, float:1.435E-42)
        byte[] r2 = new byte[r2]     // Catch:{ FileNotFoundException -> 0x0046, IOException -> 0x0044, PatternSyntaxException -> 0x0042, all -> 0x0040 }
    L_0x0014:
        int r3 = r1.read(r2)     // Catch:{ FileNotFoundException -> 0x0046, IOException -> 0x0044, PatternSyntaxException -> 0x0042, all -> 0x0040 }
        r4 = -1
        if (r3 == r4) goto L_0x0020
        r4 = 0
        r5.write(r2, r4, r3)     // Catch:{ FileNotFoundException -> 0x0046, IOException -> 0x0044, PatternSyntaxException -> 0x0042, all -> 0x0040 }
        goto L_0x0014
    L_0x0020:
        java.lang.String r2 = new java.lang.String     // Catch:{ FileNotFoundException -> 0x0046, IOException -> 0x0044, PatternSyntaxException -> 0x0042, all -> 0x0040 }
        byte[] r3 = r5.toByteArray()     // Catch:{ FileNotFoundException -> 0x0046, IOException -> 0x0044, PatternSyntaxException -> 0x0042, all -> 0x0040 }
        r2.<init>(r3)     // Catch:{ FileNotFoundException -> 0x0046, IOException -> 0x0044, PatternSyntaxException -> 0x0042, all -> 0x0040 }
        java.lang.String r3 = "\\n"
        java.lang.String[] r0 = r2.split(r3)     // Catch:{ FileNotFoundException -> 0x0046, IOException -> 0x0044, PatternSyntaxException -> 0x0042, all -> 0x0040 }
        r1.close()     // Catch:{ IOException -> 0x0033 }
        goto L_0x0037
    L_0x0033:
        r1 = move-exception
        r1.printStackTrace()
    L_0x0037:
        r5.close()     // Catch:{ IOException -> 0x003b }
        goto L_0x003f
    L_0x003b:
        r5 = move-exception
        r5.printStackTrace()
    L_0x003f:
        return r0
    L_0x0040:
        r2 = move-exception
        goto L_0x005d
    L_0x0042:
        r2 = move-exception
        goto L_0x0071
    L_0x0044:
        r2 = move-exception
        goto L_0x0088
    L_0x0046:
        r2 = move-exception
        goto L_0x009c
    L_0x0049:
        r5 = move-exception
        r2 = r5
        r5 = r0
        goto L_0x005d
    L_0x004d:
        r5 = move-exception
        r2 = r5
        r5 = r0
        goto L_0x0071
    L_0x0051:
        r5 = move-exception
        r2 = r5
        r5 = r0
        goto L_0x0088
    L_0x0055:
        r5 = move-exception
        r2 = r5
        r5 = r0
        goto L_0x009c
    L_0x0059:
        r5 = move-exception
        r2 = r5
        r5 = r0
        r1 = r5
    L_0x005d:
        r2.printStackTrace()     // Catch:{ all -> 0x00b1 }
        if (r1 == 0) goto L_0x006a
        r1.close()     // Catch:{ IOException -> 0x0066 }
        goto L_0x006a
    L_0x0066:
        r1 = move-exception
        r1.printStackTrace()
    L_0x006a:
        if (r5 == 0) goto L_0x00b0
        goto L_0x00ab
    L_0x006d:
        r5 = move-exception
        r2 = r5
        r5 = r0
        r1 = r5
    L_0x0071:
        r2.printStackTrace()     // Catch:{ all -> 0x00b1 }
        if (r1 == 0) goto L_0x007e
        r1.close()     // Catch:{ IOException -> 0x007a }
        goto L_0x007e
    L_0x007a:
        r1 = move-exception
        r1.printStackTrace()
    L_0x007e:
        if (r5 == 0) goto L_0x00b0
    L_0x0080:
        r5.close()     // Catch:{ IOException -> 0x00ac }
        goto L_0x00b0
    L_0x0084:
        r5 = move-exception
        r2 = r5
        r5 = r0
        r1 = r5
    L_0x0088:
        r2.printStackTrace()     // Catch:{ all -> 0x00b1 }
        if (r1 == 0) goto L_0x0095
        r1.close()     // Catch:{ IOException -> 0x0091 }
        goto L_0x0095
    L_0x0091:
        r1 = move-exception
        r1.printStackTrace()
    L_0x0095:
        if (r5 == 0) goto L_0x00b0
        goto L_0x00ab
    L_0x0098:
        r5 = move-exception
        r2 = r5
        r5 = r0
        r1 = r5
    L_0x009c:
        r2.printStackTrace()     // Catch:{ all -> 0x00b1 }
        if (r1 == 0) goto L_0x00a9
        r1.close()     // Catch:{ IOException -> 0x00a5 }
        goto L_0x00a9
    L_0x00a5:
        r1 = move-exception
        r1.printStackTrace()
    L_0x00a9:
        if (r5 == 0) goto L_0x00b0
    L_0x00ab:
        goto L_0x0080
    L_0x00ac:
        r5 = move-exception
        r5.printStackTrace()
    L_0x00b0:
        return r0
    L_0x00b1:
        r0 = move-exception
        if (r1 == 0) goto L_0x00bc
        r1.close()     // Catch:{ IOException -> 0x00b8 }
        goto L_0x00bc
    L_0x00b8:
        r1 = move-exception
        r1.printStackTrace()
    L_0x00bc:
        if (r5 == 0) goto L_0x00c6
        r5.close()     // Catch:{ IOException -> 0x00c2 }
        goto L_0x00c6
    L_0x00c2:
        r5 = move-exception
        r5.printStackTrace()
    L_0x00c6:
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.p605ep.commonbase.utils.FileUtil.readLinesFromMemoryFile(java.io.File):java.lang.String[]");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    public static void saveFile(java.lang.String r2, byte[] r3) {
        /*
        java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ all -> 0x0011 }
        r1 = 0
        r0.<init>(r2, r1)     // Catch:{ all -> 0x0011 }
        r0.write(r3)     // Catch:{ all -> 0x000f }
    L_0x0009:
        r0.close()     // Catch:{ IOException -> 0x000d }
        goto L_0x001c
    L_0x000d:
        r2 = move-exception
        goto L_0x0019
    L_0x000f:
        r2 = move-exception
        goto L_0x0013
    L_0x0011:
        r2 = move-exception
        r0 = 0
    L_0x0013:
        r2.printStackTrace()     // Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x001c
        goto L_0x0009
    L_0x0019:
        r2.printStackTrace()
    L_0x001c:
        return
    L_0x001d:
        r2 = move-exception
        if (r0 == 0) goto L_0x0028
        r0.close()     // Catch:{ IOException -> 0x0024 }
        goto L_0x0028
    L_0x0024:
        r3 = move-exception
        r3.printStackTrace()
    L_0x0028:
        throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.p605ep.commonbase.utils.FileUtil.saveFile(java.lang.String, byte[]):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0016, code lost:
            if (r0 != null) goto L_0x001f;
     */
    public static int writeFiles(android.content.Context r3, java.lang.String r4, java.lang.String r5) {
        /*
        if (r4 == 0) goto L_0x0047
        if (r5 != 0) goto L_0x0005
        goto L_0x0047
    L_0x0005:
        r0 = 0
        r1 = 0
        r2 = -2
        java.io.FileOutputStream r0 = r3.openFileOutput(r5, r1)     // Catch:{ FileNotFoundException -> 0x0030, IOException -> 0x0027, all -> 0x0019 }
        byte[] r3 = r4.getBytes()     // Catch:{ FileNotFoundException -> 0x0030, IOException -> 0x0027, all -> 0x0019 }
        if (r3 == 0) goto L_0x0016
        r0.write(r3)     // Catch:{ FileNotFoundException -> 0x0030, IOException -> 0x0027, all -> 0x0019 }
        r2 = 0
    L_0x0016:
        if (r0 == 0) goto L_0x003b
        goto L_0x001f
    L_0x0019:
        r3 = move-exception
        r3.printStackTrace()     // Catch:{ all -> 0x0025 }
        if (r0 == 0) goto L_0x003b
    L_0x001f:
        r0.close()     // Catch:{ IOException -> 0x0023 }
        goto L_0x003b
    L_0x0023:
        r3 = move-exception
        goto L_0x0038
    L_0x0025:
        r3 = move-exception
        goto L_0x003c
    L_0x0027:
        r3 = move-exception
        r2 = -7000(0xffffffffffffe4a8, float:NaN)
        r3.printStackTrace()     // Catch:{ all -> 0x0025 }
        if (r0 == 0) goto L_0x003b
        goto L_0x001f
    L_0x0030:
        r3 = move-exception
        r2 = -1
        r3.printStackTrace()     // Catch:{ all -> 0x0025 }
        if (r0 == 0) goto L_0x003b
        goto L_0x001f
    L_0x0038:
        r3.printStackTrace()
    L_0x003b:
        return r2
    L_0x003c:
        if (r0 == 0) goto L_0x0046
        r0.close()     // Catch:{ IOException -> 0x0042 }
        goto L_0x0046
    L_0x0042:
        r4 = move-exception
        r4.printStackTrace()
    L_0x0046:
        throw r3
    L_0x0047:
        r3 = -57
        return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.p605ep.commonbase.utils.FileUtil.writeFiles(android.content.Context, java.lang.String, java.lang.String):int");
    }

    public static int writeWupDataToFile(Context context, Object obj, String str, String str2) {
        if (context == null || obj == null || str == null || str2 == null) {
            return -57;
        }
        return writeWupDataToFile(obj, str, new File(context.getFilesDir(), str2));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0043, code lost:
            if (r0 != null) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x005b, code lost:
            if (r0 != null) goto L_0x0045;
     */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0055 A[Catch:{ FileNotFoundException -> 0x0056, IOException -> 0x004d, all -> 0x003f, all -> 0x004b }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:14:0x0032=Splitter:B:14:0x0032, B:26:0x0045=Splitter:B:26:0x0045} */
    public static int writeWupDataToFile(java.lang.Object r5, java.lang.String r6, java.io.File r7) {
        /*
        if (r5 == 0) goto L_0x006d
        if (r6 == 0) goto L_0x006d
        if (r7 != 0) goto L_0x0008
        goto L_0x006d
    L_0x0008:
        r0 = 0
        r1 = -2
        boolean r2 = createFile(r7)     // Catch:{ FileNotFoundException -> 0x0056, IOException -> 0x004d, all -> 0x003f }
        if (r2 != 0) goto L_0x0011
        return r1
    L_0x0011:
        java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0056, IOException -> 0x004d, all -> 0x003f }
        r3 = 0
        r2.<init>(r7, r3)     // Catch:{ FileNotFoundException -> 0x0056, IOException -> 0x004d, all -> 0x003f }
        com.qq.jce.wup.UniAttribute r7 = new com.qq.jce.wup.UniAttribute     // Catch:{ FileNotFoundException -> 0x003c, IOException -> 0x0039, all -> 0x0036 }
        r7.m50931init()     // Catch:{ FileNotFoundException -> 0x003c, IOException -> 0x0039, all -> 0x0036 }
        java.lang.String r4 = "UTF-8"
        r7.setEncodeName(r4)     // Catch:{ FileNotFoundException -> 0x003c, IOException -> 0x0039, all -> 0x0036 }
        r7.put(r6, r5)     // Catch:{ FileNotFoundException -> 0x003c, IOException -> 0x0039, all -> 0x0036 }
        byte[] r5 = r7.encode()     // Catch:{ FileNotFoundException -> 0x003c, IOException -> 0x0039, all -> 0x0036 }
        byte[] r5 = com.tencent.p605ep.commonbase.utils.XxteaCryptor.encryptV2(r5, r0)     // Catch:{ FileNotFoundException -> 0x003c, IOException -> 0x0039, all -> 0x0036 }
        if (r5 == 0) goto L_0x0032
        r2.write(r5)     // Catch:{ FileNotFoundException -> 0x003c, IOException -> 0x0039, all -> 0x0036 }
        r1 = 0
    L_0x0032:
        r2.close()     // Catch:{ IOException -> 0x0049 }
        goto L_0x0061
    L_0x0036:
        r5 = move-exception
        r0 = r2
        goto L_0x0040
    L_0x0039:
        r5 = move-exception
        r0 = r2
        goto L_0x004e
    L_0x003c:
        r5 = move-exception
        r0 = r2
        goto L_0x0057
    L_0x003f:
        r5 = move-exception
    L_0x0040:
        r5.printStackTrace()     // Catch:{ all -> 0x004b }
        if (r0 == 0) goto L_0x0061
    L_0x0045:
        r0.close()     // Catch:{ IOException -> 0x0049 }
        goto L_0x0061
    L_0x0049:
        r5 = move-exception
        goto L_0x005e
    L_0x004b:
        r5 = move-exception
        goto L_0x0062
    L_0x004d:
        r5 = move-exception
    L_0x004e:
        r1 = -7000(0xffffffffffffe4a8, float:NaN)
        r5.printStackTrace()     // Catch:{ all -> 0x004b }
        if (r0 == 0) goto L_0x0061
        goto L_0x0045
    L_0x0056:
        r5 = move-exception
    L_0x0057:
        r1 = -1
        r5.printStackTrace()     // Catch:{ all -> 0x004b }
        if (r0 == 0) goto L_0x0061
        goto L_0x0045
    L_0x005e:
        r5.printStackTrace()
    L_0x0061:
        return r1
    L_0x0062:
        if (r0 == 0) goto L_0x006c
        r0.close()     // Catch:{ IOException -> 0x0068 }
        goto L_0x006c
    L_0x0068:
        r6 = move-exception
        r6.printStackTrace()
    L_0x006c:
        throw r5
    L_0x006d:
        r5 = -57
        return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.p605ep.commonbase.utils.FileUtil.writeWupDataToFile(java.lang.Object, java.lang.String, java.io.File):int");
    }
}
