package com.kwad.sdk.nativead.p349b;

import android.view.View;
import com.ksad.download.p297c.C3607b;
import com.kwad.sdk.contentalliance.detail.video.C3989e;
import com.kwad.sdk.contentalliance.detail.video.C3990f;
import com.kwad.sdk.nativead.p348a.C4474a;

/* renamed from: com.kwad.sdk.nativead.b.d */
public class C4484d extends C4474a {
    /* renamed from: b */
    private View f14655b;
    /* renamed from: c */
    private C3989e f14656c = new C3990f() {
        /* renamed from: a */
        public void mo23373a() {
            super.mo23373a();
            C4484d.this.m18236g();
        }

        /* renamed from: c */
        public void mo23347c() {
            super.mo23347c();
            C4484d.this.m18236g();
        }
    };

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m18236g() {
        if (this.f14655b.getVisibility() == 0) {
            this.f14655b.setVisibility(8);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23338a() {
        super.mo23338a();
        if (C3607b.m15045a(this.f14655b.getContext())) {
            this.f14655b.setVisibility(8);
            return;
        }
        this.f14655b.setVisibility(0);
        this.f14621a.f14627f.mo24793a(this.f14656c);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo23339b() {
        super.mo23339b();
        this.f14655b = mo24760a("ksad_video_network_unavailable");
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo23340c() {
        super.mo23340c();
        this.f14621a.f14627f.mo24795b(this.f14656c);
    }
}
