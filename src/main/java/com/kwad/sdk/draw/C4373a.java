package com.kwad.sdk.draw;

import android.content.Context;
import android.view.View;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.p333g.C4143b;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p342b.C4322a;
import com.kwad.sdk.core.response.p342b.C4324c;
import com.kwad.sdk.draw.view.C4389c;
import com.kwad.sdk.draw.view.C4389c.C4401a;
import com.kwad.sdk.export.p347i.KsDrawAd;
import com.kwad.sdk.export.p347i.KsDrawAd.AdInteractionListener;

/* renamed from: com.kwad.sdk.draw.a */
public class C4373a implements KsDrawAd {
    /* renamed from: a */
    private AdTemplate f14318a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public AdInteractionListener f14319b;
    /* renamed from: c */
    private C4389c f14320c;

    public C4373a(AdTemplate adTemplate) {
        this.f14318a = adTemplate;
        KSImageLoader.preloadImage(C4322a.m17638f(C4324c.m17668e(this.f14318a)));
    }

    public View getDrawView(Context context) {
        if (this.f14320c == null) {
            this.f14320c = new C4389c(context, this.f14318a);
            this.f14320c.setAdClickListener(new C4401a() {
                /* renamed from: a */
                public void mo24552a() {
                    if (C4373a.this.f14319b != null) {
                        C4373a.this.f14319b.onAdClicked();
                    }
                }

                /* renamed from: b */
                public void mo24553b() {
                    if (C4373a.this.f14319b != null) {
                        C4373a.this.f14319b.onAdShow();
                    }
                }
            });
        } else {
            C4065b.m16867b("KSDrawAdControl", "mDrawVideoView is not null");
        }
        this.f14320c.mo24595e();
        return this.f14320c;
    }

    public int getECPM() {
        return C4322a.m17653u(C4324c.m17668e(this.f14318a));
    }

    public void setAdInteractionListener(AdInteractionListener adInteractionListener) {
        this.f14319b = adInteractionListener;
    }

    public void setBidEcpm(int i) {
        AdTemplate adTemplate = this.f14318a;
        adTemplate.mBidEcpm = i;
        C4143b.m17150m(adTemplate);
    }
}
