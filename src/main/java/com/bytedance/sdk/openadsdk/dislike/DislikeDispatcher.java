package com.bytedance.sdk.openadsdk.dislike;

import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.NetApi;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.p165c.AdEvent;
import java.util.List;

/* renamed from: com.bytedance.sdk.openadsdk.dislike.a */
public class DislikeDispatcher {
    /* renamed from: a */
    private static volatile DislikeDispatcher f8497a;
    /* renamed from: b */
    private final NetApi<AdEvent> f8498b = InternalContainer.m10067f();

    private DislikeDispatcher() {
    }

    /* renamed from: a */
    public static DislikeDispatcher m11044a() {
        if (f8497a == null) {
            synchronized (DislikeDispatcher.class) {
                if (f8497a == null) {
                    f8497a = new DislikeDispatcher();
                }
            }
        }
        return f8497a;
    }

    /* renamed from: a */
    public void mo16452a(MaterialMeta kVar, List<FilterWord> list) {
        this.f8498b.mo15918a(kVar, list);
    }
}
