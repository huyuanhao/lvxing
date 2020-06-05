package com.kwad.sdk.core.p337i.p339b;

import com.kwad.sdk.core.p337i.C4200a;
import com.kwad.sdk.core.p337i.p338a.C4201a;
import com.kwad.sdk.core.p337i.p338a.C4203c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p341a.C4321b;
import com.kwad.sdk.p306a.C3800e;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.i.b.d */
public class C4216d implements C4201a {
    /* renamed from: a */
    private final C4200a f14014a;

    /* renamed from: com.kwad.sdk.core.i.b.d$a */
    public static final class C4217a implements C4321b {
        /* access modifiers changed from: private */
        /* renamed from: a */
        public List<AdTemplate> f14015a;

        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            C3800e.m15753a(jSONObject, "impAdInfo", this.f14015a);
            return jSONObject;
        }
    }

    public C4216d(C4200a aVar) {
        this.f14014a = aVar;
    }

    /* renamed from: a */
    public String mo23976a() {
        return "getKsAdData";
    }

    /* renamed from: a */
    public void mo23977a(String str, C4203c cVar) {
        if (this.f14014a.f13972b == null) {
            cVar.mo23980a(-1, "native adTemplate is null");
            return;
        }
        C4217a aVar = new C4217a();
        aVar.f14015a = Collections.singletonList(this.f14014a.f13972b);
        cVar.mo23981a(aVar);
    }

    /* renamed from: b */
    public void mo23978b() {
    }
}
