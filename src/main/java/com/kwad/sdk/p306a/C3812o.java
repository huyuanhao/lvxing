package com.kwad.sdk.p306a;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.LocaleList;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.core.content.ContextCompat;
import com.kwad.sdk.KsAdSDK;
import com.kwad.sdk.core.p319c.C4065b;
import com.tencent.android.tpush.common.Constants;
import java.io.File;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Pattern;

/* renamed from: com.kwad.sdk.a.o */
public class C3812o {
    /* renamed from: a */
    private static final Pattern f12926a = Pattern.compile("^[0-9a-fA-F]{16}$");
    /* renamed from: b */
    private static String f12927b;
    /* renamed from: c */
    private static String f12928c;
    /* renamed from: d */
    private static final List<String> f12929d = Arrays.asList(new String[]{"a5f5faddde9e9f02", "8e17f7422b35fbea", "b88c3c236923d9d9", "cb36bf76cca443d0", "5d4e49ed381836c5", "cffa38e9136f93e9", "62bd2daa59ea0173", "b7aad49a2d5bc5d9", "f2138912c5e5dd5c", "330a1e81a2bf9f31", "59c0f432ccbef844", "521376155e535f39", "aa5ec6ce14abd680", "5522a09bb500d82f", "6dfe4a96800edfb4", "ecc9a2dded8cdf72", "399f868043955b11", "34dc327c00dbff94", "d1b4e3862c309f8b", "68bdbf71f863ccac", "01558dd995085a35", "351174200a06da52", "fa0988506c76ff4b", "8eb8ef823312c61a", "a72e81be65c4638b", "416d15a015c8f324", "474086ea2d737519", "befdddf908c8d749", "780ee58a6f57aab6", "cfe86fa07cae3601", "704ff4d1534f0ff4", "9298b9e9bbd7cdea", "7b634c42f236c6e8", "11eacf22b9ceab7d", "2941a4f39eec5864", "87d134dc5ba45550", "fdd2313bb1750eb9", "6560ef232d8424bb", "5d876286e1064482", "f66fefb916f4962d", "7baf82d0ac49f596", "57748921d8d88ed4", "120cd57f1a50b8f5", "e164f9610ddd9fc8", "6256f0e8da6389de", "bcb22df712476416", "714fa9aff63f7adb", "cb8252e4da7cf610", "e18f649aa80e140c", "966790a9db5ea8d8", "e1769e681af901dd", "d23f2574a60964a4", "d717e6298d3c9cb2", "f5ea5e8ba730864e", "a8a0a223d1a42232", "6675a4f231f5c8db", "3edb7c2103e5c75a", "8ce6a9a216b326c4", "af606153eb3be0a7", "7ae255c3d760c920", "e50e94c40048c5fd", "55009bca30f9dc4c", "c37566487909214a", "891b74f7e534d14a", "726e190aae663525", "df473127d30fb669", "bfbcc646d92dfd48", "a4a1954c44751936", "da4a44a3d7c4d8be", "5ff5bca4a775dd30", "14917461e1917c53", "14ce20d0a80955fa", "a56a63de4d3f3d39", "f780246adc7bd556", "3495a541aea0da72", "f7f205ce47fed2a5", "f52db3f434279c3a", "dca17088c97dee5e", "dd53a8b3a2a4ccc0", "52e07629290d45e4", "cda522b0f8f50d9a", "b85a1c8bcd51d82c", "e344a00cd3f5e93a", "fa59d8a66d7bdd88", "68fb1f1393a216e8", "4c30ab1fb10af181", "b1376e0578099143", "88752f72d8d305fd", "fddf20078d27bf3c", "dab2120bffa2be8c", "c7c8dde481793471", "e4b1bdbcabfc284d"});

    static {
        String str = "";
        f12927b = str;
        f12928c = str;
    }

