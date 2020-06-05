package com.kwad.sdk.nativead.p349b;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kwad.sdk.contentalliance.detail.video.C3989e;
import com.kwad.sdk.contentalliance.detail.video.C3990f;
import com.kwad.sdk.core.download.p323a.C4087a;
import com.kwad.sdk.core.download.p323a.C4087a.C4088a;
import com.kwad.sdk.core.p333g.C4143b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p342b.C4322a;
import com.kwad.sdk.core.response.p342b.C4324c;
import com.kwad.sdk.nativead.p348a.C4474a;

/* renamed from: com.kwad.sdk.nativead.b.h */
public class C4494h extends C4474a implements OnClickListener {
    /* renamed from: b */
    private ViewGroup f14677b;
    /* renamed from: c */
    private TextView f14678c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public AdTemplate f14679d;
    /* renamed from: e */
    private AdInfo f14680e;
    /* renamed from: f */
    private C3989e f14681f = new C3990f() {
        /* renamed from: b */
        public void mo23346b() {
            C4494h.this.m18270g();
        }
    };

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m18270g() {
        this.f14678c.setText(C4322a.m17650r(this.f14680e));
        this.f14677b.setOnClickListener(this);
        this.f14677b.setVisibility(0);
    }

    /* renamed from: h */
    private void m18271h() {
        C4087a.m16967a(this.f14677b.getContext(), this.f14679d, new C4088a() {
            /* renamed from: a */
            public void mo23360a() {
                C4143b.m17117a(C4494h.this.f14679d, 2, C4494h.this.f14621a.f14624c.getTouchCoords());
            }
        }, null);
    }

    /* renamed from: i */
    private void m18272i() {
        this.f14621a.f14622a.onAdClicked(this.f14677b, null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23338a() {
        super.mo23338a();
        this.f14679d = this.f14621a.f14625d;
        this.f14680e = C4324c.m17668e(this.f14679d);
        this.f14621a.f14627f.mo24793a(this.f14681f);
        this.f14677b.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo23339b() {
        super.mo23339b();
        this.f14677b = (ViewGroup) mo24760a("ksad_video_complete_h5_container");
        this.f14678c = (TextView) mo24760a("ksad_h5_open");
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo23340c() {
        super.mo23340c();
        this.f14621a.f14627f.mo24795b(this.f14681f);
    }

    public void onClick(View view) {
        m18271h();
        m18272i();
    }
}
