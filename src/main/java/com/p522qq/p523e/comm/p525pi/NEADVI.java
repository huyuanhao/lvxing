package com.p522qq.p523e.comm.p525pi;

import com.p522qq.p523e.ads.nativ.ADSize;
import com.p522qq.p523e.comm.adevent.ADListener;

/* renamed from: com.qq.e.comm.pi.NEADVI */
public interface NEADVI {
    void destroy();

    void preloadVideo();

    void render();

    void reportAdNegative();

    void setAdListener(ADListener aDListener);

    void setAdSize(ADSize aDSize);

    void setBrowserType(int i);
}
