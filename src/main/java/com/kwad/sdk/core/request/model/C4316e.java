package com.kwad.sdk.core.request.model;

import com.kwad.sdk.KsAdSDK;
import com.kwad.sdk.core.response.p341a.C4321b;
import com.kwad.sdk.p306a.C3800e;
import com.kwad.sdk.p306a.C3812o;
import com.kwad.sdk.p306a.C3822w;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.request.model.e */
public class C4316e implements C4321b {
    /* renamed from: a */
    private int f14194a;
    /* renamed from: b */
    private String f14195b;
    /* renamed from: c */
    private int f14196c;
    /* renamed from: d */
    private Long f14197d;
    /* renamed from: e */
    private Long f14198e;
    /* renamed from: f */
    private Long f14199f;
    /* renamed from: g */
    private Long f14200g;
    /* renamed from: h */
    private String f14201h;
    /* renamed from: i */
    private String f14202i;
    /* renamed from: j */
    private List<C4312a> f14203j = new ArrayList();

    /* renamed from: a */
    public static C4316e m17621a() {
        C4316e eVar = new C4316e();
        eVar.f14194a = C3812o.m15826c();
        eVar.f14195b = C3812o.m15829d();
        eVar.f14196c = C3812o.m15817a(KsAdSDK.getContext());
        eVar.f14197d = Long.valueOf(C3812o.m15823b(KsAdSDK.getContext()));
        eVar.f14198e = Long.valueOf(C3812o.m15827c(KsAdSDK.getContext()));
        eVar.f14199f = Long.valueOf(C3812o.m15818a());
        eVar.f14200g = Long.valueOf(C3812o.m15822b());
        eVar.f14201h = C3812o.m15832e(KsAdSDK.getContext());
        eVar.f14202i = C3812o.m15834f(KsAdSDK.getContext());
        eVar.f14203j = C3822w.m15878a(KsAdSDK.getContext(), 15);
        return eVar;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        C3800e.m15749a(jSONObject, "cpuCount", this.f14194a);
        C3800e.m15752a(jSONObject, "cpuAbi", this.f14195b);
        C3800e.m15749a(jSONObject, "batteryPercent", this.f14196c);
        C3800e.m15750a(jSONObject, "totalMemorySize", this.f14197d.longValue());
        C3800e.m15750a(jSONObject, "availableMemorySize", this.f14198e.longValue());
        C3800e.m15750a(jSONObject, "totalDiskSize", this.f14199f.longValue());
        C3800e.m15750a(jSONObject, "availableDiskSize", this.f14200g.longValue());
        C3800e.m15752a(jSONObject, "imsi", this.f14201h);
        C3800e.m15752a(jSONObject, "iccid", this.f14202i);
        C3800e.m15753a(jSONObject, "wifiList", this.f14203j);
        return jSONObject;
    }
}
