package com.p522qq.p523e.ads.interstitial2;

import com.p522qq.p523e.comm.util.AdError;

/* renamed from: com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener */
public interface UnifiedInterstitialMediaListener {
    void onVideoComplete();

    void onVideoError(AdError adError);

    void onVideoInit();

    void onVideoLoading();

    void onVideoPageClose();

    void onVideoPageOpen();

    void onVideoPause();

    void onVideoReady(long j);

    void onVideoStart();
}
