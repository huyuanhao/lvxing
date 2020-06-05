package com.kwad.sdk.core.p337i.p339b;

import com.kwad.sdk.core.p337i.C4200a;
import com.kwad.sdk.core.p337i.p338a.C4201a;
import com.kwad.sdk.core.p337i.p338a.C4203c;
import com.kwad.sdk.core.response.p341a.C4321b;
import com.kwad.sdk.p306a.C3800e;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.i.b.b */
public class C4212b implements C4201a {
    /* renamed from: a */
    private final C4200a f13995a;

    /* renamed from: com.kwad.sdk.core.i.b.b$a */
    public static final class C4213a implements C4321b {
        /* renamed from: a */
        public int f13996a;
        /* renamed from: b */
        public int f13997b;

        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            C3800e.m15749a(jSONObject, "width", this.f13996a);
            C3800e.m15749a(jSONObject, "height", this.f13997b);
            return jSONObject;
        }
    }

    public C4212b(C4200a aVar) {
        this.f13995a = aVar;
    }

    /* renamed from: a */
    public String mo23976a() {
        return "getContainerLimit";
    }

    /* renamed from: a */
    public void mo23977a(String str, C4203c cVar) {
        C4213a aVar = new C4213a();
        aVar.f13996a = this.f13995a.f13975e.getWidth();
        aVar.f13996a = this.f13995a.f13975e.getHeight();
        cVar.mo23981a(aVar);
    }

    /* renamed from: b */
    public void mo23978b() {
    }
}
