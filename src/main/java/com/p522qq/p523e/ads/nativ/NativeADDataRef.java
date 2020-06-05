package com.p522qq.p523e.ads.nativ;

import android.view.View;
import java.util.List;

/* renamed from: com.qq.e.ads.nativ.NativeADDataRef */
public interface NativeADDataRef {
    boolean equalsAdData(NativeADDataRef nativeADDataRef);

    double getAPPPrice();

    int getAPPScore();

    int getAPPStatus();

    int getAdPatternType();

    String getDesc();

    long getDownloadCount();

    int getECPM();

    String getECPMLevel();

    String getIconUrl();

    List<String> getImgList();

    String getImgUrl();

    int getPictureHeight();

    int getPictureWidth();

    int getProgress();

    String getTitle();

    boolean isAPP();

    void negativeFeedback();

    void onClicked(View view);

    void onExposured(View view);
}
