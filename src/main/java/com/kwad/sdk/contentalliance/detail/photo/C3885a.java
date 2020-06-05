package com.kwad.sdk.contentalliance.detail.photo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.contentalliance.detail.C3849a;
import com.kwad.sdk.contentalliance.detail.C3873c;
import com.kwad.sdk.contentalliance.detail.C3874d;
import com.kwad.sdk.contentalliance.detail.C3880e;
import com.kwad.sdk.contentalliance.detail.photo.p313b.C3900a;
import com.kwad.sdk.contentalliance.detail.photo.p313b.C3902b;
import com.kwad.sdk.contentalliance.detail.photo.p313b.C3915d;
import com.kwad.sdk.contentalliance.detail.photo.p313b.C3919e;
import com.kwad.sdk.contentalliance.detail.photo.p313b.C3922f;
import com.kwad.sdk.contentalliance.detail.photo.p313b.C3923g;
import com.kwad.sdk.contentalliance.detail.photo.p313b.C3935h;
import com.kwad.sdk.contentalliance.detail.video.C3982b;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.contentalliance.p308a.C3828a;
import com.kwad.sdk.contentalliance.p308a.C3830c;
import com.kwad.sdk.contentalliance.p308a.C3832e;
import com.kwad.sdk.core.p317a.C4057a;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.p306a.C3817t;
import java.io.Serializable;

/* renamed from: com.kwad.sdk.contentalliance.detail.photo.a */
public class C3885a extends C3849a<C3873c> {
    /* renamed from: g */
    private int f13164g;
    /* renamed from: h */
    private AdTemplate f13165h;
    /* renamed from: i */
    private DetailVideoView f13166i;

    /* renamed from: a */
    public void mo23230a() {
        StringBuilder sb = new StringBuilder();
        sb.append("becomesDetachedOnPageSelected position=");
        sb.append(this.f13164g);
        C4065b.m16863a("DetailPhotoFragment", sb.toString());
        for (C3828a a : ((C3873c) this.f12960b).f13127a) {
            a.mo23230a();
        }
    }

    /* renamed from: a */
    public void mo23384a(float f, float f2) {
        for (C3832e a : ((C3873c) this.f12960b).f13129c) {
            a.mo23239a(f, f2);
        }
    }

    /* renamed from: b */
    public void mo23231b() {
        StringBuilder sb = new StringBuilder();
        sb.append("becomesAttachedOnPageSelected position=");
        sb.append(this.f13164g);
        C4065b.m16863a("DetailPhotoFragment", sb.toString());
        for (C3828a b : ((C3873c) this.f12960b).f13127a) {
            b.mo23231b();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b_ */
    public String mo23227b_() {
        return "ksad_content_alliance_detail_photo";
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Presenter mo23229d() {
        Presenter presenter = new Presenter();
        presenter.mo24762a((Presenter) new C3919e());
        presenter.mo24762a((Presenter) new C3874d());
        presenter.mo24762a((Presenter) new C3915d());
        presenter.mo24762a((Presenter) new C3935h());
        presenter.mo24762a((Presenter) new C3900a());
        presenter.mo24762a((Presenter) new C3923g());
        presenter.mo24762a((Presenter) new C3880e());
        if (C4057a.m16823b()) {
            presenter.mo24762a((Presenter) new C3922f());
        }
        presenter.mo24762a((Presenter) new C3902b());
        return presenter;
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public C3873c mo23228c() {
        C3873c cVar = new C3873c();
        cVar.f13134h = this.f13047d;
        AdTemplate adTemplate = this.f13165h;
        cVar.f13133g = adTemplate;
        cVar.f13132f = this.f13164g;
        C3982b bVar = new C3982b(this, this.f13166i, adTemplate);
        cVar.f13127a.add(bVar);
        cVar.f13128b.add(bVar.mo23563e());
        cVar.f13135i = bVar;
        return cVar;
    }

    /* renamed from: m */
    public void mo23232m() {
        StringBuilder sb = new StringBuilder();
        sb.append("attachedOnScrollEnd position=");
        sb.append(this.f13164g);
        C4065b.m16863a("DetailPhotoFragment", sb.toString());
        for (C3828a m : ((C3873c) this.f12960b).f13127a) {
            m.mo23232m();
        }
    }

    /* renamed from: n */
    public void mo23233n() {
        StringBuilder sb = new StringBuilder();
        sb.append("detachedOnScrollEnd position=");
        sb.append(this.f13164g);
        C4065b.m16863a("DetailPhotoFragment", sb.toString());
        for (C3828a n : ((C3873c) this.f12960b).f13127a) {
            n.mo23233n();
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        StringBuilder sb = new StringBuilder();
        sb.append("onActivityCreated position=");
        sb.append(this.f13164g);
        C4065b.m16867b("DetailPhotoFragment", sb.toString());
        mo23334i();
        for (C3830c e : ((C3873c) this.f12960b).f13128b) {
            e.mo23238e();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String sb;
        super.onCreateView(layoutInflater, viewGroup, bundle);
        Bundle arguments = getArguments();
        String str = "DetailPhotoFragment";
        if (arguments == null) {
            sb = "bundle is null";
        } else {
            this.f13164g = arguments.getInt("KEY_INDEX_IN_VIEW_PAGER");
            Serializable serializable = getArguments().getSerializable("key_template");
            if (!(serializable instanceof AdTemplate)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("data is not instanceof AdTemplate:");
                sb2.append(serializable);
                sb = sb2.toString();
            } else {
                this.f13165h = (AdTemplate) serializable;
                this.f13166i = (DetailVideoView) C3817t.m15863a(this.f12961c, "ksad_video_player");
                return this.f12961c;
            }
        }
        C4065b.m16869d(str, sb);
        return this.f12961c;
    }

    public void onDestroy() {
        super.onDestroy();
        StringBuilder sb = new StringBuilder();
        sb.append("onDestroy position=");
        sb.append(this.f13164g);
        C4065b.m16867b("DetailPhotoFragment", sb.toString());
        for (C3830c d : ((C3873c) this.f12960b).f13128b) {
            d.mo23237d();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        StringBuilder sb = new StringBuilder();
        sb.append("onDestroyView position=");
        sb.append(this.f13164g);
        C4065b.m16867b("DetailPhotoFragment", sb.toString());
        for (C3830c c : ((C3873c) this.f12960b).f13128b) {
            c.mo23236c();
        }
    }

    public void onPause() {
        super.onPause();
        StringBuilder sb = new StringBuilder();
        sb.append("onPause position=");
        sb.append(this.f13164g);
        C4065b.m16867b("DetailPhotoFragment", sb.toString());
        for (C3830c b : ((C3873c) this.f12960b).f13128b) {
            b.mo23235b();
        }
    }

    public void onResume() {
        super.onResume();
        StringBuilder sb = new StringBuilder();
        sb.append("onResume position=");
        sb.append(this.f13164g);
        C4065b.m16867b("DetailPhotoFragment", sb.toString());
        for (C3830c a : ((C3873c) this.f12960b).f13128b) {
            a.mo23234a();
        }
    }
}
