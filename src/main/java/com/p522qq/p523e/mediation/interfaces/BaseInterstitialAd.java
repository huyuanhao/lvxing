package com.p522qq.p523e.mediation.interfaces;

import android.app.Activity;
import com.p522qq.p523e.ads.cfg.DownAPPConfirmPolicy;
import com.p522qq.p523e.ads.cfg.VideoOption;
import com.p522qq.p523e.ads.interstitial2.UnifiedInterstitialADListener;
import com.p522qq.p523e.ads.interstitial2.UnifiedInterstitialMediaListener;

/* renamed from: com.qq.e.mediation.interfaces.BaseInterstitialAd */
public abstract class BaseInterstitialAd {
    public static final int DEFAULT_PRIORITY = -1;

    public BaseInterstitialAd(Activity activity, String str, String str2) {
    }

    public abstract void close();

    public abstract void destory();

    public abstract int getAdPatternType();

    public int getAdapterPriority() {
        return -1;
    }

    public abstract int getECPM();

    public abstract String getECPMLevel();

    public abstract void loadAd();

    public abstract void setAdListener(UnifiedInterstitialADListener unifiedInterstitialADListener);

    public abstract void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy);

    public abstract void setMaxVideoDuration(int i);

    public abstract void setMediaListener(UnifiedInterstitialMediaListener unifiedInterstitialMediaListener);

    public abstract void setMinVideoDuration(int i);

    public abstract void setVideoOption(VideoOption videoOption);

    public abstract void setVideoPlayPolicy(int i);

    public abstract void show();

    public abstract void show(Activity activity);

    public abstract void showAsPopupWindow();

    public abstract void showAsPopupWindow(Activity activity);
}
