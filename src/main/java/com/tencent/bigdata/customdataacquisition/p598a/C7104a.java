package com.tencent.bigdata.customdataacquisition.p598a;

import android.app.ActivityManager;
import android.app.ActivityManager.RecentTaskInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.tencent.android.tpush.common.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.bigdata.customdataacquisition.a.a */
public class C7104a {
    /* renamed from: a */
    public static Map<String, Integer> m30442a(Context context) {
        HashMap hashMap = new HashMap();
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(Constants.FLAG_ACTIVITY_NAME);
            if (activityManager != null) {
                List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                if (runningAppProcesses != null) {
                    for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                        hashMap.put(runningAppProcessInfo.processName, Integer.valueOf(1));
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return hashMap;
    }

    /* renamed from: b */
    public static Map<String, RunningAppProcessInfo> m30443b(Context context) {
        HashMap hashMap = new HashMap();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Constants.FLAG_ACTIVITY_NAME);
        if (activityManager != null) {
            List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses != null) {
                for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    String[] strArr = runningAppProcessInfo.pkgList;
                    for (String put : strArr) {
                        hashMap.put(put, runningAppProcessInfo);
                    }
                }
            }
        }
        return hashMap;
    }

    /* renamed from: c */
    public static Map<String, Integer> m30444c(Context context) {
        HashMap hashMap = new HashMap();
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(Constants.FLAG_ACTIVITY_NAME);
            if (activityManager != null) {
                List<RecentTaskInfo> recentTasks = activityManager.getRecentTasks(64, 1);
                if (recentTasks != null) {
                    for (RecentTaskInfo recentTaskInfo : recentTasks) {
                        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(recentTaskInfo.baseIntent, 0);
                        if (resolveActivity != null) {
                            hashMap.put(resolveActivity.resolvePackageName, Integer.valueOf(1));
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return hashMap;
    }

    /* renamed from: d */
    public static List<PackageInfo> m30445d(Context context) {
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = context.getPackageManager();
        return packageManager != null ? packageManager.getInstalledPackages(0) : arrayList;
    }
}
