package com.tencent.bigdata.dataacquisition.p600a;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.core.p003os.EnvironmentCompat;
import com.tencent.bigdata.dataacquisition.p601b.C7117a;
import com.tencent.mid.core.Constants;
import com.tencent.mid.sotrage.StorageInterface;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.RandomAccessFile;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.bigdata.dataacquisition.a.a */
public class C7113a {
    /* renamed from: a */
    private static String f23632a = null;
    /* renamed from: b */
    private static DisplayMetrics f23633b = null;
    /* renamed from: c */
    private static int f23634c = -1;
    /* renamed from: d */
    private static long f23635d = -1;
    /* renamed from: e */
    private static C7114a f23636e;

    /* renamed from: com.tencent.bigdata.dataacquisition.a.a$a */
    static class C7114a {

        /* renamed from: com.tencent.bigdata.dataacquisition.a.a$a$a */
        class C7115a implements FileFilter {
            C7115a() {
            }

            public boolean accept(File file) {
                return Pattern.matches("cpu[0-9]", file.getName());
            }
        }

        C7114a() {
        }

        /* renamed from: a */
        static int m30509a() {
            try {
                return new File("/sys/devices/system/cpu/").listFiles(new C7115a()).length;
            } catch (Exception e) {
                e.printStackTrace();
                return 1;
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            r1.close();
     */
        /* renamed from: b */
        static int m30510b() {
            /*
            r0 = 0
            r1 = 0
            java.lang.String r2 = ""
            java.lang.String r3 = "/system/bin/cat"
            java.lang.String r4 = "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4}     // Catch:{ Exception -> 0x0053 }
            java.lang.ProcessBuilder r4 = new java.lang.ProcessBuilder     // Catch:{ Exception -> 0x0053 }
            r4.<init>(r3)     // Catch:{ Exception -> 0x0053 }
            java.lang.Process r3 = r4.start()     // Catch:{ Exception -> 0x0053 }
            java.io.InputStream r1 = r3.getInputStream()     // Catch:{ Exception -> 0x0053 }
            r3 = 24
            byte[] r3 = new byte[r3]     // Catch:{ Exception -> 0x0053 }
        L_0x001d:
            int r4 = r1.read(r3)     // Catch:{ Exception -> 0x0053 }
            r5 = -1
            if (r4 == r5) goto L_0x0039
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0053 }
            r4.<init>()     // Catch:{ Exception -> 0x0053 }
            r4.append(r2)     // Catch:{ Exception -> 0x0053 }
            java.lang.String r2 = new java.lang.String     // Catch:{ Exception -> 0x0053 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0053 }
            r4.append(r2)     // Catch:{ Exception -> 0x0053 }
            java.lang.String r2 = r4.toString()     // Catch:{ Exception -> 0x0053 }
            goto L_0x001d
        L_0x0039:
            java.lang.String r2 = r2.trim()     // Catch:{ Exception -> 0x0053 }
            int r3 = r2.length()     // Catch:{ Exception -> 0x0053 }
            if (r3 <= 0) goto L_0x004b
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x0053 }
            int r0 = r2.intValue()     // Catch:{ Exception -> 0x0053 }
        L_0x004b:
            if (r1 == 0) goto L_0x005c
        L_0x004d:
            r1.close()     // Catch:{ Exception -> 0x005c }
            goto L_0x005c
        L_0x0051:
            r0 = move-exception
            goto L_0x005f
        L_0x0053:
            r2 = move-exception
            java.lang.String r3 = "getMaxCpuFreq err"
            com.tencent.bigdata.dataacquisition.p601b.C7117a.m30515a(r3, r2)     // Catch:{ all -> 0x0051 }
            if (r1 == 0) goto L_0x005c
            goto L_0x004d
        L_0x005c:
            int r0 = r0 * 1000
            return r0
        L_0x005f:
            if (r1 == 0) goto L_0x0064
            r1.close()     // Catch:{ Exception -> 0x0064 }
        L_0x0064:
            throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.bigdata.dataacquisition.p600a.C7113a.C7114a.m30510b():int");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            r1.close();
     */
        /* renamed from: c */
        static int m30511c() {
            /*
            r0 = 0
            r1 = 0
            java.lang.String r2 = ""
            java.lang.String r3 = "/system/bin/cat"
            java.lang.String r4 = "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4}     // Catch:{ IOException -> 0x0053 }
            java.lang.ProcessBuilder r4 = new java.lang.ProcessBuilder     // Catch:{ IOException -> 0x0053 }
            r4.<init>(r3)     // Catch:{ IOException -> 0x0053 }
            java.lang.Process r3 = r4.start()     // Catch:{ IOException -> 0x0053 }
            java.io.InputStream r1 = r3.getInputStream()     // Catch:{ IOException -> 0x0053 }
            r3 = 24
            byte[] r3 = new byte[r3]     // Catch:{ IOException -> 0x0053 }
        L_0x001d:
            int r4 = r1.read(r3)     // Catch:{ IOException -> 0x0053 }
            r5 = -1
            if (r4 == r5) goto L_0x0039
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0053 }
            r4.<init>()     // Catch:{ IOException -> 0x0053 }
            r4.append(r2)     // Catch:{ IOException -> 0x0053 }
            java.lang.String r2 = new java.lang.String     // Catch:{ IOException -> 0x0053 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x0053 }
            r4.append(r2)     // Catch:{ IOException -> 0x0053 }
            java.lang.String r2 = r4.toString()     // Catch:{ IOException -> 0x0053 }
            goto L_0x001d
        L_0x0039:
            java.lang.String r2 = r2.trim()     // Catch:{ IOException -> 0x0053 }
            int r3 = r2.length()     // Catch:{ IOException -> 0x0053 }
            if (r3 <= 0) goto L_0x004b
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ IOException -> 0x0053 }
            int r0 = r2.intValue()     // Catch:{ IOException -> 0x0053 }
        L_0x004b:
            if (r1 == 0) goto L_0x005c
        L_0x004d:
            r1.close()     // Catch:{ Exception -> 0x005c }
            goto L_0x005c
        L_0x0051:
            r0 = move-exception
            goto L_0x005f
        L_0x0053:
            r2 = move-exception
            java.lang.String r3 = "getMinCpuFreq"
            com.tencent.bigdata.dataacquisition.p601b.C7117a.m30515a(r3, r2)     // Catch:{ all -> 0x0051 }
            if (r1 == 0) goto L_0x005c
            goto L_0x004d
        L_0x005c:
            int r0 = r0 * 1000
            return r0
        L_0x005f:
            if (r1 == 0) goto L_0x0064
            r1.close()     // Catch:{ Exception -> 0x0064 }
        L_0x0064:
            throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.bigdata.dataacquisition.p600a.C7113a.C7114a.m30511c():int");
        }

        /* renamed from: d */
        static String m30512d() {
            BufferedReader bufferedReader;
            Throwable th;
            try {
                bufferedReader = new BufferedReader(new FileReader("/proc/cpuinfo"));
                try {
                    String readLine = bufferedReader.readLine();
                    if (!TextUtils.isEmpty(readLine)) {
                        String[] split = readLine.split(":\\s+", 2);
                        if (split.length > 0) {
                            String str = split[1];
                            try {
                                bufferedReader.close();
                            } catch (Exception unused) {
                            }
                            return str;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        C7117a.m30515a("getCpuName", th);
                    } finally {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception unused2) {
                            }
                        }
                    }
                }
            } catch (Throwable th3) {
                bufferedReader = null;
                th = th3;
                C7117a.m30515a("getCpuName", th);
            }
            try {
                bufferedReader.close();
            } catch (Exception unused3) {
            }
            return "";
        }
    }

    /* renamed from: com.tencent.bigdata.dataacquisition.a.a$b */
    static class C7116b {
        /* renamed from: a */
        private static int f23637a = -1;

        /* renamed from: a */
        public static boolean m30513a() {
            int i = f23637a;
            if (i == 1) {
                return true;
            }
            if (i == 0) {
                return false;
            }
            String[] strArr = {"/bin", "/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
            int i2 = 0;
            while (i2 < strArr.length) {
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append(strArr[i2]);
                    sb.append("su");
                    if (new File(sb.toString()).exists()) {
                        f23637a = 1;
                        return true;
                    }
                    i2++;
                } catch (Exception unused) {
                }
            }
            f23637a = 0;
            return false;
        }
    }

    /* renamed from: a */
    public static Integer m30486a(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                return Integer.valueOf(telephonyManager.getNetworkType());
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    /* renamed from: a */
    public static String m30487a() {
        String str;
        if (Build.CPU_ABI.equalsIgnoreCase("x86")) {
            return "Intel";
        }
        try {
            byte[] bArr = new byte[1024];
            new RandomAccessFile("/proc/cpuinfo", "r").read(bArr);
            str = new String(bArr);
            int indexOf = str.indexOf(0);
            if (indexOf != -1) {
                str = str.substring(0, indexOf);
            }
        } catch (Throwable th) {
            C7117a.m30515a("getCpuString", th);
            str = "";
        }
        return str;
    }

    /* renamed from: b */
    public static String m30488b() {
        String str;
        StringBuilder sb;
        String str2;
        String a = m30487a();
        if (a.contains("ARMv5")) {
            str = "armv5";
        } else if (a.contains("ARMv6")) {
            str = "armv6";
        } else if (a.contains("ARMv7")) {
            str = "armv7";
        } else if (!a.contains("Intel")) {
            return EnvironmentCompat.MEDIA_UNKNOWN;
        } else {
            str = "x86";
        }
        if (a.contains("neon")) {
            sb = new StringBuilder();
            sb.append(str);
            str2 = "_neon";
        } else if (a.contains("vfpv3")) {
            sb = new StringBuilder();
            sb.append(str);
            str2 = "_vfpv3";
        } else if (a.contains(" vfp")) {
            sb = new StringBuilder();
            sb.append(str);
            str2 = "_vfp";
        } else {
            sb = new StringBuilder();
            sb.append(str);
            str2 = "_none";
        }
        sb.append(str2);
        return sb.toString();
    }

    /* renamed from: b */
    public static boolean m30489b(Context context) {
        try {
            if (C7117a.m30516a(context, Constants.PERMISSION_ACCESS_NETWORK_STATE)) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null) {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                        return true;
                    }
                    C7117a.m30514a("Network error");
                }
            }
        } catch (Throwable th) {
            C7117a.m30515a("isNetworkAvailable error", th);
        }
        return false;
    }