    /* renamed from: a */
    public static int m15817a(Context context) {
        try {
            if (VERSION.SDK_INT >= 21) {
                return ((BatteryManager) context.getApplicationContext().getSystemService("batterymanager")).getIntProperty(4);
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    /* renamed from: a */
    public static long m15818a() {
        try {
            return m15819a(Environment.getDataDirectory());
        } catch (Exception unused) {
            return 0;
        }
    }

    /* renamed from: a */
    private static long m15819a(File file) {
        if (file == null) {
            return 0;
        }
        try {
            StatFs statFs = new StatFs(file.getPath());
            return VERSION.SDK_INT < 18 ? ((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount()) : statFs.getBlockSizeLong() * statFs.getBlockCountLong();
        } catch (Exception unused) {
            return 0;
        }
    }

    /* renamed from: a */
    private static String m15820a(String str, int i, char c) {
        StringBuilder sb = new StringBuilder();
        while (sb.length() + str.length() < i) {
            sb.append(c);
        }
        sb.append(str);
        return sb.toString();
    }

    /* renamed from: a */
    private static boolean m15821a(String str) {
        return !TextUtils.isEmpty(str) && f12926a.matcher(str).find();
    }

    /* renamed from: b */
    public static long m15822b() {
        try {
            return m15824b(Environment.getDataDirectory());
        } catch (Exception unused) {
            return 0;
        }
    }

    /* renamed from: b */
    public static long m15823b(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getApplicationContext().getSystemService(Constants.FLAG_ACTIVITY_NAME);
            MemoryInfo memoryInfo = new MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            long j = memoryInfo.totalMem;
            if (j <= 0) {
                j = m15848n();
            }
            return j;
        } catch (Exception unused) {
            return 0;
        }
    }

    /* renamed from: b */
    private static long m15824b(File file) {
        try {
            StatFs statFs = new StatFs(file.getPath());
            return VERSION.SDK_INT < 18 ? ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks()) : statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong();
        } catch (Exception unused) {
            return 0;
        }
    }

    /* renamed from: b */
    private static boolean m15825b(String str) {
        return f12929d.contains(str.toLowerCase(Locale.US));
    }

    /* renamed from: c */
    public static int m15826c() {
        return Runtime.getRuntime().availableProcessors();
    }

    /* renamed from: c */
    public static long m15827c(Context context) {
        long j = 0;
        if (context == null) {
            return j;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(Constants.FLAG_ACTIVITY_NAME);
            MemoryInfo memoryInfo = new MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            j = memoryInfo.availMem;
        } catch (Exception unused) {
        }
        return j;
    }

    /* renamed from: c */
    private static void m15828c(String str) {
        Context context = KsAdSDK.getContext();
        if (context != null) {
            context.getSharedPreferences("ksadsdk_pref", 0).edit().putString("android_id", str).apply();
        }
    }

    /* renamed from: d */
    public static String m15829d() {
        return Build.CPU_ABI;
    }

    /* renamed from: d */
    public static String m15830d(Context context) {
        if (!TextUtils.isEmpty(f12928c) || context == null) {
            return f12928c;
        }
        try {
            if (ContextCompat.checkSelfPermission(context, com.tencent.mid.core.Constants.PERMISSION_READ_PHONE_STATE) == 0) {
                f12928c = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
            }
        } catch (Exception e) {
            C4065b.m16865a(e);
        }
        return f12928c;
    }

    /* renamed from: e */
    public static String m15831e() {
        Locale locale = VERSION.SDK_INT >= 24 ? LocaleList.getDefault().get(0) : Locale.getDefault();
        if (locale == null) {
            locale = Locale.CHINESE;
        }
        return String.valueOf(locale);
    }

    /* renamed from: e */
    public static String m15832e(Context context) {
        String str = "";
        if (context == null) {
            return str;
        }
        try {
            if (ContextCompat.checkSelfPermission(context, com.tencent.mid.core.Constants.PERMISSION_READ_PHONE_STATE) == 0) {
                ((TelephonyManager) context.getApplicationContext().getSystemService("phone")).getSubscriberId();
            }
        } catch (Exception unused) {
        }
        boolean isEmpty = TextUtils.isEmpty(str);
        return str;
    }

    /* renamed from: f */
    public static String m15833f() {
        return Build.MODEL;
    }

    /* renamed from: f */
    public static String m15834f(Context context) {
        String str = "";
        if (context == null) {
            return str;
        }
        try {
            if (ContextCompat.checkSelfPermission(context, com.tencent.mid.core.Constants.PERMISSION_READ_PHONE_STATE) == 0) {
                ((TelephonyManager) context.getApplicationContext().getSystemService("phone")).getSimSerialNumber();
            }
        } catch (Exception unused) {
        }
        boolean isEmpty = TextUtils.isEmpty(str);
        return str;
    }

    /* renamed from: g */
    public static int m15835g(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.widthPixels;
        } catch (Exception unused) {
            return 0;
        }
    }

    /* renamed from: g */
    public static String m15836g() {
        return Build.BRAND;
    }

    /* renamed from: h */
    public static int m15837h(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.heightPixels;
        } catch (Exception unused) {
            return 0;
        }
    }

