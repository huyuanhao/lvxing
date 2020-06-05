package com.alibaba.android.arouter.p045c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.alibaba.android.arouter.facade.template.ILogger;
import com.alibaba.android.arouter.p043a.ARouter;

/* renamed from: com.alibaba.android.arouter.c.d */
public class PackageUtils {
    /* renamed from: a */
    private static String f2281a;
    /* renamed from: b */
    private static int f2282b;

    /* renamed from: a */
    public static boolean m2161a(Context context) {
        PackageInfo c = m2163c(context);
        if (c != null) {
            String str = c.versionName;
            int i = c.versionCode;
            SharedPreferences sharedPreferences = context.getSharedPreferences("SP_AROUTER_CACHE", 0);
            if (str.equals(sharedPreferences.getString("LAST_VERSION_NAME", null)) && i == sharedPreferences.getInt("LAST_VERSION_CODE", -1)) {
                return false;
            }
            f2281a = str;
            f2282b = i;
        }
        return true;
    }

    /* renamed from: b */
    public static void m2162b(Context context) {
        if (!TextUtils.isEmpty(f2281a) && f2282b != 0) {
            String str = "LAST_VERSION_CODE";
            context.getSharedPreferences("SP_AROUTER_CACHE", 0).edit().putString("LAST_VERSION_NAME", f2281a).putInt(str, f2282b).apply();
        }
    }

    /* renamed from: c */
    private static PackageInfo m2163c(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384);
        } catch (Exception unused) {
            ARouter.f2236a.error(ILogger.defaultTag, "Get package info error.");
            return null;
        }
    }
}
