package com.kwad.sdk.core.p337i.p339b;

import com.kwad.sdk.KsAdSDK;
import com.kwad.sdk.core.p330f.C4111a;
import com.kwad.sdk.core.p337i.p338a.C4201a;
import com.kwad.sdk.core.p337i.p338a.C4203c;
import com.kwad.sdk.core.response.p341a.C4321b;
import com.kwad.sdk.p306a.C3800e;
import com.kwad.sdk.p306a.C3806i;
import com.kwad.sdk.p306a.C3812o;
import com.kwad.sdk.p306a.C3817t;
import com.tencent.mid.api.MidEntity;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.i.b.c */
public class C4214c implements C4201a {

    /* renamed from: com.kwad.sdk.core.i.b.c$a */
    public static final class C4215a implements C4321b {
        /* renamed from: a */
        private String f13998a;
        /* renamed from: b */
        private String f13999b;
        /* renamed from: c */
        private String f14000c;
        /* renamed from: d */
        private String f14001d;
        /* renamed from: e */
        private String f14002e;
        /* renamed from: f */
        private String f14003f;
        /* renamed from: g */
        private String f14004g;
        /* renamed from: h */
        private String f14005h;
        /* renamed from: i */
        private int f14006i;
        /* renamed from: j */
        private int f14007j;
        /* renamed from: k */
        private String f14008k;
        /* renamed from: l */
        private String f14009l;
        /* renamed from: m */
        private String f14010m;
        /* renamed from: n */
        private String f14011n;
        /* renamed from: o */
        private int f14012o;
        /* renamed from: p */
        private int f14013p;

        /* renamed from: a */
        public static C4215a m17437a() {
            C4215a aVar = new C4215a();
            aVar.f13998a = C3812o.m15844k(KsAdSDK.getContext());
            aVar.f13999b = "";
            aVar.f14000c = String.valueOf(C3806i.m15778c(KsAdSDK.getContext()));
            aVar.f14001d = C3812o.m15838h();
            aVar.f14002e = C3812o.m15833f();
            aVar.f14003f = C3812o.m15841j();
            aVar.f14004g = C3812o.m15831e();
            aVar.f14005h = C3812o.m15847m();
            aVar.f14006i = C3817t.m15872c(KsAdSDK.getContext());
            aVar.f14007j = C3817t.m15870b(KsAdSDK.getContext());
            aVar.f14008k = C3812o.m15830d(KsAdSDK.getContext());
            aVar.f14009l = C4111a.m17072a();
            aVar.f14010m = C3812o.m15840i(KsAdSDK.getContext());
            aVar.f14011n = C3812o.m15842j(KsAdSDK.getContext());
            aVar.f14012o = C3817t.m15861a(KsAdSDK.getContext());
            aVar.f14013p = C3817t.m15862a(KsAdSDK.getContext(), 50.0f);
            return aVar;
        }

        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            C3800e.m15752a(jSONObject, "appVersion", this.f13998a);
            C3800e.m15752a(jSONObject, "globalId", this.f13999b);
            C3800e.m15752a(jSONObject, "networkType", this.f14000c);
            C3800e.m15752a(jSONObject, "manufacturer", this.f14001d);
            C3800e.m15752a(jSONObject, "model", this.f14002e);
            C3800e.m15752a(jSONObject, "systemVersion", this.f14003f);
            C3800e.m15752a(jSONObject, "locale", this.f14004g);
            C3800e.m15752a(jSONObject, "uuid", this.f14005h);
            C3800e.m15749a(jSONObject, "screenWidth", this.f14006i);
            C3800e.m15749a(jSONObject, "screenHeight", this.f14007j);
            C3800e.m15752a(jSONObject, MidEntity.TAG_IMEI, this.f14008k);
            C3800e.m15752a(jSONObject, "oaid", this.f14009l);
            C3800e.m15752a(jSONObject, "androidId", this.f14010m);
            C3800e.m15752a(jSONObject, MidEntity.TAG_MAC, this.f14011n);
            C3800e.m15749a(jSONObject, "statusBarHeight", this.f14012o);
            C3800e.m15749a(jSONObject, "titleBarHeight", this.f14013p);
            return jSONObject;
        }
    }

    /* renamed from: a */
    public String mo23976a() {
        return "getDeviceInfo";
    }

    /* renamed from: a */
    public void mo23977a(String str, C4203c cVar) {
        cVar.mo23981a(C4215a.m17437a());
    }

    /* renamed from: b */
    public void mo23978b() {
    }
}
