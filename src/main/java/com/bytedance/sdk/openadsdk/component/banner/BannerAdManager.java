package com.bytedance.sdk.openadsdk.component.banner;

import android.content.Context;
import android.graphics.Bitmap;
import com.bytedance.sdk.adnet.core.C1982p;
import com.bytedance.sdk.adnet.p159b.ImageLoader.C1963c;
import com.bytedance.sdk.adnet.p159b.ImageLoader.C1964d;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative.BannerAdListener;
import com.bytedance.sdk.openadsdk.core.C2240g;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.NetApi;
import com.bytedance.sdk.openadsdk.core.NetApi.C2287b;
import com.bytedance.sdk.openadsdk.core.p170d.AdInfo;
import com.bytedance.sdk.openadsdk.core.p170d.Image;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.core.p170d.NetExtParams;
import com.bytedance.sdk.openadsdk.p188g.TTNetClient;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import java.lang.ref.WeakReference;

/* renamed from: com.bytedance.sdk.openadsdk.component.banner.b */
public class BannerAdManager {
    /* renamed from: a */
    private static volatile BannerAdManager f6840a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public WeakReference<Context> f6841b;
    /* renamed from: c */
    private final NetApi f6842c = InternalContainer.m10067f();

    /* compiled from: BannerAdManager */
    /* renamed from: com.bytedance.sdk.openadsdk.component.banner.b$a */
    public interface C2105a {
        /* renamed from: a */
        void mo15058a();

        /* renamed from: a */
        void mo15059a(BannerAdInfo aVar);
    }

    private BannerAdManager(Context context) {
        this.f6841b = new WeakReference<>(context);
    }

    /* renamed from: b */
    private void m8567b(Context context) {
        this.f6841b = new WeakReference<>(context);
    }

    /* renamed from: a */
    public static BannerAdManager m8563a(Context context) {
        if (f6840a == null) {
            synchronized (BannerAdManager.class) {
                if (f6840a == null) {
                    f6840a = new BannerAdManager(context);
                }
            }
        } else {
            f6840a.m8567b(context);
        }
        return f6840a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo15057a(AdSlot adSlot, final C2105a aVar) {
        this.f6842c.mo15917a(adSlot, (NetExtParams) null, 1, (C2287b) new C2287b() {
            /* renamed from: a */
            public void mo14946a(int i, String str) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append("  ");
                sb.append(i);
                C2564t.m12220b("BannerAdManager", sb.toString());
                C2105a aVar = aVar;
                if (aVar != null) {
                    aVar.mo15058a();
                }
            }

            /* renamed from: a */
            public void mo14947a(AdInfo aVar) {
                if (aVar.mo15336c() != null && !aVar.mo15336c().isEmpty()) {
                    MaterialMeta kVar = (MaterialMeta) aVar.mo15336c().get(0);
                    if (kVar.mo15455aa()) {
                        BannerAdManager.this.m8566a(kVar, aVar);
                        return;
                    }
                    C2564t.m12220b("BannerAdManager", "Banner广告解析失败/广告为空");
                    C2105a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.mo15058a();
                    }
                }
            }
        });
    }

    /* renamed from: a */
    public void mo15056a(final AdSlot adSlot, final BannerAdListener bannerAdListener) {
        this.f6842c.mo15917a(adSlot, (NetExtParams) null, 1, (C2287b) new C2287b() {
            /* renamed from: a */
            public void mo14946a(int i, String str) {
                bannerAdListener.onError(i, str);
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(" ");
                sb.append(i);
                C2564t.m12220b("BannerAdManager", sb.toString());
            }

            /* renamed from: a */
            public void mo14947a(AdInfo aVar) {
                String str = "BannerAdManager";
                if (aVar.mo15336c() == null || aVar.mo15336c().isEmpty()) {
                    C2564t.m12220b(str, "Banner广告解析失败/广告为空");
                    bannerAdListener.onError(-4, C2240g.m9576a(-4));
                    return;
                }
                MaterialMeta kVar = (MaterialMeta) aVar.mo15336c().get(0);
                if (kVar.mo15455aa()) {
                    BannerAdManager.this.m8566a(kVar, (C2105a) new C2105a() {
                        /* renamed from: a */
                        public void mo15059a(BannerAdInfo aVar) {
                            if (BannerAdManager.this.f6841b.get() != null) {
                                bannerAdListener.onBannerAdLoad(new TTBannerAdImpl((Context) BannerAdManager.this.f6841b.get(), aVar, adSlot));
                            }
                        }

                        /* renamed from: a */
                        public void mo15058a() {
                            bannerAdListener.onError(-5, C2240g.m9576a(-5));
                        }
                    });
                    return;
                }
                C2564t.m12220b(str, "Banner广告解析失败");
                bannerAdListener.onError(-4, C2240g.m9576a(-4));
            }
        });
    }

    /* renamed from: a */
    private Context m8562a() {
        WeakReference<Context> weakReference = this.f6841b;
        return (weakReference == null || weakReference.get() == null) ? InternalContainer.m10059a() : (Context) this.f6841b.get();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8566a(final MaterialMeta kVar, final C2105a aVar) {
        TTNetClient.m11428a(m8562a()).mo16660g().mo14198a(((Image) kVar.mo15418F().get(0)).mo15406a(), (C1964d) new C1964d() {
            /* renamed from: a */
            public void mo14215a() {
            }

            /* renamed from: a */
            public void mo14171a(C1982p<Bitmap> pVar) {
            }

            /* renamed from: b */
            public void mo14217b() {
            }

            /* renamed from: a */
            public void mo14216a(C1963c cVar, boolean z) {
                if (cVar == null || cVar.mo14214a() == null) {
                    C2105a aVar = aVar;
                    if (aVar != null) {
                        aVar.mo15058a();
                    }
                    return;
                }
                C2105a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.mo15059a(new BannerAdInfo(cVar.mo14214a(), kVar));
                }
            }

            /* renamed from: b */
            public void mo14172b(C1982p<Bitmap> pVar) {
                C2105a aVar = aVar;
                if (aVar != null) {
                    aVar.mo15058a();
                }
            }
        });
    }
}
