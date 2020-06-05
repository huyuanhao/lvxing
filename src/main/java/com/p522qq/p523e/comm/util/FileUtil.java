package com.p522qq.p523e.comm.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.qq.e.comm.util.FileUtil */
public class FileUtil {
    public static boolean copyTo(InputStream inputStream, File file) {
        if (inputStream == null || file == null) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            if (file.getParentFile().exists() || file.getParentFile().mkdirs()) {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read > 0) {
                            fileOutputStream2.write(bArr, 0, read);
                        } else {
                            tryClose(inputStream);
                            tryClose((OutputStream) fileOutputStream2);
                            return true;
                        }
                    }
                } catch (Throwable th) {
                    FileOutputStream fileOutputStream3 = fileOutputStream2;
                    th = th;
                    fileOutputStream = fileOutputStream3;
                    try {
                        GDTLogger.m25261e(String.format("Exception while copy from InputStream to File %s", new Object[]{file.getAbsolutePath()}), th);
                        tryClose(inputStream);
                        tryClose((OutputStream) fileOutputStream);
                        return false;
                    } catch (Throwable th2) {
                        tryClose(inputStream);
                        tryClose((OutputStream) fileOutputStream);
                        throw th2;
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            GDTLogger.m25261e(String.format("Exception while copy from InputStream to File %s", new Object[]{file.getAbsolutePath()}), th);
            tryClose(inputStream);
            tryClose((OutputStream) fileOutputStream);
            return false;
        }
        tryClose(inputStream);
        tryClose((OutputStream) fileOutputStream);
        return false;
    }

    public static String getFileName(String str) {
        return Md5Util.encode(str);
    }

    public static String getTempFileName(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(Md5Util.encode(str));
        sb.append(".temp");
        return sb.toString();
    }

    public static boolean renameTo(File file, File file2) {
        if (file == null || file2 == null || !file.exists()) {
            return false;
        }
        if (!file.renameTo(file2)) {
            return copyTo(null, file2);
        }
        return true;
    }

    public static void tryClose(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void tryClose(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (Exception unused) {
            }
        }
    }
}
