package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: com.bytedance.sdk.openadsdk.utils.ad */
public class SPUtils {
    /* renamed from: a */
    private static Map<String, SPUtils> f9118a = new HashMap();
    /* renamed from: b */
    private SharedPreferences f9119b;

    /* renamed from: a */
    public static SPUtils m11969a(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            str = "tt_ad_sdk_sp";
        }
        SPUtils adVar = (SPUtils) f9118a.get(str);
        if (adVar != null) {
            return adVar;
        }
        SPUtils adVar2 = new SPUtils(str, context);
        f9118a.put(str, adVar2);
        return adVar2;
    }

    private SPUtils(String str, Context context) {
        if (context != null) {
            this.f9119b = context.getApplicationContext().getSharedPreferences(str, 0);
        }
    }

    /* renamed from: a */
    public void mo16911a(String str, String str2) {
        try {
            this.f9119b.edit().putString(str, str2).apply();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public String mo16908a(String str) {
        try {
            return mo16915b(str, "");
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: b */
    public String mo16915b(String str, String str2) {
        try {
            return this.f9119b.getString(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    /* renamed from: a */
    public void mo16909a(String str, int i) {
        try {
            this.f9119b.edit().putInt(str, i).apply();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b */
    public int mo16913b(String str, int i) {
        try {
            return this.f9119b.getInt(str, i);
        } catch (Throwable unused) {
            return i;
        }
    }

    /* renamed from: a */
    public void mo16910a(String str, long j) {
        try {
            this.f9119b.edit().putLong(str, j).apply();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b */
    public long mo16914b(String str, long j) {
        try {
            return this.f9119b.getLong(str, j);
        } catch (Throwable unused) {
            return j;
        }
    }

    /* renamed from: a */
    public void mo16912a(String str, Set<String> set) {
        try {
            this.f9119b.edit().putStringSet(str, set).apply();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b */
    public Set<String> mo16916b(String str, Set<String> set) {
        try {
            return this.f9119b.getStringSet(str, set);
        } catch (Throwable unused) {
            return set;
        }
    }

    /* renamed from: b */
    public void mo16917b(String str) {
        try {
            this.f9119b.edit().remove(str).apply();
        } catch (Throwable unused) {
        }
    }
}
