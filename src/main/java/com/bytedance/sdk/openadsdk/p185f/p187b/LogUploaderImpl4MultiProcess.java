package com.bytedance.sdk.openadsdk.p185f.p187b;

import com.bytedance.sdk.openadsdk.multipro.p204c.AdEventProviderImpl;
import com.bytedance.sdk.openadsdk.p185f.p186a.ILogStats;
import com.bytedance.sdk.openadsdk.p185f.p187b.LogUploaderImpl.C2424a;
import java.util.UUID;

/* renamed from: com.bytedance.sdk.openadsdk.f.b.d */
public class LogUploaderImpl4MultiProcess implements ILogUploader {
    /* renamed from: b */
    public void mo16618b() {
    }

    /* renamed from: a */
    public void mo16615a() {
        AdEventProviderImpl.m11828d();
    }

    /* renamed from: a */
    public void mo16616a(ILogStats bVar) {
        try {
            AdEventProviderImpl.m11827c(bVar.mo16587a().toString());
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public void mo16617a(ILogStats bVar, boolean z) {
        try {
            AdEventProviderImpl.m11823a(new C2424a(UUID.randomUUID().toString(), bVar.mo16587a()).mo16623a(), z);
        } catch (Throwable unused) {
        }
    }
}
