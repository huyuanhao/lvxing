package com.p522qq.p523e.ads.nativ;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.p522qq.p523e.ads.cfg.VideoOption;
import com.p522qq.p523e.ads.nativ.widget.NativeAdContainer;
import com.p522qq.p523e.comm.C6411a;
import com.p522qq.p523e.comm.adevent.ADEvent;
import com.p522qq.p523e.comm.adevent.ADEventListener;
import com.p522qq.p523e.comm.adevent.ADListener;
import com.p522qq.p523e.comm.constants.Constants.KEYS;
import com.p522qq.p523e.comm.util.GDTLogger;
import java.util.List;

/* renamed from: com.qq.e.ads.nativ.NativeUnifiedADDataAdapter */
public class NativeUnifiedADDataAdapter implements NativeUnifiedADData {
    /* renamed from: a */
    private NativeUnifiedADData f20105a;
    /* renamed from: b */
    private NativeADEventListener f20106b;
    /* renamed from: c */
    private NativeADMediaListener f20107c;

    /* renamed from: com.qq.e.ads.nativ.NativeUnifiedADDataAdapter$UnifiedAdListener */
    private class UnifiedAdListener implements ADListener {
        private UnifiedAdListener() {
        }

        /* synthetic */ UnifiedAdListener(NativeUnifiedADDataAdapter nativeUnifiedADDataAdapter, byte b) {
            this();
        }

        public void onADEvent(ADEvent aDEvent) {
            if (aDEvent.getType() <= 4) {
                NativeUnifiedADDataAdapter.m25147a(NativeUnifiedADDataAdapter.this, aDEvent);
            } else {
                NativeUnifiedADDataAdapter.m25148b(NativeUnifiedADDataAdapter.this, aDEvent);
            }
        }
    }

