package com.kwad.sdk.core.request.model;

import com.kwad.sdk.KsAdSDK;
import com.kwad.sdk.core.response.p341a.C4321b;
import com.kwad.sdk.export.proxy.AdRequestExtentParamsProxy;
import com.kwad.sdk.p306a.C3800e;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.request.model.h */
public class C4319h implements C4321b {
    /* renamed from: a */
    private String f14209a;

    /* renamed from: a */
    public static C4319h m17624a() {
        C4319h hVar = new C4319h();
        AdRequestExtentParamsProxy requestExtentParamsProxy = KsAdSDK.getRequestExtentParamsProxy();
        if (requestExtentParamsProxy != null) {
            Map extentParams = requestExtentParamsProxy.getExtentParams();
            if (extentParams != null) {
                hVar.f14209a = (String) extentParams.get("user_id");
            }
        }
        return hVar;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        C3800e.m15752a(jSONObject, "user_id", this.f14209a);
        return jSONObject;
    }
}
