package com.bytedance.embedapplog.p142b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.UUID;
import org.json.JSONObject;

/* renamed from: com.bytedance.embedapplog.b.f */
class C1819f extends C1816c {
    /* renamed from: e */
    private final Context f5100e;

    C1819f(Context context) {
        super(false, false);
        this.f5100e = context;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo13364a(JSONObject jSONObject) {
        SharedPreferences sharedPreferences = this.f5100e.getSharedPreferences("snssdk_openudid", 0);
        String str = "clientudid";
        String string = sharedPreferences.getString(str, null);
        if (!C1822i.m6385d(string)) {
            try {
                string = mo13365a("clientudid.dat", UUID.randomUUID().toString());
            } catch (Exception unused) {
            }
            Editor edit = sharedPreferences.edit();
            edit.putString(str, string);
            edit.apply();
        }
        jSONObject.put(str, string);
        return true;
    }
}
