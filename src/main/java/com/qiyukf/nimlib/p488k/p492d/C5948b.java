package com.qiyukf.nimlib.p488k.p492d;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import com.qiyukf.basesdk.p412c.p417d.C5411c;
import com.qiyukf.nimlib.C5718b;
import java.util.UUID;

/* renamed from: com.qiyukf.nimlib.k.d.b */
public final class C5948b {
    /* renamed from: a */
    public static String m23845a() {
        try {
            return System.getString(C5718b.m23009a().getContentResolver(), "android_id");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    public static String m23846b() {
        try {
            return ((TelephonyManager) C5718b.m23009a().getSystemService("phone")).getDeviceId();
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: c */
    public static String m23847c() {
        String b = m23846b();
        String str = "";
        if (b != null && !b.equals(str)) {
            return b;
        }
        String a = m23845a();
        if (a != null && !a.toLowerCase().equals("9774d56d682e549c") && !a.equals(str)) {
            return a;
        }
        String str2 = Build.SERIAL;
        if (str2 != null) {
            return str2;
        }
        String g = C5411c.m22140g(C5718b.m23009a());
        return (g == null || g.equals(str)) ? m23848d() : g;
    }

    /* renamed from: d */
    private static String m23848d() {
        String str;
        String str2 = "";
        String str3 = "OpenUdid";
        try {
            SharedPreferences sharedPreferences = C5718b.m23009a().getSharedPreferences(str3, 0);
            str = sharedPreferences.getString(str3, str2);
            try {
                if (str.equals(str2)) {
                    String uuid = UUID.randomUUID().toString();
                    Editor edit = sharedPreferences.edit();
                    edit.putString(str3, uuid);
                    edit.commit();
                    return uuid;
                }
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            str = null;
        }
        return str;
    }
}
