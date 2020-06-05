package com.p522qq.p523e.ads.interstitial;

import com.p522qq.p523e.comm.util.GDTLogger;

/* renamed from: com.qq.e.ads.interstitial.AbstractInterstitialADListener */
public abstract class AbstractInterstitialADListener implements InterstitialADListener {
    public void onADClicked() {
        GDTLogger.m25262i("ON InterstitialAD Clicked");
    }

    public void onADClosed() {
        GDTLogger.m25262i("ON InterstitialAD Closed");
    }

    public void onADExposure() {
        GDTLogger.m25262i("ON InterstitialAD Exposure");
    }

    public void onADLeftApplication() {
        GDTLogger.m25262i("ON InterstitialAD LeftApplication");
    }

    public void onADOpened() {
        GDTLogger.m25262i("ON InterstitialAD Opened");
    }
}
