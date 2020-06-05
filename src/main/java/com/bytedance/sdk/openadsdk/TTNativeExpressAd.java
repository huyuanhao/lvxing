package com.bytedance.sdk.openadsdk;

import android.app.Activity;
import android.view.View;
import com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback;
import com.bytedance.sdk.openadsdk.multipro.p203b.VideoControllerDataModel;
import java.util.List;
import java.util.Map;

public interface TTNativeExpressAd {

    /* renamed from: com.bytedance.sdk.openadsdk.TTNativeExpressAd$AdInteractionListener */
    public interface AdInteractionListener extends ExpressAdInteractionListener {
        void onAdDismiss();
    }

    /* renamed from: com.bytedance.sdk.openadsdk.TTNativeExpressAd$ExpressAdInteractionListener */
    public interface ExpressAdInteractionListener {
        void onAdClicked(View view, int i);

        void onAdShow(View view, int i);

        void onRenderFail(View view, String str, int i);

        void onRenderSuccess(View view, float f, float f2);
    }

    /* renamed from: com.bytedance.sdk.openadsdk.TTNativeExpressAd$ExpressVideoAdListener */
    public interface ExpressVideoAdListener {
        void onClickRetry();

        void onProgressUpdate(long j, long j2);

        void onVideoAdComplete();

        void onVideoAdContinuePlay();

        void onVideoAdPaused();

        void onVideoAdStartPlay();

        void onVideoError(int i, int i2);

        void onVideoLoad();
    }

    void destroy();

    View getExpressAdView();

    List<FilterWord> getFilterWords();

    int getImageMode();

    int getInteractionType();

    Map<String, Object> getMediaExtraInfo();

    VideoControllerDataModel getVideoModel();

    void render();

    void setCanInterruptVideoPlay(boolean z);

    void setDislikeCallback(Activity activity, DislikeInteractionCallback dislikeInteractionCallback);

    void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract);

    void setDownloadListener(TTAppDownloadListener tTAppDownloadListener);

    void setExpressInteractionListener(AdInteractionListener adInteractionListener);

    void setExpressInteractionListener(ExpressAdInteractionListener expressAdInteractionListener);

    void setSlideIntervalTime(int i);

    void setVideoAdListener(ExpressVideoAdListener expressVideoAdListener);

    void showInteractionExpressAd(Activity activity);
}
