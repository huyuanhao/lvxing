package com.kwad.sdk.core.response.model;

import com.kwad.sdk.core.response.p341a.C4321b;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.response.model.c */
public class C4328c implements C4321b {
    /* renamed from: a */
    private long f14221a;
    /* renamed from: b */
    private String f14222b;
    /* renamed from: c */
    private long f14223c;

    /* renamed from: a */
    public long mo24468a() {
        return this.f14221a;
    }

    /* renamed from: a */
    public void mo24469a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f14221a = jSONObject.optLong(ArgKey.KEY_RESULT);
            this.f14222b = jSONObject.optString("errorMsg");
            this.f14223c = jSONObject.optLong("interval");
        }
    }

    /* renamed from: b */
    public String mo24470b() {
        return this.f14222b;
    }

    /* renamed from: c */
    public long mo24471c() {
        return this.f14223c;
    }

    /* renamed from: d */
    public boolean mo24472d() {
        return this.f14221a == 1;
    }

    public JSONObject toJson() {
        return null;
    }
}
