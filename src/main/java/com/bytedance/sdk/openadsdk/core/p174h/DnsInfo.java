package com.bytedance.sdk.openadsdk.core.p174h;

import java.util.HashMap;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.openadsdk.core.h.c */
public class DnsInfo {
    /* renamed from: a */
    String f7622a;
    /* renamed from: b */
    HashMap<String, DnsItem> f7623b = new HashMap<>();

    private DnsInfo() {
    }

    /* renamed from: a */
    public static DnsInfo m9704a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            DnsInfo cVar = new DnsInfo();
            cVar.mo15725a(jSONObject.optString("cip"));
            JSONArray optJSONArray = jSONObject.optJSONArray("dns");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    DnsItem a = DnsItem.m9709a(optJSONArray.getJSONObject(i));
                    cVar.mo15726b().put(a.mo15728a(), a);
                }
            } else {
                DnsItem a2 = DnsItem.m9709a(jSONObject);
                cVar.mo15726b().put(a2.mo15728a(), a2);
            }
            return cVar;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    public String mo15724a() {
        return this.f7622a;
    }

    /* renamed from: a */
    public void mo15725a(String str) {
        this.f7622a = str;
    }

    /* renamed from: b */
    public HashMap<String, DnsItem> mo15726b() {
        return this.f7623b;
    }

    /* renamed from: c */
    public JSONObject mo15727c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cip", mo15724a());
            JSONArray jSONArray = new JSONArray();
            if (mo15726b() != null) {
                for (Entry value : mo15726b().entrySet()) {
                    jSONArray.put(((DnsItem) value.getValue()).mo15740h());
                }
            }
            jSONObject.put("dns", jSONArray);
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}
