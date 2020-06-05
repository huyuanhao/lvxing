package com.kwad.sdk.nativead;

import android.content.Context;
import android.view.View;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.core.download.p323a.C4089b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p342b.C4322a;
import com.kwad.sdk.core.response.p342b.C4324c;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.view.C4370a;
import com.kwad.sdk.core.view.C4371b;
import com.kwad.sdk.export.config.KSAdVideoPlayConfig;
import com.kwad.sdk.export.p347i.KsNativeAd.AdInteractionListener;
import com.kwad.sdk.export.p347i.KsNativeAd.VideoPlayListener;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.nativead.p348a.C4475b;
import com.kwad.sdk.nativead.p349b.C4477a;
import com.kwad.sdk.nativead.p349b.C4479b;
import com.kwad.sdk.nativead.p349b.C4482c;
import com.kwad.sdk.nativead.p349b.C4484d;
import com.kwad.sdk.nativead.p349b.C4486e;
import com.kwad.sdk.nativead.p349b.C4488f;
import com.kwad.sdk.nativead.p349b.C4492g;
import com.kwad.sdk.nativead.p349b.C4494h;
import com.kwad.sdk.nativead.p349b.C4497i;
import com.kwad.sdk.nativead.p349b.C4500j;
import com.kwad.sdk.nativead.p349b.C4502k;
import com.kwad.sdk.nativead.p350c.C4504a;
import com.kwad.sdk.p306a.C3809l;
import com.kwad.sdk.p306a.C3817t;

/* renamed from: com.kwad.sdk.nativead.b */
public class C4476b extends C4370a {
    /* renamed from: a */
    private AdInteractionListener f14628a;
    /* renamed from: b */
    private VideoPlayListener f14629b;
    /* renamed from: c */
    private AdBaseFrameLayout f14630c;
    /* renamed from: d */
    private DetailVideoView f14631d;
    /* renamed from: e */
    private C4475b f14632e;
    /* renamed from: f */
    private Presenter f14633f;
    /* renamed from: g */
    private AdTemplate f14634g;
    /* renamed from: h */
    private AdInfo f14635h;
    /* renamed from: i */
    private C4089b f14636i;
    /* renamed from: j */
    private C4504a f14637j;
    /* renamed from: k */
    private C4371b f14638k;
    /* renamed from: l */
    private KSAdVideoPlayConfig f14639l;

    public C4476b(Context context) {
        super(context);
        m18207c();
    }

    /* renamed from: c */
    private void m18207c() {
        inflate(getContext(), C3809l.m15792b(getContext(), "ksad_native_video_layout"), this);
        this.f14630c = (AdBaseFrameLayout) C3817t.m15863a((View) this, "ksad_root_container");
        this.f14631d = (DetailVideoView) C3817t.m15863a((View) this.f14630c, "ksad_video_player");
        this.f14631d.setAd(true);
    }

    /* renamed from: d */
    private C4475b m18208d() {
        C4475b bVar = new C4475b();
        bVar.f14624c = this.f14630c;
        bVar.f14625d = this.f14634g;
        bVar.f14622a = this.f14628a;
        bVar.f14623b = this.f14629b;
        C4089b bVar2 = (this.f14636i != null || !C4322a.m17651s(this.f14635h)) ? this.f14636i : new C4089b(this.f14634g);
        bVar.f14626e = bVar2;
        bVar.f14627f = this.f14637j;
        return bVar;
    }

    /* renamed from: e */
    private Presenter m18209e() {
        Presenter presenter = new Presenter();
        presenter.mo24762a((Presenter) new C4486e());
        presenter.mo24762a((Presenter) new C4482c());
        presenter.mo24762a((Presenter) new C4497i());
        presenter.mo24762a((Presenter) new C4500j());
        presenter.mo24762a((Presenter) new C4484d());
        presenter.mo24762a((Presenter) new C4479b());
        presenter.mo24762a((Presenter) new C4502k());
        KSAdVideoPlayConfig kSAdVideoPlayConfig = this.f14639l;
        if (kSAdVideoPlayConfig == null || !kSAdVideoPlayConfig.dataFlowAutoStart) {
            presenter.mo24762a((Presenter) new C4477a());
        }
        presenter.mo24762a((Presenter) new C4492g());
        presenter.mo24762a(C4322a.m17651s(this.f14635h) ? new C4488f() : new C4494h());
        return presenter;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo24535a() {
        C4371b bVar = this.f14638k;
        if (bVar != null) {
            bVar.mo24545c();
        }
        C4504a aVar = this.f14637j;
        if (aVar != null) {
            aVar.mo24794b();
        }
        C4475b bVar2 = this.f14632e;
        if (bVar2 != null) {
            bVar2.mo23367a();
        }
        Presenter presenter = this.f14633f;
        if (presenter != null) {
            presenter.mo24765k();
        }
    }

    /* renamed from: a */
    public void mo24784a(AdTemplate adTemplate, C4089b bVar, KSAdVideoPlayConfig kSAdVideoPlayConfig) {
        this.f14634g = adTemplate;
        this.f14635h = C4324c.m17668e(this.f14634g);
        this.f14636i = bVar;
        this.f14639l = kSAdVideoPlayConfig;
        this.f14638k = new C4371b(getParent() == null ? this : (View) getParent(), 30);
        this.f14637j = new C4504a(this.f14634g, this.f14638k, this.f14631d, kSAdVideoPlayConfig);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo24536b() {
        this.f14638k.mo24541a();
        this.f14637j.mo24792a();
        this.f14632e = m18208d();
        this.f14633f = m18209e();
        this.f14633f.mo24761a((View) this.f14630c);
        this.f14633f.mo24763a((Object) this.f14632e);
    }

    public void setAdInteractionListener(AdInteractionListener adInteractionListener) {
        this.f14628a = adInteractionListener;
    }

    public void setVideoPlayListener(VideoPlayListener videoPlayListener) {
        this.f14629b = videoPlayListener;
    }
}
