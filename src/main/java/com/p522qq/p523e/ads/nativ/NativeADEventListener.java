package com.p522qq.p523e.ads.nativ;

import com.p522qq.p523e.comm.util.AdError;

/* renamed from: com.qq.e.ads.nativ.NativeADEventListener */
public interface NativeADEventListener {
    void onADClicked();

    void onADError(AdError adError);

    void onADExposed();

    void onADStatusChanged();
}
