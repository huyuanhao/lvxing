package com.p522qq.p523e.ads.nativ;

import com.p522qq.p523e.comm.util.AdError;

/* renamed from: com.qq.e.ads.nativ.NativeADMediaListener */
public interface NativeADMediaListener {
    void onVideoClicked();

    void onVideoCompleted();

    void onVideoError(AdError adError);

    void onVideoInit();

    void onVideoLoaded(int i);

    void onVideoLoading();

    void onVideoPause();

    void onVideoReady();

    void onVideoResume();

    void onVideoStart();

    void onVideoStop();
}
