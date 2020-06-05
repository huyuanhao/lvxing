package com.bytedance.embedapplog.p142b;

import android.content.SharedPreferences;
import org.json.JSONObject;

/* renamed from: com.bytedance.embedapplog.b.r */
class C1831r extends C1816c {
    /* renamed from: e */
    private final C1821h f5129e;

    C1831r(C1821h hVar) {
        super(true, false, false);
        this.f5129e = hVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo13364a(JSONObject jSONObject) {
        SharedPreferences d = this.f5129e.mo13399d();
        String str = "install_id";
        String string = d.getString(str, null);
        String str2 = "device_id";
        String string2 = d.getString(str2, null);
        String str3 = "ssid";
        String string3 = d.getString(str3, null);
        C1822i.m6381a(jSONObject, str, string);
        C1822i.m6381a(jSONObject, str2, string2);
        C1822i.m6381a(jSONObject, str3, string3);
        String str4 = "register_time";
        long j = 0;
        long j2 = d.getLong(str4, 0);
        if ((!C1822i.m6386e(string) || !C1822i.m6386e(string2)) && j2 != 0) {
            d.edit().putLong(str4, 0).apply();
        } else {
            j = j2;
        }
        jSONObject.put(str4, j);
        return true;
    }
}
