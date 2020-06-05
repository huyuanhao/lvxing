package com.bytedance.sdk.openadsdk;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import java.util.Map;

public interface TTNativeAd {

    /* renamed from: com.bytedance.sdk.openadsdk.TTNativeAd$AdInteractionListener */
    public interface AdInteractionListener {
        void onAdClicked(View view, TTNativeAd tTNativeAd);

        void onAdCreativeClick(View view, TTNativeAd tTNativeAd);

        void onAdShow(TTNativeAd tTNativeAd);
    }

    Bitmap getAdLogo();

    View getAdView();

    int getAppCommentNum();

    int getAppScore();

    int getAppSize();

    String getButtonText();

    String getDescription();

    TTAdDislike getDislikeDialog(Activity activity);

    TTAdDislike getDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract);

    DownloadStatusController getDownloadStatusController();

    List<FilterWord> getFilterWords();

    TTImage getIcon();

    List<TTImage> getImageList();

    int getImageMode();

    int getInteractionType();

    Map<String, Object> getMediaExtraInfo();

    String getSource();

    String getTitle();

    TTImage getVideoCoverImage();

    void registerViewForInteraction(ViewGroup viewGroup, View view, AdInteractionListener adInteractionListener);

    void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, View view, AdInteractionListener adInteractionListener);

    void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, AdInteractionListener adInteractionListener);

    void setActivityForDownloadApp(Activity activity);

    void setDownloadListener(TTAppDownloadListener tTAppDownloadListener);
}
