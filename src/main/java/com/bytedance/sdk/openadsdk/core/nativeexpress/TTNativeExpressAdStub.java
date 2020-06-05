package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.app.Activity;
import android.view.View;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd.AdInteractionListener;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener;
import com.bytedance.sdk.openadsdk.multipro.p203b.VideoControllerDataModel;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.bytedance.sdk.openadsdk.core.nativeexpress.l */
public class TTNativeExpressAdStub implements TTNativeExpressAd {
    /* renamed from: e */
    public AtomicBoolean f7863e = new AtomicBoolean(false);

    public void destroy() {
    }

    public View getExpressAdView() {
        return null;
    }

    public List<FilterWord> getFilterWords() {
        return null;
    }

    public int getImageMode() {
        return 0;
    }

    public int getInteractionType() {
        return 0;
    }

    public Map<String, Object> getMediaExtraInfo() {
        return null;
    }

    public VideoControllerDataModel getVideoModel() {
        return null;
    }

    public void render() {
    }

    public void setCanInterruptVideoPlay(boolean z) {
    }

    public void setDislikeCallback(Activity activity, DislikeInteractionCallback dislikeInteractionCallback) {
    }

    public void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
    }

    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
    }

    public void setExpressInteractionListener(AdInteractionListener adInteractionListener) {
    }

    public void setExpressInteractionListener(ExpressAdInteractionListener expressAdInteractionListener) {
    }

    public void setSlideIntervalTime(int i) {
    }

    public void setVideoAdListener(ExpressVideoAdListener expressVideoAdListener) {
    }

    public void showInteractionExpressAd(Activity activity) {
    }
}
