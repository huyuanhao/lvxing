package com.tencent.android.otherPush.p578a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.otherPush.a.b */
public class C6816b {
    /* renamed from: a */
    static int f22618a = 100;
    /* renamed from: b */
    private static SharedPreferences f22619b;

    /* renamed from: a */
    public static String m29185a(Context context, String str, String str2) {
        m29184a(context);
        return f22619b.getString(str, str2);
    }

    /* renamed from: a */
    public static int m29183a(Context context, String str, int i) {
        m29184a(context);
        return f22619b.getInt(str, i);
    }

    /* renamed from: b */
    public static void m29186b(Context context, String str, int i) {
        try {
            Editor edit = m29184a(context).edit();
            edit.putInt(str, i);
            edit.commit();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    private static SharedPreferences m29184a(Context context) {
        if (f22619b == null) {
            f22619b = context.getSharedPreferences("tpush.shareprefs", 0);
        }
        return f22619b;
    }
}
