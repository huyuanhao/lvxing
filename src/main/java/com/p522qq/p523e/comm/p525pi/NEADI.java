package com.p522qq.p523e.comm.p525pi;

import com.p522qq.p523e.ads.cfg.VideoOption;
import com.p522qq.p523e.comm.constants.LoadAdParams;

/* renamed from: com.qq.e.comm.pi.NEADI */
public interface NEADI extends ADI {
    void loadAd(int i);

    void loadAd(int i, LoadAdParams loadAdParams);

    void setMaxVideoDuration(int i);

    void setMinVideoDuration(int i);

    void setVideoOption(VideoOption videoOption);

    void setVideoPlayPolicy(int i);
}
