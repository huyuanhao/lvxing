package com.kwad.sdk.nativead.p349b;

import android.widget.ProgressBar;
import com.kwad.sdk.contentalliance.detail.video.C3989e;
import com.kwad.sdk.contentalliance.detail.video.C3990f;
import com.kwad.sdk.nativead.p348a.C4474a;

/* renamed from: com.kwad.sdk.nativead.b.k */
public class C4502k extends C4474a {
    /* renamed from: b */
    private ProgressBar f14692b;
    /* renamed from: c */
    private C3989e f14693c = new C3990f() {
        /* renamed from: a */
        public void mo23377a(int i, int i2) {
            C4502k.this.m18297g();
        }

        /* renamed from: a */
        public void mo23345a(long j, long j2) {
            C4502k.this.m18294a(j != 0 ? (int) ((((float) j2) * 100.0f) / ((float) j)) : 0);
        }

        /* renamed from: b */
        public void mo23346b() {
            C4502k.this.m18297g();
        }
    };

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m18294a(int i) {
        this.f14692b.setProgress(i);
        if (this.f14692b.getVisibility() != 0) {
            this.f14692b.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m18297g() {
        if (this.f14692b.getVisibility() == 0) {
            this.f14692b.setVisibility(8);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23338a() {
        super.mo23338a();
        this.f14692b.setProgress(0);
        this.f14692b.setVisibility(8);
        this.f14621a.f14627f.mo24793a(this.f14693c);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo23339b() {
        super.mo23339b();
        this.f14692b = (ProgressBar) mo24760a("ksad_video_progress");
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo23340c() {
        super.mo23340c();
        this.f14621a.f14627f.mo24795b(this.f14693c);
    }
}
