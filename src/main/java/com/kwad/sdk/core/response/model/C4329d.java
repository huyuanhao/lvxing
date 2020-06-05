package com.kwad.sdk.core.response.model;

import com.kwad.sdk.core.response.p341a.C4321b;
import com.kwad.sdk.p306a.C3800e;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.response.model.d */
public class C4329d implements C4321b {
    /* renamed from: a */
    public int f14224a;
    /* renamed from: b */
    public String f14225b;
    /* renamed from: c */
    public int f14226c;
    /* renamed from: d */
    public int f14227d;
    /* renamed from: e */
    public String f14228e;
    /* renamed from: f */
    public transient List<AdTemplate> f14229f;

    /* renamed from: a */
    public void mo24473a(JSONObject jSONObject) {
        this.f14224a = jSONObject.optInt("entryType");
        this.f14225b = jSONObject.optString("sourceDesc", "来自 快手推荐");
        this.f14226c = jSONObject.optInt("sourceDescPos");
        this.f14228e = jSONObject.optString("entryId");
        this.f14227d = jSONObject.optInt("likePos");
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        C3800e.m15749a(jSONObject, "entryType", this.f14224a);
        C3800e.m15752a(jSONObject, "sourceDesc", this.f14225b);
        C3800e.m15749a(jSONObject, "sourceDescPos", this.f14226c);
        C3800e.m15752a(jSONObject, "entryId", this.f14228e);
        C3800e.m15749a(jSONObject, "likePos", this.f14227d);
        return jSONObject;
    }
}
