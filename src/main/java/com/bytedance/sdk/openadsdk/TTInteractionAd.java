package com.bytedance.sdk.openadsdk;

import android.app.Activity;
import java.util.Map;

public interface TTInteractionAd {

    /* renamed from: com.bytedance.sdk.openadsdk.TTInteractionAd$AdInteractionListener */
    public interface AdInteractionListener {
        void onAdClicked();

        void onAdDismiss();

        void onAdShow();
    }

    int getInteractionType();

    Map<String, Object> getMediaExtraInfo();

    void setAdInteractionListener(AdInteractionListener adInteractionListener);

    void setDownloadListener(TTAppDownloadListener tTAppDownloadListener);

    void showInteractionAd(Activity activity);
}