    /* renamed from: c */
    public static byte m30490c(Context context) {
        if (context != null) {
            try {
                if (C7117a.m30516a(context, Constants.PERMISSION_ACCESS_NETWORK_STATE)) {
                    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                    if (connectivityManager == null) {
                        return 0;
                    }
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                        if (activeNetworkInfo.isConnected()) {
                            if (activeNetworkInfo.getType() == 1) {
                                return 1;
                            }
                            if (activeNetworkInfo.getType() != 0) {
                                return 0;
                            }
                            switch (activeNetworkInfo.getSubtype()) {
                                case 1:
                                case 2:
                                case 4:
                                case 7:
                                case 11:
                                    return 2;
                                case 3:
                                case 5:
                                case 6:
                                case 8:
                                case 9:
                                case 10:
                                case 15:
                                    return 3;
                                case 13:
                                    return 4;
                                default:
                                    return 0;
                            }
                        }
                    }
                    return -1;
                }
            } catch (Exception e) {
                C7117a.m30515a("getNetworkType: ", (Throwable) e);
            }
        }
        return -1;
    }

    /* renamed from: c */
    public static String m30491c() {
        long d = m30492d() / 1000000;
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        long blockSize = (((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks())) / 1000000;
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(blockSize));
        sb.append("/");
        sb.append(String.valueOf(d));
        return sb.toString();
    }

