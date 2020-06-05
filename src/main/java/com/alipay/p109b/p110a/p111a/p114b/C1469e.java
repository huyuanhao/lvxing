package com.alipay.p109b.p110a.p111a.p114b;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import java.util.Map;

/* renamed from: com.alipay.b.a.a.b.e */
public final class C1469e {
    /* renamed from: a */
    public static String m4286a(Context context, String str, String str2, String str3) {
        return context.getSharedPreferences(str, 0).getString(str2, str3);
    }

    /* renamed from: a */
    public static void m4287a(Context context, String str, Map<String, String> map) {
        Editor edit = context.getSharedPreferences(str, 0).edit();
        if (edit != null) {
            for (String str2 : map.keySet()) {
                edit.putString(str2, (String) map.get(str2));
            }
            edit.commit();
        }
    }
}
