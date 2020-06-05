package com.p522qq.p523e.ads.banner2;

import com.p522qq.p523e.comm.util.AdError;

/* renamed from: com.qq.e.ads.banner2.UnifiedBannerADListener */
public interface UnifiedBannerADListener {
    void onADClicked();

    void onADCloseOverlay();

    void onADClosed();

    void onADExposure();

    void onADLeftApplication();

    void onADOpenOverlay();

    void onADReceive();

    void onNoAD(AdError adError);
}