    /* renamed from: d */
    public static long m30492d() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
    }

    /* renamed from: d */
    public static boolean m30493d(Context context) {
        try {
            if (C7117a.m30516a(context, Constants.PERMISSION_ACCESS_NETWORK_STATE)) {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    return "WIFI".equalsIgnoreCase(activeNetworkInfo.getTypeName());
                }
            }
        } catch (Throwable th) {
            C7117a.m30515a("Check isWiFiActive error", th);
        }
        return false;
    }

    /* renamed from: e */
    public static String m30494e(Context context) {
        try {
            if (!C7117a.m30516a(context, Constants.PERMISSION_INTERNET) || !C7117a.m30516a(context, Constants.PERMISSION_ACCESS_NETWORK_STATE)) {
                C7117a.m30517b("can not get the permission of android.permission.ACCESS_WIFI_STATE");
                return null;
            }
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            String str = "MOBILE";
            String str2 = "WIFI";
            if (activeNetworkInfo == null) {
                return null;
            }
            if (!activeNetworkInfo.isConnected()) {
                return null;
            }
            String typeName = activeNetworkInfo.getTypeName();
            String extraInfo = activeNetworkInfo.getExtraInfo();
            if (typeName == null) {
                return null;
            }
            if (typeName.equalsIgnoreCase(str2)) {
                return str2;
            }
            if (typeName.equalsIgnoreCase(str)) {
                if (extraInfo == null) {
                    return str;
                }
            } else if (extraInfo == null) {
                return typeName;
            }
            return extraInfo;
        } catch (Throwable th) {
            C7117a.m30517b(th);
            return null;
        }
    }

    /* renamed from: e */
    public static boolean m30495e() {
        try {
            return "mounted".equals(Environment.getExternalStorageState());
        } catch (Exception e) {
            C7117a.m30515a("isSDCardMounted", (Throwable) e);
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0043, code lost:
            if (r0 != null) goto L_0x0030;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003e A[SYNTHETIC, Splitter:B:16:0x003e] */
    /* renamed from: f */
    private static long m30496f() {
        /*
        long r0 = f23635d
        r2 = 0
        int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
        if (r4 <= 0) goto L_0x0009
        return r0
    L_0x0009:
        java.lang.String r0 = "/proc/meminfo"
        r1 = 0
        java.io.FileReader r4 = new java.io.FileReader     // Catch:{ IOException -> 0x0042, all -> 0x0038 }
        r4.<init>(r0)     // Catch:{ IOException -> 0x0042, all -> 0x0038 }
        java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0042, all -> 0x0038 }
        r5 = 8192(0x2000, float:1.14794E-41)
        r0.<init>(r4, r5)     // Catch:{ IOException -> 0x0042, all -> 0x0038 }
        java.lang.String r1 = r0.readLine()     // Catch:{ IOException -> 0x0036, all -> 0x0034 }
        java.lang.String r4 = "\\s+"
        java.lang.String[] r1 = r1.split(r4)     // Catch:{ IOException -> 0x0036, all -> 0x0034 }
        r4 = 1
        r1 = r1[r4]     // Catch:{ IOException -> 0x0036, all -> 0x0034 }
        java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ IOException -> 0x0036, all -> 0x0034 }
        int r1 = r1.intValue()     // Catch:{ IOException -> 0x0036, all -> 0x0034 }
        int r1 = r1 * 1024
        long r2 = (long) r1
    L_0x0030:
        r0.close()     // Catch:{ Exception -> 0x0046 }
        goto L_0x0046
    L_0x0034:
        r1 = move-exception
        goto L_0x003c
        goto L_0x0043
    L_0x0038:
        r0 = move-exception
        r6 = r1
        r1 = r0
        r0 = r6
    L_0x003c:
        if (r0 == 0) goto L_0x0041
        r0.close()     // Catch:{ Exception -> 0x0041 }
    L_0x0041:
        throw r1
    L_0x0042:
        r0 = r1
    L_0x0043:
        if (r0 == 0) goto L_0x0046
        goto L_0x0030
    L_0x0046:
        f23635d = r2
        long r0 = f23635d
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bigdata.dataacquisition.p600a.C7113a.m30496f():long");
    }

    /* renamed from: f */
    public static DisplayMetrics m30497f(Context context) {
        if (f23633b == null) {
            f23633b = new DisplayMetrics();
            ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(f23633b);
        }
        return f23633b;
    }

    /* renamed from: g */
    public static String m30498g(Context context) {
        if (f23632a == null) {
            f23632a = Build.MODEL;
        }
        return f23632a;
    }

    /* renamed from: h */
    public static boolean m30499h(Context context) {
        return ((SensorManager) context.getSystemService("sensor")) != null;
    }

    /* renamed from: i */
    public static int m30500i(Context context) {
        int i = f23634c;
        if (i >= 0) {
            return i;
        }
        try {
            if (C7116b.m30513a()) {
                return 1;
            }
        } catch (Throwable th) {
            C7117a.m30515a("call hasRootAccess Error:", th);
        }
        return 0;
    }

    /* renamed from: j */
    public static String m30501j(Context context) {
        try {
            if (C7117a.m30516a(context, Constants.PERMISSION_WRITE_EXTERNAL_STORAGE)) {
                String externalStorageState = Environment.getExternalStorageState();
                if (externalStorageState != null && externalStorageState.equals("mounted")) {
                    String path = Environment.getExternalStorageDirectory().getPath();
                    if (path != null) {
                        StatFs statFs = new StatFs(path);
                        long blockCount = (((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / 1000000;
                        long availableBlocks = (((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / 1000000;
                        StringBuilder sb = new StringBuilder();
                        sb.append(String.valueOf(availableBlocks));
                        sb.append("/");
                        sb.append(String.valueOf(blockCount));
                        return sb.toString();
                    }
                }
                return null;
            }
            C7117a.m30514a("can not get the permission of android.permission.WRITE_EXTERNAL_STORAGE");
            return null;
        } catch (Throwable th) {
            C7117a.m30515a("getExternalStorageInfo err:", th);
        }
    }

    /* renamed from: k */
    public static int m30502k(Context context) {
        if (C7117a.m30516a(context, "android.permission.BLUETOOTH")) {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter == null) {
                return -1;
            }
            if (defaultAdapter.isEnabled()) {
                return 1;
            }
        }
        return 0;
    }

    /* renamed from: l */
    public static String m30503l(Context context) {
        long p = m30507p(context) / 1000000;
        long f = m30496f() / 1000000;
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(p));
        sb.append("/");
        sb.append(String.valueOf(f));
        return sb.toString();
    }

    /* renamed from: m */
    public static JSONObject m30504m(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            m30508q(context);
            int b = C7114a.m30510b();
            if (b > 0) {
                jSONObject.put("fx", b / 1000000);
            }
            m30508q(context);
            int c = C7114a.m30511c();
            if (c > 0) {
                jSONObject.put("fn", c / 1000000);
            }
            m30508q(context);
            int a = C7114a.m30509a();
            if (a > 0) {
                jSONObject.put("n", a);
            }
            m30508q(context);
            String d = C7114a.m30512d();
            if (d != null && d.length() == 0) {
                m30508q(context);
                jSONObject.put("na", C7114a.m30512d());
            }
        } catch (Throwable th) {
            C7117a.m30515a("getCpuInfo", th);
        }
        return jSONObject;
    }

    /* renamed from: n */
    public static String m30505n(Context context) {
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            if (sensorManager != null) {
                List sensorList = sensorManager.getSensorList(-1);
                if (sensorList != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < sensorList.size(); i++) {
                        sb.append(((Sensor) sensorList.get(i)).getType());
                        if (i != sensorList.size() - 1) {
                            sb.append(StorageInterface.KEY_SPLITER);
                        }
                    }
                    return sb.toString();
                }
            }
        } catch (Throwable th) {
            C7117a.m30515a("getAllSensors", th);
        }
        return "";
    }

    /* renamed from: o */
    public static JSONArray m30506o(Context context) {
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            if (sensorManager != null) {
                List sensorList = sensorManager.getSensorList(-1);
                if (sensorList != null && sensorList.size() > 0) {
                    JSONArray jSONArray = new JSONArray();
                    for (int i = 0; i < sensorList.size(); i++) {
                        Sensor sensor = (Sensor) sensorList.get(i);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(ArgKey.KEY_NAME, sensor.getName());
                        jSONObject.put("vendor", sensor.getVendor());
                        jSONArray.put(jSONObject);
                    }
                    return jSONArray;
                }
            }
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("getSensors:");
            sb.append(th.toString());
            C7117a.m30514a(sb.toString());
        }
        return null;
    }

    /* renamed from: p */
    private static long m30507p(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(com.tencent.android.tpush.common.Constants.FLAG_ACTIVITY_NAME);
        MemoryInfo memoryInfo = new MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    /* renamed from: q */
    private static synchronized C7114a m30508q(Context context) {
        C7114a aVar;
        synchronized (C7113a.class) {
            if (f23636e == null) {
                f23636e = new C7114a();
            }
            aVar = f23636e;
        }
        return aVar;
    }
}
