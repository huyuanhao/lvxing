package com.bytedance.sdk.openadsdk.multipro.p205d;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.multipro.TTPathConst;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.tencent.android.tpush.SettingsContentProvider;
import com.tencent.mid.sotrage.StorageInterface;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.bytedance.sdk.openadsdk.multipro.d.a */
public class SPMultiHelper {
    /* renamed from: a */
    private static Context f9095a;

    /* renamed from: a */
    public static boolean m11876a() {
        if (f9095a != null && InternalContainer.m10059a() != null) {
            return true;
        }
        C2564t.m12219b("The context of SPHelper is null, please initialize sdk in main process");
        return false;
    }

    /* renamed from: b */
    private static ContentResolver m11878b() {
        try {
            if (m11876a()) {
                return m11882c().getContentResolver();
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    /* renamed from: a */
    public static void m11867a(Context context) {
        f9095a = context == null ? InternalContainer.m10059a() : context.getApplicationContext();
    }

    /* renamed from: c */
    private static Context m11882c() {
        Context context = f9095a;
        return context == null ? InternalContainer.m10059a() : context;
    }

    /* renamed from: d */
    private static String m11883d() {
        StringBuilder sb = new StringBuilder();
        sb.append(TTPathConst.f9099b);
        String str = "/";
        sb.append(str);
        sb.append("t_sp");
        sb.append(str);
        return sb.toString();
    }

    /* renamed from: b */
    private static String m11879b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("?sp_file_name=");
        sb.append(str);
        return sb.toString();
    }

    /* renamed from: a */
    public static synchronized void m11870a(String str, String str2, Boolean bool) {
        synchronized (SPMultiHelper.class) {
            if (m11876a()) {
                try {
                    ContentResolver b = m11878b();
                    if (b != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(m11883d());
                        sb.append(SettingsContentProvider.BOOLEAN_TYPE);
                        sb.append("/");
                        sb.append(str2);
                        sb.append(m11879b(str));
                        Uri parse = Uri.parse(sb.toString());
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(ArgKey.KEY_VALUE, bool);
                        b.update(parse, contentValues, null, null);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* renamed from: a */
    public static synchronized void m11874a(String str, String str2, String str3) {
        synchronized (SPMultiHelper.class) {
            if (m11876a()) {
                try {
                    ContentResolver b = m11878b();
                    if (b != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(m11883d());
                        sb.append(SettingsContentProvider.STRING_TYPE);
                        sb.append("/");
                        sb.append(str2);
                        sb.append(m11879b(str));
                        Uri parse = Uri.parse(sb.toString());
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(ArgKey.KEY_VALUE, str3);
                        b.update(parse, contentValues, null, null);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* renamed from: a */
    public static synchronized void m11872a(String str, String str2, Integer num) {
        synchronized (SPMultiHelper.class) {
            if (m11876a()) {
                try {
                    ContentResolver b = m11878b();
                    if (b != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(m11883d());
                        sb.append("int");
                        sb.append("/");
                        sb.append(str2);
                        sb.append(m11879b(str));
                        Uri parse = Uri.parse(sb.toString());
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(ArgKey.KEY_VALUE, num);
                        b.update(parse, contentValues, null, null);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* renamed from: a */
    public static synchronized void m11873a(String str, String str2, Long l) {
        synchronized (SPMultiHelper.class) {
            if (m11876a()) {
                try {
                    ContentResolver b = m11878b();
                    if (b != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(m11883d());
                        sb.append(SettingsContentProvider.LONG_TYPE);
                        sb.append("/");
                        sb.append(str2);
                        sb.append(m11879b(str));
                        Uri parse = Uri.parse(sb.toString());
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(ArgKey.KEY_VALUE, l);
                        b.update(parse, contentValues, null, null);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* renamed from: a */
    public static synchronized void m11871a(String str, String str2, Float f) {
        synchronized (SPMultiHelper.class) {
            if (m11876a()) {
                try {
                    ContentResolver b = m11878b();
                    if (b != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(m11883d());
                        sb.append(SettingsContentProvider.FLOAT_TYPE);
                        sb.append("/");
                        sb.append(str2);
                        sb.append(m11879b(str));
                        Uri parse = Uri.parse(sb.toString());
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(ArgKey.KEY_VALUE, f);
                        b.update(parse, contentValues, null, null);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* renamed from: a */
    public static synchronized void m11875a(String str, String str2, Set<String> set) {
        synchronized (SPMultiHelper.class) {
            if (m11876a()) {
                try {
                    ContentResolver b = m11878b();
                    if (b != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(m11883d());
                        sb.append("string_set");
                        sb.append("/");
                        sb.append(str2);
                        sb.append(m11879b(str));
                        Uri parse = Uri.parse(sb.toString());
                        ContentValues contentValues = new ContentValues();
                        HashSet hashSet = new HashSet();
                        for (String replace : set) {
                            hashSet.add(replace.replace(StorageInterface.KEY_SPLITER, "__COMMA__"));
                        }
                        contentValues.put(ArgKey.KEY_VALUE, hashSet.toString());
                        b.update(parse, contentValues, null, null);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* renamed from: b */
    public static String m11880b(String str, String str2, String str3) {
        if (!m11876a()) {
            return str3;
        }
        try {
            ContentResolver b = m11878b();
            if (b != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(m11883d());
                sb.append(SettingsContentProvider.STRING_TYPE);
                sb.append("/");
                sb.append(str2);
                sb.append(m11879b(str));
                String type = b.getType(Uri.parse(sb.toString()));
                return (type == null || type.equals("null")) ? str3 : type;
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public static int m11865a(String str, String str2, int i) {
        if (!m11876a()) {
            return i;
        }
        try {
            ContentResolver b = m11878b();
            if (b != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(m11883d());
                sb.append("int");
                sb.append("/");
                sb.append(str2);
                sb.append(m11879b(str));
                String type = b.getType(Uri.parse(sb.toString()));
                if (type != null) {
                    if (!type.equals("null")) {
                        return Integer.parseInt(type);
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return i;
    }

    /* renamed from: a */
    public static float m11864a(String str, String str2, float f) {
        if (!m11876a()) {
            return f;
        }
        try {
            ContentResolver b = m11878b();
            if (b != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(m11883d());
                sb.append(SettingsContentProvider.FLOAT_TYPE);
                sb.append("/");
                sb.append(str2);
                sb.append(m11879b(str));
                String type = b.getType(Uri.parse(sb.toString()));
                if (type != null) {
                    if (!type.equals("null")) {
                        return Float.parseFloat(type);
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return f;
    }

    /* renamed from: a */
    public static boolean m11877a(String str, String str2, boolean z) {
        if (!m11876a()) {
            return z;
        }
        try {
            ContentResolver b = m11878b();
            if (b != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(m11883d());
                sb.append(SettingsContentProvider.BOOLEAN_TYPE);
                sb.append("/");
                sb.append(str2);
                sb.append(m11879b(str));
                String type = b.getType(Uri.parse(sb.toString()));
                if (type != null) {
                    if (!type.equals("null")) {
                        return Boolean.parseBoolean(type);
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return z;
    }

    /* renamed from: a */
    public static long m11866a(String str, String str2, long j) {
        if (!m11876a()) {
            return j;
        }
        try {
            ContentResolver b = m11878b();
            if (b != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(m11883d());
                sb.append(SettingsContentProvider.LONG_TYPE);
                sb.append("/");
                sb.append(str2);
                sb.append(m11879b(str));
                String type = b.getType(Uri.parse(sb.toString()));
                if (type != null) {
                    if (!type.equals("null")) {
                        return Long.parseLong(type);
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return j;
    }

    /* renamed from: b */
    public static Set<String> m11881b(String str, String str2, Set<String> set) {
        String str3 = ", ";
        if (!m11876a()) {
            return set;
        }
        try {
            ContentResolver b = m11878b();
            if (b != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(m11883d());
                sb.append("string_set");
                sb.append("/");
                sb.append(str2);
                sb.append(m11879b(str));
                String type = b.getType(Uri.parse(sb.toString()));
                if (type != null) {
                    if (!type.equals("null")) {
                        if (!type.matches("\\[.*\\]")) {
                            return set;
                        }
                        String[] split = type.substring(1, type.length() - 1).split(str3);
                        HashSet hashSet = new HashSet();
                        for (String replace : split) {
                            hashSet.add(replace.replace("__COMMA__", str3));
                        }
                        return hashSet;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return set;
    }

    /* renamed from: a */
    public static void m11869a(String str, String str2) {
        if (m11876a()) {
            try {
                ContentResolver b = m11878b();
                if (b != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(m11883d());
                    sb.append(SettingsContentProvider.LONG_TYPE);
                    sb.append("/");
                    sb.append(str2);
                    sb.append(m11879b(str));
                    b.delete(Uri.parse(sb.toString()), null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    public static void m11868a(String str) {
        if (m11876a()) {
            try {
                ContentResolver b = m11878b();
                if (b != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(m11883d());
                    sb.append("clean");
                    sb.append(m11879b(str));
                    b.delete(Uri.parse(sb.toString()), null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
