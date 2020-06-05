package com.kwad.sdk.contentalliance.detail.p310ad.p311a;

import android.widget.FrameLayout;
import com.kwad.sdk.contentalliance.detail.C3872b;
import com.kwad.sdk.contentalliance.p308a.C3828a;
import com.kwad.sdk.contentalliance.p308a.C3829b;
import com.kwad.sdk.core.response.p342b.C4323b;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.p307b.C3823a;

/* renamed from: com.kwad.sdk.contentalliance.detail.ad.a.d */
public class C3860d extends C3872b {
    /* access modifiers changed from: private */
    /* renamed from: c */
    public AdBaseFrameLayout f13088c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public FrameLayout f13089d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public C3823a f13090e;
    /* renamed from: f */
    private C3828a f13091f = new C3829b() {
        /* renamed from: a */
        public void mo23230a() {
            super.mo23230a();
            if (C3860d.this.f13090e != null) {
                C3860d.this.f13090e.mo23222d();
            }
        }

        /* renamed from: b */
        public void mo23231b() {
            super.mo23231b();
            if (C3860d.this.f13090e != null) {
                C3860d.this.f13090e.mo23217a(C3860d.this.f13089d, C3860d.this.f13088c, C3860d.this.f13125b.f13133g, C3860d.this.f13125b.f13136k);
                C3860d.this.f13090e.mo23216a();
            }
        }
    };

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23338a() {
        super.mo23338a();
        if (C4323b.m17662d(this.f13125b.f13133g)) {
            this.f13090e = this.f13125b.f13137l;
            this.f13125b.f13127a.add(this.f13091f);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo23339b() {
        super.mo23339b();
        this.f13088c = (AdBaseFrameLayout) mo24760a("ksad_root_container");
        this.f13089d = (FrameLayout) mo24760a("ksad_play_end_web_card_container");
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo23340c() {
        super.mo23340c();
        C3823a aVar = this.f13090e;
        if (aVar != null) {
            aVar.mo23222d();
        }
        this.f13125b.f13127a.remove(this.f13091f);
    }
}
