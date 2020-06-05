package com.kwad.sdk.export.p347i;

import android.content.Context;
import android.view.View;

/* renamed from: com.kwad.sdk.export.i.KsDrawAd */
public interface KsDrawAd {

    /* renamed from: com.kwad.sdk.export.i.KsDrawAd$AdInteractionListener */
    public interface AdInteractionListener {
        void onAdClicked();

        void onAdShow();
    }

    View getDrawView(Context context);

    int getECPM();

    void setAdInteractionListener(AdInteractionListener adInteractionListener);

    void setBidEcpm(int i);
}
