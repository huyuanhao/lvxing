package com.kwad.sdk.reward;

import android.app.Activity;
import android.content.Context;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.p333g.C4143b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p342b.C4322a;
import com.kwad.sdk.core.response.p342b.C4324c;
import com.kwad.sdk.export.p347i.KsRewardVideoAd;
import com.kwad.sdk.export.p347i.KsRewardVideoAd.RewardAdInteractionListener;
import com.kwad.sdk.video.VideoPlayConfig;
import com.kwad.sdk.video.VideoPlayConfig.Builder;

/* renamed from: com.kwad.sdk.reward.b */
public class C4531b implements KsRewardVideoAd {
    /* renamed from: a */
    private AdTemplate f14765a;
    /* renamed from: b */
    private AdInfo f14766b;
    /* renamed from: c */
    private RewardAdInteractionListener f14767c;

    public C4531b(AdTemplate adTemplate) {
        this.f14765a = adTemplate;
        this.f14766b = C4324c.m17668e(adTemplate);
    }

    /* renamed from: a */
    private void m18411a(Context context, VideoPlayConfig videoPlayConfig) {
        if (!isAdEnable()) {
            C4065b.m16867b("KsRewardVideoAdControl", "isAdEnable is false");
            return;
        }
        if (videoPlayConfig == null) {
            videoPlayConfig = new Builder().build();
        }
        KSRewardVideoActivity.m18329a(context, this.f14765a, videoPlayConfig, this.f14767c);
    }

    public int getECPM() {
        return C4322a.m17653u(this.f14766b);
    }

    public boolean isAdEnable() {
        return C4542e.m18436b(this.f14765a);
    }

    public void setBidEcpm(int i) {
        AdTemplate adTemplate = this.f14765a;
        adTemplate.mBidEcpm = i;
        C4143b.m17150m(adTemplate);
    }

    public void setRewardAdInteractionListener(RewardAdInteractionListener rewardAdInteractionListener) {
        this.f14767c = rewardAdInteractionListener;
    }

    public void showRewardVideoAd(Activity activity, VideoPlayConfig videoPlayConfig) {
        m18411a(activity, videoPlayConfig);
    }
}
