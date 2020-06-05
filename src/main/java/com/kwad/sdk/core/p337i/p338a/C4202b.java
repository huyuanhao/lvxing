package com.kwad.sdk.core.p337i.p338a;

import com.kwad.sdk.core.response.p341a.C4321b;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.i.a.b */
public class C4202b implements C4321b {
    /* renamed from: a */
    public String f13977a;
    /* renamed from: b */
    public String f13978b;
    /* renamed from: c */
    public String f13979c;

    /* renamed from: a */
    public void mo23979a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f13977a = jSONObject.optString("action");
            this.f13978b = jSONObject.optString("data");
            this.f13979c = jSONObject.optString("callback");
        }
    }

    public JSONObject toJson() {
        return null;
    }
}
