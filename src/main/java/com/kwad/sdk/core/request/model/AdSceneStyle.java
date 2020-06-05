package com.kwad.sdk.core.request.model;

public enum AdSceneStyle {
    FeedAd(1),
    RewardAd(2),
    FullscreenAd(3),
    DrawAd(6),
    ContentAllianceAd(7);
    
    public int adStyle;

    private AdSceneStyle(int i) {
        this.adStyle = i;
    }
}
