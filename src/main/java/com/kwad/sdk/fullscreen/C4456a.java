package com.kwad.sdk.fullscreen;

import android.app.Activity;
import android.content.Context;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.p333g.C4143b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p342b.C4322a;
import com.kwad.sdk.core.response.p342b.C4324c;
import com.kwad.sdk.export.p347i.KsFullScreenVideoAd;
import com.kwad.sdk.export.p347i.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener;
import com.kwad.sdk.reward.C4542e;
import com.kwad.sdk.video.VideoPlayConfig;
import com.kwad.sdk.video.VideoPlayConfig.Builder;

/* renamed from: com.kwad.sdk.fullscreen.a */
public class C4456a implements KsFullScreenVideoAd {
    /* renamed from: a */
    private AdTemplate f14588a;
    /* renamed from: b */
    private AdInfo f14589b;
    /* renamed from: c */
    private FullScreenVideoAdInteractionListener f14590c;

    public C4456a(AdTemplate adTemplate) {
        this.f14588a = adTemplate;
        this.f14589b = C4324c.m17668e(adTemplate);
    }

    /* renamed from: a */
    private void m18170a(Context context, VideoPlayConfig videoPlayConfig) {
        if (!isAdEnable()) {
            C4065b.m16867b("KsFullScreenVideoAdControl", "isAdEnable is false");
            return;
        }
        if (videoPlayConfig == null) {
            videoPlayConfig = new Builder().build();
        }
        KsFullScreenVideoActivity.m18107a(context, this.f14588a, videoPlayConfig, this.f14590c);
    }

    public int getECPM() {
        return C4322a.m17653u(this.f14589b);
    }

    public boolean isAdEnable() {
        return C4542e.m18436b(this.f14588a);
    }

    public void setBidEcpm(int i) {
        AdTemplate adTemplate = this.f14588a;
        adTemplate.mBidEcpm = i;
        C4143b.m17150m(adTemplate);
    }

    public void setFullScreenVideoAdInteractionListener(FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        this.f14590c = fullScreenVideoAdInteractionListener;
    }

    public void showFullScreenVideoAd(Activity activity, VideoPlayConfig videoPlayConfig) {
        m18170a(activity, videoPlayConfig);
    }
}
