package com.yanzhenjie.permission.p633a;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Process;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.yanzhenjie.permission.a.s */
public final class StandardChecker implements PermissionChecker {
    /* renamed from: a */
    public boolean mo38009a(Context context, String... strArr) {
        return mo38014a(context, Arrays.asList(strArr));
    }

    /* renamed from: a */
    public boolean mo38014a(Context context, List<String> list) {
        if (VERSION.SDK_INT < 23) {
            return true;
        }
        AppOpsManager appOpsManager = null;
        for (String str : list) {
            if (context.checkPermission(str, Process.myPid(), Process.myUid()) == -1) {
                return false;
            }
            String permissionToOp = AppOpsManager.permissionToOp(str);
            if (!TextUtils.isEmpty(permissionToOp)) {
                if (appOpsManager == null) {
                    appOpsManager = (AppOpsManager) context.getSystemService("appops");
                }
                int checkOpNoThrow = appOpsManager.checkOpNoThrow(permissionToOp, Process.myUid(), context.getPackageName());
                if (!(checkOpNoThrow == 0 || checkOpNoThrow == 4 || checkOpNoThrow == 5)) {
                    return false;
                }
            }
        }
        return true;
    }
}
