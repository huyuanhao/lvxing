package com.bytedance.sdk.openadsdk;

import com.bytedance.sdk.openadsdk.p163a.CommonListener;
import java.util.List;

public interface TTAdNative {

    /* renamed from: com.bytedance.sdk.openadsdk.TTAdNative$BannerAdListener */
    public interface BannerAdListener extends CommonListener {
        void onBannerAdLoad(TTBannerAd tTBannerAd);

        void onError(int i, String str);
    }

    /* renamed from: com.bytedance.sdk.openadsdk.TTAdNative$DrawFeedAdListener */
    public interface DrawFeedAdListener extends CommonListener {
        void onDrawFeedAdLoad(List<TTDrawFeedAd> list);

        void onError(int i, String str);
    }

    /* renamed from: com.bytedance.sdk.openadsdk.TTAdNative$FeedAdListener */
    public interface FeedAdListener extends CommonListener {
        void onError(int i, String str);

        void onFeedAdLoad(List<TTFeedAd> list);
    }

    /* renamed from: com.bytedance.sdk.openadsdk.TTAdNative$FullScreenVideoAdListener */
    public interface FullScreenVideoAdListener extends CommonListener {
        void onError(int i, String str);

        void onFullScreenVideoAdLoad(TTFullScreenVideoAd tTFullScreenVideoAd);

        void onFullScreenVideoCached();
    }

    /* renamed from: com.bytedance.sdk.openadsdk.TTAdNative$InteractionAdListener */
    public interface InteractionAdListener extends CommonListener {
        void onError(int i, String str);

        void onInteractionAdLoad(TTInteractionAd tTInteractionAd);
    }

    /* renamed from: com.bytedance.sdk.openadsdk.TTAdNative$NativeAdListener */
    public interface NativeAdListener extends CommonListener {
        void onError(int i, String str);

        void onNativeAdLoad(List<TTNativeAd> list);
    }

    /* renamed from: com.bytedance.sdk.openadsdk.TTAdNative$NativeExpressAdListener */
    public interface NativeExpressAdListener extends CommonListener {
        void onError(int i, String str);

        void onNativeExpressAdLoad(List<TTNativeExpressAd> list);
    }

    /* renamed from: com.bytedance.sdk.openadsdk.TTAdNative$RewardVideoAdListener */
    public interface RewardVideoAdListener extends CommonListener {
        void onError(int i, String str);

        void onRewardVideoAdLoad(TTRewardVideoAd tTRewardVideoAd);

        void onRewardVideoCached();
    }

    /* renamed from: com.bytedance.sdk.openadsdk.TTAdNative$SplashAdListener */
    public interface SplashAdListener extends CommonListener {
        void onError(int i, String str);

        void onSplashAdLoad(TTSplashAd tTSplashAd);

        void onTimeout();
    }

    void loadBannerAd(AdSlot adSlot, BannerAdListener bannerAdListener);

    void loadBannerExpressAd(AdSlot adSlot, NativeExpressAdListener nativeExpressAdListener);

    void loadDrawFeedAd(AdSlot adSlot, DrawFeedAdListener drawFeedAdListener);

    void loadExpressDrawFeedAd(AdSlot adSlot, NativeExpressAdListener nativeExpressAdListener);

    void loadFeedAd(AdSlot adSlot, FeedAdListener feedAdListener);

    void loadFullScreenVideoAd(AdSlot adSlot, FullScreenVideoAdListener fullScreenVideoAdListener);

    void loadInteractionAd(AdSlot adSlot, InteractionAdListener interactionAdListener);

    void loadInteractionExpressAd(AdSlot adSlot, NativeExpressAdListener nativeExpressAdListener);

    void loadNativeAd(AdSlot adSlot, NativeAdListener nativeAdListener);

    void loadNativeExpressAd(AdSlot adSlot, NativeExpressAdListener nativeExpressAdListener);

    void loadRewardVideoAd(AdSlot adSlot, RewardVideoAdListener rewardVideoAdListener);

    void loadSplashAd(AdSlot adSlot, SplashAdListener splashAdListener);

    void loadSplashAd(AdSlot adSlot, SplashAdListener splashAdListener, int i);
}
