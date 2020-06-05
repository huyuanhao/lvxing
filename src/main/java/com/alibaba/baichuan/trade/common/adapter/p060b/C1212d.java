package com.alibaba.baichuan.trade.common.adapter.p060b;

import org.json.JSONObject;

/* renamed from: com.alibaba.baichuan.trade.common.adapter.b.d */
public class C1212d {
    /* renamed from: a */
    public String f2500a;
    /* renamed from: b */
    public String f2501b;

    public C1212d() {
        String str = "";
        this.f2500a = str;
        this.f2501b = str;
    }

    /* renamed from: a */
    public String mo10871a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appKey", this.f2500a);
            jSONObject.put("sdkVersion", this.f2501b);
            return jSONObject.toString();
        } catch (Exception unused) {
            return "";
        }
    }
}
