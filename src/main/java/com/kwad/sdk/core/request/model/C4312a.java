package com.kwad.sdk.core.request.model;

import com.kwad.sdk.core.response.p341a.C4321b;
import com.kwad.sdk.p306a.C3800e;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.request.model.a */
public class C4312a implements C4321b {
    /* renamed from: a */
    public int f14171a;
    /* renamed from: b */
    public String f14172b;
    /* renamed from: c */
    public String f14173c;

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        C3800e.m15749a(jSONObject, "level", this.f14171a);
        C3800e.m15752a(jSONObject, "ssid", this.f14172b);
        C3800e.m15752a(jSONObject, "bssid", this.f14173c);
        return jSONObject;
    }
}
