package com.kwad.sdk.nativead.p350c;

import android.content.Context;
import com.ksad.download.p297c.C3607b;
import com.kwad.sdk.contentalliance.detail.video.C3971a;
import com.kwad.sdk.contentalliance.detail.video.C3989e;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.core.p334h.p335a.C4174c;
import com.kwad.sdk.core.p334h.p335a.C4174c.C4179e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p342b.C4322a;
import com.kwad.sdk.core.response.p342b.C4324c;
import com.kwad.sdk.core.view.C4371b;
import com.kwad.sdk.core.view.C4371b.C4372a;
import com.kwad.sdk.export.config.KSAdVideoPlayConfig;

/* renamed from: com.kwad.sdk.nativead.c.a */
public class C4504a {
    /* renamed from: a */
    private String f14695a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public C4371b f14696b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public C3971a f14697c;
    /* renamed from: d */
    private boolean f14698d;
    /* renamed from: e */
    private boolean f14699e;
    /* renamed from: f */
    private Context f14700f;
    /* renamed from: g */
    private C4372a f14701g = new C4372a() {
        /* renamed from: a */
        public void mo24547a(boolean z) {
            if (z) {
                C4504a.this.mo24796c();
            } else {
                C4504a.this.mo24797d();
            }
        }
    };

    public C4504a(AdTemplate adTemplate, C4371b bVar, DetailVideoView detailVideoView, KSAdVideoPlayConfig kSAdVideoPlayConfig) {
        this.f14696b = bVar;
        boolean z = true;
        boolean z2 = kSAdVideoPlayConfig != null && kSAdVideoPlayConfig.videoSoundEnable;
        this.f14698d = z2;
        if (kSAdVideoPlayConfig == null || !kSAdVideoPlayConfig.dataFlowAutoStart) {
            z = false;
        }
        this.f14699e = z;
        this.f14700f = detailVideoView.getContext();
        this.f14695a = C4322a.m17632a(C4324c.m17668e(adTemplate));
        this.f14697c = new C3971a(detailVideoView);
        m18308g();
        this.f14697c.mo23526a((C4179e) new C4179e() {
            /* renamed from: a */
            public void mo23545a(C4174c cVar) {
                if (C4504a.this.m18309h() && C4504a.this.f14696b.mo24546d()) {
                    C4504a.this.f14697c.mo23535g();
                }
            }
        });
    }

    /* renamed from: a */
    private void m18304a(boolean z) {
        C3971a aVar;
        float f;
        if (z) {
            aVar = this.f14697c;
            f = 1.0f;
        } else {
            aVar = this.f14697c;
            f = 0.0f;
        }
        aVar.mo23521a(f, f);
    }

    /* renamed from: g */
    private void m18308g() {
        this.f14697c.mo23528b();
        this.f14697c.mo23527a(this.f14695a);
        m18304a(this.f14698d);
        this.f14697c.mo23534f();
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public boolean m18309h() {
        if (!this.f14699e) {
            this.f14699e = C3607b.m15046b(this.f14700f);
        }
        return this.f14699e;
    }

    /* renamed from: a */
    public void mo24792a() {
        if (this.f14697c.mo23520a() == null) {
            m18308g();
        }
        if (this.f14697c.mo23532d() && m18309h()) {
            this.f14697c.mo23535g();
        }
        this.f14696b.mo24542a(this.f14701g);
    }

    /* renamed from: a */
    public void mo24793a(C3989e eVar) {
        if (eVar != null) {
            this.f14697c.mo23525a(eVar);
        }
    }

    /* renamed from: b */
    public void mo24794b() {
        this.f14696b.mo24544b(this.f14701g);
        this.f14697c.mo23541m();
    }

    /* renamed from: b */
    public void mo24795b(C3989e eVar) {
        if (eVar != null) {
            this.f14697c.mo23529b(eVar);
        }
    }

    /* renamed from: c */
    public void mo24796c() {
        if (m18309h()) {
            this.f14697c.mo23537i();
        }
    }

    /* renamed from: d */
    public void mo24797d() {
        this.f14697c.mo23540l();
    }

    /* renamed from: e */
    public void mo24798e() {
        C3971a aVar = this.f14697c;
        if (aVar != null) {
            aVar.mo23544p();
        }
    }

    /* renamed from: f */
    public void mo24799f() {
        this.f14699e = true;
        if (this.f14697c.mo23532d() && this.f14696b.mo24546d()) {
            this.f14697c.mo23535g();
        }
    }
}
