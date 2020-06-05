package com.kwad.sdk.contentalliance.detail.p310ad.p311a;

import com.kwad.sdk.contentalliance.detail.C3872b;
import com.kwad.sdk.contentalliance.detail.video.C3989e;
import com.kwad.sdk.contentalliance.detail.video.C3990f;
import com.kwad.sdk.contentalliance.p308a.C3828a;
import com.kwad.sdk.contentalliance.p308a.C3829b;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.draw.view.DrawVideoTailFrame;
import com.kwad.sdk.p307b.C3823a;

/* renamed from: com.kwad.sdk.contentalliance.detail.ad.a.c */
public class C3857c extends C3872b {
    /* renamed from: c */
    private AdBaseFrameLayout f13080c;
    /* renamed from: d */
    private DrawVideoTailFrame f13081d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public C3823a f13082e;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public boolean f13083f;
    /* renamed from: g */
    private C3828a f13084g = new C3829b() {
        /* renamed from: a */
        public void mo23230a() {
            super.mo23230a();
            C3857c.this.m16049g();
        }
    };
    /* renamed from: h */
    private C3989e f13085h = new C3990f() {
        /* renamed from: b */
        public void mo23346b() {
            boolean z;
            C3857c cVar;
            super.mo23346b();
            if (C3857c.this.f13082e == null || !C3857c.this.f13082e.mo23220b()) {
                C3857c.this.m16050h();
                cVar = C3857c.this;
                z = true;
            } else {
                cVar = C3857c.this;
                z = false;
            }
            cVar.f13083f = z;
        }
    };

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m16049g() {
        if (this.f13083f) {
            this.f13081d.setVisibility(8);
            this.f13081d.mo24574b();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m16050h() {
        this.f13081d.mo24572a();
        this.f13081d.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23338a() {
        super.mo23338a();
        this.f13082e = this.f13125b.f13137l;
        this.f13081d.mo24573a(this.f13125b.f13133g);
        this.f13081d.setAdBaseFrameLayout(this.f13080c);
        this.f13081d.setApkDownloadHelper(this.f13125b.f13136k);
        this.f13081d.setVisibility(8);
        this.f13125b.f13127a.add(this.f13084g);
        this.f13125b.f13135i.mo23557a(this.f13085h);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo23339b() {
        super.mo23339b();
        this.f13080c = (AdBaseFrameLayout) mo24760a("ksad_root_container");
        this.f13081d = (DrawVideoTailFrame) mo24760a("ksad_video_tail_frame");
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo23340c() {
        super.mo23340c();
        this.f13125b.f13127a.remove(this.f13084g);
        this.f13125b.f13135i.mo23560b(this.f13085h);
    }
}
