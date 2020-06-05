package com.kwad.sdk.nativead.p349b;

import android.view.View;
import com.kwad.sdk.contentalliance.detail.video.C3989e;
import com.kwad.sdk.contentalliance.detail.video.C3990f;
import com.kwad.sdk.nativead.p348a.C4474a;

/* renamed from: com.kwad.sdk.nativead.b.j */
public class C4500j extends C4474a {
    /* renamed from: b */
    private View f14689b;
    /* renamed from: c */
    private C3989e f14690c = new C3990f() {
        /* renamed from: a */
        public void mo23377a(int i, int i2) {
            C4500j.this.m18289g();
        }
    };

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m18289g() {
        if (this.f14689b.getVisibility() != 0) {
            this.f14689b.setVisibility(0);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23338a() {
        super.mo23338a();
        this.f14689b.setVisibility(8);
        this.f14621a.f14627f.mo24793a(this.f14690c);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo23339b() {
        super.mo23339b();
        this.f14689b = mo24760a("ksad_video_error_container");
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo23340c() {
        super.mo23340c();
        this.f14621a.f14627f.mo24795b(this.f14690c);
    }
}
