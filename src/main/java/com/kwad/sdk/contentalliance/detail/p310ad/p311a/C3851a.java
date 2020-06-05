package com.kwad.sdk.contentalliance.detail.p310ad.p311a;

import com.kwad.sdk.contentalliance.detail.C3872b;
import com.kwad.sdk.contentalliance.detail.p310ad.view.AdBottomView;
import com.kwad.sdk.contentalliance.detail.video.C3982b;
import com.kwad.sdk.contentalliance.detail.video.C3989e;
import com.kwad.sdk.contentalliance.p308a.C3828a;
import com.kwad.sdk.contentalliance.p308a.C3829b;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p342b.C4324c;
import com.kwad.sdk.core.view.AdBaseFrameLayout;

/* renamed from: com.kwad.sdk.contentalliance.detail.ad.a.a */
public class C3851a extends C3872b {
    /* renamed from: c */
    private AdBaseFrameLayout f13054c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public AdBottomView f13055d;
    /* renamed from: e */
    private AdTemplate f13056e;
    /* renamed from: f */
    private C3982b f13057f;
    /* renamed from: g */
    private C3989e f13058g;
    /* renamed from: h */
    private C3828a f13059h = new C3829b() {
        /* renamed from: a */
        public void mo23230a() {
            super.mo23230a();
            C3851a.this.f13055d.mo23352b();
        }

        /* renamed from: b */
        public void mo23231b() {
            super.mo23231b();
        }
    };

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23338a() {
        super.mo23338a();
        this.f13056e = this.f13125b.f13133g;
        if (C4324c.m17664a(this.f13056e)) {
            this.f13055d.mo23351a(this.f13056e, C4324c.m17668e(this.f13056e));
            this.f13055d.setAdBaseFrameLayout(this.f13054c);
            this.f13055d.setVisibility(0);
            this.f13058g = this.f13055d.getVideoPlayStateListener();
            this.f13057f = this.f13125b.f13135i;
            this.f13057f.mo23557a(this.f13058g);
            this.f13125b.f13127a.add(this.f13059h);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo23339b() {
        super.mo23339b();
        this.f13054c = (AdBaseFrameLayout) mo24760a("ksad_root_container");
        this.f13055d = (AdBottomView) mo24760a("ksad_bottom_view");
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo23340c() {
        super.mo23340c();
        if (C4324c.m17664a(this.f13056e)) {
            this.f13055d.mo23350a();
            this.f13057f.mo23560b(this.f13058g);
            this.f13125b.f13127a.remove(this.f13059h);
        }
    }
}
