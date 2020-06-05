package com.alipay.sdk.util;

import android.content.Context;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.alipay.sdk.app.statistic.C1505a;
import com.alipay.sdk.p122c.C1517e;

/* renamed from: com.alipay.sdk.util.k */
public class C1549k {
    /* renamed from: a */
    private static String f3964a;

    /* renamed from: a */
    public static void m4654a(Context context, String str) {
        try {
            PreferenceManager.getDefaultSharedPreferences(context).edit().remove(str).commit();
        } catch (Throwable th) {
            C1542e.m4633a(th);
        }
    }

    /* renamed from: a */
    public static void m4655a(Context context, String str, String str2) {
        try {
            String a = C1517e.m4518a(m4653a(context), str2);
            if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(a)) {
                C1505a.m4452a("cp", "TriDesDecryptError", String.format("%s,%s", new Object[]{str, str2}));
            }
            PreferenceManager.getDefaultSharedPreferences(context).edit().putString(str, a).commit();
        } catch (Throwable th) {
            C1542e.m4633a(th);
        }
    }

    /* renamed from: b */
    public static String m4656b(Context context, String str, String str2) {
        String str3 = null;
        try {
            String string = PreferenceManager.getDefaultSharedPreferences(context).getString(str, str2);
            if (!TextUtils.isEmpty(string)) {
                str3 = C1517e.m4520b(m4653a(context), string);
            }
            if (!TextUtils.isEmpty(string) && TextUtils.isEmpty(str3)) {
                Object[] objArr = {str, string};
                C1505a.m4452a("cp", "TriDesEncryptError", String.format("%s,%s", objArr));
            }
        } catch (Exception e) {
            C1542e.m4633a(e);
        }
        return str3;
    }

    /* renamed from: a */
    private static String m4653a(Context context) {
        String str;
        if (TextUtils.isEmpty(f3964a)) {
            try {
                str = context.getApplicationContext().getPackageName();
            } catch (Throwable th) {
                C1542e.m4633a(th);
                str = "";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("0000000000000000000000000000");
            f3964a = sb.toString().substring(0, 24);
        }
        return f3964a;
    }
}
