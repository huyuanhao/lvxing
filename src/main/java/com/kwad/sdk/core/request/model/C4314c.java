package com.kwad.sdk.core.request.model;

import com.kwad.sdk.KsAdSDK;
import com.kwad.sdk.core.p330f.C4111a;
import com.kwad.sdk.core.response.p341a.C4321b;
import com.kwad.sdk.p306a.C3798d;
import com.kwad.sdk.p306a.C3800e;
import com.kwad.sdk.p306a.C3812o;
import com.tencent.android.tpush.common.Constants;
import com.tencent.bugly.beta.tinker.TinkerUtils;
import com.tencent.mid.api.MidEntity;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.request.model.c */
public class C4314c implements C4321b {
    /* renamed from: a */
    public String f14178a;
    /* renamed from: b */
    private String f14179b;
    /* renamed from: c */
    private String f14180c;
    /* renamed from: d */
    private int f14181d;
    /* renamed from: e */
    private String f14182e;
    /* renamed from: f */
    private int f14183f;
    /* renamed from: g */
    private int f14184g;
    /* renamed from: h */
    private String f14185h;
    /* renamed from: i */
    private String f14186i;
    /* renamed from: j */
    private String f14187j;
    /* renamed from: k */
    private int f14188k;
    /* renamed from: l */
    private String f14189l;
    /* renamed from: m */
    private String f14190m;
    /* renamed from: n */
    private JSONArray f14191n;

    /* renamed from: a */
    public static C4314c m17619a() {
        C4314c cVar = new C4314c();
        cVar.f14179b = C3812o.m15830d(KsAdSDK.getContext());
        cVar.f14180c = C4111a.m17072a();
        cVar.f14189l = C3812o.m15833f();
        cVar.f14190m = C3812o.m15836g();
        cVar.f14181d = 1;
        cVar.f14182e = C3812o.m15841j();
        cVar.f14178a = C3812o.m15843k();
        cVar.f14184g = C3812o.m15837h(KsAdSDK.getContext());
        cVar.f14183f = C3812o.m15835g(KsAdSDK.getContext());
        cVar.f14191n = C3798d.m15737a(KsAdSDK.getContext());
        cVar.f14185h = C3812o.m15840i(KsAdSDK.getContext());
        cVar.f14186i = C3812o.m15847m();
        cVar.f14187j = C3812o.m15838h();
        cVar.f14188k = C3812o.m15839i();
        return cVar;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        C3800e.m15752a(jSONObject, MidEntity.TAG_IMEI, this.f14179b);
        C3800e.m15752a(jSONObject, "oaid", this.f14180c);
        C3800e.m15752a(jSONObject, "deviceModel", this.f14189l);
        C3800e.m15752a(jSONObject, "deviceBrand", this.f14190m);
        C3800e.m15749a(jSONObject, "osType", this.f14181d);
        C3800e.m15752a(jSONObject, "osVersion", this.f14182e);
        C3800e.m15752a(jSONObject, "language", this.f14178a);
        C3800e.m15752a(jSONObject, "androidId", this.f14185h);
        C3800e.m15752a(jSONObject, Constants.FLAG_DEVICE_ID, this.f14186i);
        C3800e.m15752a(jSONObject, "deviceVendor", this.f14187j);
        C3800e.m15749a(jSONObject, TinkerUtils.PLATFORM, this.f14188k);
        C3800e.m15749a(jSONObject, "screenWidth", this.f14183f);
        C3800e.m15749a(jSONObject, "screenHeight", this.f14184g);
        C3800e.m15754a(jSONObject, "appPackageName", this.f14191n);
        return jSONObject;
    }
}
