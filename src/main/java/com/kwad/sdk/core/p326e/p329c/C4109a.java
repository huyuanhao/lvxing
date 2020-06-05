package com.kwad.sdk.core.p326e.p329c;

import com.kwad.sdk.core.p326e.p328b.C4107a;
import com.kwad.sdk.core.response.p341a.C4320a;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.e.c.a */
public class C4109a implements AdHttpProxy<C4320a> {
    /* renamed from: a */
    public C4320a parseResponse(C4320a aVar) {
        return aVar;
    }

    public C4320a doGet(String str, Map<String, String> map) {
        return C4107a.m17055a(str, map);
    }

    public C4320a doPost(String str, Map<String, String> map, Map<String, String> map2) {
        return C4107a.m17057a(str, map, map2);
    }

    public C4320a doPost(String str, Map<String, String> map, JSONObject jSONObject) {
        return C4107a.m17056a(str, map, jSONObject != null ? jSONObject.toString() : null, true);
    }
}
