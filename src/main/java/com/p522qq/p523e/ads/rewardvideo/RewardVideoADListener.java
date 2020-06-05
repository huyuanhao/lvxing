package com.p522qq.p523e.ads.rewardvideo;

import com.p522qq.p523e.comm.util.AdError;

/* renamed from: com.qq.e.ads.rewardvideo.RewardVideoADListener */
public interface RewardVideoADListener {
    void onADClick();

    void onADClose();

    void onADExpose();

    void onADLoad();

    void onADShow();

    void onError(AdError adError);

    void onReward();

    void onVideoCached();

    void onVideoComplete();
}
