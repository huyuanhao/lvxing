package com.bytedance.tea.crash.p218e;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.tea.crash.NpthBus;

/* renamed from: com.bytedance.tea.crash.e.j */
public final class SettingManager {
    /* renamed from: a */
    private SharedPreferences f9354a;

    public SettingManager(Context context) {
        this.f9354a = context.getSharedPreferences("npth", 0);
    }

    /* renamed from: a */
    public void mo17060a(String str) {
        this.f9354a.edit().putString("device_id", str).apply();
    }

    /* renamed from: a */
    public String mo17059a() {
        String e = NpthBus.m12591a().mo17023e();
        String str = "0";
        if (TextUtils.isEmpty(e) || str.equals(e)) {
            return this.f9354a.getString("device_id", str);
        }
        return e;
    }
}
