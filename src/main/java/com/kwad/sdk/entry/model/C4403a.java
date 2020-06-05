package com.kwad.sdk.entry.model;

import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.C4329d;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kwad.sdk.entry.model.a */
public class C4403a {
    /* renamed from: a */
    public final C4329d f14424a;
    /* renamed from: b */
    public int f14425b;

    public C4403a(C4329d dVar) {
        this.f14424a = dVar;
    }

    /* renamed from: a */
    public List<AdTemplate> mo24603a(long j) {
        List<AdTemplate> list = this.f14424a.f14229f;
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (AdTemplate cacheTemplate : list) {
            CacheTemplate cacheTemplate2 = new CacheTemplate(cacheTemplate);
            cacheTemplate2.mMirroPosId = j;
            arrayList.add(cacheTemplate2);
        }
        return arrayList;
    }

    /* renamed from: a */
    public void mo24604a(AdTemplate adTemplate) {
        if (!(adTemplate == null || this.f14424a.f14229f == null)) {
            for (int i = 0; i < this.f14424a.f14229f.size(); i++) {
                if (adTemplate.equals((AdTemplate) this.f14424a.f14229f.get(i))) {
                    this.f14425b = i;
                    return;
                }
            }
        }
    }
}