    public NativeUnifiedADDataAdapter(NativeUnifiedADData nativeUnifiedADData) {
        this.f20105a = nativeUnifiedADData;
        NativeUnifiedADData nativeUnifiedADData2 = this.f20105a;
        if (nativeUnifiedADData2 instanceof ADEventListener) {
            ((ADEventListener) nativeUnifiedADData2).setAdListener(new UnifiedAdListener(this, 0));
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m25147a(NativeUnifiedADDataAdapter nativeUnifiedADDataAdapter, ADEvent aDEvent) {
        if (nativeUnifiedADDataAdapter.f20106b != null) {
            int type = aDEvent.getType();
            if (type == 1) {
                nativeUnifiedADDataAdapter.f20106b.onADExposed();
            } else if (type != 2) {
                if (type != 3) {
                    if (type == 4) {
                        nativeUnifiedADDataAdapter.f20106b.onADStatusChanged();
                    }
                } else if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                    nativeUnifiedADDataAdapter.f20106b.onADError(C6411a.m25175a(((Integer) aDEvent.getParas()[0]).intValue()));
                }
            } else if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof String)) {
                try {
                    NativeUnifiedADData.ext.put(KEYS.EXPOSED_CLICK_URL_KEY, (String) aDEvent.getParas()[0]);
                } catch (Exception e) {
                    GDTLogger.m25260e("native 2.0 set click url error");
                    e.printStackTrace();
                }
                nativeUnifiedADDataAdapter.f20106b.onADClicked();
            }
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m25148b(NativeUnifiedADDataAdapter nativeUnifiedADDataAdapter, ADEvent aDEvent) {
        if (nativeUnifiedADDataAdapter.f20107c != null) {
            switch (aDEvent.getType()) {
                case 5:
                    nativeUnifiedADDataAdapter.f20107c.onVideoInit();
                    break;
                case 6:
                    nativeUnifiedADDataAdapter.f20107c.onVideoLoading();
                    return;
                case 7:
                    nativeUnifiedADDataAdapter.f20107c.onVideoReady();
                    return;
                case 8:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                        nativeUnifiedADDataAdapter.f20107c.onVideoLoaded(((Integer) aDEvent.getParas()[0]).intValue());
                        return;
                    }
                case 9:
                    nativeUnifiedADDataAdapter.f20107c.onVideoStart();
                    return;
                case 10:
                    nativeUnifiedADDataAdapter.f20107c.onVideoPause();
                    return;
                case 11:
                    nativeUnifiedADDataAdapter.f20107c.onVideoResume();
                    return;
                case 12:
                    nativeUnifiedADDataAdapter.f20107c.onVideoCompleted();
                    return;
                case 13:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                        nativeUnifiedADDataAdapter.f20107c.onVideoError(C6411a.m25175a(((Integer) aDEvent.getParas()[0]).intValue()));
                        return;
                    }
                case 14:
                    nativeUnifiedADDataAdapter.f20107c.onVideoStop();
                    return;
                case 15:
                    nativeUnifiedADDataAdapter.f20107c.onVideoClicked();
                    break;
            }
        }
    }

    public void bindAdToView(Context context, NativeAdContainer nativeAdContainer, LayoutParams layoutParams, List<View> list) {
        this.f20105a.bindAdToView(context, nativeAdContainer, layoutParams, list);
    }

    public void bindCTAViews(List<View> list) {
        this.f20105a.bindCTAViews(list);
    }

    public void bindMediaView(MediaView mediaView, VideoOption videoOption, NativeADMediaListener nativeADMediaListener) {
        this.f20107c = nativeADMediaListener;
        this.f20105a.bindMediaView(mediaView, videoOption, null);
    }

    public void destroy() {
        this.f20105a.destroy();
    }

    public boolean equalsAdData(NativeUnifiedADData nativeUnifiedADData) {
        return this.f20105a.equalsAdData(nativeUnifiedADData);
    }

    public NativeUnifiedADData getAdData() {
        return this.f20105a;
    }

    public int getAdPatternType() {
        return this.f20105a.getAdPatternType();
    }

    public double getAppPrice() {
        return this.f20105a.getAppPrice();
    }

    public int getAppScore() {
        return this.f20105a.getAppScore();
    }

    public int getAppStatus() {
        return this.f20105a.getAppStatus();
    }

    public String getCTAText() {
        return this.f20105a.getCTAText();
    }

    public String getDesc() {
        return this.f20105a.getDesc();
    }

    public long getDownloadCount() {
        return this.f20105a.getDownloadCount();
    }

    public int getECPM() {
        return this.f20105a.getECPM();
    }

    public String getECPMLevel() {
        return this.f20105a.getECPMLevel();
    }

    public String getIconUrl() {
        return this.f20105a.getIconUrl();
    }

    public List<String> getImgList() {
        return this.f20105a.getImgList();
    }

    public String getImgUrl() {
        return this.f20105a.getImgUrl();
    }

    public int getPictureHeight() {
        return this.f20105a.getPictureHeight();
    }

    public int getPictureWidth() {
        return this.f20105a.getPictureWidth();
    }

    public int getProgress() {
        return this.f20105a.getProgress();
    }

    public String getTitle() {
        return this.f20105a.getTitle();
    }

    public String getVastContent() {
        return this.f20105a.getVastContent();
    }

    public String getVastTag() {
        return this.f20105a.getVastTag();
    }

    public int getVideoCurrentPosition() {
        return this.f20105a.getVideoCurrentPosition();
    }

    public int getVideoDuration() {
        return this.f20105a.getVideoDuration();
    }

    public boolean isAppAd() {
        return this.f20105a.isAppAd();
    }

    public boolean isSkippable() {
        return this.f20105a.isSkippable();
    }

    public void negativeFeedback() {
        this.f20105a.negativeFeedback();
    }

    public void onVideoADExposured(View view) {
        this.f20105a.onVideoADExposured(view);
    }

    public void pauseVideo() {
        this.f20105a.pauseVideo();
    }

    public void preloadVideo(VideoPreloadListener videoPreloadListener) {
        this.f20105a.preloadVideo(videoPreloadListener);
    }

    public void reportVastEvent(ADEvent aDEvent) {
    }

    public void resume() {
        this.f20105a.resume();
    }

    public void resumeVideo() {
        this.f20105a.resumeVideo();
    }

    public void setNativeAdEventListener(NativeADEventListener nativeADEventListener) {
        this.f20106b = nativeADEventListener;
    }

    public void setVideoMute(boolean z) {
        this.f20105a.setVideoMute(z);
    }

    public void startVideo() {
        this.f20105a.startVideo();
    }

    public void stopVideo() {
        this.f20105a.stopVideo();
    }
}
