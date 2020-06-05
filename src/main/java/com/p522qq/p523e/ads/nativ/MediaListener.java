package com.p522qq.p523e.ads.nativ;

import com.p522qq.p523e.comm.util.AdError;

/* renamed from: com.qq.e.ads.nativ.MediaListener */
public interface MediaListener {
    void onADButtonClicked();

    void onFullScreenChanged(boolean z);

    void onReplayButtonClicked();

    void onVideoComplete();

    void onVideoError(AdError adError);

    void onVideoPause();

    void onVideoReady(long j);

    void onVideoStart();
}
