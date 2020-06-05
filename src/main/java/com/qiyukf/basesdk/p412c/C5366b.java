package com.qiyukf.basesdk.p412c;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.qiyukf.basesdk.c.b */
public final class C5366b {
    /* renamed from: a */
    public static String m22026a(JSONArray jSONArray, int i) {
        if (jSONArray == null) {
            return null;
        }
        return jSONArray.optString(i);
    }

    /* renamed from: a */
    public static JSONObject m22027a(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return new JSONObject(str);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    /* renamed from: a */
    public static void m22028a(JSONArray jSONArray, Object obj) {
        try {
            jSONArray.put(obj);
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public static void m22029a(JSONObject jSONObject, String str, int i) {
        try {
            jSONObject.put(str, i);
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public static void m22030a(JSONObject jSONObject, String str, long j) {
        try {
            jSONObject.put(str, j);
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public static void m22031a(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public static void m22032a(JSONObject jSONObject, String str, String str2) {
        try {
            jSONObject.put(str, str2);
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public static boolean m22033a(JSONObject jSONObject, String str) {
        return jSONObject != null && jSONObject.optBoolean(str);
    }

    /* renamed from: b */
    public static int m22034b(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return 0;
        }
        return jSONObject.optInt(str);
    }

    /* renamed from: b */
    public static JSONArray m22035b(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return new JSONArray(str);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    /* renamed from: b */
    public static JSONObject m22036b(JSONArray jSONArray, int i) {
        if (jSONArray == null) {
            return null;
        }
        return jSONArray.optJSONObject(i);
    }

    /* renamed from: c */
    public static long m22037c(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return 0;
        }
        return jSONObject.optLong(str);
    }

    /* renamed from: d */
    public static double m22038d(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return 0.0d;
        }
        return jSONObject.optDouble(str);
    }

    /* renamed from: e */
    public static String m22039e(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.optString(str, null);
    }

    /* renamed from: f */
    public static JSONObject m22040f(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.optJSONObject(str);
    }

    /* renamed from: g */
    public static JSONArray m22041g(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.optJSONArray(str);
    }
}
