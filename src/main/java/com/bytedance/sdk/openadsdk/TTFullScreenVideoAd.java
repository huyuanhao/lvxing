package com.bytedance.sdk.openadsdk;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.TTAdConstant.RitScenes;
import java.util.Map;

public interface TTFullScreenVideoAd {

    /* renamed from: com.bytedance.sdk.openadsdk.TTFullScreenVideoAd$FullScreenVideoAdInteractionListener */
    public interface FullScreenVideoAdInteractionListener {
        void onAdClose();

        void onAdShow();

        void onAdVideoBarClick();

        void onSkippedVideo();

        void onVideoComplete();
    }

    int getFullVideoAdType();

    int getInteractionType();

    Map<String, Object> getMediaExtraInfo();

    void setDownloadListener(TTAppDownloadListener tTAppDownloadListener);

    void setFullScreenVideoAdInteractionListener(FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener);

    void setShowDownLoadBar(boolean z);

    void showFullScreenVideoAd(Activity activity);

    void showFullScreenVideoAd(Activity activity, RitScenes ritScenes, String str);
}
