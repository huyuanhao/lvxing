package com.tencent.p605ep.commonbase.utils;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.util.Log;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Pattern;
import org.slf4j.Marker;

/* renamed from: com.tencent.ep.commonbase.utils.EnvUtil */
public class EnvUtil {
    private static String TAG = "EnvUtil";
    private static Integer cpuNum;

    public static int getCpuNum() {
        if (cpuNum == null) {
            try {
                File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new FileFilter() {
                    public boolean accept(File file) {
                        return Pattern.matches("cpu[0-9]", file.getName());
                    }
                });
                if (listFiles == null) {
                    return 1;
                }
                String str = TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("CPU Count: ");
                sb.append(listFiles.length);
                Log.d(str, sb.toString());
                cpuNum = Integer.valueOf(listFiles.length);
            } catch (Throwable th) {
                Log.w(TAG, th);
                return 1;
            }
        }
        return cpuNum.intValue();
    }

    public static String getMaxCpuFreq() {
        StringBuilder sb = new StringBuilder();
        try {
            InputStream inputStream = new ProcessBuilder(new String[]{"/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"}).start().getInputStream();
            byte[] bArr = new byte[24];
            while (inputStream.read(bArr) != -1) {
                sb.append(new String(bArr));
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            sb = new StringBuilder("N/A");
        }
        return sb.toString().trim();
    }

    public static String[] getPhoneInfo(Context context) {
        String str;
        String[] strArr = new String[4];
        strArr[0] = Build.MODEL;
        strArr[1] = VERSION.RELEASE;
        try {
            str = FileUtil.readFile("/proc/cpuinfo").split("\\n")[0];
        } catch (Exception e) {
            e.printStackTrace();
            str = "";
        }
        strArr[2] = str;
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toString(ScreenUtil.getScreenWidth()));
        sb.append(Marker.ANY_MARKER);
        sb.append(Integer.toString(ScreenUtil.getScreenHeight()));
        strArr[3] = sb.toString();
        return strArr;
    }

    public static long getRomSize() {
        try {
            File dataDirectory = Environment.getDataDirectory();
            if (!dataDirectory.exists()) {
                dataDirectory = new File("/data");
            }
            StatFs statFs = new StatFs(dataDirectory.getPath());
            return ((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount());
        } catch (Throwable th) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("getRomSize() exception: ");
            sb.append(th);
            Log.w(str, sb.toString(), th);
            return 0;
        }
    }

    public static long getSystemAndDataSize() {
        try {
            File rootDirectory = Environment.getRootDirectory();
            if (!rootDirectory.exists()) {
                rootDirectory = new File("/system");
            }
            StatFs statFs = new StatFs(rootDirectory.getPath());
            return (((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount())) + getRomSize();
        } catch (Throwable th) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("getSystemAndDataSize() exception: ");
            sb.append(th);
            Log.w(str, sb.toString(), th);
            return 0;
        }
    }

    public static boolean isBuildIn(Context context) {
        try {
            return (context.getApplicationInfo().flags & 1) != 0;
        } catch (Throwable unused) {
            return false;
        }
    }
}
