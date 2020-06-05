package com.kwad.sdk.nativead.p349b;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.kwad.sdk.contentalliance.detail.video.C3989e;
import com.kwad.sdk.contentalliance.detail.video.C3990f;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.C4330e;
import com.kwad.sdk.core.response.p342b.C4322a;
import com.kwad.sdk.core.response.p342b.C4324c;
import com.kwad.sdk.nativead.p348a.C4474a;
import com.kwad.sdk.p306a.C3817t;

/* renamed from: com.kwad.sdk.nativead.b.b */
public class C4479b extends C4474a {
    /* access modifiers changed from: private */
    /* renamed from: b */
    public ImageView f14645b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public C4330e f14646c;
    /* renamed from: d */
    private C3989e f14647d = new C3990f() {
        /* renamed from: a */
        public void mo23373a() {
            super.mo23373a();
            if (C4479b.this.f14645b.getVisibility() == 0) {
                C4479b.this.f14645b.setVisibility(8);
            }
        }
    };
    /* renamed from: e */
    private Runnable f14648e = new Runnable() {
        public void run() {
            C3817t.m15865a((View) C4479b.this.f14645b, C4479b.this.f14646c.mo24476c(), C4479b.this.f14646c.mo24475b());
            C4479b.this.f14645b.setImageDrawable(null);
            KSImageLoader.loadImage(C4479b.this.f14645b, C4479b.this.f14646c.mo24474a());
        }
    };

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23338a() {
        super.mo23338a();
        this.f14646c = C4322a.m17629E(C4324c.m17668e(this.f14621a.f14625d));
        if (!TextUtils.isEmpty(this.f14646c.mo24474a())) {
            mo24768n().post(this.f14648e);
            this.f14645b.setVisibility(0);
            this.f14621a.f14627f.mo24793a(this.f14647d);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo23339b() {
        super.mo23339b();
        this.f14645b = (ImageView) mo24760a("ksad_video_first_frame");
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo23340c() {
        super.mo23340c();
        mo24768n().removeCallbacks(this.f14648e);
        this.f14621a.f14627f.mo24795b(this.f14647d);
    }
}
