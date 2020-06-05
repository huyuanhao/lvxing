package com.kwad.sdk.core.p337i.p339b;

import com.kwad.sdk.core.p337i.p338a.C4201a;
import com.kwad.sdk.core.p337i.p338a.C4203c;

/* renamed from: com.kwad.sdk.core.i.b.f */
public class C4220f implements C4201a {
    /* renamed from: a */
    private C4221a f14018a;

    /* renamed from: com.kwad.sdk.core.i.b.f$a */
    public interface C4221a {
        /* renamed from: a */
        void mo23223a();
    }

    public C4220f(C4221a aVar) {
        this.f14018a = aVar;
    }

    /* renamed from: c */
    private void m17446c() {
        C4221a aVar = this.f14018a;
        if (aVar != null) {
            aVar.mo23223a();
        }
    }

    /* renamed from: a */
    public String mo23976a() {
        return "hide";
    }

    /* renamed from: a */
    public void mo23977a(String str, C4203c cVar) {
        m17446c();
        cVar.mo23981a(null);
    }

    /* renamed from: b */
    public void mo23978b() {
        this.f14018a = null;
    }
}
