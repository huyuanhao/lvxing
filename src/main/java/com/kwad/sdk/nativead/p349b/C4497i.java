package com.kwad.sdk.nativead.p349b;

import android.view.View;
import android.view.View.OnClickListener;
import com.kwad.sdk.contentalliance.detail.video.C3989e;
import com.kwad.sdk.contentalliance.detail.video.C3990f;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.core.download.p323a.C4087a;
import com.kwad.sdk.core.download.p323a.C4087a.C4088a;
import com.kwad.sdk.core.p333g.C4143b;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.nativead.p348a.C4474a;

/* renamed from: com.kwad.sdk.nativead.b.i */
public class C4497i extends C4474a implements OnClickListener {
    /* access modifiers changed from: private */
    /* renamed from: b */
    public DetailVideoView f14684b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public AdTemplate f14685c;
    /* renamed from: d */
    private C3989e f14686d = new C3990f() {
        /* renamed from: c */
        public void mo23347c() {
            super.mo23347c();
            C4497i.this.f14684b.setOnClickListener(C4497i.this);
        }
    };

    /* renamed from: g */
    private void m18281g() {
        C4087a.m16967a(this.f14684b.getContext(), this.f14685c, new C4088a() {
            /* renamed from: a */
            public void mo23360a() {
                C4143b.m17117a(C4497i.this.f14685c, 2, C4497i.this.f14621a.f14624c.getTouchCoords());
            }
        }, this.f14621a.f14626e);
    }

    /* renamed from: h */
    private void m18282h() {
        this.f14621a.f14622a.onAdClicked(this.f14684b, null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23338a() {
        super.mo23338a();
        this.f14685c = this.f14621a.f14625d;
        this.f14621a.f14627f.mo24793a(this.f14686d);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo23339b() {
        super.mo23339b();
        this.f14684b = (DetailVideoView) mo24760a("ksad_video_player");
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo23340c() {
        super.mo23340c();
        this.f14684b.setOnClickListener(null);
        this.f14621a.f14627f.mo24795b(this.f14686d);
    }

    public void onClick(View view) {
        if (view == this.f14684b) {
            m18281g();
            m18282h();
        }
    }
}
