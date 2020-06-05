package com.kwad.sdk.contentalliance.home.p315a;

import com.kwad.sdk.contentalliance.home.C4011c;
import com.kwad.sdk.contentalliance.home.C4012d;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayViewPager;
import com.kwad.sdk.entry.C4402a;
import com.kwad.sdk.entry.model.C4403a;
import com.kwad.sdk.protocol.model.AdScene;

/* renamed from: com.kwad.sdk.contentalliance.home.a.a */
public class C3995a extends C4012d {
    /* renamed from: b */
    private SlidePlayViewPager f13425b;
    /* renamed from: c */
    private C4403a f13426c;
    /* renamed from: d */
    private AdScene f13427d;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23338a() {
        super.mo23338a();
        if (this.f13426c != null) {
            this.f13427d = this.f13465a.f13469d;
            C4403a aVar = this.f13426c;
            if (aVar != null) {
                C4011c.m16624a(aVar.mo24603a(this.f13427d.posId));
                C4402a.m17971b();
            }
            this.f13425b = this.f13465a.f13468c;
            this.f13425b.setInitStartPosition(this.f13426c.f14425b);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo23339b() {
        super.mo23339b();
        this.f13426c = C4402a.m17968a();
    }
}
