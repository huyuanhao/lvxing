package com.alibaba.mtl.log.p077d;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import com.alibaba.mtl.log.UTDC;
import com.tencent.android.tpush.common.Constants;

/* renamed from: com.alibaba.mtl.log.d.b */
public class AppInfoUtil {
    /* renamed from: a */
    private static String f3375a = "";
    /* renamed from: b */
    private static String f3376b;

    /* renamed from: d */
    public static String m3797d() {
        return "";
    }

    /* renamed from: e */
    public static String m3798e() {
        return "";
    }

    /* renamed from: a */
    public static String m3790a() {
        String str = "";
        if (UTDC.m3697c() == null) {
            return str;
        }
        try {
            String string = UTDC.m3697c().getSharedPreferences("UTCommon", 0).getString("_lun", str);
            if (!TextUtils.isEmpty(string)) {
                str = new String(Base64.m3800a(string.getBytes(), 2), "UTF-8");
            }
        } catch (Exception unused) {
        }
        return str;
    }

    /* renamed from: b */
    public static String m3793b() {
        String str = "";
        if (UTDC.m3697c() == null) {
            return str;
        }
        try {
            String string = UTDC.m3697c().getSharedPreferences("UTCommon", 0).getString("_luid", str);
            if (!TextUtils.isEmpty(string)) {
                str = new String(Base64.m3800a(string.getBytes(), 2), "UTF-8");
            }
        } catch (Exception unused) {
        }
        return str;
    }

    /* renamed from: c */
    public static String m3796c() {
        return f3375a;
    }

    /* renamed from: a */
    public static void m3791a(String str) {
        Logger.m3833a("AppInfoUtil", "[setChannle]", str);
        if (!TextUtils.isEmpty(str)) {
            int indexOf = str.indexOf("@");
            if (indexOf == -1) {
                f3375a = str;
            } else {
                f3375a = str.substring(0, indexOf);
            }
        }
    }

    /* renamed from: f */
    public static String m3799f() {
        return f3376b;
    }

    /* renamed from: b */
    public static void m3795b(String str) {
        Logger.m3833a("AppInfoUtil", "set Appkey:", str);
        f3376b = str;
    }

    /* renamed from: a */
    public static boolean m3792a(Context context) {
        if (context == null) {
            return false;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(Constants.FLAG_ACTIVITY_NAME);
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            String packageName = context.getPackageName();
            for (RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                if (runningAppProcessInfo.processName.equals(packageName)) {
                    if (runningAppProcessInfo.importance == 400) {
                        return false;
                    }
                    if (powerManager.isScreenOn()) {
                        return true;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    /* renamed from: b */
    public static String m3794b(Context context) {
        if (context == null) {
            return "";
        }
        int myPid = Process.myPid();
        for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(Constants.FLAG_ACTIVITY_NAME)).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }
}
