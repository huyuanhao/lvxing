package com.bytedance.sdk.openadsdk.component.interaction;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative.InteractionAdListener;
import com.bytedance.sdk.openadsdk.core.C2240g;
import com.bytedance.sdk.openadsdk.core.ImageLoadListener;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.NetApi;
import com.bytedance.sdk.openadsdk.core.NetApi.C2287b;
import com.bytedance.sdk.openadsdk.core.p170d.AdInfo;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.core.p170d.NetExtParams;

/* renamed from: com.bytedance.sdk.openadsdk.component.interaction.a */
public class InteractionAdManager {
    /* renamed from: a */
    private final NetApi f6885a = InternalContainer.m10067f();

    /* renamed from: a */
    public static InteractionAdManager m8633a() {
        return new InteractionAdManager();
    }

    private InteractionAdManager() {
    }

    /* renamed from: a */
    public void mo15084a(final Context context, AdSlot adSlot, final InteractionAdListener interactionAdListener) {
        this.f6885a.mo15917a(adSlot, (NetExtParams) null, 2, (C2287b) new C2287b() {
            /* renamed from: a */
            public void mo14946a(int i, String str) {
                interactionAdListener.onError(i, str);
            }

            /* renamed from: a */
            public void mo14947a(AdInfo aVar) {
                if (aVar.mo15336c() == null || aVar.mo15336c().isEmpty()) {
                    interactionAdListener.onError(-3, C2240g.m9576a(-3));
                    return;
                }
                MaterialMeta kVar = (MaterialMeta) aVar.mo15336c().get(0);
                if (kVar.mo15455aa()) {
                    final TTInteractionAdImpl bVar = new TTInteractionAdImpl(context, kVar);
                    bVar.mo15087a((ImageLoadListener) new ImageLoadListener() {
                        /* renamed from: a */
                        public void mo15085a() {
                            interactionAdListener.onInteractionAdLoad(bVar);
                        }

                        /* renamed from: b */
                        public void mo15086b() {
                            interactionAdListener.onError(-6, C2240g.m9576a(-6));
                        }
                    });
                    return;
                }
                interactionAdListener.onError(-4, C2240g.m9576a(-4));
            }
        });
    }
}
