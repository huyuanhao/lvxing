package com.tencent.stat.common;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RecentTaskInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.KeyguardManager;
import android.bluetooth.BluetoothAdapter;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import android.webkit.WebSettings;
import androidx.core.app.NotificationCompat;
import androidx.core.p003os.EnvironmentCompat;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import com.tencent.mid.api.MidService;
import com.tencent.mid.core.Constants;
import com.tencent.mid.sotrage.StorageInterface;
import com.tencent.stat.C7614e;
import com.tencent.stat.StatConfig;
import com.tencent.stat.StatMultiAccount;
import com.tencent.stat.StatMultiAccount.AccountType;
import com.tencent.stat.StatReportStrategy;
import com.tencent.stat.StatSpecifyReportedInfo;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpHost;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class StatCommonHelper {
    /* renamed from: A */
    private static Intent f25615A = null;
    public static String NEXT_REPORT = "next_al_report_time";
    /* renamed from: a */
    private static String f25616a = null;
    /* renamed from: b */
    private static String f25617b = null;
    /* renamed from: c */
    private static String f25618c = null;
    /* renamed from: d */
    private static String f25619d = null;
    /* renamed from: e */
    private static Random f25620e = null;
    /* renamed from: f */
    private static DisplayMetrics f25621f = null;
    /* renamed from: g */
    private static String f25622g = null;
    /* renamed from: h */
    private static String f25623h = "";
    /* renamed from: i */
    private static String f25624i = "";
    /* renamed from: j */
    private static String f25625j = "";
    /* renamed from: k */
    private static String f25626k = "";
    /* renamed from: l */
    private static int f25627l = -1;
    /* access modifiers changed from: private|static */
    /* renamed from: m */
    public static StatLogger f25628m = null;
    /* renamed from: n */
    private static String f25629n = null;
    /* renamed from: o */
    private static String f25630o = null;
    /* renamed from: p */
    private static volatile int f25631p = -1;
    /* renamed from: q */
    private static String f25632q = null;
    /* renamed from: r */
    private static String f25633r = null;
    /* renamed from: s */
    private static long f25634s = -1;
    /* renamed from: t */
    private static String f25635t = "";
    /* renamed from: u */
    private static String f25636u = "__MTA_FIRST_ACTIVATE__";
    /* renamed from: v */
    private static int f25637v = -1;
    /* renamed from: w */
    private static long f25638w = -1;
    /* renamed from: x */
    private static int f25639x = 0;
    /* renamed from: y */
    private static long f25640y = -1;
    /* renamed from: z */
    private static long f25641z;

    /* renamed from: com.tencent.stat.common.StatCommonHelper$a */
    static class C7588a {

        /* renamed from: com.tencent.stat.common.StatCommonHelper$a$a */
        class C7589a implements FileFilter {
            C7589a() {
            }

            public boolean accept(File file) {
                return Pattern.matches("cpu[0-9]", file.getName());
            }
        }

        /* renamed from: a */
        static int m32729a() {
            try {
                return new File("/sys/devices/system/cpu/").listFiles(new C7589a()).length;
            } catch (Exception e) {
                e.printStackTrace();
                return 1;
            }
        }

        /* renamed from: b */
        static int m32730b() {
            int i = 0;
            String str = "";
            try {
                InputStream inputStream = new ProcessBuilder(new String[]{"/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"}).start().getInputStream();
                byte[] bArr = new byte[24];
                while (inputStream.read(bArr) != -1) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(new String(bArr));
                    str = sb.toString();
                }
                inputStream.close();
                String trim = str.trim();
                if (trim.length() > 0) {
                    i = Integer.valueOf(trim).intValue();
                }
            } catch (Exception e) {
                StatCommonHelper.f25628m.mo37104e((Throwable) e);
            }
            return i * 1000;
        }

        /* renamed from: c */
        static int m32731c() {
            int i = 0;
            String str = "";
            try {
                InputStream inputStream = new ProcessBuilder(new String[]{"/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq"}).start().getInputStream();
                byte[] bArr = new byte[24];
                while (inputStream.read(bArr) != -1) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(new String(bArr));
                    str = sb.toString();
                }
                inputStream.close();
                String trim = str.trim();
                if (trim.length() > 0) {
                    i = Integer.valueOf(trim).intValue();
                }
            } catch (Throwable th) {
                StatCommonHelper.f25628m.mo37104e(th);
            }
            return i * 1000;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0066, code lost:
            if (r4 != null) goto L_0x0046;
     */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0056 A[SYNTHETIC, Splitter:B:24:0x0056] */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x005b A[Catch:{ IOException -> 0x005e }] */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0063 A[SYNTHETIC, Splitter:B:34:0x0063] */
        /* renamed from: d */
        static java.lang.String m32732d() {
            /*
            java.lang.String r0 = "/proc/cpuinfo"
            java.lang.String r1 = ""
            java.lang.String[] r1 = new java.lang.String[]{r1, r1}
            r2 = 0
            r3 = 0
            java.io.FileReader r4 = new java.io.FileReader     // Catch:{ IOException -> 0x005f, all -> 0x0051 }
            r4.<init>(r0)     // Catch:{ IOException -> 0x005f, all -> 0x0051 }
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ IOException -> 0x004f, all -> 0x004c }
            r5 = 8192(0x2000, float:1.14794E-41)
            r0.<init>(r4, r5)     // Catch:{ IOException -> 0x004f, all -> 0x004c }
            java.lang.String r2 = r0.readLine()     // Catch:{ IOException -> 0x0061, all -> 0x004a }
            if (r2 == 0) goto L_0x0043
            java.lang.String r5 = "\\s+"
            java.lang.String[] r2 = r2.split(r5)     // Catch:{ IOException -> 0x0061, all -> 0x004a }
            r5 = 2
        L_0x0023:
            int r6 = r2.length     // Catch:{ IOException -> 0x0061, all -> 0x004a }
            if (r5 >= r6) goto L_0x0043
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0061, all -> 0x004a }
            r6.<init>()     // Catch:{ IOException -> 0x0061, all -> 0x004a }
            r7 = r1[r3]     // Catch:{ IOException -> 0x0061, all -> 0x004a }
            r6.append(r7)     // Catch:{ IOException -> 0x0061, all -> 0x004a }
            r7 = r2[r5]     // Catch:{ IOException -> 0x0061, all -> 0x004a }
            r6.append(r7)     // Catch:{ IOException -> 0x0061, all -> 0x004a }
            java.lang.String r7 = " "
            r6.append(r7)     // Catch:{ IOException -> 0x0061, all -> 0x004a }
            java.lang.String r6 = r6.toString()     // Catch:{ IOException -> 0x0061, all -> 0x004a }
            r1[r3] = r6     // Catch:{ IOException -> 0x0061, all -> 0x004a }
            int r5 = r5 + 1
            goto L_0x0023
        L_0x0043:
            r0.close()     // Catch:{ IOException -> 0x0069 }
        L_0x0046:
            r4.close()     // Catch:{ IOException -> 0x0069 }
            goto L_0x0069
        L_0x004a:
            r1 = move-exception
            goto L_0x0054
        L_0x004c:
            r1 = move-exception
            r0 = r2
            goto L_0x0054
        L_0x004f:
            r0 = r2
            goto L_0x0061
        L_0x0051:
            r1 = move-exception
            r0 = r2
            r4 = r0
        L_0x0054:
            if (r0 == 0) goto L_0x0059
            r0.close()     // Catch:{ IOException -> 0x005e }
        L_0x0059:
            if (r4 == 0) goto L_0x005e
            r4.close()     // Catch:{ IOException -> 0x005e }
        L_0x005e:
            throw r1
        L_0x005f:
            r0 = r2
            r4 = r0
        L_0x0061:
            if (r0 == 0) goto L_0x0066
            r0.close()     // Catch:{ IOException -> 0x0069 }
        L_0x0066:
            if (r4 == 0) goto L_0x0069
            goto L_0x0046
        L_0x0069:
            r0 = r1[r3]
            return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.common.StatCommonHelper.C7588a.m32732d():java.lang.String");
        }
    }

    /* renamed from: com.tencent.stat.common.StatCommonHelper$b */
    static class C7590b {
        /* renamed from: a */
        private static int f25642a = -1;

        /* renamed from: a */
        public static boolean m32733a() {
            int i = f25642a;
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
                        f25642a = 1;
                        return true;
                    }
                    i2++;
                } catch (Exception unused) {
                }
            }
            f25642a = 0;
            return false;
        }
    }

    public static void loadMultiAccounts(Context context) {
    }

    public static void saveMultiAccounts(Context context) {
    }

    public static DeviceInfo getUser(Context context) {
        return C7614e.m32812a(context).mo37149b(context);
    }

    /* renamed from: b */
    private static synchronized Random m32727b() {
        Random random;
        synchronized (StatCommonHelper.class) {
            if (f25620e == null) {
                f25620e = new Random();
            }
            random = f25620e;
        }
        return random;
    }

    public static JSONArray multiAccountMapToJSONArray(Map<AccountType, StatMultiAccount> map) {
        JSONArray jSONArray = new JSONArray();
        for (Entry value : map.entrySet()) {
            StatMultiAccount statMultiAccount = (StatMultiAccount) value.getValue();
            if (statMultiAccount != null) {
                jSONArray.put(statMultiAccount.toJson());
            }
        }
        return jSONArray;
    }

    public static Map<AccountType, StatMultiAccount> multiAccounStrToMap(String str) {
        HashMap hashMap = new HashMap();
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    StatMultiAccount parse = StatMultiAccount.parse(jSONArray.optString(i));
                    hashMap.put(parse.getType(), parse);
                }
            }
        } catch (JSONException e) {
            f25628m.mo37104e((Throwable) e);
        }
        return hashMap;
    }

    public static void encodeMultiAccount(JSONObject jSONObject, Map<AccountType, StatMultiAccount> map) {
        if (map != null) {
            try {
                jSONObject.put("cua", multiAccountMapToJSONArray(map));
            } catch (Exception unused) {
            }
        }
    }

    public static int getNextSessionID() {
        return m32727b().nextInt(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    public static byte[] deocdeGZipContent(byte[] bArr) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        byte[] bArr2 = new byte[4096];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length * 2);
        while (true) {
            int read = gZIPInputStream.read(bArr2);
            if (read != -1) {
                byteArrayOutputStream.write(bArr2, 0, read);
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayInputStream.close();
                gZIPInputStream.close();
                byteArrayOutputStream.close();
                return byteArray;
            }
        }
    }

    public static String md5sum(String str) {
        String str2 = "0";
        if (str == null) {
            return str2;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                byte b2 = b & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
                if (b2 < 16) {
                    stringBuffer.append(str2);
                }
                stringBuffer.append(Integer.toHexString(b2));
            }
            return stringBuffer.toString();
        } catch (Throwable unused) {
            return str2;
        }
    }

    public static HttpHost getHttpProxy(Context context) {
        if (context == null) {
            return null;
        }
        try {
            if (context.getPackageManager().checkPermission(Constants.PERMISSION_ACCESS_NETWORK_STATE, context.getPackageName()) != 0) {
                return null;
            }
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return null;
            }
            if (activeNetworkInfo.getTypeName() != null && activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI")) {
                return null;
            }
            String extraInfo = activeNetworkInfo.getExtraInfo();
            if (extraInfo == null) {
                return null;
            }
            if (!extraInfo.equals("cmwap") && !extraInfo.equals("3gwap")) {
                if (!extraInfo.equals("uniwap")) {
                    if (extraInfo.equals("ctwap")) {
                        return new HttpHost("10.0.0.200", 80);
                    }
                    String defaultHost = Proxy.getDefaultHost();
                    if (defaultHost != null && defaultHost.trim().length() > 0) {
                        return new HttpHost(defaultHost, Proxy.getDefaultPort());
                    }
                    return null;
                }
            }
            return new HttpHost("10.0.0.172", 80);
        } catch (Throwable th) {
            f25628m.mo37104e(th);
        }
    }

    public static synchronized String getUserID(Context context) {
        synchronized (StatCommonHelper.class) {
            if (f25616a == null || f25616a.trim().length() == 0) {
                f25616a = Util.getDeviceID(context);
                if (f25616a == null || f25616a.trim().length() == 0) {
                    int i = 0;
                    while (true) {
                        if (i >= 100) {
                            break;
                        }
                        String upperCase = Long.toHexString(m32727b().nextLong()).toUpperCase();
                        if (upperCase.length() == 16 && !upperCase.startsWith("0")) {
                            f25616a = upperCase;
                            break;
                        }
                        i++;
                    }
                }
                String str = f25616a;
                return str;
            }
            String str2 = f25616a;
            return str2;
        }
    }

    public static synchronized String getMacId(Context context) {
        String str;
        synchronized (StatCommonHelper.class) {
            if (f25618c == null || f25618c.trim().length() == 0) {
                f25618c = Util.getWifiMacAddress(context);
            }
            str = f25618c;
        }
        return str;
    }

    public static Location getGPSLocation(Context context) {
        String str = "gps";
        try {
            if (!Util.checkPermission(context, "android.permission.ACCESS_FINE_LOCATION")) {
                return null;
            }
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            if (locationManager.isProviderEnabled(str)) {
                return locationManager.getLastKnownLocation(str);
            }
            return null;
        } catch (Throwable th) {
            f25628m.mo37104e(th);
            return null;
        }
    }

    public static Location getNetworkLocation(Context context) {
        String str = "network";
        try {
            if (!Util.checkPermission(context, "android.permission.ACCESS_COARSE_LOCATION") && !Util.checkPermission(context, "android.permission.ACCESS_FINE_LOCATION")) {
                return null;
            }
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            if (locationManager.isProviderEnabled(str)) {
                return locationManager.getLastKnownLocation(str);
            }
            return null;
        } catch (Throwable th) {
            f25628m.mo37104e(th);
            return null;
        }
    }

    public static DisplayMetrics getDisplayMetrics(Context context) {
        if (f25621f == null) {
            f25621f = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(f25621f);
        }
        return f25621f;
    }

    public static StatReportStrategy getStatSendStrategy(Context context) {
        return StatConfig.getStatSendStrategy();
    }

    public static boolean isWiFiActive(Context context) {
        try {
            if (Util.checkPermission(context, Constants.PERMISSION_ACCESS_WIFI_STATE)) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null) {
                    NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
                    if (allNetworkInfo != null) {
                        int i = 0;
                        while (i < allNetworkInfo.length) {
                            if (allNetworkInfo[i].getTypeName().equalsIgnoreCase("WIFI") && allNetworkInfo[i].isConnected()) {
                                return true;
                            }
                            i++;
                        }
                    }
                }
                return false;
            }
            f25628m.warn("can not get the permission of android.permission.ACCESS_WIFI_STATE");
            return false;
        } catch (Throwable th) {
            f25628m.mo37104e(th);
        }
    }

    public static String getProperty(Context context, String str) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                String string = applicationInfo.metaData.getString(str);
                if (string != null) {
                    return string;
                }
            }
        } catch (Throwable th) {
            f25628m.mo37104e(th);
        }
        return "";
    }

    public static String getAppKey(Context context) {
        String str = "Could not read APPKEY meta-data from AndroidManifest.xml";
        String str2 = f25617b;
        if (str2 != null) {
            return str2;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                String string = applicationInfo.metaData.getString("TA_APPKEY");
                if (string != null) {
                    f25617b = string;
                    return string;
                }
                f25628m.mo37108i(str);
            }
        } catch (Throwable unused) {
            f25628m.mo37108i(str);
        }
        return null;
    }

    public static String getDeviceModel(Context context) {
        if (f25619d == null) {
            f25619d = Build.MODEL;
        }
        return f25619d;
    }

    public static String getInstallChannel(Context context) {
        String str = "Could not read InstallChannel meta-data from AndroidManifest.xml";
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                Object obj = applicationInfo.metaData.get("InstallChannel");
                if (obj != null) {
                    return obj.toString();
                }
                f25628m.mo37116w(str);
            }
        } catch (Throwable unused) {
            f25628m.mo37116w(str);
        }
        return null;
    }

    public static String getActivityName(Context context) {
        if (context == null) {
            return null;
        }
        return context.getClass().getName();
    }

    public static String getPackageName(Context context) {
        if (Util.checkPermission(context, "android.permission.GET_TASKS")) {
            return ((RunningTaskInfo) ((ActivityManager) context.getSystemService(com.tencent.android.tpush.common.Constants.FLAG_ACTIVITY_NAME)).getRunningTasks(1).get(0)).topActivity.getPackageName();
        }
        f25628m.mo37103e((Object) "Could not get permission of android.permission.GET_TASKS");
        return null;
    }

    public static String getSimOperator(Context context) {
        String str = f25622g;
        if (str != null) {
            return str;
        }
        try {
            if (!Util.checkPermission(context, Constants.PERMISSION_READ_PHONE_STATE)) {
                f25628m.mo37103e((Object) "Could not get permission of android.permission.READ_PHONE_STATE");
            } else if (checkPhoneState(context)) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    f25622g = telephonyManager.getSimOperator();
                }
            }
        } catch (Throwable th) {
            f25628m.mo37104e(th);
        }
        return f25622g;
    }

    public static String getDeviceIMSI(Context context) {
        try {
            if (Util.checkPermission(context, Constants.PERMISSION_READ_PHONE_STATE)) {
                String subscriberId = checkPhoneState(context) ? ((TelephonyManager) context.getSystemService("phone")).getSubscriberId() : null;
                if (subscriberId != null) {
                    return subscriberId;
                }
                return null;
            }
        } catch (Throwable th) {
            f25628m.mo37104e(th);
        }
        return "";
    }

    public static String getCurAppVersion(Context context) {
        if (isStringValid(f25623h)) {
            return f25623h;
        }
        try {
            f25623h = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            if (f25623h == null) {
                return "";
            }
        } catch (Throwable th) {
            f25628m.mo37104e(th);
        }
        return f25623h;
    }

    public static String getCurAppMd5Signature(Context context) {
        if (isStringValid(f25624i)) {
            return f25624i;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            String str = "";
            if (packageInfo == null) {
                f25628m.mo37103e((Object) "packageInfo is null ");
                return str;
            }
            Signature[] signatureArr = packageInfo.signatures;
            if (signatureArr != null) {
                if (signatureArr.length != 0) {
                    f25624i = md5sum(signatureArr[0].toCharsString());
                    return f25624i;
                }
            }
            f25628m.mo37103e((Object) "signatures is null");
            return str;
        } catch (Throwable th) {
            f25628m.mo37104e(th);
        }
    }

    public static String getCurAppSHA1Signature(Context context) {
        if (isStringValid(f25625j)) {
            return f25625j;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            String str = "";
            if (packageInfo == null) {
                f25628m.mo37103e((Object) "packageInfo is null ");
                return str;
            }
            Signature[] signatureArr = packageInfo.signatures;
            if (signatureArr != null) {
                if (signatureArr.length != 0) {
                    byte[] digest = MessageDigest.getInstance("SHA1").digest(signatureArr[0].toByteArray());
                    StringBuffer stringBuffer = new StringBuffer();
                    int length = digest.length;
                    for (int i = 0; i < length; i++) {
                        String upperCase = Integer.toHexString(digest[i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED).toUpperCase(Locale.US);
                        if (upperCase.length() == 1) {
                            stringBuffer.append("0");
                        }
                        stringBuffer.append(upperCase);
                        if (i != length - 1) {
                            stringBuffer.append(":");
                        }
                    }
                    f25625j = stringBuffer.toString();
                    return f25625j;
                }
            }
            f25628m.mo37103e((Object) "signatures is null");
            return str;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static boolean checkPhoneState(Context context) {
        return context.getPackageManager().checkPermission(Constants.PERMISSION_READ_PHONE_STATE, context.getPackageName()) == 0;
    }

    public static String getLinkedWay(Context context) {
        String str = "";
        try {
            if (!Util.checkPermission(context, Constants.PERMISSION_INTERNET) || !Util.checkPermission(context, Constants.PERMISSION_ACCESS_NETWORK_STATE)) {
                f25628m.mo37103e((Object) "can not get the permission of android.permission.ACCESS_WIFI_STATE");
                return str;
            }
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            String str2 = "MOBILE";
            String str3 = "WIFI";
            if (activeNetworkInfo == null) {
                return str;
            }
            if (!activeNetworkInfo.isConnected()) {
                return str;
            }
            String typeName = activeNetworkInfo.getTypeName();
            String extraInfo = activeNetworkInfo.getExtraInfo();
            if (typeName == null) {
                return str;
            }
            if (typeName.equalsIgnoreCase(str3)) {
                return str3;
            }
            if (typeName.equalsIgnoreCase(str2)) {
                if (extraInfo == null || extraInfo.trim().length() <= 0) {
                    return str2;
                }
            } else if (extraInfo == null || extraInfo.trim().length() <= 0) {
                return typeName;
            }
            return extraInfo;
        } catch (Throwable th) {
            f25628m.mo37104e(th);
            return str;
        }
    }

    public static Integer getTelephonyNetworkType(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                return Integer.valueOf(telephonyManager.getNetworkType());
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static boolean haveGravity(Context context) {
        return ((SensorManager) context.getSystemService("sensor")) != null;
    }

    public static String getAppVersion(Context context) {
        if (isStringValid(f25626k)) {
            return f25626k;
        }
        try {
            f25626k = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            if (f25626k == null || f25626k.length() == 0) {
                return EnvironmentCompat.MEDIA_UNKNOWN;
            }
        } catch (Throwable th) {
            f25628m.mo37104e(th);
        }
        return f25626k;
    }

    public static int hasRootAccess(Context context) {
        int i = f25627l;
        if (i != -1) {
            return i;
        }
        f25627l = 0;
        try {
            if (C7590b.m32733a()) {
                f25627l = 1;
            }
        } catch (Throwable th) {
            f25628m.mo37104e(th);
        }
        return f25627l;
    }

    public static synchronized StatLogger getLogger() {
        StatLogger statLogger;
        synchronized (StatCommonHelper.class) {
            if (f25628m == null) {
                f25628m = new StatLogger(StatConstants.LOG_TAG);
                f25628m.setDebugEnable(false);
            }
            statLogger = f25628m;
        }
        return statLogger;
    }

    public static long getTomorrowStartMilliseconds() {
        try {
            Calendar instance = Calendar.getInstance();
            instance.set(11, 0);
            instance.set(12, 0);
            instance.set(13, 0);
            instance.set(14, 0);
            return instance.getTimeInMillis() + 86400000;
        } catch (Throwable th) {
            f25628m.mo37104e(th);
            return System.currentTimeMillis() + 86400000;
        }
    }

    public static String getDateString(int i) {
        Calendar instance = Calendar.getInstance();
        instance.roll(6, i);
        return new SimpleDateFormat("yyyyMMdd").format(instance.getTime());
    }

    public static Long convertStringToLong(String str, String str2, int i, int i2, Long l) {
        if (!(str == null || str2 == null)) {
            if (str2.equalsIgnoreCase(".") || str2.equalsIgnoreCase("|")) {
                StringBuilder sb = new StringBuilder();
                sb.append("\\");
                sb.append(str2);
                str2 = sb.toString();
            }
            String[] split = str.split(str2);
            if (split.length == i2) {
                try {
                    Long valueOf = Long.valueOf(0);
                    for (String valueOf2 : split) {
                        valueOf = Long.valueOf(((long) i) * (valueOf.longValue() + Long.valueOf(valueOf2).longValue()));
                    }
                    return valueOf;
                } catch (NumberFormatException unused) {
                }
            }
        }
        return l;
    }

    public static long getSDKLongVersion(String str) {
        return convertStringToLong(str, ".", 100, 3, Long.valueOf(0)).longValue();
    }

    public static boolean isStringValid(String str) {
        return (str == null || str.trim().length() == 0) ? false : true;
    }

    public static String getExternalStorageInfo(Context context) {
        if (isStringValid(f25629n)) {
            return f25629n;
        }
        try {
            if (Util.checkPermission(context, Constants.PERMISSION_WRITE_EXTERNAL_STORAGE)) {
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
                        f25629n = sb.toString();
                        return f25629n;
                    }
                }
                return null;
            }
            f25628m.warn("can not get the permission of android.permission.WRITE_EXTERNAL_STORAGE");
            return null;
        } catch (Throwable th) {
            f25628m.mo37104e(th);
        }
    }

    public static String getDateFormat(long j) {
        return new SimpleDateFormat("yyyyMMdd").format(new Date(j));
    }

    public static String getTimeFormat(long j) {
        return new SimpleDateFormat("yyyyMMddHHmmSS").format(new Date(j));
    }

    public static int getAndroidOsBuildVersion() {
        return VERSION.SDK_INT;
    }

    public static int checkBluetooth() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null) {
            return -1;
        }
        return defaultAdapter.isEnabled() ? 1 : 0;
    }

    public static boolean isMainProcess(Context context) {
        return context.getPackageName().equals(getCurProcessName(context));
    }

    public static String getCurProcessName(Context context) {
        try {
            if (f25630o != null) {
                return f25630o;
            }
            int myPid = Process.myPid();
            Iterator it = ((ActivityManager) context.getSystemService(com.tencent.android.tpush.common.Constants.FLAG_ACTIVITY_NAME)).getRunningAppProcesses().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                RunningAppProcessInfo runningAppProcessInfo = (RunningAppProcessInfo) it.next();
                if (runningAppProcessInfo.pid == myPid) {
                    f25630o = runningAppProcessInfo.processName;
                    break;
                }
            }
            return f25630o;
        } catch (Throwable unused) {
        }
    }

    public static String getTagForConcurrentProcess(Context context, String str) {
        if (StatConfig.isEnableConcurrentProcess()) {
            if (f25630o == null) {
                f25630o = getCurProcessName(context);
            }
            if (f25630o != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append("_");
                sb.append(f25630o);
                return sb.toString();
            }
        }
        return str;
    }

    public static void destroyProcess(Process process) {
        if (process != null) {
            try {
                process.exitValue();
            } catch (IllegalThreadStateException unused) {
            }
        }
    }

    public static String getDatabaseName(Context context) {
        return getTagForConcurrentProcess(context, StatConstants.DATABASE_NAME);
    }

    public static synchronized Integer getNextEventIndexNo(Context context) {
        Integer valueOf;
        synchronized (StatCommonHelper.class) {
            if (f25631p <= 0) {
                f25631p = StatPreferences.getInt(context, "MTA_EVENT_INDEX", 0);
                StatPreferences.putInt(context, "MTA_EVENT_INDEX", f25631p + 1000);
            } else if (f25631p % 1000 == 0) {
                try {
                    int i = f25631p + 1000;
                    if (f25631p >= 2147383647) {
                        i = 0;
                    }
                    StatPreferences.putInt(context, "MTA_EVENT_INDEX", i);
                } catch (Throwable th) {
                    f25628m.mo37116w(th);
                }
            }
            f25631p++;
            valueOf = Integer.valueOf(f25631p);
        }
        return valueOf;
    }

    public static String getCpuString() {
        if (isStringValid(f25632q)) {
            return f25632q;
        }
        if (Build.CPU_ABI.equalsIgnoreCase("x86")) {
            f25632q = "Intel";
        } else {
            try {
                byte[] bArr = new byte[1024];
                RandomAccessFile randomAccessFile = new RandomAccessFile("/proc/cpuinfo", "r");
                randomAccessFile.read(bArr);
                randomAccessFile.close();
                String str = new String(bArr);
                int indexOf = str.indexOf(0);
                if (indexOf != -1) {
                    f25632q = str.substring(0, indexOf);
                } else {
                    f25632q = str;
                }
            } catch (Throwable th) {
                f25628m.mo37104e(th);
            }
        }
        return f25632q;
    }

    public static String getCpuType() {
        String str;
        String str2;
        String cpuString = getCpuString();
        if (cpuString.contains("ARMv5")) {
            str = "armv5";
        } else if (cpuString.contains("ARMv6")) {
            str = "armv6";
        } else if (cpuString.contains("ARMv7")) {
            str = "armv7";
        } else if (!cpuString.contains("Intel")) {
            return EnvironmentCompat.MEDIA_UNKNOWN;
        } else {
            str = "x86";
        }
        if (cpuString.contains("neon")) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("_neon");
            str2 = sb.toString();
        } else if (cpuString.contains("vfpv3")) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append("_vfpv3");
            str2 = sb2.toString();
        } else if (cpuString.contains(" vfp")) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append("_vfp");
            str2 = sb3.toString();
        } else {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str);
            sb4.append("_none");
            str2 = sb4.toString();
        }
        return str2;
    }

    public static String getRomMemory() {
        if (isStringValid(f25633r)) {
            return f25633r;
        }
        long totalInternalMemorySize = getTotalInternalMemorySize() / 1000000;
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        long blockSize = (((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks())) / 1000000;
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(blockSize));
        sb.append("/");
        sb.append(String.valueOf(totalInternalMemorySize));
        f25633r = sb.toString();
        return f25633r;
    }

    public static long getTotalInternalMemorySize() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
    }

    public static String getSystemMemory(Context context) {
        try {
            long a = m32725a(context) / 1000000;
            long c = m32728c() / 1000000;
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(a));
            sb.append("/");
            sb.append(String.valueOf(c));
            return sb.toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private static long m32725a(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(com.tencent.android.tpush.common.Constants.FLAG_ACTIVITY_NAME);
        MemoryInfo memoryInfo = new MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0059 A[SYNTHETIC, Splitter:B:29:0x0059] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x005e A[Catch:{ Exception -> 0x003d }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0069 A[SYNTHETIC, Splitter:B:37:0x0069] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0071 A[Catch:{ Exception -> 0x006d }] */
    /* renamed from: c */
    private static long m32728c() {
        /*
        long r0 = f25634s
        r2 = 0
        int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
        if (r4 <= 0) goto L_0x0009
        return r0
    L_0x0009:
        java.lang.String r0 = "/proc/meminfo"
        r1 = 1
        r3 = 0
        java.io.FileReader r4 = new java.io.FileReader     // Catch:{ Exception -> 0x0050, all -> 0x004c }
        r4.<init>(r0)     // Catch:{ Exception -> 0x0050, all -> 0x004c }
        java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0047, all -> 0x0044 }
        r5 = 8192(0x2000, float:1.14794E-41)
        r0.<init>(r4, r5)     // Catch:{ Exception -> 0x0047, all -> 0x0044 }
        java.lang.String r3 = r0.readLine()     // Catch:{ Exception -> 0x0042 }
        if (r3 == 0) goto L_0x0036
        java.lang.String r5 = "\\s+"
        java.lang.String[] r3 = r3.split(r5)     // Catch:{ Exception -> 0x0042 }
        r5 = 1
        r3 = r3[r5]     // Catch:{ Exception -> 0x0042 }
        java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x0042 }
        int r1 = r3.intValue()     // Catch:{ Exception -> 0x0042 }
        long r1 = (long) r1
        r5 = 1024(0x400, double:5.06E-321)
        long r1 = r1 * r5
    L_0x0036:
        r4.close()     // Catch:{ Exception -> 0x003d }
        r0.close()     // Catch:{ Exception -> 0x003d }
        goto L_0x0061
    L_0x003d:
        r0 = move-exception
        r0.printStackTrace()
        goto L_0x0061
    L_0x0042:
        r3 = move-exception
        goto L_0x0054
    L_0x0044:
        r1 = move-exception
        r0 = r3
        goto L_0x0067
    L_0x0047:
        r0 = move-exception
        r7 = r3
        r3 = r0
        r0 = r7
        goto L_0x0054
    L_0x004c:
        r1 = move-exception
        r0 = r3
        r4 = r0
        goto L_0x0067
    L_0x0050:
        r0 = move-exception
        r4 = r3
        r3 = r0
        r0 = r4
    L_0x0054:
        r3.printStackTrace()     // Catch:{ all -> 0x0066 }
        if (r4 == 0) goto L_0x005c
        r4.close()     // Catch:{ Exception -> 0x003d }
    L_0x005c:
        if (r0 == 0) goto L_0x0061
        r0.close()     // Catch:{ Exception -> 0x003d }
    L_0x0061:
        f25634s = r1
        long r0 = f25634s
        return r0
    L_0x0066:
        r1 = move-exception
    L_0x0067:
        if (r4 == 0) goto L_0x006f
        r4.close()     // Catch:{ Exception -> 0x006d }
        goto L_0x006f
    L_0x006d:
        r0 = move-exception
        goto L_0x0075
    L_0x006f:
        if (r0 == 0) goto L_0x0078
        r0.close()     // Catch:{ Exception -> 0x006d }
        goto L_0x0078
    L_0x0075:
        r0.printStackTrace()
    L_0x0078:
        throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.common.StatCommonHelper.m32728c():long");
    }

    public static JSONObject getCpuInfo(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("n", C7588a.m32729a());
            String d = C7588a.m32732d();
            if (d != null && d.length() > 0) {
                jSONObject.put("na", d);
            }
            int b = C7588a.m32730b();
            if (b > 0) {
                jSONObject.put("fx", b / 1000000);
            }
            int c = C7588a.m32731c();
            if (c > 0) {
                jSONObject.put("fn", c / 1000000);
            }
        } catch (Throwable th) {
            Log.w(StatConstants.LOG_TAG, "get cpu error", th);
        }
        return jSONObject;
    }

    public static String getAllSensors(Context context) {
        if (isStringValid(f25635t)) {
            return f25635t;
        }
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            if (sensorManager != null) {
                List sensorList = sensorManager.getSensorList(-1);
                if (sensorList != null) {
                    StringBuilder sb = new StringBuilder(sensorList.size() * 10);
                    for (int i = 0; i < sensorList.size(); i++) {
                        sb.append(((Sensor) sensorList.get(i)).getType());
                        if (i != sensorList.size() - 1) {
                            sb.append(StorageInterface.KEY_SPLITER);
                        }
                    }
                    f25635t = sb.toString();
                }
            }
        } catch (Throwable th) {
            f25628m.mo37104e(th);
        }
        return f25635t;
    }

    public static synchronized int isTheFirstTimeActivate(Context context) {
        synchronized (StatCommonHelper.class) {
            if (f25637v != -1) {
                int i = f25637v;
                return i;
            }
            checkFirstTimeActivate(context);
            int i2 = f25637v;
            return i2;
        }
    }

    public static void checkFirstTimeActivate(Context context) {
        f25637v = StatPreferences.getInt(context, f25636u, 1);
        if (f25637v == 1) {
            StatPreferences.putInt(context, f25636u, 0);
        }
    }

    public static boolean isSpecifyReportedValid(StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (statSpecifyReportedInfo == null) {
            return false;
        }
        return isStringValid(statSpecifyReportedInfo.getAppKey());
    }

    public static boolean needCheckTime(Context context) {
        if (f25638w < 0) {
            f25638w = StatPreferences.getLong(context, "mta.qq.com.checktime", 0);
        }
        return Math.abs(System.currentTimeMillis() - f25638w) > 86400000;
    }

    public static void updateCheckTime(Context context) {
        f25638w = System.currentTimeMillis();
        StatPreferences.putLong(context, "mta.qq.com.checktime", f25638w);
    }

    public static int getDiffTime(Context context, boolean z) {
        if (z) {
            f25639x = readDiffTimeFromServer(context);
        }
        return f25639x;
    }

    public static int readDiffTimeFromServer(Context context) {
        return StatPreferences.getInt(context, "mta.qq.com.difftime", 0);
    }

    public static void writeDiffTimeFromServer(Context context, int i) {
        f25639x = i;
        StatPreferences.putInt(context, "mta.qq.com.difftime", i);
    }

    public static boolean isBackgroundRunning(Context context) {
        boolean z = false;
        if (context == null) {
            return false;
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService(com.tencent.android.tpush.common.Constants.FLAG_ACTIVITY_NAME);
        if (activityManager == null) {
            return false;
        }
        String packageName = context.getPackageName();
        Iterator it = activityManager.getRunningAppProcesses().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            RunningAppProcessInfo runningAppProcessInfo = (RunningAppProcessInfo) it.next();
            if (runningAppProcessInfo.processName.startsWith(packageName)) {
                if (runningAppProcessInfo.importance == 400) {
                    z = true;
                }
            }
        }
        return z;
    }

    public static Map<String, Integer> getRunningApp(Context context) {
        HashMap hashMap = new HashMap();
        try {
            for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(com.tencent.android.tpush.common.Constants.FLAG_ACTIVITY_NAME)).getRunningAppProcesses()) {
                hashMap.put(runningAppProcessInfo.processName, Integer.valueOf(1));
            }
        } catch (Throwable th) {
            f25628m.mo37104e(th);
        }
        return hashMap;
    }

    public static Map<String, Integer> getRecentTasks(Context context) {
        HashMap hashMap = new HashMap();
        try {
            for (RecentTaskInfo recentTaskInfo : ((ActivityManager) context.getSystemService(com.tencent.android.tpush.common.Constants.FLAG_ACTIVITY_NAME)).getRecentTasks(64, 1)) {
                ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(recentTaskInfo.baseIntent, 0);
                if (resolveActivity != null) {
                    hashMap.put(resolveActivity.resolvePackageName, Integer.valueOf(1));
                }
            }
        } catch (Throwable th) {
            f25628m.mo37104e(th);
        }
        return hashMap;
    }

    public static JSONArray formatThrowable(Throwable th) {
        JSONArray jSONArray = new JSONArray();
        if (th != null) {
            jSONArray.put(th.toString());
            formatStackTraceElement(jSONArray, th.getStackTrace());
        }
        return jSONArray;
    }

    public static JSONArray formatStackTraceElement(JSONArray jSONArray, StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr != null) {
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                jSONArray.put(stackTraceElement.toString());
            }
        }
        return jSONArray;
    }

    public static int getRunningCounter(Context context) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(getCurAppVersion(context));
            sb.append(".run.cnt");
            String sb2 = sb.toString();
            int i = StatPreferences.getInt(context, sb2, 1);
            StatPreferences.putInt(context, sb2, i + 1);
            return i;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static void encodeAppPackageInfo(JSONObject jSONObject, PackageInfo packageInfo) {
        try {
            jSONObject.put("pn", packageInfo.packageName);
            jSONObject.put("av", packageInfo.versionName);
            jSONObject.put("vc", packageInfo.versionCode);
            jSONObject.put("fit", packageInfo.firstInstallTime / 1000);
            jSONObject.put("lut", packageInfo.lastUpdateTime / 1000);
            jSONObject.put("fg", packageInfo.applicationInfo.flags);
        } catch (JSONException unused) {
        }
    }

    public static JSONArray getAppList(Context context) {
        JSONArray jSONArray = new JSONArray();
        try {
            List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
            Map runningApp = getRunningApp(context);
            Map recentTasks = getRecentTasks(context);
            for (PackageInfo packageInfo : installedPackages) {
                JSONObject jSONObject = new JSONObject();
                String str = packageInfo.packageName;
                encodeAppPackageInfo(jSONObject, packageInfo);
                if (runningApp.containsKey(str)) {
                    jSONObject.put("rn", 1);
                }
                if (recentTasks.containsKey(str)) {
                    jSONObject.put("rt", 1);
                }
                jSONArray.put(jSONObject);
            }
        } catch (JSONException e) {
            f25628m.mo37104e((Throwable) e);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONArray;
    }

    public static String getLauncherPackageName(Context context) {
        if (context == null) {
            return null;
        }
        try {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 0);
            if (resolveActivity.activityInfo != null && !resolveActivity.activityInfo.packageName.equals("android")) {
                return resolveActivity.activityInfo.packageName;
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static boolean isBackground(Context context) {
        Iterator it = ((ActivityManager) context.getSystemService(com.tencent.android.tpush.common.Constants.FLAG_ACTIVITY_NAME)).getRunningAppProcesses().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            RunningAppProcessInfo runningAppProcessInfo = (RunningAppProcessInfo) it.next();
            if (runningAppProcessInfo.processName.equalsIgnoreCase(context.getPackageName())) {
                StatLogger statLogger = f25628m;
                StringBuilder sb = new StringBuilder();
                sb.append("isBackground processName:");
                sb.append(runningAppProcessInfo.processName);
                sb.append(", importance:");
                sb.append(runningAppProcessInfo.importance);
                statLogger.mo37108i(sb.toString());
                if ((runningAppProcessInfo.importance == 100 || runningAppProcessInfo.importance == 200) && !isLockScreenOn(context)) {
                    return isApplicationBroughtToBackground(context);
                }
            }
        }
        return true;
    }

    public static boolean isLockScreenOn(Context context) {
        return ((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
    }

    public static boolean isApplicationBroughtToBackground(Context context) {
        if (!Util.checkPermission(context, "android.permission.GET_TASKS")) {
            return true;
        }
        List runningTasks = ((ActivityManager) context.getSystemService(com.tencent.android.tpush.common.Constants.FLAG_ACTIVITY_NAME)).getRunningTasks(1);
        if (!runningTasks.isEmpty()) {
            ComponentName componentName = ((RunningTaskInfo) runningTasks.get(0)).topActivity;
            StatLogger statLogger = f25628m;
            StringBuilder sb = new StringBuilder();
            sb.append("isApplicationBroughtToBackground top package:");
            sb.append(componentName.getPackageName());
            statLogger.mo37108i(sb.toString());
            if (!componentName.getPackageName().equals(context.getPackageName())) {
                return true;
            }
        }
        return false;
    }

    public static boolean needReportApp(Context context) {
        boolean z = false;
        if (!StatConfig.isAutoTrackAppsEvent()) {
            return false;
        }
        if (f25640y == -1) {
            f25641z = Long.valueOf(StatConfig.getSDKProperty("autoAL", String.valueOf(86400))).longValue() * 1000;
            if (f25641z > 10800000) {
                f25640y = StatPreferences.getLong(context, NEXT_REPORT, 0);
            } else {
                f25640y = Long.MAX_VALUE;
            }
            StatLogger statLogger = f25628m;
            StringBuilder sb = new StringBuilder();
            sb.append("next_al_report_time:");
            sb.append(f25640y);
            statLogger.mo37101d(sb.toString());
        }
        if (f25640y < System.currentTimeMillis()) {
            z = true;
        }
        return z;
    }

    public static void updateNextReportTime(Context context) {
        f25640y = System.currentTimeMillis() + f25641z;
        StatPreferences.putLong(context, NEXT_REPORT, f25640y);
    }

    public static String getNewMid(Context context) {
        try {
            return (String) MidService.class.getMethod("getNewMid", new Class[]{Context.class}).invoke(null, new Object[]{context});
        } catch (Throwable unused) {
            f25628m.mo37116w("MidService.getNewMid method notfound");
            return null;
        }
    }

    public static void safeClose(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static int getArgumentsLength(Object... objArr) {
        if (objArr == null) {
            return 0;
        }
        int i = 0;
        for (Object obj : objArr) {
            if (obj != null) {
                i += obj.toString().length();
            }
        }
        return i;
    }

    public static boolean checkArgumentsLength(Object... objArr) {
        return getArgumentsLength(objArr) > 61440;
    }

    public static String getUserAgent(Context context) {
        String str;
        String str2 = "http.agent";
        if (VERSION.SDK_INT >= 17) {
            try {
                str = WebSettings.getDefaultUserAgent(context);
            } catch (Exception unused) {
                str = System.getProperty(str2);
            }
        } else {
            str = System.getProperty(str2);
        }
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt <= 31 || charAt >= 127) {
                stringBuffer.append(String.format("\\u%04x", new Object[]{Integer.valueOf(charAt)}));
            } else {
                stringBuffer.append(charAt);
            }
        }
        return stringBuffer.toString();
    }

    public static JSONObject getBatteryInfo(Context context) {
        String str = "technology";
        String str2 = "temperature";
        String str3 = "voltage";
        String str4 = "plugged";
        String str5 = "scale";
        String str6 = "level";
        String str7 = "present";
        String str8 = "health";
        String str9 = NotificationCompat.CATEGORY_STATUS;
        if (context == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (f25615A == null) {
                f25615A = Util.getContextSelf(context).registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            }
            int intExtra = f25615A.getIntExtra(str9, 0);
            int intExtra2 = f25615A.getIntExtra(str8, 1);
            boolean booleanExtra = f25615A.getBooleanExtra(str7, false);
            int intExtra3 = f25615A.getIntExtra(str6, 0);
            int intExtra4 = f25615A.getIntExtra(str5, 0);
            String str10 = str5;
            int intExtra5 = f25615A.getIntExtra(str4, 0);
            String str11 = str4;
            int intExtra6 = f25615A.getIntExtra(str3, 0);
            String str12 = str3;
            int intExtra7 = f25615A.getIntExtra(str2, 0);
            String stringExtra = f25615A.getStringExtra(str);
            jSONObject.put(str9, intExtra);
            jSONObject.put(str8, intExtra2);
            jSONObject.put(str7, booleanExtra);
            jSONObject.put(str6, intExtra3);
            jSONObject.put(str10, intExtra4);
            jSONObject.put(str11, intExtra5);
            jSONObject.put(str12, intExtra6);
            jSONObject.put(str2, intExtra7);
            jSONObject.put(str, stringExtra);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
