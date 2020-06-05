package com.kwad.sdk.export.p347i;

import android.content.Context;
import android.view.View;

/* renamed from: com.kwad.sdk.export.i.KsFeedAd */
public interface KsFeedAd {

    /* renamed from: com.kwad.sdk.export.i.KsFeedAd$AdInteractionListener */
    public interface AdInteractionListener {
        void onAdClicked();

        void onAdShow();

        void onDislikeClicked();
    }

    int getECPM();

    View getFeedView(Context context);

    void setAdInteractionListener(AdInteractionListener adInteractionListener);

    void setBidEcpm(int i);

    void setVideoSoundEnable(boolean z);
}
