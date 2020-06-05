package com.kwad.sdk.core.request;

import com.kwad.sdk.core.request.model.C4313b;
import com.kwad.sdk.core.request.model.C4314c;
import com.kwad.sdk.core.request.model.C4315d;
import com.kwad.sdk.core.request.model.C4317f;
import com.kwad.sdk.core.request.model.C4318g;
import com.kwad.sdk.core.request.model.C4319h;
import com.kwad.sdk.core.request.p340a.C4257a;
import com.kwad.sdk.core.response.p341a.C4321b;
import com.kwad.sdk.p306a.C3800e;
import com.kwad.sdk.protocol.model.AdScene;
import org.json.JSONArray;

/* renamed from: com.kwad.sdk.core.request.c */
public abstract class C4280c extends C4257a {
    /* renamed from: a */
    private AdScene f14126a;

    public C4280c() {
    }

    public C4280c(AdScene adScene) {
        this.f14126a = adScene;
        JSONArray jSONArray = new JSONArray();
        C3800e.m15746a(jSONArray, adScene.toJson());
        mo24380a("impInfo", jSONArray);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo23861b() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo23862c() {
        mo24378a("SDKVersion", "2.6.5.2");
        mo24378a("protocolVersion", "2.0");
        mo24377a("appInfo", (C4321b) C4313b.m17618a());
        mo24377a("deviceInfo", (C4321b) C4314c.m17619a());
        mo24377a("networkInfo", (C4321b) C4317f.m17622a());
        mo24377a("geoInfo", (C4321b) C4315d.m17620a());
        mo24377a("ext", (C4321b) C4318g.m17623a());
        mo24377a("userInfo", (C4321b) C4319h.m17624a());
    }

    /* renamed from: d */
    public AdScene mo24409d() {
        return this.f14126a;
    }
}
