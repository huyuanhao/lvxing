package com.kwad.sdk.core.request;

import com.kwad.sdk.protocol.model.AdScene;

/* renamed from: com.kwad.sdk.core.request.j */
public class C4303j extends C4280c {
    public C4303j(AdScene adScene, long j) {
        super(adScene);
        mo24376a("photoId", j);
    }

    /* renamed from: a */
    public String mo23849a() {
        return "https://open.e.kuaishou.com/rest/e/v3/open/share";
    }
}
