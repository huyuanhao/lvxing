package com.p368pw.inner.base.p387d;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.WindowManager;
import android.webkit.WebSettings;
import com.tencent.android.tpush.common.Constants;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;
import java.util.UUID;

/* renamed from: com.pw.inner.base.d.i */
public class C5191i {
    /* renamed from: a */
    private static String f16890a = null;
    /* renamed from: b */
    private static String f16891b = null;
    /* renamed from: c */
    private static String f16892c = null;
    /* renamed from: d */
    private static String f16893d = "";
    /* renamed from: e */
    private static String f16894e = "";
    /* renamed from: f */
    private static String f16895f = "";
    /* renamed from: g */
    private static String f16896g = "";

    /* renamed from: A */
    public static String m21381A(Context context) {
        String str = "";
        if (VERSION.SDK_INT >= 21) {
            UsageStatsManager usageStatsManager = (UsageStatsManager) context.getSystemService("usagestats");
            if (usageStatsManager == null) {
                return str;
            }
            long currentTimeMillis = System.currentTimeMillis();
            List<UsageStats> queryUsageStats = usageStatsManager.queryUsageStats(0, currentTimeMillis - 60000, currentTimeMillis);
            if (queryUsageStats == null) {
                return str;
            }
            TreeMap treeMap = new TreeMap();
            for (UsageStats usageStats : queryUsageStats) {
                treeMap.put(Long.valueOf(usageStats.getLastTimeUsed()), usageStats);
            }
            return !treeMap.isEmpty() ? ((UsageStats) treeMap.get(treeMap.lastKey())).getPackageName() : str;
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Constants.FLAG_ACTIVITY_NAME);
        return activityManager != null ? ((RunningTaskInfo) activityManager.getRunningTasks(5).get(0)).topActivity.getPackageName() : str;
    }

