package com.tencent.android.tpush.service.p595e;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import com.tencent.android.tpush.p580b.C6864a;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.service.e.d */
public class C7051d {
    /* renamed from: a */
    public static boolean m30147a(Context context) {
        String str = "NotificationsUtils";
        boolean z = true;
        if (VERSION.SDK_INT >= 27) {
            C6864a.m29306g(str, "OS >= 27, return true");
            return true;
        }
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String packageName = context.getApplicationContext().getPackageName();
        int i = applicationInfo.uid;
        try {
            Class cls = Class.forName(AppOpsManager.class.getName());
            if (((Integer) cls.getMethod("checkOpNoThrow", new Class[]{Integer.TYPE, Integer.TYPE, String.class}).invoke(appOpsManager, new Object[]{Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i), packageName})).intValue() != 0) {
                z = false;
            }
            return z;
        } catch (Throwable th) {
            C6864a.m29308i(str, th.getMessage());
            return true;
        }
    }
}
