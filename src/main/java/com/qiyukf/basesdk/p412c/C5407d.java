package com.qiyukf.basesdk.p412c;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;

/* renamed from: com.qiyukf.basesdk.c.d */
public final class C5407d {
    /* renamed from: a */
    public static void m22124a(Editor editor) {
        if (VERSION.SDK_INT >= 9) {
            editor.apply();
        } else {
            editor.commit();
        }
    }

    /* renamed from: a */
    public static void m22125a(SharedPreferences sharedPreferences, String str, int i) {
        m22124a(sharedPreferences.edit().putInt(str, i));
    }

    /* renamed from: a */
    public static void m22126a(SharedPreferences sharedPreferences, String str, long j) {
        m22124a(sharedPreferences.edit().putLong(str, j));
    }

    /* renamed from: a */
    public static void m22127a(SharedPreferences sharedPreferences, String str, String str2) {
        m22124a(sharedPreferences.edit().putString(str, str2));
    }

    /* renamed from: a */
    public static void m22128a(SharedPreferences sharedPreferences, String str, boolean z) {
        m22124a(sharedPreferences.edit().putBoolean(str, z));
    }
}
