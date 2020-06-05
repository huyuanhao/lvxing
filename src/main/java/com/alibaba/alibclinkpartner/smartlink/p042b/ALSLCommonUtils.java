package com.alibaba.alibclinkpartner.smartlink.p042b;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.os.Build.VERSION;
import com.tencent.android.tpush.common.Constants;
import java.lang.reflect.Field;
import java.util.Iterator;

/* renamed from: com.alibaba.alibclinkpartner.smartlink.b.a */
public class ALSLCommonUtils {
    /* renamed from: a */
    private static String f2232a = "android.permission.READ_PHONE_STATE";

    /* renamed from: a */
    public static String m2121a(Activity activity) {
        String str;
        String str2 = "unKnown";
        if (activity == null) {
            return str2;
        }
        try {
            if (VERSION.SDK_INT < 22) {
                Iterator it = ((ActivityManager) activity.getSystemService(Constants.FLAG_ACTIVITY_NAME)).getRunningTasks(2).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        str = "";
                        break;
                    }
                    RunningTaskInfo runningTaskInfo = (RunningTaskInfo) it.next();
                    if (!runningTaskInfo.baseActivity.getPackageName().equals(activity.getPackageName())) {
                        str = runningTaskInfo.baseActivity.getPackageName();
                        break;
                    }
                }
            } else {
                str = m2122b(activity);
            }
            str2 = str;
        } catch (Exception unused) {
        }
        return str2;
    }

    /* renamed from: b */
    private static String m2122b(Activity activity) {
        try {
            Field declaredField = Class.forName("android.app.Activity").getDeclaredField("mReferrer");
            declaredField.setAccessible(true);
            return (String) declaredField.get(activity);
        } catch (Exception unused) {
            return "";
        }
    }
}
