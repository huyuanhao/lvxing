package com.bytedance.sdk.openadsdk.core.p170d;

import android.text.TextUtils;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.openadsdk.core.d.c */
public class BackHtmlModel {
    /* renamed from: a */
    private String f7328a;
    /* renamed from: b */
    private String f7329b;
    /* renamed from: c */
    private Map<String, String> f7330c;

    /* renamed from: a */
    public void mo15355a(String str) {
        this.f7328a = str;
    }

    /* renamed from: b */
    public void mo15357b(String str) {
        this.f7329b = str;
    }

    /* renamed from: a */
    public void mo15356a(Map<String, String> map) {
        this.f7330c = map;
    }

    /* renamed from: a */
    public JSONObject mo15354a() {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.f7328a) && !TextUtils.isEmpty(this.f7329b)) {
            try {
                jSONObject.put("url", this.f7328a);
                jSONObject.put("html", this.f7329b);
                JSONObject jSONObject2 = new JSONObject();
                if (this.f7330c != null && this.f7330c.size() > 0) {
                    for (Entry entry : this.f7330c.entrySet()) {
                        jSONObject2.put((String) entry.getKey(), entry.getValue());
                    }
                }
                jSONObject.put("headers", jSONObject2);
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }
}
