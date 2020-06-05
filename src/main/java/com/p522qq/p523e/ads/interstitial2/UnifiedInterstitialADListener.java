package com.p522qq.p523e.ads.interstitial2;

import com.p522qq.p523e.comm.util.AdError;

/* renamed from: com.qq.e.ads.interstitial2.UnifiedInterstitialADListener */
public interface UnifiedInterstitialADListener {
    void onADClicked();

    void onADClosed();

    void onADExposure();

    void onADLeftApplication();

    void onADOpened();

    void onADReceive();

    void onNoAD(AdError adError);

    void onVideoCached();
}
