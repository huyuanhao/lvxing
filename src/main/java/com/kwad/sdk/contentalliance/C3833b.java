package com.kwad.sdk.contentalliance;

import androidx.fragment.app.Fragment;
import com.kwad.sdk.contentalliance.home.C4014f;
import com.kwad.sdk.export.p347i.KsContentAllianceAd;
import com.kwad.sdk.protocol.model.AdScene;

/* renamed from: com.kwad.sdk.contentalliance.b */
public class C3833b implements KsContentAllianceAd {
    /* renamed from: a */
    private AdScene f12962a;

    public C3833b(AdScene adScene) {
        this.f12962a = adScene;
    }

    public Fragment getFragment() {
        return C4014f.m16629a(this.f12962a);
    }
}
