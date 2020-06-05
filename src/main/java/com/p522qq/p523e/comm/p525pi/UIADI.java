package com.p522qq.p523e.comm.p525pi;

import android.app.Activity;
import com.p522qq.p523e.ads.cfg.DownAPPConfirmPolicy;
import com.p522qq.p523e.ads.cfg.VideoOption;
import com.p522qq.p523e.ads.interstitial2.UnifiedInterstitialMediaListener;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.qq.e.comm.pi.UIADI */
public interface UIADI {
    public static final Map<String, String> ext = new HashMap();

    void close();

    void destory();

    String getAdNetWorkName();

    int getAdPatternType();

    int getECPM();

    String getECPMLevel();

    void loadAd();

    void loadFullScreenAD();

    void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy);

    void setMaxVideoDuration(int i);

    void setMediaListener(UnifiedInterstitialMediaListener unifiedInterstitialMediaListener);

    void setMinVideoDuration(int i);

    void setVideoOption(VideoOption videoOption);

    void setVideoPlayPolicy(int i);

    void show();

    void show(Activity activity);

    void showAsPopupWindow();

    void showAsPopupWindow(Activity activity);

    void showFullScreenAD(Activity activity);
}
