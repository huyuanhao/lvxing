package com.kwad.sdk.core.response.model;

import android.text.TextUtils;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.response.p341a.C4321b;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.response.model.a */
public class C4326a implements C4321b {
    /* renamed from: a */
    public int f14212a;
    /* renamed from: b */
    public int f14213b;
    /* renamed from: c */
    public String f14214c;

    /* renamed from: a */
    public static C4326a m17691a(String str) {
        C4326a aVar = new C4326a();
        if (TextUtils.isEmpty(str)) {
            return aVar;
        }
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            C4065b.m16865a(e);
        }
        aVar.mo24464a(jSONObject);
        return aVar;
    }

    /* renamed from: a */
    public void mo24464a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f14212a = jSONObject.optInt("videoBlackAreaClick");
            this.f14213b = jSONObject.optInt("videoBlackAreaNewStyle");
            this.f14214c = jSONObject.optString("drawActionBarTimes");
        }
    }

    public JSONObject toJson() {
        return null;
    }
}
