package com.alipay.apmobilesecuritysdk.p107e;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import com.alipay.p109b.p110a.p111a.p112a.C1460a;
import com.alipay.p109b.p110a.p111a.p112a.p113a.C1463c;
import com.alipay.p109b.p110a.p111a.p114b.C1469e;

/* renamed from: com.alipay.apmobilesecuritysdk.e.g */
public final class C1452g {
    /* renamed from: a */
    public static synchronized String m4208a(Context context, String str) {
        synchronized (C1452g.class) {
            String str2 = "openapi_file_pri";
            StringBuilder sb = new StringBuilder("openApi");
            sb.append(str);
            String a = C1469e.m4286a(context, str2, sb.toString(), "");
            if (C1460a.m4260a(a)) {
                String str3 = "";
                return str3;
            }
            String b = C1463c.m4276b(C1463c.m4271a(), a);
            if (!C1460a.m4260a(b)) {
                return b;
            }
            String str4 = "";
            return str4;
        }
    }

    /* renamed from: a */
    public static synchronized void m4209a() {
        synchronized (C1452g.class) {
        }
    }

    /* renamed from: a */
    public static synchronized void m4210a(Context context) {
        synchronized (C1452g.class) {
            Editor edit = context.getSharedPreferences("openapi_file_pri", 0).edit();
            if (edit != null) {
                edit.clear();
                edit.commit();
            }
        }
    }

    /* renamed from: a */
    public static synchronized void m4211a(Context context, String str, String str2) {
        synchronized (C1452g.class) {
            try {
                Editor edit = context.getSharedPreferences("openapi_file_pri", 0).edit();
                if (edit != null) {
                    StringBuilder sb = new StringBuilder("openApi");
                    sb.append(str);
                    edit.putString(sb.toString(), C1463c.m4272a(C1463c.m4271a(), str2));
                    edit.commit();
                }
            } catch (Throwable unused) {
            }
        }
    }
}
