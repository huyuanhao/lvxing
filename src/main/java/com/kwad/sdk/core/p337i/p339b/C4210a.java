package com.kwad.sdk.core.p337i.p339b;

import com.kwad.sdk.core.download.p323a.C4087a;
import com.kwad.sdk.core.download.p323a.C4087a.C4088a;
import com.kwad.sdk.core.download.p323a.C4089b;
import com.kwad.sdk.core.p337i.C4200a;
import com.kwad.sdk.core.p337i.p338a.C4201a;
import com.kwad.sdk.core.p337i.p338a.C4203c;
import com.kwad.sdk.p307b.C3823a.C3826a;

/* renamed from: com.kwad.sdk.core.i.b.a */
public class C4210a implements C4201a {
    /* renamed from: a */
    private final C4200a f13991a;
    /* renamed from: b */
    private final C4089b f13992b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public C3826a f13993c;

    public C4210a(C4200a aVar, C4089b bVar, C3826a aVar2) {
        this.f13991a = aVar;
        this.f13992b = bVar;
        this.f13993c = aVar2;
    }

    /* renamed from: a */
    public String mo23976a() {
        return "convert";
    }

    /* renamed from: a */
    public void mo23977a(String str, C4203c cVar) {
        if (this.f13991a.f13972b == null) {
            cVar.mo23980a(-1, "native adTemplate is null");
            return;
        }
        C4087a.m16967a(this.f13991a.f13975e.getContext(), this.f13991a.f13972b, new C4088a() {
            /* renamed from: a */
            public void mo23360a() {
                if (C4210a.this.f13993c != null) {
                    C4210a.this.f13993c.mo23225a();
                }
            }
        }, this.f13992b);
        cVar.mo23981a(null);
    }

    /* renamed from: b */
    public void mo23978b() {
        this.f13993c = null;
    }
}
