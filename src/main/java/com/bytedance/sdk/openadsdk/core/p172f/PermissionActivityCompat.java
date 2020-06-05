package com.bytedance.sdk.openadsdk.core.p172f;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Process;

/* renamed from: com.bytedance.sdk.openadsdk.core.f.b */
public class PermissionActivityCompat {
    /* renamed from: a */
    public static void m9559a(Activity activity, String[] strArr, int i) {
        if (VERSION.SDK_INT >= 23) {
            activity.requestPermissions(strArr, i);
        }
    }

    /* renamed from: a */
    public static int m9558a(Context context, String str) {
        if (str != null) {
            try {
                return context.checkPermission(str, Process.myPid(), Process.myUid());
            } catch (Throwable th) {
                th.printStackTrace();
                return VERSION.SDK_INT >= 23 ? -1 : 0;
            }
        } else {
            throw new IllegalArgumentException("permission is null");
        }
    }
}
