package com.tencent.p605ep.commonbase.utils;

import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.p605ep.commonbase.api.Log;
import java.io.File;

/* renamed from: com.tencent.ep.commonbase.utils.PackageUtil */
public class PackageUtil {
    private static final String TAG = "--PackageUtil--";

    public static Object getPackageParser(String str) {
        Object newInstance;
        try {
            String str2 = "android.content.pm.PackageParser";
            if (VERSION.SDK_INT >= 21) {
                newInstance = ReflecterHelper.newInstance(str2, null);
            } else {
                newInstance = ReflecterHelper.newInstance(str2, new Object[]{str});
            }
            return newInstance;
        } catch (Exception e) {
            Log.m31480e(TAG, e.getMessage(), e);
            return null;
        }
    }

    public static Object parsePackage(Object obj, File file, String str, DisplayMetrics displayMetrics, int i) {
        try {
            String str2 = "parsePackage";
            if (VERSION.SDK_INT >= 21) {
                return ReflecterHelper.invokeMethod(obj, str2, new Object[]{file, Integer.valueOf(i)});
            }
            return ReflecterHelper.invokeMethod(obj, str2, new Object[]{file, str, displayMetrics, Integer.valueOf(i)});
        } catch (Exception e) {
            Log.m31480e(TAG, e.getMessage(), e);
            return null;
        }
    }
}
