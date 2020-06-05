package com.tencent.android.tpush.common;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.android.tpush.p580b.C6864a;
import com.tencent.android.tpush.service.C6973b;
import com.tencent.mid.core.Constants;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.common.f */
public class C6906f {
    /* renamed from: a */
    private static final String[] f22975a = {Constants.PERMISSION_INTERNET, Constants.PERMISSION_ACCESS_WIFI_STATE, Constants.PERMISSION_ACCESS_NETWORK_STATE};
    /* renamed from: b */
    private static Map<String, Boolean> f22976b = new HashMap(8);

    /* renamed from: b */
    private static Context m29474b() {
        if (XGPushManager.getContext() != null) {
            return XGPushManager.getContext();
        }
        return C6973b.m29776f();
    }

    /* renamed from: a */
    public static boolean m29472a(String str) {
        boolean z = false;
        try {
            if (f22976b.containsKey(str)) {
                return ((Boolean) f22976b.get(str)).booleanValue();
            }
            Context b = m29474b();
            if (b.getPackageManager().checkPermission(str, b.getPackageName()) == 0) {
                z = true;
            }
            f22976b.put(str, Boolean.valueOf(z));
            return z;
        } catch (Throwable th) {
            Log.e("XgStat", "checkPermission error", th);
        }
    }

    /* renamed from: a */
    public static boolean m29471a() {
        String[] strArr;
        String str = Constants.LogTag;
        Context b = m29474b();
        if (b != null) {
            try {
                PackageManager packageManager = b.getPackageManager();
                if (packageManager != null) {
                    String[] strArr2 = packageManager.getPackageInfo(b.getPackageName(), 4096).requestedPermissions;
                    if (strArr2 == null) {
                        return false;
                    }
                    for (String str2 : f22975a) {
                        boolean a = m29473a(strArr2, str2);
                        f22976b.put(str2, Boolean.valueOf(a));
                        if (!a) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("The required permission of <");
                            sb.append(str2);
                            sb.append("> does not found!");
                            C6864a.m29309j(str, sb.toString());
                            return false;
                        }
                    }
                }
                return true;
            } catch (Exception e) {
                C6864a.m29302d(str, "check required permissins exception.", e);
                return false;
            }
        } else {
            throw new IllegalArgumentException("The context parameter can not be null!");
        }
    }

    /* renamed from: a */
    private static boolean m29473a(String[] strArr, String str) {
        for (String equals : strArr) {
            if (str.equals(equals)) {
                return true;
            }
        }
        return false;
    }
}
