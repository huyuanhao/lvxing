package com.bytedance.sdk.openadsdk.multipro.p205d;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.android.tpush.SettingsContentProvider;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.bytedance.sdk.openadsdk.multipro.d.b */
class SPMultiHelperImpl {
    /* renamed from: a */
    private static SoftReference<ConcurrentHashMap<String, Map<String, Object>>> f9096a;

    /* renamed from: c */
    private static SharedPreferences m11899c(Context context, String str) {
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences(m11889a(str), 0);
    }

    /* renamed from: a */
    private static String m11889a(String str) {
        return TextUtils.isEmpty(str) ? "sphelper_ttopenadsdk" : str;
    }

    /* renamed from: a */
    private static Object m11887a(String str, String str2) {
        SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = f9096a;
        if (softReference != null) {
            ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) softReference.get();
            if (concurrentHashMap != null) {
                Map map = (Map) concurrentHashMap.get(m11889a(str));
                if (map != null) {
                    return map.get(str2);
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    private static void m11892a(String str, String str2, Object obj) {
        SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = f9096a;
        if (softReference == null || softReference.get() == null) {
            f9096a = new SoftReference<>(new ConcurrentHashMap());
        }
        String a = m11889a(str);
        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) f9096a.get();
        if (concurrentHashMap.get(a) == null) {
            concurrentHashMap.put(a, new HashMap());
        }
        ((Map) concurrentHashMap.get(a)).put(str2, obj);
    }

    /* renamed from: b */
    private static void m11898b(String str) {
        SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = f9096a;
        if (softReference != null && softReference.get() != null) {
            Map map = (Map) ((ConcurrentHashMap) f9096a.get()).get(m11889a(str));
            if (map != null) {
                map.clear();
            }
        }
    }

    /* renamed from: a */
    static synchronized <T> void m11891a(Context context, String str, String str2, T t) {
        synchronized (SPMultiHelperImpl.class) {
            SharedPreferences c = m11899c(context, str);
            if (c != null) {
                if (!t.equals(m11887a(str, str2))) {
                    Editor edit = c.edit();
                    if (t instanceof Boolean) {
                        edit.putBoolean(str2, ((Boolean) t).booleanValue());
                    }
                    if (t instanceof String) {
                        edit.putString(str2, (String) t);
                    }
                    if (t instanceof Integer) {
                        edit.putInt(str2, ((Integer) t).intValue());
                    }
                    if (t instanceof Long) {
                        edit.putLong(str2, ((Long) t).longValue());
                    }
                    if (t instanceof Float) {
                        edit.putFloat(str2, ((Float) t).floatValue());
                    }
                    edit.apply();
                    m11892a(str, str2, (Object) t);
                }
            }
        }
    }

    /* renamed from: a */
    static String m11888a(Context context, String str, String str2, String str3) {
        Object a = m11887a(str, str2);
        String str4 = "";
        if (a != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(a);
            sb.append(str4);
            return sb.toString();
        }
        Object b = m11895b(context, str, str2, str3);
        m11892a(str, str2, b);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(b);
        sb2.append(str4);
        return sb2.toString();
    }

    /* renamed from: b */
    private static Object m11895b(Context context, String str, String str2, String str3) {
        String a = m11889a(str);
        if (!m11893a(context, a, str2)) {
            return null;
        }
        if (str3.equalsIgnoreCase(SettingsContentProvider.STRING_TYPE)) {
            return m11900c(context, a, str2, null);
        }
        if (str3.equalsIgnoreCase(SettingsContentProvider.BOOLEAN_TYPE)) {
            return Boolean.valueOf(m11894a(context, a, str2, false));
        }
        if (str3.equalsIgnoreCase("int")) {
            return Integer.valueOf(m11885a(context, a, str2, 0));
        }
        if (str3.equalsIgnoreCase(SettingsContentProvider.LONG_TYPE)) {
            return Long.valueOf(m11886a(context, a, str2, 0));
        }
        if (str3.equalsIgnoreCase(SettingsContentProvider.FLOAT_TYPE)) {
            return Float.valueOf(m11884a(context, a, str2, 0.0f));
        }
        if (str3.equalsIgnoreCase("string_set")) {
            return m11900c(context, a, str2, null);
        }
        return null;
    }

    /* renamed from: c */
    private static String m11900c(Context context, String str, String str2, String str3) {
        SharedPreferences c = m11899c(context, str);
        if (c == null) {
            return str3;
        }
        return c.getString(str2, str3);
    }

    /* renamed from: a */
    private static int m11885a(Context context, String str, String str2, int i) {
        SharedPreferences c = m11899c(context, str);
        if (c == null) {
            return i;
        }
        return c.getInt(str2, i);
    }

    /* renamed from: a */
    private static float m11884a(Context context, String str, String str2, float f) {
        SharedPreferences c = m11899c(context, str);
        if (c == null) {
            return f;
        }
        return c.getFloat(str2, f);
    }

    /* renamed from: a */
    private static boolean m11894a(Context context, String str, String str2, boolean z) {
        SharedPreferences c = m11899c(context, str);
        if (c == null) {
            return z;
        }
        return c.getBoolean(str2, z);
    }

    /* renamed from: a */
    private static long m11886a(Context context, String str, String str2, long j) {
        SharedPreferences c = m11899c(context, str);
        if (c == null) {
            return j;
        }
        return c.getLong(str2, j);
    }

    /* renamed from: a */
    static boolean m11893a(Context context, String str, String str2) {
        SharedPreferences c = m11899c(context, str);
        return c != null && c.contains(str2);
    }

    /* renamed from: b */
    static void m11897b(Context context, String str, String str2) {
        try {
            SharedPreferences c = m11899c(context, str);
            if (c != null) {
                Editor edit = c.edit();
                edit.remove(str2);
                edit.apply();
                if (!(f9096a == null || f9096a.get() == null)) {
                    String a = m11889a(str);
                    if (!TextUtils.isEmpty(a)) {
                        Map map = (Map) ((ConcurrentHashMap) f9096a.get()).get(a);
                        if (map != null) {
                            if (map.size() != 0) {
                                map.remove(str2);
                                if (!(f9096a == null || f9096a.get() == null)) {
                                    ((ConcurrentHashMap) f9096a.get()).put(a, map);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    static void m11890a(Context context, String str) {
        Editor edit = m11899c(context, str).edit();
        edit.clear();
        edit.apply();
        m11898b(str);
    }

    /* renamed from: b */
    static Map<String, ?> m11896b(Context context, String str) {
        return m11899c(context, str).getAll();
    }
}
