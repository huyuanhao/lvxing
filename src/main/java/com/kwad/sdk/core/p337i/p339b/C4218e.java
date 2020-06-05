package com.kwad.sdk.core.p337i.p339b;

import com.kwad.sdk.core.p337i.C4200a;
import com.kwad.sdk.core.p337i.p338a.C4201a;
import com.kwad.sdk.core.p337i.p338a.C4203c;
import com.kwad.sdk.core.response.p341a.C4321b;
import com.kwad.sdk.p306a.C3800e;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.i.b.e */
public class C4218e implements C4201a {
    /* renamed from: a */
    private final C4200a f14016a;

    /* renamed from: com.kwad.sdk.core.i.b.e$a */
    public static final class C4219a implements C4321b {
        /* access modifiers changed from: private */
        /* renamed from: a */
        public int f14017a;

        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            C3800e.m15749a(jSONObject, "screenOrientation", this.f14017a);
            return jSONObject;
        }
    }

    public C4218e(C4200a aVar) {
        this.f14016a = aVar;
    }

    /* renamed from: a */
    public String mo23976a() {
        return "getScreenOrientation";
    }

    /* renamed from: a */
    public void mo23977a(String str, C4203c cVar) {
        if (this.f14016a.f13972b == null) {
            cVar.mo23980a(-1, "native adTemplate is null");
            return;
        }
        C4219a aVar = new C4219a();
        aVar.f14017a = this.f14016a.f13971a;
        cVar.mo23981a(aVar);
    }

    /* renamed from: b */
    public void mo23978b() {
    }
}
