package com.alipay.apmobilesecuritysdk.p107e;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import com.alipay.p109b.p110a.p111a.p112a.C1460a;
import com.alipay.p109b.p110a.p111a.p112a.p113a.C1462b;
import com.alipay.p109b.p110a.p111a.p114b.C1465a;
import com.alipay.p109b.p110a.p111a.p114b.C1469e;
import java.util.UUID;

/* renamed from: com.alipay.apmobilesecuritysdk.e.h */
public class C1453h {
    /* renamed from: a */
    private static String f3712a = "";

    /* renamed from: a */
    public static long m4212a(Context context) {
        String a = C1465a.m4280a(context, "vkeyid_settings", "update_time_interval");
        long j = 86400000;
        if (!C1460a.m4263b(a)) {
            return 86400000;
        }
        try {
            j = Long.parseLong(a);
            return j;
        } catch (Exception unused) {
            return j;
        }
    }

    /* renamed from: a */
    public static void m4213a(Context context, String str) {
        m4215a(context, "update_time_interval", str);
    }

    /* renamed from: a */
    public static void m4214a(Context context, String str, long j) {
        StringBuilder sb = new StringBuilder("vkey_valid");
        sb.append(str);
        C1465a.m4281a(context, "vkeyid_settings", sb.toString(), String.valueOf(j));
    }

    /* renamed from: a */
    private static void m4215a(Context context, String str, String str2) {
        C1465a.m4281a(context, "vkeyid_settings", str, str2);
    }

    /* renamed from: a */
    public static void m4216a(Context context, boolean z) {
        m4215a(context, "log_switch", z ? "1" : "0");
    }

    /* renamed from: b */
    public static String m4217b(Context context) {
        return C1465a.m4280a(context, "vkeyid_settings", "last_apdid_env");
    }

    /* renamed from: b */
    public static void m4218b(Context context, String str) {
        m4215a(context, "last_machine_boot_time", str);
    }

    /* renamed from: c */
    public static void m4219c(Context context, String str) {
        m4215a(context, "last_apdid_env", str);
    }

    /* renamed from: c */
    public static boolean m4220c(Context context) {
        String a = C1465a.m4280a(context, "vkeyid_settings", "log_switch");
        return a != null && "1".equals(a);
    }

    /* renamed from: d */
    public static String m4221d(Context context) {
        return C1465a.m4280a(context, "vkeyid_settings", "dynamic_key");
    }

    /* renamed from: d */
    public static void m4222d(Context context, String str) {
        m4215a(context, "agent_switch", str);
    }

    /* renamed from: e */
    public static String m4223e(Context context) {
        return C1465a.m4280a(context, "vkeyid_settings", "apse_degrade");
    }

    /* renamed from: e */
    public static void m4224e(Context context, String str) {
        m4215a(context, "dynamic_key", str);
    }

    /* renamed from: f */
    public static String m4225f(Context context) {
        String str;
        synchronized (C1453h.class) {
            if (C1460a.m4260a(f3712a)) {
                String a = C1469e.m4286a(context, "alipay_vkey_random", "random", "");
                f3712a = a;
                if (C1460a.m4260a(a)) {
                    f3712a = C1462b.m4270a(UUID.randomUUID().toString());
                    String str2 = "alipay_vkey_random";
                    String str3 = "random";
                    String str4 = f3712a;
                    if (str4 != null) {
                        Editor edit = context.getSharedPreferences(str2, 0).edit();
                        if (edit != null) {
                            edit.putString(str3, str4);
                            edit.commit();
                        }
                    }
                }
            }
            str = f3712a;
        }
        return str;
    }

    /* renamed from: f */
    public static void m4226f(Context context, String str) {
        m4215a(context, "webrtc_url", str);
    }

    /* renamed from: g */
    public static void m4227g(Context context, String str) {
        m4215a(context, "apse_degrade", str);
    }

    /* renamed from: h */
    public static long m4228h(Context context, String str) {
        String str2 = "vkeyid_settings";
        try {
            StringBuilder sb = new StringBuilder("vkey_valid");
            sb.append(str);
            String a = C1465a.m4280a(context, str2, sb.toString());
            if (C1460a.m4260a(a)) {
                return 0;
            }
            return Long.parseLong(a);
        } catch (Throwable unused) {
            return 0;
        }
    }
}
