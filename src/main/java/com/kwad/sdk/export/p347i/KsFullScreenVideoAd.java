package com.kwad.sdk.export.p347i;

import android.app.Activity;
import com.kwad.sdk.video.VideoPlayConfig;

/* renamed from: com.kwad.sdk.export.i.KsFullScreenVideoAd */
public interface KsFullScreenVideoAd {

    /* renamed from: com.kwad.sdk.export.i.KsFullScreenVideoAd$FullScreenVideoAdInteractionListener */
    public interface FullScreenVideoAdInteractionListener {
        void onAdClicked();

        void onPageDismiss();

        void onSkippedVideo();

        void onVideoPlayEnd();

        void onVideoPlayError(int i, int i2);

        void onVideoPlayStart();
    }

    int getECPM();

    boolean isAdEnable();

    void setBidEcpm(int i);

    void setFullScreenVideoAdInteractionListener(FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener);

    void showFullScreenVideoAd(Activity activity, VideoPlayConfig videoPlayConfig);
}