    /* renamed from: h */
    public static String m15838h() {
        return Build.MANUFACTURER;
    }

    /* renamed from: i */
    public static int m15839i() {
        return m15846l(KsAdSDK.getContext()) ? 4 : 3;
    }

    /* renamed from: i */
    public static String m15840i(Context context) {
        try {
            return Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: j */
    public static String m15841j() {
        return VERSION.RELEASE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0031, code lost:
            if (f12927b.equals(r0) != false) goto L_0x0033;
     */
    /* renamed from: j */
    public static java.lang.String m15842j(android.content.Context r8) {
        /*
        if (r8 != 0) goto L_0x0005
        java.lang.String r8 = ""
        return r8
    L_0x0005:
        java.lang.String r0 = f12927b
        boolean r0 = android.text.TextUtils.isEmpty(r0)
        if (r0 == 0) goto L_0x00d7
        java.lang.String r0 = "wifi"
        java.lang.Object r8 = r8.getSystemService(r0)     // Catch:{ Exception -> 0x00d7 }
        android.net.wifi.WifiManager r8 = (android.net.wifi.WifiManager) r8     // Catch:{ Exception -> 0x00d7 }
        android.net.wifi.WifiInfo r8 = r8.getConnectionInfo()     // Catch:{ Exception -> 0x00d7 }
        if (r8 == 0) goto L_0x0021
        java.lang.String r8 = r8.getMacAddress()     // Catch:{ Exception -> 0x00d7 }
        f12927b = r8     // Catch:{ Exception -> 0x00d7 }
    L_0x0021:
        java.lang.String r8 = f12927b     // Catch:{ Exception -> 0x00d7 }
        boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x00d7 }
        java.lang.String r0 = "02:00:00:00:00:00"
        if (r8 != 0) goto L_0x0033
        java.lang.String r8 = f12927b     // Catch:{ Exception -> 0x00d7 }
        boolean r8 = r8.equals(r0)     // Catch:{ Exception -> 0x00d7 }
        if (r8 == 0) goto L_0x0097
    L_0x0033:
        java.util.Enumeration r8 = java.net.NetworkInterface.getNetworkInterfaces()     // Catch:{ Exception -> 0x00d7 }
        java.util.ArrayList r8 = java.util.Collections.list(r8)     // Catch:{ Exception -> 0x00d7 }
        java.util.Iterator r8 = r8.iterator()     // Catch:{ Exception -> 0x00d7 }
    L_0x003f:
        boolean r1 = r8.hasNext()     // Catch:{ Exception -> 0x00d7 }
        if (r1 == 0) goto L_0x0097
        java.lang.Object r1 = r8.next()     // Catch:{ Exception -> 0x00d7 }
        java.net.NetworkInterface r1 = (java.net.NetworkInterface) r1     // Catch:{ Exception -> 0x00d7 }
        java.lang.String r2 = r1.getName()     // Catch:{ Exception -> 0x00d7 }
        java.lang.String r3 = "wlan0"
        boolean r2 = r2.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x00d7 }
        if (r2 != 0) goto L_0x0058
        goto L_0x003f
    L_0x0058:
        byte[] r8 = r1.getHardwareAddress()     // Catch:{ Exception -> 0x00d7 }
        if (r8 == 0) goto L_0x0097
        int r1 = r8.length     // Catch:{ Exception -> 0x00d7 }
        if (r1 != 0) goto L_0x0062
        goto L_0x0097
    L_0x0062:
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d7 }
        r1.<init>()     // Catch:{ Exception -> 0x00d7 }
        int r2 = r8.length     // Catch:{ Exception -> 0x00d7 }
        r3 = 0
        r4 = 0
    L_0x006a:
        r5 = 1
        if (r4 >= r2) goto L_0x0083
        byte r6 = r8[r4]     // Catch:{ Exception -> 0x00d7 }
        java.lang.String r7 = "%02X:"
        java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x00d7 }
        java.lang.Byte r6 = java.lang.Byte.valueOf(r6)     // Catch:{ Exception -> 0x00d7 }
        r5[r3] = r6     // Catch:{ Exception -> 0x00d7 }
        java.lang.String r5 = java.lang.String.format(r7, r5)     // Catch:{ Exception -> 0x00d7 }
        r1.append(r5)     // Catch:{ Exception -> 0x00d7 }
        int r4 = r4 + 1
        goto L_0x006a
    L_0x0083:
        int r8 = r1.length()     // Catch:{ Exception -> 0x00d7 }
        if (r8 <= 0) goto L_0x0091
        int r8 = r1.length()     // Catch:{ Exception -> 0x00d7 }
        int r8 = r8 - r5
        r1.deleteCharAt(r8)     // Catch:{ Exception -> 0x00d7 }
    L_0x0091:
        java.lang.String r8 = r1.toString()     // Catch:{ Exception -> 0x00d7 }
        f12927b = r8     // Catch:{ Exception -> 0x00d7 }
    L_0x0097:
        java.lang.String r8 = f12927b     // Catch:{ Exception -> 0x00d7 }
        boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x00d7 }
        if (r8 != 0) goto L_0x00a7
        java.lang.String r8 = f12927b     // Catch:{ Exception -> 0x00d7 }
        boolean r8 = r8.equals(r0)     // Catch:{ Exception -> 0x00d7 }
        if (r8 == 0) goto L_0x00c5
    L_0x00a7:
        java.lang.Runtime r8 = java.lang.Runtime.getRuntime()     // Catch:{ Exception -> 0x00d7 }
        java.lang.String r0 = "cat /sys/class/net/wlan0/address "
        java.lang.Process r8 = r8.exec(r0)     // Catch:{ Exception -> 0x00d7 }
        java.io.InputStreamReader r0 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00d7 }
        java.io.InputStream r8 = r8.getInputStream()     // Catch:{ Exception -> 0x00d7 }
        r0.<init>(r8)     // Catch:{ Exception -> 0x00d7 }
        java.io.LineNumberReader r8 = new java.io.LineNumberReader     // Catch:{ Exception -> 0x00d7 }
        r8.<init>(r0)     // Catch:{ Exception -> 0x00d7 }
        java.lang.String r8 = r8.readLine()     // Catch:{ Exception -> 0x00d7 }
        f12927b = r8     // Catch:{ Exception -> 0x00d7 }
    L_0x00c5:
        java.lang.String r8 = f12927b     // Catch:{ Exception -> 0x00d7 }
        boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x00d7 }
        if (r8 != 0) goto L_0x00d7
        java.lang.String r8 = f12927b     // Catch:{ Exception -> 0x00d7 }
        java.util.Locale r0 = java.util.Locale.US     // Catch:{ Exception -> 0x00d7 }
        java.lang.String r8 = r8.toUpperCase(r0)     // Catch:{ Exception -> 0x00d7 }
        f12927b = r8     // Catch:{ Exception -> 0x00d7 }
    L_0x00d7:
        java.lang.String r8 = f12927b
        return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.p306a.C3812o.m15842j(android.content.Context):java.lang.String");
    }

    /* renamed from: k */
    public static String m15843k() {
        return Locale.getDefault().getLanguage();
    }

    /* renamed from: k */
    public static String m15844k(Context context) {
        try {
            PackageInfo packageInfo = context.getApplicationContext().getPackageManager().getPackageInfo(context.getPackageName(), 64);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
        } catch (Exception unused) {
        }
        return "";
    }

    /* renamed from: l */
    public static String m15845l() {
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration inetAddresses = ((NetworkInterface) networkInterfaces.nextElement()).getInetAddresses();
                while (true) {
                    if (inetAddresses.hasMoreElements()) {
                        InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                        if ((inetAddress instanceof Inet4Address) && !inetAddress.isLoopbackAddress()) {
                            return inetAddress.getHostAddress();
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    /* renamed from: l */
    private static boolean m15846l(Context context) {
        return (context == null || context.getResources() == null || context.getResources().getConfiguration() == null || (context.getResources().getConfiguration().screenLayout & 15) < 3) ? false : true;
    }

    /* renamed from: m */
    public static String m15847m() {
        StringBuilder sb;
        String p = m15850p();
        String str = "ANDROID_";
        if (!m15821a(p) || m15825b(p)) {
            p = m15851q();
            if (m15821a(p)) {
                sb = new StringBuilder();
            } else {
                p = m15849o();
                if (p != null) {
                    m15828c(p);
                }
                sb = new StringBuilder();
            }
        } else {
            sb = new StringBuilder();
        }
        sb.append(str);
        sb.append(p);
        return sb.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0045, code lost:
            if (r2 != null) goto L_0x0035;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0040 A[SYNTHETIC, Splitter:B:20:0x0040] */
    /* renamed from: n */
    private static long m15848n() {
        /*
        r0 = 0
        java.io.FileReader r1 = new java.io.FileReader     // Catch:{ Exception -> 0x0044, all -> 0x003b }
        java.lang.String r2 = "/proc/meminfo"
        r1.<init>(r2)     // Catch:{ Exception -> 0x0044, all -> 0x003b }
        java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0044, all -> 0x003b }
        r3 = 8192(0x2000, float:1.14794E-41)
        r2.<init>(r1, r3)     // Catch:{ Exception -> 0x0044, all -> 0x003b }
    L_0x000f:
        java.lang.String r0 = r2.readLine()     // Catch:{ Exception -> 0x0045, all -> 0x0039 }
        if (r0 == 0) goto L_0x0035
        java.lang.String r1 = "MemTotal"
        boolean r1 = r0.contains(r1)     // Catch:{ Exception -> 0x0045, all -> 0x0039 }
        if (r1 == 0) goto L_0x000f
        java.lang.String r1 = "\\s+"
        java.lang.String[] r0 = r0.split(r1)     // Catch:{ Exception -> 0x0045, all -> 0x0039 }
        r1 = 1
        r0 = r0[r1]     // Catch:{ Exception -> 0x0045, all -> 0x0039 }
        java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ Exception -> 0x0045, all -> 0x0039 }
        long r0 = r0.longValue()     // Catch:{ Exception -> 0x0045, all -> 0x0039 }
        r3 = 10
        long r0 = r0 << r3
        r2.close()     // Catch:{ IOException -> 0x0034 }
    L_0x0034:
        return r0
    L_0x0035:
        r2.close()     // Catch:{ IOException -> 0x0048 }
        goto L_0x0048
    L_0x0039:
        r0 = move-exception
        goto L_0x003e
    L_0x003b:
        r1 = move-exception
        r2 = r0
        r0 = r1
    L_0x003e:
        if (r2 == 0) goto L_0x0043
        r2.close()     // Catch:{ IOException -> 0x0043 }
    L_0x0043:
        throw r0
    L_0x0044:
        r2 = r0
    L_0x0045:
        if (r2 == 0) goto L_0x0048
        goto L_0x0035
    L_0x0048:
        r0 = 0
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.p306a.C3812o.m15848n():long");
    }

    /* renamed from: o */
    private static String m15849o() {
        try {
            return m15820a(Long.toHexString(new Random(System.currentTimeMillis()).nextLong()), 16, '0');
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: p */
    private static String m15850p() {
        try {
            return Secure.getString(KsAdSDK.getContext().getContentResolver(), "android_id");
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: q */
    private static String m15851q() {
        Context context = KsAdSDK.getContext();
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences("ksadsdk_pref", 0).getString("android_id", null);
    }
}
