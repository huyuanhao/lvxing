package com.kwad.sdk.core.p337i.p339b;

import com.kwad.sdk.core.p337i.p338a.C4201a;
import com.kwad.sdk.core.p337i.p338a.C4203c;
import com.kwad.sdk.core.response.p341a.C4321b;
import com.kwad.sdk.p306a.C3800e;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.i.b.i */
public class C4227i implements C4201a {
    /* renamed from: a */
    private C4203c f14024a;

    /* renamed from: com.kwad.sdk.core.i.b.i$a */
    public static final class C4228a implements C4321b {
        /* access modifiers changed from: private */
        /* renamed from: a */
        public String f14025a;

        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            C3800e.m15752a(jSONObject, "lifeStatus", this.f14025a);
            return jSONObject;
        }
    }

    /* renamed from: a */
    private void m17464a(String str) {
        if (this.f14024a != null) {
            C4228a aVar = new C4228a();
            aVar.f14025a = str;
            this.f14024a.mo23981a(aVar);
        }
    }

    /* renamed from: a */
    public String mo23976a() {
        return "registerLifecycleListener";
    }

    /* renamed from: a */
    public void mo23977a(String str, C4203c cVar) {
        this.f14024a = cVar;
    }

    /* renamed from: b */
    public void mo23978b() {
        this.f14024a = null;
    }

    /* renamed from: c */
    public void mo23987c() {
        m17464a("showStart");
    }

    /* renamed from: d */
    public void mo23988d() {
        m17464a("showEnd");
    }

    /* renamed from: e */
    public void mo23989e() {
        m17464a("hideStart");
    }

    /* renamed from: f */
    public void mo23990f() {
        m17464a("hideEnd");
    }
}
