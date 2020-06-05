package com.tencent.android.tpush.service.p595e;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.service.e.h */
public class C7055h {
    /* renamed from: a */
    static int f23437a = 100;
    /* renamed from: b */
    private static SharedPreferences f23438b;

    /* renamed from: a */
    public static String m30169a(Context context, String str, String str2) {
        m30168a(context);
        return f23438b.getString(str, str2);
    }

    /* renamed from: b */
    public static void m30172b(Context context, String str, String str2) {
        try {
            Editor edit = m30168a(context).edit();
            edit.putString(str, str2);
            edit.commit();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public static int m30166a(Context context, String str, int i) {
        m30168a(context);
        return f23438b.getInt(str, i);
    }

    /* renamed from: b */
    public static void m30170b(Context context, String str, int i) {
        try {
            Editor edit = m30168a(context).edit();
            edit.putInt(str, i);
            edit.commit();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public static long m30167a(Context context, String str, long j) {
        m30168a(context);
        return f23438b.getLong(str, j);
    }

    /* renamed from: b */
    public static void m30171b(Context context, String str, long j) {
        try {
            Editor edit = m30168a(context).edit();
            edit.putLong(str, j);
            edit.commit();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    private static SharedPreferences m30168a(Context context) {
        if (f23438b == null) {
            f23438b = context.getSharedPreferences("tpush.shareprefs", 0);
        }
        return f23438b;
    }
}
