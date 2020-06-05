package com.tencent.mta.track;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.tencent.mid.core.Constants;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.e */
class C7374e {
    /* renamed from: a */
    public static String f24953a = "ConfigurationChecker";

    /* renamed from: a */
    public static boolean m31790a(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            if (packageManager != null) {
                if (packageName != null) {
                    if (packageManager.checkPermission(Constants.PERMISSION_INTERNET, packageName) == 0) {
                        return true;
                    }
                    Log.w(f24953a, "Package does not have permission android.permission.INTERNET - StatisticsData SDK will not work at all!");
                    Log.i(f24953a, "You can fix this by adding the following to your AndroidManifest.xml file:\n<uses-permission android:name=\"android.permission.INTERNET\" />");
                    return false;
                }
            }
            Log.w(f24953a, "Can't check configuration when using a Context with null packageManager or packageName");
            return false;
        } catch (Exception e) {
            Log.w(f24953a, e.toString());
            return false;
        }
    }
}
