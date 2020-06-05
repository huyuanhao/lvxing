package com.tencent.android.tpush.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.tencent.android.tpush.p580b.C6864a;
import java.io.Closeable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.common.b */
public class C6900b {
    /* renamed from: a */
    public static boolean m29457a(JSONObject jSONObject, String str, Object obj) {
        if (obj != null) {
            try {
                jSONObject.put(str, obj);
                return true;
            } catch (JSONException unused) {
            }
        }
        return false;
    }

    /* renamed from: b */
    public static Object m29458b(JSONObject jSONObject, String str, Object obj) {
        try {
            if (jSONObject.has(str)) {
                return jSONObject.get(str);
            }
        } catch (JSONException unused) {
        }
        return obj;
    }

    /* renamed from: a */
    public static Object m29455a(Context context, String str, Object obj) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                Object obj2 = applicationInfo.metaData.get(str);
                if (obj2 != null) {
                    return obj2;
                }
            }
        } catch (Throwable th) {
            C6864a.m29302d(Constants.LogTag, "", th);
        }
        return obj;
    }

    /* renamed from: a */
    public static boolean m29456a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
