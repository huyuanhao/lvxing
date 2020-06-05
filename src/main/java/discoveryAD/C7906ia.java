package discoveryAD;

import android.os.Environment;
import android.os.StatFs;
import androidx.core.app.NotificationCompat;
import com.tencent.p605ep.commonbase.api.Log;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.slf4j.Marker;

/* renamed from: discoveryAD.ia */
public final class C7906ia {
    private static final String[][] MIME_TYPE_ARRAY;
    public static final String TAG = "FileUtil";

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

    /* renamed from: G */
    public static String m34320G(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            return bytesToString(instance.digest());
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
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

    /* renamed from: c */
    public static long m34321c(File file) {
        try {
            StatFs statFs = new StatFs(file.getPath());
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(e.getMessage());
            Log.m31479e("FileUtil", sb.toString());
            return 0;
        }
    }

    /* renamed from: e */
    public static String m34322e(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            return bytesToString(instance.digest());
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0032 A[SYNTHETIC, Splitter:B:20:0x0032] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0039 A[SYNTHETIC, Splitter:B:27:0x0039] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0040 A[SYNTHETIC, Splitter:B:34:0x0040] */
    public static java.lang.String getFileMD5(java.io.File r5) {
        /*
        java.lang.String r0 = "MD5"
        r1 = 0
        java.security.MessageDigest r0 = java.security.MessageDigest.getInstance(r0)     // Catch:{ IOException -> 0x003d, NoSuchAlgorithmException -> 0x0036, all -> 0x002f }
        java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ IOException -> 0x003d, NoSuchAlgorithmException -> 0x0036, all -> 0x002f }
        r2.<init>(r5)     // Catch:{ IOException -> 0x003d, NoSuchAlgorithmException -> 0x0036, all -> 0x002f }
        r5 = 8192(0x2000, float:1.14794E-41)
        byte[] r5 = new byte[r5]     // Catch:{ IOException -> 0x002d, NoSuchAlgorithmException -> 0x002b, all -> 0x0028 }
    L_0x0010:
        int r3 = r2.read(r5)     // Catch:{ IOException -> 0x002d, NoSuchAlgorithmException -> 0x002b, all -> 0x0028 }
        r4 = -1
        if (r3 == r4) goto L_0x001c
        r4 = 0
        r0.update(r5, r4, r3)     // Catch:{ IOException -> 0x002d, NoSuchAlgorithmException -> 0x002b, all -> 0x0028 }
        goto L_0x0010
    L_0x001c:
        byte[] r5 = r0.digest()     // Catch:{ IOException -> 0x002d, NoSuchAlgorithmException -> 0x002b, all -> 0x0028 }
        java.lang.String r5 = bytesToString(r5)     // Catch:{ IOException -> 0x002d, NoSuchAlgorithmException -> 0x002b, all -> 0x0028 }
        r2.close()     // Catch:{ IOException -> 0x0027 }
    L_0x0027:
        return r5
    L_0x0028:
        r5 = move-exception
        r1 = r2
        goto L_0x0030
        goto L_0x0037
        goto L_0x003e
    L_0x002f:
        r5 = move-exception
    L_0x0030:
        if (r1 == 0) goto L_0x0035
        r1.close()     // Catch:{ IOException -> 0x0035 }
    L_0x0035:
        throw r5
    L_0x0036:
        r2 = r1
    L_0x0037:
        if (r2 == 0) goto L_0x003c
        r2.close()     // Catch:{ IOException -> 0x003c }
    L_0x003c:
        return r1
    L_0x003d:
        r2 = r1
    L_0x003e:
        if (r2 == 0) goto L_0x0043
        r2.close()     // Catch:{ IOException -> 0x0043 }
    L_0x0043:
        return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: discoveryAD.C7906ia.getFileMD5(java.io.File):java.lang.String");
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

    public static int getSdcardStatus(long j) {
        if (!hasStorageCard()) {
            return 1;
        }
        if (!hasStorageCardReadWritePermission()) {
            return 2;
        }
        return (!hasStorageCard() || m34321c(C7918na.getExternalStorageDirectory()) >= j) ? 0 : 3;
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
        throw new UnsupportedOperationException("Method not decompiled: discoveryAD.C7906ia.guessFileName(java.lang.String, java.lang.String):java.lang.String");
    }

    public static boolean hasStorageCard() {
        try {
            return Environment.getExternalStorageState().equals("mounted");
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean hasStorageCardReadWritePermission() {
        StringBuilder sb = new StringBuilder();
        sb.append(C7918na.getExternalStorageDirectory().toString());
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

    public static boolean isContainFolderErrorChar(String str) {
        return (str.indexOf("\\") == -1 && str.indexOf("/") == -1 && str.indexOf(":") == -1 && str.indexOf(Marker.ANY_MARKER) == -1 && str.indexOf("?") == -1 && str.indexOf("\"") == -1 && str.indexOf("<") == -1 && str.indexOf(">") == -1 && str.indexOf("|") == -1) ? false : true;
    }
}
