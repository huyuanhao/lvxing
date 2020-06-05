package com.tencent.android.tpush.stat.p596a;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.tencent.bigdata.dataacquisition.CustomDeviceInfos;
import java.util.Random;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.stat.a.f */
public class C7069f {
    /* renamed from: a */
    public static boolean m30292a(Context context, String str) {
        try {
            if (context.getPackageManager().checkPermission(str, context.getPackageName()) == 0) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            Log.e("XgStat", "checkPermission error", th);
            return false;
        }
    }

    /* renamed from: a */
    public static String m30289a(Context context) {
        String str = "xg.mta.ui";
        String a = C7068e.m30285a(context, str, "");
        if (TextUtils.isEmpty(a)) {
            a = CustomDeviceInfos.getDeviceId(context);
        }
        if (TextUtils.isEmpty(a)) {
            a = Integer.toString(new Random().nextInt(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED));
        }
        C7068e.m30288b(context, str, a);
        return a;
    }

    /* renamed from: a */
    public static String m30290a(String str) {
        String str2 = "UTF-8";
        if (str == null) {
            return null;
        }
        if (VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(C7065b.m30248b(Base64.decode(str.getBytes(str2), 0)), str2);
        } catch (Throwable th) {
            Log.e("XgStat", "decode error", th);
            return str;
        }
    }

    /* renamed from: b */
    public static String m30293b(String str) {
        String str2 = "UTF-8";
        if (str == null) {
            return null;
        }
        if (VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(Base64.encode(C7065b.m30246a(str.getBytes(str2)), 0), str2);
        } catch (Throwable th) {
            Log.e("XgStat", "encode error", th);
            return str;
        }
    }

    /* renamed from: a */
    public static void m30291a(JSONObject jSONObject, String str, String str2) {
        if (str2 != null) {
            try {
                if (str2.length() > 0) {
                    jSONObject.put(str, str2);
                }
            } catch (Throwable th) {
                Log.e("XgStat", "jsonPut error", th);
            }
        }
    }
}
