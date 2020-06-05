package com.qiyukf.nimlib.p429a;

import android.content.Context;
import android.content.SharedPreferences;
import com.qiyukf.basesdk.p412c.C5407d;
import com.qiyukf.nimlib.C5718b;

/* renamed from: com.qiyukf.nimlib.a.d */
public final class C5685d {
    /* renamed from: a */
    public static int m22935a() {
        return (int) m22939c().getLong("k_sys_msg_unread_c", 0);
    }

    /* renamed from: a */
    public static void m22936a(int i) {
        C5407d.m22126a(m22939c(), "k_sys_msg_unread_c", (long) i);
    }

    /* renamed from: a */
    public static void m22937a(String str) {
        C5407d.m22127a(m22939c(), "k_client_ip", str);
    }

    /* renamed from: b */
    public static String m22938b() {
        return m22939c().getString("k_client_ip", null);
    }

    /* renamed from: c */
    private static SharedPreferences m22939c() {
        Context a = C5718b.m23009a();
        StringBuilder sb = new StringBuilder("NIMSDK_Config_");
        sb.append(C5718b.m23020g());
        sb.append("_");
        sb.append(C5718b.m23015b());
        return a.getSharedPreferences(sb.toString(), 0);
    }
}