    /* renamed from: B */
    public static List<String> m21382B(Context context) {
        List installedPackages = context.getPackageManager().getInstalledPackages(0);
        if (installedPackages == null || installedPackages.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(installedPackages.size());
        for (int i = 0; i < installedPackages.size(); i++) {
            PackageInfo packageInfo = (PackageInfo) installedPackages.get(i);
            if ((packageInfo.applicationInfo.flags & 1) == 0) {
                arrayList.add(packageInfo.packageName);
            }
        }
        return arrayList;
    }

    /* renamed from: C */
    private static String m21383C(Context context) {
        WifiInfo wifiInfo;
        String str = "02:00:00:00:00:00";
        if (context == null) {
            return str;
        }
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        if (wifiManager == null) {
            return str;
        }
        try {
            wifiInfo = wifiManager.getConnectionInfo();
        } catch (Exception e) {
            C5205o.m21464a((Throwable) e);
            wifiInfo = null;
        }
        if (wifiInfo == null) {
            return null;
        }
        String macAddress = wifiInfo.getMacAddress();
        if (!TextUtils.isEmpty(macAddress)) {
            macAddress = macAddress.toUpperCase(Locale.ENGLISH);
        }
        return macAddress;
    }

    /* renamed from: a */
    public static int m21384a(Context context, int i) {
        if (context == null) {
            return 0;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (i == 1) {
            return windowManager.getDefaultDisplay().getWidth();
        }
        if (i == 2) {
            return windowManager.getDefaultDisplay().getHeight();
        }
        return 0;
    }

    /* renamed from: a */
    public static String m21385a() {
        return System.getProperty("http.agent");
    }

    /* renamed from: a */
    private static String m21386a(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(i & 255);
        String str = ".";
        sb.append(str);
        sb.append((i >> 8) & 255);
        sb.append(str);
        sb.append((i >> 16) & 255);
        sb.append(str);
        sb.append((i >> 24) & 255);
        return sb.toString();
    }

    /* renamed from: a */
    public static String m21387a(Context context) {
        String str = "wns_ab";
        try {
            if (TextUtils.isEmpty(f16890a)) {
                f16890a = Secure.getString(context.getContentResolver(), "android_id");
            }
            if (TextUtils.isEmpty(f16890a)) {
                f16890a = C5206p.m21472b(context, str);
                if (TextUtils.isEmpty(f16890a)) {
                    f16890a = UUID.randomUUID().toString().replace("-", "");
                    C5206p.m21471a(context, str, f16890a);
                }
            }
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
        return f16890a;
    }

    /* renamed from: a */
    private static String m21388a(WifiManager wifiManager) {
        String a = m21386a(wifiManager.getConnectionInfo().getIpAddress());
        return a != null ? a : "";
    }

    /* renamed from: a */
    public static String m21389a(String str) {
        String str2 = "";
        try {
            return (String) Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[]{String.class, String.class}).invoke(null, new Object[]{str, str2});
        } catch (Throwable th) {
            C5205o.m21464a(th);
            return str2;
        }
    }

    /* renamed from: a */
    public static boolean m21390a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            context.getPackageManager().getPackageInfo(str, 1024);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: b */
    public static int m21391b(Context context, int i) {
        return (int) (((float) i) * m21412o(context));
    }

    /* renamed from: b */
    public static long m21392b(Context context, String str) {
        long j;
        try {
            j = context.getPackageManager().getPackageInfo(str, 0).firstInstallTime;
        } catch (Exception e) {
            C5205o.m21464a((Throwable) e);
            j = 0;
        }
        int currentTimeMillis = j > 0 ? (int) ((System.currentTimeMillis() - j) / 86400000) : 1;
        if (currentTimeMillis == 0) {
            currentTimeMillis = 1;
        }
        return (long) currentTimeMillis;
    }

    /* renamed from: b */
    public static String m21393b() {
        if (TextUtils.isEmpty(f16895f)) {
            f16895f = m21389a("ro.yunos.model");
            if (TextUtils.isEmpty(f16895f)) {
                f16895f = Build.MODEL;
            }
        }
        return f16895f;
    }

    /* renamed from: b */
    public static String m21394b(Context context) {
        String str = "wns_ac";
        try {
            if (f16891b == null) {
                f16891b = C5206p.m21472b(context, str);
                if (TextUtils.isEmpty(f16891b)) {
                    f16891b = C5144a.m21266a(context).mo26750a();
                    C5206p.m21471a(context, str, f16891b);
                }
            }
        } catch (Throwable unused) {
            C5205o.m21462a("不存在google play");
        }
        return f16891b;
    }

    /* renamed from: b */
    public static String m21395b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF8"));
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                byte b2 = b & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
                sb.append(cArr[b2 / 16]);
                sb.append(cArr[b2 % 16]);
            }
            return sb.toString();
        } catch (Exception e) {
            C5205o.m21464a((Throwable) e);
            return str;
        }
    }

    /* renamed from: c */
    public static String m21396c() {
        return Build.MANUFACTURER;
    }

    /* renamed from: c */
    public static String m21397c(Context context) {
        if (TextUtils.isEmpty(f16892c)) {
            try {
                f16892c = VERSION.SDK_INT >= 17 ? WebSettings.getDefaultUserAgent(context) : m21385a();
            } catch (Throwable unused) {
                f16892c = m21385a();
            }
        }
        return f16892c;
    }

    /* renamed from: d */
    private static String m21398d() {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "";
                    }
                    StringBuilder sb = new StringBuilder();
                    for (byte valueOf : hardwareAddress) {
                        sb.append(String.format("%02X:", new Object[]{Byte.valueOf(valueOf)}));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
        return "02:00:00:00:00:00";
    }

    /* renamed from: d */
    public static String m21399d(Context context) {
        String str = "";
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                str = telephonyManager.getSimCountryIso().toUpperCase();
            }
        } catch (Exception e) {
            C5205o.m21464a((Throwable) e);
        }
        return TextUtils.isEmpty(str) ? Locale.getDefault().getCountry().toString().toUpperCase() : str;
    }

    /* renamed from: e */
    private static String m21400e() {
        try {
            return new BufferedReader(new FileReader(new File("/sys/class/net/wlan0/address"))).readLine();
        } catch (Throwable th) {
            C5205o.m21464a(th);
            return "02:00:00:00:00:00";
        }
    }

    /* renamed from: e */
    public static String m21401e(Context context) {
        return context.getApplicationInfo().packageName;
    }

    /* renamed from: f */
    public static int m21402f(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Throwable th) {
            C5205o.m21464a(th);
            return 0;
        }
    }

    /* renamed from: f */
    private static String m21403f() {
        String str;
        String str2 = "";
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration inetAddresses = ((NetworkInterface) networkInterfaces.nextElement()).getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        str2 = inetAddress.getHostAddress();
                    }
                }
            }
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
        return str;
    }

    /* renamed from: g */
    public static String m21404g(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Throwable th) {
            C5205o.m21464a(th);
            return "1.0";
        }
    }

    /* renamed from: h */
    public static synchronized Drawable m21405h(Context context) {
        Drawable drawable;
        synchronized (C5191i.class) {
            drawable = null;
            try {
                PackageManager packageManager = context.getApplicationContext().getPackageManager();
                drawable = packageManager.getApplicationIcon(packageManager.getApplicationInfo(context.getPackageName(), 0));
            } catch (Throwable th) {
                C5205o.m21464a(th);
            }
        }
        return drawable;
    }

    /* renamed from: i */
    public static synchronized String m21406i(Context context) {
        String string;
        synchronized (C5191i.class) {
            try {
                string = context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
            } catch (Throwable th) {
                C5205o.m21464a(th);
                return "";
            }
        }
        return string;
    }

    /* renamed from: j */
    public static int m21407j(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3 ? 2 : 1;
    }

    /* renamed from: k */
    public static boolean m21408k(Context context) {
        return m21384a(context, 1) > m21384a(context, 2);
    }

    /* renamed from: l */
    public static String m21409l(Context context) {
        Locale locale = Locale.getDefault();
        return String.format("%s_%s", new Object[]{locale.getLanguage().toLowerCase(), locale.getCountry().toLowerCase()});
    }

    /* renamed from: m */
    public static String m21410m(Context context) {
        if (TextUtils.isEmpty(f16896g)) {
            f16896g = ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
            if (TextUtils.isEmpty(f16896g)) {
                f16896g = "";
            }
        }
        return f16896g;
    }

    /* renamed from: n */
    public static int m21411n(Context context) {
        if (TextUtils.isEmpty(f16896g)) {
            f16896g = ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
            if (TextUtils.isEmpty(f16896g)) {
                f16896g = "";
            }
        }
        if (!"46000".equals(f16896g)) {
            if (!"46002".equals(f16896g)) {
                if (!"46004".equals(f16896g)) {
                    if (!"46007".equals(f16896g)) {
                        if (!"46008".equals(f16896g)) {
                            if (!"46001".equals(f16896g)) {
                                if (!"46006".equals(f16896g)) {
                                    if (!"46009".equals(f16896g)) {
                                        if (!"46003".equals(f16896g)) {
                                            if (!"46005".equals(f16896g)) {
                                                if (!"46011".equals(f16896g)) {
                                                    return "46020".equals(f16896g) ? 4 : 0;
                                                }
                                            }
                                        }
                                        return 3;
                                    }
                                }
                            }
                            return 2;
                        }
                    }
                }
            }
        }
        return 1;
    }

    /* renamed from: o */
    public static float m21412o(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    /* renamed from: p */
    public static String m21413p(Context context) {
        Location r = m21415r(context);
        return r != null ? String.valueOf(r.getLatitude()) : "";
    }

    /* renamed from: q */
    public static String m21414q(Context context) {
        Location r = m21415r(context);
        return r != null ? String.valueOf(r.getLongitude()) : "";
    }

    /* renamed from: r */
    public static Location m21415r(Context context) {
        try {
            return ((LocationManager) context.getSystemService("location")).getLastKnownLocation("gps");
        } catch (Throwable unused) {
            C5205o.m21462a("无权限：ACCESS_FINE_LOCATION");
            return null;
        }
    }

    /* renamed from: s */
    public static String m21416s(Context context) {
        if (TextUtils.isEmpty(f16894e)) {
            try {
                f16894e = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
            } catch (Exception e) {
                C5205o.m21464a((Throwable) e);
            }
        }
        return f16894e;
    }

    /* renamed from: t */
    public static String m21417t(Context context) {
        if (TextUtils.isEmpty(f16893d)) {
            try {
                f16893d = ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
            } catch (Exception e) {
                C5205o.m21464a((Throwable) e);
            }
        }
        return f16893d;
    }

    /* renamed from: u */
    public static int m21418u(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return 0;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            if (networkInfo != null) {
                State state = networkInfo.getState();
                if (state != null && (state == State.CONNECTED || state == State.CONNECTING)) {
                    return 1;
                }
            }
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
            if (networkInfo2 != null) {
                State state2 = networkInfo2.getState();
                String subtypeName = networkInfo2.getSubtypeName();
                if (state2 != null && (state2 == State.CONNECTED || state2 == State.CONNECTING)) {
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
                        case 12:
                        case 14:
                        case 15:
                            return 3;
                        case 13:
                            return 4;
                        default:
                            return (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) ? 3 : 5;
                    }
                }
            }
        }
        return 0;
    }

    /* renamed from: v */
    public static String m21419v(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getLine1Number();
        } catch (Throwable th) {
            C5205o.m21464a(th);
            return "";
        }
    }

    /* renamed from: w */
    public static String m21420w(Context context) {
        return VERSION.SDK_INT < 23 ? m21383C(context) : (VERSION.SDK_INT < 23 || VERSION.SDK_INT >= 24) ? VERSION.SDK_INT >= 24 ? m21398d() : "02:00:00:00:00:00" : m21400e();
    }

    /* renamed from: x */
    public static String m21421x(Context context) {
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            return wifiManager.isWifiEnabled() ? m21388a(wifiManager) : m21403f();
        } catch (Throwable th) {
            C5205o.m21464a(th);
            return "0.0.0.0";
        }
    }

    /* renamed from: y */
    public static boolean m21422y(Context context) {
        return context.getPackageManager().queryIntentActivities(new Intent("android.settings.USAGE_ACCESS_SETTINGS"), 65536).size() > 0;
    }

    /* renamed from: z */
    public static boolean m21423z(Context context) {
        List queryUsageStats = ((UsageStatsManager) context.getSystemService("usagestats")).queryUsageStats(4, 0, System.currentTimeMillis());
        return queryUsageStats != null && !queryUsageStats.isEmpty();
    }
}
