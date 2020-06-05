package com.p522qq.p523e.ads.splash;

import com.p522qq.p523e.comm.util.AdError;

/* renamed from: com.qq.e.ads.splash.SplashADListener */
public interface SplashADListener {
    void onADClicked();

    void onADDismissed();

    void onADExposure();

    void onADLoaded(long j);

    void onADPresent();

    void onADTick(long j);

    void onNoAD(AdError adError);
}
