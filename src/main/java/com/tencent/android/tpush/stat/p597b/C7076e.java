package com.tencent.android.tpush.stat.p597b;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.stat.b.e */
public class C7076e {
    /* renamed from: a */
    private static C7076e f23530a;
    /* renamed from: b */
    private Context f23531b = null;
    /* renamed from: c */
    private SharedPreferences f23532c = null;
    /* renamed from: d */
    private String f23533d = "__QQ_MID_STR__";

    private C7076e(Context context) {
        this.f23531b = context.getApplicationContext();
        this.f23532c = PreferenceManager.getDefaultSharedPreferences(this.f23531b);
    }

    /* renamed from: a */
    public void mo34194a(String str) {
        if (str == null || !str.equals(mo34193a())) {
            this.f23532c.edit().putString(this.f23533d, str).commit();
        }
    }

    /* renamed from: a */
    public String mo34193a() {
        return this.f23532c.getString(this.f23533d, null);
    }

    /* renamed from: a */
    public static C7076e m30335a(Context context) {
        if (f23530a == null) {
            synchronized (C7076e.class) {
                if (f23530a == null) {
                    f23530a = new C7076e(context);
                }
            }
        }
        return f23530a;
    }
}
