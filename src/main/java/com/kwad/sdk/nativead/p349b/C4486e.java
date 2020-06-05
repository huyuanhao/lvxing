package com.kwad.sdk.nativead.p349b;

import com.kwad.sdk.contentalliance.detail.video.C3989e;
import com.kwad.sdk.contentalliance.detail.video.C3990f;
import com.kwad.sdk.export.p347i.KsNativeAd.VideoPlayListener;
import com.kwad.sdk.nativead.p348a.C4474a;

/* renamed from: com.kwad.sdk.nativead.b.e */
public class C4486e extends C4474a {
    /* access modifiers changed from: private */
    /* renamed from: b */
    public VideoPlayListener f14658b;
    /* renamed from: c */
    private C3989e f14659c = new C3990f() {
        /* renamed from: a */
        public void mo23377a(int i, int i2) {
            if (C4486e.this.f14658b != null) {
                C4486e.this.f14658b.onVideoPlayError(i, i2);
            }
        }

        /* renamed from: b */
        public void mo23346b() {
            if (C4486e.this.f14658b != null) {
                C4486e.this.f14658b.onVideoPlayComplete();
            }
        }

        /* renamed from: c */
        public void mo23347c() {
            if (C4486e.this.f14658b != null) {
                C4486e.this.f14658b.onVideoPlayStart();
            }
        }
    };

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23338a() {
        super.mo23338a();
        this.f14658b = this.f14621a.f14623b;
        this.f14621a.f14627f.mo24793a(this.f14659c);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo23340c() {
        super.mo23340c();
        this.f14621a.f14627f.mo24795b(this.f14659c);
    }
}
