package com.p522qq.p523e.ads.banner;

import com.p522qq.p523e.comm.util.AdError;

/* renamed from: com.qq.e.ads.banner.BannerADListener */
public interface BannerADListener {
    void onADClicked();

    void onADCloseOverlay();

    void onADClosed();

    void onADExposure();

    void onADLeftApplication();

    void onADOpenOverlay();

    void onADReceiv();

    void onNoAD(AdError adError);
}
