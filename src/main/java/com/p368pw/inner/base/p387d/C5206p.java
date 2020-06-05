package com.p368pw.inner.base.p387d;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/* renamed from: com.pw.inner.base.d.p */
public class C5206p {
    /* renamed from: a */
    public static long m21468a(Context context, String str) {
        return m21469a(context).getLong(str, 0);
    }

    /* renamed from: a */
    public static SharedPreferences m21469a(Context context) {
        return context.getSharedPreferences("wns_aa", 0);
    }

    /* renamed from: a */
    public static void m21470a(Context context, String str, long j) {
        Editor edit = m21469a(context).edit();
        edit.putLong(str, j);
        edit.apply();
    }

    /* renamed from: a */
    public static void m21471a(Context context, String str, String str2) {
        Editor edit = m21469a(context).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    /* renamed from: b */
    public static String m21472b(Context context, String str) {
        return m21469a(context).getString(str, "");
    }

    /* renamed from: c */
    public static void m21473c(Context context, String str) {
        Editor edit = m21469a(context).edit();
        edit.remove(str);
        edit.apply();
    }
}
