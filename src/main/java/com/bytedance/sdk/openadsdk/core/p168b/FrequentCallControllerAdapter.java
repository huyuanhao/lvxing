package com.bytedance.sdk.openadsdk.core.p168b;

import com.bytedance.sdk.openadsdk.multipro.MultiGlobalInfo;
import com.bytedance.sdk.openadsdk.multipro.p204c.FrequentCallProviderImpl;

/* renamed from: com.bytedance.sdk.openadsdk.core.b.b */
public class FrequentCallControllerAdapter {
    /* renamed from: a */
    public static boolean m9102a(String str) {
        return MultiGlobalInfo.m11808b() ? FrequentCallProviderImpl.m11850a(str) : FrequentCallController.m9090a().mo15290a(str);
    }

    /* renamed from: a */
    public static boolean m9101a() {
        return MultiGlobalInfo.m11808b() ? FrequentCallProviderImpl.m11851c() : FrequentCallController.m9090a().mo15291b();
    }

    /* renamed from: b */
    public static String m9103b() {
        return MultiGlobalInfo.m11808b() ? FrequentCallProviderImpl.m11852d() : FrequentCallController.m9090a().mo15292c();
    }
}
