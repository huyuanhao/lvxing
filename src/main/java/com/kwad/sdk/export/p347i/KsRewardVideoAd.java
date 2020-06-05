package com.kwad.sdk.export.p347i;

import android.app.Activity;
import com.kwad.sdk.video.VideoPlayConfig;

/* renamed from: com.kwad.sdk.export.i.KsRewardVideoAd */
public interface KsRewardVideoAd {

    /* renamed from: com.kwad.sdk.export.i.KsRewardVideoAd$RewardAdInteractionListener */
    public interface RewardAdInteractionListener {
        void onAdClicked();

        void onPageDismiss();

        void onRewardVerify();

        void onVideoPlayEnd();

        void onVideoPlayError(int i, int i2);

        void onVideoPlayStart();
    }

    int getECPM();

    boolean isAdEnable();

    void setBidEcpm(int i);

    void setRewardAdInteractionListener(RewardAdInteractionListener rewardAdInteractionListener);

    void showRewardVideoAd(Activity activity, VideoPlayConfig videoPlayConfig);
}
