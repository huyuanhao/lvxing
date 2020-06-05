package com.p522qq.p523e.ads.nativ;

import android.content.res.Configuration;
import android.view.View;
import com.p522qq.p523e.ads.contentad.ContentAdData;
import java.util.List;

/* renamed from: com.qq.e.ads.nativ.NativeMediaADData */
public interface NativeMediaADData extends ContentAdData {
    void bindView(MediaView mediaView, boolean z);

    void destroy();

    boolean equalsAdData(NativeMediaADData nativeMediaADData);

    double getAPPPrice();

    int getAPPScore();

    int getAPPStatus();

    int getAdPatternType();

    int getCurrentPosition();

    String getDesc();

    long getDownloadCount();

    int getDuration();

    int getECPM();

    String getECPMLevel();

    String getIconUrl();

    List<String> getImgList();

    String getImgUrl();

    int getProgress();

    String getTitle();

    boolean isAPP();

    boolean isPlaying();

    @Deprecated
    boolean isVideoAD();

    boolean isVideoLoaded();

    void onClicked(View view);

    void onConfigurationChanged(Configuration configuration);

    void onExposured(View view);

    void onScroll(int i, View view);

    void play();

    void preLoadVideo();

    void resume();

    void setMediaListener(MediaListener mediaListener);

    void setVolumeOn(boolean z);

    void stop();
}
