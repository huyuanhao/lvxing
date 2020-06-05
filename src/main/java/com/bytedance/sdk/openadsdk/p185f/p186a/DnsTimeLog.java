package com.bytedance.sdk.openadsdk.p185f.p186a;

import android.text.TextUtils;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.openadsdk.f.a.a */
public class DnsTimeLog extends LogStatsBase<DnsTimeLog> {
    /* renamed from: a */
    private JSONObject f8641a = new JSONObject();

    /* renamed from: a */
    public DnsTimeLog mo16586a(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            try {
                this.f8641a.put(str, obj);
            } catch (Throwable unused) {
            }
        }
        return this;
    }

    /* renamed from: a */
    public JSONObject mo16587a() {
        JSONObject jSONObject;
        String str = "event_extra";
        JSONObject a = super.mo16587a();
        try {
            String optString = a.optString(str, null);
            if (TextUtils.isEmpty(optString)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(optString);
            }
            jSONObject.put("dns_info", this.f8641a);
            a.put(str, jSONObject.toString());
        } catch (Exception unused) {
        }
        return a;
    }
}
