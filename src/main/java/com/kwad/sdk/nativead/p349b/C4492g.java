package com.kwad.sdk.nativead.p349b;

import android.widget.ImageView;
import com.kwad.sdk.contentalliance.detail.video.C3989e;
import com.kwad.sdk.contentalliance.detail.video.C3990f;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.p342b.C4322a;
import com.kwad.sdk.core.response.p342b.C4324c;
import com.kwad.sdk.nativead.p348a.C4474a;

/* renamed from: com.kwad.sdk.nativead.b.g */
public class C4492g extends C4474a {
    /* renamed from: b */
    private ImageView f14673b;
    /* renamed from: c */
    private AdInfo f14674c;
    /* renamed from: d */
    private C3989e f14675d = new C3990f() {
        /* renamed from: b */
        public void mo23346b() {
            C4492g.this.m18262g();
        }
    };

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m18262g() {
        KSImageLoader.loadImage(this.f14673b, C4322a.m17638f(this.f14674c));
        this.f14673b.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23338a() {
        super.mo23338a();
        this.f14674c = C4324c.m17668e(this.f14621a.f14625d);
        this.f14621a.f14627f.mo24793a(this.f14675d);
        this.f14673b.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo23339b() {
        super.mo23339b();
        this.f14673b = (ImageView) mo24760a("ksad_video_cover_image");
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo23340c() {
        super.mo23340c();
        this.f14621a.f14627f.mo24795b(this.f14675d);
    }
}
