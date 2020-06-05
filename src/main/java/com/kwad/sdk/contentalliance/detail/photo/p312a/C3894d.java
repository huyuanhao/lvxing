package com.kwad.sdk.contentalliance.detail.photo.p312a;

import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.core.response.p342b.C4324c;
import com.kwad.sdk.core.response.p342b.C4325d;

/* renamed from: com.kwad.sdk.contentalliance.detail.photo.a.d */
public class C3894d {
    /* renamed from: a */
    private long f13181a;
    /* renamed from: b */
    private PhotoInfo f13182b;
    /* renamed from: c */
    private AdTemplate f13183c;
    /* renamed from: d */
    private long f13184d;

    public C3894d(AdTemplate adTemplate, long j) {
        this.f13183c = adTemplate;
        this.f13181a = C4324c.m17665b(adTemplate);
        this.f13182b = C4324c.m17669f(adTemplate);
        this.f13184d = j;
    }

    /* renamed from: a */
    public AdTemplate mo23397a() {
        return this.f13183c;
    }

    /* renamed from: b */
    public long mo23398b() {
        return C4325d.m17680i(this.f13182b);
    }

    /* renamed from: c */
    public long mo23399c() {
        return this.f13181a;
    }

    /* renamed from: d */
    public long mo23400d() {
        return this.f13184d;
    }
}
