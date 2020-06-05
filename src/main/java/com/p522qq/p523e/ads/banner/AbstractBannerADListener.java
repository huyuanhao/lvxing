package com.p522qq.p523e.ads.banner;

import com.p522qq.p523e.comm.util.GDTLogger;

/* renamed from: com.qq.e.ads.banner.AbstractBannerADListener */
public abstract class AbstractBannerADListener implements BannerADListener {
    public void onADClicked() {
        GDTLogger.m25262i("On BannerAD Clicked");
    }

    public void onADCloseOverlay() {
        GDTLogger.m25262i("On BannerAD AdCloseOverlay");
    }

    public void onADClosed() {
        GDTLogger.m25262i("On BannerAD Closed");
    }

    public void onADExposure() {
        GDTLogger.m25262i("On BannerAD Exposured");
    }

    public void onADLeftApplication() {
        GDTLogger.m25262i("On BannerAD AdLeftApplication");
    }

    public void onADOpenOverlay() {
        GDTLogger.m25262i("On BannerAD AdOpenOverlay");
    }
}
