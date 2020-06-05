package com.bytedance.sdk.openadsdk.p165c;

import com.bytedance.sdk.openadsdk.multipro.p204c.AdEventProviderImpl;
import com.bytedance.sdk.openadsdk.p185f.p187b.LogUploaderImpl.C2424a;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.bytedance.sdk.openadsdk.c.m */
public class StatsDispatcher4MultiProcess extends AdEventDispatcher<C2424a> {
    /* renamed from: a */
    private AtomicBoolean f6811a = new AtomicBoolean(false);
    /* renamed from: b */
    private boolean f6812b = true;

    /* renamed from: b */
    public void mo14999b() {
    }

    public StatsDispatcher4MultiProcess(boolean z) {
        this.f6812b = z;
    }

    /* renamed from: a */
    public void mo14997a() {
        if (!this.f6811a.getAndSet(true)) {
            AdEventProviderImpl.m11824a(this.f6812b);
        }
    }

    /* renamed from: a */
    public void mo14998a(C2424a aVar) {
        if (this.f6811a.get()) {
            AdEventProviderImpl.m11823a(aVar.mo16623a(), this.f6812b);
        }
    }
}
