package com.tencent.dynamicbundle.p604a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/* compiled from: ProGuard */
/* renamed from: com.tencent.dynamicbundle.a.b */
public class C7285b {
    /* renamed from: a */
    private static SharedPreferences f24682a;

    /* renamed from: a */
    public static String m31451a(Context context, String str, String str2) {
        m31450a(context);
        return f24682a.getString(str, str2);
    }

    /* renamed from: a */
    public static int m31449a(Context context, String str, int i) {
        m31450a(context);
        return f24682a.getInt(str, i);
    }

    /* renamed from: b */
    public static void m31452b(Context context, String str, int i) {
        try {
            Editor edit = m31450a(context).edit();
            edit.putInt(str, i);
            edit.commit();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    private static SharedPreferences m31450a(Context context) {
        if (f24682a == null) {
            f24682a = context.getSharedPreferences("tpush.shareprefs", 0);
        }
        return f24682a;
    }
}
