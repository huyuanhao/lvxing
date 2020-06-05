package com.p522qq.p523e.ads.hybrid;

import com.p522qq.p523e.comm.util.AdError;

/* renamed from: com.qq.e.ads.hybrid.HybridADListener */
public interface HybridADListener {
    void onClose();

    void onError(AdError adError);

    void onLoadFinished();

    void onPageShow();
}
