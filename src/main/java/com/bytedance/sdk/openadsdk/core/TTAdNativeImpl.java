package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdNative.BannerAdListener;
import com.bytedance.sdk.openadsdk.TTAdNative.DrawFeedAdListener;
import com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener;
import com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener;
import com.bytedance.sdk.openadsdk.TTAdNative.InteractionAdListener;
import com.bytedance.sdk.openadsdk.TTAdNative.NativeAdListener;
import com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener;
import com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener;
import com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener;
import com.bytedance.sdk.openadsdk.core.NetApi.C2287b;
import com.bytedance.sdk.openadsdk.core.nativeexpress.ExpressAdLoadManager;
import com.bytedance.sdk.openadsdk.core.p170d.AdInfo;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.core.p170d.NetExtParams;
import com.bytedance.sdk.openadsdk.core.p171e.TTNativeAdImpl;
import com.bytedance.sdk.openadsdk.core.p174h.SdkSwitch;
import com.bytedance.sdk.openadsdk.p163a.CommonListener;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.Predicate;
import com.bytedance.sdk.openadsdk.utils.TTReflectUtils;
import com.kwad.sdk.core.imageloader.core.download.BaseImageDownloader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.bytedance.sdk.openadsdk.core.w */
public class TTAdNativeImpl implements TTAdNative {
    /* renamed from: a */
    private final NetApi f8228a = InternalContainer.m10067f();
    /* access modifiers changed from: private|final */
    /* renamed from: b */
    public final Context f8229b;

    public TTAdNativeImpl(Context context) {
        this.f8229b = context;
    }

    public void loadFeedAd(AdSlot adSlot, FeedAdListener feedAdListener) {
        if (!m10740a((CommonListener) feedAdListener)) {
            m10742c(adSlot);
            try {
                Method a = TTReflectUtils.m11989a("com.bytedance.sdk.openadsdk.TTC5Proxy", "loadFeed", Context.class, AdSlot.class, FeedAdListener.class);
                if (a != null) {
                    a.invoke(null, new Object[]{this.f8229b, adSlot, feedAdListener});
                }
            } catch (Throwable th) {
                C2564t.m12221b("TTAdNativeImpl", "feed component maybe not exist, pls check1", th);
            }
        }
    }

    public void loadDrawFeedAd(AdSlot adSlot, DrawFeedAdListener drawFeedAdListener) {
        if (!m10740a((CommonListener) drawFeedAdListener)) {
            m10739a(adSlot);
            try {
                Method a = TTReflectUtils.m11989a("com.bytedance.sdk.openadsdk.TTC5Proxy", "loadDraw", Context.class, AdSlot.class, DrawFeedAdListener.class);
                if (a != null) {
                    a.invoke(null, new Object[]{this.f8229b, adSlot, drawFeedAdListener});
                }
            } catch (Throwable th) {
                C2564t.m12221b("TTAdNativeImpl", "feed component maybe not exist, pls check2", th);
            }
        }
    }

