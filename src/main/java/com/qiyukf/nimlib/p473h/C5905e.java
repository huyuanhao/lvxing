package com.qiyukf.nimlib.p473h;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.qiyukf.basesdk.p412c.C5407d;
import com.qiyukf.nimlib.C5718b;
import java.util.UUID;

/* renamed from: com.qiyukf.nimlib.h.e */
public final class C5905e {
    /* renamed from: a */
    public static String m23645a() {
        String str = "k_s_did";
        String d = m23653d(str);
        if (!TextUtils.isEmpty(d)) {
            return d;
        }
        String uuid = UUID.randomUUID().toString();
        m23647a(str, uuid);
        return uuid;
    }

    /* renamed from: a */
    public static void m23646a(String str) {
        m23647a("k_default_link", str);
    }

    /* renamed from: a */
    private static void m23647a(String str, String str2) {
        C5407d.m22127a(m23654e(), str, str2);
    }

    /* renamed from: b */
    public static String m23648b() {
        return m23653d("k_default_link");
    }

    /* renamed from: b */
    public static void m23649b(String str) {
        m23647a("k_default_link_test", str);
    }

    /* renamed from: c */
    public static String m23650c() {
        return m23653d("k_default_link_test");
    }

    /* renamed from: c */
    public static void m23651c(String str) {
        m23647a("k_default_link_pre", str);
    }

    /* renamed from: d */
    public static String m23652d() {
        return m23653d("k_default_link_pre");
    }

    /* renamed from: d */
    private static String m23653d(String str) {
        return m23654e().getString(str, null);
    }

    /* renamed from: e */
    private static SharedPreferences m23654e() {
        Context a = C5718b.m23009a();
        StringBuilder sb = new StringBuilder("NIMSDK_Config_");
        sb.append(C5718b.m23020g());
        return a.getSharedPreferences(sb.toString(), 0);
    }
}
