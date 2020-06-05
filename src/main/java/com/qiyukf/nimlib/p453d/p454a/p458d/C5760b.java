package com.qiyukf.nimlib.p453d.p454a.p458d;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;

/* renamed from: com.qiyukf.nimlib.d.a.d.b */
public final class C5760b {
    /* renamed from: a */
    public static boolean m23157a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && packageManager.checkPermission(str, context.getApplicationInfo().packageName) == 0) {
                return true;
            }
        }
        return false;
    }
}
