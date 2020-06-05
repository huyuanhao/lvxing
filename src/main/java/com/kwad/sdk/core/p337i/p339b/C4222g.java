package com.kwad.sdk.core.p337i.p339b;

import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.p333g.C4143b;
import com.kwad.sdk.core.p337i.C4200a;
import com.kwad.sdk.core.p337i.p338a.C4201a;
import com.kwad.sdk.core.p337i.p338a.C4203c;
import com.kwad.sdk.core.response.p341a.C4321b;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.i.b.g */
public class C4222g implements C4201a {
    /* renamed from: a */
    private final C4200a f14019a;

    /* renamed from: com.kwad.sdk.core.i.b.g$a */
    public static final class C4223a implements C4321b {
        /* access modifiers changed from: private */
        /* renamed from: a */
        public int f14020a;
        /* access modifiers changed from: private */
        /* renamed from: b */
        public String f14021b;

        /* renamed from: a */
        public void mo23985a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.f14020a = jSONObject.optInt("actionType");
                this.f14021b = jSONObject.optString("payload");
            }
        }

        public JSONObject toJson() {
            return null;
        }
    }

    public C4222g(C4200a aVar) {
        this.f14019a = aVar;
    }

    /* renamed from: a */
    private void m17451a(C4223a aVar) {
        if (aVar.f14020a == 1) {
            C4065b.m16867b("WebCardLogHandler", "handleH5Log actionType is AD_ITEM_IMPRESSION");
        } else if (aVar.f14020a == 2) {
            AdBaseFrameLayout adBaseFrameLayout = this.f14019a.f13973c;
            if (adBaseFrameLayout != null) {
                C4143b.m17124a(this.f14019a.f13972b, this.f14019a.f13974d, adBaseFrameLayout.getTouchCoords(), aVar.f14021b);
            } else {
                C4143b.m17125a(this.f14019a.f13972b, this.f14019a.f13974d, aVar.f14021b);
            }
        } else {
            C4143b.m17121a(this.f14019a.f13972b, aVar.f14020a, this.f14019a.f13974d, aVar.f14021b);
        }
    }

    /* renamed from: a */
    public String mo23976a() {
        return "log";
    }

    /* renamed from: a */
    public void mo23977a(String str, C4203c cVar) {
        if (this.f14019a.f13972b == null) {
            cVar.mo23980a(-1, "native adTemplate is null");
        }
        try {
            C4223a aVar = new C4223a();
            aVar.mo23985a(new JSONObject(str));
            m17451a(aVar);
            cVar.mo23981a(null);
        } catch (JSONException e) {
            C4065b.m16865a(e);
            cVar.mo23980a(-1, e.getMessage());
        }
    }

    /* renamed from: b */
    public void mo23978b() {
    }
}
