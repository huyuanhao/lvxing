package com.bytedance.sdk.openadsdk;

import android.view.View;
import com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback;
import java.util.Map;

public interface TTBannerAd {

    /* renamed from: com.bytedance.sdk.openadsdk.TTBannerAd$AdInteractionListener */
    public interface AdInteractionListener {
        void onAdClicked(View view, int i);

        void onAdShow(View view, int i);
    }

    View getBannerView();

    TTAdDislike getDislikeDialog(DislikeInteractionCallback dislikeInteractionCallback);

    int getInteractionType();

    Map<String, Object> getMediaExtraInfo();

    void setBannerInteractionListener(AdInteractionListener adInteractionListener);

    void setDownloadListener(TTAppDownloadListener tTAppDownloadListener);

    void setShowDislikeIcon(DislikeInteractionCallback dislikeInteractionCallback);

    void setSlideIntervalTime(int i);
}