    public void loadNativeAd(final AdSlot adSlot, final NativeAdListener nativeAdListener) {
        if (!m10740a((CommonListener) nativeAdListener)) {
            m10741b(adSlot);
            this.f8228a.mo15917a(adSlot, (NetExtParams) null, adSlot.getNativeAdType(), (C2287b) new C2287b() {
                /* renamed from: a */
                public void mo14946a(int i, String str) {
                    nativeAdListener.onError(i, str);
                }

                /* renamed from: a */
                public void mo14947a(AdInfo aVar) {
                    if (aVar.mo15336c() == null || aVar.mo15336c().isEmpty()) {
                        nativeAdListener.onError(-3, C2240g.m9576a(-3));
                        return;
                    }
                    List<MaterialMeta> c = aVar.mo15336c();
                    ArrayList arrayList = new ArrayList(c.size());
                    for (MaterialMeta kVar : c) {
                        if (kVar.mo15455aa()) {
                            arrayList.add(new TTNativeAdImpl(TTAdNativeImpl.this.f8229b, kVar, adSlot.getNativeAdType()) {
                            });
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        nativeAdListener.onNativeAdLoad(arrayList);
                    } else {
                        nativeAdListener.onError(-4, C2240g.m9576a(-4));
                    }
                }
            });
        }
    }

    public void loadBannerAd(AdSlot adSlot, BannerAdListener bannerAdListener) {
        if (!m10740a((CommonListener) bannerAdListener)) {
            m10742c(adSlot);
            try {
                Method a = TTReflectUtils.m11989a("com.bytedance.sdk.openadsdk.TTC1Proxy", "load", Context.class, AdSlot.class, BannerAdListener.class);
                if (a != null) {
                    a.invoke(null, new Object[]{this.f8229b, adSlot, bannerAdListener});
                }
            } catch (Throwable th) {
                C2564t.m12221b("TTAdNativeImpl", "banner component maybe not exist, pls check", th);
            }
        }
    }

    public void loadInteractionAd(AdSlot adSlot, InteractionAdListener interactionAdListener) {
        if (!m10740a((CommonListener) interactionAdListener)) {
            m10742c(adSlot);
            try {
                Method a = TTReflectUtils.m11989a("com.bytedance.sdk.openadsdk.TTC4Proxy", "load", Context.class, AdSlot.class, InteractionAdListener.class);
                if (a != null) {
                    a.invoke(null, new Object[]{this.f8229b, adSlot, interactionAdListener});
                }
            } catch (Throwable th) {
                C2564t.m12221b("TTAdNativeImpl", "interaction component maybe not exist, pls check", th);
            }
        }
    }

    public void loadSplashAd(AdSlot adSlot, SplashAdListener splashAdListener, int i) {
        if (!m10740a((CommonListener) splashAdListener)) {
            m10742c(adSlot);
            try {
                Method a = TTReflectUtils.m11989a("com.bytedance.sdk.openadsdk.TTC2Proxy", "load", Context.class, AdSlot.class, SplashAdListener.class, Integer.TYPE);
                if (a != null) {
                    a.invoke(null, new Object[]{this.f8229b, adSlot, splashAdListener, Integer.valueOf(i)});
                }
            } catch (Throwable th) {
                C2564t.m12221b("TTAdNativeImpl", "splash component maybe not exist, pls check1", th);
            }
        }
    }

    public void loadSplashAd(AdSlot adSlot, SplashAdListener splashAdListener) {
        if (!m10740a((CommonListener) splashAdListener)) {
            m10742c(adSlot);
            loadSplashAd(adSlot, splashAdListener, -1);
        }
    }

    public void loadRewardVideoAd(AdSlot adSlot, RewardVideoAdListener rewardVideoAdListener) {
        if (!m10740a((CommonListener) rewardVideoAdListener)) {
            try {
                Method a = TTReflectUtils.m11989a("com.bytedance.sdk.openadsdk.TTC3Proxy", "loadReward", Context.class, AdSlot.class, RewardVideoAdListener.class);
                if (a != null) {
                    a.invoke(null, new Object[]{this.f8229b, adSlot, rewardVideoAdListener});
                }
            } catch (Throwable th) {
                C2564t.m12221b("TTAdNativeImpl", "reward component maybe not exist, pls check1", th);
            }
        }
    }

    public void loadFullScreenVideoAd(AdSlot adSlot, FullScreenVideoAdListener fullScreenVideoAdListener) {
        if (!m10740a((CommonListener) fullScreenVideoAdListener)) {
            try {
                Method a = TTReflectUtils.m11989a("com.bytedance.sdk.openadsdk.TTC3Proxy", "loadFull", Context.class, AdSlot.class, FullScreenVideoAdListener.class);
                if (a != null) {
                    a.invoke(null, new Object[]{this.f8229b, adSlot, fullScreenVideoAdListener});
                }
            } catch (Throwable th) {
                C2564t.m12221b("TTAdNativeImpl", "reward component maybe not exist, pls check2", th);
            }
        }
    }

    public void loadNativeExpressAd(AdSlot adSlot, NativeExpressAdListener nativeExpressAdListener) {
        if (!m10740a((CommonListener) nativeExpressAdListener)) {
            ExpressAdLoadManager.m9985a(this.f8229b).mo15898a(adSlot, 5, nativeExpressAdListener, BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT);
        }
    }

    public void loadExpressDrawFeedAd(AdSlot adSlot, NativeExpressAdListener nativeExpressAdListener) {
        if (!m10740a((CommonListener) nativeExpressAdListener)) {
            ExpressAdLoadManager.m9985a(this.f8229b).mo15898a(adSlot, 9, nativeExpressAdListener, BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT);
        }
    }

    public void loadBannerExpressAd(AdSlot adSlot, NativeExpressAdListener nativeExpressAdListener) {
        if (!m10740a((CommonListener) nativeExpressAdListener)) {
            adSlot.setNativeAdType(1);
            ExpressAdLoadManager.m9985a(this.f8229b).mo15898a(adSlot, 1, nativeExpressAdListener, BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT);
        }
    }

    public void loadInteractionExpressAd(AdSlot adSlot, NativeExpressAdListener nativeExpressAdListener) {
        if (!m10740a((CommonListener) nativeExpressAdListener)) {
            adSlot.setNativeAdType(2);
            ExpressAdLoadManager.m9985a(this.f8229b).mo15898a(adSlot, 2, nativeExpressAdListener, BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT);
        }
    }

    /* renamed from: a */
    private void m10739a(AdSlot adSlot) {
        boolean z = true;
        String str = "必须设置图片素材尺寸";
        Predicate.m12258a(adSlot.getImgAcceptedWidth() > 0, str);
        if (adSlot.getImgAcceptedHeight() <= 0) {
            z = false;
        }
        Predicate.m12258a(z, str);
    }

    /* renamed from: b */
    private void m10741b(AdSlot adSlot) {
        m10739a(adSlot);
        Predicate.m12258a(adSlot.getNativeAdType() > 0, "必须设置请求原生广告的类型，目前支持TYPE_BANNER和TYPE_INTERACTION_AD");
    }

    /* renamed from: c */
    private void m10742c(AdSlot adSlot) {
        m10739a(adSlot);
        Predicate.m12258a(adSlot.getNativeAdType() == 0, "请求非原生广告的类型，请勿调用setNativeAdType()方法");
    }

    /* renamed from: a */
    private boolean m10740a(CommonListener bVar) {
        if (SdkSwitch.m9757a()) {
            return false;
        }
        if (bVar != null) {
            bVar.onError(1000, "广告请求开关已关闭,请联系穿山甲管理员");
        }
        return true;
    }
}
