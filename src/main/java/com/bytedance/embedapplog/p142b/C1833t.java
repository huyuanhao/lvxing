package com.bytedance.embedapplog.p142b;

import android.content.Context;
import android.telephony.TelephonyManager;
import org.json.JSONObject;

/* renamed from: com.bytedance.embedapplog.b.t */
class C1833t extends C1816c {
    /* renamed from: e */
    private final Context f5131e;

    C1833t(Context context) {
        super(true, false);
        this.f5131e = context;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo13364a(JSONObject jSONObject) {
        C1822i.m6381a(jSONObject, "sim_region", ((TelephonyManager) this.f5131e.getSystemService("phone")).getSimCountryIso());
        return true;
    }
}
