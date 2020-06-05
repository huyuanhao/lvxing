package com.kwad.sdk.core.p326e.p329c;

import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.p326e.p328b.C4108b;
import com.kwad.sdk.core.response.p341a.C4320a;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import java.util.Map;
import okhttp3.C8362ab;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.e.c.b */
public class C4110b implements AdHttpProxy<C8362ab> {
    /* renamed from: a */
    public C4320a parseResponse(C8362ab abVar) {
        C4320a aVar = new C4320a();
        if (abVar != null) {
            try {
                aVar.f14210a = abVar.mo40091c();
                aVar.f14211b = C4108b.m17062a(abVar);
            } catch (Exception e) {
                C4065b.m16865a(e);
            }
        }
        return aVar;
    }

    public C4320a doGet(String str, Map<String, String> map) {
        return parseResponse(C4108b.m17063a(str, map));
    }

    public C4320a doPost(String str, Map<String, String> map, Map<String, String> map2) {
        return parseResponse(C4108b.m17064a(str, map, map2));
    }

    public C4320a doPost(String str, Map<String, String> map, JSONObject jSONObject) {
        return parseResponse(C4108b.m17065a(str, map, jSONObject));
    }
}
