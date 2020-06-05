package com.tencent.android.tpush.service.p595e;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.service.e.g */
public class C7054g {
    /* renamed from: a */
    private static SharedPreferences f23436a;

    /* renamed from: a */
    static synchronized SharedPreferences m30160a(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (C7054g.class) {
            if (f23436a == null) {
                f23436a = context.getSharedPreferences(".tpns.service.xml", 0);
            }
            sharedPreferences = f23436a;
        }
        return sharedPreferences;
    }

    /* renamed from: a */
    public static long m30159a(Context context, String str, long j) {
        return m30160a(context).getLong(str, j);
    }

    /* renamed from: b */
    public static void m30164b(Context context, String str, long j) {
        Editor edit = m30160a(context).edit();
        edit.putLong(str, j);
        m30162a(edit);
    }

    /* renamed from: a */
    public static int m30158a(Context context, String str, int i) {
        return m30160a(context).getInt(str, i);
    }

    /* renamed from: b */
    public static void m30163b(Context context, String str, int i) {
        Editor edit = m30160a(context).edit();
        edit.putInt(str, i);
        m30162a(edit);
    }

    /* renamed from: a */
    public static String m30161a(Context context, String str, String str2) {
        if (!m30160a(context).contains(str)) {
            return str2;
        }
        return m30160a(context).getString(str, str2);
    }

    /* renamed from: b */
    public static void m30165b(Context context, String str, String str2) {
        Editor edit = m30160a(context).edit();
        edit.putString(str, str2);
        m30162a(edit);
    }

    /* renamed from: a */
    private static void m30162a(Editor editor) {
        if (VERSION.SDK_INT >= 9) {
            editor.apply();
        } else {
            editor.commit();
        }
    }
}
