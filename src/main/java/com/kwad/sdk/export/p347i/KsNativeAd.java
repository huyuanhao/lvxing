package com.kwad.sdk.export.p347i;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.export.config.KSAdVideoPlayConfig;
import com.kwad.sdk.nativead.KsAppDownloadListener;
import com.kwad.sdk.nativead.KsImage;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* renamed from: com.kwad.sdk.export.i.KsNativeAd */
public interface KsNativeAd {

    /* renamed from: com.kwad.sdk.export.i.KsNativeAd$AdInteractionListener */
    public interface AdInteractionListener {
        void onAdClicked(View view, KsNativeAd ksNativeAd);

        void onAdShow(KsNativeAd ksNativeAd);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.kwad.sdk.export.i.KsNativeAd$InteractionType */
    public @interface InteractionType {
        public static final int DOWNLOAD = 1;
        /* renamed from: H5 */
        public static final int f14459H5 = 2;
        public static final int UNKNOWN = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.kwad.sdk.export.i.KsNativeAd$MaterialType */
    public @interface MaterialType {
        public static final int GROUP_IMG = 3;
        public static final int SINGLE_IMG = 2;
        public static final int UNKNOWN = 0;
        public static final int VIDEO = 1;
    }

    /* renamed from: com.kwad.sdk.export.i.KsNativeAd$VideoPlayListener */
    public interface VideoPlayListener {
        void onVideoPlayComplete();

        void onVideoPlayError(int i, int i2);

        void onVideoPlayStart();
    }

    String getActionDescription();

    String getAdDescription();

    String getAdSource();

    String getAppDownloadCountDes();

    String getAppIconUrl();

    String getAppName();

    float getAppScore();

    int getECPM();

    List<KsImage> getImageList();

    int getInteractionType();

    int getMaterialType();

    Bitmap getSdkLogo();

    KsImage getVideoCoverImage();

    int getVideoDuration();

    String getVideoUrl();

    View getVideoView(Context context, KSAdVideoPlayConfig kSAdVideoPlayConfig);

    @Deprecated
    View getVideoView(Context context, boolean z);

    void registerViewForInteraction(ViewGroup viewGroup, List<View> list, AdInteractionListener adInteractionListener);

    void setBidEcpm(int i);

    void setDownloadListener(KsAppDownloadListener ksAppDownloadListener);

    void setVideoPlayListener(VideoPlayListener videoPlayListener);
}
