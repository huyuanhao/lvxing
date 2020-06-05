package com.kwad.sdk.core.request.model;

import com.kwad.sdk.core.response.p341a.C4321b;
import com.kwad.sdk.p306a.C3800e;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.request.model.g */
public class C4318g implements C4321b {
    /* renamed from: a */
    private C4316e f14208a;

    /* renamed from: a */
    public static C4318g m17623a() {
        C4318g gVar = new C4318g();
        gVar.f14208a = C4316e.m17621a();
        return gVar;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        C3800e.m15751a(jSONObject, "modeInfo", (C4321b) this.f14208a);
        return jSONObject;
    }
}
