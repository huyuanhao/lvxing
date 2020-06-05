package com.bytedance.sdk.openadsdk.component.p166a;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative.DrawFeedAdListener;
import com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener;
import com.bytedance.sdk.openadsdk.core.C2240g;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.NetApi;
import com.bytedance.sdk.openadsdk.core.NetApi.C2287b;
import com.bytedance.sdk.openadsdk.core.p170d.AdInfo;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.core.p170d.NetExtParams;
import com.bytedance.sdk.openadsdk.p190h.p196f.VideoCachePreloader;
import com.bytedance.sdk.openadsdk.p190h.p196f.VideoUrlModel;
import com.bytedance.sdk.openadsdk.utils.ToolUtils;
import com.kwad.sdk.core.imageloader.utils.IoUtils;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.bytedance.sdk.openadsdk.component.a.a */
public class FeedAdManager {
    /* renamed from: a */
    private static volatile FeedAdManager f6816a;
    /* renamed from: b */
    private final NetApi f6817b = InternalContainer.m10067f();

    /* renamed from: a */
    public static FeedAdManager m8531a() {
        if (f6816a == null) {
            synchronized (FeedAdManager.class) {
                if (f6816a == null) {
                    f6816a = new FeedAdManager();
                }
            }
        }
        return f6816a;
    }

    private FeedAdManager() {
    }

    /* renamed from: a */
    public void mo15043a(final Context context, final AdSlot adSlot, final FeedAdListener feedAdListener) {
        this.f6817b.mo15917a(adSlot, (NetExtParams) null, 5, (C2287b) new C2287b() {
            /* renamed from: a */
            public void mo14946a(int i, String str) {
                feedAdListener.onError(i, str);
            }

            /* renamed from: a */
            public void mo14947a(AdInfo aVar) {
                if (aVar.mo15336c() == null || aVar.mo15336c().isEmpty()) {
                    feedAdListener.onError(-3, C2240g.m9576a(-3));
                    return;
                }
                List<MaterialMeta> c = aVar.mo15336c();
                ArrayList arrayList = new ArrayList(c.size());
                for (MaterialMeta kVar : c) {
                    if (kVar.mo15455aa()) {
                        arrayList.add(new TTFeedAdImpl(context, kVar, 5, adSlot));
                    }
                    if (!(kVar.mo15429Q() != 5 || kVar.mo15512z() == null || kVar.mo15512z().mo15603g() == null)) {
                        int d = ToolUtils.m12018d(kVar.mo15428P());
                        if (InternalContainer.m10069h().mo15775a(String.valueOf(d)) && InternalContainer.m10069h().mo15810q(String.valueOf(d))) {
                            VideoCachePreloader.m11598a().mo16766a(new VideoUrlModel().mo16772a(kVar.mo15512z().mo15603g()).mo16771a(204800).mo16773b(kVar.mo15512z().mo15606j()));
                        }
                    }
                }
                if (!arrayList.isEmpty()) {
                    feedAdListener.onFeedAdLoad(arrayList);
                } else {
                    feedAdListener.onError(-4, C2240g.m9576a(-4));
                }
            }
        });
    }

    /* renamed from: a */
    public void mo15042a(final Context context, AdSlot adSlot, final DrawFeedAdListener drawFeedAdListener) {
        this.f6817b.mo15917a(adSlot, (NetExtParams) null, 9, (C2287b) new C2287b() {
            /* renamed from: a */
            public void mo14946a(int i, String str) {
                drawFeedAdListener.onError(i, str);
            }

            /* renamed from: a */
            public void mo14947a(AdInfo aVar) {
                if (aVar.mo15336c() == null || aVar.mo15336c().isEmpty()) {
                    drawFeedAdListener.onError(-3, C2240g.m9576a(-3));
                    return;
                }
                List<MaterialMeta> c = aVar.mo15336c();
                ArrayList arrayList = new ArrayList(c.size());
                for (MaterialMeta kVar : c) {
                    if (kVar.mo15455aa()) {
                        arrayList.add(new TTDrawFeedAdImpl(context, kVar, 9));
                    }
                    if (!((kVar.mo15429Q() != 5 && kVar.mo15429Q() != 15) || kVar.mo15512z() == null || kVar.mo15512z().mo15603g() == null)) {
                        int d = ToolUtils.m12018d(kVar.mo15428P());
                        if (InternalContainer.m10069h().mo15775a(String.valueOf(d)) && InternalContainer.m10069h().mo15810q(String.valueOf(d))) {
                            VideoCachePreloader.m11598a().mo16766a(new VideoUrlModel().mo16772a(kVar.mo15512z().mo15603g()).mo16771a((int) IoUtils.DEFAULT_IMAGE_TOTAL_SIZE).mo16773b(kVar.mo15512z().mo15606j()));
                        }
                    }
                }
                if (!arrayList.isEmpty()) {
                    drawFeedAdListener.onDrawFeedAdLoad(arrayList);
                } else {
                    drawFeedAdListener.onError(-4, C2240g.m9576a(-4));
                }
            }
        });
    }
}
