package com.tencent.mta.track.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import java.util.UUID;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.util.g */
public final class C7468g {
    /* renamed from: h */
    private static SharedPreferences m32348h(Context context) {
        return context.getSharedPreferences("StatisticsData", 0);
    }

    /* renamed from: a */
    public static void m32340a(Context context) {
        try {
            Editor edit = m32348h(context).edit();
            edit.putString("StatisticsData.user.agent", null);
            edit.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public static String m32342b(Context context) {
        SharedPreferences h = m32348h(context);
        String str = "StatisticsData.device.id";
        String string = h.getString(str, null);
        if (string != null) {
            return string;
        }
        String uuid = UUID.randomUUID().toString();
        Editor edit = h.edit();
        edit.putString(str, uuid);
        edit.apply();
        return uuid;
    }

    /* renamed from: c */
    public static final String m32343c(Context context) {
        SharedPreferences h = m32348h(context);
        String str = "StatisticsData.config.version";
        String string = h.getString(str, null);
        if (string != null) {
            return string;
        }
        String str2 = "1.0";
        Editor edit = h.edit();
        edit.putString(str, str2);
        edit.apply();
        return str2;
    }

    /* renamed from: d */
    public static final long m32344d(Context context) {
        return m32348h(context).getLong("StatisticsData.config.ts", 1490253471);
    }

    /* renamed from: e */
    public static final String m32345e(Context context) {
        return m32348h(context).getString("StatisticsData.sessionID", "");
    }

    /* renamed from: a */
    public static void m32341a(Context context, String str) {
        Editor edit = m32348h(context).edit();
        edit.putString("StatisticsData.sessionID", str);
        edit.apply();
    }

    /* renamed from: f */
    public static String m32346f(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
                return "WIFI";
            }
        }
        switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return "2G";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return "3G";
            case 13:
                return "4G";
            default:
                return "NULL";
        }
    }

    /* renamed from: g */
    public static boolean m32347g(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    public static Object m32339a(Context context, String str, Object obj) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                Object obj2 = applicationInfo.metaData.get(str);
                if (obj2 != null) {
                    return obj2;
                }
            }
        } catch (Throwable unused) {
        }
        return obj;
    }
}
