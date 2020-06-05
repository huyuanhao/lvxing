package com.kwad.sdk.core.request.model;

import com.kwad.sdk.KsAdSDK;
import com.kwad.sdk.core.response.p341a.C4321b;
import com.kwad.sdk.p306a.C3800e;
import com.kwad.sdk.p306a.C3806i;
import com.kwad.sdk.p306a.C3812o;
import com.tencent.mid.api.MidEntity;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.request.model.f */
public class C4317f implements C4321b {
    /* renamed from: a */
    private String f14204a;
    /* renamed from: b */
    private String f14205b;
    /* renamed from: c */
    private int f14206c;
    /* renamed from: d */
    private int f14207d;

    /* renamed from: a */
    public static C4317f m17622a() {
        C4317f fVar = new C4317f();
        fVar.f14204a = C3812o.m15845l();
        fVar.f14205b = C3812o.m15842j(KsAdSDK.getContext());
        fVar.f14206c = C3806i.m15778c(KsAdSDK.getContext());
        fVar.f14207d = C3806i.m15779d(KsAdSDK.getContext());
        return fVar;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        C3800e.m15752a(jSONObject, "ip", this.f14204a);
        C3800e.m15752a(jSONObject, MidEntity.TAG_MAC, this.f14205b);
        C3800e.m15749a(jSONObject, "connectionType", this.f14206c);
        C3800e.m15749a(jSONObject, "operatorType", this.f14207d);
        return jSONObject;
    }
}
