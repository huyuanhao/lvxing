package com.kwad.sdk.nativead;

import com.kwad.sdk.core.p333g.C4143b;
import com.kwad.sdk.export.p347i.KsNativeAd;

public class KsNativeAdReporter {
    private static final String TAG = "KsNativeAdReporter";

    public static void reportAdVideoPlayEnd(KsNativeAd ksNativeAd) {
        if (ksNativeAd instanceof C4467a) {
            C4143b.m17138f(((C4467a) ksNativeAd).mo24781a());
        }
    }

    public static void reportAdVideoPlayStart(KsNativeAd ksNativeAd) {
        if (ksNativeAd instanceof C4467a) {
            C4143b.m17136e(((C4467a) ksNativeAd).mo24781a());
        }
    }
}
