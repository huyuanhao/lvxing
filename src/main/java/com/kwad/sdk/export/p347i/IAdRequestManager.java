package com.kwad.sdk.export.p347i;

import com.kwad.sdk.protocol.model.AdScene;
import java.util.List;

/* renamed from: com.kwad.sdk.export.i.IAdRequestManager */
public interface IAdRequestManager {

    /* renamed from: com.kwad.sdk.export.i.IAdRequestManager$DrawAdListener */
    public interface DrawAdListener {
        void onDrawAdLoad(List<KsDrawAd> list);

        void onError(int i, String str);
    }

    /* renamed from: com.kwad.sdk.export.i.IAdRequestManager$EntryElementListener */
    public interface EntryElementListener<T> {
        void onEntryLoad(T t);

        void onError(int i, String str);
    }

    /* renamed from: com.kwad.sdk.export.i.IAdRequestManager$FeedAdListener */
    public interface FeedAdListener {
        void onError(int i, String str);

        void onFeedAdLoad(List<KsFeedAd> list);
    }

    /* renamed from: com.kwad.sdk.export.i.IAdRequestManager$FullScreenVideoAdListener */
    public interface FullScreenVideoAdListener {
        void onError(int i, String str);

        void onFullScreenVideoAdLoad(List<KsFullScreenVideoAd> list);
    }

    /* renamed from: com.kwad.sdk.export.i.IAdRequestManager$NativeAdListener */
    public interface NativeAdListener {
        void onError(int i, String str);

        void onNativeAdLoad(List<KsNativeAd> list);
    }

    /* renamed from: com.kwad.sdk.export.i.IAdRequestManager$RewardVideoAdListener */
    public interface RewardVideoAdListener {
        void onError(int i, String str);

        void onRewardVideoAdLoad(List<KsRewardVideoAd> list);
    }

    KsContentAllianceAd loadContentAllianceAd(AdScene adScene);

    void loadDrawAd(AdScene adScene, DrawAdListener drawAdListener);

    KsEntryElement loadEntryElement(AdScene adScene, EntryElementListener<KsEntryElement> entryElementListener);

    void loadFeedAd(AdScene adScene, FeedAdListener feedAdListener);

    void loadFullScreenVideoAd(AdScene adScene, FullScreenVideoAdListener fullScreenVideoAdListener);

    void loadNativeAd(AdScene adScene, NativeAdListener nativeAdListener);

    void loadRewardVideoAd(AdScene adScene, RewardVideoAdListener rewardVideoAdListener);
}
