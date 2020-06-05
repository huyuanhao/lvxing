package com.bytedance.sdk.openadsdk.p165c;

import com.bytedance.sdk.openadsdk.multipro.p204c.AdEventProviderImpl;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.bytedance.sdk.openadsdk.c.c */
public class AdEventDispatcher4MultiProcess extends AdEventDispatcher<AdEvent> {
    /* renamed from: a */
    private AtomicBoolean f6750a = new AtomicBoolean(false);

    /* renamed from: b */
    public void mo14999b() {
    }

    /* renamed from: a */
    public void mo14997a() {
        if (!this.f6750a.getAndSet(true)) {
            AdEventProviderImpl.m11826c();
        }
    }

    /* renamed from: a */
    public void mo14998a(AdEvent aVar) {
        if (this.f6750a.get()) {
            AdEventProviderImpl.m11821a(aVar.mo14995a());
        }
    }
}
