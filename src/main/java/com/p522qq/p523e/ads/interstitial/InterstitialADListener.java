package com.p522qq.p523e.ads.interstitial;

import com.p522qq.p523e.comm.util.AdError;

/* renamed from: com.qq.e.ads.interstitial.InterstitialADListener */
public interface InterstitialADListener {
    void onADClicked();

    void onADClosed();

    void onADExposure();

    void onADLeftApplication();

    void onADOpened();

    void onADReceive();

    void onNoAD(AdError adError);
}
