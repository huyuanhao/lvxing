package com.kwad.sdk.core.request;

import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.protocol.model.AdScene;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.request.h */
public class C4295h extends C4280c {
    C4295h(AdScene adScene, int i) {
        super(adScene);
        if (i != 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("contentType", i);
            } catch (JSONException e) {
                C4065b.m16865a(e);
            }
            mo24381a("contentInfo", jSONObject);
        }
    }

    /* renamed from: a */
    public String mo23849a() {
        return "https://open.e.kuaishou.com/rest/e/v3/open/feed";
    }
}
