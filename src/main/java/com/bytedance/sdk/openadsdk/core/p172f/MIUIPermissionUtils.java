package com.bytedance.sdk.openadsdk.core.p172f;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build.VERSION;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.tencent.mid.core.Constants;
import com.tencent.mid.sotrage.StorageInterface;

/* renamed from: com.bytedance.sdk.openadsdk.core.f.a */
public class MIUIPermissionUtils {
    /* renamed from: a */
    private static final String f7518a = MIUIPermissionUtils.class.getSimpleName();

    /* renamed from: a */
    public static boolean m9555a(Context context, String str) {
        if (VERSION.SDK_INT >= 19) {
            return m9556b(context, str);
        }
        return m9557c(context, str);
    }

    /* renamed from: b */
    private static boolean m9556b(Context context, String str) {
        String str2 = f7518a;
        StringBuilder sb = new StringBuilder();
        sb.append("checkPermissinKITKATNew，permission：");
        sb.append(str);
        C2564t.m12226e(str2, sb.toString());
        char c = 65535;
        boolean z = false;
        try {
            int hashCode = str.hashCode();
            if (hashCode != -1888586689) {
                if (hashCode != -63024214) {
                    if (hashCode == -5573545) {
                        if (str.equals(Constants.PERMISSION_READ_PHONE_STATE)) {
                            c = 2;
                        }
                    }
                } else if (str.equals("android.permission.ACCESS_COARSE_LOCATION")) {
                    c = 0;
                }
            } else if (str.equals("android.permission.ACCESS_FINE_LOCATION")) {
                c = 1;
            }
            String str3 = c != 0 ? c != 1 ? c != 2 ? str.replaceFirst("android.permission.", "android:").toLowerCase() : "android:read_phone_state" : "android:fine_location" : "android:coarse_location";
            int checkOp = ((AppOpsManager) context.getSystemService("appops")).checkOp(str3, Binder.getCallingUid(), context.getPackageName());
            String str4 = f7518a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("checkPermissinKITKATNew，locationOp,permission：");
            sb2.append(checkOp);
            sb2.append(StorageInterface.KEY_SPLITER);
            sb2.append(str3);
            C2564t.m12226e(str4, sb2.toString());
            if (checkOp == 0) {
                return true;
            }
            try {
                String str5 = f7518a;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("checkPermissinKITKATNew，false,permission：");
                sb3.append(str3);
                C2564t.m12226e(str5, sb3.toString());
                return false;
            } catch (Exception e) {
                e = e;
            }
        } catch (Exception e2) {
            e = e2;
            z = true;
            String str6 = f7518a;
            StringBuilder sb4 = new StringBuilder();
            sb4.append("权限检查出错时默认返回有权限，异常代码：");
            sb4.append(e);
            C2564t.m12226e(str6, sb4.toString());
            return z;
        }
    }

    /* renamed from: c */
    private static boolean m9557c(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }
}
