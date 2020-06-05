package com.bytedance.sdk.openadsdk;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.TTAdConstant.RitScenes;
import java.util.Map;

public interface TTRewardVideoAd {

    /* renamed from: com.bytedance.sdk.openadsdk.TTRewardVideoAd$RewardAdInteractionListener */
    public interface RewardAdInteractionListener {
        void onAdClose();

        void onAdShow();

        void onAdVideoBarClick();

        void onRewardVerify(boolean z, int i, String str);

        void onSkippedVideo();

        void onVideoComplete();

        void onVideoError();
    }

    int getInteractionType();

    Map<String, Object> getMediaExtraInfo();

    int getRewardVideoAdType();

    void setDownloadListener(TTAppDownloadListener tTAppDownloadListener);

    void setRewardAdInteractionListener(RewardAdInteractionListener rewardAdInteractionListener);

    void setShowDownLoadBar(boolean z);

    void showRewardVideoAd(Activity activity);

    void showRewardVideoAd(Activity activity, RitScenes ritScenes, String str);
}
